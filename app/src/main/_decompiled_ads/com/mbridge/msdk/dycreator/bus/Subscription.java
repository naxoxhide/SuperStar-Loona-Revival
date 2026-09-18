package com.mbridge.msdk.dycreator.bus;

/* JADX INFO: loaded from: classes4.dex */
final class Subscription {
    final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SubscriberMethod f2004b;

    Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.a = obj;
        this.f2004b = subscriberMethod;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.a == subscription.a && this.f2004b.equals(subscription.f2004b);
    }

    public final int hashCode() {
        return this.a.hashCode() + this.f2004b.d.hashCode();
    }
}
