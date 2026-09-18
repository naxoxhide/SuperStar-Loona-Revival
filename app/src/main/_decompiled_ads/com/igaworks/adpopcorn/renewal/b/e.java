package com.igaworks.adpopcorn.renewal.b;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class e extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1655b;
    private String c;
    private long d;
    private TextView e;
    private ProgressBar f;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (Build.VERSION.SDK_INT > 11) {
                try {
                    String str = new DecimalFormat("###,###").format(valueAnimator.getAnimatedValue());
                    e.this.f.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    k.a(e.this.e, str + e.this.c, 34, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                } catch (Exception unused) {
                    e.this.f.setProgress((int) e.this.d);
                    k.a(e.this.e, e.this.d + e.this.c, 34, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
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
                    if (e.this.isShowing()) {
                        e.this.dismiss();
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

    public e(Context context, long j, String str, int i) {
        super(context, i);
        this.a = context;
        this.d = j;
        this.c = str;
        this.f1655b = g.a();
    }

    private View a() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 360), com.igaworks.adpopcorn.cores.common.d.a(this.a, 360));
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO));
        layoutParams2.gravity = 17;
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        frameLayout.addView(linearLayout2);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 120);
        textView.setLayoutParams(layoutParams3);
        k.a(textView, this.f1655b.t1, 16, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView.setGravity(17);
        textView.setSingleLine();
        linearLayout2.addView(textView);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 160), -2);
        layoutParams4.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        this.e.setLayoutParams(layoutParams4);
        this.e.setGravity(17);
        this.e.setSingleLine();
        linearLayout2.addView(this.e);
        linearLayout.addView(frameLayout);
        ProgressBar progressBar = new ProgressBar(this.a, null, R.style.Widget.DeviceDefault.ProgressBar.Horizontal);
        this.f = progressBar;
        progressBar.setIndeterminate(false);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.SPLASH_DIALOG_PROGRESS_BAR_DRAWABLE_ID);
        if (iC == -100) {
            this.f.setProgressDrawable(this.a.getResources().getDrawable(com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_circular_progress_bar", "drawable")));
        } else {
            this.f.setProgressDrawable(this.a.getResources().getDrawable(iC));
        }
        this.f.setMax((int) this.d);
        this.f.setProgress(0);
        frameLayout.addView(this.f);
        if (Build.VERSION.SDK_INT > 11) {
            try {
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setObjectValues(0, Integer.valueOf((int) this.d));
                valueAnimator.addUpdateListener(new a());
                valueAnimator.addListener(new b());
                valueAnimator.setDuration(800L);
                valueAnimator.start();
            } catch (Exception unused) {
                TextView textView2 = this.e;
                if (textView2 != null) {
                    k.a(textView2, this.d + this.c, 34, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
                }
            }
        } else {
            TextView textView3 = this.e;
            if (textView3 != null) {
                k.a(textView3, this.d + this.c, 34, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
            }
        }
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
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        getWindow().setAttributes(layoutParams);
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        i.a(getWindow().getDecorView());
    }
}
