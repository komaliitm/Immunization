package com.social.healthometer;
import static com.microsoft.windowsazure.mobileservices.MobileServiceQueryOperations.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.Toast;

import android.widget.ExpandableListView;
import android.widget.ListView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceQuery;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;
import com.social.healthometer.adapter.CustomArrayAdapter;
import com.social.healthometer.adapter.ExpandableListAdapter;
import com.social.healthometer.model.TodoItem;
import com.social.healthometer.model.SearchFilterItem;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;



public class ViewDetailFragment extends Activity {
	public static TodoItem ITEM_TO_EDIT = null;

	private Button searchButton;
	private EditText searchEditText;
	private ListView listView;
  
	private CustomArrayAdapter customArrayAdapter;
	private ArrayList<TodoItem> listItems;
	private MobileServiceClient mClient;
	private MobileServiceTable<TodoItem> mToDoTable;
	Boolean ready;
	 /** An array of strings to populate dropdown list */
    String[] actions = new String[] {
        "Menu",
        "Add Detail",
        "Search",
        "Verify",
        "Setting"
    };

		
		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fragment_edit_patient);
	        ///////////////////////
	        /** Create an array adapter to populate dropdownlist */
	    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, actions);

	    	/** Enabling dropdown list navigation for the action bar */
	    	getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);



	    	/** Defining Navigation listener */
	    	ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {

	    	    @Override
	    	    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
	    	     

	    				switch (itemPosition) {
	    				case 0:
	    							//Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_LONG).show();
	    							//Intent i = new Intent(getBaseContext(), AddDetailsActivity.class);
	    							//startActivity(i);
	    					
	    				    break;
	    				case 1:
	    					Intent i = new Intent(getBaseContext(), AddDetailsActivity.class);
	    					startActivity(i);
	    				    break;
	    				case 2:
	    					Intent j = new Intent(getBaseContext(), ViewDetailFragment.class);
	    					startActivity(j);
	    				    break;
	    				case 3:
	    					Intent k = new Intent(getBaseContext(), VerificationActivity.class);
	    					startActivity(k);
	    				    break;
	    				case 4:
	    					Intent l = new Intent(getBaseContext(), SettingsActivity.class);
	    					startActivity(l);
	    				    break;
	    				default:
	    				    break;
	    				}

	    			
	    				return true;
	    			    }
	    	    
	    	      
	    	    
	    	};



	    	/** Setting dropdown items and item navigation listener for the actionbar */
	    	getActionBar().setListNavigationCallbacks(adapter, navigationListener);

	    	    
	    	final Button btnMenu = (Button) findViewById(R.id.menusearch_button_id);
			
			
			btnMenu.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					//Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_LONG).show();
					Intent i = new Intent(getBaseContext(), MainMenuActivity.class);
					startActivity(i);
				}
			});	
	        
	    
	   

	       
	    
	        
	      
	        //expandableListView.setFadingEdgeLength(3);
	        
   
	        ////////////////

	        
	        searchButton = (Button)findViewById(R.id.search_btn_id);
		   searchButton.setOnClickListener(
			        new Button.OnClickListener() {
			        	public void onClick(View v) {
			        		// Log.d("count="+adapter.getGroupCount(), "id="+adapter.getGroupView(0, true, convertView, parent));
			                	  // Code to be performed when 
						  // the button is clicked
			        		EditText editTextName = (EditText)findViewById(R.id.txtSearchName_id);
			        		String Name = editTextName.getText().toString();
			        		 EditText editTextPhone =(EditText)findViewById(R.id.txtSearchPhone_id);
			        		 String Phone = editTextPhone.getText().toString();
			        		SearchClicked(v,Name,Phone);
			        		}
			        	}
			        );
			        
		  
			listView = (ListView)findViewById(R.id.listView1);
			
			
			searchEditText = (EditText)findViewById(R.id.editText1);
			try{
			
			
			listItems = new ArrayList<TodoItem>();
			customArrayAdapter = new CustomArrayAdapter(getApplicationContext(),listItems);
			listView.setAdapter(customArrayAdapter);
			
			
		listView.setOnItemClickListener(new ListView.OnItemClickListener()
					{
				@Override
				public void onItemClick(AdapterView l, View v, int position, long id) {
					TodoItem item = (TodoItem) customArrayAdapter.getItem(position);
				    Intent intent = new Intent(getBaseContext(), AddDetailsActivity.class);
				    ITEM_TO_EDIT = item;
				    startActivity(intent);
				  }
					} );
			}catch( Exception ee){
				ShowMessage("ListView", "Exception:"+ee);
			}
			try
			{
				  mClient = new MobileServiceClient(
							 "https://vaccineproapp.azure-mobile.net/",
						      "AKuNBrSjWykyVFDZFWmwECbDlyfjvt98",
							this);
						
			//ShowMessage("Success", mClient.get);
					
			mToDoTable = mClient.getTable(TodoItem.class);
			if(mToDoTable != null)
			{
				ready = true;
				//ShowMessage("Success", "MobileServiceClient created successfully");
			}
			else
			{
				ready = false;
				ShowMessage("Failed", "Cannot create MobileServiceClient");
			}
				
			}
			catch(MalformedURLException ex)
			{
				ready = false;
				ShowMessage("Exception", "Cannot create MobileServiceClient");
			}
		
			
			refreshItemsFromTable();
			

	}
	
	
	
	
	public void SearchClicked(View view,String Name,String Phone)
	{
		String nameToBeSearched;
		String phoneToBeSearched;
		MobileServiceQuery<TableQueryCallback<TodoItem>> msq;
		if(Name.length() <= 0 && Phone.length() >= 0 )
		{
			phoneToBeSearched = Phone;
			msq = mToDoTable.where().field("notify_num").eq(phoneToBeSearched);
			
		}
		else
		if(Phone.length() <= 0 && Name.length() >= 0)
		{
			nameToBeSearched = Name;
		    msq = mToDoTable.where().field("ChildName").eq(nameToBeSearched);
			
		}
		else
			if(Phone.length() >= 0 && Name.length() >= 0)
			{
				nameToBeSearched = Name;
				phoneToBeSearched = Phone;
				msq = mToDoTable.where().field("ChildName").and().field("notify_num").eq(phoneToBeSearched).eq(nameToBeSearched);
				
			}
			else
			{
				return;
			}


	//	mToDoTable.where().field("text").eq(nameToBeSearched).execute(new TableQueryCallback<ToDoItem>()
	
	msq.execute(new TableQueryCallback<TodoItem>() {

			public void onCompleted(List<TodoItem> result, int count, Exception exception, ServiceFilterResponse response) {
				
			//	ShowMessage("Sucess", result.get(0).toString());
				if (exception == null) {
					customArrayAdapter.clear();
					//ShowMessage("Sucess", "Found");
					for (TodoItem item : result) {
						
						
						customArrayAdapter.add(item);
						customArrayAdapter.notifyDataSetChanged();
					}
					//ShowMessage("Sucess", "Record Found");

				} else {
					ShowMessage("Error", exception.toString());
				}
			}
		});
		
		

		
		
	}
	
	public void checkItem(TodoItem item) {
		if (mClient == null) {
			return;
		}

		// Set the item as completed and update it in the table
		item.setComplete(true);
		
		mToDoTable.update(item, new TableOperationCallback<TodoItem>() {

			public void onCompleted(TodoItem entity, Exception exception, ServiceFilterResponse response) {
				if (exception == null) {	
					if (entity.isComplete()) {
						customArrayAdapter.remove(entity);
					}
				} else {
					ShowMessage("exception", exception.toString());
				}
			}

		});
	}

	
	private void refreshItemsFromTable() {

		// Get the items that weren't marked as completed and add them in the
		// adapter
		mToDoTable.where().field("complete").eq(val(false)).execute(new TableQueryCallback<TodoItem>() {

			public void onCompleted(List<TodoItem> result, int count, Exception exception, ServiceFilterResponse response) {
				if (exception == null) {
					customArrayAdapter.clear();

					for (TodoItem item : result) {
						customArrayAdapter.add(item);
					}

				} else {
					ShowMessage("exception", exception.toString());
				}
			}
		});
	}

	
	
	public void ShowMessage(String title,
			String message)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage(message);
		builder.setTitle(title);
		builder.create().show();
	}
	
	
	
	  
	
}
