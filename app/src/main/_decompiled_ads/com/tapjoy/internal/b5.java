package com.tapjoy.internal;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatExtras;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class b5 {
    public final Notification.Builder a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y4 f2732b;
    public final ArrayList c = new ArrayList();
    public final Bundle d = new Bundle();

    public b5(y4 y4Var) {
        ArrayList arrayList;
        this.f2732b = y4Var;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.a = new Notification.Builder(y4Var.a, y4Var.j);
        } else {
            this.a = new Notification.Builder(y4Var.a);
        }
        Notification notification = y4Var.k;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(y4Var.c).setContentText(y4Var.d).setContentInfo(null).setContentIntent(y4Var.e).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(y4Var.f).setNumber(0).setProgress(0, 0, false);
        if (i < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i >= 16) {
            this.a.setSubText(null).setUsesChronometer(false).setPriority(y4Var.g);
            Iterator it = y4Var.f2833b.iterator();
            while (it.hasNext()) {
                g6.a(it.next());
                a();
            }
            int i2 = Build.VERSION.SDK_INT;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 19) {
            this.a.setShowWhen(y4Var.h);
            if (i3 < 21 && (arrayList = y4Var.l) != null && !arrayList.isEmpty()) {
                Bundle bundle = this.d;
                ArrayList arrayList2 = y4Var.l;
                bundle.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (i3 >= 20) {
            this.a.setLocalOnly(false).setGroup(null).setGroupSummary(false).setSortKey(null);
        }
        if (i3 >= 21) {
            this.a.setCategory(null).setColor(0).setVisibility(0).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
            Iterator it2 = y4Var.l.iterator();
            while (it2.hasNext()) {
                this.a.addPerson((String) it2.next());
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            this.a.setExtras(null).setRemoteInputHistory(null);
        }
        if (i4 >= 26) {
            this.a.setBadgeIconType(0).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
            if (TextUtils.isEmpty(y4Var.j)) {
                return;
            }
            this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    public static void a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            throw null;
        }
        if (i < 16) {
            return;
        }
        Object obj = c5.a;
        throw null;
    }

    public final Notification b() {
        Notification notification;
        z4 z4Var = this.f2732b.i;
        if (z4Var != null) {
            x4 x4Var = (x4) z4Var;
            if (Build.VERSION.SDK_INT >= 16) {
                new Notification.BigTextStyle(this.a).setBigContentTitle(x4Var.f2838b).bigText(x4Var.c);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 || i >= 24) {
            notification = this.a.build();
        } else if (i < 21 && i < 20) {
            int i2 = 0;
            SparseArray<? extends Parcelable> sparseArray = null;
            if (i >= 19) {
                ArrayList arrayList = this.c;
                Object obj = c5.a;
                int size = arrayList.size();
                while (i2 < size) {
                    Bundle bundle = (Bundle) arrayList.get(i2);
                    if (bundle != null) {
                        if (sparseArray == null) {
                            sparseArray = new SparseArray<>();
                        }
                        sparseArray.put(i2, bundle);
                    }
                    i2++;
                }
                if (sparseArray != null) {
                    this.d.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, sparseArray);
                }
                this.a.setExtras(this.d);
                notification = this.a.build();
            } else if (i >= 16) {
                notification = this.a.build();
                Bundle bundleA = a5.a(notification);
                Bundle bundle2 = new Bundle(this.d);
                for (String str : this.d.keySet()) {
                    if (bundleA.containsKey(str)) {
                        bundle2.remove(str);
                    }
                }
                bundleA.putAll(bundle2);
                ArrayList arrayList2 = this.c;
                Object obj2 = c5.a;
                int size2 = arrayList2.size();
                while (i2 < size2) {
                    Bundle bundle3 = (Bundle) arrayList2.get(i2);
                    if (bundle3 != null) {
                        if (sparseArray == null) {
                            sparseArray = new SparseArray<>();
                        }
                        sparseArray.put(i2, bundle3);
                    }
                    i2++;
                }
                if (sparseArray != null) {
                    a5.a(notification).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, sparseArray);
                }
            } else {
                notification = this.a.getNotification();
            }
        } else {
            this.a.setExtras(this.d);
            notification = this.a.build();
        }
        this.f2732b.getClass();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21 && z4Var != null) {
            this.f2732b.i.getClass();
        }
        if (i3 >= 16 && z4Var != null) {
            a5.a(notification);
        }
        return notification;
    }
}
