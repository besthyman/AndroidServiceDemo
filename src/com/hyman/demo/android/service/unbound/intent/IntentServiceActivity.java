package com.hyman.demo.android.service.unbound.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hyman.demo.android.service.R;

/**
 * 
 * @author Hyman
 *
 */
public class IntentServiceActivity extends Activity {
	private static final String TAG = "IntentServiceActivity";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unbound_intent);
	}
	
	public void onSendClick(View src) {
		Log.d(TAG, "onSendClick");
		Intent msgIntent = new Intent(this, SimpleIntentService.class);
		startService(msgIntent);
	}
}
/*
click send button one time
06-29 07:53:10.508: DEBUG/IntentServiceActivity(482): onSendClick
06-29 07:53:10.608: DEBUG/SimpleIntentService(482): SimpleIntentService
06-29 07:53:10.637: DEBUG/SimpleIntentService(482): onCreate
06-29 07:53:10.688: DEBUG/SimpleIntentService(482): onHandleIntent
06-29 07:53:10.688: DEBUG/SimpleIntentService(482): Before Sleep
06-29 07:53:20.750: DEBUG/SimpleIntentService(482): After Sleep
06-29 07:53:20.767: DEBUG/SimpleIntentService(482): onDestroy


click send button one time, and click it again after one second
06-29 07:53:23.907: DEBUG/IntentServiceActivity(482): onSendClick
06-29 07:53:23.997: DEBUG/SimpleIntentService(482): SimpleIntentService
06-29 07:53:24.018: DEBUG/SimpleIntentService(482): onCreate
06-29 07:53:24.028: DEBUG/SimpleIntentService(482): onHandleIntent
06-29 07:53:24.037: DEBUG/SimpleIntentService(482): Before Sleep
06-29 07:53:24.258: DEBUG/IntentServiceActivity(482): onSendClick
06-29 07:53:34.089: DEBUG/SimpleIntentService(482): After Sleep
06-29 07:53:34.089: DEBUG/SimpleIntentService(482): onHandleIntent
06-29 07:53:34.098: DEBUG/SimpleIntentService(482): Before Sleep
06-29 07:53:44.142: DEBUG/SimpleIntentService(482): After Sleep
06-29 07:53:44.157: DEBUG/SimpleIntentService(482): onDestroy
 */