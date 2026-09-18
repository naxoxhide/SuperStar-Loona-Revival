package com.dalcom.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class RuntimePermissions {
    public static void OpenSettings(Context context) {
        Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), (String) null);
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uriFromParts);
        context.startActivity(intent);
    }

    public static String CheckPermission(String[] strArr, Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return "1";
        }
        String str = "";
        for (String str2 : strArr) {
            str = str + (context.checkSelfPermission(str2) == 0 ? '1' : '0');
        }
        return str;
    }

    public static void RequestPermission(String[] strArr, Context context, RuntimePermissionsReceiver runtimePermissionsReceiver, String str) {
        String strCheckPermission = CheckPermission(strArr, context);
        Log.d("UNITY", "RequestPermission: " + strCheckPermission);
        if (Build.VERSION.SDK_INT < 23) {
            runtimePermissionsReceiver.OnPermissionResult(strCheckPermission);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray(RuntimePermissionsFragment.PERMISSIONS, strArr);
        RuntimePermissionsFragment runtimePermissionsFragment = new RuntimePermissionsFragment(runtimePermissionsReceiver);
        runtimePermissionsFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, runtimePermissionsFragment).commit();
    }
}
