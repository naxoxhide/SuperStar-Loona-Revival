package com.stansassets.android.content.pm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.stansassets.android.app.AN_Activity;
import com.stansassets.android.content.AN_Intent;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PackageManager {
    public static String QueryIntentActivities(String str, String str2, int i) {
        AN_Intent aN_Intent = (AN_Intent) AN_UnityBridge.fromJson(str2, AN_Intent.class);
        AN_Activity aN_Activity = (AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class);
        AN_PackageManagerResolveInfoResult aN_PackageManagerResolveInfoResult = new AN_PackageManagerResolveInfoResult();
        Iterator<ResolveInfo> it = aN_Activity.toActivity().getPackageManager().queryIntentActivities(aN_Intent.toIntent(), i).iterator();
        while (it.hasNext()) {
            aN_PackageManagerResolveInfoResult.Add(it.next());
        }
        return AN_UnityBridge.toJson(aN_PackageManagerResolveInfoResult);
    }

    public static String GetPackageInfo(String str, String str2, int i) {
        try {
            return AN_UnityBridge.toJson(new AN_PackageInfo(((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity().getPackageManager().getPackageInfo(str2, i)));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int GetLaunchIntentForPackage(String str, String str2) {
        Intent launchIntentForPackage = ((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity().getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage == null) {
            return 0;
        }
        return AN_HashStorage.add(launchIntentForPackage);
    }
}
