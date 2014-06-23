package com.social.healthometer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentUpdate extends Fragment {

	static public  String NAME; 
	public View onCreateView(  LayoutInflater inflater, ViewGroup container , Bundle bundle)
	{
		View rootView = inflater.inflate(R.layout.fragment_person_detail, container, false);
		return rootView;
	}
	
}
