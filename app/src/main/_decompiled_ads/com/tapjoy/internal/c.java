package com.tapjoy.internal;

import android.app.Application;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Runnable {
    public final /* synthetic */ CountDownLatch a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f2734b;

    public c(e eVar, CountDownLatch countDownLatch) {
        this.f2734b = eVar;
        this.a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                this.f2734b.a = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
            } catch (Exception e) {
                TapjoyLog.w("Tapjoy.ActivityTracker", Log.getStackTraceString(e));
            }
        } finally {
            this.a.countDown();
        }
    }
}
