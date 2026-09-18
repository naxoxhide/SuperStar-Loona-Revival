package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class aj extends aq {
    public static final g.a<aj> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$aj$rLiMWqRVqVrbcm4ctbmP9fdGnI4
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return aj.i(bundle);
        }
    };
    private final float go;

    public aj() {
        this.go = -1.0f;
    }

    public aj(float f) {
        com.applovin.exoplayer2.l.a.checkArgument(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.go = f;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.go));
    }

    public boolean equals(Object obj) {
        return (obj instanceof aj) && this.go == ((aj) obj).go;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static aj i(Bundle bundle) {
        com.applovin.exoplayer2.l.a.checkArgument(bundle.getInt(t(0), -1) == 1);
        float f = bundle.getFloat(t(1), -1.0f);
        return f == -1.0f ? new aj() : new aj(f);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
