package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDynamicClickSlideUp extends LinearLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LinearLayout f290b;
    private TextView c;

    public TTDynamicClickSlideUp(Context context) {
        super(context);
        this.a = context;
        a();
    }

    private void a() {
        setClipChildren(false);
        setGravity(81);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.a);
        this.f290b = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams((int) d.a(this.a, 46.0f), (int) d.a(this.a, 32.0f)));
        this.f290b.setGravity(17);
        this.f290b.setOrientation(1);
        this.f290b.setBackgroundResource(t.e(this.a, "tt_interact_round_rect_stroke"));
        addView(this.f290b);
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setBackgroundResource(t.e(this.a, "tt_splash_slide_up_10"));
        this.f290b.addView(imageView);
        View view = new View(this.a);
        view.setLayoutParams(new ViewGroup.LayoutParams(0, (int) d.a(this.a, 4.0f)));
        addView(view);
        this.c = new TextView(this.a);
        this.c.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        this.c.setGravity(1);
        this.c.setTextColor(-1);
        this.c.setTextSize(14.0f);
        addView(this.c);
    }

    public LinearLayout getBgContainer() {
        return this.f290b;
    }

    public TextView getTvButText() {
        return this.c;
    }
}
