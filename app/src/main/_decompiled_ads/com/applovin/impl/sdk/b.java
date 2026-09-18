package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b implements AppLovinBroadcastManager.Receiver {
    private static final long ayM = TimeUnit.SECONDS.toMillis(2);
    private final HashSet<c> ayN = new HashSet<>();
    private final Object ayO = new Object();
    private final x logger;
    private final n sdk;

    public interface a {
        void onAdExpired(com.applovin.impl.sdk.ad.g gVar);
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
    }

    public boolean a(com.applovin.impl.sdk.ad.g gVar, a aVar) {
        synchronized (this.ayO) {
            if (b(gVar) != null) {
                if (x.Fk()) {
                    this.logger.f("AdExpirationManager", "Ad expiration already scheduled for ad: " + gVar);
                }
                return true;
            }
            if (gVar.getTimeToLiveMillis() <= ayM) {
                if (x.Fk()) {
                    this.logger.f("AdExpirationManager", "Ad has already expired: " + gVar);
                }
                gVar.setExpired();
                return false;
            }
            if (x.Fk()) {
                this.logger.f("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(gVar.getTimeToLiveMillis()) + " seconds from now for " + gVar + "...");
            }
            if (this.ayN.isEmpty()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            this.ayN.add(c.a(gVar, aVar, this.sdk));
            return true;
        }
    }

    public void a(com.applovin.impl.sdk.ad.g gVar) {
        synchronized (this.ayO) {
            c cVarB = b(gVar);
            if (cVarB != null) {
                if (x.Fk()) {
                    this.logger.f("AdExpirationManager", "Cancelling expiration timer for ad: " + gVar);
                }
                cVarB.tT();
                a(cVarB);
            }
        }
    }

    public void a(c cVar) {
        synchronized (this.ayO) {
            this.ayN.remove(cVar);
            if (this.ayN.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private c b(com.applovin.impl.sdk.ad.g gVar) {
        synchronized (this.ayO) {
            try {
                if (gVar == null) {
                    return null;
                }
                for (c cVar : this.ayN) {
                    if (gVar == cVar.AB()) {
                        return cVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            Az();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            AA();
        }
    }

    private void Az() {
        synchronized (this.ayO) {
            Iterator<c> it = this.ayN.iterator();
            while (it.hasNext()) {
                it.next().tT();
            }
        }
    }

    private void AA() {
        HashSet<c> hashSet = new HashSet();
        synchronized (this.ayO) {
            for (c cVar : this.ayN) {
                com.applovin.impl.sdk.ad.g gVarAB = cVar.AB();
                if (gVarAB == null) {
                    hashSet.add(cVar);
                } else {
                    long timeToLiveMillis = gVarAB.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (x.Fk()) {
                            this.logger.f("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + gVarAB);
                        }
                        hashSet.add(cVar);
                    } else {
                        if (x.Fk()) {
                            this.logger.f("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + gVarAB);
                        }
                        cVar.bJ(timeToLiveMillis);
                    }
                }
            }
        }
        for (c cVar2 : hashSet) {
            a(cVar2);
            cVar2.AC();
        }
    }
}
