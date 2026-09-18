package com.applovin.impl.mediation.debugger.c;

import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.p;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {
    private final com.applovin.impl.sdk.network.b.d<JSONObject> apP;

    public c(com.applovin.impl.sdk.network.b.d<JSONObject> dVar, n nVar) {
        super("TaskFetchMediationDebuggerInfo", nVar, true);
        this.apP = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, String> mapVQ = vQ();
        JSONObject jSONObjectVR = vR();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPW)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            JsonUtils.putAll(jSONObjectVR, mapVQ);
            mapVQ = null;
        }
        w<JSONObject> wVar = new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).db("POST").da(com.applovin.impl.mediation.e.b.d(this.sdk)).dc(com.applovin.impl.mediation.e.b.e(this.sdk)).k(mapVQ).K(jSONObjectVR).ad(new JSONObject()).gD(((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJg)).intValue()).a(p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPN)).intValue())).Ie(), this.sdk, Kf()) { // from class: com.applovin.impl.mediation.debugger.c.c.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject, int i) {
                c.this.apP.d(jSONObject, i);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject) {
                c.this.apP.a(i, str, jSONObject);
            }
        };
        wVar.e(com.applovin.impl.sdk.c.a.aJc);
        wVar.f(com.applovin.impl.sdk.c.a.aJd);
        this.sdk.BM().b(wVar);
    }

    protected Map<String, String> vQ() {
        Map<String, Object> mapCY;
        Map<String, Object> mapCQ;
        HashMap map = new HashMap();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPG)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        if (this.sdk.BT() != null) {
            mapCY = this.sdk.BT().DF();
            mapCQ = this.sdk.BT().CQ();
        } else {
            mapCY = this.sdk.BQ().CY();
            mapCQ = this.sdk.BQ().CQ();
        }
        map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, String.valueOf(mapCY.get(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        map.put(TapjoyConstants.TJC_APP_VERSION_NAME, String.valueOf(mapCY.get(TapjoyConstants.TJC_APP_VERSION_NAME)));
        map.put(TapjoyConstants.TJC_PLATFORM, String.valueOf(mapCQ.get(TapjoyConstants.TJC_PLATFORM)));
        map.put("os", String.valueOf(mapCQ.get("os")));
        return map;
    }

    private JSONObject vR() {
        com.applovin.impl.sdk.utils.d.a aVarDf;
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", com.applovin.impl.mediation.e.c.f(this.sdk));
        if (this.sdk.BT() != null) {
            aVarDf = this.sdk.BS().DJ();
        } else {
            aVarDf = this.sdk.BQ().Df();
        }
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVarDf.KQ().KR());
        Boolean boolB = com.applovin.impl.privacy.a.zM().B(rQ());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOw)).booleanValue() && !Boolean.TRUE.equals(boolB)) {
            JsonUtils.putStringIfValid(jSONObject, "idfa", aVarDf.KP());
        }
        return jSONObject;
    }
}
