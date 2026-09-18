package com.stansassets.android.app.notifications;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class AN_NotificationLaunchActivity extends Activity {
    public static AN_NotificationRequest lastOpenedRequest;

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        if (intent != null) {
            AN_NotificationRequest requestFromIntent = AN_AlarmNotificationTriggerReceiver.getRequestFromIntent(intent);
            if (requestFromIntent == null) {
                return;
            }
            lastOpenedRequest = requestFromIntent;
            ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(requestFromIntent.m_identifier);
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            }
            AN_NotificationManager.onNotificationClick(requestFromIntent);
        }
        finish();
    }
}
