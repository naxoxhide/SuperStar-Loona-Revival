package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class CircleLongPressView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f301b;
    private ImageView c;
    private TextView d;
    private RingProgressView e;
    private AnimatorSet f;

    public CircleLongPressView(Context context) {
        super(context);
        this.f = new AnimatorSet();
        this.a = context;
        d();
        c();
    }

    private void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f.setDuration(800L);
        this.f.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void d() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.e = new RingProgressView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) d.a(this.a, 95.0f), (int) d.a(this.a, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.e, layoutParams);
        ImageView imageView = new ImageView(this.a);
        this.f301b = imageView;
        imageView.setImageResource(t.e(this.a, "tt_interact_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) d.a(this.a, 75.0f), (int) d.a(this.a, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.f301b, layoutParams2);
        ImageView imageView2 = new ImageView(this.a);
        this.c = imageView2;
        imageView2.setImageResource(t.e(this.a, "tt_interact_oval"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) d.a(this.a, 63.0f), (int) d.a(this.a, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.c, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.a);
        this.d = textView;
        textView.setTextColor(-1);
        this.d.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.d, layoutParams4);
    }

    public void a() {
        this.f.cancel();
    }

    public void b() {
        this.e.a();
        this.e.b();
    }

    public void e() {
        this.f.start();
    }

    public void f() {
        this.e.c();
    }

    public void setGuideText(String str) {
        this.d.setText(str);
    }
}
