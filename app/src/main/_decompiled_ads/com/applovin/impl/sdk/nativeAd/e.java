package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.e.t;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.i;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.applovin.impl.sdk.e.d implements a.InterfaceC0137a, AppLovinAdLoadListener {
    private final JSONObject adObject;
    private String advertiser;
    private final AppLovinNativeAdLoadListener awc;
    private String body;
    private String callToAction;
    private Uri clickDestinationBackupUri;
    private Uri clickDestinationUri;
    private final List<String> clickTrackingUrls;
    private final JSONObject fullResponse;
    private Uri iconUri;
    private final List<i> impressionRequests;
    private final List<String> jsTrackers;
    private Uri mainImageUri;
    private Uri privacyDestinationUri;
    private Uri privacyIconUri;
    private Double starRating;
    private String title;
    private com.applovin.impl.b.a vastAd;
    private final List<i> viewableMRC100Requests;
    private final List<i> viewableMRC50Requests;
    private final List<i> viewableVideo50Requests;

    public e(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, n nVar) {
        super("TaskRenderNativeAd", nVar);
        this.title = "";
        this.advertiser = "";
        this.body = "";
        this.starRating = null;
        this.callToAction = "";
        this.iconUri = null;
        this.mainImageUri = null;
        this.privacyIconUri = null;
        this.privacyDestinationUri = null;
        this.clickDestinationUri = null;
        this.clickDestinationBackupUri = null;
        this.clickTrackingUrls = new ArrayList();
        this.jsTrackers = new ArrayList();
        this.impressionRequests = new ArrayList();
        this.viewableMRC50Requests = new ArrayList();
        this.viewableMRC100Requests = new ArrayList();
        this.viewableVideo50Requests = new ArrayList();
        this.adObject = jSONObject;
        this.fullResponse = jSONObject2;
        this.awc = appLovinNativeAdLoadListener;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v95 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r2 = 0;
        String string = JsonUtils.getString(this.adObject, "privacy_icon_url", null);
        if (URLUtil.isValidUrl(string)) {
            this.privacyIconUri = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.adObject, CampaignEx.JSON_KEY_PRIVACY_URL, null);
        if (URLUtil.isValidUrl(string2)) {
            this.privacyDestinationUri = Uri.parse(string2);
        }
        JSONObject jSONObject = JsonUtils.getJSONObject(this.adObject, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "No oRtb response provided: " + this.adObject);
            }
            cW("No oRtb response provided");
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, "version", null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "value", (JSONObject) null);
        x xVar2 = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Rendering native ad for oRTB version: " + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, "native", jSONObject2);
        J(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", null);
        if (jSONArray == null || jSONArray.length() == 0) {
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "Unable to retrieve assets - failing ad load: " + this.adObject);
            }
            cW("Unable to retrieve assets");
            return;
        }
        String string4 = "";
        int i = 0;
        while (i < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) r2);
            if (jSONObject4.has("title")) {
                this.title = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r2), "text", r2);
                x xVar4 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Processed title: " + this.title);
                }
            } else if (jSONObject4.has("link")) {
                J(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r2));
            } else if (jSONObject4.has("img")) {
                int i2 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r2);
                int i3 = JsonUtils.getInt(jSONObject5, "type", -1);
                String string5 = JsonUtils.getString(jSONObject5, "url", r2);
                if (i3 == 1 || 3 == i2) {
                    this.iconUri = Uri.parse(string5);
                    x xVar5 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed icon URL: " + this.iconUri);
                    }
                } else if (i3 == 3 || 2 == i2) {
                    this.mainImageUri = Uri.parse(string5);
                    x xVar6 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed main image URL: " + this.mainImageUri);
                    }
                } else {
                    x xVar7 = this.logger;
                    if (x.Fk()) {
                        this.logger.h(this.tag, "Unrecognized image: " + jSONObject4);
                    }
                    int i4 = JsonUtils.getInt(jSONObject5, "w", -1);
                    int i5 = JsonUtils.getInt(jSONObject5, "h", -1);
                    if (i4 <= 0 || i5 <= 0) {
                        x xVar8 = this.logger;
                        if (x.Fk()) {
                            this.logger.h(this.tag, "Skipping...");
                        }
                    } else if (i4 / i5 > 1.0d) {
                        x xVar9 = this.logger;
                        if (x.Fk()) {
                            this.logger.f(this.tag, "Inferring main image from " + i4 + "x" + i5 + "...");
                        }
                        this.mainImageUri = Uri.parse(string5);
                    } else {
                        x xVar10 = this.logger;
                        if (x.Fk()) {
                            this.logger.f(this.tag, "Inferring icon image from " + i4 + "x" + i5 + "...");
                        }
                        this.iconUri = Uri.parse(string5);
                    }
                }
            } else if (jSONObject4.has("video")) {
                string4 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "video", (JSONObject) null), "vasttag", null);
                if (StringUtils.isValidString(string4)) {
                    x xVar11 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed VAST video");
                    }
                } else {
                    x xVar12 = this.logger;
                    if (x.Fk()) {
                        this.logger.h(this.tag, "Ignoring invalid \"vasttag\" for video: " + jSONObject4);
                    }
                }
            } else if (jSONObject4.has("data")) {
                int i6 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                int i7 = JsonUtils.getInt(jSONObject6, "type", -1);
                String string6 = JsonUtils.getString(jSONObject6, "value", null);
                if (i7 == 1 || i6 == 8) {
                    this.advertiser = string6;
                    x xVar13 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed advertiser: " + this.advertiser);
                    }
                } else if (i7 == 2 || i6 == 4) {
                    this.body = string6;
                    x xVar14 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed body: " + this.body);
                    }
                } else if (i7 == 12 || i6 == 5) {
                    this.callToAction = string6;
                    x xVar15 = this.logger;
                    if (x.Fk()) {
                        this.logger.f(this.tag, "Processed cta: " + this.callToAction);
                    }
                } else if (i7 == 3 || i6 == 6) {
                    double dA = u.a(string6, -1.0d);
                    if (dA == -1.0d) {
                        x xVar16 = this.logger;
                        if (x.Fk()) {
                            this.logger.f(this.tag, "Received invalid star rating: " + string6);
                        }
                    } else {
                        this.starRating = Double.valueOf(dA);
                        x xVar17 = this.logger;
                        if (x.Fk()) {
                            this.logger.f(this.tag, "Processed star rating: " + this.starRating);
                        }
                    }
                } else {
                    x xVar18 = this.logger;
                    if (x.Fk()) {
                        this.logger.h(this.tag, "Skipping unsupported data: " + jSONObject4);
                    }
                }
            } else {
                x xVar19 = this.logger;
                if (x.Fk()) {
                    this.logger.i(this.tag, "Unsupported asset object: " + jSONObject4);
                }
            }
            i++;
            r2 = 0;
        }
        String string7 = JsonUtils.getString(jSONObject3, "jstracker", null);
        if (StringUtils.isValidString(string7)) {
            this.jsTrackers.add(string7);
            x xVar20 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Processed jstracker: " + string7);
            }
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", null);
        if (jSONArray2 != null) {
            int i8 = 0;
            while (i8 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i8, obj);
                if (objectAtIndex instanceof String) {
                    String str = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str)) {
                        this.impressionRequests.add(new i.a(this.sdk).da(str).aU(false).aS(false).Ie());
                        x xVar21 = this.logger;
                        if (x.Fk()) {
                            this.logger.f(this.tag, "Processed imptracker URL: " + str);
                        }
                    }
                }
                i8++;
                obj = null;
            }
        }
        ?? r3 = 0;
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", null);
        if (jSONArray3 != null) {
            int i9 = 0;
            while (i9 < jSONArray3.length()) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i9, (JSONObject) r3);
                int i10 = JsonUtils.getInt(jSONObject7, "event", -1);
                int i11 = JsonUtils.getInt(jSONObject7, "method", -1);
                String string8 = JsonUtils.getString(jSONObject7, "url", r3);
                if (!TextUtils.isEmpty(string8)) {
                    if (i11 != 1 && i11 != 2) {
                        x xVar22 = this.logger;
                        if (x.Fk()) {
                            this.logger.i(this.tag, "Unsupported method for event tracker: " + jSONObject7);
                        }
                    } else if (i11 == 2 && string8.startsWith("<script")) {
                        this.jsTrackers.add(string8);
                    } else {
                        i iVarIe = new i.a(this.sdk).da(string8).aU(false).aS(false).bb(i11 == 2).Ie();
                        if (i10 == 1) {
                            this.impressionRequests.add(iVarIe);
                            x xVar23 = this.logger;
                            if (x.Fk()) {
                                this.logger.f(this.tag, "Processed impression URL: " + string8);
                            }
                        } else if (i10 == 2) {
                            this.viewableMRC50Requests.add(iVarIe);
                            x xVar24 = this.logger;
                            if (x.Fk()) {
                                this.logger.f(this.tag, "Processed viewable MRC50 URL: " + string8);
                            }
                        } else if (i10 == 3) {
                            this.viewableMRC100Requests.add(iVarIe);
                            x xVar25 = this.logger;
                            if (x.Fk()) {
                                this.logger.f(this.tag, "Processed viewable MRC100 URL: " + string8);
                            }
                        } else if (i10 == 4) {
                            this.viewableVideo50Requests.add(iVarIe);
                            x xVar26 = this.logger;
                            if (x.Fk()) {
                                this.logger.f(this.tag, "Processed viewable video 50 URL: " + string8);
                            }
                        } else if (i10 == 555) {
                            x xVar27 = this.logger;
                            if (x.Fk()) {
                                this.logger.f(this.tag, "Ignoring processing of OMID URL: " + string8);
                            }
                        } else {
                            x xVar28 = this.logger;
                            if (x.Fk()) {
                                this.logger.i(this.tag, "Unsupported event tracker: " + jSONObject7);
                            }
                        }
                    }
                }
                i9++;
                r3 = 0;
            }
        }
        if (StringUtils.isValidString(string4)) {
            x xVar29 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Processing VAST video...");
            }
            this.sdk.BM().b(t.a(string4, JsonUtils.shallowCopy(this.adObject), JsonUtils.shallowCopy(this.fullResponse), com.applovin.impl.sdk.ad.b.UNKNOWN, this, this.sdk));
            return;
        }
        HH();
    }

    private void J(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String string = JsonUtils.getString(jSONObject, "url", null);
        if (StringUtils.isValidString(string)) {
            this.clickDestinationUri = Uri.parse(string);
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Processed click destination URL: " + this.clickDestinationUri);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "fallback", null);
        if (StringUtils.isValidString(string2)) {
            this.clickDestinationBackupUri = Uri.parse(string2);
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Processed click destination backup URL: " + this.clickDestinationBackupUri);
            }
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", null);
        if (jSONArray != null) {
            try {
                this.clickTrackingUrls.addAll(JsonUtils.toList(jSONArray));
                x xVar3 = this.logger;
                if (x.Fk()) {
                    this.logger.f(this.tag, "Processed click tracking URLs: " + this.clickTrackingUrls);
                }
            } catch (Throwable th) {
                x xVar4 = this.logger;
                if (x.Fk()) {
                    this.logger.c(this.tag, "Failed to render click tracking URLs", th);
                }
            }
        }
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "VAST ad rendered successfully");
        }
        this.vastAd = (com.applovin.impl.b.a) appLovinAd;
        HH();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.i(this.tag, "VAST ad failed to render");
        }
        HH();
    }

    private void HH() {
        AppLovinNativeAdImpl appLovinNativeAdImplBuild = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.adObject), JsonUtils.shallowCopy(this.fullResponse), this.sdk).setTitle(this.title).setAdvertiser(this.advertiser).setBody(this.body).setCallToAction(this.callToAction).setStarRating(this.starRating).setIconUri(this.iconUri).setMainImageUri(this.mainImageUri).setPrivacyIconUri(this.privacyIconUri).setVastAd(this.vastAd).setPrivacyDestinationUri(this.privacyDestinationUri).setClickDestinationUri(this.clickDestinationUri).setClickDestinationBackupUri(this.clickDestinationBackupUri).setClickTrackingUrls(this.clickTrackingUrls).setJsTrackers(this.jsTrackers).setImpressionRequests(this.impressionRequests).setViewableMRC50Requests(this.viewableMRC50Requests).setViewableMRC100Requests(this.viewableMRC100Requests).setViewableVideo50Requests(this.viewableVideo50Requests).build();
        appLovinNativeAdImplBuild.getAdEventTracker().IH();
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Starting cache task for type: " + appLovinNativeAdImplBuild.getType() + "...");
        }
        this.sdk.BM().a(new a(appLovinNativeAdImplBuild, this.sdk, this), q.b.MAIN);
    }

    @Override // com.applovin.impl.sdk.nativeAd.a.InterfaceC0137a
    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Successfully cached and loaded ad");
        }
        b(appLovinNativeAdImpl);
    }

    private void b(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.-$$Lambda$e$7Xn64U7NUFybMJHyvrWGut_fvSU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(appLovinNativeAdImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.f(this.tag, "Preparing native ad view components...");
        }
        try {
            appLovinNativeAdImpl.setUpNativeAdViewComponents();
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.f(this.tag, "Successfully prepared native ad view components");
            }
            appLovinNativeAdImpl.getAdEventTracker().II();
            this.awc.onNativeAdLoaded(appLovinNativeAdImpl);
        } catch (Throwable th) {
            x xVar3 = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to prepare native ad view components", th);
            }
            cW(th.getMessage());
            this.sdk.Cq().d(this.tag, "prepareNativeComponents", th);
        }
    }

    private void cW(String str) {
        this.awc.onNativeAdLoadFailed(new AppLovinError(-6, str));
    }
}
