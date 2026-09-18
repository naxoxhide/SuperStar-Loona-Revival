package com.fyber.inneractive.sdk.dv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes2.dex */
public class c extends BroadcastReceiver {

    public class a implements com.fyber.inneractive.sdk.factories.b.InterfaceC0266b {
        public a(c cVar) {
        }

        @Override // com.fyber.inneractive.sdk.factories.b.InterfaceC0266b
        public com.fyber.inneractive.sdk.interfaces.a a() {
            return new com.fyber.inneractive.sdk.dv.b();
        }

        @Override // com.fyber.inneractive.sdk.factories.b.InterfaceC0266b
        public com.fyber.inneractive.sdk.response.b b() {
            return new e();
        }
    }

    public class b implements com.fyber.inneractive.sdk.factories.c.a {
        public b(c cVar) {
        }

        @Override // com.fyber.inneractive.sdk.factories.c.a
        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return IAConfigManager.M.F != null && (inneractiveAdSpot.getAdContent() instanceof com.fyber.inneractive.sdk.dv.a);
        }

        @Override // com.fyber.inneractive.sdk.factories.c.a
        public com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot) {
            InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().a;
            boolean z = inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen();
            if (inneractiveAdSpot.getAdContent().e() && z) {
                return inneractiveAdSpot.getAdContent().d().n == UnitDisplayType.INTERSTITIAL ? new com.fyber.inneractive.sdk.dv.interstitial.d() : new com.fyber.inneractive.sdk.dv.rewarded.c();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.fyber.inneractive.sdk.dv.c$c, reason: collision with other inner class name */
    public class C0261c implements com.fyber.inneractive.sdk.factories.a.InterfaceC0265a {
        public C0261c() {
        }

        @Override // com.fyber.inneractive.sdk.factories.a.InterfaceC0265a
        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return c.a(c.this, inneractiveAdSpot);
        }

        @Override // com.fyber.inneractive.sdk.factories.a.InterfaceC0265a
        public com.fyber.inneractive.sdk.interfaces.b b(InneractiveAdSpot inneractiveAdSpot) {
            return new com.fyber.inneractive.sdk.dv.banner.b();
        }
    }

    public static boolean a(c cVar, InneractiveAdSpot inneractiveAdSpot) {
        cVar.getClass();
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof com.fyber.inneractive.sdk.dv.a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IAlog.a("DVKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.factories.b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MOBILE_ADS, new a(this));
        com.fyber.inneractive.sdk.factories.c.b.a.a.add(new b(this));
        com.fyber.inneractive.sdk.factories.a.b.a.a.add(new C0261c());
    }
}
