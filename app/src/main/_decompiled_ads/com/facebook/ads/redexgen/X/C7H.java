package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.datamodels.AdInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7H extends AbstractC1283Td {
    public static byte[] A0F;
    public static String[] A0G = {"hEO5MspmmQwWZDjfO9hYkGtE8t8ljCUN", "895GOd6GqHS2SDNwtQvAqIE", "zBXblOu1CdgXx49mdyV8flA", "GxqIbNjcrUQMSJiuMkyJv1mwkudVYaGP", "be3ZgXhlaup3yXbKLr41yKjcTusIQNjx", "HLi8FTj59ZkYUe8FmXrpO0CEflvtIm0o", "7bereGXxKpIS6kk2UNHV0kt11i4QSfeP", "LRvrjmvhZNKPrr4qRukG9JYrfPQqD7wd"};
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public static final int A0L;
    public int A00;
    public int A01;
    public LinearLayout A02;
    public AbstractC1484aS A03;
    public C6Q A04;
    public C2O A05;
    public C1131Nh A06;
    public S0 A07;
    public AbstractC1202Qa A08;
    public C1203Qb A09;
    public String A0A;
    public List<PC> A0B;
    public boolean A0C;
    public final YA A0D;
    public final LN A0E;

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0G;
            if (strArr[0].charAt(22) != strArr[6].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[5] = "I427OJiZERIl1pgFYs7VIJxgJMuHqTWY";
            strArr2[4] = "m1VK8a3APoHjuOOKlTc7gi9yCeUy6Tbh";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
            i4++;
        }
    }

    public static void A0B() {
        A0F = new byte[]{118, 115, 72, 115, 118, 99, 118, 72, 117, 98, 121, 115, 123, 114, 117, 98, 112, 102, 117, 99, 98, 99, 81, 110, 99, 98, 104, 70, 99, 67, 102, 115, 102, 69, 114, 105, 99, 107, 98};
    }

    static {
        A0B();
        A0H = (int) (C1066Ku.A02 * 48.0f);
        A0I = (int) (C1066Ku.A02 * 8.0f);
        A0J = (int) (C1066Ku.A02 * 8.0f);
        A0L = (int) (C1066Ku.A02 * 56.0f);
        A0K = (int) (C1066Ku.A02 * 12.0f);
    }

    public C7H(YA ya, InterfaceC1004If interfaceC1004If, C6Q c6q, InterfaceC1091Lt interfaceC1091Lt, C0921Ey c0921Ey) {
        super(ya, interfaceC1004If, interfaceC1091Lt, c0921Ey);
        this.A0E = new LN();
        this.A0C = false;
        super.A07 = true;
        super.A06 = new PU(ya, new TQ(), super.A0A.A0S(), interfaceC1091Lt);
        this.A04 = c6q;
        this.A0D = ya;
    }

    public C7H(YA ya, InterfaceC1004If interfaceC1004If, C6Q c6q, InterfaceC1091Lt interfaceC1091Lt, F0 f0) {
        super(ya, interfaceC1004If, interfaceC1091Lt, f0);
        this.A0E = new LN();
        this.A0C = false;
        this.A04 = c6q;
        this.A0D = ya;
    }

    private AbstractC1484aS A00(Intent intent) {
        if (super.A07) {
            return (AbstractC1484aS) intent.getSerializableExtra(A09(14, 25, 77));
        }
        return (AbstractC1484aS) intent.getSerializableExtra(A09(0, 14, 93));
    }

    private final void A0C() {
        LinearLayout linearLayout = this.A02;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A02 = null;
        }
        C2O c2o = this.A05;
        if (c2o != null) {
            c2o.removeAllViews();
            this.A05.A1R();
            this.A05 = null;
        }
        C1131Nh c1131Nh = this.A06;
        if (c1131Nh != null) {
            c1131Nh.removeAllViews();
            this.A06 = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0130  */
    private final void A0D(int i, Bundle bundle) {
        int extraSpacing;
        int i2;
        int height;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.A02 = linearLayout;
        if (i == 1) {
            linearLayout.setGravity(17);
        } else {
            linearLayout.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i3 = C1066Ku.A03.widthPixels;
        int i4 = C1066Ku.A03.heightPixels;
        if (i == 1) {
            extraSpacing = Math.min(i3 - (A0I * 4), i4 / 2);
            i2 = (i3 - extraSpacing) / 8;
            height = i2 * 4;
        } else {
            extraSpacing = i4 - ((A0L + A0H) + (A0I * 4));
            i2 = A0I;
            height = i2 * 2;
        }
        this.A08 = new C1242Ro(this);
        C1203Qb c1203Qb = new C1203Qb(this, 1, new WeakReference(this.A08), this.A0D);
        this.A09 = c1203Qb;
        c1203Qb.A0W(this.A00);
        this.A09.A0X(this.A01);
        C2O c2o = new C2O(this.A0D);
        this.A05 = c2o;
        c2o.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new S0(this.A05, i, this.A0B, this.A09, bundle);
        int extraSpacing2 = i2;
        int childSpacing = extraSpacing;
        this.A05.setAdapter(new C1244Rq(this.A0D, this.A0B, this.A03, super.A0C, this.A04, this.A09, this.A0E, getAudienceNetworkListener(), this.A0A, childSpacing, extraSpacing2, height, i, this.A07, super.A0E));
        C2O c2o2 = this.A05;
        c2o2.A1k(c2o2.getOnScrollListener());
        if (i == 1) {
            A0F(this.A07);
        }
        LinearLayout linearLayout2 = this.A02;
        C2O c2o3 = this.A05;
        if (A0G[7].charAt(26) == 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[0] = "pS0yYjaDPNGuTrfnUmeGhxtdEtLadoEJ";
        strArr[6] = "mwC7eMAbLdHre0yQkkMBVztsNAF33a9m";
        linearLayout2.addView(c2o3);
        C1131Nh c1131Nh = this.A06;
        if (c1131Nh != null) {
            LinearLayout linearLayout3 = this.A02;
            String[] strArr2 = A0G;
            if (strArr2[5].charAt(16) == strArr2[4].charAt(16)) {
                throw new RuntimeException();
            }
            A0G[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
            linearLayout3.addView(c1131Nh);
        }
        boolean zA1X = IP.A1X(this.A0D);
        String[] strArr3 = A0G;
        if (strArr3[0].charAt(22) == strArr3[6].charAt(22)) {
            A0G[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
            if (zA1X) {
                this.A0D.A0A().AGA(this.A05, super.A0A.A11(), false);
            }
        } else if (zA1X) {
            this.A0D.A0A().AGA(this.A05, super.A0A.A11(), false);
        }
        A0W(this.A02, false, i);
    }

    private void A0E(AbstractC1484aS abstractC1484aS) {
        this.A03 = abstractC1484aS;
        this.A0A = abstractC1484aS.A11();
        this.A00 = this.A03.A0C();
        this.A01 = this.A03.A0D();
        List<C1D> listA13 = this.A03.A13();
        List<AdInfo> adInfoList = new ArrayList<>(listA13.size());
        this.A0B = adInfoList;
        int i = 0;
        while (true) {
            int size = listA13.size();
            String[] strArr = A0G;
            String str = strArr[5];
            String str2 = strArr[4];
            int i2 = str.charAt(16);
            if (i2 == str2.charAt(16)) {
                throw new RuntimeException();
            }
            A0G[3] = "1AHb04hcylshFNuVFPVd0IA840Fx90m0";
            if (i < size) {
                C1D c1d = listA13.get(i);
                List<PC> list = this.A0B;
                int i3 = listA13.size();
                list.add(new PC(i, i3, c1d));
                i++;
            } else {
                return;
            }
        }
    }

    private void A0F(S0 s0) {
        new EE().A0G(this.A05);
        s0.A0Z(new C1241Rn(this));
        this.A06 = new C1131Nh(this.A0D, super.A05.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0J);
        layoutParams.setMargins(0, A0K, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1283Td
    public final boolean A0c() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void A9C(Intent intent, Bundle bundle, C5J c5j) {
        AbstractC1484aS dataBundle = A00(intent);
        A0X(c5j);
        A0E(dataBundle);
        A0D(c5j.A0J().getResources().getConfiguration().orientation, bundle);
        c5j.A0N(new C1240Rm(this, c5j));
        AbstractC1484aS dataBundle2 = super.A0A;
        int unskippableSec = dataBundle2.A0v().A0D().A03();
        if (super.A07) {
            AbstractC1484aS dataBundle3 = super.A0A;
            unskippableSec = dataBundle3.A0v().A0D().A02();
        }
        if (unskippableSec > 0) {
            A0V(unskippableSec);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1283Td, com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACJ(boolean z) {
        super.ACJ(z);
        S0 s0 = this.A07;
        if (s0 != null) {
            s0.A0Q();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1283Td, com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void ACj(boolean z) {
        super.ACj(z);
        this.A07.A0R();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void AEt(Bundle bundle) {
        S0 s0 = this.A07;
        if (s0 != null) {
            s0.A0X(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1283Td
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        AEt(bundle);
        A0C();
        A0D(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1283Td, com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final void onDestroy() {
        super.onDestroy();
        if (IP.A1X(this.A0D)) {
            this.A0D.A0A().AFz(this.A05);
        }
        if (!TextUtils.isEmpty(this.A0A)) {
            super.A0C.A9J(this.A0A, new NL().A03(this.A09).A02(this.A0E).A05());
        }
        A0C();
        this.A09.A0V();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0E.A06(this.A0D, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
