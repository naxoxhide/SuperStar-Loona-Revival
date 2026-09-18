package com.igaworks.adpopcorn.renewal.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.cores.model.g;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {
    private Context a;

    /* JADX WARN: Code duplicated, block: B:16:0x0095  */
    public a(Context context, boolean z, boolean z2) {
        int iA;
        super(context);
        this.a = context;
        int iA2 = z ? d.a(this.a, 72) : d.a(context, 88);
        setBackgroundColor(Color.parseColor("#ffffff"));
        LinearLayout linearLayout = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        if (z) {
            linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            layoutParams.bottomMargin = d.a(this.a, 6);
            layoutParams.topMargin = d.a(this.a, 6);
            if (Build.VERSION.SDK_INT >= 21) {
                linearLayout.setElevation(d.a(this.a, 3));
            }
        } else {
            Context context2 = this.a;
            if (z2) {
                layoutParams.leftMargin = d.a(context2, 6);
                iA = d.a(this.a, 6);
            } else {
                layoutParams.leftMargin = d.a(context2, 16);
                iA = d.a(this.a, 16);
            }
            layoutParams.rightMargin = iA;
            layoutParams.bottomMargin = d.a(this.a, 6);
            layoutParams.topMargin = d.a(this.a, 6);
            linearLayout.setBackgroundResource(R.drawable.ap_reward_card_round_bg);
            if (Build.VERSION.SDK_INT >= 21) {
                linearLayout.setElevation(d.a(this.a, 3));
            }
        }
        APSize aPSize = z ? new APSize(44, 44) : new APSize(56, 56);
        FrameLayout frameLayout = new FrameLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a(this.a, aPSize.getWidth() + 4), d.a(this.a, aPSize.getHeight() + 4));
        layoutParams2.rightMargin = d.a(this.a, 12);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = d.a(this.a, 16);
        frameLayout.setLayoutParams(layoutParams2);
        Context context3 = this.a;
        i iVar = new i(context3, d.a(context3, 8));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(d.a(this.a, aPSize.getWidth()), d.a(this.a, aPSize.getHeight()));
        layoutParams3.gravity = 17;
        iVar.setLayoutParams(layoutParams3);
        frameLayout.addView(iVar);
        ImageView imageView = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(d.a(this.a, 18), d.a(this.a, 18));
        layoutParams4.gravity = 85;
        imageView.setLayoutParams(layoutParams4);
        imageView.setImageResource(R.drawable.ap_reward_choice_icon);
        frameLayout.addView(imageView);
        linearLayout.addView(frameLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams5.rightMargin = d.a(this.a, 16);
        linearLayout2.setLayoutParams(layoutParams5);
        linearLayout2.setOrientation(1);
        linearLayout2.setGravity(16);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.bottomMargin = d.a(this.a, 2);
        textView.setSingleLine();
        textView.setGravity(19);
        textView.setMinimumHeight(d.a(this.a, 20));
        textView.setLayoutParams(layoutParams6);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this.a);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, d.a(this.a, 16)));
        textView2.setGravity(19);
        textView2.setSingleLine();
        linearLayout2.addView(textView2);
        TextView textView3 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, d.a(this.a, 34));
        layoutParams7.rightMargin = d.a(this.a, 16);
        textView3.setLayoutParams(layoutParams7);
        textView3.setMinWidth(d.a(this.a, 61));
        textView3.setSingleLine();
        textView3.setPadding(d.a(this.a, 8), 0, d.a(this.a, 8), 0);
        textView3.setGravity(17);
        linearLayout.addView(textView3);
        linearLayout.setId(0);
        iVar.setId(1);
        imageView.setId(2);
        linearLayout2.setId(3);
        textView.setId(4);
        textView2.setId(5);
        textView3.setId(6);
        frameLayout.setId(7);
        addView(linearLayout);
        if (z) {
            return;
        }
        int iC = d.c() - d.a(this.a, 32);
        iC = iC >= d.a(this.a, 400) ? d.a(this.a, 400) : iC;
        int iA3 = a(iC);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(d.c() - d.a(this.a, 32), d.a(this.a, 70) + iA3);
        layoutParams8.leftMargin = d.a(this.a, 16);
        layoutParams8.rightMargin = d.a(this.a, 16);
        layoutParams8.bottomMargin = d.a(this.a, 12);
        linearLayout3.setLayoutParams(layoutParams8);
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundResource(R.drawable.ap_reward_card_round_bg);
        if (Build.VERSION.SDK_INT >= 21) {
            linearLayout3.setElevation(d.a(this.a, 6));
        }
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(iC, iA3);
        layoutParams9.gravity = 17;
        imageView2.setLayoutParams(layoutParams9);
        linearLayout3.addView(imageView2);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, d.a(this.a, 70));
        layoutParams10.gravity = 16;
        linearLayout4.setLayoutParams(layoutParams10);
        linearLayout4.setGravity(16);
        linearLayout4.setOrientation(0);
        linearLayout4.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout3.addView(linearLayout4);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams11.rightMargin = d.a(this.a, 16);
        layoutParams11.leftMargin = d.a(this.a, 16);
        layoutParams11.gravity = 16;
        linearLayout5.setLayoutParams(layoutParams11);
        linearLayout5.setGravity(16);
        linearLayout5.setOrientation(1);
        linearLayout4.addView(linearLayout5);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams12.bottomMargin = d.a(this.a, 2);
        textView4.setSingleLine();
        textView4.setGravity(19);
        textView4.setMinimumHeight(d.a(this.a, 20));
        textView4.setLayoutParams(layoutParams12);
        linearLayout5.addView(textView4);
        TextView textView5 = new TextView(this.a);
        textView5.setLayoutParams(new LinearLayout.LayoutParams(-1, d.a(this.a, 16)));
        textView5.setGravity(19);
        textView5.setSingleLine();
        linearLayout5.addView(textView5);
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, d.a(this.a, 34));
        layoutParams13.rightMargin = d.a(this.a, 16);
        textView6.setLayoutParams(layoutParams13);
        textView6.setMinWidth(d.a(this.a, 61));
        textView6.setSingleLine();
        textView6.setPadding(d.a(this.a, 8), 0, d.a(this.a, 8), 0);
        textView6.setGravity(17);
        linearLayout4.addView(textView6);
        linearLayout3.setId(100);
        imageView2.setId(101);
        textView4.setId(102);
        textView5.setId(103);
        textView6.setId(106);
        addView(linearLayout3);
    }

    public static int a(int i) {
        return (int) ((((double) i) / 1200.0d) * 628.0d);
    }

    public static a a(Context context, int i) {
        a aVar = new a(context, true, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (i != 0) {
            layoutParams.topMargin = i;
        }
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }

    public static a a(Context context, boolean z) {
        a aVar = new a(context, false, z);
        aVar.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    public void a(View view, Context context, g gVar, boolean z, boolean z2, int i) {
        GradientDrawable gradientDrawable;
        String str;
        try {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
            int i2 = ApRewardStyle.mainOfferwallColor;
            GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{i2, i2});
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius(d.a(context, 6));
            gradientDrawable2.setGradientType(0);
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, ViewCompat.MEASURED_SIZE_MASK});
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius(d.a(context, 10));
            gradientDrawable3.setGradientType(0);
            gradientDrawable3.setStroke(d.a(context, 1), ApRewardStyle.mainOfferwallColor);
            if (ApRewardStyle.mainOfferwallColor != Color.parseColor("#2685f4")) {
                GradientDrawable.Orientation orientation2 = GradientDrawable.Orientation.TOP_BOTTOM;
                int i3 = ApRewardStyle.mainOfferwallColor;
                gradientDrawable = new GradientDrawable(orientation2, new int[]{i3, i3});
            } else {
                gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-10668801, -14252556});
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(d.a(context, 10));
            gradientDrawable.setStroke(d.a(context, 2), Color.parseColor("#ffffff"));
            gradientDrawable.setGradientType(0);
            if (gVar != null) {
                String strW = gVar.w();
                String strV = gVar.V();
                int iK = gVar.K();
                String strC = gVar.c();
                com.igaworks.adpopcorn.cores.common.g gVarA = com.igaworks.adpopcorn.cores.common.g.a();
                i iVar = (i) view.findViewById(1);
                ImageView imageView = (ImageView) view.findViewById(2);
                TextView textView = (TextView) view.findViewById(4);
                TextView textView2 = (TextView) view.findViewById(5);
                TextView textView3 = (TextView) view.findViewById(6);
                ((FrameLayout) view.findViewById(7)).setBackgroundDrawable(gradientDrawable3);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(d.a(context, 40), d.a(context, 40));
                layoutParams.gravity = 17;
                iVar.setLayoutParams(layoutParams);
                imageView.setBackgroundDrawable(gradientDrawable);
                k.a(textView, strV, 14, Color.parseColor("#212529"), null, 0, 0, TextUtils.TruncateAt.END, true);
                k.a(textView2, gVar.p() + " ", 13, Color.parseColor("#808C99"), null, 0, 0, TextUtils.TruncateAt.END, false);
                try {
                    str = new DecimalFormat("###,###").format(gVar.Q());
                } catch (Exception unused) {
                    str = gVar.Q() + "";
                }
                k.a(textView3, ((iK == 7 || iK == 23) && com.igaworks.adpopcorn.a.b.a().a(context, "participateFlag", strC, false)) ? gVarA.F : str + gVar.O(), 14, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, true);
                textView3.setBackgroundDrawable(null);
                textView3.setMinWidth(d.a(context, 61));
                textView3.getLayoutParams().width = -2;
                textView3.setBackgroundDrawable(gradientDrawable2);
                iVar.setTag(strW);
                iVar.setImageDrawable(null);
                e.a(context, strW, iVar, d.a(context, 56), d.a(context, 56), (e.b) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(View view, g gVar) {
        if (gVar != null) {
            try {
                String strW = gVar.w();
                i iVar = (i) view.findViewById(1);
                APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
                Context context = this.a;
                e.a(context, strW, iVar, d.a(context, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()), (e.b) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
