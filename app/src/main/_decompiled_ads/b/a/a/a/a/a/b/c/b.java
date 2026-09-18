package b.a.a.a.a.a.b.c;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: compiled from: DownloadTask.java */
/* JADX INFO: loaded from: classes.dex */
class b extends b.a.a.a.a.a.b.c.a {
    private final int o;
    private final InterfaceC0012b p;
    final Object q;
    final Object r;
    private volatile h.a s;
    private volatile b.a.a.a.a.a.b.c.n.b t;

    /* JADX INFO: renamed from: b.a.a.a.a.a.b.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadTask.java */
    public interface InterfaceC0012b {
        void a(b bVar);
    }

    b(a aVar) {
        super(aVar.d, aVar.e);
        this.o = aVar.g;
        this.p = aVar.i;
        this.q = this;
        this.g = aVar.a;
        this.h = aVar.f34b;
        this.f = aVar.f;
        this.j = aVar.c;
        this.i = aVar.h;
        this.r = aVar.j;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0242  */
    /* JADX WARN: Code duplicated, block: B:96:0x0236  */
    /* JADX WARN: Code duplicated, block: B:98:0x023b  */
    private void a(k.a aVar) throws Throwable {
        File fileB = this.a.b(this.h);
        long length = fileB.length();
        int i = this.o;
        if (i > 0 && length >= i) {
            if (e.d) {
                Log.i("TAG_PROXY_DownloadTask", "no necessary to download for " + this.h + ", cache file size: " + length + ", max: " + this.o);
                return;
            }
            return;
        }
        int iD = d();
        b.a.a.a.a.a.b.c.m.a aVarA = this.f33b.a(this.h, iD);
        if (aVarA != null && length >= aVarA.c) {
            if (e.d) {
                Log.i("TAG_PROXY_DownloadTask", "file download complete, key: " + this.h);
                return;
            }
            return;
        }
        a();
        int i2 = (int) length;
        b.a.a.a.a.a.b.c.p.a aVarA2 = a(aVar, i2, this.o, "GET");
        if (aVarA2 == null) {
            return;
        }
        h hVar = null;
        boolean z = true;
        try {
            a();
            String strA = b.a.a.a.a.a.b.d.a.a(aVarA2, this.i == null && e.g, true);
            if (strA != null) {
                throw new b.a.a.a.a.a.b.c.n.c(strA + ", rawKey: " + this.g + ", url: " + aVar);
            }
            int iA = b.a.a.a.a.a.b.d.a.a(aVarA2);
            if (aVarA != null && aVarA.c != iA) {
                if (e.d) {
                    Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + aVarA.c + ", " + iA + ", key: " + this.h);
                }
                throw new b.a.a.a.a.a.b.c.n.b("Content-Length not match, old length: " + aVarA.c + ", new length: " + iA + ", rawKey: " + this.g + ", currentUrl: " + aVar + ", previousInfo: " + aVarA.e);
            }
            b.a.a.a.a.a.b.d.a.a(aVarA2, this.f33b, this.h, iD);
            b.a.a.a.a.a.b.c.m.a aVarA3 = this.f33b.a(this.h, iD);
            int i3 = aVarA3 == null ? 0 : aVarA3.c;
            InputStream inputStreamB = aVarA2.b();
            h hVar2 = new h(fileB, e.f ? "rwd" : "rw");
            try {
                hVar2.a(length);
                if (e.d) {
                    Log.i("TAG_PROXY_DownloadTask", "preload start from: " + length);
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamB.read(bArr);
                    if (i4 < 0) {
                        try {
                            c();
                            if (e.d) {
                                Log.i("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
                            }
                            b.a.a.a.a.a.b.d.a.a(aVarA2.b());
                            hVar2.a();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            hVar = hVar2;
                            b.a.a.a.a.a.b.d.a.a(aVarA2.b());
                            if (hVar != null) {
                                hVar.a();
                            }
                            if (z) {
                                b();
                                if (e.d) {
                                    Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                }
                            }
                            throw th;
                        }
                    }
                    a();
                    if (i4 > 0) {
                        hVar2.a(bArr, 0, i4);
                        i2 += i4;
                        if (this.i != null) {
                            synchronized (this.q) {
                                this.q.notifyAll();
                            }
                        }
                        this.c.addAndGet(i4);
                        a(i3, i2);
                    }
                    int i5 = this.o;
                    if (i5 > 0 && i2 >= i5) {
                        boolean z2 = e.d;
                        if (z2) {
                            Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i2 + ", max: " + this.o);
                        }
                        b.a.a.a.a.a.b.d.a.a(aVarA2.b());
                        hVar2.a();
                        b();
                        if (z2) {
                            Log.w("TAG_PROXY_DownloadTask", "cancel call");
                            return;
                        }
                        return;
                    }
                    a();
                }
            } catch (Throwable th2) {
                th = th2;
                hVar = hVar2;
                b.a.a.a.a.a.b.d.a.a(aVarA2.b());
                if (hVar != null) {
                    hVar.a();
                }
                if (z) {
                    b();
                    if (e.d) {
                        Log.w("TAG_PROXY_DownloadTask", "cancel call");
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean j() throws b.a.a.a.a.a.b.c.n.a {
        while (this.j.c()) {
            a();
            k.a aVarD = this.j.d();
            try {
                a(aVarD);
                return true;
            } catch (h.a e) {
                this.s = e;
                a(Boolean.valueOf(g()), this.g, e);
                return false;
            } catch (b.a.a.a.a.a.b.c.n.b e2) {
                this.t = e2;
                return false;
            } catch (b.a.a.a.a.a.b.c.n.c e3) {
                aVarD.a();
                a(Boolean.valueOf(g()), this.g, e3);
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    aVarD.b();
                }
                if (!e()) {
                    a(Boolean.valueOf(g()), this.g, e4);
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    h.a h() {
        return this.s;
    }

    b.a.a.a.a.a.b.c.n.b i() {
        return this.t;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.h);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            j();
        } catch (Throwable unused) {
        }
        this.d.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.a.c(this.h);
        InterfaceC0012b interfaceC0012b = this.p;
        if (interfaceC0012b != null) {
            interfaceC0012b.a(this);
        }
    }

    /* JADX INFO: compiled from: DownloadTask.java */
    static final class a {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f34b;
        k c;
        b.a.a.a.a.a.b.c.l.a d;
        b.a.a.a.a.a.b.c.m.c e;
        List<i.b> f;
        int g;
        i h;
        InterfaceC0012b i;
        Object j;

        a() {
        }

        a a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.f34b = str;
            return this;
        }

        a b(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.a = str;
            return this;
        }

        a a(k kVar) {
            if (kVar != null) {
                this.c = kVar;
                return this;
            }
            throw new IllegalArgumentException("urls is empty");
        }

        a a(b.a.a.a.a.a.b.c.l.a aVar) {
            if (aVar != null) {
                this.d = aVar;
                return this;
            }
            throw new IllegalArgumentException("cache == null");
        }

        a a(b.a.a.a.a.a.b.c.m.c cVar) {
            if (cVar != null) {
                this.e = cVar;
                return this;
            }
            throw new IllegalArgumentException("db == null");
        }

        a a(List<i.b> list) {
            this.f = list;
            return this;
        }

        a a(int i) {
            this.g = i;
            return this;
        }

        a a(InterfaceC0012b interfaceC0012b) {
            this.i = interfaceC0012b;
            return this;
        }

        a a(i iVar) {
            this.h = iVar;
            return this;
        }

        a a(Object obj) {
            this.j = obj;
            return this;
        }

        b a() {
            if (this.d != null && this.e != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.f34b) && this.c != null) {
                return new b(this);
            }
            throw new IllegalArgumentException();
        }
    }
}
