package com.igaworks.adpopcorn.renewal.b;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static class a extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1649b;
        private GradientDrawable c;
        private GradientDrawable d;
        private GradientDrawable e;
        private View.OnClickListener f;
        private View.OnClickListener g;
        private g h;
        private String i;
        private String j;
        private String k;
        private String l;
        private int m;
        private boolean n;

        public a(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.f = onClickListener;
            this.g = onClickListener2;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            this.m = 2;
            this.n = z;
        }

        public a(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, boolean z, boolean z2) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.f = onClickListener;
            this.i = str;
            this.j = str2;
            this.k = str3;
            this.m = 1;
            this.n = z;
        }

        private View a() {
            LinearLayout.LayoutParams layoutParams;
            GradientDrawable gradientDrawable;
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 51));
            textView.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0, 0);
            textView.setLayoutParams(layoutParams2);
            textView.setBackgroundDrawable(this.f1649b);
            textView.setGravity(49);
            k.a(textView, this.i, 18, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
            linearLayout.addView(textView);
            final ScrollView scrollView = new ScrollView(this.a);
            scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            final TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), -2));
            textView2.setBackgroundColor(Color.parseColor("#ffffff"));
            k.a(textView2, this.j, 14, Color.parseColor("#66737F"), null, 0, 0, null, false);
            textView2.setGravity(19);
            textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
            scrollView.addView(textView2);
            scrollView.post(new Runnable() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$d$a$yxcmKOVyvctNlFfCGZWQhYmGy84
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(textView2, scrollView);
                }
            });
            linearLayout.addView(scrollView);
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), com.igaworks.adpopcorn.cores.common.d.a(this.a, 78)));
            linearLayout2.setBackgroundDrawable(this.c);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            TextView textView3 = new TextView(this.a);
            textView3.setGravity(17);
            if (this.m == 1) {
                layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 268), com.igaworks.adpopcorn.cores.common.d.a(this.a, 46));
                k.a(textView3, this.k, 16, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
                gradientDrawable = this.d;
            } else {
                layoutParams = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 129), com.igaworks.adpopcorn.cores.common.d.a(this.a, 46));
                layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
                k.a(textView3, this.k, 16, Color.parseColor("#9CA6AF"), null, 0, 1, TextUtils.TruncateAt.END, false);
                gradientDrawable = this.e;
            }
            textView3.setBackgroundDrawable(gradientDrawable);
            textView3.setLayoutParams(layoutParams);
            textView3.setOnClickListener(this.f);
            TextView textView4 = new TextView(this.a);
            textView4.setGravity(17);
            textView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 129), com.igaworks.adpopcorn.cores.common.d.a(this.a, 46)));
            k.a(textView4, this.l, 16, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
            textView4.setBackgroundDrawable(this.d);
            textView4.setOnClickListener(this.g);
            int i = this.m;
            if (i == 1) {
                linearLayout2.addView(textView3);
            } else if (i == 2) {
                linearLayout2.addView(textView3);
                linearLayout2.addView(textView4);
            }
            linearLayout.addView(linearLayout2);
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(TextView textView, ScrollView scrollView) {
            Context context;
            int i;
            if (this.n) {
                context = this.a;
                i = 160;
            } else {
                context = this.a;
                i = 230;
            }
            int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
            if (textView == null || textView.getHeight() < iA) {
                return;
            }
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO), iA));
        }

        private void b() {
            g gVarA = g.a();
            this.h = gVarA;
            gVarA.d();
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f1649b = gradientDrawable;
            gradientDrawable.setShape(0);
            float f = iA;
            this.f1649b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1649b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            this.c.setGradientType(0);
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            int i = ApRewardStyle.mainOfferwallColor;
            GradientDrawable gradientDrawable3 = new GradientDrawable(orientation, new int[]{i, i});
            this.d = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.d.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            this.d.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-920844, -920844});
            this.e = gradientDrawable4;
            gradientDrawable4.setShape(0);
            this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            this.e.setGradientType(0);
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

    public static class b extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1650b;
        private GradientDrawable c;
        private GradientDrawable d;
        private GradientDrawable e;
        private GradientDrawable f;
        private View.OnClickListener g;
        private View.OnClickListener h;
        private g i;
        private String j;
        private String k;
        private String l;
        private boolean m;
        private com.igaworks.adpopcorn.renewal.c.a n;
        private TextView o;
        private int p;

        public b(Context context, int i, String str, String str2, int i2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2, boolean z) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.g = onClickListener;
            this.h = onClickListener2;
            this.j = str;
            this.k = str3;
            this.l = str4;
            this.m = z;
        }

        private View a() {
            Context context;
            int i;
            if (this.m) {
                context = this.a;
                i = 420;
            } else {
                context = this.a;
                i = ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO;
            }
            this.p = com.igaworks.adpopcorn.cores.common.d.a(context, i);
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.p, -2));
            linearLayout.setGravity(17);
            TextView textView = new TextView(this.a);
            textView.setLayoutParams(new LinearLayout.LayoutParams(this.p, com.igaworks.adpopcorn.cores.common.d.a(this.a, 59)));
            textView.setGravity(17);
            k.a(textView, this.j, 18, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView.setBackgroundDrawable(this.f1650b);
            linearLayout.addView(textView);
            ImageView imageView = new ImageView(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.p, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundColor(Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.MATERIAL_STYLE_COMMON_DIALOG_TITLE_DIVIDER_COLOR)));
            linearLayout.addView(imageView);
            final ScrollView scrollView = new ScrollView(this.a);
            scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(this.p, -2));
            linearLayout.addView(scrollView);
            final LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setOrientation(1);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(this.p, -2));
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundDrawable(this.c);
            scrollView.addView(linearLayout2);
            TextView textView2 = new TextView(this.a);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(this.p, -2));
            textView2.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), 0);
            k.a(textView2, this.i.a1, 14, Color.parseColor("#66737F"), null, 0, 0, null, false);
            linearLayout2.addView(textView2);
            FrameLayout frameLayout = new FrameLayout(this.a);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(this.p, -2));
            frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout2.addView(frameLayout);
            LinearLayout linearLayout3 = new LinearLayout(this.a);
            FrameLayout.LayoutParams layoutParams2 = this.m ? new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 388), -2) : new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 268), -2);
            layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            linearLayout3.setLayoutParams(layoutParams2);
            linearLayout3.setOrientation(1);
            frameLayout.addView(linearLayout3);
            TextView textView3 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
            textView3.setLayoutParams(layoutParams3);
            k.a(textView3, this.i.b1, 14, Color.parseColor("#66737F"), null, 0, 0, null, false);
            linearLayout3.addView(textView3);
            TextView textView4 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            textView4.setLayoutParams(layoutParams4);
            k.a(textView4, this.i.c1, 14, Color.parseColor("#212529"), null, 0, 0, null, false);
            linearLayout3.addView(textView4);
            TextView textView5 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
            textView5.setLayoutParams(layoutParams5);
            k.a(textView5, this.i.g1, 14, Color.parseColor("#66737F"), null, 0, 0, null, false);
            linearLayout3.addView(textView5);
            TextView textView6 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            textView6.setLayoutParams(layoutParams6);
            k.a(textView6, this.i.h1, 14, Color.parseColor("#212529"), null, 0, 0, null, false);
            linearLayout3.addView(textView6);
            scrollView.post(new Runnable() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$d$b$XDkm-r_qykXF20xWdGvoTw3pLoY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(linearLayout2, scrollView);
                }
            });
            LinearLayout linearLayout4 = new LinearLayout(this.a);
            linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(this.p, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20)));
            linearLayout4.setGravity(16);
            linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout4.setOrientation(0);
            this.n = new com.igaworks.adpopcorn.renewal.c.a(this.a);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
            layoutParams7.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
            layoutParams7.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams7.gravity = 17;
            this.n.setLayoutParams(layoutParams7);
            this.n.setSelected(false);
            this.n.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$d$b$vTlD_gyCAh99zkbqS0eH9pS6gLA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
            TextView textView7 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
            layoutParams8.gravity = 17;
            layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            textView7.setLayoutParams(layoutParams8);
            textView7.setIncludeFontPadding(false);
            textView7.setGravity(16);
            k.a(textView7, this.i.i1, 14, Color.parseColor("#212529"), null, 0, 0, null, false);
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$d$b$NGXRJ-wjsLFSqkBfRJ4kEYnpTzw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
            linearLayout4.addView(this.n);
            linearLayout4.addView(textView7);
            linearLayout.addView(linearLayout4);
            LinearLayout linearLayout5 = new LinearLayout(this.a);
            linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(this.p, com.igaworks.adpopcorn.cores.common.d.a(this.a, 82)));
            linearLayout5.setGravity(49);
            linearLayout5.setOrientation(0);
            linearLayout5.setBackgroundDrawable(this.c);
            TextView textView8 = new TextView(this.a);
            textView8.setGravity(17);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 46), 1.0f);
            layoutParams9.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            textView8.setLayoutParams(layoutParams9);
            k.a(textView8, this.k, 16, Color.parseColor("#9CA6AF"), null, 0, 1, TextUtils.TruncateAt.END, false);
            textView8.setBackgroundDrawable(this.d);
            textView8.setOnClickListener(this.g);
            TextView textView9 = new TextView(this.a);
            this.o = textView9;
            textView9.setGravity(17);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 46), 1.0f);
            layoutParams10.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            layoutParams10.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            this.o.setLayoutParams(layoutParams10);
            k.a(this.o, this.l, 16, Color.parseColor("#ffffff"), null, 0, 1, TextUtils.TruncateAt.END, false);
            this.o.setBackgroundDrawable(this.e);
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$d$b$lYvz8zgkXYrzrXTtBQeIOXAnhLM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
            linearLayout5.addView(textView8);
            linearLayout5.addView(this.o);
            linearLayout.addView(linearLayout5);
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            TextView textView;
            GradientDrawable gradientDrawable;
            com.igaworks.adpopcorn.renewal.c.a aVar = this.n;
            if (aVar != null) {
                aVar.setSelected(!aVar.isSelected());
                if (this.n.isSelected()) {
                    textView = this.o;
                    gradientDrawable = this.f;
                } else {
                    textView = this.o;
                    gradientDrawable = this.e;
                }
                textView.setBackgroundDrawable(gradientDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LinearLayout linearLayout, ScrollView scrollView) {
            Context context;
            int i;
            if (this.m) {
                context = this.a;
                i = 140;
            } else {
                context = this.a;
                i = 330;
            }
            int iA = com.igaworks.adpopcorn.cores.common.d.a(context, i);
            if (linearLayout == null || linearLayout.getHeight() < iA) {
                return;
            }
            scrollView.setLayoutParams(new LinearLayout.LayoutParams(this.p, iA));
        }

        private void b() {
            g gVarA = g.a();
            this.i = gVarA;
            gVarA.d();
            int iA = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f1650b = gradientDrawable;
            gradientDrawable.setShape(0);
            float f = iA;
            this.f1650b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1650b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            this.c.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-920844, -920844});
            this.d = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.d.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            this.d.setGradientType(0);
            GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-4669498, -4669498});
            this.e = gradientDrawable4;
            gradientDrawable4.setShape(0);
            this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            this.e.setGradientType(0);
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            int i = ApRewardStyle.mainOfferwallColor;
            GradientDrawable gradientDrawable5 = new GradientDrawable(orientation, new int[]{i, i});
            this.f = gradientDrawable5;
            gradientDrawable5.setShape(0);
            this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            this.f.setGradientType(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            TextView textView;
            GradientDrawable gradientDrawable;
            com.igaworks.adpopcorn.renewal.c.a aVar = this.n;
            if (aVar != null) {
                aVar.setSelected(!aVar.isSelected());
                if (this.n.isSelected()) {
                    textView = this.o;
                    gradientDrawable = this.f;
                } else {
                    textView = this.o;
                    gradientDrawable = this.e;
                }
                textView.setBackgroundDrawable(gradientDrawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            View.OnClickListener onClickListener = this.h;
            if (onClickListener != null) {
                onClickListener.onClick(this.n);
            }
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
        private int f1651b;

        public c(Context context, int i) {
            super(context, i);
            this.f1651b = 0;
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
            this.f1651b = -1;
        }

        private View a() {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 329), -2));
            linearLayout.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            ProgressBar progressBar = new ProgressBar(this.a, null, R.attr.progressBarStyleLarge);
            progressBar.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 40)));
            this.f1651b = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.LOADING_BAR_COLOR);
            progressBar.getIndeterminateDrawable().setColorFilter(this.f1651b, PorterDuff.Mode.MULTIPLY);
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

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.d$d, reason: collision with other inner class name */
    public static class DialogC0441d extends Dialog {
        private Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private GradientDrawable f1652b;
        private GradientDrawable c;
        private AdapterView.OnItemClickListener d;
        private boolean e;
        private int f;
        private ArrayList<String> g;
        private c h;
        private int i;
        private LinearLayout j;

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.d$d$a */
        class a implements Runnable {
            final /* synthetic */ ListView a;

            a(ListView listView) {
                this.a = listView;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iB = com.igaworks.adpopcorn.cores.common.d.b() - com.igaworks.adpopcorn.cores.common.d.a(DialogC0441d.this.a, 100);
                ListView listView = this.a;
                if (listView == null || listView.getHeight() < iB) {
                    return;
                }
                this.a.setLayoutParams(new LinearLayout.LayoutParams(DialogC0441d.this.i, iB));
                DialogC0441d.this.j.setVisibility(0);
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.d$d$b */
        class b implements AdapterView.OnItemClickListener {
            b() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DialogC0441d.this.h != null) {
                    DialogC0441d.this.f = i;
                    DialogC0441d.this.h.notifyDataSetInvalidated();
                }
                if (DialogC0441d.this.d != null) {
                    DialogC0441d.this.d.onItemClick(adapterView, view, i, j);
                }
            }
        }

        /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.d$d$c */
        public class c extends BaseAdapter {
            private Context a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private List<String> f1654b;

            public c(Context context, List<String> list) {
                this.a = context;
                this.f1654b = list;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                List<String> list = this.f1654b;
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
                com.igaworks.adpopcorn.renewal.c.b bVar;
                if (view == null) {
                    linearLayout = new LinearLayout(this.a);
                    linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42)));
                    linearLayout.setGravity(16);
                    textView = new TextView(this.a);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
                    layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
                    textView.setLayoutParams(layoutParams);
                    textView.setGravity(16);
                    textView.setId(0);
                    bVar = new com.igaworks.adpopcorn.renewal.c.b(this.a);
                    bVar.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20)));
                    bVar.setId(1);
                    linearLayout.addView(textView);
                    linearLayout.addView(bVar);
                } else {
                    linearLayout = (LinearLayout) view;
                    textView = (TextView) linearLayout.findViewById(0);
                    bVar = (com.igaworks.adpopcorn.renewal.c.b) linearLayout.findViewById(1);
                }
                int color = Color.parseColor("#808c99");
                if (DialogC0441d.this.f != -1 ? DialogC0441d.this.f != i : i != 0) {
                    bVar.setSelected(false);
                } else {
                    bVar.setSelected(true);
                }
                k.a(textView, this.f1654b.get(i), 16, bVar.isSelected() ? Color.parseColor("#212529") : color, null, 0, 1, TextUtils.TruncateAt.END, false);
                return linearLayout;
            }
        }

        public DialogC0441d(Context context, int i, ArrayList<String> arrayList, int i2, boolean z, AdapterView.OnItemClickListener onItemClickListener) {
            super(context, i);
            float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.flags = 2;
            layoutParams.dimAmount = fC;
            getWindow().setAttributes(layoutParams);
            this.a = context;
            this.g = arrayList;
            this.d = onItemClickListener;
            this.e = z;
            this.f = i2;
            int iA = com.igaworks.adpopcorn.cores.common.d.a(context, 12);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1, -1});
            this.f1652b = gradientDrawable;
            gradientDrawable.setShape(0);
            float f = iA;
            this.f1652b.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
            this.f1652b.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, -1});
            this.c = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.c.setGradientType(0);
        }

        private View a() {
            if (this.e) {
                this.i = com.igaworks.adpopcorn.cores.common.d.a(this.a, 420);
            } else {
                this.i = -1;
            }
            FrameLayout frameLayout = new FrameLayout(this.a);
            frameLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.i, -2);
            layoutParams.gravity = 81;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(81);
            frameLayout.addView(linearLayout);
            TextView textView = new TextView(this.a);
            textView.setLayoutParams(new LinearLayout.LayoutParams(this.i, com.igaworks.adpopcorn.cores.common.d.a(this.a, 45)));
            textView.setBackgroundDrawable(this.f1652b);
            textView.setGravity(49);
            textView.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, 0);
            k.a(textView, g.a().M, 18, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
            linearLayout.addView(textView);
            ListView listView = new ListView(this.a);
            listView.setLayoutParams(new LinearLayout.LayoutParams(this.i, -2));
            c cVar = new c(this.a, this.g);
            this.h = cVar;
            listView.setAdapter((ListAdapter) cVar);
            listView.setDividerHeight(0);
            listView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
            listView.setBackgroundColor(Color.parseColor("#ffffff"));
            listView.setVerticalScrollBarEnabled(false);
            listView.setSelector(new ColorDrawable(0));
            listView.post(new a(listView));
            listView.setOnItemClickListener(new b());
            int i = this.f;
            if (i > 0) {
                listView.setSelection(i);
            }
            linearLayout.addView(listView);
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            this.j = linearLayout2;
            linearLayout2.setOrientation(1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.i, com.igaworks.adpopcorn.cores.common.d.a(this.a, 40));
            layoutParams2.gravity = 81;
            this.j.setLayoutParams(layoutParams2);
            this.j.setGravity(81);
            this.j.setBackgroundDrawable(this.c);
            this.j.setVisibility(4);
            frameLayout.addView(this.j);
            return frameLayout;
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
