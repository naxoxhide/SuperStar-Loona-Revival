package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.adexpress.widget.BrushMaskView;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDynamicSplashLayoutBrushMaskView extends RelativeLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BrushMaskView f294b;
    private RelativeLayout c;
    private ImageView d;
    private TextView e;
    private FrameLayout f;
    private ImageView g;

    public TTDynamicSplashLayoutBrushMaskView(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        FrameLayout frameLayout = new FrameLayout(this.a);
        this.f = frameLayout;
        frameLayout.setId(b.b.a.a.d.d.a.l);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d.a(this.a, 300.0f), (int) d.a(this.a, 60.0f));
        layoutParams.addRule(14);
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundResource(t.e(this.a, "tt_interact_round_rect"));
        addView(this.f);
        BrushMaskView brushMaskView = new BrushMaskView(this.a);
        this.f294b = brushMaskView;
        brushMaskView.setId(b.b.a.a.d.d.a.m);
        this.f294b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.addView(this.f294b);
        this.d = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) d.a(this.a, 150.0f), (int) d.a(this.a, 30.0f));
        layoutParams2.leftMargin = (int) d.a(this.a, 40.0f);
        layoutParams2.topMargin = (int) d.a(this.a, 30.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setBackgroundResource(t.e(this.a, "tt_interact_round_rect"));
        this.f.addView(this.d);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f.addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(t.j(this.a, "tt_splash_brush_mask_title"));
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = (int) d.a(this.a, 5.0f);
        layoutParams3.leftMargin = (int) d.a(this.a, 20.0f);
        layoutParams3.rightMargin = (int) d.a(this.a, 20.0f);
        this.e.setLayoutParams(layoutParams3);
        this.e.setText(t.j(this.a, "tt_splash_brush_mask_hint"));
        this.e.setTextColor(-1);
        this.e.setTextSize(14.0f);
        linearLayout.addView(this.e);
        this.c = new RelativeLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = (int) d.a(this.a, 40.0f);
        layoutParams4.rightMargin = (int) d.a(this.a, 30.0f);
        this.c.setLayoutParams(layoutParams4);
        ImageView imageView = new ImageView(this.a);
        this.g = imageView;
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.g.setImageDrawable(t.f(this.a, "tt_splash_hand3"));
        this.c.addView(this.g);
        addView(this.c);
    }

    public RelativeLayout getBrushHandRelativeLayout() {
        return this.c;
    }

    public BrushMaskView getBrushMaskView() {
        return this.f294b;
    }

    public TextView getBrushView() {
        return this.e;
    }

    public ImageView getFirstStepImage() {
        return this.d;
    }

    public ImageView getImageHand() {
        return this.g;
    }

    public FrameLayout getSplashBrushFl() {
        return this.f;
    }
}
