package com.stansassets.android.app.notifications;

import android.app.NotificationChannel;
import android.net.Uri;
import android.os.Build;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_NotificationChannel {
    private String m_Description;
    private String m_Id;
    private int m_Importance;
    private String m_Name;
    private boolean m_ShowBadge;
    private String m_Sound;

    public AN_NotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.m_Id = notificationChannel.getId();
            this.m_Name = notificationChannel.getName().toString();
            this.m_Description = notificationChannel.getDescription();
            this.m_Importance = notificationChannel.getImportance();
            this.m_ShowBadge = notificationChannel.canShowBadge();
            Uri sound = notificationChannel.getSound();
            if (sound != null) {
                this.m_Sound = sound.toString();
            } else {
                this.m_Sound = "";
            }
        }
    }

    public NotificationChannel ToNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.m_Id, this.m_Name, this.m_Importance);
        notificationChannel.setDescription(this.m_Description);
        notificationChannel.setShowBadge(this.m_ShowBadge);
        Uri soundUri = AN_NotificationBuilder.getSoundUri(AN_UnityBridge.currentActivity, this.m_Sound);
        if (soundUri != null) {
            notificationChannel.setSound(soundUri, null);
        }
        return notificationChannel;
    }
}
