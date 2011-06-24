package com.hyman.demo.android.service.bound.binder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.hyman.demo.android.service.R;
import com.hyman.demo.android.service.bound.binder.LocalService.LocalBinder;

public class BindingActivity extends Activity implements OnClickListener {
	LocalService mService;
    boolean mBound = false;
    String TAG = "BindingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_binder);
        Button startButton = (Button) this.findViewById(R.id.buttonStart);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) this.findViewById(R.id.buttonStop);
        stopButton.setOnClickListener(this);
        Button randomButton = (Button) this.findViewById(R.id.buttonRandom);
        randomButton.setOnClickListener(this);
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            LocalBinder binder = (LocalBinder) service;
            mService = binder.getService();
            mBound = true;
			Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        	// it only happens on 'unexpected service unbinding'
            mBound = false;
			Log.d(TAG, "onServiceDisconnected");
        }
    };

	@Override
	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.buttonStart:
			Log.d(TAG, "onClick: starting srvice");
	        // Bind to LocalService
	        Intent intent = new Intent(this, LocalService.class);
	        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
			break;
		case R.id.buttonStop:
			Log.d(TAG, "onClick: stopping srvice");
	        // Unbind from the service
	        if (mBound) {
				Log.d(TAG, "unbindService");
	            unbindService(mConnection);
	            mBound = false;
	        }
			break;
		case R.id.buttonRandom:
			Log.d(TAG, "onClick: geting random number");
	        if (mBound) {
				Log.d(TAG, "getRandomNumber");
	            // Call a method from the LocalService.
	            // However, if this call were something that might hang, then this request should
	            // occur in a separate thread to avoid slowing down the activity performance.
	            int num = mService.getRandomNumber();
	            Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
	        }
			break;
		}
	}

}
