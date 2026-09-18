package com.tapjoy.internal;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ra extends q4 {
    public static final qa x = new qa();
    public static final Boolean y = Boolean.FALSE;
    public final Long c;
    public final String d;
    public final Integer e;
    public final Integer f;
    public final List g;
    public final Integer h;
    public final Long i;
    public final Long j;
    public final Long k;
    public final Long l;
    public final String m;
    public final Integer n;
    public final Double o;
    public final Long p;
    public final Double q;
    public final String r;
    public final Boolean s;
    public final String t;
    public final Integer u;
    public final List v;
    public final Boolean w;

    public ra(Long l, String str, Integer num, Integer num2, r4 r4Var, Integer num3, Long l2, Long l3, Long l4, Long l5, String str2, Integer num4, Double d, Long l6, Double d2, String str3, Boolean bool, String str4, Integer num5, r4 r4Var2, Boolean bool2, g0 g0Var) {
        super(x, g0Var);
        this.c = l;
        this.d = str;
        this.e = num;
        this.f = num2;
        this.g = i3.a("pushes", (AbstractList) r4Var);
        this.h = num3;
        this.i = l2;
        this.j = l3;
        this.k = l5;
        this.l = l4;
        this.m = str2;
        this.n = num4;
        this.o = d;
        this.p = l6;
        this.q = d2;
        this.r = str3;
        this.s = bool;
        this.t = str4;
        this.u = num5;
        this.v = i3.a("tags", (AbstractList) r4Var2);
        this.w = bool2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ra)) {
            return false;
        }
        ra raVar = (ra) obj;
        return a().equals(raVar.a()) && i3.a(this.c, raVar.c) && i3.a(this.d, raVar.d) && i3.a(this.e, raVar.e) && i3.a(this.f, raVar.f) && this.g.equals(raVar.g) && i3.a(this.h, raVar.h) && i3.a(this.i, raVar.i) && i3.a(this.j, raVar.j) && i3.a(this.k, raVar.k) && i3.a(this.l, raVar.l) && i3.a(this.m, raVar.m) && i3.a(this.n, raVar.n) && i3.a(this.o, raVar.o) && i3.a(this.p, raVar.p) && i3.a(this.q, raVar.q) && i3.a(this.r, raVar.r) && i3.a(this.s, raVar.s) && i3.a(this.t, raVar.t) && i3.a(this.u, raVar.u) && this.v.equals(raVar.v) && i3.a(this.w, raVar.w);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Long l = this.c;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.d;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.e;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f;
        int iHashCode5 = (this.g.hashCode() + ((iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37)) * 37;
        Integer num3 = this.h;
        int iHashCode6 = (iHashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.i;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.j;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.k;
        int iHashCode9 = (iHashCode8 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.l;
        int iHashCode10 = (iHashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str2 = this.m;
        int iHashCode11 = (iHashCode10 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.n;
        int iHashCode12 = (iHashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Double d = this.o;
        int iHashCode13 = (iHashCode12 + (d != null ? d.hashCode() : 0)) * 37;
        Long l6 = this.p;
        int iHashCode14 = (iHashCode13 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Double d2 = this.q;
        int iHashCode15 = (iHashCode14 + (d2 != null ? d2.hashCode() : 0)) * 37;
        String str3 = this.r;
        int iHashCode16 = (iHashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.s;
        int iHashCode17 = (iHashCode16 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.t;
        int iHashCode18 = (iHashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num5 = this.u;
        int iHashCode19 = (this.v.hashCode() + ((iHashCode18 + (num5 != null ? num5.hashCode() : 0)) * 37)) * 37;
        Boolean bool2 = this.w;
        int iHashCode20 = iHashCode19 + (bool2 != null ? bool2.hashCode() : 0);
        this.f2802b = iHashCode20;
        return iHashCode20;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append(", installed=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", referrer=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", fq7=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", fq30=").append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", pushes=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", sessionTotalCount=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", sessionTotalDuration=").append(this.i);
        }
        if (this.k != null) {
            sb.append(", sessionStartTime=").append(this.k);
        }
        if (this.j != null) {
            sb.append(", sessionLastTime=").append(this.j);
        }
        if (this.l != null) {
            sb.append(", sessionLastDuration=").append(this.l);
        }
        if (this.m != null) {
            sb.append(", purchaseCurrency=").append(this.m);
        }
        if (this.n != null) {
            sb.append(", purchaseTotalCount=").append(this.n);
        }
        if (this.o != null) {
            sb.append(", purchaseTotalPrice=").append(this.o);
        }
        if (this.p != null) {
            sb.append(", purchaseLastTime=").append(this.p);
        }
        if (this.q != null) {
            sb.append(", purchaseLastPrice=").append(this.q);
        }
        if (this.r != null) {
            sb.append(", idfa=").append(this.r);
        }
        if (this.s != null) {
            sb.append(", idfaOptout=").append(this.s);
        }
        if (this.t != null) {
            sb.append(", userId=").append(this.t);
        }
        if (this.u != null) {
            sb.append(", userLevel=").append(this.u);
        }
        if (!this.v.isEmpty()) {
            sb.append(", tags=").append(this.v);
        }
        if (this.w != null) {
            sb.append(", pushOptout=").append(this.w);
        }
        return sb.replace(0, 2, "User{").append('}').toString();
    }
}
