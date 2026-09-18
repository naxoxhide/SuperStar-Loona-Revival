package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e7 {
    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CountDownLatch f2750b = new CountDownLatch(1);
    public static final d7 c = new d7();
    public static final CountDownLatch d = new CountDownLatch(1);

    public static void a() {
        a.execute(c);
    }
}
