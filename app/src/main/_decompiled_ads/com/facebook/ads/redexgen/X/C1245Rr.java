package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1245Rr extends AbstractC06894u implements InterfaceC1094Lw {
    public C1R A00;
    public AbstractC1202Qa A01;
    public C1203Qb A02;
    public C1203Qb A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final YA A06;
    public final C9G A07;

    public C1245Rr(C9G c9g, SparseBooleanArray sparseBooleanArray, C1203Qb c1203Qb, int i, YA ya, C1R c1r) {
        super(c9g);
        this.A06 = ya;
        this.A07 = c9g;
        this.A05 = sparseBooleanArray;
        this.A02 = c1203Qb;
        this.A04 = i;
        this.A00 = c1r;
    }

    private void A0A(InterfaceC1004If interfaceC1004If, LN ln, String str, PC pc) {
        if (this.A05.get(pc.A02())) {
            return;
        }
        C1203Qb c1203Qb = this.A03;
        if (c1203Qb != null) {
            c1203Qb.A0V();
            this.A03 = null;
        }
        this.A01 = new C1247Rt(this, str, pc, interfaceC1004If, pc.A04(), ln);
        C1203Qb c1203Qb2 = new C1203Qb(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03 = c1203Qb2;
        c1203Qb2.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new C1246Rs(this, pc));
    }

    public final void A0l(PC pc, InterfaceC1004If interfaceC1004If, C6Q c6q, LN ln, String str, int i, int i2, int i3) {
        int leftMargin = pc.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(leftMargin));
        this.A07.setupNativeCtaExtension(pc);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i, -2);
        int i4 = leftMargin == 0 ? i3 : i2;
        if (leftMargin < this.A04 - 1) {
            i3 = i2;
        }
        marginLayoutParams.setMargins(i4, 0, i3, 0);
        String strA07 = pc.A03().A0D().A07();
        String strA08 = pc.A03().A0D().A08();
        this.A07.setIsVideo(!TextUtils.isEmpty(strA08));
        if (this.A07.A17()) {
            this.A07.setVideoPlaceholderUrl(strA07);
            this.A07.setVideoUrl(c6q.A0S(strA08));
        } else {
            this.A07.setImageUrl(strA07);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(pc.A03().A0F(), pc.A04());
        this.A07.A18(pc.A04());
        A0A(interfaceC1004If, ln, str, pc);
    }

    public final void A0m(C1203Qb c1203Qb) {
        this.A02 = c1203Qb;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1094Lw
    public final void AF5(NR nr) {
        this.A07.setAdDetailsClickListener(nr);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1094Lw
    public final void AF7() {
        this.A07.A12();
    }
}
