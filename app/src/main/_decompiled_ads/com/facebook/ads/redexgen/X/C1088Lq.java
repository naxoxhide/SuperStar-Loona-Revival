package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1088Lq extends LinearLayout {
    public static byte[] A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final ImageView A00;
    public final ImageView A01;
    public final C2G A02;
    public final YA A03;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{118, 83};
    }

    static {
        A03();
        A08 = (int) (C1066Ku.A02 * 50.0f);
        A05 = (int) (C1066Ku.A02 * 10.0f);
        A06 = (int) (C1066Ku.A02 * 20.0f);
        A09 = (int) (C1066Ku.A02 * 4.0f);
        A07 = (int) (C1066Ku.A02 * 12.0f);
    }

    public C1088Lq(YA ya, int i) {
        super(ya);
        this.A03 = ya;
        this.A02 = C2H.A00(ya.A01());
        setOrientation(0);
        this.A00 = new ImageView(ya);
        this.A01 = new ImageView(ya);
        A04(i);
    }

    private void A04(int i) {
        EnumC1075Ld enumC1075Ld;
        A05(this.A00, EnumC1075Ld.AD_CHOICES_ICON);
        if (i == 2) {
            int i2 = A05;
            setPadding(i2, i2 / 3, i2, i2 / 3);
            TextView textView = new TextView(this.A03);
            textView.setText(A02(0, 2, 108));
            textView.setTextColor(-1);
            textView.setPadding(0, i2 / 2, i2 / 2, i2 / 2);
            LV.A0X(textView, true, 13);
            LinearLayout.LayoutParams textViewParams = new LinearLayout.LayoutParams(-2, -2);
            textViewParams.gravity = 16;
            addView(textView, textViewParams);
            int i3 = A07;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.gravity = 16;
            addView(this.A00, layoutParams);
            return;
        }
        int i4 = A05;
        setPadding(i4, i4, i4, i4);
        if (i == 1) {
            enumC1075Ld = EnumC1075Ld.AN_INFO_ICON;
        } else {
            enumC1075Ld = EnumC1075Ld.DEFAULT_INFO_ICON;
        }
        A05(this.A01, enumC1075Ld);
        int i5 = A06;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i5, i5);
        layoutParams2.gravity = 17;
        addView(this.A01, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i5, i5);
        layoutParams3.setMargins(A09, 0, 0, 0);
        layoutParams3.gravity = 17;
        addView(this.A00, layoutParams3);
    }

    public static void A05(ImageView imageView, EnumC1075Ld enumC1075Ld) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(C1076Le.A01(enumC1075Ld));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C1X c1x, String str, C1012In c1012In, InterfaceC1091Lt interfaceC1091Lt) {
        setOnClickListener(new ViewOnClickListenerC1087Lp(this, c1012In, interfaceC1091Lt, str, c1x));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A08);
        gradientDrawable.setColor(i);
        LV.A0S(this, gradientDrawable);
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
        this.A01.setColorFilter(i);
    }
}
