package com.bytedance.sdk.openadsdk.q.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: PAGVideoMrcTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends b {
    private int j;

    public h(Integer num, View view, q qVar, int i) {
        super(num, view, qVar, 2000, i);
        this.j = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected boolean a() {
        return f.a(this.c.get()) && this.j == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    public boolean d() {
        int i = this.j;
        boolean z = i == 2 || i == 0;
        if (z) {
            this.e.set(false);
        }
        return !z || super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    public int f() {
        return 200;
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    public void k() {
        if (this.j != 1) {
            return;
        }
        super.k();
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected void a(int i) {
        if (h()) {
            return;
        }
        if (i == 6 || i == 5) {
            this.j = 0;
            j();
        }
        if (i == 3 || i == 2) {
            this.j = 2;
            j();
        }
        if (this.j == 1 || i != 0) {
            return;
        }
        this.j = 1;
        k();
    }
}
