package com.applovin.impl.mediation.d;

import com.applovin.impl.sdk.e.ad;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends ad {
    private final com.applovin.impl.mediation.b.c auq;

    @Override // com.applovin.impl.sdk.e.aa
    protected String zJ() {
        return "2.0/mvr";
    }

    public h(com.applovin.impl.mediation.b.c cVar, n nVar) {
        super("TaskValidateMaxReward", nVar);
        this.auq = cVar;
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.auq.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.auq.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.auq.yF());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.auq.getFormat().getLabel());
        String strYd = this.auq.yd();
        if (!StringUtils.isValidString(strYd)) {
            strYd = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strYd);
        String strXr = this.auq.xr();
        if (!StringUtils.isValidString(strXr)) {
            strXr = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strXr);
    }

    @Override // com.applovin.impl.sdk.e.ad
    protected void b(com.applovin.impl.sdk.b.c cVar) {
        this.auq.a(cVar);
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void gu(int i) {
        super.gu(i);
        this.auq.a(com.applovin.impl.sdk.b.c.dr((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    @Override // com.applovin.impl.sdk.e.ad
    protected boolean zL() {
        return this.auq.ye();
    }
}
