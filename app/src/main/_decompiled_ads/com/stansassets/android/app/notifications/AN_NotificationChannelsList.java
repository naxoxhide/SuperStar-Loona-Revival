package com.stansassets.android.app.notifications;

import android.app.NotificationChannel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AN_NotificationChannelsList {
    private ArrayList<AN_NotificationChannel> m_channels = new ArrayList<>();

    public void Add(NotificationChannel notificationChannel) {
        this.m_channels.add(new AN_NotificationChannel(notificationChannel));
    }
}
