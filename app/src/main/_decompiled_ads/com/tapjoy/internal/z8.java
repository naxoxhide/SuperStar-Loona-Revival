package com.tapjoy.internal;

import com.tapjoy.TJError;
import com.tapjoy.TJOfferwallDiscoverListener;
import com.tapjoy.TJOfferwallDiscoverView;
import com.tapjoy.TJWebView;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;

/* JADX INFO: loaded from: classes4.dex */
public final class z8 implements Runnable {
    public final /* synthetic */ TapjoyHttpURLResponse a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2842b;
    public final /* synthetic */ com.tapjoy.v c;

    public z8(com.tapjoy.v vVar, TapjoyHttpURLResponse tapjoyHttpURLResponse, String str) {
        this.c = vVar;
        this.a = tapjoyHttpURLResponse;
        this.f2842b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a.statusCode;
        if (i != 200) {
            TJOfferwallDiscoverListener tJOfferwallDiscoverListener = this.c.f2852b.c;
            if (tJOfferwallDiscoverListener != null) {
                tJOfferwallDiscoverListener.requestFailure(new TJError(i, "Unknown Error"));
            }
            this.c.f2852b.clearContent();
            return;
        }
        TJOfferwallDiscoverListener tJOfferwallDiscoverListener2 = this.c.f2852b.c;
        if (tJOfferwallDiscoverListener2 != null) {
            tJOfferwallDiscoverListener2.requestSuccess();
        }
        TJOfferwallDiscoverView tJOfferwallDiscoverView = this.c.f2852b;
        TapjoyHttpURLResponse tapjoyHttpURLResponse = this.a;
        tJOfferwallDiscoverView.d = tapjoyHttpURLResponse;
        TJWebView tJWebView = tJOfferwallDiscoverView.a;
        if (tJWebView != null) {
            tJWebView.loadDataWithBaseURL(this.f2842b, tapjoyHttpURLResponse.response, "text/html", "charset=UTF-8", null);
        } else {
            TapjoyLog.d("TJOfferwallDiscoverView", "Webview is null");
        }
    }
}
