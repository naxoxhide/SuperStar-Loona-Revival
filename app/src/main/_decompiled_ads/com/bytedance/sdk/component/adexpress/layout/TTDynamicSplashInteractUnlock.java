package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.widget.FlowLightView;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDynamicSplashInteractUnlock extends RelativeLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RelativeLayout f293b;
    private TextView c;
    private ImageView d;
    private FlowLightView e;
    private ImageView f;

    public TTDynamicSplashInteractUnlock(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        this.f293b = relativeLayout;
        int i = b.b.a.a.d.d.a.g;
        relativeLayout.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d.a(this.a, 247.0f), (int) d.a(this.a, 56.0f));
        layoutParams.addRule(14);
        this.f293b.setLayoutParams(layoutParams);
        this.f293b.setBackgroundResource(t.e(this.a, "tt_splash_unlock_btn_bg"));
        addView(this.f293b);
        this.d = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) d.a(this.a, 48.0f), (int) d.a(this.a, 48.0f));
        this.d.setLayoutParams(layoutParams2);
        layoutParams2.addRule(20);
        layoutParams2.addRule(15);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            layoutParams2.setMarginStart((int) d.a(this.a, 4.0f));
        } else {
            layoutParams2.leftMargin = (int) d.a(this.a, 4.0f);
        }
        this.d.setImageDrawable(t.f(this.a, "tt_splash_unlock_image_go"));
        ImageView imageView = this.d;
        int i3 = b.b.a.a.d.d.a.h;
        imageView.setId(i3);
        this.f293b.addView(this.d);
        FlowLightView flowLightView = new FlowLightView(this.a);
        this.e = flowLightView;
        flowLightView.setId(b.b.a.a.d.d.a.i);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) d.a(this.a, 24.0f));
        layoutParams3.addRule(15);
        int i4 = b.b.a.a.d.d.a.j;
        layoutParams3.addRule(16, i4);
        layoutParams3.addRule(17, i3);
        layoutParams3.addRule(15);
        if (i2 >= 17) {
            layoutParams3.setMarginStart((int) d.a(this.a, 12.0f));
            layoutParams3.setMarginEnd((int) d.a(this.a, 12.0f));
        } else {
            layoutParams3.leftMargin = (int) d.a(this.a, 12.0f);
            layoutParams3.rightMargin = (int) d.a(this.a, 12.0f);
        }
        this.e.setLayoutParams(layoutParams3);
        this.f293b.addView(this.e);
        ImageView imageView2 = new ImageView(this.a);
        this.f = imageView2;
        imageView2.setId(i4);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) d.a(this.a, 48.0f), (int) d.a(this.a, 48.0f));
        layoutParams4.addRule(21);
        layoutParams4.addRule(15);
        if (i2 >= 17) {
            layoutParams4.setMarginStart((int) d.a(this.a, 2.0f));
            layoutParams4.setMarginEnd((int) d.a(this.a, 4.0f));
        } else {
            layoutParams4.leftMargin = (int) d.a(this.a, 2.0f);
            layoutParams4.rightMargin = (int) d.a(this.a, 4.0f);
        }
        this.f.setLayoutParams(layoutParams4);
        this.f.setImageDrawable(t.f(this.a, "tt_splash_unlock_icon_empty"));
        this.f293b.addView(this.f);
        TextView textView = new TextView(this.a);
        this.c = textView;
        textView.setId(b.b.a.a.d.d.a.k);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = (int) d.a(this.a, 12.0f);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, i);
        this.c.setLayoutParams(layoutParams5);
        this.c.setGravity(17);
        this.c.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.c.setTextColor(-1);
        addView(this.c);
    }

    public FlowLightView getFlowLightView() {
        return this.e;
    }

    public RelativeLayout getUnlockBtn() {
        return this.f293b;
    }

    public ImageView getUnlockEmpty() {
        return this.f;
    }

    public ImageView getUnlockGo() {
        return this.d;
    }

    public TextView getUnlockText() {
        return this.c;
    }
}
