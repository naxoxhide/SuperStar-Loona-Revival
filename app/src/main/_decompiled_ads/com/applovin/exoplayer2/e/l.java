package com.applovin.exoplayer2.e;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface l {
    public static final l ux = new l() { // from class: com.applovin.exoplayer2.e.-$$Lambda$l$0A0vhTiD20MRA6dOO_FeUPKwlTg
        @Override // com.applovin.exoplayer2.e.l
        public final h[] createExtractors() {
            return l.ih();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ h[] ih() {
        return new h[0];
    }

    h[] createExtractors();

    default h[] a(Uri uri, Map<String, List<String>> map) {
        return createExtractors();
    }
}
