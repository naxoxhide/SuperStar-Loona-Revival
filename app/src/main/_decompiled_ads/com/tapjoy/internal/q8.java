package com.tapjoy.internal;

import android.content.Intent;
import com.tapjoy.TJCorePlacement;

/* JADX INFO: loaded from: classes4.dex */
public final class q8 implements Runnable {
    public final /* synthetic */ Intent a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJCorePlacement f2804b;

    public q8(TJCorePlacement tJCorePlacement, Intent intent) {
        this.f2804b = tJCorePlacement;
        this.a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2804b.f2688b.startActivity(this.a);
    }
}
