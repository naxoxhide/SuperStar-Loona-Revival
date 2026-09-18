package com.bytedance.sdk.component.adexpress.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.a.a.d.g.d;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class TTDynamicHandShake extends LinearLayout {
    TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f292b;

    public TTDynamicHandShake(Context context) {
        super(context);
        this.f292b = context;
        a();
    }

    private void a() {
        setGravity(17);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundResource(t.e(this.f292b, "tt_splash_unlock_btn_bg"));
        setPadding((int) d.a(this.f292b, 38.0f), (int) d.a(this.f292b, 20.0f), (int) d.a(this.f292b, 38.0f), (int) d.a(this.f292b, 20.0f));
        ImageView imageView = new ImageView(this.f292b);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setBackgroundResource(t.e(this.f292b, "tt_splash_shake_hand"));
        addView(imageView);
        this.a = new TextView(this.f292b);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = (int) d.a(this.f292b, 8.0f);
        this.a.setLayoutParams(marginLayoutParams);
        this.a.setTextColor(-1);
        this.a.setTextSize(17.0f);
        addView(this.a);
    }

    public TextView getTvButText() {
        return this.a;
    }
}
