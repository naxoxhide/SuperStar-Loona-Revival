package com.applovin.impl.mediation.d;

import com.applovin.impl.sdk.e.y;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends y {
    private final com.applovin.impl.mediation.b.c auq;

    @Override // com.applovin.impl.sdk.e.aa
    protected String zJ() {
        return "2.0/mcr";
    }

    public g(com.applovin.impl.mediation.b.c cVar, n nVar) {
        super("TaskReportMaxReward", nVar);
        this.auq = cVar;
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.auq.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.auq.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.auq.yF());
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

    @Override // com.applovin.impl.sdk.e.y
    protected com.applovin.impl.sdk.b.c yg() {
        return this.auq.yg();
    }

    @Override // com.applovin.impl.sdk.e.y
    protected void y(JSONObject jSONObject) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Reported reward successfully for mediated ad: " + this.auq);
        }
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void gu(int i) {
        super.gu(i);
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Failed to report reward for mediated ad: " + this.auq + " - error code: " + i);
        }
    }

    @Override // com.applovin.impl.sdk.e.y
    protected void zK() {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.i(this.tag, "No reward result was found for mediated ad: " + this.auq);
        }
    }
}
