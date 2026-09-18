package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1254Sa extends FrameLayout implements InterfaceC1092Lu {
    public String A00;
    public final InterfaceC1091Lt A01;
    public final C1157Oh A02;

    public C1254Sa(YA ya, InterfaceC1091Lt interfaceC1091Lt, C1157Oh c1157Oh, String str) {
        super(ya);
        this.A02 = c1157Oh;
        this.A01 = interfaceC1091Lt;
        this.A00 = str;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void A9C(Intent intent, Bundle bundle, C5J c5j) {
        C1157Oh.A0B().incrementAndGet();
        this.A02.A0V();
        LV.A0J(this.A02.A0O());
        addView(this.A02.A0O(), new FrameLayout.LayoutParams(-1, -1));
        this.A01.A3Q(this, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACJ(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACj(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void AEt(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public String getCurrentClientToken() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void onDestroy() {
        this.A02.A0U();
        if (this.A02.A0N() != null) {
            this.A02.A0N().ABT();
        }
        C1157Oh.A0B().decrementAndGet();
    }

    public void setListener(InterfaceC1091Lt interfaceC1091Lt) {
    }
}
