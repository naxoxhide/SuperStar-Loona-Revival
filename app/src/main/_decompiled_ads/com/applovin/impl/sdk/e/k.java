package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends d {
    private final String aTY;
    protected final com.applovin.impl.sdk.ad.d azx;

    protected abstract d I(JSONObject jSONObject);

    protected abstract String zA();

    protected abstract String zB();

    public k(com.applovin.impl.sdk.ad.d dVar, String str, com.applovin.impl.sdk.n nVar) {
        super(str, nVar);
        this.azx = dVar;
        this.aTY = nVar.BG();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, Object> mapA;
        com.applovin.impl.sdk.utils.p.a aVarGU;
        Map<String, String> map;
        Map<String, Object> mapA2;
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Fetching next ad of zone: " + this.azx);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOE)).booleanValue() && com.applovin.impl.sdk.utils.u.Lx()) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "User is connected to a VPN");
            }
        }
        com.applovin.impl.sdk.d.g gVarBP = this.sdk.BP();
        gVarBP.a(com.applovin.impl.sdk.d.f.aSN);
        if (gVarBP.b(com.applovin.impl.sdk.d.f.aSQ) == 0) {
            gVarBP.b(com.applovin.impl.sdk.d.f.aSQ, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.sdk.BB().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNV)).booleanValue()) {
                aVarGU = com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPO)).intValue());
                if (this.sdk.BT() != null) {
                    mapA2 = this.sdk.BT().a(HG(), false, true);
                } else {
                    mapA2 = this.sdk.BQ().a(HG(), false, true);
                }
                JSONObject jSONObject = new JSONObject(mapA2);
                map = new HashMap<>();
                if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPX)).booleanValue() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
                    map.put("rid", UUID.randomUUID().toString());
                }
                if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
                }
                JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                andResetCustomPostBody = jSONObject;
            } else {
                com.applovin.impl.sdk.utils.p.a aVarGU2 = com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPP)).intValue());
                if (this.sdk.BT() != null) {
                    mapA = this.sdk.BT().a(HG(), false, false);
                } else {
                    mapA = this.sdk.BQ().a(HG(), false, false);
                }
                Map<String, String> mapS = com.applovin.impl.sdk.utils.u.s(mapA);
                if (andResetCustomPostBody == null) {
                    andResetCustomPostBody = null;
                    str = "GET";
                }
                aVarGU = aVarGU2;
                map = mapS;
            }
            if (com.applovin.impl.sdk.utils.u.ai(rQ())) {
                map.putAll(this.sdk.BB().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.aTY)) {
                map.put("sts", this.aTY);
            }
            a(gVarBP);
            com.applovin.impl.sdk.network.c.a aVarAT = com.applovin.impl.sdk.network.c.D(this.sdk).da(zA()).dc(zB()).k(map).db(str).l(zC()).ad(new JSONObject()).gC(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNK)).intValue()).aP(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNL)).booleanValue()).aQ(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNM)).booleanValue()).gD(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNJ)).intValue()).a(aVarGU).aT(true);
            if (andResetCustomPostBody != null) {
                aVarAT.K(andResetCustomPostBody);
                aVarAT.aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQh)).booleanValue());
            }
            final com.applovin.impl.sdk.network.c cVarIe = aVarAT.Ie();
            w<JSONObject> wVar = new w<JSONObject>(cVarIe, this.sdk) { // from class: com.applovin.impl.sdk.e.k.1
                @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void d(JSONObject jSONObject2, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject2, "ad_fetch_latency_millis", this.aHr.getLatencyMillis());
                        JsonUtils.putLong(jSONObject2, "ad_fetch_response_size", this.aHr.HJ());
                        k.this.q(jSONObject2);
                    } else {
                        k.this.e(i, MaxAdapterError.NO_FILL.getErrorMessage());
                        this.sdk.Cq().b(cVarIe.zJ(), "fetchAd", i);
                    }
                }

                @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
                public void a(int i, String str2, JSONObject jSONObject2) {
                    k.this.e(i, str2);
                    this.sdk.Cq().b(cVarIe.zJ(), "fetchAd", i);
                }
            };
            wVar.e(com.applovin.impl.sdk.c.b.aLp);
            wVar.f(com.applovin.impl.sdk.c.b.aLq);
            this.sdk.BM().b(wVar);
        } catch (Throwable th) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.c(this.tag, "Unable to fetch ad " + this.azx, th);
            }
            e(0, th.getMessage());
        }
    }

    protected com.applovin.impl.sdk.ad.b getSource() {
        return this.azx.FQ() ? com.applovin.impl.sdk.ad.b.APPLOVIN_PRIMARY_ZONE : com.applovin.impl.sdk.ad.b.APPLOVIN_CUSTOM_ZONE;
    }

    private Map<String, String> zC() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.azx.mQ());
        if (this.azx.getSize() != null) {
            map.put("AppLovin-Ad-Size", this.azx.getSize().getLabel());
        }
        if (this.azx.getType() != null) {
            map.put("AppLovin-Ad-Type", this.azx.getType().getLabel());
        }
        return map;
    }

    protected Map<String, String> HG() {
        HashMap map = new HashMap(4);
        map.put(AppLovinUtils.ServerParameterKeys.ZONE_ID, this.azx.mQ());
        if (this.azx.getSize() != null) {
            map.put("size", this.azx.getSize().getLabel());
        }
        if (this.azx.getType() != null) {
            map.put("require", this.azx.getType().getLabel());
        }
        return map;
    }

    protected void q(JSONObject jSONObject) {
        com.applovin.impl.sdk.utils.i.j(jSONObject, this.sdk);
        com.applovin.impl.sdk.utils.i.i(jSONObject, this.sdk);
        com.applovin.impl.sdk.utils.i.k(jSONObject, this.sdk);
        com.applovin.impl.sdk.ad.d.H(jSONObject);
        this.sdk.BM().b(I(jSONObject));
    }

    protected void e(int i, String str) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Unable to fetch " + this.azx + " ad: server returned " + i);
        }
        if (i == -800) {
            this.sdk.BP().a(com.applovin.impl.sdk.d.f.aSW);
        }
    }

    private void a(com.applovin.impl.sdk.d.g gVar) {
        long jB = gVar.b(com.applovin.impl.sdk.d.f.aSQ);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB > TimeUnit.MINUTES.toMillis(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aOf)).intValue())) {
            gVar.b(com.applovin.impl.sdk.d.f.aSQ, jCurrentTimeMillis);
            gVar.c(com.applovin.impl.sdk.d.f.aSR);
            gVar.c(com.applovin.impl.sdk.d.f.aSS);
        }
    }
}
