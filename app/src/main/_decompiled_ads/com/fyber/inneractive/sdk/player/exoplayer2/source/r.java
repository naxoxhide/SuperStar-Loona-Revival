package com.fyber.inneractive.sdk.player.exoplayer2.source;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.i[] f1191b;
    public int c;

    public r(com.fyber.inneractive.sdk.player.exoplayer2.i... iVarArr) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(iVarArr.length > 0);
        this.f1191b = iVarArr;
        this.a = iVarArr.length;
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.i a(int i) {
        return this.f1191b[i];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return this.a == rVar.a && Arrays.equals(this.f1191b, rVar.f1191b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = Arrays.hashCode(this.f1191b) + 527;
        }
        return this.c;
    }

    public int a(com.fyber.inneractive.sdk.player.exoplayer2.i iVar) {
        int i = 0;
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.i[] iVarArr = this.f1191b;
            if (i >= iVarArr.length) {
                return -1;
            }
            if (iVar == iVarArr[i]) {
                return i;
            }
            i++;
        }
    }
}
