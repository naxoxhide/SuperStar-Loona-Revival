package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.tools.af;

/* JADX INFO: loaded from: classes2.dex */
public class MBSplashShakeView extends MBLinearLayout {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1964b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private ImageView g;
    private Animation h;

    public MBSplashShakeView(Context context) {
        super(context);
        this.a = "浏览第三方应用";
        this.f1964b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "浏览第三方应用";
        this.f1964b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }

    public MBSplashShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "浏览第三方应用";
        this.f1964b = "View";
        this.c = "打开第三方应用";
        this.d = "Open";
        this.e = "下载第三方应用";
        this.f = "Install";
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0128  */
    /* JADX WARN: Code duplicated, block: B:37:0x0142  */
    /* JADX WARN: Code duplicated, block: B:38:0x0144  */
    public void initView(String str) {
        boolean z = true;
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(af.b(getContext(), 80.0f), af.b(getContext(), 80.0f)));
        int color = Color.parseColor("#60000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(200);
        imageView.setBackground(gradientDrawable);
        this.g = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(af.b(getContext(), 40.0f), af.b(getContext(), 40.0f));
        layoutParams.gravity = 17;
        this.g.setLayoutParams(layoutParams);
        this.g.setImageResource(getResources().getIdentifier("mbridge_cm_btn_shake", "drawable", b.d().b()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.g);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = af.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        textView.setText("Shake your phone");
        textView.setTextSize(16.0f);
        textView.setTextColor(-1);
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "Install":
                case "Open":
                case "View":
                case "下载第三方应用":
                case "打开第三方应用":
                case "浏览第三方应用":
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                if (getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
                    str = "浏览第三方应用";
                } else {
                    str = "View";
                }
            }
        } else if (getContext().getResources().getConfiguration().locale.getLanguage().contains("zh")) {
            str = "浏览第三方应用";
        } else {
            str = "View";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = af.b(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBLinearLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.g != null) {
            RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
            this.h = rotateAnimation;
            rotateAnimation.setDuration(100L);
            this.h.setRepeatMode(2);
            this.h.setRepeatCount(-1);
            this.g.startAnimation(this.h);
        }
    }
}
