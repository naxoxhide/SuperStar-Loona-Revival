package com.bytedance.sdk.openadsdk.b.n;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: TTAppOpenAdTopLayoutHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private final com.bytedance.sdk.openadsdk.b.p.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.b.n.a f518b;
    private int c = 0;
    private float d = 5.0f;
    private int e = 0;
    private ValueAnimator f;
    private boolean g;

    /* JADX INFO: compiled from: TTAppOpenAdTopLayoutHelper.java */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.a.a(b.this.c);
            b.this.a(iIntValue);
        }
    }

    public b(com.bytedance.sdk.openadsdk.b.p.a aVar) {
        this.a = aVar;
    }

    public void c() {
        int i = (int) (this.d * 1000.0f);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, i);
        this.f = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i);
        this.f.setInterpolator(new LinearInterpolator());
        this.f.addUpdateListener(new a());
    }

    public void a(int i) {
        this.c = i;
        float f = (i * 1.0f) / 1000.0f;
        int iCeil = (int) Math.ceil(this.d - f);
        if (iCeil <= 0) {
            com.bytedance.sdk.openadsdk.b.n.a aVar = this.f518b;
            if (aVar != null && !this.g) {
                aVar.a();
                this.g = true;
            }
            iCeil = 0;
        }
        boolean z = f >= ((float) this.e);
        com.bytedance.sdk.openadsdk.b.n.a aVar2 = this.f518b;
        if (aVar2 != null) {
            aVar2.a(iCeil, i, z);
        }
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public void a(float f) {
        this.d = f;
        if (f <= 0.0f) {
            this.d = 5.0f;
        }
        c();
    }

    public void a(com.bytedance.sdk.openadsdk.b.n.a aVar) {
        this.f518b = aVar;
    }

    public ValueAnimator a() {
        return this.f;
    }
}
