package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PE extends FrameLayout {
    public static final int A08 = (int) (C1066Ku.A02 * 16.0f);
    public AE A00;
    public C1176Pa A01;
    public AnonymousClass76 A02;
    public C1040Jr A03;
    public C07266j A04;
    public C6E A05;
    public final YA A06;
    public final C1012In A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A04(InterfaceC1004If interfaceC1004If, String str, Map<String, String> map) {
        A02();
        this.A02 = new AnonymousClass76(this.A06, interfaceC1004If, this.A00, str, map);
        if (IP.A1Y(this.A06)) {
            this.A01 = new C1176Pa(this.A06, interfaceC1004If, this.A00, str, map);
        } else {
            this.A01 = null;
        }
    }

    public PE(YA ya, C1012In c1012In) {
        super(ya);
        this.A07 = c1012In;
        this.A06 = ya;
        setUpView(ya);
    }

    public final void A01() {
        this.A00.A0e(true, 10);
    }

    public final void A02() {
        C1176Pa c1176Pa = this.A01;
        if (c1176Pa != null) {
            c1176Pa.A0A();
            this.A01 = null;
        }
        AnonymousClass76 anonymousClass76 = this.A02;
        if (anonymousClass76 != null) {
            anonymousClass76.A0g();
            this.A02 = null;
        }
    }

    public final void A03(AbstractC07628a abstractC07628a) {
        this.A00.getEventBus().A05(abstractC07628a);
    }

    public final void A05(EnumC1185Pj enumC1185Pj) {
        this.A00.A0b(enumC1185Pj, 13);
    }

    public final boolean A06() {
        return this.A00.A0k();
    }

    public RX getSimpleVideoView() {
        return this.A00;
    }

    public float getVolume() {
        return this.A00.getVolume();
    }

    public void setPlaceholderUrl(String str) {
        this.A04.setImage(str);
    }

    private void setUpPlugins(YA ya) {
        this.A00.A0X();
        C07266j c07266j = new C07266j(ya);
        this.A04 = c07266j;
        this.A00.A0c(c07266j);
        this.A03 = new C1040Jr(ya, this.A07);
        this.A00.A0c(new C07326r(ya));
        this.A00.A0c(this.A03);
        C6E c6e = new C6E(ya, true, this.A07);
        this.A05 = c6e;
        this.A00.A0c(c6e);
        this.A00.A0c(new C1042Ju(this.A05, EnumC1198Pw.A03, true, true));
        if (!this.A00.A0g() && !IP.A2H(ya)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i = A08;
        layoutParams.setMargins(i, i, i, i);
        this.A03.setLayoutParams(layoutParams);
        this.A00.addView(this.A03);
    }

    private void setUpVideo(YA ya) {
        AE ae = new AE(ya);
        this.A00 = ae;
        ae.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LV.A0K(this.A00);
        addView(this.A00);
        setOnClickListener(new PD(this));
    }

    private void setUpView(YA ya) {
        setUpVideo(ya);
        setUpPlugins(ya);
    }

    public void setVideoURI(String str) {
        this.A00.setVideoURI(str);
    }

    public void setVolume(float f) {
        this.A00.setVolume(f);
        this.A03.A09();
    }
}
