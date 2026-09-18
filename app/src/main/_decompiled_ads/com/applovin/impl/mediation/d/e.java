package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.r;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.applovin.impl.sdk.e.d {
    private static final AtomicBoolean aww = new AtomicBoolean();
    private final String adUnitId;
    private final List<MaxNetworkResponseInfo> akY;
    private final WeakReference<Context> alN;
    private final Object awA;
    private final Queue<com.applovin.impl.mediation.b.a> awB;
    private final Object awC;
    private final int awD;
    private final AtomicBoolean awE;
    private final AtomicBoolean awF;
    private final AtomicBoolean awG;
    private com.applovin.impl.mediation.b.a awH;
    private r awI;
    private final JSONObject awx;
    private final com.applovin.impl.mediation.ads.a.InterfaceC0117a awy;
    private final Queue<com.applovin.impl.mediation.b.a> awz;
    private final MaxAdFormat format;
    private long startTimeMillis;

    private enum b {
        BIDDING,
        TAG
    }

    public e(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, n nVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        super("TaskProcessMediationWaterfallV2", nVar, str);
        this.awz = new LinkedList();
        this.awA = new Object();
        this.awB = new LinkedList();
        this.awC = new Object();
        this.awE = new AtomicBoolean();
        this.awF = new AtomicBoolean();
        this.awG = new AtomicBoolean();
        this.adUnitId = str;
        this.format = maxAdFormat;
        this.awx = jSONObject;
        this.awy = interfaceC0117a;
        this.alN = new WeakReference<>(context);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            com.applovin.impl.mediation.b.a aVarA = com.applovin.impl.mediation.b.a.a(i, map, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, nVar);
            if (aVarA.isBidding()) {
                this.awB.add(aVarA);
            } else {
                this.awz.add(aVarA);
            }
        }
        int size = this.awz.size() + this.awB.size();
        this.awD = size;
        this.akY = new ArrayList(size);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.startTimeMillis = SystemClock.elapsedRealtime();
        if (this.awx.optBoolean("is_testing", false) && !this.sdk.CC().isEnabled() && aww.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$e$77Ln00phZNWELeTXPoMznWYLPh0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.zH();
                }
            });
        }
        if (this.awD == 0) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.h(this.tag, "No ads were returned from the server for " + this.format.getLabel() + " ad unit " + this.adUnitId);
            }
            u.a(this.adUnitId, this.format, this.awx, this.sdk);
            JSONObject jSONObject = JsonUtils.getJSONObject(this.awx, "settings", new JSONObject());
            long j = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
            final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
            if (j > 0) {
                long millis = TimeUnit.SECONDS.toMillis(j);
                Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$e$a_XuqGDGF4LB-irTXk3FGhgX9G0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(maxErrorImpl);
                    }
                };
                if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", false).booleanValue()) {
                    com.applovin.impl.sdk.utils.f.a(millis, this.sdk, runnable);
                    return;
                } else {
                    AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
                    return;
                }
            }
            a(maxErrorImpl);
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Starting waterfall for " + this.format.getLabel() + " ad unit " + this.adUnitId + " with " + this.awD + " ad(s)...");
        }
        a(b.TAG);
        a(b.BIDDING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zH() {
        u.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.sdk.CD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar) {
        com.applovin.impl.mediation.b.a aVarC = c(bVar);
        if (aVarC == null) {
            d(bVar);
            return false;
        }
        this.sdk.BM().a(new a(aVarC, bVar), q.b.MEDIATION_MAIN);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.applovin.impl.mediation.b.a b(b bVar) {
        return a(bVar, true);
    }

    private com.applovin.impl.mediation.b.a c(b bVar) {
        return a(bVar, false);
    }

    private com.applovin.impl.mediation.b.a a(b bVar, boolean z) {
        com.applovin.impl.mediation.b.a aVarPeek;
        com.applovin.impl.mediation.b.a aVarPeek2;
        if (bVar == b.BIDDING) {
            synchronized (this.awC) {
                try {
                    aVarPeek2 = z ? this.awB.peek() : this.awB.poll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVarPeek2;
        }
        synchronized (this.awA) {
            try {
                aVarPeek = z ? this.awz.peek() : this.awz.poll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVarPeek;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        if (b.BIDDING == bVar) {
            this.awE.compareAndSet(false, true);
        } else if (b.TAG == bVar) {
            this.awF.compareAndSet(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.applovin.impl.mediation.b.a aVar) {
        a(aVar, (com.applovin.impl.mediation.b.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.b.a aVar2) {
        if (this.awG.compareAndSet(false, true)) {
            zG();
            zF();
            this.sdk.CA().b(aVar, aVar2);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.g(this.tag, "Waterfall loaded in " + jElapsedRealtime + "ms from " + aVar.yz() + " for " + this.format + " ad unit " + this.adUnitId);
            }
            aVar.setWaterfall(new MaxAdWaterfallInfoImpl(aVar, jElapsedRealtime, this.akY));
            m.a((MaxAdListener) this.awy, (MaxAd) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(MaxError maxError) {
        int i = 0;
        if (this.awG.compareAndSet(false, true)) {
            if (maxError.getCode() == 204) {
                this.sdk.BP().a(com.applovin.impl.sdk.d.f.aTe);
            } else if (maxError.getCode() == -5001) {
                this.sdk.BP().a(com.applovin.impl.sdk.d.f.aTf);
            } else {
                this.sdk.BP().a(com.applovin.impl.sdk.d.f.aTg);
            }
            ArrayList arrayList = new ArrayList(this.akY.size());
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.akY) {
                if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                    arrayList.add(maxNetworkResponseInfo);
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
                sb.append("\n");
                while (i < arrayList.size()) {
                    MaxNetworkResponseInfo maxNetworkResponseInfo2 = (MaxNetworkResponseInfo) arrayList.get(i);
                    i++;
                    sb.append(i).append(") ").append(maxNetworkResponseInfo2.getMediatedNetwork().getName()).append("\n").append("..code: ").append(maxNetworkResponseInfo2.getError().getCode()).append("\n").append("..message: ").append(maxNetworkResponseInfo2.getError().getMessage()).append("\n");
                }
                ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.g(this.tag, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.format + " ad unit " + this.adUnitId + " with error: " + maxError);
            }
            ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.awx, "waterfall_name", ""), JsonUtils.getString(this.awx, "waterfall_test_name", ""), jElapsedRealtime, this.akY));
            m.a(this.awy, this.adUnitId, maxError);
        }
    }

    private void zF() {
        a(this.awz);
        a(this.awB);
    }

    private void a(Queue<com.applovin.impl.mediation.b.a> queue) {
        Iterator<com.applovin.impl.mediation.b.a> it = queue.iterator();
        while (it.hasNext()) {
            a(it.next(), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
        }
    }

    private void zG() {
        r rVar = this.awI;
        if (rVar == null) {
            return;
        }
        rVar.tT();
        this.awI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
        this.akY.add(new MaxNetworkResponseInfoImpl(adLoadState, new MaxMediatedNetworkInfoImpl(com.applovin.impl.mediation.e.c.a(aVar.vt(), this.sdk)), aVar.getCredentials(), aVar.isBidding(), j, maxError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a extends com.applovin.impl.sdk.e.d {
        private final com.applovin.impl.mediation.b.a amk;
        private final String awJ;
        private final b awK;
        private final int awL;
        private final long startTimeMillis;

        /* JADX INFO: Access modifiers changed from: private */
        public void ch(String str) {
        }

        private a(com.applovin.impl.mediation.b.a aVar, b bVar) {
            super(e.this.tag, e.this.sdk, e.this.adUnitId);
            this.awJ = this.tag + CertificateUtil.DELIMITER + bVar;
            this.startTimeMillis = SystemClock.elapsedRealtime();
            this.amk = aVar;
            this.awK = bVar;
            this.awL = aVar.ah() + 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.awJ, "Loading ad " + this.awL + " of " + e.this.awD + " from " + this.amk.yz() + " for " + e.this.format + " ad unit " + e.this.adUnitId);
            }
            ch("started to load ad");
            Context context = (Context) e.this.alN.get();
            this.sdk.Cw().loadThirdPartyMediatedAd(e.this.adUnitId, this.amk, context instanceof Activity ? (Activity) context : this.sdk.CD(), new AnonymousClass1(e.this.awy));
        }

        /* JADX INFO: renamed from: com.applovin.impl.mediation.d.e$a$1, reason: invalid class name */
        class AnonymousClass1 extends com.applovin.impl.mediation.e.a {
            AnonymousClass1(com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
                super(interfaceC0117a);
            }

            @Override // com.applovin.impl.mediation.e.a, com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                boolean z;
                long jXs;
                com.applovin.impl.mediation.b.a aVar;
                a.this.ch("loaded ad");
                com.applovin.impl.mediation.b.a aVar2 = (com.applovin.impl.mediation.b.a) maxAd;
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                x unused = a.this.logger;
                if (x.Fk()) {
                    a.this.logger.f(a.this.awJ, "Ad (" + a.this.awL + ") loaded in " + jElapsedRealtime + "ms for " + e.this.format + " ad unit " + e.this.adUnitId);
                }
                e.this.a(aVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                e.this.d(a.this.awK);
                if (b.BIDDING == a.this.awK) {
                    z = e.this.awF.get();
                    jXs = aVar2.xt();
                } else {
                    z = e.this.awE.get();
                    jXs = aVar2.xs();
                }
                if (!z && jXs != 0) {
                    e.this.awH = aVar2;
                    if (jXs < 0) {
                        return;
                    }
                    e.this.awI = r.b(jXs, a.this.sdk, new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$e$a$1$_9lGWI84HD3eQy794V7DhU81Z3M
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.zI();
                        }
                    });
                    return;
                }
                if (a.this.i(aVar2)) {
                    aVar = aVar2;
                    aVar2 = e.this.awH;
                } else {
                    aVar = e.this.awH;
                }
                e.this.a(aVar2, aVar);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void zI() {
                e.this.h(e.this.awH);
            }

            @Override // com.applovin.impl.mediation.e.a, com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                x unused = a.this.logger;
                if (x.Fk()) {
                    a.this.logger.f(a.this.awJ, "Ad (" + a.this.awL + ") failed to load in " + jElapsedRealtime + "ms for " + e.this.format + " ad unit " + str + " with error: " + maxError);
                }
                a.this.ch("failed to load ad: " + maxError.getCode());
                e.this.a(a.this.amk, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                if (e.this.awG.get()) {
                    return;
                }
                if (e.this.awH != null) {
                    if (a.this.i(e.this.b(a.this.awK))) {
                        e.this.h(e.this.awH);
                        return;
                    }
                }
                if ((!e.this.a(a.this.awK)) && e.this.awF.get() && e.this.awE.get()) {
                    e.this.a(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i(com.applovin.impl.mediation.b.a aVar) {
            if (e.this.awH == null) {
                return false;
            }
            if (aVar == null) {
                return true;
            }
            double dXu = e.this.awH.xu();
            double dXu2 = aVar.xu();
            if (dXu < 0.0d || dXu2 < 0.0d) {
                return e.this.awH.ah() < aVar.ah();
            }
            return dXu > dXu2;
        }
    }
}
