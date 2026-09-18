package com.mbridge.msdk.splash.c;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;

/* JADX INFO: compiled from: WebViewRenderManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2437b;

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    public interface b {
        void a();

        void a(int i);

        void a(String str);
    }

    private e() {
        this.a = false;
        this.f2437b = false;
    }

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    static class a {
        private static final e a = new e();
    }

    public final void a() {
        this.a = false;
        this.f2437b = false;
    }

    public final void a(final MBSplashView mBSplashView, c cVar, final b bVar) {
        String requestId;
        if (mBSplashView == null || cVar == null) {
            return;
        }
        final String strC = cVar.c();
        String strB = cVar.b();
        final CampaignEx campaignExD = cVar.d();
        String strA = cVar.a();
        boolean zE = cVar.e();
        int iF = cVar.f();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        com.mbridge.msdk.splash.signal.b bVar2 = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), strB, strC);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignExD);
        bVar2.a(arrayList);
        bVar2.a(zE ? 1 : 0);
        bVar2.b(iF);
        mBSplashView.setSplashSignalCommunicationImpl(bVar2);
        if (TextUtils.isEmpty(campaignExD.getRequestId())) {
            requestId = campaignExD.getRequestIdNotice();
        } else {
            requestId = campaignExD.getRequestId();
        }
        String requestId2 = splashWebview.getRequestId();
        aa.d("WebViewRenderManager", "CampaignEx RequestId = " + requestId + " WebView RequestId = " + requestId2);
        if (!TextUtils.isEmpty(requestId2) && requestId2.equals(requestId) && (this.a || this.f2437b)) {
            mBSplashView.setH5Ready(true);
            if (bVar != null) {
                bVar.a(1);
                return;
            }
            return;
        }
        a();
        splashWebview.setRequestId(requestId);
        com.mbridge.msdk.splash.a.b bVarA = com.mbridge.msdk.splash.a.b.a().c(campaignExD.getId()).d(campaignExD.getRequestId()).g(campaignExD.getRequestIdNotice()).b(strC).a(campaignExD.isBidCampaign());
        if (bVarA != null) {
            bVarA.a("2000067");
            if (k.a().c()) {
                k.a().a(bVarA.b());
            } else {
                n.a(bVarA.b(), com.mbridge.msdk.foundation.controller.b.d().g(), strC);
            }
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.splash.c.e.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i) {
                super.a(webView, i);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(i);
                }
                if (i == 1) {
                    e.this.a = true;
                    mBSplashView.setH5Ready(true);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "", jCurrentTimeMillis, 1);
                    com.mbridge.msdk.splash.e.a.a(campaignExD, strC);
                    return;
                }
                e.this.a = false;
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "readyState 2", strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "readyState 2", jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i, String str, String str2) {
                super.a(webView, i, str, str2);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(str);
                }
                e.this.a();
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "error code:" + i + str, strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "error code:" + i + str, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a(sslError.toString());
                }
                e.this.a();
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "error url:" + sslError.getUrl(), strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                b bVar3 = bVar;
                if (bVar3 != null) {
                    bVar3.a();
                }
                e.this.f2437b = true;
                if (!campaignExD.isHasMBTplMark()) {
                    mBSplashView.setH5Ready(true);
                    com.mbridge.msdk.splash.e.a.a(campaignExD, strC);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.splash.signal.c.a(webView);
            }
        });
        if (!splashWebview.isDestoryed()) {
            splashWebview.loadUrl(strA);
        } else {
            mBSplashView.setH5Ready(false);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignExD, strC, "webview had destory", jCurrentTimeMillis, 3);
        }
    }

    /* JADX INFO: compiled from: WebViewRenderManager.java */
    public static class c {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2439b;
        private CampaignEx c;
        private String d;
        private boolean e;
        private int f;

        public final String a() {
            return this.d;
        }

        public final void a(String str) {
            this.d = str;
        }

        public final String b() {
            return this.a;
        }

        public final void b(String str) {
            this.a = str;
        }

        public final String c() {
            return this.f2439b;
        }

        public final void c(String str) {
            this.f2439b = str;
        }

        public final CampaignEx d() {
            return this.c;
        }

        public final void a(CampaignEx campaignEx) {
            this.c = campaignEx;
        }

        public final boolean e() {
            return this.e;
        }

        public final void a(boolean z) {
            this.e = z;
        }

        public final int f() {
            return this.f;
        }

        public final void a(int i) {
            this.f = i;
        }
    }
}
