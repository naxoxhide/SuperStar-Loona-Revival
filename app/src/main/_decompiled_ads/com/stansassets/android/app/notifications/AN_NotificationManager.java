package com.stansassets.android.app.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.stansassets.core.interfaces.AN_CallbackJsonHandler;
import com.stansassets.core.utility.AN_Logger;
import com.stansassets.core.utility.AN_UnityBridge;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AN_NotificationManager {
    private static AN_CallbackJsonHandler m_notificationClick;
    private static AN_CallbackJsonHandler m_notificationReceived;

    public static String GetLastOpenNotification() {
        return AN_NotificationLaunchActivity.lastOpenedRequest != null ? AN_UnityBridge.toJson(AN_NotificationLaunchActivity.lastOpenedRequest) : "";
    }

    public static void CancelAll() {
        NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancelAll();
        } else {
            AN_Logger.LogError("The NotificationManager is null");
        }
    }

    public static void Cancel(int i) {
        NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(i);
        } else {
            AN_Logger.LogError("The NotificationManager is null");
        }
    }

    public static void Schedule(String str) {
        AN_NotificationRequest aN_NotificationRequest = (AN_NotificationRequest) AN_UnityBridge.fromJson(str, AN_NotificationRequest.class);
        aN_NotificationRequest.m_trigger.Schedule(aN_NotificationRequest);
    }

    public static void Unschedule(int i) {
        AN_AlarmNotificationTrigger.Cancel(i);
    }

    public static void Subscribe(AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        m_notificationClick = aN_CallbackJsonHandler;
    }

    public static void SubscribeToNotificationReceived(AN_CallbackJsonHandler aN_CallbackJsonHandler) {
        m_notificationReceived = aN_CallbackJsonHandler;
    }

    public static void CreateNotificationChannel(String str) {
        NotificationChannel notificationChannelToNotificationChannel = ((AN_NotificationChannel) AN_UnityBridge.fromJson(str, AN_NotificationChannel.class)).ToNotificationChannel();
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannelToNotificationChannel);
            } else {
                AN_Logger.LogError("The NotificationManager is null");
            }
        }
    }

    public static String GetNotificationChannels() {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
        if (notificationManager != null) {
            List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
            if (notificationChannels == null || notificationChannels.size() <= 0) {
                return "";
            }
            AN_NotificationChannelsList aN_NotificationChannelsList = new AN_NotificationChannelsList();
            Iterator<NotificationChannel> it = notificationChannels.iterator();
            while (it.hasNext()) {
                aN_NotificationChannelsList.Add(it.next());
            }
            return AN_UnityBridge.toJson(aN_NotificationChannelsList);
        }
        AN_Logger.LogError("The NotificationManager is null");
        return "";
    }

    public static String GetNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
        if (notificationManager != null) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            return notificationChannel != null ? AN_UnityBridge.toJson(new AN_NotificationChannel(notificationChannel)) : "";
        }
        AN_Logger.LogError("The NotificationManager is null");
        return "";
    }

    public static void DeleteNotificationChannel(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) AN_UnityBridge.currentActivity.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.deleteNotificationChannel(str);
            } else {
                AN_Logger.LogError("The NotificationManager is null");
            }
        }
    }

    public static void notify(int i, Notification notification, Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(i, notification);
        } else {
            AN_Logger.LogError("The NotificationManager is null");
        }
    }

    public static void onNotificationClick(AN_NotificationRequest aN_NotificationRequest) {
        AN_CallbackJsonHandler aN_CallbackJsonHandler = m_notificationClick;
        if (aN_CallbackJsonHandler != null) {
            AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_NotificationRequest);
        }
    }

    public static void onNotificationReceived(AN_NotificationRequest aN_NotificationRequest) {
        AN_CallbackJsonHandler aN_CallbackJsonHandler = m_notificationReceived;
        if (aN_CallbackJsonHandler != null) {
            AN_UnityBridge.sendCallback(aN_CallbackJsonHandler, aN_NotificationRequest);
        }
    }
}
