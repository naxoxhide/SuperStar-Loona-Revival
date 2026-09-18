package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class w {
    private static final Set<w> aVw = new HashSet();
    private final Timer aWa;
    private final boolean aWr;
    private final Object ayU = new Object();
    private final com.applovin.impl.sdk.n sdk;
    private Runnable v;

    public static w a(long j, boolean z, com.applovin.impl.sdk.n nVar, Runnable runnable) {
        return new w(j, z, nVar, runnable);
    }

    private w(long j, boolean z, com.applovin.impl.sdk.n nVar, Runnable runnable) {
        Timer timer = new Timer();
        this.aWa = timer;
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j);
        }
        if (nVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
        this.aWr = z;
        this.sdk = nVar;
        this.v = runnable;
        aVw.add(this);
        timer.schedule(Lr(), j);
    }

    public void tT() {
        synchronized (this.ayU) {
            this.aWa.cancel();
            this.v = null;
            aVw.remove(this);
        }
    }

    private TimerTask Lr() {
        return new TimerTask() { // from class: com.applovin.impl.sdk.utils.w.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!w.this.sdk.Cc().isApplicationPaused() || w.this.aWr) {
                    w.this.LF();
                } else {
                    AppLovinBroadcastManager.registerReceiver(new AppLovinBroadcastManager.Receiver() { // from class: com.applovin.impl.sdk.utils.w.1.1
                        @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
                        public void onReceive(Intent intent, Map<String, Object> map) {
                            AppLovinBroadcastManager.unregisterReceiver(this);
                            w.this.LF();
                        }
                    }, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LF() {
        Runnable runnable = this.v;
        if (runnable != null) {
            runnable.run();
            tT();
        }
    }
}
