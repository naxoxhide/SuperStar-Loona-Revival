package com.dalcomsoft.fcm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import com.tapjoy.TJAdUnitConstants;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class LocalNotificationManager extends BroadcastReceiver {
    private static final String TAG = "NotificationManager";
    private static final String drawableFolderName = "drawable";
    private static final String largeIconName = "notification_icon_large";
    private static final String smallIconName = "notification_icon_small";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("message");
        String stringExtra3 = intent.getStringExtra(TJAdUnitConstants.String.BUNDLE);
        int intExtra = intent.getIntExtra("id", 0);
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
        TaskStackBuilder.create(context).addNextIntent(launchIntentForPackage);
        PendingIntent activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 67108864);
        Boolean bool = false;
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("dalcom_channel_2", NotificationCompat.CATEGORY_ALARM, 4);
            notificationChannel.setDescription("Alarm Channel");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.setVibrationPattern(new long[]{1000, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
            bool = true;
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "dalcom_channel_2");
        builder.setContentIntent(activity).setAutoCancel(true).setContentTitle(stringExtra).setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(Html.fromHtml(stringExtra)).bigText(Html.fromHtml(stringExtra2))).setContentText(stringExtra2);
        builder.setSmallIcon(context.getResources().getIdentifier(smallIconName, drawableFolderName, context.getPackageName()));
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(largeIconName, drawableFolderName, context.getPackageName())));
        builder.setSound(RingtoneManager.getDefaultUri(2));
        if (bool.booleanValue()) {
            builder.setVibrate(new long[]{1000, 1000});
        }
        if (bool.booleanValue()) {
            builder.setLights(-16776961, 3000, 3000);
        }
        notificationManager.notify(intExtra, builder.build());
    }

    public static void SetNotification(int i, long j, String str, String str2, String str3) {
        Activity activity = UnityPlayer.currentActivity;
        AlarmManager alarmManager = (AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(activity, (Class<?>) LocalNotificationManager.class);
        intent.putExtra("title", str);
        intent.putExtra("message", str2);
        intent.putExtra("id", i);
        intent.putExtra(TJAdUnitConstants.String.BUNDLE, str3);
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExact(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(activity, i, intent, 134217728));
        } else {
            alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(activity, i, intent, 134217728));
        }
        Log.d(TAG, "SetNotification Success - " + i);
    }

    public static void CancelPendingNotification(int i) {
        Activity activity = UnityPlayer.currentActivity;
        ((AlarmManager) activity.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(PendingIntent.getBroadcast(activity, i, new Intent(activity, (Class<?>) LocalNotificationManager.class), 67108864));
        Log.d(TAG, "CancelPendingNotification - " + i);
    }

    public static void ClearShowingNotifications() {
        ((NotificationManager) UnityPlayer.currentActivity.getSystemService("notification")).cancelAll();
    }
}
