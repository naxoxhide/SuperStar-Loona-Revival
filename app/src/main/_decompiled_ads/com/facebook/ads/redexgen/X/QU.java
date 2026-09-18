package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QU implements View.OnTouchListener {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC1008Ij A00;

    public QU(TextureViewSurfaceTextureListenerC1008Ij textureViewSurfaceTextureListenerC1008Ij) {
        this.A00 = textureViewSurfaceTextureListenerC1008Ij;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.A00.A0G && this.A00.A0A != null && motionEvent.getAction() == 1) {
            if (this.A00.A0A.isShowing()) {
                this.A00.A0A.hide();
            } else {
                this.A00.A0A.show();
            }
        }
        return true;
    }
}
