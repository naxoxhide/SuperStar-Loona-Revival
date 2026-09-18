package com.bytedance.sdk.openadsdk.core.c0;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.j;

/* JADX INFO: compiled from: InteractionListener.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int n = 8;
    private static float o;
    private static float p;
    private static float q;
    private static float r;
    private static long s;
    protected float a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f564b = -1.0f;
    protected float c = -1.0f;
    protected float d = -1.0f;
    protected long e = -1;
    protected long f = -1;
    protected int g = -1;
    protected int h = -1024;
    protected int i = -1;
    protected boolean j = true;
    public SparseArray<a> k = new SparseArray<>();
    private int l = 0;
    private int m = 0;

    /* JADX INFO: compiled from: InteractionListener.java */
    public static class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f565b;
        public double c;
        public long d;

        public a(int i, double d, double d2, long j) {
            this.a = -1;
            this.f565b = -1.0d;
            this.c = -1.0d;
            this.d = -1L;
            this.a = i;
            this.f565b = d;
            this.c = d2;
            this.d = j;
        }
    }

    static {
        if (o.a() != null) {
            n = o.e();
        }
        o = 0.0f;
        p = 0.0f;
        q = 0.0f;
        r = 0.0f;
        s = 0L;
    }

    private boolean a(View view, Point point) {
        int i;
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (b.c(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && (i = point.x) >= iArr[0] && i <= iArr[0] + childAt.getWidth() && (i2 = point.y) >= iArr[1] && i2 <= iArr[1] + childAt.getHeight();
                }
                if (a(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected abstract void a(View view, float f, float f2, float f3, float f4, SparseArray<a> sparseArray, boolean z);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a()) {
            a(view, this.a, this.f564b, this.c, this.d, this.k, this.j);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0072  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        this.h = motionEvent.getDeviceId();
        this.g = motionEvent.getToolType(0);
        this.i = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 3;
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.f = System.currentTimeMillis();
                if (Math.abs(this.c - this.l) >= n || Math.abs(this.d - this.m) >= n) {
                    this.j = false;
                }
                Point point = new Point((int) this.c, (int) this.d);
                if (view != null && !b.c(view) && a((View) view.getParent(), point)) {
                    return true;
                }
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                q += Math.abs(motionEvent.getX() - o);
                r += Math.abs(motionEvent.getY() - p);
                o = motionEvent.getX();
                p = motionEvent.getY();
                if (System.currentTimeMillis() - s > 200) {
                    float f = q;
                    float f2 = n;
                    if (f > f2 || r > f2) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                } else {
                    i2 = 2;
                }
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                if (Math.abs(this.c - this.l) >= n || Math.abs(this.d - this.m) >= n) {
                    this.j = false;
                }
            }
            i = i2;
        } else {
            this.l = (int) motionEvent.getRawX();
            this.m = (int) motionEvent.getRawY();
            this.a = motionEvent.getRawX();
            this.f564b = motionEvent.getRawY();
            this.e = System.currentTimeMillis();
            this.g = motionEvent.getToolType(0);
            this.h = motionEvent.getDeviceId();
            this.i = motionEvent.getSource();
            s = System.currentTimeMillis();
            this.j = true;
            i = 0;
        }
        this.k.put(motionEvent.getActionMasked(), new a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public boolean a() {
        return this.j;
    }
}
