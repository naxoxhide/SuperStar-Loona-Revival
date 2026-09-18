package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SM extends AbstractC1172Ow {
    public static byte[] A0W;
    public static String[] A0X = {"zF", "YuhgBsbCJ4GENG72FYuTSQ3UxVCmrs0t", "RSfzcHToFNO8jc1tX2m0S0AZ0vbf9kKl", "p", "lGjhRdALEILVIUsiuWCm6MXJK2R8L6Co", "wXQvDYR5huLQKlTsBS5mG0rN7ygrQvR2", "AYgBJnzxyMi9rrwHO3oB8yOhTSWVLxNu", "3k2Jytm7iEKA6X2jmmGhgFSNDYaf4AHR"};
    public static final int A0Y;
    public static final int A0Z;
    public static final int A0a;
    public static final int A0b;
    public static final int A0c;
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public C1M A00;
    public C1061Kn A01;
    public EnumC1185Pj A02;
    public JX A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final YA A0C;
    public final NR A0D;
    public final T3 A0E;
    public final P0 A0F;
    public final PS A0G;
    public final C1176Pa A0H;
    public final RX A0I;
    public final AnonymousClass76 A0J;
    public final AbstractC1151Ob A0K;
    public final AbstractC1137Nn A0L;
    public final MU A0M;
    public final MI A0N;
    public final MA A0O;
    public final M9 A0P;
    public final K2 A0Q;
    public final C1040Jr A0R;
    public final C1026Jb A0S;
    public final JT A0T;
    public final boolean A0U;
    public final boolean A0V;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0W, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0W = new byte[]{-55, -43, -45, -108, -52, -57, -55, -53, -56, -43, -43, -47, -108, -57, -54, -39, -108, -49, -44, -38, -53, -40, -39, -38, -49, -38, -49, -57, -46, -108, -55, -46, -49, -55, -47, -53, -54, 27, 14, 32, 10, 27, 13, 14, 13, 8, 31, 18, 13, 14, 24};
    }

    static {
        A0D();
        A0b = (int) (C1066Ku.A02 * 48.0f);
        int iA01 = C06232d.A01(-1, 77);
        A0Z = iA01;
        A0g = (int) (C1066Ku.A02 * 26.0f);
        A0h = (int) (C1066Ku.A02 * 12.0f);
        A0d = (int) (C1066Ku.A02 * 12.0f);
        A0e = (int) (C1066Ku.A02 * 44.0f);
        A0c = (int) (C1066Ku.A02 * 8.0f);
        A0f = (int) (C1066Ku.A02 * 16.0f);
        A0a = C06232d.A01(iA01, 90);
        A0Y = (int) (C1066Ku.A02 * 4.0f);
    }

    public SM(YA ya, InterfaceC1004If interfaceC1004If, AbstractC1484aS abstractC1484aS, C6Q c6q, MM mm, int i, InterfaceC1091Lt interfaceC1091Lt, C1012In c1012In, int i2, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, P0 p0) {
        C1M c1mA00;
        super(ya, mm, interfaceC1004If, abstractC1484aS, i, z3, z4, interfaceC1091Lt);
        this.A04 = false;
        this.A05 = false;
        this.A07 = false;
        MA ma = new MA() { // from class: com.facebook.ads.redexgen.X.8x
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MD md) {
                this.A00.A07 = true;
            }
        };
        this.A0O = ma;
        MI mi = new MI() { // from class: com.facebook.ads.redexgen.X.8q
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(MJ mj) {
                if (!((AbstractC1172Ow) this.A00).A08.A07()) {
                    this.A00.A03();
                }
            }
        };
        this.A0N = mi;
        MU mu = new MU() { // from class: com.facebook.ads.redexgen.X.8l
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            public final /* bridge */ /* synthetic */ void A03(C8Y c8y) {
            }
        };
        this.A0M = mu;
        M9 m9 = new M9() { // from class: com.facebook.ads.redexgen.X.8X
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(AnonymousClass71 anonymousClass71) {
                this.A00.A0G(anonymousClass71);
                this.A00.A0F.ABO(anonymousClass71.A00());
            }
        };
        this.A0P = m9;
        AbstractC1151Ob abstractC1151Ob = new AbstractC1151Ob() { // from class: com.facebook.ads.redexgen.X.8E
            public static String[] A01 = {"WHlfg22LQewOceL2LP0nfjs", "MLczN6H9d0ts9YHCrKUbmxW9Pv4xX40Z", "bfgAoKxvo7gEuP52Z2EO408IJ8JPPLb2", "8W4TrLCVwT5pN341HhH6D3mP2byMMwpU", "ScQcjv0hvXE5sqpvLhFnJdo", "ew857MaMURY893GG0hi3zO6RFtTWvxkk", "kzrdBoT0QozH1fOZ2V6a3FXV0JrhAD1i", "6tn8KSSYbJPeTKsUVc3lRKjtLiYgy0EC"};

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.AbstractC07628a
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(AnonymousClass75 anonymousClass75) {
                this.A00.A0F.AB2(this.A00.A0I.getDuration());
                if (this.A00.A0P()) {
                    this.A00.A0L();
                    return;
                }
                SM sm = this.A00;
                String[] strArr = A01;
                if (strArr[6].charAt(31) == strArr[1].charAt(31)) {
                    throw new RuntimeException();
                }
                A01[2] = "b2r5SY6tJEDKh19k0rBQmCTxaUfC6Ghy";
                sm.A0F.AAf();
            }
        };
        this.A0K = abstractC1151Ob;
        C8C c8c = new C8C(this);
        this.A0L = c8c;
        this.A0C = ya;
        this.A0R = new C1040Jr(ya, c1012In);
        this.A0S = new C1026Jb(ya);
        this.A0A = i5;
        this.A0V = z2;
        this.A09 = i2;
        this.A0B = i3;
        this.A0F = p0;
        this.A08 = i4;
        this.A0U = z;
        this.A0G = new PS(ya, interfaceC1004If, super.A05);
        if (i3 == 1) {
            c1mA00 = super.A05.A0u().A01();
        } else {
            c1mA00 = super.A05.A0u().A00();
        }
        this.A00 = c1mA00;
        RX rx = new RX(ya);
        this.A0I = rx;
        rx.getEventBus().A03(ma, mi, mu, m9, abstractC1151Ob, c8c);
        this.A0J = new AnonymousClass76(ya, interfaceC1004If, rx, abstractC1484aS.A11());
        A0C();
        rx.setVideoURI(c6q.A0S(super.A05.A0v().A0D().A08()));
        A0B();
        C1279Sz c1279SzA05 = A05();
        this.A0D = c1279SzA05;
        JT jt = new JT(c1279SzA05, 400, 100, 0);
        this.A0T = jt;
        jt.A3U(true, false);
        this.A0Q = new K2(true);
        A0E();
        T3 cTAButton = c1279SzA05.getCTAButton();
        this.A0E = cTAButton;
        LV.A0G(1001, cTAButton);
        A0A();
        A09();
        c1279SzA05.bringToFront();
        if (IP.A1X(ya)) {
            ya.A0A().AGA(rx, super.A05.A11(), true);
        }
        if (IP.A1Y(ya)) {
            this.A0H = new C1176Pa(ya, interfaceC1004If, rx, super.A05.A11(), null);
        } else {
            this.A0H = null;
        }
    }

    private C1279Sz A05() {
        String strA08;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (super.A05.A0O().equals(A08(37, 14, 125))) {
            strA08 = EnumC1188Pm.A04.A02();
        } else {
            strA08 = A08(0, 37, 58);
        }
        C1279Sz c1279Sz = new C1279Sz(this.A0C, A0b, super.A05.A0v().A0E().A00() == C1I.A05, getColors(), super.A05.A0v().A0F().A06(), strA08, super.A07, super.A09, super.A0B, super.A08, super.A05.A0x());
        LV.A0G(PointerIconCompat.TYPE_TEXT, c1279Sz);
        c1279Sz.A0C(this.A0B);
        addView(c1279Sz, layoutParams);
        c1279Sz.setInfo(super.A05.A0v().A0E(), super.A05.A0v().A0F(), super.A05.A11(), super.A05.A0z().A01(), null);
        return c1279Sz;
    }

    private void A09() {
        this.A0S.A06(-1, A0Z);
        C1026Jb c1026Jb = this.A0S;
        int i = A0h;
        c1026Jb.setPadding(i, i, i, i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0g);
        layoutParams.addRule(12);
        addView(this.A0S, layoutParams);
    }

    private void A0A() {
        C1040Jr c1040Jr = this.A0R;
        int i = A0d;
        c1040Jr.setPadding(i, i, i, i);
        int i2 = A0e;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.setMargins(0, AbstractC1090Ls.A00, A0c, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        ViewGroup.LayoutParams videoViewParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A0I, videoViewParams);
        addView(this.A0R, layoutParams);
    }

    private void A0B() {
        postDelayed(new SP(this), IP.A0L(this.A0C));
    }

    private void A0C() {
        this.A0I.A0c(this.A0S);
        this.A0I.A0c(this.A0R);
        if (!TextUtils.isEmpty(super.A05.A0v().A0D().A07())) {
            C07266j c07266j = new C07266j(this.A0C);
            this.A0I.A0c(c07266j);
            c07266j.setImage(super.A05.A0v().A0D().A07());
        }
        this.A0I.A0c(new C6Z(this.A0C));
    }

    private final void A0E() {
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null) {
            JX jx = this.A03;
            if (jx != null) {
                this.A0Q.A0I(jx);
            }
            C1M c1mA01 = super.A05.A0u().A01();
            this.A0Q.A0I(new JV(this.A0D.getCTAButton(), ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, -1, c1mA01.A09(true)));
            int i = A0Z;
            int i2 = A0a;
            int i3 = A0Y;
            Drawable drawableA08 = LV.A08(i, i2, i3);
            Drawable endDrawable = LV.A05(c1mA01.A08(true), i3);
            this.A0Q.A0I(new JY(this.A0D.getCTAButton(), ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, drawableA08, endDrawable));
            this.A0Q.A0I(new JW(expandableLayout, 150, false));
            this.A0Q.A9D(this.A0I);
            this.A0Q.A0H(2300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(AnonymousClass71 anonymousClass71) {
        if (this.A0I.getState() == QY.A02 && IP.A1E(this.A0C)) {
            postDelayed(new SO(this, anonymousClass71), 5000L);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final void A0K() {
        C1061Kn c1061Kn = this.A01;
        if (c1061Kn != null) {
            c1061Kn.A07();
        }
        if (IP.A1X(this.A0C)) {
            this.A0C.A0A().AFz(this.A0I);
        }
        C1176Pa c1176Pa = this.A0H;
        if (c1176Pa != null) {
            c1176Pa.A0A();
        }
        RX rx = this.A0I;
        if (rx != null) {
            rx.getEventBus().A04(this.A0O, this.A0N, this.A0M, this.A0P, this.A0K, this.A0L);
            LV.A0H(this.A0I);
            this.A0I.A0V();
        }
        this.A0J.A0g();
        View[] viewArr = new View[3];
        viewArr[0] = this.A0I;
        C1026Jb c1026Jb = this.A0S;
        String[] strArr = A0X;
        if (strArr[0].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A0X[2] = "4e1dr9g4n9kT22ZIdoKy0n8REVoGbgbF";
        viewArr[1] = c1026Jb;
        viewArr[2] = this.A0R;
        LV.A0Z(viewArr);
        super.A0B.A0V();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final void A0L() {
        this.A0C.A0E().A4C();
        this.A04 = true;
        LV.A0T(this);
        LV.A0H(this.A0I);
        LV.A0Z(this.A0I, this.A0S, this.A0R);
        Pair<PR, View> pairA03 = this.A0G.A03(this.A0E);
        View view = (View) pairA03.second;
        LV.A0G(1101, view);
        switch (C1173Ox.A00[((PR) pairA03.first).ordinal()]) {
            case 1:
                this.A0D.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, AbstractC1090Ls.A00, 0, 0);
                layoutParams.addRule(2, this.A0D.getId());
                addView(view, layoutParams);
                break;
            case 2:
                LV.A0Z(this.A0D);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                int i = A0f;
                layoutParams2.setMargins(i, i, i, i);
                addView(view, layoutParams2);
                break;
        }
        if (this.A08 == 0 && this.A0U) {
            if (this.A0V) {
                this.A0F.AG5();
            }
            C1061Kn c1061Kn = new C1061Kn(this.A0A, 100.0f, 100L, new Handler(Looper.getMainLooper()), new SN(this));
            this.A01 = c1061Kn;
            c1061Kn.A08();
            return;
        }
        this.A05 = true;
        this.A0F.ACw(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final void A0M() {
        this.A0I.A0b(EnumC1185Pj.A02, 20);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final void A0N(boolean z) {
        C1061Kn c1061Kn = this.A01;
        if (c1061Kn != null) {
            c1061Kn.A07();
        }
        if (this.A0I.A0i()) {
            return;
        }
        this.A02 = this.A0I.getVideoStartReason();
        this.A06 = z;
        this.A0I.A0e(false, 13);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final void A0O(boolean z) {
        EnumC1185Pj enumC1185Pj;
        C1061Kn c1061Kn = this.A01;
        if (c1061Kn != null && !c1061Kn.A06()) {
            C1061Kn c1061Kn2 = this.A01;
            if (A0X[5].charAt(17) != 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A0X;
            strArr[7] = "pObqmm4LdTsqTcUgL7kozPbufRCkwYZC";
            strArr[6] = "5szeP9lNqMFVM0rzjOQcuK8NUDwg7u3G";
            c1061Kn2.A08();
        }
        if (this.A04 || this.A0I.getState() == QY.A06 || (enumC1185Pj = this.A02) == null) {
            return;
        }
        if (!this.A06 || z) {
            this.A0I.A0b(enumC1185Pj, 19);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final boolean A0P() {
        if (this.A08 != 2 && super.A05.A0v().A0O() && !this.A04) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public final boolean A0Q() {
        return this.A04;
    }

    public C1M getColors() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public C1175Oz getFullScreenAdStyle() {
        return new C1175Oz(true, C1175Oz.A06, super.A05.A0u().A01(), T3.A08(super.A05), super.A05.A0u().A01().A07(true), super.A05.A0v().A0D().A07());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow
    public LN getTouchDataRecorder() {
        return super.A08;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1172Ow, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        C1M c1mA00;
        super.onConfigurationChanged(configuration);
        if (!this.A04) {
            if (configuration.orientation == 1) {
                c1mA00 = super.A05.A0u().A01();
            } else {
                AnonymousClass19 anonymousClass19A0u = super.A05.A0u();
                if (A0X[4].charAt(4) != 'R') {
                    throw new RuntimeException();
                }
                A0X[1] = "uYIsd2DhsQ91Wp0xmXJ9348eeMLtSRMf";
                c1mA00 = anonymousClass19A0u.A00();
            }
            this.A00 = c1mA00;
            this.A0E.setViewShowsOverMedia(true);
            this.A0E.setUpButtonColors(this.A00);
            this.A0D.A0C(configuration.orientation);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null && z && this.A03 == null) {
            JX jx = new JX(expandableLayout, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, expandableLayout.getHeight(), 0);
            this.A03 = jx;
            this.A0Q.A0I(jx);
            this.A0Q.A0G();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            A0O(false);
        } else {
            A0N(false);
        }
    }
}
