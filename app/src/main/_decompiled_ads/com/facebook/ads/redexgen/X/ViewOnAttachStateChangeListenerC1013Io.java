package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Io, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnAttachStateChangeListenerC1013Io implements View.OnAttachStateChangeListener {
    public final /* synthetic */ EnumC1011Im A00;
    public final /* synthetic */ C1012In A01;

    public ViewOnAttachStateChangeListenerC1013Io(C1012In c1012In, EnumC1011Im enumC1011Im) {
        this.A01 = c1012In;
        this.A00 = enumC1011Im;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.A01.A04(this.A00, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
