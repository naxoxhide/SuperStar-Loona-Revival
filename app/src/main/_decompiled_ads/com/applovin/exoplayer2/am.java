package com.applovin.exoplayer2;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class am implements g {
    public final float gD;
    public final float gE;
    private final int gF;
    public static final am gC = new am(1.0f);
    public static final g.a<am> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$am$fU_eWXJikoMAx2pOLJ63azeZAH8
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return am.k(bundle);
        }
    };

    public am(float f) {
        this(f, 1.0f);
    }

    public am(float f, float f2) {
        com.applovin.exoplayer2.l.a.checkArgument(f > 0.0f);
        com.applovin.exoplayer2.l.a.checkArgument(f2 > 0.0f);
        this.gD = f;
        this.gE = f2;
        this.gF = Math.round(f * 1000.0f);
    }

    public long x(long j) {
        return j * ((long) this.gF);
    }

    public am f(float f) {
        return new am(f, this.gE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        am amVar = (am) obj;
        return this.gD == amVar.gD && this.gE == amVar.gE;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.gD)) * 31) + Float.floatToRawIntBits(this.gE);
    }

    public String toString() {
        return com.applovin.exoplayer2.l.ai.a("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.gD), Float.valueOf(this.gE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ am k(Bundle bundle) {
        return new am(bundle.getFloat(t(0), 1.0f), bundle.getFloat(t(1), 1.0f));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
