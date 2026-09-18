package com.fyber.inneractive.sdk.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.o;
import com.fyber.inneractive.sdk.player.cache.n;
import com.fyber.inneractive.sdk.renderers.h;
import com.fyber.inneractive.sdk.renderers.j;
import com.fyber.inneractive.sdk.renderers.m;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s;
import com.fyber.inneractive.sdk.util.t;

/* JADX INFO: loaded from: classes2.dex */
public class IAVideoKit extends BroadcastReceiver {
    private static final s sProvider = new a();

    public class b implements com.fyber.inneractive.sdk.factories.b.InterfaceC0266b {
        public b(IAVideoKit iAVideoKit) {
        }

        @Override // com.fyber.inneractive.sdk.factories.b.InterfaceC0266b
        public com.fyber.inneractive.sdk.interfaces.a a() {
            return new o("Interstitial");
        }

        @Override // com.fyber.inneractive.sdk.factories.b.InterfaceC0266b
        public com.fyber.inneractive.sdk.response.b b() {
            return new com.fyber.inneractive.sdk.response.d();
        }
    }

    public class c implements com.fyber.inneractive.sdk.factories.c.a {
        public c(IAVideoKit iAVideoKit) {
        }

        @Override // com.fyber.inneractive.sdk.factories.c.a
        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof f0);
        }

        @Override // com.fyber.inneractive.sdk.factories.c.a
        public com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot) {
            InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().a;
            return (inneractiveAdSpot.getAdContent().e() && (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen())) ? new m() : new j();
        }
    }

    public class d implements com.fyber.inneractive.sdk.factories.a.InterfaceC0265a {
        public d(IAVideoKit iAVideoKit) {
        }

        @Override // com.fyber.inneractive.sdk.factories.a.InterfaceC0265a
        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof f0);
        }

        @Override // com.fyber.inneractive.sdk.factories.a.InterfaceC0265a
        public com.fyber.inneractive.sdk.interfaces.b b(InneractiveAdSpot inneractiveAdSpot) {
            return new h();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        s sVar = sProvider;
        IAConfigManager.M.I.put(sVar.a(), sVar);
        n nVar = n.f;
        Context applicationContext = context.getApplicationContext();
        nVar.getClass();
        if (applicationContext == null) {
            IAlog.e("context is null, would not start the video cache.", new Object[0]);
        } else if (!nVar.a()) {
            nVar.a = applicationContext;
            new Thread(nVar.e, "VideoCache").start();
        }
        IAlog.a("IAVideoKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.factories.b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST, new b(this));
        com.fyber.inneractive.sdk.factories.c.b.a.a.add(new c(this));
        com.fyber.inneractive.sdk.factories.a.b.a.a.add(new d(this));
    }

    public class a implements s {
        @Override // com.fyber.inneractive.sdk.util.s
        public boolean a(String str) {
            if (TextUtils.equals(str, "vid_cache")) {
                return n.f.a();
            }
            return false;
        }

        @Override // com.fyber.inneractive.sdk.util.s
        public t a() {
            return t.Video;
        }
    }
}
