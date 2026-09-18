package com.igaworks.adpopcorn.activity.layout.f;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {
    private Context a;

    public a(Context context, boolean z, int i, int i2, boolean z2) {
        i iVar;
        super(context);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(this.a);
        int iA = z ? a((com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 60)) / 2) / 2 : com.igaworks.adpopcorn.cores.common.d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT));
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_DIVIDER_HEIGHT);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, iA));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, iA - com.igaworks.adpopcorn.cores.common.d.a(this.a, iC)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
        if (i2 != 4) {
            Context context2 = this.a;
            iVar = new i(context2, com.igaworks.adpopcorn.cores.common.d.a(context2, 15));
        } else {
            Context context3 = this.a;
            iVar = new i(context3, com.igaworks.adpopcorn.cores.common.d.a(context3, 4));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getWidth()), com.igaworks.adpopcorn.cores.common.d.a(this.a, aPSizeA.getHeight()));
        layoutParams.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 10);
        layoutParams.gravity = 19;
        iVar.setScaleType(ImageView.ScaleType.FIT_XY);
        iVar.setLayoutParams(layoutParams);
        linearLayout2.addView(iVar);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams2.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 22);
        linearLayout3.setLayoutParams(layoutParams2);
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(16);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(2);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 16));
        layoutParams4.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 6);
        textView2.setGravity(17);
        textView2.setLayoutParams(layoutParams4);
        textView2.setSingleLine();
        textView2.setIncludeFontPadding(false);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        textView3.setIncludeFontPadding(false);
        textView3.setMaxLines(2);
        linearLayout3.addView(textView);
        linearLayout4.addView(textView2);
        linearLayout4.addView(textView3);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        TextView textView4 = new TextView(this.a);
        textView4.setLayoutParams(new LinearLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 70), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32)));
        textView4.setGravity(17);
        linearLayout2.addView(textView4);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(this.a);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 1)));
        imageView.setBackgroundColor(Color.parseColor("#dddddd"));
        linearLayout.addView(imageView);
        addView(linearLayout);
        int iC2 = com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40);
        iC2 = iC2 >= com.igaworks.adpopcorn.cores.common.d.a(this.a, 400) ? com.igaworks.adpopcorn.cores.common.d.a(this.a, 400) : iC2;
        int iA2 = a(iC2);
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(this.a, 40), com.igaworks.adpopcorn.cores.common.d.a(this.a, 80) + iA2);
        layoutParams5.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams5.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        layoutParams5.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 20);
        linearLayout5.setLayoutParams(layoutParams5);
        linearLayout5.setOrientation(1);
        linearLayout5.setBackgroundResource(R.drawable.onestore_card_round_bg);
        if (Build.VERSION.SDK_INT >= 21) {
            linearLayout5.setElevation(com.igaworks.adpopcorn.cores.common.d.a(this.a, 6));
        }
        ImageView imageView2 = new ImageView(this.a);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(iC2, iA2);
        layoutParams6.gravity = 17;
        imageView2.setLayoutParams(layoutParams6);
        linearLayout5.addView(imageView2);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 80));
        layoutParams7.gravity = 16;
        linearLayout6.setLayoutParams(layoutParams7);
        linearLayout6.setGravity(16);
        linearLayout6.setOrientation(0);
        linearLayout6.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.addView(linearLayout6);
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams8.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 14);
        layoutParams8.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        layoutParams8.gravity = 16;
        linearLayout7.setLayoutParams(layoutParams8);
        linearLayout7.setGravity(16);
        linearLayout7.setOrientation(1);
        linearLayout6.addView(linearLayout7);
        TextView textView5 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        textView5.setMaxLines(2);
        textView5.setGravity(16);
        textView5.setIncludeFontPadding(false);
        textView5.setMinimumHeight(com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        textView5.setLayoutParams(layoutParams9);
        linearLayout7.addView(textView5);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(this.a, 18));
        layoutParams10.gravity = 16;
        linearLayout8.setGravity(16);
        linearLayout8.setLayoutParams(layoutParams10);
        linearLayout8.setOrientation(0);
        linearLayout7.addView(linearLayout8);
        TextView textView6 = new TextView(this.a);
        textView6.setLayoutParams(new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19)));
        textView6.setGravity(17);
        textView6.setSingleLine();
        textView6.setIncludeFontPadding(false);
        linearLayout8.addView(textView6);
        TextView textView7 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        layoutParams11.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 2);
        textView7.setSingleLine();
        textView7.setLayoutParams(layoutParams11);
        textView7.setGravity(19);
        textView7.setIncludeFontPadding(false);
        linearLayout8.addView(textView7);
        TextView textView8 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, com.igaworks.adpopcorn.cores.common.d.a(this.a, 19));
        textView8.setSingleLine();
        textView8.setIncludeFontPadding(false);
        textView8.setLayoutParams(layoutParams12);
        textView8.setGravity(17);
        textView8.setSingleLine();
        linearLayout8.addView(textView8);
        TextView textView9 = new TextView(this.a);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(com.igaworks.adpopcorn.cores.common.d.a(this.a, 70), com.igaworks.adpopcorn.cores.common.d.a(this.a, 32));
        layoutParams13.rightMargin = com.igaworks.adpopcorn.cores.common.d.a(this.a, 16);
        textView9.setLayoutParams(layoutParams13);
        textView9.setGravity(17);
        linearLayout6.addView(textView9);
        linearLayout.setId(0);
        linearLayout2.setId(1);
        iVar.setId(2);
        linearLayout3.setId(3);
        textView.setId(4);
        textView2.setId(5);
        textView3.setId(6);
        textView4.setId(7);
        imageView.setId(8);
        linearLayout5.setId(100);
        imageView2.setId(101);
        textView5.setId(102);
        textView6.setId(103);
        textView7.setId(104);
        textView8.setId(105);
        textView9.setId(106);
        addView(linearLayout5);
    }

    public static int a(int i) {
        return (int) ((((double) i) / 1200.0d) * 628.0d);
    }

    public static a a(Context context, boolean z, boolean z2, int i, int i2, boolean z3) {
        a aVar;
        if (z) {
            aVar = new a(context, z, i, i2, z3);
            int iA = a((com.igaworks.adpopcorn.cores.common.d.c() - com.igaworks.adpopcorn.cores.common.d.a(context, 60)) / 2) / 2;
            aVar.setLayoutParams(z2 ? new AbsListView.LayoutParams(-1, iA) : new LinearLayout.LayoutParams(-1, iA));
        } else {
            aVar = new a(context, z, i, i2, z3);
            aVar.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
        return aVar;
    }
}
