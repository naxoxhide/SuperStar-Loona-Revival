package com.mbridge.msdk.e.a;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m<T> implements Comparable<m<T>> {
    private c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2029b;
    private p c;
    private final v.a d;
    private final int e;
    private final String f;
    private final int g;
    private final int h;
    private final Object i;
    private o.a j;
    private Integer k;
    private n l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private r r;
    private com.mbridge.msdk.e.a.a.C0475a s;
    private a t;

    /* JADX INFO: compiled from: Request.java */
    interface a {
        void a(m<?> mVar);

        void a(m<?> mVar, o<?> oVar);
    }

    /* JADX INFO: compiled from: Request.java */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract o<T> a(k kVar);

    protected abstract void a(T t);

    protected Map<String, String> b() {
        return null;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        m mVar = (m) obj;
        b bVarD = d();
        b bVarD2 = mVar.d();
        return bVarD == bVarD2 ? this.k.intValue() - mVar.k.intValue() : bVarD2.ordinal() - bVarD.ordinal();
    }

    public m(int i, String str) {
        this(i, str, 0);
    }

    public m(int i, String str, int i2) {
        Uri uri;
        String host;
        this.d = null;
        this.i = new Object();
        int iHashCode = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.e = i;
        this.f = str;
        this.g = i2;
        this.r = new e();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.h = iHashCode;
    }

    public final void a(o.a aVar) {
        this.j = aVar;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.h;
    }

    final void a(String str) {
        n nVar = this.l;
        if (nVar != null) {
            nVar.b(this);
        }
    }

    final void a(int i) {
        n nVar = this.l;
        if (nVar != null) {
            nVar.a(this, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> a(n nVar) {
        this.l = nVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> b(int i) {
        this.k = Integer.valueOf(i);
        return this;
    }

    public final String h() {
        return this.f;
    }

    public final String i() {
        if (!TextUtils.isEmpty(this.f2029b)) {
            return this.f2029b;
        }
        if (this.a == null) {
            this.a = new com.mbridge.msdk.e.a.a.d();
        }
        String strA = this.a.a(this);
        this.f2029b = strA;
        return strA;
    }

    public final p j() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> a(com.mbridge.msdk.e.a.a.C0475a c0475a) {
        this.s = c0475a;
        return this;
    }

    public final com.mbridge.msdk.e.a.a.C0475a k() {
        return this.s;
    }

    public final boolean l() {
        boolean z;
        synchronized (this.i) {
            z = this.n;
        }
        return z;
    }

    public Map<String, String> c() {
        return Collections.emptyMap();
    }

    public final String m() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final byte[] n() {
        Map<String, String> mapB = b();
        if (mapB == null || mapB.size() <= 0) {
            return null;
        }
        return a(mapB, "UTF-8");
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i++;
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                if (i <= map.size() - 1) {
                    sb.append(Typography.amp);
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> a(boolean z) {
        this.m = z;
        return this;
    }

    public final boolean o() {
        return this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> b(boolean z) {
        this.p = z;
        return this;
    }

    public final boolean p() {
        return this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> c(boolean z) {
        this.q = z;
        return this;
    }

    public final boolean q() {
        return this.q;
    }

    public b d() {
        return b.NORMAL;
    }

    public final int r() {
        return a().a();
    }

    public r a() {
        return this.r;
    }

    public final void s() {
        synchronized (this.i) {
            this.o = true;
        }
    }

    public final boolean t() {
        boolean z;
        synchronized (this.i) {
            z = this.o;
        }
        return z;
    }

    public final void a(u uVar) {
        o.a aVar;
        synchronized (this.i) {
            aVar = this.j;
        }
        if (aVar != null) {
            aVar.a(uVar);
        }
    }

    final void a(a aVar) {
        synchronized (this.i) {
            this.t = aVar;
        }
    }

    final void a(o<?> oVar) {
        a aVar;
        synchronized (this.i) {
            aVar = this.t;
        }
        if (aVar != null) {
            aVar.a(this, oVar);
        }
    }

    final void u() {
        a aVar;
        synchronized (this.i) {
            aVar = this.t;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public String toString() {
        return (l() ? "[X] " : "[ ] ") + this.f + " " + ("0x" + Integer.toHexString(this.h)) + " " + d() + " " + this.k;
    }
}
