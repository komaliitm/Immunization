package com.social.healthometer.adapter;



import java.util.ArrayList;

import com.social.healthometer.R;
import com.social.healthometer.model.SearchFilterItem;



import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

   @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    private Context context;
 
    TextView groupTitle;
    private ArrayList<String> groups;

    private ArrayList<ArrayList<SearchFilterItem>> children;
    private ArrayList<ArrayList<SearchFilterItem>> iconImage;
    EditText tv;
    public ExpandableListAdapter(Context context, ArrayList<String> groups, ArrayList<ArrayList<SearchFilterItem>> children) {
        this.context = context;
        this.groups = groups;
        this.children = children;
    }

    /**
     * A general add method, that allows you to add a Vehicle to this list
     * 
     * Depending on if the category opf the vehicle is present or not,
     * the corresponding item will either be added to an existing group if it 
     * exists, else the group will be created and then the item will be added
     * @param vehicle
     */
    public void addItem(SearchFilterItem searchFilterItem , int count) 
    {
      if (!groups.contains(searchFilterItem.getGroup())) {
         groups.add(searchFilterItem.getGroup());
     }
       int index = groups.indexOf(searchFilterItem.getGroup());
   
   if (children.size() < index + 1) {
            children.add(new ArrayList<SearchFilterItem>() );
   }
        
        children.get(index).add(searchFilterItem);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children.get(groupPosition).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    // Return a child view. You can load your custom layout here.
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
    	SearchFilterItem searchFilterItem = (SearchFilterItem) getChild(groupPosition, childPosition);
    	
        if (convertView == null) {
        	Log.d("Nulllllllllllllllllllll", "no back");
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.searchfilter_item, null);
            
        }
        Log.d("mmmmmmmmmmmmmmmmmm", "no back");
             tv = (EditText) convertView.findViewById(R.id.editText1);
            tv.setTag(childPosition);
            
        ImageView imageIcon =(ImageView) convertView.findViewById(R.id.ImageView01);
        if(childPosition==0)
        tv.setHint("Enter Name");
        else
        	if(childPosition==1)
        		 tv.setHint("Enter Phone No");
        	else
        		if(childPosition==2)
           		 tv.setHint("Enter Date of Birth");
        
        imageIcon.setImageResource(children.get(0).get(childPosition).getProfile_pic_id());
       // searchFilterItem.setGroup("Search Options"); 
        // Depending upon the child type, set the imageTextView01
    //    tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        
        tv.setText(children.get(0).get(childPosition).getName());
        
            tv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.dark_red_gradient, 0, 0, 0);
           // tv.setId(childPosition);
           final int c = childPosition;
         //  final int g = groupPosition;
      	  
           /*  tv.setOnClickListener(new OnClickListener(){
        	  
        	   public void onClick(View arg0) {
        		   Log.d("clivkkkkkkkkkkkkkkkkk", "no back");
        			children.get(0).get(c).setName( ((EditText)arg0.findViewById(R.id.editText1)).getText().toString());
    					
   	            // Do something here.
   	        }
        	   
           });
           */
          
           
            tv.setOnKeyListener( new OnKeyListener() {
            	 
            	  
    			@Override
    			public boolean onKey(View arg0, int keyCode, KeyEvent event) {
    				// TODO Auto-generated method stub
    				Log.d("innnnnnnnnnnnnnnnnnnnnnnnnnnnn", "no back");
    				//if( keyCode != KeyEvent.KEYCODE_BACK )
    			    //{ 
    					
    					children.get(0).get(c).setName( ((EditText)arg0.findViewById(R.id.editText1)).getText().toString());
    					
    				// super.onKey( keyCode, event );
    				
    			   // }
    				//else
    				//{
    				//	((EditText)arg0.findViewById(R.id.verificiation_code_id)).setFocusable(false);
    					Log.d("Backhhghg", "yes back");
    					
    			//	}
    				
    				return false;
    				
    			}
    			
    			 
    	    	
    	    });
            
         
            
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    
    // Return a group view. You can load your custom layout here.
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        String group = (String) getGroup(groupPosition);
        Log.d("gggggggggggggggggggg", "no back");
        if (convertView == null) {
        	  Log.d("reeeeeeeeeeeeeeeeeeee", "no back");
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_layout, null);
       
            int i = Integer.parseInt(convertView.getTag().toString());
             
            
            
            
            TextView groupTitle = (TextView) convertView.findViewById(R.id.tvGroup);
        groupTitle.setText("Search Filters");
        }
        
        
        
        
        
        
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        return true;
    }

}