package com.kakao.adfit.n;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.kakao.adfit.m.b> f1857b;
    private final int c;
    private final InputStream d;
    private final byte[] e;

    public f(int i, List<com.kakao.adfit.m.b> list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        InputStream inputStream = this.d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.e != null) {
            return new ByteArrayInputStream(this.e);
        }
        return null;
    }

    public final int b() {
        return this.c;
    }

    public final List<com.kakao.adfit.m.b> c() {
        return Collections.unmodifiableList(this.f1857b);
    }

    public final int d() {
        return this.a;
    }

    public f(int i, List<com.kakao.adfit.m.b> list, int i2, InputStream inputStream) {
        this.a = i;
        this.f1857b = list;
        this.c = i2;
        this.d = inputStream;
        this.e = null;
    }
}
