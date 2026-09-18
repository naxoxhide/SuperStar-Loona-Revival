package com.mbridge.msdk.dycreator.bus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
final class HandlerPoster extends Handler {
    private final PendingPostQueue a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1999b;
    private final EventBus c;
    private boolean d;

    HandlerPoster(EventBus eventBus, Looper looper, int i) {
        super(looper);
        this.c = eventBus;
        this.f1999b = i;
        this.a = new PendingPostQueue();
    }

    final void a(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            this.a.a(pendingPostA);
            if (!this.d) {
                this.d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                PendingPost pendingPostA = this.a.a();
                if (pendingPostA == null) {
                    synchronized (this) {
                        pendingPostA = this.a.a();
                        if (pendingPostA == null) {
                            this.d = false;
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.a(pendingPostA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f1999b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.d = true;
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }
}
