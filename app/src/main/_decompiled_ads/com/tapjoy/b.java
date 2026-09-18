package com.tapjoy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.tapjoy.internal.r6;
import com.tapjoy.internal.s6;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends WebViewClient {
    public final /* synthetic */ TJAdUnit a;

    public b(TJAdUnit tJAdUnit) {
        this.a = tJAdUnit;
    }

    public final boolean a(String str) {
        boolean z;
        boolean z2;
        NetworkInfo activeNetworkInfo;
        TJAdUnit tJAdUnit = this.a;
        tJAdUnit.getClass();
        try {
            z = tJAdUnit.h.getContext() != null && (activeNetworkInfo = ((ConnectivityManager) tJAdUnit.h.getContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnit", "Exception getting NetworkInfo: " + e.getLocalizedMessage());
        }
        if (!z || !URLUtil.isValidUrl(str)) {
            TJAdUnitActivity tJAdUnitActivity = this.a.d;
            if (tJAdUnitActivity != null) {
                tJAdUnitActivity.showErrorDialog();
            }
            return true;
        }
        this.a.getClass();
        try {
            String host = new URL(TapjoyConnectCore.getHostURL()).getHost();
            z2 = (host != null && str.contains(host)) || str.contains(TapjoyConnectCore.getRedirectDomain()) || str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()));
        } catch (MalformedURLException unused) {
        }
        if (z2) {
            return false;
        }
        if (this.a.e.allowRedirect) {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            if (this.a.h.getContext() != null) {
                try {
                    this.a.h.getContext().startActivity(intent);
                    return true;
                } catch (Exception e2) {
                    TapjoyLog.e("TJAdUnit", "Exception in loading URL. " + e2.getMessage());
                }
            }
        } else if (str.startsWith("javascript:")) {
            try {
                this.a.h.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
                return true;
            } catch (Exception e3) {
                TapjoyLog.e("TJAdUnit", "Exception in evaluateJavascript. Device not supported. " + e3.toString());
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        TJAdUnitJSBridge tJAdUnitJSBridge;
        TapjoyLog.d("TJAdUnit", "onPageFinished: " + str);
        TJAdUnit tJAdUnit = this.a;
        if (tJAdUnit.y) {
            return;
        }
        TJAdUnitActivity tJAdUnitActivity = tJAdUnit.d;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.setProgressSpinnerVisibility(false);
        }
        TJAdUnit tJAdUnit2 = this.a;
        tJAdUnit2.y = true;
        if (tJAdUnit2.u && (tJAdUnitJSBridge = tJAdUnit2.e) != null) {
            tJAdUnitJSBridge.display();
        }
        TJAdUnitJSBridge tJAdUnitJSBridge2 = this.a.e;
        if (tJAdUnitJSBridge2 != null) {
            tJAdUnitJSBridge2.flushMessageQueue();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        TapjoyLog.d("TJAdUnit", "onPageStarted: " + str);
        TJAdUnit tJAdUnit = this.a;
        TJAdUnitJSBridge tJAdUnitJSBridge = tJAdUnit.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.allowRedirect = true;
            tJAdUnitJSBridge.customClose = false;
            tJAdUnitJSBridge.closeRequested = false;
            TapjoyLog.d("TJAdUnit", "detachVolumeListener");
            ScheduledFuture scheduledFuture = tJAdUnit.o;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                tJAdUnit.o = null;
            }
            tJAdUnit.p = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        TapjoyLog.d("TJAdUnit", "error:" + str);
        TJAdUnitActivity tJAdUnitActivity = this.a.d;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.showErrorDialog();
        }
        if (this.a.getSdkBeacon() != null) {
            s6 sdkBeacon = this.a.getSdkBeacon();
            if (!TextUtils.isEmpty(sdkBeacon.d)) {
                HashMap map = new HashMap(sdkBeacon.f2811b);
                map.put("error", "loadFailure");
                new r6(sdkBeacon, map).start();
            }
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "WebView rendering process exited while instantiating a WebViewClient unexpectedly"));
        if (this.a.getSdkBeacon() != null) {
            s6 sdkBeacon = this.a.getSdkBeacon();
            if (!TextUtils.isEmpty(sdkBeacon.d)) {
                HashMap map = new HashMap(sdkBeacon.f2811b);
                map.put("error", "terminated");
                new r6(sdkBeacon, map).start();
            }
        }
        TJAdUnit tJAdUnit = this.a;
        VideoView videoView = tJAdUnit.i;
        if (videoView != null && (tJAdUnit.m || videoView.getDuration() > 0)) {
            TJAdUnit tJAdUnit2 = this.a;
            tJAdUnit2.m = false;
            tJAdUnit2.l = true;
            tJAdUnit2.fireOnVideoError("WebView loading while trying to play video.");
        }
        View view = this.a.g;
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a.g);
            }
            this.a.g = null;
        }
        TJWebView tJWebView = this.a.h;
        if (tJWebView != null) {
            ViewGroup viewGroup2 = (ViewGroup) tJWebView.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.a.h);
            }
            this.a.h.removeAllViews();
            this.a.h.destroy();
            this.a.h = null;
        }
        TJAdUnitJSBridge tJAdUnitJSBridge = this.a.e;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.cleanUpJSBridge();
            this.a.e = null;
        }
        TJAdUnitActivity tJAdUnitActivity = this.a.d;
        if (tJAdUnitActivity != null) {
            tJAdUnitActivity.finish();
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        TapjoyCachedAssetData cachedDataForURL;
        WebResourceResponse webResourceResponse;
        if (TapjoyCache.getInstance() != null && (cachedDataForURL = TapjoyCache.getInstance().getCachedDataForURL(str)) != null) {
            try {
                webResourceResponse = new WebResourceResponse(cachedDataForURL.getMimeType(), "UTF-8", new FileInputStream(cachedDataForURL.getLocalFilePath()));
            } catch (Exception unused) {
                webResourceResponse = null;
            }
            if (webResourceResponse != null) {
                TapjoyLog.d("TJAdUnit", "Reading request for " + str + " from cache -- localPath: " + cachedDataForURL.getLocalFilePath());
                return webResourceResponse;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(str);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webResourceRequest.getUrl().toString());
    }
}
