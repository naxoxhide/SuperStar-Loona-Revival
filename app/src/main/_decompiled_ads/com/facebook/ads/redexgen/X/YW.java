package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class YW implements InterfaceC06975c {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ C06995e A01;
    public final /* synthetic */ UJ A02;

    public YW(C06995e c06995e, ImageView imageView, UJ uj) {
        this.A01 = c06995e;
        this.A00 = imageView;
        this.A02 = uj;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06975c
    public final void ABY(Drawable drawable) {
        UJ.A0e(drawable, this.A00);
        this.A02.A1J(drawable);
    }
}
