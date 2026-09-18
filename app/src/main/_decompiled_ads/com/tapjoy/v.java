package com.tapjoy;

import com.tapjoy.internal.z8;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class v extends Thread {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJOfferwallDiscoverView f2852b;

    public v(TJOfferwallDiscoverView tJOfferwallDiscoverView, String str) {
        this.f2852b = tJOfferwallDiscoverView;
        this.a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        String placementURL = TapjoyConnectCore.getPlacementURL();
        String str = placementURL + "v1/apps/" + TapjoyConnectCore.getAppID() + "/content?";
        TapjoyURLConnection tapjoyURLConnection = new TapjoyURLConnection();
        Map<String, String> genericURLParams = TapjoyConnectCore.getGenericURLParams();
        genericURLParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        TapjoyUtil.safePut(genericURLParams, "event_name", this.a, true);
        TapjoyUtil.safePut(genericURLParams, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
        TapjoyUtil.safePut(genericURLParams, "offerwall_discover", "true", true);
        TapjoyUtil.runOnMainThread(new z8(this, tapjoyURLConnection.getResponseFromURL(str, (Map<String, String>) null, (Map<String, String>) null, genericURLParams), placementURL));
    }
}
