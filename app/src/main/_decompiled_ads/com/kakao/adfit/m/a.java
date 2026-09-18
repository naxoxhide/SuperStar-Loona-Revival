package com.kakao.adfit.m;

import com.kakao.adfit.common.volley.VolleyError;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements f {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1849b;
    private final int c;
    private final float d;

    public a() {
        this(2500, 1, 1.0f);
    }

    @Override // com.kakao.adfit.m.f
    public int a() {
        return this.a;
    }

    @Override // com.kakao.adfit.m.f
    public int b() {
        return this.f1849b;
    }

    protected boolean c() {
        return this.f1849b <= this.c;
    }

    public a(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.kakao.adfit.m.f
    public void a(VolleyError volleyError) throws VolleyError {
        this.f1849b++;
        float f = this.a;
        this.a = (int) (f + (this.d * f));
        if (!c()) {
            throw volleyError;
        }
    }
}
