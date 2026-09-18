package com.tapjoy.internal;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class o9 extends ViewOutlineProvider {
    public final /* synthetic */ float a;

    public o9(float f) {
        this.a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int width = view.getWidth();
        float height = view.getHeight();
        float f = this.a;
        outline.setRoundRect(0, 0, width, (int) (height + f), f);
    }
}
