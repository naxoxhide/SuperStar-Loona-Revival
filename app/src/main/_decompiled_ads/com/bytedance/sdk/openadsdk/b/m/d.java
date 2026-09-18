package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: FullScreenVideoCache.java */
/* JADX INFO: loaded from: classes2.dex */
class d {
    private static volatile d d;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f463b;
    private Map<q, Long> c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: FullScreenVideoCache.java */
    class a implements FileFilter {
        a(d dVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                return file.getName().contains("sp_full_screen_video");
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoCache.java */
    class b implements FileFilter {
        b(d dVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                return file.getName().contains("full_screen_video_cache");
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FullScreenVideoCache.java */
    interface InterfaceC0183d<T> {
        void a(boolean z, T t);
    }

    private d(Context context) {
        this.a = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context.getApplicationContext();
        this.f463b = new m("sp_full_screen_video");
    }

    public AdSlot b(String str) {
        return this.f463b.c(str);
    }

    public com.bytedance.sdk.openadsdk.core.f0.a c(String str) {
        com.bytedance.sdk.openadsdk.core.f0.a aVarA;
        long jE = this.f463b.e(str);
        boolean zF = this.f463b.f(str);
        if ((System.currentTimeMillis() - jE < 10500000) && !zF) {
            try {
                String strB = this.f463b.b(str);
                if (!TextUtils.isEmpty(strB)) {
                    JSONObject jSONObject = new JSONObject(strB);
                    if (jSONObject.has("creatives")) {
                        aVarA = com.bytedance.sdk.openadsdk.core.f0.a.a(jSONObject);
                    } else {
                        q qVarF = com.bytedance.sdk.openadsdk.core.b.f(jSONObject);
                        com.bytedance.sdk.openadsdk.core.f0.a aVar = new com.bytedance.sdk.openadsdk.core.f0.a();
                        aVar.a(qVarF);
                        aVarA = aVar;
                    }
                    if (aVarA != null && aVarA.f()) {
                        Iterator<q> it = aVarA.b().iterator();
                        while (it.hasNext()) {
                            if (!a(it.next())) {
                                it.remove();
                            }
                        }
                        if (aVarA.f()) {
                            return aVarA;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void a(String str) {
        this.f463b.a(str);
    }

    public void b(AdSlot adSlot) {
        this.f463b.b(adSlot);
    }

    public void a() {
        File[] fileArrListFiles;
        File file;
        File[] fileArrListFiles2;
        try {
            int i = Build.VERSION.SDK_INT;
            boolean z = i >= 19 && com.bytedance.sdk.openadsdk.core.h.e("sp_full_screen_video");
            String str = z ? "files" : "shared_prefs";
            if (i >= 24) {
                file = new File(this.a.getDataDir(), str);
            } else {
                file = new File(this.a.getDatabasePath("1").getParentFile().getParentFile(), str);
            }
            if (file.exists() && file.isDirectory() && (fileArrListFiles2 = file.listFiles(new a(this))) != null) {
                for (File file2 : fileArrListFiles2) {
                    if (z) {
                        try {
                            com.bytedance.sdk.component.utils.g.a(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        String strReplace = file2.getName().replace(".xml", "");
                        if (Build.VERSION.SDK_INT >= 24) {
                            this.a.deleteSharedPreferences(strReplace);
                        } else {
                            this.a.getSharedPreferences(strReplace, 0).edit().clear().apply();
                            com.bytedance.sdk.component.utils.g.a(file2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null || !cacheDir.exists() || !cacheDir.isDirectory() || (fileArrListFiles = cacheDir.listFiles(new b(this))) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file3 : fileArrListFiles) {
                try {
                    com.bytedance.sdk.component.utils.g.a(file3);
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public AdSlot b() {
        return this.f463b.a();
    }

    public String b(q qVar) {
        if (qVar == null || qVar.N0() == null || TextUtils.isEmpty(qVar.N0().t())) {
            return null;
        }
        return a(qVar.N0().t(), qVar.N0().h(), qVar.u0());
    }

    /* JADX INFO: compiled from: FullScreenVideoCache.java */
    class c extends b.b.a.a.j.c.a {
        final /* synthetic */ InterfaceC0183d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f464b;

        c(InterfaceC0183d interfaceC0183d, q qVar) {
            this.a = interfaceC0183d;
            this.f464b = qVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (bVar.g() && bVar.d() != null && bVar.d().exists()) {
                InterfaceC0183d interfaceC0183d = this.a;
                if (interfaceC0183d != null) {
                    interfaceC0183d.a(true, null);
                }
                com.bytedance.sdk.component.utils.m.d("FullScreenVideoCache", "onResponse: FullScreenVideo preload success ");
                d.this.a(true, this.f464b, bVar.b(), bVar.f());
                return;
            }
            InterfaceC0183d interfaceC0183d2 = this.a;
            if (interfaceC0183d2 != null) {
                interfaceC0183d2.a(false, null);
            }
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoCache", "onResponse: FullScreenVideo preload Fail ");
            d.this.a(false, this.f464b, bVar.b(), bVar.f());
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            InterfaceC0183d interfaceC0183d = this.a;
            if (interfaceC0183d != null) {
                interfaceC0183d.a(false, null);
            }
            com.bytedance.sdk.component.utils.m.d("FullScreenVideoCache", "onFailure: FullScreenVideo preload fail ");
            d.this.a(false, this.f464b, -2L, iOException.getMessage());
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        b(adSlot);
        if (aVar != null) {
            try {
                this.f463b.a(adSlot.getCodeId(), aVar.k().toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.f463b.a(adSlot);
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d(context);
                }
            }
        }
        return d;
    }

    public String a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.component.utils.e.a(str);
        }
        File fileA = a(str2, i);
        if (fileA == null || !fileA.exists() || !fileA.isFile() || fileA.length() <= 0) {
            return null;
        }
        return fileA.getAbsolutePath();
    }

    private boolean a(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (t.h(qVar)) {
            return true;
        }
        b.a.a.a.a.a.a.f.b bVarN0 = qVar.N0();
        if (bVarN0 == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return !TextUtils.isEmpty(a(bVarN0.t(), bVarN0.h(), qVar.u0()));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, q qVar, long j, String str) {
        Long lRemove = this.c.remove(qVar);
        com.bytedance.sdk.openadsdk.d.c.b(qVar, "fullscreen_interstitial_ad", z ? "load_video_success" : "load_video_error", a0.a(z, qVar, lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue(), j, (z || str == null) ? null : str));
    }

    public void a(q qVar, InterfaceC0183d<Object> interfaceC0183d) {
        this.c.put(qVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (qVar != null && qVar.N0() != null && !TextUtils.isEmpty(qVar.N0().t())) {
            String strT = qVar.N0().t();
            File fileA = a(qVar.N0().h(), qVar.u0());
            b.b.a.a.j.d.a aVarA = com.bytedance.sdk.openadsdk.n.c.b().d().a();
            aVarA.b(strT);
            aVarA.b(fileA.getParent(), fileA.getName());
            aVarA.a(new c(interfaceC0183d, qVar));
            return;
        }
        if (interfaceC0183d != null) {
            interfaceC0183d.a(false, null);
        }
        a(false, qVar, -1L, null);
    }

    private File a(String str, int i) {
        return new File(CacheDirFactory.getICacheDir(i).b(), str);
    }
}
