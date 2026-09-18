package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.igaworks.adpopcorn.cores.common.k;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Toast {
    private Context a;

    public b(Context context) {
        super(context);
        this.a = context;
    }

    private void a(Toast toast, View view, int i, int i2) {
        toast.setGravity(i2, 0, 0);
        toast.setDuration(i);
        toast.setView(view);
        toast.show();
    }

    public void a(String str, int i, int i2) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.setOrientation(1);
            TextView textView = new TextView(this.a);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            textView.setGravity(17);
            textView.setPadding(com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10), com.igaworks.adpopcorn.cores.common.d.a(this.a, 10));
            textView.setBackgroundColor(Color.parseColor("#d9000000"));
            k.b(textView, str, 12, Color.parseColor("#ffffff"), null, 0, 0, TextUtils.TruncateAt.END, false);
            linearLayout.addView(textView);
            a(this, linearLayout, i, 17);
        } catch (Exception unused) {
        }
    }
}
