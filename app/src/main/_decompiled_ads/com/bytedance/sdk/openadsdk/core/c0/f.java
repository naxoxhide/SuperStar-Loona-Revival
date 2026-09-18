package com.bytedance.sdk.openadsdk.core.c0;

import android.util.SparseArray;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TouchInfoHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static int m = 8;
    private static float n;
    private static float o;
    private static float p;
    private static float q;
    private static long r;
    public float a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f566b = -1.0f;
    public float c = -1.0f;
    public float d = -1.0f;
    public long e = -1;
    public long f = -1;
    public int g = -1;
    public int h = -1024;
    public int i = -1;
    public SparseArray<c.a> j = new SparseArray<>();
    private int k = 0;
    private int l = 0;

    static {
        if (o.a() != null) {
            m = o.e();
        }
        n = 0.0f;
        o = 0.0f;
        p = 0.0f;
        q = 0.0f;
        r = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0071  */
    public void a(MotionEvent motionEvent) {
        int i;
        this.h = motionEvent.getDeviceId();
        int i2 = 0;
        this.g = motionEvent.getToolType(0);
        this.i = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            i2 = 1;
            if (actionMasked == 1) {
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.f = System.currentTimeMillis();
                if (Math.abs(this.c - this.k) < m) {
                    Math.abs(this.d - this.l);
                }
                i = 3;
            } else if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                p += Math.abs(motionEvent.getX() - n);
                q += Math.abs(motionEvent.getY() - o);
                n = motionEvent.getX();
                o = motionEvent.getY();
                if (System.currentTimeMillis() - r > 200) {
                    float f = p;
                    float f2 = m;
                    if (f <= f2 && q <= f2) {
                        i2 = 2;
                    }
                } else {
                    i2 = 2;
                }
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                if (Math.abs(this.c - this.k) < m) {
                    Math.abs(this.d - this.l);
                }
            }
            this.j.put(motionEvent.getActionMasked(), new c.a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        this.k = (int) motionEvent.getRawX();
        this.l = (int) motionEvent.getRawY();
        this.a = motionEvent.getRawX();
        this.f566b = motionEvent.getRawY();
        this.e = System.currentTimeMillis();
        this.g = motionEvent.getToolType(0);
        this.h = motionEvent.getDeviceId();
        this.i = motionEvent.getSource();
        r = System.currentTimeMillis();
        i = i2;
        this.j.put(motionEvent.getActionMasked(), new c.a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
    }
}
