package com.applovin.impl.mediation.d;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends com.applovin.impl.sdk.e.d {
    private static final AtomicBoolean aww = new AtomicBoolean();
    private final List<MaxNetworkResponseInfo> akY;
    private final String awR;
    private final MaxAdFormat awS;
    private final JSONObject awT;
    private final List<com.applovin.impl.mediation.b.a> awU;
    private final com.applovin.impl.mediation.ads.a.InterfaceC0117a awV;
    private final WeakReference<Context> awW;
    private long startTimeMillis;

    f(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, n nVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        super("TaskProcessMediationWaterfall", nVar, str);
        this.awR = str;
        this.awS = maxAdFormat;
        this.awT = jSONObject;
        this.awV = interfaceC0117a;
        this.awW = new WeakReference<>(context);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        this.awU = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            this.awU.add(com.applovin.impl.mediation.b.a.a(i, map, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, nVar));
        }
        this.akY = new ArrayList(this.awU.size());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.startTimeMillis = SystemClock.elapsedRealtime();
        if (this.awT.optBoolean("is_testing", false) && !this.sdk.CC().isEnabled() && aww.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$f$arnj0VTRLhIQOfCBYG-doW7gjnY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.zH();
                }
            });
        }
        if (this.awU.size() > 0) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Starting waterfall for " + this.awS.getLabel() + " ad unit " + this.awR + " with " + this.awU.size() + " ad(s)...");
            }
            this.sdk.BM().b(new a(0, this.awU));
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.h(this.tag, "No ads were returned from the server for " + this.awS.getLabel() + " ad unit " + this.awR);
        }
        u.a(this.awR, this.awS, this.awT, this.sdk);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.awT, "settings", new JSONObject());
        long j = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j > 0) {
            long millis = TimeUnit.SECONDS.toMillis(j);
            Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$f$w429SYDfaTU6QkS5SDwVBXyGyv0
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zH() {
        u.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.sdk.CD());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.applovin.impl.mediation.b.a aVar) {
        this.sdk.CA().l(aVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.startTimeMillis;
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.g(this.tag, "Waterfall loaded in " + jElapsedRealtime + "ms from " + aVar.yz() + " for " + this.awS.getLabel() + " ad unit " + this.awR);
        }
        aVar.setWaterfall(new MaxAdWaterfallInfoImpl(aVar, jElapsedRealtime, this.akY));
        m.a((MaxAdListener) this.awV, (MaxAd) aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(MaxError maxError) {
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
            int i = 0;
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
            this.logger.g(this.tag, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.awS.getLabel() + " ad unit " + this.awR + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.awT, "waterfall_name", ""), JsonUtils.getString(this.awT, "waterfall_test_name", ""), jElapsedRealtime, this.akY));
        m.a(this.awV, this.awR, maxError);
    }

    private class a extends com.applovin.impl.sdk.e.d {
        private final com.applovin.impl.mediation.b.a amk;
        private final int awX;
        private final List<com.applovin.impl.mediation.b.a> awY;
        private final long startTimeMillis;

        /* JADX INFO: Access modifiers changed from: private */
        public void ch(String str) {
        }

        a(int i, List<com.applovin.impl.mediation.b.a> list) {
            super(f.this.tag, f.this.sdk, f.this.awR);
            this.startTimeMillis = SystemClock.elapsedRealtime();
            this.awX = i;
            this.amk = list.get(i);
            this.awY = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Loading ad " + (this.awX + 1) + " of " + this.awY.size() + " from " + this.amk.yz() + " for " + f.this.awS.getLabel() + " ad unit " + f.this.awR);
            }
            ch("started to load ad");
            Context context = (Context) f.this.awW.get();
            this.sdk.Cw().loadThirdPartyMediatedAd(f.this.awR, this.amk, context instanceof Activity ? (Activity) context : this.sdk.CD(), new com.applovin.impl.mediation.e.a(f.this.awV) { // from class: com.applovin.impl.mediation.d.f.a.1
                @Override // com.applovin.impl.mediation.e.a, com.applovin.mediation.MaxAdListener
                public void onAdLoaded(MaxAd maxAd) {
                    a.this.ch("loaded ad");
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fk()) {
                        a.this.logger.f(a.this.tag, "Ad loaded in " + jElapsedRealtime + "ms for " + f.this.awS.getLabel() + " ad unit " + f.this.awR);
                    }
                    com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
                    a.this.a(aVar, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                    int i = a.this.awX;
                    while (true) {
                        i++;
                        if (i >= a.this.awY.size()) {
                            f.this.h(aVar);
                            return;
                        } else {
                            a aVar2 = a.this;
                            aVar2.a((com.applovin.impl.mediation.b.a) aVar2.awY.get(i), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
                        }
                    }
                }

                @Override // com.applovin.impl.mediation.e.a, com.applovin.mediation.MaxAdListener
                public void onAdLoadFailed(String str, MaxError maxError) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.startTimeMillis;
                    x unused = a.this.logger;
                    if (x.Fk()) {
                        a.this.logger.f(a.this.tag, "Ad failed to load in " + jElapsedRealtime + " ms for " + f.this.awS.getLabel() + " ad unit " + f.this.awR + " with error: " + maxError);
                    }
                    a.this.ch("failed to load ad: " + maxError.getCode());
                    a aVar = a.this;
                    aVar.a(aVar.amk, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                    if (a.this.awX < a.this.awY.size() - 1) {
                        a.this.sdk.BM().a(f.this.new a(a.this.awX + 1, a.this.awY), com.applovin.impl.mediation.e.c.f(f.this.awS));
                    } else {
                        f.this.a(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.applovin.impl.mediation.b.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
            f.this.akY.add(new MaxNetworkResponseInfoImpl(adLoadState, new MaxMediatedNetworkInfoImpl(com.applovin.impl.mediation.e.c.a(aVar.vt(), this.sdk)), aVar.getCredentials(), aVar.isBidding(), j, maxError));
        }
    }
}
