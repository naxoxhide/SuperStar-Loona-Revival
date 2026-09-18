package com.adxcorp.ads.mediation.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.ADXSdk;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.AdRequest;
import com.adxcorp.ads.mediation.common.AdResponse;
import com.adxcorp.ads.mediation.common.DataKeys;
import com.adxcorp.ads.mediation.event.AdEventListener;
import com.adxcorp.ads.mediation.nativeads.NativeAdData;
import com.adxcorp.ads.mediation.network.NetworkServiceManager;
import com.adxcorp.ads.mediation.pref.Preference;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.ads.mediation.videoads.VideoAdData;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdController {
    public static final String TAG = "AdController";
    private static final int WAIT_INTERVAL_MILLI_TIME = 100;
    private static final int WAIT_MAXIMUM_MILLI_TIME = 2000;
    private AdEventListener mAdEventListener;
    private AdRequest mAdRequest;
    private Context mContext;
    private Handler mHandler;
    private boolean mIsLoading;
    private HashMap<String, String> mQueryMap;
    private String mSlotId;
    private int waitTime;

    static /* synthetic */ int access$012(AdController adController, int i) {
        int i2 = adController.waitTime + i;
        adController.waitTime = i2;
        return i2;
    }

    public AdController(Context context, AdEventListener adEventListener) {
        this.waitTime = 0;
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "AdController instance is created.");
        }
        this.mContext = context;
        this.mAdEventListener = adEventListener;
        this.waitTime = 0;
    }

    public void setSlotID(String str) {
        this.mSlotId = str;
    }

    public void destroy() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
        this.mAdRequest = null;
        this.mAdEventListener = null;
    }

    public void loadAd(HashMap<String, String> map) {
        this.mQueryMap = map;
        loadAd();
    }

    public void loadAd() {
        if (this.mContext == null) {
            ADXLogUtil.e(TAG, new Exception("Context cannot be null."));
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mSlotId)) {
            ADXLogUtil.e(TAG, new Exception("AdUnit ID cannot be null."));
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(101);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(ADXSdk.getInstance().getAppId())) {
            if (!ADXSdk.getInstance().isInitialized() || !MediationSDK.getInstance().isInitialized()) {
                if (this.waitTime < 2000) {
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = new Handler(Looper.getMainLooper());
                    this.mHandler = handler2;
                    handler2.postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.controller.AdController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdController.access$012(AdController.this, 100);
                            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                                ADXLogUtil.d(AdController.TAG, "waiting : " + AdController.this.waitTime);
                            }
                            AdController.this.loadAd();
                        }
                    }, 100L);
                    return;
                }
                ADXLogUtil.d(TAG, "AdSDK must be initialized before ads loading.");
                AdEventListener adEventListener3 = this.mAdEventListener;
                if (adEventListener3 != null) {
                    adEventListener3.notifyAdFailedToLoad(105);
                    return;
                }
                return;
            }
            if (this.mIsLoading) {
                ADXLogUtil.d(TAG, "AdSDK (" + this.mSlotId + ") is already loading an ad. Wait for previous load to finish.");
                AdEventListener adEventListener4 = this.mAdEventListener;
                if (adEventListener4 != null) {
                    adEventListener4.notifyAdFailedToLoad(106);
                    return;
                }
                return;
            }
            int networkConnectionType = MediationSDK.getInstance().getNetworkConnectionType();
            if (networkConnectionType == 0) {
                AdEventListener adEventListener5 = this.mAdEventListener;
                if (adEventListener5 != null) {
                    adEventListener5.notifyAdFailedToLoad(103);
                    return;
                }
                return;
            }
            getRequest().setConnectionType(networkConnectionType);
            getRequest().setUserAgent(MediationSDK.getInstance().getUserAgent());
            this.mIsLoading = true;
            fetchAd();
            return;
        }
        String stringValue = Preference.getStringValue(this.mContext, DataKeys.getKeyWithSlot("MEDIA_ID_OF_SLOT", this.mSlotId), null);
        if (!TextUtils.isEmpty(stringValue)) {
            MediationSDK.getInstance().initialize(this.mContext, stringValue);
        }
        ADXLogUtil.d(TAG, "AdSDK must be initialized before ads loading.");
        AdEventListener adEventListener6 = this.mAdEventListener;
        if (adEventListener6 != null) {
            adEventListener6.notifyAdFailedToLoad(105);
        }
    }

    private void fetchAd() {
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            ADXLogUtil.d(TAG, "fetchAd : " + getRequest().toString());
        }
        NetworkServiceManager.getInstance().get(getRequest().getRequestURL() + "?" + getRequest().toUri().getEncodedQuery(), new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.controller.AdController.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 200) {
                    AdController.this.parsing(message.obj);
                } else if (AdController.this.mAdEventListener != null) {
                    AdController.this.mAdEventListener.notifyAdFailedToLoad(102);
                }
                AdController.this.mIsLoading = false;
            }
        });
    }

    private AdRequest getRequest() {
        if (this.mAdRequest == null) {
            this.mAdRequest = (AdRequest) MediationSDK.getInstance().getCommonHeader().clone();
        }
        this.mAdRequest.setRequestURL("https://api.mediation.adxcorp.kr/v1/mediations", true);
        this.mAdRequest.setAppId(MediationSDK.getInstance().getAppId());
        this.mAdRequest.setAdUnitId(this.mSlotId);
        this.mAdRequest.setQueryMap(this.mQueryMap);
        return this.mAdRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parsing(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mediations");
            if (jSONArrayOptJSONArray != null) {
                receivedMediationData(jSONArrayOptJSONArray, jSONObject.optString("requestId"), jSONObject.optString("metricEndpointFormat"), jSONObject.optString("settings"), jSONObject.optString("newsFeed"));
            } else {
                AdEventListener adEventListener = this.mAdEventListener;
                if (adEventListener != null) {
                    adEventListener.notifyAdFailedToLoad(111);
                }
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(104);
            }
        }
    }

    private ArrayList convertJSONArrayToArrayList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strOptString = jSONArray.optString(i);
                if (strOptString != null) {
                    arrayList.add(strOptString);
                }
            }
        }
        return arrayList;
    }

    private int[] convertJSONArrayToIntArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            iArr[i] = jSONArray.optInt(i);
        }
        return iArr;
    }

    public void receivedMediationData(JSONArray jSONArray, String str, String str2, String str3, String str4) {
        NewsFeed newsFeed;
        JSONException e;
        try {
            ArrayList<MediationData> arrayList = new ArrayList<>(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    MediationData mediationData = new MediationData();
                    mediationData.setRequestId(str);
                    mediationData.setMetricEndpointFormat(str2);
                    mediationData.setMediationId(jSONObject.getString("mediationId"));
                    mediationData.setAdNetworkName(jSONObject.getString("adNetworkName"));
                    mediationData.setCustomEventName(jSONObject.getString("customEventName"));
                    mediationData.setCustomEventParams(jSONObject.getString("customEventParams"));
                    mediationData.setBidResponse(jSONObject.optString("bidResponse"));
                    mediationData.setEcpm(jSONObject.optDouble("ecpm"));
                    arrayList.add(mediationData);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            MediationSettings mediationSettings = new MediationSettings();
            try {
                JSONObject jSONObject2 = new JSONObject(str3);
                mediationSettings.setMediationRequestTimeout(jSONObject2.optLong("mediationRequestTimeout", 0L));
                mediationSettings.setBannerRefreshInterval(jSONObject2.optLong("bannerRefreshInterval", 0L));
                mediationSettings.setBiddingKitMediationId(jSONObject2.optString("biddingKitMediationId"));
                mediationSettings.setBiddingKitAdUnitId(jSONObject2.optString("biddingKitAdUnitId"));
                double d = 0.05d;
                if (jSONObject2.has("biddingKitEcpm")) {
                    double d2 = jSONObject2.getDouble("biddingKitEcpm");
                    if (d2 != 0.0d) {
                        d = d2;
                    }
                    mediationSettings.setBiddingKitEcpm(d);
                } else {
                    mediationSettings.setBiddingKitEcpm(0.05d);
                }
                mediationSettings.setEnableBiddingKit(jSONObject2.optBoolean("enableBiddingKit"));
                mediationSettings.setBiddingKitRequestId(str);
                mediationSettings.setBiddingKitMetricEndpointFormat(str2);
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "MediationSettings : " + mediationSettings);
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            NewsFeed newsFeed2 = null;
            try {
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject jSONObject3 = new JSONObject(str4);
                    newsFeed = new NewsFeed();
                    try {
                        newsFeed.setTitle(jSONObject3.optString("title"));
                        newsFeed.setLink(jSONObject3.optString("link"));
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                    newsFeed2 = newsFeed;
                }
            } catch (JSONException e5) {
                newsFeed = null;
                e = e5;
            }
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyMediationLoaded(arrayList, mediationSettings, newsFeed2);
            }
        } catch (Exception e6) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e6);
            }
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(104);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void parsingBidResponse(MediationData mediationData) {
        int i;
        int i2;
        long j;
        try {
            AdResponse adResponse = new AdResponse();
            JSONObject jSONObject = new JSONObject(mediationData.getBidResponse());
            int iOptInt = jSONObject.optInt("result", -1);
            adResponse.setResult(iOptInt);
            adResponse.setMessage(jSONObject.optString("message"));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            long jOptLong = 0;
            if (jSONObjectOptJSONObject != null) {
                jOptLong = jSONObjectOptJSONObject.optLong(TJAdUnitConstants.String.INTERVAL);
                if (iOptInt == 0) {
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("count");
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ad");
                    if (jSONObjectOptJSONObject2 != null) {
                        int iOptInt3 = jSONObjectOptJSONObject2.optInt("ictype");
                        int iOptInt4 = jSONObjectOptJSONObject2.optInt("wv_clk_v2");
                        int iOptInt5 = jSONObjectOptJSONObject2.optInt("back_enable", 1);
                        if (iOptInt3 == 11 || iOptInt3 == 21) {
                            i2 = iOptInt2;
                            j = jOptLong;
                            AdData adData = new AdData();
                            adData.setIcType(iOptInt3);
                            adData.setOrientation(jSONObjectOptJSONObject2.optInt("orientation"));
                            adData.setWebviewLanding(iOptInt4);
                            adData.setBackButtonEnabled(iOptInt5);
                            adData.setAdm(jSONObjectOptJSONObject2.getString("adm"));
                            adData.setAdmImageTag(jSONObjectOptJSONObject2.optString("adm_img_tag"));
                            adData.setContentWidth(jSONObjectOptJSONObject2.optInt("width"));
                            adData.setContentHeight(jSONObjectOptJSONObject2.optInt("height"));
                            adData.setBgColor(jSONObjectOptJSONObject2.optString("bgcolor"));
                            adData.setPosition(jSONObjectOptJSONObject2.optInt("position"));
                            adData.setAnimationType(jSONObjectOptJSONObject2.optInt(TJAdUnitConstants.String.SPLIT_VIEW_ANIMATION));
                            adData.setCloseButtonPosition(jSONObjectOptJSONObject2.optInt("xposition"));
                            adData.setCloseButtonDelay(jSONObjectOptJSONObject2.optLong(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_CBD));
                            adData.setMonitoring(jSONObjectOptJSONObject2.optInt("act"));
                            adData.setWebviewLoadingSkip(jSONObjectOptJSONObject2.optInt("wvls"));
                            adData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject2.optJSONArray("imptrackers")));
                            adData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject2.optJSONArray("clicktrackers")));
                            adResponse.setAdData(adData);
                        } else {
                            i2 = iOptInt2;
                            j = jOptLong;
                            if (iOptInt3 == 31) {
                                JSONObject jSONObject2 = jSONObjectOptJSONObject2.getJSONObject("native");
                                NativeAdData nativeAdData = new NativeAdData();
                                nativeAdData.setIcType(iOptInt3);
                                nativeAdData.setWebviewLanding(iOptInt4);
                                nativeAdData.setAssetTypes(convertJSONArrayToIntArray(jSONObject2.optJSONArray("assettype")));
                                nativeAdData.setTitle(jSONObject2.optString("title"));
                                nativeAdData.setDescription(jSONObject2.optString(CampaignEx.JSON_KEY_DESC));
                                nativeAdData.setIconImageUrl(jSONObject2.optString("img_icon"));
                                nativeAdData.setMainImageUrl(jSONObject2.optString("img_main"));
                                nativeAdData.setMainWidth(jSONObjectOptJSONObject2.optInt("width"));
                                nativeAdData.setMainHeight(jSONObjectOptJSONObject2.optInt("height"));
                                nativeAdData.setCallToAction(jSONObject2.optString(SDKConstants.PARAM_GAME_REQUESTS_CTA));
                                nativeAdData.setRating(jSONObject2.optDouble(CampaignEx.JSON_KEY_STAR));
                                nativeAdData.setLink(jSONObject2.optString("link"));
                                nativeAdData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObject2.optJSONArray("imptrackers")));
                                nativeAdData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObject2.optJSONArray("clicktrackers")));
                                nativeAdData.setOptoutImageUrl(jSONObject2.optString("optout_img"));
                                nativeAdData.setOptoutLink(jSONObject2.optString("optout_link"));
                                nativeAdData.setOnlyClickCTA(jSONObject2.optInt("ck_cta"));
                                adResponse.setAdData(nativeAdData);
                            } else if (iOptInt3 == 32) {
                                JSONObject jSONObject3 = jSONObjectOptJSONObject2.getJSONObject("video");
                                NativeAdData nativeAdData2 = new NativeAdData();
                                nativeAdData2.setIcType(iOptInt3);
                                nativeAdData2.setWebviewLanding(iOptInt4);
                                nativeAdData2.setAssetTypes(convertJSONArrayToIntArray(jSONObject3.optJSONArray("assettype")));
                                nativeAdData2.setTitle(jSONObject3.optString("title"));
                                nativeAdData2.setDescription(jSONObject3.optString("description"));
                                nativeAdData2.setIconImageUrl(jSONObject3.optString("img_icon"));
                                nativeAdData2.setCallToAction(jSONObject3.optString("link_text"));
                                nativeAdData2.setLink(jSONObject3.optString("link"));
                                nativeAdData2.setOptoutImageUrl(jSONObject3.optString("optout_img"));
                                nativeAdData2.setOptoutLink(jSONObject3.optString("optout_link"));
                                nativeAdData2.setOnlyClickCTA(jSONObject3.optInt("ck_cta"));
                                VideoAdData videoAdData = new VideoAdData();
                                videoAdData.setIcType(iOptInt3);
                                videoAdData.setTitle(jSONObject3.optString("title"));
                                videoAdData.setDescription(jSONObject3.optString("description"));
                                videoAdData.setDuration(jSONObject3.optInt("duration"));
                                videoAdData.setLink(jSONObject3.optString("link"));
                                videoAdData.setLinkText(jSONObject3.optString("link_text"));
                                videoAdData.setVideoContent(jSONObject3.getString("content"));
                                videoAdData.setVideoContentType(jSONObject3.optString(FirebaseAnalytics.Param.CONTENT_TYPE));
                                videoAdData.setDelivery(jSONObject3.optInt("delivery"));
                                videoAdData.setContentWidth(jSONObject3.optInt("content_width"));
                                videoAdData.setContentHeight(jSONObject3.optInt("content_height"));
                                videoAdData.setAutoPlay(jSONObject3.optInt("autoplay") != 0);
                                JSONObject jSONObjectOptJSONObject3 = jSONObject3.optJSONObject("trackers");
                                if (jSONObjectOptJSONObject3 != null) {
                                    videoAdData.setTrackingStartUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("start")));
                                    videoAdData.setTrackingFirstQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                                    videoAdData.setTrackingMidpointUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("midpoint")));
                                    videoAdData.setTrackingThirdQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                                    videoAdData.setTrackingCompleteUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("complete")));
                                    videoAdData.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("impression")));
                                    nativeAdData2.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("impression")));
                                    videoAdData.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("click")));
                                    nativeAdData2.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject3.optJSONArray("click")));
                                }
                                nativeAdData2.setVideoAdData(videoAdData);
                                adResponse.setAdData(nativeAdData2);
                                adResponse = adResponse;
                            } else {
                                if (iOptInt3 != 52 && iOptInt3 != 42 && iOptInt3 != 22) {
                                    ADXLogUtil.i(TAG, "This icType is not matched. -> " + iOptInt3);
                                    AdEventListener adEventListener = this.mAdEventListener;
                                    if (adEventListener != null) {
                                        adEventListener.notifyAdFailedToLoad(108);
                                        return;
                                    }
                                    return;
                                }
                                JSONObject jSONObject4 = jSONObjectOptJSONObject2.getJSONObject("video");
                                VideoAdData videoAdData2 = new VideoAdData();
                                videoAdData2.setIcType(iOptInt3);
                                videoAdData2.setOrientation(jSONObjectOptJSONObject2.optInt("orientation"));
                                videoAdData2.setWebviewLanding(iOptInt4);
                                videoAdData2.setBackButtonEnabled(iOptInt5);
                                videoAdData2.setTitle(jSONObject4.optString("title"));
                                videoAdData2.setDescription(jSONObject4.optString("description"));
                                videoAdData2.setSkipOffset(jSONObject4.optInt("skip_offset"));
                                videoAdData2.setDuration(jSONObject4.optInt("duration"));
                                videoAdData2.setLink(jSONObject4.optString("link"));
                                videoAdData2.setLinkText(jSONObject4.optString("link_text"));
                                videoAdData2.setVideoContent(jSONObject4.getString("content"));
                                videoAdData2.setVideoContentType(jSONObject4.optString(FirebaseAnalytics.Param.CONTENT_TYPE));
                                videoAdData2.setDelivery(jSONObject4.optInt("delivery"));
                                videoAdData2.setContentWidth(jSONObject4.optInt("content_width"));
                                videoAdData2.setContentHeight(jSONObject4.optInt("content_height"));
                                videoAdData2.setOptoutImageUrl(jSONObject4.optString("optout_img"));
                                videoAdData2.setOptoutLink(jSONObject4.optString("optout_link"));
                                JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject("trackers");
                                if (jSONObjectOptJSONObject4 != null) {
                                    videoAdData2.setTrackingStartUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("start")));
                                    videoAdData2.setTrackingFirstQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_FIRST_QUARTILE)));
                                    videoAdData2.setTrackingMidpointUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("midpoint")));
                                    videoAdData2.setTrackingThirdQuartileUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray(CampaignEx.JSON_NATIVE_VIDEO_THIRD_QUARTILE)));
                                    videoAdData2.setTrackingCompleteUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("complete")));
                                    videoAdData2.setTrackingImpUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("impression")));
                                    videoAdData2.setTrackingClkUrls(convertJSONArrayToArrayList(jSONObjectOptJSONObject4.optJSONArray("click")));
                                }
                                adResponse = adResponse;
                                adResponse.setAdData(videoAdData2);
                            }
                        }
                    } else {
                        i2 = iOptInt2;
                        j = jOptLong;
                    }
                    i = i2;
                    jOptLong = j;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            adResponse.setInterval(jOptLong);
            adResponse.setCount(i);
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.receivedResponse(adResponse);
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
            AdEventListener adEventListener3 = this.mAdEventListener;
            if (adEventListener3 != null) {
                adEventListener3.notifyAdFailedToLoad(108);
            }
        }
    }

    private void addMetricUrls(AdData adData, MediationData mediationData) {
        if (adData == null || mediationData == null) {
            return;
        }
        if (adData.getTrackingImpUrls() != null) {
            adData.getTrackingImpUrls().add(ReportUtil.getMetricUrl(mediationData, "impression"));
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(ReportUtil.getMetricUrl(mediationData, "impression"));
            adData.setTrackingImpUrls(arrayList);
        }
        if (adData.getTrackingClkUrls() != null) {
            adData.getTrackingClkUrls().add(ReportUtil.getMetricUrl(mediationData, "click"));
        } else {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(ReportUtil.getMetricUrl(mediationData, "click"));
            adData.setTrackingClkUrls(arrayList2);
        }
        if (adData.getTrackingCloseUrls() != null) {
            adData.getTrackingCloseUrls().add(ReportUtil.getMetricUrl(mediationData, "close"));
        } else {
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.add(ReportUtil.getMetricUrl(mediationData, "close"));
            adData.setTrackingCloseUrls(arrayList3);
        }
        if (adData instanceof VideoAdData) {
            VideoAdData videoAdData = (VideoAdData) adData;
            if (videoAdData.getTrackingCompleteUrls() != null) {
                videoAdData.getTrackingCompleteUrls().add(ReportUtil.getMetricUrl(mediationData, ReportUtil.EVENT_TYPE_REWARD));
                return;
            }
            ArrayList<String> arrayList4 = new ArrayList<>();
            arrayList4.add(ReportUtil.getMetricUrl(mediationData, ReportUtil.EVENT_TYPE_REWARD));
            videoAdData.setTrackingCompleteUrls(arrayList4);
        }
    }
}
