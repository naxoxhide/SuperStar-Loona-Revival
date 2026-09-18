package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public static void a(Context context, v vVar) {
        boolean zIsLimitAdTrackingEnabled;
        String id = null;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            id = advertisingIdInfo.getId();
            IAlog.d("advertising id: %s", id);
            zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
            try {
                IAlog.d("limit ad tracking: %s", Boolean.valueOf(zIsLimitAdTrackingEnabled));
            } catch (Exception e) {
                e = e;
                IAlog.d("Handled Exception:", new Object[0]);
                IAlog.d(com.fyber.inneractive.sdk.util.q.b(e), new Object[0]);
                IAlog.c("Advertising ID is not available. Please add Google Play Services library (v 4.0+) to improve your ad targeting. (relevant for devices running Android API 2.3 and above)", new Object[0]);
            }
        } catch (Exception e2) {
            e = e2;
            zIsLimitAdTrackingEnabled = false;
        }
        l lVar = (l) vVar;
        synchronized (lVar) {
            l.c cVar = lVar.f887b;
            cVar.a = id;
            cVar.f888b = zIsLimitAdTrackingEnabled;
            cVar.c = false;
        }
    }
}
