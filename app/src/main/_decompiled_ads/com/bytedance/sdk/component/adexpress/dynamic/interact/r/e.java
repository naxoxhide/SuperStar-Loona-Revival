package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;

/* JADX INFO: compiled from: TapTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements View.OnTouchListener {
    private static int e = 10;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f287b;
    private boolean c;
    private g d;

    public e(g gVar) {
        this.d = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.f287b = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.a) >= e || Math.abs(y - this.f287b) >= e) {
                    this.c = true;
                }
            } else if (action == 3) {
                this.c = false;
            }
        } else {
            if (this.c) {
                this.c = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.a) >= e || Math.abs(y2 - this.f287b) >= e) {
                this.c = false;
            } else {
                g gVar = this.d;
                if (gVar != null) {
                    gVar.a();
                }
            }
        }
        return true;
    }
}
