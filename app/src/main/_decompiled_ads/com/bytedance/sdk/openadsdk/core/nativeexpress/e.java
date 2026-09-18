package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.s;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ExpressAdLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static Set<e> n = Collections.synchronizedSet(new HashSet());
    private AdSlot a;
    private Context c;
    private PAGBannerAdLoadListener d;
    private List<q> f;
    private List<q> g;
    private c h;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private int i = 5;
    private ScheduledFuture<?> j = null;
    private ScheduledFuture<?> k = null;
    private ScheduledFuture<?> l = null;
    private final z m = z.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.p f654b = com.bytedance.sdk.openadsdk.core.o.c();

    /* JADX INFO: compiled from: ExpressAdLoadManager.java */
    class a implements com.bytedance.sdk.openadsdk.core.p.a {
        final /* synthetic */ AdSlot a;

        a(AdSlot adSlot) {
            this.a = adSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            if (aVar.b() == null || aVar.b().isEmpty()) {
                e.this.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            e.this.f = aVar.b();
            e.this.g = aVar.b();
            e.this.a(this.a);
            e eVar = e.this;
            eVar.b(eVar.m);
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            e.this.a(i, str);
        }
    }

    /* JADX INFO: compiled from: ExpressAdLoadManager.java */
    class b implements Runnable {
        final /* synthetic */ z a;

        b(z zVar) {
            this.a = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.g != null && e.this.g.size() > 0) {
                e.this.a(this.a);
                if (e.this.h != null) {
                    e.this.h.a(e.this.g);
                }
            } else if (e.this.h != null) {
                e.this.h.a();
            }
            e.this.a();
        }
    }

    /* JADX INFO: compiled from: ExpressAdLoadManager.java */
    public interface c {
        void a();

        void a(List<q> list);
    }

    private e(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = com.bytedance.sdk.openadsdk.core.o.a();
        }
        n.add(this);
    }

    private void c(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.j;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            com.bytedance.sdk.component.utils.m.b("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + this.j.cancel(z));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(z zVar) {
        if (this.e.getAndSet(false)) {
            y.a(new b(zVar));
        }
    }

    public static e a(Context context) {
        return new e(context);
    }

    private void b(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.k;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            com.bytedance.sdk.component.utils.m.b("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + this.k.cancel(z));
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.common.b bVar, int i2) {
        a(adSlot, i, bVar, null, i2);
    }

    public void a(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.common.b bVar, c cVar, int i2) {
        this.m.e();
        if (this.e.get()) {
            com.bytedance.sdk.component.utils.m.b("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i;
        this.e.set(true);
        this.a = adSlot;
        if (bVar instanceof PAGBannerAdLoadListener) {
            this.d = (PAGBannerAdLoadListener) bVar;
        }
        this.h = cVar;
        a(adSlot, bVar);
    }

    private void b() {
        n.remove(this);
    }

    private void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.b bVar) {
        if (adSlot == null) {
            return;
        }
        s sVar = new s();
        sVar.f = 2;
        this.f654b.a(adSlot, sVar, this.i, new a(adSlot));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        List<q> list = this.f;
        if (list == null) {
            return;
        }
        for (q qVar : list) {
            if (q.c(qVar) && qVar.N0() != null && qVar.N0().t() != null) {
                if (com.bytedance.sdk.openadsdk.core.o.d().n(String.valueOf(qVar.S())) && com.bytedance.sdk.openadsdk.core.o.d().b0()) {
                    com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(qVar.u0()).d(), qVar);
                    bVarA.a("material_meta", qVar);
                    bVarA.a("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z zVar) {
        if (this.d != null) {
            PAGBannerAd pAGBannerAdA = null;
            Iterator<q> it = this.g.iterator();
            while (it.hasNext() && (pAGBannerAdA = a(it.next())) == null) {
            }
            if (pAGBannerAdA != null) {
                if (!TextUtils.isEmpty(this.a.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.d.c.b(this.g.get(0), a0.d(this.i), this.m.d());
                } else {
                    com.bytedance.sdk.openadsdk.d.c.b(this.g.get(0), a0.d(this.a.getDurationSlotType()), zVar);
                }
                this.d.onAdLoaded(pAGBannerAdA);
                return;
            }
            this.d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
            a(103);
        }
    }

    private void a(int i) {
        List<q> list = this.f;
        com.bytedance.sdk.openadsdk.l.c.b bVarE = com.bytedance.sdk.openadsdk.l.c.b.o().a(this.i).f(this.a.getCodeId()).e((list == null || list.size() <= 0) ? "" : this.f.get(0).U());
        bVarE.b(i).b(com.bytedance.sdk.openadsdk.core.g.a(i));
        com.bytedance.sdk.openadsdk.l.b.a().c(bVarE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (this.e.getAndSet(false)) {
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.d;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i, str);
            }
            c cVar = this.h;
            if (cVar != null) {
                cVar.a();
            }
            a();
        }
    }

    private PAGBannerAd a(q qVar) {
        if (this.i != 1) {
            return null;
        }
        if (qVar.N0() != null) {
            return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.c, qVar, this.a);
        }
        return new com.bytedance.sdk.openadsdk.core.bannerexpress.a(this.c, qVar, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<q> list = this.f;
        if (list != null) {
            list.clear();
        }
        List<q> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        b(true);
        a(true);
        c(true);
        b();
    }

    private void a(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            com.bytedance.sdk.component.utils.m.a("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + this.l.cancel(z));
        } catch (Throwable unused) {
        }
    }
}
