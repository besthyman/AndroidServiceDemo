package com.hyman.demo.android.service.unbound.intent;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class SimpleIntentService extends IntentService {
	private static final String TAG = "SimpleIntentService";
 
    public SimpleIntentService() {
        super("SimpleIntentService");
        Log.d(TAG, "SimpleIntentService");
    }
 
    @Override
    protected void onHandleIntent(Intent intent) { 
        Log.d(TAG, "onHandleIntent");
        Log.d(TAG, "Before Sleep");
        SystemClock.sleep(10 * 1000); // 10 seconds
        Log.d(TAG, "After Sleep");
    }

    @Override
    public void onCreate() {
    	super.onCreate();
    	Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {
    	Log.d(TAG, "onDestroy");
    	super.onDestroy();
    }
}
