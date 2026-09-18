package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicClickSlideUp;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView extends SlideUpView {
    private TextView l;
    private TTDynamicClickSlideUp m;
    private AnimatorSet n;

    public ClickSlideUpView(Context context) {
        super(context);
        this.n = new AnimatorSet();
        b(context);
    }

    private void b(Context context) {
        this.m = new TTDynamicClickSlideUp(context);
        setClipChildren(false);
        addView(this.m);
        this.l = this.m.getTvButText();
    }

    private void d() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.m.getBgContainer(), "translationY", 0.0f, d.a(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.m.getBgContainer(), "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.n.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.n.setDuration(1000L);
        this.n.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void a() {
        this.n.cancel();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void a(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void c() {
        d();
    }

    public void setButtonText(String str) {
        if (this.l == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.l.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void setSlideText(String str) {
        if (this.m.getTvButText() != null) {
            if (TextUtils.isEmpty(str)) {
                this.m.getTvButText().setText("");
            } else {
                this.m.getTvButText().setText(str);
            }
        }
    }
}
