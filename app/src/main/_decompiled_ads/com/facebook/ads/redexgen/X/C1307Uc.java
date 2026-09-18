package com.facebook.ads.redexgen.X;

import android.content.Context;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1307Uc implements InterfaceC1017Is {
    public final Context A00;

    public C1307Uc(Context context) {
        this.A00 = context;
    }

    public final void A01(boolean z, String str, String str2, String str3, long j) {
        ExecutorC1072La.A06.execute(new C1308Ud(this, str, z, str2, str3, j));
    }
}
