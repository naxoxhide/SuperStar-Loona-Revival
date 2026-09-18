package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
final class BackgroundPoster implements Runnable {
    private final PendingPostQueue a = new PendingPostQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1997b;
    private final EventBus c;

    BackgroundPoster(EventBus eventBus) {
        this.c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost pendingPostA = PendingPost.a(subscription, obj);
        synchronized (this) {
            this.a.a(pendingPostA);
            if (!this.f1997b) {
                this.f1997b = true;
                EventBus.a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    PendingPost pendingPostA = this.a.a(1000);
                    if (pendingPostA == null) {
                        synchronized (this) {
                            pendingPostA = this.a.a();
                            if (pendingPostA == null) {
                                this.f1997b = false;
                                this.f1997b = false;
                                return;
                            }
                        }
                    }
                    this.c.a(pendingPostA);
                } catch (InterruptedException e) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    this.f1997b = false;
                    return;
                }
            } catch (Throwable th) {
                this.f1997b = false;
                throw th;
            }
        }
    }
}
