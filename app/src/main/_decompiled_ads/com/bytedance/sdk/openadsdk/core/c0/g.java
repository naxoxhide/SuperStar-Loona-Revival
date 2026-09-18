package com.bytedance.sdk.openadsdk.core.c0;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.h;

/* JADX INFO: compiled from: VastClickListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends c {
    private final String t;
    private final com.bytedance.sdk.openadsdk.core.i0.a u;
    private c v;

    public g(String str, com.bytedance.sdk.openadsdk.core.i0.a aVar) {
        this(str, aVar, null);
    }

    public void a(c cVar) {
        this.v = cVar;
    }

    public abstract void b();

    @Override // com.bytedance.sdk.openadsdk.core.c0.c, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    public g(String str, com.bytedance.sdk.openadsdk.core.i0.a aVar, c cVar) {
        this.t = str;
        this.u = aVar;
        this.v = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.c
    protected void a(View view, float f, float f2, float f3, float f4, SparseArray<c.a> sparseArray, boolean z) {
        com.bytedance.sdk.openadsdk.core.i0.a aVar = this.u;
        if (aVar != null) {
            aVar.b(this.t);
        }
        if (view != null) {
            if (view.getId() == h.c) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == h.g) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.t);
            }
        }
        c cVar = this.v;
        if (cVar != null) {
            cVar.e = this.e;
            cVar.f = this.f;
            cVar.g = this.g;
            int i = this.g;
            cVar.h = i;
            cVar.i = i;
            cVar.a(view, f, f2, f3, f4, sparseArray, z);
        }
        b();
    }
}
