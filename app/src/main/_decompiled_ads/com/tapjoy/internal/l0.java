package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 extends View {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f2776b;
    public Rect c;
    public Rect d;
    public Rect e;
    public final Rect f;

    public l0(Context context) {
        super(context);
        this.a = false;
        this.f2776b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = new Rect();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.e == null || this.f2776b == null) {
            return;
        }
        getDrawingRect(this.f);
        canvas.drawBitmap(this.f2776b, this.e, this.f, (Paint) null);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f2776b = bitmap;
        int width = bitmap.getWidth();
        int height = this.f2776b.getHeight();
        int i = width / 2;
        this.d = new Rect(0, 0, i, height);
        Rect rect = new Rect(i, 0, width, height);
        this.c = rect;
        if (this.a) {
            this.e = rect;
        } else {
            this.e = this.d;
        }
    }
}
