package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.m;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public e adSpot;
    public MarketplaceAuctionParameters mMarketplaceAuctionParameters;
    private com.fyber.marketplace.fairbid.impl.c mMarketplaceAuctionResponse;
    private boolean mMuted;
    public String mPlacementId;
    public com.fyber.inneractive.sdk.dv.g mWrapperQueryInfo;

    /* JADX INFO: renamed from: com.fyber.marketplace.fairbid.impl.a$a, reason: collision with other inner class name */
    public class RunnableC0311a implements Runnable {
        public final /* synthetic */ MarketplaceAdLoadListener a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.fyber.inneractive.sdk.response.a f1375b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ InneractiveUnitController e;

        public RunnableC0311a(MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map map, InneractiveUnitController inneractiveUnitController) {
            this.a = marketplaceAdLoadListener;
            this.f1375b = aVar;
            this.c = str;
            this.d = map;
            this.e = inneractiveUnitController;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.loadParsedData(this.e, this.a, a.this.parseResponseData(this.a, this.f1375b, this.c, this.d), a.this.getAdContentLoader(this.a, this.f1375b));
        }
    }

    public class c implements n {
        public final /* synthetic */ Map a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1377b;

        public c(a aVar, Map map, String str) {
            this.a = map;
            this.f1377b = str;
        }

        @Override // com.fyber.inneractive.sdk.network.n
        public StringBuffer e() {
            return new StringBuffer(this.f1377b);
        }

        @Override // com.fyber.inneractive.sdk.network.n
        public Map<String, String> t() {
            return this.a;
        }
    }

    public a(String str, JSONObject jSONObject, Map<String, String> map, boolean z, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        Map<String, String> mapLowerCaseHeaders = lowerCaseHeaders(map);
        com.fyber.inneractive.sdk.response.a responseAdType = getResponseAdType(mapLowerCaseHeaders);
        this.mMarketplaceAuctionParameters = marketplaceAuctionParameters;
        this.mPlacementId = str;
        if (responseAdType != null) {
            this.mMarketplaceAuctionResponse = new com.fyber.marketplace.fairbid.impl.c(jSONObject, responseAdType, mapLowerCaseHeaders);
        }
        this.mMuted = z;
    }

    private void fireAdLoadFailedEvent(MarketplaceAdLoadError marketplaceAdLoadError) {
        if (isFullscreen()) {
            IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", marketplaceAdLoadError.getErrorMessage());
            s.a aVar = new s.a(q.IA_AD_LOAD_FAILED, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null, (JSONArray) null);
            JSONObject jSONObject = new JSONObject();
            String string = marketplaceAdLoadError.toString();
            try {
                jSONObject.put("message", string);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "message", string);
            }
            String errorMessage = marketplaceAdLoadError.getErrorMessage();
            try {
                jSONObject.put("extra_description", errorMessage);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "extra_description", errorMessage);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    private com.fyber.inneractive.sdk.response.b generateParser(com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        com.fyber.inneractive.sdk.response.b bVarA = com.fyber.inneractive.sdk.factories.b.a.a.a(aVar);
        IAlog.a("IA Exchange response handler: final headers: %s", map);
        if (bVarA != null) {
            c cVar = new c(this, map, str);
            bVarA.a = bVarA.a();
            bVarA.c = new k(cVar);
        }
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadParsedData(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.e eVar, com.fyber.inneractive.sdk.interfaces.a aVar) {
        if (eVar == null || aVar == null) {
            return;
        }
        m.f1343b.post(new b(eVar, aVar, inneractiveUnitController, marketplaceAdLoadListener));
    }

    public com.fyber.inneractive.sdk.interfaces.a getAdContentLoader(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar) {
        com.fyber.inneractive.sdk.factories.b.InterfaceC0266b interfaceC0266b = com.fyber.inneractive.sdk.factories.b.a.a.a.get(aVar);
        com.fyber.inneractive.sdk.interfaces.a aVarA = interfaceC0266b != null ? interfaceC0266b.a() : null;
        if (aVarA != null) {
            return aVarA;
        }
        notifyFailToListener(MarketplaceAdLoadError.UNSUPPORTED_AD_TYPE, marketplaceAdLoadListener);
        return null;
    }

    public com.fyber.inneractive.sdk.response.a getResponseAdType(Map<String, String> map) {
        String str = map.get(com.fyber.inneractive.sdk.network.m.RETURNED_AD_TYPE.key.toLowerCase(Locale.ENGLISH));
        if (str == null) {
            return null;
        }
        try {
            return com.fyber.inneractive.sdk.response.a.a(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public abstract void internalOnAdLoaded(a aVar, e eVar);

    public abstract boolean isFullscreen();

    public boolean isMuted() {
        return this.mMuted;
    }

    public void loadAd(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        com.fyber.marketplace.fairbid.impl.c cVar = this.mMarketplaceAuctionResponse;
        if (cVar == null) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            return;
        }
        com.fyber.inneractive.sdk.response.a aVar = cVar.f1379b;
        String str = cVar.a;
        Map<String, String> map = cVar.c;
        if (aVar == null || str == null || map.isEmpty()) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
        } else {
            m.a(new RunnableC0311a(marketplaceAdLoadListener, aVar, str, map, inneractiveUnitController));
        }
    }

    public Map<String, String> lowerCaseHeaders(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            for (String str : map.keySet()) {
                map2.put(TextUtils.isEmpty(str) ? str : str.toLowerCase(Locale.ENGLISH), map.get(str));
            }
        }
        return map2;
    }

    public void notifyFailToListener(MarketplaceAdLoadError marketplaceAdLoadError, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        fireAdLoadFailedEvent(marketplaceAdLoadError);
        marketplaceAdLoadListener.onAdLoadFailed(marketplaceAdLoadError);
    }

    public com.fyber.inneractive.sdk.response.e parseResponseData(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        try {
            com.fyber.inneractive.sdk.response.e eVarA = generateParser(aVar, str, map).a(str);
            com.fyber.inneractive.sdk.dv.g gVar = this.mWrapperQueryInfo;
            if (gVar != null) {
                eVarA.s = gVar;
            }
            InneractiveErrorCode inneractiveErrorCodeA = eVarA.a((InneractiveAdRequest) null);
            if (inneractiveErrorCodeA == null) {
                return eVarA;
            }
            notifyFailToListener(MarketplaceAdLoadError.RESPONSE_VALIDATION_FAILED, marketplaceAdLoadListener);
            IAlog.a("failed parsing response data with error: %s", inneractiveErrorCodeA.toString());
            return null;
        } catch (Exception e) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            if (e.getMessage() != null) {
                IAlog.a("failed parsing response data with error: %s", e.getMessage());
            }
            return null;
        }
    }

    public void setQueryInfo(com.fyber.inneractive.sdk.dv.g gVar) {
        this.mWrapperQueryInfo = gVar;
    }

    public class b implements Runnable {
        public final /* synthetic */ com.fyber.inneractive.sdk.response.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.fyber.inneractive.sdk.interfaces.a f1376b;
        public final /* synthetic */ InneractiveUnitController c;
        public final /* synthetic */ MarketplaceAdLoadListener d;

        public b(com.fyber.inneractive.sdk.response.e eVar, com.fyber.inneractive.sdk.interfaces.a aVar, InneractiveUnitController inneractiveUnitController, MarketplaceAdLoadListener marketplaceAdLoadListener) {
            this.a = eVar;
            this.f1376b = aVar;
            this.c = inneractiveUnitController;
            this.d = marketplaceAdLoadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            com.fyber.inneractive.sdk.config.global.s featureProvider = aVar.mMarketplaceAuctionParameters.getFeatureProvider(aVar.mPlacementId);
            if (featureProvider == null) {
                featureProvider = com.fyber.inneractive.sdk.config.global.s.b();
            }
            com.fyber.inneractive.sdk.config.global.s sVar = featureProvider;
            com.fyber.inneractive.sdk.response.e eVar = this.a;
            com.fyber.inneractive.sdk.config.global.e eVar2 = new com.fyber.inneractive.sdk.config.global.e();
            ImpressionData impressionData = eVar.r;
            eVar2.a = impressionData != null ? impressionData.getDemandId() : null;
            try {
                eVar2.f876b = Long.valueOf(IAConfigManager.M.d);
            } catch (NumberFormatException unused) {
                IAlog.a("invalid publisherId", new Object[0]);
            }
            sVar.a(eVar2);
            com.fyber.inneractive.sdk.interfaces.a aVar2 = this.f1376b;
            com.fyber.inneractive.sdk.response.e eVar3 = this.a;
            boolean z = a.this.mMuted;
            C0312a c0312a = new C0312a();
            com.fyber.inneractive.sdk.flow.h hVar = (com.fyber.inneractive.sdk.flow.h) aVar2;
            hVar.h = z;
            hVar.a(null, eVar3, sVar, c0312a, null);
        }

        /* JADX INFO: renamed from: com.fyber.marketplace.fairbid.impl.a$b$a, reason: collision with other inner class name */
        public class C0312a implements com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a {
            public C0312a() {
            }

            @Override // com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a
            public void a(InneractiveAdRequest inneractiveAdRequest) {
                b bVar = b.this;
                a.this.adSpot = new e(bVar.c, ((com.fyber.inneractive.sdk.flow.h) bVar.f1376b).c);
                a aVar = a.this;
                aVar.internalOnAdLoaded(aVar, aVar.adSpot);
            }

            @Override // com.fyber.inneractive.sdk.interfaces.a.InterfaceC0270a
            public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
                b.this.d.onAdLoadFailed(MarketplaceAdLoadError.FAILED_TO_LOAD_AD);
            }
        }
    }
}
