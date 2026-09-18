package com.fyber.inneractive.sdk.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.fyber.inneractive.sdk.util.l;

/* JADX INFO: loaded from: classes2.dex */
public class IAcloseButton extends View {
    public Paint a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f1326b;

    public IAcloseButton(Context context, int i, boolean z) {
        super(context);
        int iB = l.b(10);
        int i2 = (z ? (i - (iB * 2)) / 4 : 0) + iB;
        Point point = new Point(i2, i2);
        int i3 = i - i2;
        Point point2 = new Point(i2, i3);
        Point point3 = new Point(i3, i3);
        Point point4 = new Point(i3, i2);
        Path path = new Path();
        this.f1326b = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f1326b.moveTo(point.x, point.y);
        this.f1326b.lineTo(point3.x, point3.y);
        this.f1326b.moveTo(point2.x, point2.y);
        this.f1326b.lineTo(point4.x, point4.y);
        this.f1326b.close();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStrokeWidth(l.b(2));
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setAntiAlias(true);
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(-1436657061);
            gradientDrawable.setStroke(l.b(2), -1);
            l.a(this, gradientDrawable);
        }
        setPadding(iB, iB, iB, iB);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f1326b, this.a);
    }
}
