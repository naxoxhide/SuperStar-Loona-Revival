package com.mbridge.msdk.e.a.a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.e.a.g> f2018b;
    private final int c;
    private final InputStream d;
    private final byte[] e;

    public f(int i, List<com.mbridge.msdk.e.a.g> list) {
        this(i, list, -1, null);
    }

    public f(int i, List<com.mbridge.msdk.e.a.g> list, int i2, InputStream inputStream) {
        this.a = i;
        this.f2018b = list;
        this.c = i2;
        this.d = inputStream;
        this.e = null;
    }

    public final int a() {
        return this.a;
    }

    public final List<com.mbridge.msdk.e.a.g> b() {
        return Collections.unmodifiableList(this.f2018b);
    }

    public final int c() {
        return this.c;
    }

    public final InputStream d() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }
}
