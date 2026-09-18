package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@22.5.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzchd extends zzche {
    public zzchd(zzcgb zzcgbVar, zzaxv zzaxvVar, boolean z, zzedz zzedzVar) {
        super(zzcgbVar, zzaxvVar, z, zzedzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcgi, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzN(webView, str, null);
    }
}
