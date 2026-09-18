package com.igaworks.adpopcorn.renewal.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Dialog {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f1648b;
    private View.OnClickListener c;
    private GradientDrawable d;
    private GradientDrawable e;
    private GradientDrawable f;
    private GradientDrawable g;

    class a implements com.igaworks.adpopcorn.cores.common.e.b {
        final /* synthetic */ ImageView a;

        a(c cVar, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    class b implements com.igaworks.adpopcorn.cores.common.e.b {
        final /* synthetic */ i a;

        b(c cVar, i iVar) {
            this.a = iVar;
        }

        @Override // com.igaworks.adpopcorn.cores.common.e.b
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.igaworks.adpopcorn.renewal.b.c$c, reason: collision with other inner class name */
    class ViewOnClickListenerC0440c implements View.OnClickListener {
        ViewOnClickListenerC0440c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public c(Context context, int i, int i2, g gVar, View.OnClickListener onClickListener) {
        super(context, i);
        this.a = context;
        this.f1648b = gVar;
        this.c = onClickListener;
    }

    private int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    private View a() {
        String str;
        com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
        int iC = com.igaworks.adpopcorn.cores.common.d.c();
        if (iC >= com.igaworks.adpopcorn.cores.common.d.a(this.a, 400)) {
            iC = com.igaworks.adpopcorn.cores.common.d.a(this.a, 400);
        }
        int iA = a(iC);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.igaworks.adpopcorn.renewal.b.-$$Lambda$c$DGaARuMPEw99kbAGXIR6UwRi5-M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50));
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundResource(R.drawable.ap_reward_card_round_bg);
        if (Build.VERSION.SDK_INT > 21) {
            linearLayout2.setClipToOutline(true);
        }
        frameLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, iA));
        com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1648b.T(), imageView, 0, 0, new a(this, imageView));
        linearLayout2.addView(imageView);
        imageView.setOnClickListener(this.c);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 94)));
        linearLayout3.setOrientation(0);
        linearLayout3.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout3.setGravity(16);
        linearLayout2.addView(linearLayout3);
        APSize aPSize = new APSize(52, 52);
        FrameLayout frameLayout2 = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 58), com.igaworks.adpopcorn.cores.common.d.a(this.a, 58));
        layoutParams3.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 12);
        layoutParams3.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        frameLayout2.setBackgroundDrawable(this.g);
        frameLayout2.setLayoutParams(layoutParams3);
        Context context = this.a;
        i iVar = new i(context, com.igaworks.adpopcorn.cores.common.d.a(context, 8));
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSize.getHeight()));
        layoutParams4.gravity = 17;
        iVar.setLayoutParams(layoutParams4);
        com.igaworks.adpopcorn.cores.common.e.a(this.a, this.f1648b.w(), iVar, 0, 0, new b(this, iVar));
        frameLayout2.addView(iVar);
        ImageView imageView2 = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 18), com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams5.gravity = 85;
        imageView2.setLayoutParams(layoutParams5);
        imageView2.setImageResource(R.drawable.ap_reward_choice_icon);
        imageView2.setBackgroundDrawable(this.f);
        frameLayout2.addView(imageView2);
        linearLayout3.addView(frameLayout2);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams6.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        linearLayout4.setLayoutParams(layoutParams6);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(16);
        linearLayout3.addView(linearLayout4);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView.setSingleLine();
        textView.setGravity(19);
        textView.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 20));
        textView.setLayoutParams(layoutParams7);
        linearLayout4.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16)));
        textView2.setGravity(19);
        textView2.setSingleLine();
        linearLayout4.addView(textView2);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 62)));
        linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.setOrientation(0);
        linearLayout5.setGravity(49);
        TextView textView3 = new TextView(this.a);
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), 1.0f);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        textView3.setBackgroundDrawable(this.e);
        textView3.setLayoutParams(layoutParams8);
        textView3.setOnClickListener(new ViewOnClickListenerC0440c());
        TextView textView4 = new TextView(this.a);
        textView4.setGravity(17);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, com.igaworks.adpopcorn.cores.common.d.a(this.a, 50), 1.0f);
        layoutParams9.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        textView4.setLayoutParams(layoutParams9);
        textView4.setBackgroundDrawable(this.d);
        textView4.setOnClickListener(this.c);
        linearLayout5.addView(textView3);
        linearLayout5.addView(textView4);
        linearLayout2.addView(linearLayout5);
        k.a(textView, this.f1648b.V(), 16, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
        k.a(textView2, this.f1648b.p() + " ", 14, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
        k.a(textView3, gVarA.h, 16, Color.parseColor("#9CA6AF"), null, 0, 1, TextUtils.TruncateAt.END, false);
        try {
            str = new DecimalFormat("###,###").format(this.f1648b.Q());
        } catch (Exception unused) {
            str = this.f1648b.Q() + "";
        }
        k.a(textView4, str + this.f1648b.O() + " " + gVarA.q2, 16, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, true);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        if (com.igaworks.adpopcorn.a.b.a().a(this.a, "adpopcorn_sdk_flag", "use_flag_show_When_locked_sp", false)) {
            getWindow().addFlags(524288);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        GradientDrawable gradientDrawable;
        super.onCreate(bundle);
        float fC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.DIALOG_BG_OPACITY) / 100.0f;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 2;
        layoutParams.dimAmount = fC;
        getWindow().setAttributes(layoutParams);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        int i = ApRewardStyle.mainOfferwallColor;
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{i, i});
        this.d = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.d.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.d.setGradientType(0);
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-920844, -920844});
        this.e = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.e.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 8));
        this.e.setGradientType(0);
        if (ApRewardStyle.mainOfferwallColor != Color.parseColor("#2685F4")) {
            GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.TOP_BOTTOM;
            int i2 = ApRewardStyle.mainOfferwallColor;
            gradientDrawable = new GradientDrawable(orientation2, new int[]{i2, i2});
        } else {
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-10668801, -14252556});
        }
        this.f = gradientDrawable;
        this.f.setShape(0);
        this.f.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        this.f.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), Color.parseColor("#ffffff"));
        this.f.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, ViewCompat.MEASURED_SIZE_MASK});
        this.g = gradientDrawable4;
        gradientDrawable4.setShape(0);
        this.g.setCornerRadius(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
        this.g.setStroke(com.igaworks.adpopcorn.cores.common.d.a(this.a, 2), ApRewardStyle.mainOfferwallColor);
        this.g.setGradientType(0);
        setContentView(a());
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        com.igaworks.adpopcorn.cores.common.i.a(getWindow().getDecorView());
    }
}
