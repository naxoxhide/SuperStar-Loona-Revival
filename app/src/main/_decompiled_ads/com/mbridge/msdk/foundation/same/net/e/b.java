package com.mbridge.msdk.foundation.same.net.e;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.foundation.same.net.c.b> f2143b;
    private final InputStream c;

    public b(int i, List<com.mbridge.msdk.foundation.same.net.c.b> list, InputStream inputStream) {
        this.a = i;
        this.f2143b = list;
        this.c = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final List<com.mbridge.msdk.foundation.same.net.c.b> b() {
        return Collections.unmodifiableList(this.f2143b);
    }

    public final InputStream c() {
        return this.c;
    }
}
