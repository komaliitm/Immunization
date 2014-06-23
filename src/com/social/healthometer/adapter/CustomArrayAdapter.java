package com.social.healthometer.adapter;

import java.util.ArrayList;

import com.social.healthometer.AddDetailsActivity;
import com.social.healthometer.R;
import com.social.healthometer.model.TodoItem;

import android.R.color;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Editable;
//import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomArrayAdapter extends ArrayAdapter<TodoItem> {
	
	private final ArrayList<TodoItem> items;
	private final Context context;
	
	public CustomArrayAdapter(Context context, ArrayList<TodoItem> values) {
	    super(context, R.layout.list_pending_item, values);
	    this.context = context;
	    this.items = values;
	  }
	 private String nameVal[] ;

	public View getView( int position, View convertView, ViewGroup parent) {
	   
	//	 if (convertView == null) {
		LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.list_pending_item, parent, false);
	 

	//	 }
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
		  */
	    TextView nameTextView = (TextView) rowView.findViewById(R.id.name_id);
	    ImageView profile_pics = (ImageView) rowView.findViewById(R.id.profile_pic_id);
	    ImageView see_details = (ImageView) rowView.findViewById(R.id.see_detail1);
	    
	    TextView mob_num = (TextView) rowView.findViewById(R.id.mob_id);
	    
	    TextView genderText = (TextView) rowView.findViewById(R.id.gender_id);
	    
	    EditText code = (EditText) rowView.findViewById(R.id.verificiation_code_id);
	  
	  
	  
	    
	    final int a = position;
	    
	    code.setText(items.get(a).getNotifyNumber());
	    
	  /*  code.setOnFocusChangeListener(new OnFocusChangeListener() {          

	        public void onFocusChange(View v, boolean hasFocus) {
	            if(!hasFocus)
	            {
	            	   
	               //do job here when EditText loses focus
	            }
	            else
	            	  items.get(a).setNotifyNumber( ((EditText)v.findViewById(R.id.verificiation_code_id)).getText().toString());
			    
	        }
	    });
	*/  
	    
	    code.setOnKeyListener( new OnKeyListener() {
 	
			@Override
			public boolean onKey(View arg0, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if( keyCode != KeyEvent.KEYCODE_BACK )
			      { 
				   items.get(a).setNotifyNumber( ((EditText)arg0.findViewById(R.id.verificiation_code_id)).getText().toString());
				   Log.d("Key", "no back");
				// super.onKey( keyCode, event );
				return false;
			    }
				else
				{
				//	((EditText)arg0.findViewById(R.id.verificiation_code_id)).setFocusable(false);
					Log.d("Back", "yes back");
					return false;
				}
				
				
				
			}
			
			 
	    	
	    });
	    
	    
	    CheckBox ck = (CheckBox)rowView.findViewById(R.id.checkBox_id);
	    
	   
	   if(parent.getId() == R.id.listverified||parent.getId() == R.id.listView1) 
	   {
		  
		   ck.setVisibility(View.GONE);
	   }
	
	   EditText otp= (EditText)rowView.findViewById(R.id.verificiation_code_id);
	   if(parent.getId() == R.id.listView1) 
	   {
		  
		   otp.setVisibility(View.GONE);
	   } 
	   //ck.setFocusable(true);
	   ck.setClickable(true);
	   ck.setChecked(items.get(position).isChecked());
	    //ck.setChecked(items.get(position).isChecked());
	  if( items.get(position).isChecked() )
	  ck.setBackgroundResource(R.drawable.dark_green_gradient);
	  
	    ck.setOnClickListener(new OnClickListener() {
	        @SuppressLint("ResourceAsColor")
			@Override
	        public void onClick(View arg0) {
	        	if(!items.get(a).isChecked())
	        	{
	        		items.get(a).setChecked(true);
	        		arg0.setBackgroundResource(R.drawable.dark_green_gradient);
	        	}
	        	else
	        	{
	        		items.get(a).setChecked(false);
	        		arg0.setBackgroundResource(R.drawable.checkbox_gradient);
	        	}
	        		
	            // Do something here.
	        }
	    });
	
	 
	    nameTextView.setText(items.get(position).getText());
	   
	    genderText.setText(items.get(position).getSex());
	    // mob_num.setText(items.get(position).getMobileNumber());
	     mob_num.setText(items.get(position).getRegCode());
	    code.setText(items.get(position).getNotifyNumber());
	  
	
	    nameTextView.setTextColor(Color.BLACK);
	    genderText.setTextColor(Color.BLACK);
	     mob_num.setTextColor(Color.BLACK);
	     code.setTextColor(Color.BLACK);
	  
	   
	     genderText.setTextColor(Color.BLACK);
	   
	    // Change the icon for Windows and iPhone
	   //profile_pics.recycle();
	    return rowView;
	}
	
}
