package com.igaworks.adpopcorn.activity.layout.e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.activity.c.i;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FrameLayout {
    private Context a;

    public a(Context context, boolean z, int i, int i2, boolean z2) {
        super(context);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, d.a(this.a, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.OFFERWALL_LIST_ITEM_HEIGHT)));
        linearLayout.setOrientation(1);
        layoutParams.topMargin = d.a(this.a, 16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout.setBackgroundResource(R.drawable.lottemem_card_round_bg);
        LinearLayout linearLayout2 = new LinearLayout(this.a);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, d.a(this.a, 128)));
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.CAMPAIGN_LIST_APP_ICON_SIZE);
        Context context2 = this.a;
        i iVar = new i(context2, d.a(context2, 48));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.a(this.a, aPSizeA.getWidth()), d.a(this.a, aPSizeA.getHeight()));
        layoutParams2.leftMargin = d.a(this.a, 16);
        layoutParams2.rightMargin = d.a(this.a, 17);
        iVar.setLayoutParams(layoutParams2);
        linearLayout2.addView(iVar);
        LinearLayout linearLayout3 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams3.rightMargin = d.a(this.a, 16);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(16);
        TextView textView = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.bottomMargin = d.a(this.a, 4);
        textView.setLayoutParams(layoutParams4);
        textView.setMaxLines(1);
        TextView textView2 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.bottomMargin = d.a(this.a, 2);
        textView2.setLayoutParams(layoutParams5);
        textView2.setMaxLines(1);
        linearLayout3.addView(textView);
        linearLayout3.addView(textView2);
        LinearLayout linearLayout4 = new LinearLayout(this.a);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        ImageView imageView = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(d.a(this.a, 16), d.a(this.a, 18));
        imageView.setImageResource(R.drawable.lottemem_payback);
        layoutParams6.rightMargin = d.a(this.a, 6);
        imageView.setLayoutParams(layoutParams6);
        linearLayout4.addView(imageView);
        TextView textView3 = new TextView(this.a);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(0, d.a(this.a, 26), 1.0f));
        textView3.setGravity(19);
        linearLayout4.addView(textView3);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        int iA = a(d.c());
        LinearLayout linearLayout5 = new LinearLayout(this.a);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, d.a(this.a, 6) + iA + d.a(this.a, 80));
        layoutParams7.topMargin = d.a(this.a, 16);
        linearLayout5.setLayoutParams(layoutParams7);
        linearLayout5.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.setBackgroundResource(R.drawable.lottemem_card_round_bg);
        linearLayout5.setOrientation(1);
        Context context3 = this.a;
        i iVar2 = new i(context3, d.a(context3, 0));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, iA);
        layoutParams8.gravity = 17;
        iVar2.setLayoutParams(layoutParams8);
        linearLayout5.addView(iVar2);
        LinearLayout linearLayout6 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, d.a(this.a, 80));
        layoutParams9.leftMargin = d.a(this.a, 16);
        layoutParams9.rightMargin = d.a(this.a, 16);
        layoutParams9.gravity = 16;
        linearLayout6.setLayoutParams(layoutParams9);
        linearLayout6.setGravity(16);
        linearLayout6.setOrientation(0);
        linearLayout6.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout5.addView(linearLayout6);
        LinearLayout linearLayout7 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams10.rightMargin = d.a(this.a, 14);
        layoutParams10.gravity = 16;
        linearLayout7.setLayoutParams(layoutParams10);
        linearLayout7.setGravity(16);
        linearLayout7.setOrientation(1);
        linearLayout6.addView(linearLayout7);
        TextView textView4 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, d.a(this.a, 18));
        layoutParams11.bottomMargin = d.a(this.a, 6);
        textView4.setSingleLine();
        textView4.setLayoutParams(layoutParams11);
        linearLayout7.addView(textView4);
        LinearLayout linearLayout8 = new LinearLayout(this.a);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, d.a(this.a, 16));
        layoutParams12.gravity = 16;
        linearLayout8.setGravity(16);
        linearLayout8.setLayoutParams(layoutParams12);
        linearLayout8.setOrientation(0);
        linearLayout7.addView(linearLayout8);
        TextView textView5 = new TextView(this.a);
        textView5.setLayoutParams(new LinearLayout.LayoutParams(-2, d.a(this.a, 16)));
        textView5.setGravity(17);
        textView5.setSingleLine();
        textView5.setIncludeFontPadding(false);
        linearLayout8.addView(textView5);
        TextView textView6 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, d.a(this.a, 16));
        layoutParams13.leftMargin = d.a(this.a, 4);
        textView6.setSingleLine();
        textView6.setIncludeFontPadding(false);
        textView6.setLayoutParams(layoutParams13);
        textView6.setGravity(17);
        textView6.setSingleLine();
        TextView textView7 = new TextView(this.a);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-2, d.a(this.a, 18));
        layoutParams14.leftMargin = d.a(this.a, 2);
        textView7.setSingleLine();
        textView7.setIncludeFontPadding(false);
        textView7.setLayoutParams(layoutParams14);
        textView7.setGravity(17);
        textView7.setSingleLine();
        TextView textView8 = new TextView(this.a);
        textView8.setLayoutParams(new RelativeLayout.LayoutParams(d.a(this.a, 99), d.a(this.a, 42)));
        textView8.setGravity(17);
        linearLayout6.addView(textView8);
        linearLayout.setId(0);
        linearLayout2.setId(1);
        iVar.setId(2);
        linearLayout3.setId(3);
        textView.setId(4);
        textView2.setId(5);
        linearLayout4.setId(6);
        textView3.setId(7);
        imageView.setId(8);
        addView(linearLayout);
        linearLayout5.setId(100);
        iVar2.setId(101);
        textView4.setId(102);
        textView5.setId(103);
        textView8.setId(106);
        addView(linearLayout5);
    }

    public static int a(int i) {
        return (int) ((((double) i) / 720.0d) * 376.0d);
    }

    public static a a(Context context, boolean z, boolean z2, int i, int i2, boolean z3) {
        a aVar;
        ViewGroup.LayoutParams layoutParams;
        if (z) {
            int iE = (int) (d.e() * 618.0d);
            int iD = (int) (d.d() * 163.0d);
            if (i == 1) {
                iE = (int) (d.e() * 600.0d);
                iD = (int) (d.d() * 158.0d);
            }
            aVar = new a(context, z, i, i2, z3);
            layoutParams = z2 ? new AbsListView.LayoutParams(iE, iD) : new LinearLayout.LayoutParams(iE, iD);
        } else {
            aVar = new a(context, z, i, i2, z3);
            layoutParams = new AbsListView.LayoutParams(-1, -1);
        }
        aVar.setLayoutParams(layoutParams);
        return aVar;
    }
}
