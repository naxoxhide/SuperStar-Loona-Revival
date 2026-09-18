package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;

/* JADX INFO: loaded from: classes4.dex */
public class MBImageView extends ImageView {
    private Bitmap a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2677b;

    public MBImageView(Context context) {
        super(context);
        this.a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public MBImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }

    public void setImageUrl(String str) {
        this.f2677b = str;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.a;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.onDraw(canvas);
        } else if (getContext() != null) {
            b.a(getContext()).a(this.f2677b, new c() { // from class: com.mbridge.msdk.widget.MBImageView.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap2, String str) {
                    MBImageView.this.setImageBitmap(bitmap2);
                }
            });
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.a = bitmap;
        if (bitmap != null && bitmap.isRecycled()) {
            this.a = null;
            super.setImageBitmap(null);
        } else {
            super.setImageBitmap(bitmap);
        }
    }
}
