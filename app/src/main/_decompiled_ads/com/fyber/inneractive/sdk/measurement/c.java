package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f947b;

    public c(b bVar, Context context) {
        this.f947b = bVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Omid.activate(this.a);
            this.f947b.e = Partner.createPartner(ADXLogUtil.PLATFORM_FYBER, InneractiveAdManager.getVersion());
            b.a(this.f947b, this.a);
            IAlog.a("OMID SDK was activated - version %s", Omid.getVersion());
        } catch (Throwable th) {
            IAlog.a("Failed starting omsdk with exception %s", th.getLocalizedMessage());
            this.f947b.getClass();
            t.a(th.getClass().getSimpleName(), String.format("%s - %s", "OpenMeasurementMeasurer", th.getMessage()), null, null);
        }
    }
}
