package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTHandShake extends LinearLayout implements a {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinearLayout f295b;
    private ImageView c;
    private TextView d;
    private TextView e;

    public TTHandShake(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        this.f295b = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) d.a(this.a, 110.0f), (int) d.a(this.a, 110.0f));
        this.f295b.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        this.f295b.setGravity(17);
        this.f295b.setOrientation(1);
        addView(this.f295b);
        ImageView imageView = new ImageView(this.a);
        this.c = imageView;
        imageView.setLayoutParams(new LinearLayout.LayoutParams((int) d.a(this.a, 60.0f), (int) d.a(this.a, 60.0f)));
        this.c.setImageDrawable(t.f(this.a, "tt_splash_rock"));
        this.f295b.addView(this.c);
        this.d = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.d.setSingleLine(true);
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextColor(-1);
        this.d.setText("Shake it");
        this.d.setTextSize(14.0f);
        this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.f295b.addView(this.d);
        this.e = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.e.setLayoutParams(layoutParams3);
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = (int) d.a(this.a, 12.0f);
        this.e.setTextColor(-1);
        this.e.setText("Go to details page or third-party application");
        this.e.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        addView(this.e);
    }

    @Override // com.bytedance.sdk.component.adexpress.layout.a
    public LinearLayout getHandContainer() {
        return this.f295b;
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
