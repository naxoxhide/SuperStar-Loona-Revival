package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: CoverDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends GradientDrawable {
    private final Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Path f274b;

    public b() {
        this.f274b = new Path();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
    }

    protected void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.f274b;
        if (path == null || path.isEmpty()) {
            a(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.a, 31);
        a(canvas);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawPath(this.f274b, this.a);
        this.a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f274b.addRect(i, i2, i3, i4, Path.Direction.CW);
        invalidateSelf();
    }

    public b(GradientDrawable.Orientation orientation, int[] iArr) {
        super(orientation, iArr);
        this.f274b = new Path();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
    }
}
