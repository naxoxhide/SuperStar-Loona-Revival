package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {
    public final TimeUnit a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1348b;
    public Handler c;
    public boolean d;
    public b e;
    public long f;

    public static class a extends Handler {
        public final WeakReference<u0> a;

        public a(u0 u0Var) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(u0Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            u0 u0Var = this.a.get();
            if (u0Var == null || message.what != 1932593528 || u0Var.d) {
                return;
            }
            u0Var.a(message.getWhen());
        }
    }

    public interface b {
        void a(u0 u0Var);
    }

    public u0(TimeUnit timeUnit, long j) {
        this.d = false;
        this.f = 0L;
        this.f1348b = j;
        this.a = timeUnit;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }

    public void a() {
        this.d = true;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(1932593528);
        }
    }

    public void b() {
        this.d = false;
        a(SystemClock.uptimeMillis());
    }

    public void c() {
        a aVar = new a(this);
        this.c = aVar;
        this.d = false;
        aVar.sendEmptyMessage(1932593528);
    }

    public final void a(long j) {
        long jUptimeMillis = this.f + (SystemClock.uptimeMillis() - j) + 50;
        this.f = jUptimeMillis;
        if (this.e != null && jUptimeMillis > this.a.toMillis(this.f1348b)) {
            this.e.a(this);
            return;
        }
        Handler handler = this.c;
        if (handler == null || this.e == null) {
            return;
        }
        handler.removeMessages(1932593528);
        this.c.sendEmptyMessageDelayed(1932593528, 50L);
    }

    public u0(TimeUnit timeUnit, long j, long j2) {
        this.d = false;
        this.f = 0L;
        this.f1348b = j;
        this.a = timeUnit;
        this.f = j2;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }
}
