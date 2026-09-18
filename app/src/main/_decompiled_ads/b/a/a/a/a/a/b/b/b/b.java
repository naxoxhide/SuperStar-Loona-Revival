package b.a.a.a.a.a.b.b.b;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import b.b.a.a.f.a.j;
import b.b.a.a.f.a.l;
import b.b.a.a.f.a.n;
import b.b.a.a.f.a.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MediaDownloadPlayCacheImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    private File c;
    private File d;
    private long e;
    private RandomAccessFile i;
    private final b.a.a.a.a.a.a.f.c j;
    private volatile long a = -2147483648L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f30b = new Object();
    private volatile long f = -1;
    private volatile boolean g = false;
    private volatile boolean h = false;

    public b(Context context, b.a.a.a.a.a.a.f.c cVar) {
        this.e = 0L;
        this.i = null;
        this.j = cVar;
        try {
            this.c = b.a.a.a.a.a.b.f.b.c(cVar.b(), cVar.e());
            this.d = b.a.a.a.a.a.b.f.b.b(cVar.b(), cVar.e());
            if (d()) {
                this.i = new RandomAccessFile(this.d, CampaignEx.JSON_KEY_AD_R);
            } else {
                this.i = new RandomAccessFile(this.c, "rw");
            }
            if (d()) {
                return;
            }
            this.e = this.c.length();
            c();
        } catch (Throwable unused) {
            b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "Error using file ", cVar.m(), " as disc cache");
        }
    }

    @Override // b.a.a.a.a.a.b.b.b.c
    public void close() {
        try {
            if (!this.g) {
                this.i.close();
            }
            File file = this.c;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.d;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.g = true;
    }

    @Override // b.a.a.a.a.a.b.b.b.c
    public long length() throws IOException {
        if (d()) {
            this.a = this.d.length();
        } else {
            synchronized (this.f30b) {
                int i = 0;
                while (this.a == -2147483648L) {
                    try {
                        b.a.a.a.a.a.a.i.c.c("CSJ_MediaDLPlay", "totalLength: wait");
                        i += 15;
                        this.f30b.wait(5L);
                        if (i > 20000) {
                            return -1L;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.a));
        return this.a;
    }

    /* JADX INFO: compiled from: MediaDownloadPlayCacheImpl.java */
    class a implements b.b.a.a.f.a.c {
        a() {
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, IOException iOException) {
            b.this.h = false;
            b.this.a = -1L;
        }

        @Override // b.b.a.a.f.a.c
        public void a(b.b.a.a.f.a.b bVar, n nVar) throws IOException {
            o oVarA;
            boolean z;
            long length;
            long j;
            boolean z2;
            if (nVar != null) {
                InputStream inputStreamA = null;
                try {
                    b.this.h = nVar.d();
                    if (!b.this.h) {
                        b.this.h = false;
                        b bVar2 = b.this;
                        bVar2.a = bVar2.f;
                        oVarA = null;
                    } else {
                        oVarA = nVar.a();
                        try {
                            if (b.this.h && oVarA != null) {
                                b.this.a = oVarA.c() + b.this.e;
                                inputStreamA = oVarA.a();
                            }
                            if (inputStreamA == null) {
                                if (inputStreamA != null) {
                                    try {
                                        inputStreamA.close();
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                        return;
                                    }
                                }
                                if (oVarA != null) {
                                    oVarA.close();
                                }
                                if (nVar != null) {
                                    nVar.close();
                                }
                                if (b.this.h && b.this.c.length() == b.this.a) {
                                    b.this.b();
                                    return;
                                }
                                return;
                            }
                            byte[] bArr = new byte[8192];
                            long j2 = b.this.e;
                            long j3 = 0;
                            int i = 0;
                            long j4 = 0;
                            while (true) {
                                int i2 = inputStreamA.read(bArr, i, 8192 - i);
                                z2 = true;
                                if (i2 == -1) {
                                    break;
                                }
                                i += i2;
                                j4 += (long) i2;
                                boolean z3 = j4 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == j3 || j4 == b.this.a - b.this.e;
                                b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "Write segment,execAppend =", Boolean.valueOf(z3), " offset=", Integer.valueOf(i), " totalLength = ", Long.valueOf(b.this.a), " saveSize =", Long.valueOf(j4), " startSaved=", Long.valueOf(b.this.e), " fileHash=", b.this.j.e(), " url=", b.this.j.m());
                                if (z3) {
                                    synchronized (b.this.f30b) {
                                        b.a.a.a.a.a.b.f.b.a(b.this.i, bArr, Long.valueOf(j2).intValue(), i, b.this.j.e());
                                    }
                                    j2 += (long) i;
                                    i = 0;
                                }
                                j3 = 0;
                            }
                            Object[] objArr = new Object[10];
                            objArr[0] = "Write segment,Write over, startIndex =";
                            objArr[1] = Long.valueOf(b.this.e);
                            objArr[2] = " totalLength = ";
                            objArr[3] = Long.valueOf(b.this.a);
                            objArr[4] = " saveSize = ";
                            objArr[5] = Long.valueOf(j4);
                            objArr[6] = " writeEndSegment =";
                            if (j4 != b.this.a - b.this.e) {
                                z2 = false;
                            }
                            objArr[7] = Boolean.valueOf(z2);
                            objArr[8] = " url=";
                            objArr[9] = b.this.j.m();
                            b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", objArr);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                b.this.h = false;
                                b bVar3 = b.this;
                                bVar3.a = bVar3.f;
                                th.printStackTrace();
                                if (inputStreamA != null) {
                                    try {
                                    } catch (Throwable th3) {
                                        return;
                                    }
                                }
                                if (z) {
                                    if (length == j) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            } finally {
                                if (inputStreamA != null) {
                                    try {
                                        inputStreamA.close();
                                    } catch (Throwable th4) {
                                        th4.printStackTrace();
                                    }
                                }
                                if (oVarA != null) {
                                    oVarA.close();
                                }
                                if (nVar != null) {
                                    nVar.close();
                                }
                                if (b.this.h && b.this.c.length() == b.this.a) {
                                    b.this.b();
                                }
                            }
                        }
                    }
                    if (inputStreamA != null) {
                        try {
                            inputStreamA.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    if (oVarA != null) {
                        oVarA.close();
                    }
                    if (nVar != null) {
                        nVar.close();
                    }
                    if (b.this.h && b.this.c.length() == b.this.a) {
                        b.this.b();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    oVarA = null;
                }
            } else {
                b.this.h = false;
                b bVar4 = b.this;
                bVar4.a = bVar4.f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() throws IOException {
        synchronized (this.f30b) {
            if (d()) {
                b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "complete: isCompleted ", this.j.m(), this.j.e());
                return;
            }
            try {
                if (!this.c.renameTo(this.d)) {
                    throw new IOException("Error renaming file " + this.c + " to " + this.d + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.i;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.i = new RandomAccessFile(this.d, "rw");
                b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "complete: rename ", this.j.e(), this.j.m());
            } catch (Throwable th) {
                th.printStackTrace();
                b.a.a.a.a.a.a.i.c.c("CSJ_MediaDLPlay", th.getMessage());
            }
        }
    }

    private boolean d() {
        return this.d.exists();
    }

    public void c() {
        j.a aVarC = b.a.a.a.a.a.a.c.b() != null ? b.a.a.a.a.a.a.c.b().c() : new j.a("v_cache");
        long jC = this.j.c();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        aVarC.a(jC, timeUnit).b(this.j.k(), timeUnit).c(this.j.r(), timeUnit);
        j jVarA = aVarC.a();
        b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "RANGE, bytes=", Long.valueOf(this.e), " file hash=", this.j.e());
        jVarA.a(new l.a().b("RANGE", "bytes=" + this.e + "-").a(this.j.m()).b().a()).a(new a());
    }

    @Override // b.a.a.a.a.a.b.b.b.c
    public int a(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.a) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.g) {
                synchronized (this.f30b) {
                    long jA = a();
                    if (j < jA) {
                        b.a.a.a.a.a.a.i.c.c("CSJ_MediaDLPlay", "read:  read " + j + " success");
                        this.i.seek(j);
                        i4 = this.i.read(bArr, i, i2);
                    } else {
                        b.a.a.a.a.a.a.i.c.b("CSJ_MediaDLPlay", "read: wait at ", Long.valueOf(j), "  file size = ", Long.valueOf(jA));
                        i3 += 33;
                        this.f30b.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    private long a() {
        if (d()) {
            return this.d.length();
        }
        return this.c.length();
    }
}
