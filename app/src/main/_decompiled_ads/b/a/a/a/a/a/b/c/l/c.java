package b.a.a.a.a.a.b.c.l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b.a.a.a.a.a.b.c.l.a {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, File> f49b = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock c;
    private final ReentrantReadWriteLock.ReadLock d;
    private final ReentrantReadWriteLock.WriteLock e;
    private final Set<f> f;
    private volatile long g;
    private volatile float h;
    private final g i;
    private final Runnable j;
    private final Handler k;

    /* JADX INFO: compiled from: DiskLruCache.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.l.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DiskLruCache.java */
        class C0014a extends b.b.a.a.k.g {
            C0014a(String str, int i) {
                super(str, i);
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.b(cVar.g);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.k.e.c(new C0014a("cleanupCmd", 1));
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    class b extends b.b.a.a.k.g {
        b(String str, int i) {
            super(str, i);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.c();
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.l.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    class C0015c implements Comparator<File> {
        final /* synthetic */ HashMap a;

        C0015c(c cVar, HashMap map) {
            this.a = map;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long jLongValue = ((Long) this.a.get(file)).longValue() - ((Long) this.a.get(file2)).longValue();
            if (jLongValue < 0) {
                return -1;
            }
            return jLongValue > 0 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    class d extends b.b.a.a.k.g {
        d(String str, int i) {
            super(str, i);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(0L);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    class e extends b.b.a.a.k.g {
        final /* synthetic */ HashSet c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(c cVar, String str, int i, HashSet hashSet) {
            super(str, i);
            this.c = hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    ((File) it.next()).delete();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public interface f {
        void a(String str);

        void a(Set<String> set);
    }

    public c(File file) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.g = 104857600L;
        this.h = 0.5f;
        this.i = new g(null);
        this.j = new a();
        this.k = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            throw new IOException("dir error!  " + (file == null ? " dir null" : "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite()));
        }
        this.a = file;
        b.b.a.a.k.e.c(new b("DiskLruCache", 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e.lock();
        try {
            File[] fileArrListFiles = this.a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new C0015c(this, map));
                for (File file2 : arrayList) {
                    this.f49b.put(a(file2), file2);
                }
            }
            this.e.unlock();
            a();
        } catch (Throwable th) {
            this.e.unlock();
            throw th;
        }
    }

    @Override // b.a.a.a.a.a.b.c.l.a
    public File d(String str) {
        if (!this.d.tryLock()) {
            return null;
        }
        File file = this.f49b.get(str);
        this.d.unlock();
        return file;
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class g {
        private final Map<String, Integer> a;

        private g() {
            this.a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.a.get(str);
                if (num == null) {
                    this.a.put(str, 1);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.a.containsKey(str);
        }

        synchronized void c(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.a.remove(str);
                } else {
                    this.a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    public void b() {
        b.a.a.a.a.a.b.c.d.d().a();
        Context contextB = b.a.a.a.a.a.b.c.e.b();
        if (contextB != null) {
            b.a.a.a.a.a.b.c.m.c.a(contextB).b(0);
        }
        this.k.removeCallbacks(this.j);
        b.b.a.a.k.e.c(new d("clear", 1));
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.f.add(fVar);
        }
    }

    public void a(long j) {
        this.g = j;
        a();
    }

    private void a() {
        this.k.removeCallbacks(this.j);
        this.k.postDelayed(this.j, 10000L);
    }

    @Override // b.a.a.a.a.a.b.c.l.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.a(str);
    }

    private String a(File file) {
        return file.getName();
    }

    @Override // b.a.a.a.a.a.b.c.l.a
    public File b(String str) {
        this.d.lock();
        File file = this.f49b.get(str);
        this.d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.a, str);
        this.e.lock();
        this.f49b.put(str, file2);
        this.e.unlock();
        Iterator<f> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
        a();
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x00de A[LOOP:3: B:40:0x00d8->B:42:0x00de, LOOP_END] */
    public void b(long j) {
        HashSet hashSet;
        Iterator<f> it;
        HashSet hashSet2 = new HashSet();
        this.e.lock();
        try {
            Iterator<Map.Entry<String, File>> it2 = this.f49b.entrySet().iterator();
            long length = 0;
            while (it2.hasNext()) {
                length += it2.next().getValue().length();
            }
            try {
                if (length <= j) {
                    this.e.unlock();
                    return;
                }
                long j2 = (long) (j * this.h);
                hashSet = new HashSet();
                try {
                    for (Map.Entry<String, File> entry : this.f49b.entrySet()) {
                        File value = entry.getValue();
                        if (value != null && value.exists()) {
                            if (!this.i.b(a(value))) {
                                long length2 = value.length();
                                File file = new File(value.getAbsolutePath() + "-tmp");
                                if (value.renameTo(file)) {
                                    hashSet2.add(file);
                                    length -= length2;
                                    hashSet.add(entry.getKey());
                                }
                            }
                        } else {
                            hashSet.add(entry.getKey());
                        }
                        if (length <= j2) {
                            break;
                        }
                    }
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        this.f49b.remove((String) it3.next());
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
                this.e.unlock();
                it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().a(hashSet);
                }
                b.b.a.a.k.e.c(new e(this, "trimSize", 1, hashSet2));
                th.printStackTrace();
                this.e.unlock();
                it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().a(hashSet);
                }
                b.b.a.a.k.e.c(new e(this, "trimSize", 1, hashSet2));
            } catch (Throwable th2) {
                this.e.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            hashSet = null;
        }
    }

    @Override // b.a.a.a.a.a.b.c.l.a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.c(str);
    }
}
