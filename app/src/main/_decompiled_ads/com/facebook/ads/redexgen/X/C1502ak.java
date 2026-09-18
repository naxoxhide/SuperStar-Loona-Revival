package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.widget.LinearLayout;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1502ak<NativeViewabilityLogger> implements InterfaceC05820o {
    public static byte[] A0G;
    public static String[] A0H = {"1VlIdrj3fRAASVh0IRQbA", "AKXoeI10d8PJONEXEmQHjWIEkAB2E", "HfXt1ktTFXNYFvURT1ePpe", "VNbNAjzqH3UXN3t9RrTP5z6I5Qa6gPQJ", "DeawL9PzUIlDumNdtXISYTaSpfy6P3Cj", "KNbO6MhxkLbBAZAqlm1H7U8Ouut8mEhI", "i536pd2CEb7n0lc", "TelURl5RBqiFivFSJRRvco6RCKborqoX"};
    public static final String A0I;
    public InterfaceC05900w A00;
    public C1490aY A01;
    public F6 A02;
    public C0896Dz A03;
    public InterfaceC1004If A04;
    public NE A06;
    public TA A07;
    public AnonymousClass95 A08;
    public AbstractC1202Qa A09;
    public C1203Qb A0A;
    public String A0C;
    public boolean A0D = false;
    public boolean A0E = false;
    public boolean A0F = false;
    public LN A05 = new LN();
    public Boolean A0B = false;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 19);
            if (A0H[2].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[3] = "viF0h1063r6cbXDqGfnWrC6qPBVBGzAv";
            strArr[7] = "3ywSXssJKLxMazlfVUMLvW6ymO505mlb";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0G = new byte[]{-28, -16, -18, -81, -25, -30, -28, -26, -29, -16, -16, -20, -81, -30, -27, -12, -81, -29, -30, -17, -17, -26, -13, -81, -28, -19, -22, -28, -20, -26, -27, -24, -39, -20, -24, -93, -36, -24, -31, -32, -68, -69, -83, 116, 127};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0E(C8G c8g, C06121s c06121s) {
        C1492aa c1492aaA00 = C1492aa.A00(this.A03, c06121s.A03());
        this.A0C = c1492aaA00.A6N();
        if (C05790k.A06(this.A03, c1492aaA00, this.A04)) {
            this.A03.A0E().A4H();
            this.A00.ABm(this, JG.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A06 = new FE(this, c1492aaA00);
        TA ta = new TA(this.A03, (WeakReference<NE>) new WeakReference(this.A06), c8g.A04(), A6N());
        this.A07 = ta;
        ta.A0G(c8g.A07(), c8g.A08());
        C1503al c1503al = new C1503al(this);
        C0896Dz c0896Dz = this.A03;
        InterfaceC1004If interfaceC1004If = this.A04;
        TA ta2 = this.A07;
        C1490aY c1490aY = new C1490aY(c0896Dz, interfaceC1004If, ta2, ta2.getViewabilityChecker(), c1503al);
        this.A01 = c1490aY;
        c1490aY.A08(c1492aaA00);
        this.A07.loadDataWithBaseURL(NH.A01(AdInternalSettings.getUrlPrefix()), c1492aaA00.A04(), A08(31, 9, 97), A08(40, 5, 52), null);
        this.A0D = true;
        A09();
    }

    static {
        A0A();
        A0I = C1502ak.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A09() {
        F6 f6;
        if (this.A00 != null && this.A08 != null && (f6 = this.A02) != null && f6.A0k()) {
            this.A00.AAj(this, this.A08);
        }
        InterfaceC05900w interfaceC05900w = this.A00;
        if (interfaceC05900w != null && this.A0D) {
            boolean z = this.A0E;
            if (A0H[2].length() == 29) {
                throw new RuntimeException();
            }
            A0H[2] = "DQYu3GBVfiN4Ml";
            if (z || !this.A0F) {
                interfaceC05900w.AAj(this, this.A07);
            }
        }
        this.A03.A0E().A3e(this.A00 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0B(int i, C8G c8g) {
        this.A08 = new AnonymousClass95(this.A03, this.A04, new C1505an(this), this.A02, A08(0, 31, 110), 2, this.A05);
        this.A09 = new C1504am(this);
        C1203Qb c1203Qb = new C1203Qb(this.A08, c8g.A04(), c8g.A09(), true, new WeakReference(this.A09), this.A03);
        this.A0A = c1203Qb;
        c1203Qb.A0W(this.A02.A0C());
        this.A0A.A0X(this.A02.A0D());
        this.A08.setVisibility(0);
        this.A03.getResources();
        this.A08.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        this.A08.AFn();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    private void A0F(JJ jj, C8G c8g) {
        if (this.A02 == null || this.A04 == null) {
            return;
        }
        int iA02 = (int) (jj.A02() * Resources.getSystem().getDisplayMetrics().density);
        int bannerHeight = (IP.A1j(this.A03) && C07115q.A0A(this.A02.A0U())) ? 1 : 0;
        if (bannerHeight == 0) {
            A0B(iA02, c8g);
        } else {
            new C07115q(new C6Q(this.A03), this.A02.A0U(), this.A02.A0O(), this.A02.A0R(), true, new C1507ap(this, iA02, c8g, this)).A0B();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public final void A0I(C0896Dz c0896Dz, InterfaceC1004If interfaceC1004If, JJ jj, InterfaceC05900w interfaceC05900w, C06121s c06121s) {
        c0896Dz.A0E().A3d();
        this.A03 = c0896Dz;
        this.A04 = interfaceC1004If;
        this.A00 = interfaceC05900w;
        this.A0F = IP.A1N(c0896Dz.getApplicationContext());
        C8G c8gA01 = c06121s.A01();
        F6 f6A02 = F6.A02(c06121s.A03(), this.A03);
        this.A02 = f6A02;
        if (f6A02.A0k()) {
            A0F(jj, c8gA01);
        } else {
            A0E(c8gA01, c06121s);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final String A6N() {
        return this.A0C;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final AdPlacementType A7W() {
        return AdPlacementType.BANNER;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final boolean AFs() {
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ak != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC05820o
    public final void onDestroy() {
        this.A03.A0E().A3b(this.A07 != null);
        TA ta = this.A07;
        if (ta != null) {
            ta.destroy();
            this.A07 = null;
            this.A06 = null;
        }
    }
}
