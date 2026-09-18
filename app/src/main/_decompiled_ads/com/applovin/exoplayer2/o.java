package com.applovin.exoplayer2;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class o implements g {
    public static final o bn = new o(0, 0, 0);
    public static final g.a<o> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$o$zTuPP5Ca3a4z2vTF_RsO_XT_-mI
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return o.a(bundle);
        }
    };
    public final int bo;
    public final int bp;
    public final int bq;

    public o(int i, int i2, int i3) {
        this.bo = i;
        this.bp = i2;
        this.bq = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.bo == oVar.bo && this.bp == oVar.bp && this.bq == oVar.bq;
    }

    public int hashCode() {
        return ((((527 + this.bo) * 31) + this.bp) * 31) + this.bq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o a(Bundle bundle) {
        return new o(bundle.getInt(t(0), 0), bundle.getInt(t(1), 0), bundle.getInt(t(2), 0));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
