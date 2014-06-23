package com.social.healthometer.adapter;



import java.util.List;

import com.social.healthometer.R;
import com.social.healthometer.model.ListItems;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemAdapter extends BaseAdapter {

 Context context;
 List<ListItems> listItems;

 public ListItemAdapter(Context context, List<ListItems> listItems) {
  this.context = context;
  this.listItems = listItems;
 }

 @Override
 public int getCount() {
  return listItems.size();
 }

 @Override
 public Object getItem(int position) {
  return listItems.get(position);
 }

 @Override
 public long getItemId(int position) {
  return listItems.indexOf(getItem(position));
 }
 ViewHolder v = new ViewHolder();
 public void setcheckbox() {

    // Log.d("viewholser" + v, "checkbox" + v.selected);

   //  v.selected.setVisibility(View.VISIBLE);

 }
 /* private view holder class */
 private class ViewHolder {
  CheckBox check_box;
	 ImageView profile_pic;
  TextView member_name;
  TextView status;
  TextView contactType;
  
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {

  ViewHolder holder = null;

  LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
  if (convertView == null) 
  {
   convertView = mInflater.inflate(R.layout.list_pending_item, null);
   holder = new ViewHolder();

 
   holder.profile_pic = (ImageView) convertView.findViewById(R.id.profile_pic_id);
   holder.status = (TextView) convertView.findViewById(R.id.mob_id);
   holder.contactType = (TextView) convertView.findViewById(R.id.gender_id);
   holder.check_box = (CheckBox)  convertView.findViewById(R.id.checkBox_id);
   holder.member_name = (TextView) convertView.findViewById(R.id.name_id);
   
   ListItems row_pos = listItems.get(position);

   holder.check_box.setChecked(row_pos.getCheckBoxState());
   holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
   holder.member_name.setText(row_pos.getMember_name());
   holder.status.setText(row_pos.getStatus());
   holder.contactType.setText(row_pos.getContactType());

   convertView.setTag(holder);
   holder.check_box.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
           //CheckBox cb = (CheckBox) v;
          // ListItems _state = (ListItems) cb.getTag();
    	  
          // _state.setCheckBoxState(cb.isChecked());
       }
      
       
   });
   
  /* 
   if (!AppConstants.ischeckboxvisible)
   {
holder.check_box.setVisibility(View.INVISIBLE);
}
if (AppConstants.ischeckboxvisible)
   {
  holder.check_box.setVisibility(View.VISIBLE);
}
*/
   
  } else {
   holder = (ViewHolder) convertView.getTag();
  }

  return convertView;
 }

}
