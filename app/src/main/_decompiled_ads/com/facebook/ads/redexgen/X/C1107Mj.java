package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1107Mj extends LinearLayout {
    public static final int A03 = (int) (C1066Ku.A02 * 40.0f);
    public static final int A04 = (int) (C1066Ku.A02 * 20.0f);
    public static final int A05 = (int) (C1066Ku.A02 * 10.0f);
    public final C2K A00;
    public final YA A01;
    public final MT A02;

    public C1107Mj(YA ya, C2K c2k, MT mt, EnumC1075Ld enumC1075Ld) {
        this(ya, c2k, mt, null, enumC1075Ld);
    }

    public C1107Mj(YA ya, C2K c2k, MT mt, String str, EnumC1075Ld enumC1075Ld) {
        super(ya);
        this.A01 = ya;
        this.A00 = c2k;
        this.A02 = mt;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View viewA01 = A01(str);
            viewA01.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            LV.A0M(view, -10459280);
            addView(viewA01, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(c2k.A03())) {
            View viewA00 = A00(enumC1075Ld, c2k.A03());
            int i = A05;
            viewA00.setPadding(0, i, 0, i);
            addView(viewA00, layoutParams);
        }
        C1113Mp c1113MpA03 = A03();
        c1113MpA03.setPadding(0, A05, 0, 0);
        addView(c1113MpA03, layoutParams);
    }

    private View A00(EnumC1075Ld enumC1075Ld, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        int i = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(C1076Le.A01(enumC1075Ld));
        TextView textView = new TextView(getContext());
        LV.A0X(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        textView.setFocusable(true);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A01(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(C1076Le.A01(EnumC1075Ld.BACK_ARROW));
        int i = A05;
        imageView.setPadding(0, i, i * 2, i);
        int i2 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        imageView.setOnClickListener(new ViewOnClickListenerC1105Mh(this));
        TextView titleView = new TextView(getContext());
        titleView.setGravity(17);
        titleView.setText(str);
        LV.A0X(titleView, true, 16);
        titleView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, i2, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(titleView, layoutParams2);
        return linearLayout;
    }

    private C1113Mp A03() {
        C1113Mp c1113Mp = new C1113Mp(this.A01);
        for (C2K c2k : this.A00.A05()) {
            MV mv = new MV(this.A01);
            mv.setData(c2k.A04(), null);
            mv.setOnClickListener(new ViewOnClickListenerC1106Mi(this, mv, c2k));
            c1113Mp.addView(mv);
        }
        return c1113Mp;
    }
}
