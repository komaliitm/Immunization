package com.social.healthometer;

import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;










import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;









import android.widget.Toast;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;
import com.microsoft.windowsazure.mobileservices.TableOperationCallback;
import com.social.healthometer.model.TodoItem;


public class AddDetailsActivity extends Activity {
	
	
	
	private FragmentAddDetails addDetailsFragment;
	
	
	
	//private DatePicker datePicker;
	private EditText dateOfbirth;
public AddDetailsActivity()
{
	 Log.d("createView", "value1");

}
	
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	
	
	setContentView(R.layout.activity_add_details);
	
	addDetailsFragment=new FragmentAddDetails();
	if (ViewDetailFragment.ITEM_TO_EDIT!=null) {
		addDetailsFragment.setItem(ViewDetailFragment.ITEM_TO_EDIT);

		ViewDetailFragment.ITEM_TO_EDIT=null;
	}
	
	

	FragmentManager fragmentManager=getFragmentManager();
	android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
	fragmentTransaction.add(R.id.frame,addDetailsFragment);
	fragmentTransaction.commit();
	
}






}
