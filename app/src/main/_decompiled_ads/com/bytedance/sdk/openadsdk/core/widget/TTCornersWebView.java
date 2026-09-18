package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class TTCornersWebView extends WebView {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f694b;
    private int c;
    private int d;
    private float[] e;

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.c = getScrollX();
        this.d = getScrollY();
        Path path = new Path();
        int i = this.d;
        path.addRoundRect(new RectF(0.0f, i, this.c + this.a, i + this.f694b), this.e, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a = getMeasuredWidth();
        this.f694b = getMeasuredHeight();
    }
}
