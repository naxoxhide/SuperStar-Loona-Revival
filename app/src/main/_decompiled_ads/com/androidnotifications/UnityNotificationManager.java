package com.unity.androidnotifications;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.BadParcelableException;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdError;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class UnityNotificationManager extends BroadcastReceiver {
    protected static final String NOTIFICATION_CHANNELS_SHARED_PREFS = "UNITY_NOTIFICATIONS";
    protected static final String NOTIFICATION_CHANNELS_SHARED_PREFS_KEY = "ChannelIDs";
    protected static final String NOTIFICATION_IDS_SHARED_PREFS = "UNITY_STORED_NOTIFICATION_IDS";
    protected static final String NOTIFICATION_IDS_SHARED_PREFS_KEY = "UNITY_NOTIFICATION_IDS";
    protected static Method mCanScheduleExactAlarms;
    protected static NotificationCallback mNotificationCallback;
    protected static UnityNotificationManager mUnityNotificationManager;
    protected Activity mActivity;
    public Context mContext;
    protected Class mOpenActivity;
    protected boolean mRescheduleOnRestart;

    public UnityNotificationManager() {
        this.mContext = null;
        this.mActivity = null;
        this.mOpenActivity = null;
        this.mRescheduleOnRestart = false;
    }

    public UnityNotificationManager(Context context, Activity activity) {
        this.mContext = null;
        this.mActivity = null;
        this.mOpenActivity = null;
        this.mRescheduleOnRestart = false;
        this.mContext = context;
        this.mActivity = activity;
        try {
            Boolean boolValueOf = Boolean.valueOf(activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData.getBoolean("reschedule_notifications_on_restart"));
            if (boolValueOf.booleanValue()) {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) UnityNotificationRestartOnBootReceiver.class), 1, 1);
            }
            this.mRescheduleOnRestart = boolValueOf.booleanValue();
            Class<?> openAppActivity = UnityNotificationUtilities.getOpenAppActivity(context, false);
            this.mOpenActivity = openAppActivity;
            if (openAppActivity == null) {
                this.mOpenActivity = activity.getClass();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("UnityNotifications", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e2) {
            Log.e("UnityNotifications", "Failed to load meta-data, NullPointer: " + e2.getMessage());
        }
    }

    public static UnityNotificationManager getNotificationManagerImpl(Context context) {
        return getNotificationManagerImpl(context, (Activity) context);
    }

    public static UnityNotificationManager getNotificationManagerImpl(Context context, Activity activity) {
        UnityNotificationManager unityNotificationManager = mUnityNotificationManager;
        if (unityNotificationManager != null) {
            return unityNotificationManager;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            mUnityNotificationManager = new UnityNotificationManagerOreo(context, activity);
        } else {
            mUnityNotificationManager = new UnityNotificationManager(context, activity);
        }
        return mUnityNotificationManager;
    }

    public NotificationManager getNotificationManager() {
        return getNotificationManager(this.mContext);
    }

    public static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }

    public void setNotificationCallback(NotificationCallback notificationCallback) {
        mNotificationCallback = notificationCallback;
    }

    public void registerNotificationChannel(String id, String name, int importance, String description, boolean enableLights, boolean enableVibration, boolean canBypassDnd, boolean canShowBadge, long[] vibrationPattern, int lockscreenVisibility) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet()));
        hashSet.add(id);
        SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
        editorClear.putStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, hashSet);
        editorClear.apply();
        SharedPreferences.Editor editorEdit = this.mContext.getSharedPreferences(getSharedPrefsNameByChannelId(id), 0).edit();
        editorEdit.putString("title", name);
        editorEdit.putInt("importance", importance);
        editorEdit.putString("description", description);
        editorEdit.putBoolean("enableLights", enableLights);
        editorEdit.putBoolean("enableVibration", enableVibration);
        editorEdit.putBoolean("canBypassDnd", canBypassDnd);
        editorEdit.putBoolean("canShowBadge", canShowBadge);
        editorEdit.putString("vibrationPattern", Arrays.toString(vibrationPattern));
        editorEdit.putInt("lockscreenVisibility", lockscreenVisibility);
        editorEdit.apply();
    }

    protected static String getSharedPrefsNameByChannelId(String id) {
        return String.format("unity_notification_channel_%s", id);
    }

    protected static NotificationChannelWrapper getNotificationChannel(Context context, String id) {
        if (Build.VERSION.SDK_INT >= 26) {
            return UnityNotificationManagerOreo.getOreoNotificationChannel(context, id);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(getSharedPrefsNameByChannelId(id), 0);
        NotificationChannelWrapper notificationChannelWrapper = new NotificationChannelWrapper();
        notificationChannelWrapper.id = id;
        notificationChannelWrapper.name = sharedPreferences.getString("title", AdError.UNDEFINED_DOMAIN);
        notificationChannelWrapper.importance = sharedPreferences.getInt("importance", 3);
        notificationChannelWrapper.description = sharedPreferences.getString("description", AdError.UNDEFINED_DOMAIN);
        notificationChannelWrapper.enableLights = sharedPreferences.getBoolean("enableLights", false);
        notificationChannelWrapper.enableVibration = sharedPreferences.getBoolean("enableVibration", false);
        notificationChannelWrapper.canBypassDnd = sharedPreferences.getBoolean("canBypassDnd", false);
        notificationChannelWrapper.canShowBadge = sharedPreferences.getBoolean("canShowBadge", false);
        notificationChannelWrapper.lockscreenVisibility = sharedPreferences.getInt("lockscreenVisibility", 1);
        String[] strArrSplit = sharedPreferences.getString("vibrationPattern", "[]").split(",");
        int length = strArrSplit.length;
        long[] jArr = new long[length];
        if (length > 1) {
            for (int i = 0; i < strArrSplit.length; i++) {
                try {
                    jArr[i] = Long.parseLong(strArrSplit[i]);
                } catch (NumberFormatException unused) {
                    jArr[i] = 1;
                }
            }
        }
        if (length <= 1) {
            jArr = null;
        }
        notificationChannelWrapper.vibrationPattern = jArr;
        return notificationChannelWrapper;
    }

    protected NotificationChannelWrapper getNotificationChannel(String id) {
        return getNotificationChannel(this.mContext, id);
    }

    public void deleteNotificationChannel(String id) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet()));
        if (hashSet.contains(id)) {
            hashSet.remove(id);
            SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
            editorClear.putStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, hashSet);
            editorClear.apply();
            this.mContext.getSharedPreferences(getSharedPrefsNameByChannelId(id), 0).edit().clear().apply();
        }
    }

    public Object[] getNotificationChannels() {
        Set<String> stringSet = this.mContext.getSharedPreferences(NOTIFICATION_CHANNELS_SHARED_PREFS, 0).getStringSet(NOTIFICATION_CHANNELS_SHARED_PREFS_KEY, new HashSet());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            arrayList.add(getNotificationChannel(it.next()));
        }
        return arrayList.toArray();
    }

    public void scheduleNotificationIntent(Intent data_intent_source) {
        Intent intentDeserializeNotificationIntent = UnityNotificationUtilities.deserializeNotificationIntent(this.mContext, UnityNotificationUtilities.serializeNotificationIntent(data_intent_source));
        int intExtra = intentDeserializeNotificationIntent.getIntExtra("id", 0);
        Intent intentBuildNotificationIntent = buildNotificationIntent(this.mContext, intentDeserializeNotificationIntent, getActivityPendingIntent(this.mContext, intExtra, buildOpenAppIntent(intentDeserializeNotificationIntent, this.mContext, this.mOpenActivity), 0));
        if (intentBuildNotificationIntent != null) {
            if (this.mRescheduleOnRestart) {
                saveNotificationIntent(this.mContext, intentDeserializeNotificationIntent);
            }
            scheduleNotificationIntentAlarm(this.mContext, intentBuildNotificationIntent, getBroadcastPendingIntent(this.mContext, intExtra, intentBuildNotificationIntent, 134217728));
        }
    }

    protected static Intent buildOpenAppIntent(Intent data_intent, Context context, Class className) {
        Intent intent = new Intent(context, (Class<?>) className);
        intent.addFlags(805306368);
        intent.putExtras(data_intent);
        return intent;
    }

    protected static Intent buildNotificationIntent(Context context, Intent intent, PendingIntent pendingIntent) {
        Intent intent2 = (Intent) intent.clone();
        intent2.putExtra("tapIntent", pendingIntent);
        SharedPreferences sharedPreferences = context.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0);
        HashSet<String> hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet()));
        HashSet hashSet2 = new HashSet();
        for (String str : hashSet) {
            if (getBroadcastPendingIntent(context, Integer.valueOf(str).intValue(), intent, 536870912) != null) {
                hashSet2.add(str);
            }
        }
        if (Build.MANUFACTURER.equals("samsung") && hashSet2.size() >= 499) {
            Log.w("UnityNotifications", "Attempting to schedule more than 500 notifications. There is a limit of 500 concurrently scheduled Alarms on Samsung devices either wait for the currently scheduled ones to be triggered or cancel them if you wish to schedule additional notifications.");
            intent2 = null;
        } else {
            hashSet2.add(Integer.toString(intent2.getIntExtra("id", 0)));
            intent2.setFlags(268468224);
        }
        SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
        editorClear.putStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, hashSet2);
        editorClear.apply();
        return intent2;
    }

    public static PendingIntent getActivityPendingIntent(Context context, int id, Intent intent, int flags) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getActivity(context, id, intent, flags | 67108864);
        }
        return PendingIntent.getActivity(context, id, intent, flags);
    }

    public static PendingIntent getBroadcastPendingIntent(Context context, int id, Intent intent, int flags) {
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getBroadcast(context, id, intent, flags | 67108864);
        }
        return PendingIntent.getBroadcast(context, id, intent, flags);
    }

    protected static void saveNotificationIntent(Context context, Intent intent) {
        String string = Integer.toString(intent.getIntExtra("id", 0));
        SharedPreferences.Editor editorClear = context.getSharedPreferences(getSharedPrefsNameByNotificationId(string), 0).edit().clear();
        editorClear.putString("data", UnityNotificationUtilities.serializeNotificationIntent(intent));
        editorClear.apply();
        SharedPreferences sharedPreferences = context.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet()));
        hashSet.add(string);
        SharedPreferences.Editor editorClear2 = sharedPreferences.edit().clear();
        editorClear2.putStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, hashSet);
        editorClear2.apply();
        loadNotificationIntents(context);
    }

    protected static String getSharedPrefsNameByNotificationId(String id) {
        return String.format("u_notification_data_%s", id);
    }

    protected static List<Intent> loadNotificationIntents(Context context) {
        HashSet<String> hashSet = new HashSet(context.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0).getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet()));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet2 = new HashSet();
        for (String str : hashSet) {
            String string = context.getSharedPreferences(getSharedPrefsNameByNotificationId(str), 0).getString("data", "");
            if (string.length() > 1) {
                arrayList.add(UnityNotificationUtilities.deserializeNotificationIntent(context, string));
            } else {
                hashSet2.add(str);
            }
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            deleteExpiredNotificationIntent(context, (String) it.next());
        }
        return arrayList;
    }

    private static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        try {
            if (mCanScheduleExactAlarms == null) {
                mCanScheduleExactAlarms = AlarmManager.class.getMethod("canScheduleExactAlarms", new Class[0]);
            }
            return ((Boolean) mCanScheduleExactAlarms.invoke(alarmManager, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            Log.e("UnityNotifications", "No AlarmManager.canScheduleExactAlarms() on Android 31+ device, should not happen", e);
            return false;
        } catch (Exception e2) {
            Log.e("UnityNotifications", "AlarmManager.canScheduleExactAlarms() threw", e2);
            return false;
        }
    }

    protected static void scheduleNotificationIntentAlarm(Context context, Intent intent, PendingIntent broadcast) {
        long longExtra = intent.getLongExtra("repeatInterval", 0L);
        long longExtra2 = intent.getLongExtra("fireTime", 0L);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (longExtra <= 0) {
            if (Build.VERSION.SDK_INT >= 23 && canScheduleExactAlarms(alarmManager)) {
                alarmManager.setExactAndAllowWhileIdle(0, longExtra2, broadcast);
                return;
            } else {
                alarmManager.set(0, longExtra2, broadcast);
                return;
            }
        }
        alarmManager.setInexactRepeating(0, longExtra2, longExtra, broadcast);
    }

    public int checkNotificationStatus(int id) {
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        for (StatusBarNotification statusBarNotification : getNotificationManager().getActiveNotifications()) {
            if (id == statusBarNotification.getId()) {
                return 2;
            }
        }
        return checkIfPendingNotificationIsRegistered(id) ? 1 : 0;
    }

    public boolean checkIfPendingNotificationIsRegistered(int id) {
        return getBroadcastPendingIntent(this.mContext, id, new Intent(this.mActivity, (Class<?>) UnityNotificationManager.class), 536870912) != null;
    }

    public void cancelAllPendingNotificationIntents() {
        for (int i : getScheduledNotificationIDs()) {
            cancelPendingNotificationIntent(i);
        }
    }

    protected int[] getScheduledNotificationIDs() {
        int i = 0;
        Set<String> stringSet = this.mContext.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0).getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet());
        int[] iArr = new int[stringSet.size()];
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            iArr[i] = Integer.valueOf(it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public void cancelPendingNotificationIntent(int id) {
        cancelPendingNotificationIntent(this.mContext, id);
        if (this.mRescheduleOnRestart) {
            deleteExpiredNotificationIntent(this.mContext, Integer.toString(id));
        }
    }

    protected static void cancelPendingNotificationIntent(Context context, int id) {
        PendingIntent broadcastPendingIntent = getBroadcastPendingIntent(context, id, new Intent(context, (Class<?>) UnityNotificationManager.class), 536870912);
        if (broadcastPendingIntent != null) {
            if (context != null) {
                ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(broadcastPendingIntent);
            }
            broadcastPendingIntent.cancel();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet()));
        if (hashSet.contains(Integer.toString(id))) {
            hashSet.remove(Integer.toString(id));
            SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
            editorClear.putStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, hashSet);
            editorClear.apply();
        }
    }

    protected static void deleteExpiredNotificationIntent(Context context, String id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NOTIFICATION_IDS_SHARED_PREFS, 0);
        HashSet hashSet = new HashSet(sharedPreferences.getStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, new HashSet()));
        cancelPendingNotificationIntent(context, Integer.valueOf(id).intValue());
        hashSet.remove(id);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet(NOTIFICATION_IDS_SHARED_PREFS_KEY, hashSet);
        editorEdit.apply();
        context.getSharedPreferences(getSharedPrefsNameByNotificationId(id), 0).edit().clear().apply();
    }

    public void cancelDisplayedNotification(int id) {
        getNotificationManager().cancel(id);
    }

    public void cancelAllNotifications() {
        getNotificationManager().cancelAll();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.hasExtra("channelID") && intent.hasExtra("smallIconStr")) {
                sendNotification(context, intent);
            }
        } catch (BadParcelableException e) {
            Log.w("UnityNotifications", e.toString());
        }
    }

    protected static void sendNotification(Context context, Intent intent) {
        notify(context, intent.getIntExtra("id", -1), buildNotification(context, intent).build(), intent);
    }

    protected static Notification.Builder buildNotification(Context context, Intent intent) {
        Notification.Builder builder;
        int intExtra;
        String stringExtra = intent.getStringExtra("channelID");
        if (Build.VERSION.SDK_INT < 26) {
            builder = new Notification.Builder(context);
        } else {
            builder = new Notification.Builder(context, stringExtra);
        }
        int iFindResourceIdInContextByName = UnityNotificationUtilities.findResourceIdInContextByName(context, intent.getStringExtra("largeIconStr"));
        if (iFindResourceIdInContextByName != 0) {
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), iFindResourceIdInContextByName));
        }
        int iFindResourceIdInContextByName2 = UnityNotificationUtilities.findResourceIdInContextByName(context, intent.getStringExtra("smallIconStr"));
        if (iFindResourceIdInContextByName2 == 0) {
            iFindResourceIdInContextByName2 = context.getApplicationInfo().icon;
        }
        builder.setSmallIcon(iFindResourceIdInContextByName2);
        String stringExtra2 = intent.getStringExtra("textTitle");
        String stringExtra3 = intent.getStringExtra("textContent");
        builder.setContentTitle(stringExtra2).setContentText(stringExtra3).setContentIntent((PendingIntent) intent.getParcelableExtra("tapIntent")).setAutoCancel(intent.getBooleanExtra("autoCancel", true));
        int i = 0;
        int intExtra2 = intent.getIntExtra("number", 0);
        if (intExtra2 >= 0) {
            builder.setNumber(intExtra2);
        }
        if (intent.getIntExtra("style", 0) == 2) {
            builder.setStyle(new Notification.BigTextStyle().bigText(stringExtra3));
        }
        builder.setWhen(intent.getLongExtra("timestamp", -1L));
        if (Build.VERSION.SDK_INT >= 20) {
            String stringExtra4 = intent.getStringExtra("group");
            if (stringExtra4 != null && stringExtra4.length() > 0) {
                builder.setGroup(stringExtra4);
            }
            boolean booleanExtra = intent.getBooleanExtra("groupSummary", false);
            if (booleanExtra) {
                builder.setGroupSummary(booleanExtra);
            }
            String stringExtra5 = intent.getStringExtra("sortKey");
            if (stringExtra5 != null && stringExtra5.length() > 0) {
                builder.setSortKey(stringExtra5);
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            builder.setShowWhen(intent.getBooleanExtra("showTimestamp", false));
        }
        if (Build.VERSION.SDK_INT >= 21 && (intExtra = intent.getIntExtra("color", 0)) != 0) {
            builder.setColor(intExtra);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setColorized(true);
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            builder.setUsesChronometer(intent.getBooleanExtra("usesChronometer", false));
        }
        if (Build.VERSION.SDK_INT < 26) {
            NotificationChannelWrapper notificationChannel = getNotificationChannel(context, stringExtra);
            if (notificationChannel.vibrationPattern != null && notificationChannel.vibrationPattern.length > 0) {
                builder.setDefaults(5);
                builder.setVibrate(notificationChannel.vibrationPattern);
            } else {
                builder.setDefaults(-1);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                builder.setVisibility(notificationChannel.lockscreenVisibility);
            }
            int i2 = notificationChannel.importance;
            if (i2 == 0) {
                i = -2;
            } else if (i2 == 2) {
                i = -1;
            } else if (i2 != 3 && i2 == 4) {
                i = 2;
            }
            builder.setPriority(i);
        } else {
            builder.setGroupAlertBehavior(intent.getIntExtra("groupAlertBehaviour", 0));
        }
        return builder;
    }

    protected static void notify(Context context, int id, Notification notification, Intent intent) {
        getNotificationManager(context).notify(id, notification);
        try {
            mNotificationCallback.onSentNotification(intent);
        } catch (RuntimeException unused) {
            Log.w("UnityNotifications", "Can not invoke OnNotificationReceived event when the app is not running!");
        }
        if (intent.getLongExtra("repeatInterval", 0L) > 0) {
            return;
        }
        deleteExpiredNotificationIntent(context, Integer.toString(id));
    }
}
