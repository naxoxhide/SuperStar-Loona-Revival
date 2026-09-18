package com.facebook.ads.redexgen.X;

import android.os.ConditionVariable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC0884Dn implements Runnable {
    public final /* synthetic */ ConditionVariable A00;

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A00.open();
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
