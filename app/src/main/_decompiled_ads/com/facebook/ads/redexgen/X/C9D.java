package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9D, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9D extends AbstractC1278Sy implements MB {
    public static byte[] A0F;
    public static String[] A0G = {"QUFYIN7o4MSHfMbcaqgxGqdg8oING", "Qixa92rp7KQSHPhBId3L5m9SXc6gxNRP", "TUKhftCqFUFv9xNbjbPA3CLhBIkdW", "aNiMBj1VMT3xct4Co4hWzqTsg", "QYSCqyZ4CS", "VjIbmM2G6pRRrYhuKIf6SOzC6eQUF7eo", "KFJXOgKoK7JNlCBWMf", "dachHr6cLZKwbIDqTeRsc0FgbmZCJ"};
    public View A00;
    public View A01;
    public YA A02;
    public C1061Kn A03;
    public AbstractC1090Ls A04;
    public PS A05;
    public JT A06;
    public boolean A07;
    public boolean A08;
    public final InterfaceC1091Lt A09;
    public final InterfaceC1129Nf A0A;
    public final C1130Ng A0B;
    public final RX A0C;
    public final C1026Jb A0D;
    public final AtomicBoolean A0E;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0F = new byte[]{-53, -60, -39, -56, -30, -42, -41, -60, -43, -41, -52, -47, -54, -30, -60, -47, -52, -48, -60, -41, -52, -46, -47, -42, -30, -45, -49, -60, -36, -56, -57, -51, -48, -44, -58, -32, -45, -58, -40, -62, -45, -59, -32, -44, -60, -45, -58, -58, -49, -32, -44, -55, -48, -40, -49, -53, -75, -57, -45, -71, -62, -72, -45, -73, -75, -58, -72, -45, -57, -68, -61, -53, -62};
    }

    static {
        A08();
    }

    public C9D(C1149Nz c1149Nz) {
        super(c1149Nz, false);
        this.A0E = new AtomicBoolean(false);
        this.A08 = false;
        this.A07 = false;
        this.A02 = c1149Nz.A05();
        this.A04 = c1149Nz.A08();
        View view = new View(this.A02);
        this.A01 = view;
        LV.A0K(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.A01, layoutParams);
        A05();
        InterfaceC1091Lt interfaceC1091LtA09 = c1149Nz.A09();
        this.A09 = interfaceC1091LtA09;
        C1139Np.A00(c1149Nz.A05(), this, getAdInfo().A0D().A07());
        RX rxA01 = A01(c1149Nz);
        this.A0C = rxA01;
        getAdDetailsView().bringToFront();
        C1026Jb c1026JbA02 = A02(c1149Nz);
        this.A0D = c1026JbA02;
        A13();
        this.A05 = new PS(this.A02, c1149Nz.A06(), getAdDataBundle());
        C1276Sw c1276Sw = new C1276Sw(this);
        this.A0A = c1276Sw;
        this.A0B = new C1130Ng(c1149Nz, getAdDataBundle(), rxA01, c1026JbA02, getAdDetailsView(), interfaceC1091LtA09, c1276Sw);
        if (IP.A19(getAdContextWrapper())) {
            NO.A00(rxA01.getVideoImplView(), IP.A1A(getAdContextWrapper()), new O1(this));
        }
    }

    private RX A01(C1149Nz c1149Nz) {
        RX rx = (RX) c1149Nz.A02();
        int iA12 = A12(c1149Nz.A08());
        ImageView imageView = (ImageView) c1149Nz.A03();
        int i = AbstractC1278Sy.A0D;
        int i2 = AbstractC1278Sy.A0D;
        int toolbarHeight = AbstractC1278Sy.A0D;
        imageView.setPadding(i, i2, toolbarHeight, AbstractC1278Sy.A0D);
        int toolbarHeight2 = AbstractC1278Sy.A0E;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(toolbarHeight2, AbstractC1278Sy.A0E);
        int toolbarHeight3 = AbstractC1278Sy.A0C;
        layoutParams.setMargins(0, iA12, toolbarHeight3, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        addView(rx, layoutParams2);
        rx.addView(imageView, layoutParams);
        return rx;
    }

    private C1026Jb A02(C1149Nz c1149Nz) {
        C1026Jb c1026JbA0A = c1149Nz.A0A();
        c1026JbA0A.A06(-1, AbstractC1278Sy.A09);
        c1026JbA0A.setPadding(AbstractC1278Sy.A0H, AbstractC1278Sy.A0H, AbstractC1278Sy.A0H, AbstractC1278Sy.A0H);
        RelativeLayout.LayoutParams progressBarLayoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1278Sy.A0G);
        progressBarLayoutParams.addRule(12);
        addView(c1026JbA0A, progressBarLayoutParams);
        return c1026JbA0A;
    }

    private void A04() {
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A0E();
            this.A0C.A0d(getAnimationPlugin());
        }
    }

    private void A05() {
        AbstractC1090Ls abstractC1090Ls = this.A04;
        if (abstractC1090Ls == null) {
            return;
        }
        this.A06 = new JT(abstractC1090Ls, 400, -abstractC1090Ls.getToolbarHeight(), 0);
    }

    private void A06() {
        new C1012In(getAdDataBundle().A11(), getAdEventManager()).A04(EnumC1011Im.A0r, null);
        if (!getAdInfo().A0O()) {
            return;
        }
        this.A0E.set(true);
        LV.A0T(this);
        LV.A0H(this.A0C);
        LV.A0Z(this.A0C, this.A0D, this.A0B, this.A00);
        LV.A0L(this.A04);
        PS ps = this.A05;
        T3 ctaButton = getCtaButton();
        String[] strArr = A0G;
        if (strArr[2].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A0G[3] = "FxfG3zWETYKhpCEsP1aqGpvXk";
        Pair<PR, View> pairA03 = ps.A03(ctaButton);
        this.A00 = (View) pairA03.second;
        switch (O2.A00[((PR) pairA03.first).ordinal()]) {
            case 1:
                getAdDetailsView().setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, A12(this.A04), 0, 0);
                layoutParams.addRule(2, getAdDetailsView().getId());
                addView(this.A00, layoutParams);
                break;
            case 2:
                LV.A0Z(getAdDetailsView());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.setMargins(AbstractC1278Sy.A0F, AbstractC1278Sy.A0F, AbstractC1278Sy.A0F, AbstractC1278Sy.A0F);
                addView(this.A00, layoutParams2);
                break;
        }
        if (getAdInfo().A0G().A00() >= 0) {
            this.A07 = true;
            AbstractC1090Ls abstractC1090Ls = this.A04;
            if (abstractC1090Ls != null) {
                abstractC1090Ls.setToolbarActionMode(2);
                this.A04.setProgressImmediate(0.0f);
            }
            C1061Kn c1061Kn = new C1061Kn((int) getAdInfo().A0G().A00(), 20.0f, 20L, new Handler(Looper.getMainLooper()), new C1275Sv(this));
            this.A03 = c1061Kn;
            c1061Kn.A08();
        }
    }

    private void A07() {
        JT jt = this.A06;
        if (jt != null) {
            jt.A3U(true, false);
        }
        if (getAdDetailsAnimation() != null) {
            getAdDetailsAnimation().A3U(true, false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0B(AnonymousClass75 anonymousClass75) {
        super.A0B(anonymousClass75);
        A06();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0C(AnonymousClass71 anonymousClass71) {
        super.A0C(anonymousClass71);
        int videoLengthMs = anonymousClass71.A00();
        int duration = this.A0C.getDuration() - videoLengthMs;
        if (getAnimationPlugin() != null) {
            int videoLengthMs2 = A0G[1].charAt(18);
            if (videoLengthMs2 != 51) {
                throw new RuntimeException();
            }
            A0G[5] = "xiBnzSw2W6K3rvYkwdUGMYXv5m3ZqRWR";
            if (duration < 3000 && getAnimationPlugin().A0J()) {
                getAnimationPlugin().A0F();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0u() {
        super.A0u();
        A04();
        this.A04 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1278Sy, com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final void A0z(C1D c1d, String str, double d, Bundle bundle) {
        super.A0z(c1d, str, d, bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.getBoolean(A03(0, 31, 118), false)) {
            A07();
        }
        if (bundle.getBoolean(A03(55, 18, 103), false)) {
            A06();
        }
        if (bundle.getBoolean(A03(31, 24, 116), false)) {
            C1130Ng c1130Ng = this.A0B;
            if (A0G[1].charAt(18) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "jjtMTZWEM7Dg1szUnnnmuTjwvMhej";
            strArr[0] = "cexdZia4vusGbXInA5fVVHDcQrSB4";
            c1130Ng.A07(this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A10() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public final boolean A11(boolean z) {
        boolean zA0O;
        if (!z || this.A08) {
            zA0O = getAdInfo().A0O();
            if (A0G[5].charAt(17) != 'k') {
                A0G[1] = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor";
                if (!zA0O && !this.A0E.get()) {
                    this.A0C.A0a(EnumC1180Pe.A08);
                    return true;
                }
            }
        } else {
            boolean z2 = this.A0E.get();
            String[] strArr = A0G;
            if (strArr[7].length() != strArr[4].length()) {
                String[] strArr2 = A0G;
                strArr2[2] = "IfEmWBIDBUNw5tL7YhS4lNzldGhzw";
                strArr2[0] = "8CoNQoXVMdzgwU1krh95bRLsSKKH4";
                if (!z2) {
                    this.A0B.A07(this);
                    return true;
                }
                zA0O = getAdInfo().A0O();
                if (A0G[5].charAt(17) != 'k') {
                    A0G[1] = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor";
                    return !zA0O ? false : false;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1278Sy
    public final void A13() {
        super.A13();
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A9D(this.A0C);
        }
    }

    public final boolean A14() {
        return getAdInfo().A0O();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public int getCloseButtonStyle() {
        if (this.A07) {
            return 2;
        }
        if (A14() && !this.A0E.get()) {
            return 1;
        }
        return super.getCloseButtonStyle();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1278Sy, com.facebook.ads.redexgen.X.AbstractC1145Nv, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
