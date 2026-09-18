package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends PAGFrameLayout {
    private static int h = -1;
    private static int i;
    private static int j;
    private static int k;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f696b;
    private Drawable c;
    private Drawable d;
    private double e;
    private LinearLayout f;
    private LinearLayout g;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.a, (int) this.f696b));
        imageView.setPadding(h, i, j, k);
        return imageView;
    }

    private void m() {
        Context context = getContext();
        this.f = new LinearLayout(context);
        this.g = new LinearLayout(context);
        this.f.setOrientation(0);
        this.f.setGravity(GravityCompat.START);
        this.g.setOrientation(0);
        this.g.setGravity(GravityCompat.START);
        if (h < 0) {
            int iA = (int) b0.a(context, 1.0f, false);
            h = iA;
            j = iA;
            k = (int) b0.a(context, 3.0f, false);
        }
        this.c = t.f(context, "tt_star_thick");
        this.d = t.f(context, "tt_star");
    }

    public void a(double d, int i2, int i3) {
        float f = i3;
        this.a = (int) b0.a(getContext(), f, false);
        this.f696b = (int) b0.a(getContext(), f, false);
        this.e = d;
        this.f.removeAllViews();
        this.g.removeAllViews();
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.g.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.f.addView(starImageView2);
        }
        addView(this.f);
        addView(this.g);
        requestLayout();
    }

    public Drawable getStarEmptyDrawable() {
        return this.c;
    }

    public Drawable getStarFillDrawable() {
        return this.d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f.measure(i2, i3);
        double d = this.e;
        int i4 = (int) d;
        float f = this.a;
        int i5 = h;
        this.g.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((i4 * f) + i5)) + (((double) (f - (i5 + j))) * (d - ((double) i4)))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f.getMeasuredHeight(), 1073741824));
    }

    public TTRatingBar2(Context context) {
        super(context);
        m();
    }
}
