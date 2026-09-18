package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N9 extends RelativeLayout {
    public static InterfaceC1091Lt A05;
    public static byte[] A06;
    public static String[] A07 = {"CT308ms2RTF49ixw7iITcI5DvAIGWMXZ", "UVauKq3DlAHpB1vMyeeSD4Us6AaVXCYd", "G3Ivv2DNtSsvdOlvNnw6jHI40eb4uyYL", "qur6nZLrhU9XJET37yOODnXWYcrj37IJ", "OCLfHPrXkMpm02uq88EYR3Uw1JpI2kE3", "KopKmjllEHptdGx3", "mL4xXMXopKoNgp", "1VwEGJcTQNgN7iTbFc9O"};
    public static final int A08;
    public static final int A09;
    public static final int A0A;
    public AbstractC1428Yw A00;
    public YA A01;
    public C05730e A02;
    public TH A03;
    public C1131Nh A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A07[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[2] = "hwjeWCnyrgrPOyFOaJyYR4Ki88uO9bQs";
            strArr[0] = "4m7NTkn57B9pIqsgccGzW0RoTzQfESBy";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 119);
            i4++;
        }
    }

    public static void A02() {
        A06 = new byte[]{-25, 5, 22, 19, 25, 23, 9, 16, -60, -14, 5, 24, 13, 26, 9, -60, 26, 13, 9, 27, -60, 5, 8, 9, 20, 24, 9, 22, -60, 13, 23, 18, -53, 24, -60, 7, 22, 9, 5, 24, 9, 8, -60, 20, 22, 19, 20, 9, 22, 16, 29, -5, -7, 2, -7, 6, -3, -9};
    }

    static {
        A02();
        int i = (int) (C1066Ku.A02 * 8.0f);
        A09 = i;
        A08 = i * 10;
        A0A = (int) (C1066Ku.A02 * 15.0f);
        A05 = new TG();
    }

    public N9(YA ya) {
        super(ya);
        this.A01 = ya;
        C05730e c05730e = new C05730e(ya);
        this.A02 = c05730e;
        LV.A0K(c05730e);
        EE ee = new EE();
        this.A00 = ee;
        ee.A0G(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
    }

    private ArrayList<PC> A01(AbstractC1484aS abstractC1484aS) {
        if (abstractC1484aS == null) {
            return new ArrayList<>();
        }
        List<C1D> listA13 = abstractC1484aS.A13();
        ArrayList<PC> arrayList = new ArrayList<>(listA13.size());
        for (int i = 0; i < listA13.size(); i++) {
            arrayList.add(new PC(i, listA13.size(), listA13.get(i)));
        }
        return arrayList;
    }

    public final void A04() {
        this.A02.setAdapter(null);
    }

    public final void A05(UJ uj, int i) {
        ArrayList<PC> arrayListA01 = A01(uj.A0z());
        this.A02.setCardsInfo(arrayListA01);
        TH th = new TH(this.A01, arrayListA01, uj.A0z(), this.A01.A01().A09(), uj, A05, uj.A0z().A11(), this.A02.getCarouselCardBehaviorHelper(), null);
        this.A03 = th;
        this.A02.setAdapter(th);
        this.A03.A0F(i - A08, 16, 0);
        this.A03.A06();
        setupDotsLayout(uj, arrayListA01);
    }

    public final void A06(C1203Qb c1203Qb) {
        TH th = this.A03;
        if (th != null) {
            th.A0G(c1203Qb);
        } else {
            this.A01.A07().A9M(A00(51, 7, 29), C07597x.A1u, new C07607y(A00(0, 51, 45)));
        }
        this.A02.A23(c1203Qb);
    }

    public static InterfaceC1091Lt getDummyListener() {
        return A05;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TH th;
        if (z && (th = this.A03) != null) {
            th.A0F((i3 - i) - A08, 16, 0);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpLayoutForCardAtIndex(int i) {
        C1131Nh c1131Nh = this.A04;
        if (c1131Nh != null) {
            c1131Nh.A00(i);
        }
    }

    private void setupDotsLayout(UJ uj, ArrayList<PC> arrayList) {
        this.A02.getCarouselCardBehaviorHelper().A0Z(new TF(this));
        C1131Nh c1131Nh = new C1131Nh(this.A01, uj.A0z().A0u().A01(), arrayList.size());
        this.A04 = c1131Nh;
        LV.A0K(c1131Nh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A02.getId());
        layoutParams.setMargins(0, A0A, 0, 0);
        addView(this.A04, layoutParams);
    }
}
