package com.tapjoy.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class p extends q4 {
    public static final o g = new o();
    public final String c;
    public final Integer d;
    public final String e;
    public final String f;

    public p(String str, Integer num, String str2, String str3, g0 g0Var) {
        super(g, g0Var);
        this.c = str;
        this.d = num;
        this.e = str2;
        this.f = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return a().equals(pVar.a()) && i3.a(this.c, pVar.c) && i3.a(this.d, pVar.d) && i3.a(this.e, pVar.e) && i3.a(this.f, pVar.f);
    }

    public final int hashCode() {
        int i = this.f2802b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.d;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.e;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f;
        int iHashCode5 = iHashCode4 + (str3 != null ? str3.hashCode() : 0);
        this.f2802b = iHashCode5;
        return iHashCode5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.c != null) {
            sb.append(", pkgVer=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", pkgRev=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", installer=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", store=").append(this.f);
        }
        return sb.replace(0, 2, "App{").append('}').toString();
    }
}
