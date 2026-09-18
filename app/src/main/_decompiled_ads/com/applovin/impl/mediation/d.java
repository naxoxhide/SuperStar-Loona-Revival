package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final Map<String, c> als = new HashMap(4);
    private final Object alt = new Object();
    private final Map<String, com.applovin.impl.mediation.b.a> alu = new HashMap(4);
    private final Object alv = new Object();
    private final Map<String, Integer> alw = new HashMap();
    private final Object alx = new Object();
    private final n sdk;

    private static class c {
        private final AtomicBoolean alS;
        private int alT;
        private volatile com.applovin.impl.mediation.ads.a.InterfaceC0117a alU;
        private final String loadTag;

        static /* synthetic */ int e(c cVar) {
            int i = cVar.alT;
            cVar.alT = i + 1;
            return i;
        }

        private c(String str) {
            this.alS = new AtomicBoolean();
            this.loadTag = str;
        }
    }

    public enum a {
        PUBLISHER_INITIATED("publisher_initiated"),
        SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
        REFRESH("refresh"),
        EXPONENTIAL_RETRY("exponential_retry"),
        EXPIRED("expired"),
        NATIVE_AD_PLACER("native_ad_placer");

        private final String Jn;

        a(String str) {
            this.Jn = str;
        }

        public String tU() {
            return this.Jn;
        }
    }

    public d(n nVar) {
        this.sdk = nVar;
    }

    public boolean bw(String str) {
        boolean z;
        synchronized (this.alv) {
            z = this.alu.get(str) != null;
        }
        return z;
    }

    public void o(String str, String str2) {
        synchronized (this.alt) {
            this.als.remove(q(str, str2));
        }
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, a aVar, Map<String, Object> map, Map<String, Object> map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        com.applovin.impl.mediation.b.a aVarBx = (this.sdk.CC().xi() || u.ai(n.getApplicationContext())) ? null : bx(str);
        if (aVarBx != null) {
            aVarBx.setLoadTag(str2);
            aVarBx.xB().uf().a(interfaceC0117a);
            interfaceC0117a.onAdLoaded(aVarBx);
            if (aVarBx.xy().endsWith("load")) {
                interfaceC0117a.onAdRevenuePaid(aVarBx);
            }
        }
        c cVarP = p(str, str2);
        if (!cVarP.alS.compareAndSet(false, true)) {
            if (cVarP.alU != null && cVarP.alU != interfaceC0117a) {
                x.F("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            cVarP.alU = interfaceC0117a;
            return;
        }
        if (aVarBx == null) {
            cVarP.alU = interfaceC0117a;
        }
        Map<String, Object> mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.put("art", aVar.tU());
        if (StringUtils.isValidString(str2)) {
            mapSynchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new b(map, map2, mapSynchronizedMap, cVarP, maxAdFormat, SystemClock.elapsedRealtime(), this, this.sdk, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final MaxAdFormat maxAdFormat, final Map<String, Object> map, final Map<String, Object> map2, final Map<String, Object> map3, final Context context, final com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        this.sdk.BM().a(new com.applovin.impl.mediation.d.b(str, maxAdFormat, map, context, this.sdk, new com.applovin.impl.mediation.d.b.a() { // from class: com.applovin.impl.mediation.d.1
            @Override // com.applovin.impl.mediation.d.b.a
            public void a(JSONArray jSONArray) {
                map3.put("calfc", Integer.valueOf(d.this.bA(str)));
                d.this.sdk.BM().b(new com.applovin.impl.mediation.d.c(str, maxAdFormat, map, map2, map3, jSONArray, context, d.this.sdk, interfaceC0117a));
            }
        }), com.applovin.impl.mediation.e.c.f(maxAdFormat));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.b.a aVar) {
        synchronized (this.alv) {
            if (this.alu.containsKey(aVar.getAdUnitId())) {
                x.H("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.alu.put(aVar.getAdUnitId(), aVar);
        }
    }

    private com.applovin.impl.mediation.b.a bx(String str) {
        com.applovin.impl.mediation.b.a aVar;
        synchronized (this.alv) {
            aVar = this.alu.get(str);
            this.alu.remove(str);
        }
        return aVar;
    }

    private c p(String str, String str2) {
        c cVar;
        synchronized (this.alt) {
            String strQ = q(str, str2);
            cVar = this.als.get(strQ);
            if (cVar == null) {
                cVar = new c(str2);
                this.als.put(strQ, cVar);
            }
        }
        return cVar;
    }

    private String q(String str, String str2) {
        return str + (str2 != null ? "-" + str2 : "");
    }

    public void by(String str) {
        synchronized (this.alx) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
            }
            Integer num = this.alw.get(str);
            if (num == null) {
                num = 0;
            }
            this.alw.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(String str) {
        synchronized (this.alx) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
            }
            this.alw.remove(str);
        }
    }

    public int bA(String str) {
        int iIntValue;
        synchronized (this.alx) {
            Integer num = this.alw.get(str);
            iIntValue = num != null ? num.intValue() : 0;
        }
        return iIntValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements com.applovin.impl.mediation.ads.a.InterfaceC0117a {
        private final WeakReference<Context> alN;
        private final d alO;
        private final c alP;
        private final Map<String, Object> alQ;
        private final int alR;
        private final Map<String, Object> extraParameters;
        private final MaxAdFormat format;
        private final Map<String, Object> localExtraParameters;
        private final n sdk;
        private long startTimeMillis;

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private b(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, c cVar, MaxAdFormat maxAdFormat, long j, d dVar, n nVar, Context context) {
            this.sdk = nVar;
            this.alN = new WeakReference<>(context);
            this.alO = dVar;
            this.alP = cVar;
            this.format = maxAdFormat;
            this.extraParameters = map2;
            this.localExtraParameters = map;
            this.alQ = map3;
            this.startTimeMillis = j;
            if (CollectionUtils.getBoolean(map2, AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES)) {
                this.alR = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.alR = Math.min(2, ((Integer) nVar.a(com.applovin.impl.sdk.c.a.aJR)).intValue());
            } else {
                this.alR = ((Integer) nVar.a(com.applovin.impl.sdk.c.a.aJR)).intValue();
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
            aVar.setLoadTag(this.alP.loadTag);
            aVar.setRequestLatencyMillis(SystemClock.elapsedRealtime() - this.startTimeMillis);
            this.alO.bz(maxAd.getAdUnitId());
            this.alP.alT = 0;
            if (this.alP.alU == null) {
                this.alO.b(aVar);
                this.alP.alS.set(false);
                return;
            }
            aVar.xB().uf().a(this.alP.alU);
            this.alP.alU.onAdLoaded(aVar);
            if (aVar.xy().endsWith("load")) {
                this.alP.alU.onAdRevenuePaid(aVar);
            }
            com.applovin.impl.mediation.ads.a.InterfaceC0117a unused = this.alP.alU;
            this.alP.alU = null;
            if ((!this.sdk.b(com.applovin.impl.sdk.c.a.aJQ).contains(maxAd.getAdUnitId()) && !this.sdk.a(com.applovin.impl.sdk.c.a.aJP, maxAd.getFormat())) || this.sdk.CC().isEnabled() || this.sdk.CC().xi()) {
                this.alP.alS.set(false);
                return;
            }
            Context applicationContext = this.alN.get();
            if (applicationContext == null) {
                applicationContext = n.getApplicationContext();
            }
            this.startTimeMillis = SystemClock.elapsedRealtime();
            this.alQ.put("art", a.SEQUENTIAL_OR_PRECACHE.tU());
            this.alO.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.localExtraParameters, this.extraParameters, this.alQ, applicationContext, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(final String str, MaxError maxError) {
            this.alO.by(str);
            if (!this.sdk.a(com.applovin.impl.sdk.c.a.aJS, this.format) || this.alP.alT >= this.alR) {
                this.alP.alT = 0;
                this.alP.alS.set(false);
                if (this.alP.alU != null) {
                    MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError;
                    maxErrorImpl.setLoadTag(this.alP.loadTag);
                    maxErrorImpl.setRequestLatencyMillis(SystemClock.elapsedRealtime() - this.startTimeMillis);
                    m.a(this.alP.alU, str, maxError);
                    this.alP.alU = null;
                    return;
                }
                return;
            }
            c.e(this.alP);
            final int iPow = (int) Math.pow(2.0d, this.alP.alT);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$d$b$cSdUWaA_la7fe4oyEVqZYPYbSDM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d(iPow, str);
                }
            }, TimeUnit.SECONDS.toMillis(iPow));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i, String str) {
            this.extraParameters.put("retry_delay_sec", Integer.valueOf(i));
            this.extraParameters.put("retry_attempt", Integer.valueOf(this.alP.alT));
            Context applicationContext = this.alN.get();
            if (applicationContext == null) {
                applicationContext = n.getApplicationContext();
            }
            this.alQ.put("art", a.EXPONENTIAL_RETRY.tU());
            this.alQ.put("era", Integer.valueOf(this.alP.alT));
            this.alO.a(str, this.format, this.localExtraParameters, this.extraParameters, this.alQ, applicationContext, this);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }
    }
}
