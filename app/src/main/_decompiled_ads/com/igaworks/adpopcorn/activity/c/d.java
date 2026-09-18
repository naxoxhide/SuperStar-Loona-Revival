package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.igaworks.adpopcorn.style.ApStyleManager;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ImageView {
    private Context a;

    public d(Context context) {
        super(context);
        this.a = context;
        com.igaworks.adpopcorn.a.a.a(context, "igaw_ap_btn_check_normal.png", this, true);
        setColorFilter(com.igaworks.adpopcorn.style.a.b().c(ApStyleManager.CustomStyle.COMMON_LIST_DIALOG_RADIO_DOT_COLOR), PorterDuff.Mode.MULTIPLY);
    }

    public void setChecked(boolean z) {
        if (z) {
            com.igaworks.adpopcorn.a.a.a(this.a, "igaw_ap_btn_check_select.png", this, false);
        } else {
            setImageBitmap(null);
        }
    }
}
