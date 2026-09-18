package com.igaworks.adpopcorn.activity.b;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class i extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.common.g f1539b;
    private String c;
    private long d;
    private TextView e;
    private TextView f;
    private ProgressBar g;
    private com.igaworks.adpopcorn.activity.c.j.a h;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Build.VERSION.SDK_INT > 11) {
                try {
                    i.this.e.setText(new DecimalFormat("###,###").format(valueAnimator.getAnimatedValue()));
                    i.this.g.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                } catch (Exception unused) {
                    i.this.e.setText(i.this.d + "");
                    i.this.g.setProgress((int) i.this.d);
                }
            }
        }
    }

    class b extends AnimatorListenerAdapter {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (i.this.isShowing()) {
                        i.this.dismiss();
                    }
                } catch (Exception unused) {
                }
            }
        }

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            new Handler().postDelayed(new a(), 1000L);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Build.VERSION.SDK_INT > 11) {
                try {
                    i.this.e.setText(new DecimalFormat("###,###").format(valueAnimator.getAnimatedValue()) + i.this.c);
                    i.this.h.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                } catch (Exception unused) {
                    i.this.e.setText(i.this.d + "" + i.this.c);
                    i.this.h.setProgress((int) i.this.d);
                }
            }
        }
    }

    class d extends AnimatorListenerAdapter {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (i.this.isShowing()) {
                        i.this.dismiss();
                    }
                } catch (Exception unused) {
                }
            }
        }

        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            new Handler().postDelayed(new a(), 1000L);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (i.this.isShowing()) {
                    i.this.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    public i(Context context, long j, String str, int i) {
        super(context, i);
        this.a = context;
        this.d = j;
        this.c = str;
        this.f1539b = com.igaworks.adpopcorn.cores.common.g.a();
    }

    private View a() {
        TextView textView;
        StringBuilder sb;
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        k.b(textView2, this.f1539b.t1, 26, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setGravity(17);
        textView2.setSingleLine();
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 320), com.igaworks.adpopcorn.cores.common.d.a(this.a, 320));
        layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 22);
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 320), com.igaworks.adpopcorn.cores.common.d.a(this.a, 320)));
        linearLayout2.setGravity(1);
        linearLayout2.setOrientation(1);
        frameLayout.addView(linearLayout2);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 160), com.igaworks.adpopcorn.cores.common.d.a(this.a, 60));
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 119);
        this.e.setLayoutParams(layoutParams2);
        k.b(this.e, this.f1539b.t1, 42, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.e.setGravity(17);
        this.e.setSingleLine();
        linearLayout2.addView(this.e);
        this.f = new TextView(this.a);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 320), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24)));
        k.b(this.f, this.c, 24, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.f.setGravity(17);
        this.f.setSingleLine();
        linearLayout2.addView(this.f);
        linearLayout.addView(frameLayout);
        ProgressBar progressBar = new ProgressBar(this.a, null, R.style.Widget.DeviceDefault.ProgressBar.Horizontal);
        this.g = progressBar;
        progressBar.setIndeterminate(false);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_PROGRESS_BAR_DRAWABLE_ID);
        if (iC == -100) {
            this.g.setProgressDrawable(this.a.getResources().getDrawable(com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_circular_progress_bar", "drawable")));
        } else {
            this.g.setProgressDrawable(this.a.getResources().getDrawable(iC));
        }
        this.g.setMax((int) this.d);
        this.g.setProgress(0);
        frameLayout.addView(this.g);
        if (Build.VERSION.SDK_INT > 11) {
            try {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setObjectValues(0, Integer.valueOf((int) this.d));
                valueAnimator.addUpdateListener(new a());
                valueAnimator.addListener(new b());
                valueAnimator.setDuration(800L);
                valueAnimator.start();
            } catch (Exception unused) {
                textView = this.e;
                if (textView != null) {
                    sb = new StringBuilder();
                    textView.setText(sb.append(this.d).append("").toString());
                }
            }
        } else {
            textView = this.e;
            if (textView != null) {
                sb = new StringBuilder();
                textView.setText(sb.append(this.d).append("").toString());
            }
        }
        return linearLayout;
    }

    private View b() {
        TextView textView;
        StringBuilder sb;
        FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 280), com.igaworks.adpopcorn.cores.common.d.a(this.a, 280));
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 41), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 67);
        layoutParams2.gravity = 1;
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(com.igaworks.adpopcorn.R.drawable.onestore_ic_sc_appicon);
        linearLayout.addView(imageView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        textView2.setLayoutParams(layoutParams3);
        k.b(textView2, this.f1539b.l2, 22, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setGravity(17);
        textView2.setSingleLine();
        linearLayout.addView(textView2);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        k.b(textView3, this.f1539b.t1, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_PRE_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setGravity(17);
        textView3.setSingleLine();
        linearLayout.addView(textView3);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 17;
        linearLayout2.setGravity(1);
        linearLayout2.setLayoutParams(layoutParams4);
        linearLayout.addView(linearLayout2);
        this.e = new TextView(this.a);
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20)));
        k.b(this.e, this.f1539b.t1 + this.c, 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.e.setGravity(17);
        this.e.setSingleLine();
        linearLayout2.addView(this.e);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 280), com.igaworks.adpopcorn.cores.common.d.a(this.a, 280));
        layoutParams5.gravity = 17;
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        linearLayout3.setLayoutParams(layoutParams5);
        com.igaworks.adpopcorn.activity.c.j.a aVar = new com.igaworks.adpopcorn.activity.c.j.a(this.a, 3);
        this.h = aVar;
        aVar.setStyle(2);
        this.h.setProgressBackgroundColor(Color.parseColor("#878787"));
        this.h.setProgressStartColor(Color.parseColor("#ffffff"));
        this.h.setProgressEndColor(Color.parseColor("#ffffff"));
        this.h.setMax((int) this.d);
        this.h.setProgress(0);
        linearLayout3.addView(this.h);
        frameLayout.addView(linearLayout3);
        if (Build.VERSION.SDK_INT > 11) {
            try {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setObjectValues(0, Integer.valueOf((int) this.d));
                valueAnimator.addUpdateListener(new c());
                valueAnimator.addListener(new d());
                valueAnimator.setDuration(1200L);
                valueAnimator.start();
            } catch (Exception unused) {
                textView = this.e;
                if (textView != null) {
                    sb = new StringBuilder();
                    textView.setText(sb.append(this.d).append("").append(this.c).toString());
                }
            }
        } else {
            textView = this.e;
            if (textView != null) {
                sb = new StringBuilder();
                textView.setText(sb.append(this.d).append("").append(this.c).toString());
            }
        }
        frameLayout.addView(linearLayout);
        return frameLayout;
    }

    private View c() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#d1000000"));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 270), com.igaworks.adpopcorn.cores.common.d.a(this.a, 210));
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 150);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundResource(com.igaworks.adpopcorn.R.drawable.tpmn_bggradient);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        k.b(textView, this.f1539b.t1 + "!", 18, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView.setGravity(17);
        textView.getPaint().setShader(new LinearGradient(0.0f, 0.0f, textView.getWidth(), textView.getTextSize(), new int[]{Color.parseColor("#aed9ff"), Color.parseColor("#e3c7ff")}, (float[]) null, Shader.TileMode.CLAMP));
        textView.getPaint().setShadowLayer(com.igaworks.adpopcorn.cores.common.d.a(this.a, 4), com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), Color.parseColor("#80000000"));
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 270), com.igaworks.adpopcorn.cores.common.d.a(this.a, 39));
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        linearLayout2.addView(linearLayout3);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 26), com.igaworks.adpopcorn.cores.common.d.a(this.a, 23));
        layoutParams4.gravity = 16;
        imageView.setLayoutParams(layoutParams4);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(com.igaworks.adpopcorn.R.drawable.tpmn_berricon);
        linearLayout3.addView(imageView);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        this.e.getPaint().setShadowLayer(com.igaworks.adpopcorn.cores.common.d.a(this.a, 4), com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), Color.parseColor("#80000000"));
        this.e.setLayoutParams(layoutParams5);
        k.b(this.e, new DecimalFormat("###,###").format(this.d) + "", 33, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        this.e.setGravity(17);
        this.e.setSingleLine();
        linearLayout3.addView(this.e);
        this.f = new TextView(this.a);
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19)));
        k.b(this.f, this.c, 16, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_TOTAL_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        this.f.setGravity(17);
        this.f.setSingleLine();
        this.f.getPaint().setShadowLayer(com.igaworks.adpopcorn.cores.common.d.a(this.a, 4), com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), Color.parseColor("#80000000"));
        linearLayout3.addView(this.f);
        new Handler().postDelayed(new e(), 3000L);
        return linearLayout;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        View viewC;
        super.onCreate(bundle);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        if (iC == 1) {
            fC = 0.8f;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        getWindow().setAttributes(layoutParams);
        if (iC == 1) {
            viewC = b();
        } else {
            viewC = iC == 2 ? c() : a();
        }
        setContentView(viewC);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
