package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1278Sy extends AbstractC1145Nv {
    public static byte[] A06;
    public static String[] A07 = {"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public K2 A00;
    public JX A01;
    public JT A02;
    public final AbstractC1484aS A03;
    public final C1D A04;
    public final NR A05;

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A06 = new byte[]{9, 5, 7, 68, 12, 11, 9, 15, 8, 5, 5, 1, 68, 11, 14, 25, 68, 3, 4, 30, 15, 24, 25, 30, 3, 30, 3, 11, 6, 68, 9, 6, 3, 9, 1, 15, 14, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    static {
        A0D();
        A0B = (int) (C1066Ku.A02 * 48.0f);
        A0F = (int) (C1066Ku.A02 * 16.0f);
        A08 = (int) (C1066Ku.A02 * 4.0f);
        A0E = (int) (C1066Ku.A02 * 44.0f);
        A0C = (int) (C1066Ku.A02 * 8.0f);
        A0D = (int) (C1066Ku.A02 * 12.0f);
        A0H = (int) (C1066Ku.A02 * 12.0f);
        A0G = (int) (C1066Ku.A02 * 26.0f);
        int iA01 = C06232d.A01(-1, 77);
        A09 = iA01;
        A0A = C06232d.A01(iA01, 90);
    }

    public AbstractC1278Sy(C1149Nz c1149Nz, boolean z) {
        super(c1149Nz, z);
        AbstractC1484aS abstractC1484aSA04 = c1149Nz.A04();
        this.A03 = abstractC1484aSA04;
        this.A04 = abstractC1484aSA04.A0v();
        this.A05 = A0B(c1149Nz);
        AbstractC1090Ls abstractC1090LsA08 = c1149Nz.A08();
        if (abstractC1090LsA08 != null) {
            abstractC1090LsA08.setLayoutParams(new RelativeLayout.LayoutParams(-1, abstractC1090LsA08.getToolbarHeight()));
            abstractC1090LsA08.setPageDetailsVisible(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:14:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:17:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:9:0x005c  */
    private C1279Sz A0B(C1149Nz c1149Nz) {
        String strA0C;
        C1279Sz c1279Sz;
        boolean z;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (!c1149Nz.A04().A0O().equals(A0C(37, 14, 56))) {
            if (A07[5].length() != 7) {
                A07[7] = "aLegEIjbGKC4WYI41vdDU1g9u";
                strA0C = A0C(0, 37, 124);
                YA yaA05 = c1149Nz.A05();
                int i = A0B;
                if (this.A04.A0E().A00() == C1I.A05) {
                    z = true;
                } else {
                    z = false;
                }
                c1279Sz = new C1279Sz(yaA05, i, z, getColors(), this.A04.A0F().A06(), strA0C, c1149Nz.A06(), c1149Nz.A09(), c1149Nz.A0B(), c1149Nz.A07(), c1149Nz.A04().A0x());
                this.A02 = new JT(c1279Sz, 400, 100, 0);
                LV.A0K(c1279Sz);
                c1279Sz.A0C(c1149Nz.A00());
                if (IP.A0z(c1149Nz.A05())) {
                    c1279Sz.A0B();
                    if (c1149Nz.A08() != null) {
                        c1149Nz.A08().setCTAClickListener(getCtaButton());
                    }
                }
                addView(c1279Sz, layoutParams);
                c1279Sz.getCTAButton().A0A(this.A03, c1149Nz.A08());
                return c1279Sz;
            }
            throw new RuntimeException();
        }
        EnumC1188Pm enumC1188Pm = EnumC1188Pm.A04;
        if (A07[7].length() != 22) {
            String[] strArr = A07;
            strArr[6] = "Ca3psE1IPVUhCMreDaAATfbsplsRsoNT";
            strArr[1] = "q1VyT2b1NhDnFBLs9y9UP0y4iho0jP8D";
            strA0C = enumC1188Pm.A02();
            YA yaA06 = c1149Nz.A05();
            int i2 = A0B;
            if (this.A04.A0E().A00() == C1I.A05) {
                z = true;
            } else {
                z = false;
            }
            c1279Sz = new C1279Sz(yaA06, i2, z, getColors(), this.A04.A0F().A06(), strA0C, c1149Nz.A06(), c1149Nz.A09(), c1149Nz.A0B(), c1149Nz.A07(), c1149Nz.A04().A0x());
            this.A02 = new JT(c1279Sz, 400, 100, 0);
            LV.A0K(c1279Sz);
            c1279Sz.A0C(c1149Nz.A00());
            if (IP.A0z(c1149Nz.A05())) {
                c1279Sz.A0B();
                if (c1149Nz.A08() != null) {
                    c1149Nz.A08().setCTAClickListener(getCtaButton());
                }
            }
            addView(c1279Sz, layoutParams);
            c1279Sz.getCTAButton().A0A(this.A03, c1149Nz.A08());
            return c1279Sz;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv
    public void A0z(C1D c1d, String str, double d, Bundle bundle) {
        super.A0z(c1d, str, d, bundle);
        this.A05.setInfo(c1d.A0E(), c1d.A0F(), str, this.A03.A0z().A01(), null);
    }

    public final int A12(AbstractC1090Ls abstractC1090Ls) {
        return abstractC1090Ls == null ? AbstractC1090Ls.A00 : abstractC1090Ls.getToolbarHeight();
    }

    public void A13() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            K2 k2 = new K2(true);
            this.A00 = k2;
            JX jx = this.A01;
            if (jx != null) {
                k2.A0I(jx);
            }
            C1M c1mA01 = this.A03.A0u().A01();
            this.A00.A0I(new JV(getAdDetailsView().getCTAButton(), ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, -1, c1mA01.A09(true)));
            int i = A09;
            int i2 = A0A;
            int i3 = A08;
            Drawable drawableA08 = LV.A08(i, i2, i3);
            Drawable startDrawable = LV.A05(c1mA01.A08(true), i3);
            this.A00.A0I(new JY(getAdDetailsView().getCTAButton(), ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, drawableA08, startDrawable));
            this.A00.A0I(new JW(expandableLayout, 150, false));
            this.A00.A0H(2300);
        }
    }

    public AbstractC1484aS getAdDataBundle() {
        return this.A03;
    }

    public JT getAdDetailsAnimation() {
        return this.A02;
    }

    public NR getAdDetailsView() {
        return this.A05;
    }

    public C1D getAdInfo() {
        return this.A04;
    }

    public K2 getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1145Nv, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0C(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout == null || !z) {
            return;
        }
        JX jx = this.A01;
        if (A07[2].charAt(30) != '4') {
            throw new RuntimeException();
        }
        A07[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        if (jx == null) {
            JX jx2 = new JX(expandableLayout, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO, expandableLayout.getHeight(), 0);
            this.A01 = jx2;
            this.A00.A0I(jx2);
            this.A00.A0G();
        }
    }
}
