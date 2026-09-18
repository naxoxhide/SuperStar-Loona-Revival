package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes2.dex */
public class f extends VideoView {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1571b;
    private boolean c;

    public f(Context context, int i, int i2) {
        super(context, null);
        this.c = false;
        this.a = i;
        this.f1571b = i2;
        this.c = true;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.c = false;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c) {
            setMeasuredDimension(this.a, this.f1571b);
        } else {
            Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
            setMeasuredDimension(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
    }
}
