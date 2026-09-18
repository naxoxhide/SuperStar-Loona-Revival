package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ny, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1148Ny {
    public boolean A00;
    public View A03;
    public UJ A04;
    public AbstractC1090Ls A05;
    public C1026Jb A06;
    public final View A07;
    public final AbstractC1484aS A08;
    public final YA A09;
    public final InterfaceC1004If A0A;
    public final LN A0B;
    public final InterfaceC1091Lt A0C;
    public final C1203Qb A0D;
    public int A02 = 0;
    public int A01 = 1;

    public C1148Ny(YA ya, InterfaceC1004If interfaceC1004If, InterfaceC1091Lt interfaceC1091Lt, AbstractC1484aS abstractC1484aS, View view, C1203Qb c1203Qb, LN ln) {
        this.A09 = ya;
        this.A0A = interfaceC1004If;
        this.A0C = interfaceC1091Lt;
        this.A08 = abstractC1484aS;
        this.A07 = view;
        this.A0D = c1203Qb;
        this.A0B = ln;
    }

    public final C1148Ny A0D(int i) {
        this.A01 = i;
        return this;
    }

    public final C1148Ny A0E(int i) {
        this.A02 = i;
        return this;
    }

    public final C1148Ny A0F(View view) {
        this.A03 = view;
        return this;
    }

    public final C1148Ny A0G(UJ uj) {
        this.A04 = uj;
        return this;
    }

    public final C1148Ny A0H(AbstractC1090Ls abstractC1090Ls) {
        this.A05 = abstractC1090Ls;
        return this;
    }

    public final C1148Ny A0I(C1026Jb c1026Jb) {
        this.A06 = c1026Jb;
        return this;
    }

    public final C1148Ny A0J(boolean z) {
        this.A00 = z;
        return this;
    }

    public final C1149Nz A0K() {
        return new C1149Nz(this);
    }
}
