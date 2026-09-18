package com.igaworks.adpopcorn.renewal.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.igaworks.adpopcorn.cores.common.d;

/* JADX INFO: loaded from: classes2.dex */
public class c extends FrameLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1661b;
    private View.OnClickListener c;
    private GradientDrawable d;

    public c(Context context, int i, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.a = context;
        this.f1661b = i;
        this.c = onClickListener;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1023410176, 1023410176});
        this.d = gradientDrawable;
        gradientDrawable.setShape(0);
        this.d.setCornerRadius(d.a(context, 8));
        this.d.setGradientType(0);
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        setBackgroundColor(Color.parseColor("#00000000"));
        a();
    }

    private int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    private void a() {
        View view = new View(this.a);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        addView(view);
        int iA = a(this.f1661b - d.a(this.a, 32));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setId(0);
        ViewFlipper viewFlipper = new ViewFlipper(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f1661b - d.a(this.a, 32), iA);
        layoutParams.leftMargin = d.a(this.a, 16);
        layoutParams.bottomMargin = d.a(this.a, 10);
        viewFlipper.setLayoutParams(layoutParams);
        viewFlipper.setId(1);
        viewFlipper.setTag(0);
        viewFlipper.setOnClickListener(this.c);
        linearLayout.addView(viewFlipper);
        addView(linearLayout);
        TextView textView = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.a(this.a, 34), d.a(this.a, 15));
        layoutParams2.gravity = 85;
        layoutParams2.rightMargin = d.a(this.a, 22);
        layoutParams2.bottomMargin = d.a(this.a, 22);
        textView.setLayoutParams(layoutParams2);
        textView.setBackgroundDrawable(this.d);
        textView.setGravity(17);
        textView.setVisibility(8);
        textView.setId(2);
        addView(textView);
    }
}
