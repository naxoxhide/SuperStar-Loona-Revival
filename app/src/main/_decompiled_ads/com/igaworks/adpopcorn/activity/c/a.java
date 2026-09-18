package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class a extends ImageView {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1566b;

    public a(Context context) {
        super(context);
        this.f1566b = context;
        if (com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID) != -100) {
            setImageResource(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID));
        } else {
            com.igaworks.adpopcorn.a.a.a(context, "igaw_ap_ic_checkbox_off.png", this, true);
            setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR), PorterDuff.Mode.MULTIPLY);
        }
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        int iC;
        Context context;
        boolean z2;
        String str;
        int iC2 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_ON_RESOURCE_ID);
        int iC3 = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID);
        if (z) {
            if (iC2 == -100) {
                context = this.f1566b;
                z2 = false;
                str = "igaw_ap_ic_checkbox_on.png";
                com.igaworks.adpopcorn.a.a.a(context, str, this, z2);
            } else {
                iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_ON_RESOURCE_ID);
                setImageResource(iC);
            }
        } else if (iC2 == -100) {
            setImageBitmap(null);
        } else if (iC3 == -100) {
            context = this.f1566b;
            z2 = true;
            str = "igaw_ap_ic_checkbox_off.png";
            com.igaworks.adpopcorn.a.a.a(context, str, this, z2);
        } else {
            iC = com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.PRIVACY_POLICE_DIALOG_CHECKBOX_OFF_RESOURCE_ID);
            setImageResource(iC);
        }
        this.a = z;
    }
}
