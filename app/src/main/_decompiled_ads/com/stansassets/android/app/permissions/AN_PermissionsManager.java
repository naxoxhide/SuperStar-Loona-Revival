package com.stansassets.android.app.permissions;

import android.os.Build;
import com.stansassets.core.interfaces.AN_ActivityCreateCallback;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.interfaces.AN_RequestPermissionsResult;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_PermissionsManager {
    public static int CheckSelfPermission(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AN_UnityBridge.currentActivity.checkSelfPermission(str);
        }
        return 0;
    }

    public static boolean ShouldShowRequestPermissionRationale(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AN_UnityBridge.currentActivity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void RequestPermissions(String str, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        final AN_PermissionsRequest aN_PermissionsRequest = (AN_PermissionsRequest) AN_UnityBridge.fromJson(str, AN_PermissionsRequest.class);
        AN_PermissionsProxyActivity.Create(new AN_ActivityCreateCallback<AN_PermissionsProxyActivity>() { // from class: com.stansassets.android.app.permissions.AN_PermissionsManager.1
            @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
            public void OnCreate(final AN_PermissionsProxyActivity aN_PermissionsProxyActivity) {
                aN_PermissionsProxyActivity.AddRequestPermissionsResultListner(new AN_RequestPermissionsResult() { // from class: com.stansassets.android.app.permissions.AN_PermissionsManager.1.1
                    @Override // com.stansassets.core.interfaces.AN_RequestPermissionsResult
                    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                        AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_PermissionsRequestResult(strArr, iArr));
                        aN_PermissionsProxyActivity.finish();
                    }
                });
                String[] strArr = (String[]) aN_PermissionsRequest.m_permissions.toArray(new String[0]);
                if (Build.VERSION.SDK_INT >= 23) {
                    aN_PermissionsProxyActivity.requestPermissions(strArr, 200);
                }
            }
        });
    }
}
