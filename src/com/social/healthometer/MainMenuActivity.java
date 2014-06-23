package com.social.healthometer;


import com.social.actionlisteners.ButtonClickListener;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;

public class MainMenuActivity extends Activity {

	private Button btnAdd;
    private Button btnSearch;
    private Button btnVerify;
    private Button btnSettings;
    private OnClickListener onClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        btnAdd = (Button) findViewById(R.id.add_button);
        btnSearch = (Button) findViewById(R.id.search_button);
    	btnVerify = (Button) findViewById(R.id.verify_button);
    	btnSettings = (Button) findViewById(R.id.settings_button);
    	onClickListener=new ButtonClickListener(this);
		
		btnAdd.setOnClickListener(onClickListener);
		btnVerify.setOnClickListener(onClickListener);
		btnSearch.setOnClickListener(onClickListener);
		btnSettings.setOnClickListener(onClickListener);
		
		
        
    }

    @Override
    protected void onResume()
    {
    	
    	super.onResume();
    	
    	if (this.getApplicationContext().getResources().getConfiguration().locale.toString().equals("hi")) {
    		 setContentView(R.layout.activity_main_menu);
    		 btnAdd = (Button) findViewById(R.id.add_button);
    	        btnSearch = (Button) findViewById(R.id.search_button);
    	    	btnVerify = (Button) findViewById(R.id.verify_button);
    	    	btnSettings = (Button) findViewById(R.id.settings_button);
    	    	onClickListener=new ButtonClickListener(this);
    			
    			btnAdd.setOnClickListener(onClickListener);
    			btnVerify.setOnClickListener(onClickListener);
    			btnSearch.setOnClickListener(onClickListener);
    			btnSettings.setOnClickListener(onClickListener);
			
		}
    	
    	if (this.getApplicationContext().getResources().getConfiguration().locale.toString().equals("en")) {
   		 setContentView(R.layout.activity_main_menu);
   		btnAdd = (Button) findViewById(R.id.add_button);
        btnSearch = (Button) findViewById(R.id.search_button);
    	btnVerify = (Button) findViewById(R.id.verify_button);
    	btnSettings = (Button) findViewById(R.id.settings_button);
    	onClickListener=new ButtonClickListener(this);
		
		btnAdd.setOnClickListener(onClickListener);
		btnVerify.setOnClickListener(onClickListener);
		btnSearch.setOnClickListener(onClickListener);
		btnSettings.setOnClickListener(onClickListener);
			
		}
    	
    	
    	
    }
   
  
    
}
