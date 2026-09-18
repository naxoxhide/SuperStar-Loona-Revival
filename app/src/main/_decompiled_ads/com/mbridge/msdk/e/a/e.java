package com.mbridge.msdk.e.a;

import android.util.Log;

/* JADX INFO: compiled from: DefaultRetryPolicy.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements r {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2023b;
    private final int c;
    private final float d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.mbridge.msdk.e.a.r
    public final int a() {
        return this.a;
    }

    @Override // com.mbridge.msdk.e.a.r
    public final int b() {
        return this.f2023b;
    }

    @Override // com.mbridge.msdk.e.a.r
    public final void a(u uVar) throws u {
        Log.d("DefaultRetryPolicy", "============= retry: " + uVar);
        int i = this.f2023b + 1;
        this.f2023b = i;
        int i2 = this.a;
        this.a = i2 + ((int) (i2 * this.d));
        if (!(i <= this.c)) {
            throw uVar;
        }
    }
}
