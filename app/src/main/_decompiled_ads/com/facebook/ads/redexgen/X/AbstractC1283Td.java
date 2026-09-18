package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Td, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1283Td extends RelativeLayout implements InterfaceC1092Lu {
    public static byte[] A0F;
    public static String[] A0G = {"fqT9snXDZkE2N6bIU2twhbCcrvrF5wQR", "W8MK3buqarkLhDixdfnbfGeXuw3i87xB", "M5iWaw3OwwKxChS5bTa9KUrj63pwu1Od", "QKu8TlGQ3D7NsDDaY", "OUnrWL6BanKvWJF", "644mHU9zQQHAcSiNB", "MqQzuM0GD0HqxOL2854PPJvoiao7nama", "mSpdOD621tCilusEUOf234Jx9LR3KzyX"};
    public View A00;
    public C1061Kn A01;
    public P3 A02;
    public boolean A03;
    public boolean A04;
    public AnonymousClass19 A05;
    public PU A06;
    public boolean A07;
    public final LI A08;
    public final InterfaceC1091Lt A09;
    public final AbstractC1484aS A0A;
    public final YA A0B;
    public final InterfaceC1004If A0C;
    public final C1012In A0D;
    public final AbstractC1090Ls A0E;

    public static String A0N(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0Q() {
        A0F = new byte[]{88, 84, 86, 21, 93, 90, 88, 94, 89, 84, 84, 80, 21, 90, 95, 72, 21, 82, 85, 79, 94, 73, 72, 79, 82, 79, 82, 90, 87, 21, 82, 86, 75, 73, 94, 72, 72, 82, 84, 85, 21, 87, 84, 92, 92, 94, 95};
    }

    public abstract boolean A0c();

    public abstract int getCloseButtonStyle();

    static {
        A0Q();
    }

    public AbstractC1283Td(YA ya, InterfaceC1004If interfaceC1004If, InterfaceC1091Lt interfaceC1091Lt, AbstractC1484aS abstractC1484aS) {
        super(ya);
        this.A07 = false;
        this.A04 = false;
        this.A03 = false;
        this.A0B = ya;
        this.A0C = interfaceC1004If;
        this.A09 = interfaceC1091Lt;
        this.A08 = new LI(this);
        this.A0A = abstractC1484aS;
        C1012In c1012In = new C1012In(abstractC1484aS.A11(), interfaceC1004If);
        this.A0D = c1012In;
        this.A0E = new FullScreenAdToolbar(ya, getAudienceNetworkListener(), c1012In, 0, abstractC1484aS.A0p());
    }

    private C1M A0L(int i) {
        if (i == 1) {
            return this.A05.A01();
        }
        AnonymousClass19 anonymousClass19 = this.A05;
        if (A0G[2].charAt(7) != 'O') {
            throw new RuntimeException();
        }
        A0G[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        return anonymousClass19.A00();
    }

    private void A0O() {
        removeAllViews();
        LV.A0J(this);
    }

    private void A0P() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (A0Z() && this.A02 == null) {
            this.A04 = true;
            P3 p3A0B = new P1(this.A0B, this.A0A.A0v().A0E(), this.A0A.A0z()).A08(this.A0A.A0u().A01()).A0B();
            this.A02 = p3A0B;
            C1014Ip.A04(p3A0B, this.A0D, EnumC1011Im.A0U);
            this.A09.A3P(this, 0, layoutParams);
            this.A09.A3P(this.A02, 1, layoutParams);
            this.A02.A04(new C1285Tf(this));
            return;
        }
        this.A09.A3P(this, 0, layoutParams);
    }

    private void A0R(C1M c1m, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0E.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0E.A06(c1m, T3.A08(this.A0A));
        addView(this.A0E, layoutParams);
    }

    public final void A0U() {
        View view = this.A00;
        if (view == null || !(view instanceof AbstractC1145Nv)) {
            return;
        }
        if (A0a()) {
            ((AbstractC1145Nv) this.A00).A0y();
        } else {
            ((AbstractC1145Nv) this.A00).A0x();
        }
    }

    public final void A0V(int i) {
        this.A01 = new C1061Kn(i, new C1284Te(this, i));
        this.A03 = true;
        A0U();
        this.A01.A08();
    }

    public final void A0W(View view, boolean z, int i) {
        this.A0E.setFullscreen(z);
        this.A00 = view;
        this.A08.A05(LH.A03);
        A0O();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z ? 0 : this.A0E.getToolbarHeight(), 0, 0);
        layoutParams.addRule(12);
        addView(view, layoutParams);
        C1M c1mA0L = A0L(i);
        A0R(c1mA0L, z);
        LV.A0M(this, c1mA0L.A07(false));
        if (this.A09 != null) {
            A0P();
            String[] strArr = A0G;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0G[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            if (z && Build.VERSION.SDK_INT >= 19) {
                LI li = this.A08;
                if (A0G[0].charAt(10) == 'o') {
                    throw new RuntimeException();
                }
                A0G[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                li.A05(LH.A04);
            }
        }
    }

    public final void A0X(C5J c5j) {
        this.A08.A04(c5j.A0J().getWindow());
        this.A05 = this.A0A.A0u();
        C1D c1dA0v = null;
        C1D adInfo = this.A0A.A0v();
        if (adInfo != null) {
            C1D adInfo2 = this.A0A.A0v();
            if (adInfo2 != null) {
                c1dA0v = this.A0A.A0v();
            }
        }
        this.A0E.setPageDetails(this.A0A.A0z(), this.A0A.A11(), c1dA0v != null ? c1dA0v.A0D().A03() : 0, this.A0A.A10());
        this.A0E.setToolbarListener(new C1287Th(this, c5j));
    }

    public final void A0Y(C5J c5j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new M1(this, this, c5j));
        startAnimation(alphaAnimation);
    }

    public final boolean A0Z() {
        if (!this.A0A.A13().isEmpty()) {
            boolean zA0P = this.A0A.A0v().A0P();
            if (A0G[6].charAt(3) != 'z') {
                throw new RuntimeException();
            }
            A0G[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            if (zA0P) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0a() {
        return this.A03;
    }

    public final boolean A0b() {
        return this.A04;
    }

    public void ACJ(boolean z) {
        C1061Kn c1061Kn = this.A01;
        if (c1061Kn != null && c1061Kn.A06()) {
            this.A01.A07();
        }
    }

    public void ACj(boolean z) {
        C1061Kn c1061Kn = this.A01;
        if (c1061Kn != null && !c1061Kn.A05()) {
            this.A01.A08();
        }
    }

    public InterfaceC1004If getAdEventManager() {
        return this.A0C;
    }

    public InterfaceC1091Lt getAudienceNetworkListener() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public String getCurrentClientToken() {
        return this.A0A.A11();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1092Lu
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public void onDestroy() {
        this.A08.A03();
        this.A0E.setToolbarListener(null);
        A0O();
    }

    public void setImpressionRecordingFlag(LN ln) {
        ln.A05();
        if (getAudienceNetworkListener() != null) {
            if (this.A07) {
                getAudienceNetworkListener().A3z(new TQ().A74());
            } else {
                getAudienceNetworkListener().A3z(A0N(0, 47, 106));
            }
        }
    }

    public void setListener(InterfaceC1091Lt interfaceC1091Lt) {
    }

    public void setServerSideRewardHandler(PU pu) {
        this.A06 = pu;
    }
}
