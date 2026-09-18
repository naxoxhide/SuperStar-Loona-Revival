package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ax extends aq {
    public static final g.a<ax> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$ax$qDiv-q696IBRcDz_Zf71EbCJb-I
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return ax.o(bundle);
        }
    };
    private final int in;
    private final float io;

    public ax(int i) {
        com.applovin.exoplayer2.l.a.checkArgument(i > 0, "maxStars must be a positive integer");
        this.in = i;
        this.io = -1.0f;
    }

    public ax(int i, float f) {
        com.applovin.exoplayer2.l.a.checkArgument(i > 0, "maxStars must be a positive integer");
        com.applovin.exoplayer2.l.a.checkArgument(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.in = i;
        this.io = f;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.in), Float.valueOf(this.io));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ax)) {
            return false;
        }
        ax axVar = (ax) obj;
        return this.in == axVar.in && this.io == axVar.io;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ax o(Bundle bundle) {
        com.applovin.exoplayer2.l.a.checkArgument(bundle.getInt(t(0), -1) == 2);
        int i = bundle.getInt(t(1), 5);
        float f = bundle.getFloat(t(2), -1.0f);
        if (f == -1.0f) {
            return new ax(i);
        }
        return new ax(i, f);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
