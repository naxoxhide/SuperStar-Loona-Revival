package com.applovin.impl.mediation.c.a;

import android.text.TextUtils;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.c.b {
    private final String avK;
    private final String avL;
    private final String avM;
    private String avN;

    public a(String str, String str2, String str3, n nVar) {
        super("NimbusApiService", nVar);
        this.avK = str;
        this.avN = UUID.randomUUID().toString().toLowerCase(Locale.US);
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f(this.tag, "Initializing Nimbus with apiKey=" + str + ", pubId=" + str2 + ", sessionId=" + this.avN);
        }
        this.avL = "https://" + str2 + "." + (StringUtils.isValidString(str3) ? str3 : "adsbynimbus.com/rta/v1");
        String string = (String) nVar.b(c.avC, null, this.avs);
        if (TextUtils.isEmpty(string)) {
            string = UUID.randomUUID().toString();
            nVar.a(c.avC, string, this.avs);
        }
        this.avM = string;
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f(this.tag, "Setting Nimbus instanceId=" + string);
        }
    }

    public void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters) {
        a((MaxAdapterParameters) maxAdapterInitializationParameters);
    }

    public void a(final MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, final AppLovinAdLoadListener appLovinAdLoadListener) {
        Map<String, Object> mapCS;
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Loading Nimbus " + maxAdFormat.getLabel() + " ad with position: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        }
        a(maxAdapterResponseParameters);
        if (this.sdk.BT() != null) {
            mapCS = this.sdk.BT().CS();
        } else {
            mapCS = this.sdk.BQ().CS();
        }
        HashMap map = new HashMap();
        map.put("x-openrtb-version", "2.5");
        map.put("Nimbus-Api-Key", this.avK);
        map.put("Nimbus-Sdkv", "2.0.0");
        map.put("Nimbus-Instance-Id", this.avM);
        map.put("User-Agent", String.valueOf(mapCS.get("ua")));
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "session_id", this.avN);
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "position", maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        this.sdk.BM().b(new w<JSONObject>(a(this.avL, UUID.randomUUID().toString().toLowerCase(Locale.US), maxAdapterResponseParameters, maxAdFormat, com.applovin.impl.mediation.c.b.a.zr().k(jSONObject).n(zo()).l(jSONObject2).m(zp()).zs(), map, true, this.sdk), this.sdk) { // from class: com.applovin.impl.mediation.c.a.a.1
            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void d(JSONObject jSONObject3, int i) {
                if (i == 200 && jSONObject3 != null) {
                    this.sdk.BM().b(new b(jSONObject3, maxAdapterResponseParameters, maxAdFormat, a.this.avN, appLovinAdLoadListener, this.sdk));
                } else {
                    x xVar = this.logger;
                    if (x.Fk()) {
                        this.logger.i(this.tag, "Unable to fetch " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + " Nimbus ad: server returned " + i);
                    }
                    appLovinAdLoadListener.failedToReceiveAd(i);
                }
            }

            @Override // com.applovin.impl.sdk.e.w, com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, JSONObject jSONObject3) {
                if (jSONObject3 != null && "No Bid".equalsIgnoreCase(JsonUtils.getString(jSONObject3, "message", null))) {
                    Object object = JsonUtils.getObject(jSONObject3, "nbr", null);
                    x xVar = this.logger;
                    if (x.Fk()) {
                        this.logger.i(this.tag, "Nimbus request for " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + " returned with no fill code: " + object);
                    }
                    appLovinAdLoadListener.failedToReceiveAd(204);
                }
                x xVar2 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unable to fetch " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + " Nimbus ad: server returned " + i);
                }
                appLovinAdLoadListener.failedToReceiveAd(i);
            }
        });
    }

    private void a(MaxAdapterParameters maxAdapterParameters) {
        Object obj = maxAdapterParameters.getLocalExtraParameters().get("session_id");
        if (obj instanceof String) {
            String str = (String) obj;
            if (StringUtils.isValidString(str)) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f(this.tag, "Updating Nimbus sessionId to " + obj);
                }
                this.avN = str;
            }
        }
    }
}
