package com.facebook.ads.redexgen.X;

import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1454Zy extends AbstractRunnableC1043Jv {
    public final /* synthetic */ Message A00;
    public final /* synthetic */ AbstractC1452Zw A01;

    public C1454Zy(AbstractC1452Zw abstractC1452Zw, Message message) {
        this.A01 = abstractC1452Zw;
        this.A00 = message;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC1043Jv
    public final void A01() {
        this.A01.A04.A8M(this.A00);
    }
}
