package com.tapjoy;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes4.dex */
public class TJImageButton extends ImageButton {
    public Bitmap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f2693b;

    public TJImageButton(Context context) {
        super(context);
    }

    public void setDisableImageBitmap(Bitmap bitmap) {
        this.f2693b = bitmap;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setImageBitmap(z ? this.a : this.f2693b);
    }

    public void setEnabledImageBitmap(Bitmap bitmap) {
        this.a = bitmap;
    }

    public TJImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TJImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TJImageButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
