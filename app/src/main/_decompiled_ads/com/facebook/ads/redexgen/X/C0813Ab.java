package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ab, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0813Ab extends ZC {
    public static String[] A08 = {"bHvO3zM", "7z8VpEP", "iw2Y0c", "LME8njBPiXs011hhslbtp", "9K0lNzbR5X2b0vS5", "Pt0EnZUFnGQLsNks8pQcEgn0FivkNzUh", "t6anbflpJj2CGicCnIMdWTRCydsD", "D9TL9YTSSd0lWzGeUvgWfvwaUF0YdAOx"};
    public float A00;
    public int A01;
    public int A02;
    public C0820Ai A03;
    public int[] A04;
    public final YA A05;
    public final P5 A06;
    public final P6 A07;

    public C0813Ab(YA ya, P6 p6, P5 p5) {
        super(ya);
        this.A02 = 0;
        this.A00 = 50.0f;
        this.A05 = ya;
        this.A07 = p6;
        this.A06 = p5;
        this.A01 = -1;
        this.A03 = new C0820Ai(this, ya);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f7  */
    @Override // com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1J(C06794k c06794k, C06864r c06864r, int i, int widthMode) {
        int[] iArrA02;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(widthMode);
        if ((mode == 1073741824 && A2A() == 1) || (mode2 == 1073741824 && A2A() == 0)) {
            super.A1J(c06794k, c06864r, i, widthMode);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(widthMode);
        if (this.A06.A01(this.A01)) {
            iArrA02 = this.A06.A02(this.A01);
        } else {
            iArrA02 = new int[]{0, 0};
            if (c06864r.A03() >= 1) {
                int iA0W = A0W() > 0 ? 1 : A0W();
                for (int i2 = 0; i2 < iA0W; i2++) {
                    View viewA1q = A1q(i2);
                    if (A08[5].length() != 32) {
                        throw new RuntimeException();
                    }
                    A08[4] = "FajaHWp";
                    if (viewA1q == null) {
                        break;
                    }
                    this.A04 = this.A07.A00(viewA1q, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    if (A2A() == 0) {
                        int heightMode = iArrA02[0];
                        int[] iArr = this.A04;
                        iArrA02[0] = heightMode + iArr[0];
                        if (i2 == 0) {
                            int iA0g = iArr[1] + A0g();
                            if (A08[6].length() != 1) {
                                A08[6] = "o1L5u";
                                iArrA02[1] = iA0g + A0d();
                            } else {
                                throw new RuntimeException();
                            }
                        } else {
                            continue;
                        }
                    } else {
                        int i3 = iArrA02[1];
                        int[] iArr2 = this.A04;
                        if (A08[6].length() != 1) {
                            A08[5] = "6nCDHSOFLCCkeDdRDThHGlolS6KLs45E";
                            iArrA02[1] = i3 + iArr2[1];
                            if (i2 == 0) {
                                iArrA02[0] = iArr2[0] + A0e() + A0f();
                            }
                        } else {
                            A08[3] = "KFvpvLkhCjqU9hzA1pvFB";
                            iArrA02[1] = i3 + iArr2[1];
                            if (i2 == 0) {
                                iArrA02[0] = iArr2[0] + A0e() + A0f();
                            }
                        }
                    }
                }
                int widthMode2 = this.A01;
                if (widthMode2 != -1) {
                    this.A06.A00(widthMode2, iArrA02);
                }
            }
        }
        if (mode == 1073741824) {
            iArrA02[0] = size;
        }
        if (mode2 == 1073741824) {
            iArrA02[1] = size2;
        }
        A13(iArrA02[0], iArrA02[1]);
    }

    @Override // com.facebook.ads.redexgen.X.ZC, com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A1t(int i) {
        A2F(i, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.ZC, com.facebook.ads.redexgen.X.AbstractC06724c
    public final void A21(ED ed, C06864r c06864r, int i) {
        this.A03.A0A(i);
        A1L(this.A03);
    }

    public final void A2K(double d) {
        if (d <= 0.0d) {
            d = 1.0d;
        }
        this.A00 = (float) (50.0d / d);
        this.A03 = new C0820Ai(this, this.A05);
    }

    public final void A2L(int i) {
        this.A01 = i;
    }

    public final void A2M(int i) {
        this.A02 = i;
    }
}
