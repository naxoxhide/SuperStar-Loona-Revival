package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.w;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.fyber.inneractive.sdk.measurement.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f946b;
    public String c;
    public String d;
    public Partner e;
    public final com.fyber.inneractive.sdk.measurement.tracker.d f = new com.fyber.inneractive.sdk.measurement.tracker.d();
    public w<String> g = new a();
    public w<String> h = new C0272b();
    public w<String> i = new c();

    public class a implements w<String> {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(String str, Exception exc, boolean z) {
            String str2 = str;
            if (str2 != null) {
                b.this.f946b = str2;
            }
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.measurement.b$b, reason: collision with other inner class name */
    public class C0272b implements w<String> {
        public C0272b() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(String str, Exception exc, boolean z) {
            String str2 = str;
            if (str2 != null) {
                b.this.c = str2;
            }
        }
    }

    public class c implements w<String> {
        public c() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(String str, Exception exc, boolean z) {
            String str2 = str;
            if (str2 != null) {
                b.this.d = str2;
            }
        }
    }

    public static void a(b bVar, Context context) {
        bVar.getClass();
        bVar.a(context, String.format("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/%s.js", Omid.getVersion()), "omid-latest.js", bVar.g);
        bVar.a(context, String.format("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/omid-session-client-%s.js", Omid.getVersion()), "omid-session-client-latest.js", bVar.h);
        bVar.a(context, "https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/dt-omsdk-mraid-video-tracker.js", "dt-omsdk-mraid-video-tracker.js", bVar.i);
    }

    public final void a(Context context, String str, String str2, w<String> wVar) {
        g0 g0Var = new g0(wVar, context, new com.fyber.inneractive.sdk.cache.e(str, str2));
        IAConfigManager.M.s.a.offer(g0Var);
        g0Var.a(q0.QUEUED);
    }
}
