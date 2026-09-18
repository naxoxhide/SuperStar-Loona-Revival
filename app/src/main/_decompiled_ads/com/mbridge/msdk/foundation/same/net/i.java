package com.mbridge.msdk.foundation.same.net;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.tools.aa;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i<T> implements Comparable<i<T>> {
    private static final String c = "i";
    protected ConcurrentHashMap<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected e<T> f2151b;
    private final boolean d;
    private final int e;
    private final String f;
    private Integer g;
    private j h;
    private boolean i;
    private l j;
    private int k;

    protected abstract k<T> a(com.mbridge.msdk.foundation.same.net.e.c cVar);

    public byte[] e() {
        return null;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int iG = g();
        int iG2 = iVar.g();
        return iG == iG2 ? this.g.intValue() - iVar.g.intValue() : iG2 - iG;
    }

    public i(int i, String str, e<T> eVar) {
        this.a = new ConcurrentHashMap<>();
        this.f2151b = null;
        this.i = false;
        this.k = 2;
        this.f = str;
        this.e = i;
        this.f2151b = eVar;
        this.d = false;
        this.j = new b();
    }

    public i(int i, String str, e<T> eVar, boolean z) {
        this.a = new ConcurrentHashMap<>();
        this.f2151b = null;
        this.i = false;
        this.k = 2;
        this.f = str;
        this.e = i;
        this.f2151b = eVar;
        this.d = z;
        this.j = new b();
    }

    public i(int i, String str) {
        this.a = new ConcurrentHashMap<>();
        this.f2151b = null;
        this.i = false;
        this.k = 2;
        this.f = str;
        this.e = i;
        this.d = false;
        this.j = new b();
    }

    public final int a() {
        return this.e;
    }

    public final void a(e<T> eVar) {
        this.f2151b = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(l lVar) {
        this.j = lVar;
        return this;
    }

    public final void a(String str) {
        j jVar = this.h;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(j jVar) {
        this.h = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public final String b() {
        return this.f;
    }

    public final boolean c() {
        return this.i;
    }

    public final Map<String, String> d() {
        return this.a;
    }

    public final void f() {
        a("Charset", "UTF-8");
        if (this.d) {
            a(HttpHeaders.CONNECTION, "keep-alive");
        } else {
            a(HttpHeaders.CONNECTION, "close");
        }
    }

    public byte[] a(com.mbridge.msdk.foundation.same.net.e.b bVar, c cVar) throws com.mbridge.msdk.foundation.same.net.a.a, IOException {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0067 A[Catch: IOException -> 0x0063, TRY_LEAVE, TryCatch #1 {IOException -> 0x0063, blocks: (B:35:0x005f, B:39:0x0067), top: B:45:0x005f }] */
    private byte[] a(com.mbridge.msdk.foundation.same.net.e.b bVar) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            InputStream inputStreamC = bVar.c();
            try {
                if (com.mbridge.msdk.foundation.same.net.f.b.b(bVar.b()) && !(inputStreamC instanceof GZIPInputStream)) {
                    inputStreamC = new GZIPInputStream(inputStreamC);
                }
                if (inputStreamC == null) {
                    throw new com.mbridge.msdk.foundation.same.net.a.a(7, null);
                }
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamC.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (inputStreamC != null) {
                        try {
                            inputStreamC.close();
                        } catch (IOException e) {
                            aa.d(c, e.getMessage());
                        }
                    }
                    byteArrayOutputStream2.close();
                    return byteArray;
                } catch (Throwable th) {
                    inputStream = inputStreamC;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        } catch (IOException e2) {
                            aa.d(c, e2.getMessage());
                            throw th;
                        }
                    } else if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamC;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public int g() {
        return this.k;
    }

    public final void b(int i) {
        if (i < 1 || i > 4) {
            return;
        }
        this.k = i;
    }

    public final int h() {
        try {
            return this.j.b();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int i() {
        try {
            return this.j.c();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int j() {
        try {
            return this.j.d();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int k() {
        try {
            return this.j.e();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int l() {
        try {
            return this.j.f();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final l m() {
        return this.j;
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onSuccess(kVar);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onError(aVar);
        }
    }

    public final void n() {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onCancel();
        }
    }

    public final void o() {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onPreExecute();
        }
    }

    public final void p() {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onFinish();
        }
    }

    public final void q() {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onRetry();
        }
    }

    public final void r() {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onNetworking();
        }
    }

    public final void a(long j, long j2) {
        e<T> eVar = this.f2151b;
        if (eVar != null) {
            eVar.onProgressChange(j, j2);
        }
    }

    public String toString() {
        return (this.i ? "[X] " : "[ ] ") + this.f + " " + g() + " " + this.g;
    }

    public final void a(String str, String str2) {
        this.a.remove(str);
        this.a.put(str, str2);
    }
}
