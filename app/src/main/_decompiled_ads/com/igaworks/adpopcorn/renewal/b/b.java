package com.igaworks.adpopcorn.renewal.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1647b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private GradientDrawable e;
    private boolean f;
    private ImageView g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    public b(Context context, int i, g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, boolean z, View.OnClickListener onClickListener) {
        super(context, i);
        this.a = context;
        this.f1647b = gVar;
        this.c = gVar2;
        this.f = z;
        this.d = onClickListener;
    }

    private int a(boolean z, int i) {
        return (int) ((((double) i) / 720.0d) * (z ? 780.0d : 376.0d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v42, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r21v0, types: [android.view.View, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, android.widget.ScrollView] */
    /* JADX WARN: Type inference failed for: r5v15, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View, android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, android.widget.LinearLayout] */
    private View a() {
        boolean z;
        RelativeLayout.LayoutParams layoutParams;
        TextView textView;
        TextView textView2;
        int i;
        boolean z2;
        String str;
        ?? frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ?? scrollView = new ScrollView(this.a);
        scrollView.setBackgroundColor(Color.parseColor("#F8F9FA"));
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        scrollView.setFillViewport(true);
        scrollView.setVerticalScrollBarEnabled(false);
        frameLayout.addView(scrollView);
        ?? linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#F8F9FA"));
        linearLayout.addView(c());
        View view = new View(this.a);
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        view.setBackgroundColor(Color.parseColor("#F1F2F4"));
        linearLayout.addView(view);
        if (this.f) {
            z = false;
        } else {
            int iA = (this.f1647b.q() == null || this.f1647b.q().length() <= 4) ? a(false, com.igaworks.adpopcorn.cores.common.d.c()) : a(true, com.igaworks.adpopcorn.cores.common.d.c());
            this.g = new ImageView(this.a);
            this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
            linearLayout.addView(this.g);
            z = true;
        }
        ?? linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, -2)));
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.addView(linearLayout2);
        ?? linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, z ? 24 : 20);
        layoutParams2.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams2.gravity = 16;
        linearLayout3.setLayoutParams(layoutParams2);
        linearLayout2.addView(linearLayout3);
        if (!z) {
            Context context = this.a;
            i iVar = new i(context, com.igaworks.adpopcorn.cores.common.d.a(context, 8));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 60), com.igaworks.adpopcorn.cores.common.d.a(this.a, 60));
            layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
            layoutParams3.gravity = 17;
            iVar.setLayoutParams(layoutParams3);
            linearLayout3.addView(iVar);
            com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1647b.w(), iVar, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
        }
        ?? relativeLayout = new RelativeLayout(this.a);
        LinearLayout.LayoutParams layoutParams4 = z ? new LinearLayout.LayoutParams(0, -2, 1.0f) : new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 60), 1.0f);
        relativeLayout.setGravity(16);
        relativeLayout.setLayoutParams(layoutParams4);
        linearLayout3.addView(relativeLayout);
        TextView textView3 = new TextView(this.a);
        Context context2 = this.a;
        if (z) {
            layoutParams = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context2, 23));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context2, 22));
            layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 4);
        }
        layoutParams.addRule(9);
        textView3.setLayoutParams(layoutParams);
        textView3.setGravity(48);
        textView3.setId(1);
        TextView textView4 = new TextView(this.a);
        Context context3 = this.a;
        RelativeLayout.LayoutParams layoutParams5 = z ? new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context3, 23)) : new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context3, 17));
        layoutParams5.addRule(9);
        layoutParams5.addRule(3, textView3.getId());
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        textView4.setLayoutParams(layoutParams5);
        textView4.setGravity(80);
        textView4.setId(2);
        textView4.setSingleLine();
        TextView textView5 = new TextView(this.a);
        Context context4 = this.a;
        RelativeLayout.LayoutParams layoutParams6 = z ? new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context4, 23)) : new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(context4, 17));
        layoutParams6.addRule(14);
        layoutParams6.addRule(3, textView3.getId());
        layoutParams6.addRule(1, textView4.getId());
        textView5.setLayoutParams(layoutParams6);
        textView5.setGravity(80);
        textView5.setId(3);
        textView5.setSingleLine();
        TextView textView6 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams7 = z ? new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 23)) : new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 17));
        layoutParams7.addRule(14);
        layoutParams7.addRule(3, textView3.getId());
        layoutParams7.addRule(1, textView5.getId());
        textView6.setLayoutParams(layoutParams7);
        textView6.setGravity(80);
        textView6.setId(4);
        textView6.setSingleLine();
        relativeLayout.addView(textView3);
        relativeLayout.addView(textView4);
        relativeLayout.addView(textView5);
        relativeLayout.addView(textView6);
        if (this.f1647b.o() != null && this.f1647b.o().size() > 0) {
            ?? linearLayout4 = new LinearLayout(this.a);
            linearLayout4.setOrientation(1);
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams8.gravity = 17;
            linearLayout4.setLayoutParams(layoutParams8);
            linearLayout4.setGravity(17);
            linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout4.setPadding(0, 0, 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            linearLayout.addView(linearLayout4);
            int i2 = 0;
            frameLayout = frameLayout;
            while (i2 < this.f1647b.o().size()) {
                TextView textView7 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams9.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                layoutParams9.gravity = 16;
                textView7.setLayoutParams(layoutParams9);
                textView7.setGravity(19);
                textView7.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
                linearLayout4.addView(textView7);
                k.a(textView7, this.f1647b.o().get(i2), 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                i2++;
                frameLayout = frameLayout;
            }
        }
        ?? r21 = frameLayout;
        if (this.f1647b.L() == null || this.f1647b.L().size() <= 0) {
            textView = textView6;
            textView2 = textView5;
            if (this.f1647b.u() != null && this.f1647b.u().length() > 0) {
                ?? linearLayout5 = new LinearLayout(this.a);
                LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams10.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
                linearLayout5.setLayoutParams(layoutParams10);
                linearLayout5.setOrientation(1);
                linearLayout5.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 17));
                linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
                linearLayout.addView(linearLayout5);
                TextView textView8 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams11.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 11);
                textView8.setLayoutParams(layoutParams11);
                textView8.setGravity(19);
                textView8.setIncludeFontPadding(false);
                textView8.setSingleLine();
                linearLayout5.addView(textView8);
                TextView textView9 = new TextView(this.a);
                textView9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView9.setGravity(19);
                textView9.setIncludeFontPadding(false);
                textView9.setLineSpacing(TypedValue.applyDimension(2, 7.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
                linearLayout5.addView(textView9);
                k.b(textView8, this.c.E, 16, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.b(textView9, this.f1647b.u(), 14, Color.parseColor("#343940"), null, 0, 0, TextUtils.TruncateAt.END, false);
            }
        } else {
            ?? linearLayout6 = new LinearLayout(this.a);
            linearLayout6.setOrientation(1);
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams12.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 8);
            layoutParams12.gravity = 17;
            linearLayout6.setLayoutParams(layoutParams12);
            linearLayout6.setGravity(17);
            linearLayout6.setBackgroundColor(Color.parseColor("#ffffff"));
            linearLayout6.setPadding(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), 0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 24));
            linearLayout.addView(linearLayout6);
            int i3 = 0;
            while (i3 < this.f1647b.L().size()) {
                TextView textView10 = new TextView(this.a);
                TextView textView11 = textView6;
                LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 21));
                layoutParams13.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
                layoutParams13.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                layoutParams13.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                if (i3 > 0) {
                    layoutParams13.topMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 30);
                }
                textView10.setLayoutParams(layoutParams13);
                textView10.setGravity(19);
                textView10.setSingleLine();
                linearLayout6.addView(textView10);
                TextView textView12 = new TextView(this.a);
                LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams14.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                layoutParams14.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
                textView12.setLayoutParams(layoutParams14);
                textView12.setGravity(19);
                linearLayout6.addView(textView12);
                int i4 = i3 + 1;
                k.a(textView10, this.c.E + " " + i4, 16, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, false);
                k.a(textView12, this.f1647b.L().get(i3), 14, Color.parseColor("#66737F"), null, 0, 0, TextUtils.TruncateAt.END, false);
                i3 = i4;
                textView6 = textView11;
                textView5 = textView5;
            }
            textView = textView6;
            textView2 = textView5;
        }
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        linearLayout7.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout7.setOrientation(1);
        linearLayout7.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 24), com.igaworks.adpopcorn.cores.common.d.a(this.a, 16), com.igaworks.adpopcorn.cores.common.d.a(this.a, 86));
        linearLayout7.setBackgroundColor(Color.parseColor("#F8F9FA"));
        linearLayout.addView(linearLayout7);
        TextView textView13 = new TextView(this.a);
        textView13.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textView13.setGravity(19);
        textView13.setIncludeFontPadding(false);
        textView13.setLineSpacing(TypedValue.applyDimension(2, 6.0f, this.a.getResources().getDisplayMetrics()), 1.0f);
        linearLayout7.addView(textView13);
        View view2 = new View(this.a);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        view2.setBackgroundColor(Color.parseColor("#eceff1"));
        linearLayout.addView(view2);
        scrollView.addView(linearLayout);
        if (!this.f) {
            if (this.f1647b.q() == null || this.f1647b.q().length() <= 4) {
                com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1647b.r(), this.g, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
            } else {
                com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1647b.q(), this.g, 0, 0, (com.igaworks.adpopcorn.cores.common.e.b) null);
            }
        }
        k.a(textView3, this.f1647b.v(), 18, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, true);
        String strO = this.f1647b.O();
        if (z) {
            i = 18;
            strO = this.f1647b.O() + this.c.M1;
            z2 = true;
        } else {
            i = 14;
            z2 = false;
        }
        k.a(textView4, this.f1647b.p(), i, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, z2);
        try {
            str = new DecimalFormat("###,###").format(this.f1647b.Q());
        } catch (Exception unused) {
            str = this.f1647b.Q() + "";
        }
        int i5 = i;
        k.a(textView2, str, i5, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
        k.a(textView, strO, i5, ApRewardStyle.mainOfferwallColor, null, 0, 0, TextUtils.TruncateAt.END, true);
        String strS = this.c.v1;
        if (this.f1647b.s() != null && this.f1647b.s().length() > 0) {
            strS = this.f1647b.s();
        }
        k.a(textView13, strS, 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
        ?? linearLayout8 = new LinearLayout(this.a);
        linearLayout8.setOrientation(0);
        FrameLayout.LayoutParams layoutParams15 = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 54));
        layoutParams15.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams15.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams15.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams15.gravity = 81;
        linearLayout8.setLayoutParams(layoutParams15);
        linearLayout8.setGravity(17);
        linearLayout8.setBackgroundDrawable(this.e);
        r21.addView(linearLayout8);
        TextView textView14 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams16.gravity = 16;
        textView14.setLayoutParams(layoutParams16);
        textView14.setGravity(17);
        textView14.setSingleLine();
        linearLayout8.addView(textView14);
        linearLayout8.setId(0);
        linearLayout8.setOnClickListener(this.d);
        k.b(textView14, this.c.z1, 16, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, true);
        return r21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    private void b() {
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int i = ApRewardStyle.mainOfferwallColor;
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, new int[]{i, i});
        this.e = gradientDrawable;
        gradientDrawable.setShape(0);
        this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.e.setGradientType(0);
    }

    private RelativeLayout c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 46)));
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView = new ImageView(this.a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 26), com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
        imageView.setImageResource(R.drawable.ap_reward_back);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$b$KjWDRHuxls0cewRfxNKrpuL8kmk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        layoutParams.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 42), com.igaworks.adpopcorn.cores.common.d.a(this.a, 46));
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOnClickListener(new a());
        relativeLayout.addView(linearLayout);
        TextView textView = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 48);
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 48);
        textView.setLayoutParams(layoutParams3);
        k.a(textView, this.f1647b.v(), 18, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, true);
        textView.setGravity(17);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 26), com.igaworks.adpopcorn.cores.common.d.a(this.a, 26));
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams4.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        layoutParams4.addRule(15);
        layoutParams4.addRule(11);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(R.drawable.ap_reward_help);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setId(1);
        imageView2.setOnClickListener(this.d);
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
