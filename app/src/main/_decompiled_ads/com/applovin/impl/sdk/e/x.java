package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class x extends y {
    private final com.applovin.impl.sdk.ad.e aiL;

    @Override // com.applovin.impl.sdk.e.aa
    protected String zJ() {
        return "2.0/cr";
    }

    public x(com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.sdk.n nVar) {
        super("TaskReportAppLovinReward", nVar);
        this.aiL = eVar;
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.aiL.getAdZone().mQ());
        JsonUtils.putInt(jSONObject, "fire_percent", this.aiL.GS());
        String clCode = this.aiL.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.sdk.e.y
    protected com.applovin.impl.sdk.b.c yg() {
        return this.aiL.yg();
    }

    @Override // com.applovin.impl.sdk.e.y
    protected void y(JSONObject jSONObject) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Reported reward successfully for ad: " + this.aiL);
        }
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void gu(int i) {
        super.gu(i);
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Failed to report reward for ad: " + this.aiL + " - error code: " + i);
        }
    }

    @Override // com.applovin.impl.sdk.e.y
    protected void zK() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "No reward result was found for ad: " + this.aiL);
        }
    }
}
