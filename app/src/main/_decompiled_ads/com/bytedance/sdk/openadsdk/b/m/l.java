package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.s;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardVideoLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static volatile l g;
    private final Context a;
    private b.b.a.a.k.g e;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final List<i> d = Collections.synchronizedList(new ArrayList());
    private final w.b f = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f482b = com.bytedance.sdk.openadsdk.core.o.c();

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class a implements com.bytedance.sdk.openadsdk.core.j0.b.a.d {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdSlot f483b;
        final /* synthetic */ z c;

        a(q qVar, AdSlot adSlot, z zVar) {
            this.a = qVar;
            this.f483b = adSlot;
            this.c = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.j0.b.a.d
        public void a(boolean z) {
            if (t.h(this.a)) {
                com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f483b.getDurationSlotType()), this.c);
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class c implements p.a {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.common.b f485b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ long d;
        final /* synthetic */ z e;

        c(boolean z, com.bytedance.sdk.openadsdk.common.b bVar, AdSlot adSlot, long j, z zVar) {
            this.a = z;
            this.f485b = bVar;
            this.c = adSlot;
            this.d = j;
            this.e = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            com.bytedance.sdk.openadsdk.common.b bVar2;
            if (aVar.b() == null || aVar.b().isEmpty()) {
                if (this.a || (bVar2 = this.f485b) == null) {
                    return;
                }
                bVar2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            com.bytedance.sdk.component.utils.m.a("RewardVideoLoadManager", "get material data success isPreload=" + this.a);
            o oVar = new o(l.this.a, aVar, this.c);
            if (!this.a) {
                if (!TextUtils.isEmpty(this.c.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.d.c.b(aVar.a(), "rewarded_video", System.currentTimeMillis() - this.d);
                }
                if (!aVar.h() && (this.f485b instanceof PAGRewardedAdLoadListener) && com.bytedance.sdk.openadsdk.core.o.d().C() == 0) {
                    ((PAGRewardedAdLoadListener) this.f485b).onAdLoaded(oVar.a());
                }
            }
            h hVar = new h(this.f485b, aVar, null);
            for (int i = 0; i < aVar.b().size(); i++) {
                l.this.a(aVar, aVar.b().get(i), oVar, this.c, this.a, this.e, hVar, aVar.h());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            com.bytedance.sdk.openadsdk.common.b bVar;
            if (this.a || (bVar = this.f485b) == null) {
                return;
            }
            bVar.onError(i, str);
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class d implements com.bytedance.sdk.openadsdk.core.j0.b.a.d {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f486b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ z d;

        d(boolean z, q qVar, AdSlot adSlot, z zVar) {
            this.a = z;
            this.f486b = qVar;
            this.c = adSlot;
            this.d = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.j0.b.a.d
        public void a(boolean z) {
            q qVar;
            if (this.a || (qVar = this.f486b) == null || !t.h(qVar)) {
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.f486b, a0.d(this.c.getDurationSlotType()), this.d);
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class f implements k.d<Object> {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f488b;
        final /* synthetic */ o c;
        final /* synthetic */ AdSlot d;
        final /* synthetic */ z e;
        final /* synthetic */ h f;
        final /* synthetic */ boolean g;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.a h;

        f(boolean z, q qVar, o oVar, AdSlot adSlot, z zVar, h hVar, boolean z2, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            this.a = z;
            this.f488b = qVar;
            this.c = oVar;
            this.d = adSlot;
            this.e = zVar;
            this.f = hVar;
            this.g = z2;
            this.h = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.k.d
        public void a(boolean z, Object obj) {
            com.bytedance.sdk.component.utils.m.a("RewardVideoLoadManager", "download video file: " + z + ", preload: " + this.a);
            if (z) {
                this.c.a(k.a(l.this.a).b(this.f488b));
            }
            if (this.a) {
                if (z) {
                    k.a(l.this.a).a(this.d, this.h);
                    return;
                }
                return;
            }
            if (!z) {
                if (this.f != null) {
                    if (this.g || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                        this.f.onError(-1, "");
                        return;
                    }
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.f488b, a0.d(this.d.getDurationSlotType()), this.e);
            if (this.f != null) {
                if (this.g || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.f.onAdLoaded(this.c.a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class g implements w.b {
        g() {
        }

        @Override // com.bytedance.sdk.component.utils.w.b
        public void a(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (l.this.e == null) {
                    l lVar = l.this;
                    lVar.e = new com.bytedance.sdk.openadsdk.b.m.b("net connect task", lVar.d);
                }
                com.bytedance.sdk.component.utils.i.a().post(l.this.e);
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    private static class h implements PAGRewardedAdLoadListener {
        private final com.bytedance.sdk.openadsdk.common.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f489b;
        private final AtomicInteger c;
        private final com.bytedance.sdk.openadsdk.core.f0.a d;

        /* JADX INFO: compiled from: RewardVideoLoadManager.java */
        class a implements com.bytedance.sdk.openadsdk.l.a {
            a() {
            }

            @Override // com.bytedance.sdk.openadsdk.l.a
            public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("req_id", h.this.d.c());
                return com.bytedance.sdk.openadsdk.l.c.b.o().h("choose_ad_load_error").c(jSONObject.toString());
            }
        }

        /* synthetic */ h(com.bytedance.sdk.openadsdk.common.b bVar, com.bytedance.sdk.openadsdk.core.f0.a aVar, a aVar2) {
            this(bVar, aVar);
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.b
        public void onError(int i, String str) {
            if (this.c.decrementAndGet() <= 0 && (this.a instanceof PAGRewardedAdLoadListener) && this.f489b.compareAndSet(false, true)) {
                this.a.onError(i, str);
                com.bytedance.sdk.openadsdk.l.b.a("choose_ad_load_error", false, (com.bytedance.sdk.openadsdk.l.a) new a());
            }
        }

        private h(com.bytedance.sdk.openadsdk.common.b bVar, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            this.f489b = new AtomicBoolean(false);
            this.a = bVar;
            this.d = aVar;
            this.c = new AtomicInteger(a());
        }

        private int a() {
            if (!this.d.f()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.d.b().size(); i2++) {
                q qVar = this.d.b().get(i2);
                if (qVar != null && !t.h(qVar) && qVar.N0() != null) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.c.decrementAndGet();
            if ((this.a instanceof PAGRewardedAdLoadListener) && this.f489b.compareAndSet(false, true)) {
                ((PAGRewardedAdLoadListener) this.a).onAdLoaded(pAGRewardedAd);
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    public static class i extends b.b.a.a.k.g {
        q c;
        AdSlot d;
        com.bytedance.sdk.openadsdk.core.f0.a e;

        /* JADX INFO: compiled from: RewardVideoLoadManager.java */
        class b implements k.d<Object> {
            b() {
            }

            @Override // com.bytedance.sdk.openadsdk.b.m.k.d
            public void a(boolean z, Object obj) {
                if (!z) {
                    com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
                    return;
                }
                com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                k kVarA = k.a(com.bytedance.sdk.openadsdk.core.o.a());
                i iVar = i.this;
                kVarA.a(iVar.d, iVar.e);
            }
        }

        i(q qVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            super("Reward Task");
            this.c = qVar;
            this.d = adSlot;
            this.e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar = this.c;
            if (qVar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                k.a(com.bytedance.sdk.openadsdk.core.o.a()).a(this.c, new b());
            } else if (qVar.N0() != null) {
                com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.c.u0()).b(), this.c);
                bVarA.a("material_meta", this.c);
                bVarA.a("ad_slot", this.d);
                com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new a());
            }
        }

        /* JADX INFO: compiled from: RewardVideoLoadManager.java */
        class a extends b.a.a.a.a.a.a.h.b {
            a() {
            }

            @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
            public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
                com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                k kVarA = k.a(com.bytedance.sdk.openadsdk.core.o.a());
                i iVar = i.this;
                kVarA.a(iVar.d, iVar.e);
            }

            @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
            public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
                com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
            }
        }
    }

    private l(Context context) {
        this.a = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context.getApplicationContext();
        c();
    }

    private void d() {
        if (this.c.get()) {
            this.c.set(false);
            try {
                w.a(this.f);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.e != null) {
            try {
                com.bytedance.sdk.component.utils.i.a().removeCallbacks(this.e);
            } catch (Exception unused) {
            }
            this.e = null;
        }
        d();
    }

    private void c() {
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        w.a(this.f, this.a);
    }

    public void b() {
        AdSlot adSlotB = k.a(this.a).b();
        if (adSlotB == null || TextUtils.isEmpty(adSlotB.getCodeId()) || k.a(this.a).c(adSlotB.getCodeId()) != null) {
            return;
        }
        a(adSlotB);
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class b extends b.a.a.a.a.a.a.h.b {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdSlot f484b;
        final /* synthetic */ z c;
        final /* synthetic */ h d;
        final /* synthetic */ boolean e;
        final /* synthetic */ o f;
        final /* synthetic */ b.a.a.a.a.a.a.f.b g;

        b(q qVar, AdSlot adSlot, z zVar, h hVar, boolean z, o oVar, b.a.a.a.a.a.a.f.b bVar) {
            this.a = qVar;
            this.f484b = adSlot;
            this.c = zVar;
            this.d = hVar;
            this.e = z;
            this.f = oVar;
            this.g = bVar;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
            Log.d("RewardVideoLoadManager", "onVideoPreloadSuccess: ");
            com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f484b.getDurationSlotType()), this.c);
            if (this.d != null) {
                if (this.e || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.d.onAdLoaded(this.f.a());
                }
            }
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
            com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail");
            if (this.g.v()) {
                com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f484b.getDurationSlotType()), this.c);
            }
            if (this.d != null) {
                if (this.e || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.d.onError(i, str);
                }
            }
        }
    }

    public static l a(Context context) {
        if (g == null) {
            synchronized (l.class) {
                if (g == null) {
                    g = new l(context);
                }
            }
        }
        return g;
    }

    public void b(AdSlot adSlot) {
        k.a(this.a).a(adSlot);
    }

    /* JADX INFO: compiled from: RewardVideoLoadManager.java */
    class e extends b.a.a.a.a.a.a.h.b {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f487b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ z d;
        final /* synthetic */ h e;
        final /* synthetic */ boolean f;
        final /* synthetic */ o g;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.a h;
        final /* synthetic */ b.a.a.a.a.a.a.f.b i;

        e(boolean z, q qVar, AdSlot adSlot, z zVar, h hVar, boolean z2, o oVar, com.bytedance.sdk.openadsdk.core.f0.a aVar, b.a.a.a.a.a.a.f.b bVar) {
            this.a = z;
            this.f487b = qVar;
            this.c = adSlot;
            this.d = zVar;
            this.e = hVar;
            this.f = z2;
            this.g = oVar;
            this.h = aVar;
            this.i = bVar;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
            com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess");
            if (this.a) {
                k.a(l.this.a).a(this.c, this.h);
                com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: ad json save");
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.f487b, a0.d(this.c.getDurationSlotType()), this.d);
            if (this.e != null) {
                if (this.f || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.e.onAdLoaded(this.g.a());
                }
            }
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
            com.bytedance.sdk.component.utils.m.d("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail");
            if (this.i.v()) {
                com.bytedance.sdk.openadsdk.d.c.b(this.f487b, a0.d(this.c.getDurationSlotType()), this.d);
            }
            if (this.e != null) {
                if (this.f || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.e.onError(i, str);
                }
            }
        }
    }

    public AdSlot b(String str) {
        return k.a(this.a).b(str);
    }

    public void a() {
        try {
            k.a(this.a).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.b bVar) {
        k.a(this.a).b(adSlot);
        a(adSlot, false, bVar);
    }

    public void a(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getBidAdm())) {
            a(adSlot, true, null);
        }
    }

    private void a(AdSlot adSlot, boolean z, com.bytedance.sdk.openadsdk.common.b bVar) {
        z zVarC = z.c();
        if (z) {
            a(adSlot, true, zVarC, bVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.f0.a aVarC = k.a(this.a).c(adSlot.getCodeId());
        if (aVarC != null && aVarC.f()) {
            o oVar = new o(this.a, aVarC, adSlot);
            if (!aVarC.h() && !t.h(aVarC.a())) {
                oVar.a(k.a(this.a).b(aVarC.a()));
            }
            if (bVar != null) {
                if (!aVarC.h() && (bVar instanceof PAGRewardedAdLoadListener) && com.bytedance.sdk.openadsdk.core.o.d().C() == 0) {
                    ((PAGRewardedAdLoadListener) bVar).onAdLoaded(oVar.a());
                }
                h hVar = new h(bVar, aVarC, null);
                for (int i2 = 0; i2 < aVarC.b().size(); i2++) {
                    a(aVarC.b().get(i2), adSlot, hVar, zVarC, oVar, aVarC.h());
                }
            }
            for (int i3 = 0; i3 < aVarC.b().size(); i3++) {
                q qVar = aVarC.b().get(i3);
                com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(qVar, new a(qVar, adSlot, zVarC));
            }
            com.bytedance.sdk.component.utils.m.a("RewardVideoLoadManager", "get cache data success");
            com.bytedance.sdk.component.utils.m.a("bidding", "reward video get cache data success");
            return;
        }
        a(adSlot, false, zVarC, bVar);
    }

    private void a(q qVar, AdSlot adSlot, h hVar, z zVar, o oVar, boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        if (hVar == null || (!z && com.bytedance.sdk.openadsdk.core.o.d().C() != 1)) {
            z2 = false;
        }
        if (t.h(qVar)) {
            z3 = z2;
        } else if (Build.VERSION.SDK_INT >= 23) {
            b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
            com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(qVar.u0()).b(), qVar);
            bVarA.a("material_meta", qVar);
            bVarA.a("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new b(qVar, adSlot, zVar, hVar, z, oVar, bVarN0));
        } else {
            com.bytedance.sdk.openadsdk.d.c.b(qVar, a0.d(adSlot.getDurationSlotType()), zVar);
            z3 = z2;
        }
        if (z3) {
            hVar.onAdLoaded(oVar.a());
        }
    }

    private void a(AdSlot adSlot, boolean z, z zVar, com.bytedance.sdk.openadsdk.common.b bVar) {
        if (com.bytedance.sdk.component.utils.m.c()) {
            com.bytedance.sdk.component.utils.m.a("bidding", "reward video doNetwork , get new materials:BidAdm->MD5->" + b.a.a.a.a.a.a.i.b.a(adSlot.getBidAdm()));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        s sVar = new s();
        sVar.f589b = z ? 2 : 1;
        if (com.bytedance.sdk.openadsdk.core.o.d().d(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            sVar.f = 2;
        }
        this.f482b.a(adSlot, sVar, 7, new c(z, bVar, adSlot, jCurrentTimeMillis, zVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, q qVar, o oVar, AdSlot adSlot, boolean z, z zVar, h hVar, boolean z2) {
        boolean z3;
        com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(qVar, new d(z, qVar, adSlot, zVar));
        boolean z4 = true;
        if (z && !t.h(qVar) && com.bytedance.sdk.openadsdk.core.o.d().l(adSlot.getCodeId()).d == 1 && !com.bytedance.sdk.component.utils.p.g(this.a)) {
            a(new i(qVar, adSlot, aVar));
            return;
        }
        if (hVar == null || (!z2 && com.bytedance.sdk.openadsdk.core.o.d().C() != 1)) {
            z4 = false;
        }
        if (!t.h(qVar)) {
            if (Build.VERSION.SDK_INT >= 23) {
                b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
                if (bVarN0 != null) {
                    com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(qVar.u0()).b(), qVar);
                    bVarA.a("material_meta", qVar);
                    bVarA.a("ad_slot", adSlot);
                    com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new e(z, qVar, adSlot, zVar, hVar, z2, oVar, aVar, bVarN0));
                }
                if (z3) {
                    hVar.onAdLoaded(oVar.a());
                }
            }
            k.a(this.a).a(qVar, new f(z, qVar, oVar, adSlot, zVar, hVar, z2, aVar));
            z3 = false;
            if (z3) {
                hVar.onAdLoaded(oVar.a());
            }
        }
        k.a(this.a).a(adSlot, aVar);
        z3 = z4;
        if (z3) {
            hVar.onAdLoaded(oVar.a());
        }
    }

    public void a(String str) {
        k.a(this.a).a(str);
    }

    private void a(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.d.size() >= 1) {
            this.d.remove(0);
        }
        this.d.add(iVar);
    }
}
