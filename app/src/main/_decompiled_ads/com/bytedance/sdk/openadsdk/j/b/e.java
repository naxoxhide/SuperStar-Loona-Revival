package com.bytedance.sdk.openadsdk.j.b;

import androidx.core.app.NotificationCompat;
import b.b.a.a.e.r;
import com.bytedance.sdk.openadsdk.core.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: OldBridgeSyncMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends b.b.a.a.e.e<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f777b;
    private x c;

    public e(String str, x xVar) {
        this.c = xVar;
        this.f777b = str;
    }

    public static void a(r rVar, x xVar) {
        rVar.a("appInfo", new e("appInfo", xVar));
        rVar.a("adInfo", new e("adInfo", xVar));
        rVar.a("sendLog", new e("sendLog", xVar));
        rVar.a("playable_style", new e("playable_style", xVar));
        rVar.a("getTemplateInfo", new e("getTemplateInfo", xVar));
        rVar.a("getTeMaiAds", new e("getTeMaiAds", xVar));
        rVar.a("isViewable", new e("isViewable", xVar));
        rVar.a("getScreenSize", new e("getScreenSize", xVar));
        rVar.a("getCloseButtonInfo", new e("getCloseButtonInfo", xVar));
        rVar.a("getVolume", new e("getVolume", xVar));
        rVar.a("removeLoading", new e("removeLoading", xVar));
        rVar.a("sendReward", new e("sendReward", xVar));
        rVar.a("subscribe_app_ad", new e("subscribe_app_ad", xVar));
        rVar.a("download_app_ad", new e("download_app_ad", xVar));
        rVar.a("cancel_download_app_ad", new e("cancel_download_app_ad", xVar));
        rVar.a("unsubscribe_app_ad", new e("unsubscribe_app_ad", xVar));
        rVar.a("landscape_click", new e("landscape_click", xVar));
        rVar.a("clickEvent", new e("clickEvent", xVar));
        rVar.a("renderDidFinish", new e("renderDidFinish", xVar));
        rVar.a("dynamicTrack", new e("dynamicTrack", xVar));
        rVar.a("skipVideo", new e("skipVideo", xVar));
        rVar.a("muteVideo", new e("muteVideo", xVar));
        rVar.a("changeVideoState", new e("changeVideoState", xVar));
        rVar.a("getCurrentVideoState", new e("getCurrentVideoState", xVar));
        rVar.a("send_temai_product_ids", new e("send_temai_product_ids", xVar));
        rVar.a("getMaterialMeta", new e("getMaterialMeta", xVar));
        rVar.a("endcard_load", new e("endcard_load", xVar));
        rVar.a("pauseWebView", new e("pauseWebView", xVar));
        rVar.a("pauseWebViewTimers", new e("pauseWebViewTimers", xVar));
        rVar.a("webview_time_track", new e("webview_time_track", xVar));
        rVar.a("openPrivacy", new e("openPrivacy", xVar));
        rVar.a("openAdLandPageLinks", new e("openAdLandPageLinks", xVar));
        rVar.a("getNativeSiteCustomData", new e("getNativeSiteCustomData", xVar));
        rVar.a("close", new e("close", xVar));
    }

    @Override // b.b.a.a.e.e
    public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        x.k kVar = new x.k();
        kVar.a = NotificationCompat.CATEGORY_CALL;
        kVar.c = this.f777b;
        kVar.d = jSONObject;
        return this.c.a(kVar, 3);
    }
}
