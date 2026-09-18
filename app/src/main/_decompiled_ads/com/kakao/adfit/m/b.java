package com.kakao.adfit.m;

import android.text.TextUtils;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1850b;

    public b(String str, String str2) {
        this.a = str;
        this.f1850b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f1850b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.a, bVar.a) && TextUtils.equals(this.f1850b, bVar.f1850b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f1850b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.a + ",value=" + this.f1850b + "]";
    }
}
