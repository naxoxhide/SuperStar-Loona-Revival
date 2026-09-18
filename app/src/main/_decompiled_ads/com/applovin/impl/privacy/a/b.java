package com.applovin.impl.privacy.a;

import com.applovin.impl.sdk.n;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static List<e> h(n nVar) {
        if (!nVar.Cj().isEnabled()) {
            return null;
        }
        Boolean boolB = com.applovin.impl.privacy.a.zM().B(n.getApplicationContext());
        if (boolB == null || !boolB.booleanValue()) {
            return j.m(nVar);
        }
        return null;
    }

    public static List<e> i(n nVar) {
        if (!nVar.Cj().isEnabled()) {
            return null;
        }
        boolean zBJ = nVar.BJ();
        Boolean bool = (Boolean) nVar.b((com.applovin.impl.sdk.c.d<boolean>) com.applovin.impl.sdk.c.d.aRo, false);
        if (zBJ) {
            if (bool.booleanValue()) {
                return j(nVar);
            }
            return null;
        }
        return j(nVar);
    }

    private static List<e> j(n nVar) {
        if (nVar.Cj().getTermsOfServiceUri() != null) {
            return j.l(nVar);
        }
        return j.k(nVar);
    }
}
