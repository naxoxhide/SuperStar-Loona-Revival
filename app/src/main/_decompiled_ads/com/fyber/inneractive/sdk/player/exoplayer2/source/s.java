package com.fyber.inneractive.sdk.player.exoplayer2.source;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final s d = new s(new r[0]);
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r[] f1192b;
    public int c;

    public s(r... rVarArr) {
        this.f1192b = rVarArr;
        this.a = rVarArr.length;
    }

    public int a(r rVar) {
        for (int i = 0; i < this.a; i++) {
            if (this.f1192b[i] == rVar) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        return this.a == sVar.a && Arrays.equals(this.f1192b, sVar.f1192b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f1192b);
        }
        return this.c;
    }
}
