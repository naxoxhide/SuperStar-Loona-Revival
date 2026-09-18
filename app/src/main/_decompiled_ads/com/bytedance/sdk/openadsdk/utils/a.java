package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.ApmHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ActivityLifecycleListener.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static boolean h = false;
    public static long i;
    public static long j;
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RunnableC0254a f821b = new RunnableC0254a();
    private final c c = new c(this);
    private final b d = new b();
    private int e = 0;
    private HandlerThread f = null;
    private Handler g = null;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityLifecycleListener.java */
    static class RunnableC0254a implements Runnable {

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActivityLifecycleListener.java */
        class C0255a extends b.b.a.a.k.g {
            C0255a(RunnableC0254a runnableC0254a, String str) {
                super(str);
            }

            @Override // java.lang.Runnable
            public void run() {
                ApmHelper.reportPvFromBackGround();
            }
        }

        RunnableC0254a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.k.e.f().execute(new C0255a(this, "reportPvFromBackGround"));
        }
    }

    /* JADX INFO: compiled from: ActivityLifecycleListener.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApmHelper.isIsInit()) {
                Handler handlerA = com.bytedance.sdk.openadsdk.core.l.a();
                Message messageObtain = Message.obtain(handlerA, a.this.f821b);
                messageObtain.what = 1001;
                handlerA.sendMessageDelayed(messageObtain, 30000L);
            }
        }
    }

    /* JADX INFO: compiled from: ActivityLifecycleListener.java */
    class c implements Runnable {
        c(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.l.a().removeMessages(1001);
            if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.h0.a.b();
        }
    }

    /* JADX INFO: compiled from: ActivityLifecycleListener.java */
    public class d implements Runnable {
        private long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f822b;
        private boolean c;

        public d(long j, long j2, boolean z) {
            this.a = 0L;
            this.f822b = 0L;
            this.c = false;
            this.a = j;
            this.f822b = j2;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                com.bytedance.sdk.openadsdk.l.b.a().a(this.a / 1000, this.f822b / 1000);
            }
            a.this.c();
        }
    }

    public a() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.d.p.a.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        int i2 = this.e - 1;
        this.e = i2;
        if (i2 < 0) {
            this.e = 0;
        }
        if (ApmHelper.isIsInit()) {
            a(this.d);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(this.c);
        if (h) {
            return;
        }
        i = System.currentTimeMillis();
        h = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.e++;
        this.a.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.e <= 0) {
            this.a.set(true);
        }
        if (b()) {
            h = false;
            com.bytedance.sdk.openadsdk.core.l.f640b.set(false);
            j = System.currentTimeMillis();
        }
        a(new d(i, j, b()));
    }

    private void a() {
        HandlerThread handlerThread = new HandlerThread("lifecycle", 10);
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper());
    }

    public boolean b() {
        return this.a.get();
    }

    private void a(Runnable runnable) {
        if (!this.f.isAlive()) {
            a();
        }
        this.g.post(runnable);
    }
}
