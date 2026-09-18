package com.applovin.impl.mediation.debugger.a;

import com.amazon.device.ads.DTBAdSize;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final String aoh;
    private final DTBAdSize aoi;

    private enum a {
        VIDEO,
        DISPLAY,
        INTERSTITIAL
    }

    public b(String str, JSONObject jSONObject, MaxAdFormat maxAdFormat) {
        this.aoh = str;
        this.aoi = a(JsonUtils.getInt(jSONObject, "type", a(maxAdFormat).ordinal()), maxAdFormat, str);
    }

    public DTBAdSize uF() {
        return this.aoi;
    }

    private a a(MaxAdFormat maxAdFormat) {
        return maxAdFormat.isAdViewAd() ? a.DISPLAY : a.INTERSTITIAL;
    }

    private DTBAdSize a(int i, MaxAdFormat maxAdFormat, String str) {
        try {
            if (a.VIDEO.ordinal() == i) {
                return new DTBAdSize.DTBVideo(320, 480, str);
            }
            if (a.DISPLAY.ordinal() == i) {
                return new DTBAdSize(maxAdFormat.getSize().getWidth(), maxAdFormat.getSize().getHeight(), str);
            }
            if (a.INTERSTITIAL.ordinal() == i) {
                return new DTBAdSize.DTBInterstitialAdSize(str);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
