package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;

/* JADX INFO: loaded from: classes2.dex */
public class MBSplashClickView extends MBRelativeLayout {
    public final int TYPE_SPLASH_BTN_CLICK;
    public final int TYPE_SPLASH_BTN_GO;
    public final int TYPE_SPLASH_BTN_OPEN;
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1959b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private String m;
    private int n;
    private ImageView o;
    private ImageView p;
    private final RectF q;
    private final Paint r;
    private final Paint s;

    public MBSplashClickView(Context context) {
        super(context);
        this.a = "浏览第三方应用";
        this.f1959b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.q = new RectF();
        this.r = new Paint();
        this.s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "浏览第三方应用";
        this.f1959b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.q = new RectF();
        this.r = new Paint();
        this.s = new Paint();
        a();
    }

    public MBSplashClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "浏览第三方应用";
        this.f1959b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
        this.g = "mbridge_splash_btn_arrow_right";
        this.h = "mbridge_splash_btn_circle";
        this.i = "mbridge_splash_btn_finger";
        this.j = "mbridge_splash_btn_go";
        this.k = "mbridge_splash_btn_light";
        this.l = "mbridge_expand_data";
        this.TYPE_SPLASH_BTN_OPEN = 1;
        this.TYPE_SPLASH_BTN_GO = 2;
        this.TYPE_SPLASH_BTN_CLICK = 3;
        this.q = new RectF();
        this.r = new Paint();
        this.s = new Paint();
        a();
    }

    private void a() {
        this.r.setAntiAlias(true);
        this.r.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.s.setAntiAlias(true);
        this.s.setColor(-1);
    }

    public void initView(String str) {
        boolean z;
        View viewA;
        this.m = str;
        str.hashCode();
        final int identifier = 0;
        switch (str) {
            case "Install":
            case "下载第三方应用":
                this.n = 3;
                z = true;
                break;
            case "Open":
            case "打开第三方应用":
                this.n = 1;
                z = true;
                break;
            case "View":
            case "浏览第三方应用":
                this.n = 2;
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            boolean zContains = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
            if (TextUtils.isEmpty(this.m)) {
                this.m = zContains ? "浏览第三方应用" : "View";
            }
            this.n = 2;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        String string = (viewGroup == null || (viewA = a(viewGroup, "mbridge_expand_data")) == null || !(viewA instanceof TextView)) ? "" : ((TextView) viewA).getText().toString();
        int i = this.n;
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
        textView.setText(this.m);
        this.o = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = null;
        int i2 = this.n;
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
            this.p = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(af.b(getContext(), 30.0f), af.b(getContext(), 30.0f));
            layoutParams4.addRule(11);
            layoutParams4.rightMargin = af.b(getContext(), 50.0f);
            layoutParams4.topMargin = af.b(getContext(), 5.0f);
            this.p.setLayoutParams(layoutParams4);
            this.p.setImageResource(getResources().getIdentifier("mbridge_splash_btn_circle", "drawable", b.d().b()));
            addView(this.p);
        }
        this.o.setLayoutParams(layoutParams2);
        if (TextUtils.isEmpty(string)) {
            this.o.setImageResource(identifier);
        } else {
            final ImageView imageView2 = this.o;
            if (imageView2 != null) {
                try {
                    if (TextUtils.isEmpty(string)) {
                        imageView2.setBackgroundResource(identifier);
                    }
                    com.mbridge.msdk.foundation.same.c.b.a(b.d().g()).a(string, new c() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.4
                        @Override // com.mbridge.msdk.foundation.same.c.c
                        public void onSuccessLoad(Bitmap bitmap, String str2) {
                            if (imageView2 != null) {
                                if (bitmap != null && !bitmap.isRecycled()) {
                                    if (MBSplashClickView.this.p != null) {
                                        MBSplashClickView mBSplashClickView = MBSplashClickView.this;
                                        mBSplashClickView.removeView(mBSplashClickView.p);
                                    }
                                    imageView2.setImageBitmap(bitmap);
                                    return;
                                }
                                imageView2.setBackgroundResource(identifier);
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.same.c.c
                        public void onFailedLoad(String str2, String str3) {
                            ImageView imageView3 = imageView2;
                            if (imageView3 != null) {
                                imageView3.setBackgroundResource(identifier);
                            }
                        }
                    });
                } catch (Exception e) {
                    aa.a("MBSplashClickView", e.getMessage());
                    if (imageView2 != null) {
                        imageView2.setBackgroundResource(identifier);
                    }
                }
            }
        }
        addView(textView);
        addView(this.o);
        invalidate();
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.q.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.q, this.s, 31);
        canvas.drawRoundRect(this.q, 200.0f, 200.0f, this.s);
        canvas.saveLayer(this.q, this.r, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBRelativeLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.n;
        if (i == 2) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(500L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.o.startAnimation(scaleAnimation);
            return;
        }
        if (i == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -100.0f, 0, 1000.0f, 0, 0.0f, 0, 0.0f);
            translateAnimation.setDuration(1000L);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.o.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(final Animation animation) {
                    MBSplashClickView.this.o.setVisibility(4);
                    MBSplashClickView.this.o.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.o.startAnimation(animation);
                        }
                    }, 2000L);
                }
            });
            this.o.startAnimation(translateAnimation);
            return;
        }
        if (i == 3) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(1000L);
            scaleAnimation2.setRepeatCount(-1);
            scaleAnimation2.setRepeatMode(2);
            final ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.0f, 0.5f, 0.0f, 0.5f, 1, 0.5f, 1, 0.5f);
            scaleAnimation3.setDuration(400L);
            scaleAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    MBSplashClickView.this.p.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MBSplashClickView.this.p.setVisibility(4);
                    MBSplashClickView.this.p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MBSplashClickView.this.p.startAnimation(scaleAnimation3);
                        }
                    }, 1600L);
                }
            });
            this.p.setVisibility(4);
            this.o.startAnimation(scaleAnimation2);
            this.p.postDelayed(new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.MBSplashClickView.2
                @Override // java.lang.Runnable
                public void run() {
                    MBSplashClickView.this.p.startAnimation(scaleAnimation3);
                }
            }, 800L);
        }
    }

    private View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (viewGroup.getId() == str.hashCode()) {
                        return viewGroup;
                    }
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getId() == str.hashCode()) {
                            return childAt;
                        }
                        if (childAt instanceof ViewGroup) {
                            a((ViewGroup) childAt, str);
                        }
                    }
                    return null;
                }
            } catch (Exception e) {
                aa.d("MBSplashClickView", e.getMessage());
            }
        }
        return null;
    }
}
