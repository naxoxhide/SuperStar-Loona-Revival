package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class e implements AppLovinBroadcastManager.Receiver {
    private com.applovin.impl.sdk.utils.r ayR;
    private final Object ayU = new Object();
    private final AtomicBoolean ayV = new AtomicBoolean();
    private boolean ayW;
    private final WeakReference<a> ayX;
    private long ayY;
    private final n sdk;

    public interface a {
        void onAdRefresh();
    }

    public e(n nVar, a aVar) {
        this.ayX = new WeakReference<>(aVar);
        this.sdk = nVar;
    }

    public boolean AE() {
        boolean z;
        synchronized (this.ayU) {
            z = this.ayR != null;
        }
        return z;
    }

    public long AF() {
        long jAF;
        synchronized (this.ayU) {
            com.applovin.impl.sdk.utils.r rVar = this.ayR;
            jAF = rVar != null ? rVar.AF() : -1L;
        }
        return jAF;
    }

    public void bK(long j) {
        synchronized (this.ayU) {
            AG();
            this.ayY = j;
            this.ayR = com.applovin.impl.sdk.utils.r.b(j, this.sdk, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$e$JI5I8UX2Exl1QakfTWC_2tuB8Ng
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.AO();
                }
            });
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJr)).booleanValue()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_displayed"));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.fullscreen_ad_hidden"));
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJq)).booleanValue() && (this.sdk.Cd().EZ() || this.sdk.Cc().isApplicationPaused())) {
                this.ayR.pause();
            }
            if (this.ayV.compareAndSet(true, false) && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJs)).booleanValue()) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AdRefreshManager", "Pausing refresh for a previous request.");
                }
                this.ayR.pause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AO() {
        Y();
        a aVar = this.ayX.get();
        if (aVar != null) {
            aVar.onAdRefresh();
        }
    }

    public void AG() {
        synchronized (this.ayU) {
            com.applovin.impl.sdk.utils.r rVar = this.ayR;
            if (rVar != null) {
                rVar.tT();
                Y();
            }
        }
    }

    public void AH() {
        synchronized (this.ayU) {
            AK();
            this.ayW = true;
        }
    }

    public void AI() {
        synchronized (this.ayU) {
            AL();
            this.ayW = false;
        }
    }

    public boolean AJ() {
        return this.ayW;
    }

    private void AK() {
        synchronized (this.ayU) {
            com.applovin.impl.sdk.utils.r rVar = this.ayR;
            if (rVar != null) {
                rVar.pause();
            } else {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AdRefreshManager", "An ad load is in progress. Will pause refresh once the ad finishes loading.");
                }
                this.ayV.set(true);
            }
        }
    }

    private void AL() {
        synchronized (this.ayU) {
            com.applovin.impl.sdk.utils.r rVar = this.ayR;
            if (rVar != null) {
                rVar.resume();
            } else {
                this.ayV.set(false);
            }
        }
    }

    private void Y() {
        synchronized (this.ayU) {
            this.ayR = null;
            if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJr)).booleanValue()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            Az();
            return;
        }
        if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            AA();
        } else if ("com.applovin.fullscreen_ad_displayed".equals(action)) {
            AM();
        } else if ("com.applovin.fullscreen_ad_hidden".equals(action)) {
            AN();
        }
    }

    public void Az() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJp)).booleanValue()) {
            AK();
        }
    }

    public void AA() {
        a aVar;
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJp)).booleanValue()) {
            synchronized (this.ayU) {
                if (this.ayW) {
                    this.sdk.BL();
                    if (x.Fk()) {
                        this.sdk.BL().f("AdRefreshManager", "Application resumed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                    return;
                }
                if (this.sdk.Cd().EZ()) {
                    this.sdk.BL();
                    if (x.Fk()) {
                        this.sdk.BL().f("AdRefreshManager", "Waiting for the full screen ad to be dismissed to resume the timer.");
                    }
                    return;
                }
                boolean z = false;
                if (this.ayR != null) {
                    long jAF = this.ayY - AF();
                    long jLongValue = ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJo)).longValue();
                    if (jLongValue >= 0 && jAF > jLongValue) {
                        AG();
                        z = true;
                    } else {
                        this.ayR.resume();
                    }
                }
                if (!z || (aVar = this.ayX.get()) == null) {
                    return;
                }
                aVar.onAdRefresh();
            }
        }
    }

    private void AM() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJq)).booleanValue()) {
            AK();
        }
    }

    private void AN() {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJq)).booleanValue()) {
            synchronized (this.ayU) {
                if (this.ayW) {
                    this.sdk.BL();
                    if (x.Fk()) {
                        this.sdk.BL().f("AdRefreshManager", "Fullscreen ad dismissed but banner ad refresh paused by publisher. Waiting for publisher to resume banner ad refresh.");
                    }
                } else if (this.sdk.Cc().isApplicationPaused()) {
                    this.sdk.BL();
                    if (x.Fk()) {
                        this.sdk.BL().f("AdRefreshManager", "Waiting for the application to enter foreground to resume the timer.");
                    }
                } else {
                    com.applovin.impl.sdk.utils.r rVar = this.ayR;
                    if (rVar != null) {
                        rVar.resume();
                    }
                }
            }
        }
    }
}
