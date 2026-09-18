package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicSplashInteractUnlock;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicUnlockView extends FrameLayout {
    private final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageView f307b;
    private final FlowLightView c;
    private final RotateAnimation d;

    class a implements Runnable {

        /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView$a$a, reason: collision with other inner class name */
        class RunnableC0156a implements Runnable {
            RunnableC0156a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.c.a(4);
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.c.a(4);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicUnlockView.this.f307b.startAnimation(DynamicUnlockView.this.d);
            DynamicUnlockView.this.postDelayed(new RunnableC0156a(), 100L);
            DynamicUnlockView.this.postDelayed(new b(), 300L);
            DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
            dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
        }
    }

    public DynamicUnlockView(Context context) {
        super(context);
        TTDynamicSplashInteractUnlock tTDynamicSplashInteractUnlock = new TTDynamicSplashInteractUnlock(context);
        addView(tTDynamicSplashInteractUnlock);
        this.a = tTDynamicSplashInteractUnlock.getUnlockText();
        this.f307b = tTDynamicSplashInteractUnlock.getUnlockGo();
        this.c = tTDynamicSplashInteractUnlock.getFlowLightView();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.d = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new a();
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a() {
        this.d.cancel();
    }

    public void b() {
        postDelayed(getHaloAnimation(), 300L);
    }
}
