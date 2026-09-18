package com.igaworks.adpopcorn.activity.layout;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class b extends LinearLayout {
    public b(Context context, int i) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = com.igaworks.adpopcorn.cores.common.d.a(context, i);
        setLayoutParams(layoutParams);
        setGravity(17);
        setOrientation(1);
        setBackgroundColor(Color.parseColor("#ffffff"));
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, 0));
        addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, com.igaworks.adpopcorn.cores.common.d.a(context, 27)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#585757"));
        linearLayout.setId(0);
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleSmall);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(context, null, R.attr.textAppearanceMedium);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = com.igaworks.adpopcorn.cores.common.d.a(context, 10);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(0, com.igaworks.adpopcorn.cores.common.d.a(context, 15));
        textView2.setTypeface(Typeface.DEFAULT);
        textView2.setTextColor(Color.parseColor("#ffffff"));
        textView2.setId(1);
        linearLayout.addView(progressBar);
        linearLayout.addView(textView2);
        linearLayout.setVisibility(8);
        addView(linearLayout);
    }
}
