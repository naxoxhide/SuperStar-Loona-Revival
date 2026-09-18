package com.applovin.impl.mediation.debugger.ui.testmode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.DTBAdResponse;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.ads.MaxRewardedInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.applovin.impl.mediation.debugger.ui.a implements com.applovin.impl.mediation.debugger.a.a.InterfaceC0122a, AdControlButton.a, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {
    private MaxInterstitialAd apV;
    private MaxAppOpenAd apW;
    private MaxRewardedInterstitialAd apX;
    private MaxRewardedAd apY;
    private MaxNativeAdLoader apZ;
    private MaxAd aqa;
    private List<String> aqc;
    private com.applovin.impl.mediation.debugger.b.c.b arS;
    private MaxAdView atP;
    private MaxAdView atQ;
    private String atR;
    private AdControlButton atS;
    private AdControlButton atT;
    private AdControlButton atU;
    private AdControlButton atV;
    private AdControlButton atW;
    private AdControlButton atX;
    private AdControlButton atY;
    private Button atZ;
    private Button aua;
    private FrameLayout aub;
    private FrameLayout auc;
    private Switch aud;
    private Switch aue;
    private Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> auf;
    private n sdk;

    public void initialize(com.applovin.impl.mediation.debugger.b.c.b bVar) {
        this.arS = bVar;
        this.sdk = bVar.getSdk();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a
    protected n getSdk() {
        return this.sdk;
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.arS == null) {
            x.H("MaxDebuggerMultiAdActivity", "Failed to initialize activity with a network model.");
            return;
        }
        setContentView(R.layout.mediation_debugger_multi_ad_activity);
        setTitle(this.arS.getDisplayName() + " Test Ads");
        this.aqc = this.sdk.CC().xj();
        xd();
        xe();
        xf();
        xg();
        xh();
        findViewById(R.id.rewarded_interstitial_control_view).setVisibility(8);
        findViewById(R.id.app_open_ad_control_view).setVisibility(8);
        this.atZ = (Button) findViewById(R.id.show_mrec_button);
        this.aua = (Button) findViewById(R.id.show_native_button);
        if (!this.arS.vz() || !this.arS.vy().contains(MaxAdFormat.MREC)) {
            this.atZ.setVisibility(8);
            this.aua.setVisibility(8);
        } else {
            this.auc.setVisibility(8);
            this.atZ.setBackgroundColor(-1);
            this.aua.setBackgroundColor(-3355444);
            this.atZ.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.-$$Lambda$a$1-u0_28R8w0962RHyCMfxR2lslE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.o(view);
                }
            });
            this.aua.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.-$$Lambda$a$SY5tazQjMiRijFIYqsFeqYXRjDQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.p(view);
                }
            });
        }
        this.aud = (Switch) findViewById(R.id.native_banner_switch);
        this.aue = (Switch) findViewById(R.id.native_mrec_switch);
        if (this.arS.vA()) {
            this.aud.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.-$$Lambda$a$9lxcAvR5vpRMM5PeT13HRZgWXHE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.s(view);
                }
            });
            this.aue.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.-$$Lambda$a$9hV_o8BBIUlCrWVJPXKQxosZ1wg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.r(view);
                }
            });
        } else {
            this.aud.setVisibility(8);
            this.aue.setVisibility(8);
        }
        if (StringUtils.isValidString(this.arS.vJ()) && this.arS.vK() != null && this.arS.vK().size() > 0) {
            AdRegistration.getInstance(this.arS.vJ(), this);
            AdRegistration.enableTesting(true);
            AdRegistration.enableLogging(true);
            HashMap map = new HashMap(this.arS.vK().size());
            for (MaxAdFormat maxAdFormat : this.arS.vK().keySet()) {
                map.put(maxAdFormat, new com.applovin.impl.mediation.debugger.a.a(this.arS.vK().get(maxAdFormat), maxAdFormat, this));
            }
            this.auf = map;
        }
        try {
            setRequestedOrientation(7);
        } catch (Throwable th) {
            x.e("AppLovinSdk", "Failed to set portrait orientation", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.aub.setVisibility(0);
        this.auc.setVisibility(8);
        this.atZ.setBackgroundColor(-1);
        this.aua.setBackgroundColor(-3355444);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        this.auc.setVisibility(0);
        this.aub.setVisibility(8);
        this.aua.setBackgroundColor(-1);
        this.atZ.setBackgroundColor(-3355444);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.atP.removeAllViews();
        this.atS.setControlState(AdControlButton.b.LOAD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        this.atQ.removeAllViews();
        this.atT.setControlState(AdControlButton.b.LOAD);
    }

    @Override // com.applovin.impl.mediation.debugger.ui.a, android.app.Activity
    protected void onDestroy() {
        MaxAd maxAd;
        super.onDestroy();
        this.sdk.CC().C(this.aqc);
        MaxAdView maxAdView = this.atP;
        if (maxAdView != null) {
            maxAdView.destroy();
        }
        MaxAdView maxAdView2 = this.atQ;
        if (maxAdView2 != null) {
            maxAdView2.destroy();
        }
        MaxInterstitialAd maxInterstitialAd = this.apV;
        if (maxInterstitialAd != null) {
            maxInterstitialAd.destroy();
        }
        MaxRewardedAd maxRewardedAd = this.apY;
        if (maxRewardedAd != null) {
            maxRewardedAd.destroy();
        }
        MaxNativeAdLoader maxNativeAdLoader = this.apZ;
        if (maxNativeAdLoader == null || (maxAd = this.aqa) == null) {
            return;
        }
        maxNativeAdLoader.destroy(maxAd);
    }

    private void xd() {
        MaxAdFormat maxAdFormat;
        String str;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_ad_view_container);
        if (zIsTablet) {
            maxAdFormat = MaxAdFormat.LEADER;
            ((TextView) findViewById(R.id.banner_label)).setText("Leader");
            str = "test_mode_leader";
        } else {
            maxAdFormat = MaxAdFormat.BANNER;
            str = "test_mode_banner";
        }
        if (this.arS.vy().contains(maxAdFormat)) {
            MaxAdView maxAdView = new MaxAdView(str, maxAdFormat, this.sdk.getWrappingSdk(), this);
            this.atP = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER, TJAdUnitConstants.String.FALSE);
            this.atP.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.atP.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_PRECACHE, "true");
            this.atP.setExtraParameter(AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE, "true");
            this.atP.stopAutoRefresh();
            this.atP.setListener(this);
            frameLayout.addView(this.atP, new FrameLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this, maxAdFormat.getSize().getHeight())));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.banner_control_button);
            this.atS = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atS.setFormat(maxAdFormat);
            return;
        }
        findViewById(R.id.banner_control_view).setVisibility(8);
        frameLayout.setVisibility(8);
    }

    private void xe() {
        this.aub = (FrameLayout) findViewById(R.id.mrec_ad_view_container);
        if (this.arS.vy().contains(MaxAdFormat.MREC)) {
            MaxAdView maxAdView = new MaxAdView("test_mode_mrec", MaxAdFormat.MREC, this.sdk.getWrappingSdk(), this);
            this.atQ = maxAdView;
            maxAdView.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.atQ.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_PRECACHE, "true");
            this.atQ.setExtraParameter(AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE, "true");
            this.atQ.stopAutoRefresh();
            this.atQ.setListener(this);
            this.aub.addView(this.atQ, new FrameLayout.LayoutParams(-1, -1));
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.mrec_control_button);
            this.atT = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atT.setFormat(MaxAdFormat.MREC);
            return;
        }
        findViewById(R.id.mrec_control_view).setVisibility(8);
        this.aub.setVisibility(8);
    }

    private void xf() {
        if (this.arS.vy().contains(MaxAdFormat.INTERSTITIAL)) {
            MaxInterstitialAd maxInterstitialAd = new MaxInterstitialAd("test_mode_interstitial", this.sdk.getWrappingSdk(), this);
            this.apV = maxInterstitialAd;
            maxInterstitialAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apV.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.interstitial_control_button);
            this.atU = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atU.setFormat(MaxAdFormat.INTERSTITIAL);
            return;
        }
        findViewById(R.id.interstitial_control_view).setVisibility(8);
    }

    private void xg() {
        if (this.arS.vy().contains(MaxAdFormat.REWARDED)) {
            String str = "test_mode_rewarded_" + this.arS.getName();
            this.atR = str;
            MaxRewardedAd maxRewardedAd = MaxRewardedAd.getInstance(str, this.sdk.getWrappingSdk(), this);
            this.apY = maxRewardedAd;
            maxRewardedAd.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apY.setListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.rewarded_control_button);
            this.atX = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atX.setFormat(MaxAdFormat.REWARDED);
            return;
        }
        findViewById(R.id.rewarded_control_view).setVisibility(8);
    }

    private void xh() {
        this.auc = (FrameLayout) findViewById(R.id.native_ad_view_container);
        if (this.arS.vz()) {
            MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader("test_mode_native", this.sdk.getWrappingSdk(), this);
            this.apZ = maxNativeAdLoader;
            maxNativeAdLoader.setExtraParameter(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES, "true");
            this.apZ.setNativeAdListener(new MaxNativeAdListener() { // from class: com.applovin.impl.mediation.debugger.ui.testmode.a.1
                @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
                public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                    if (a.this.aqa != null) {
                        a.this.apZ.destroy(a.this.aqa);
                    }
                    a.this.aqa = maxAd;
                    a.this.auc.removeAllViews();
                    a.this.auc.addView(maxNativeAdView);
                    a.this.onAdLoaded(maxAd);
                }

                @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
                public void onNativeAdLoadFailed(String str, MaxError maxError) {
                    a.this.onAdLoadFailed(str, maxError);
                }

                @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
                public void onNativeAdClicked(MaxAd maxAd) {
                    a.this.onAdClicked(maxAd);
                }
            });
            this.apZ.setRevenueListener(this);
            AdControlButton adControlButton = (AdControlButton) findViewById(R.id.native_control_button);
            this.atY = adControlButton;
            adControlButton.setOnClickListener(this);
            this.atY.setFormat(MaxAdFormat.NATIVE);
            return;
        }
        findViewById(R.id.native_control_view).setVisibility(8);
        this.auc.setVisibility(8);
    }

    private void b(MaxAdFormat maxAdFormat) {
        boolean z = (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) && this.aud.isChecked();
        boolean z2 = MaxAdFormat.MREC == maxAdFormat && this.aue.isChecked();
        if (z || z2) {
            this.sdk.CC().bT(this.arS.vu());
        } else {
            this.sdk.CC().bT(getTestModeNetwork(maxAdFormat));
        }
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atP.loadAd();
            return;
        }
        if (MaxAdFormat.MREC == maxAdFormat) {
            this.atQ.loadAd();
            this.atZ.callOnClick();
            return;
        }
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apV.loadAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apW.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.apX.loadAd();
            return;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.apY.loadAd();
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.apZ.loadAd();
            this.aua.callOnClick();
        }
    }

    private void c(MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apV.showAd();
            return;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apW.showAd();
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.apX.showAd();
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.apY.showAd();
        }
    }

    public String getTestModeNetwork(MaxAdFormat maxAdFormat) {
        if (this.arS.vF() != null && this.arS.vF().containsKey(maxAdFormat)) {
            return this.arS.vF().get(maxAdFormat);
        }
        return this.arS.getName();
    }

    @Override // com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton.a
    public void onClick(AdControlButton adControlButton) {
        MaxAdFormat format = adControlButton.getFormat();
        if (AdControlButton.b.LOAD == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOADING);
            Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.a> map = this.auf;
            if (map != null && map.get(format) != null) {
                this.auf.get(format).loadAd();
                return;
            } else {
                b(format);
                return;
            }
        }
        if (AdControlButton.b.SHOW == adControlButton.getControlState()) {
            adControlButton.setControlState(AdControlButton.b.LOAD);
            c(format);
        }
    }

    private AdControlButton bS(String str) {
        if (str.equals("test_mode_banner") || str.equals("test_mode_leader")) {
            return this.atS;
        }
        if (str.equals("test_mode_mrec")) {
            return this.atT;
        }
        if (str.equals("test_mode_interstitial")) {
            return this.atU;
        }
        if (str.equals("test_mode_app_open")) {
            return this.atV;
        }
        if (str.equals("test_mode_rewarded_interstitial")) {
            return this.atW;
        }
        if (str.equals(this.atR)) {
            return this.atX;
        }
        if (str.equals("test_mode_native")) {
            return this.atY;
        }
        throw new IllegalArgumentException("Invalid test mode ad unit identifier provided " + str);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoaded(MaxAd maxAd) {
        AdControlButton adControlButtonBS = bS(maxAd.getAdUnitId());
        if (maxAd.getFormat().isAdViewAd() || maxAd.getFormat().equals(MaxAdFormat.NATIVE)) {
            adControlButtonBS.setControlState(AdControlButton.b.LOAD);
        } else {
            adControlButtonBS.setControlState(AdControlButton.b.SHOW);
        }
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdLoadFailed(String str, MaxError maxError) {
        AdControlButton adControlButtonBS = bS(str);
        adControlButtonBS.setControlState(AdControlButton.b.LOAD);
        u.a(maxError, adControlButtonBS.getFormat().getLabel(), this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayed(MaxAd maxAd) {
        u.a("onAdDisplayed", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdHidden(MaxAd maxAd) {
        u.a("onAdHidden", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdClicked(MaxAd maxAd) {
        u.a("onAdClicked", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdRevenueListener
    public void onAdRevenuePaid(MaxAd maxAd) {
        u.a("onAdRevenuePaid", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdListener
    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        bS(maxAd.getAdUnitId()).setControlState(AdControlButton.b.LOAD);
        u.a("Failed to display " + maxAd.getFormat().getDisplayName(), "MAX Error\nCode: " + maxError.getCode() + "\nMessage: " + maxError.getMessage() + "\n\n" + maxAd.getNetworkName() + " Display Error\nCode: " + maxError.getMediatedNetworkErrorCode() + "\nMessage: " + maxError.getMediatedNetworkErrorMessage(), this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoStarted(MaxAd maxAd) {
        u.a("onRewardedVideoStarted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onRewardedVideoCompleted(MaxAd maxAd) {
        u.a("onRewardedVideoCompleted", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxRewardedAdListener
    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        u.a("onUserRewarded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdExpanded(MaxAd maxAd) {
        u.a("onAdExpanded", maxAd, this);
    }

    @Override // com.applovin.mediation.MaxAdViewAdListener
    public void onAdCollapsed(MaxAd maxAd) {
        u.a("onAdCollapsed", maxAd, this);
    }

    @Override // com.applovin.impl.mediation.debugger.a.a.InterfaceC0122a
    public void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atP.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.atQ.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apV.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apW.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.apX.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.apY.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.apZ.setLocalExtraParameter("amazon_ad_response", dTBAdResponse);
        }
        b(maxAdFormat);
    }

    @Override // com.applovin.impl.mediation.debugger.a.a.InterfaceC0122a
    public void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat) {
        if (MaxAdFormat.BANNER == maxAdFormat || MaxAdFormat.LEADER == maxAdFormat) {
            this.atP.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.MREC == maxAdFormat) {
            this.atQ.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            this.apV.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            this.apW.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            this.apX.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.REWARDED == maxAdFormat) {
            this.apY.setLocalExtraParameter("amazon_ad_error", adError);
        } else if (MaxAdFormat.NATIVE == maxAdFormat) {
            this.apZ.setLocalExtraParameter("amazon_ad_error", adError);
        }
        b(maxAdFormat);
    }
}
