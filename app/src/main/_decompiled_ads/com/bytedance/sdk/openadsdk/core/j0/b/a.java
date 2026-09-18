package com.bytedance.sdk.openadsdk.core.j0.b;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import androidx.webkit.ProxyConfig;
import b.b.a.a.k.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.z;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.y;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a f;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<q, e> f633b = Collections.synchronizedMap(new HashMap());
    private Map<String, JSONObject> c = Collections.synchronizedMap(new HashMap());
    private AtomicBoolean d = new AtomicBoolean(false);
    private Set<String> e = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlayableCache.java */
    class C0206a extends g {
        C0206a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] fileArrListFiles;
            try {
                String strA = a.this.a();
                if (!TextUtils.isEmpty(strA)) {
                    File file = new File(strA);
                    if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                        for (File file2 : fileArrListFiles) {
                            try {
                                a.this.a(a.this.b(file2), true);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
            a.this.d.set(true);
        }
    }

    /* JADX INFO: compiled from: PlayableCache.java */
    class c implements Runnable {
        final /* synthetic */ d a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f635b;

        c(a aVar, d dVar, boolean z) {
            this.a = dVar;
            this.f635b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(this.f635b);
            }
        }
    }

    /* JADX INFO: compiled from: PlayableCache.java */
    public interface d {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: PlayableCache.java */
    private static class e {
        long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f636b;
        long c;
        long d;

        private e() {
        }

        public long a() {
            return this.f636b - this.a;
        }

        public long b() {
            return this.d - this.c;
        }

        public e c(long j) {
            this.d = j;
            return this;
        }

        public e d(long j) {
            this.c = j;
            return this;
        }

        /* synthetic */ e(C0206a c0206a) {
            this();
        }

        public e a(long j) {
            this.f636b = j;
            return this;
        }

        public e b(long j) {
            this.a = j;
            return this;
        }
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(File file) {
        d(file);
        try {
            h.a().g().a(file);
        } catch (Throwable unused) {
        }
    }

    private boolean c(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    public void d() {
        if (this.d.get()) {
            return;
        }
        y.b(new C0206a("PlayableCache_init"));
    }

    public static a b() {
        if (f == null) {
            synchronized (a.class) {
                if (f == null) {
                    f = new a();
                }
            }
        }
        return f;
    }

    private String c() {
        if (TextUtils.isEmpty(this.a)) {
            try {
                File file = new File(o.a().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.a = file.getAbsolutePath();
            } catch (Throwable th) {
                m.b("PlayableCache", "init root path error: " + th);
            }
        }
        return this.a;
    }

    private void d(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    public boolean a(q qVar) {
        if (this.d.get() && qVar != null && qVar.N0() != null && qVar.N0().l() != null) {
            try {
                String strA = com.bytedance.sdk.component.utils.e.a(qVar.N0().l());
                if (this.c.get(strA) == null) {
                    return false;
                }
                return a(new File(a(), strA));
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return c(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(File file, boolean z) {
        byte[] bArrD;
        String strA;
        try {
            if (!c(file) || (bArrD = com.bytedance.sdk.component.utils.g.d(file)) == null || bArrD.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat")) {
                strA = com.bytedance.sdk.component.utils.a.a(new String(bArrD));
            } else {
                strA = b.b.a.a.g.a.a(new String(bArrD), com.bytedance.sdk.openadsdk.core.a.c());
            }
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strA);
            if (z && jSONObject.length() > 0) {
                this.c.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public WebResourceResponse a(String str, String str2, String str3) {
        try {
            if (!this.d.get() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                if (str3.startsWith(ProxyConfig.MATCH_HTTP) && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
            String strA = com.bytedance.sdk.component.utils.o.a(o.a(), str3);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            String strA2 = com.bytedance.sdk.component.utils.e.a(str);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            File file = new File(a(), strA2);
            if (a(file)) {
                String strA3 = a(str2);
                if (TextUtils.isEmpty(strA3)) {
                    return null;
                }
                String strReplace = str3.replace(strA3, "");
                if (TextUtils.isEmpty(strReplace)) {
                    return null;
                }
                File file2 = new File(file, strReplace);
                if (a(strA2, strReplace, file2) && file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                    return new WebResourceResponse(strA, "utf-8", new FileInputStream(file2));
                }
            }
        } catch (Throwable th) {
            m.b("PlayableCache", "playable intercept error: ", th);
        }
        return null;
    }

    /* JADX INFO: compiled from: PlayableCache.java */
    class b extends b.b.a.a.j.c.a {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ q f634b;
        final /* synthetic */ File c;
        final /* synthetic */ d d;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.j0.b.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: PlayableCache.java */
        class C0207a extends g {
            final /* synthetic */ e c;
            final /* synthetic */ b.b.a.a.j.b d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0207a(String str, e eVar, b.b.a.a.j.b bVar) {
                super(str);
                this.c = eVar;
                this.d = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                long jB;
                boolean z = true;
                try {
                    e eVar = this.c;
                    if (eVar != null) {
                        eVar.d(System.currentTimeMillis());
                    }
                    z.a(this.d.d().getAbsolutePath(), a.this.a());
                    e eVar2 = this.c;
                    if (eVar2 != null) {
                        eVar2.c(System.currentTimeMillis());
                    }
                    e eVar3 = this.c;
                    long jA = 0;
                    if (eVar3 != null) {
                        jA = eVar3.a();
                        jB = this.c.b();
                    } else {
                        jB = 0;
                    }
                    com.bytedance.sdk.openadsdk.core.j0.b.b.a(b.this.f634b, jA, jB);
                    b bVar = b.this;
                    a.this.e(bVar.c);
                    try {
                        b bVar2 = b.this;
                        a.this.a(a.this.b(bVar2.c), true);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    m.b("PlayableCache", "unzip error: ", th);
                    com.bytedance.sdk.openadsdk.core.j0.b.b.a(b.this.f634b, -704, th.getMessage());
                    z = false;
                }
                try {
                    this.d.d().delete();
                } catch (Throwable unused2) {
                }
                b bVar3 = b.this;
                a.this.a(bVar3.d, z);
            }
        }

        b(String str, q qVar, File file, d dVar) {
            this.a = str;
            this.f634b = qVar;
            this.c = file;
            this.d = dVar;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            a.this.e.remove(this.a);
            e eVar = (e) a.this.f633b.remove(this.f634b);
            if (eVar != null) {
                eVar.a(System.currentTimeMillis());
            }
            if (bVar.g() && bVar.d() != null && bVar.d().exists()) {
                m.d("PlayableCache", "onResponse: Playable zip download success");
                y.c(new C0207a("downloadZip", eVar, bVar));
            } else {
                com.bytedance.sdk.openadsdk.core.j0.b.b.a(this.f634b, bVar.b() != 0 ? bVar.b() : -700, (String) null);
                m.d("PlayableCache", "onResponse: Playable zip download fail");
                a.this.a(this.d, false);
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            a.this.e.remove(this.a);
            a.this.f633b.remove(this.f634b);
            com.bytedance.sdk.openadsdk.core.j0.b.b.a(this.f634b, -700, iOException.getMessage());
            a.this.a(this.d, false);
            m.d("PlayableCache", "onFailure: Playable zip download fail");
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("\\?");
        if (strArrSplit != null && strArrSplit.length == 2) {
            if (strArrSplit[0] != null && strArrSplit[0].endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str = str.substring(0, strArrSplit.length - 1);
            }
            if (strArrSplit[0] != null && strArrSplit[0].endsWith("index.html")) {
                str = strArrSplit[0];
            }
        }
        return str.replace("index.html", "");
    }

    private boolean a(String str, String str2, File file) {
        JSONObject jSONObject;
        String strOptString;
        return (file == null || !file.exists() || (jSONObject = this.c.get(str)) == null || (strOptString = jSONObject.optString(str2)) == null || !strOptString.equalsIgnoreCase(com.bytedance.sdk.component.utils.e.a(file))) ? false : true;
    }

    public void a(q qVar, d dVar) {
        C0206a c0206a = null;
        if (qVar != null && qVar.N0() != null && !TextUtils.isEmpty(qVar.N0().l())) {
            String strL = qVar.N0().l();
            if (this.e.contains(strL)) {
                return;
            }
            this.f633b.put(qVar, new e(c0206a).b(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.core.j0.b.b.a(qVar);
            String strA = com.bytedance.sdk.component.utils.e.a(strL);
            File file = new File(a(), strA);
            if (a(file)) {
                com.bytedance.sdk.openadsdk.core.j0.b.b.a(qVar, -702, (String) null);
                d(file);
                this.f633b.remove(qVar);
                a(dVar, true);
                return;
            }
            try {
                com.bytedance.sdk.component.utils.g.a(file);
            } catch (Throwable unused) {
            }
            this.e.add(strL);
            File file2 = new File(c(), strA + ".zip");
            b.b.a.a.j.d.a aVarA = com.bytedance.sdk.openadsdk.n.c.b().d().a();
            aVarA.b(strL);
            aVarA.b(file2.getParent(), file2.getName());
            aVarA.a(new b(strL, qVar, file, dVar));
            return;
        }
        com.bytedance.sdk.openadsdk.core.j0.b.b.a(qVar, -701, (String) null);
        a(dVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, boolean z) {
        y.a(new c(this, dVar, z));
    }

    private boolean a(File file) {
        String[] list;
        if (file == null || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return false;
        }
        return Arrays.asList(list).contains("index.html");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        File file = new File(c(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
