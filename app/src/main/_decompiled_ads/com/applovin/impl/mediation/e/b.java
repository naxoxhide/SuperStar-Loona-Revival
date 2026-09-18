package com.applovin.impl.mediation.e;

import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.i;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends i {
    private static final String[] axc = {CampaignUnit.JSON_KEY_ADS, "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};
    private static final String[] axd = {CampaignUnit.JSON_KEY_ADS, "settings", "signal_providers", "ad_unit_signal_providers"};

    public static void z(JSONObject jSONObject) {
    }

    public static void d(JSONObject jSONObject, n nVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, axc);
            nVar.a(d.aRF, jSONObjectShallowCopy.toString());
            com.applovin.impl.mediation.d.b.p(jSONObjectShallowCopy);
        }
    }

    public static void e(JSONObject jSONObject, n nVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            com.applovin.impl.mediation.d.b.c(jSONObject, nVar);
        }
    }

    public static void f(JSONObject jSONObject, n nVar) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (JsonUtils.valueExists(jSONObject, "auto_init_adapters") || JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, axd);
            nVar.a(d.aRG, jSONObjectShallowCopy.toString());
            return;
        }
        nVar.b(d.aRG);
    }

    public static String b(n nVar) {
        return i.a((String) nVar.a(com.applovin.impl.sdk.c.a.aJc), "1.0/mediate", nVar);
    }

    public static String c(n nVar) {
        return i.a((String) nVar.a(com.applovin.impl.sdk.c.a.aJd), "1.0/mediate", nVar);
    }

    public static String d(n nVar) {
        return i.a((String) nVar.a(com.applovin.impl.sdk.c.a.aJc), "1.0/mediate_debug", nVar);
    }

    public static String e(n nVar) {
        return i.a((String) nVar.a(com.applovin.impl.sdk.c.a.aJd), "1.0/mediate_debug", nVar);
    }
}
