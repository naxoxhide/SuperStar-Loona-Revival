package com.stansassets.android.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.stansassets.android.content.AN_Context;
import com.stansassets.android.content.AN_Intent;
import com.stansassets.core.interfaces.AN_ActivityCreateCallback;
import com.stansassets.core.interfaces.AN_ActivityResultCallback;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.interfaces.AN_iProxyActivity;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_ProxyActivity;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Activity extends AN_Context {
    private static HashMap<String, Activity> s_createdActivities = new HashMap<>();

    public static boolean StartActivity(String str, String str2) {
        try {
            final AN_Intent aN_Intent = (AN_Intent) AN_UnityBridge.fromJson(str2, AN_Intent.class);
            ((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity(new AN_ActivityCreateCallback<Activity>() { // from class: com.stansassets.android.app.AN_Activity.1
                @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
                public void OnCreate(Activity activity) {
                    activity.startActivity(aN_Intent.toIntent());
                }
            });
            return true;
        } catch (Exception e) {
            AN_Logger.Log(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean StartActivityForResult(String str, String str2, final AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        try {
            final AN_Intent aN_Intent = (AN_Intent) AN_UnityBridge.fromJson(str2, AN_Intent.class);
            ((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity(new AN_ActivityCreateCallback<Activity>() { // from class: com.stansassets.android.app.AN_Activity.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
                public void OnCreate(Activity activity) {
                    AN_Logger.Log("activity started");
                    if (activity instanceof AN_iProxyActivity) {
                        ((AN_iProxyActivity) activity).AddActivityResultListener(new AN_ActivityResultCallback() { // from class: com.stansassets.android.app.AN_Activity.2.1
                            @Override // com.stansassets.core.interfaces.AN_ActivityResultCallback
                            public void onActivityResult(int i, int i2, Intent intent) {
                                AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, new AN_ActivityResult(i2, intent));
                            }
                        });
                    }
                    activity.startActivityForResult(aN_Intent.toIntent(), 1);
                }
            });
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean Finish(String str) {
        try {
            AN_Activity aN_Activity = (AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class);
            Activity activity = aN_Activity.toActivity();
            if (Build.VERSION.SDK_INT < 17 || activity.isFinishing() || activity.isDestroyed()) {
                return true;
            }
            aN_Activity.toActivity().finish();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean MoveTaskToBack(String str, boolean z) {
        try {
            return ((AN_Activity) AN_UnityBridge.fromJson(str, AN_Activity.class)).toActivity().moveTaskToBack(z);
        } catch (Exception unused) {
            return false;
        }
    }

    public Activity toActivity() {
        if (s_createdActivities.containsKey(this.m_instanceId)) {
            return s_createdActivities.get(this.m_instanceId);
        }
        return AN_UnityBridge.currentActivity;
    }

    private void toActivity(final AN_ActivityCreateCallback<Activity> aN_ActivityCreateCallback) {
        if (s_createdActivities.containsKey(this.m_instanceId)) {
            aN_ActivityCreateCallback.OnCreate(s_createdActivities.get(this.m_instanceId));
            return;
        }
        int i = this.m_classId;
        if (i == 1) {
            aN_ActivityCreateCallback.OnCreate(AN_UnityBridge.currentActivity);
        } else if (i != 2) {
            return;
        }
        AN_ProxyActivity.Create(new AN_ActivityCreateCallback<AN_ProxyActivity>() { // from class: com.stansassets.android.app.AN_Activity.3
            @Override // com.stansassets.core.interfaces.AN_ActivityCreateCallback
            public void OnCreate(AN_ProxyActivity aN_ProxyActivity) {
                AN_Activity.s_createdActivities.put(AN_Activity.this.m_instanceId, aN_ProxyActivity);
                aN_ActivityCreateCallback.OnCreate(aN_ProxyActivity);
            }
        });
    }
}
