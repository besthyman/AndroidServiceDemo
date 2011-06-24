package com.hyman.demo.android.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

import com.hyman.demo.android.service.player.audio.AudioPlayerActivity;

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
				}
			}
        	
        });
    }
}