package com.mbridge.msdk.foundation.same.net.c;

import android.text.TextUtils;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2129b;

    public b(String str, String str2) {
        this.a = str;
        this.f2129b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f2129b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.a, bVar.a) && TextUtils.equals(this.f2129b, bVar.f2129b);
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.f2129b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.a + ",value=" + this.f2129b + "]";
    }
}
