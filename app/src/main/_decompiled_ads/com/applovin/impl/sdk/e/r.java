package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.android.gms.ads.AdError;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r extends d implements com.applovin.impl.sdk.ad.i {
    private final AppLovinAdLoadListener avQ;
    private final JSONObject awx;
    private final com.applovin.impl.sdk.ad.d azx;
    private final com.applovin.impl.sdk.ad.b source;

    public r(JSONObject jSONObject, com.applovin.impl.sdk.ad.d dVar, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        super("TaskProcessAdResponse", nVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.awx = jSONObject;
        this.azx = dVar;
        this.source = bVar;
        this.avQ = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.awx, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Processing ad...");
            }
            R(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.h(this.tag, "No ads were returned from the server");
        }
        com.applovin.impl.sdk.utils.u.a(this.azx.mQ(), this.azx.getFormat(), this.awx, this.sdk);
        failedToReceiveAdV2(AppLovinError.NO_FILL);
    }

    private void R(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", AdError.UNDEFINED_DOMAIN);
        if ("applovin".equalsIgnoreCase(string)) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Starting task for AppLovin ad...");
            }
            this.sdk.BM().b(new u(jSONObject, this.awx, this.source, this, this.sdk));
            return;
        }
        if ("vast".equalsIgnoreCase(string)) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Starting task for VAST ad...");
            }
            this.sdk.BM().b(t.a(jSONObject, this.awx, this.source, this, this.sdk));
            return;
        }
        if ("js_tag".equalsIgnoreCase(string)) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Starting task for JS tag ad...");
            }
            this.sdk.BM().b(new s(jSONObject, this.awx, this.source, this, this.sdk));
            return;
        }
        com.applovin.impl.sdk.x xVar4 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Unable to process ad of unknown type: " + string);
        }
        failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.avQ;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        failedToReceiveAdV2(new AppLovinError(i, ""));
    }

    @Override // com.applovin.impl.sdk.ad.i
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.avQ;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i) {
            ((com.applovin.impl.sdk.ad.i) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }
}
