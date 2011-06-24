package com.hyman.demo.android.service.bound.messager;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class MessagerService extends Service {
	private static final String TAG = "LocalService";
	/** Command to the service to display a message */
	static final int MSG_SAY_HELLO = 1;

	/**
	 * Handler of incoming messages from clients.
	 */
	class IncomingHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SAY_HELLO:
				Toast.makeText(getApplicationContext(), "hello!",
						Toast.LENGTH_SHORT).show();
				break;
			default:
				super.handleMessage(msg);
			}
		}
	}

	/**
	 * Target we publish for clients to send messages to IncomingHandler.
	 */
	final Messenger mMessenger = new Messenger(new IncomingHandler());

	/**
	 * When binding to the service, we return an interface to our messenger for
	 * sending messages to the service.
	 */
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT)
				.show();
		return mMessenger.getBinder();
	}
    
    public void onCreate() {
    	Log.d(TAG, "onCreate");
    }
    
    public void onDestroy() {
    	Log.d(TAG, "onDestroy");
    }

}
