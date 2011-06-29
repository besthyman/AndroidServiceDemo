package com.hyman.demo.android.service.client.bound.aidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hyman.demo.android.service.bound.aidl.IRemoteService;
import com.hyman.demo.android.service.client.R;

public class ServiceClientActivity extends Activity implements OnClickListener{
	private IRemoteService mIRemoteService;

    /** Flag indicating whether we have called bind on the service. */
    private boolean mBound;

    private static final String TAG = "ServiceClientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_aidl_client);
        Button startButton = (Button) this.findViewById(R.id.buttonStart);
        startButton.setOnClickListener(this);
        Button stopButton = (Button) this.findViewById(R.id.buttonStop);
        stopButton.setOnClickListener(this);
        Button randomButton = (Button) this.findViewById(R.id.buttonSend);
        randomButton.setOnClickListener(this);
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                IBinder service) {
        	// Following the example above for an AIDL interface,
            // this gets an instance of the IRemoteInterface, which we can use to call on the service
            mIRemoteService = IRemoteService.Stub.asInterface(service);
            mBound = true;

			Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        	Log.e(TAG, "Service has unexpectedly disconnected");
            mIRemoteService = null;
            mBound = false;
			Log.d(TAG, "onServiceDisconnected");
        }
    };


	@Override
	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.buttonStart:
			Log.d(TAG, "onClick: buttonStart");
			// Bind to the service
			Intent intent = new Intent();
			intent.setAction("com.hyman.demo.android.service.bound.aidl.ACTION_REMOTE");
	        bindService(intent, mConnection,
	            Context.BIND_AUTO_CREATE);
			break;
		case R.id.buttonStop:
			Log.d(TAG, "onClick: buttonStop");
			// Unbind from the service
	        if (mBound) {
	            unbindService(mConnection);
	            mBound = false;
	        }
			break;
		case R.id.buttonSend:
			Log.d(TAG, "onClick: buttonSend");
	        if (mBound) {
				Log.d(TAG, "call remote service");
				int pid = -1;
				try {
					pid = mIRemoteService.getPid();
				} catch (RemoteException e) {
					e.printStackTrace();
					Log.d(TAG, "RemoteException");
				}
				Log.d(TAG, "pid:" + pid);
	        }
			break;
		}
	}
}
