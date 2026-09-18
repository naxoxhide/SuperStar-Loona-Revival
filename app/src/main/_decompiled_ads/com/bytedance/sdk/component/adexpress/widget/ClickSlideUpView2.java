package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.layout.TTDynamicClickSlideUp2;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView2 extends SlideUpView {
    private TextView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private int p;
    private AnimatorSet q;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.q = new AnimatorSet();
        b(context);
    }

    private void b(Context context) {
        TTDynamicClickSlideUp2 tTDynamicClickSlideUp2 = new TTDynamicClickSlideUp2(context);
        addView(tTDynamicClickSlideUp2);
        this.m = tTDynamicClickSlideUp2.getIv1();
        this.n = tTDynamicClickSlideUp2.getIv2();
        this.o = tTDynamicClickSlideUp2.getIv3();
        this.l = tTDynamicClickSlideUp2.getTvButText();
    }

    private void d() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void a() {
        this.q.cancel();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void a(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void c() {
        d();
    }

    public float getAlphaColor() {
        return this.p;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.o.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.n.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.m.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    public void setButtonText(String str) {
        if (this.l == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.l.setText(str);
    }
}
