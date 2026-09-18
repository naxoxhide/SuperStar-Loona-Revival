package com.tapjoy.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class z2 extends u5 {
    public z2() {
        super(3, a3.class);
    }

    @Override // com.tapjoy.internal.u5
    public final void a(w5 w5Var, Object obj) {
        a3 a3Var = (a3) obj;
        String str = a3Var.c;
        if (str != null) {
            u5.k.a(w5Var, 1, str);
        }
        String str2 = a3Var.d;
        if (str2 != null) {
            u5.k.a(w5Var, 2, str2);
        }
        String str3 = a3Var.e;
        if (str3 != null) {
            u5.k.a(w5Var, 3, str3);
        }
        String str4 = a3Var.f;
        if (str4 != null) {
            u5.k.a(w5Var, 4, str4);
        }
        String str5 = a3Var.g;
        if (str5 != null) {
            u5.k.a(w5Var, 5, str5);
        }
        String str6 = a3Var.h;
        if (str6 != null) {
            u5.k.a(w5Var, 6, str6);
        }
        Integer num = a3Var.i;
        if (num != null) {
            u5.e.a(w5Var, 7, num);
        }
        Integer num2 = a3Var.j;
        if (num2 != null) {
            u5.e.a(w5Var, 8, num2);
        }
        Integer num3 = a3Var.k;
        if (num3 != null) {
            u5.e.a(w5Var, 9, num3);
        }
        String str7 = a3Var.l;
        if (str7 != null) {
            u5.k.a(w5Var, 10, str7);
        }
        String str8 = a3Var.m;
        if (str8 != null) {
            u5.k.a(w5Var, 11, str8);
        }
        String str9 = a3Var.n;
        if (str9 != null) {
            u5.k.a(w5Var, 12, str9);
        }
        String str10 = a3Var.o;
        if (str10 != null) {
            u5.k.a(w5Var, 13, str10);
        }
        String str11 = a3Var.p;
        if (str11 != null) {
            u5.k.a(w5Var, 14, str11);
        }
        String str12 = a3Var.q;
        if (str12 != null) {
            u5.k.a(w5Var, 15, str12);
        }
        String str13 = a3Var.r;
        if (str13 != null) {
            u5.k.a(w5Var, 16, str13);
        }
        String str14 = a3Var.s;
        if (str14 != null) {
            u5.k.a(w5Var, 17, str14);
        }
        String str15 = a3Var.t;
        if (str15 != null) {
            u5.k.a(w5Var, 18, str15);
        }
        w5Var.a(a3Var.a());
    }

    @Override // com.tapjoy.internal.u5
    public final int a(Object obj) {
        a3 a3Var = (a3) obj;
        String str = a3Var.c;
        int iA = str != null ? u5.k.a(1, str) : 0;
        String str2 = a3Var.d;
        int iA2 = iA + (str2 != null ? u5.k.a(2, str2) : 0);
        String str3 = a3Var.e;
        int iA3 = iA2 + (str3 != null ? u5.k.a(3, str3) : 0);
        String str4 = a3Var.f;
        int iA4 = iA3 + (str4 != null ? u5.k.a(4, str4) : 0);
        String str5 = a3Var.g;
        int iA5 = iA4 + (str5 != null ? u5.k.a(5, str5) : 0);
        String str6 = a3Var.h;
        int iA6 = iA5 + (str6 != null ? u5.k.a(6, str6) : 0);
        Integer num = a3Var.i;
        int iA7 = iA6 + (num != null ? u5.e.a(7, num) : 0);
        Integer num2 = a3Var.j;
        int iA8 = iA7 + (num2 != null ? u5.e.a(8, num2) : 0);
        Integer num3 = a3Var.k;
        int iA9 = iA8 + (num3 != null ? u5.e.a(9, num3) : 0);
        String str7 = a3Var.l;
        int iA10 = iA9 + (str7 != null ? u5.k.a(10, str7) : 0);
        String str8 = a3Var.m;
        int iA11 = iA10 + (str8 != null ? u5.k.a(11, str8) : 0);
        String str9 = a3Var.n;
        int iA12 = iA11 + (str9 != null ? u5.k.a(12, str9) : 0);
        String str10 = a3Var.o;
        int iA13 = iA12 + (str10 != null ? u5.k.a(13, str10) : 0);
        String str11 = a3Var.p;
        int iA14 = iA13 + (str11 != null ? u5.k.a(14, str11) : 0);
        String str12 = a3Var.q;
        int iA15 = iA14 + (str12 != null ? u5.k.a(15, str12) : 0);
        String str13 = a3Var.r;
        int iA16 = iA15 + (str13 != null ? u5.k.a(16, str13) : 0);
        String str14 = a3Var.s;
        int iA17 = iA16 + (str14 != null ? u5.k.a(17, str14) : 0);
        String str15 = a3Var.t;
        return a3Var.a().b() + iA17 + (str15 != null ? u5.k.a(18, str15) : 0);
    }

    @Override // com.tapjoy.internal.u5
    public final Object a(v5 v5Var) throws IOException {
        g0 g0Var;
        long jB = v5Var.b();
        b0 b0Var = null;
        w5 w5Var = null;
        String strB = null;
        String strB2 = null;
        String strB3 = null;
        String strB4 = null;
        String strB5 = null;
        String strB6 = null;
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        Integer numValueOf3 = null;
        String strB7 = null;
        String strB8 = null;
        String strB9 = null;
        String strB10 = null;
        String strB11 = null;
        String strB12 = null;
        String strB13 = null;
        String strB14 = null;
        String strB15 = null;
        while (true) {
            int iD = v5Var.d();
            String str = strB7;
            if (iD != -1) {
                switch (iD) {
                    case 1:
                        strB = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 2:
                        strB2 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 3:
                        strB3 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 4:
                        strB4 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 5:
                        strB5 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 6:
                        strB6 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 7:
                        numValueOf = Integer.valueOf(v5Var.g());
                        strB7 = str;
                        break;
                    case 8:
                        numValueOf2 = Integer.valueOf(v5Var.g());
                        strB7 = str;
                        break;
                    case 9:
                        numValueOf3 = Integer.valueOf(v5Var.g());
                        strB7 = str;
                        break;
                    case 10:
                        numValueOf3 = numValueOf3;
                        strB7 = ((b0) v5Var.a).b(v5Var.a());
                        numValueOf3 = numValueOf3;
                        break;
                    case 11:
                        strB15 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 12:
                        strB8 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 13:
                        strB9 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 14:
                        strB10 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 15:
                        strB11 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 16:
                        strB12 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 17:
                        strB13 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
                        break;
                    case 18:
                        strB14 = ((b0) v5Var.a).b(v5Var.a());
                        strB7 = str;
                        numValueOf3 = numValueOf3;
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
                            strB7 = str;
                            numValueOf3 = numValueOf3;
                        } catch (IOException unused) {
                            throw new AssertionError();
                        }
                        break;
                }
            } else {
                Integer num = numValueOf3;
                v5Var.a(jB);
                if (b0Var != null) {
                    g0Var = new g0(b0Var.clone().c());
                } else {
                    g0Var = g0.e;
                }
                return new a3(strB, strB2, strB3, strB4, strB5, strB6, numValueOf, numValueOf2, num, str, strB15, strB8, strB9, strB10, strB11, strB12, strB13, strB14, g0Var);
            }
        }
    }
}
