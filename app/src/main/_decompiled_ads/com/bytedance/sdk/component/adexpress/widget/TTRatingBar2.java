package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import b.b.a.a.d.d.i.j;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTRatingBar2 extends FrameLayout {
    private static final int i = (j.a("", 0.0f, true)[1] / 2) + 1;
    private static final int j = (j.a("", 0.0f, true)[1] / 2) + 3;
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f322b;
    private Drawable c;
    private Drawable d;
    private double e;
    private float f;
    LinearLayout g;
    LinearLayout h;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new LinearLayout(getContext());
        this.h = new LinearLayout(getContext());
        this.g.setOrientation(0);
        this.g.setGravity(GravityCompat.START);
        this.h.setOrientation(0);
        this.h.setGravity(GravityCompat.START);
        this.c = t.f(context, "tt_star_thick");
        this.d = t.f(context, "tt_star");
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.a, (int) this.f322b));
        imageView.setPadding(1, i, 1, j);
        return imageView;
    }

    public void a(double d, int i2, int i3, int i4) {
        float f = i3;
        this.a = (int) d.b(getContext(), f);
        this.f322b = (int) d.b(getContext(), f);
        this.e = d;
        this.f = i4;
        removeAllViews();
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.h.addView(starImageView);
        }
        for (int i6 = 0; i6 < 5; i6++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.g.addView(starImageView2);
        }
        addView(this.g);
        addView(this.h);
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
        this.g.measure(i2, i3);
        double d = this.e;
        int i4 = (int) d;
        float f = this.a;
        this.h.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((i4 * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) i4)))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.g.getMeasuredHeight(), 1073741824));
        if (this.f > 0.0f) {
            LinearLayout linearLayout = this.g;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.f)) / 2, 0, 0);
            this.h.setPadding(0, ((int) (this.g.getMeasuredHeight() - this.f)) / 2, 0, 0);
        }
    }
}
