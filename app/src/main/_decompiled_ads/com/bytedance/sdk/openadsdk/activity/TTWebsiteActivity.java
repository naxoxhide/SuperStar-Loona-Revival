package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.common.h;
import com.bytedance.sdk.openadsdk.core.a0;
import com.bytedance.sdk.openadsdk.core.customview.PAGImageView;
import com.bytedance.sdk.openadsdk.core.customview.PAGLinearLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGRelativeLayout;
import com.bytedance.sdk.openadsdk.core.customview.PAGTextView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.google.common.net.HttpHeaders;
import java.net.URLEncoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TTWebsiteActivity extends TTBaseActivity {
    private String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f422b;
    private WebView c;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTWebsiteActivity.this.c.canGoBack()) {
                TTWebsiteActivity.this.c.goBack();
            } else {
                TTWebsiteActivity.this.finish();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebsiteActivity.this.finish();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent("android.intent.action.VIEW");
            String url = TTWebsiteActivity.this.c.getUrl();
            if (TextUtils.isEmpty(url)) {
                return;
            }
            intent.setData(Uri.parse(url));
            com.bytedance.sdk.component.utils.b.a(TTWebsiteActivity.this, intent, null);
        }
    }

    class d implements View.OnClickListener {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TTWebsiteActivity.this.f422b == null) {
                TTWebsiteActivity.this.f422b = new h(TTWebsiteActivity.this);
                TTWebsiteActivity.this.f422b.a(this.a);
                TTWebsiteActivity.this.f422b.setCanceledOnTouchOutside(false);
            }
            TTWebsiteActivity.this.f422b.show();
        }
    }

    class e extends WebChromeClient {
        final /* synthetic */ ProgressBar a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PAGImageView f424b;

        e(ProgressBar progressBar, PAGImageView pAGImageView) {
            this.a = progressBar;
            this.f424b = pAGImageView;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (this.a == null || TTWebsiteActivity.this.isFinishing()) {
                return;
            }
            if (i != 100) {
                this.a.setVisibility(0);
                this.a.setProgress(i);
                return;
            }
            this.a.setVisibility(8);
            if (webView.canGoBack()) {
                this.f424b.setVisibility(0);
                this.f424b.setClickable(true);
            } else {
                this.f424b.setVisibility(4);
                this.f424b.setClickable(false);
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        super.onCreate(bundle);
        o.a(getApplicationContext());
        if (!l.e()) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("_extra_meta");
        String stringExtra2 = getIntent().getStringExtra("_extra_glo_d");
        PAGLinearLayout pAGLinearLayout = new PAGLinearLayout(this);
        pAGLinearLayout.setBackgroundColor(-1);
        pAGLinearLayout.setId(520093726);
        pAGLinearLayout.setOrientation(1);
        pAGLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        try {
            setContentView(pAGLinearLayout);
            int iA = b0.a(this, 5.0f);
            int iA2 = b0.a(this, 8.0f);
            int iA3 = b0.a(this, 10.0f);
            int iA4 = b0.a(this, 12.0f);
            int iA5 = b0.a(this, 14.0f);
            int iA6 = b0.a(this, 20.0f);
            int iA7 = b0.a(this, 24.0f);
            int iA8 = b0.a(this, 40.0f);
            int iA9 = b0.a(this, 44.0f);
            int iA10 = b0.a(this, 191.0f);
            PAGRelativeLayout pAGRelativeLayout = new PAGRelativeLayout(this);
            pAGRelativeLayout.setGravity(15);
            pAGRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, iA9));
            PAGImageView pAGImageView = new PAGImageView(this);
            pAGImageView.setId(520093720);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA8, iA9);
            int i = Build.VERSION.SDK_INT;
            if (i >= 17) {
                layoutParams.setMarginStart(iA2);
            } else {
                layoutParams.leftMargin = iA2;
            }
            pAGImageView.setLayoutParams(layoutParams);
            pAGImageView.setClickable(true);
            pAGImageView.setFocusable(true);
            pAGImageView.setPadding(iA5, iA4, iA5, iA4);
            pAGImageView.setImageDrawable(t.f(this, "tt_ad_arrow_backward_wrapper"));
            PAGImageView pAGImageView2 = new PAGImageView(this);
            pAGImageView2.setId(520093716);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA8, iA9);
            if (i >= 17) {
                layoutParams2.addRule(17, 520093720);
                z = true;
            } else {
                z = true;
                layoutParams2.addRule(1, 520093720);
            }
            pAGImageView2.setLayoutParams(layoutParams2);
            pAGImageView2.setClickable(z);
            pAGImageView2.setFocusable(z);
            pAGImageView2.setPadding(iA4, iA5, iA4, iA5);
            pAGImageView2.setImageDrawable(t.f(this, "tt_ad_xmark"));
            PAGTextView pAGTextView = new PAGTextView(this);
            pAGTextView.setId(com.bytedance.sdk.openadsdk.utils.h.o0);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iA10, iA7);
            if (i >= 17) {
                layoutParams3.setMarginStart(iA);
            } else {
                layoutParams3.leftMargin = iA;
            }
            layoutParams3.addRule(15);
            if (i >= 17) {
                layoutParams3.addRule(16, 520093741);
                layoutParams3.addRule(17, 520093716);
                z2 = true;
            } else {
                layoutParams3.addRule(0, 520093741);
                z2 = true;
                layoutParams3.addRule(1, 520093716);
            }
            pAGTextView.setLayoutParams(layoutParams3);
            pAGTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            pAGTextView.setGravity(17);
            pAGTextView.setSingleLine(z2);
            pAGTextView.setTextColor(Color.parseColor("#222222"));
            pAGTextView.setTextSize(17.0f);
            PAGImageView pAGImageView3 = new PAGImageView(this);
            pAGImageView3.setId(520093741);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA8, iA9);
            if (i >= 17) {
                layoutParams4.addRule(16, 520093742);
            } else {
                layoutParams4.addRule(0, 520093742);
            }
            pAGImageView3.setLayoutParams(layoutParams4);
            pAGImageView3.setPadding(iA3, iA4, iA3, iA4);
            pAGImageView3.setImageDrawable(t.f(this, "tt_ad_link"));
            PAGImageView pAGImageView4 = new PAGImageView(this);
            pAGImageView4.setId(520093742);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iA8, iA9);
            if (i >= 17) {
                layoutParams5.addRule(21);
                layoutParams5.setMarginEnd(iA2);
            } else {
                layoutParams5.addRule(11);
                layoutParams5.rightMargin = iA2;
            }
            pAGImageView4.setLayoutParams(layoutParams5);
            pAGImageView4.setPadding(iA4, iA6, iA4, iA6);
            pAGImageView4.setImageDrawable(t.f(this, "tt_ad_threedots"));
            ProgressBar progressBar = new ProgressBar(this, null, R.style.Widget.ProgressBar.Horizontal);
            progressBar.setId(520093743);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, b0.a(this, 2.0f));
            layoutParams6.addRule(12);
            progressBar.setLayoutParams(layoutParams6);
            progressBar.setProgress(1);
            progressBar.setProgressDrawable(t.f(this, "tt_privacy_progress_style"));
            View view = new View(this);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, b0.a(this, 1.0f));
            layoutParams7.addRule(12);
            view.setLayoutParams(layoutParams7);
            pAGRelativeLayout.addView(pAGImageView);
            pAGRelativeLayout.addView(pAGImageView2);
            pAGRelativeLayout.addView(pAGTextView);
            pAGRelativeLayout.addView(pAGImageView3);
            pAGRelativeLayout.addView(pAGImageView4);
            pAGRelativeLayout.addView(progressBar);
            pAGRelativeLayout.addView(view);
            pAGLinearLayout.addView(pAGRelativeLayout);
            try {
                WebView webView = new WebView(this);
                this.c = webView;
                webView.setBackgroundColor(-1);
                pAGLinearLayout.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
                pAGImageView.setOnClickListener(new a());
                pAGImageView2.setOnClickListener(new b());
                pAGImageView2.setVisibility(4);
                pAGImageView2.setClickable(false);
                pAGTextView.setText(t.k(this, "tt_privacy_title"));
                pAGImageView3.setOnClickListener(new c());
                pAGImageView4.setOnClickListener(new d(stringExtra));
                if (o.d() != null) {
                    this.a = o.d().W();
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        String strEncode = URLEncoder.encode(stringExtra2);
                        if (this.a.contains("?")) {
                            this.a += "&gdid_encrypted=" + strEncode;
                        } else {
                            this.a += "?gdid_encrypted=" + strEncode;
                        }
                    }
                }
                if (this.a == null) {
                    finish();
                    return;
                }
                WebSettings settings = this.c.getSettings();
                if (i >= 21) {
                    z3 = false;
                    settings.setMixedContentMode(0);
                } else {
                    z3 = false;
                }
                try {
                    settings.setJavaScriptEnabled(true);
                    settings.setDomStorageEnabled(true);
                    settings.setSavePassword(z3);
                    settings.setAllowFileAccess(z3);
                } catch (Throwable unused) {
                }
                HashMap map = new HashMap();
                map.put(HttpHeaders.REFERER, TTAdConstant.REQUEST_HEAD_REFERER);
                try {
                    this.c.loadUrl(this.a, map);
                } catch (Throwable unused2) {
                    this.c.loadUrl(this.a);
                }
                this.c.setWebChromeClient(new e(progressBar, pAGImageView2));
                this.c.setWebViewClient(new f(this));
                com.bytedance.sdk.openadsdk.core.widget.webview.b.b(this.c);
            } catch (Exception e2) {
                m.b("TTAD.TTWebsiteActivity", "onCreate: ", e2);
                finish();
            }
        } catch (Throwable unused3) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        a0.a(this.c);
    }

    class f extends SSWebView.r0 {
        f(TTWebsiteActivity tTWebsiteActivity) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            m.b("TTAD.TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + webResourceError.getErrorCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            m.b("TTAD.TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=" + webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webView == null || webResourceRequest == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.loadUrl(webResourceRequest.getUrl().toString());
                return true;
            }
            webView.loadUrl(webResourceRequest.toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    public static void a(Context context, q qVar, String str) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.d.c.a(qVar, str, "open_policy");
        if (TextUtils.isEmpty(o.d().W())) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTWebsiteActivity.class);
        if (qVar != null) {
            intent.putExtra("_extra_meta", qVar.n1().toString());
            intent.putExtra("_extra_glo_d", qVar.J());
        }
        com.bytedance.sdk.component.utils.b.a(context, intent, null);
    }
}
