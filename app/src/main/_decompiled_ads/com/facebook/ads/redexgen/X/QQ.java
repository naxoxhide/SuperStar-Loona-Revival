package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QQ implements View.OnTouchListener {
    public final /* synthetic */ TextureViewSurfaceTextureListenerC1010Il A00;

    public QQ(TextureViewSurfaceTextureListenerC1010Il textureViewSurfaceTextureListenerC1010Il) {
        this.A00 = textureViewSurfaceTextureListenerC1010Il;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A00.A09 != null && motionEvent.getAction() == 1) {
            if (this.A00.A09.isShowing()) {
                this.A00.A09.hide();
            } else {
                this.A00.A09.show();
            }
        }
        return true;
    }
}
