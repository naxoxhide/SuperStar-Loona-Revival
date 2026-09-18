package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.applovin.impl.sdk.e.d {
    private final AppLovinNativeAdLoadListener awc;
    private final JSONObject fullResponse;

    public d(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super("TaskProcessNativeAdResponse", nVar);
        this.fullResponse = jSONObject;
        this.awc = appLovinNativeAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.fullResponse, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Processing ad...");
            }
            this.sdk.BM().b(new e(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.fullResponse, this.awc, this.sdk));
            return;
        }
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.h(this.tag, "No ads were returned from the server");
        }
        u.a("native_native", MaxAdFormat.NATIVE, this.fullResponse, this.sdk);
        this.awc.onNativeAdLoadFailed(AppLovinError.NO_FILL);
    }
}
