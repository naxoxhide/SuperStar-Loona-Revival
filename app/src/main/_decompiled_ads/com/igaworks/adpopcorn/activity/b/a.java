package com.igaworks.adpopcorn.activity.b;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.StateSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.igaworks.adpopcorn.cores.model.g f1510b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private GradientDrawable h;
    private boolean i;
    private boolean j;
    private StateListDrawable k;
    private StateListDrawable l;
    private ColorStateList m;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0404a implements View.OnClickListener {
        ViewOnClickListenerC0404a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    public a(Context context, int i, com.igaworks.adpopcorn.cores.model.g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener, boolean z, boolean z2) {
        super(context, i);
        this.a = context;
        this.f1510b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
        this.i = z;
        this.j = z2;
    }

    private int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0508  */
    /* JADX WARN: Code duplicated, block: B:53:0x050e  */
    /* JADX WARN: Code duplicated, block: B:56:0x053e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0542  */
    /* JADX WARN: Code duplicated, block: B:59:0x0545  */
    /* JADX WARN: Code duplicated, block: B:61:0x054c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x054e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0555  */
    /* JADX WARN: Code duplicated, block: B:66:0x058f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0595  */
    /* JADX WARN: Code duplicated, block: B:70:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:71:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:80:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:86:0x061a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x061c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0630  */
    private View a() {
        int iA;
        int iA2;
        int i;
        int i2;
        Context context;
        int i3;
        int iA3;
        TextView textView;
        int iA4;
        int iC;
        int i4;
        String strW = this.f1510b.w();
        String strV = this.f1510b.V();
        String strP = this.f1510b.P();
        String strN = this.f1510b.N();
        int iK = this.f1510b.K();
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        if (this.i) {
            linearLayout.setGravity(17);
        } else {
            linearLayout.setGravity(81);
        }
        boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_CAMPAIGN_DIALOG);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        if (this.i) {
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 487), com.igaworks.adpopcorn.cores.common.d.a(this.a, 96)));
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 96);
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 487);
        } else {
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 336), com.igaworks.adpopcorn.cores.common.d.a(this.a, 96)));
            iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 96);
            iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 336);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundDrawable(this.f);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_APP_ICON_SIZE);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth() + 30), iA));
        Context context2 = this.a;
        com.igaworks.adpopcorn.activity.c.i iVar = new com.igaworks.adpopcorn.activity.c.i(context2, com.igaworks.adpopcorn.cores.common.d.a(context2, 10));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        layoutParams.gravity = 17;
        iVar.setLayoutParams(layoutParams);
        frameLayout.addView(iVar);
        ImageView imageView = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 37), com.igaworks.adpopcorn.cores.common.d.a(this.a, 37));
        layoutParams2.gravity = 17;
        imageView.setLayoutParams(layoutParams2);
        frameLayout.addView(imageView);
        linearLayout2.addView(frameLayout);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(16);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        textView2.setLayoutParams(layoutParams3);
        textView2.setMaxLines(1);
        linearLayout3.addView(textView2);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        layoutParams4.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        linearLayout4.setLayoutParams(layoutParams4);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        linearLayout3.addView(linearLayout4);
        TextView textView3 = new TextView(this.a);
        APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BADGE_SIZE);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight())));
        textView3.setSingleLine();
        textView3.setIncludeFontPadding(false);
        textView3.setGravity(17);
        int iC2 = k.c(iK);
        int iB = k.b(iK);
        String strA = k.a(this.c, iK);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iB, iB});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()) / 2);
        gradientDrawable.setGradientType(0);
        textView3.setBackgroundDrawable(gradientDrawable);
        k.b(textView3, strA, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BADGE_TEXT_SIZE_DP), iC2, null, 0, 1, TextUtils.TruncateAt.END, false);
        if (strA != null && strA.length() > 9) {
            textView3.setTextSize(1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BADGE_TEXT_SIZE_DP) - 6);
        }
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_SIZE).getHeight()));
        layoutParams5.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
        textView4.setLayoutParams(layoutParams5);
        textView4.setGravity(19);
        linearLayout4.addView(textView4);
        linearLayout2.addView(linearLayout3);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(iA2, -2));
        linearLayout5.setOrientation(1);
        linearLayout5.setBackgroundDrawable(this.g);
        int iA5 = a(com.igaworks.adpopcorn.cores.common.d.a(this.a, 336));
        ImageView imageView2 = new ImageView(this.a);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, iA5));
        if (this.j || this.i || this.f1510b.T() == null || this.f1510b.T().length() <= 4) {
            if (zB) {
                int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_DIVIDER_LR_PADDING);
                ImageView imageView3 = new ImageView(this.a);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iA2 - com.igaworks.adpopcorn.cores.common.d.a(this.a, iC3 * 2), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
                layoutParams6.gravity = 17;
                imageView3.setLayoutParams(layoutParams6);
                imageView3.setBackgroundColor(Color.parseColor("#251904"));
                linearLayout5.addView(imageView3);
                i = 8;
            } else {
                i = 8;
            }
            imageView2.setVisibility(i);
        } else {
            com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1510b.T(), imageView2, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
            iA5 = 0;
        }
        linearLayout5.addView(imageView2);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        if (this.i) {
            i2 = -1;
            linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 103)));
        } else {
            i2 = -1;
            linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 124) + iA5));
        }
        linearLayout6.setOrientation(0);
        linearLayout6.setVerticalScrollBarEnabled(true);
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams7.gravity = 48;
        layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        textView5.setLayoutParams(layoutParams7);
        textView5.setMovementMethod(new ScrollingMovementMethod());
        k.b(textView5, "\n" + strN, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView5.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 3));
        linearLayout6.addView(textView5);
        linearLayout5.addView(linearLayout6);
        ImageView imageView4 = new ImageView(this.a);
        if (zB) {
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(iA2 - com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_DIVIDER_LR_PADDING) * 2), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
            layoutParams8.gravity = 17;
            imageView4.setLayoutParams(layoutParams8);
        } else {
            imageView4.setLayoutParams(new LinearLayout.LayoutParams(iA2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        }
        imageView4.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_DIVIDER_COLOR)));
        linearLayout5.addView(imageView4);
        APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_SIZE);
        APSize aPSizeA4 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_SIZE);
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(iA2, com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getHeight() + 32));
        linearLayout7.setGravity(zB ? 21 : 17);
        layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        linearLayout7.setLayoutParams(layoutParams9);
        linearLayout7.setOrientation(0);
        linearLayout7.setBackgroundDrawable(this.h);
        boolean zB2 = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_EXCHANGE_BTN_POSITION);
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getHeight()));
        layoutParams10.gravity = 17;
        if (zB2) {
            if (zB) {
                context = this.a;
                i3 = 5;
            } else {
                iA3 = 0;
            }
            layoutParams10.rightMargin = iA3;
            textView6.setLayoutParams(layoutParams10);
            textView6.setGravity(17);
            k.b(textView6, this.c.y, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
            if (zB) {
                textView6.setTextColor(this.m);
            } else {
                textView6.setBackgroundDrawable(this.k);
            }
            textView6.setOnClickListener(this.d);
            textView = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getHeight()));
            layoutParams11.gravity = 17;
            if (zB2) {
                Context context3 = this.a;
                if (zB) {
                    i4 = 8;
                } else {
                    i4 = 10;
                }
                iA4 = com.igaworks.adpopcorn.cores.common.d.a(context3, i4);
            } else if (zB) {
                iA4 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            } else {
                iA4 = 0;
            }
            layoutParams11.rightMargin = iA4;
            textView.setLayoutParams(layoutParams11);
            textView.setGravity(17);
            k.b(textView, this.c.z, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
            if (zB) {
                textView.setTextColor(this.m);
            } else {
                textView.setBackgroundDrawable(this.l);
            }
            textView.setOnClickListener(new ViewOnClickListenerC0404a());
            if (zB2) {
                linearLayout7.addView(textView);
                linearLayout7.addView(textView6);
            } else {
                linearLayout7.addView(textView6);
                linearLayout7.addView(textView);
            }
            linearLayout.addView(linearLayout2);
            linearLayout.addView(linearLayout5);
            linearLayout.addView(linearLayout7);
            if (iK != 16 || iK == 26 || iK == 27) {
                imageView.setVisibility(0);
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_play.png", imageView, false);
            } else {
                imageView.setVisibility(8);
            }
            k.b(textView2, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, true);
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_SIZE_DP);
            if (strP == null && strP.length() >= 9) {
                iC -= 4;
            } else if (strP != null && strP.length() >= 7) {
                iC -= 2;
            }
            int i5 = iC;
            if (strP != null || strP.length() < 1) {
                textView4.setVisibility(8);
            }
            k.b(textView4, "+" + strP, i5, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, true);
            com.igaworks.adpopcorn.cores.common.e.b(this.a);
            Context context4 = this.a;
            com.igaworks.adpopcorn.cores.common.e.a(context4, strW, iVar, com.igaworks.adpopcorn.cores.common.d.a(context4, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()), (com.igaworks.adpopcorn.cores.common.e.b) null);
            return linearLayout;
        }
        context = this.a;
        i3 = zB ? 8 : 16;
        iA3 = com.igaworks.adpopcorn.cores.common.d.a(context, i3);
        layoutParams10.rightMargin = iA3;
        textView6.setLayoutParams(layoutParams10);
        textView6.setGravity(17);
        k.b(textView6, this.c.y, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
        if (zB) {
            textView6.setTextColor(this.m);
        } else {
            textView6.setBackgroundDrawable(this.k);
        }
        textView6.setOnClickListener(this.d);
        textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA4.getHeight()));
        layoutParams12.gravity = 17;
        if (zB2) {
            Context context5 = this.a;
            if (zB) {
                i4 = 8;
            } else {
                i4 = 10;
            }
            iA4 = com.igaworks.adpopcorn.cores.common.d.a(context5, i4);
        } else if (zB) {
            iA4 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
        } else {
            iA4 = 0;
        }
        layoutParams12.rightMargin = iA4;
        textView.setLayoutParams(layoutParams12);
        textView.setGravity(17);
        k.b(textView, this.c.z, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
        if (zB) {
            textView.setTextColor(this.m);
        } else {
            textView.setBackgroundDrawable(this.l);
        }
        textView.setOnClickListener(new ViewOnClickListenerC0404a());
        if (zB2) {
            linearLayout7.addView(textView);
            linearLayout7.addView(textView6);
        } else {
            linearLayout7.addView(textView6);
            linearLayout7.addView(textView);
        }
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout5);
        linearLayout.addView(linearLayout7);
        if (iK != 16) {
            imageView.setVisibility(0);
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_play.png", imageView, false);
        } else {
            imageView.setVisibility(0);
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_play.png", imageView, false);
        }
        k.b(textView2, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, true);
        iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_SIZE_DP);
        if (strP == null) {
            if (strP != null) {
                iC -= 2;
            }
        } else if (strP != null) {
            iC -= 2;
        }
        int i6 = iC;
        if (strP != null) {
            textView4.setVisibility(8);
        } else {
            textView4.setVisibility(8);
        }
        k.b(textView4, "+" + strP, i6, Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, true);
        com.igaworks.adpopcorn.cores.common.e.b(this.a);
        Context context6 = this.a;
        com.igaworks.adpopcorn.cores.common.e.a(context6, strW, iVar, com.igaworks.adpopcorn.cores.common.d.a(context6, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()), (com.igaworks.adpopcorn.cores.common.e.b) null);
        return linearLayout;
    }

    private void b() {
        int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.e = gradientDrawable;
        gradientDrawable.setShape(0);
        this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_CORNER_ROUND_DP)));
        this.e.setGradientType(0);
        this.e.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_LINE_COLOR)));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR)});
        this.f = gradientDrawable2;
        gradientDrawable2.setShape(0);
        float f = iA;
        this.f.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR)});
        this.g = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.g.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR)});
        this.h = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.h.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        this.h.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_BG_COLOR)});
        gradientDrawable5.setShape(0);
        gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable5.setGradientType(0);
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_POSITIVE_BTN_BG_COLOR)});
        gradientDrawable6.setAlpha(125);
        gradientDrawable6.setShape(0);
        gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable7.setShape(0);
        gradientDrawable7.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable7.setGradientType(0);
        gradientDrawable7.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_BG_COLOR)});
        gradientDrawable8.setShape(0);
        gradientDrawable8.setAlpha(125);
        gradientDrawable8.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_CORNER_ROUND_DP)));
        gradientDrawable8.setGradientType(0);
        gradientDrawable8.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.k = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable6);
        this.k.addState(StateSet.WILD_CARD, gradientDrawable5);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        this.l = stateListDrawable2;
        stateListDrawable2.addState(new int[]{R.attr.state_pressed}, gradientDrawable8);
        this.l.addState(StateSet.WILD_CARD, gradientDrawable7);
        this.m = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor(k.b(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR), 50)), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)});
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
        b();
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
