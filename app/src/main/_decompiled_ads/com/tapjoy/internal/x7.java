package com.tapjoy.internal;

import com.tapjoy.TJTaskHandler;
import com.tapjoy.TJWebView;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class x7 implements Runnable {
    public final /* synthetic */ TJTaskHandler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.tapjoy.c f2832b;

    public x7(com.tapjoy.c cVar, TJTaskHandler tJTaskHandler) {
        this.f2832b = cVar;
        this.a = tJTaskHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            TJWebView tJWebView = this.f2832b.a.h;
            if (tJWebView == null || tJWebView.getSettings() == null) {
                this.a.onComplete(Float.valueOf(1.0f));
            } else {
                this.a.onComplete(Float.valueOf(this.f2832b.a.h.getSettings().getTextZoom() / 100.0f));
            }
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnit", "Error getting text zoom: " + e.getMessage());
            this.a.onComplete(Float.valueOf(1.0f));
        }
    }
}
