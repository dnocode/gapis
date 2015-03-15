package com.dnocode.google.apis.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class AppUtils
{
        private static final String TAG = "APPUTILS";
        public static final String KEY_HOOK = "com.dnocode.google.apis.key";


    public static String getMetadataApplication(Context context,String key) {
        try {
                   ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);

              if (ai.metaData != null) { return ai.metaData.getString(key);  }

        } catch (PackageManager.NameNotFoundException e) {

            Log.e(TAG,e.getMessage());
        }

        return null;
    }





}
