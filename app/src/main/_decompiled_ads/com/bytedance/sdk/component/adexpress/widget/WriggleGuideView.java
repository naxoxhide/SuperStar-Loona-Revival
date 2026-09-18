package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.component.utils.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WriggleGuideView extends View {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f326b;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private int f;
    private final List<Object> g;
    private boolean h;
    private boolean i;
    private a j;

    public interface a {
        void a();
    }

    public WriggleGuideView(Context context) {
        this(context, null);
    }

    private Bitmap a(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), t.e(getContext(), "tt_wriggle_union"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), this.e);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap b(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getContext().getResources(), t.e(getContext(), "tt_wriggle_union_white"));
        if (bitmapDecodeResource != null) {
            canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
        }
        return bitmapCreateBitmap;
    }

    private Bitmap c(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.f, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.j != null) {
            this.j = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            this.a = getWidth();
            int height = getHeight();
            this.f326b = height;
            this.c = a(this.a, height);
            this.d = b(this.a, this.f326b);
            this.h = false;
        }
        canvas.drawBitmap(this.c, 0.0f, 0.0f, this.e);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, this.e);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(c(this.a, this.f326b), 0.0f, 0.0f, this.e);
        this.e.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.i) {
            this.f += 5;
            invalidate();
            if (this.f >= this.a) {
                a aVar = this.j;
                if (aVar != null) {
                    aVar.a();
                }
                this.i = false;
            }
        }
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WriggleGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.f326b = 0;
        this.f = 0;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.h = true;
        this.i = false;
        setLayerType(1, null);
        this.e = new Paint();
        this.e = new Paint(1);
        arrayList.clear();
    }
}
