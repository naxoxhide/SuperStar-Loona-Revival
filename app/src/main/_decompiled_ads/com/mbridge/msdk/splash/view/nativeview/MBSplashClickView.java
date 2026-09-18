package com.mbridge.msdk.splash.view.nativeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.af;

/* JADX INFO: loaded from: classes4.dex */
public class MBSplashClickView extends RelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2459b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private String l;
    private int m;
    private ImageView n;
    private ImageView o;
    private final RectF p;
    private final Paint q;
    private final Paint r;

    public MBSplashClickView(Context context) {
        super(context);
        this.a = "浏览第三方应用";
        this.f2459b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.p = new RectF();
        this.q = new Paint();
        this.r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "浏览第三方应用";
        this.f2459b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.p = new RectF();
        this.q = new Paint();
        this.r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "浏览第三方应用";
        this.f2459b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.p = new RectF();
        this.q = new Paint();
        this.r = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = "浏览第三方应用";
        this.f2459b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.p = new RectF();
        this.q = new Paint();
        this.r = new Paint();
    }

    private void a() {
        this.q.setAntiAlias(true);
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.r.setAntiAlias(true);
        this.r.setColor(-1);
    }

    public void initView(String str) {
        boolean z;
        this.l = str;
        str.hashCode();
        int identifier = 0;
        switch (str) {
            case "Install":
            case "下载第三方应用":
                this.m = 3;
                z = true;
                break;
            case "Open":
            case "打开第三方应用":
                this.m = 1;
                z = true;
                break;
            case "View":
            case "浏览第三方应用":
                this.m = 2;
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            boolean zContains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
            if (TextUtils.isEmpty(this.l)) {
                this.l = zContains ? "浏览第三方应用" : "View";
            }
            this.m = 2;
        }
        int i = this.m;
        int color = Color.parseColor("#666666");
        int color2 = Color.parseColor("#8FC31F");
        int color3 = Color.parseColor("#000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (i == 2) {
            gradientDrawable.setColor(color2);
        } else {
            gradientDrawable.setColor(color3);
            gradientDrawable.setStroke(2, color);
        }
        gradientDrawable.setCornerRadius(200);
        setBackground(gradientDrawable);
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(15);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(17);
        textView.setTextSize(20.0f);
        textView.setTextColor(-1);
        textView.setText(this.l);
        this.n = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = null;
        int i2 = this.m;
        if (i2 == 2) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_go", "drawable", b.d().b());
            layoutParams2 = new RelativeLayout.LayoutParams(af.b(getContext(), 35.0f), af.b(getContext(), 35.0f));
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = af.b(getContext(), 10.0f);
        } else if (i2 == 1) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_light", "drawable", b.d().b());
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = 20;
            layoutParams2.rightMargin = 20;
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            layoutParams3.rightMargin = af.b(getContext(), 50.0f);
            imageView.setImageResource(getResources().getIdentifier("mbridge_splash_btn_arrow_right", "drawable", b.d().b()));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setLayoutParams(layoutParams3);
            addView(imageView);
        } else if (i2 == 3) {
            identifier = getResources().getIdentifier("mbridge_splash_btn_finger", "drawable", b.d().b());
            layoutParams2 = new RelativeLayout.LayoutParams(af.b(getContext(), 25.0f), af.b(getContext(), 25.0f));
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = af.b(getContext(), 50.0f);
            layoutParams2.topMargin = af.b(getContext(), 18.0f);
            this.o = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(af.b(getContext(), 30.0f), af.b(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = af.b(getContext(), 50.0f);
            layoutParams4.topMargin = af.b(getContext(), 5.0f);
            this.o.setLayoutParams(layoutParams4);
            this.o.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", b.d().b()));
            addView(this.o);
        }
        this.n.setLayoutParams(layoutParams2);
        this.n.setImageResource(identifier);
        addView(textView);
        addView(this.n);
        invalidate();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.p.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.p, this.r, 31);
        canvas.drawRoundRect(this.p, 200.0f, 200.0f, this.r);
        canvas.saveLayer(this.p, this.q, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.m;
        if (i == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.n.startAnimation(scaleAnimation);
            return;
        }
        if (i == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.n.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.n.setVisibility(4);
                    MBSplashClickView.this.n.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.n.startAnimation(animation);
                        }
                    }, 2000L);
                }
            });
            this.n.startAnimation(translateAnimation);
            return;
        }
        if (i == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(400L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(200L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.o.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.o.setVisibility(4);
                    MBSplashClickView.this.o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBSplashClickView.this.o.startAnimation(scaleAnimation3);
                        }
                    }, 700L);
                }
            });
            this.o.setVisibility(4);
            this.n.startAnimation(scaleAnimation2);
            this.o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.splash.view.nativeview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBSplashClickView.this.o.startAnimation(scaleAnimation3);
                }
            }, 500L);
        }
    }
}
