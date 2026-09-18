package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Runnable {
    public final /* synthetic */ IAConfigManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f889b;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.a.J = new com.fyber.inneractive.sdk.measurement.b();
            n nVar = n.this;
            com.fyber.inneractive.sdk.measurement.a aVar = nVar.a.J;
            Context context = nVar.f889b;
            if (aVar.a) {
                return;
            }
            aVar.a = true;
            com.fyber.inneractive.sdk.util.m.f1343b.post(new com.fyber.inneractive.sdk.measurement.c((com.fyber.inneractive.sdk.measurement.b) aVar, context));
        }
    }

    public n(IAConfigManager iAConfigManager, Context context) {
        this.a = iAConfigManager;
        this.f889b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Class.forName("com.iab.omid.library.fyber.Omid");
            com.fyber.inneractive.sdk.util.m.f1343b.post(new a());
        } catch (Throwable unused) {
        }
    }
}
