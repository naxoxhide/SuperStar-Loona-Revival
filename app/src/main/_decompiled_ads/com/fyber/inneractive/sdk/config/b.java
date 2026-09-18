package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u0;
import com.tapjoy.TapjoyConstants;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class b implements j.b {
    public u0 c;
    public final g0 d;
    public final u0.b f;
    public final AtomicBoolean a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f867b = false;
    public final Handler e = new Handler(Looper.getMainLooper(), new a());

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 123) {
                return false;
            }
            b bVar = b.this;
            if (bVar.a.compareAndSet(false, true)) {
                if (bVar.a.get() && bVar.c != null) {
                    IAlog.a("startCounting", new Object[0]);
                    bVar.c.c();
                }
                IAlog.a("Pause signal", new Object[0]);
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.b$b, reason: collision with other inner class name */
    public class C0258b implements Application.ActivityLifecycleCallbacks {
        public C0258b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (b.this.e.hasMessages(123) || b.this.a.get()) {
                return;
            }
            b.this.e.sendEmptyMessageDelayed(123, 3000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b.this.e.removeMessages(123);
            b bVar = b.this;
            if (bVar.a.compareAndSet(true, false)) {
                if (bVar.f867b) {
                    IAlog.a("onActivityResumed: restartSession", new Object[0]);
                    bVar.f867b = false;
                    g0 g0Var = bVar.d;
                    if (g0Var != null) {
                        com.fyber.inneractive.sdk.cache.session.d dVar = ((f0) g0Var).a;
                        if (dVar != null) {
                            dVar.a(dVar.a);
                            com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.cache.session.c(dVar, com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION, com.fyber.inneractive.sdk.cache.session.enums.b.NONE));
                        }
                        g0 g0Var2 = bVar.d;
                        ((f0) g0Var2).c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                        ((f0) bVar.d).f872b.clear();
                    }
                }
                u0 u0Var = bVar.c;
                if (u0Var != null) {
                    u0Var.d = false;
                    u0Var.f = 0L;
                    Handler handler = u0Var.c;
                    if (handler != null) {
                        handler.removeMessages(1932593528);
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public class c implements u0.b {
        public c() {
        }

        @Override // com.fyber.inneractive.sdk.util.u0.b
        public void a(u0 u0Var) {
            IAlog.a("onVisibleTimeReached: %s", Long.valueOf(System.currentTimeMillis()));
            b.this.f867b = true;
        }
    }

    public b(g0 g0Var) {
        C0258b c0258b = new C0258b();
        this.f = new c();
        this.d = g0Var;
        Application applicationA = com.fyber.inneractive.sdk.util.l.a();
        if (applicationA != null) {
            applicationA.registerActivityLifecycleCallbacks(c0258b);
        }
    }

    @Override // com.fyber.inneractive.sdk.config.j.b
    public void onGlobalConfigChanged(j jVar, i iVar) {
        u0 u0Var = this.c;
        if (u0Var != null) {
            u0Var.d = false;
            u0Var.f = 0L;
            Handler handler = u0Var.c;
            if (handler != null) {
                handler.removeMessages(1932593528);
            }
            u0 u0Var2 = new u0(TimeUnit.MINUTES, iVar.a(TapjoyConstants.TJC_SESSION_CURRENT_LENGTH, 30, 1), this.c.f);
            this.c = u0Var2;
            u0Var2.e = this.f;
        }
        jVar.c.remove(this);
    }
}
