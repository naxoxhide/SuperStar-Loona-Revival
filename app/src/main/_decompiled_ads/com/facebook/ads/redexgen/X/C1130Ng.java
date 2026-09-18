package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.RewardData;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ng, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1130Ng extends FrameLayout {
    public static String[] A07 = {"Lu0oG19N", "JNY", "Ev6F9eDhg42RHlCeRuJfEtiFO07AluFn", "qSbaO4FE34QcNqD1YWxCxyT8wr5s9kWw", "hZddA1hSD7Y", "v9TnLSaOxYneacolptRVdRHaZQ0ab06L", "iyW9tyIIQvF7WQz3LOxNHXxa074IcWbN", "vzh"};
    public AbstractC1090Ls A00;
    public final AbstractC1484aS A01;
    public final YA A02;
    public final InterfaceC1091Lt A03;
    public final InterfaceC1129Nf A04;
    public final RX A05;
    public final View[] A06;

    public C1130Ng(C1149Nz c1149Nz, AbstractC1484aS abstractC1484aS, RX rx, C1026Jb c1026Jb, NR nr, InterfaceC1091Lt interfaceC1091Lt, InterfaceC1129Nf interfaceC1129Nf) {
        this(c1149Nz, abstractC1484aS, rx, interfaceC1091Lt, interfaceC1129Nf, c1026Jb, nr);
    }

    public C1130Ng(C1149Nz c1149Nz, AbstractC1484aS abstractC1484aS, RX rx, InterfaceC1091Lt interfaceC1091Lt, InterfaceC1129Nf interfaceC1129Nf, View... viewArr) {
        this(c1149Nz.A05(), c1149Nz.A08(), abstractC1484aS, rx, interfaceC1091Lt, interfaceC1129Nf, viewArr);
    }

    public C1130Ng(YA ya, AbstractC1090Ls abstractC1090Ls, AbstractC1484aS abstractC1484aS, RX rx, InterfaceC1091Lt interfaceC1091Lt, InterfaceC1129Nf interfaceC1129Nf, View... viewArr) {
        super(ya);
        this.A02 = ya;
        this.A00 = abstractC1090Ls;
        this.A01 = abstractC1484aS;
        this.A06 = viewArr;
        this.A03 = interfaceC1091Lt;
        this.A05 = rx;
        this.A04 = interfaceC1129Nf;
        A03();
    }

    private void A03() {
        String title;
        RewardData rewardDataA0J = this.A01.A0J();
        if (rewardDataA0J == null) {
            title = this.A01.A0y().A05();
        } else {
            title = this.A01.A0y().A06(rewardDataA0J.getCurrency(), rewardDataA0J.getQuantity());
        }
        M3 m3 = new M3(this.A02, -1, -16777216, title, null, this.A01.A0y().A04(), this.A01.A0y().A03(), C1076Le.A01(EnumC1075Ld.REWARD_ICON));
        m3.A02.setOnClickListener(new ViewOnClickListenerC1127Nd(this));
        m3.A01.setOnClickListener(new ViewOnClickListenerC1128Ne(this));
        addView(m3, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        RX rx = this.A05;
        if (rx != null) {
            rx.A0a(EnumC1180Pe.A07);
        }
        this.A04.AAS();
        if (!this.A01.A0v().A0O()) {
            this.A01.A14(this.A03);
        }
    }

    public final void A07(ViewGroup viewGroup) {
        RX rx = this.A05;
        if (rx != null && !rx.A0j()) {
            this.A05.A0f(false, false, 11);
            LV.A0N(this.A05, 4);
        }
        AbstractC1090Ls abstractC1090Ls = this.A00;
        String[] strArr = A07;
        if (strArr[7].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A07[0] = "vGH3jzSu";
        if (abstractC1090Ls != null) {
            LV.A0H(abstractC1090Ls);
        }
        for (View view : this.A06) {
            view.clearAnimation();
            LV.A0N(view, 4);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        viewGroup.addView(this, layoutParams);
        this.A04.AC0();
    }
}
