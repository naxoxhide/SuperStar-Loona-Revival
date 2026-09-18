package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class w2 {
    public static Handler a;

    public static Handler a() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            return looperMyLooper == Looper.getMainLooper() ? b() : new Handler(looperMyLooper);
        }
        return null;
    }

    public static synchronized Handler b() {
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        return a;
    }

    public static v2 a(Handler handler) {
        return new v2(handler);
    }
}
