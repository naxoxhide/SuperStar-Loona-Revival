package com.facebook.ads.redexgen.X;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1250Rw implements C5H {
    public final /* synthetic */ C5J A00;
    public final /* synthetic */ C7I A01;

    public C1250Rw(C7I c7i, C5J c5j) {
        this.A01 = c7i;
        this.A00 = c5j;
    }

    @Override // com.facebook.ads.redexgen.X.C5H
    public final boolean A8k() {
        if (!this.A01.A0Z()) {
            if (this.A01.A0a()) {
                return true;
            }
            return this.A01.A0b();
        }
        this.A01.A0Y(this.A00);
        return true;
    }
}
