package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.c;
import com.applovin.impl.sdk.utils.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdView extends RelativeLayout {
    private MaxAdViewImpl aYn;
    private View aYo;
    private int aYp;

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, c.R(context), appLovinSdk, context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context.getApplicationContext());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.aYn.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.aYn.setListener(maxAdViewAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.aYn.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYn.setRevenueListener(maxAdRevenueListener);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.aYn.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.aYn.setRequestListener(maxAdRequestListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.aYn.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYn.setAdReviewListener(maxAdReviewListener);
    }

    public void loadAd() {
        this.aYn.logApiCall("loadAd()");
        this.aYn.loadAd();
    }

    public void startAutoRefresh() {
        this.aYn.logApiCall("startAutoRefresh()");
        this.aYn.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.aYn.logApiCall("stopAutoRefresh()");
        this.aYn.stopAutoRefresh();
    }

    public void setPlacement(String str) {
        this.aYn.logApiCall("setPlacement(placement=" + str + ")");
        this.aYn.setPlacement(str);
    }

    public String getPlacement() {
        this.aYn.logApiCall("getPlacement()");
        return this.aYn.getPlacement();
    }

    public String getAdUnitId() {
        return this.aYn.getAdUnitId();
    }

    public MaxAdFormat getAdFormat() {
        return this.aYn.getAdFormat();
    }

    public void destroy() {
        this.aYn.destroy();
    }

    public void setExtraParameter(String str, String str2) {
        this.aYn.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYn.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.aYn.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYn.setLocalExtraParameter(str, obj);
    }

    public void setCustomData(String str) {
        this.aYn.logApiCall("setCustomData(value=" + str + ")");
        this.aYn.setCustomData(str);
    }

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        MaxAdFormat maxAdFormatR;
        super(context, attributeSet, i);
        String strA = c.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String strA2 = c.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        if (StringUtils.isValidString(strA2)) {
            maxAdFormatR = MaxAdFormat.formatFromString(strA2);
        } else {
            maxAdFormatR = c.R(context);
        }
        MaxAdFormat maxAdFormat = maxAdFormatR;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (strA == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        }
        if (TextUtils.isEmpty(strA)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        if (isInEditMode()) {
            am(context);
        } else {
            a(strA, maxAdFormat, attributeIntValue, AppLovinSdk.getInstance(context), context);
        }
    }

    private void a(String str, MaxAdFormat maxAdFormat, int i, AppLovinSdk appLovinSdk, Context context) {
        View view = new View(context.getApplicationContext());
        this.aYo = view;
        view.setBackgroundColor(0);
        addView(this.aYo);
        this.aYo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.aYp = getVisibility();
        this.aYn = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.aYo, appLovinSdk.a(), context);
        setGravity(i);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    private void am(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.aYn.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl = this.aYn;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i);
        }
        View view = this.aYo;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.aYn.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.aYo;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    @Override // android.view.View
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.aYn;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (isInEditMode()) {
            return;
        }
        this.aYn.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.aYn != null && v.T(this.aYp, i)) {
            this.aYn.onWindowVisibilityChanged(i);
        }
        this.aYp = i;
    }
}
