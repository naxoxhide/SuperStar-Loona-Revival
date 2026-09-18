package com.mbridge.msdk.e;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ReportRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u<T> extends com.mbridge.msdk.e.a.m<T> {
    private Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.e.a.m.b f2054b;
    private com.mbridge.msdk.e.a.o.b<T> c;
    private v d;
    private com.mbridge.msdk.e.a.e e;

    public u(String str, int i) {
        super(i, str);
    }

    public u(String str, int i, int i2) {
        super(i, str, i2);
    }

    public final void a(v vVar) {
        this.d = vVar;
    }

    public final void a(com.mbridge.msdk.e.a.m.b bVar) {
        this.f2054b = bVar;
    }

    public final void a(Map<String, String> map) {
        this.a = map;
    }

    public final void a(com.mbridge.msdk.e.a.o.b<T> bVar) {
        this.c = bVar;
    }

    @Override // com.mbridge.msdk.e.a.m
    public final com.mbridge.msdk.e.a.r a() {
        if (y.a(this.e)) {
            this.e = new com.mbridge.msdk.e.a.e(30000, 5, 1.0f);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.e.a.m
    protected final com.mbridge.msdk.e.a.o<T> a(com.mbridge.msdk.e.a.k kVar) {
        return this.d.a(kVar);
    }

    @Override // com.mbridge.msdk.e.a.m
    protected final Map<String, String> b() {
        return this.a;
    }

    @Override // com.mbridge.msdk.e.a.m
    public final Map<String, String> c() {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED);
        return map;
    }

    @Override // com.mbridge.msdk.e.a.m
    public final com.mbridge.msdk.e.a.m.b d() {
        return this.f2054b;
    }

    @Override // com.mbridge.msdk.e.a.m
    protected final void a(T t) {
        com.mbridge.msdk.e.a.o.b<T> bVar = this.c;
        this.c = bVar;
        if (bVar != null) {
            bVar.a(t);
        }
    }
}
