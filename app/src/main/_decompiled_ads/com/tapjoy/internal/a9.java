package com.tapjoy.internal;

import com.tapjoy.TJOfferwallDiscoverView;
import com.tapjoy.TJWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class a9 implements Runnable {
    public final /* synthetic */ TJOfferwallDiscoverView a;

    public a9(TJOfferwallDiscoverView tJOfferwallDiscoverView) {
        this.a = tJOfferwallDiscoverView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.removeAllViews();
        TJWebView tJWebView = this.a.a;
        if (tJWebView != null) {
            tJWebView.loadUrl("about:blank");
            this.a.a.destroy();
            this.a.f2696b.destroy();
            TJOfferwallDiscoverView tJOfferwallDiscoverView = this.a;
            tJOfferwallDiscoverView.a = null;
            tJOfferwallDiscoverView.f2696b = null;
        }
        TJOfferwallDiscoverView tJOfferwallDiscoverView2 = this.a;
        tJOfferwallDiscoverView2.e = false;
        tJOfferwallDiscoverView2.f = false;
    }
}
