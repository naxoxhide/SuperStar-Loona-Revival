package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* JADX INFO: compiled from: LongPressTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements View.OnTouchListener {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f284b;
    private long c;
    private boolean d;
    private InteractViewContainer e;
    private g f;

    public b(InteractViewContainer interactViewContainer, g gVar) {
        this.e = interactViewContainer;
        this.f = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = System.currentTimeMillis();
            this.a = motionEvent.getX();
            this.f284b = motionEvent.getY();
            this.e.g();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.a) >= b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), 10.0f) || Math.abs(y - this.f284b) >= b.b.a.a.d.g.d.a(b.b.a.a.d.c.a(), 10.0f)) {
                    this.d = true;
                    this.e.b();
                }
            }
        } else {
            if (this.d) {
                return false;
            }
            if (System.currentTimeMillis() - this.c >= 1500) {
                g gVar = this.f;
                if (gVar != null) {
                    gVar.a();
                }
            } else {
                this.e.b();
            }
        }
        return true;
    }
}
