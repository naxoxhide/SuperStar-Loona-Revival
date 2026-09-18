package com.tapjoy;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements Runnable {
    public final WebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2850b;
    public final boolean c;
    public final /* synthetic */ TJAdUnitJSBridge d;

    public q(TJAdUnitJSBridge tJAdUnitJSBridge, WebView webView, boolean z, boolean z2) {
        this.d = tJAdUnitJSBridge;
        this.a = webView;
        this.f2850b = z;
        this.c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!(this.d.f2684b.getContext() instanceof Activity)) {
            TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            return;
        }
        if (!this.f2850b) {
            this.a.setVisibility(4);
            if (this.a.getParent() instanceof RelativeLayout) {
                ((RelativeLayout) this.a.getParent()).getBackground().setAlpha(0);
                ((RelativeLayout) this.a.getParent()).setBackgroundColor(0);
                return;
            }
            return;
        }
        this.a.setVisibility(0);
        if (this.c) {
            if (this.a.getParent() instanceof RelativeLayout) {
                ((RelativeLayout) this.a.getParent()).getBackground().setAlpha(0);
                ((RelativeLayout) this.a.getParent()).setBackgroundColor(0);
            }
            this.a.setLayerType(1, null);
            return;
        }
        if (this.a.getParent() instanceof RelativeLayout) {
            ((RelativeLayout) this.a.getParent()).getBackground().setAlpha(255);
            ((RelativeLayout) this.a.getParent()).setBackgroundColor(-1);
        }
        this.a.setLayerType(0, null);
    }
}
