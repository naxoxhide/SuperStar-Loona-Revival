package com.mbridge.msdk.e.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2026b;

    public g(String str, String str2) {
        this.a = str;
        this.f2026b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f2026b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.a, gVar.a) && TextUtils.equals(this.f2026b, gVar.f2026b);
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.f2026b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.a + ",value=" + this.f2026b + "]";
    }
}
