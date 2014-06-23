package com.social.healthometer.model;

public class ListItems {

	private boolean checkbox_state ;
	 private String member_name;
	 private int profile_pic_id;
	 private String status;
	 private String contactType;
	 private boolean inEditMode;

	 public ListItems(boolean checkbox_state, String member_name, int profile_pic_id, String status,
	   String contactType) {

		 this.checkbox_state=checkbox_state ;
	  this.member_name = member_name;
	  this.profile_pic_id = profile_pic_id;
	  this.status = status;
	  this.contactType = contactType;
	 }
	 
	 public boolean getCheckBoxState() {
		  return checkbox_state;
		 }

		 public void setCheckBoxState(boolean checkbox_state) {
		  this.checkbox_state = checkbox_state;
		 }


	 public String getMember_name() {
	  return member_name;
	 }

	 public void setMember_name(String member_name) {
	  this.member_name = member_name;
	 }

	 public int getProfile_pic_id() {
	  return profile_pic_id;
	 }

	 public void setProfile_pic_id(int profile_pic_id) {
	  this.profile_pic_id = profile_pic_id;
	 }

	 public String getStatus() {
	  return status;
	 }

	 public void setStatus(String status) {
	  this.status = status;
	 }

	 public String getContactType() {
	  return contactType;
	 }

	 public void setContactType(String contactType) {
	  this.contactType = contactType;
	 }

	} 
