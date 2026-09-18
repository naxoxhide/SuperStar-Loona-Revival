package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkUtils;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AppLovinAdServiceImpl implements com.applovin.impl.sdk.b.a, AppLovinAdService {
    private final Map<com.applovin.impl.sdk.ad.d, c> als;
    private final Object alt = new Object();
    private final Map<String, String> azp = new HashMap();
    private final AtomicReference<JSONObject> azq = new AtomicReference<>();
    private final x logger;
    private final n sdk;

    AppLovinAdServiceImpl(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        HashMap map = new HashMap(6);
        this.als = map;
        map.put(com.applovin.impl.sdk.ad.d.FS(), new c());
        map.put(com.applovin.impl.sdk.ad.d.FT(), new c());
        map.put(com.applovin.impl.sdk.ad.d.FU(), new c());
        map.put(com.applovin.impl.sdk.ad.d.FV(), new c());
        map.put(com.applovin.impl.sdk.ad.d.FW(), new c());
        map.put(com.applovin.impl.sdk.ad.d.FX(), new c());
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No zone id specified");
        }
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Loading next ad of zone {" + str + "}");
        }
        a(com.applovin.impl.sdk.ad.d.cU(str), appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public String getBidToken() {
        String bidToken;
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "getBidToken()");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (this.sdk.BT() != null) {
            bidToken = this.sdk.BT().getBidToken();
        } else {
            bidToken = this.sdk.BQ().getBidToken();
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (StringUtils.isValidString(bidToken) && x.Fk()) {
            this.logger.f("AppLovinAdService", "Successfully retrieved bid token");
        }
        return bidToken;
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForAdToken(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            x.H("AppLovinAdService", "Empty ad token");
            a(new AppLovinError(-8, "Empty ad token"), appLovinAdLoadListener);
            return;
        }
        com.applovin.impl.sdk.ad.c cVar = new com.applovin.impl.sdk.ad.c(strTrim, this.sdk);
        AppLovinAdLoadListener aVar = ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aKA)).booleanValue() ? new a(appLovinAdLoadListener) : appLovinAdLoadListener;
        if (cVar.FN() == com.applovin.impl.sdk.ad.c.a.REGULAR) {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Loading next ad for token: " + cVar);
            }
            a(new com.applovin.impl.sdk.e.o(cVar, aVar, this.sdk));
            return;
        }
        if (cVar.FN() == com.applovin.impl.sdk.ad.c.a.AD_RESPONSE_JSON) {
            JSONObject jSONObjectFP = cVar.FP();
            if (jSONObjectFP != null) {
                com.applovin.impl.sdk.utils.i.j(jSONObjectFP, this.sdk);
                com.applovin.impl.sdk.utils.i.i(jSONObjectFP, this.sdk);
                com.applovin.impl.sdk.utils.i.k(jSONObjectFP, this.sdk);
                g.o(this.sdk);
                if (JsonUtils.getJSONArray(jSONObjectFP, CampaignUnit.JSON_KEY_ADS, new JSONArray()).length() > 0) {
                    if (x.Fk()) {
                        this.logger.f("AppLovinAdService", "Rendering ad for token: " + cVar);
                    }
                    a(new com.applovin.impl.sdk.e.r(jSONObjectFP, com.applovin.impl.sdk.utils.u.l(jSONObjectFP, this.sdk), com.applovin.impl.sdk.ad.b.DECODED_AD_TOKEN_JSON, aVar, this.sdk));
                    return;
                } else {
                    if (x.Fk()) {
                        this.logger.i("AppLovinAdService", "No ad returned from the server for token: " + cVar);
                    }
                    a(AppLovinError.NO_FILL, appLovinAdLoadListener);
                    return;
                }
            }
            String str2 = "Unable to retrieve ad response JSON from token: " + cVar.mQ();
            AppLovinError appLovinError = new AppLovinError(-8, str2);
            x.H("AppLovinAdService", str2);
            a(appLovinError, appLovinAdLoadListener);
            return;
        }
        AppLovinError appLovinError2 = new AppLovinError(-8, "Invalid token type");
        x.H("AppLovinAdService", "Invalid token type");
        a(appLovinError2, appLovinAdLoadListener);
    }

    @Override // com.applovin.sdk.AppLovinAdService
    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (listRemoveTrimmedEmptyStrings == null || listRemoveTrimmedEmptyStrings.isEmpty()) {
            x.H("AppLovinAdService", "No zones were provided");
            b(new AppLovinError(-7, ""), appLovinAdLoadListener);
        } else {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Loading next ad for zones: " + listRemoveTrimmedEmptyStrings);
            }
            a(new com.applovin.impl.sdk.e.m(listRemoveTrimmedEmptyStrings, appLovinAdLoadListener, this.sdk));
        }
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(com.applovin.impl.sdk.ad.d.cV(str), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(com.applovin.impl.sdk.ad.d.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    private void a(com.applovin.impl.sdk.ad.d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        if (appLovinAdLoadListener == null) {
            throw new IllegalArgumentException("No callback specified");
        }
        this.sdk.BL();
        if (x.Fk()) {
            this.sdk.BL().f("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
        }
        c cVarG = g(dVar);
        synchronized (cVarG.azz) {
            cVarG.azC.add(appLovinAdLoadListener);
            if (!cVarG.azA) {
                cVarG.azA = true;
                a(dVar, new b(dVar, cVarG));
            } else if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Already waiting on an ad load...");
            }
        }
    }

    private void a(com.applovin.impl.sdk.e.d dVar) {
        if (!this.sdk.isEnabled()) {
            x.F("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.sdk.Bj();
        this.sdk.BM().a(dVar, com.applovin.impl.sdk.e.q.b.MAIN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$AppLovinAdServiceImpl$wsWi9k1eaNdZR1ABS2P43hr3v5U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(appLovinAdLoadListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAdLoadListener appLovinAdLoadListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdLoadListener.adReceived(appLovinAd);
        } catch (Throwable th) {
            x.e("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
            this.sdk.Cq().d("AppLovinAdService", "notifyAdLoadedCallback", th);
        }
    }

    private void a(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i) {
            ((com.applovin.impl.sdk.ad.i) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinError appLovinError, final AppLovinAdLoadListener appLovinAdLoadListener) {
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$AppLovinAdServiceImpl$bo72lkF8tijv57lHSZlLjO135dA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(appLovinError, appLovinAdLoadListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(AppLovinError appLovinError, AppLovinAdLoadListener appLovinAdLoadListener) {
        try {
            a(appLovinError, appLovinAdLoadListener);
        } catch (Throwable th) {
            x.e("AppLovinAdService", "Unable to notify listener about ad load failure", th);
            this.sdk.Cq().d("AppLovinAdService", "notifyAdLoadFailedCallback" + (appLovinAdLoadListener instanceof com.applovin.impl.sdk.ad.i ? "V2" : ""), th);
        }
    }

    public AppLovinAd dequeueAd(com.applovin.impl.sdk.ad.d dVar) {
        AppLovinAdImpl appLovinAdImplB = this.sdk.BY().b(dVar);
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Dequeued ad: " + appLovinAdImplB + " for zone: " + dVar + "...");
        }
        return appLovinAdImplB;
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.azp) {
            this.azp.putAll(map);
        }
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        Map<String, String> map;
        synchronized (this.azp) {
            map = CollectionUtils.map(this.azp);
            this.azp.clear();
        }
        return map;
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.azq.set(jSONObject);
    }

    public JSONObject getAndResetCustomPostBody() {
        return this.azq.getAndSet(null);
    }

    public void trackAndLaunchVideoClick(final com.applovin.impl.sdk.ad.e eVar, final Uri uri, MotionEvent motionEvent, Bundle bundle, final com.applovin.impl.adview.activity.b.a aVar, final Context context) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track video click. No ad specified");
                return;
            }
            return;
        }
        if (bundle != null && Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Skipping tracking for VIDEO click on an ad...");
            }
        } else {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            boolean z = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(eVar.a(motionEvent, z));
            if (this.sdk.BU() != null) {
                this.sdk.BU().a(eVar.d(motionEvent, true, z), motionEvent);
            }
        }
        if (eVar.isDirectDownloadEnabled()) {
            this.sdk.Cp().startDirectInstallOrDownloadProcess(eVar, bundle, new ArrayService.DirectDownloadListener() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl.1
                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onAppDetailsDisplayed() {
                    AppLovinAdServiceImpl.this.sdk.Cc().pauseForClick();
                }

                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onAppDetailsDismissed() {
                    AppLovinAdServiceImpl.this.sdk.Cc().resumeForClick();
                }

                @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                public void onFailure() {
                    x unused = AppLovinAdServiceImpl.this.logger;
                    if (x.Fk()) {
                        AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
                    }
                    AppLovinAdServiceImpl.this.a(eVar, uri, aVar, context);
                }
            });
        } else {
            a(eVar, uri, aVar, context);
        }
    }

    public void trackAndLaunchClick(final com.applovin.impl.sdk.ad.e eVar, final AppLovinAdView appLovinAdView, final com.applovin.impl.adview.b bVar, final Uri uri, MotionEvent motionEvent, boolean z, Bundle bundle) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track ad view click. No ad specified");
                return;
            }
            return;
        }
        if (bundle != null && Boolean.parseBoolean(bundle.getString("skip_click_tracking"))) {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Skipping tracking for click on an ad...");
            }
        } else {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Tracking click on an ad...");
            }
            boolean z2 = bundle != null && Boolean.parseBoolean(bundle.getString("install_click"));
            maybeSubmitPersistentPostbacks(eVar.a(motionEvent, z, z2));
            if (this.sdk.BU() != null) {
                this.sdk.BU().a(eVar.d(motionEvent, false, z2), motionEvent);
            }
        }
        if (appLovinAdView != null && uri != null) {
            if (eVar.isDirectDownloadEnabled()) {
                this.sdk.Cp().startDirectInstallOrDownloadProcess(eVar, bundle, new ArrayService.DirectDownloadListener() { // from class: com.applovin.impl.sdk.AppLovinAdServiceImpl.2
                    @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                    public void onAppDetailsDisplayed() {
                        AppLovinAdServiceImpl.this.sdk.Cc().pauseForClick();
                        com.applovin.impl.adview.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.qX();
                            com.applovin.impl.sdk.utils.m.a(bVar.qQ(), eVar, appLovinAdView);
                        }
                    }

                    @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                    public void onAppDetailsDismissed() {
                        if (bVar != null) {
                            AppLovinAdServiceImpl.this.sdk.Cc().resumeForClick();
                            com.applovin.impl.sdk.utils.m.b(bVar.qQ(), eVar, appLovinAdView);
                        }
                    }

                    @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
                    public void onFailure() {
                        x unused = AppLovinAdServiceImpl.this.logger;
                        if (x.Fk()) {
                            AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Could not execute Direct Install/Direct Download - falling back to normal click logic");
                        }
                        AppLovinAdServiceImpl.this.a(eVar, appLovinAdView, bVar, uri);
                    }
                });
                return;
            } else {
                a(eVar, appLovinAdView, bVar, uri);
                return;
            }
        }
        if (x.Fk()) {
            this.logger.i("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.e eVar, Uri uri, com.applovin.impl.adview.activity.b.a aVar, Context context) {
        if (cB(uri.getScheme())) {
            a(uri, eVar, (com.applovin.impl.adview.b) null, aVar);
        } else if (com.applovin.impl.sdk.utils.s.s(uri)) {
            a(uri, eVar, (AppLovinAdView) null, (com.applovin.impl.adview.b) null, context, this.sdk);
        } else {
            com.applovin.impl.sdk.utils.s.a(uri, context, this.sdk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Uri uri) {
        if (cB(uri.getScheme())) {
            a(uri, eVar, bVar, (com.applovin.impl.adview.activity.b.a) null);
        } else if (com.applovin.impl.sdk.utils.s.s(uri)) {
            a(uri, eVar, appLovinAdView, bVar, appLovinAdView.getContext(), this.sdk);
        } else {
            a(uri, eVar, appLovinAdView, bVar);
        }
    }

    public void trackImpression(com.applovin.impl.sdk.ad.e eVar) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track impression click. No ad specified");
            }
        } else {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.Hh());
            if (this.sdk.BU() != null) {
                this.sdk.BU().I(eVar.getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public void trackVideoEnd(com.applovin.impl.sdk.ad.e eVar, long j, int i, boolean z) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track video end. No ad specified");
                return;
            }
            return;
        }
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Tracking video end on ad...");
        }
        List<com.applovin.impl.sdk.d.a> listHe = eVar.He();
        if (listHe != null && !listHe.isEmpty()) {
            String string = Long.toString(System.currentTimeMillis());
            for (com.applovin.impl.sdk.d.a aVar : listHe) {
                if (StringUtils.isValidString(aVar.JI())) {
                    String strA = a(aVar.JI(), j, i, string, z);
                    String strA2 = a(aVar.It(), j, i, string, z);
                    if (strA != null) {
                        a(new com.applovin.impl.sdk.d.a(strA, strA2));
                    } else if (x.Fk()) {
                        this.logger.i("AppLovinAdService", "Failed to parse url: " + aVar.JI());
                    }
                } else if (x.Fk()) {
                    this.logger.h("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
                }
            }
            return;
        }
        if (x.Fk()) {
            this.logger.h("AppLovinAdService", "Unable to submit persistent postback for AD #" + eVar.getAdIdNumber() + ". Missing video end tracking URL.");
        }
    }

    private String a(String str, long j, int i, String str2, boolean z) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i < 0 || i > 100) {
                i = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j)).appendQueryParameter("pv", Integer.toString(i)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z)).build().toString();
        } catch (Throwable th) {
            if (x.Fk()) {
                this.logger.c("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            this.sdk.Cq().d("AppLovinAdService", "buildVideoEndUrl", th);
            return null;
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar) {
        if (com.applovin.impl.sdk.utils.s.a(uri, appLovinAdView.getContext(), this.sdk)) {
            com.applovin.impl.sdk.utils.m.c(bVar.qQ(), eVar, appLovinAdView);
        }
        bVar.qX();
    }

    private boolean cB(String str) {
        String str2 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.FORWARDING_CLICK_SCHEME);
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.e eVar, com.applovin.impl.adview.b bVar, final com.applovin.impl.adview.activity.b.a aVar) {
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Forwarding click " + uri);
        }
        eVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.CLOSE_AD_ON_FORWARDING_CLICK_SCHEME);
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (aVar != null) {
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$AppLovinAdServiceImpl$8FPQVsrGBa57H_TjK_GmCizfztc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.f(aVar);
                    }
                });
            } else {
                if (bVar == null || com.applovin.impl.sdk.utils.u.b(eVar.getSize())) {
                    return;
                }
                if (x.Fk()) {
                    this.logger.f("AppLovinAdService", "Closing ad after forwarding click");
                }
                bVar.qU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.applovin.impl.adview.activity.b.a aVar) {
        if (aVar != null) {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Dismissing ad after forwarding click");
            }
            aVar.dismiss();
        }
    }

    private void a(Uri uri, com.applovin.impl.sdk.ad.e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, n nVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri uriA = a(uri, "primaryUrl");
            List<Uri> listB = b(uri, "primaryTrackingUrl");
            Uri uriA2 = a(uri, "fallbackUrl");
            List<Uri> listB2 = b(uri, "fallbackTrackingUrl");
            if (uriA == null && uriA2 == null) {
                nVar.BL();
                if (x.Fk()) {
                    nVar.BL().i("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
                    return;
                }
                return;
            }
            if (!a(uriA, "primary", listB, eVar, appLovinAdView, bVar, context, nVar)) {
                a(uriA2, "backup", listB2, eVar, appLovinAdView, bVar, context, nVar);
            }
            if (bVar != null) {
                bVar.qX();
                return;
            }
            return;
        }
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().i("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private boolean a(Uri uri, String str, List<Uri> list, com.applovin.impl.sdk.ad.e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, n nVar) {
        nVar.BL();
        if (x.Fk()) {
            nVar.BL().f("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean zA = com.applovin.impl.sdk.utils.s.a(uri, context, nVar);
        if (zA) {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().f("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            Iterator<Uri> it = list.iterator();
            while (it.hasNext()) {
                nVar.Cr().dispatchPostbackAsync(it.next().toString(), null);
            }
            if (bVar != null) {
                com.applovin.impl.sdk.utils.m.c(bVar.qQ(), eVar, appLovinAdView);
            }
        } else {
            nVar.BL();
            if (x.Fk()) {
                nVar.BL().i("AppLovinAdService", "URL failed to open");
            }
        }
        return zA;
    }

    private Uri a(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().h("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            }
            this.sdk.Cq().d("AppLovinAdService", "buildDeepLinkPlusUrl", th);
            return null;
        }
    }

    private List<Uri> b(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        Iterator<String> it = queryParameters.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Uri.parse(it.next()));
            } catch (Throwable th) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().h("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
                this.sdk.Cq().d("AppLovinAdService", "buildDeepLinkPlusUrlList", th);
            }
        }
        return arrayList;
    }

    public void trackFullScreenAdClosed(com.applovin.impl.sdk.ad.e eVar, long j, List<Long> list, long j2, boolean z, int i) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track ad closed. No ad specified.");
                return;
            }
            return;
        }
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Tracking ad closed...");
        }
        List<com.applovin.impl.sdk.d.a> listHf = eVar.Hf();
        if (listHf != null && !listHf.isEmpty()) {
            for (com.applovin.impl.sdk.d.a aVar : listHf) {
                String strA = a(aVar.JI(), j, j2, list, z, i);
                String strA2 = a(aVar.It(), j, j2, list, z, i);
                if (StringUtils.isValidString(strA)) {
                    a(new com.applovin.impl.sdk.d.a(strA, strA2));
                } else if (x.Fk()) {
                    this.logger.i("AppLovinAdService", "Failed to parse url: " + aVar.JI());
                }
            }
            return;
        }
        if (x.Fk()) {
            this.logger.h("AppLovinAdService", "Unable to track ad closed for AD #" + eVar.getAdIdNumber() + ". Missing ad close tracking URL." + eVar.getAdIdNumber());
        }
    }

    private String a(String str, long j, long j2, List<Long> list, boolean z, int i) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j)).appendQueryParameter("vs_ms", Long.toString(j2));
        if (list != null && list.size() > 0) {
            builderAppendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i != i.azY) {
            builderAppendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z));
            builderAppendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(i.gv(i)));
        }
        return builderAppendQueryParameter.build().toString();
    }

    public void trackAppKilled(com.applovin.impl.sdk.ad.e eVar) {
        if (eVar == null) {
            if (x.Fk()) {
                this.logger.i("AppLovinAdService", "Unable to track app killed. No ad specified");
                return;
            }
            return;
        }
        if (x.Fk()) {
            this.logger.f("AppLovinAdService", "Tracking app killed during ad...");
        }
        List<com.applovin.impl.sdk.d.a> listHg = eVar.Hg();
        if (listHg != null && !listHg.isEmpty()) {
            for (com.applovin.impl.sdk.d.a aVar : listHg) {
                a(new com.applovin.impl.sdk.d.a(aVar.JI(), aVar.It()));
            }
            return;
        }
        if (x.Fk()) {
            this.logger.h("AppLovinAdService", "Unable to track app killed during AD #" + eVar.getAdIdNumber() + ". Missing app killed tracking URL.");
        }
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.sdk.d.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<com.applovin.impl.sdk.d.a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void a(com.applovin.impl.sdk.d.a aVar) {
        if (StringUtils.isValidString(aVar.JI())) {
            this.sdk.Cs().a(com.applovin.impl.sdk.network.h.IB().dh(aVar.JI()).di(StringUtils.isValidString(aVar.It()) ? aVar.It() : null).o(aVar.HQ()).aV(false).aY(aVar.Iv()).ID());
        } else if (x.Fk()) {
            this.logger.h("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.applovin.impl.sdk.ad.d dVar, b bVar) {
        AppLovinAdImpl appLovinAdImplA = this.sdk.BY().a(dVar);
        if (appLovinAdImplA != null && !appLovinAdImplA.isExpired()) {
            if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Using pre-loaded ad: " + appLovinAdImplA + " for " + dVar);
            }
            bVar.adReceived(appLovinAdImplA);
            return;
        }
        a(new com.applovin.impl.sdk.e.n(dVar, bVar, this.sdk));
    }

    private c g(com.applovin.impl.sdk.ad.d dVar) {
        c cVar;
        synchronized (this.alt) {
            cVar = this.als.get(dVar);
            if (cVar == null) {
                cVar = new c();
                this.als.put(dVar, cVar);
            }
        }
        return cVar;
    }

    @Override // com.applovin.impl.sdk.b.a
    public void onAdExpired(com.applovin.impl.sdk.ad.g gVar) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) gVar;
        com.applovin.impl.sdk.ad.d adZone = appLovinAdImpl.getAdZone();
        if (x.Fk()) {
            this.logger.h("AppLovinAdService", "Ad expired for zone: " + adZone);
        }
        this.sdk.BY().b(appLovinAdImpl);
        if (this.sdk.Bp() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLZ)).booleanValue()) {
            return;
        }
        c cVarG = g(adZone);
        synchronized (cVarG.azz) {
            if (!cVarG.azA) {
                this.sdk.BL();
                if (x.Fk()) {
                    this.sdk.BL().f("AppLovinAdService", "Reloading ad after expiration for zone {" + adZone + "}...");
                }
                cVarG.azA = true;
                cVarG.azB = true;
                a(adZone, new b(adZone, cVarG));
            } else if (x.Fk()) {
                this.logger.f("AppLovinAdService", "Cancelled expired ad reload. Already waiting on an ad load...");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements com.applovin.impl.sdk.ad.i {
        private final int alR;
        private final com.applovin.impl.sdk.ad.d azx;
        private final c azy;

        private b(com.applovin.impl.sdk.ad.d dVar, c cVar) {
            this.azx = dVar;
            this.azy = cVar;
            if (!Boolean.parseBoolean(AppLovinAdServiceImpl.this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES))) {
                this.alR = ((Integer) AppLovinAdServiceImpl.this.sdk.a(com.applovin.impl.sdk.c.b.aKF)).intValue();
            } else {
                this.alR = -1;
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.f)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.sdk.BY().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.sdk.BZ().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.f(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.sdk);
            }
            Collection collectionEmptySet = Collections.emptySet();
            synchronized (this.azy.azz) {
                if (!this.azy.azB) {
                    collectionEmptySet = new HashSet(this.azy.azC);
                    this.azy.azC.clear();
                }
                this.azy.alT = 0;
                this.azy.azA = false;
                this.azy.azB = false;
            }
            Iterator it = collectionEmptySet.iterator();
            while (it.hasNext()) {
                AppLovinAdServiceImpl.this.a(appLovinAd, (AppLovinAdLoadListener) it.next());
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            failedToReceiveAdV2(new AppLovinError(i, ""));
        }

        @Override // com.applovin.impl.sdk.ad.i
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            Collections.emptySet();
            synchronized (this.azy.azz) {
                if (!AppLovinAdServiceImpl.this.sdk.b(com.applovin.impl.sdk.c.b.aKG).contains(this.azx.getSize().getLabel()) || this.azy.alT >= this.alR) {
                    HashSet hashSet = new HashSet(this.azy.azC);
                    this.azy.azC.clear();
                    this.azy.alT = 0;
                    this.azy.azA = false;
                    this.azy.azB = false;
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        AppLovinAdServiceImpl.this.b(appLovinError, (AppLovinAdLoadListener) it.next());
                    }
                } else {
                    this.azy.alT++;
                    int iPow = (int) Math.pow(2.0d, this.azy.alT);
                    x unused = AppLovinAdServiceImpl.this.logger;
                    if (x.Fk()) {
                        AppLovinAdServiceImpl.this.logger.f("AppLovinAdService", "Failed to load ad of zone {" + this.azx.mQ() + "} with size " + this.azx.getSize() + ". Current retry attempt: " + this.azy.alT + " of " + this.alR + ". Retrying again in " + iPow + " seconds...");
                    }
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.-$$Lambda$AppLovinAdServiceImpl$b$HqcPl2gn--TjTO_NM_8XlCvgYtM
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.AQ();
                        }
                    }, TimeUnit.SECONDS.toMillis(iPow));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void AQ() {
            AppLovinAdServiceImpl.this.a(this.azx, this);
        }
    }

    private class a implements com.applovin.impl.sdk.ad.i {
        private AppLovinAdLoadListener avQ;

        public a(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.avQ = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.f)) {
                AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
                AppLovinAdServiceImpl.this.sdk.BY().a(appLovinAdImpl);
                if (appLovinAdImpl.canExpire()) {
                    AppLovinAdServiceImpl.this.sdk.BZ().a(appLovinAdImpl, AppLovinAdServiceImpl.this);
                }
                appLovinAd = new com.applovin.impl.sdk.ad.f(appLovinAdImpl.getAdZone(), AppLovinAdServiceImpl.this.sdk);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.avQ;
            if (appLovinAdLoadListener == null) {
                if (((Boolean) AppLovinAdServiceImpl.this.sdk.a(com.applovin.impl.sdk.c.b.aKB)).booleanValue()) {
                    throw new IllegalStateException("Unable to notify listener about ad load");
                }
            } else {
                appLovinAdLoadListener.adReceived(appLovinAd);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i) {
            failedToReceiveAdV2(new AppLovinError(i, ""));
        }

        @Override // com.applovin.impl.sdk.ad.i
        public void failedToReceiveAdV2(AppLovinError appLovinError) {
            AppLovinAdServiceImpl.this.b(appLovinError, this.avQ);
            this.avQ = null;
        }
    }

    private static class c {
        int alT;
        boolean azA;
        boolean azB;
        final Collection<AppLovinAdLoadListener> azC;
        final Object azz;

        private c() {
            this.azz = new Object();
            this.azC = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.azA + ", isReloadingExpiredAd=" + this.azB + ", pendingAdListeners=" + this.azC + '}';
        }
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.als + '}';
    }
}
