package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.download.g;
import com.mbridge.msdk.videocommon.download.h;

/* JADX INFO: loaded from: classes4.dex */
public class MBridgeAlertWebview extends MBridgeH5EndCardView {
    private String y;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected final String a() {
        if (TextUtils.isEmpty(this.v)) {
            return "";
        }
        b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.v, false);
        String str = c.a;
        this.y = str;
        return !TextUtils.isEmpty(str) ? g.a().b(this.y) : "";
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String strA = a();
        if (this.f && this.f2526b != null && !TextUtils.isEmpty(strA)) {
            BrowserView.MBDownloadListener mBDownloadListener = new BrowserView.MBDownloadListener(this.f2526b);
            mBDownloadListener.setTitle(this.f2526b.getAppName());
            this.q.setDownloadListener(mBDownloadListener);
            this.q.setCampaignId(this.f2526b.getId());
            setCloseVisible(8);
            this.q.setApiManagerJSFactory(bVar);
            this.q.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.video.module.MBridgeAlertWebview.1
                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, String str) {
                    super.a(webView, str);
                    aa.d("MBridgeAlertWebview", "finish+" + str);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView, "onSignalCommunication", "");
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i, String str, String str2) {
                    super.a(webView, i, str, str2);
                    aa.d("MBridgeAlertWebview", "onReceivedError");
                    if (MBridgeAlertWebview.this.u) {
                        return;
                    }
                    aa.a(MBridgeBaseView.TAG, "onReceivedError,url:" + str2);
                    q.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.f2526b, MBridgeAlertWebview.this.y, MBridgeAlertWebview.this.v, 2, str);
                    MBridgeAlertWebview.this.u = true;
                }

                @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
                public final void a(WebView webView, int i) {
                    super.a(webView, i);
                    aa.d("MBridgeAlertWebview", "readyState  :  " + i);
                    if (MBridgeAlertWebview.this.u) {
                        return;
                    }
                    MBridgeAlertWebview.this.t = i == 1;
                    q.a(MBridgeAlertWebview.this.a, MBridgeAlertWebview.this.f2526b, MBridgeAlertWebview.this.y, MBridgeAlertWebview.this.v, i, MBridgeAlertWebview.this.t ? "readyState state is " + i : "");
                }
            });
            setHtmlSource(h.a().b(strA));
            this.t = false;
            if (TextUtils.isEmpty(this.s)) {
                aa.a(MBridgeBaseView.TAG, "load url:" + strA);
                this.q.loadUrl(strA);
            } else {
                aa.a(MBridgeBaseView.TAG, "load html...");
                this.q.loadDataWithBaseURL(strA, this.s, "text/html", "UTF-8", null);
            }
            this.q.setBackgroundColor(0);
            setBackgroundColor(0);
            return;
        }
        this.e.a(101, "");
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        if (this.o != null) {
            this.o.setBackgroundColor(0);
        }
        super.webviewshow();
        q.a(this.a, this.f2526b, this.y, this.v, 2);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }
}
