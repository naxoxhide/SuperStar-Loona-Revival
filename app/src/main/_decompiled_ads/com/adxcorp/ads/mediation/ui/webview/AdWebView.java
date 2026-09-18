package com.adxcorp.ads.mediation.ui.webview;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.util.ADXLogUtil;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class AdWebView extends WebView {
    public static final String TAG = "AdWebView";
    private Context mContext;
    private Handler mHandler;
    private String mHtmlData;
    private boolean mIsDestroyed;
    private boolean mIsFinished;
    private boolean mIsWebviewLoadingSkip;
    private Date mStartDate;
    private WebViewEventListener mWebViewEventListener;
    private boolean mWebViewPressed;

    public interface WebViewEventListener {
        void onPageDelayed();

        void onPageFinished();

        void onUserClick(String str);
    }

    public AdWebView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public void setWebViewEventListener(WebViewEventListener webViewEventListener) {
        this.mWebViewEventListener = webViewEventListener;
    }

    private void init() {
        this.mIsFinished = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(0);
        if (Build.VERSION.SDK_INT >= 21) {
            setLayerType(2, null);
        } else if (Build.VERSION.SDK_INT >= 19 || Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        setScrollBarStyle(33554432);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.adxcorp.ads.mediation.ui.webview.AdWebView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AdWebView.TAG, "Touch :  " + motionEvent.getAction());
                }
                if (motionEvent.getAction() == 1) {
                    AdWebView.this.mWebViewPressed = true;
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.ui.webview.AdWebView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdWebView.this.mWebViewPressed = false;
                        }
                    }, 1000L);
                }
                return motionEvent.getAction() == 2;
            }
        });
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportMultipleWindows(true);
        getSettings().setDefaultTextEncodingName("utf-8");
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT < 30) {
            getSettings().setAllowUniversalAccessFromFileURLs(false);
            getSettings().setAllowFileAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog() && Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        getSettings().setBuiltInZoomControls(false);
        getSettings().setSupportZoom(false);
        if (Build.VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        getSettings().setDomStorageEnabled(true);
        setWebViewClient(new WebViewClientClass());
        setWebChromeClient(new WebChromeClient() { // from class: com.adxcorp.ads.mediation.ui.webview.AdWebView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                try {
                    WebView webView2 = new WebView(AdWebView.this.mContext);
                    webView2.setWebViewClient(AdWebView.this.new WebViewClientInChromeClient());
                    ((WebView.WebViewTransport) message.obj).setWebView(webView2);
                    message.sendToTarget();
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        onPause();
        removeCallback();
        this.mWebViewEventListener = null;
        if (this.mIsDestroyed) {
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.mIsDestroyed = true;
        removeAllViews();
        super.destroy();
    }

    public void loadData(String str, long j) {
        this.mHtmlData = str;
        removeCallback();
        if (this.mIsWebviewLoadingSkip) {
            this.mIsFinished = true;
            WebViewEventListener webViewEventListener = this.mWebViewEventListener;
            if (webViewEventListener != null) {
                webViewEventListener.onPageFinished();
            }
        } else if (j > 0) {
            Handler handler = new Handler(Looper.getMainLooper());
            this.mHandler = handler;
            handler.postDelayed(new Runnable() { // from class: com.adxcorp.ads.mediation.ui.webview.AdWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AdWebView.this.mIsFinished) {
                        return;
                    }
                    AdWebView.this.mIsFinished = true;
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(AdWebView.TAG, "Webview loading time is delayed.");
                    }
                    if (AdWebView.this.mWebViewEventListener != null) {
                        AdWebView.this.mWebViewEventListener.onPageFinished();
                    }
                }
            }, j);
        }
        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
            this.mStartDate = new Date();
        }
        loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCallback() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToBrowser(WebView webView, String str) {
        try {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, "goToBrowser - url : " + str);
            }
            if (webView != null) {
                webView.stopLoading();
            }
            if (!this.mWebViewPressed) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, "block goToBrowser - url : " + str);
                }
            } else {
                WebViewEventListener webViewEventListener = this.mWebViewEventListener;
                if (webViewEventListener != null) {
                    webViewEventListener.onUserClick(str);
                }
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public void setWebviewLoadingSkip(int i) {
        this.mIsWebviewLoadingSkip = i == 1;
    }

    private class WebViewClientClass extends WebViewClient {
        private WebViewClientClass() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            try {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AdWebView.TAG, "WebViewClient - onReceivedError : " + str2 + ", errorCode : " + i);
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            try {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AdWebView.TAG, "WebViewClient - onReceivedError : " + webResourceRequest.getUrl().toString() + ", errorCode : " + webResourceError.getErrorCode());
                }
            } catch (Exception unused) {
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(AdWebView.TAG, "WebViewClient - onLoadResource : " + str);
            }
            super.onLoadResource(webView, str);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:20:0x0066
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView r5, java.lang.String r6) {
            /*
                r4 = this;
                com.adxcorp.ads.mediation.MediationSDK r5 = com.adxcorp.ads.mediation.MediationSDK.getInstance()     // Catch: java.lang.Exception -> L66
                com.adxcorp.ads.mediation.common.Configuration r5 = r5.getConfiguration()     // Catch: java.lang.Exception -> L66
                boolean r5 = r5.isSdkLog()     // Catch: java.lang.Exception -> L66
                if (r5 == 0) goto L66
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L66
                java.util.Date r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.access$500(r5)     // Catch: java.lang.Exception -> L66
                java.lang.String r0 = "WebViewClient - onPageFinished : "
                if (r5 == 0) goto L50
                java.lang.String r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.TAG     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66
                r1.<init>()     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r6 = r0.append(r6)     // Catch: java.lang.Exception -> L66
                java.lang.String r0 = ", delayTime : "
                java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.lang.Exception -> L66
                java.util.Date r0 = new java.util.Date     // Catch: java.lang.Exception -> L66
                r0.<init>()     // Catch: java.lang.Exception -> L66
                long r0 = r0.getTime()     // Catch: java.lang.Exception -> L66
                com.adxcorp.ads.mediation.ui.webview.AdWebView r2 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L66
                java.util.Date r2 = com.adxcorp.ads.mediation.ui.webview.AdWebView.access$500(r2)     // Catch: java.lang.Exception -> L66
                long r2 = r2.getTime()     // Catch: java.lang.Exception -> L66
                long r0 = r0 - r2
                r2 = 1000(0x3e8, double:4.94E-321)
                long r0 = r0 / r2
                java.lang.StringBuilder r6 = r6.append(r0)     // Catch: java.lang.Exception -> L66
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L66
                com.adxcorp.util.ADXLogUtil.d(r5, r6)     // Catch: java.lang.Exception -> L66
                goto L66
            L50:
                java.lang.String r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.TAG     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66
                r1.<init>()     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L66
                java.lang.StringBuilder r6 = r0.append(r6)     // Catch: java.lang.Exception -> L66
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L66
                com.adxcorp.util.ADXLogUtil.d(r5, r6)     // Catch: java.lang.Exception -> L66
            L66:
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L8b
                boolean r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.access$300(r5)     // Catch: java.lang.Exception -> L8b
                if (r5 != 0) goto L9f
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L8b
                r6 = 1
                com.adxcorp.ads.mediation.ui.webview.AdWebView.access$302(r5, r6)     // Catch: java.lang.Exception -> L8b
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L8b
                com.adxcorp.ads.mediation.ui.webview.AdWebView.access$600(r5)     // Catch: java.lang.Exception -> L8b
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L8b
                com.adxcorp.ads.mediation.ui.webview.AdWebView$WebViewEventListener r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.access$400(r5)     // Catch: java.lang.Exception -> L8b
                if (r5 == 0) goto L9f
                com.adxcorp.ads.mediation.ui.webview.AdWebView r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.this     // Catch: java.lang.Exception -> L8b
                com.adxcorp.ads.mediation.ui.webview.AdWebView$WebViewEventListener r5 = com.adxcorp.ads.mediation.ui.webview.AdWebView.access$400(r5)     // Catch: java.lang.Exception -> L8b
                r5.onPageFinished()     // Catch: java.lang.Exception -> L8b
                goto L9f
            L8b:
                r5 = move-exception
                com.adxcorp.ads.mediation.MediationSDK r6 = com.adxcorp.ads.mediation.MediationSDK.getInstance()
                com.adxcorp.ads.mediation.common.Configuration r6 = r6.getConfiguration()
                boolean r6 = r6.isSdkLog()
                if (r6 == 0) goto L9f
                java.lang.String r6 = com.adxcorp.ads.mediation.ui.webview.AdWebView.TAG
                com.adxcorp.util.ADXLogUtil.e(r6, r5)
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(AdWebView.TAG, "WebViewClient - shouldOverrideUrlLoading : " + str);
            }
            AdWebView.this.goToBrowser(webView, str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String string = webResourceRequest.getUrl().toString();
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(AdWebView.TAG, "WebViewClient - shouldOverrideUrlLoading[N] : " + string);
            }
            AdWebView.this.goToBrowser(webView, string);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(AdWebView.TAG, "WebViewClient - onRenderProcessGone");
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (webView == null) {
                return true;
            }
            try {
                if (webView.getParent() instanceof ViewGroup) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                }
                webView.onPause();
                webView.destroy();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public class WebViewClientInChromeClient extends WebViewClientClass {
        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        public WebViewClientInChromeClient() {
            super();
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewClientClass, android.webkit.WebViewClient
        public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
