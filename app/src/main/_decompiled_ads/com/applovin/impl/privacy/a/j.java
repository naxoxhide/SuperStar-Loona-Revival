package com.applovin.impl.privacy.a;

import android.text.TextUtils;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {
    public static List<e> k(n nVar) {
        return a(R.raw.applovin_consent_flow_privacy_policy, nVar);
    }

    public static List<e> l(n nVar) {
        return a(R.raw.applovin_consent_flow_terms_of_service_and_privacy_policy, nVar);
    }

    public static List<e> m(n nVar) {
        return a(R.raw.applovin_consent_flow_unified_cmp, nVar);
    }

    private static List<e> a(int i, n nVar) {
        String strA = u.a(i, n.getApplicationContext(), nVar);
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalStateException("Unable to retrieve consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONObject jSONObjectJsonObjectFromJsonString = JsonUtils.jsonObjectFromJsonString(strA, null);
        if (jSONObjectJsonObjectFromJsonString == null) {
            throw new IllegalStateException("Unable to parse consent flow data! Please ensure that the AppLovin SDK resources are bundled correctly!");
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObjectJsonObjectFromJsonString, "states", new JSONArray());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(e.g(JsonUtils.getJSONObject(jSONArray, i2, new JSONObject()), nVar));
        }
        return arrayList;
    }
}
