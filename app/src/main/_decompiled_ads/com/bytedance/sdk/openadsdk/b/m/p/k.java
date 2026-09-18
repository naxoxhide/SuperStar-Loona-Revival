package com.bytedance.sdk.openadsdk.b.m.p;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.b.a.a.h.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGLoadingBaseLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingFourLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingOneLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingThreeLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.PAGPAGLoadingTwoLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.tapjoy.TJAdUnitConstants;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f505b;
    private int c = 0;
    private PAGLoadingBaseLayout d;
    TTRoundRectImageView e;
    TextView f;
    ProgressBar g;
    TextView h;
    private LinearLayout i;
    private TwoSemicirclesView j;
    private TwoSemicirclesView k;
    private TextView l;
    private final String m;
    private final int n;
    private AnimatorSet o;
    private AnimatorSet p;

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(k.this.f505b, k.this.a, k.this.m);
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(k.this.f505b, k.this.a, k.this.m);
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(k.this.f505b, k.this.a, k.this.m);
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.a(k.this.f505b, k.this.a, k.this.m);
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ProgressBar progressBar = k.this.g;
            if (progressBar != null) {
                progressBar.setProgress(iIntValue);
            }
            k.this.h.setText(String.valueOf(iIntValue));
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ProgressBar progressBar = k.this.g;
            if (progressBar != null) {
                progressBar.setProgress(iIntValue);
            }
            k.this.h.setText(String.valueOf(iIntValue));
        }
    }

    public k(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.f505b = aVar.W;
        this.a = aVar.a;
        this.m = aVar.g;
        this.n = aVar.j;
    }

    private void d() {
        if (this.a.b0() == null || TextUtils.isEmpty(this.a.b0().d())) {
            this.e.setVisibility(8);
            return;
        }
        try {
            b.b.a.a.h.j jVarA = com.bytedance.sdk.openadsdk.h.d.a(this.a.b0());
            q qVar = this.a;
            jVarA.a(new com.bytedance.sdk.openadsdk.h.b(qVar, qVar.b0().d(), new g(this.e)));
        } catch (Throwable unused) {
            this.e.setVisibility(8);
        }
    }

    private void e() {
        PAGPAGLoadingFourLayout pAGPAGLoadingFourLayout = new PAGPAGLoadingFourLayout(this.f505b);
        this.d = pAGPAGLoadingFourLayout;
        this.j = pAGPAGLoadingFourLayout.getInnerCircle();
        this.k = this.d.getOuterCircle();
        this.j.setRadius(b0.a(this.f505b, 80.0f));
        Paint paintTwo = this.j.getPaintTwo();
        paintTwo.setColor(Color.parseColor("#C4C4C4"));
        this.j.setPaintTwo(paintTwo);
        this.k.setRadius(b0.a(this.f505b, 95.0f));
        Paint paintTwo2 = this.k.getPaintTwo();
        paintTwo2.setStrokeWidth(6.0f);
        paintTwo2.setColor(Color.parseColor("#118BFF"));
        this.k.setPaintTwo(paintTwo2);
        this.h = this.d.getLoadingProgressNumber();
        PAGTextView loadingLogo = this.d.getLoadingLogo();
        this.l = loadingLogo;
        loadingLogo.setOnClickListener(new d());
    }

    private void f() {
        PAGPAGLoadingOneLayout pAGPAGLoadingOneLayout = new PAGPAGLoadingOneLayout(this.f505b);
        this.d = pAGPAGLoadingOneLayout;
        this.e = pAGPAGLoadingOneLayout.getLoadingIcon();
        this.f = this.d.getLoadingAppName();
        this.g = this.d.getLoadingProgressBar();
        this.h = this.d.getLoadingProgressNumber();
        this.l = this.d.getLoadingLogo();
        if (this.n == 1 && this.a.h() != null && !TextUtils.isEmpty(this.a.h().a())) {
            this.f.setText(this.a.h().a());
        } else if (TextUtils.isEmpty(this.a.K0())) {
            this.f.setVisibility(8);
        } else {
            this.f.setText(this.a.K0());
        }
        d();
        this.l.setOnClickListener(new a());
    }

    private void g() {
        PAGPAGLoadingThreeLayout pAGPAGLoadingThreeLayout = new PAGPAGLoadingThreeLayout(this.f505b);
        this.d = pAGPAGLoadingThreeLayout;
        this.i = pAGPAGLoadingThreeLayout.getWaveContainer();
        this.h = this.d.getLoadingProgressNumber();
        PAGTextView loadingLogo = this.d.getLoadingLogo();
        this.l = loadingLogo;
        loadingLogo.setOnClickListener(new c());
    }

    private void h() {
        PAGPAGLoadingTwoLayout pAGPAGLoadingTwoLayout = new PAGPAGLoadingTwoLayout(this.f505b);
        this.d = pAGPAGLoadingTwoLayout;
        this.e = pAGPAGLoadingTwoLayout.getLoadingIcon();
        this.h = this.d.getLoadingProgressNumber();
        this.l = this.d.getLoadingLogo();
        d();
        this.l.setOnClickListener(new b());
    }

    private void j() {
        this.o = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.j, TJAdUnitConstants.String.ROTATION, 0.0f, 360.0f).setDuration(1500L);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatCount(-1);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.k, TJAdUnitConstants.String.ROTATION, 0.0f, 360.0f).setDuration(2500L);
        duration2.setRepeatCount(-1);
        this.o.playTogether(duration, duration2);
        this.o.start();
        n();
    }

    private void k() {
        n();
    }

    private void l() {
        this.o = new AnimatorSet();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", -9.0f, 9.0f).setDuration(300L);
            duration.setRepeatMode(2);
            duration.setRepeatCount(-1);
            AnimatorSet.Builder builderPlay = this.o.play(duration);
            for (int i = 1; i < this.i.getChildCount(); i++) {
                float f2 = -9.0f;
                if (i % 2 == 0) {
                    f2 = 9.0f;
                }
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.i.getChildAt(i), "translationY", -f2, f2).setDuration(300L);
                duration2.setRepeatMode(2);
                duration2.setRepeatCount(-1);
                builderPlay = builderPlay.with(duration2);
            }
            this.o.start();
        }
        n();
    }

    private void m() {
        Context context = this.f505b;
        this.e.setAnimation(AnimationUtils.loadAnimation(context, t.a(context, "tt_loading_two_icon_scale")));
        n();
    }

    private void n() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 80);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.addUpdateListener(new e());
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(81, 99);
        valueAnimatorOfInt2.setDuration(3000L);
        valueAnimatorOfInt2.addUpdateListener(new f());
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.play(valueAnimatorOfInt).before(valueAnimatorOfInt2);
        this.p.start();
    }

    public void i() {
        try {
            int i = this.c;
            if (i == 1) {
                k();
            } else if (i == 2) {
                m();
            } else if (i == 3) {
                l();
            } else if (i == 4) {
                j();
            }
        } catch (Throwable unused) {
        }
    }

    public void a() {
        AnimatorSet animatorSet = this.o;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.p;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public View b() {
        return this.d;
    }

    public void c() {
        try {
            if (!q.c(this.a) || com.bytedance.sdk.openadsdk.core.f0.t.h(this.a)) {
                return;
            }
            try {
                this.c = new JSONObject(this.a.I0().c()).optInt("loading_page_type", 0);
            } catch (JSONException unused) {
            }
            int i = this.c;
            if (i == 1) {
                f();
                return;
            }
            if (i == 2) {
                h();
            } else if (i == 3) {
                g();
            } else {
                if (i != 4) {
                    return;
                }
                e();
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: compiled from: RewardFullVideoLoadingManager.java */
    private static class g implements o<Bitmap> {
        private final WeakReference<ImageView> a;

        public g(ImageView imageView) {
            this.a = new WeakReference<>(imageView);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001f A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:7:0x000f, B:9:0x0015, B:10:0x001f), top: B:15:0x000f }] */
        @Override // b.b.a.a.h.o
        public void a(b.b.a.a.h.k<Bitmap> kVar) {
            ImageView imageView = this.a.get();
            if (imageView == null) {
                return;
            }
            if (kVar != null) {
                try {
                    if (kVar.c() != null) {
                        imageView.setImageBitmap(kVar.c());
                    } else {
                        imageView.setVisibility(8);
                    }
                } catch (Throwable unused) {
                    imageView.setVisibility(8);
                }
            } else {
                imageView.setVisibility(8);
            }
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            ImageView imageView = this.a.get();
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
