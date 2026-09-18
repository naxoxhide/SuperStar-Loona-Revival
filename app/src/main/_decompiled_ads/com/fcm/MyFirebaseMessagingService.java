package com.dalcomsoft.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.PowerManager;
import android.text.Html;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFCMService";
    private static final String drawableFolderName = "drawable";
    private static final String largeIconName = "notification_icon_large";
    private static final String smallIconName = "notification_icon_small";

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage != null) {
            try {
                if (remoteMessage.getData() != null && remoteMessage.getData().size() != 0 && remoteMessage.getData().containsKey("id") && remoteMessage.getData().containsKey("style") && remoteMessage.getData().containsKey("title") && remoteMessage.getData().containsKey("body")) {
                    int i = Integer.parseInt(remoteMessage.getData().get("id"));
                    int i2 = Integer.parseInt(remoteMessage.getData().get("style"));
                    String str = remoteMessage.getData().get("title");
                    String str2 = remoteMessage.getData().get("body");
                    String str3 = remoteMessage.getData().containsKey("image") ? remoteMessage.getData().get("image") : "";
                    Log.d(TAG, "FCM id: " + i);
                    Log.d(TAG, "FCM style: " + i2);
                    Log.d(TAG, "FCM title: " + str);
                    Log.d(TAG, "FCM body: " + str2);
                    Log.d(TAG, "FCM image: " + str3);
                    if (remoteMessage.getData().size() > 0) {
                        SendNotification(i, i2, str, str2, str3);
                    } else {
                        Log.d(TAG, "onMessageReceived Data is empty.");
                    }
                }
            } catch (Exception e) {
                Log.d(TAG, "FCM onMessageReceived Exception: " + e.getMessage());
            }
        }
    }

    public Bitmap getBitmapFromURL(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x01e3 A[ORIG_RETURN, RETURN] */
    public void SendNotification(int i, int i2, String str, String str2, String str3) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("dalcom_channel_1", "common", 4);
            notificationChannel.setDescription("Common Channel");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.setVibrationPattern(new long[]{1000, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        launchIntentForPackage.putExtra("notificationId", i);
        PendingIntent activity = PendingIntent.getActivity(this, 0, launchIntentForPackage, 67108864);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "dalcom_channel_1");
        try {
            try {
                if (i2 == 0) {
                    builder.setContentTitle(Html.fromHtml(str)).setContentText(Html.fromHtml(str2)).setSmallIcon(getResources().getIdentifier(smallIconName, drawableFolderName, getPackageName())).setDefaults(1).setVibrate(new long[]{1000, 1000}).setLights(-16776961, 3000, 3000).setAutoCancel(true).setContentIntent(activity);
                } else if (i2 == 1) {
                    builder.setContentTitle(Html.fromHtml(str)).setContentText(Html.fromHtml(str2)).setSmallIcon(getResources().getIdentifier(smallIconName, drawableFolderName, getPackageName())).setDefaults(1).setVibrate(new long[]{1000, 1000}).setLights(-16776961, 3000, 3000).setAutoCancel(true).setLargeIcon(BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(largeIconName, drawableFolderName, getPackageName()))).setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(Html.fromHtml(str)).bigText(Html.fromHtml(str2))).setContentIntent(activity);
                } else {
                    if (i2 == 2) {
                        builder.setContentTitle(Html.fromHtml(str)).setContentText(Html.fromHtml(str2)).setSmallIcon(getResources().getIdentifier(smallIconName, drawableFolderName, getPackageName())).setDefaults(1).setVibrate(new long[]{1000, 1000}).setLights(-16776961, 3000, 3000).setAutoCancel(true).setLargeIcon(BitmapFactory.decodeResource(getResources(), getResources().getIdentifier(largeIconName, drawableFolderName, getPackageName()))).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(str3)).setBigContentTitle(Html.fromHtml(str)).setSummaryText(Html.fromHtml(str2))).setContentIntent(activity);
                    }
                    wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "AppName:TAG");
                    wakeLockNewWakeLock.acquire();
                    ((NotificationManager) getSystemService("notification")).notify(i, builder.build());
                    if (wakeLockNewWakeLock == null) {
                        return;
                    }
                }
            } catch (Exception unused) {
                Log.d(TAG, "mBuilder Setting Exception.");
            }
            ((NotificationManager) getSystemService("notification")).notify(i, builder.build());
            if (wakeLockNewWakeLock == null) {
                return;
            }
        } catch (Exception e) {
            Log.d(TAG, "SendNotification Error : " + e);
            if (wakeLockNewWakeLock == null) {
                return;
            }
        } finally {
            if (wakeLockNewWakeLock != null) {
                wakeLockNewWakeLock.release();
            }
        }
        wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(268435466, "AppName:TAG");
        wakeLockNewWakeLock.acquire();
    }
}
