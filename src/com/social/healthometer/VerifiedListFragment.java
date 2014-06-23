package com.social.healthometer;

import static com.microsoft.windowsazure.mobileservices.MobileServiceQueryOperations.val;

import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.social.healthometer.R.color;
import com.social.healthometer.adapter.CustomArrayAdapter;
import com.social.healthometer.adapter.ListItemAdapter;
import com.social.healthometer.model.TodoItem;
import com.social.healthometer.model.ListItems;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class VerifiedListFragment extends Fragment implements OnItemClickListener  {
	 
	 String[] member_names;
	 TypedArray profile_pics;
	 String[] mob_num;
	 String[] code;
	 
	// List<CheckBoxItem> rowCheckBoxItems ;
	 //List<ListItems> listItems;
	 ListView mylistview , checklistview;

	 private CustomArrayAdapter customArrayAdapter;
	 private MobileServiceClient mClient;
		private MobileServiceTable<TodoItem> mToDoTable;
		Boolean ready;
		
	 
	// List<CheckBoxItem> rowCheckBoxItems ;
		private ArrayList<TodoItem> listItems;

	 @Override
	    public View onCreateView(LayoutInflater inflater, 
	              ViewGroup container, Bundle savedInstanceState) {
	        
	  View view = inflater.inflate(R.layout.fragment_verified,  container, false);
	   mylistview = (ListView) view.findViewById(R.id.listverified);

	  
	   mylistview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	  
	  listItems = new ArrayList<TodoItem>();  
	//  rowCheckBoxItems = new ArrayList<CheckBoxItem>();  
	  customArrayAdapter = new CustomArrayAdapter(getActivity().getApplicationContext(),listItems);
	  mylistview.setAdapter(customArrayAdapter);
	//  rowCheckBoxItems = new ArrayList<CheckBoxItem>();  
	  
	  /*
	  member_names = getResources().getStringArray(R.array.Member_names);

	  profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

	  code = getResources().getStringArray(R.array.code);

	  mob_num = getResources().getStringArray(R.array.mob_num);
	
	  for (int i = 0; i < member_names.length; i++) {
		  
	   ListItems item = new ListItems(true, member_names[i], profile_pics.getResourceId(i, -1), code[i], mob_num[i]);
	   //CheckBoxItem checkItem = new CheckBoxItem(true);
	//   rowCheckBoxItems.add(checkItem);
	   listItems.add(item);
	  }

	  mylistview = (ListView) view.findViewById(R.id.list);
	  ListItemAdapter adapter = new ListItemAdapter(this.getActivity(), listItems);
	  mylistview.setAdapter(adapter);
	  profile_pics.recycle();
*/
	  
	  mylistview.setOnItemClickListener(this);
	 
	 
	  
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
		
		refreshItemsFromTable();
	  
	  
	  return view;

	 }

	
	 
	 
	 @Override
	 public void onItemClick(AdapterView<?> parent, View view, int position,
	   long id) {

		  String member_name = listItems.get(position).getText();
	  Toast.makeText(this.getActivity().getApplicationContext(), "df" + member_name,
	    Toast.LENGTH_SHORT).show();
	    
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
	   
	  
	 }
	 
	 private void refreshItemsFromTable() {

		
			mToDoTable.where().field("complete").eq(val(true)).execute(new TableQueryCallback<TodoItem>() {
				
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

	 
	 public void ShowMessage(String title, String message)
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());

			builder.setMessage(message);
			builder.setTitle(title);
			builder.create().show();
		}
	 
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


