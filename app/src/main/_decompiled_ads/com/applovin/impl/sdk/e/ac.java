package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ac extends ad {
    private final AppLovinAdRewardListener aIU;
    private final com.applovin.impl.sdk.ad.e aiL;

    @Override // com.applovin.impl.sdk.e.aa
    public String zJ() {
        return "2.0/vr";
    }

    public ac(com.applovin.impl.sdk.ad.e eVar, AppLovinAdRewardListener appLovinAdRewardListener, com.applovin.impl.sdk.n nVar) {
        super("TaskValidateAppLovinReward", nVar);
        this.aiL = eVar;
        this.aIU = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void x(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.aiL.getAdZone().mQ());
        String clCode = this.aiL.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.sdk.e.ad
    protected void b(com.applovin.impl.sdk.b.c cVar) {
        this.aiL.a(cVar);
        String strJA = cVar.JA();
        Map<String, String> mapJz = cVar.Jz();
        if (strJA.equals("accepted")) {
            this.aIU.userRewardVerified(this.aiL, mapJz);
            return;
        }
        if (strJA.equals("quota_exceeded")) {
            this.aIU.userOverQuota(this.aiL, mapJz);
        } else if (strJA.equals("rejected")) {
            this.aIU.userRewardRejected(this.aiL, mapJz);
        } else {
            this.aIU.validationRequestFailed(this.aiL, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.sdk.e.aa
    protected void gu(int i) {
        String str;
        super.gu(i);
        if (i >= 400 && i < 500) {
            this.aIU.userRewardRejected(this.aiL, Collections.emptyMap());
            str = "rejected";
        } else {
            this.aIU.validationRequestFailed(this.aiL, i);
            str = "network_timeout";
        }
        this.aiL.a(com.applovin.impl.sdk.b.c.dr(str));
    }

    @Override // com.applovin.impl.sdk.e.ad
    protected boolean zL() {
        return this.aiL.ye();
    }
}
