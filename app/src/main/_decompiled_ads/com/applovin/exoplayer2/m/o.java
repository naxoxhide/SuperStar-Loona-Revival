package com.applovin.exoplayer2.m;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class o implements com.applovin.exoplayer2.g {
    public static final o afk = new o(0, 0);
    public static final com.applovin.exoplayer2.g.a<o> br = new com.applovin.exoplayer2.g.a() { // from class: com.applovin.exoplayer2.m.-$$Lambda$o$T89zUQq-To4vaaj-Y2Ec0NOrQaM
        @Override // com.applovin.exoplayer2.g.a
        public final com.applovin.exoplayer2.g fromBundle(Bundle bundle) {
            return o.H(bundle);
        }
    };
    public final int afl;
    public final int dE;
    public final float dH;
    public final int height;

    public o(int i, int i2) {
        this(i, i2, 0, 1.0f);
    }

    public o(int i, int i2, int i3, float f) {
        this.dE = i;
        this.height = i2;
        this.afl = i3;
        this.dH = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.dE == oVar.dE && this.height == oVar.height && this.afl == oVar.afl && this.dH == oVar.dH;
    }

    public int hashCode() {
        return ((((((217 + this.dE) * 31) + this.height) * 31) + this.afl) * 31) + Float.floatToRawIntBits(this.dH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o H(Bundle bundle) {
        return new o(bundle.getInt(t(0), 0), bundle.getInt(t(1), 0), bundle.getInt(t(2), 0), bundle.getFloat(t(3), 1.0f));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
