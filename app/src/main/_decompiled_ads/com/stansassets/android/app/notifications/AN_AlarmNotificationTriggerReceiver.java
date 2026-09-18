package com.stansassets.android.app.notifications;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_AlarmNotificationTriggerReceiver extends BroadcastReceiver {
    public static AN_NotificationRequest getRequestFromIntent(Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras == null || (string = extras.getString(AN_AlarmNotificationTrigger.NOTIFICATION_REQUEST)) == null || string.isEmpty()) {
            return null;
        }
        return (AN_NotificationRequest) AN_UnityBridge.fromJson(string, AN_NotificationRequest.class);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AN_Logger.LogError("AN_AlarmNotificationTriggerReceiver::onReceive");
        if (context == null || intent == null) {
            AN_Logger.LogError("AN_AlarmNotificationTriggerReceiver::onReceive context or intent is null, event ignored");
            return;
        }
        try {
            if (intent.getAction() != null) {
                String action = intent.getAction();
                byte b2 = -1;
                int iHashCode = action.hashCode();
                if (iHashCode != -2078032080) {
                    if (iHashCode == 798292259 && action.equals("android.intent.action.BOOT_COMPLETED")) {
                        b2 = 0;
                    }
                } else if (action.equals(AN_AlarmNotificationService.RESTART_SERVICE_ACTION)) {
                    b2 = 1;
                }
                if (b2 == 0 || b2 == 1) {
                    AN_AlarmNotificationService.StartService();
                    return;
                } else {
                    AN_Logger.LogError("AN_AlarmNotificationTriggerReceiver:: Action name is not recognized.");
                    return;
                }
            }
        } catch (Exception e) {
            AN_Logger.LogError("Wasn't able to start AN_AlarmNotificationService after device boot: " + e.getMessage());
        }
        AN_NotificationRequest requestFromIntent = getRequestFromIntent(intent);
        AN_NotificationRequest requestFromIntent2 = getRequestFromIntent(intent);
        if (requestFromIntent == null) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) AN_NotificationLaunchActivity.class);
        intent2.setFlags(603979776);
        intent2.putExtra(AN_AlarmNotificationTrigger.NOTIFICATION_REQUEST, AN_UnityBridge.toJson(requestFromIntent));
        requestFromIntent.m_content.setContentIntent(PendingIntent.getActivity(context, 500, intent2, 134217728));
        ((PowerManager) context.getSystemService("power")).newWakeLock(268435457, context.getClass().getName()).acquire(1000L);
        if (IsInAppActiveAndInForeground()) {
            AN_NotificationManager.onNotificationReceived(requestFromIntent2);
        } else if (requestFromIntent.m_content.build(context) != null) {
            AN_NotificationManager.notify(requestFromIntent.m_identifier, requestFromIntent.m_content.build(context), context);
        }
    }

    private boolean IsInAppActiveAndInForeground() {
        if (AN_UnityBridge.currentActivity == null) {
            return false;
        }
        try {
            return AN_UnityBridge.currentActivity.getWindow().getDecorView().getRootView().isShown();
        } catch (Exception e) {
            e.printStackTrace();
            AN_Logger.LogError(e.getMessage());
            return false;
        }
    }
}
