package com.kakao.adfit.common.inappbrowser.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.webkit.internal.AssetHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.kakao.adfit.ads.R;
import com.kakao.adfit.k.a0;
import com.kakao.adfit.k.f;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IABLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010 R\u0014\u0010#\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010%R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010'R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010'R\u001c\u0010.\u001a\n ,*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout;", "Landroid/widget/FrameLayout;", "Landroid/webkit/WebView;", "webView", "", "a", "", "url", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/content/Intent;", SDKConstants.PARAM_INTENT, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "c", "Landroid/os/Bundle;", "outState", "inState", "g", InneractiveMediationDefs.GENDER_FEMALE, "e", "i", "j", "h", "Lcom/kakao/adfit/common/inappbrowser/widget/IABWebView;", "Lcom/kakao/adfit/common/inappbrowser/widget/IABWebView;", "Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar;", "Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar;", "webNavi", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "loadingBar", "Landroid/view/View;", "Landroid/view/View;", "errorView", "Landroid/widget/FrameLayout;", "fullScreenView", "Landroid/webkit/WebChromeClient;", "Landroid/webkit/WebChromeClient;", "webChromeClient", "Z", "isErrorState", "isFullScreenViewEnabled", "clearHistoryFlag", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "webUrlSchemePattern", "Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;", CampaignEx.JSON_KEY_AD_K, "Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;", "getOnEventListener", "()Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;", "setOnEventListener", "(Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;)V", "onEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
public final class IABLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final IABWebView webView;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IABNavigationBar webNavi;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final ProgressBar loadingBar;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final View errorView;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final FrameLayout fullScreenView;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private WebChromeClient webChromeClient;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private boolean isErrorState;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private boolean isFullScreenViewEnabled;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private boolean clearHistoryFlag;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final Pattern webUrlSchemePattern;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private d onEventListener;

    /* JADX INFO: compiled from: IABLayout.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/kakao/adfit/common/inappbrowser/widget/IABLayout$a", "Lcom/kakao/adfit/common/inappbrowser/widget/IABNavigationBar$a;", "", "a", "e", "c", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, InneractiveMediationDefs.GENDER_FEMALE, "g", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class a implements IABNavigationBar.a {
        a() {
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void a() {
            IABLayout.this.b();
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void b() {
            IABLayout.this.h();
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void c() {
            if (IABLayout.this.webView.canGoForward()) {
                IABLayout.this.webView.goForward();
            }
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void d() {
            IABLayout.this.c();
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void e() {
            if (IABLayout.this.webView.canGoBack()) {
                IABLayout.this.webView.goBack();
            }
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void f() {
            IABLayout.this.i();
        }

        @Override // com.kakao.adfit.common.inappbrowser.widget.IABNavigationBar.a
        public void g() {
            IABLayout.this.j();
        }
    }

    /* JADX INFO: compiled from: IABLayout.kt */
    @Metadata(bv = {}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¨\u0006\u0016"}, d2 = {"com/kakao/adfit/common/inappbrowser/widget/IABLayout$b", "Landroid/webkit/WebViewClient;", "Landroid/webkit/WebView;", "webView", "", "url", "", "shouldOverrideUrlLoading", "view", "Landroid/graphics/Bitmap;", "favicon", "", "onPageStarted", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "Landroid/webkit/RenderProcessGoneDetail;", "detail", "onRenderProcessGone", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class b extends WebViewClient {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IABLayout f1706b;

        /* JADX INFO: compiled from: IABLayout.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        public static final class a implements Runnable {
            final /* synthetic */ WeakReference a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IABNavigationBar f1707b;

            public a(WeakReference weakReference, IABNavigationBar iABNavigationBar) {
                this.a = weakReference;
                this.f1707b = iABNavigationBar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WebView webView = (WebView) this.a.get();
                if (webView == null || !webView.isAttachedToWindow()) {
                    return;
                }
                this.f1707b.a(webView);
            }
        }

        b(Context context, IABLayout iABLayout) {
            this.a = context;
            this.f1706b = iABLayout;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            f.d("IABLayout#onPageFinished(): url = " + url);
            if (this.f1706b.clearHistoryFlag) {
                if (!StringsKt.equals("about:blank", url, true)) {
                    this.f1706b.clearHistoryFlag = false;
                }
                try {
                    view.clearHistory();
                } catch (Throwable unused) {
                }
            }
            super.onPageFinished(view, url);
            if (this.f1706b.isErrorState) {
                IABNavigationBar iABNavigationBar = this.f1706b.webNavi;
                iABNavigationBar.postDelayed(new a(new WeakReference(view), iABNavigationBar), 300L);
            } else {
                String title = view.getTitle();
                if (title != null) {
                    this.f1706b.webNavi.c(title);
                }
                this.f1706b.webNavi.a(view);
                this.f1706b.webView.setVisibility(0);
                this.f1706b.errorView.setVisibility(8);
            }
            this.f1706b.loadingBar.setVisibility(8);
            com.kakao.adfit.k.c.a.a();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            f.d("IABLayout#onPageStarted(): url = " + url);
            super.onPageStarted(view, url, favicon);
            if (this.f1706b.isErrorState) {
                this.f1706b.isErrorState = false;
                this.f1706b.webView.setVisibility(0);
                this.f1706b.errorView.setVisibility(8);
            }
            IABNavigationBar iABNavigationBar = this.f1706b.webNavi;
            String string = this.a.getString(R.string.adfit_iab_label_for_request_web);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ab_label_for_request_web)");
            iABNavigationBar.c(string);
            this.f1706b.webNavi.b(url);
            this.f1706b.webNavi.a(view);
            this.f1706b.loadingBar.setProgress(0);
            this.f1706b.loadingBar.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
            f.a("IABLayout#onReceivedError(): error = [" + errorCode + "] " + description + ", url = " + failingUrl);
            super.onReceivedError(view, errorCode, description, failingUrl);
            this.f1706b.isErrorState = true;
            IABNavigationBar iABNavigationBar = this.f1706b.webNavi;
            String string = this.f1706b.getResources().getString(R.string.adfit_iab_label_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_iab_label_error_message)");
            iABNavigationBar.c(string);
            this.f1706b.webNavi.b();
            this.f1706b.webView.setVisibility(8);
            this.f1706b.errorView.setVisibility(0);
            this.f1706b.loadingBar.setVisibility(8);
            a0.a.a(this.a, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(detail, "detail");
            f.a("IABLayout#onRenderProcessGone()");
            this.f1706b.b();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(url, "url");
            f.d("IABLayout#shouldOverrideUrlLoading(): url = " + url);
            if (a0.a.c(this.a, url)) {
                return true;
            }
            if (this.f1706b.a(url)) {
                return super.shouldOverrideUrlLoading(webView, url);
            }
            this.f1706b.b(url);
            return true;
        }
    }

    /* JADX INFO: compiled from: IABLayout.kt */
    @Metadata(bv = {}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"com/kakao/adfit/common/inappbrowser/widget/IABLayout$c", "Landroid/webkit/WebChromeClient;", "Landroid/view/View;", "view", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "", "onShowCustomView", "onHideCustomView", "Landroid/webkit/WebView;", "", NotificationCompat.CATEGORY_PROGRESS, "onProgressChanged", "", "title", "onReceivedTitle", "a", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customViewCallback", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public static final class c extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private WebChromeClient.CustomViewCallback customViewCallback;

        c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            f.d("IABLayout#onHideCustomView()");
            if (IABLayout.this.isFullScreenViewEnabled) {
                IABLayout.this.isFullScreenViewEnabled = false;
                IABLayout.this.fullScreenView.setVisibility(8);
                IABLayout.this.fullScreenView.removeAllViews();
                try {
                    WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                } catch (Throwable unused) {
                }
                this.customViewCallback = null;
                d onEventListener = IABLayout.this.getOnEventListener();
                if (onEventListener != null) {
                    onEventListener.a();
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int progress) {
            Intrinsics.checkNotNullParameter(view, "view");
            IABLayout.this.loadingBar.setProgress(progress);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(title, "title");
            f.d("IABLayout#onReceivedTitle(): title = " + title);
            if (!IABLayout.this.isErrorState) {
                IABLayout.this.webNavi.c(title);
            }
            IABLayout.this.webNavi.a(view);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            Intrinsics.checkNotNullParameter(view, "view");
            f.d("IABLayout#onShowCustomView()");
            IABLayout.this.isFullScreenViewEnabled = true;
            IABLayout.this.fullScreenView.addView(view);
            IABLayout.this.fullScreenView.setVisibility(0);
            this.customViewCallback = callback;
            d onEventListener = IABLayout.this.getOnEventListener();
            if (onEventListener != null) {
                onEventListener.b();
            }
        }
    }

    /* JADX INFO: compiled from: IABLayout.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/kakao/adfit/common/inappbrowser/widget/IABLayout$d;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "c", "library_networkRelease"}, k = 1, mv = {1, 6, 0})
    public interface d {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IABLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IABLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ IABLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final d getOnEventListener() {
        return this.onEventListener;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    public final void i() {
        boolean z;
        String url = this.webView.getUrl();
        if (url == null) {
            z = false;
        } else {
            if (url.length() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("android.intent.extra.TEXT", url);
            String it = this.webView.getTitle();
            if (it != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!(it.length() > 0)) {
                    it = null;
                }
                if (it != null) {
                    intent.putExtra("android.intent.extra.SUBJECT", it);
                }
            }
            try {
                getContext().startActivity(Intent.createChooser(intent, null));
            } catch (Exception unused) {
            }
        }
    }

    public final void j() {
        String url = this.webView.getUrl();
        boolean z = false;
        if (url != null) {
            if (url.length() > 0) {
                z = true;
            }
        }
        if (z) {
            a0 a0Var = a0.a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a0Var.b(context, url);
        }
    }

    public final void setOnEventListener(d dVar) {
        this.onEventListener = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IABLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.webUrlSchemePattern = Pattern.compile("^(https?://|about:|javascript:).*", 2);
        LayoutInflater.from(context).inflate(R.layout.adfit_webview_layout, (ViewGroup) this, true);
        View viewFindViewById = findViewById(R.id.webview);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.webview)");
        IABWebView iABWebView = (IABWebView) viewFindViewById;
        this.webView = iABWebView;
        View viewFindViewById2 = findViewById(R.id.webview_navigation);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.webview_navigation)");
        IABNavigationBar iABNavigationBar = (IABNavigationBar) viewFindViewById2;
        this.webNavi = iABNavigationBar;
        View viewFindViewById3 = findViewById(R.id.webview_progress);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.webview_progress)");
        this.loadingBar = (ProgressBar) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.webview_error_page);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.webview_error_page)");
        this.errorView = viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.fullscreen_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.fullscreen_view)");
        this.fullScreenView = (FrameLayout) viewFindViewById5;
        iABNavigationBar.setOnItemClickListener(new a());
        iABWebView.setWebViewClient(new b(context, this));
        c cVar = new c();
        this.webChromeClient = cVar;
        iABWebView.setWebChromeClient(cVar);
        iABWebView.setHorizontalScrollBarEnabled(false);
        iABWebView.setDownloadListener(new DownloadListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABLayout$l3XQvnM92qeQiID04xTskP9g-xk
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                IABLayout.a(context, str, str2, str3, str4, j);
            }
        });
        findViewById(R.id.webview_refresh_button).setOnClickListener(new View.OnClickListener() { // from class: com.kakao.adfit.common.inappbrowser.widget.-$$Lambda$IABLayout$fo2iTw4g9qC2-uOrJeiz0x5Lu8Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IABLayout.a(this.f$0, view);
            }
        });
        com.kakao.adfit.k.c.a.a(iABWebView);
    }

    public final boolean d() {
        if (!this.webView.isAttachedToWindow()) {
            return false;
        }
        if (this.isFullScreenViewEnabled) {
            WebChromeClient webChromeClient = this.webChromeClient;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
            return true;
        }
        if (!this.webView.canGoBack()) {
            return false;
        }
        this.webView.goBack();
        return true;
    }

    public final void e() {
        this.onEventListener = null;
        this.webChromeClient = null;
        removeAllViews();
        a(this.webView);
        System.gc();
    }

    public final void f() {
        WebChromeClient webChromeClient;
        if (this.isFullScreenViewEnabled && (webChromeClient = this.webChromeClient) != null) {
            webChromeClient.onHideCustomView();
        }
        this.webView.onPause();
    }

    public final void g() {
        this.webView.onResume();
    }

    public final void h() {
        this.webView.stopLoading();
        this.webView.reload();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public final void c() {
        boolean z;
        String url = this.webView.getUrl();
        if (url != null) {
            z = url.length() > 0;
        }
        if (z) {
            Object systemService = getContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipData clipDataNewPlainText = ClipData.newPlainText("URL", url);
            Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(\"URL\", url)");
            ((ClipboardManager) systemService).setPrimaryClip(clipDataNewPlainText);
            Toast toastMakeText = Toast.makeText(getContext(), getResources().getString(R.string.adfit_iab_url_copy), 0);
            toastMakeText.setGravity(48, 17, getResources().getDimensionPixelOffset(R.dimen.adfit_webview_url_copy_toast_y));
            toastMakeText.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, String str, String str2, String str3, String str4, long j) {
        Intrinsics.checkNotNullParameter(context, "$context");
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            context.startActivity(intent);
        } catch (Throwable th) {
            f.b("Failed to downloaded file. [error = " + th + ']');
        }
    }

    public final void b(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.webView.saveState(outState);
    }

    public final void b() {
        this.webView.stopLoading();
        d dVar = this.onEventListener;
        if (dVar != null) {
            dVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    public final boolean b(String url) {
        ?? r4;
        ?? r2;
        ?? r1;
        f.d("IABLayout#overrideUrlLoading(): url = " + url);
        boolean z = false;
        try {
            Intent uri = Intent.parseUri(url, StringsKt.startsWith$default(url, "intent:", false, 2, (Object) null) ? 1 : 0);
            Intrinsics.checkNotNullExpressionValue(uri, "{\n            Intent.par…_SCHEME else 0)\n        }");
            if (d(uri)) {
                f.a("In-app browser load URL by intent: intent = " + uri);
                String url2 = this.webView.getUrl();
                if (url2 != null) {
                    if ((url2.length() > 0) == true) {
                        z = true;
                    }
                }
                if (!z) {
                    b();
                }
                return true;
            }
            String strA = a(uri);
            if (strA == null) {
                r4 = false;
            } else {
                if ((strA.length() > 0) == true) {
                    r4 = true;
                } else {
                    r4 = false;
                }
            }
            if (r4 != false && !Intrinsics.areEqual(url, strA)) {
                f.a("In-app browser load fallback URL: URL = " + strA);
                if (a(strA)) {
                    this.webView.loadUrl(strA);
                    return true;
                }
                if (b(strA)) {
                    return true;
                }
            }
            String strB = b(uri);
            if (strB == null) {
                r2 = false;
            } else {
                if ((strB.length() > 0) == true) {
                    r2 = true;
                } else {
                    r2 = false;
                }
            }
            if (r2 != false) {
                f.a("In-app browser load market page: URL = " + strB);
                if (b(strB)) {
                    return true;
                }
            }
            if (Intrinsics.areEqual(uri.getScheme(), "market")) {
                String strC = c(uri);
                if (strC == null) {
                    r1 = false;
                } else {
                    if ((strC.length() > 0) == true) {
                        r1 = true;
                    } else {
                        r1 = false;
                    }
                }
                if (r1 != false) {
                    f.a("In-app browser load Play Store page: URL = " + strC);
                    this.webView.loadUrl(strC);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            f.e("Failed to parse URL: " + e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IABLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    private final boolean d(Intent intent) {
        try {
            getContext().startActivity(intent.addFlags(268435456));
            return true;
        } catch (Exception e) {
            f.b("Failed to start Activity: " + e);
            return false;
        }
    }

    public final void a(Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        this.webView.restoreState(inState);
    }

    private final void a(WebView webView) {
        try {
            webView.destroyDrawingCache();
            webView.setDownloadListener(null);
            webView.setWebChromeClient(null);
            webView.stopLoading();
            webView.clearCache(true);
            webView.removeAllViews();
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.clearFormData();
            webView.clearSslPreferences();
            webView.clearDisappearingChildren();
            webView.clearFocus();
            webView.clearMatches();
            webView.freeMemory();
        } catch (Throwable unused) {
        }
        try {
            webView.destroy();
        } catch (Throwable unused2) {
        }
    }

    public final void c(String url) {
        boolean z = false;
        if (url != null) {
            if (url.length() > 0) {
                z = true;
            }
        }
        if (!z) {
            this.webView.loadUrl("about:blank");
            return;
        }
        a0 a0Var = a0.a;
        if (a0Var.a(url)) {
            this.webView.loadUrl("about:blank");
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (a0Var.c(context, url)) {
            b();
            return;
        }
        if (a(url) || !b(url)) {
            f.a("In-app browser load URL: URL = " + url);
            IABNavigationBar iABNavigationBar = this.webNavi;
            String string = getContext().getString(R.string.adfit_iab_label_for_request_web);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ab_label_for_request_web)");
            iABNavigationBar.c(string);
            this.webView.loadUrl(url);
        }
    }

    public final void a() {
        this.clearHistoryFlag = true;
        this.webView.loadUrl("about:blank");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(String url) {
        return this.webUrlSchemePattern.matcher(url).matches();
    }

    private final String a(Intent intent) {
        String stringExtra = intent.getStringExtra("browser_fallback_url");
        boolean z = false;
        if (stringExtra != null) {
            if (stringExtra.length() > 0) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        try {
            return URLDecoder.decode(stringExtra, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private final String c(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            String string = data.toString();
            Intrinsics.checkNotNullExpressionValue(string, "data.toString()");
            boolean z = false;
            if (StringsKt.startsWith$default(string, "market://details?", false, 2, (Object) null)) {
                try {
                    String queryParameter = data.getQueryParameter("id");
                    if (queryParameter != null) {
                        if (queryParameter.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        return "https://play.google.com/store/apps/details?" + data.getEncodedQuery();
                    }
                } catch (UnsupportedOperationException unused) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    private final String b(Intent intent) {
        boolean z;
        String str = intent.getPackage();
        boolean z2 = false;
        if (str == null) {
            z = false;
        } else {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            return null;
        }
        String stringExtra = intent.getStringExtra("market_referrer");
        if (stringExtra != null) {
            if (stringExtra.length() > 0) {
                z2 = true;
            }
        }
        if (z2) {
            try {
                return "market://details?id=" + str + "&referrer=" + URLEncoder.encode(stringExtra, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return "market://details?id=" + str;
    }
}
