package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinNativeAdImpl extends AppLovinAdBase implements View.OnClickListener, AppLovinTouchToClickListener.OnClickListener, AppLovinNativeAd {
    private static final String AD_RESPONSE_TYPE_APPLOVIN = "applovin";
    private static final String AD_RESPONSE_TYPE_ORTB = "ortb";
    private static final String AD_RESPONSE_TYPE_UNDEFINED = "undefined";
    private static final String DEFAULT_APPLOVIN_PRIVACY_URL = "https://www.applovin.com/privacy/";
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private static final String TAG = "AppLovinNativeAd";
    private static final int VIEWABLE_MRC100_PERCENTAGE = 100;
    private static final int VIEWABLE_MRC50_PERCENTAGE = 50;
    private static final int VIEWABLE_MRC_REQUIRED_SECONDS = 1;
    private static final int VIEWABLE_VIDEO_MRC_REQUIRED_SECONDS = 2;
    private final com.applovin.impl.sdk.a.e adEventTracker;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final Uri clickDestinationBackupUri;
    private final Uri clickDestinationUri;
    private final List<String> clickTrackingUrls;
    private AppLovinNativeAdEventListener eventListener;
    private Uri iconUri;
    private final List<i> impressionRequests;
    private final AtomicBoolean impressionTracked;
    private final List<String> jsTrackers;
    private Uri mainImageUri;
    private AppLovinMediaView mediaView;
    private ViewGroup nativeAdView;
    private final a onAttachStateChangeHandler;
    private AppLovinOptionsView optionsView;
    private Uri privacyDestinationUri;
    private Uri privacyIconUri;
    private final List<View> registeredViews;
    private final Double starRating;
    private final String tag;
    private final String title;
    private final com.applovin.impl.b.a vastAd;
    private View videoView;
    private final b viewableMRC100Callback;
    private ad viewableMRC100Tracker;
    private final b viewableMRC50Callback;
    private ad viewableMRC50Tracker;
    private b viewableVideoMRC50Callback;
    private ad viewableVideoMRC50Tracker;

    public boolean shouldInjectOpenMeasurementScriptDuringCaching() {
        return false;
    }

    public com.applovin.impl.b.a getVastAd() {
        return this.vastAd;
    }

    public void setEventListener(AppLovinNativeAdEventListener appLovinNativeAdEventListener) {
        this.eventListener = appLovinNativeAdEventListener;
    }

    public void setIconUri(Uri uri) {
        this.iconUri = uri;
    }

    public Uri getMainImageUri() {
        return this.mainImageUri;
    }

    public void setMainImageUri(Uri uri) {
        this.mainImageUri = uri;
    }

    public Uri getPrivacyIconUri() {
        return this.privacyIconUri;
    }

    public void setPrivacyIconUri(Uri uri) {
        this.privacyIconUri = uri;
    }

    public Uri getPrivacyDestinationUri() {
        return this.privacyDestinationUri;
    }

    public void setVideoView(View view) {
        this.videoView = view;
    }

    private AppLovinNativeAdImpl(Builder builder) {
        super(builder.adObject, builder.fullResponse, builder.sdk);
        this.impressionTracked = new AtomicBoolean();
        this.registeredViews = new ArrayList();
        this.onAttachStateChangeHandler = new a(this);
        this.adEventTracker = new com.applovin.impl.sdk.a.e(this);
        this.title = builder.title;
        this.advertiser = builder.advertiser;
        this.body = builder.body;
        this.callToAction = builder.callToAction;
        this.iconUri = builder.iconUri;
        this.mainImageUri = builder.mainImageUri;
        this.privacyIconUri = builder.privacyIconUri;
        com.applovin.impl.b.a aVar = builder.vastAd;
        this.vastAd = aVar;
        this.clickDestinationUri = builder.clickDestinationUri;
        this.clickDestinationBackupUri = builder.clickDestinationBackupUri;
        this.clickTrackingUrls = builder.clickTrackingUrls;
        this.jsTrackers = builder.jsTrackers;
        this.impressionRequests = builder.impressionRequests;
        Double d = builder.starRating;
        this.starRating = (d == null || d.doubleValue() < 3.0d) ? null : d;
        if (builder.privacyDestinationUri == null) {
            if (!isDspAd() || getSdk().CC().isEnabled()) {
                this.privacyDestinationUri = Uri.parse(DEFAULT_APPLOVIN_PRIVACY_URL);
            }
        } else {
            this.privacyDestinationUri = builder.privacyDestinationUri;
        }
        this.viewableMRC50Callback = new b(builder.viewableMRC50Requests);
        this.viewableMRC100Callback = new b(builder.viewableMRC100Requests);
        if (aVar != null && aVar.hasVideoUrl()) {
            this.viewableVideoMRC50Callback = new b(builder.viewableVideo50Requests);
        }
        this.tag = "AppLovinNativeAd:" + getAdIdNumber();
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void registerViewsForInteraction(List<View> list, ViewGroup viewGroup) {
        this.nativeAdView = viewGroup;
        if (h.KU() && this.nativeAdView.isAttachedToWindow()) {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        } else if (!h.KU() && this.nativeAdView.getParent() != null) {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        } else {
            this.nativeAdView.addOnAttachStateChangeListener(this.onAttachStateChangeHandler);
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Registered ad view for impressions: " + this.nativeAdView);
        }
        if (this.clickDestinationUri == null && this.clickDestinationBackupUri == null) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Skipping click registration - no click URLs provided");
                return;
            }
            return;
        }
        for (View view : list) {
            if (view.hasOnClickListeners()) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h(this.tag, "View has an onClickListener already - " + view);
                }
            }
            if (!view.isClickable()) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h(this.tag, "View is not clickable - " + view);
                }
            }
            if (!view.isEnabled()) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().i(this.tag, "View is not enabled - " + view);
                }
            }
            if (view instanceof Button) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f(this.tag, "Registering click for button: " + view);
                }
            } else {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f(this.tag, "Registering click for view: " + view);
                }
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNw)).booleanValue()) {
                view.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, com.applovin.impl.sdk.c.b.aLk, viewGroup.getContext(), this));
            } else {
                view.setOnClickListener(this);
            }
            this.registeredViews.add(view);
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Registered views: " + this.registeredViews);
        }
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void unregisterViewsForInteraction() {
        for (View view : this.registeredViews) {
            view.setOnTouchListener(null);
            view.setOnClickListener(null);
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Unregistered views: " + this.registeredViews);
        }
        this.registeredViews.clear();
        ad adVar = this.viewableMRC50Tracker;
        if (adVar != null) {
            adVar.Fu();
        }
        ad adVar2 = this.viewableMRC100Tracker;
        if (adVar2 != null) {
            adVar2.Fu();
        }
        ad adVar3 = this.viewableVideoMRC50Tracker;
        if (adVar3 != null) {
            adVar3.Fu();
        }
        ViewGroup viewGroup = this.nativeAdView;
        if (viewGroup != null) {
            viewGroup.removeOnAttachStateChangeListener(this.onAttachStateChangeHandler);
            this.nativeAdView = null;
        }
        AppLovinMediaView appLovinMediaView = this.mediaView;
        if (appLovinMediaView != null) {
            appLovinMediaView.destroy();
        }
        AppLovinOptionsView appLovinOptionsView = this.optionsView;
        if (appLovinOptionsView != null) {
            appLovinOptionsView.destroy();
        }
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void destroy() {
        unregisterViewsForInteraction();
        this.eventListener = null;
        this.adEventTracker.IK();
    }

    public void setUpNativeAdViewComponents() {
        com.applovin.impl.b.a aVar = this.vastAd;
        if (aVar != null && aVar.hasVideoUrl()) {
            try {
                n nVar = this.sdk;
                n nVar2 = this.sdk;
                this.mediaView = new AppLovinVastMediaView(this, nVar, n.getApplicationContext());
            } catch (Throwable th) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().b(this.tag, "Failed to create ExoPlayer VAST media view. Falling back to static image for media view.", th);
                }
                this.sdk.Cq().d(TAG, "createExoPlayerVASTMediaView", th);
                n nVar3 = this.sdk;
                n nVar4 = this.sdk;
                this.mediaView = new AppLovinMediaView(this, nVar3, n.getApplicationContext());
            }
        } else {
            n nVar5 = this.sdk;
            n nVar6 = this.sdk;
            this.mediaView = new AppLovinMediaView(this, nVar5, n.getApplicationContext());
        }
        if (this.privacyDestinationUri != null) {
            n nVar7 = this.sdk;
            n nVar8 = this.sdk;
            this.optionsView = new AppLovinOptionsView(this, nVar7, n.getApplicationContext());
        } else {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Privacy icon will not render because no native ad privacy URL is provided.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandleOnAttachedToWindow(View view) {
        if (this.impressionTracked.compareAndSet(false, true)) {
            ad adVar = new ad(this.nativeAdView, this.sdk, this.viewableMRC50Callback);
            this.viewableMRC50Tracker = adVar;
            adVar.a(0, 50.0f, 50.0f, TimeUnit.SECONDS.toMillis(1L), this.nativeAdView);
            ad adVar2 = new ad(this.nativeAdView, this.sdk, this.viewableMRC100Callback);
            this.viewableMRC100Tracker = adVar2;
            adVar2.a(0, 100.0f, 100.0f, TimeUnit.SECONDS.toMillis(1L), this.nativeAdView);
            com.applovin.impl.b.a aVar = this.vastAd;
            if (aVar != null && aVar.hasVideoUrl()) {
                ad adVar3 = new ad(this.nativeAdView, this.sdk, this.viewableVideoMRC50Callback);
                this.viewableVideoMRC50Tracker = adVar3;
                adVar3.a(0, 50.0f, 50.0f, TimeUnit.SECONDS.toMillis(2L), this.videoView);
            }
            List<String> list = this.jsTrackers;
            if (list != null && list.size() > 0) {
                if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQG)).booleanValue()) {
                    Iterator<String> it = this.jsTrackers.iterator();
                    while (it.hasNext()) {
                        this.sdk.Ce().cQ(it.next());
                    }
                } else {
                    String str = this.jsTrackers.get(0);
                    if (StringUtils.isValidString(str)) {
                        final com.applovin.impl.adview.d dVar = new com.applovin.impl.adview.d(null, this.sdk, view.getContext());
                        dVar.loadData(str, "text/html", "UTF-8");
                        Objects.requireNonNull(dVar);
                        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.-$$Lambda$AppLovinNativeAdImpl$BfwAZVQQVqj7holA2Xp2cKxERsY
                            @Override // java.lang.Runnable
                            public final void run() {
                                dVar.stopLoading();
                            }
                        }, TimeUnit.SECONDS.toMillis(5L));
                    }
                }
            }
            Iterator<i> it2 = this.impressionRequests.iterator();
            while (it2.hasNext()) {
                this.sdk.Cr().dispatchPostbackRequest(it2.next(), null);
            }
            this.adEventTracker.x(view);
            this.adEventTracker.IJ();
            if (this.sdk.BU() != null) {
                this.sdk.BU().I(getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    private List<String> getPrivacySandboxImpressionAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.emptyList());
    }

    private List<com.applovin.impl.sdk.d.a> getDirectClickTrackingPostbacks() {
        List<com.applovin.impl.sdk.d.a> listA;
        synchronized (this.adObjectLock) {
            listA = u.a("click_tracking_urls", this.adObject, getClCode(), getStringFromAdObject("click_tracking_url", null), this.sdk);
        }
        return listA;
    }

    private List<String> getPrivacySandboxClickAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.emptyList());
    }

    private boolean isDspAd() {
        return AD_RESPONSE_TYPE_ORTB.equalsIgnoreCase(getType());
    }

    public String getType() {
        return getStringFromAdObject("type", "undefined");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getTitle() {
        return this.title;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getAdvertiser() {
        return this.advertiser;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getBody() {
        return this.body;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getCallToAction() {
        return this.callToAction;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public Double getStarRating() {
        return this.starRating;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public Uri getIconUri() {
        return this.iconUri;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public AppLovinMediaView getMediaView() {
        return this.mediaView;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public AppLovinOptionsView getOptionsView() {
        return this.optionsView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Handle view clicked");
        }
        this.sdk.BB().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, view.getContext());
    }

    @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
    public void onClick(View view, MotionEvent motionEvent) {
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f(this.tag, "Handle view clicked");
        }
        this.sdk.BB().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, motionEvent, view.getContext());
    }

    protected void handleNativeAdClick(Uri uri, Uri uri2, MotionEvent motionEvent, Context context) {
        if (this.sdk.BU() != null) {
            this.sdk.BU().a(getPrivacySandboxClickAttributionUrls(), motionEvent);
        }
        handleNativeAdClick(uri, uri2, context);
    }

    private void handleNativeAdClick(final Uri uri, final Uri uri2, final Context context) {
        Iterator<String> it = this.clickTrackingUrls.iterator();
        while (it.hasNext()) {
            this.sdk.Cr().dispatchPostbackAsync(it.next(), null);
        }
        m.a(this.eventListener, this);
        if (isDirectDownloadEnabled()) {
            this.sdk.Cp().startDirectInstallOrDownloadProcess(this, null, new ArrayService.DirectDownloadListener() { // from class: com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl.1
                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onAppDetailsDismissed() {
                }

                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onAppDetailsDisplayed() {
                }

                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onFailure() {
                    AppLovinNativeAdImpl.this.launchUri(uri, uri2, context);
                }
            });
        } else {
            launchUri(uri, uri2, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchUri(Uri uri, Uri uri2, Context context) {
        if (s.a(uri, context, this.sdk)) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Opening URL: " + uri);
                return;
            }
            return;
        }
        if (s.a(uri2, context, this.sdk)) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().f(this.tag, "Opening backup URL: " + uri2);
            }
        }
    }

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    public com.applovin.impl.sdk.a.e getAdEventTracker() {
        return this.adEventTracker;
    }

    @Override // com.applovin.impl.sdk.a.a
    public boolean isOpenMeasurementEnabled() {
        return getBooleanFromAdObject("omsdk_enabled", false);
    }

    @Override // com.applovin.impl.sdk.a.a
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.a.a
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.a.a
    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.adObjectLock) {
            JSONArray jSONArray = JsonUtils.getJSONArray(this.adObject, "omid_verification_script_resources", null);
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
                    try {
                        URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                        String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                        String string2 = JsonUtils.getString(jSONObject, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, null);
                        if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                        } else {
                            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                        }
                    } catch (Throwable th) {
                        this.sdk.BL();
                        if (x.Fk()) {
                            this.sdk.BL().c(this.tag, "Failed to parse OMID verification script resource", th);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        return JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", null));
    }

    private class b implements ad.a {
        private final List<i> aHb;

        public b(List<i> list) {
            this.aHb = list;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.canEqual(this)) {
                return false;
            }
            List<i> listHE = HE();
            List<i> listHE2 = bVar.HE();
            return listHE != null ? listHE.equals(listHE2) : listHE2 == null;
        }

        public int hashCode() {
            List<i> listHE = HE();
            return 59 + (listHE == null ? 43 : listHE.hashCode());
        }

        public String toString() {
            return "AppLovinNativeAdImpl.VisibilityCallback(requests=" + HE() + ")";
        }

        public List<i> HE() {
            return this.aHb;
        }

        @Override // com.applovin.impl.sdk.ad.a
        public void onLogVisibilityImpression() {
            Iterator<i> it = this.aHb.iterator();
            while (it.hasNext()) {
                AppLovinNativeAdImpl.this.sdk.Cr().dispatchPostbackRequest(it.next(), null);
            }
        }
    }

    private static class a implements View.OnAttachStateChangeListener {
        private final AppLovinNativeAdImpl aHa;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        public a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.aHa = appLovinNativeAdImpl;
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.canEqual(this)) {
                return false;
            }
            AppLovinNativeAdImpl appLovinNativeAdImplHD = HD();
            AppLovinNativeAdImpl appLovinNativeAdImplHD2 = aVar.HD();
            return appLovinNativeAdImplHD != null ? appLovinNativeAdImplHD.equals(appLovinNativeAdImplHD2) : appLovinNativeAdImplHD2 == null;
        }

        public int hashCode() {
            AppLovinNativeAdImpl appLovinNativeAdImplHD = HD();
            return 59 + (appLovinNativeAdImplHD == null ? 43 : appLovinNativeAdImplHD.hashCode());
        }

        public String toString() {
            return "AppLovinNativeAdImpl.OnAttachStateChangeHandler(ad=" + HD() + ")";
        }

        public AppLovinNativeAdImpl HD() {
            return this.aHa;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.aHa.maybeHandleOnAttachedToWindow(view);
        }
    }

    public String toString() {
        return "AppLovinNativeAd{adIdNumber=" + getAdIdNumber() + " - " + getTitle() + "}";
    }

    public static class Builder {
        private final JSONObject adObject;
        private String advertiser;
        private String body;
        private String callToAction;
        private Uri clickDestinationBackupUri;
        private Uri clickDestinationUri;
        private List<String> clickTrackingUrls;
        private final JSONObject fullResponse;
        private Uri iconUri;
        private List<i> impressionRequests;
        private List<String> jsTrackers;
        private Uri mainImageUri;
        private Uri privacyDestinationUri;
        private Uri privacyIconUri;
        private final n sdk;
        private Double starRating;
        private String title;
        private com.applovin.impl.b.a vastAd;
        private List<i> viewableMRC100Requests;
        private List<i> viewableMRC50Requests;
        private List<i> viewableVideo50Requests;

        public Builder(JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.sdk = nVar;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.advertiser = str;
            return this;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.callToAction = str;
            return this;
        }

        public Builder setStarRating(Double d) {
            this.starRating = d;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        public Builder setMainImageUri(Uri uri) {
            this.mainImageUri = uri;
            return this;
        }

        public Builder setPrivacyIconUri(Uri uri) {
            this.privacyIconUri = uri;
            return this;
        }

        public Builder setVastAd(com.applovin.impl.b.a aVar) {
            this.vastAd = aVar;
            return this;
        }

        public Builder setPrivacyDestinationUri(Uri uri) {
            this.privacyDestinationUri = uri;
            return this;
        }

        public Builder setClickDestinationUri(Uri uri) {
            this.clickDestinationUri = uri;
            return this;
        }

        public Builder setClickDestinationBackupUri(Uri uri) {
            this.clickDestinationBackupUri = uri;
            return this;
        }

        public Builder setClickTrackingUrls(List<String> list) {
            this.clickTrackingUrls = list;
            return this;
        }

        public Builder setJsTrackers(List<String> list) {
            this.jsTrackers = list;
            return this;
        }

        public Builder setImpressionRequests(List<i> list) {
            this.impressionRequests = list;
            return this;
        }

        public Builder setViewableMRC50Requests(List<i> list) {
            this.viewableMRC50Requests = list;
            return this;
        }

        public Builder setViewableMRC100Requests(List<i> list) {
            this.viewableMRC100Requests = list;
            return this;
        }

        public Builder setViewableVideo50Requests(List<i> list) {
            this.viewableVideo50Requests = list;
            return this;
        }

        public AppLovinNativeAdImpl build() {
            return new AppLovinNativeAdImpl(this);
        }
    }
}
