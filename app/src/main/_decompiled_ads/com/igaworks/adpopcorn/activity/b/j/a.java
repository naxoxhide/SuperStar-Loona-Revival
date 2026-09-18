package com.igaworks.adpopcorn.activity.b.j;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1540b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private View.OnClickListener e;
    private GradientDrawable f;
    private TextView g;
    private TextView h;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.j.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0415a implements View.OnClickListener {
        ViewOnClickListenerC0415a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public a(Context context, int i, g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, i);
        this.a = context;
        this.f1540b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
        this.e = onClickListener2;
    }

    private int a(boolean z, int i) {
        return (int) ((((double) i) / 720.0d) * (z ? 780.0d : 376.0d));
    }

    private View a() {
        int iA;
        ImageView imageView;
        Context context;
        String strR;
        int i;
        int i2;
        e.b bVar;
        TextView textView;
        String str;
        String strS;
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#F1F5F8"));
        linearLayout.addView(c());
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setBackgroundColor(Color.parseColor("#F1F5F8"));
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        scrollView.setBackgroundResource(R.drawable.lottemem_card_round_bg);
        scrollView.setFillViewport(true);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout2.setBackgroundColor(Color.parseColor("#F1F5F8"));
        if (Build.VERSION.SDK_INT > 21) {
            scrollView.setClipToOutline(true);
        }
        if (this.f1540b.q() == null || this.f1540b.q().length() <= 4) {
            iA = (this.f1540b.r() == null || this.f1540b.r().length() <= 4) ? 0 : a(false, d.c());
        } else {
            iA = a(true, d.c());
        }
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
        linearLayout2.addView(imageView2);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.a, 1));
        linearLayout3.setBackgroundColor(Color.parseColor("#0a000000"));
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, d.a(this.a, 128));
        linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout4.setLayoutParams(layoutParams2);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        linearLayout2.addView(linearLayout4);
        linearLayout4.setOnClickListener(this.d);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
        Context context2 = this.a;
        ImageView iVar = new i(context2, d.a(context2, 48));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
        layoutParams3.leftMargin = d.a(this.a, 16);
        layoutParams3.rightMargin = d.a(this.a, 17);
        iVar.setLayoutParams(layoutParams3);
        linearLayout4.addView(iVar);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams4.rightMargin = d.a(this.a, 32);
        linearLayout5.setLayoutParams(layoutParams4);
        linearLayout5.setOrientation(1);
        linearLayout5.setGravity(16);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.bottomMargin = d.a(this.a, 4);
        textView2.setLayoutParams(layoutParams5);
        textView2.setMaxLines(1);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.bottomMargin = d.a(this.a, 2);
        textView3.setLayoutParams(layoutParams6);
        textView3.setMaxLines(1);
        linearLayout5.addView(textView2);
        linearLayout5.addView(textView3);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(16);
        ImageView imageView3 = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(d.a(this.a, 16), d.a(this.a, 18));
        imageView3.setImageResource(R.drawable.lottemem_payback);
        layoutParams7.rightMargin = d.a(this.a, 6);
        imageView3.setLayoutParams(layoutParams7);
        linearLayout6.addView(imageView3);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, d.a(this.a, 26), 1.0f));
        textView4.setGravity(19);
        linearLayout6.addView(textView4);
        linearLayout5.addView(linearLayout6);
        linearLayout4.addView(linearLayout5);
        if (this.f1540b.K() == 35) {
            Drawable drawable = getContext().getResources().getDrawable(com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_list_bullet", "drawable"));
            drawable.setBounds(0, 0, d.a(this.a, 4), d.a(this.a, 4));
            LinearLayout linearLayout7 = new LinearLayout(this.a);
            linearLayout7.setOrientation(1);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams8.leftMargin = d.a(this.a, 24);
            layoutParams8.rightMargin = d.a(this.a, 24);
            layoutParams8.bottomMargin = d.a(this.a, 16);
            layoutParams8.topMargin = d.a(this.a, 16);
            layoutParams8.gravity = 17;
            linearLayout7.setLayoutParams(layoutParams8);
            linearLayout7.setGravity(17);
            linearLayout7.setBackgroundColor(Color.parseColor("#F1F5F8"));
            linearLayout2.addView(linearLayout7);
            TextView textView5 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams9.gravity = 16;
            textView5.setLayoutParams(layoutParams9);
            textView5.setGravity(19);
            textView5.setIncludeFontPadding(false);
            textView5.setCompoundDrawables(drawable, null, null, null);
            textView5.setCompoundDrawablePadding(d.a(this.a, 8));
            textView5.setMinimumHeight(d.a(this.a, 24));
            linearLayout7.addView(textView5);
            TextView textView6 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams10.topMargin = d.a(this.a, 4);
            layoutParams10.gravity = 16;
            textView6.setLayoutParams(layoutParams10);
            textView6.setGravity(19);
            textView6.setCompoundDrawables(drawable, null, null, null);
            textView6.setCompoundDrawablePadding(d.a(this.a, 8));
            textView6.setMinimumHeight(d.a(this.a, 24));
            textView6.setIncludeFontPadding(false);
            linearLayout7.addView(textView6);
            TextView textView7 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams11.gravity = 16;
            layoutParams11.leftMargin = d.a(this.a, 12);
            textView7.setLayoutParams(layoutParams11);
            textView7.setGravity(19);
            textView7.setIncludeFontPadding(false);
            linearLayout7.addView(textView7);
            k.b(textView5, this.c.J1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView6, this.c.K1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView7, this.c.L1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView7.setLineSpacing(d.a(this.a, 5), 1.0f);
        }
        if (this.f1540b.u() != null && this.f1540b.u().length() > 0) {
            LinearLayout linearLayout8 = new LinearLayout(this.a);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, d.a(this.a, 1));
            layoutParams12.leftMargin = d.a(this.a, 16);
            layoutParams12.rightMargin = d.a(this.a, 16);
            linearLayout8.setBackgroundColor(Color.parseColor("#eeeeee"));
            linearLayout8.setLayoutParams(layoutParams12);
            linearLayout2.addView(linearLayout8);
            LinearLayout linearLayout9 = new LinearLayout(this.a);
            linearLayout9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout9.setOrientation(1);
            linearLayout9.setPadding(d.a(this.a, 16), d.a(this.a, 16), d.a(this.a, 16), d.a(this.a, 17));
            linearLayout9.setBackgroundColor(Color.parseColor("#F1F5F8"));
            linearLayout2.addView(linearLayout9);
            this.g = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams13.bottomMargin = d.a(this.a, 11);
            this.g.setLayoutParams(layoutParams13);
            this.g.setGravity(19);
            this.g.setIncludeFontPadding(false);
            this.g.setSingleLine();
            linearLayout9.addView(this.g);
            this.h = new TextView(this.a);
            this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.h.setGravity(19);
            this.h.setIncludeFontPadding(false);
            this.h.setLineSpacing(TypedValue.applyDimension(2, 7.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
            linearLayout9.addView(this.h);
        }
        LinearLayout linearLayout10 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, d.a(this.a, 1));
        linearLayout10.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout10.setLayoutParams(layoutParams14);
        linearLayout2.addView(linearLayout10);
        LinearLayout linearLayout11 = new LinearLayout(this.a);
        linearLayout11.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout11.setOrientation(1);
        linearLayout11.setPadding(d.a(this.a, 16), d.a(this.a, 15), d.a(this.a, 16), 0);
        linearLayout11.setBackgroundColor(Color.parseColor("#F1F5F8"));
        linearLayout2.addView(linearLayout11);
        LinearLayout linearLayout12 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, d.a(this.a, 21));
        layoutParams15.bottomMargin = d.a(this.a, 7);
        linearLayout12.setLayoutParams(layoutParams15);
        linearLayout12.setOrientation(0);
        linearLayout11.addView(linearLayout12);
        ImageView imageView4 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(d.a(this.a, 14), d.a(this.a, 14));
        layoutParams16.rightMargin = d.a(this.a, 4);
        layoutParams16.gravity = 16;
        imageView4.setLayoutParams(layoutParams16);
        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_info_circle_fill.png", imageView4, false);
        linearLayout12.addView(imageView4);
        TextView textView8 = new TextView(this.a);
        textView8.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView8.setGravity(19);
        textView8.setIncludeFontPadding(false);
        textView8.setSingleLine();
        linearLayout12.addView(textView8);
        TextView textView9 = new TextView(this.a);
        textView9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView9.setGravity(19);
        textView9.setIncludeFontPadding(false);
        textView9.setLineSpacing(TypedValue.applyDimension(2, 6.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
        linearLayout11.addView(textView9);
        View view = new View(this.a);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view.setBackgroundColor(Color.parseColor("#F1F5F8"));
        linearLayout2.addView(view);
        scrollView.addView(linearLayout2);
        try {
            if (this.f1540b.q() == null || this.f1540b.q().length() <= 4) {
                imageView = iVar;
                if (this.f1540b.r() != null && this.f1540b.r().length() > 4) {
                    context = this.a;
                    strR = this.f1540b.r();
                    i = 0;
                    i2 = 0;
                    bVar = null;
                }
                textView = this.g;
                if (textView != null && this.h != null) {
                    k.b(textView, this.c.E, 16, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, true);
                    k.b(this.h, this.f1540b.u(), 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
                }
                k.b(textView2, this.f1540b.v(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
                k.b(textView3, this.f1540b.p(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
                str = new DecimalFormat("###,###").format(this.f1540b.Q());
                k.b(textView2, this.f1540b.V(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), Typeface.SERIF, 0, 1, TextUtils.TruncateAt.END, false);
                k.b(textView3, this.f1540b.p(), 14, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                k.b(textView4, "+" + str + this.f1540b.O(), 16, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(textView8, this.c.u1, 14, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
                strS = this.c.v1;
                if (this.f1540b.s() != null && this.f1540b.s().length() > 0) {
                    strS = this.f1540b.s();
                }
                k.b(textView9, strS, 12, Color.parseColor("#666666"), null, 0, 0, TextUtils.TruncateAt.END, false);
                e.a(this.a, this.f1540b.w(), imageView, d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
                linearLayout.addView(scrollView);
                return linearLayout;
            }
            context = this.a;
            strR = this.f1540b.q();
            i = 0;
            i2 = 0;
            bVar = null;
            imageView = iVar;
            str = new DecimalFormat("###,###").format(this.f1540b.Q());
        } catch (Exception unused) {
            str = this.f1540b.Q() + "";
        }
        e.a(context, strR, imageView2, i, i2, bVar);
        textView = this.g;
        if (textView != null) {
            k.b(textView, this.c.E, 16, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, true);
            k.b(this.h, this.f1540b.u(), 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
        }
        k.b(textView2, this.f1540b.v(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
        k.b(textView3, this.f1540b.p(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
        k.b(textView2, this.f1540b.V(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), Typeface.SERIF, 0, 1, TextUtils.TruncateAt.END, false);
        k.b(textView3, this.f1540b.p(), 14, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
        k.b(textView4, "+" + str + this.f1540b.O(), 16, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_LIST_REWARD_VIEW_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, true);
        k.b(textView8, this.c.u1, 14, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        strS = this.c.v1;
        if (this.f1540b.s() != null) {
            strS = this.f1540b.s();
        }
        k.b(textView9, strS, 12, Color.parseColor("#666666"), null, 0, 0, TextUtils.TruncateAt.END, false);
        e.a(this.a, this.f1540b.w(), imageView, d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
        linearLayout.addView(scrollView);
        return linearLayout;
    }

    private void b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR)});
        this.f = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f.setCornerRadius(d.a(this.a, 3));
        this.f.setGradientType(0);
    }

    private RelativeLayout c() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, d.a(this.a, iC));
        layoutParams2.bottomMargin = d.a(this.a, 16);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setBackgroundColor(Color.parseColor("#F1F5F8"));
        ImageView imageView = new ImageView(this.a);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID);
        if (iC2 == -100) {
            layoutParams = new RelativeLayout.LayoutParams(d.a(this.a, 24), d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_arrow_back.png", imageView, false);
        } else {
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(iC2);
            layoutParams = layoutParams3;
        }
        imageView.setOnClickListener(new ViewOnClickListenerC0415a());
        layoutParams.leftMargin = d.a(this.a, 16);
        layoutParams.rightMargin = d.a(this.a, 8);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(d.a(this.a, 42), d.a(this.a, iC));
        layoutParams4.addRule(15);
        layoutParams4.addRule(9);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setOnClickListener(new b());
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        layoutParams5.leftMargin = d.a(this.a, 56);
        layoutParams5.rightMargin = d.a(this.a, 56);
        textView.setLayoutParams(layoutParams5);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        k.b(textView, com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC3, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView.setGravity(17);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(d.a(this.a, 24), d.a(this.a, 24));
        layoutParams6.rightMargin = d.a(this.a, 16);
        layoutParams6.leftMargin = d.a(this.a, 6);
        layoutParams6.addRule(15);
        layoutParams6.addRule(11);
        imageView2.setLayoutParams(layoutParams6);
        imageView2.setImageResource(R.drawable.lottemem_cs);
        imageView2.setId(2);
        imageView2.setOnClickListener(this.e);
        relativeLayout.addView(imageView2);
        return relativeLayout;
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
        layoutParams.windowAnimations = com.igaworks.adpopcorn.a.a.a(this.a, "IGAWFeedDialogAnimation", "style");
        getWindow().setAttributes(layoutParams);
        b();
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
