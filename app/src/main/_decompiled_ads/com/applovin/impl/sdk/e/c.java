package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.applovin.impl.sdk.e.a {
    private final com.applovin.impl.sdk.d.e aHe;
    private final List<String> aTk;
    private final String aTv;
    private final boolean aTw;
    private final a aTx;
    private final com.applovin.impl.sdk.ad.e aiL;
    private final com.applovin.impl.sdk.n sdk;

    public interface a {
        void q(Uri uri);
    }

    public c(String str, com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.sdk.d.e eVar2, com.applovin.impl.sdk.n nVar, a aVar) {
        this(str, eVar, eVar.Gv(), true, eVar2, nVar, aVar);
    }

    public c(String str, com.applovin.impl.sdk.ad.e eVar, List<String> list, boolean z, com.applovin.impl.sdk.d.e eVar2, com.applovin.impl.sdk.n nVar, a aVar) {
        super("AsyncTaskCacheResource", nVar);
        this.aTv = str;
        this.aiL = eVar;
        this.aTk = list;
        this.aTw = z;
        this.aHe = eVar2;
        this.sdk = nVar;
        this.aTx = aVar;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: Ka, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        if (this.aTi.get()) {
            return false;
        }
        String strA = this.sdk.Ca().a(rQ(), this.aTv, this.aiL.getCachePrefix(), this.aTk, this.aTw, this.aHe);
        if (TextUtils.isEmpty(strA)) {
            r(null);
            return false;
        }
        if (this.aTi.get()) {
            return false;
        }
        File fileA = this.sdk.Ca().a(strA, rQ());
        if (fileA == null) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Unable to retrieve File for cached filename = " + strA);
            }
            r(null);
            return false;
        }
        if (this.aTi.get()) {
            return false;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        if (uriFromFile == null) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Unable to extract Uri from file");
            }
            r(null);
            return false;
        }
        if (this.aTi.get()) {
            return false;
        }
        r(uriFromFile);
        return true;
    }

    private void r(Uri uri) {
        a aVar;
        if (this.aTi.get() || (aVar = this.aTx) == null) {
            return;
        }
        aVar.q(uri);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aTv.equals(((c) obj).aTv);
    }

    public int hashCode() {
        String str = this.aTv;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
