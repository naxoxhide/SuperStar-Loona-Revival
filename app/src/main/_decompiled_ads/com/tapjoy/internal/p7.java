package com.tapjoy.internal;

import com.tapjoy.TJActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class p7 implements Runnable {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJActivity f2798b;

    public p7(TJActivity tJActivity, boolean z) {
        this.f2798b = tJActivity;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            this.f2798b.d.setVisibility(0);
        } else {
            this.f2798b.d.setVisibility(4);
        }
    }
}
