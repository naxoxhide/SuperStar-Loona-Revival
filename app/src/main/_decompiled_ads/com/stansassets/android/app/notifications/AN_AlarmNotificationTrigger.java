package com.stansassets.android.app.notifications;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public class AN_AlarmNotificationTrigger implements AN_iNotificationTrigger {
    public static final String NOTIFICATION_REQUEST = "NOTIFICATION_JSON";
    private boolean m_repeating;
    private int m_seconds;

    @Override // com.stansassets.android.app.notifications.AN_iNotificationTrigger
    public void Schedule(AN_NotificationRequest aN_NotificationRequest) {
        Activity activity = AN_UnityBridge.currentActivity;
        AN_AlarmNotificationService.StartService();
        Intent intent = new Intent(activity, (Class<?>) AN_AlarmNotificationTriggerReceiver.class);
        intent.addFlags(32);
        AN_Logger.Log("Builder extra: " + AN_UnityBridge.toJson(aN_NotificationRequest));
        intent.putExtra(NOTIFICATION_REQUEST, AN_UnityBridge.toJson(aN_NotificationRequest));
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, this.m_seconds);
        PendingIntent broadcast = PendingIntent.getBroadcast(activity, aN_NotificationRequest.m_identifier, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (this.m_repeating) {
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), this.m_seconds * 1000, broadcast);
        } else {
            alarmManager.set(0, calendar.getTimeInMillis(), broadcast);
        }
    }

    public static void Cancel(int i) {
        ((AlarmManager) AN_UnityBridge.currentActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(AN_UnityBridge.currentActivity, i, new Intent(AN_UnityBridge.currentActivity, (Class<?>) AN_AlarmNotificationTriggerReceiver.class), 134217728));
    }
}
