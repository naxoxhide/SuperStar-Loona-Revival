package com.igaworks.adpopcorn.renewal.layout;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.igaworks.adpopcorn.R;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.g;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.renewal.ApRewardStyle;

/* JADX INFO: loaded from: classes2.dex */
public class b extends RelativeLayout {
    private Context a;

    public b(Context context, int i) {
        super(context);
        this.a = context;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, d.a(context, i)));
        setBackgroundColor(Color.parseColor("#ffffff"));
        a();
    }

    private void a() {
        g.a();
        ImageView imageView = new ImageView(this.a.getApplicationContext());
        LinearLayout linearLayout = new LinearLayout(this.a.getApplicationContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a(this.a, 26), d.a(this.a, 26));
        layoutParams.leftMargin = d.a(this.a, 16);
        layoutParams.rightMargin = d.a(this.a, 6);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.ap_reward_back);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setId(0);
        TextView textView = new TextView(this.a.getApplicationContext());
        textView.setIncludeFontPadding(false);
        textView.setBackgroundColor(0);
        k.a(textView, ApRewardStyle.offerwallTitle, 18, Color.parseColor("#212529"), null, 0, 1, TextUtils.TruncateAt.END, true);
        textView.setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = d.a(this.a, 16) + d.a(this.a, 24) + d.a(this.a, 10);
        layoutParams2.addRule(15);
        layoutParams2.addRule(9);
        textView.setLayoutParams(layoutParams2);
        addView(imageView);
        addView(textView);
        ImageView imageView2 = new ImageView(this.a.getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(d.a(this.a, 26), d.a(this.a, 26));
        layoutParams3.rightMargin = d.a(this.a, 16);
        layoutParams3.leftMargin = d.a(this.a, 16);
        layoutParams3.addRule(15);
        layoutParams3.addRule(11);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setImageResource(R.drawable.ap_reward_help);
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setId(2);
        addView(imageView2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(d.a(this.a, 42), d.a(this.a, 44));
        layoutParams4.addRule(15);
        layoutParams4.addRule(9);
        linearLayout.setLayoutParams(layoutParams4);
        linearLayout.setId(1);
        addView(linearLayout);
    }
}
