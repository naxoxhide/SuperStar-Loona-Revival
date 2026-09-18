package b.b.a.a.h.x.i.d;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: LruCountDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements b.b.a.a.h.c {
    private a a;

    public b(File file, long j, ExecutorService executorService) {
        try {
            this.a = a.a(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    @Override // b.b.a.a.h.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean contains(String str) {
        try {
            try {
                a.e eVarB = this.a.b(str);
                boolean z = eVarB != null;
                b.b.a.a.h.x.k.b.a(eVarB);
                return z;
            } catch (IOException e) {
                Log.w("LruCountDiskCache", e.getMessage());
                b.b.a.a.h.x.k.b.a(null);
                return false;
            }
        } catch (Throwable th) {
            b.b.a.a.h.x.k.b.a(null);
            throw th;
        }
    }

    @Override // b.b.a.a.h.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] get(String str) throws Throwable {
        InputStream inputStreamA;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar = this.a;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (aVar == null || str == null) {
            return null;
        }
        try {
            a.e eVarB = aVar.b(str);
            if (eVarB == null) {
                b.b.a.a.h.x.k.b.a(null);
                b.b.a.a.h.x.k.b.a(null);
                return null;
            }
            inputStreamA = eVarB.a(0);
            if (inputStreamA != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStreamA.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                    } catch (IOException e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        b.b.a.a.h.x.k.b.a(inputStreamA);
                        b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    b.b.a.a.h.x.k.b.a(inputStreamA);
                    b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
                    throw th;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            b.b.a.a.h.x.k.b.a(inputStreamA);
            b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStreamA = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamA = null;
        }
        byteArrayOutputStream = null;
        try {
            Log.w("LruCountDiskCache", e.toString());
            b.b.a.a.h.x.k.b.a(inputStreamA);
            b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream2 = byteArrayOutputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            b.b.a.a.h.x.k.b.a(inputStreamA);
            b.b.a.a.h.x.k.b.a(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // b.b.a.a.h.c
    public InputStream a(String str) {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        try {
            a.e eVarB = aVar.b(str);
            if (eVarB != null) {
                return eVarB.a(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    @Override // b.b.a.a.h.a
    public boolean a(String str, byte[] bArr) throws Throwable {
        a aVar = this.a;
        if (aVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable = null;
        a.c cVar = null;
        try {
            try {
                a.c cVarA = aVar.a(str);
                try {
                    if (cVarA == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        b.b.a.a.h.x.k.b.a(null);
                        return false;
                    }
                    OutputStream outputStreamA = cVarA.a(0);
                    if (outputStreamA == a.q) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                        b.b.a.a.h.x.k.b.a(outputStreamA);
                        return false;
                    }
                    outputStreamA.write(bArr);
                    cVarA.b();
                    this.a.c();
                    b.b.a.a.h.x.k.b.a(outputStreamA);
                    return true;
                } catch (IOException e) {
                    e = e;
                    cVar = cVarA;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (cVar != null) {
                            try {
                                cVar.a();
                            } catch (IOException unused) {
                            }
                        }
                        b.b.a.a.h.x.k.b.a(0);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        closeable = closeable;
                        b.b.a.a.h.x.k.b.a(closeable);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                b.b.a.a.h.x.k.b.a(closeable);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
