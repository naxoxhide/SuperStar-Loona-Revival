package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class Z4 implements InterfaceC06924x {
    public final /* synthetic */ AbstractC06724c A00;

    public Z4(AbstractC06724c abstractC06724c) {
        this.A00 = abstractC06724c;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06924x
    public final View A6H(int i) {
        return this.A00.A0t(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06924x
    public final int A6J(View view) {
        return this.A00.A0n(view) + ((C06734d) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06924x
    public final int A6K(View view) {
        return this.A00.A0k(view) - ((C06734d) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06924x
    public final int A7S() {
        return this.A00.A0h() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06924x
    public final int A7T() {
        return this.A00.A0e();
    }
}
