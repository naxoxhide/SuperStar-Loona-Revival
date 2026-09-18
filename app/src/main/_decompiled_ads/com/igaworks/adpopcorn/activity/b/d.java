package com.igaworks.adpopcorn.activity.b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static class a extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1515b;
        private GradientDrawable c;
        private GradientDrawable d;
        private GradientDrawable e;
        private GradientDrawable f;
        private View.OnClickListener g;
        private View.OnClickListener h;
        private com.igaworks.adpopcorn.cores.common.g i;
        private String j;
        private String k;
        private String l;
        private String m;
        private int n;
        private boolean o;
        private int p;
        private boolean q;
        private StateListDrawable r;
        private StateListDrawable s;
        private ColorStateList t;
        private ColorStateList u;
        private ColorStateList v;
        private int w;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$a$a, reason: collision with other inner class name */
        class RunnableC0407a implements Runnable {
            final /* synthetic */ TextView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollView f1516b;

            RunnableC0407a(TextView textView, ScrollView scrollView) {
                this.a = textView;
                this.f1516b = scrollView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                int i;
                if (a.this.q) {
                    context = a.this.a;
                    i = 160;
                } else {
                    context = a.this.a;
                    i = 230;
                }
                int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
                TextView textView = this.a;
                if (textView == null || textView.getHeight() < iA) {
                    return;
                }
                this.f1516b.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(a.this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), iA));
            }
        }

        class b implements Runnable {
            final /* synthetic */ TextView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollView f1517b;
            final /* synthetic */ int c;

            b(TextView textView, ScrollView scrollView, int i) {
                this.a = textView;
                this.f1517b = scrollView;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                int i;
                if (a.this.q) {
                    context = a.this.a;
                    i = 160;
                } else {
                    context = a.this.a;
                    i = 230;
                }
                int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
                TextView textView = this.a;
                if (textView == null || textView.getHeight() < iA) {
                    return;
                }
                this.f1517b.setLayoutParams(new LinearLayout.LayoutParams(this.c - com.igaworks.adpopcorn.cores.common.d.a(a.this.a, 40), iA));
            }
        }

        public a(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z) {
            super(context, i);
            this.p = -1;
            this.w = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.g = onClickListener;
            this.h = onClickListener2;
            this.j = str;
            this.k = str2;
            this.p = i2;
            this.l = str3;
            this.m = str4;
            this.n = 2;
            this.o = false;
            this.q = z;
        }

        public a(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, boolean z, boolean z2) {
            super(context, i);
            this.p = -1;
            this.w = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            if (this.w == 1 && Build.VERSION.SDK_INT >= 23) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.g = onClickListener;
            this.j = str;
            this.k = str2;
            this.p = i2;
            this.l = str3;
            this.n = 1;
            this.o = z2;
            this.q = z;
        }

        private View a() {
            int i;
            int i2;
            float f;
            LinearLayout.LayoutParams layoutParams;
            int iC;
            int color;
            TextUtils.TruncateAt truncateAt;
            Typeface typeface;
            int i3;
            int i4;
            boolean z;
            String str;
            StateListDrawable stateListDrawable;
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_COMMON_DIALOG);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.a);
            if (zB) {
                i = 15;
                i2 = 5;
                f = 1.0f;
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 54)));
                textView.setGravity(19);
                k.b(textView, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0);
            } else {
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                textView.setGravity(17);
                i = 15;
                i2 = 5;
                f = 1.0f;
                k.b(textView, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 45), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 45), com.igaworks.adpopcorn.cores.common.d.a(this.a, 13));
                textView.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), 1.0f);
            }
            textView.setBackgroundDrawable(this.f1515b);
            linearLayout.addView(textView);
            if (zB) {
                int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_DIVIDER_LR_PADDING);
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
                ImageView imageView = new ImageView(this.a);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) - com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2 * 2), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
                layoutParams2.gravity = 17;
                imageView.setLayoutParams(layoutParams2);
                imageView.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_COMMON_DIALOG_TITLE_DIVIDER_COLOR)));
                linearLayout2.addView(imageView);
                linearLayout.addView(linearLayout2);
            }
            ScrollView scrollView = new ScrollView(this.a);
            scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            textView2.setBackgroundColor(Color.parseColor("#ffffff"));
            if (zB) {
                k.b(textView2, this.k, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                textView2.setGravity(3);
                textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, i), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, i), 0);
            } else {
                k.b(textView2, this.k, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                int i5 = this.p;
                if (i5 != -1) {
                    textView2.setGravity(i5);
                }
                textView2.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), f);
                textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 28), com.igaworks.adpopcorn.cores.common.d.a(this.a, 21), com.igaworks.adpopcorn.cores.common.d.a(this.a, 28), com.igaworks.adpopcorn.cores.common.d.a(this.a, i));
            }
            scrollView.addView(textView2);
            scrollView.post(new RunnableC0407a(textView2, scrollView));
            linearLayout.addView(scrollView);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_SIZE);
            APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_SIZE);
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight() + 30)));
            linearLayout3.setOrientation(0);
            if (zB) {
                linearLayout3.setGravity(21);
            } else {
                linearLayout3.setGravity(49);
            }
            linearLayout3.setBackgroundDrawable(this.c);
            TextView textView3 = new TextView(this.a);
            textView3.setGravity(17);
            if (this.n != 1) {
                layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()));
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, !zB ? 10 : 8);
            } else if (zB) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
                layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, i2);
                layoutParams = layoutParams3;
            } else {
                layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 200), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            }
            textView3.setLayoutParams(layoutParams);
            if (this.o) {
                String str2 = this.l;
                iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP);
                com.igaworks.adpopcorn.style.a aVarB = com.igaworks.adpopcorn.style.a.b();
                if (zB) {
                    color = Color.parseColor(aVarB.d(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR));
                    truncateAt = TextUtils.TruncateAt.END;
                    typeface = null;
                    i3 = 0;
                    i4 = 1;
                    z = false;
                    str = str2;
                    k.b(textView3, str, iC, color, typeface, i3, i4, truncateAt, z);
                    textView3.setTextColor(this.t);
                } else {
                    k.b(textView3, str2, iC, Color.parseColor(aVarB.d(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                    stateListDrawable = this.r;
                    textView3.setBackgroundDrawable(stateListDrawable);
                }
            } else {
                String str3 = this.l;
                iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP);
                com.igaworks.adpopcorn.style.a aVarB2 = com.igaworks.adpopcorn.style.a.b();
                if (zB) {
                    color = Color.parseColor(aVarB2.d(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR));
                    truncateAt = TextUtils.TruncateAt.END;
                    typeface = null;
                    i3 = 0;
                    i4 = 1;
                    z = false;
                    str = str3;
                    k.b(textView3, str, iC, color, typeface, i3, i4, truncateAt, z);
                    textView3.setTextColor(this.t);
                } else {
                    k.b(textView3, str3, iC, Color.parseColor(aVarB2.d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                    stateListDrawable = this.s;
                    textView3.setBackgroundDrawable(stateListDrawable);
                }
            }
            textView3.setOnClickListener(this.g);
            TextView textView4 = new TextView(this.a);
            textView4.setGravity(17);
            if (zB) {
                if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_TEXT_COLOR) != -100) {
                    k.b(textView4, this.m, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                } else {
                    k.b(textView4, this.m, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                    textView4.setTextColor(this.t);
                }
                if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_COLOR) != -100) {
                    textView4.setBackgroundDrawable(this.r);
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
                layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                textView4.setLayoutParams(layoutParams4);
            } else {
                textView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight())));
                k.b(textView4, this.m, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                textView4.setBackgroundDrawable(this.r);
            }
            textView4.setOnClickListener(this.h);
            int i6 = this.n;
            if (i6 == 1) {
                linearLayout3.addView(textView3);
            } else if (i6 == 2) {
                linearLayout3.addView(textView3);
                linearLayout3.addView(textView4);
            }
            linearLayout.addView(linearLayout3);
            return linearLayout;
        }

        private View b() {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setGravity(81);
            int iC = com.igaworks.adpopcorn.cores.common.d.c();
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = (!this.q && iC < com.igaworks.adpopcorn.cores.common.d.a(this.a, 480)) ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setBackgroundDrawable(this.d);
            linearLayout.addView(linearLayout2);
            TextView textView = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 25);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(3);
            k.b(textView, this.k, 15, Color.parseColor("#454545"), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 25), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 25), 0);
            textView.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
            linearLayout2.addView(textView);
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            linearLayout3.setLayoutParams(layoutParams3);
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(17);
            TextView textView2 = new TextView(this.a);
            textView2.setGravity(17);
            if (this.n == 1) {
                textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 180), -1));
                textView2.setOnClickListener(this.g);
                linearLayout3.addView(textView2);
                k.b(textView2, this.l, 16, Color.parseColor("#3e3877"), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView2.setBackgroundDrawable(this.s);
                textView2.setTextColor(this.u);
            } else {
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 160), -1);
                layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                textView2.setLayoutParams(layoutParams4);
                textView2.setBackgroundDrawable(this.s);
                textView2.setOnClickListener(this.g);
                k.b(textView2, this.l, 16, Color.parseColor("#3e3877"), null, 0, 0, TextUtils.TruncateAt.END, false);
                TextView textView3 = new TextView(this.a);
                textView3.setGravity(17);
                textView3.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 160), -1));
                textView3.setOnClickListener(this.h);
                textView3.setBackgroundDrawable(this.r);
                k.b(textView3, this.m, 16, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView2.setTextColor(this.u);
                textView3.setTextColor(this.v);
                linearLayout3.addView(textView2);
                linearLayout3.addView(textView3);
            }
            linearLayout2.addView(linearLayout3);
            return linearLayout;
        }

        private View c() {
            LinearLayout.LayoutParams layoutParams;
            String str;
            int color;
            int iC = com.igaworks.adpopcorn.cores.common.d.c();
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.setGravity(49);
            TextView textView = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
            layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 192);
            textView.setLayoutParams(layoutParams2);
            textView.setGravity(17);
            k.b(textView, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView.setBackgroundDrawable(this.f1515b);
            linearLayout.addView(textView);
            ScrollView scrollView = new ScrollView(this.a);
            scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), -2));
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), -2));
            textView2.setBackgroundColor(Color.parseColor("#ffffff"));
            k.b(textView2, this.k, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
            textView2.setGravity(17);
            textView2.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
            textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
            textView2.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 108.5f));
            scrollView.addView(textView2);
            scrollView.post(new b(textView2, scrollView, iC));
            linearLayout.addView(scrollView);
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
            linearLayout2.setOrientation(0);
            linearLayout2.setBackgroundColor(Color.parseColor("#ececec"));
            linearLayout.addView(linearLayout2);
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 49.5f)));
            linearLayout3.setOrientation(0);
            linearLayout3.setGravity(17);
            linearLayout3.setBackgroundDrawable(this.c);
            TextView textView3 = new TextView(this.a);
            textView3.setGravity(17);
            if (this.n == 1) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
                str = this.l;
                color = Color.parseColor("#6280e3");
            } else {
                layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                str = this.l;
                color = Color.parseColor("#929292");
            }
            k.b(textView3, str, 14, color, null, 0, 1, TextUtils.TruncateAt.END, false);
            textView3.setLayoutParams(layoutParams);
            textView3.setOnClickListener(this.g);
            TextView textView4 = new TextView(this.a);
            textView4.setGravity(17);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            k.b(textView4, this.m, 14, Color.parseColor("#6280e3"), null, 0, 1, TextUtils.TruncateAt.END, false);
            textView4.setOnClickListener(this.h);
            int i = this.n;
            if (i == 1) {
                linearLayout3.addView(textView3);
            } else if (i == 2) {
                linearLayout3.addView(textView3);
                linearLayout3.addView(textView4);
            }
            linearLayout.addView(linearLayout3);
            return linearLayout;
        }

        private void d() {
            GradientDrawable gradientDrawable;
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            this.i = gVarA;
            gVarA.d();
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_COMMON_DIALOG);
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_CORNER_ROUND_DP));
            if (zB) {
                gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            } else {
                gradientDrawable = this.w == 2 ? new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-789517, -789517}) : new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-789517, -920587});
            }
            this.f1515b = gradientDrawable;
            this.f1515b.setShape(0);
            float f = iA;
            this.f1515b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1515b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            this.c.setGradientType(0);
            int i = this.w;
            if (i != 1) {
                if (i == 2) {
                    return;
                }
                int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
                GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
                gradientDrawable3.setShape(0);
                gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
                gradientDrawable3.setGradientType(0);
                GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
                gradientDrawable4.setShape(0);
                gradientDrawable4.setAlpha(125);
                gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
                gradientDrawable4.setGradientType(0);
                GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
                gradientDrawable5.setShape(0);
                gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
                gradientDrawable5.setGradientType(0);
                gradientDrawable5.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
                GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
                gradientDrawable6.setShape(0);
                gradientDrawable6.setAlpha(125);
                gradientDrawable6.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
                gradientDrawable6.setGradientType(0);
                gradientDrawable6.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
                StateListDrawable stateListDrawable = new StateListDrawable();
                this.r = stateListDrawable;
                stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable4);
                this.r.addState(StateSet.WILD_CARD, gradientDrawable3);
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                this.s = stateListDrawable2;
                stateListDrawable2.addState(new int[]{R.attr.state_pressed}, gradientDrawable6);
                this.s.addState(StateSet.WILD_CARD, gradientDrawable5);
                this.t = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor(k.b(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR), 50)), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)});
                return;
            }
            GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.d = gradientDrawable7;
            gradientDrawable7.setShape(0);
            this.d.setCornerRadii(new float[]{com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0.0f, 0.0f, 0.0f, 0.0f});
            this.d.setGradientType(0);
            GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1510401, -1510401});
            this.e = gradientDrawable8;
            gradientDrawable8.setShape(0);
            this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5));
            this.e.setGradientType(0);
            GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-13532426, -13532426});
            this.f = gradientDrawable9;
            gradientDrawable9.setShape(0);
            this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5));
            this.f.setGradientType(0);
            int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
            GradientDrawable gradientDrawable10 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
            gradientDrawable10.setShape(0);
            gradientDrawable10.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable10.setGradientType(0);
            GradientDrawable gradientDrawable11 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC2, iC2});
            gradientDrawable11.setShape(0);
            gradientDrawable11.setAlpha(204);
            gradientDrawable11.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable11.setGradientType(0);
            GradientDrawable gradientDrawable12 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            gradientDrawable12.setShape(0);
            gradientDrawable12.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable12.setGradientType(0);
            gradientDrawable12.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
            GradientDrawable gradientDrawable13 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            gradientDrawable13.setShape(0);
            gradientDrawable13.setAlpha(204);
            gradientDrawable13.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable13.setGradientType(0);
            gradientDrawable13.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
            StateListDrawable stateListDrawable3 = new StateListDrawable();
            this.r = stateListDrawable3;
            stateListDrawable3.addState(new int[]{R.attr.state_pressed}, gradientDrawable11);
            this.r.addState(StateSet.WILD_CARD, gradientDrawable10);
            StateListDrawable stateListDrawable4 = new StateListDrawable();
            this.s = stateListDrawable4;
            stateListDrawable4.addState(new int[]{R.attr.state_pressed}, gradientDrawable13);
            this.s.addState(StateSet.WILD_CARD, gradientDrawable12);
            this.v = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")});
            this.u = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor("#7f4b469c"), Color.parseColor("#4b469c")});
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
                getWindow().addFlags(524288);
            }
        }

        @Override // android.app.Dialog
        public void onCreate(Bundle bundle) {
            View viewC;
            super.onCreate(bundle);
            d();
            int i = this.w;
            if (i == 1) {
                viewC = b();
            } else {
                viewC = i == 2 ? c() : a();
            }
            setContentView(viewC);
        }
    }

    public static class b extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1518b;
        private GradientDrawable c;
        private View.OnClickListener d;
        private View.OnClickListener e;
        private com.igaworks.adpopcorn.cores.common.g f;
        private String g;
        private String h;
        private String i;
        private String j;
        private int k;
        private boolean l;
        private StateListDrawable m;
        private StateListDrawable n;
        private ColorStateList o;
        private com.igaworks.adpopcorn.activity.c.a p;

        class a implements Runnable {
            final /* synthetic */ TextView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollView f1519b;

            a(TextView textView, ScrollView scrollView) {
                this.a = textView;
                this.f1519b = scrollView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                int i;
                if (b.this.l) {
                    context = b.this.a;
                    i = 160;
                } else {
                    context = b.this.a;
                    i = 230;
                }
                int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
                TextView textView = this.a;
                if (textView == null || textView.getHeight() < iA) {
                    return;
                }
                this.f1519b.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(b.this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), iA));
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$b$b, reason: collision with other inner class name */
        class RunnableC0408b implements Runnable {
            final /* synthetic */ TextView a;

            RunnableC0408b(b bVar, TextView textView) {
                this.a = textView;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getLineCount() > 1) {
                    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                }
            }
        }

        class c implements Runnable {
            final /* synthetic */ LinearLayout a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollView f1520b;

            c(LinearLayout linearLayout, ScrollView scrollView) {
                this.a = linearLayout;
                this.f1520b = scrollView;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                int i;
                if (b.this.l) {
                    context = b.this.a;
                    i = 140;
                } else {
                    context = b.this.a;
                    i = 330;
                }
                int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
                LinearLayout linearLayout = this.a;
                if (linearLayout == null || linearLayout.getHeight() < iA) {
                    return;
                }
                this.f1520b.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(b.this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), iA));
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$b$d, reason: collision with other inner class name */
        class ViewOnClickListenerC0409d implements View.OnClickListener {
            ViewOnClickListenerC0409d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.p != null) {
                    b.this.p.setSelected(!b.this.p.isSelected());
                }
            }
        }

        class e implements View.OnClickListener {
            e() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.p != null) {
                    b.this.p.setSelected(!b.this.p.isSelected());
                }
            }
        }

        class f implements View.OnClickListener {
            f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.e != null) {
                    b.this.e.onClick(b.this.p);
                }
            }
        }

        public b(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z) {
            super(context, i);
            this.k = -1;
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.d = onClickListener;
            this.e = onClickListener2;
            this.g = str;
            this.h = str2;
            this.k = i2;
            this.i = str3;
            this.j = str4;
            this.l = z;
        }

        private View a() {
            int i;
            float f2;
            LinearLayout.LayoutParams layoutParams;
            int iA;
            int iA2;
            int iA3;
            int iA4;
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_COMMON_DIALOG);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.a);
            if (zB) {
                i = 15;
                f2 = 1.0f;
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 54)));
                textView.setGravity(19);
                k.b(textView, this.g, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0);
            } else {
                textView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                textView.setGravity(17);
                i = 15;
                f2 = 1.0f;
                k.b(textView, this.g, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
                textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 45), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 45), com.igaworks.adpopcorn.cores.common.d.a(this.a, 13));
                textView.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), 1.0f);
            }
            textView.setBackgroundDrawable(this.f1518b);
            linearLayout.addView(textView);
            if (zB) {
                int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_DIVIDER_LR_PADDING);
                LinearLayout linearLayout2 = new LinearLayout(this.a);
                linearLayout2.setOrientation(1);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
                linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
                ImageView imageView = new ImageView(this.a);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) - com.igaworks.adpopcorn.cores.common.d.a(this.a, iC * 2), com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
                layoutParams2.gravity = 17;
                imageView.setLayoutParams(layoutParams2);
                imageView.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_COMMON_DIALOG_TITLE_DIVIDER_COLOR)));
                linearLayout2.addView(imageView);
                linearLayout.addView(linearLayout2);
            }
            String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CUSTOM_TEXT);
            if (strD != null && strD.length() > 0) {
                this.h = strD;
            }
            if (strD == null || strD.length() <= 0) {
                ScrollView scrollView = new ScrollView(this.a);
                scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
                scrollView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                linearLayout.addView(scrollView);
                LinearLayout linearLayout3 = new LinearLayout(this.a);
                linearLayout3.setOrientation(1);
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                linearLayout3.setGravity(17);
                scrollView.addView(linearLayout3);
                TextView textView2 = new TextView(this.a);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                textView2.setBackgroundColor(Color.parseColor("#ffffff"));
                textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, i), com.igaworks.adpopcorn.cores.common.d.a(this.a, i), com.igaworks.adpopcorn.cores.common.d.a(this.a, i), com.igaworks.adpopcorn.cores.common.d.a(this.a, i));
                k.b(textView2, this.f.a1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout3.addView(textView2);
                FrameLayout frameLayout = new FrameLayout(this.a);
                frameLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                linearLayout3.addView(frameLayout);
                LinearLayout linearLayout4 = new LinearLayout(this.a);
                int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_PADDING);
                linearLayout4.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_BACKGROUND_COLOR));
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO) - com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), -2);
                layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                linearLayout4.setLayoutParams(layoutParams3);
                linearLayout4.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2), com.igaworks.adpopcorn.cores.common.d.a(this.a, iC2));
                linearLayout4.setOrientation(1);
                frameLayout.addView(linearLayout4);
                TextView textView3 = new TextView(this.a);
                textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                k.b(textView3, this.f.b1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout4.addView(textView3);
                TextView textView4 = new TextView(this.a);
                textView4.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP) + 4)));
                String str = this.f.c1;
                if (com.igaworks.adpopcorn.a.d.a(this.a).f()) {
                    str = this.f.d1;
                }
                k.b(textView4, str, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                textView4.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), 0, 0);
                textView4.post(new RunnableC0408b(this, textView4));
                linearLayout4.addView(textView4);
                TextView textView5 = new TextView(this.a);
                textView5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView5.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, 0);
                k.b(textView5, this.f.e1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout4.addView(textView5);
                TextView textView6 = new TextView(this.a);
                textView6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView6.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), 0, 0);
                k.b(textView6, this.f.f1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout4.addView(textView6);
                TextView textView7 = new TextView(this.a);
                textView7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView7.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 15), 0, 0);
                k.b(textView7, this.f.g1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout4.addView(textView7);
                TextView textView8 = new TextView(this.a);
                textView8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView8.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), 0, 0);
                k.b(textView8, this.f.h1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                linearLayout4.addView(textView8);
                scrollView.post(new c(linearLayout3, scrollView));
            } else {
                ScrollView scrollView2 = new ScrollView(this.a);
                scrollView2.setBackgroundColor(Color.parseColor("#ffffff"));
                scrollView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                TextView textView9 = new TextView(this.a);
                textView9.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
                textView9.setBackgroundColor(Color.parseColor("#ffffff"));
                String str2 = this.h;
                if (zB) {
                    k.b(textView9, str2, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                    textView9.setGravity(3);
                    iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                    iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                    iA4 = 0;
                } else {
                    k.b(textView9, str2, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
                    int i2 = this.k;
                    if (i2 != -1) {
                        textView9.setGravity(i2);
                    }
                    textView9.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), f2);
                    iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 28);
                    iA2 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 21);
                    iA3 = com.igaworks.adpopcorn.cores.common.d.a(this.a, 28);
                    iA4 = com.igaworks.adpopcorn.cores.common.d.a(this.a, i);
                }
                textView9.setPadding(iA, iA2, iA3, iA4);
                scrollView2.addView(textView9);
                scrollView2.post(new a(textView9, scrollView2));
                linearLayout.addView(scrollView2);
            }
            LinearLayout linearLayout5 = new LinearLayout(this.a);
            linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 58)));
            linearLayout5.setGravity(19);
            linearLayout5.setOrientation(0);
            linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
            this.p = new com.igaworks.adpopcorn.activity.c.a(this.a);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_SIZE);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
            layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            layoutParams4.gravity = 17;
            this.p.setLayoutParams(layoutParams4);
            this.p.setSelected(false);
            this.p.setOnClickListener(new ViewOnClickListenerC0409d());
            TextView textView10 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.gravity = 17;
            layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
            textView10.setLayoutParams(layoutParams5);
            textView10.setIncludeFontPadding(false);
            textView10.setGravity(16);
            k.b(textView10, this.f.i1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout5.setOnClickListener(new e());
            linearLayout5.addView(this.p);
            linearLayout5.addView(textView10);
            linearLayout.addView(linearLayout5);
            APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_SIZE);
            APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_SIZE);
            LinearLayout linearLayout6 = new LinearLayout(this.a);
            linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight() + 30)));
            linearLayout6.setOrientation(0);
            linearLayout6.setGravity(zB == 0 ? 49 : 21);
            linearLayout6.setBackgroundDrawable(this.c);
            TextView textView11 = new TextView(this.a);
            textView11.setGravity(17);
            int iA5 = com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getWidth());
            int iA6 = com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getHeight());
            if (zB == 0) {
                layoutParams = new LinearLayout.LayoutParams(iA5, iA6);
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                textView11.setLayoutParams(layoutParams);
                k.b(textView11, this.i, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                textView11.setBackgroundDrawable(this.n);
            } else {
                layoutParams = new LinearLayout.LayoutParams(iA5, iA6);
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
                textView11.setLayoutParams(layoutParams);
                k.b(textView11, this.i, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                textView11.setTextColor(this.o);
            }
            textView11.setOnClickListener(this.d);
            TextView textView12 = new TextView(this.a);
            textView12.setGravity(17);
            if (zB) {
                if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_TEXT_COLOR) != -100) {
                    k.b(textView12, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                } else {
                    k.b(textView12, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                    textView12.setTextColor(this.o);
                }
                if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_COLOR) != -100) {
                    textView12.setBackgroundDrawable(this.m);
                }
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight()));
                layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 15);
                textView12.setLayoutParams(layoutParams6);
            } else {
                textView12.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight())));
                k.b(textView12, this.j, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                textView12.setBackgroundDrawable(this.m);
            }
            textView12.setOnClickListener(new f());
            linearLayout6.addView(textView11);
            linearLayout6.addView(textView12);
            linearLayout.addView(linearLayout6);
            return linearLayout;
        }

        private void b() {
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            this.f = gVarA;
            gVarA.d();
            boolean zB = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_MATERIAL_STYLE_COMMON_DIALOG);
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_CORNER_ROUND_DP));
            this.f1518b = zB ? new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1}) : new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-920587, -920587});
            this.f1518b.setShape(0);
            float f2 = iA;
            this.f1518b.setCornerRadii(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1518b.setGradientType(0);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable;
            gradientDrawable.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2});
            this.c.setGradientType(0);
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_BG_COLOR);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_COLOR) != -100) {
                iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_AGREE_BTN_COLOR);
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable2.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{iC, iC});
            gradientDrawable3.setShape(0);
            gradientDrawable3.setAlpha(125);
            gradientDrawable3.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable3.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            gradientDrawable4.setShape(0);
            gradientDrawable4.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable4.setGradientType(0);
            gradientDrawable4.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
            GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            gradientDrawable5.setShape(0);
            gradientDrawable5.setAlpha(125);
            gradientDrawable5.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            gradientDrawable5.setGradientType(0);
            gradientDrawable5.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.m = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable3);
            this.m.addState(StateSet.WILD_CARD, gradientDrawable2);
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            this.n = stateListDrawable2;
            stateListDrawable2.addState(new int[]{R.attr.state_pressed}, gradientDrawable5);
            this.n.addState(StateSet.WILD_CARD, gradientDrawable4);
            this.o = new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor(k.b(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR), 50)), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.MATERIAL_STYLE_DIALOG_BTN_TEXT_COLOR)});
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
            b();
            setContentView(a());
        }
    }

    public static class c extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1521b;

        public c(Context context, int i) {
            super(context, i);
            this.f1521b = 0;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = 0.6f;
            getWindow().setAttributes(layoutParams);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_CUSTOM_MEDIA_MODE) == 1 && Build.VERSION.SDK_INT >= 23) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
            this.a = context;
            this.f1521b = -1;
        }

        private View a() {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 329), -2));
            linearLayout.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            ProgressBar progressBar = new ProgressBar(this.a, null, R.attr.progressBarStyleLarge);
            progressBar.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
            this.f1521b = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.LOADING_BAR_COLOR);
            progressBar.getIndeterminateDrawable().setColorFilter(this.f1521b, PorterDuff.Mode.MULTIPLY);
            linearLayout.addView(progressBar);
            return linearLayout;
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
            setContentView(a());
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$d, reason: collision with other inner class name */
    public static class DialogC0410d extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1522b;
        private AdapterView.OnItemClickListener c;
        private int d;
        private ArrayList<String> e;
        private c f;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$d$a */
        class a implements Runnable {
            final /* synthetic */ ListView a;

            a(ListView listView) {
                this.a = listView;
            }

            @Override // java.lang.Runnable
            public void run() {
                ListView listView = this.a;
                if (listView == null || listView.getHeight() < com.igaworks.adpopcorn.cores.common.d.a(DialogC0410d.this.a, 215)) {
                    return;
                }
                this.a.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(DialogC0410d.this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(DialogC0410d.this.a, 215)));
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$d$b */
        class b implements AdapterView.OnItemClickListener {
            b() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DialogC0410d.this.f != null) {
                    DialogC0410d.this.d = i;
                    DialogC0410d.this.f.notifyDataSetInvalidated();
                }
                if (DialogC0410d.this.c != null) {
                    DialogC0410d.this.c.onItemClick(adapterView, view, i, j);
                }
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$d$c */
        public class c extends BaseAdapter {
            private Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List<String> f1524b;

            public c(Context context, List<String> list) {
                this.a = context;
                this.f1524b = list;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                List<String> list = this.f1524b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            @Override // android.widget.Adapter
            public Object getItem(int i) {
                return null;
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return 0L;
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout;
                TextView textView;
                com.igaworks.adpopcorn.activity.c.d dVar;
                if (view == null) {
                    linearLayout = new LinearLayout(this.a);
                    linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
                    linearLayout.setGravity(16);
                    textView = new TextView(this.a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(16);
                    textView.setId(0);
                    dVar = new com.igaworks.adpopcorn.activity.c.d(this.a);
                    dVar.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16)));
                    dVar.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), com.igaworks.adpopcorn.cores.common.d.a(this.a, 3));
                    dVar.setId(1);
                    linearLayout.addView(textView);
                    linearLayout.addView(dVar);
                } else {
                    linearLayout = (LinearLayout) view;
                    textView = (TextView) linearLayout.findViewById(0);
                    dVar = (com.igaworks.adpopcorn.activity.c.d) linearLayout.findViewById(1);
                }
                com.igaworks.adpopcorn.activity.c.d dVar2 = dVar;
                k.b(textView, this.f1524b.get(i), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
                if (DialogC0410d.this.d != -1 ? DialogC0410d.this.d != i : i != 0) {
                    dVar2.setChecked(false);
                } else {
                    dVar2.setChecked(true);
                }
                return linearLayout;
            }
        }

        public DialogC0410d(Context context, int i, ArrayList<String> arrayList, int i2, boolean z, AdapterView.OnItemClickListener onItemClickListener) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.e = arrayList;
            this.c = onItemClickListener;
            this.d = i2;
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f1522b = gradientDrawable;
            gradientDrawable.setShape(0);
            this.f1522b.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, 6));
            this.f1522b.setGradientType(0);
        }

        private View a() {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new AbsListView.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            linearLayout.setGravity(17);
            ListView listView = new ListView(this.a);
            listView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            c cVar = new c(this.a, this.e);
            this.f = cVar;
            listView.setAdapter((ListAdapter) cVar);
            listView.setDivider(new ColorDrawable(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_DIVIDER_COLOR)));
            listView.setDividerHeight(1);
            listView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
            listView.setBackgroundDrawable(this.f1522b);
            listView.setVerticalScrollBarEnabled(false);
            listView.setSelector(new ColorDrawable(0));
            listView.post(new a(listView));
            listView.setOnItemClickListener(new b());
            int i = this.d;
            if (i > 0) {
                listView.setSelection(i);
            }
            linearLayout.addView(listView);
            return linearLayout;
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
            setContentView(a());
        }
    }

    public static class e extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AdapterView.OnItemClickListener f1525b;
        private int c;
        private ArrayList<String> d;
        private c e;
        private GradientDrawable f;
        private boolean g;

        class a implements Runnable {
            final /* synthetic */ ListView a;

            a(ListView listView) {
                this.a = listView;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iB = ((int) (((double) com.igaworks.adpopcorn.cores.common.d.b()) * 0.9d)) - com.igaworks.adpopcorn.cores.common.d.a(e.this.a, 60);
                ListView listView = this.a;
                if (listView == null || listView.getHeight() < iB) {
                    return;
                }
                this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, iB));
            }
        }

        class b implements AdapterView.OnItemClickListener {
            b() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.e != null) {
                    e.this.c = i;
                    e.this.e.notifyDataSetInvalidated();
                }
                if (e.this.f1525b != null) {
                    e.this.f1525b.onItemClick(adapterView, view, i, j);
                }
            }
        }

        public class c extends BaseAdapter {
            private Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List<String> f1527b;

            public c(Context context, List<String> list) {
                this.a = context;
                this.f1527b = list;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                List<String> list = this.f1527b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            @Override // android.widget.Adapter
            public Object getItem(int i) {
                return null;
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return 0L;
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout;
                TextView textView;
                com.igaworks.adpopcorn.activity.c.j.c cVar;
                Context context;
                int i2;
                if (view == null) {
                    linearLayout = new LinearLayout(this.a);
                    linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 45)));
                    linearLayout.setGravity(17);
                    textView = new TextView(this.a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                    textView.setLayoutParams(layoutParams);
                    if (e.this.g) {
                        context = this.a;
                        i2 = 430;
                    } else {
                        context = this.a;
                        i2 = 254;
                    }
                    textView.setMaxWidth(com.igaworks.adpopcorn.cores.common.d.a(context, i2));
                    textView.setGravity(17);
                    textView.setId(0);
                    cVar = new com.igaworks.adpopcorn.activity.c.j.c(this.a);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
                    cVar.setLayoutParams(layoutParams2);
                    cVar.setId(1);
                    com.igaworks.adpopcorn.activity.c.j.c cVar2 = new com.igaworks.adpopcorn.activity.c.j.c(this.a);
                    cVar2.setLayoutParams(layoutParams2);
                    cVar2.setVisibility(4);
                    linearLayout.addView(cVar);
                    linearLayout.addView(textView);
                    linearLayout.addView(cVar2);
                } else {
                    linearLayout = (LinearLayout) view;
                    textView = (TextView) linearLayout.findViewById(0);
                    cVar = (com.igaworks.adpopcorn.activity.c.j.c) linearLayout.findViewById(1);
                }
                TextView textView2 = textView;
                k.b(textView2, this.f1527b.get(i), 17, Color.parseColor("#000000"), null, 0, 1, TextUtils.TruncateAt.END, false);
                if (e.this.c != -1 && e.this.c == i) {
                    cVar.setChecked(true);
                    textView2.setTextColor(Color.parseColor("#3a3294"));
                } else {
                    cVar.setChecked(false);
                }
                return linearLayout;
            }
        }

        public e(Context context, int i, ArrayList<String> arrayList, int i2, AdapterView.OnItemClickListener onItemClickListener) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            if (Build.VERSION.SDK_INT >= 23) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
            this.g = a(context);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f = gradientDrawable;
            gradientDrawable.setShape(0);
            this.f.setCornerRadii(new float[]{com.igaworks.adpopcorn.cores.common.d.a(context, 15), com.igaworks.adpopcorn.cores.common.d.a(context, 15), com.igaworks.adpopcorn.cores.common.d.a(context, 15), com.igaworks.adpopcorn.cores.common.d.a(context, 15), 0.0f, 0.0f, 0.0f, 0.0f});
            this.f.setGradientType(0);
            this.a = context;
            this.d = arrayList;
            this.f1525b = onItemClickListener;
            this.c = i2;
        }

        private View a() {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setGravity(81);
            int iC = com.igaworks.adpopcorn.cores.common.d.c();
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setOrientation(1);
            ViewGroup.LayoutParams layoutParams = (!this.g && iC < com.igaworks.adpopcorn.cores.common.d.a(this.a, 480)) ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 480), -2);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setGravity(80);
            linearLayout2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 25), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30), com.igaworks.adpopcorn.cores.common.d.a(this.a, 25), com.igaworks.adpopcorn.cores.common.d.a(this.a, 30));
            linearLayout2.setBackgroundDrawable(this.f);
            linearLayout.addView(linearLayout2);
            ListView listView = new ListView(this.a);
            listView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            c cVar = new c(this.a, this.d);
            this.e = cVar;
            listView.setAdapter((ListAdapter) cVar);
            listView.setDividerHeight(0);
            listView.setVerticalScrollBarEnabled(false);
            listView.setSelector(new ColorDrawable(0));
            listView.post(new a(listView));
            listView.setOnItemClickListener(new b());
            int i = this.c;
            if (i > 0) {
                listView.setSelection(i);
            }
            linearLayout2.addView(listView);
            return linearLayout;
        }

        private boolean a(Context context) {
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
            setContentView(a());
        }
    }

    public static class f extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1528b;
        private GradientDrawable c;
        private View.OnClickListener d;
        private View.OnClickListener e;
        private com.igaworks.adpopcorn.cores.common.g f;
        private String g;
        private String h;
        private String i;
        private boolean j;
        GradientDrawable k;
        GradientDrawable l;
        private com.igaworks.adpopcorn.activity.c.k.a m;
        private TextView n;

        class a implements Runnable {
            final /* synthetic */ TextView a;

            a(f fVar, TextView textView) {
                this.a = textView;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a.getLineCount() > 1) {
                    this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ LinearLayout a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollView f1529b;
            final /* synthetic */ int c;

            b(LinearLayout linearLayout, ScrollView scrollView, int i) {
                this.a = linearLayout;
                this.f1529b = scrollView;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context;
                int i;
                if (f.this.j) {
                    context = f.this.a;
                    i = 140;
                } else {
                    context = f.this.a;
                    i = 330;
                }
                int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
                LinearLayout linearLayout = this.a;
                if (linearLayout == null || linearLayout.getHeight() < iA) {
                    return;
                }
                this.f1529b.setLayoutParams(new LinearLayout.LayoutParams(this.c, iA));
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TextView textView;
                float f;
                if (f.this.m != null) {
                    f.this.m.setSelected(!f.this.m.isSelected());
                }
                if (f.this.m.isSelected()) {
                    if (Build.VERSION.SDK_INT < 11) {
                        return;
                    }
                    textView = f.this.n;
                    f = 1.0f;
                } else {
                    if (Build.VERSION.SDK_INT < 11) {
                        return;
                    }
                    textView = f.this.n;
                    f = 0.3f;
                }
                textView.setAlpha(f);
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$f$d, reason: collision with other inner class name */
        class ViewOnClickListenerC0411d implements View.OnClickListener {
            ViewOnClickListenerC0411d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.e != null) {
                    f.this.e.onClick(f.this.m);
                }
            }
        }

        public f(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.d = onClickListener;
            this.e = onClickListener2;
            this.g = str;
            this.h = str3;
            this.i = str4;
            this.j = z;
        }

        private View a() {
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 320);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.a);
            textView.setLayoutParams(new LinearLayout.LayoutParams(iA, com.igaworks.adpopcorn.cores.common.d.a(this.a, 48)));
            textView.setGravity(19);
            k.b(textView, this.g, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_TITLE_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0, 0);
            textView.setBackgroundDrawable(this.f1528b);
            linearLayout.addView(textView);
            ScrollView scrollView = new ScrollView(this.a);
            scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
            linearLayout.addView(scrollView);
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setOrientation(1);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
            linearLayout2.setGravity(19);
            scrollView.addView(linearLayout2);
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
            textView2.setBackgroundColor(Color.parseColor("#ffffff"));
            textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
            k.b(textView2, this.f.a1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_MAIN_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout2.addView(textView2);
            FrameLayout frameLayout = new FrameLayout(this.a);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
            frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout2.addView(frameLayout);
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            linearLayout3.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_BACKGROUND_COLOR));
            linearLayout3.setLayoutParams(new FrameLayout.LayoutParams(iA, -2));
            linearLayout3.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
            linearLayout3.setOrientation(1);
            frameLayout.addView(linearLayout3);
            TextView textView3 = new TextView(this.a);
            textView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            k.b(textView3, this.f.b1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout3.addView(textView3);
            TextView textView4 = new TextView(this.a);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            String str = this.f.c1;
            if (com.igaworks.adpopcorn.a.d.a(this.a).f()) {
                str = this.f.d1;
            }
            k.b(textView4, str, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
            textView4.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), 0, 0);
            textView4.post(new a(this, textView4));
            linearLayout3.addView(textView4);
            TextView textView5 = new TextView(this.a);
            textView5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView5.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), 0, 0);
            k.b(textView5, this.f.e1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout3.addView(textView5);
            TextView textView6 = new TextView(this.a);
            textView6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView6.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), 0, 0);
            k.b(textView6, this.f.f1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout3.addView(textView6);
            TextView textView7 = new TextView(this.a);
            textView7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView7.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 22), 0, 0);
            k.b(textView7, this.f.g1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_SUB_TITLE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout3.addView(textView7);
            TextView textView8 = new TextView(this.a);
            textView8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView8.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 3), 0, 0);
            k.b(textView8, this.f.h1, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_DESC_MESSAGE_TEXT_COLOR)), null, 0, 0, null, false);
            linearLayout3.addView(textView8);
            scrollView.post(new b(linearLayout2, scrollView, iA));
            LinearLayout linearLayout4 = new LinearLayout(this.a);
            linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(iA, com.igaworks.adpopcorn.cores.common.d.a(this.a, 76)));
            linearLayout4.setGravity(19);
            linearLayout4.setOrientation(0);
            linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
            TextView textView9 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.gravity = 17;
            layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            textView9.setLayoutParams(layoutParams);
            textView9.setIncludeFontPadding(false);
            textView9.setGravity(16);
            k.b(textView9, this.f.i1, 12, Color.parseColor("#2c2c2c"), null, 0, 0, null, false);
            this.m = new com.igaworks.adpopcorn.activity.c.k.a(this.a);
            APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_SIZE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
            layoutParams2.gravity = 17;
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            this.m.setLayoutParams(layoutParams2);
            this.m.setSelected(false);
            this.m.setOnClickListener(new c());
            linearLayout4.addView(textView9);
            linearLayout4.addView(this.m);
            linearLayout.addView(linearLayout4);
            APSize aPSizeA2 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_SIZE);
            APSize aPSizeA3 = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_SIZE);
            LinearLayout linearLayout5 = new LinearLayout(this.a);
            linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(iA, com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight() + 20)));
            linearLayout5.setOrientation(0);
            linearLayout5.setGravity(49);
            linearLayout5.setBackgroundDrawable(this.c);
            TextView textView10 = new TextView(this.a);
            textView10.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA3.getHeight()));
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
            textView10.setLayoutParams(layoutParams3);
            k.b(textView10, this.h, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
            textView10.setBackgroundDrawable(this.l);
            textView10.setOnClickListener(this.d);
            TextView textView11 = new TextView(this.a);
            this.n = textView11;
            textView11.setGravity(17);
            this.n.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA2.getHeight())));
            k.b(this.n, this.i, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_POSITIVE_BTN_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
            this.n.setBackgroundDrawable(this.k);
            if (Build.VERSION.SDK_INT >= 11) {
                this.n.setAlpha(0.3f);
            }
            this.n.setOnClickListener(new ViewOnClickListenerC0411d());
            linearLayout5.addView(textView10);
            linearLayout5.addView(this.n);
            linearLayout.addView(linearLayout5);
            return linearLayout;
        }

        private void b() {
            com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
            this.f = gVarA;
            gVarA.d();
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_CORNER_ROUND_DP));
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-789517, -789517});
            this.f1528b = gradientDrawable;
            gradientDrawable.setShape(0);
            float f = iA;
            this.f1528b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1528b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            this.c.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-12231749, -10280571});
            this.k = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.k.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            this.k.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            this.l = gradientDrawable4;
            gradientDrawable4.setShape(0);
            this.l.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            this.l.setGradientType(0);
            this.l.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
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
            b();
            setContentView(a());
        }
    }

    public static class g extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1530b;
        private GradientDrawable c;
        private GradientDrawable d;
        private GradientDrawable e;
        private AdapterView.OnItemClickListener f;
        private int g;
        private ArrayList<String> h;
        private e i;
        private com.igaworks.adpopcorn.cores.common.g j;
        private TextView k;

        class a implements Runnable {
            final /* synthetic */ ListView a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f1531b;

            a(ListView listView, int i) {
                this.a = listView;
                this.f1531b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iB = ((int) (((double) com.igaworks.adpopcorn.cores.common.d.b()) * 0.9d)) - com.igaworks.adpopcorn.cores.common.d.a(g.this.a, 120);
                ListView listView = this.a;
                if (listView == null || listView.getHeight() < iB) {
                    return;
                }
                this.a.setLayoutParams(new LinearLayout.LayoutParams(this.f1531b - com.igaworks.adpopcorn.cores.common.d.a(g.this.a, 80), iB));
            }
        }

        class b implements AdapterView.OnItemClickListener {
            b() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (Build.VERSION.SDK_INT >= 11) {
                    g.this.k.setAlpha(1.0f);
                }
                if (g.this.i != null) {
                    g.this.g = i;
                    g.this.i.notifyDataSetInvalidated();
                }
            }
        }

        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.d$g$d, reason: collision with other inner class name */
        class ViewOnClickListenerC0412d implements View.OnClickListener {
            ViewOnClickListenerC0412d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.f != null) {
                    g.this.f.onItemClick(null, view, g.this.g, 0L);
                }
            }
        }

        public class e extends BaseAdapter {
            private Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List<String> f1532b;

            public e(Context context, List<String> list) {
                this.a = context;
                this.f1532b = list;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                List<String> list = this.f1532b;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }

            @Override // android.widget.Adapter
            public Object getItem(int i) {
                return null;
            }

            @Override // android.widget.Adapter
            public long getItemId(int i) {
                return 0L;
            }

            @Override // android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout;
                TextView textView;
                com.igaworks.adpopcorn.activity.c.k.b bVar;
                if (view == null) {
                    linearLayout = new LinearLayout(this.a);
                    linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 52)));
                    linearLayout.setGravity(16);
                    textView = new TextView(this.a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                    layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 37);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(16);
                    textView.setId(0);
                    bVar = new com.igaworks.adpopcorn.activity.c.k.b(this.a);
                    bVar.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20)));
                    bVar.setId(1);
                    linearLayout.addView(bVar);
                    linearLayout.addView(textView);
                } else {
                    linearLayout = (LinearLayout) view;
                    textView = (TextView) linearLayout.findViewById(0);
                    bVar = (com.igaworks.adpopcorn.activity.c.k.b) linearLayout.findViewById(1);
                }
                k.b(textView, this.f1532b.get(i), 12, Color.parseColor("#2a2a2a"), null, 0, 1, TextUtils.TruncateAt.END, false);
                if (g.this.g != -1 && g.this.g == i) {
                    bVar.setChecked(true);
                } else {
                    bVar.setChecked(false);
                }
                return linearLayout;
            }
        }

        public g(Context context, int i, ArrayList<String> arrayList, int i2, AdapterView.OnItemClickListener onItemClickListener) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.h = arrayList;
            this.f = onItemClickListener;
            this.g = i2;
            this.j = com.igaworks.adpopcorn.cores.common.g.a();
            int iA = com.igaworks.adpopcorn.cores.common.d.a(context, 8);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f1530b = gradientDrawable;
            gradientDrawable.setShape(0);
            float f = iA;
            this.f1530b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1530b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            this.c.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-12231749, -10280571});
            this.d = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.d.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            this.d.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_BG_COLOR)});
            this.e = gradientDrawable4;
            gradientDrawable4.setShape(0);
            this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_CORNER_ROUND_DP)));
            this.e.setGradientType(0);
            this.e.setStroke(com.igaworks.adpopcorn.cores.common.d.a(context, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_DIALOG_BTN_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.COMMON_DIALOG_NEGATIVE_BTN_LINE_COLOR)));
        }

        private View a() {
            int iC = com.igaworks.adpopcorn.cores.common.d.c();
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 80), -2));
            linearLayout.setGravity(49);
            ListView listView = new ListView(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 80), -2);
            layoutParams.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 168);
            listView.setLayoutParams(layoutParams);
            e eVar = new e(this.a, this.h);
            this.i = eVar;
            listView.setAdapter((ListAdapter) eVar);
            listView.setDivider(new ColorDrawable(-1250068));
            listView.setDividerHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
            listView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
            listView.setBackgroundDrawable(this.f1530b);
            listView.setVerticalScrollBarEnabled(false);
            listView.setSelector(new ColorDrawable(0));
            listView.post(new a(listView, iC));
            listView.setOnItemClickListener(new b());
            int i = this.g;
            if (i > 0) {
                listView.setSelection(i);
            }
            linearLayout.addView(listView);
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(iC - com.igaworks.adpopcorn.cores.common.d.a(this.a, 80), com.igaworks.adpopcorn.cores.common.d.a(this.a, 56)));
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundDrawable(this.c);
            TextView textView = new TextView(this.a);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 110), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            textView.setLayoutParams(layoutParams2);
            textView.setBackgroundDrawable(this.e);
            textView.setOnClickListener(new c());
            k.b(textView, this.j.Z1, 12, Color.parseColor("#929292"), null, 0, 0, TextUtils.TruncateAt.END, false);
            TextView textView2 = new TextView(this.a);
            this.k = textView2;
            textView2.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 110), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            this.k.setLayoutParams(layoutParams3);
            this.k.setOnClickListener(new ViewOnClickListenerC0412d());
            this.k.setBackgroundDrawable(this.d);
            if (this.g == -1 && Build.VERSION.SDK_INT >= 11) {
                this.k.setAlpha(0.3f);
            }
            k.b(this.k, this.j.w2, 12, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            linearLayout2.addView(textView);
            linearLayout2.addView(this.k);
            linearLayout.addView(linearLayout2);
            return linearLayout;
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
            setContentView(a());
        }
    }

    public static int a(Context context) {
        try {
            return (((Activity) context).getWindow().getAttributes().flags & 1024) == 1024 ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar;
        } catch (Exception unused) {
        }
    }
}
