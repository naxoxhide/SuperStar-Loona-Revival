package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class a3 extends q4 {
    public static final z2 u = new z2();
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final Integer j;
    public final Integer k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;

    public a3(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, g0 g0Var) {
        super(u, g0Var);
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = num;
        this.j = num2;
        this.k = num3;
        this.l = str7;
        this.m = str8;
        this.n = str9;
        this.o = str10;
        this.p = str11;
        this.q = str12;
        this.r = str13;
        this.s = str14;
        this.t = str15;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a3)) {
            return false;
        }
        a3 a3Var = (a3) obj;
        return a().equals(a3Var.a()) && i3.a(this.c, a3Var.c) && i3.a(this.d, a3Var.d) && i3.a(this.e, a3Var.e) && i3.a(this.f, a3Var.f) && i3.a(this.g, a3Var.g) && i3.a(this.h, a3Var.h) && i3.a(this.i, a3Var.i) && i3.a(this.j, a3Var.j) && i3.a(this.k, a3Var.k) && i3.a(this.l, a3Var.l) && i3.a(this.m, a3Var.m) && i3.a(this.n, a3Var.n) && i3.a(this.o, a3Var.o) && i3.a(this.p, a3Var.p) && i3.a(this.q, a3Var.q) && i3.a(this.r, a3Var.r) && i3.a(this.s, a3Var.s) && i3.a(this.t, a3Var.t);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.f;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.g;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.h;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.i;
        int iHashCode8 = (iHashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.j;
        int iHashCode9 = (iHashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.k;
        int iHashCode10 = (iHashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str7 = this.l;
        int iHashCode11 = (iHashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.m;
        int iHashCode12 = (iHashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.n;
        int iHashCode13 = (iHashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.o;
        int iHashCode14 = (iHashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.p;
        int iHashCode15 = (iHashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.q;
        int iHashCode16 = (iHashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.r;
        int iHashCode17 = (iHashCode16 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.s;
        int iHashCode18 = (iHashCode17 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.t;
        int iHashCode19 = iHashCode18 + (str15 != null ? str15.hashCode() : 0);
        this.f2802b = iHashCode19;
        return iHashCode19;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append(", mac=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", deviceId=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", deviceMaker=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", deviceModel=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", osName=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", osVer=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", displayD=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", displayW=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", displayH=").append(this.k);
        }
        if (this.l != null) {
            sb.append(", locale=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", timezone=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", pkgId=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", pkgSign=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", sdk=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", countrySim=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", countryNet=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", imei=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", androidId=").append(this.t);
        }
        return sb.replace(0, 2, "Info{").append('}').toString();
    }
}
