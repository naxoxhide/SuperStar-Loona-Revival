package com.igaworks.adpopcorn.activity.b.k;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1541b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private StateListDrawable e;
    private StateListDrawable f;
    private ColorStateList g;
    private ColorStateList h;
    private GradientDrawable i;
    private GradientDrawable j;
    private GradientDrawable k;
    private LinearLayout l;
    private boolean m;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.k.a$a, reason: collision with other inner class name */
    class RunnableC0416a implements Runnable {
        final /* synthetic */ ScrollView a;

        RunnableC0416a(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout linearLayout;
            int i;
            int iB = ((int) (((double) com.igaworks.adpopcorn.cores.common.d.b()) * 0.9d)) - com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 95);
            ScrollView scrollView = this.a;
            if (scrollView == null || scrollView.getHeight() < iB) {
                linearLayout = a.this.l;
                i = 4;
            } else {
                this.a.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 480), iB));
                linearLayout = a.this.l;
                i = 0;
            }
            linearLayout.setVisibility(i);
        }
    }

    class b implements ViewTreeObserver.OnScrollChangedListener {
        final /* synthetic */ ScrollView a;

        b(ScrollView scrollView) {
            this.a = scrollView;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            a aVar;
            a aVar2;
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    if (this.a.canScrollVertically(1)) {
                        if (a.this.l != null) {
                            aVar = a.this;
                            aVar.l.setVisibility(0);
                        }
                        return;
                    }
                    if (a.this.l != null) {
                        aVar2 = a.this;
                        aVar2.l.setVisibility(4);
                        return;
                    }
                    return;
                }
                if (this.a.getChildAt(0).getBottom() <= this.a.getHeight() + this.a.getScrollY()) {
                    if (a.this.l != null) {
                        aVar2 = a.this;
                        aVar2.l.setVisibility(4);
                        return;
                    }
                    return;
                }
                if (a.this.l != null) {
                    aVar = a.this;
                    aVar.l.setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ RelativeLayout a;

        c(RelativeLayout relativeLayout) {
            this.a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TextView textView = new TextView(a.this.a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.a.getHeight());
                textView.setBackgroundDrawable(a.this.k);
                if (Build.VERSION.SDK_INT >= 11) {
                    textView.setAlpha(0.1f);
                }
                textView.setLayoutParams(layoutParams);
                this.a.addView(textView);
            } catch (Exception unused) {
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class e implements Runnable {
        final /* synthetic */ TextView a;

        e(TextView textView) {
            this.a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 4);
            layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 25);
            layoutParams.gravity = 48;
            this.a.setLayoutParams(layoutParams);
        }
    }

    class f implements Runnable {
        final /* synthetic */ TextView a;

        f(TextView textView) {
            this.a = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 4);
            layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 25);
            layoutParams.gravity = 48;
            this.a.setLayoutParams(layoutParams);
        }
    }

    public a(Context context, int i, g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener) {
        super(context, i);
        this.a = context;
        this.f1541b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x08a4 A[PHI: r51 r53
      0x08a4: PHI (r51v2 android.widget.ImageView) = (r51v0 android.widget.ImageView), (r51v3 android.widget.ImageView) binds: [B:36:0x08a2, B:22:0x0701] A[DONT_GENERATE, DONT_INLINE]
      0x08a4: PHI (r53v2 android.widget.TextView) = (r53v0 android.widget.TextView), (r53v3 android.widget.TextView) binds: [B:36:0x08a2, B:22:0x0701] A[DONT_GENERATE, DONT_INLINE]] */
    private View a() {
        TextView textView;
        ImageView imageView;
        String str;
        String strS;
        String strW = this.f1541b.w();
        String strV = this.f1541b.V();
        String strP = this.f1541b.P();
        String strN = this.f1541b.N();
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(81);
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15)));
        linearLayout2.setBackgroundDrawable(this.i);
        linearLayout.addView(linearLayout2);
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2));
        linearLayout.addView(scrollView);
        scrollView.post(new RunnableC0416a(scrollView));
        try {
            scrollView.getViewTreeObserver().addOnScrollChangedListener(new b(scrollView));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout3.setGravity(81);
        scrollView.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 19);
        linearLayout4.setLayoutParams(layoutParams);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(48);
        Context context = this.a;
        ImageView iVar = new i(context, com.igaworks.adpopcorn.cores.common.d.a(context, 15));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 18);
        layoutParams2.gravity = 17;
        iVar.setLayoutParams(layoutParams2);
        linearLayout4.addView(iVar);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        linearLayout5.setOrientation(1);
        linearLayout5.setGravity(48);
        TextView textView2 = new TextView(this.a);
        textView2.setGravity(48);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams3.gravity = 48;
        textView2.setLayoutParams(layoutParams3);
        textView2.setIncludeFontPadding(false);
        textView2.setMaxLines(2);
        linearLayout5.addView(textView2);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19)));
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        linearLayout5.addView(linearLayout6);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView3.setLayoutParams(layoutParams4);
        textView3.setSingleLine();
        textView3.setIncludeFontPadding(false);
        textView3.setGravity(17);
        linearLayout6.addView(textView3);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        textView4.setGravity(19);
        linearLayout6.addView(textView4);
        linearLayout4.addView(linearLayout5);
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        linearLayout7.setLayoutParams(new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2));
        linearLayout7.setOrientation(1);
        linearLayout7.setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480) - com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        layoutParams5.gravity = 17;
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout7.addView(imageView2);
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams6.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams6.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        textView5.setLayoutParams(layoutParams6);
        textView5.setGravity(16);
        linearLayout7.addView(textView5);
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
        textView6.setLayoutParams(layoutParams7);
        linearLayout7.addView(textView6);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams8.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams8.gravity = 16;
        relativeLayout.setLayoutParams(layoutParams8);
        linearLayout7.addView(relativeLayout);
        relativeLayout.post(new c(relativeLayout));
        ImageView imageView3 = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 19), com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams9.addRule(9);
        layoutParams9.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 21);
        layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        imageView3.setLayoutParams(layoutParams9);
        imageView3.setId(10);
        imageView3.setImageResource(R.drawable.onestore_ic_sc_appicon);
        relativeLayout.addView(imageView3);
        TextView textView7 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams10.addRule(1, imageView3.getId());
        layoutParams10.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
        layoutParams10.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 21);
        textView7.setLayoutParams(layoutParams10);
        textView7.setMaxLines(1);
        textView7.setId(11);
        textView7.setIncludeFontPadding(false);
        textView7.setGravity(48);
        relativeLayout.addView(textView7);
        TextView textView8 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(9);
        layoutParams11.addRule(3, imageView3.getId());
        layoutParams11.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams11.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        textView8.setLayoutParams(layoutParams11);
        textView8.setId(12);
        textView8.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        textView8.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        relativeLayout.addView(textView8);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        linearLayout8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout8.setOrientation(1);
        linearLayout8.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
        linearLayout8.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout7.addView(linearLayout8);
        TextView textView9 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams12.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        textView9.setLayoutParams(layoutParams12);
        textView9.setGravity(19);
        textView9.setIncludeFontPadding(false);
        textView9.setSingleLine();
        linearLayout8.addView(textView9);
        TextView textView10 = new TextView(this.a);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView10.setGravity(19);
        textView10.setIncludeFontPadding(false);
        textView10.setLineSpacing(TypedValue.applyDimension(2, 3.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
        linearLayout8.addView(textView10);
        View view = new View(this.a);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view.setBackgroundColor(Color.parseColor("#eceff1"));
        linearLayout7.addView(view);
        LinearLayout linearLayout9 = new LinearLayout(this.a);
        linearLayout9.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 55)));
        linearLayout9.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout9.setOrientation(0);
        linearLayout9.setGravity(49);
        TextView textView11 = new TextView(this.a);
        textView11.setGravity(17);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 100), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
        layoutParams13.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        textView11.setLayoutParams(layoutParams13);
        textView11.setBackgroundDrawable(this.f);
        textView11.setOnClickListener(new d());
        TextView textView12 = new TextView(this.a);
        textView12.setGravity(17);
        textView12.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 260), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
        textView12.setOnClickListener(this.d);
        textView12.setBackgroundDrawable(this.e);
        textView11.setTextColor(this.g);
        textView12.setTextColor(this.h);
        linearLayout9.addView(textView11);
        linearLayout9.addView(textView12);
        linearLayout3.addView(linearLayout4);
        linearLayout3.addView(linearLayout7);
        linearLayout.addView(linearLayout9);
        this.l = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams14.gravity = 81;
        layoutParams14.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 55);
        this.l.setLayoutParams(layoutParams14);
        this.l.setOrientation(1);
        this.l.setBackgroundDrawable(this.j);
        frameLayout.addView(this.l);
        if (this.f1541b.a0() || this.f1541b.X()) {
            textView = textView10;
            imageView = iVar;
            k.b(textView2, this.f1541b.n(), 17, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
            textView2.post(new e(textView2));
            try {
                str = new DecimalFormat("###,###").format(this.f1541b.m());
            } catch (Exception unused) {
                str = this.f1541b.Q() + "";
            }
            k.b(textView5, this.c.n2, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView6, this.f1541b.h() + this.c.o2, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView11, this.c.h, 15, Color.parseColor("#3e3877"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView12, String.format(this.c.k2, str + this.f1541b.O()), 15, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView4, String.format(this.c.k2, str + this.f1541b.O()), 12, Color.parseColor("#3e3877"), null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView7, this.c.S1, 15, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView8, this.m ? this.c.T1 : this.c.U1, 13, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView9, this.c.u1, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            strS = this.c.v1;
            if (this.f1541b.s() != null && this.f1541b.s().length() > 0) {
                strS = this.f1541b.s();
            }
        } else {
            imageView = iVar;
            textView = textView10;
            k.b(textView2, strV, 17, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
            textView2.post(new f(textView2));
            String strP2 = this.f1541b.p();
            if (strP2.isEmpty()) {
                strP2 = this.c.c2;
            }
            k.b(textView3, strP2, 13, Color.parseColor("#8c8c8c"), null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView5, this.c.E, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView6, strN, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView11, this.c.h, 15, Color.parseColor("#3e3877"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView12, String.format(this.c.j2, this.f1541b.Q() + this.f1541b.O()), 15, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView4, strP, 12, Color.parseColor("#3e3877"), null, 0, 1, TextUtils.TruncateAt.END, false);
            k.b(textView7, this.c.S1, 15, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView8, this.m ? this.c.T1 : this.c.U1, 13, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView9, this.c.u1, 15, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
            strS = this.c.v1;
            if (this.f1541b.s() != null && this.f1541b.s().length() > 0) {
                strS = this.f1541b.s();
            }
        }
        k.b(textView, strS, 12, Color.parseColor("#8c8c8c"), null, 0, 0, TextUtils.TruncateAt.END, false);
        com.igaworks.adpopcorn.cores.common.e.b(this.a);
        Context context2 = this.a;
        com.igaworks.adpopcorn.cores.common.e.a(context2, strW, imageView, com.igaworks.adpopcorn.cores.common.d.a(context2, 56), com.igaworks.adpopcorn.cores.common.d.a(this.a, 56), (com.igaworks.adpopcorn.cores.common.e.b) null);
        return frameLayout;
    }

    private void b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.i = gradientDrawable;
        gradientDrawable.setShape(0);
        this.i.setCornerRadii(new float[]{com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0.0f, 0.0f, 0.0f, 0.0f});
        this.i.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, -1275068417, -1});
        this.j = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.j.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2144918184, -2144918184});
        this.k = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.k.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15));
        this.k.setGradientType(0);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
        gradientDrawable5.setShape(0);
        gradientDrawable5.setAlpha(204);
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable6.setGradientType(0);
        gradientDrawable6.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable7.setShape(0);
        gradientDrawable7.setAlpha(204);
        gradientDrawable7.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable7.setGradientType(0);
        gradientDrawable7.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.e = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable5);
        this.e.addState(StateSet.WILD_CARD, gradientDrawable4);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.f = stateListDrawable2;
        stateListDrawable2.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable7);
        this.f.addState(StateSet.WILD_CARD, gradientDrawable6);
        this.h = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")});
        this.g = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#7f4b469c"), Color.parseColor("#4b469c")});
        this.m = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_ONESTORE_COMMON_POINT);
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
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
