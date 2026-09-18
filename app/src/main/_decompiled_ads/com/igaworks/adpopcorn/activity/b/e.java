package com.igaworks.adpopcorn.activity.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.model.g f1533b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private View.OnClickListener e;
    private GradientDrawable f;
    private ImageView g;
    private TextView h;
    private TextView i;

    class a implements com.igaworks.adpopcorn.cores.common.e.b {
        a() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                e.this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (((double) bitmap.getHeight()) * (((double) com.igaworks.adpopcorn.cores.common.d.c()) / 720.0d))));
                e.this.g.setScaleType(ImageView.ScaleType.FIT_XY);
                e.this.g.setImageBitmap(bitmap);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    public e(Context context, int i, com.igaworks.adpopcorn.cores.model.g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, i);
        this.a = context;
        this.f1533b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
        this.e = onClickListener2;
    }

    private int a(boolean z, int i) {
        return (int) ((((double) i) / 720.0d) * (z ? 780.0d : 376.0d));
    }

    private View a() {
        Context context;
        String strR;
        int i;
        int i2;
        com.igaworks.adpopcorn.cores.common.e.b bVar;
        String str;
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        scrollView.setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(d());
        int iA = (this.f1533b.q() == null || this.f1533b.q().length() <= 4) ? a(false, com.igaworks.adpopcorn.cores.common.d.c()) : a(true, com.igaworks.adpopcorn.cores.common.d.c());
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
        linearLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        linearLayout2.setBackgroundColor(Color.parseColor("#0a000000"));
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, -2)));
        linearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.gravity = 16;
        linearLayout4.setLayoutParams(layoutParams2);
        linearLayout3.addView(linearLayout4);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        relativeLayout.setGravity(16);
        relativeLayout.setLayoutParams(layoutParams3);
        linearLayout4.addView(relativeLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(9);
        layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        textView.setLayoutParams(layoutParams4);
        textView.setId(1);
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        layoutParams5.addRule(9);
        layoutParams5.addRule(3, textView.getId());
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        textView2.setLayoutParams(layoutParams5);
        textView2.setGravity(16);
        textView2.setId(2);
        textView2.setSingleLine();
        TextView textView3 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        layoutParams6.addRule(14);
        layoutParams6.addRule(3, textView.getId());
        layoutParams6.addRule(1, textView2.getId());
        textView3.setLayoutParams(layoutParams6);
        textView3.setGravity(16);
        textView3.setId(3);
        textView3.setSingleLine();
        TextView textView4 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
        layoutParams7.addRule(14);
        layoutParams7.addRule(3, textView.getId());
        layoutParams7.addRule(1, textView3.getId());
        textView4.setLayoutParams(layoutParams7);
        textView4.setGravity(16);
        textView4.setId(4);
        textView4.setSingleLine();
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView3);
        relativeLayout.addView(textView4);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        linearLayout5.setOrientation(0);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 328), com.igaworks.adpopcorn.cores.common.d.a(this.a, 48));
        layoutParams8.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams8.gravity = 17;
        linearLayout5.setLayoutParams(layoutParams8);
        linearLayout5.setGravity(17);
        linearLayout5.setBackgroundDrawable(this.f);
        linearLayout3.addView(linearLayout5);
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams9.gravity = 16;
        textView5.setLayoutParams(layoutParams9);
        textView5.setGravity(17);
        textView5.setIncludeFontPadding(false);
        textView5.setSingleLine();
        linearLayout5.addView(textView5);
        linearLayout5.setOnClickListener(this.d);
        if (this.f1533b.K() == 35) {
            Drawable drawable = getContext().getResources().getDrawable(com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_list_bullet", "drawable"));
            drawable.setBounds(0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 4), com.igaworks.adpopcorn.cores.common.d.a(this.a, 4));
            LinearLayout linearLayout6 = new LinearLayout(this.a);
            linearLayout6.setOrientation(1);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams10.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
            layoutParams10.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
            layoutParams10.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams10.gravity = 17;
            linearLayout6.setLayoutParams(layoutParams10);
            linearLayout6.setGravity(17);
            linearLayout6.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.addView(linearLayout6);
            TextView textView6 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams11.gravity = 16;
            textView6.setLayoutParams(layoutParams11);
            textView6.setGravity(19);
            textView6.setIncludeFontPadding(false);
            textView6.setCompoundDrawables(drawable, null, null, null);
            textView6.setCompoundDrawablePadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            textView6.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            linearLayout6.addView(textView6);
            TextView textView7 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams12.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
            layoutParams12.gravity = 16;
            textView7.setLayoutParams(layoutParams12);
            textView7.setGravity(19);
            textView7.setCompoundDrawables(drawable, null, null, null);
            textView7.setCompoundDrawablePadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            textView7.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            textView7.setIncludeFontPadding(false);
            linearLayout6.addView(textView7);
            TextView textView8 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams13.gravity = 16;
            layoutParams13.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            textView8.setLayoutParams(layoutParams13);
            textView8.setGravity(19);
            textView8.setIncludeFontPadding(false);
            linearLayout6.addView(textView8);
            k.b(textView6, this.c.J1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView7, this.c.K1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView8, this.c.L1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView8.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), 1.0f);
        }
        if (this.f1533b.t() != null && this.f1533b.t().length() > 0) {
            this.g = new ImageView(this.a);
            this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.g);
        } else if (this.f1533b.u() != null && this.f1533b.u().length() > 0) {
            LinearLayout linearLayout7 = new LinearLayout(this.a);
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
            layoutParams14.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams14.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            linearLayout7.setBackgroundColor(Color.parseColor("#eeeeee"));
            linearLayout7.setLayoutParams(layoutParams14);
            linearLayout.addView(linearLayout7);
            LinearLayout linearLayout8 = new LinearLayout(this.a);
            linearLayout8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout8.setOrientation(1);
            linearLayout8.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 17));
            linearLayout8.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.addView(linearLayout8);
            this.h = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams15.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
            this.h.setLayoutParams(layoutParams15);
            this.h.setGravity(19);
            this.h.setIncludeFontPadding(false);
            this.h.setSingleLine();
            linearLayout8.addView(this.h);
            this.i = new TextView(this.a);
            this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.i.setGravity(19);
            this.i.setIncludeFontPadding(false);
            this.i.setLineSpacing(TypedValue.applyDimension(2, 7.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
            linearLayout8.addView(this.i);
        }
        LinearLayout linearLayout9 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        linearLayout9.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout9.setLayoutParams(layoutParams16);
        linearLayout.addView(linearLayout9);
        LinearLayout linearLayout10 = new LinearLayout(this.a);
        linearLayout10.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout10.setOrientation(1);
        linearLayout10.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
        linearLayout10.setBackgroundColor(Color.parseColor("#eceff1"));
        linearLayout.addView(linearLayout10);
        LinearLayout linearLayout11 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams17.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
        linearLayout11.setLayoutParams(layoutParams17);
        linearLayout11.setOrientation(0);
        linearLayout10.addView(linearLayout11);
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 14), com.igaworks.adpopcorn.cores.common.d.a(this.a, 14));
        layoutParams18.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        layoutParams18.gravity = 16;
        imageView2.setLayoutParams(layoutParams18);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_info_circle_fill.png", imageView2, false);
        linearLayout11.addView(imageView2);
        TextView textView9 = new TextView(this.a);
        textView9.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView9.setGravity(19);
        textView9.setIncludeFontPadding(false);
        textView9.setSingleLine();
        linearLayout11.addView(textView9);
        TextView textView10 = new TextView(this.a);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView10.setGravity(19);
        textView10.setIncludeFontPadding(false);
        textView10.setLineSpacing(TypedValue.applyDimension(2, 6.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
        linearLayout10.addView(textView10);
        View view = new View(this.a);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view.setBackgroundColor(Color.parseColor("#eceff1"));
        linearLayout.addView(view);
        linearLayout.addView(c());
        scrollView.addView(linearLayout);
        if (this.f1533b.q() == null || this.f1533b.q().length() <= 4) {
            context = this.a;
            strR = this.f1533b.r();
            i = 0;
            i2 = 0;
            bVar = null;
        } else {
            context = this.a;
            strR = this.f1533b.q();
            i = 0;
            i2 = 0;
            bVar = null;
        }
        com.igaworks.adpopcorn.cores.common.e.a(context, strR, imageView, i, i2, bVar);
        if (this.g != null) {
            com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1533b.t(), (ImageView) null, 0, 0, new a());
        } else {
            TextView textView11 = this.h;
            if (textView11 != null && this.i != null) {
                k.b(textView11, this.c.E, 16, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(this.i, this.f1533b.u(), 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
        }
        k.b(textView, this.f1533b.v(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
        k.b(textView2, this.f1533b.p(), 20, Color.parseColor("#000000"), null, 0, 2, TextUtils.TruncateAt.END, false);
        try {
            str = new DecimalFormat("###,###").format(this.f1533b.Q());
        } catch (Exception unused) {
            str = this.f1533b.Q() + "";
        }
        k.b(textView3, str, 22, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_INFO_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        k.b(textView4, "<b>" + this.f1533b.O() + "</b> " + this.c.M1, 22, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_INFO_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, false);
        k.b(textView5, this.c.z1, 16, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_REWARD_TEXT_COLOR), null, 0, 0, TextUtils.TruncateAt.END, true);
        k.b(textView9, this.c.u1, 14, Color.parseColor("#000000"), null, 0, 0, TextUtils.TruncateAt.END, false);
        String strS = this.c.v1;
        if (this.f1533b.s() != null && this.f1533b.s().length() > 0) {
            strS = this.f1533b.s();
        }
        k.b(textView10, strS, 12, Color.parseColor("#666666"), null, 0, 0, TextUtils.TruncateAt.END, false);
        return scrollView;
    }

    private void b() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR)});
        this.f = gradientDrawable;
        gradientDrawable.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 3));
        this.f.setGradientType(0);
    }

    private LinearLayout c() {
        String language = Locale.getDefault().getLanguage();
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_TEXT_COLOR);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_ICON_COLOR);
        LinearLayout linearLayout = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_HEIGHT)));
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.BOTTOM_BAR_BG_COLOR));
        linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 13), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 13), 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 11), com.igaworks.adpopcorn.cores.common.d.a(this.a, 11));
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        imageView.setLayoutParams(layoutParams2);
        imageView.setTag(0);
        imageView.setOnClickListener(this.e);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_ques.png", imageView, false);
        imageView.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(17);
        k.b(textView, this.c.J, 10, iC, null, 0, 1, TextUtils.TruncateAt.END, true);
        textView.setIncludeFontPadding(false);
        textView.setTag(0);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView.setTextSize(1, 8.0f);
        }
        textView.setOnClickListener(this.e);
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1), com.igaworks.adpopcorn.cores.common.d.a(this.a, 9)));
        textView2.setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 11), com.igaworks.adpopcorn.cores.common.d.a(this.a, 11));
        layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 5);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setTag(1);
        imageView2.setOnClickListener(this.e);
        com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_lock.png", imageView2, false);
        imageView2.setColorFilter(iC2, PorterDuff.Mode.MULTIPLY);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        textView3.setGravity(17);
        k.b(textView3, this.c.X, 10, iC, null, 0, 1, TextUtils.TruncateAt.END, true);
        if (language.contains(ApStyleManager.Language.JA) || language.contains(ApStyleManager.Language.EN)) {
            textView3.setTextSize(1, 8.0f);
        }
        textView3.setIncludeFontPadding(false);
        textView3.setTag(1);
        textView3.setOnClickListener(this.e);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.BOTTOM_BAR_CLICKABLE_LINK_TEXT);
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.BOTTOM_BAR_LINK_TEXT);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        textView4.setGravity(21);
        if (zB) {
            textView4.setTag(2);
            textView4.setOnClickListener(this.e);
        }
        k.b(textView4, strD, 10, iC, null, 0, 1, TextUtils.TruncateAt.END, true);
        textView4.setIncludeFontPadding(false);
        linearLayout.addView(imageView);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        linearLayout.addView(imageView2);
        linearLayout.addView(textView3);
        linearLayout.addView(textView4);
        return linearLayout;
    }

    private RelativeLayout d() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
        relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        ImageView imageView = new ImageView(this.a);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID);
        if (iC2 == -100) {
            layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_arrow_back.png", imageView, false);
        } else {
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(iC2);
            layoutParams = layoutParams2;
        }
        imageView.setOnClickListener(new b());
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC));
        layoutParams3.addRule(15);
        layoutParams3.addRule(9);
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setOnClickListener(new c());
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 56);
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 56);
        textView.setLayoutParams(layoutParams4);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        k.b(textView, this.f1533b.v(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC3, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
        textView.setGravity(17);
        relativeLayout.addView(textView);
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
