package com.applovin.impl.sdk.nativeAd;

import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.x;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinNativeAdService {
    private static final String TAG = "AppLovinNativeAdService";
    private final x logger;
    private final n sdk;

    public AppLovinNativeAdService(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
    }

    public void loadNextAdForAdToken(String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            x.H(TAG, "Empty ad token");
            m.a(appLovinNativeAdLoadListener, new AppLovinError(-8, "Empty ad token"));
            return;
        }
        com.applovin.impl.sdk.ad.c cVar = new com.applovin.impl.sdk.ad.c(strTrim, this.sdk);
        if (cVar.FN() == com.applovin.impl.sdk.ad.c.a.REGULAR) {
            if (x.Fk()) {
                this.logger.f(TAG, "Loading next ad for token: " + cVar);
            }
            this.sdk.BM().a(new b(cVar, appLovinNativeAdLoadListener, this.sdk), q.b.MAIN);
            return;
        }
        if (cVar.FN() == com.applovin.impl.sdk.ad.c.a.AD_RESPONSE_JSON) {
            JSONObject jSONObjectFP = cVar.FP();
            if (jSONObjectFP != null) {
                i.j(jSONObjectFP, this.sdk);
                i.i(jSONObjectFP, this.sdk);
                i.k(jSONObjectFP, this.sdk);
                if (JsonUtils.getJSONArray(jSONObjectFP, CampaignUnit.JSON_KEY_ADS, new JSONArray()).length() > 0) {
                    if (x.Fk()) {
                        this.logger.f(TAG, "Rendering ad for token: " + cVar);
                    }
                    this.sdk.BM().a(new d(jSONObjectFP, appLovinNativeAdLoadListener, this.sdk), q.b.MAIN);
                    return;
                } else {
                    if (x.Fk()) {
                        this.logger.i(TAG, "No ad returned from the server for token: " + cVar);
                    }
                    m.a(appLovinNativeAdLoadListener, AppLovinError.NO_FILL);
                    return;
                }
            }
            String str2 = "Unable to retrieve ad response JSON from token: " + cVar.mQ();
            AppLovinError appLovinError = new AppLovinError(-8, str2);
            x.H(TAG, str2);
            m.a(appLovinNativeAdLoadListener, appLovinError);
            return;
        }
        AppLovinError appLovinError2 = new AppLovinError(-8, "Invalid token type");
        x.H(TAG, "Invalid token type");
        m.a(appLovinNativeAdLoadListener, appLovinError2);
    }
}
