package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.webkit.WebView;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class r implements Runnable {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f890b;

    public r(String str, String str2) {
        this.a = str;
        this.f890b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (iAConfigManager.K == null && (context = iAConfigManager.f) != null) {
            iAConfigManager.K = iAConfigManager.a(context);
        }
        WebView webView = iAConfigManager.K;
        String str = this.a;
        String str2 = this.f890b;
        if (webView != null) {
            if (str2 == null) {
                str2 = "";
            }
            webView.loadDataWithBaseURL(str, str2, "text/html", "utf-8", null);
        }
        com.fyber.inneractive.sdk.util.m.f1343b.postDelayed(IAConfigManager.O, TimeUnit.SECONDS.toMillis(10L));
    }
}
