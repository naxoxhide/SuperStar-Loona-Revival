package com.tapjoy.internal;

import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class r0 implements View.OnTouchListener {
    public final /* synthetic */ u2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitmapDrawable f2805b;
    public final /* synthetic */ u2 c;
    public final /* synthetic */ BitmapDrawable d;

    public r0(u2 u2Var, BitmapDrawable bitmapDrawable, u2 u2Var2, BitmapDrawable bitmapDrawable2) {
        this.a = u2Var;
        this.f2805b = bitmapDrawable;
        this.c = u2Var2;
        this.d = bitmapDrawable2;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        u2 u2Var;
        if (motionEvent.getAction() == 0) {
            if (this.a != null || this.f2805b != null) {
                u2 u2Var2 = this.c;
                if (u2Var2 != null) {
                    u2Var2.b();
                    this.c.setVisibility(4);
                }
                ta.a(view, null);
            }
            BitmapDrawable bitmapDrawable = this.f2805b;
            if (bitmapDrawable != null) {
                ta.a(view, bitmapDrawable);
            } else {
                u2 u2Var3 = this.a;
                if (u2Var3 != null) {
                    u2Var3.setVisibility(0);
                    u2 u2Var4 = this.a;
                    u2Var4.d = true;
                    u2Var4.a();
                }
            }
        } else if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z = x < 0.0f || x >= ((float) view.getWidth()) || y < 0.0f || y >= ((float) view.getHeight());
            if (z) {
                BitmapDrawable bitmapDrawable2 = this.d;
                if (bitmapDrawable2 != null) {
                    ta.a(view, bitmapDrawable2);
                } else if (this.f2805b != null) {
                    ta.a(view, null);
                }
            }
            u2 u2Var5 = this.a;
            if (u2Var5 != null) {
                u2Var5.b();
                this.a.setVisibility(4);
            }
            if ((this.a != null || this.f2805b != null) && (u2Var = this.c) != null && z) {
                u2Var.setVisibility(0);
                u2 u2Var6 = this.c;
                u2Var6.d = true;
                u2Var6.a();
            }
        }
        return false;
    }
}
