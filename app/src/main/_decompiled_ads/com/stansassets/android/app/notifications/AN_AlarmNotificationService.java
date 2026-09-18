package com.stansassets.android.app.notifications;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AN_AlarmNotificationService extends Service {
    public static final String RESTART_SERVICE_ACTION = "restart_service_action";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        AN_Logger.Log("AN_AlarmNotificationService Started");
        return super.onStartCommand(intent, i, i2);
    }

    public static void StartService() {
        AN_Logger.Log("AN_AlarmNotificationService::StartService");
        Activity activity = AN_UnityBridge.currentActivity;
        Intent intent = new Intent(activity, (Class<?>) AN_AlarmNotificationService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            activity.startService(intent);
        } else {
            activity.startService(intent);
        }
        AN_Logger.Log("AN_AlarmNotificationService:: service is started");
    }

    public static void Restart() {
        AN_Logger.Log("Restart called");
        Intent intent = new Intent();
        intent.setAction(RESTART_SERVICE_ACTION);
        intent.setClass(AN_UnityBridge.currentActivity, AN_AlarmNotificationTriggerReceiver.class);
        AN_UnityBridge.currentActivity.sendBroadcast(intent);
        AN_Logger.Log("Restart Broadcast sent");
    }

    private static boolean isServiceRunning(Class<?> cls, Context context) {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
        while (it.hasNext()) {
            if (cls.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
