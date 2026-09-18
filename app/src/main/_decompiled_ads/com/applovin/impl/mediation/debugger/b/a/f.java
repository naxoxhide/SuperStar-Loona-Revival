package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.tapjoy.TapjoyConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private final String aoB;
    private final String aoC;
    private final String aoD;
    private final String aoE;
    private final List<String> aoF;
    private final List<String> aoG;

    public String uV() {
        return this.aoB;
    }

    public String uW() {
        return this.aoC;
    }

    public String uX() {
        return this.aoD;
    }

    public String uY() {
        return this.aoE;
    }

    public List<String> uZ() {
        return this.aoF;
    }

    public List<String> getKeywords() {
        return this.aoG;
    }

    public f(JSONObject jSONObject) {
        this.aoB = JsonUtils.getString(jSONObject, "user_type", "all");
        this.aoC = JsonUtils.getString(jSONObject, TapjoyConstants.TJC_DEVICE_TYPE_NAME, "all");
        this.aoD = JsonUtils.getString(jSONObject, "min_age", null);
        this.aoE = JsonUtils.getString(jSONObject, "max_age", null);
        this.aoF = JsonUtils.getList(jSONObject, InneractiveMediationDefs.KEY_GENDER, null);
        this.aoG = JsonUtils.getList(jSONObject, "keywords", null);
    }
}
