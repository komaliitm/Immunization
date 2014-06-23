package com.social.healthometer.model;

public class SearchFilterItem {
	int profile_pic_id;

    private String name;

    private String group;

    public String getGroup() {
        return group;
    }

	 public int getProfile_pic_id() {
		  return profile_pic_id;
		 }

		 public void setProfile_pic_id(int profile_pic_id) {
		  this.profile_pic_id = profile_pic_id;
		 }
		 
    public void setGroup(String group) {
        this.group = group;
    }

    public SearchFilterItem(int profile_pic_id) {
      //  this.name = name;
  	  this.profile_pic_id = profile_pic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}