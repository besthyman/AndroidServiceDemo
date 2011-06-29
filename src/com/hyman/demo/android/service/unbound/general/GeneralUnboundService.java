package com.hyman.demo.android.service.unbound.general;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class GeneralUnboundService extends Service {
	private static final String TAG = "GeneralUnboundService";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "GeneralUnboundService Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "GeneralUnboundService Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "GeneralUnboundService Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStartCommand");
        Log.d(TAG, "Before Sleep");
        SystemClock.sleep(5 * 1000); // 5 seconds
        Log.d(TAG, "After Sleep");
		return START_STICKY;
	}
}
