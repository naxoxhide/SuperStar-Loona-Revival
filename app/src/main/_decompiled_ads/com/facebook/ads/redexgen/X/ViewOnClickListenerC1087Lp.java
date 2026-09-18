package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1087Lp implements View.OnClickListener {
    public final /* synthetic */ C1X A00;
    public final /* synthetic */ C1012In A01;
    public final /* synthetic */ C1088Lq A02;
    public final /* synthetic */ InterfaceC1091Lt A03;
    public final /* synthetic */ String A04;

    public ViewOnClickListenerC1087Lp(C1088Lq c1088Lq, C1012In c1012In, InterfaceC1091Lt interfaceC1091Lt, String str, C1X c1x) {
        this.A02 = c1088Lq;
        this.A01 = c1012In;
        this.A03 = interfaceC1091Lt;
        this.A04 = str;
        this.A00 = c1x;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (K0.A02(this)) {
            return;
        }
        try {
            this.A01.A04(EnumC1011Im.A0A, null);
            if (this.A02.A02.A0O(this.A02.A03.A01(), true)) {
                this.A03.A98(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                KZ.A0L(new KZ(), this.A02.A03, C1050Kc.A00(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            K0.A00(th, this);
        }
    }
}
