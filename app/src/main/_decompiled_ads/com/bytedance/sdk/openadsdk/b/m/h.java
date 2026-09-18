package com.bytedance.sdk.openadsdk.b.m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PAGRewardVideoAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends PAGRewardedAd {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.f0.a f477b;
    private final AdSlot c;
    private com.bytedance.sdk.openadsdk.a.f.a d;
    private String f;
    private boolean i;
    private boolean j;
    private final AtomicBoolean g = new AtomicBoolean(false);
    private boolean e = false;
    private final String h = q.a();

    /* JADX INFO: compiled from: PAGRewardVideoAdImpl.java */
    class a implements com.bytedance.sdk.component.utils.b.a {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q a;

        a(h hVar, com.bytedance.sdk.openadsdk.core.f0.q qVar) {
            this.a = qVar;
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a() {
        }

        @Override // com.bytedance.sdk.component.utils.b.a
        public void a(Throwable th) {
            com.bytedance.sdk.component.utils.m.b("TTRewardVideoAdImpl", "show reward video error: ", th);
            com.bytedance.sdk.openadsdk.d.c.b(this.a, "fullscreen_interstitial_ad", "activity start  fail ");
        }
    }

    /* JADX INFO: compiled from: PAGRewardVideoAdImpl.java */
    class b implements Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.q a;

        b(com.bytedance.sdk.openadsdk.core.f0.q qVar) {
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strC = this.a.c((String) null);
            if (strC != null) {
                try {
                    AdSlot adSlotB = l.a(h.this.a).b(strC);
                    l.a(h.this.a).a(strC);
                    if (adSlotB != null) {
                        if (!h.this.e || TextUtils.isEmpty(h.this.f)) {
                            l.a(h.this.a).b(adSlotB);
                        } else {
                            l.a(h.this.a).a(adSlotB);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: PAGRewardVideoAdImpl.java */
    class c extends b.b.a.a.k.g {
        final /* synthetic */ int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, int i) {
            super(str);
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.multipro.aidl.a aVarC = com.bytedance.sdk.openadsdk.multipro.aidl.a.c();
            if (this.c == 0 && h.this.d != null) {
                com.bytedance.sdk.component.utils.m.a("MultiProcess", "start registerRewardVideoListener ! ");
                com.bytedance.sdk.openadsdk.multipro.aidl.e.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.e.d(h.this.d);
                IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(aVarC.a(0));
                if (iListenerManagerAsInterface != null) {
                    try {
                        iListenerManagerAsInterface.registerRewardVideoListener(h.this.h, dVar);
                        com.bytedance.sdk.component.utils.m.a("MultiProcess", "end registerRewardVideoListener ! ");
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.m.b("TTRewardVideoAdImpl", e.getMessage());
                    }
                }
            }
        }
    }

    h(Context context, com.bytedance.sdk.openadsdk.core.f0.a aVar, AdSlot adSlot) {
        this.a = context;
        this.f477b = aVar;
        this.c = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.f0.a aVar = this.f477b;
        if (aVar == null || aVar.a() == null) {
            return null;
        }
        return this.f477b.a().i0();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d, String str, String str2) {
        if (this.j) {
            return;
        }
        u.a(this.f477b.a(), d, str, str2);
        this.j = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.d = new i(pAGRewardedAdInteractionCallback);
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.d = new i(pAGRewardedAdInteractionListener);
        a(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void show(Activity activity) {
        Activity activity2;
        Intent intent;
        if (activity == null || !activity.isFinishing()) {
            activity2 = activity;
        } else {
            com.bytedance.sdk.component.utils.m.b("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity2 = null;
        }
        com.bytedance.sdk.openadsdk.core.f0.a aVar = this.f477b;
        if (aVar == null || !aVar.f()) {
            return;
        }
        boolean zH = this.f477b.h();
        com.bytedance.sdk.openadsdk.core.f0.q qVarA = this.f477b.a();
        if (!b.a.a.a.a.a.b.d.a.b()) {
            com.bytedance.sdk.openadsdk.d.c.b(qVarA, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            com.bytedance.sdk.component.utils.m.b("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
        }
        if (this.g.compareAndSet(false, true)) {
            if (qVarA == null || qVarA.N0() == null) {
                com.bytedance.sdk.openadsdk.d.c.b(qVarA, "fullscreen_interstitial_ad", "materialMeta error ");
                return;
            }
            Context contextA = activity2 == null ? this.a : activity2;
            if (contextA == null) {
                contextA = com.bytedance.sdk.openadsdk.core.o.a();
            }
            if (zH) {
                intent = new Intent(contextA, (Class<?>) TTRewardExpressVideoActivity.class);
            } else {
                intent = (qVarA.w0() != 2 || qVarA.v() == 5 || qVarA.v() == 6 || qVarA.v() == 19) ? new Intent(contextA, (Class<?>) TTRewardVideoActivity.class) : new Intent(contextA, (Class<?>) TTRewardExpressVideoActivity.class);
            }
            com.bytedance.sdk.openadsdk.b.m.p.b.a(intent, activity2, this.e, this.f, this.f477b, this.h);
            intent.putExtra("media_extra", this.c.getMediaExtra());
            intent.putExtra("user_id", this.c.getUserID());
            intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                s.g().a(this.d);
                this.d = null;
            }
            com.bytedance.sdk.component.utils.b.a(contextA, intent, new a(this, qVarA));
            com.bytedance.sdk.openadsdk.core.l.a().post(new b(qVarA));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d) {
        if (this.i) {
            return;
        }
        u.a(this.f477b.a(), d);
        this.i = true;
    }

    public void a(String str) {
        if (this.g.get()) {
            return;
        }
        this.e = true;
        this.f = str;
    }

    private void a(int i) {
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            y.a(new c("Reward_registerMultiProcessListener", i), 5);
        }
    }
}
