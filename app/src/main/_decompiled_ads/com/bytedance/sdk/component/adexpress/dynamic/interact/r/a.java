package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;
import com.bytedance.sdk.component.utils.m;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: LimitBrushTapTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements View.OnTouchListener {
    private static int h = 10;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f282b;
    private g c;
    private int d;
    private RectF e = new RectF();
    private long f = 0;
    private SoftReference<ViewGroup> g = new SoftReference<>(null);

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.interact.r.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LimitBrushTapTouch.java */
    class RunnableC0155a implements Runnable {
        final /* synthetic */ ViewGroup a;

        RunnableC0155a(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.g = new SoftReference(this.a);
        }
    }

    public a(g gVar, int i, ViewGroup viewGroup) {
        this.d = h;
        this.c = gVar;
        if (i > 0) {
            this.d = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new RunnableC0155a(viewGroup));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = a(this.g.get());
            this.a = motionEvent.getRawX();
            this.f282b = motionEvent.getRawY();
            this.f = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.e;
            if (rectF != null && !rectF.contains(this.a, this.f282b)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.a);
            float fAbs2 = Math.abs(rawY - this.f282b);
            float f = this.d;
            if (fAbs < f || fAbs2 < f) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.f;
                m.a("limittouch", "d:" + jCurrentTimeMillis + " a:" + fAbs + " b:" + fAbs2);
                if ((jCurrentTimeMillis < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (gVar = this.c) != null) {
                    gVar.a();
                }
            } else {
                g gVar2 = this.c;
                if (gVar2 != null) {
                    gVar2.a();
                }
            }
        }
        return true;
    }

    private RectF a(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }
}
