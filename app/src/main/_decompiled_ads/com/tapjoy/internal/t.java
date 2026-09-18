package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t {
    public static Application a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2813b;
    public static final va c = new va();
    public static final Set d = Collections.synchronizedSet(new ua(new WeakHashMap()));
    public static final va e = new va();

    public static Activity a() {
        WeakReference weakReference = c.a;
        Activity activity = (Activity) (weakReference != null ? weakReference.get() : null);
        if (activity != null) {
            return activity;
        }
        Set set = d;
        synchronized (set) {
            if (set.iterator().hasNext()) {
                return (Activity) set.iterator().next();
            }
            return null;
        }
    }
}
