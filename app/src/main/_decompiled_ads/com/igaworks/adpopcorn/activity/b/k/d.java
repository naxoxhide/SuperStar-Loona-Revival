package com.igaworks.adpopcorn.activity.b.k;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1553b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private boolean k;

    class a implements Runnable {
        final /* synthetic */ RelativeLayout a;

        a(RelativeLayout relativeLayout) {
            this.a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TextView textView = new TextView(d.this.a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.a.getHeight());
                textView.setBackgroundDrawable(d.this.g);
                if (Build.VERSION.SDK_INT >= 11) {
                    textView.setAlpha(0.1f);
                }
                textView.setLayoutParams(layoutParams);
                this.a.addView(textView);
            } catch (Exception unused) {
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f1555b;

        b(TextView textView, RelativeLayout relativeLayout) {
            this.a = textView;
            this.f1555b = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getLineCount() > 1) {
                this.f1555b.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(d.this.a, 115)));
            }
        }
    }

    class c implements com.igaworks.adpopcorn.cores.common.e.b {
        c() {
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                d.this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (((double) bitmap.getHeight()) * (((double) com.igaworks.adpopcorn.cores.common.d.c()) / 720.0d))));
                d.this.h.setScaleType(ImageView.ScaleType.FIT_XY);
                d.this.h.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.k.d$d, reason: collision with other inner class name */
    class RunnableC0419d implements Runnable {
        final /* synthetic */ TextView a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f1556b;

        RunnableC0419d(TextView textView, RelativeLayout relativeLayout) {
            this.a = textView;
            this.f1556b = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getLineCount() > 1) {
                this.f1556b.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(d.this.a, 115)));
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.dismiss();
        }
    }

    public d(Context context, int i, g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        super(context, i);
        this.a = context;
        this.f1553b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
    }

    private int a(boolean z, int i) {
        return (int) ((((double) i) / 720.0d) * (z ? 780.0d : 376.0d));
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0b0d  */
    private View a() {
        Context context;
        String strR;
        int i;
        int i2;
        com.igaworks.adpopcorn.cores.common.e.b bVar;
        String str;
        String strS;
        Context context2;
        String strR2;
        int i3;
        int i4;
        com.igaworks.adpopcorn.cores.common.e.b bVar2;
        String str2;
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        ScrollView scrollView = new ScrollView(this.a);
        scrollView.setBackgroundColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 70);
        scrollView.setLayoutParams(layoutParams);
        scrollView.setFillViewport(true);
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(c());
        int iA = (this.f1553b.q() == null || this.f1553b.q().length() <= 4) ? a(false, com.igaworks.adpopcorn.cores.common.d.c()) : a(true, com.igaworks.adpopcorn.cores.common.d.c());
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
        linearLayout.addView(imageView);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        linearLayout2.setBackgroundColor(Color.parseColor("#0a000000"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, -2)));
        linearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        linearLayout4.setLayoutParams(layoutParams3);
        linearLayout3.addView(linearLayout4);
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 92));
        relativeLayout.setGravity(16);
        relativeLayout.setLayoutParams(layoutParams4);
        linearLayout4.addView(relativeLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(9);
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView.setLayoutParams(layoutParams5);
        textView.setMaxLines(2);
        textView.setId(1);
        TextView textView2 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams6.addRule(9);
        layoutParams6.addRule(3, textView.getId());
        layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView2.setLayoutParams(layoutParams6);
        textView2.setGravity(16);
        textView2.setId(2);
        textView2.setSingleLine();
        TextView textView3 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams7.addRule(14);
        layoutParams7.addRule(3, textView.getId());
        layoutParams7.addRule(1, textView2.getId());
        textView3.setLayoutParams(layoutParams7);
        textView3.setGravity(16);
        textView3.setId(3);
        textView3.setSingleLine();
        TextView textView4 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams8.addRule(14);
        layoutParams8.addRule(3, textView.getId());
        layoutParams8.addRule(1, textView3.getId());
        textView4.setLayoutParams(layoutParams8);
        textView4.setGravity(16);
        textView4.setId(4);
        textView4.setSingleLine();
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        relativeLayout.addView(textView3);
        relativeLayout.addView(textView4);
        if (this.f1553b.K() == 35) {
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.igaw_ap_list_bullet);
            drawable.setBounds(0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 4), com.igaworks.adpopcorn.cores.common.d.a(this.a, 4));
            LinearLayout linearLayout5 = new LinearLayout(this.a);
            linearLayout5.setOrientation(1);
            LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
            layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
            layoutParams9.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
            layoutParams9.gravity = 17;
            linearLayout5.setLayoutParams(layoutParams9);
            linearLayout5.setGravity(17);
            linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.addView(linearLayout5);
            TextView textView5 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams10.gravity = 16;
            textView5.setLayoutParams(layoutParams10);
            textView5.setGravity(19);
            textView5.setIncludeFontPadding(false);
            textView5.setCompoundDrawables(drawable, null, null, null);
            textView5.setCompoundDrawablePadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            textView5.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            linearLayout5.addView(textView5);
            TextView textView6 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams11.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
            layoutParams11.gravity = 16;
            textView6.setLayoutParams(layoutParams11);
            textView6.setGravity(19);
            textView6.setCompoundDrawables(drawable, null, null, null);
            textView6.setCompoundDrawablePadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
            textView6.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            textView6.setIncludeFontPadding(false);
            linearLayout5.addView(textView6);
            TextView textView7 = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams12.gravity = 16;
            layoutParams12.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
            textView7.setLayoutParams(layoutParams12);
            textView7.setGravity(19);
            textView7.setIncludeFontPadding(false);
            linearLayout5.addView(textView7);
            k.b(textView5, this.c.J1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView6, this.c.K1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView7, this.c.L1, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            textView7.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 5), 1.0f);
        }
        if (this.f1553b.t() != null && this.f1553b.t().length() > 0) {
            this.h = new ImageView(this.a);
            this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout.addView(this.h);
        } else if (this.f1553b.a0() || this.f1553b.X() || (this.f1553b.u() != null && this.f1553b.u().length() > 0)) {
            LinearLayout linearLayout6 = new LinearLayout(this.a);
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
            layoutParams13.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            layoutParams13.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
            linearLayout6.setBackgroundColor(Color.parseColor("#eeeeee"));
            linearLayout6.setLayoutParams(layoutParams13);
            linearLayout.addView(linearLayout6);
            LinearLayout linearLayout7 = new LinearLayout(this.a);
            linearLayout7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            linearLayout7.setOrientation(1);
            linearLayout7.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
            linearLayout7.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout.addView(linearLayout7);
            this.i = new TextView(this.a);
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams14.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
            this.i.setLayoutParams(layoutParams14);
            this.i.setGravity(19);
            this.i.setIncludeFontPadding(false);
            this.i.setSingleLine();
            linearLayout7.addView(this.i);
            this.j = new TextView(this.a);
            this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.j.setGravity(19);
            this.j.setIncludeFontPadding(false);
            this.j.setLineSpacing(TypedValue.applyDimension(2, 7.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
            linearLayout7.addView(this.j);
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this.a);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams15.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 24);
        layoutParams15.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams15.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams15.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams15.gravity = 16;
        relativeLayout2.setLayoutParams(layoutParams15);
        linearLayout.addView(relativeLayout2);
        relativeLayout2.post(new a(relativeLayout2));
        ImageView imageView2 = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 19), com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams16.addRule(9);
        layoutParams16.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 21);
        layoutParams16.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        layoutParams16.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams16.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        imageView2.setLayoutParams(layoutParams16);
        imageView2.setImageResource(R.drawable.onestore_ic_sc_appicon);
        imageView2.setId(10);
        relativeLayout2.addView(imageView2);
        TextView textView8 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams17.addRule(1, imageView2.getId());
        layoutParams17.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 7);
        layoutParams17.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 21);
        textView8.setLayoutParams(layoutParams17);
        textView8.setMaxLines(1);
        textView8.setIncludeFontPadding(false);
        textView8.setId(11);
        textView8.setGravity(48);
        relativeLayout2.addView(textView8);
        TextView textView9 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams18.addRule(9);
        layoutParams18.addRule(3, imageView2.getId());
        layoutParams18.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams18.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        textView9.setLayoutParams(layoutParams18);
        textView9.setId(12);
        textView9.setLineSpacing(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6), 1.0f);
        textView9.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        relativeLayout2.addView(textView9);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1));
        linearLayout8.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout8.setLayoutParams(layoutParams19);
        LinearLayout linearLayout9 = new LinearLayout(this.a);
        linearLayout9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout9.setOrientation(1);
        linearLayout9.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), com.igaworks.adpopcorn.cores.common.d.a(this.a, 0), com.igaworks.adpopcorn.cores.common.d.a(this.a, 20), 0);
        linearLayout9.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(linearLayout9);
        TextView textView10 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
        layoutParams20.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 9);
        textView10.setLayoutParams(layoutParams20);
        textView10.setGravity(19);
        textView10.setIncludeFontPadding(false);
        textView10.setSingleLine();
        linearLayout9.addView(textView10);
        TextView textView11 = new TextView(this.a);
        textView11.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView11.setGravity(19);
        textView11.setIncludeFontPadding(false);
        textView11.setLineSpacing(TypedValue.applyDimension(2, 3.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
        linearLayout9.addView(textView11);
        View view = new View(this.a);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view.setBackgroundColor(Color.parseColor("#eceff1"));
        linearLayout.addView(view);
        LinearLayout linearLayout10 = new LinearLayout(this.a);
        linearLayout10.setOrientation(0);
        FrameLayout.LayoutParams layoutParams21 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams21.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams21.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams21.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams21.gravity = 81;
        linearLayout10.setLayoutParams(layoutParams21);
        linearLayout10.setGravity(17);
        linearLayout10.setBackgroundDrawable(this.e);
        if (Build.VERSION.SDK_INT >= 21) {
            linearLayout10.setElevation(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
        }
        TextView textView12 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams22.gravity = 16;
        textView12.setLayoutParams(layoutParams22);
        textView12.setGravity(17);
        textView12.setIncludeFontPadding(false);
        textView12.setSingleLine();
        linearLayout10.addView(textView12);
        linearLayout10.setOnClickListener(this.d);
        LinearLayout linearLayout11 = new LinearLayout(this.a);
        linearLayout11.setOrientation(0);
        FrameLayout.LayoutParams layoutParams23 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 42));
        layoutParams23.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 58);
        layoutParams23.gravity = 81;
        linearLayout11.setLayoutParams(layoutParams23);
        linearLayout11.setBackgroundDrawable(this.f);
        scrollView.addView(linearLayout);
        frameLayout.addView(scrollView);
        frameLayout.addView(linearLayout11);
        frameLayout.addView(linearLayout10);
        if (this.f1553b.a0() || this.f1553b.X()) {
            if (this.f1553b.q() == null || this.f1553b.q().length() <= 4) {
                context = this.a;
                strR = this.f1553b.r();
                i = 0;
                i2 = 0;
                bVar = null;
            } else {
                context = this.a;
                strR = this.f1553b.q();
                i = 0;
                i2 = 0;
                bVar = null;
            }
            com.igaworks.adpopcorn.cores.common.e.a(context, strR, imageView, i, i2, bVar);
            TextView textView13 = this.i;
            if (textView13 != null && this.j != null) {
                k.b(textView13, this.c.n2, 15, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(this.j, this.f1553b.h() + this.c.o2, 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
            k.b(textView8, this.c.S1, 15, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(textView9, this.k ? this.c.T1 : this.c.U1, 13, Color.parseColor("#4b469c"), null, 0, 0, TextUtils.TruncateAt.END, false);
            k.b(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0a29: INVOKE 
                  (r15v4 ?? I:android.widget.TextView)
                  (wrap java.lang.String:0x0a13: INVOKE 
                  (wrap com.igaworks.adpopcorn.cores.model.g:0x0a11: IGET (r54v0 'this' com.igaworks.adpopcorn.activity.b.k.d A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] com.igaworks.adpopcorn.activity.b.k.d.b com.igaworks.adpopcorn.cores.model.g)
                 VIRTUAL call: com.igaworks.adpopcorn.cores.model.g.n():java.lang.String A[MD:():java.lang.String (m), WRAPPED])
                  (17 int)
                  (wrap int:0x0a17: INVOKE ("#000000") STATIC call: android.graphics.Color.parseColor(java.lang.String):int A[MD:(java.lang.String):int (c), WRAPPED])
                  (null android.graphics.Typeface)
                  (0 int)
                  (2 int)
                  (wrap android.text.TextUtils$TruncateAt:0x0a1b: SGET  A[WRAPPED] android.text.TextUtils.TruncateAt.END android.text.TextUtils$TruncateAt)
                  false
                 STATIC call: com.igaworks.adpopcorn.cores.common.k.b(android.widget.TextView, java.lang.String, int, int, android.graphics.Typeface, int, int, android.text.TextUtils$TruncateAt, boolean):void A[MD:(android.widget.TextView, java.lang.String, int, int, android.graphics.Typeface, int, int, android.text.TextUtils$TruncateAt, boolean):void (m)] in method: com.igaworks.adpopcorn.activity.b.k.d.a():android.view.View, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r15v4 ??
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                */
            /*
                Method dump skipped, instruction units count: 2861
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.igaworks.adpopcorn.activity.b.k.d.a():android.view.View");
        }

        private void b() {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.FEED_DETAIL_DIALOG_BTN_COLOR)});
            this.e = gradientDrawable;
            gradientDrawable.setShape(0);
            this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15));
            this.e.setGradientType(0);
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, -1275068417, -1});
            this.f = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.f.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2144918184, -2144918184});
            this.g = gradientDrawable3;
            gradientDrawable3.setShape(0);
            this.g.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 15));
            this.g.setGradientType(0);
            this.k = com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.USE_ONESTORE_COMMON_POINT);
        }

        private RelativeLayout c() {
            RelativeLayout.LayoutParams layoutParams;
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_HEIGHT);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
            relativeLayout.setBackgroundColor(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BG_COLOR));
            ImageView imageView = new ImageView(this.a);
            if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_ID) == -100) {
                layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
                com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_ic_arrow_back.png", imageView, false);
            } else {
                APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.TOP_BAR_BACK_BTN_RESOURCE_SIZE);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(R.drawable.onestore_gnb_gnb_back);
                layoutParams = layoutParams2;
            }
            imageView.setOnClickListener(new e());
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
            linearLayout.setOnClickListener(new f());
            relativeLayout.addView(linearLayout);
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
