package b.a.a.a.a.a.b.c.q;

import android.text.TextUtils;
import b.a.a.a.a.a.b.c.d;
import b.a.a.a.a.a.b.c.e;
import b.a.a.a.a.a.b.c.f;
import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: VideoCachePreloader.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private b a;

    /* JADX INFO: compiled from: VideoCachePreloader.java */
    private static class c {
        private static final a a = new a();
    }

    static {
        b.a.a.a.a.a.a.i.c.b();
    }

    public static a b() {
        return c.a;
    }

    private static b.a.a.a.a.a.b.c.l.c c() {
        b.a.a.a.a.a.b.c.l.c cVar;
        File file = new File(b.a.a.a.a.a.a.c.a().getCacheDir(), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            cVar = new b.a.a.a.a.a.b.c.l.c(file);
            try {
                cVar.a(104857600L);
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e = e2;
            cVar = null;
        }
        return cVar;
    }

    public boolean a() {
        if (this.a != null) {
            return true;
        }
        b.a.a.a.a.a.b.c.l.c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.f().i();
        try {
            b bVar = new b(this);
            this.a = bVar;
            bVar.setName("csj_video_cache_preloader");
            this.a.start();
            e.a(cVarC, b.a.a.a.a.a.a.c.a());
            d.d().a(30000L, 30000L, 30000L);
            d.d().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private a() {
        new HashMap();
        a();
    }

    public String b(b.a.a.a.a.a.a.f.c cVar) {
        if (cVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(cVar.e());
        return f.f().a(false, z, z ? cVar.e() : cVar.m(), cVar.m());
    }

    /* JADX INFO: compiled from: VideoCachePreloader.java */
    class b extends Thread {
        private final Queue<C0017a> c = new ArrayBlockingQueue(10);
        private Queue<C0017a> a = new LinkedBlockingQueue();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f56b = true;
        private Queue<C0017a> d = new LinkedBlockingQueue();

        /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.q.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VideoCachePreloader.java */
        private class C0017a {
            public int a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f57b;
            public String[] c;
            public int d;
            public String e;
            public b.a.a.a.a.a.a.f.c f;

            public C0017a(b bVar) {
            }
        }

        public b(a aVar) {
        }

        private C0017a a(int i, b.a.a.a.a.a.a.f.c cVar) {
            a();
            m.a("VideoCachePreloader", "pool: " + this.c.size());
            C0017a c0017aPoll = this.c.poll();
            if (c0017aPoll == null) {
                c0017aPoll = new C0017a(this);
            }
            c0017aPoll.a = i;
            c0017aPoll.f = cVar;
            return c0017aPoll;
        }

        private void a() {
        }

        private void b() {
        }

        private void b(C0017a c0017a) {
            b();
            if (c0017a == null) {
                return;
            }
            this.a.offer(c0017a);
            notify();
        }

        private void c(C0017a c0017a) {
            b();
            c0017a.c = null;
            c0017a.f57b = null;
            c0017a.a = -1;
            c0017a.f = null;
            this.c.offer(c0017a);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f56b) {
                synchronized (this) {
                    if (!this.d.isEmpty()) {
                        c();
                    }
                    while (!this.a.isEmpty()) {
                        C0017a c0017aPoll = this.a.poll();
                        if (c0017aPoll != null) {
                            int i = c0017aPoll.a;
                            if (i == 0) {
                                String[] strArr = c0017aPoll.c;
                                if (strArr != null && strArr.length > 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (String str : c0017aPoll.c) {
                                        if (b.a.a.a.a.a.b.d.a.a(str)) {
                                            arrayList.add(str);
                                        }
                                    }
                                    d.d().a(false, !TextUtils.isEmpty(c0017aPoll.e), c0017aPoll.d, c0017aPoll.f57b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                }
                            } else if (i == 1) {
                                d.d().a(c0017aPoll.f57b);
                            } else if (i == 2) {
                                d.d().a();
                            } else if (i == 3) {
                                d.d().a();
                                if (e.c() != null) {
                                    e.c().a();
                                    throw null;
                                }
                                if (e.d() != null) {
                                    e.d().b();
                                }
                            } else if (i == 4) {
                                d.d().a();
                                this.f56b = false;
                            }
                            c(c0017aPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            b();
            while (true) {
                C0017a c0017aPoll = this.d.poll();
                if (c0017aPoll == null) {
                    return;
                }
                c0017aPoll.f57b = c0017aPoll.f.m();
                c0017aPoll.c = new String[]{c0017aPoll.f.m()};
                int iG = c0017aPoll.f.g();
                if (iG <= 0) {
                    iG = c0017aPoll.f.j();
                }
                c0017aPoll.d = iG;
                c0017aPoll.e = c0017aPoll.f.e();
                if (!TextUtils.isEmpty(c0017aPoll.f.e())) {
                    c0017aPoll.f57b = c0017aPoll.f.e();
                }
                c0017aPoll.f = null;
                b(c0017aPoll);
            }
        }

        private synchronized void a(C0017a c0017a) {
            a();
            this.d.add(c0017a);
            notify();
        }

        public void a(b.a.a.a.a.a.a.f.c cVar) {
            a(a(0, cVar));
        }
    }

    public boolean a(b.a.a.a.a.a.a.f.c cVar) {
        if (!a()) {
            return false;
        }
        this.a.a(cVar);
        return true;
    }
}
