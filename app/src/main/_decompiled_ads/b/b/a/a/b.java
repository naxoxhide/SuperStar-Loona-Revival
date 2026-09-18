package b.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: TTPropHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static boolean j = false;
    private static ArrayMap<String, File> k;
    private static ArrayMap<File, b> l;
    private static ExecutorService m;
    private final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f68b;
    private Properties c;
    private volatile boolean d;
    private int e;
    private long f;
    private long g;
    private final File h;
    private final File i;

    /* JADX INFO: compiled from: TTPropHelper.java */
    class a extends Thread {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            b.this.d();
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TTPropHelper.java */
    class RunnableC0021b implements Runnable {
        RunnableC0021b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d();
        }
    }

    /* JADX INFO: compiled from: TTPropHelper.java */
    class c implements Runnable {
        final /* synthetic */ e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f69b;

        c(e eVar, boolean z) {
            this.a = eVar;
            this.f69b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this.f68b) {
                b.this.b(this.a, this.f69b);
            }
            synchronized (b.this.a) {
                b.e(b.this);
            }
        }
    }

    /* JADX INFO: compiled from: TTPropHelper.java */
    public static class d {
        public static void a(ExecutorService executorService) {
            ExecutorService unused = b.m = executorService;
        }
    }

    /* JADX INFO: compiled from: TTPropHelper.java */
    private static class e {
        final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Properties f70b;
        final CountDownLatch c;
        volatile boolean d;

        /* synthetic */ e(long j, Properties properties, a aVar) {
            this(j, properties);
        }

        void a(boolean z, boolean z2) {
            this.d = z2;
            this.c.countDown();
        }

        private e(long j, Properties properties) {
            this.c = new CountDownLatch(1);
            this.d = false;
            this.a = j;
            this.f70b = properties;
        }
    }

    private b(File file) {
        Object obj = new Object();
        this.a = obj;
        this.f68b = new Object();
        this.c = new Properties();
        this.d = false;
        this.e = 0;
        this.h = file;
        this.i = a(file);
        synchronized (obj) {
            this.d = false;
        }
        ExecutorService executorService = m;
        if (executorService == null) {
            new a("TTPropHelper").start();
        } else {
            executorService.execute(new RunnableC0021b());
        }
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.e;
        bVar.e = i + 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.e;
        bVar.e = i - 1;
        return i;
    }

    static /* synthetic */ long h(b bVar) {
        long j2 = bVar.f;
        bVar.f = 1 + j2;
        return j2;
    }

    public f c() {
        return new f();
    }

    public void d() {
        String str;
        String message;
        synchronized (this.a) {
            if (this.d) {
                if (j) {
                    Log.d("TTPropHelper", "reload: already loaded, ignore");
                }
                return;
            }
            if (this.i.exists()) {
                this.h.delete();
                this.i.renameTo(this.h);
            }
            if (j) {
                Log.d("TTPropHelper", "reload: " + this.h.getAbsolutePath() + ", exist? " + this.h.exists());
            }
            if (this.h.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(this.h);
                        try {
                            properties.load(fileInputStream2);
                            if (j) {
                                Log.d("TTPropHelper", "reload: find " + properties.size() + " ,items from " + this.h.getAbsolutePath());
                            }
                            if (!properties.isEmpty()) {
                                this.c = properties;
                            }
                            try {
                                fileInputStream2.close();
                            } catch (Throwable th) {
                                str = "TTPropHelper";
                                message = th.getMessage();
                                Log.w(str, message);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            Log.e("TTPropHelper", "reload: ", e);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th2) {
                                    str = "TTPropHelper";
                                    message = th2.getMessage();
                                    Log.w(str, message);
                                }
                            }
                            this.d = true;
                            this.a.notifyAll();
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th4) {
                                    Log.w("TTPropHelper", th4.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            this.d = true;
            this.a.notifyAll();
        }
    }

    private void b() {
        while (!this.d) {
            try {
                this.a.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: compiled from: TTPropHelper.java */
    public class f implements SharedPreferences.Editor {
        private final Object a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Object> f71b = new HashMap();
        private boolean c = false;

        public f() {
        }

        private e b() {
            Properties properties;
            long j;
            Object obj;
            boolean z;
            synchronized (b.this.a) {
                if (b.this.e > 0) {
                    Properties properties2 = new Properties();
                    properties2.putAll(b.this.c);
                    b.this.c = properties2;
                }
                properties = b.this.c;
                b.d(b.this);
                synchronized (this.a) {
                    boolean z2 = false;
                    if (this.c) {
                        if (properties.isEmpty()) {
                            z = false;
                        } else {
                            properties.clear();
                            z = true;
                        }
                        this.c = false;
                        z2 = z;
                    }
                    for (Map.Entry<String, Object> entry : this.f71b.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value == this || value == null) {
                            if (properties.containsKey(key)) {
                                properties.remove(key);
                                z2 = true;
                            }
                        } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                            properties.put(key, String.valueOf(value));
                            z2 = true;
                        }
                    }
                    this.f71b.clear();
                    if (z2) {
                        b.h(b.this);
                    }
                    j = b.this.f;
                }
            }
            return new e(j, properties, null);
        }

        public f a(String str, Set<String> set) {
            synchronized (this.a) {
                this.f71b.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            b.this.a(b(), false);
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long jCurrentTimeMillis = b.j ? System.currentTimeMillis() : 0L;
            e eVarB = b();
            b.this.a(eVarB, true);
            try {
                eVarB.c.await();
                return eVarB.d;
            } catch (InterruptedException unused) {
                return false;
            } finally {
                if (b.j) {
                    Log.d("TTPropHelper", b.this.h.getName() + CertificateUtil.DELIMITER + eVarB.a + " committed after " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public /* bridge */ /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return a(str, (Set<String>) set);
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f putInt(String str, int i) {
            synchronized (this.a) {
                this.f71b.put(str, Integer.valueOf(i));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f putLong(String str, long j) {
            synchronized (this.a) {
                this.f71b.put(str, Long.valueOf(j));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f putFloat(String str, float f) {
            synchronized (this.a) {
                this.f71b.put(str, Float.valueOf(f));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f putString(String str, String str2) {
            synchronized (this.a) {
                this.f71b.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f putBoolean(String str, boolean z) {
            synchronized (this.a) {
                this.f71b.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f remove(String str) {
            synchronized (this.a) {
                this.f71b.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f clear() {
            synchronized (this.a) {
                this.c = true;
            }
            return this;
        }
    }

    public static b a(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (b.class) {
            if (k == null) {
                k = new ArrayMap<>();
            }
            file = k.get(str);
            if (file == null) {
                file = new File(context.getFilesDir(), str);
                k.put(str, file);
            }
        }
        synchronized (b.class) {
            if (l == null) {
                l = new ArrayMap<>();
            }
            b bVar = l.get(file);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b(file);
            l.put(file, bVar2);
            return bVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(e eVar, boolean z) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        Throwable th;
        FileOutputStream fileOutputStream;
        long jCurrentTimeMillis3;
        String str;
        String message;
        boolean z2;
        long jCurrentTimeMillis4 = j ? System.currentTimeMillis() : 0L;
        boolean zExists = this.h.exists();
        if (j) {
            jCurrentTimeMillis = System.currentTimeMillis();
            jCurrentTimeMillis2 = jCurrentTimeMillis;
        } else {
            jCurrentTimeMillis = 0;
            jCurrentTimeMillis2 = 0;
        }
        if (zExists) {
            if (this.g >= eVar.a) {
                z2 = false;
            } else if (z) {
                z2 = true;
            } else {
                synchronized (this.a) {
                    z2 = this.f == eVar.a;
                }
            }
            if (!z2) {
                eVar.a(false, true);
                return;
            }
            boolean zExists2 = this.i.exists();
            if (j) {
                jCurrentTimeMillis2 = System.currentTimeMillis();
            }
            if (!zExists2) {
                if (!this.h.renameTo(this.i)) {
                    Log.e("TTPropHelper", "Couldn't rename file " + this.h + " to backup file " + this.i);
                    eVar.a(false, false);
                    return;
                }
            } else {
                this.h.delete();
            }
        }
        try {
            synchronized (this.f68b) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(this.h);
                        try {
                            try {
                                jCurrentTimeMillis3 = j ? System.currentTimeMillis() : 0L;
                                try {
                                    eVar.f70b.store(fileOutputStream, (String) null);
                                    if (j) {
                                        Log.d("TTPropHelper", "save: " + eVar.f70b);
                                        Log.d("TTPropHelper", "saveToLocal: save to" + this.h.getAbsolutePath() + "success");
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable th2) {
                                        str = "TTPropHelper";
                                        message = th2.getMessage();
                                        Log.w(str, message);
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    fileOutputStream2 = fileOutputStream;
                                    Log.e("TTPropHelper", "saveToLocal: ", e);
                                    eVar.a(false, false);
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (Throwable th3) {
                                            str = "TTPropHelper";
                                            message = th3.getMessage();
                                            Log.w(str, message);
                                        }
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                jCurrentTimeMillis3 = 0;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (Throwable th5) {
                                    Log.w("TTPropHelper", th5.getMessage());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    jCurrentTimeMillis3 = 0;
                }
            }
            long jCurrentTimeMillis5 = j ? System.currentTimeMillis() : 0L;
            this.i.delete();
            long jCurrentTimeMillis6 = j ? System.currentTimeMillis() : 0L;
            this.g = eVar.a;
            eVar.a(true, true);
            if (j) {
                Log.d("TTPropHelper", "write: " + (jCurrentTimeMillis - jCurrentTimeMillis4) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis2 - jCurrentTimeMillis4) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis3 - jCurrentTimeMillis4) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis5 - jCurrentTimeMillis4) + RemoteSettings.FORWARD_SLASH_STRING + (jCurrentTimeMillis6 - jCurrentTimeMillis4));
            }
        } catch (Throwable th7) {
            Log.w("TTPropHelper", "writeToFile: Got exception:", th7);
            if (this.h.exists() && !this.h.delete()) {
                Log.e("TTPropHelper", "Couldn't clean up partially-written file " + this.h);
            }
            eVar.a(false, false);
        }
    }

    static File a(File file) {
        return new File(file.getPath() + ".bak");
    }

    public String a(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.a) {
            b();
            property = this.c.getProperty(str, str2);
        }
        return property;
    }

    public int a(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        synchronized (this.a) {
            try {
                b();
                i2 = Integer.parseInt(this.c.getProperty(str, String.valueOf(i)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return i;
            }
        }
        return i2;
    }

    public long a(String str, long j2) {
        long j3;
        if (TextUtils.isEmpty(str)) {
            return j2;
        }
        synchronized (this.a) {
            try {
                b();
                j3 = Long.parseLong(this.c.getProperty(str, String.valueOf(j2)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return j2;
            }
        }
        return j3;
    }

    public float a(String str, float f2) {
        float f3;
        if (TextUtils.isEmpty(str)) {
            return f2;
        }
        synchronized (this.a) {
            try {
                b();
                f3 = Float.parseFloat(this.c.getProperty(str, String.valueOf(f2)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return f2;
            }
        }
        return f3;
    }

    public boolean a(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        synchronized (this.a) {
            try {
                b();
                z2 = Boolean.parseBoolean(this.c.getProperty(str, String.valueOf(z)));
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return z;
            }
        }
        return z2;
    }

    public boolean a(String str) {
        boolean zContainsKey;
        synchronized (this.a) {
            try {
                b();
                zContainsKey = this.c.containsKey(str);
            } catch (NumberFormatException e2) {
                Log.e("TTPropHelper", e2.getMessage());
                return false;
            }
        }
        return zContainsKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z) {
        boolean z2;
        c cVar = new c(eVar, z);
        if (z) {
            synchronized (this.a) {
                z2 = this.e == 1;
            }
            if (z2) {
                cVar.run();
                return;
            }
        }
        b.b.a.a.c.a(cVar, true ^ z);
    }
}
