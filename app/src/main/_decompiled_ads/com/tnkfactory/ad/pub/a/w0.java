package com.tnkfactory.ad.pub.a;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class w0 extends ViewOutlineProvider {
    public int a;

    public w0(int i) {
        this.a = i;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        if (this.a > 0) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.a);
            view.setClipToOutline(true);
        }
    }
}
