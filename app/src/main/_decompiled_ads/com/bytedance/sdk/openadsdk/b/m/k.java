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

/* JADX INFO: compiled from: RewardVideoCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static volatile k d;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f480b;
    private final Map<q, Long> c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: compiled from: RewardVideoCache.java */
    class a implements FileFilter {
        a(k kVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                return file.getName().contains("sp_reward_video");
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: RewardVideoCache.java */
    class b implements FileFilter {
        b(k kVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                return file.getName().contains("reward_video_cache");
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: RewardVideoCache.java */
    interface d<T> {
        void a(boolean z, T t);
    }

    private k(Context context) {
        this.a = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context.getApplicationContext();
        this.f480b = new m("sp_reward_video");
    }

    public AdSlot b(String str) {
        return this.f480b.c(str);
    }

    public com.bytedance.sdk.openadsdk.core.f0.a c(String str) {
        com.bytedance.sdk.openadsdk.core.f0.a aVarA;
        long jE = this.f480b.e(str);
        boolean zF = this.f480b.f(str);
        if ((System.currentTimeMillis() - jE < 10500000) && !zF) {
            try {
                String strB = this.f480b.b(str);
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
        this.f480b.a(str);
    }

    public void b(AdSlot adSlot) {
        this.f480b.b(adSlot);
    }

    public void a() {
        File[] fileArrListFiles;
        File file;
        File[] fileArrListFiles2;
        try {
            int i = Build.VERSION.SDK_INT;
            boolean z = i >= 19 && com.bytedance.sdk.openadsdk.core.h.e("sp_reward_video");
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
        return this.f480b.a();
    }

    public String b(q qVar) {
        if (qVar == null || qVar.N0() == null || TextUtils.isEmpty(qVar.N0().t())) {
            return null;
        }
        return a(qVar.N0().t(), qVar.N0().h(), qVar.u0());
    }

    /* JADX INFO: compiled from: RewardVideoCache.java */
    class c extends b.b.a.a.j.c.a {
        final /* synthetic */ d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f481b;

        c(d dVar, q qVar) {
            this.a = dVar;
            this.f481b = qVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            if (bVar.g() && bVar.d() != null && bVar.d().exists()) {
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(true, null);
                }
                com.bytedance.sdk.component.utils.m.d("RewardVideoCache", "onFailure: RewardVideo preload success ");
                k.this.a(true, this.f481b, bVar.b(), bVar.f());
                return;
            }
            d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.a(false, null);
            }
            com.bytedance.sdk.component.utils.m.d("RewardVideoCache", "onFailure: RewardVideo preload fail ");
            k.this.a(false, this.f481b, bVar.b(), bVar.f());
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(false, null);
            }
            com.bytedance.sdk.component.utils.m.d("RewardVideoCache", "onFailure: RewardVideo preload fail ");
            k.this.a(false, this.f481b, -2L, iOException.getMessage());
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.f0.a aVar) {
        if (aVar == null || aVar.g()) {
            return;
        }
        synchronized (aVar) {
            if (!aVar.g()) {
                b(adSlot);
                try {
                    this.f480b.a(adSlot.getCodeId(), aVar.k().toString());
                } catch (Throwable unused) {
                    aVar.j();
                }
            }
        }
    }

    public void a(AdSlot adSlot) {
        this.f480b.a(adSlot);
    }

    public static k a(Context context) {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k(context);
                }
            }
        }
        return d;
    }

    public String a(String str, String str2, int i) {
        File fileA;
        if (!TextUtils.isEmpty(str) && (fileA = a(str2, i)) != null && fileA.exists() && fileA.isFile() && fileA.length() > 0) {
            return fileA.getAbsolutePath();
        }
        return null;
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
        com.bytedance.sdk.openadsdk.d.c.b(qVar, "rewarded_video", z ? "load_video_success" : "load_video_error", a0.a(z, qVar, lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue(), j, (z || str == null) ? null : str));
    }

    public void a(q qVar, d<Object> dVar) {
        this.c.put(qVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (qVar != null && qVar.N0() != null && !TextUtils.isEmpty(qVar.N0().t())) {
            String strT = qVar.N0().t();
            File fileA = a(qVar.N0().h(), qVar.u0());
            b.b.a.a.j.d.a aVarA = com.bytedance.sdk.openadsdk.n.c.b().d().a();
            aVarA.b(strT);
            aVarA.b(fileA.getParent(), fileA.getName());
            aVarA.a(new c(dVar, qVar));
            return;
        }
        if (dVar != null) {
            dVar.a(false, null);
        }
        a(false, qVar, -1L, null);
    }

    private File a(String str, int i) {
        return new File(CacheDirFactory.getICacheDir(i).b(), str);
    }
}
