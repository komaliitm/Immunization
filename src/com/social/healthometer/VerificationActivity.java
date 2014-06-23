package com.social.healthometer;



import static com.microsoft.windowsazure.mobileservices.MobileServiceQueryOperations.val;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableQueryCallback;
import com.social.healthometer.adapter.CustomArrayAdapter;
import com.social.healthometer.model.TodoItem;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class VerificationActivity extends Activity  {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verification);
		Fragment fragment = null;	
		fragment = new PendingListFragment();
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();		
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
			}
		else {
			// error in creating fragment
				Log.e("MainActivity", "Error in creating fragment");
			}
					
			TextView textObj = (TextView)findViewById(R.id.pending_text_id);
			textObj.setOnClickListener( new OnClickListener() {
	            @Override
	            public void onClick(View viewIn) {
	            	 Fragment fragmentPending = null;
	     			
	            	 fragmentPending = new PendingListFragment();
	     			if (fragmentPending != null) {
	     				FragmentManager fragmentManager = getFragmentManager();
	     				fragmentManager.beginTransaction().replace(R.id.frame_container, fragmentPending).commit();

	     			} else {
	     				// error in creating fragment
	     				Log.e("MainActivity", "Error in creating fragment");
	     			}
	     		
	            }
	        });
			
			TextView textObjVerified = (TextView)findViewById(R.id.verified_text_id);
			textObjVerified.setOnClickListener( new OnClickListener() {
	            @Override
	            public void onClick(View viewIn) {
	            	 Fragment fragmentVerified = null;
	     			
	            	 fragmentVerified = new VerifiedListFragment();
	            	
	     			if (fragmentVerified != null) {
	     				FragmentManager fragmentManager = getFragmentManager();
	     				fragmentManager.beginTransaction().replace(R.id.frame_container, fragmentVerified).commit();

	     			} else {
	     				// error in creating fragment
	     				Log.e("MainActivity", "Error in creating fragment");
	     			}
	     		
	            }
	        });
		
			
	            	 
			
			
	}
	
 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.verification, menu);
		return true;
	}



	//private  ArrayList<TodoItem> items;
	//EditText code;
	
	
	
	
	
	public void ShowMessage(String title, String message)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setMessage(message);
		builder.setTitle(title);
		builder.create().show();
	}
}
