package com.igaworks.adpopcorn.activity.b.l;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import com.kbeanie.imagechooser.api.ChooserType;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1559b;
    private com.igaworks.adpopcorn.cores.common.g c;
    private View.OnClickListener d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;
    private GradientDrawable h;
    private GradientDrawable i;
    private boolean j;

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.activity.b.l.a$a, reason: collision with other inner class name */
    class RunnableC0421a implements Runnable {
        final /* synthetic */ LinearLayout a;

        RunnableC0421a(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iB = ((int) (((double) d.b()) * 0.9d)) - d.a(a.this.a, ChooserType.REQUEST_PICK_PICTURE_OR_VIDEO);
            LinearLayout linearLayout = this.a;
            if (linearLayout == null || linearLayout.getHeight() < iB) {
                return;
            }
            this.a.setLayoutParams(new LinearLayout.LayoutParams(-1, iB));
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

    public a(Context context, int i, g gVar, com.igaworks.adpopcorn.cores.common.g gVar2, View.OnClickListener onClickListener, boolean z, boolean z2) {
        super(context, i);
        this.a = context;
        this.f1559b = gVar;
        this.c = gVar2;
        this.d = onClickListener;
        this.j = z;
    }

    private View a() {
        String strW = this.f1559b.w();
        String strV = this.f1559b.V();
        this.f1559b.P();
        String strP = this.f1559b.p();
        String strN = this.f1559b.N();
        int iC = d.c();
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(49);
        int iA = iC - d.a(this.a, 40);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, d.a(this.a, 65.5f));
        layoutParams.topMargin = d.a(this.a, 162);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundDrawable(this.g);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_APP_ICON_SIZE);
        Context context = this.a;
        i iVar = new i(context, d.a(context, 18));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
        layoutParams2.leftMargin = d.a(this.a, 20);
        layoutParams2.rightMargin = d.a(this.a, 12);
        layoutParams2.gravity = 17;
        iVar.setBackgroundDrawable(this.e);
        iVar.setPadding(d.a(this.a, 1), d.a(this.a, 1), d.a(this.a, 1), d.a(this.a, 1));
        iVar.setLayoutParams(layoutParams2);
        linearLayout2.addView(iVar);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(16);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.rightMargin = d.a(this.a, 16);
        layoutParams3.bottomMargin = d.a(this.a, 4);
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(1);
        linearLayout3.addView(textView);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.rightMargin = d.a(this.a, 20);
        textView2.setLayoutParams(layoutParams4);
        textView2.setSingleLine();
        textView2.setIncludeFontPadding(false);
        textView2.setGravity(19);
        linearLayout3.addView(textView2);
        k.b(textView2, strP + " " + this.f1559b.Q() + " " + this.f1559b.O(), 10, Color.parseColor("#969696"), null, 0, 1, TextUtils.TruncateAt.END, false);
        linearLayout2.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(iC - d.a(this.a, 40), d.a(this.a, 1)));
        linearLayout4.setOrientation(0);
        linearLayout4.setBackgroundColor(Color.parseColor("#ececec"));
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(iA, -2));
        linearLayout5.setOrientation(1);
        linearLayout5.setBackgroundDrawable(this.h);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        if (this.j) {
            linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, d.a(this.a, 103)));
        } else {
            linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
        linearLayout6.setOrientation(1);
        linearLayout6.setMinimumHeight(d.a(this.a, 124));
        linearLayout6.setVerticalScrollBarEnabled(true);
        linearLayout6.post(new RunnableC0421a(linearLayout6));
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.gravity = 48;
        textView3.setLayoutParams(layoutParams5);
        textView3.setPadding(d.a(this.a, 20), d.a(this.a, 16.5f), d.a(this.a, 20), d.a(this.a, 10));
        k.b(textView3, this.c.E, 12, Color.parseColor("#232532"), null, 0, 0, TextUtils.TruncateAt.END, false);
        linearLayout6.addView(textView3);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.gravity = 48;
        textView4.setLayoutParams(layoutParams6);
        textView4.setMovementMethod(new ScrollingMovementMethod());
        k.b(textView4, strN, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_DESC_TEXT_COLOR)), null, 0, 0, TextUtils.TruncateAt.END, false);
        textView4.setPadding(d.a(this.a, 20), d.a(this.a, 0), d.a(this.a, 20), 0);
        linearLayout6.addView(textView4);
        linearLayout5.addView(linearLayout6);
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(iC - d.a(this.a, 40), d.a(this.a, 1));
        layoutParams7.topMargin = d.a(this.a, 19.5f);
        linearLayout7.setLayoutParams(layoutParams7);
        linearLayout7.setOrientation(0);
        linearLayout7.setBackgroundColor(Color.parseColor("#ececec"));
        linearLayout5.addView(linearLayout7);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        linearLayout8.setLayoutParams(new LinearLayout.LayoutParams(iC - d.a(this.a, 40), d.a(this.a, 49.5f)));
        linearLayout8.setOrientation(0);
        linearLayout8.setGravity(17);
        linearLayout8.setBackgroundDrawable(this.i);
        TextView textView5 = new TextView(this.a);
        textView5.setGravity(17);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        k.b(textView5, this.c.z, 12, Color.parseColor("#929292"), null, 0, 1, TextUtils.TruncateAt.END, false);
        textView5.setLayoutParams(layoutParams8);
        textView5.setOnClickListener(new b());
        TextView textView6 = new TextView(this.a);
        textView6.setGravity(17);
        textView6.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        k.b(textView6, String.format(this.c.j2, this.f1559b.Q() + this.f1559b.O()), 12, Color.parseColor("#6280e3"), null, 0, 1, TextUtils.TruncateAt.END, false);
        textView6.setOnClickListener(this.d);
        linearLayout8.addView(textView5);
        linearLayout8.addView(textView6);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout4);
        linearLayout.addView(linearLayout5);
        linearLayout.addView(linearLayout8);
        k.b(textView, strV, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_SIZE_DP), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TITLE_TEXT_COLOR)), null, 0, 1, TextUtils.TruncateAt.END, false);
        e.b(this.a);
        Context context2 = this.a;
        e.a(context2, strW, iVar, d.a(context2, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
        return linearLayout;
    }

    private void b() {
        int iA = d.a(this.a, 8);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.e = gradientDrawable;
        gradientDrawable.setShape(0);
        this.e.setCornerRadius(d.a(this.a, 18));
        this.e.setGradientType(0);
        this.e.setStroke(d.a(this.a, 1), Color.parseColor("#ececec"));
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 0});
        this.f = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.f.setCornerRadius(d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_CORNER_ROUND_DP)));
        this.f.setGradientType(0);
        this.f.setStroke(d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_STROKE_DP)), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_REWARD_VIEW_LINE_COLOR)));
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_TOP_LAYOUT_BG_COLOR)});
        this.g = gradientDrawable3;
        gradientDrawable3.setShape(0);
        float f = iA;
        this.g.setCornerRadii(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.g.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_MIDDLE_LAYOUT_BG_COLOR)});
        this.h = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.h.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.CAMPAIGN_DIALOG_BOTTOM_LAYOUT_BG_COLOR)});
        this.i = gradientDrawable5;
        gradientDrawable5.setShape(0);
        this.i.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
        this.i.setGradientType(0);
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
