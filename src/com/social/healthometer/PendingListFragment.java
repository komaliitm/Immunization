package com.social.healthometer;

import static com.microsoft.windowsazure.mobileservices.MobileServiceQueryOperations.val;

import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;
import com.social.healthometer.R.id;
import com.social.healthometer.adapter.CustomArrayAdapter;
import com.social.healthometer.model.TodoItem;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;


import com.microsoft.windowsazure.mobileservices.TableOperationCallback;


public class PendingListFragment extends Fragment implements OnItemClickListener  
{
	 
	 String[] member_names;
	 TypedArray profile_pics;
	 String[] mob_num;
	 String[] code;
	 SparseBooleanArray mCheckStates ;
	 private CustomArrayAdapter customArrayAdapter;
	 private MobileServiceClient mClient;
		private MobileServiceTable<TodoItem> mToDoTable;
		Boolean ready;
		ListView mylistview ;
	 
	// List<CheckBoxItem> rowCheckBoxItems ;
		private ArrayList<TodoItem> listItems;
		//private ListView mylistview ;

	 @Override
	    public View onCreateView(LayoutInflater inflater, 
	              ViewGroup container, Bundle savedInstanceState) {
	        
	  View view = inflater.inflate(R.layout.fragment_pending,  container, false);
	   mylistview = (ListView) view.findViewById(R.id.list);
	//  l.setBackgroundColor(color.dark_red_color);
	  
	  
	   mylistview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	  
	  listItems = new ArrayList<TodoItem>();  
	//  rowCheckBoxItems = new ArrayList<CheckBoxItem>();  
	  customArrayAdapter = new CustomArrayAdapter(getActivity().getApplicationContext(),listItems);
	
	 // mylistview.setItemsCanFocus(true);
	  mylistview.setAdapter(customArrayAdapter);
	 // ShowMessage("Success", "MobileServiceClient created ii successfull");
	  


	//  profile_pics.recycle();
	mylistview.setFocusable(false);
	 mylistview.setOnItemClickListener( this);
	 
	// Toast.makeText(getActivity().getApplicationContext(), "hjhghg",	    Toast.LENGTH_SHORT).show();

	  
	  try
		{
			mClient = new MobileServiceClient(
					 "https://vaccineproapp.azure-mobile.net/",
				      "AKuNBrSjWykyVFDZFWmwECbDlyfjvt98",
					this.getActivity());
					
		//ShowMessage("Success", mClient.get);
				
		mToDoTable = mClient.getTable(TodoItem.class);
		if(mToDoTable != null)
		{
			ready = true;
		//	ShowMessage("Success", "MobileServiceClient created ii successfully");
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
	  	/*
	  TodoItem tempItem = new TodoItem();	
		tempItem.setText("Arun");
		tempItem.setSex("male");
		tempItem.setChecked(false);
		Date dob = new Date(1000);
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("1994");
		strBuilder.append("-");
		strBuilder.append("06");
		strBuilder.append("-");
		strBuilder.append("09");
		dob = Date.valueOf(strBuilder.toString());
		tempItem.setDateOfBirth(dob);
		//Date date = new Date(2000);
		//date = Date.valueOf("1978-12-05");
	//	tempItem.setDateOfBirth(date);
		tempItem.setNotifyNumber("");
		listItems.add(tempItem);
		
		TodoItem tempItem2 = new TodoItem();
	
		
		tempItem2.setText("Ram");
		tempItem2.setSex("male");
		tempItem2.setChecked(false);
		Date dob2 = new Date(1000);
		StringBuilder strBuilder2 = new StringBuilder();
		strBuilder2.append("2001");
		strBuilder2.append("-");
		strBuilder2.append("06");
		strBuilder2.append("-");
		strBuilder2.append("09");
		
		dob2 = Date.valueOf(strBuilder2.toString());
		tempItem2.setDateOfBirth(dob);
		tempItem2.setNotifyNumber("");
		listItems.add(tempItem2);
		
		TodoItem tempItem3 = new TodoItem();	
		tempItem3.setText("james");
		tempItem3.setSex("male");
		tempItem3.setChecked(false);
		Date dob3 = new Date(1000);
		StringBuilder strBuilder3 = new StringBuilder();
		strBuilder3.append("1990");
		strBuilder3.append("-");
		strBuilder3.append("09");
		strBuilder3.append("-");
		strBuilder3.append("09");
		dob3 = Date.valueOf(strBuilder3.toString());
		tempItem3.setDateOfBirth(dob3);
		tempItem3.setNotifyNumber("");
		listItems.add(tempItem3);
		
		TodoItem tempItem4 = new TodoItem();	
		tempItem4.setText("Karan");
		tempItem4.setSex("male");
		tempItem4.setChecked(false);
		Date dob4 = new Date(1000);
		StringBuilder strBuilder4 = new StringBuilder();
		strBuilder4.append("1988");
		strBuilder4.append("-");
		strBuilder4.append("06");
		strBuilder4.append("-");
		strBuilder4.append("09");
		dob4 = Date.valueOf(strBuilder4.toString());
		tempItem4.setDateOfBirth(dob4);
		tempItem4.setNotifyNumber("");
		listItems.add(tempItem4);
		
		TodoItem tempItem5 = new TodoItem();	
		tempItem5.setText("Hemant");
		tempItem5.setSex("male");
		tempItem5.setChecked(false);
		Date dob5 = new Date(1000);
		StringBuilder strBuilder5 = new StringBuilder();
		strBuilder5.append("1988");
		strBuilder5.append("-");
		strBuilder5.append("06");
		strBuilder5.append("-");
		strBuilder5.append("09");
		dob5 = Date.valueOf(strBuilder5.toString());
		tempItem5.setDateOfBirth(dob5);
		tempItem5.setNotifyNumber("9053535250");
		listItems.add(tempItem5);
		
		TodoItem tempItem6 = new TodoItem();	
		tempItem6.setText("Deepa");
		tempItem6.setSex("female");
		tempItem6.setChecked(false);
		Date dob6 = new Date(1000);
		StringBuilder strBuilder6 = new StringBuilder();
		strBuilder6.append("1988");
		strBuilder6.append("-");
		strBuilder6.append("06");
		strBuilder6.append("-");
		strBuilder6.append("09");
		dob6 = Date.valueOf(strBuilder6.toString());
		tempItem6.setDateOfBirth(dob6);
		tempItem6.setNotifyNumber("9063636260");
		listItems.add(tempItem6);
		*/
		
	  
	
		Button btnObjVerified = (Button)view.findViewById(R.id.verify_button_id);
		btnObjVerified.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {
            	 SparseBooleanArray checked = mylistview.getCheckedItemPositions();
            	
            
            	 //ShowMessage("click",""+ "verify" );
            	
            	 TodoItem planet ;
            	int y = mylistview.getCount() ;
            	  for (int i = 0; i < y; i++)
            	  {
            		  
            		  
            		  
            		 // ShowMessage("i=","count-"+mylistview.getCount() ); 
            		   planet = customArrayAdapter.getItem(i);
            		  
            		   
            		//   ShowMessage("for","check-"+ planet.isChecked()+" name= "+planet.getText() );
            		 
            		
                      if ( planet.isChecked()	)
                      {
                    	  
                    	//  SaveClicked( planet.getText() , planet.getNotifyNumber(),  planet.getSex() );
                    	 
                    	 SaveClicked( planet );
                    	  listItems.remove(i);
                    	 y-- ;
                    	 i-- ;

                      } 
                     

                  }
            	  customArrayAdapter.notifyDataSetChanged(); 
                  mylistview.clearChoices(); 
                  ShowMessage("Success","Verified Successfully." );	 
                   
         
            	
            }});
		
		   
		
		
		
		refreshItemsFromTable();
	  
	  return view;
	  

	 }

	public static TodoItem ITEM_TO_EDIT = null;

	 
	
		//public void SaveClicked(String nameEditText ,String cellNoEditText, String sex )
		public void SaveClicked(TodoItem item  )
		{
			ITEM_TO_EDIT = item;
		
			
			
			
						/*Log.d("cellNoEditText=",cellNoEditText);
			if(cellNoEditText!=null)
			PendingListFragment.ITEM_TO_EDIT.setNotifyNumber(cellNoEditText);
			else
				PendingListFragment.ITEM_TO_EDIT.setNotifyNumber("232332");
				
			Log.d("sex=",sex);
			if(sex!=null)
				PendingListFragment.ITEM_TO_EDIT.setSex(sex);
			else
				PendingListFragment.ITEM_TO_EDIT.setSex("male");
			
			
			
		
			Date dob = new Date(1000);
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("2011");
			strBuilder.append("-");
			strBuilder.append("06");
			strBuilder.append("-");
			strBuilder.append("09");
			
			dob = Date.valueOf(strBuilder.toString());
			
			*/

		
			PendingListFragment.ITEM_TO_EDIT.setComplete(true);
			//ShowMessage("exception", ViewDetailFragment.ITEM_TO_EDIT.toString());  
			 
			mToDoTable.update(PendingListFragment.ITEM_TO_EDIT, new TableOperationCallback<TodoItem>() {
			      public void onCompleted(TodoItem entity, Exception exception, ServiceFilterResponse response) {
			    	    
			            if (exception == null) 
			            {
			            		
			     
			            } 
			            else 
			            {
			            	ShowMessage("exception", exception.toString());  
			            	//	ShowMessage("Failed", "Cannot be Updated");
			            }
			      }
			      });
			
		}
		
		
	 @Override
	 public void onItemClick(AdapterView<?> parent, View view, int position,
	   long id) {
		
		 Toast.makeText(getActivity().getApplicationContext(), "df", Toast.LENGTH_SHORT).show();
	 // String member_name = listItems.get(position).getText();
	  
	  //Item planet = customArrayAdapter.getItem(position);
	  
//planet.setChecked(true);	  
     
//customArrayAdapter.notifyDataSetChanged(); 
	  
	  /*
	  
	  Fragment fragment2 = new FragmentUpdate();
	  Bundle args = new Bundle();
     args.putString(FragmentUpdate.NAME, member_name);
     fragment2.setArguments(args);
	  FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
	  fragmentTransaction.replace(R.id.frame_container, fragment2, member_name);
	  fragmentTransaction.addToBackStack(member_name);
	  fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
	  fragmentTransaction.commit();
	 // ListView checklistview1 = (ListView) view.findViewById(R.id.listCheckbox);
	  //checklistview1.setVisibility(View.VISIBLE);
	//  CheckBox checkObj = (CheckBox) view.findViewById(R.id.checkBoxId);
	  //  checkObj.setVisibility(View.GONE);
	  //rowCheckBoxItems.get(position).g
	   
	  */
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

						customArrayAdapter.notifyDataSetChanged();	  
					} else {
						ShowMessage("exception", exception.toString());
					}
				}
			});
		}

		public void ShowMessage(String title, String message)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());

			builder.setMessage(message);
			
			builder.setIcon(R.drawable.ic_action_done);
			builder.setTitle(title);
			builder.create().show();
		}
		ImageView seeDetailImg;
		
		
		 @Override
		 public void onActivityCreated(Bundle savedInstanceState) {
		     // TODO Auto-generated method stub
		     super.onActivityCreated(savedInstanceState);
	
		 	final Button btnMenu = (Button) getView().findViewById(R.id.menu_button_id);
			
			//final View v = view;
				btnMenu.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						//Toast.makeText(getApplicationContext(), "add", Toast.LENGTH_LONG).show();
						Intent i = new Intent(v.getContext(), MainMenuActivity.class);
						startActivity(i);
					}
				});	
		 }
	
	} 


