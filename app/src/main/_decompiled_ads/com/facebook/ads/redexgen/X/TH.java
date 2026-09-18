package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TH extends C4Q<C1245Rr> {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC1091Lt A03;
    public C1203Qb A04;
    public String A05;
    public List<PC> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1484aS A08;
    public final C6Q A09;
    public final YA A0A;
    public final InterfaceC1004If A0B;
    public final UJ A0C;
    public final LN A0D;
    public final C07969j A0E;
    public final C1026Jb A0F;

    public TH(YA ya, List<PC> list, AbstractC1484aS abstractC1484aS, InterfaceC1004If interfaceC1004If, UJ uj, InterfaceC1091Lt interfaceC1091Lt, String str, C07969j c07969j, C1026Jb c1026Jb) {
        this.A0A = ya;
        this.A0B = interfaceC1004If;
        this.A0C = uj;
        this.A09 = uj.A10();
        this.A04 = uj.A1A();
        this.A0D = uj.A19();
        this.A03 = interfaceC1091Lt;
        this.A08 = abstractC1484aS;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c07969j;
        this.A0F = c1026Jb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1245Rr A0C(ViewGroup viewGroup, int i) {
        return new C1245Rr(NX.A00(new C1148Ny(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0I(this.A0F).A0G(this.A0C).A0K(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A0x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0E(C1245Rr c1245Rr, int i) {
        PC pc = this.A06.get(i);
        c1245Rr.A0m(this.A04);
        c1245Rr.A0l(pc, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.C4Q
    public final int A0D() {
        return this.A06.size();
    }

    public final void A0F(int i, int i2, int i3) {
        boolean needsUpdate = i != this.A00;
        this.A00 = i;
        this.A02 = i2;
        this.A01 = i3;
        if (needsUpdate) {
            A06();
        }
    }

    public final void A0G(C1203Qb c1203Qb) {
        this.A04 = c1203Qb;
    }
}
