package com.tapjoy.internal;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompatJellybean;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a5 {
    /* JADX WARN: Code duplicated, block: B:25:0x004a A[Catch: NoSuchFieldException -> 0x0057, IllegalAccessException -> 0x0060, all -> 0x006c, TRY_LEAVE, TryCatch #3 {IllegalAccessException -> 0x0060, NoSuchFieldException -> 0x0057, blocks: (B:15:0x0018, B:17:0x001c, B:19:0x0030, B:22:0x003b, B:23:0x0040, B:25:0x004a), top: B:41:0x0018, outer: #2 }] */
    public static Bundle a(Notification notification) {
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        Bundle bundle2 = null;
        if (i < 16) {
            return null;
        }
        synchronized (c5.a) {
            if (!c5.c) {
                try {
                    if (c5.f2736b == null) {
                        Field declaredField = Notification.class.getDeclaredField("extras");
                        if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                            declaredField.setAccessible(true);
                            c5.f2736b = declaredField;
                            bundle = (Bundle) c5.f2736b.get(notification);
                            if (bundle == null) {
                                bundle = new Bundle();
                                c5.f2736b.set(notification, bundle);
                            }
                            bundle2 = bundle;
                        } else {
                            Log.e(NotificationCompatJellybean.TAG, "Notification.extras field is not of type Bundle");
                            c5.c = true;
                        }
                    } else {
                        bundle = (Bundle) c5.f2736b.get(notification);
                        if (bundle == null) {
                            bundle = new Bundle();
                            c5.f2736b.set(notification, bundle);
                        }
                        bundle2 = bundle;
                    }
                } catch (IllegalAccessException e) {
                    Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e);
                    c5.c = true;
                } catch (NoSuchFieldException e2) {
                    Log.e(NotificationCompatJellybean.TAG, "Unable to access notification extras", e2);
                    c5.c = true;
                }
            }
        }
        return bundle2;
    }
}
