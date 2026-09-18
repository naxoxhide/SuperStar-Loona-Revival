package com.applovin.impl.mediation.c.a;

import android.text.TextUtils;
import com.applovin.impl.mediation.c.d;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.e.u;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends d implements AppLovinAdLoadListener {
    private final String avN;
    private final AppLovinAdLoadListener avQ;
    private String avR;
    private JSONObject avS;
    private JSONObject avT;
    private String avU;

    public b(JSONObject jSONObject, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, String str, AppLovinAdLoadListener appLovinAdLoadListener, n nVar) {
        super("TaskProcessNimbusAd", jSONObject, maxAdapterResponseParameters, maxAdFormat, nVar);
        this.avN = str;
        this.avQ = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String string = JsonUtils.getString(this.avG, "markup", "");
        this.avR = string;
        if (TextUtils.isEmpty(string)) {
            this.avQ.failedToReceiveAd(204);
            return;
        }
        String string2 = JsonUtils.getString(this.avG, "position", "");
        String string3 = JsonUtils.getString(this.avG, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, "");
        String string4 = JsonUtils.getString(this.avG, "auction_id", "");
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f("TaskProcessNimbusAd", "Processing Nimbus ad (" + string2 + ") for placement: " + string3 + " with auction id: " + string4 + "...");
        }
        this.avJ = JsonUtils.getString(this.avG, "network", "");
        this.avU = JsonUtils.getString(this.avG, "crid", null);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.avG, "trackers", new JSONObject());
        this.avT = c(JsonUtils.getJSONArray(jSONObject, "click_trackers", null));
        this.avS = c(JsonUtils.getJSONArray(jSONObject, "impression_trackers", null));
        JSONObject jSONObjectZt = zt();
        JSONObject jSONObjectO = o(jSONObjectZt);
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f("TaskProcessNimbusAd", "Starting render task for Nimbus ad: " + string2 + "...");
        }
        this.sdk.BM().a(new u(jSONObjectZt, jSONObjectO, com.applovin.impl.sdk.ad.b.UNKNOWN, this.avQ, this.sdk), q.b.MAIN);
    }

    @Override // com.applovin.impl.mediation.c.d
    protected JSONObject zt() {
        JSONObject jSONObjectA = a(this.avR, this.avT, this.avS);
        JsonUtils.putString(jSONObjectA, "cache_prefix", "nimbus");
        JsonUtils.putString(jSONObjectA, "type", "nimbus");
        JsonUtils.putJSONObject(jSONObjectA, "http_headers_for_postbacks", zx());
        return jSONObjectA;
    }

    private JSONObject c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(string, "");
                }
            } catch (JSONException e) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().c(this.tag, "Failed to retrieve tracking url with a non-String value.", e);
                }
            }
        }
        return jSONObject;
    }

    private JSONObject zx() {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "Nimbus-Session-Id", this.avN);
        return jSONObject;
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        ((AppLovinAdImpl) appLovinAd).setMaxAdValue(CampaignEx.JSON_KEY_CREATIVE_ID, this.avU);
        this.avQ.adReceived(appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        this.avQ.failedToReceiveAd(i);
    }
}
