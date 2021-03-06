package com.hyman.demo.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

import com.hyman.demo.android.service.bound.binder.BindingActivity;
import com.hyman.demo.android.service.bound.messager.MessagerActivity;
import com.hyman.demo.android.service.player.audio.AudioPlayerActivity;
import com.hyman.demo.android.service.unbound.general.GeneralUnboundActivity;
import com.hyman.demo.android.service.unbound.intent.IntentServiceActivity;

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
				if ("audio player".equals(value)) {
					Intent intent = new Intent(MainActivity.this, AudioPlayerActivity.class);
					MainActivity.this.startActivity(intent);
				} else if ("bound binder".equals(value)) {
					Intent intent = new Intent(MainActivity.this, BindingActivity.class);
					MainActivity.this.startActivity(intent);
				} else if ("bound messager".equals(value)) {
					Intent intent = new Intent(MainActivity.this, MessagerActivity.class);
					MainActivity.this.startActivity(intent);
				} else if ("unbound intent".equals(value)) {
					Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
					MainActivity.this.startActivity(intent);
				} else if ("unbound general".equals(value)) {
					Intent intent = new Intent(MainActivity.this, GeneralUnboundActivity.class);
					MainActivity.this.startActivity(intent);
				}
			}
        	
        });
    }
}