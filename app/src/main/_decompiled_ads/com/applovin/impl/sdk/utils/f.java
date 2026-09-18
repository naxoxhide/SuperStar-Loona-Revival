package com.applovin.impl.sdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements AppLovinBroadcastManager.Receiver {
    private static final Set<f> aVw = new HashSet();
    private final r ayR;
    private final com.applovin.impl.sdk.n sdk;

    public static f a(long j, com.applovin.impl.sdk.n nVar, Runnable runnable) {
        return new f(j, nVar, runnable);
    }

    private f(long j, com.applovin.impl.sdk.n nVar, final Runnable runnable) {
        this.ayR = r.b(j, nVar, new Runnable() { // from class: com.applovin.impl.sdk.utils.-$$Lambda$f$5XsSsDCQCn-5KGn4nwq5DQGJVpE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j(runnable);
            }
        });
        this.sdk = nVar;
        aVw.add(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Runnable runnable) {
        tT();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void tT() {
        this.ayR.tT();
        AppLovinBroadcastManager.unregisterReceiver(this);
        aVw.remove(this);
    }

    public long AF() {
        return this.ayR.AF();
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.ayR.pause();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.ayR.resume();
        }
    }
}
