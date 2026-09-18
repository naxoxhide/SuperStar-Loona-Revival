package com.applovin.impl.mediation.ads;

import android.app.Activity;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected final MaxAdFormat adFormat;
    protected MaxAdListener adListener;
    protected MaxAdReviewListener adReviewListener;
    protected final String adUnitId;
    protected MaxAdExpirationListener expirationListener;
    protected final x logger;
    protected MaxAdRequestListener requestListener;
    protected MaxAdRevenueListener revenueListener;
    protected final n sdk;
    protected final String tag;
    protected final Map<String, Object> localExtraParameters = Collections.synchronizedMap(new HashMap());
    protected final Map<String, Object> extraParameters = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.applovin.impl.mediation.ads.a$a, reason: collision with other inner class name */
    public interface InterfaceC0117a extends MaxAdListener, MaxAdRequestListener, MaxAdRevenueListener {
    }

    protected a(String str, MaxAdFormat maxAdFormat, String str2, n nVar) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.sdk = nVar;
        this.tag = str2;
        this.logger = nVar.BL();
    }

    public void setListener(MaxAdListener maxAdListener) {
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting listener: " + maxAdListener);
        }
        this.adListener = maxAdListener;
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting request listener: " + maxAdRequestListener);
        }
        this.requestListener = maxAdRequestListener;
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting revenue listener: " + maxAdRevenueListener);
        }
        this.revenueListener = maxAdRevenueListener;
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting expiration listener: " + maxAdExpirationListener);
        }
        this.expirationListener = maxAdExpirationListener;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        if (x.Fk()) {
            this.logger.f(this.tag, "Setting Ad Review creative id listener: " + maxAdReviewListener);
        }
        this.adReviewListener = maxAdReviewListener;
    }

    public void setExtraParameter(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (u.b(n.getApplicationContext(), this.sdk) && ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str))) {
            throw new IllegalArgumentException("`setExtraParameter()` is an incorrect method for passing `amazon_ad_response` or `amazon_ad_error`. Please use the following method: `setLocalExtraParameter()`. Also note that this exception occurs in development builds only.");
        }
        if (this.adFormat.isAdViewAd() && "ad_refresh_seconds".equals(str) && StringUtils.isValidString(str2)) {
            int i = Integer.parseInt(str2);
            if (i > TimeUnit.MINUTES.toSeconds(2L)) {
                x.H(this.tag, "Attempting to set extra parameter \"ad_refresh_seconds\" to over 2 minutes (" + i + "s) - this will be ignored");
            }
        }
        this.extraParameters.put(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        if (obj instanceof Activity) {
            if (x.Fk()) {
                this.logger.i(this.tag, "Ignoring setting local extra parameter to Activity instance - please pass a WeakReference of it instead!");
            }
        } else {
            if ("amazon_ad_response".equals(str) || "amazon_ad_error".equals(str)) {
                setExtraParameter("is_amazon_integration", Boolean.toString(true));
            }
            this.localExtraParameters.put(str, obj);
        }
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    void g(com.applovin.impl.mediation.b.a aVar) {
        com.applovin.impl.sdk.utils.n nVar = new com.applovin.impl.sdk.utils.n();
        nVar.Lm().dD("MAX Ad").n(aVar).Lm();
        if (x.Fk()) {
            this.logger.f(this.tag, nVar.toString());
        }
    }

    public void logApiCall(String str) {
        if (x.Fk()) {
            this.logger.f(this.tag, str);
        }
    }

    public static void logApiCall(String str, String str2) {
        if (n.aAz != null) {
            n.aAz.BL();
            if (x.Fk()) {
                n.aAz.BL().f(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroy() {
        this.localExtraParameters.clear();
        this.adListener = null;
        this.revenueListener = null;
        this.requestListener = null;
        this.expirationListener = null;
        this.adReviewListener = null;
    }
}
