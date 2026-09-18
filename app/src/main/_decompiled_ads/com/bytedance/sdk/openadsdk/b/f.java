package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.s;
import com.bytedance.sdk.openadsdk.core.f0.v;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.y;
import com.bytedance.sdk.openadsdk.utils.z;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static volatile f e;
    private final com.bytedance.sdk.openadsdk.c.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p<com.bytedance.sdk.openadsdk.d.a> f441b;
    private final Context c;
    private Map<String, AtomicInteger> d = new ConcurrentHashMap();

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    static class b implements b.b.a.a.h.h {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // b.b.a.a.h.h
        public Bitmap a(Bitmap bitmap) {
            if (this.a <= 0) {
                return bitmap;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return b.b.a.a.d.g.a.a(o.a(), bitmap, this.a);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class c implements p.a {
        final /* synthetic */ AdSlot a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v f442b;

        c(AdSlot adSlot, v vVar) {
            this.a = adSlot;
            this.f442b = vVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            m.a("TTAppOpenAdCacheManager", "cache Load App Open Ad From Network success");
            if (aVar == null || aVar.b() == null || aVar.b().size() == 0) {
                m.a("TTAppOpenAdCacheManager", "material is null");
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
            } else {
                q qVar = aVar.b().get(0);
                if (q.c(qVar)) {
                    f.this.b(qVar, this.a, this.f442b);
                } else {
                    f.this.a(qVar, this.a, this.f442b);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            m.a("TTAppOpenAdCacheManager", "cache Load App OpenAd From Network fail");
            f.this.c(this.a);
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class h implements FileFilter {
        h(f fVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            String name = file.getName();
            return name.contains("openad_image_cache") || name.contains("openad_video_cache");
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    private class i extends b.b.a.a.k.g {
        private final com.bytedance.sdk.openadsdk.b.l.a c;

        public i(f fVar, com.bytedance.sdk.openadsdk.b.l.a aVar) {
            super("App Open Ad Write Cache");
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.sdk.openadsdk.m.i.d.b("tt_openad_materialMeta", "material" + this.c.b(), com.bytedance.sdk.component.utils.a.a(this.c.a().n1()).toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    public interface j {
        void a();

        void a(com.bytedance.sdk.openadsdk.n.d.b bVar);
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    interface k {
        void a();

        void a(int i, String str);
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    public interface l {
        void a();

        void a(Bitmap bitmap);
    }

    private f(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = o.a();
        }
        this.a = new com.bytedance.sdk.openadsdk.c.b(10, 8, true);
        this.f441b = o.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdSlot adSlot) {
        AtomicInteger atomicInteger = this.d.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        } else {
            atomicInteger.decrementAndGet();
        }
        this.d.put(adSlot.getCodeId(), atomicInteger);
    }

    public q d(int i2) {
        String strA;
        String strA2 = com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad_materialMeta", "material" + i2, (String) null);
        if (!TextUtils.isEmpty(strA2)) {
            try {
                strA = com.bytedance.sdk.component.utils.a.a(new JSONObject(strA2).optString("message"));
            } catch (JSONException e2) {
                m.b("TTAppOpenAdCacheManager", e2.getMessage());
                strA = null;
            }
            if (!TextUtils.isEmpty(strA)) {
                try {
                    q qVarF = com.bytedance.sdk.openadsdk.core.b.f(new JSONObject(strA));
                    if (qVarF != null) {
                        return qVarF;
                    }
                } catch (JSONException e3) {
                    m.b("TTAppOpenAdCacheManager", e3.getMessage());
                }
            }
        }
        return null;
    }

    public q e(int i2) {
        long jA = com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "material_expiration_time" + i2, -1L);
        q qVarD = d(i2);
        if (System.currentTimeMillis() / 1000 < jA && qVarD != null) {
            return qVarD;
        }
        if (qVarD == null && jA == -1) {
            return null;
        }
        c(i2);
        if (qVarD == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.b.k.a.a(qVarD);
        return null;
    }

    public void f(int i2) {
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "image_has_cached" + i2, Boolean.TRUE);
    }

    public void g(int i2) {
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "video_has_cached" + i2, Boolean.TRUE);
    }

    public void b(AdSlot adSlot) {
        if (adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        AtomicInteger atomicInteger = this.d.get(adSlot.getCodeId());
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
        }
        m.a("TTAppOpenAdCacheManager", "local Requesting:", atomicInteger);
        int iA = atomicInteger.get() + a(adSlot);
        if (iA >= 1) {
            m.a("TTAppOpenAdCacheManager", Integer.valueOf(iA), ",The number of preloads exceeds the limit ", 1);
            return;
        }
        atomicInteger.incrementAndGet();
        this.d.put(adSlot.getCodeId(), atomicInteger);
        v vVar = new v();
        vVar.b(z.c());
        s sVar = new s();
        sVar.h = vVar;
        sVar.d = 2;
        sVar.f = 2;
        this.f441b.a(adSlot, sVar, 3, new c(adSlot, vVar));
    }

    public static f a(Context context) {
        if (e == null) {
            synchronized (f.class) {
                if (e == null) {
                    e = new f(context);
                }
            }
        }
        return e;
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class d implements k {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f443b;
        final /* synthetic */ v c;
        final /* synthetic */ AdSlot d;

        d(int i, q qVar, v vVar, AdSlot adSlot) {
            this.a = i;
            this.f443b = qVar;
            this.c = vVar;
            this.d = adSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.k
        public void a() {
            com.bytedance.sdk.openadsdk.b.l.a aVar = new com.bytedance.sdk.openadsdk.b.l.a(this.a, this.f443b);
            f.this.a(aVar);
            com.bytedance.sdk.openadsdk.b.k.a.a(aVar.a(), 1, this.c);
            f.this.c(this.d);
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.k
        public void a(int i, String str) {
            f.this.c(this.d);
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class e implements j {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f444b;
        final /* synthetic */ v c;
        final /* synthetic */ AdSlot d;

        e(int i, q qVar, v vVar, AdSlot adSlot) {
            this.a = i;
            this.f444b = qVar;
            this.c = vVar;
            this.d = adSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.j
        public void a(com.bytedance.sdk.openadsdk.n.d.b bVar) {
            com.bytedance.sdk.openadsdk.b.l.a aVar = new com.bytedance.sdk.openadsdk.b.l.a(this.a, this.f444b);
            f.this.a(aVar);
            com.bytedance.sdk.openadsdk.b.k.a.a(aVar.a(), 1, this.c);
            f.this.c(this.d);
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.j
        public void a() {
            f.this.c(this.d);
        }
    }

    public void c(int i2) {
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad_materialMeta", "material" + i2);
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "material_expiration_time" + i2);
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "video_has_cached" + i2);
        com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "image_has_cached" + i2);
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    static class a implements b.b.a.a.h.o<Bitmap> {
        final /* synthetic */ l a;

        a(l lVar) {
            this.a = lVar;
        }

        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k<Bitmap> kVar) {
            if (kVar == null || kVar.c() == null || kVar.e() == null) {
                l lVar = this.a;
                if (lVar != null) {
                    lVar.a();
                    return;
                }
                return;
            }
            l lVar2 = this.a;
            if (lVar2 != null) {
                lVar2.a(kVar.c());
            }
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            l lVar = this.a;
            if (lVar != null) {
                lVar.a();
            }
        }
    }

    public static void a(q qVar, l lVar) {
        a(qVar, lVar, 0);
    }

    public static void a(q qVar, l lVar, int i2) {
        String strB = qVar.N0().b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.d.a(strB).b(qVar.N0().c()).a(qVar.N0().a()).d(b0.g(o.a())).c(b0.i(o.a())).a(u.BITMAP).a(new b(i2)).a(new com.bytedance.sdk.openadsdk.h.b(qVar, strB, new a(lVar)));
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class C0175f implements b.a.a.a.a.a.a.h.a.InterfaceC0009a {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f445b;
        final /* synthetic */ q c;
        final /* synthetic */ v d;
        final /* synthetic */ k e;
        final /* synthetic */ File f;

        C0175f(int i, z zVar, q qVar, v vVar, k kVar, File file) {
            this.a = i;
            this.f445b = zVar;
            this.c = qVar;
            this.d = vVar;
            this.e = kVar;
            this.f = file;
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
            m.a("TTAppOpenAdCacheManager", "Video file caching success");
            f.this.g(this.a);
            long jD = this.f445b.d();
            com.bytedance.sdk.openadsdk.b.k.a.b(this.c, jD, true);
            v vVar = this.d;
            if (vVar != null) {
                vVar.a(jD);
                this.d.a(2);
            }
            this.e.a();
            f.a(this.c, (l) null);
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void b(b.a.a.a.a.a.a.f.c cVar, int i) {
        }

        @Override // b.a.a.a.a.a.a.h.a.InterfaceC0009a
        public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
            m.a("TTAppOpenAdCacheManager", "Video file caching failed");
            long jD = this.f445b.d();
            com.bytedance.sdk.openadsdk.b.k.a.b(this.c, jD, false);
            v vVar = this.d;
            if (vVar != null) {
                vVar.a(jD);
            }
            this.e.a(i, str);
            try {
                if (this.f.exists() && this.f.isFile()) {
                    com.bytedance.sdk.component.utils.g.a(this.f);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdCacheManager.java */
    class g implements com.bytedance.sdk.openadsdk.utils.i.b {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z f446b;
        final /* synthetic */ q c;
        final /* synthetic */ v d;
        final /* synthetic */ j e;

        g(int i, z zVar, q qVar, v vVar, j jVar) {
            this.a = i;
            this.f446b = zVar;
            this.c = qVar;
            this.d = vVar;
            this.e = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void a(com.bytedance.sdk.openadsdk.n.d.b bVar) {
            if (!bVar.b()) {
                com.bytedance.sdk.openadsdk.b.k.a.a(this.c, this.f446b.d(), false);
                this.e.a();
                return;
            }
            m.a("TTAppOpenAdCacheManager", "Image loaded successfully");
            f.this.f(this.a);
            long jD = this.f446b.d();
            com.bytedance.sdk.openadsdk.b.k.a.a(this.c, jD, true);
            v vVar = this.d;
            if (vVar != null) {
                vVar.a(jD);
                this.d.a(2);
            }
            this.e.a(bVar);
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void b() {
            m.a("TTAppOpenAdCacheManager", "Image loading failed");
            com.bytedance.sdk.openadsdk.b.k.a.a(this.c, this.f446b.d(), false);
            this.e.a();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.i.b
        public void a() {
            m.a("TTAppOpenAdCacheManager", "Image caching success");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(q qVar, AdSlot adSlot, v vVar) {
        a(qVar, adSlot, vVar, new d(qVar.S(), qVar, vVar, adSlot));
    }

    public boolean b(int i2) {
        return com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "video_has_cached" + i2, false);
    }

    private void b(com.bytedance.sdk.openadsdk.b.l.a aVar) {
        y.b(new i(this, aVar), 5);
    }

    public boolean b(q qVar) {
        if (qVar == null || qVar.d0() == null || qVar.d0().size() == 0 || TextUtils.isEmpty(qVar.d0().get(0).d())) {
            return false;
        }
        n nVar = qVar.d0().get(0);
        return a(nVar.d(), nVar.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, AdSlot adSlot, v vVar) {
        a(qVar, vVar, new e(qVar.S(), qVar, vVar, adSlot));
    }

    public void a(q qVar, AdSlot adSlot, v vVar, k kVar) {
        z zVarC = z.c();
        int iS = qVar.S();
        b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
        String strT = bVarN0.t();
        String strH = bVarN0.h();
        if (TextUtils.isEmpty(strH)) {
            strH = com.bytedance.sdk.component.utils.e.a(strT);
        }
        File fileB = com.bytedance.sdk.openadsdk.b.o.a.b(strH);
        if (fileB.exists()) {
            m.a("TTAppOpenAdCacheManager", "The video cache exists locally, use the cache directly");
            com.bytedance.sdk.openadsdk.b.o.a.a(fileB);
            g(iS);
            long jD = zVarC.d();
            if (vVar != null) {
                vVar.a(jD);
                vVar.a(1);
            }
            kVar.a();
            a(qVar, (l) null);
            return;
        }
        if (o.d().t(String.valueOf(iS)) && !com.bytedance.sdk.component.utils.p.g(o.a())) {
            kVar.a(100, "OnlyWifi");
            return;
        }
        com.bytedance.sdk.openadsdk.core.j0.a.b bVarA = q.a(fileB.getParent(), qVar);
        bVarA.a("material_meta", qVar);
        bVarA.a("ad_slot", adSlot);
        com.bytedance.sdk.openadsdk.core.j0.d.a.a(bVarA, new C0175f(iS, zVarC, qVar, vVar, kVar, fileB));
        if (Build.VERSION.SDK_INT < 23) {
            a(new File(b.a.a.a.a.a.a.c.a().getCacheDir(), "proxy_cache"));
            g(iS);
            long jD2 = zVarC.d();
            com.bytedance.sdk.openadsdk.b.k.a.b(qVar, jD2, true);
            if (vVar != null) {
                vVar.a(jD2);
                vVar.a(2);
            }
            kVar.a();
            a(qVar, (l) null);
        }
    }

    public String b() {
        String name = new File(CacheDirFactory.getRootDir()).getName();
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            return name + RemoteSettings.FORWARD_SLASH_STRING + "openad_image_cache" + RemoteSettings.FORWARD_SLASH_STRING;
        }
        return name + RemoteSettings.FORWARD_SLASH_STRING + "/openad_image_cache" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public void a(q qVar, v vVar, j jVar) {
        z zVarC = z.c();
        int iS = qVar.S();
        n nVar = qVar.d0().get(0);
        String strC = nVar.c();
        String strD = nVar.d();
        int iE = nVar.e();
        int iB = nVar.b();
        File fileA = com.bytedance.sdk.openadsdk.b.o.a.a(TextUtils.isEmpty(strC) ? com.bytedance.sdk.component.utils.e.a(strD) : strC);
        if (a(strD, strC)) {
            m.a("TTAppOpenAdCacheManager", "The image cache exists locally, directly use the cache");
            f(iS);
            long jD = zVarC.d();
            if (vVar != null) {
                vVar.a(jD);
                vVar.a(1);
            }
            jVar.a(null);
            return;
        }
        com.bytedance.sdk.openadsdk.utils.i.a(new com.bytedance.sdk.openadsdk.n.a(strD, nVar.c()), iE, iB, new g(iS, zVarC, qVar, vVar, jVar), fileA.getParent());
    }

    public boolean a(int i2) {
        return com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "image_has_cached" + i2, false);
    }

    public void a(com.bytedance.sdk.openadsdk.b.l.a aVar) {
        if (aVar.a() != null) {
            com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "material_expiration_time" + aVar.b(), Long.valueOf(aVar.a().M()));
            b(aVar);
        }
    }

    public String a(q qVar) {
        if (qVar != null && qVar.N0() != null && !TextUtils.isEmpty(qVar.N0().t())) {
            String strT = qVar.N0().t();
            String strH = qVar.N0().h();
            if (TextUtils.isEmpty(strH)) {
                strH = com.bytedance.sdk.component.utils.e.a(strT);
            }
            File fileB = com.bytedance.sdk.openadsdk.b.o.a.b(strH);
            if (fileB.exists() && fileB.isFile()) {
                return fileB.getAbsolutePath();
            }
        }
        return null;
    }

    public boolean a(String str, String str2) {
        boolean z;
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.e.a(str);
            }
            File fileA = com.bytedance.sdk.openadsdk.b.o.a.a(str2);
            InputStream inputStreamA = com.bytedance.sdk.openadsdk.h.d.a(str, str2);
            if (inputStreamA != null) {
                try {
                    inputStreamA.close();
                } catch (IOException e2) {
                    m.b("TTAppOpenAdCacheManager", e2.getMessage());
                }
                z = true;
            } else {
                z = false;
            }
            if (z || !(com.bytedance.sdk.openadsdk.h.d.a(str, str2, fileA.getParent()) || new File(fileA.getPath() + ".0").exists())) {
                return z;
            }
            return true;
        } catch (Exception e3) {
            m.b("TTAppOpenAdCacheManager", e3.getMessage());
            return false;
        }
    }

    public void a(File file) {
        try {
            this.a.a(file);
        } catch (IOException e2) {
            m.b("TTAppOpenAdCacheManager", "trimFileCache fail", e2);
        }
    }

    public void a() {
        File[] fileArrListFiles;
        try {
            com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad_materialMeta");
            com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad");
        } catch (Throwable unused) {
        }
        try {
            File cacheDir = this.c.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new h(this))) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.g.a(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    private int a(AdSlot adSlot) {
        long jA = com.bytedance.sdk.openadsdk.m.i.d.a("tt_openad", "material_expiration_time" + adSlot.getCodeId(), -1L);
        Object[] objArr = new Object[2];
        objArr[0] = "local cache number : ";
        objArr[1] = Integer.valueOf(jA == -1 ? 0 : 1);
        m.a("TTAppOpenAdCacheManager", objArr);
        return jA == -1 ? 0 : 1;
    }
}
