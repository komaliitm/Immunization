package com.social.healthometer;
import java.util.Locale;




import com.social.actionlisteners.ButtonClickListener;
import com.social.utilities.Localization;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.OnNavigationListener;
import android.content.Intent;
import android.content.res.Configuration;
public class ChooseLanguageActivity extends Activity  {
	
	 /** An array of strings to populate dropdown list */
    String[] actions = new String[] {
        "Menu",
        "Add Detail",
        "Search",
        "Verify",
        "Setting"
    };
    
    private Locale activityLocale;
    private OnClickListener onClickListener;
    private  Button btnEnglish;
    private  Button btnHindi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
setContentView(R.layout.activity_choose_language);

//setting the private variables
activityLocale=this.getResources().getConfiguration().locale;
onClickListener=new ButtonClickListener(this.getBaseContext(),activityLocale);
btnEnglish = (Button) findViewById(R.id.english);
btnHindi=(Button)findViewById(R.id.hindi);

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
				Intent j = new Intent(getBaseContext(), AddDetailsActivity.class);
				startActivity(j);
			    break;
			default:
			    break;
			}

		
			return true;
		    }
    
      
    
};


getActionBar().setListNavigationCallbacks(adapter, navigationListener);

				
btnEnglish.setOnClickListener(onClickListener);
btnHindi.setOnClickListener(onClickListener);
				

}
}
