package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
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

/* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static volatile e g;
    private final Context a;
    private b.b.a.a.k.g e;
    private AtomicBoolean c = new AtomicBoolean(false);
    private List<i> d = Collections.synchronizedList(new ArrayList());
    private final w.b f = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f465b = com.bytedance.sdk.openadsdk.core.o.c();

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class a implements com.bytedance.sdk.openadsdk.core.j0.b.a.d {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdSlot f466b;
        final /* synthetic */ z c;

        a(q qVar, AdSlot adSlot, z zVar) {
            this.a = qVar;
            this.f466b = adSlot;
            this.c = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.j0.b.a.d
        public void a(boolean z) {
            if (t.h(this.a)) {
                com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f466b.getDurationSlotType()), this.c);
            }
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class c implements p.a {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.common.b f468b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ long d;
        final /* synthetic */ z e;

        c(boolean z, com.bytedance.sdk.openadsdk.common.b bVar, AdSlot adSlot, long j, z zVar) {
            this.a = z;
            this.f468b = bVar;
            this.c = adSlot;
            this.d = j;
            this.e = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            com.bytedance.sdk.openadsdk.common.b bVar2;
            if (aVar.b() == null || aVar.b().isEmpty()) {
                if (this.a || (bVar2 = this.f468b) == null) {
                    return;
                }
                bVar2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            com.bytedance.sdk.component.utils.m.a("FullScreenVideoLoadManager", "get material data success isPreload=" + this.a);
            n nVar = new n(e.this.a, aVar);
            if (!this.a) {
                if (!TextUtils.isEmpty(this.c.getBidAdm())) {
                    com.bytedance.sdk.openadsdk.d.c.b(aVar.a(), "fullscreen_interstitial_ad", System.currentTimeMillis() - this.d);
                }
                if (!aVar.h() && (this.f468b instanceof PAGInterstitialAdLoadListener) && com.bytedance.sdk.openadsdk.core.o.d().C() == 0) {
                    ((PAGInterstitialAdLoadListener) this.f468b).onAdLoaded(nVar.a());
                }
            }
            h hVar = new h(this.f468b, aVar, null);
            for (int i = 0; i < aVar.b().size(); i++) {
                e.this.a(aVar, aVar.b().get(i), nVar, this.c, this.a, this.e, hVar, aVar.h());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            com.bytedance.sdk.openadsdk.common.b bVar;
            if (this.a || (bVar = this.f468b) == null) {
                return;
            }
            bVar.onError(i, str);
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class d implements com.bytedance.sdk.openadsdk.core.j0.b.a.d {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f469b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ z d;

        d(boolean z, q qVar, AdSlot adSlot, z zVar) {
            this.a = z;
            this.f469b = qVar;
            this.c = adSlot;
            this.d = zVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.j0.b.a.d
        public void a(boolean z) {
            q qVar;
            if (this.a || (qVar = this.f469b) == null || !t.h(qVar)) {
                return;
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.f469b, a0.d(this.c.getDurationSlotType()), this.d);
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class f implements com.bytedance.sdk.openadsdk.b.m.d.InterfaceC0183d<Object> {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f471b;
        final /* synthetic */ n c;
        final /* synthetic */ AdSlot d;
        final /* synthetic */ z e;
        final /* synthetic */ h f;
        final /* synthetic */ boolean g;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.a h;

        f(boolean z, q qVar, n nVar, AdSlot adSlot, z zVar, h hVar, boolean z2, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            this.a = z;
            this.f471b = qVar;
            this.c = nVar;
            this.d = adSlot;
            this.e = zVar;
            this.f = hVar;
            this.g = z2;
            this.h = aVar;
        }

        @Override // com.bytedance.sdk.openadsdk.b.m.d.InterfaceC0183d
        public void a(boolean z, Object obj) {
            com.bytedance.sdk.component.utils.m.a("FullScreenVideoLoadManager", "download video file: " + z + ", preload: " + this.a);
            if (z) {
                this.c.a(com.bytedance.sdk.openadsdk.b.m.d.a(e.this.a).b(this.f471b));
            }
            if (this.a) {
                if (z) {
                    com.bytedance.sdk.openadsdk.b.m.d.a(e.this.a).a(this.d, this.h);
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
            com.bytedance.sdk.openadsdk.d.c.b(this.f471b, a0.d(this.d.getDurationSlotType()), this.e);
            if (this.f != null) {
                if (this.g || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.f.onAdLoaded(this.c.a());
                }
            }
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class g implements w.b {
        g() {
        }

        @Override // com.bytedance.sdk.component.utils.w.b
        public void a(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (e.this.e == null) {
                    e eVar = e.this;
                    eVar.e = new com.bytedance.sdk.openadsdk.b.m.b("fsv net connect task", eVar.d);
                }
                com.bytedance.sdk.component.utils.i.a().post(e.this.e);
            }
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    private static class h implements PAGInterstitialAdLoadListener {
        private final com.bytedance.sdk.openadsdk.common.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f472b;
        private final AtomicInteger c;
        private final com.bytedance.sdk.openadsdk.core.f0.a d;

        /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
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
            if (this.c.decrementAndGet() > 0 || !this.f472b.compareAndSet(false, true)) {
                return;
            }
            this.a.onError(i, str);
            com.bytedance.sdk.openadsdk.l.b.a("choose_ad_load_error", false, (com.bytedance.sdk.openadsdk.l.a) new a());
        }

        private h(com.bytedance.sdk.openadsdk.common.b bVar, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            this.f472b = new AtomicBoolean(false);
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
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.c.decrementAndGet();
            if ((this.a instanceof PAGInterstitialAdLoadListener) && this.f472b.compareAndSet(false, true)) {
                ((PAGInterstitialAdLoadListener) this.a).onAdLoaded(pAGInterstitialAd);
            }
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    private static class i extends b.b.a.a.k.g {
        q c;
        AdSlot d;
        com.bytedance.sdk.openadsdk.core.f0.a e;

        /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
        class b implements com.bytedance.sdk.openadsdk.b.m.d.InterfaceC0183d<Object> {
            b() {
            }

            @Override // com.bytedance.sdk.openadsdk.b.m.d.InterfaceC0183d
            public void a(boolean z, Object obj) {
                if (!z) {
                    com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail ");
                    return;
                }
                com.bytedance.sdk.openadsdk.b.m.d dVarA = com.bytedance.sdk.openadsdk.b.m.d.a(com.bytedance.sdk.openadsdk.core.o.a());
                i iVar = i.this;
                dVarA.a(iVar.d, iVar.e);
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
            }
        }

        i(q qVar, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
            super("Fullscreen Task");
            this.c = qVar;
            this.d = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar = this.c;
            if (qVar == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                com.bytedance.sdk.openadsdk.b.m.d.a(com.bytedance.sdk.openadsdk.core.o.a()).a(this.c, new b());
                return;
            }
            if (qVar.N0() != null) {
                com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(this.c.u0()).b(), this.c);
                bVarA.a("material_meta", this.c);
                bVarA.a("ad_slot", this.d);
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new a());
            }
        }

        /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
        class a extends b.a.a.a.a.a.a.h.b {
            a() {
            }

            @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
            public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
                com.bytedance.sdk.openadsdk.b.m.d dVarA = com.bytedance.sdk.openadsdk.b.m.d.a(com.bytedance.sdk.openadsdk.core.o.a());
                i iVar = i.this;
                dVarA.a(iVar.d, iVar.e);
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
            }

            @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
            public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail with net change ");
            }
        }
    }

    private e(Context context) {
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
        AdSlot adSlotB = com.bytedance.sdk.openadsdk.b.m.d.a(this.a).b();
        if (adSlotB == null || TextUtils.isEmpty(adSlotB.getCodeId()) || com.bytedance.sdk.openadsdk.b.m.d.a(this.a).c(adSlotB.getCodeId()) != null) {
            return;
        }
        a(adSlotB);
    }

    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class b extends b.a.a.a.a.a.a.h.b {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdSlot f467b;
        final /* synthetic */ z c;
        final /* synthetic */ h d;
        final /* synthetic */ boolean e;
        final /* synthetic */ n f;
        final /* synthetic */ b.a.a.a.a.a.a.f.b g;

        b(q qVar, AdSlot adSlot, z zVar, h hVar, boolean z, n nVar, b.a.a.a.a.a.a.f.b bVar) {
            this.a = qVar;
            this.f467b = adSlot;
            this.c = zVar;
            this.d = hVar;
            this.e = z;
            this.f = nVar;
            this.g = bVar;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
            com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f467b.getDurationSlotType()), this.c);
            if (this.d != null) {
                if (this.e || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.d.onAdLoaded(this.f.a());
                }
            }
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail");
            if (this.g.v()) {
                com.bytedance.sdk.openadsdk.d.c.b(this.a, a0.d(this.f467b.getDurationSlotType()), this.c);
            }
            if (this.d != null) {
                if (this.e || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.d.onError(i, str);
                }
            }
        }
    }

    public static e a(Context context) {
        if (g == null) {
            synchronized (e.class) {
                if (g == null) {
                    g = new e(context);
                }
            }
        }
        return g;
    }

    public void b(AdSlot adSlot) {
        com.bytedance.sdk.openadsdk.b.m.d.a(this.a).a(adSlot);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FullScreenVideoLoadManager.java */
    class C0184e extends b.a.a.a.a.a.a.h.b {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f470b;
        final /* synthetic */ AdSlot c;
        final /* synthetic */ z d;
        final /* synthetic */ h e;
        final /* synthetic */ boolean f;
        final /* synthetic */ n g;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.f0.a h;
        final /* synthetic */ b.a.a.a.a.a.a.f.b i;

        C0184e(boolean z, q qVar, AdSlot adSlot, z zVar, h hVar, boolean z2, n nVar, com.bytedance.sdk.openadsdk.core.f0.a aVar, b.a.a.a.a.a.a.f.b bVar) {
            this.a = z;
            this.f470b = qVar;
            this.c = adSlot;
            this.d = zVar;
            this.e = hVar;
            this.f = z2;
            this.g = nVar;
            this.h = aVar;
            this.i = bVar;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadSuccess");
            if (this.a) {
                com.bytedance.sdk.openadsdk.b.m.d.a(e.this.a).a(this.c, this.h);
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog:  ad json save");
                return;
            }
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: onFullScreenVideoCached");
            com.bytedance.sdk.openadsdk.d.c.b(this.f470b, a0.d(this.c.getDurationSlotType()), this.d);
            if (this.e != null) {
                if (this.f || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.e.onAdLoaded(this.g.a());
                }
            }
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail");
            if (this.i.v()) {
                com.bytedance.sdk.openadsdk.d.c.b(this.f470b, a0.d(this.c.getDurationSlotType()), this.d);
            }
            if (this.e != null) {
                if (this.f || com.bytedance.sdk.openadsdk.core.o.d().C() == 1) {
                    this.e.onError(i, str);
                }
            }
        }
    }

    public AdSlot b(String str) {
        return com.bytedance.sdk.openadsdk.b.m.d.a(this.a).b(str);
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.b.m.d.a(this.a).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.b bVar) {
        com.bytedance.sdk.openadsdk.b.m.d.a(this.a).b(adSlot);
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
        com.bytedance.sdk.openadsdk.core.f0.a aVarC = com.bytedance.sdk.openadsdk.b.m.d.a(this.a).c(adSlot.getCodeId());
        if (aVarC != null && aVarC.f()) {
            n nVar = new n(this.a, aVarC);
            if (!aVarC.h() && !t.h(aVarC.a())) {
                nVar.a(com.bytedance.sdk.openadsdk.b.m.d.a(this.a).b(aVarC.a()));
            }
            if (bVar != null) {
                if (!aVarC.h() && (bVar instanceof PAGInterstitialAdLoadListener) && com.bytedance.sdk.openadsdk.core.o.d().C() == 0) {
                    ((PAGInterstitialAdLoadListener) bVar).onAdLoaded(nVar.a());
                }
                h hVar = new h(bVar, aVarC, null);
                for (int i2 = 0; i2 < aVarC.b().size(); i2++) {
                    a(aVarC.b().get(i2), adSlot, hVar, zVarC, nVar, aVarC.h());
                }
            }
            for (int i3 = 0; i3 < aVarC.b().size(); i3++) {
                q qVar = aVarC.b().get(i3);
                com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(qVar, new a(qVar, adSlot, zVarC));
            }
            com.bytedance.sdk.component.utils.m.a("FullScreenVideoLoadManager", "get cache data success");
            com.bytedance.sdk.component.utils.m.a("bidding", "full video get cache data success");
            return;
        }
        a(adSlot, false, zVarC, bVar);
    }

    private void a(q qVar, AdSlot adSlot, h hVar, z zVar, n nVar, boolean z) {
        boolean z2 = true;
        boolean z3 = false;
        if (hVar == null || (!z && com.bytedance.sdk.openadsdk.core.o.d().C() != 1)) {
            z2 = false;
        }
        if (t.h(qVar) || !q.c(qVar)) {
            z3 = z2;
        } else if (Build.VERSION.SDK_INT >= 23) {
            b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
            com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(qVar.u0()).b(), qVar);
            bVarA.a("material_meta", qVar);
            bVarA.a("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new b(qVar, adSlot, zVar, hVar, z, nVar, bVarN0));
        } else {
            com.bytedance.sdk.openadsdk.d.c.b(qVar, a0.d(adSlot.getDurationSlotType()), zVar);
            z3 = z2;
        }
        if (z3) {
            hVar.onAdLoaded(nVar.a());
        }
    }

    private void a(AdSlot adSlot, boolean z, z zVar, com.bytedance.sdk.openadsdk.common.b bVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        s sVar = new s();
        sVar.c = z ? 2 : 1;
        if (com.bytedance.sdk.openadsdk.core.o.d().d(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            sVar.f = 2;
        }
        this.f465b.a(adSlot, sVar, 8, new c(z, bVar, adSlot, jCurrentTimeMillis, zVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, q qVar, n nVar, AdSlot adSlot, boolean z, z zVar, h hVar, boolean z2) {
        boolean z3;
        com.bytedance.sdk.openadsdk.core.j0.b.a.b().a(qVar, new d(z, qVar, adSlot, zVar));
        boolean z4 = true;
        if (z && !t.h(qVar) && q.c(qVar) && com.bytedance.sdk.openadsdk.core.o.d().l(adSlot.getCodeId()).d == 1 && !com.bytedance.sdk.component.utils.p.g(this.a)) {
            a(new i(qVar, adSlot, aVar));
            return;
        }
        if (hVar == null || (!z2 && com.bytedance.sdk.openadsdk.core.o.d().C() != 1)) {
            z4 = false;
        }
        if (!t.h(qVar) && q.c(qVar)) {
            if (Build.VERSION.SDK_INT >= 23) {
                b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
                if (bVarN0 != null) {
                    com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(CacheDirFactory.getICacheDir(qVar.u0()).b(), qVar);
                    bVarA.a("material_meta", qVar);
                    bVarA.a("ad_slot", adSlot);
                    com.bytedance.sdk.component.utils.m.d("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                    com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new C0184e(z, qVar, adSlot, zVar, hVar, z2, nVar, aVar, bVarN0));
                }
                if (z3) {
                    hVar.onAdLoaded(nVar.a());
                }
            }
            com.bytedance.sdk.openadsdk.b.m.d.a(this.a).a(qVar, new f(z, qVar, nVar, adSlot, zVar, hVar, z2, aVar));
            z3 = false;
            if (z3) {
                hVar.onAdLoaded(nVar.a());
            }
        }
        com.bytedance.sdk.openadsdk.b.m.d.a(this.a).a(adSlot, aVar);
        z3 = z4;
        if (z3) {
            hVar.onAdLoaded(nVar.a());
        }
    }

    public void a(String str) {
        com.bytedance.sdk.openadsdk.b.m.d.a(this.a).a(str);
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
