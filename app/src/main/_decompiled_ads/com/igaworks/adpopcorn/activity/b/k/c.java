package com.igaworks.adpopcorn.activity.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1550b;
    private GradientDrawable c;
    private GradientDrawable d;
    private StateListDrawable e;
    private ColorStateList f;
    private boolean g;
    private LinearLayout h;
    private LinearLayout i;
    private View.OnClickListener j;

    class a implements Runnable {
        final /* synthetic */ ScrollView a;

        a(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB = (((int) (((double) com.igaworks.adpopcorn.cores.common.d.b()) * 0.9d)) - com.igaworks.adpopcorn.cores.common.d.a(c.this.a, 25)) - com.igaworks.adpopcorn.cores.common.d.a(c.this.a, 80);
            ScrollView scrollView = this.a;
            if (scrollView == null || scrollView.getHeight() < iB) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(c.this.a, 480), iB);
            layoutParams.gravity = 81;
            this.a.setLayoutParams(layoutParams);
        }
    }

    class b implements ViewTreeObserver.OnScrollChangedListener {
        final /* synthetic */ ScrollView a;

        b(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            LinearLayout linearLayout;
            int i = 0;
            if (Build.VERSION.SDK_INT >= 14) {
                if (this.a.canScrollVertically(1)) {
                    if (c.this.i == null) {
                        return;
                    }
                    linearLayout = c.this.i;
                } else {
                    if (c.this.i == null) {
                        return;
                    }
                    linearLayout = c.this.i;
                    i = 4;
                }
            } else if (this.a.getChildAt(0).getBottom() <= this.a.getHeight() + this.a.getScrollY()) {
                if (c.this.i == null) {
                    return;
                }
                linearLayout = c.this.i;
                i = 4;
            } else {
                if (c.this.i == null) {
                    return;
                }
                linearLayout = c.this.i;
            }
            linearLayout.setVisibility(i);
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.k.c$c, reason: collision with other inner class name */
    class C0418c extends ClickableSpan {
        C0418c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.onClick(view);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public c(Context context, int i, g gVar, View.OnClickListener onClickListener) {
        super(context, i);
        this.a = context;
        this.f1550b = gVar;
        this.g = a(context);
        this.j = onClickListener;
    }

    private int a(int i) {
        return (int) ((((double) i) / ((double) com.igaworks.adpopcorn.cores.common.d.a(this.a, 310))) * 120.0d);
    }

    private View a() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        LinearLayout.LayoutParams layoutParams4;
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout2.setGravity(81);
        frameLayout.addView(linearLayout2);
        int iC = com.igaworks.adpopcorn.cores.common.d.c();
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        if (this.g) {
            layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        } else {
            layoutParams = iC >= com.igaworks.adpopcorn.cores.common.d.a(this.a, 480) ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 25)) : new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 25));
        }
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout3.setBackgroundDrawable(this.c);
        linearLayout2.addView(linearLayout3);
        ScrollView scrollView = new ScrollView(this.a);
        LinearLayout.LayoutParams layoutParams5 = (!this.g && iC < com.igaworks.adpopcorn.cores.common.d.a(this.a, 480)) ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2);
        scrollView.setLayoutParams(layoutParams5);
        linearLayout2.addView(scrollView);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        this.h = linearLayout4;
        linearLayout4.setOrientation(1);
        if (this.g) {
            this.h.setLayoutParams(new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -1));
            scrollView.addView(this.h);
            scrollView.post(new a(scrollView));
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new b(scrollView));
        } else {
            linearLayout2.addView(this.h);
            if (iC >= com.igaworks.adpopcorn.cores.common.d.a(this.a, 480)) {
                linearLayout = this.h;
                layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2);
            } else {
                linearLayout = this.h;
                layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            }
            linearLayout.setLayoutParams(layoutParams2);
        }
        this.h.setBackgroundColor(Color.parseColor("#ffffff"));
        this.h.setGravity(1);
        ImageView imageView = new ImageView(this.a);
        if (this.g) {
            layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 430), com.igaworks.adpopcorn.cores.common.d.a(this.a, 120));
            imageView.setImageResource(R.drawable.onestore_faq_landscape);
        } else {
            int iC2 = com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 50);
            if (iC2 > com.igaworks.adpopcorn.cores.common.d.a(this.a, 480)) {
                iC2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 480) - com.igaworks.adpopcorn.cores.common.d.a(this.a, 50);
            }
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iC2, com.igaworks.adpopcorn.cores.common.d.a(this.a, a(iC2)));
            imageView.setImageResource(R.drawable.onestore_faq_portrait);
            layoutParams3 = layoutParams6;
        }
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        imageView.setLayoutParams(layoutParams3);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.h.addView(imageView);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
        layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        textView.setLayoutParams(layoutParams7);
        textView.setGravity(3);
        k.b(textView, this.f1550b.X1, 16, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        this.h.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        textView2.setLayoutParams(layoutParams8);
        textView2.setGravity(3);
        k.b(textView2, "", 13, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView2.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        g gVar = this.f1550b;
        String str = gVar.Y1;
        int iIndexOf = str.indexOf(gVar.d2);
        C0418c c0418c = new C0418c();
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(c0418c, iIndexOf, iIndexOf + 4, 33);
        textView2.setText(spannableString);
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 25));
        this.h.addView(textView2);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        if (this.g) {
            layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 55));
        } else {
            layoutParams4 = iC >= com.igaworks.adpopcorn.cores.common.d.a(this.a, 480) ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 70)) : new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 70));
        }
        linearLayout5.setLayoutParams(layoutParams4);
        linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(49);
        TextView textView3 = new TextView(this.a);
        textView3.setGravity(17);
        textView3.setLayoutParams(this.g ? new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 180), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 180), com.igaworks.adpopcorn.cores.common.d.a(this.a, 45)));
        textView3.setOnClickListener(new d());
        linearLayout5.addView(textView3);
        k.b(textView3, this.f1550b.h, 16, Color.parseColor("#3e3877"), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView3.setBackgroundDrawable(this.e);
        textView3.setTextColor(this.f);
        linearLayout2.addView(linearLayout5);
        if (this.g) {
            this.i = new LinearLayout(this.a);
            FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
            layoutParams9.gravity = 81;
            layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 55);
            this.i.setLayoutParams(layoutParams9);
            this.i.setOrientation(1);
            this.i.setBackgroundDrawable(this.d);
            frameLayout.addView(this.i);
        }
        return frameLayout;
    }

    private void b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.c = gradientDrawable;
        gradientDrawable.setShape(0);
        this.c.setCornerRadii(new float[]{com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0.0f, 0.0f, 0.0f, 0.0f});
        this.c.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, -1275068417, -1});
        this.d = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.d.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable4.setShape(0);
        gradientDrawable4.setAlpha(204);
        gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable4.setGradientType(0);
        gradientDrawable4.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.e = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable4);
        this.e.addState(StateSet.WILD_CARD, gradientDrawable3);
        this.f = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#7f4b469c"), Color.parseColor("#4b469c")});
    }

    public boolean a(Context context) {
        Configuration configuration = ((Activity) context).getResources().getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        layoutParams.windowAnimations = com.igaworks.adpopcorn.a.a.a(this.a, "IGAWDialogAnimationFromBottom", "style");
        getWindow().setAttributes(layoutParams);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        b();
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        i.a(getWindow().getDecorView());
    }
}
