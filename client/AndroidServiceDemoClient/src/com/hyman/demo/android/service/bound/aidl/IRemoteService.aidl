package com.hyman.demo.android.service.bound.aidl;

// Declare any non-default types here with import statements

/** 
this aidl file content should be exactly like the remote one, include package decalre
I try to put this file under a new package 'com.hyman.demo.android.service.client.bound.aidl', and encouter the following error:
	enforceInterface() expected 'com.hyman.demo.android.service.bound.aidl.IRemoteService' but read 'com.hyman.demo.android.service.client.bound.aidl.IRemoteService'

*/

/** Example service interface */
interface IRemoteService {
    /** Request the process ID of this service, to do evil things with it. */
    int getPid();

    /** Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}