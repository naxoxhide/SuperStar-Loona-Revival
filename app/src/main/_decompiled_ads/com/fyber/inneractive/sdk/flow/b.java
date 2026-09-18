package com.fyber.inneractive.sdk.flow;

import android.os.Build;
import android.os.Handler;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.interfaces.a.b f916b;
    public final Runnable c = new a();
    public final Runnable d = new RunnableC0267b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IAlog.a("%s : ContentLoadTimeoutHandler Executing timeout task", IAlog.a(b.this));
            b.this.f916b.b();
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.b$b, reason: collision with other inner class name */
    public class RunnableC0267b implements Runnable {
        public RunnableC0267b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.fyber.inneractive.sdk.util.m.f1343b.post(b.this.c);
        }
    }

    public b(com.fyber.inneractive.sdk.interfaces.a.b bVar) {
        this.f916b = bVar;
    }

    public void a() {
        IAlog.a("%s : ContentLoadTimeoutHandler destroying timeout handler", IAlog.a(this));
        if (this.a != null) {
            b();
            if (Build.VERSION.SDK_INT >= 18) {
                this.a.getLooper().quitSafely();
            } else {
                this.a.getLooper().quit();
            }
            this.a = null;
        }
    }

    public void b() {
        IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a(this));
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacks(this.d);
        }
    }
}
