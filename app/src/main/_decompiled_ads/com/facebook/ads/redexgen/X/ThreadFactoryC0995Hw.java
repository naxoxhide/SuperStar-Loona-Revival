package com.facebook.ads.redexgen.X;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ThreadFactoryC0995Hw implements ThreadFactory {
    public final /* synthetic */ String A00;

    public ThreadFactoryC0995Hw(String str) {
        this.A00 = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.A00);
    }
}
