package com.gomfactory.adpie.sdk.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedLinearLayout extends LinearLayout {
    float mCornerRadius;
    Path mPath;

    public RoundedLinearLayout(Context context) {
        super(context);
        if (Build.VERSION.SDK_INT >= 16) {
            setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT > 11) {
            setLayerType(1, null);
        }
    }

    public RoundedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (Build.VERSION.SDK_INT >= 16) {
            setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT > 11) {
            setLayerType(1, null);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        try {
            canvas.save();
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restore();
        } catch (UnsupportedOperationException unused) {
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        Path path = new Path();
        this.mPath = path;
        float f = this.mCornerRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        this.mPath.close();
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = i;
        invalidate();
    }
}
