package com.unity.androidnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class UnityNotificationRestartOnBootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent received_intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(received_intent.getAction())) {
            for (Intent intent : UnityNotificationManager.loadNotificationIntents(context)) {
                long longExtra = intent.getLongExtra("fireTime", 0L);
                Date time = Calendar.getInstance().getTime();
                Date date = new Date(longExtra);
                int intExtra = intent.getIntExtra("id", -1);
                boolean z = intent.getLongExtra("repeatInterval", 0L) > 0;
                if (date.after(time) || z) {
                    Intent intentBuildNotificationIntent = UnityNotificationManager.buildNotificationIntent(context, intent, UnityNotificationManager.getActivityPendingIntent(context, intExtra, UnityNotificationManager.buildOpenAppIntent(intent, context, UnityNotificationUtilities.getOpenAppActivity(context, true)), 0));
                    UnityNotificationManager.scheduleNotificationIntentAlarm(context, intentBuildNotificationIntent, UnityNotificationManager.getBroadcastPendingIntent(context, intExtra, intentBuildNotificationIntent, 134217728));
                } else {
                    UnityNotificationManager.deleteExpiredNotificationIntent(context, Integer.toString(intExtra));
                }
            }
        }
    }
}
