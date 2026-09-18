package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class qa extends u5 {
    public qa() {
        super(3, ra.class);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        Long l;
        r4 r4VarA = i3.a();
        r4 r4VarA2 = i3.a();
        long jB = v5Var.b();
        Long lValueOf = null;
        String strB = null;
        b0 b0Var = null;
        Integer numValueOf = null;
        w5 w5Var = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        Long lValueOf4 = null;
        String strB2 = null;
        Integer numValueOf4 = null;
        Double dValueOf = null;
        Long lValueOf5 = null;
        Double dValueOf2 = null;
        String strB3 = null;
        Boolean bool = null;
        String strB4 = null;
        Integer numValueOf5 = null;
        Boolean bool2 = null;
        Long lValueOf6 = null;
        while (true) {
            int iD = v5Var.d();
            Long l2 = lValueOf4;
            if (iD == -1) {
                Long l3 = lValueOf3;
                v5Var.a(jB);
                return new ra(lValueOf, strB, numValueOf, numValueOf2, r4VarA, numValueOf3, lValueOf2, l3, l2, lValueOf6, strB2, numValueOf4, dValueOf, lValueOf5, dValueOf2, strB3, bool, strB4, numValueOf5, r4VarA2, bool2, b0Var != null ? new g0(b0Var.clone().c()) : g0.e);
            }
            switch (iD) {
                case 1:
                    l = lValueOf3;
                    lValueOf = Long.valueOf(v5Var.h());
                    lValueOf4 = l2;
                    lValueOf3 = l;
                    break;
                case 2:
                    l = lValueOf3;
                    strB = ((b0) v5Var.a).b(v5Var.a());
                    lValueOf4 = l2;
                    lValueOf3 = l;
                    break;
                case 3:
                    l = lValueOf3;
                    numValueOf4 = Integer.valueOf(v5Var.g());
                    lValueOf4 = l2;
                    lValueOf3 = l;
                    break;
                case 4:
                    l = lValueOf3;
                    lValueOf5 = Long.valueOf(v5Var.h());
                    lValueOf4 = l2;
                    lValueOf3 = l;
                    break;
                case 5:
                    l = lValueOf3;
                    strB4 = ((b0) v5Var.a).b(v5Var.a());
                    lValueOf4 = l2;
                    lValueOf3 = l;
                    break;
                case 6:
                    numValueOf5 = Integer.valueOf(v5Var.g());
                    lValueOf4 = l2;
                    break;
                default:
                    l = lValueOf3;
                    switch (iD) {
                        case 13:
                            numValueOf = Integer.valueOf(v5Var.g());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 14:
                            numValueOf2 = Integer.valueOf(v5Var.g());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 15:
                            r4VarA.add((c6) c6.f.a(v5Var));
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 16:
                            numValueOf3 = Integer.valueOf(v5Var.g());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 17:
                            lValueOf2 = Long.valueOf(v5Var.h());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 18:
                            lValueOf3 = Long.valueOf(v5Var.h());
                            lValueOf4 = l2;
                            break;
                        case 19:
                            lValueOf4 = Long.valueOf(v5Var.h());
                            lValueOf3 = l;
                            break;
                        case 20:
                            strB2 = ((b0) v5Var.a).b(v5Var.a());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 21:
                            dValueOf = Double.valueOf(Double.longBitsToDouble(v5Var.f()));
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 22:
                            dValueOf2 = Double.valueOf(Double.longBitsToDouble(v5Var.f()));
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 23:
                            strB3 = ((b0) v5Var.a).b(v5Var.a());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 24:
                            bool = (Boolean) u5.d.a(v5Var);
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 25:
                            bool2 = (Boolean) u5.d.a(v5Var);
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 26:
                            r4VarA2.add(((b0) v5Var.a).b(v5Var.a()));
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        case 27:
                            lValueOf6 = Long.valueOf(v5Var.h());
                            lValueOf4 = l2;
                            lValueOf3 = l;
                            break;
                        default:
                            int i = v5Var.h;
                            Object objA = s1.a(i).a(v5Var);
                            if (w5Var == null) {
                                b0Var = new b0();
                                w5Var = new w5(b0Var);
                            }
                            try {
                                s1.a(i).a(w5Var, iD, objA);
                                lValueOf4 = l2;
                                lValueOf3 = l;
                            } catch (IOException unused) {
                                throw new AssertionError();
                            }
                            break;
                    }
                    break;
            }
        }
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        ra raVar = (ra) obj;
        Long l = raVar.c;
        if (l != null) {
            u5.g.a(w5Var, 1, l);
        }
        String str = raVar.d;
        if (str != null) {
            u5.k.a(w5Var, 2, str);
        }
        Integer num = raVar.e;
        if (num != null) {
            u5.e.a(w5Var, 13, num);
        }
        Integer num2 = raVar.f;
        if (num2 != null) {
            u5.e.a(w5Var, 14, num2);
        }
        c6.f.a().a(w5Var, 15, raVar.g);
        Integer num3 = raVar.h;
        if (num3 != null) {
            u5.e.a(w5Var, 16, num3);
        }
        Long l2 = raVar.i;
        if (l2 != null) {
            u5.g.a(w5Var, 17, l2);
        }
        Long l3 = raVar.j;
        if (l3 != null) {
            u5.g.a(w5Var, 18, l3);
        }
        Long l4 = raVar.k;
        if (l4 != null) {
            u5.g.a(w5Var, 27, l4);
        }
        Long l5 = raVar.l;
        if (l5 != null) {
            u5.g.a(w5Var, 19, l5);
        }
        String str2 = raVar.m;
        if (str2 != null) {
            u5.k.a(w5Var, 20, str2);
        }
        Integer num4 = raVar.n;
        if (num4 != null) {
            u5.e.a(w5Var, 3, num4);
        }
        Double d = raVar.o;
        if (d != null) {
            u5.j.a(w5Var, 21, d);
        }
        Long l6 = raVar.p;
        if (l6 != null) {
            u5.g.a(w5Var, 4, l6);
        }
        Double d2 = raVar.q;
        if (d2 != null) {
            u5.j.a(w5Var, 22, d2);
        }
        String str3 = raVar.r;
        if (str3 != null) {
            u5.k.a(w5Var, 23, str3);
        }
        Boolean bool = raVar.s;
        if (bool != null) {
            u5.d.a(w5Var, 24, bool);
        }
        String str4 = raVar.t;
        if (str4 != null) {
            u5.k.a(w5Var, 5, str4);
        }
        Integer num5 = raVar.u;
        if (num5 != null) {
            u5.e.a(w5Var, 6, num5);
        }
        u5.k.a().a(w5Var, 26, raVar.v);
        Boolean bool2 = raVar.w;
        if (bool2 != null) {
            u5.d.a(w5Var, 25, bool2);
        }
        w5Var.a(raVar.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        ra raVar = (ra) obj;
        Long l = raVar.c;
        int iA = l != null ? u5.g.a(1, l) : 0;
        String str = raVar.d;
        int iA2 = iA + (str != null ? u5.k.a(2, str) : 0);
        Integer num = raVar.e;
        int iA3 = iA2 + (num != null ? u5.e.a(13, num) : 0);
        Integer num2 = raVar.f;
        int iA4 = c6.f.a().a(15, raVar.g) + iA3 + (num2 != null ? u5.e.a(14, num2) : 0);
        Integer num3 = raVar.h;
        int iA5 = iA4 + (num3 != null ? u5.e.a(16, num3) : 0);
        Long l2 = raVar.i;
        int iA6 = iA5 + (l2 != null ? u5.g.a(17, l2) : 0);
        Long l3 = raVar.j;
        int iA7 = iA6 + (l3 != null ? u5.g.a(18, l3) : 0);
        Long l4 = raVar.k;
        int iA8 = iA7 + (l4 != null ? u5.g.a(27, l4) : 0);
        Long l5 = raVar.l;
        int iA9 = iA8 + (l5 != null ? u5.g.a(19, l5) : 0);
        String str2 = raVar.m;
        int iA10 = iA9 + (str2 != null ? u5.k.a(20, str2) : 0);
        Integer num4 = raVar.n;
        int iA11 = iA10 + (num4 != null ? u5.e.a(3, num4) : 0);
        Double d = raVar.o;
        int iA12 = iA11 + (d != null ? u5.j.a(21, d) : 0);
        Long l6 = raVar.p;
        int iA13 = iA12 + (l6 != null ? u5.g.a(4, l6) : 0);
        Double d2 = raVar.q;
        int iA14 = iA13 + (d2 != null ? u5.j.a(22, d2) : 0);
        String str3 = raVar.r;
        int iA15 = iA14 + (str3 != null ? u5.k.a(23, str3) : 0);
        Boolean bool = raVar.s;
        int iA16 = iA15 + (bool != null ? u5.d.a(24, bool) : 0);
        String str4 = raVar.t;
        int iA17 = iA16 + (str4 != null ? u5.k.a(5, str4) : 0);
        Integer num5 = raVar.u;
        int iA18 = u5.k.a().a(26, raVar.v) + iA17 + (num5 != null ? u5.e.a(6, num5) : 0);
        Boolean bool2 = raVar.w;
        return raVar.a().b() + iA18 + (bool2 != null ? u5.d.a(25, bool2) : 0);
    }
}
