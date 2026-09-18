package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDynamicSplashSlideUp extends RelativeLayout {
    private Context a;

    public TTDynamicSplashSlideUp(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setGravity(15);
        setClipChildren(false);
        ImageView imageView = new ImageView(this.a);
        imageView.setId(b.b.a.a.d.d.a.n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d.a(this.a, 36.0f), (int) d.a(this.a, 36.0f));
        layoutParams.addRule(14);
        int i = b.b.a.a.d.d.a.q;
        layoutParams.addRule(8, i);
        layoutParams.bottomMargin = (int) d.a(this.a, -24.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setAlpha(0);
        imageView.setBackgroundResource(t.e(this.a, "tt_splash_slide_up_circle"));
        addView(imageView);
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setId(b.b.a.a.d.d.a.o);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) d.a(this.a, 67.0f), (int) d.a(this.a, 51.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, i);
        layoutParams2.addRule(1, i);
        layoutParams2.bottomMargin = (int) d.a(this.a, -20.0f);
        layoutParams2.leftMargin = (int) d.a(this.a, -7.0f);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setAlpha(0);
        imageView2.setBackgroundResource(t.e(this.a, "tt_splash_slide_up_finger"));
        addView(imageView2);
        ImageView imageView3 = new ImageView(this.a);
        imageView3.setId(b.b.a.a.d.d.a.p);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) d.a(this.a, 10.0f), (int) d.a(this.a, 0.0f));
        layoutParams3.addRule(14);
        layoutParams3.addRule(8, i);
        imageView3.setLayoutParams(layoutParams3);
        imageView3.setBackgroundResource(t.e(this.a, "tt_splash_slide_up_bg"));
        addView(imageView3);
        ImageView imageView4 = new ImageView(this.a);
        imageView4.setId(i);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) d.a(this.a, 14.0f), (int) d.a(this.a, 100.0f));
        layoutParams4.addRule(14);
        imageView4.setLayoutParams(layoutParams4);
        imageView4.setBackgroundResource(t.e(this.a, "tt_splash_slide_up_arrow"));
        addView(imageView4);
        TextView textView = new TextView(this.a);
        int i2 = b.b.a.a.d.d.a.r;
        textView.setId(i2);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, i);
        textView.setLayoutParams(layoutParams5);
        textView.setTextColor(-1);
        textView.setText("wipe up");
        textView.setTextSize(18.0f);
        textView.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        textView.setGravity(1);
        addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setId(b.b.a.a.d.d.a.s);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, i2);
        textView2.setLayoutParams(layoutParams6);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        textView2.setGravity(1);
        addView(textView2);
    }
}
