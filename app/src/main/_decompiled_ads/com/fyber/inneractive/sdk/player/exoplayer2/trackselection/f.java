package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e[] f1198b;
    public int c;

    public f(e... eVarArr) {
        this.f1198b = eVarArr;
        this.a = eVarArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f1198b, ((f) obj).f1198b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f1198b) + 527;
        }
        return this.c;
    }
}
