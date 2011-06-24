package com.hyman.demo.android.service.bound.messager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hyman.demo.android.service.R;

public class MessagerActivity extends Activity implements OnClickListener {
	/** Messenger for communicating with the service. */
    Messenger mService = null;

    /** Flag indicating whether we have called bind on the service. */
    boolean mBound;

    String TAG = "MessagerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bound_messager);
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
        	// This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            mService = new Messenger(service);
            mBound = true;

			Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
        	// This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            mService = null;
            mBound = false;
			Log.d(TAG, "onServiceDisconnected");
        }
    };


	@Override
	public void onClick(View src) {
		switch (src.getId()) {
		case R.id.buttonStart:
			Log.d(TAG, "onClick: starting srvice");
			// Bind to the service
	        bindService(new Intent(this, MessagerService.class), mConnection,
	            Context.BIND_AUTO_CREATE);
			break;
		case R.id.buttonStop:
			Log.d(TAG, "onClick: stopping srvice");
			// Unbind from the service
	        if (mBound) {
	            unbindService(mConnection);
	            mBound = false;
	        }
			break;
		case R.id.buttonSend:
			Log.d(TAG, "onClick: Send");
	        if (mBound) {
				Log.d(TAG, "sayHello");
		        // Create and send a message to the service, using a supported 'what' value
		        Message msg = Message.obtain(null, MessagerService.MSG_SAY_HELLO, 0, 0);
		        try {
		            mService.send(msg);
		        } catch (RemoteException e) {
		            e.printStackTrace();
		        }
	        }
			break;
		}
	}

}
