package com.tapjoy.internal;

import com.tapjoy.TJTaskHandler;
import com.tapjoy.TJWebView;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class d9 implements Runnable {
    public final /* synthetic */ TJTaskHandler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.w f2745b;

    public d9(com.tapjoy.w wVar, TJTaskHandler tJTaskHandler) {
        this.f2745b = wVar;
        this.a = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TJWebView tJWebView = this.f2745b.a.a;
            if (tJWebView == null || tJWebView.getSettings() == null) {
                this.a.onComplete(Float.valueOf(1.0f));
            } else {
                this.a.onComplete(Float.valueOf(this.f2745b.a.a.getSettings().getTextZoom() / 100.0f));
            }
        } catch (Exception e) {
            TapjoyLog.d("TJOfferwallDiscoverView", "Error getting text zoom: " + e.getMessage());
            this.a.onComplete(Float.valueOf(1.0f));
        }
    }
}
