package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.customview.PAGFrameLayout;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.b0;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressView extends PAGFrameLayout {
    protected final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected NativeExpressView f558b;
    protected NativeExpressView c;
    protected q d;
    protected AdSlot e;
    protected PAGBannerAdWrapperListener f;
    protected int g;
    protected boolean h;
    protected String i;

    class a implements PAGBannerAdWrapperListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdClicked(View view, int i) {
            BannerExpressView bannerExpressView = BannerExpressView.this;
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = bannerExpressView.f;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onAdClicked(bannerExpressView, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdDismissed() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderSuccess(View view, float f, float f2) {
            BannerExpressView.this.a(f, f2);
            NativeExpressView nativeExpressView = BannerExpressView.this.c;
            if (nativeExpressView != null) {
                nativeExpressView.setSoundMute(true);
            }
            BannerExpressView.this.s();
        }
    }

    class b implements PAGBannerAdWrapperListener {
        b() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdClicked(View view, int i) {
            BannerExpressView bannerExpressView = BannerExpressView.this;
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = bannerExpressView.f;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onAdClicked(bannerExpressView, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdDismissed() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderFail(View view, String str, int i) {
            BannerExpressView bannerExpressView = BannerExpressView.this;
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = bannerExpressView.f;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onRenderFail(bannerExpressView, str, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderSuccess(View view, float f, float f2) {
            NativeExpressView nativeExpressView = BannerExpressView.this.f558b;
            if (nativeExpressView != null) {
                nativeExpressView.setSoundMute(true);
            }
            BannerExpressView.this.a(f, f2);
            BannerExpressView bannerExpressView = BannerExpressView.this;
            PAGBannerAdWrapperListener pAGBannerAdWrapperListener = bannerExpressView.f;
            if (pAGBannerAdWrapperListener != null) {
                pAGBannerAdWrapperListener.onRenderSuccess(bannerExpressView, f, f2);
            }
        }
    }

    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BannerExpressView bannerExpressView = BannerExpressView.this;
            bannerExpressView.h = false;
            bannerExpressView.p();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public BannerExpressView(Context context, q qVar, AdSlot adSlot) {
        super(context);
        this.i = "banner_ad";
        this.a = context;
        this.d = qVar;
        this.e = adSlot;
        m();
        AdSlot adSlot2 = this.e;
        if (adSlot2 != null) {
            a(adSlot2.getExpressViewAcceptedWidth(), this.e.getExpressViewAcceptedHeight());
        }
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        NativeExpressView nativeExpressView = this.f558b;
        this.f558b = this.c;
        this.c = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.c.q();
            this.c = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.f558b;
    }

    public NativeExpressView getNextView() {
        return this.c;
    }

    protected void m() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, this.d, this.e, this.i);
        this.f558b = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean n() {
        return this.c != null;
    }

    public void o() {
        if (this.f558b != null) {
            h.a().f(this.f558b.getClosedListenerKey());
            removeView(this.f558b);
            this.f558b.q();
            this.f558b = null;
        }
        if (this.c != null) {
            h.a().f(this.c.getClosedListenerKey());
            removeView(this.c);
            this.c.q();
            this.c = null;
        }
        h.a().v();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f558b == null) {
            m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void q() {
        NativeExpressView nativeExpressView = this.f558b;
        if (nativeExpressView != null) {
            nativeExpressView.C();
        }
    }

    public void r() {
        NativeExpressView nativeExpressView = this.c;
        if (nativeExpressView != null) {
            nativeExpressView.C();
        }
    }

    protected void s() {
        try {
            if (this.h || this.c == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(b(this.f558b)).with(a(this.c));
            animatorSet.setDuration(this.g).start();
            b0.a((View) this.c, 0);
            this.h = true;
        } catch (Throwable th) {
            m.b("BannerExpressView", th.getMessage());
        }
    }

    public void setDuration(int i) {
        this.g = i;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.f = pAGBannerAdWrapperListener;
        NativeExpressView nativeExpressView = this.f558b;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new b());
        }
    }

    public void a(q qVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.a, qVar, adSlot, this.i);
        this.c = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new a());
        b0.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    protected void a(float f, float f2) {
        int iA = b0.a(this.a, f);
        int iA2 = b0.a(this.a, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iA, iA2);
        }
        layoutParams.width = iA;
        layoutParams.height = iA2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        objectAnimatorOfFloat.addListener(new c());
        return objectAnimatorOfFloat;
    }
}
