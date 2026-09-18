package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGProgressBar;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.p;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.Locale;

/* JADX INFO: compiled from: LandingPageLoadingFirstStyle.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends e {
    private TextView g;
    private TextView h;
    private ProgressBar i;
    private TextView j;
    private FrameLayout k;
    AnimatorSet l;
    private int m;

    /* JADX INFO: compiled from: LandingPageLoadingFirstStyle.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.l == null) {
                dVar.l = new AnimatorSet();
                d dVar2 = d.this;
                AnimatorSet.Builder builderPlay = dVar2.l.play(dVar2.b(dVar2.g));
                d dVar3 = d.this;
                builderPlay.with(dVar3.a(dVar3.h));
                d.this.l.setDuration(500L);
            }
            d.this.l.start();
        }
    }

    /* JADX INFO: compiled from: LandingPageLoadingFirstStyle.java */
    class b extends AnimatorListenerAdapter {
        final /* synthetic */ TextView a;

        b(TextView textView) {
            this.a = textView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d dVar = d.this;
            String[] strArr = dVar.c;
            if (strArr == null || strArr.length < 2 || dVar.k == null) {
                return;
            }
            d.this.b(2000);
            d.this.g();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            TextView textView = this.a;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public d(Context context, String str, String[] strArr, n nVar, p pVar) {
        super(context, str, strArr, nVar, pVar);
        this.m = 0;
    }

    private View f() {
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this.e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        pAGLinearLayout.setGravity(17);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(layoutParams);
        int iA = b0.a(this.e, 68.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(this.e);
        pAGLinearLayout.addView(tTRoundRectImageView, new LinearLayout.LayoutParams(iA, iA));
        PAGTextView pAGTextView = new PAGTextView(this.e);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b0.a(this.e, 170.0f), -2);
        layoutParams2.topMargin = b0.a(this.e, 8.0f);
        pAGTextView.setEllipsize(TextUtils.TruncateAt.END);
        pAGTextView.setGravity(17);
        pAGTextView.setMaxWidth(b0.a(this.e, 150.0f));
        pAGTextView.setMaxLines(2);
        pAGTextView.setTextColor(Color.parseColor("#222222"));
        pAGTextView.setTextSize(18.0f);
        pAGLinearLayout.addView(pAGTextView, layoutParams2);
        this.k = new PAGFrameLayout(this.e);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = b0.a(this.e, 244.0f);
        layoutParams3.height = b0.a(this.e, 24.0f);
        layoutParams3.topMargin = b0.a(this.e, 16.0f);
        pAGLinearLayout.addView(this.k, layoutParams3);
        this.g = new PAGTextView(this.e);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setVisibility(4);
        layoutParams4.gravity = 17;
        int iE = t.e(this.e, "tt_landingpage_loading_text_rect");
        this.g.setBackgroundResource(iE);
        this.g.setGravity(17);
        this.g.setMaxLines(1);
        int iA2 = b0.a(this.e, 12.0f);
        int iA3 = b0.a(this.e, 4.0f);
        this.g.setPadding(iA2, iA3, iA2, iA3);
        int color = Color.parseColor("#1A73E8");
        this.g.setTextColor(color);
        this.g.setTextSize(12.0f);
        this.k.addView(this.g, layoutParams4);
        this.h = new PAGTextView(this.e);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -1);
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        layoutParams5.gravity = 17;
        this.h.setBackgroundResource(iE);
        this.h.setGravity(17);
        this.h.setMaxLines(1);
        this.h.setPadding(iA2, iA3, iA2, iA3);
        this.h.setTextColor(color);
        this.h.setTextSize(12.0f);
        this.k.addView(this.h, layoutParams5);
        PAGLinearLayout pAGLinearLayout2 = new PAGLinearLayout(this.e);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        int iA4 = b0.a(this.e, 21.0f);
        int iA5 = b0.a(this.e, 43.0f);
        layoutParams6.topMargin = iA4;
        pAGLinearLayout2.setOrientation(0);
        pAGLinearLayout2.setPadding(iA5, 0, 0, 0);
        pAGLinearLayout.addView(pAGLinearLayout2, layoutParams6);
        this.i = new PAGProgressBar(this.e, null, R.style.Widget.ProgressBar.Horizontal);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(b0.a(this.e, 160.0f), iA2);
        layoutParams7.gravity = 16;
        this.i.setMax(100);
        this.i.setProgress(1);
        this.i.setProgressDrawable(t.f(this.e, "tt_full_reward_loading_progress_style"));
        pAGLinearLayout2.addView(this.i, layoutParams7);
        this.j = new PAGTextView(this.e);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(b0.a(this.e, 35.0f), -2);
        this.j.setMaxLines(1);
        layoutParams8.leftMargin = b0.a(this.e, 8.0f);
        this.j.setTextColor(Color.parseColor("#161823"));
        this.j.setTextSize(14.0f);
        pAGLinearLayout2.addView(this.j, layoutParams8);
        if (TextUtils.isEmpty(this.f530b)) {
            pAGTextView.setVisibility(8);
        } else {
            pAGTextView.setText(this.f530b);
        }
        n nVar = this.a;
        if (nVar == null || TextUtils.isEmpty(nVar.d())) {
            tTRoundRectImageView.setVisibility(8);
        } else {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.a, tTRoundRectImageView, (q) null);
        }
        return pAGLinearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String[] strArr = this.c;
        if (strArr == null) {
            return;
        }
        if (this.m >= strArr.length) {
            this.m = 0;
        }
        TextView textView = this.g;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.g.setVisibility(0);
            }
            this.g.setText(this.c[this.m]);
            this.g.setY(0.0f);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            int i = this.m + 1;
            String[] strArr2 = this.c;
            textView2.setText(strArr2[i < strArr2.length ? i : 0]);
            this.h.setVisibility(4);
        }
        this.m++;
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void e() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    protected void c() {
        if (this.e == null) {
            return;
        }
        this.d = f();
        String[] strArr = this.c;
        if (strArr == null || strArr.length <= 0) {
            FrameLayout frameLayout = this.k;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(strArr[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void d() {
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        FrameLayout frameLayout = this.k;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        this.k.postDelayed(new a(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator a(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "translationY", this.k.getHeight() + b0.a(this.e, 10.0f), 0.0f);
        objectAnimatorOfFloat.addListener(new b(textView));
        return objectAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ObjectAnimator b(TextView textView) {
        return ObjectAnimator.ofFloat(textView, "translationY", 0.0f, -this.k.getHeight());
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void a(int i) {
        ProgressBar progressBar = this.i;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.common.e
    public void a() {
        super.a();
    }
}
