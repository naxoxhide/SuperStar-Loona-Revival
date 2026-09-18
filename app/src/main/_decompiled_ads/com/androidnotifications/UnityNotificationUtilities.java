package com.unity.androidnotifications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class UnityNotificationUtilities {
    protected static int findResourceIdInContextByName(Context context, String name) {
        if (name == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources != null) {
                int identifier = resources.getIdentifier(name, "mipmap", context.getPackageName());
                return identifier == 0 ? resources.getIdentifier(name, "drawable", context.getPackageName()) : identifier;
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    protected static String serializeNotificationIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        Parcel parcelObtain = Parcel.obtain();
        extras.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        return Base64.encodeToString(bArrMarshall, 0, bArrMarshall.length, 0);
    }

    protected static Intent deserializeNotificationIntent(Context context, String src) {
        byte[] bArrDecode = Base64.decode(src, 0);
        Bundle bundle = new Bundle();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
        bundle.readFromParcel(parcelObtain);
        Intent intent = new Intent(context, (Class<?>) UnityNotificationManager.class);
        intent.putExtras(bundle);
        return intent;
    }

    protected static Class<?> getOpenAppActivity(Context context, boolean fallbackToDefault) {
        ApplicationInfo applicationInfo;
        Class<?> cls = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle.containsKey("custom_notification_android_activity")) {
            try {
                cls = Class.forName(bundle.getString("custom_notification_android_activity"));
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null && fallbackToDefault) {
            Log.w("UnityNotifications", "No custom_notification_android_activity found, attempting to find app activity class");
            try {
                return Class.forName("com.unity3d.player.UnityPlayerActivity");
            } catch (ClassNotFoundException unused2) {
                Log.w("UnityNotifications", String.format("Attempting to find : %s, failed!", "com.unity3d.player.UnityPlayerActivity"));
                String str = String.format("%s.UnityPlayerActivity", context.getPackageName());
                try {
                    return Class.forName(str);
                } catch (ClassNotFoundException unused3) {
                    Log.w("UnityNotifications", String.format("Attempting to find class based on package name: %s, failed!", str));
                }
            }
        }
        return cls;
    }
}
