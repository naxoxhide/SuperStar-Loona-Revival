package com.stansassets.android.app.notifications;

import android.app.Notification;
import com.stansassets.core.utility.AN_HashStorage;
import com.stansassets.core.utility.AN_UnityBridge;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Notification {
    private int m_hashCode;

    public Notification toNotification() {
        return (Notification) AN_HashStorage.get(this.m_hashCode);
    }

    public static Notification GetNotification(String str) {
        return ((AN_Notification) AN_UnityBridge.fromJson(str, AN_Notification.class)).toNotification();
    }
}
