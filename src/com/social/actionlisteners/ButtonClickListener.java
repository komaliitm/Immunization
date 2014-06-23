package com.social.actionlisteners;


import java.util.Locale;

import com.social.healthometer.AddDetailsActivity;
import com.social.healthometer.MainMenuActivity;
import com.social.healthometer.R;
import com.social.healthometer.SettingsActivity;
import com.social.healthometer.VerificationActivity;
import com.social.healthometer.ViewDetailFragment;
import com.social.utilities.Localization;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ButtonClickListener implements OnClickListener {

	private Context context;
	private Locale locale;
	
	public  ButtonClickListener(Context context) {
		
		this.context=context;	
	}
	
	public ButtonClickListener(Context context,Locale locale)
	
	{
	
		this.context=context;
		this.locale=locale;
		
	}
	
	
	
	@Override
	public void onClick(View v) {
		
    if (v.getId()==R.id.english) {
    	  
    	
    	  Localization.setLanguage(context, "en",locale); 
    	  Intent i = new Intent(context, MainMenuActivity.class);
    	  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //To add the activity to the stack of running activities
		  context.startActivity(i);
	}		
 		
    if (v.getId()==R.id.hindi) {
    	
    	 Localization.setLanguage(context, "hi",locale); 
   	     Intent i = new Intent(context, MainMenuActivity.class);
   	  	 i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //To add the activity to the stack of running activities
		 context.startActivity(i);
    	
		
	}
	
    if (v.getId()==R.id.add_button) 
    {
    	Intent i = new Intent(context, AddDetailsActivity.class);
		context.startActivity(i);
    	
    }
    if (v.getId()==R.id.menuadd_button_id) 
    {
    	Intent i = new Intent(context, MainMenuActivity.class);
		context.startActivity(i);
    	
    }
	
    if (v.getId()==R.id.search_button) 
    {
    	Intent i = new Intent(context, ViewDetailFragment.class);
		context.startActivity(i);
    	
    }
    
    if (v.getId()==R.id.verify_button) 
    {
    	Intent i = new Intent(context, VerificationActivity.class);
		context.startActivity(i);
    	
    }
    
    if (v.getId()==R.id.settings_button) 
    {
    	Intent i = new Intent(context, SettingsActivity.class);
		context.startActivity(i);
    	
    }
    
    
    
    
    
    
    
		
	}

}
