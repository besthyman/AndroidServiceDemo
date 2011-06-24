package com.hyman.demo.android.service.player.audio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hyman.demo.android.service.R;

public class AudioPlayerActivity extends Activity implements OnClickListener {
	private static final String TAG = "AudioPlayerActivity";
	Button buttonStart, buttonStop;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_audio);

		buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonStop = (Button) findViewById(R.id.buttonStop);

		buttonStart.setOnClickListener(this);
		buttonStop.setOnClickListener(this);
	}

	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.buttonStart:
			Log.d(TAG, "onClick: starting srvice");
			startService(new Intent(this, AudioPlayerService.class));
			break;
		case R.id.buttonStop:
			Log.d(TAG, "onClick: stopping srvice");
			stopService(new Intent(this, AudioPlayerService.class));
			break;
		}
	}
}
