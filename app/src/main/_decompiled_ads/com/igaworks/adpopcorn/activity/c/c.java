package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ImageView {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f1567b;

    public c(Context context) {
        super(context);
        this.f1567b = context;
        com.igaworks.adpopcorn.a.a.a(context, "igaw_ap_tcpa_checkbox_off.png", this, false);
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z) {
        com.igaworks.adpopcorn.a.a.a(this.f1567b, z ? "igaw_ap_tcpa_checkbox_on.png" : "igaw_ap_tcpa_checkbox_off.png", this, false);
        this.a = z;
    }
}
