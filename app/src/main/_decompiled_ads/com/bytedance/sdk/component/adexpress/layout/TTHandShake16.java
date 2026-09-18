package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTHandShake16 extends LinearLayout implements a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f296b;
    private ImageView c;
    private TextView d;
    private TextView e;

    public TTHandShake16(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        this.f296b = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) d.a(this.a, 80.0f), (int) d.a(this.a, 80.0f));
        this.f296b.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        this.f296b.setGravity(17);
        this.f296b.setOrientation(1);
        ImageView imageView = new ImageView(this.a);
        this.c = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) d.a(this.a, 60.0f), (int) d.a(this.a, 60.0f)));
        this.c.setImageDrawable(t.f(this.a, "tt_splash_rock"));
        this.f296b.addView(this.c);
        addView(this.f296b);
        this.d = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.d.setSingleLine(true);
        layoutParams2.topMargin = (int) d.a(this.a, 12.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextColor(-1);
        this.d.setText(t.j(this.a, "tt_splash_rock_top_text"));
        this.d.setTextSize(18.0f);
        this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        addView(this.d);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.e.setLayoutParams(layoutParams3);
        this.e.setTextColor(-1);
        this.e.setText(t.j(this.a, "tt_splash_rock_text"));
        this.e.setTextSize(14.0f);
        this.e.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        addView(this.e);
    }

    @Override // com.bytedance.sdk.component.adexpress.layout.a
    public LinearLayout getHandContainer() {
        return this.f296b;
    }

    @Override // com.bytedance.sdk.component.adexpress.layout.a
    public ImageView getRockImg() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.adexpress.layout.a
    public TextView getRockText() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.adexpress.layout.a
    public TextView getRockTopText() {
        return this.d;
    }
}
