package com.bytedance.sdk.component.adexpress.dynamic.interact.r;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.interact.g;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: UnlockTapTouch.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements View.OnTouchListener {
    private static int h = 10;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f288b;
    private g c;
    private int d;
    private RectF e = new RectF();
    private long f = 0;
    private SoftReference<View> g = new SoftReference<>(null);

    /* JADX INFO: compiled from: UnlockTapTouch.java */
    class a implements Runnable {
        final /* synthetic */ ViewGroup a;

        a(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewFindViewById = this.a.findViewById(b.b.a.a.d.d.a.g);
            f.this.g = new SoftReference(viewFindViewById);
        }
    }

    public f(g gVar, int i, ViewGroup viewGroup) {
        this.d = h;
        this.c = gVar;
        if (i > 0) {
            this.d = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new a(viewGroup));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        g gVar;
        g gVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = a(this.g.get());
            this.a = motionEvent.getRawX();
            this.f288b = motionEvent.getRawY();
            this.f = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.e;
            if (rectF != null && !rectF.contains(this.a, this.f288b)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.a);
            float fAbs2 = Math.abs(rawY - this.f288b);
            int iC = b.b.a.a.d.g.d.c(b.b.a.a.d.c.a(), Math.abs(rawX - this.a));
            float f = h;
            if (fAbs < f || fAbs2 < f) {
                if ((System.currentTimeMillis() - this.f < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (gVar = this.c) != null) {
                    gVar.a();
                }
            } else if (rawX > this.a && iC > this.d && (gVar2 = this.c) != null) {
                gVar2.a();
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
