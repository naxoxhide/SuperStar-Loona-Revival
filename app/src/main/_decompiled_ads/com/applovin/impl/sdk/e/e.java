package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class e extends d {
    e(com.applovin.impl.sdk.n nVar) {
        super("TaskApiSubmitData", nVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.g(this.tag, "Submitting user data...");
        }
        Map<String, String> mapF = com.applovin.impl.sdk.utils.i.F(this.sdk);
        JSONObject jSONObject = new JSONObject();
        O(jSONObject);
        P(jSONObject);
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPZ)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPT)).booleanValue()) {
            JsonUtils.putAll(jSONObject, mapF);
            mapF = null;
        }
        a(mapF, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.sdk.BN().a(com.applovin.impl.sdk.c.b.aKh, JsonUtils.getString(jSONObject2, "device_id", ""));
        this.sdk.BN().a(com.applovin.impl.sdk.c.b.aKk, JsonUtils.getString(jSONObject2, "device_token", ""));
        this.sdk.BN().a(com.applovin.impl.sdk.c.b.aKl, Long.valueOf(JsonUtils.getLong(jSONObject2, "publisher_id", 0L)));
        com.applovin.impl.sdk.utils.i.j(jSONObject2, this.sdk);
        com.applovin.impl.sdk.utils.i.k(jSONObject2, this.sdk);
        String string = JsonUtils.getString(jSONObject2, "latest_version", "");
        if (StringUtils.isValidString(string) && !AppLovinSdk.VERSION.equals(string)) {
            String string2 = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
            if (JsonUtils.valueExists(jSONObject2, "sdk_update_message")) {
                string2 = JsonUtils.getString(jSONObject2, "sdk_update_message", string2);
            }
            com.applovin.impl.sdk.x.F("AppLovinSdk", string2);
        }
        this.sdk.BP().JV();
    }

    private void O(JSONObject jSONObject) {
        Map<String, Object> mapCS;
        Map<String, Object> mapCY;
        if (this.sdk.BT() != null) {
            com.applovin.impl.sdk.p pVarBT = this.sdk.BT();
            mapCS = pVarBT.CS();
            mapCY = pVarBT.DF();
        } else {
            com.applovin.impl.sdk.o oVarBQ = this.sdk.BQ();
            mapCS = oVarBQ.CS();
            mapCY = oVarBQ.CY();
        }
        com.applovin.impl.sdk.utils.u.a(TapjoyConstants.TJC_PLATFORM, "type", mapCS);
        com.applovin.impl.sdk.utils.u.a("api_level", "sdk_version", mapCS);
        JsonUtils.putObject(jSONObject, DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(mapCS));
        com.applovin.impl.sdk.utils.u.a("sdk_version", "applovin_sdk_version", mapCY);
        com.applovin.impl.sdk.utils.u.a("ia", "installed_at", mapCY);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(mapCY));
    }

    private void P(JSONObject jSONObject) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPi)).booleanValue()) {
            JsonUtils.putJSONObjectIfValid(jSONObject, "stats", this.sdk.BP().JW());
        }
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        w<JSONObject> wVar = new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).da(com.applovin.impl.sdk.utils.i.c("2.0/device", this.sdk)).dc(com.applovin.impl.sdk.utils.i.d("2.0/device", this.sdk)).k(map).K(jSONObject).db("POST").aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQg)).booleanValue()).ad(new JSONObject()).gC(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNN)).intValue()).a(com.applovin.impl.sdk.utils.p.a.gU(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPR)).intValue())).Ie(), this.sdk) { // from class: com.applovin.impl.sdk.e.e.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject2, int i) {
                e.this.N(jSONObject2);
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject2) {
                com.applovin.impl.sdk.utils.i.b(i, this.sdk);
            }
        };
        wVar.e(com.applovin.impl.sdk.c.b.aLr);
        wVar.f(com.applovin.impl.sdk.c.b.aLs);
        this.sdk.BM().b(wVar);
    }
}
