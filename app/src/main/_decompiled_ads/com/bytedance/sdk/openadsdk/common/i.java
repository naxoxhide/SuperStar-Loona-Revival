package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TTTitleNewStyleManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f535b;
    private Context c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private ProgressBar g;
    TTAdDislikeDialog h;
    TTAdDislikeToast i;
    final AtomicBoolean j = new AtomicBoolean(false);
    final AtomicBoolean k = new AtomicBoolean(false);
    private final int l = b0.a(o.a(), 44.0f);
    private boolean m;

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.e();
        }
    }

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.MarginLayoutParams a;

        b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            this.a.topMargin = num.intValue();
            i.this.a.setLayoutParams(this.a);
        }
    }

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.m = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.m = true;
        }
    }

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.MarginLayoutParams a;

        d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.a = marginLayoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Integer num = (Integer) valueAnimator.getAnimatedValue();
            this.a.topMargin = num.intValue();
            i.this.a.setLayoutParams(this.a);
        }
    }

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.this.m = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.this.m = true;
        }
    }

    /* JADX INFO: compiled from: TTTitleNewStyleManager.java */
    class f implements TTAdDislikeDialog.e {
        f() {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(View view) {
            i.this.j.set(true);
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void b(View view) {
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void c(View view) {
            i.this.j.set(false);
        }

        @Override // com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog.e
        public void a(int i, FilterWord filterWord) {
            if (i.this.k.get() || filterWord == null || filterWord.hasSecondOptions()) {
                return;
            }
            i.this.k.set(true);
        }
    }

    public i(Context context, RelativeLayout relativeLayout, q qVar) {
        this.c = context;
        this.a = relativeLayout;
        this.f535b = qVar;
        d();
    }

    private void c() {
        try {
            if (this.h == null) {
                TTAdDislikeDialog tTAdDislikeDialog = new TTAdDislikeDialog(this.c, this.f535b);
                this.h = tTAdDislikeDialog;
                tTAdDislikeDialog.setCallback(new f());
            }
            ((FrameLayout) this.a.getRootView().findViewById(R.id.content)).addView(this.h);
            if (this.i == null) {
                this.i = new TTAdDislikeToast(this.c);
                ((FrameLayout) this.a.getRootView().findViewById(R.id.content)).addView(this.i);
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        this.d = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.d0);
        this.e = (TextView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.e0);
        this.f = (ImageView) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.f0);
        this.g = (ProgressBar) this.a.findViewById(com.bytedance.sdk.openadsdk.utils.h.g0);
        q qVar = this.f535b;
        if (qVar != null) {
            this.e.setText(TextUtils.isEmpty(qVar.K0()) ? t.k(this.c, "tt_web_title_default") : this.f535b.K0());
        }
        this.f.setOnClickListener(new a());
    }

    private void f() {
        this.i.a(TTAdDislikeToast.getDislikeTip());
    }

    public void b() {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            if (this.m || marginLayoutParams.topMargin != 0) {
                return;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, -this.l);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new d(marginLayoutParams));
            valueAnimatorOfInt.addListener(new e());
            valueAnimatorOfInt.start();
        } catch (Throwable unused) {
        }
    }

    protected void e() {
        if (this.k.get()) {
            f();
            return;
        }
        if (this.h == null) {
            c();
        }
        this.h.q();
    }

    public void g() {
        try {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            if (this.m) {
                return;
            }
            int i = marginLayoutParams.topMargin;
            int i2 = -this.l;
            if (i == i2) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i2, 0);
                valueAnimatorOfInt.setDuration(300L);
                valueAnimatorOfInt.addUpdateListener(new b(marginLayoutParams));
                valueAnimatorOfInt.addListener(new c());
                valueAnimatorOfInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(WebView webView, int i) {
        if (i == 100) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.g.setProgress(i);
        }
    }

    public ImageView a() {
        return this.d;
    }
}
