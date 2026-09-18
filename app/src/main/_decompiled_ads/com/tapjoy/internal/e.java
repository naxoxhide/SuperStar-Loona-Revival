package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final e d = new e();
    public Application a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f2747b;
    public final HashSet c = new HashSet();

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        e eVar = d;
        Context applicationContext = context.getApplicationContext();
        if (eVar.a == null) {
            try {
                if (applicationContext instanceof Application) {
                    eVar.a = (Application) applicationContext;
                } else {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    TapjoyUtil.runOnMainThread(new c(eVar, countDownLatch));
                    countDownLatch.await();
                }
            } catch (Exception e) {
                TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
            }
            if (eVar.a == null) {
                return;
            }
        }
        synchronized (eVar) {
            if (eVar.f2747b == null) {
                Activity activityA = t.a();
                if (activityA != null) {
                    eVar.c.add(activityA.getClass().getName() + "@" + System.identityHashCode(activityA));
                }
                d dVar = new d(eVar.c);
                eVar.f2747b = dVar;
                eVar.a.registerActivityLifecycleCallbacks(dVar);
                v1 v1Var = v1.m;
                if (v1Var.b() && v1Var.d()) {
                    q.a(null);
                }
            }
        }
    }

    public static void a() {
        e eVar = d;
        if (eVar.a == null) {
            return;
        }
        synchronized (eVar) {
            d dVar = eVar.f2747b;
            if (dVar != null) {
                eVar.a.unregisterActivityLifecycleCallbacks(dVar);
                eVar.f2747b = null;
            }
        }
    }
}
