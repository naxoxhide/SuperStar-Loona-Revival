package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SettingsPropRepository.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements c {
    private final ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();
    private final Object d = new Object();
    private final Object e = new Object();
    private final CountDownLatch f = new CountDownLatch(1);
    private Properties g = new Properties();
    private volatile boolean h = false;
    private final String i;

    /* JADX INFO: compiled from: SettingsPropRepository.java */
    class a extends b.b.a.a.k.g {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.a(false);
        }
    }

    /* JADX INFO: compiled from: SettingsPropRepository.java */
    public class b implements c.InterfaceC0213c {
        private final Map<String, Object> a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f676b = new Object();

        public b() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public void commit() {
            Object obj;
            boolean z = false;
            com.bytedance.sdk.component.utils.m.a("SdkSettings.Prop", "commit: ", this.a);
            Properties properties = new Properties();
            synchronized (this.f676b) {
                properties.putAll(m.this.g);
                for (Map.Entry<String, Object> entry : this.a.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == this || value == null) {
                        if (properties.containsKey(key)) {
                            properties.remove(key);
                            z = true;
                        }
                    } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(value)) {
                        properties.put(key, String.valueOf(value));
                        z = true;
                    }
                }
                this.a.clear();
                if (z) {
                    m.this.a(properties);
                    m.this.g = properties;
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c putBoolean(String str, boolean z) {
            synchronized (this.f676b) {
                this.a.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c putFloat(String str, float f) {
            synchronized (this.f676b) {
                this.a.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c putInt(String str, int i) {
            synchronized (this.f676b) {
                this.a.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c putLong(String str, long j) {
            synchronized (this.f676b) {
                this.a.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c putString(String str, String str2) {
            synchronized (this.f676b) {
                this.a.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.c.InterfaceC0213c
        public c.InterfaceC0213c remove(String str) {
            synchronized (this.f676b) {
                this.a.put(str, this);
            }
            return this;
        }
    }

    public m(String str) {
        this.i = str;
        y.c(new a("SetL_" + str));
    }

    private File d() {
        return new File(o.a().getFilesDir(), this.i);
    }

    public c.InterfaceC0213c c() {
        return new b();
    }

    public boolean e() {
        return this.h;
    }

    public void b() {
        File fileD = d();
        if (fileD.exists()) {
            fileD.delete();
        }
    }

    public String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        a();
        return this.g.getProperty(str, str2);
    }

    private void a() {
        while (!this.h) {
            try {
                this.f.await();
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "awaitLoadedLocked: ", e);
            }
        }
    }

    public int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        a();
        try {
            return Integer.parseInt(this.g.getProperty(str, String.valueOf(i)));
        } catch (NumberFormatException e) {
            com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "", e);
            return i;
        }
    }

    public long a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        a();
        try {
            return Long.parseLong(this.g.getProperty(str, String.valueOf(j)));
        } catch (NumberFormatException e) {
            com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "", e);
            return j;
        }
    }

    public float a(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        a();
        try {
            return Float.parseFloat(this.g.getProperty(str, String.valueOf(f)));
        } catch (NumberFormatException e) {
            com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "", e);
            return f;
        }
    }

    public boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        a();
        try {
            return Boolean.parseBoolean(this.g.getProperty(str, String.valueOf(z)));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "", e);
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public void a(boolean z) {
        Object obj;
        synchronized (this.d) {
            if (this.h && !z) {
                com.bytedance.sdk.component.utils.m.a("SdkSettings.Prop", "reload: already loaded, ignore");
                return;
            }
            File fileD = d();
            boolean z2 = false;
            if (fileD.exists()) {
                Properties properties = new Properties();
                ?? r4 = 0;
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(fileD);
                        try {
                            properties.load(fileInputStream2);
                            String str = "SdkSettings.Prop";
                            com.bytedance.sdk.component.utils.m.a("SdkSettings.Prop", "reload: find", Integer.valueOf(properties.size()), "items from " + fileD.getAbsolutePath());
                            if (!properties.isEmpty()) {
                                this.g = properties;
                                this.c.clear();
                            }
                            com.bytedance.sdk.openadsdk.utils.g.a(fileInputStream2);
                            obj = this.d;
                            r4 = str;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "reload: ", e);
                            if (fileInputStream != null) {
                                com.bytedance.sdk.openadsdk.utils.g.a(fileInputStream);
                            }
                            obj = this.d;
                            r4 = fileInputStream;
                        } catch (Throwable th) {
                            th = th;
                            r4 = fileInputStream2;
                            if (r4 != 0) {
                                com.bytedance.sdk.openadsdk.utils.g.a(r4);
                            }
                            this.d.notifyAll();
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    obj.notifyAll();
                } catch (Throwable th2) {
                    th = th2;
                }
            } else if (r.c(o.a()) && "tt_sdk_settings.prop".equals(this.i)) {
                try {
                    SharedPreferences sharedPreferences = o.a().getSharedPreferences("tt_sdk_settings", 0);
                    if (!sharedPreferences.getAll().isEmpty()) {
                        c.InterfaceC0213c interfaceC0213cC = c();
                        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (!TextUtils.isEmpty(key) && value != null) {
                                interfaceC0213cC.putString(key, value.toString());
                                z2 = true;
                            }
                        }
                        if (z2) {
                            interfaceC0213cC.commit();
                        }
                        sharedPreferences.edit().clear().commit();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            this.h = true;
            this.f.countDown();
        }
    }

    public <T> T a(String str, T t, c.d<T> dVar) {
        T tA;
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        if (this.c.containsKey(str)) {
            try {
                return (T) this.c.get(str);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "", e);
                return t;
            }
        }
        a();
        String property = this.g.getProperty(str, null);
        if (property == null || dVar == null || (tA = dVar.a(property)) == null) {
            return t;
        }
        this.c.put(str, tA);
        return tA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public void a(Properties properties) {
        synchronized (this.e) {
            File fileD = d();
            ?? r2 = 0;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileD);
                    try {
                        properties.store(fileOutputStream2, (String) null);
                        Object[] objArr = {"saveToLocal: save to", fileD.getAbsolutePath(), "success"};
                        com.bytedance.sdk.component.utils.m.a("SdkSettings.Prop", objArr);
                        com.bytedance.sdk.openadsdk.utils.g.a(fileOutputStream2);
                        r2 = objArr;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        com.bytedance.sdk.component.utils.m.b("SdkSettings.Prop", "saveToLocal: ", e);
                        r2 = fileOutputStream;
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.g.a(fileOutputStream);
                            r2 = fileOutputStream;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r2 = fileOutputStream2;
                        if (r2 != 0) {
                            com.bytedance.sdk.openadsdk.utils.g.a(r2);
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        n.m0();
    }
}
