package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class u {
    private static final a aES = new a();
    private long aEU;
    private long aEX;
    private Object aEY;
    private final n sdk;
    private final AtomicBoolean aET = new AtomicBoolean();
    private final Object aEV = new Object();
    private final AtomicBoolean aEW = new AtomicBoolean();
    private final Map<String, a> aEZ = new HashMap();
    private final Object aFa = new Object();

    public static class a {
        private long aFb = -1;
        private int aFc;

        protected boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.canEqual(this) && Fb() == aVar.Fb() && Fc() == aVar.Fc();
        }

        public int hashCode() {
            long jFb = Fb();
            return ((((int) (jFb ^ (jFb >>> 32))) + 59) * 59) + Fc();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + Fb() + ", attemptCount=" + Fc() + ")";
        }

        static /* synthetic */ int a(a aVar) {
            int i = aVar.aFc;
            aVar.aFc = i + 1;
            return i;
        }

        public long Fb() {
            return this.aFb;
        }

        public int Fc() {
            return this.aFc;
        }
    }

    u(n nVar) {
        this.sdk = nVar;
    }

    public boolean EY() {
        return this.aEW.get();
    }

    public void aM(boolean z) {
        synchronized (this.aEV) {
            this.aEW.set(z);
            if (z) {
                this.aEX = System.currentTimeMillis();
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.aEX);
                }
                final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.b.aMJ);
                if (l.longValue() >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$u$5CwL6CvH44H1Sv275W7D4CBpJH0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(l);
                        }
                    }, l.longValue());
                }
            } else {
                this.aEX = 0L;
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        if (EY() && System.currentTimeMillis() - this.aEX >= l.longValue()) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.aEW.set(false);
        }
    }

    public boolean EZ() {
        return this.aET.get();
    }

    public Object Fa() {
        return this.aEY;
    }

    public void ab(final Object obj) {
        if (!com.applovin.impl.mediation.e.c.Z(obj) && this.aET.compareAndSet(false, true)) {
            this.aEY = obj;
            this.aEU = System.currentTimeMillis();
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.aEU);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.b.aMK);
            if (l.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$u$R0_3qOBubEUYAqYsM81T7yym-y8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(l, obj);
                    }
                }, l.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l, Object obj) {
        if (this.aET.get() && System.currentTimeMillis() - this.aEU >= l.longValue()) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            ac(obj);
        }
    }

    public void ac(Object obj) {
        if (!com.applovin.impl.mediation.e.c.Z(obj) && this.aET.compareAndSet(true, false)) {
            this.aEY = null;
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public void cK(String str) {
        synchronized (this.aFa) {
            a aVar = this.aEZ.get(str);
            if (aVar == null) {
                aVar = new a();
                this.aEZ.put(str, aVar);
            }
            aVar.aFb = System.currentTimeMillis();
            a.a(aVar);
        }
    }

    public a cL(String str) {
        a aVar;
        synchronized (this.aFa) {
            aVar = this.aEZ.get(str);
            if (aVar == null) {
                aVar = aES;
            }
        }
        return aVar;
    }

    public void cM(String str) {
        synchronized (this.aFa) {
            this.aEZ.remove(str);
        }
    }
}
