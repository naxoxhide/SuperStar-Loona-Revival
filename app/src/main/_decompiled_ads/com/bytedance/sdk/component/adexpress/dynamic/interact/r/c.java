package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* JADX INFO: compiled from: SlideRightTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements View.OnTouchListener {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f285b;
    private boolean c;
    private g d;
    private int e;

    public c(g gVar) {
        this(gVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                this.f285b = x;
                if (Math.abs(x - this.a) > 10.0f) {
                    this.c = true;
                }
            }
        } else {
            if (!this.c) {
                return false;
            }
            int iC = b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), Math.abs(this.f285b - this.a));
            if (this.f285b > this.a && iC > this.e && (gVar = this.d) != null) {
                gVar.a();
            }
        }
        return true;
    }

    public c(g gVar, int i) {
        this.e = 5;
        this.d = gVar;
        if (i > 0) {
            this.e = i;
        }
    }
}
