package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {
    private final AtomicReference<JSONObject> amD = new AtomicReference<>();
    private final x logger;
    private final n sdk;

    public MediationServiceImpl(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, d.a aVar, Map<String, Object> map, Map<String, Object> map2, Context context, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No Ad Unit ID specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (interfaceC0117a == null) {
            throw new IllegalArgumentException("No listener specified");
        }
        if (TextUtils.isEmpty(this.sdk.getMediationProvider())) {
            x.H("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
        }
        if (!this.sdk.isEnabled()) {
            x.F("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.sdk.Bj();
        if (str.length() != 16 && !str.startsWith("test_mode") && !this.sdk.getSdkKey().startsWith("05TMD")) {
            x.H("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
        }
        if (this.sdk.g(maxAdFormat)) {
            x.H("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
            m.a(interfaceC0117a, str, new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
        } else {
            this.sdk.BF();
            m.a((MaxAdRequestListener) interfaceC0117a, str, true, true);
            this.sdk.CB().a(str, str2, maxAdFormat, aVar, map, map2, context, interfaceC0117a);
        }
    }

    public void showFullscreenAd(final com.applovin.impl.mediation.b.c cVar, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null && MaxAdFormat.APP_OPEN != cVar.getFormat()) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.sdk.Cd().aM(true);
        final g gVarG = g(cVar);
        long jYa = cVar.ya();
        if (x.Fk()) {
            this.logger.g("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + jYa + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$MediationServiceImpl$j5VpcziHyOleTXKWQrOPUJNCviE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(cVar, gVarG, activity, interfaceC0117a);
            }
        }, jYa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.b.c cVar, g gVar, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        cVar.aH(true);
        h(cVar);
        gVar.a(cVar, activity);
        a(cVar, interfaceC0117a);
    }

    public void showFullscreenAd(final com.applovin.impl.mediation.b.c cVar, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity, final com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.sdk.Cd().aM(true);
        final g gVarG = g(cVar);
        long jYa = cVar.ya();
        if (x.Fk()) {
            this.logger.g("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + jYa + "ms...");
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$MediationServiceImpl$AzFhxkMxnPB-FGQLkk-1n5lP7Nw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(cVar, gVarG, viewGroup, lifecycle, activity, interfaceC0117a);
            }
        }, jYa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.b.c cVar, g gVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        cVar.aH(true);
        h(cVar);
        gVar.a(cVar, viewGroup, lifecycle, activity);
        a(cVar, interfaceC0117a);
    }

    private g g(com.applovin.impl.mediation.b.c cVar) {
        g gVarXB = cVar.xB();
        if (gVarXB != null) {
            return gVarXB;
        }
        this.sdk.Cd().aM(false);
        if (x.Fk()) {
            this.logger.h("MediationService", "Failed to show " + cVar + ": adapter not found");
        }
        x.H("MediationService", "There may be an integration problem with the adapter for Ad Unit ID '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    private void h(com.applovin.impl.mediation.b.c cVar) {
        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.sdk.BM().a(new com.applovin.impl.mediation.d.h(cVar, this.sdk), q.b.MEDIATION_REWARD);
        }
    }

    private void a(com.applovin.impl.mediation.b.c cVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        this.sdk.Cd().aM(false);
        a(cVar, (MaxAdListener) interfaceC0117a);
        if (x.Fk()) {
            this.logger.f("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpressionPostback(cVar, interfaceC0117a);
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.b.a) {
            if (x.Fk()) {
                this.logger.g("MediationService", "Destroying " + maxAd);
            }
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) maxAd;
            g gVarXB = aVar.xB();
            if (gVarXB != null) {
                gVarXB.destroy();
                aVar.xP();
            }
            this.sdk.Ct().cz(aVar.xz());
        }
    }

    public void loadThirdPartyMediatedAd(String str, com.applovin.impl.mediation.b.a aVar, Activity activity, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (aVar == null) {
            throw new IllegalArgumentException("No mediated ad specified");
        }
        if (x.Fk()) {
            this.logger.f("MediationService", "Loading " + aVar + "...");
        }
        this.sdk.Cf().a(aVar, "WILL_LOAD");
        g gVarC = this.sdk.Cu().c(aVar);
        if (gVarC != null) {
            MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(aVar);
            this.sdk.Cv().a(aVar, activity);
            com.applovin.impl.mediation.b.a aVarK = aVar.k(gVarC);
            gVarC.a(str, aVarK);
            aVarK.xK();
            gVarC.a(str, maxAdapterParametersImplA, aVarK, activity, new a(aVarK, interfaceC0117a));
            return;
        }
        String str2 = "Failed to load " + aVar + ": adapter not loaded";
        x.H("MediationService", str2);
        a(aVar, new MaxErrorImpl(-5001, str2), interfaceC0117a);
    }

    public void collectSignal(final String str, MaxAdFormat maxAdFormat, final com.applovin.impl.mediation.b.h hVar, Context context, final com.applovin.impl.mediation.b.g.a aVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        final g gVarA = this.sdk.Cu().a(hVar, hVar.yJ());
        if (gVarA != null) {
            Activity activityCD = context instanceof Activity ? (Activity) context : this.sdk.CD();
            MaxAdapterParametersImpl maxAdapterParametersImplA = MaxAdapterParametersImpl.a(hVar, str, maxAdFormat);
            this.sdk.Cv().a(hVar, activityCD);
            MaxSignalCollectionListener maxSignalCollectionListener = new MaxSignalCollectionListener() { // from class: com.applovin.impl.mediation.MediationServiceImpl.1
                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollected(String str2) {
                    x unused = MediationServiceImpl.this.logger;
                    if (x.Fk()) {
                        MediationServiceImpl.this.logger.f("MediationService", "Signal collection successful from: " + gVarA.getName() + " for Ad Unit ID: " + str + " with signal: \"" + str2 + "\"");
                    }
                    aVar.a(com.applovin.impl.mediation.b.g.a(hVar, gVarA, str2));
                    gVarA.destroy();
                }

                @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
                public void onSignalCollectionFailed(String str2) {
                    x unused = MediationServiceImpl.this.logger;
                    if (x.Fk()) {
                        MediationServiceImpl.this.logger.i("MediationService", "Signal collection failed from: " + gVarA.getName() + " for Ad Unit ID: " + str + " with error message: \"" + str2 + "\"");
                    }
                    MediationServiceImpl.this.a(str2, hVar, gVarA);
                    aVar.a(com.applovin.impl.mediation.b.g.b(hVar, gVarA, str2));
                    gVarA.destroy();
                }
            };
            if (hVar.yI()) {
                if (this.sdk.Cv().b(hVar)) {
                    if (x.Fk()) {
                        this.logger.f("MediationService", "Collecting signal for now-initialized adapter: " + gVarA.getName());
                    }
                    gVarA.a(maxAdapterParametersImplA, hVar, activityCD, maxSignalCollectionListener);
                    return;
                } else {
                    if (x.Fk()) {
                        this.logger.i("MediationService", "Skip collecting signal for not-initialized adapter: " + gVarA.getName());
                    }
                    aVar.a(com.applovin.impl.mediation.b.g.a(hVar, "Adapter not initialized yet"));
                    return;
                }
            }
            if (x.Fk()) {
                this.logger.f("MediationService", "Collecting signal for adapter: " + gVarA.getName());
            }
            gVarA.a(maxAdapterParametersImplA, hVar, activityCD, maxSignalCollectionListener);
            return;
        }
        aVar.a(com.applovin.impl.mediation.b.g.a(hVar, "Could not load adapter"));
    }

    private void a(final com.applovin.impl.mediation.b.c cVar, final MaxAdListener maxAdListener) {
        final Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJH);
        if (l.longValue() <= 0) {
            return;
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$MediationServiceImpl$LMnrCiPIiQzBDIy9ngj1VxLrrzg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(cVar, l, maxAdListener);
            }
        }, l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.mediation.b.c cVar, Long l, MaxAdListener maxAdListener) {
        if (cVar.xN().get()) {
            return;
        }
        String str = "Ad (" + cVar.yA() + ") has not been displayed after " + l + "ms. Failing ad display...";
        x.H("MediationService", str);
        b(cVar, new MaxErrorImpl(-1, str), maxAdListener);
        this.sdk.Cd().ac(cVar);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.amD.set(jSONObject);
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return this.amD.getAndSet(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, aVar);
        destroyAd(aVar);
        m.a(maxAdListener, aVar.getAdUnitId(), maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.b.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.sdk.Cf().a(aVar, "DID_FAIL_DISPLAY");
        a(maxError, aVar, true);
        if (aVar.xN().compareAndSet(false, true)) {
            m.a(maxAdListener, aVar, maxError);
        }
    }

    public void processAdLossPostback(com.applovin.impl.mediation.b.a aVar, Float f) {
        String string = f != null ? f.toString() : "";
        HashMap map = new HashMap(1);
        map.put("{MBR}", string);
        a("mloss", map, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.applovin.impl.mediation.b.a aVar) {
        this.sdk.Cf().a(aVar, "DID_LOAD");
        if (aVar.xy().endsWith("load")) {
            this.sdk.Cf().j(aVar);
        }
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(aVar.xI()));
        if (aVar.getFormat().isFullscreenAd()) {
            u.a aVarCL = this.sdk.Cd().cL(aVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarCL.Fc()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarCL.Fb()));
        }
        a("load", map, aVar);
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.b.a aVar) {
        HashMap map = new HashMap(3);
        map.put("{LOAD_TIME_MS}", String.valueOf(aVar.xI()));
        if (aVar.getFormat().isFullscreenAd()) {
            u.a aVarCL = this.sdk.Cd().cL(aVar.getAdUnitId());
            map.put("{SHOW_ATTEMPT_COUNT}", String.valueOf(aVarCL.Fc()));
            map.put("{SHOW_ATTEMPT_TIMESTAMP_MS}", String.valueOf(aVarCL.Fb()));
        }
        a("mlerr", map, maxError, aVar);
    }

    public void processAdapterInitializationPostback(com.applovin.impl.mediation.b.f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap map = new HashMap(2);
        map.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        map.put("{INIT_TIME_MS}", String.valueOf(j));
        a("minit", map, new MaxErrorImpl(str), fVar);
    }

    public void processRawAdImpressionPostback(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        this.sdk.Cf().a(aVar, "WILL_DISPLAY");
        if (aVar.xy().endsWith("mimp")) {
            this.sdk.Cf().j(aVar);
            m.a((MaxAdRevenueListener) interfaceC0117a, (MaxAd) aVar);
        }
        HashMap map = new HashMap(2);
        if (aVar instanceof com.applovin.impl.mediation.b.c) {
            map.put("{TIME_TO_SHOW_MS}", String.valueOf(((com.applovin.impl.mediation.b.c) aVar).xZ()));
        }
        String strEmptyIfNull = StringUtils.emptyIfNull(this.sdk.Bx());
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOv)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mimp", map, aVar);
    }

    public void processViewabilityAdImpressionPostback(com.applovin.impl.mediation.b.e eVar, long j, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (eVar.xy().endsWith("vimp")) {
            this.sdk.Cf().j(eVar);
            m.a((MaxAdRevenueListener) interfaceC0117a, (MaxAd) eVar);
        }
        HashMap map = new HashMap(3);
        map.put("{VIEWABILITY_FLAGS}", String.valueOf(j));
        map.put("{USED_VIEWABILITY_TIMER}", String.valueOf(eVar.yv()));
        String strEmptyIfNull = StringUtils.emptyIfNull(this.sdk.Bx());
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOv)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mvimp", map, eVar);
    }

    public void processCallbackAdImpressionPostback(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        if (aVar.xy().endsWith("cimp")) {
            this.sdk.Cf().j(aVar);
            m.a((MaxAdRevenueListener) interfaceC0117a, (MaxAd) aVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.sdk.Bx());
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOv)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mcimp", map, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
        this.sdk.Cf().a(aVar, "DID_CLICKED");
        this.sdk.Cf().a(aVar, "DID_CLICK");
        if (aVar.xy().endsWith("click")) {
            this.sdk.Cf().j(aVar);
            m.a((MaxAdRevenueListener) interfaceC0117a, (MaxAd) aVar);
        }
        HashMap map = new HashMap(1);
        String strEmptyIfNull = StringUtils.emptyIfNull(this.sdk.Bx());
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOv)).booleanValue()) {
            strEmptyIfNull = "";
        }
        map.put("{CUID}", strEmptyIfNull);
        a("mclick", map, aVar);
    }

    public void processAdDisplayErrorPostbackForUserError(MaxError maxError, com.applovin.impl.mediation.b.a aVar) {
        a(maxError, aVar, false);
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.b.a aVar, boolean z) {
        a("mierr", Collections.EMPTY_MAP, maxError, aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.applovin.impl.mediation.b.h hVar, g gVar) {
        HashMap map = new HashMap(2);
        CollectionUtils.putStringIfValid("{ADAPTER_VERSION}", gVar.getAdapterVersion(), map);
        CollectionUtils.putStringIfValid("{SDK_VERSION}", gVar.getSdkVersion(), map);
        a("serr", map, new MaxErrorImpl(str), hVar);
    }

    private void a(String str, Map<String, String> map, com.applovin.impl.mediation.b.f fVar) {
        a(str, map, (MaxError) null, fVar);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, com.applovin.impl.mediation.b.f fVar) {
        a(str, map, maxError, fVar, true);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, com.applovin.impl.mediation.b.f fVar, boolean z) {
        Map map2 = CollectionUtils.map(map);
        map2.put("{PLACEMENT}", z ? StringUtils.emptyIfNull(fVar.getPlacement()) : "");
        map2.put("{CUSTOM_DATA}", z ? StringUtils.emptyIfNull(fVar.yF()) : "");
        if (fVar instanceof com.applovin.impl.mediation.b.a) {
            map2.put("{CREATIVE_ID}", z ? StringUtils.emptyIfNull(((com.applovin.impl.mediation.b.a) fVar).getCreativeId()) : "");
        }
        this.sdk.BM().a(new com.applovin.impl.mediation.d.d(str, map2, maxError, fVar, this.sdk, z), q.b.MEDIATION_POSTBACKS);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object objFa = this.sdk.Cd().Fa();
            if (objFa instanceof com.applovin.impl.mediation.b.a) {
                a((MaxError) MaxAdapterError.WEBVIEW_ERROR, (com.applovin.impl.mediation.b.a) objFa, true);
            }
        }
    }

    public class a implements com.applovin.impl.mediation.ads.a.InterfaceC0117a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
        private final com.applovin.impl.mediation.b.a amI;
        private com.applovin.impl.mediation.ads.a.InterfaceC0117a amJ;

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        public a(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
            this.amI = aVar;
            this.amJ = interfaceC0117a;
        }

        public void a(com.applovin.impl.mediation.ads.a.InterfaceC0117a interfaceC0117a) {
            this.amJ = interfaceC0117a;
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            a(maxAd, null);
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            this.amI.xM();
            MediationServiceImpl.this.d(this.amI);
            m.a((MaxAdListener) this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            this.amI.xM();
            MediationServiceImpl.this.a(this.amI, maxError, this.amJ);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
            b(maxAd, null);
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            x unused = MediationServiceImpl.this.logger;
            if (x.Fk()) {
                MediationServiceImpl.this.logger.f("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.amI, this.amJ);
            MediationServiceImpl.this.sdk.BP().a(com.applovin.impl.sdk.d.f.aSP);
            MediationServiceImpl.this.sdk.BP().a(com.applovin.impl.sdk.d.f.aSS);
            if (!maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.sdk.Cf().a(this.amI, "DID_DISPLAY");
                m.b(this.amJ, maxAd);
                return;
            }
            com.applovin.impl.mediation.b.c cVar = (com.applovin.impl.mediation.b.c) maxAd;
            if (cVar.yj()) {
                MediationServiceImpl.this.sdk.Cf().a(this.amI, "DID_DISPLAY");
                MediationServiceImpl.this.sdk.Cd().ab(this.amI);
                m.b(this.amJ, maxAd);
            } else {
                x unused2 = MediationServiceImpl.this.logger;
                if (x.Fk()) {
                    MediationServiceImpl.this.logger.h("MediationService", "Received ad display callback before attempting show" + (cVar.xE() ? " for hybrid ad" : ""));
                }
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            c(maxAd, null);
        }

        public void c(final MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            MediationServiceImpl.this.sdk.Cf().a((com.applovin.impl.mediation.b.a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.-$$Lambda$MediationServiceImpl$a$HpYJ9jiuri_0q5iYvLooVuPp6hQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(maxAd);
                }
            }, maxAd instanceof com.applovin.impl.mediation.b.c ? ((com.applovin.impl.mediation.b.c) maxAd).yb() : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.sdk.Cd().ac(maxAd);
            }
            m.c(this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            d(maxAd, null);
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            MediationServiceImpl.this.a(this.amI, this.amJ);
            m.d(this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            a(maxAd, maxError, (Bundle) null);
        }

        public void a(MaxAd maxAd, MaxError maxError, Bundle bundle) {
            this.amI.S(bundle);
            MediationServiceImpl.this.b(this.amI, maxError, this.amJ);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof com.applovin.impl.mediation.b.c)) {
                ((com.applovin.impl.mediation.b.c) maxAd).yf();
            }
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoStarted(MaxAd maxAd) {
            m.e(this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onRewardedVideoCompleted(MaxAd maxAd) {
            m.f(this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxRewardedAdListener
        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            a(maxAd, maxReward, (Bundle) null);
        }

        public void a(MaxAd maxAd, MaxReward maxReward, Bundle bundle) {
            this.amI.S(bundle);
            m.a(this.amJ, maxAd, maxReward);
            MediationServiceImpl.this.sdk.BM().a(new com.applovin.impl.mediation.d.g((com.applovin.impl.mediation.b.c) maxAd, MediationServiceImpl.this.sdk), q.b.MEDIATION_REWARD);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdExpanded(MaxAd maxAd) {
            e(maxAd, null);
        }

        public void e(MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            m.g(this.amJ, maxAd);
        }

        @Override // com.applovin.mediation.MaxAdViewAdListener
        public void onAdCollapsed(MaxAd maxAd) {
            f(maxAd, null);
        }

        public void f(MaxAd maxAd, Bundle bundle) {
            this.amI.S(bundle);
            m.h(this.amJ, maxAd);
        }
    }
}
