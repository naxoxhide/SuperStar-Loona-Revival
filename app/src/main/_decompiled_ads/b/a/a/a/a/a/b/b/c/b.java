package b.a.a.a.a.a.b.b.c;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import b.b.a.a.f.a.o;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ReallyVideoPreload.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.a.a.a.a.a.a.f.c f31b;
    private File d;
    private File e;
    private volatile boolean c = false;
    private final List<b.a.a.a.a.a.a.h.a.InterfaceC0009a> f = new ArrayList();
    private volatile boolean g = false;

    public b(Context context, b.a.a.a.a.a.a.f.c cVar) {
        this.d = null;
        this.e = null;
        this.a = context;
        this.f31b = cVar;
        this.d = b.a.a.a.a.a.b.f.b.c(cVar.b(), cVar.e());
        this.e = b.a.a.a.a.a.b.f.b.b(cVar.b(), cVar.e());
    }

    /* JADX INFO: compiled from: ReallyVideoPreload.java */
    class a implements b.b.a.a.f.a.c {
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, IOException iOException) {
            b bVar2 = b.this;
            bVar2.a(bVar2.f31b, 601, iOException.getMessage());
            c.a(b.this.f31b);
        }

        /* JADX WARN: Code duplicated, block: B:77:0x0256 A[Catch: all -> 0x02a8, TryCatch #5 {all -> 0x02a8, blocks: (B:75:0x0246, B:77:0x0256, B:78:0x025a), top: B:92:0x0246 }] */
        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, n nVar) throws IOException {
            Object obj;
            InputStream inputStreamA;
            o oVarA;
            int iB;
            long jC;
            RandomAccessFile randomAccessFile;
            RandomAccessFile randomAccessFile2;
            long j = this.a;
            char c = 1;
            char c2 = 0;
            if (nVar != null) {
                try {
                    boolean zD = nVar.d();
                    if (!zD) {
                        try {
                            b bVar2 = b.this;
                            bVar2.a(bVar2.f31b, nVar.b(), nVar.e());
                            b.this.a((Closeable) null);
                            b.this.a((Closeable) null);
                            b.this.a((Closeable) null);
                            b.this.a(nVar);
                            b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), " Preload size=", Integer.valueOf(b.this.f31b.j()));
                            c.a(b.this.f31b);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            inputStreamA = null;
                            oVarA = null;
                            obj = " Preload size=";
                        }
                    } else {
                        oVarA = nVar.a();
                        try {
                            oVarA = nVar.a();
                            if (!zD || oVarA == null) {
                                obj = " Preload size=";
                                inputStreamA = null;
                                jC = 0;
                            } else {
                                obj = " Preload size=";
                                try {
                                    jC = this.a + oVarA.c();
                                    inputStreamA = oVarA.a();
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStreamA = null;
                                }
                            }
                            try {
                                if (inputStreamA == null) {
                                    b bVar3 = b.this;
                                    bVar3.a(bVar3.f31b, nVar.b(), nVar.e());
                                    b.this.a((Closeable) null);
                                    b.this.a(inputStreamA);
                                    b.this.a(oVarA);
                                    b.this.a(nVar);
                                    b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
                                    c.a(b.this.f31b);
                                    return;
                                }
                                RandomAccessFile randomAccessFile3 = new RandomAccessFile(b.this.d, "rw");
                                try {
                                    byte[] bArr = new byte[8192];
                                    int i = 0;
                                    long j2 = 0;
                                    while (true) {
                                        int i2 = inputStreamA.read(bArr, i, 8192 - i);
                                        if (i2 != -1) {
                                            if (b.this.c) {
                                                b bVar4 = b.this;
                                                bVar4.a(bVar4.f31b, nVar.b());
                                                b.this.a(randomAccessFile3);
                                                b.this.a(inputStreamA);
                                                b.this.a(oVarA);
                                                b.this.a(nVar);
                                                Object[] objArr = new Object[4];
                                                objArr[c2] = "Pre finally ";
                                                objArr[c] = b.this.f31b.m();
                                                objArr[2] = obj;
                                                objArr[3] = Integer.valueOf(b.this.f31b.j());
                                                b.a.a.a.a.a.a.i.c.b("VideoPreload", objArr);
                                                c.a(b.this.f31b);
                                                return;
                                            }
                                            i += i2;
                                            j2 += (long) i2;
                                            if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == jC - this.a) {
                                                b.a.a.a.a.a.b.f.b.a(randomAccessFile3, bArr, Long.valueOf(j).intValue(), i, b.this.f31b.e());
                                                j += (long) i;
                                                i = 0;
                                            }
                                            c = 1;
                                            c2 = 0;
                                        } else {
                                            if (b.this.f31b.u() && jC == b.this.d.length()) {
                                                b.this.b();
                                            }
                                            b bVar5 = b.this;
                                            bVar5.b(bVar5.f31b, nVar.b());
                                            randomAccessFile2 = randomAccessFile3;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    randomAccessFile = randomAccessFile3;
                                    iB = 601;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                iB = 601;
                                randomAccessFile = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = " Preload size=";
                            iB = 601;
                            inputStreamA = null;
                            randomAccessFile = null;
                        }
                    }
                    iB = 601;
                } catch (Throwable th6) {
                    th = th6;
                    obj = " Preload size=";
                    iB = 601;
                    inputStreamA = null;
                    oVarA = null;
                }
                randomAccessFile = null;
                try {
                    th.printStackTrace();
                    b.this.a();
                    b bVar6 = b.this;
                    b.a.a.a.a.a.a.f.c cVar = bVar6.f31b;
                    if (nVar != null) {
                        iB = nVar.b();
                    }
                    bVar6.a(cVar, iB, th.getMessage());
                    b.this.a(randomAccessFile);
                    b.this.a(inputStreamA);
                    b.this.a(oVarA);
                    b.this.a(nVar);
                    b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
                    return;
                } finally {
                    b.this.a(randomAccessFile);
                    b.this.a(inputStreamA);
                    b.this.a(oVarA);
                    b.this.a(nVar);
                    b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
                    c.a(b.this.f31b);
                }
            }
            obj = " Preload size=";
            try {
                b bVar7 = b.this;
                iB = 601;
                try {
                    bVar7.a(bVar7.f31b, 601, "Network link failed.");
                    randomAccessFile2 = null;
                    inputStreamA = null;
                    oVarA = null;
                } catch (Throwable th7) {
                    th = th7;
                    inputStreamA = null;
                    oVarA = null;
                    randomAccessFile = null;
                    th.printStackTrace();
                    b.this.a();
                    b bVar8 = b.this;
                    b.a.a.a.a.a.a.f.c cVar2 = bVar8.f31b;
                    if (nVar != null) {
                        iB = nVar.b();
                    }
                    bVar8.a(cVar2, iB, th.getMessage());
                    b.this.a(randomAccessFile);
                    b.this.a(inputStreamA);
                    b.this.a(oVarA);
                    b.this.a(nVar);
                    b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
                    return;
                }
            } catch (Throwable th8) {
                th = th8;
                iB = 601;
                inputStreamA = null;
                oVarA = null;
                randomAccessFile = null;
                th.printStackTrace();
                b.this.a();
                b bVar9 = b.this;
                b.a.a.a.a.a.a.f.c cVar3 = bVar9.f31b;
                if (nVar != null) {
                    iB = nVar.b();
                }
                bVar9.a(cVar3, iB, th.getMessage());
                b.this.a(randomAccessFile);
                b.this.a(inputStreamA);
                b.this.a(oVarA);
                b.this.a(nVar);
                b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
                return;
            }
            b.this.a(randomAccessFile2);
            b.this.a(inputStreamA);
            b.this.a(oVarA);
            b.this.a(nVar);
            b.a.a.a.a.a.a.i.c.b("VideoPreload", "Pre finally ", b.this.f31b.m(), obj, Integer.valueOf(b.this.f31b.j()));
            c.a(b.this.f31b);
        }
    }

    private void c() {
        j.a aVarC = b.a.a.a.a.a.a.c.b() != null ? b.a.a.a.a.a.a.c.b().c() : new j.a("v_preload");
        long jC = this.f31b.c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarC.a(jC, timeUnit).b(this.f31b.k(), timeUnit).c(this.f31b.r(), timeUnit);
        j jVarA = aVarC.a();
        l.a aVar = new l.a();
        long length = this.d.length();
        int iJ = this.f31b.j();
        boolean zU = this.f31b.u();
        int iG = this.f31b.g();
        if (iG > 0) {
            if (iG >= this.f31b.p()) {
                zU = true;
            } else {
                iJ = iG;
            }
        }
        if (zU) {
            aVar.b("RANGE", "bytes=" + length + "-").a(this.f31b.m()).b().a();
        } else {
            aVar.b("RANGE", "bytes=" + length + "-" + iJ).a(this.f31b.m()).b().a();
        }
        jVarA.a(aVar.a()).a(new a(length));
    }

    private boolean e() {
        if (this.e.exists()) {
            return true;
        }
        if (this.f31b.u()) {
            return false;
        }
        if (this.d.length() >= this.f31b.j()) {
            return true;
        }
        return this.f31b.g() > 0 && this.d.length() >= ((long) this.f31b.g());
    }

    public b.a.a.a.a.a.a.f.c d() {
        return this.f31b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b.a.a.a.a.a.a.f.c cVar, int i) {
        synchronized (b.a.a.a.a.a.a.h.a.InterfaceC0009a.class) {
            for (b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a : this.f) {
                if (interfaceC0009a != null) {
                    interfaceC0009a.a(cVar, i);
                }
            }
        }
    }

    public void a(b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a) {
        if (this.g) {
            synchronized (b.a.a.a.a.a.a.h.a.InterfaceC0009a.class) {
                this.f.add(interfaceC0009a);
            }
            return;
        }
        this.f.add(interfaceC0009a);
        if (e()) {
            b.a.a.a.a.a.a.i.c.c("VideoPreload", "Cache file is exist");
            this.f31b.e(1);
            b(this.f31b, 200);
            c.a(this.f31b);
            return;
        }
        this.g = true;
        this.f31b.e(0);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (this.d.renameTo(this.e)) {
            } else {
                throw new IOException("Error renaming file " + this.d + " to " + this.e + " for completion!");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b.a.a.a.a.a.a.i.c.c("VideoPreload", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a.a.a.a.a.a.f.c cVar, int i, String str) {
        synchronized (b.a.a.a.a.a.a.h.a.InterfaceC0009a.class) {
            for (b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a : this.f) {
                if (interfaceC0009a != null) {
                    interfaceC0009a.a(cVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a.a.a.a.a.a.f.c cVar, int i) {
        synchronized (b.a.a.a.a.a.a.h.a.InterfaceC0009a.class) {
            for (b.a.a.a.a.a.a.h.a.InterfaceC0009a interfaceC0009a : this.f) {
                if (interfaceC0009a != null) {
                    interfaceC0009a.b(cVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.e.delete();
            this.d.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
