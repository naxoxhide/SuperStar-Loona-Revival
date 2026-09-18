package com.applovin.exoplayer2.k;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface i extends g {

    public interface a {
        i of();
    }

    long a(l lVar) throws IOException;

    void c(aa aaVar);

    void close() throws IOException;

    Uri getUri();

    default Map<String, List<String>> kT() {
        return Collections.emptyMap();
    }
}
