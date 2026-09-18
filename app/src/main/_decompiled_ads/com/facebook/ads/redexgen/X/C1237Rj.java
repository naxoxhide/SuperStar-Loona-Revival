package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1237Rj extends AbstractC06894u implements InterfaceC1094Lw {
    public static String[] A0B = {"av2tITPhYKbVn20ukUfJR25ELbcgjHbj", "MLeLe181lhP7dC21QqjxU1VDKV9lNkzJ", "XUmY4VBJ2tlJWKlPJ7YkBdCsKtcC", "bK6oHsXedskfaWsjnVeS6YyvP0sRA20b", "BhCeFQN4dHt9z3MLE3p7bnIzhrf86Cw8", "mLW9T0fP2Q5Hob07hRXsv0QUH1fN4", "pNzPXZ5fcby2PvmlRsfUzns43oHDF5Mi", "3YktW7BrcDIc4Xw2f2zdWv5xFETbHIAE"};
    public C1R A00;
    public AbstractC1202Qa A01;
    public C1203Qb A02;
    public C1203Qb A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final SparseBooleanArray A08;
    public final YA A09;
    public final AnonymousClass97 A0A;

    public C1237Rj(AnonymousClass97 anonymousClass97, SparseBooleanArray sparseBooleanArray, C1203Qb c1203Qb, int i, int i2, int i3, int i4, YA ya, C1R c1r) {
        super(anonymousClass97);
        this.A09 = ya;
        this.A0A = anonymousClass97;
        this.A08 = sparseBooleanArray;
        this.A02 = c1203Qb;
        this.A04 = i;
        this.A05 = i2;
        this.A06 = i3;
        this.A07 = i4;
        this.A00 = c1r;
    }

    private void A0A(InterfaceC1004If interfaceC1004If, LN ln, String str, PC pc) {
        if (this.A08.get(pc.A02())) {
            return;
        }
        C1203Qb c1203Qb = this.A03;
        if (c1203Qb != null) {
            c1203Qb.A0V();
            if (A0B[4].charAt(16) != 'E') {
                throw new RuntimeException();
            }
            A0B[4] = "iteeE4SnfkkyQnEAEqI0za4snrHpWaXy";
            this.A03 = null;
        }
        this.A01 = new C1239Rl(this, str, pc, interfaceC1004If, pc.A04(), ln);
        C1203Qb c1203Qb2 = new C1203Qb(this.A0A, 10, new WeakReference(this.A01), this.A09);
        this.A03 = c1203Qb2;
        c1203Qb2.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A0A.setOnAssetsLoadedListener(new C1238Rk(this, pc));
    }

    public final void A0l(PC pc, InterfaceC1004If interfaceC1004If, C6Q c6q, LN ln, String str) {
        int iA02 = pc.A02();
        this.A0A.setTag(-1593835536, Integer.valueOf(iA02));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.A04, -2);
        int rightMargin = iA02 == 0 ? this.A05 : this.A06;
        int position = this.A07;
        marginLayoutParams.setMargins(rightMargin, 0, iA02 >= position + (-1) ? this.A05 : this.A06, 0);
        String imageUrl = pc.A03().A0D().A07();
        String strA08 = pc.A03().A0D().A08();
        this.A0A.setIsVideo(!TextUtils.isEmpty(strA08));
        if (this.A0A.A17()) {
            this.A0A.setVideoPlaceholderUrl(imageUrl);
            this.A0A.setVideoUrl(c6q.A0S(strA08));
        } else {
            this.A0A.setImageUrl(imageUrl);
        }
        this.A0A.setLayoutParams(marginLayoutParams);
        this.A0A.setAdTitleAndDescription(pc.A03().A0E().A06(), pc.A03().A0E().A01());
        this.A0A.setCTAInfo(pc.A03().A0F(), pc.A04());
        this.A0A.A19(pc.A04());
        A0A(interfaceC1004If, ln, str, pc);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1094Lw
    public final void AF5(NR nr) {
        this.A0A.setAdDetailsClickListener(nr);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1094Lw
    public final void AF7() {
        this.A0A.A12();
    }
}
