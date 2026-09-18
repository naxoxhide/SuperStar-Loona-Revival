package com.applovin.impl.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final g azn = new g();
    private Handler aze;
    private Handler azg;
    private Thread azj;
    private n sdk;
    private final AtomicLong azd = new AtomicLong(0);
    private final HandlerThread azf = new HandlerThread("AppLovinSdk:anr_detector");
    private final AtomicBoolean azh = new AtomicBoolean();
    private final AtomicBoolean azi = new AtomicBoolean();
    private long azk = TimeUnit.SECONDS.toMillis(4);
    private long azl = TimeUnit.SECONDS.toMillis(3);
    private long azm = TimeUnit.SECONDS.toMillis(3);

    private g() {
    }

    private void n(n nVar) {
        if (this.azi.compareAndSet(false, true)) {
            this.sdk = nVar;
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$g$NyMDlVWasBQAhjFBIUDtsH1aIO8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.AP();
                }
            });
            this.azk = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQr)).longValue();
            this.azl = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQs)).longValue();
            this.azm = ((Long) nVar.a(com.applovin.impl.sdk.c.b.aQt)).longValue();
            this.aze = new Handler(n.getApplicationContext().getMainLooper());
            this.azf.start();
            this.aze.post(new b());
            Handler handler = new Handler(this.azf.getLooper());
            this.azg = handler;
            handler.postDelayed(new a(), this.azm / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void AP() {
        this.azj = Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        if (this.azi.get()) {
            this.azh.set(true);
        }
    }

    public static void o(n nVar) {
        if (nVar != null) {
            if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aQq)).booleanValue() && !com.applovin.impl.sdk.utils.u.b(n.getApplicationContext(), nVar)) {
                azn.n(nVar);
            } else {
                azn.X();
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.azh.get()) {
                return;
            }
            g.this.azd.set(System.currentTimeMillis());
            g.this.aze.postDelayed(this, g.this.azl);
        }
    }

    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (g.this.azh.get()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - g.this.azd.get();
            if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > g.this.azk) {
                g.this.X();
                if (g.this.azj == null || g.this.azj.getStackTrace().length <= 0) {
                    str = "None";
                } else {
                    StackTraceElement stackTraceElement = g.this.azj.getStackTrace()[0];
                    str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                }
                long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - n.CE());
                HashMap map = new HashMap(3);
                map.put("top_main_method", str);
                map.put("source", g.this.sdk.BJ() ? "non_first_session" : "first_session");
                map.put("details", "seconds_since_app_launch=" + seconds);
                g.this.sdk.Cq().a(r.a.ANR, map);
            }
            g.this.azg.postDelayed(this, g.this.azm);
        }
    }
}
