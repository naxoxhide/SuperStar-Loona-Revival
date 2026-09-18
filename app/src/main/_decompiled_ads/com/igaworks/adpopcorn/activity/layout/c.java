package com.igaworks.adpopcorn.activity.layout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class c extends RelativeLayout {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1583b;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022";
            try {
                String strA = com.igaworks.adpopcorn.a.b.a().a(c.this.a, "adpopcorn_sdk_flag", "no_ad_landingurl", "https://adpopcorn.notion.site/FAQ-35edb7e2c4ff4311b2bcf616c8e1b022");
                if (strA != null && strA.length() > 0) {
                    str = strA;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setData(Uri.parse(str));
                c.this.a.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public c(Context context) {
        super(context);
        this.a = context;
        this.f1583b = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, this.f1583b)));
        setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
        a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v9 */
    private void a() {
        LinearLayout linearLayout;
        ?? r13;
        int i;
        String str;
        TextUtils.TruncateAt truncateAt;
        Typeface typeface;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        g gVarA = g.a();
        TextView textView = new TextView(this.a.getApplicationContext());
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        LinearLayout linearLayout2 = new LinearLayout(this.a.getApplicationContext());
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_ID);
        String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_TITLE_TEXT);
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_COLOR);
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_MODE);
        if (zB) {
            linearLayout = linearLayout2;
            int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING));
            layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING));
            layoutParams.addRule(15);
            layoutParams.addRule(9);
            imageView2.setLayoutParams(layoutParams);
            if (iC3 == -100) {
                r13 = 0;
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_back_btn.png", imageView2, false);
            } else {
                r13 = 0;
                imageView2.setImageResource(iC3);
            }
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setId(r13);
            int iC4 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP);
            boolean zB2 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD);
            textView.setIncludeFontPadding(r13);
            textView.setBackgroundColor(r13);
            if (strD == null || strD.length() <= 0) {
                i = 17;
                str = gVarA.a;
                truncateAt = TextUtils.TruncateAt.END;
                typeface = null;
                i2 = 1;
                i3 = 0;
            } else {
                typeface = null;
                str = strD;
                i3 = 0;
                i = 17;
                i2 = 1;
                truncateAt = TextUtils.TruncateAt.END;
            }
            k.b(textView, str, iC4, iC2, typeface, i3, i2, truncateAt, zB2);
            textView.setGravity(i);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_L_PADDING)) + com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_R_PADDING)) + com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth());
            layoutParams2.addRule(15);
            i4 = 9;
            layoutParams2.addRule(9);
            textView.setLayoutParams(layoutParams2);
            addView(imageView2);
            addView(textView);
            if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_ENABLE)) {
                TextView textView2 = new TextView(this.a.getApplicationContext());
                String strD2 = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT);
                int iC5 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_SIZE_DP);
                int iC6 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_NAVIGATION_TOP_BAR_FAQ_BTN_TEXT_COLOR);
                textView2.setIncludeFontPadding(false);
                textView2.setBackgroundColor(0);
                k.b(textView2, strD2, iC5, iC6, null, 0, 1, TextUtils.TruncateAt.END, false);
                textView2.setGravity(i);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                layoutParams3.addRule(15);
                i5 = 11;
                layoutParams3.addRule(11);
                textView2.setLayoutParams(layoutParams3);
                textView2.setOnClickListener(new a());
                addView(textView2);
            } else {
                i5 = 11;
            }
        } else {
            int iC7 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID);
            APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_SIZE);
            linearLayout = linearLayout2;
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()));
            layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            layoutParams4.addRule(15);
            int i8 = 11;
            layoutParams4.addRule(11);
            imageView2.setLayoutParams(layoutParams4);
            if (iC7 == -100) {
                i6 = 0;
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_close.png", imageView2, false);
            } else {
                i6 = 0;
                imageView2.setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_CLOSE_BTN_RESOURCE_ID));
            }
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView2.setId(i6);
            if (iC != -100) {
                try {
                    APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_SIZE);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getHeight()));
                    layoutParams5.addRule(14);
                    try {
                        layoutParams5.addRule(15);
                        imageView.setLayoutParams(layoutParams5);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setImageResource(iC);
                        i7 = 9;
                        addView(imageView);
                    } catch (Exception unused) {
                        i7 = 9;
                    }
                } catch (Exception unused2) {
                    i7 = 9;
                }
            } else if (strD == null || strD.length() <= 0) {
                i7 = 9;
                try {
                    APSize aPSizeA4 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.OFFERWALL_TITLE_LOGO_RESOURCE_SIZE);
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getHeight()));
                    layoutParams6.addRule(14);
                    layoutParams6.addRule(15);
                    imageView.setLayoutParams(layoutParams6);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_main_logo_android.png", imageView, false);
                    addView(imageView);
                } catch (Exception unused3) {
                }
            } else {
                RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams7.addRule(14);
                layoutParams7.addRule(15);
                textView.setIncludeFontPadding(false);
                textView.setLayoutParams(layoutParams7);
                textView.setGravity(17);
                textView.setBackgroundColor(0);
                i7 = 9;
                k.b(textView, strD, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.TOP_BAR_TEXT_BOLD));
                addView(textView);
                i8 = 11;
            }
            addView(imageView2);
            i5 = i8;
            i4 = i7;
        }
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, this.f1583b));
        layoutParams8.addRule(15);
        if (zB) {
            layoutParams8.addRule(i4);
        } else {
            layoutParams8.addRule(i5);
        }
        LinearLayout linearLayout3 = linearLayout;
        linearLayout3.setLayoutParams(layoutParams8);
        linearLayout3.setId(1);
        addView(linearLayout3);
    }
}
