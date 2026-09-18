package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.webview.BrowserView;

/* JADX INFO: loaded from: classes3.dex */
public class DomainMBCommonActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f1866b;
    protected BrowserView browserView;
    String a = "";
    private BrowserView.a c = new BrowserView.a() { // from class: com.mbridge.msdk.activity.DomainMBCommonActivity.1
        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, int i, String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str, Bitmap bitmap) {
            aa.d("MBCommonActivity", "onPageStarted  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final boolean b(WebView webView, String str) {
            aa.d("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (ae.a.a(str) && ae.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void c(WebView webView, String str) {
            aa.d("MBCommonActivity", "onPageFinished  " + str);
        }
    };

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            aa.d("MBCommonActivity", th.getMessage());
        }
        if (b.d().g() == null) {
            b.d().b(getApplicationContext());
        }
        b.d().a((Context) this);
        String stringExtra = getIntent().getStringExtra("url");
        this.a = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            this.f1866b = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
            if (com.mbridge.msdk.foundation.webview.b.a.containsKey(this.a)) {
                BrowserView browserView = com.mbridge.msdk.foundation.webview.b.a.get(this.a);
                this.browserView = browserView;
                if (browserView != null) {
                    browserView.setListener(this.c);
                }
            } else {
                BrowserView browserView2 = new BrowserView(this, this.f1866b);
                this.browserView = browserView2;
                browserView2.setListener(this.c);
                this.browserView.loadUrl(this.a);
            }
            BrowserView browserView3 = this.browserView;
            if (browserView3 != null) {
                ao.a(browserView3);
                setContentView(this.browserView);
                return;
            }
            return;
        }
        Toast.makeText(this, "Error: no data", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri uri = Uri.parse(str);
            if (uri.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri.getScheme().equals("https")) {
                return false;
            }
            if (uri.getScheme().equals(SDKConstants.PARAM_INTENT)) {
                Intent uri2 = Intent.parseUri(str, 1);
                try {
                    String str2 = uri2.getPackage();
                    if (!TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                        uri2.setFlags(268435456);
                        startActivityForResult(uri2, 0);
                        finish();
                        return true;
                    }
                    try {
                        String stringExtra = uri2.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri uri3 = Uri.parse(str);
                            if (uri3.getScheme().equals(ProxyConfig.MATCH_HTTP) || uri3.getScheme().equals("https")) {
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                            str = stringExtra;
                        }
                    } catch (Throwable th) {
                        aa.d("MBCommonActivity", th.getMessage());
                    }
                } catch (Throwable th2) {
                    aa.d("MBCommonActivity", th2.getMessage());
                }
                aa.d("MBCommonActivity", th.getMessage());
                return false;
            }
            if (!com.mbridge.msdk.click.b.d(this, str)) {
                return false;
            }
            aa.d("MBCommonActivity", "openDeepLink");
            finish();
            return true;
        } catch (Throwable th3) {
            aa.d("MBCommonActivity", th3.getMessage());
            return false;
        }
    }
}
