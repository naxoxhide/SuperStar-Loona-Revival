package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1253Rz extends C4Q<C1245Rr> {
    public int A00;
    public int A01;
    public int A02;
    public AbstractC1090Ls A03;
    public InterfaceC1091Lt A04;
    public String A05;
    public List<PC> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC1484aS A08;
    public final C6Q A09;
    public final YA A0A;
    public final InterfaceC1004If A0B;
    public final LN A0C;
    public final S0 A0D;
    public final C1026Jb A0E;
    public final C1203Qb A0F;

    public C1253Rz(YA ya, List<PC> list, AbstractC1484aS abstractC1484aS, InterfaceC1004If interfaceC1004If, C6Q c6q, C1203Qb c1203Qb, LN ln, InterfaceC1091Lt interfaceC1091Lt, String str, S0 s0, C1026Jb c1026Jb, AbstractC1090Ls abstractC1090Ls) {
        this.A0A = ya;
        this.A0B = interfaceC1004If;
        this.A09 = c6q;
        this.A0F = c1203Qb;
        this.A0C = ln;
        this.A04 = interfaceC1091Lt;
        this.A08 = abstractC1484aS;
        this.A06 = list;
        this.A05 = str;
        this.A0D = s0;
        this.A0E = c1026Jb;
        this.A03 = abstractC1090Ls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C1245Rr A0C(ViewGroup viewGroup, int i) {
        InterfaceC1091Lt interfaceC1091Lt = this.A04;
        if (interfaceC1091Lt == null || this.A00 == 0) {
            return null;
        }
        return new C1245Rr(NX.A01(new C1148Ny(this.A0A, this.A0B, interfaceC1091Lt, this.A08, null, this.A0F, this.A0C).A0I(this.A0E).A0H(this.A03).A0K(), this.A05, this.A0D), this.A07, this.A0F, this.A06.size(), this.A0A, this.A08.A0x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4Q
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A0E(C1245Rr c1245Rr, int i) {
        c1245Rr.A0l(this.A06.get(i), this.A0B, this.A09, this.A0C, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.C4Q
    public final int A0D() {
        return this.A06.size();
    }

    public final void A0F(int i, int i2, int i3) {
        this.A00 = i;
        this.A02 = i2;
        this.A01 = i3;
    }
}
