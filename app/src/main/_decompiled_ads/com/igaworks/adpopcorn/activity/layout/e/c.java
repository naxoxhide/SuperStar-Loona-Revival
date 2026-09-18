package com.igaworks.adpopcorn.activity.layout.e;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RelativeLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1590b;

    public c(Context context) {
        super(context);
        this.a = context;
        this.f1590b = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, d.a(context, this.f1590b)));
        setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private void a() {
        ?? r8;
        int i;
        String str;
        TextUtils.TruncateAt truncateAt;
        Typeface typeface;
        int i2;
        int i3;
        int i4;
        int i5;
        g gVarA = g.a();
        TextView textView = new TextView(this.a.getApplicationContext());
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        LinearLayout linearLayout = new LinearLayout(this.a.getApplicationContext());
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_ID);
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        if (zB) {
            int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
            layoutParams.leftMargin = d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING));
            layoutParams.rightMargin = d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING));
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            imageView2.setLayoutParams(layoutParams);
            if (iC3 == -100) {
                r8 = 0;
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_back_btn.png", imageView2, false);
            } else {
                r8 = 0;
                imageView2.setImageResource(iC3);
            }
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setId(r8);
            int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP);
            boolean zB2 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD);
            textView.setIncludeFontPadding(r8);
            textView.setBackgroundColor(r8);
            if (strD == null || strD.length() <= 0) {
                i = 17;
                str = gVarA.a;
                truncateAt = TextUtils.TruncateAt.END;
                typeface = null;
                i2 = 1;
                i3 = 0;
                i4 = -2;
            } else {
                truncateAt = TextUtils.TruncateAt.END;
                typeface = null;
                i2 = 1;
                str = strD;
                i3 = 0;
                i = 17;
                i4 = -2;
            }
            k.b(textView, str, iC4, iC2, typeface, i3, i2, truncateAt, zB2);
            textView.setGravity(i);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, -1);
            layoutParams2.leftMargin = d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING)) + d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING)) + d.a(this.a, aPSizeA.getWidth());
            layoutParams2.addRule(15);
            layoutParams2.addRule(14);
            textView.setLayoutParams(layoutParams2);
            addView(imageView2);
            addView(textView);
            ImageView imageView3 = new ImageView(this.a.getApplicationContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(d.a(this.a, 24), d.a(this.a, 24));
            layoutParams3.rightMargin = d.a(this.a, 16);
            layoutParams3.leftMargin = d.a(this.a, 6);
            layoutParams3.addRule(15);
            layoutParams3.addRule(11);
            imageView3.setLayoutParams(layoutParams3);
            imageView3.setImageResource(R.drawable.lottemem_cs);
            imageView3.setId(2);
            addView(imageView3);
        } else {
            int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID);
            APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(d.a(this.a, aPSizeA2.getWidth()), d.a(this.a, aPSizeA2.getHeight()));
            layoutParams4.rightMargin = d.a(this.a, 10);
            layoutParams4.addRule(15);
            layoutParams4.addRule(11);
            imageView2.setLayoutParams(layoutParams4);
            if (iC5 == -100) {
                i5 = 0;
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close.png", imageView2, false);
            } else {
                i5 = 0;
                imageView2.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID));
            }
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setId(i5);
            if (iC != -100) {
                try {
                    APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_SIZE);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(d.a(this.a, aPSizeA3.getWidth()), d.a(this.a, aPSizeA3.getHeight()));
                    layoutParams5.addRule(14);
                    layoutParams5.addRule(15);
                    imageView.setLayoutParams(layoutParams5);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setImageResource(iC);
                    addView(imageView);
                } catch (Exception unused) {
                }
            } else if (strD == null || strD.length() <= 0) {
                try {
                    APSize aPSizeA4 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_SIZE);
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(d.a(this.a, aPSizeA4.getWidth()), d.a(this.a, aPSizeA4.getHeight()));
                    layoutParams6.addRule(14);
                    layoutParams6.addRule(15);
                    imageView.setLayoutParams(layoutParams6);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_main_logo_android.png", imageView, false);
                    addView(imageView);
                } catch (Exception unused2) {
                }
            } else {
                RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams7.addRule(14);
                layoutParams7.addRule(15);
                textView.setIncludeFontPadding(false);
                textView.setLayoutParams(layoutParams7);
                textView.setGravity(17);
                textView.setBackgroundColor(0);
                k.b(textView, strD, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
                addView(textView);
            }
            addView(imageView2);
        }
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(d.a(this.a, 42), d.a(this.a, this.f1590b));
        layoutParams8.addRule(15);
        layoutParams8.addRule(zB ? 9 : 11);
        linearLayout.setLayoutParams(layoutParams8);
        linearLayout.setId(1);
        addView(linearLayout);
    }
}
