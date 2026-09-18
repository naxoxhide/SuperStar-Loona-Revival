package com.bytedance.sdk.openadsdk.b.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PAGInterstitialAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends PAGInterstitialAd {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.f0.a f473b;
    private com.bytedance.sdk.openadsdk.a.d.b c;
    private String e;
    private boolean i;
    private boolean j;
    private final AtomicBoolean f = new AtomicBoolean(false);
    private boolean g = false;
    private boolean d = false;
    private final String h = q.a();

    /* JADX INFO: compiled from: PAGInterstitialAdImpl.java */
    class b extends b.b.a.a.k.g {
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i) {
            super(str);
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.multipro.aidl.a aVarC = com.bytedance.sdk.openadsdk.multipro.aidl.a.c();
            if (this.c == 1 && f.this.c != null) {
                com.bytedance.sdk.component.utils.m.a("MultiProcess", "start registerFullScreenVideoListener ! ");
                com.bytedance.sdk.openadsdk.multipro.aidl.e.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.e.c(f.this.c);
                IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarC.a(1));
                if (iListenerManagerAsInterface != null) {
                    try {
                        iListenerManagerAsInterface.registerFullVideoListener(f.this.h, cVar);
                        com.bytedance.sdk.component.utils.m.a("MultiProcess", "end registerFullScreenVideoListener ! ");
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.m.b("TTFullScreenVideoAdImpl", e.getMessage());
                    }
                }
            }
        }
    }

    f(Context context, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        this.a = context;
        this.f473b = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.f0.a aVar = this.f473b;
        if (aVar == null || aVar.a() == null) {
            return null;
        }
        return this.f473b.a().i0();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.j) {
            return;
        }
        u.a(this.f473b.a(), d, str, str2);
        this.j = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.c = new com.bytedance.sdk.openadsdk.b.j.a(pAGInterstitialAdInteractionCallback);
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.c = new com.bytedance.sdk.openadsdk.b.j.a(pAGInterstitialAdInteractionListener);
        a(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void show(Activity activity) {
        Activity activity2;
        Intent intent;
        if (activity == null || !activity.isFinishing()) {
            activity2 = activity;
        } else {
            com.bytedance.sdk.component.utils.m.b("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity2 = null;
        }
        com.bytedance.sdk.openadsdk.core.f0.a aVar = this.f473b;
        if (aVar == null || !aVar.f()) {
            return;
        }
        boolean zH = this.f473b.h();
        com.bytedance.sdk.openadsdk.core.f0.q qVarA = this.f473b.a();
        if (!b.a.a.a.a.a.b.d.a.b()) {
            com.bytedance.sdk.openadsdk.d.c.b(qVarA, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            com.bytedance.sdk.component.utils.m.b("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
        }
        if (this.f.get()) {
            return;
        }
        this.f.set(true);
        if (qVarA == null || (qVarA.N0() == null && qVarA.d0() == null)) {
            com.bytedance.sdk.openadsdk.d.c.b(qVarA, "fullscreen_interstitial_ad", "materialMeta error ");
            return;
        }
        Context contextA = activity2 == null ? this.a : activity2;
        if (contextA == null) {
            contextA = com.bytedance.sdk.openadsdk.core.o.a();
        }
        if (zH) {
            intent = new Intent(contextA, (Class<?>) TTFullScreenExpressVideoActivity.class);
        } else if (qVarA.w0() != 2 || qVarA.v() == 5 || qVarA.v() == 6 || qVarA.v() == 19) {
            intent = com.bytedance.sdk.openadsdk.b.m.q.h.a(qVarA) ? new Intent(contextA, (Class<?>) TTInterstitialActivity.class) : new Intent(contextA, (Class<?>) TTFullScreenVideoActivity.class);
        } else {
            intent = com.bytedance.sdk.openadsdk.b.m.q.h.a(qVarA) ? new Intent(contextA, (Class<?>) TTInterstitialExpressActivity.class) : new Intent(contextA, (Class<?>) TTFullScreenExpressVideoActivity.class);
        }
        Intent intent2 = intent;
        intent2.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.openadsdk.b.m.p.b.a(intent2, activity2, this.d, this.e, this.f473b, this.h);
        intent2.putExtra("is_verity_playable", this.g);
        if (!com.bytedance.sdk.openadsdk.m.b.b()) {
            s.g().a(this.c);
            this.c = null;
        }
        com.bytedance.sdk.component.utils.b.a(contextA, intent2, new a(qVarA));
        if (zH) {
            return;
        }
        com.bytedance.sdk.openadsdk.b.m.a.a(this.f473b.a(), this.d, this.e);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.i) {
            return;
        }
        u.a(this.f473b.a(), d);
        this.i = true;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(String str) {
        if (this.f.get()) {
            return;
        }
        this.d = true;
        this.e = str;
    }

    /* JADX INFO: compiled from: PAGInterstitialAdImpl.java */
    class a implements com.bytedance.sdk.component.utils.b.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q a;

        a(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
            this.a = qVar;
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a() {
            if (f.this.g) {
                try {
                    com.bytedance.sdk.openadsdk.l.b.a().a(this.a.N0().d());
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a(Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            if (f.this.g) {
                try {
                    com.bytedance.sdk.openadsdk.l.b.a().a(this.a.N0().d(), -1, th != null ? th.getMessage() : "playable tool error open");
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.a, "fullscreen_interstitial_ad", "activity start  fail ");
        }
    }

    private void a(int i) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            y.a(new b("FullScreen_registerMultiProcessListener", i), 5);
        }
    }
}
