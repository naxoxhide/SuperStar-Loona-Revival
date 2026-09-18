package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* JADX INFO: compiled from: SlideUpTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements View.OnTouchListener {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f286b;
    private boolean c;
    private g d;
    private int e;

    public d(g gVar, int i) {
        this.d = gVar;
        this.e = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.f286b = y;
                if (Math.abs(y - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else {
            if (!this.c) {
                return false;
            }
            int iC = b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), Math.abs(this.f286b - this.a));
            if (this.f286b - this.a < 0.0f && iC > this.e && (gVar = this.d) != null) {
                gVar.a();
            }
        }
        return true;
    }
}
