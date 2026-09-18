package com.igaworks.adpopcorn.nativead.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.igaworks.adpopcorn.cores.common.d;
import com.igaworks.adpopcorn.cores.common.e;
import com.igaworks.adpopcorn.cores.common.k;
import com.igaworks.adpopcorn.style.APSize;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class b extends RecyclerView.ViewHolder {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f1630b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private GradientDrawable f;
    private Drawable g;

    public b(Context context, View view) {
        super(view);
        this.g = null;
        this.a = context;
        if (com.igaworks.adpopcorn.style.a.b().b(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_LINE_TYPE)) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ViewCompat.MEASURED_SIZE_MASK, ViewCompat.MEASURED_SIZE_MASK});
            this.f = gradientDrawable;
            gradientDrawable.setShape(0);
            this.f.setCornerRadius(d.a(context, 6));
            this.f.setGradientType(0);
            this.f.setStroke(d.a(context, 1), Color.parseColor(com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_COLOR)));
        } else {
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_COLOR), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_BTN_COLOR)});
            this.f = gradientDrawable2;
            gradientDrawable2.setShape(0);
            this.f.setCornerRadius(d.a(context, 6));
            this.f.setGradientType(0);
        }
        int iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_REWARD_ICON_RESOURCE_ID);
        if (iC != -100) {
            this.g = context.getResources().getDrawable(iC);
        }
        this.e = (ImageView) view.findViewById(0);
        this.f1630b = (TextView) view.findViewById(2);
        this.c = (TextView) view.findViewById(3);
        this.d = (TextView) view.findViewById(4);
    }

    public void a(com.igaworks.adpopcorn.cores.model.a aVar) {
        TextView textView;
        StringBuilder sbAppend;
        if (aVar.m() != null) {
            this.f1630b.setVisibility(0);
            k.b(this.f1630b, aVar.m(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_TITLE_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_TITLE_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, true);
        } else {
            this.f1630b.setVisibility(4);
        }
        if (aVar.g() != null) {
            this.c.setVisibility(0);
            k.b(this.c, aVar.g(), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_DESC_TEXT_SIZE_DP), com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_DESC_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        } else {
            this.c.setVisibility(4);
        }
        if (aVar.o()) {
            k.b(this.d, com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_COMPLETE_DEFAULT_TEXT), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        } else {
            if (aVar.b() == null) {
                String strD = com.igaworks.adpopcorn.style.a.b().d(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_DEFAULT_TEXT);
                textView = this.d;
                sbAppend = new StringBuilder().append("+").append(aVar.l()).append(" ").append(strD);
            } else if (aVar.l() > 0) {
                textView = this.d;
                sbAppend = new StringBuilder().append("+").append(aVar.l()).append(" ").append(aVar.b());
            } else {
                k.b(this.d, aVar.b(), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
            }
            k.b(textView, sbAppend.toString(), 14, com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_TEXT_COLOR), null, 0, 1, TextUtils.TruncateAt.END, false);
        }
        this.d.setVisibility(0);
        this.d.setPadding(d.a(this.a, 12), 0, d.a(this.a, 12), 0);
        this.d.setBackgroundDrawable(this.f);
        try {
            if (this.g != null) {
                APSize aPSizeA = com.igaworks.adpopcorn.style.a.b().a(ApStyleManager.CustomStyle.NATIVE_RCPM_CTA_REWARD_ICON_RESOURCE_SIZE);
                this.g.setBounds(0, 0, d.a(this.a, aPSizeA.width), d.a(this.a, aPSizeA.height));
                this.d.setCompoundDrawables(this.g, null, null, null);
                this.d.setCompoundDrawablePadding(d.a(this.a, 4));
            }
        } catch (Exception unused) {
        }
        e.a(this.a, aVar.i(), this.e, 0, 0, (e.b) null);
    }
}
