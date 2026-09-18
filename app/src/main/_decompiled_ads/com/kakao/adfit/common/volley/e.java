package com.kakao.adfit.common.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> implements Comparable<e<T>> {
    private final h.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1722b;
    private final String c;
    private final int d;
    private final Object e;
    private g.a f;
    private Integer g;
    private f h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private com.kakao.adfit.m.f n;
    private com.kakao.adfit.common.volley.a.C0448a o;
    private b p;

    /* JADX INFO: compiled from: Request.java */
    class a implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f1723b;

        a(String str, long j) {
            this.a = str;
            this.f1723b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a.a(this.a, this.f1723b);
            e.this.a.a(e.this.toString());
        }
    }

    /* JADX INFO: compiled from: Request.java */
    interface b {
        void a(e<?> eVar);

        void a(e<?> eVar, g<?> gVar);
    }

    /* JADX INFO: compiled from: Request.java */
    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public e(int i, String str, g.a aVar) {
        this.a = h.a.c ? new h.a() : null;
        this.e = new Object();
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.o = null;
        this.f1722b = i;
        this.c = str;
        this.f = aVar;
        a((com.kakao.adfit.m.f) new com.kakao.adfit.m.a());
        this.d = b(str);
    }

    private static int b(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    protected abstract g<T> a(com.kakao.adfit.m.d dVar);

    protected abstract void a(T t);

    protected VolleyError b(VolleyError volleyError) {
        return volleyError;
    }

    void c(String str) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.c(this);
        }
        if (h.a.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.a.a(str, id);
                this.a.a(toString());
            }
        }
    }

    public com.kakao.adfit.common.volley.a.C0448a d() {
        return this.o;
    }

    public String e() {
        String strQ = q();
        int iG = g();
        return (iG == 0 || iG == -1) ? strQ : Integer.toString(iG) + '-' + strQ;
    }

    public Map<String, String> f() {
        return Collections.emptyMap();
    }

    public int g() {
        return this.f1722b;
    }

    protected Map<String, String> h() {
        return null;
    }

    protected String i() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] j() {
        Map<String, String> mapK = k();
        if (mapK == null || mapK.size() <= 0) {
            return null;
        }
        return a(mapK, l());
    }

    @Deprecated
    protected Map<String, String> k() {
        return h();
    }

    @Deprecated
    protected String l() {
        return i();
    }

    public c m() {
        return c.NORMAL;
    }

    public com.kakao.adfit.m.f n() {
        return this.n;
    }

    public final int o() {
        return n().a();
    }

    public int p() {
        return this.d;
    }

    public String q() {
        return this.c;
    }

    public boolean r() {
        boolean z;
        synchronized (this.e) {
            z = this.k;
        }
        return z;
    }

    public boolean s() {
        boolean z;
        synchronized (this.e) {
            z = this.j;
        }
        return z;
    }

    public void t() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public String toString() {
        return (s() ? "[X] " : "[ ] ") + q() + " " + ("0x" + Integer.toHexString(p())) + " " + m() + " " + this.g;
    }

    void u() {
        b bVar;
        synchronized (this.e) {
            bVar = this.p;
        }
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public final boolean v() {
        return this.i;
    }

    public final boolean w() {
        return this.m;
    }

    public final boolean x() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<?> a(com.kakao.adfit.m.f fVar) {
        this.n = fVar;
        return this;
    }

    public void a(String str) {
        if (h.a.c) {
            this.a.a(str, Thread.currentThread().getId());
        }
    }

    void a(int i) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a(this, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<?> a(f fVar) {
        this.h = fVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<?> b(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<?> a(com.kakao.adfit.common.volley.a.C0448a c0448a) {
        this.o = c0448a;
        return this;
    }

    public byte[] b() {
        Map<String, String> mapH = h();
        if (mapH == null || mapH.size() <= 0) {
            return null;
        }
        return a(mapH, i());
    }

    public void a() {
        synchronized (this.e) {
            this.j = true;
            this.f = null;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(e<T> eVar) {
        c cVarM = m();
        c cVarM2 = eVar.m();
        return cVarM == cVarM2 ? this.g.intValue() - eVar.g.intValue() : cVarM2.ordinal() - cVarM.ordinal();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append(Typography.amp);
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public String c() {
        return "application/x-www-form-urlencoded; charset=" + i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e<?> a(boolean z) {
        this.i = z;
        return this;
    }

    public void a(VolleyError volleyError) {
        g.a aVar;
        synchronized (this.e) {
            aVar = this.f;
        }
        if (aVar != null) {
            aVar.a(volleyError);
        }
    }

    void a(b bVar) {
        synchronized (this.e) {
            this.p = bVar;
        }
    }

    void a(g<?> gVar) {
        b bVar;
        synchronized (this.e) {
            bVar = this.p;
        }
        if (bVar != null) {
            bVar.a(this, gVar);
        }
    }
}
