package com.hyman.demo.android.service.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

import com.hyman.demo.android.service.client.bound.aidl.ServiceClientActivity;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnFrameLayout = (Button) this.findViewById(R.id.servicebutton);
        final Spinner spinner = (Spinner) this.findViewById(R.id.servicespinner);
        btnFrameLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String value = spinner.getSelectedItem().toString();
				if ("bound aidl client".equals(value)) {
					Intent intent = new Intent(MainActivity.this, ServiceClientActivity.class);
					MainActivity.this.startActivity(intent);
				}
			}
        	
        });
    }
}