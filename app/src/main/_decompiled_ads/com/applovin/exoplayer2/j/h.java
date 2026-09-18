package com.applovin.exoplayer2.j;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private final g[] Vc;
    private int dS;
    public final int fR;

    public h(g... gVarArr) {
        this.Vc = gVarArr;
        this.fR = gVarArr.length;
    }

    public g eU(int i) {
        return this.Vc[i];
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = 527 + Arrays.hashCode(this.Vc);
        }
        return this.dS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.Vc, ((h) obj).Vc);
    }
}
