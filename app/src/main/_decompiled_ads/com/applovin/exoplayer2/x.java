package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class x extends aq {
    public static final g.a<x> br = new g.a() { // from class: com.applovin.exoplayer2.-$$Lambda$x$9YtMuT1iuA7WKFyXz1INa6lQa7U
        @Override // com.applovin.exoplayer2.g.a
        public final g fromBundle(Bundle bundle) {
            return x.c(bundle);
        }
    };
    private final boolean dV;
    private final boolean dW;

    public x() {
        this.dV = false;
        this.dW = false;
    }

    public x(boolean z) {
        this.dV = true;
        this.dW = z;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.dV), Boolean.valueOf(this.dW));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.dW == xVar.dW && this.dV == xVar.dV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static x c(Bundle bundle) {
        com.applovin.exoplayer2.l.a.checkArgument(bundle.getInt(t(0), -1) == 0);
        if (bundle.getBoolean(t(1), false)) {
            return new x(bundle.getBoolean(t(2), false));
        }
        return new x();
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
