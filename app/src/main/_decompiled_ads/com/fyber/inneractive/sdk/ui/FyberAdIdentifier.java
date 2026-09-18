package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class FyberAdIdentifier implements View.OnClickListener {
    public ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1325b;
    public Animator e;
    public ClickListener g;
    public Bitmap h;
    public Corner c = Corner.BOTTOM_LEFT;
    public boolean d = false;
    public float f = 0.0f;

    public interface ClickListener {
        void a();
    }

    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Corner.values().length];
            a = iArr;
            try {
                iArr[Corner.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Corner.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Corner.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Corner.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != this.a.getId()) {
            if (view.getId() != this.f1325b.getId() || this.g == null) {
                return;
            }
            a();
            this.g.a();
            return;
        }
        if (this.e != null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, (Property<ImageView, Float>) View.ROTATION_X, 90.0f);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.a, "imageAlpha", 255, 25);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt);
        animatorSet2.addListener(new c(this, animatorSet));
        animatorSet2.setDuration(225L);
        this.e = animatorSet2;
        animatorSet2.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.a, (Property<ImageView, Float>) View.ROTATION_X, 0.0f);
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.a, "imageAlpha", 25, 255);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(objectAnimatorOfFloat2, objectAnimatorOfInt2);
        animatorSet3.setDuration(225L);
        View view2 = this.f1325b;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        fArr[0] = this.d ? this.f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, fArr);
        objectAnimatorOfFloat3.setDuration(450L);
        animatorSet.setDuration(450L);
        animatorSet.playTogether(objectAnimatorOfFloat3, animatorSet3);
        animatorSet.addListener(new d(this));
    }

    public FyberAdIdentifier a(ClickListener clickListener) {
        this.g = clickListener;
        return this;
    }

    public final void a() {
        this.d = false;
        this.f1325b.setTranslationX(0.0f);
        this.a.setImageResource(R.drawable.fyber_info_button);
        Animator animator = this.e;
        if (animator != null) {
            animator.removeAllListeners();
            this.e = null;
        }
    }

    public static boolean a(FyberAdIdentifier fyberAdIdentifier) {
        Corner corner = fyberAdIdentifier.c;
        return corner == Corner.TOP_LEFT || corner == Corner.BOTTOM_LEFT;
    }
}
