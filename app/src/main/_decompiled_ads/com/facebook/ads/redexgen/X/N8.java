package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.primitives.SignedBytes;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class N8 extends WebViewClient {
    public static byte[] A05;
    public N4 A00 = new N4() { // from class: com.facebook.ads.redexgen.X.TK
        @Override // com.facebook.ads.redexgen.X.N4
        public final boolean A91(String str) {
            return N8.A04(str);
        }
    };
    public WeakReference<N6> A01 = new WeakReference<>(null);
    public final WeakReference<YA> A02;
    public final WeakReference<N5> A03;
    public final WeakReference<N1> A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{54, 55, 68, 74, 73, 15, 55, 65, 54, 67, SignedBytes.MAX_POWER_OF_TWO, 39, 52, 37, 39, 41, 58, 47, 60, 47, 58, 63, 51, SignedBytes.MAX_POWER_OF_TWO, 54, 68, 65, 59, 54, 0, 59, SignedBytes.MAX_POWER_OF_TWO, 70, 55, SignedBytes.MAX_POWER_OF_TWO, 70, 0, 51, 53, 70, 59, 65, SignedBytes.MAX_POWER_OF_TWO, 0, 40, 27, 23, 41, 9, 22, 12, 26, 23, 17, 12, -42, 17, 22, 28, 13, 22, 28, -42, 11, 9, 28, 13, 15, 23, 26, 33, -42, -22, -6, -9, -1, -5, -23, -22, -12, -19, 7, 23, 20, 28, 24, 10, 23, 4, 11, 6, 17, 17, 7, 6, 8, 16, 4, 26, 23, 17, -54, -57, -38, -57, 49, 54, 60, 45, 54, 60, -36, -39, -45, -95, -121, -30, -48, -51, -54, -31, -44, -48, -30};
    }

    public N8(WeakReference<YA> weakReference, WeakReference<N5> weakReference2, WeakReference<N1> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    private void A02(String str, YA ya) {
        ya.A07().A9M(A00(11, 11, 101), C07597x.A09, new C07607y(A00(111, 5, 6) + str));
    }

    private boolean A03(WebView webView, String str) {
        Intent intent;
        String strA00 = A00(116, 8, 10);
        YA ya = this.A02.get();
        if (ya == null) {
            return false;
        }
        if ((TJ.A0A && (TextUtils.isEmpty(str) || A00(0, 11, 116).equals(str))) || !this.A00.A91(str)) {
            return true;
        }
        try {
            Uri uri = C1050Kc.A00(str);
            String scheme = uri.getScheme();
            try {
                boolean zA0x = IP.A0x(ya);
                String strA01 = A00(48, 33, 71);
                String strA02 = A00(22, 26, 113);
                String strA03 = A00(105, 6, 103);
                if (zA0x) {
                    if (!TJ.A0D.contains(scheme) && !A00(101, 4, 5).equals(scheme)) {
                        if (strA03.equalsIgnoreCase(scheme)) {
                            intent = Intent.parseUri(str, 1);
                            intent.setComponent(null);
                            intent.setSelector(null);
                        } else {
                            intent = new Intent(strA02, uri);
                        }
                        intent.addCategory(strA01);
                        if (Build.VERSION.SDK_INT >= 30) {
                            intent.setFlags(268436480);
                        } else {
                            intent.setFlags(268435456);
                        }
                        try {
                            if (!KN.A0B(ya, intent)) {
                                A02(str, ya);
                            }
                            return true;
                        } catch (KL unused) {
                            if (strA03.equals(scheme)) {
                                String stringExtra = intent.getStringExtra(A00(81, 20, 68));
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    if (!KN.A0B(ya, new Intent(strA02, C1050Kc.A00(stringExtra)))) {
                                        A02(str, ya);
                                    }
                                    return true;
                                }
                            }
                            C07607y c07607y = new C07607y(A00(111, 5, 6) + str);
                            c07607y.A03(1);
                            ya.A07().A9N(A00(11, 11, 101), C07597x.A06, c07607y);
                            return true;
                        }
                    }
                    return false;
                }
                if (TJ.A0A && strA03.equalsIgnoreCase(scheme)) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    uri2.addCategory(strA01);
                    uri2.setComponent(null);
                    uri2.setSelector(null);
                    if (ya.getPackageManager().resolveActivity(uri2, 65536) != null && KN.A0B(ya, uri2)) {
                        webView.goBack();
                        return true;
                    }
                } else if ((TJ.A0A && C1070Ky.A04(str)) || !TJ.A0D.contains(scheme)) {
                    return KN.A0B(ya, new Intent(strA02, uri));
                }
            } catch (Exception e) {
                ya.A07().A9N(strA00, C07597x.A2a, new C07607y(e));
                ya.A0E().A8a(e.toString());
            }
            return false;
        } catch (SecurityException e2) {
            ya.A07().A9N(strA00, C07597x.A2a, new C07607y(e2));
            return true;
        }
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(N4 n4) {
        this.A00 = n4;
    }

    public final void A06(WeakReference<N6> weakReference) {
        this.A01 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        N1 timingLogger = this.A04.get();
        if (timingLogger != null) {
            timingLogger.A03();
        }
        N5 n5 = this.A03.get();
        if (n5 != null) {
            n5.ACG(str);
        }
        N6 n6 = this.A01.get();
        if (n6 != null) {
            n6.AAg(webView.canGoBack());
            n6.ABP(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        N5 listener = this.A03.get();
        if (listener != null) {
            listener.ACI(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        YA ya = this.A02.get();
        if (ya != null) {
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            String errorMessage = C1070Ky.A01(i, sb.append(strA00).append(str).toString(), strA00 + str2);
            ya.A0E().A8X(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        YA ya = this.A02.get();
        if (ya != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 27);
            String errorMessage = C1070Ky.A01(errorCode, sb.append(strA00).append((Object) webResourceError.getDescription()).toString(), strA00 + webResourceRequest.getUrl());
            ya.A0E().A8X(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        YA context = this.A02.get();
        if (context != null) {
            context.A0E().A8Y();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        YA context = this.A02.get();
        if (context != null) {
            context.A0E().A8Z();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        NB.A02(C07597x.A2b);
        N5 listener = this.A03.get();
        if (listener != null) {
            listener.ACh();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
