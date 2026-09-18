package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.a.a.d.c;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class SlideUp3DView extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f319b;
    private TextView c;
    private TextView d;
    private AnimationDrawable e;

    public SlideUp3DView(Context context) {
        super(context);
        this.a = context;
        c();
    }

    private void a(int i, String str) {
        this.e.addFrame(t.f(this.a, str), i);
    }

    private void b() {
        this.e = new AnimationDrawable();
        a(100, "tt_slide_up_1");
        a(100, "tt_slide_up_2");
        a(100, "tt_slide_up_3");
        a(100, "tt_slide_up_4");
        a(100, "tt_slide_up_5");
        a(100, "tt_slide_up_6");
        a(100, "tt_slide_up_7");
        a(100, "tt_slide_up_8");
        a(100, "tt_slide_up_9");
        a(100, "tt_slide_up_10");
        a(120, "tt_slide_up_11");
        a(120, "tt_slide_up_12");
        a(120, "tt_slide_up_13");
        a(120, "tt_slide_up_14");
        a(120, "tt_slide_up_15");
        this.e.setOneShot(false);
    }

    public void c() {
        this.f319b = new ImageView(this.a);
        this.d = new TextView(this.a);
        this.c = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) d.a(this.a, 200.0f), (int) d.a(this.a, 200.0f));
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = (int) d.a(this.a, 70.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = (int) d.a(this.a, 25.0f);
        this.d.setText(t.j(this.a, "tt_slide_up_3d"));
        this.d.setTextColor(-1);
        this.d.setTextSize(24.0f);
        this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        this.c.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        this.c.setTextColor(-1);
        this.c.setTextSize(14.0f);
        addView(this.f319b, layoutParams);
        if (!c.c()) {
            addView(this.d, layoutParams2);
        }
        addView(this.c, layoutParams3);
    }

    public void d() {
        if (this.e == null) {
            b();
        }
        this.f319b.setImageDrawable(this.e);
        this.e.start();
    }

    public void setGuideText(String str) {
        this.c.setText(str);
    }

    public void a() {
        AnimationDrawable animationDrawable = this.e;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.e = null;
        }
    }
}
