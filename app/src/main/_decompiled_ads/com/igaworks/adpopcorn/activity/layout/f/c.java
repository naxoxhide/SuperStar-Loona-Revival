package com.igaworks.adpopcorn.activity.layout.f;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RelativeLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1595b;
    private GradientDrawable c;
    private boolean d;

    public c(Context context, boolean z) {
        super(context);
        this.a = context;
        this.f1595b = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        if (z) {
            this.f1595b = 48;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, this.f1595b)));
        setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-15199176, -15199176});
        this.c = gradientDrawable;
        gradientDrawable.setShape(0);
        this.c.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 15));
        this.c.setGradientType(0);
        this.d = z;
        a();
    }

    private void a() {
        TextUtils.TruncateAt truncateAt;
        Typeface typeface;
        int i;
        int i2;
        g gVarA = g.a();
        TextView textView = new TextView(this.a.getApplicationContext());
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        LinearLayout linearLayout = new LinearLayout(this.a.getApplicationContext());
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT);
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        int i3 = R.drawable.onestore_ic_sc_appicon;
        APSize aPSize = new APSize(26, 26);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize.getHeight()));
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING));
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING));
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(i3);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setId(0);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD);
        textView.setIncludeFontPadding(false);
        textView.setBackgroundColor(0);
        if (strD == null || strD.length() <= 0) {
            strD = gVarA.a;
            truncateAt = TextUtils.TruncateAt.END;
            typeface = null;
            i = 0;
            i2 = 1;
        } else {
            typeface = null;
            i = 0;
            i2 = 1;
            truncateAt = TextUtils.TruncateAt.END;
        }
        k.b(textView, strD, iC2, iC, typeface, i, i2, truncateAt, zB);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING)) + com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING)) + com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize.getWidth());
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        textView.setLayoutParams(layoutParams2);
        addView(imageView);
        addView(textView);
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_ENABLE)) {
            TextView textView2 = new TextView(this.a.getApplicationContext());
            String strD2 = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT);
            int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_SIZE_DP);
            int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_COLOR);
            textView2.setIncludeFontPadding(false);
            textView2.setBackgroundColor(0);
            k.b(textView2, strD2, iC3, iC4, null, 0, 1, TextUtils.TruncateAt.END, false);
            textView2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 58);
            layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            layoutParams3.addRule(15);
            layoutParams3.addRule(11);
            textView2.setLayoutParams(layoutParams3);
            textView2.setId(2);
            addView(textView2);
            APSize aPSize2 = new APSize(32, 32);
            ImageView imageView2 = new ImageView(this.a);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize2.getHeight()));
            layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            layoutParams4.addRule(15);
            layoutParams4.addRule(11);
            imageView2.setLayoutParams(layoutParams4);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageResource(R.drawable.onestore_x_ic_detail_cancel_2);
            addView(imageView2);
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, this.f1595b));
        layoutParams5.addRule(15);
        layoutParams5.addRule(11);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setId(1);
        addView(linearLayout);
        if (this.d) {
            addView(b());
        }
    }

    private LinearLayout b() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
            layoutParams.addRule(13);
            layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setBackgroundDrawable(this.c);
            linearLayout.setId(3);
            ImageView imageView = new ImageView(this.a);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_SIZE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.width), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.height));
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
            imageView.setLayoutParams(layoutParams2);
            linearLayout.addView(imageView);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID) == -100) {
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_reward.png", imageView, false);
            } else {
                imageView.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_OFFERWALL_TOTAL_REWARD_ICON_RESOURCE_ID));
            }
            TextView textView = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            textView.setLayoutParams(layoutParams3);
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setId(4);
            linearLayout.addView(textView);
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            textView2.setGravity(17);
            textView2.setSingleLine();
            textView2.setId(5);
            linearLayout.addView(textView2);
            ImageView imageView2 = new ImageView(this.a);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 9), com.igaworks.adpopcorn.cores.common.d.a(this.a, 13));
            layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
            imageView2.setLayoutParams(layoutParams4);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setImageResource(R.drawable.onestore_ic_my_cash);
            linearLayout.addView(imageView2);
        } catch (Exception unused) {
        }
        return linearLayout;
    }
}
