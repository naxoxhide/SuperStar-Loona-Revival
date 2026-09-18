package com.tapjoy.internal;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class ha implements Observer {
    public final /* synthetic */ CountDownLatch a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ja f2766b;

    public ha(ja jaVar, CountDownLatch countDownLatch) {
        this.f2766b = jaVar;
        this.a = countDownLatch;
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        k3.f2775b.deleteObserver(this);
        this.f2766b.a = Boolean.TRUE.equals(obj);
        this.a.countDown();
    }
}
