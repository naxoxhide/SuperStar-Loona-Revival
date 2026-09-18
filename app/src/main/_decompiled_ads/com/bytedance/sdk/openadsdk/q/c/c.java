package com.bytedance.sdk.openadsdk.q.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PAGDisplayMrcTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends b {
    private int j;

    public c(Integer num, View view, q qVar, int i) {
        super(num, view, qVar, 1000, i);
        this.j = -1;
        b(view);
    }

    private void b(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            this.j = width * height >= 242500 ? 1 : 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected void a(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected boolean a() {
        WeakReference<View> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        View view = this.c.get();
        if (this.j == -1) {
            b(view);
        }
        return f.a(view, this.j == 1);
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    protected void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.q.c.b
    public int f() {
        return 100;
    }
}
