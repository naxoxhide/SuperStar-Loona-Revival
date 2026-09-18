package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: loaded from: classes4.dex */
class AsyncPoster implements Runnable {
    private final PendingPostQueue a = new PendingPostQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventBus f1996b;

    AsyncPoster(EventBus eventBus) {
        this.f1996b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.a.a(PendingPost.a(subscription, obj));
        EventBus.a.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        PendingPost pendingPostA = this.a.a();
        if (pendingPostA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f1996b.a(pendingPostA);
    }
}
