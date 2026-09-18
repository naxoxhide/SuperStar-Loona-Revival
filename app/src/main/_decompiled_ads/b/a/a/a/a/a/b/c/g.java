package b.a.a.a.a.a.b.c;

import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: ProxyTask.java */
/* JADX INFO: loaded from: classes.dex */
class g extends b.a.a.a.a.a.b.c.a {
    private final Socket o;
    private final e p;
    private final b.a.a.a.a.a.b.c.d q;
    private volatile b.a.a.a.a.a.b.c.b r;
    private volatile boolean s;

    /* JADX INFO: compiled from: ProxyTask.java */
    class a implements b.a.a.a.a.a.b.c.b.InterfaceC0012b {
        a() {
        }

        @Override // b.a.a.a.a.a.b.c.b.InterfaceC0012b
        public void a(b.a.a.a.a.a.b.c.b bVar) throws Throwable {
            g.this.c.addAndGet(bVar.c.get());
            g.this.d.addAndGet(bVar.d.get());
            synchronized (bVar.q) {
                bVar.q.notifyAll();
            }
            if (bVar.f()) {
                g.this.q.a(g.this.g(), null);
            }
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    class b extends b.b.a.a.k.g {
        final /* synthetic */ b.b.a.a.k.f c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, String str, b.b.a.a.k.f fVar) {
            super(str);
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.run();
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    private static class d {
        private final OutputStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f41b;
        private boolean c;

        d(OutputStream outputStream, int i) {
            this.a = outputStream;
            this.f41b = i;
        }

        void a(byte[] bArr, int i, int i2) throws b.a.a.a.a.a.b.c.n.d {
            try {
                this.a.write(bArr, i, i2);
                this.f41b += i2;
            } catch (IOException e) {
                throw new b.a.a.a.a.a.b.c.n.d(e);
            }
        }

        boolean b() {
            return this.c;
        }

        void b(byte[] bArr, int i, int i2) throws b.a.a.a.a.a.b.c.n.d {
            if (this.c) {
                return;
            }
            try {
                this.a.write(bArr, i, i2);
                this.c = true;
            } catch (IOException e) {
                throw new b.a.a.a.a.a.b.c.n.d(e);
            }
        }

        int a() {
            return this.f41b;
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    public interface e {
        void a(g gVar);

        void b(g gVar);
    }

    g(c cVar) {
        super(cVar.a, cVar.f40b);
        this.s = true;
        this.o = cVar.c;
        this.p = cVar.d;
        this.q = b.a.a.a.a.a.b.c.d.d();
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
    }

    private void b(d dVar, k.a aVar) throws Throwable {
        if (this.s) {
            File fileB = this.a.b(this.h);
            long length = fileB.length();
            b.a.a.a.a.a.b.c.m.a aVarA = this.f33b.a(this.h, this.i.c.a);
            int iA = dVar.a();
            long j = length - ((long) iA);
            int i = (int) j;
            int i2 = aVarA == null ? -1 : aVarA.c;
            if (length > dVar.a()) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.i("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + j);
                }
                a(true, i, i2, (int) length, iA);
                a(aVarA, fileB, dVar, aVar);
                return;
            }
            a(false, i, i2, (int) length, iA);
        } else {
            a(false, 0, 0, 0, dVar.a());
        }
        d(dVar, aVar);
    }

    private void c(d dVar, k.a aVar) throws IOException, b.a.a.a.a.a.b.c.n.d {
        byte[] bArrA = a(this.f33b.a(this.h, this.i.c.a), dVar, aVar);
        if (bArrA == null) {
            return;
        }
        dVar.b(bArrA, 0, bArrA.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [b.a.a.a.a.a.b.c.h] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [b.a.a.a.a.a.b.c.h] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    private void d(d dVar, k.a aVar) throws Throwable {
        h.a e2;
        h hVar;
        h();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iA = dVar.a();
        b.a.a.a.a.a.b.c.p.a aVarA = a(aVar, iA, this.i.c.e, "GET");
        if (aVarA == null) {
            return;
        }
        ?? r5 = 0;
        r5 = 0;
        int i = 0;
        try {
            String strA = b.a.a.a.a.a.b.d.a.a(aVarA, false, true);
            if (strA != null) {
                throw new b.a.a.a.a.a.b.c.n.c(strA + ", rawKey: " + this.g + ", url: " + aVar);
            }
            b.a.a.a.a.a.b.c.m.a aVarA2 = this.f33b.a(this.h, d());
            int iA2 = b.a.a.a.a.a.b.d.a.a(aVarA);
            if (aVarA2 != null && aVarA2.c != iA2) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + aVarA2.c + ", " + iA2 + ", key: " + this.h);
                }
                throw new b.a.a.a.a.a.b.c.n.b("Content-Length not match, old length: " + aVarA2.c + ", new length: " + iA2 + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + aVarA2.e);
            }
            if (!dVar.b()) {
                String strA2 = b.a.a.a.a.a.b.d.a.a(aVarA, iA);
                a();
                byte[] bytes = strA2.getBytes(b.a.a.a.a.a.b.d.a.f58b);
                dVar.b(bytes, 0, bytes.length);
            }
            a();
            File fileD = this.a.d(this.h);
            ?? r2 = this.s;
            try {
                if (r2 == 0 || fileD == null || fileD.length() < dVar.a()) {
                    if (b.a.a.a.a.a.b.c.e.d) {
                        Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileD.length() + ", from: " + dVar.a());
                    }
                    r2 = 0;
                } else {
                    b.a.a.a.a.a.b.d.a.a(aVarA, this.f33b, this.h, this.i.c.a);
                    try {
                        h hVar2 = new h(fileD, "rwd");
                        try {
                            hVar2.a(dVar.a());
                            hVar = hVar2;
                        } catch (h.a e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            hVar = null;
                        }
                    } catch (h.a e4) {
                        e2 = e4;
                    }
                    r2 = hVar;
                    if (b.a.a.a.a.a.b.c.e.d) {
                        Log.i("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + fileD.length() + ", from: " + dVar.a());
                        r2 = hVar;
                    }
                }
                b.a.a.a.a.a.b.c.m.a aVarA3 = this.f33b.a(this.h, d());
                int i2 = aVarA3 == null ? 0 : aVarA3.c;
                byte[] bArr = new byte[8192];
                InputStream inputStreamB = aVarA.b();
                int i3 = 0;
                ?? r3 = r2;
                while (true) {
                    try {
                        int i4 = inputStreamB.read(bArr);
                        if (i4 < 0) {
                            break;
                        }
                        a();
                        if (i4 > 0) {
                            dVar.a(bArr, 0, i4);
                            i3 += i4;
                            r3 = r3;
                            if (r3 != 0) {
                                try {
                                    r3.a(bArr, 0, i4);
                                    r3 = r3;
                                } catch (Throwable th) {
                                    r3.a();
                                    try {
                                        if (b.a.a.a.a.a.b.c.e.d) {
                                            Log.e("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th));
                                        }
                                        r3 = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                            a(i2, dVar.a());
                        }
                        a();
                        r3 = r3;
                    } catch (Throwable th3) {
                        th = th3;
                        r5 = r3;
                    }
                    th = th3;
                    r5 = r3;
                    i = i3;
                    b.a.a.a.a.a.b.d.a.a(aVarA.b());
                    if (r5 != 0) {
                        r5.a();
                    }
                    this.c.addAndGet(i);
                    this.d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
                    throw th;
                }
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.i("TAG_PROXY_ProxyTask", "read from net complete!");
                }
                c();
                b.a.a.a.a.a.b.d.a.a(aVarA.b());
                if (r3 != 0) {
                    r3.a();
                }
                this.c.addAndGet(i3);
                this.d.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
            } catch (Throwable th4) {
                th = th4;
                r5 = r2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private void h() {
        b.a.a.a.a.a.b.c.b bVar = this.r;
        this.r = null;
        if (bVar != null) {
            bVar.b();
        }
    }

    private d i() {
        try {
            this.i = i.a(this.o.getInputStream());
            OutputStream outputStream = this.o.getOutputStream();
            b.a.a.a.a.a.b.c.l.a aVar = this.i.c.a == 1 ? b.a.a.a.a.a.b.c.e.a : b.a.a.a.a.a.b.c.e.f37b;
            if (aVar == null) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.a = aVar;
            this.g = this.i.c.f43b;
            this.h = this.i.c.c;
            this.j = new k(this.i.c.f);
            this.f = this.i.f42b;
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.i("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.i.toString());
            }
            return new d(outputStream, this.i.c.d);
        } catch (i.d e2) {
            b.a.a.a.a.a.b.d.a.a(this.o);
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e2);
            return null;
        } catch (IOException e3) {
            b.a.a.a.a.a.b.d.a.a(this.o);
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
            }
            a(this.a == null ? null : Boolean.valueOf(g()), this.g, e3);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a.a.a.a.a.b.c.m.a aVarA;
        d dVarI = i();
        if (dVarI == null) {
            return;
        }
        e eVar = this.p;
        if (eVar != null) {
            eVar.b(this);
        }
        this.a.a(this.h);
        if (b.a.a.a.a.a.b.c.e.j != 0 && ((aVarA = this.f33b.a(this.h, this.i.c.a)) == null || this.a.b(this.h).length() < aVarA.c)) {
            this.q.a(g(), this.h);
        }
        try {
            a(dVarI);
        } catch (b.a.a.a.a.a.b.c.n.a e2) {
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
        } catch (Throwable th) {
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.a.c(this.h);
        this.q.a(g(), null);
        b();
        b.a.a.a.a.a.b.d.a.a(this.o);
        e eVar2 = this.p;
        if (eVar2 != null) {
            eVar2.a(this);
        }
    }

    /* JADX INFO: compiled from: ProxyTask.java */
    static final class c {
        b.a.a.a.a.a.b.c.l.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b.a.a.a.a.a.b.c.m.c f40b;
        Socket c;
        e d;

        c() {
        }

        c a(b.a.a.a.a.a.b.c.m.c cVar) {
            if (cVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.f40b = cVar;
            return this;
        }

        c a(Socket socket) {
            if (socket != null) {
                this.c = socket;
                return this;
            }
            throw new IllegalArgumentException("socket == null");
        }

        c a(e eVar) {
            this.d = eVar;
            return this;
        }

        g a() {
            if (this.f40b != null && this.c != null) {
                return new g(this);
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean a(d dVar) throws Throwable {
        while (this.j.c()) {
            a();
            k.a aVarD = this.j.d();
            try {
                a(dVar, aVarD);
                return true;
            } catch (h.a e2) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                this.s = false;
                a(Boolean.valueOf(g()), this.g, e2);
            } catch (b.a.a.a.a.a.b.c.n.b e3) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                return false;
            } catch (b.a.a.a.a.a.b.c.n.c e4) {
                aVarD.a();
                a(Boolean.valueOf(g()), this.g, e4);
            } catch (b.a.a.a.a.a.b.c.n.d e5) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
                return true;
            } catch (IOException e6) {
                if (e6 instanceof SocketTimeoutException) {
                    aVarD.b();
                }
                if (!e()) {
                    a(Boolean.valueOf(g()), this.g, e6);
                } else if (b.a.a.a.a.a.b.c.e.d) {
                    if ("Canceled".equalsIgnoreCase(e6.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e6));
                    }
                }
            } catch (Exception e7) {
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e7));
                }
            }
        }
        return false;
    }

    @Override // b.a.a.a.a.a.b.c.a
    public void b() {
        super.b();
        h();
    }

    private void a(d dVar, k.a aVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.i.a.a)) {
            c(dVar, aVar);
        } else {
            b(dVar, aVar);
        }
    }

    private byte[] a(b.a.a.a.a.a.b.c.m.a aVar, d dVar, k.a aVar2) throws IOException {
        if (aVar != null) {
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.i("TAG_PROXY_ProxyTask", "get header from db");
            }
            return b.a.a.a.a.a.b.d.a.a(aVar, dVar.a()).getBytes(b.a.a.a.a.a.b.d.a.f58b);
        }
        b.a.a.a.a.a.b.c.p.a aVarA = a(aVar2, 0, -1, "HEAD");
        if (aVarA == null) {
            return null;
        }
        try {
            String strA = b.a.a.a.a.a.b.d.a.a(aVarA, false, false);
            if (strA == null) {
                b.a.a.a.a.a.b.c.m.a aVarA2 = b.a.a.a.a.a.b.d.a.a(aVarA, this.f33b, this.h, this.i.c.a);
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                byte[] bytes = b.a.a.a.a.a.b.d.a.a(aVarA2, dVar.a()).getBytes(b.a.a.a.a.a.b.d.a.f58b);
                b.a.a.a.a.a.b.d.a.a(aVarA.b());
                return bytes;
            }
            throw new b.a.a.a.a.a.b.c.n.c(strA + ", rawKey: " + this.g + ", url: " + aVar2);
        } catch (Throwable th) {
            b.a.a.a.a.a.b.d.a.a(aVarA.b());
            throw th;
        }
    }

    private void a(b.a.a.a.a.a.b.c.m.a aVar, File file, d dVar, k.a aVar2) throws Throwable {
        b.b.a.a.k.f fVar;
        b.a.a.a.a.a.b.c.b bVar;
        if (!dVar.b()) {
            byte[] bArrA = a(aVar, dVar, aVar2);
            a();
            if (bArrA == null) {
                return;
            } else {
                dVar.b(bArrA, 0, bArrA.length);
            }
        }
        h hVar = null;
        if (aVar == null && (aVar = this.f33b.a(this.h, this.i.c.a)) == null) {
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            a((b.a.a.a.a.a.b.c.m.a) null, dVar, aVar2);
            aVar = this.f33b.a(this.h, this.i.c.a);
            if (aVar == null) {
                throw new b.a.a.a.a.a.b.c.n.c("failed to get header, rawKey: " + this.g + ", url: " + aVar2);
            }
        }
        if (file.length() >= aVar.c || !((bVar = this.r) == null || bVar.e() || bVar.f())) {
            fVar = null;
        } else {
            b.a.a.a.a.a.b.c.b bVarA = new b.a.a.a.a.a.b.c.b.a().a(this.a).a(this.f33b).b(this.g).a(this.h).a(new k(aVar2.a)).a(this.f).a(this.i).a((b.a.a.a.a.a.b.c.b.InterfaceC0012b) new a()).a();
            this.r = bVarA;
            fVar = new b.b.a.a.k.f(bVarA, null, 10, 1);
            b.b.a.a.k.e.c(new b(this, "processCacheNetWorkConcurrent", fVar));
            if (b.a.a.a.a.a.b.c.e.d) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            h hVar2 = new h(file, CampaignEx.JSON_KEY_AD_R);
            try {
                hVar2.a(dVar.a());
                int iMin = this.i.c.e > 0 ? Math.min(aVar.c, this.i.c.e) : aVar.c;
                while (dVar.a() < iMin) {
                    a();
                    int iA = hVar2.a(bArr);
                    if (iA <= 0) {
                        b.a.a.a.a.a.b.c.b bVar2 = this.r;
                        if (bVar2 != null) {
                            b.a.a.a.a.a.b.c.n.b bVarI = bVar2.i();
                            if (bVarI == null) {
                                h.a aVarH = bVar2.h();
                                if (aVarH != null) {
                                    throw aVarH;
                                }
                            } else {
                                throw bVarI;
                            }
                        }
                        if (bVar2 != null && !bVar2.e() && !bVar2.f()) {
                            a();
                            synchronized (bVar2.q) {
                                try {
                                    bVar2.q.wait(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (b.a.a.a.a.a.b.c.e.d) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new b.a.a.a.a.a.b.c.n.c("illegal state download task has finished, rawKey: " + this.g + ", url: " + aVar2);
                    }
                    dVar.a(bArr, 0, iA);
                    a();
                }
                if (b.a.a.a.a.a.b.c.e.d) {
                    Log.i("TAG_PROXY_ProxyTask", "read cache file complete: " + dVar.a() + ", " + iMin);
                }
                c();
                hVar2.a();
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
                if (hVar != null) {
                    hVar.a();
                }
                if (fVar != null) {
                    try {
                        fVar.get();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
