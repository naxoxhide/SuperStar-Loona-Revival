package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnTouchListenerC1177Pb implements View.OnTouchListener {
    public final /* synthetic */ RX A00;

    public ViewOnTouchListenerC1177Pb(RX rx) {
        this.A00 = rx;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A00.A0B.A02(new L2(view, motionEvent));
        return false;
    }
}
