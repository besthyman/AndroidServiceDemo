package com.hyman.demo.android.service.bound.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class RemoteService extends Service {
	private static final String TAG = "RemoteService";
    
    public void onCreate() {
    	Log.d(TAG, "onCreate");
    }
    
    public void onDestroy() {
    	Log.d(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        public int getPid(){
            // return Process.myPid();
            return 0;
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
            float aFloat, double aDouble, String aString) {
            // Does nothing
        }
    };

}
