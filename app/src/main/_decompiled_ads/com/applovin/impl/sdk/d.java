package com.applovin.impl.sdk;

import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final x logger;
    private final n sdk;
    private final Map<com.applovin.impl.sdk.ad.d, z> alu = new HashMap();
    private final Map<com.applovin.impl.sdk.ad.d, z> ayT = new HashMap();
    private final Object ayS = new Object();

    d(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        for (com.applovin.impl.sdk.ad.d dVar : com.applovin.impl.sdk.ad.d.FR()) {
            this.alu.put(dVar, new z());
            this.ayT.put(dVar, new z());
        }
    }

    public AppLovinAdImpl a(com.applovin.impl.sdk.ad.d dVar) {
        com.applovin.impl.sdk.ad.f fVar;
        synchronized (this.ayS) {
            z zVarD = d(dVar);
            if (zVarD.Fn() > 0) {
                e(dVar).c(zVarD.Fo());
                fVar = new com.applovin.impl.sdk.ad.f(dVar, this.sdk);
            } else {
                fVar = null;
            }
        }
        if (fVar != null) {
            if (x.Fk()) {
                this.logger.f("AdPreloadManager", "Retrieved ad of zone " + dVar + "...");
            }
        } else if (x.Fk()) {
            this.logger.f("AdPreloadManager", "Unable to retrieve ad of zone " + dVar + "...");
        }
        return fVar;
    }

    void a(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.ayS) {
            d(appLovinAdImpl.getAdZone()).c(appLovinAdImpl);
            if (x.Fk()) {
                this.logger.f("AdPreloadManager", "Ad enqueued: " + appLovinAdImpl);
            }
        }
    }

    public AppLovinAdImpl b(com.applovin.impl.sdk.ad.d dVar) {
        AppLovinAdImpl appLovinAdImplFo;
        synchronized (this.ayS) {
            appLovinAdImplFo = f(dVar).Fo();
        }
        return appLovinAdImplFo;
    }

    public AppLovinAdBase c(com.applovin.impl.sdk.ad.d dVar) {
        AppLovinAdImpl appLovinAdImplFp;
        synchronized (this.ayS) {
            appLovinAdImplFp = f(dVar).Fp();
        }
        return appLovinAdImplFp;
    }

    public void b(AppLovinAdImpl appLovinAdImpl) {
        synchronized (this.ayS) {
            f(appLovinAdImpl.getAdZone()).d(appLovinAdImpl);
        }
    }

    private z d(com.applovin.impl.sdk.ad.d dVar) {
        z zVar;
        synchronized (this.ayS) {
            zVar = this.alu.get(dVar);
            if (zVar == null) {
                zVar = new z();
                this.alu.put(dVar, zVar);
            }
        }
        return zVar;
    }

    private z e(com.applovin.impl.sdk.ad.d dVar) {
        z zVar;
        synchronized (this.ayS) {
            zVar = this.ayT.get(dVar);
            if (zVar == null) {
                zVar = new z();
                this.ayT.put(dVar, zVar);
            }
        }
        return zVar;
    }

    private z f(com.applovin.impl.sdk.ad.d dVar) {
        synchronized (this.ayS) {
            z zVarE = e(dVar);
            if (zVarE.Fn() > 0) {
                return zVarE;
            }
            return d(dVar);
        }
    }
}
