package com.unity.androidnotifications;

import android.app.Activity;
import android.app.NotificationChannel;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class UnityNotificationManagerOreo extends UnityNotificationManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public UnityNotificationManagerOreo(Context context, Activity activity) {
        super(context, activity);
    }

    @Override // com.unity.androidnotifications.UnityNotificationManager
    public void registerNotificationChannel(String id, String name, int importance, String description, boolean enableLights, boolean enableVibration, boolean canBypassDnd, boolean canShowBadge, long[] vibrationPattern, int lockscreenVisibility) {
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        notificationChannel.setDescription(description);
        notificationChannel.enableLights(enableLights);
        notificationChannel.enableVibration(enableVibration);
        notificationChannel.setBypassDnd(canBypassDnd);
        notificationChannel.setShowBadge(canShowBadge);
        notificationChannel.setVibrationPattern(vibrationPattern);
        notificationChannel.setLockscreenVisibility(lockscreenVisibility);
        getNotificationManager().createNotificationChannel(notificationChannel);
    }

    protected static NotificationChannelWrapper getOreoNotificationChannel(Context context, String id) {
        new ArrayList();
        for (NotificationChannel notificationChannel : getNotificationManager(context).getNotificationChannels()) {
            if (notificationChannel.getId() == id) {
                return notificationChannelToWrapper(notificationChannel);
            }
        }
        return null;
    }

    protected static NotificationChannelWrapper notificationChannelToWrapper(NotificationChannel channel) {
        NotificationChannelWrapper notificationChannelWrapper = new NotificationChannelWrapper();
        notificationChannelWrapper.id = channel.getId();
        notificationChannelWrapper.name = channel.getName().toString();
        notificationChannelWrapper.importance = channel.getImportance();
        notificationChannelWrapper.description = channel.getDescription();
        notificationChannelWrapper.enableLights = channel.shouldShowLights();
        notificationChannelWrapper.enableVibration = channel.shouldVibrate();
        notificationChannelWrapper.canBypassDnd = channel.canBypassDnd();
        notificationChannelWrapper.canShowBadge = channel.canShowBadge();
        notificationChannelWrapper.vibrationPattern = channel.getVibrationPattern();
        notificationChannelWrapper.lockscreenVisibility = channel.getLockscreenVisibility();
        return notificationChannelWrapper;
    }

    @Override // com.unity.androidnotifications.UnityNotificationManager
    public void deleteNotificationChannel(String id) {
        getNotificationManager().deleteNotificationChannel(id);
    }

    @Override // com.unity.androidnotifications.UnityNotificationManager
    public NotificationChannelWrapper[] getNotificationChannels() {
        ArrayList arrayList = new ArrayList();
        Iterator<NotificationChannel> it = getNotificationManager().getNotificationChannels().iterator();
        while (it.hasNext()) {
            arrayList.add(notificationChannelToWrapper(it.next()));
        }
        return (NotificationChannelWrapper[]) arrayList.toArray(new NotificationChannelWrapper[arrayList.size()]);
    }
}
