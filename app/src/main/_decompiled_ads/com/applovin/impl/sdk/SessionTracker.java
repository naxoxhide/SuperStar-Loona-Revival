package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.tapjoy.TJAdUnitConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";
    private Date aFE;
    private Date aFF;
    final n mSdk;
    private final AtomicBoolean aFz = new AtomicBoolean();
    private final AtomicBoolean aFA = new AtomicBoolean();
    private final AtomicInteger aFB = new AtomicInteger();
    private final AtomicLong aFC = new AtomicLong();
    private final AtomicLong aFD = new AtomicLong();

    SessionTracker(n nVar) {
        this.mSdk = nVar;
        Application application = (Application) n.getApplicationContext();
        application.registerActivityLifecycleCallbacks(new com.applovin.impl.sdk.utils.a() { // from class: com.applovin.impl.sdk.SessionTracker.1
            @Override // com.applovin.impl.sdk.utils.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
                SessionTracker.this.AA();
            }
        });
        application.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.applovin.impl.sdk.SessionTracker.2
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
                SessionTracker.this.aFB.set(i);
                if (i == 20) {
                    SessionTracker.this.Az();
                }
            }
        });
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new BroadcastReceiver() { // from class: com.applovin.impl.sdk.SessionTracker.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    if (com.applovin.impl.sdk.utils.u.Lw()) {
                        SessionTracker.this.AA();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    SessionTracker.this.Az();
                }
            }
        }, intentFilter);
    }

    public boolean isApplicationPaused() {
        return this.aFA.get();
    }

    public int getLastTrimMemoryLevel() {
        return this.aFB.get();
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.aFC.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.aFD.get();
    }

    public void pauseForClick() {
        this.aFz.set(true);
    }

    public void resumeForClick() {
        this.aFz.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA() {
        if (this.aFA.compareAndSet(true, false)) {
            Ft();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az() {
        if (this.aFA.compareAndSet(false, true)) {
            Fs();
        }
    }

    private void Fs() {
        this.mSdk.BL();
        if (x.Fk()) {
            this.mSdk.BL().f("SessionTracker", "Application Paused");
        }
        this.aFC.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.aFz.get()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.mSdk.a(com.applovin.impl.sdk.c.b.aOg)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.mSdk.a(com.applovin.impl.sdk.c.b.aOi)).longValue());
        if (this.aFE == null || System.currentTimeMillis() - this.aFE.getTime() >= millis) {
            this.mSdk.BD().trackEvent(TJAdUnitConstants.String.VIDEO_PAUSED);
            if (zBooleanValue) {
                this.aFE = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.aFE = new Date();
    }

    private void Ft() {
        this.mSdk.BL();
        if (x.Fk()) {
            this.mSdk.BL().f("SessionTracker", "Application Resumed");
        }
        this.aFD.set(System.currentTimeMillis());
        boolean zBooleanValue = ((Boolean) this.mSdk.a(com.applovin.impl.sdk.c.b.aOg)).booleanValue();
        long jLongValue = ((Long) this.mSdk.a(com.applovin.impl.sdk.c.b.aOh)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.aFz.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(jLongValue);
        if (this.aFF == null || System.currentTimeMillis() - this.aFF.getTime() >= millis) {
            this.mSdk.BD().trackEvent("resumed");
            if (zBooleanValue) {
                this.aFF = new Date();
            }
        }
        if (!zBooleanValue) {
            this.aFF = new Date();
        }
        this.mSdk.BP().a(com.applovin.impl.sdk.d.f.aSZ);
    }
}
