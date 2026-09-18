package b.a.a.a.a.a.b.c;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Preloader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static volatile d n;
    private volatile int a = 163840;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<Map<String, b.a.a.a.a.a.b.c.b>> f35b;
    private final g<Runnable> c;
    private final ExecutorService d;
    private volatile b.a.a.a.a.a.b.c.m.c e;
    private volatile b.a.a.a.a.a.b.c.l.c f;
    private volatile b.a.a.a.a.a.b.c.l.b g;
    private final HashSet<f> h;
    private final b.a.a.a.a.a.b.c.b.InterfaceC0012b i;
    private volatile b.a.a.a.a.a.b.c.c j;
    private volatile b.a.a.a.a.a.b.c.c k;
    private volatile String l;
    private volatile boolean m;

    /* JADX INFO: compiled from: Preloader.java */
    class a implements b.a.a.a.a.a.b.c.b.InterfaceC0012b {
        a() {
        }

        @Override // b.a.a.a.a.a.b.c.b.InterfaceC0012b
        public void a(b.a.a.a.a.a.b.c.b bVar) {
            int iD = bVar.d();
            synchronized (d.this.f35b) {
                Map map = (Map) d.this.f35b.get(iD);
                if (map != null) {
                    map.remove(bVar.h);
                }
            }
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.h);
            }
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    class b extends b.b.a.a.k.g {
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, boolean z, boolean z2, String str2) {
            super(str);
            this.c = z;
            this.d = z2;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a.a.a.a.a.b.c.b bVar;
            synchronized (d.this.f35b) {
                Map map = (Map) d.this.f35b.get(b.a.a.a.a.a.b.c.m.b.a(this.c));
                if (map != null) {
                    bVar = (b.a.a.a.a.a.b.c.b) map.remove(this.d ? this.e : b.a.a.a.a.a.a.i.b.a(this.e));
                } else {
                    bVar = null;
                }
            }
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    class c extends b.b.a.a.k.g {
        c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<b.a.a.a.a.a.b.c.b> arrayList = new ArrayList();
            synchronized (d.this.f35b) {
                int size = d.this.f35b.size();
                for (int i = 0; i < size; i++) {
                    Map map = (Map) d.this.f35b.get(d.this.f35b.keyAt(i));
                    if (map != null) {
                        arrayList.addAll(map.values());
                        map.clear();
                    }
                }
                d.this.c.clear();
            }
            for (b.a.a.a.a.a.b.c.b bVar : arrayList) {
                bVar.b();
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Preloader.java */
    static class ThreadFactoryC0013d implements ThreadFactory {

        /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.d$d$a */
        /* JADX INFO: compiled from: Preloader.java */
        class a extends Thread {
            a(ThreadFactoryC0013d threadFactoryC0013d, Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                super.run();
            }
        }

        ThreadFactoryC0013d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(this, runnable);
            aVar.setName("csj_video_preload_" + aVar.getId());
            aVar.setDaemon(true);
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.i("TAG_PROXY_Preloader", "new preload thead: " + aVar.getName());
            }
            return aVar;
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    static class e implements RejectedExecutionHandler {
        final /* synthetic */ g a;

        e(g gVar) {
            this.a = gVar;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                this.a.offerFirst(runnable);
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    private static final class f {
        final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f36b;
        final int c;
        final String d;
        final Map<String, String> e;
        final String[] f;

        f(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.a = z;
            this.f36b = z2;
            this.c = i;
            this.d = str;
            this.e = map;
            this.f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            if (this.a == fVar.a && this.f36b == fVar.f36b && this.c == fVar.c) {
                return this.d.equals(fVar.d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.a ? 1 : 0) * 31) + (this.f36b ? 1 : 0)) * 31) + this.c) * 31) + this.d.hashCode();
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    private static final class g<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor a;

        private g() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.a = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.a.getPoolSize();
                int activeCount = this.a.getActiveCount();
                int maximumPoolSize = this.a.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t);
                }
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.i("TAG_PROXY_TT", "create new preloader thread");
                }
                return false;
            }
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    private d() {
        SparseArray<Map<String, b.a.a.a.a.a.b.c.b>> sparseArray = new SparseArray<>(2);
        this.f35b = sparseArray;
        this.h = new HashSet<>();
        this.i = new a();
        g<Runnable> gVar = new g<>(null);
        this.c = gVar;
        ExecutorService executorServiceA = a(gVar);
        this.d = executorServiceA;
        gVar.a((ThreadPoolExecutor) executorServiceA);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static d d() {
        if (n == null) {
            synchronized (d.class) {
                if (n == null) {
                    n = new d();
                }
            }
        }
        return n;
    }

    public synchronized void a(long j, long j2, long j3) {
    }

    b.a.a.a.a.a.b.c.c c() {
        return this.k;
    }

    void a(b.a.a.a.a.a.b.c.l.c cVar) {
        this.f = cVar;
    }

    b.a.a.a.a.a.b.c.c b() {
        return this.j;
    }

    void a(b.a.a.a.a.a.b.c.m.c cVar) {
        this.e = cVar;
    }

    public void a(int i) {
        if (i > 0) {
            this.a = i;
        }
        if (b.a.a.a.a.a.b.c.e.d) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i);
        }
    }

    void a(boolean z, String str) throws Throwable {
        b.a.a.a.a.a.b.c.b bVarRemove;
        this.l = str;
        this.m = z;
        if (b.a.a.a.a.a.b.c.e.d) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet<b.a.a.a.a.a.b.c.b> hashSet = null;
        HashSet<f> hashSet2 = null;
        if (str == null) {
            synchronized (this.h) {
                if (!this.h.isEmpty()) {
                    hashSet2 = new HashSet(this.h);
                    this.h.clear();
                }
            }
            if (hashSet2 != null) {
                for (f fVar : hashSet2) {
                    a(fVar.a, fVar.f36b, fVar.c, fVar.d, fVar.e, fVar.f);
                    if (b.a.a.a.a.a.b.c.e.d) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + fVar.d);
                    }
                }
                return;
            }
            return;
        }
        int i = b.a.a.a.a.a.b.c.e.j;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.f35b) {
                    Map<String, b.a.a.a.a.a.b.c.b> map = this.f35b.get(b.a.a.a.a.a.b.c.m.b.a(z));
                    bVarRemove = map != null ? map.remove(str) : null;
                }
                if (bVarRemove != null) {
                    bVarRemove.b();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f35b) {
            int size = this.f35b.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Map<String, b.a.a.a.a.a.b.c.b>> sparseArray = this.f35b;
                Map<String, b.a.a.a.a.a.b.c.b> map2 = sparseArray.get(sparseArray.keyAt(i2));
                if (map2 != null) {
                    Collection<b.a.a.a.a.a.b.c.b> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (b.a.a.a.a.a.b.c.b bVar : hashSet) {
            bVar.b();
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.g);
            }
        }
        if (i == 3) {
            synchronized (this.h) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    f fVar2 = (f) ((b.a.a.a.a.a.b.c.b) it.next()).r;
                    if (fVar2 != null) {
                        this.h.add(fVar2);
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i, String str, String... strArr) throws Throwable {
        a(z, z2, i, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) throws Throwable {
        SparseArray<Map<String, b.a.a.a.a.a.b.c.b>> sparseArray;
        boolean z3 = b.a.a.a.a.a.b.c.e.d;
        if (z3) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        b.a.a.a.a.a.b.c.l.a aVar = z ? this.g : this.f;
        b.a.a.a.a.a.b.c.m.c cVar = this.e;
        if (aVar == null || cVar == null) {
            if (z3) {
                Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.a : i;
        String strA = z2 ? str : b.a.a.a.a.a.a.i.b.a(str);
        File fileD = aVar.d(strA);
        if (fileD != null && fileD.length() >= i2) {
            if (z3) {
                Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + fileD.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        if (b.a.a.a.a.a.b.c.f.f().a(b.a.a.a.a.a.b.c.m.b.a(z), strA)) {
            if (z3) {
                Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                return;
            }
            return;
        }
        SparseArray<Map<String, b.a.a.a.a.a.b.c.b>> sparseArray2 = this.f35b;
        synchronized (sparseArray2) {
            try {
                Map<String, b.a.a.a.a.a.b.c.b> map2 = this.f35b.get(z ? 1 : 0);
                if (!map2.containsKey(strA)) {
                    sparseArray = sparseArray2;
                    try {
                        f fVar = new f(z, z2, i2, str, map, strArr);
                        String str2 = this.l;
                        if (str2 != null) {
                            int i3 = b.a.a.a.a.a.b.c.e.j;
                            if (i3 == 3) {
                                synchronized (this.h) {
                                    this.h.add(fVar);
                                }
                                if (z3) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                                }
                                return;
                            }
                            if (i3 == 2) {
                                if (z3) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                                }
                                return;
                            } else if (i3 == 1 && this.m == z && str2.equals(strA)) {
                                if (z3) {
                                    Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                                }
                                return;
                            }
                        }
                        ArrayList arrayList = null;
                        List<i.b> listA = b.a.a.a.a.a.b.d.a.a(b.a.a.a.a.a.b.d.a.a(map));
                        if (listA != null) {
                            arrayList = new ArrayList(listA.size());
                            int size = listA.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                i.b bVar = listA.get(i4);
                                if (bVar != null) {
                                    arrayList.add(new i.b(bVar.a, bVar.f44b));
                                }
                            }
                        }
                        b.a.a.a.a.a.b.c.b bVarA = new b.a.a.a.a.a.b.c.b.a().a(aVar).a(cVar).b(str).a(strA).a(new k(b.a.a.a.a.a.b.d.a.a(strArr))).a((List<i.b>) arrayList).a(i2).a(this.i).a(fVar).a();
                        map2.put(strA, bVarA);
                        this.d.execute(bVarA);
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                sparseArray = sparseArray2;
            }
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(boolean z, boolean z2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b.a.a.a.a.a.b.d.a.a((b.b.a.a.k.g) new b("cancel b b S", z, z2, str));
    }

    public void a() {
        b.a.a.a.a.a.b.d.a.a((b.b.a.a.k.g) new c("cancelAll"));
    }

    private static ExecutorService a(g<Runnable> gVar) {
        int i;
        int iA = b.a.a.a.a.a.b.d.a.a();
        if (iA < 1) {
            i = 1;
        } else {
            i = iA > 4 ? 4 : iA;
        }
        return new ThreadPoolExecutor(0, i, 60L, TimeUnit.SECONDS, gVar, new ThreadFactoryC0013d(), new e(gVar));
    }
}
