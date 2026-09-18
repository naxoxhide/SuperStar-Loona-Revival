package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.tapjoy.internal.u9;
import com.tapjoy.internal.v8;
import com.tapjoy.internal.v9;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TJWebViewActivity extends TJActivity {
    public View f;
    public TJWebView g;
    public TJAdUnitJSBridge h;

    public class BridgeDelegate extends TJJSBridgeDelegate {
        public BridgeDelegate() {
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public boolean dismiss() {
            super.dismiss();
            TJWebViewActivity.this.finish();
            return true;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public boolean fireContentReady() {
            super.fireContentReady();
            TJWebViewActivity.this.setProgressSpinnerVisibility(false);
            return true;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public Context getContext() {
            return TJWebViewActivity.this;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public Map<String, Object> getOrientation() {
            HashMap map = new HashMap();
            int iB = v8.b(TJWebViewActivity.this);
            int iA = v8.a(TJWebViewActivity.this);
            map.put("orientation", iB > iA ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT);
            map.put("width", Integer.valueOf(iB));
            map.put("height", Integer.valueOf(iA));
            return map;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void getTextZoom(TJTaskHandler<Float> tJTaskHandler) {
            TapjoyUtil.runOnMainThread(new b0(this, tJTaskHandler));
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public WebView getWebView() {
            return TJWebViewActivity.this.g;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void setBackgroundColor(String str, TJTaskHandler<Boolean> tJTaskHandler) {
            TapjoyUtil.runOnMainThread(new y(this, str, tJTaskHandler));
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void setCloseButtonClickable(boolean z) {
            super.setCloseButtonClickable(z);
            TapjoyUtil.runOnMainThread(new a0(this, z));
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void setCloseButtonVisible(boolean z) {
            super.setCloseButtonVisible(z);
            TapjoyUtil.runOnMainThread(new z(this, z));
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public boolean setOrientation(int i) {
            TJWebViewActivity.this.setRequestedOrientation(i);
            return true;
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void setTextZoom(float f) {
            TapjoyUtil.runOnMainThread(new c0(this, f));
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public void shouldClose(boolean z) {
            if (z) {
                TJWebViewActivity.this.finish();
            }
        }

        @Override // com.tapjoy.TJJSBridgeDelegate
        public boolean unsetOrientation() {
            TJWebViewActivity.this.setRequestedOrientation(-1);
            return true;
        }
    }

    @Override // com.tapjoy.TJActivity
    public final void a() {
        TJAdUnitJSBridge tJAdUnitJSBridge = this.h;
        if (tJAdUnitJSBridge == null || tJAdUnitJSBridge.closeRequested) {
            return;
        }
        TapjoyLog.d("TJWebViewActivity", TJAdUnitConstants.String.CLOSE_REQUESTED);
        this.h.closeRequested(Boolean.FALSE);
        new Handler(getMainLooper()).postDelayed(new u9(this), 1000L);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.h != null) {
            int iB = v8.b(this);
            int iA = v8.a(this);
            this.h.notifyOrientationChanged(iB > iA ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT, iB, iA);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        PackageInfo packageInfo;
        int i;
        String str;
        String str2;
        boolean zBooleanValue;
        Bundle extras;
        super.onCreate(bundle);
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 1);
        } catch (PackageManager.NameNotFoundException e) {
            TapjoyLog.e("TJDevice", e.getMessage());
            packageInfo = null;
        }
        if (packageInfo != null) {
            ActivityInfo[] activityInfoArr = packageInfo.activities;
            if (activityInfoArr.length > 0) {
                i = activityInfoArr[0].screenOrientation;
            } else {
                i = -1;
            }
        } else {
            i = -1;
        }
        setRequestedOrientation(i);
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            str = null;
            str2 = null;
            zBooleanValue = false;
        } else {
            String str3 = extras.containsKey("url") ? (String) intent.getExtras().get("url") : null;
            zBooleanValue = extras.containsKey(TJAdUnitConstants.String.REUSE_HTML) ? ((Boolean) intent.getExtras().get(TJAdUnitConstants.String.REUSE_HTML)).booleanValue() : false;
            str2 = extras.containsKey(TJAdUnitConstants.String.HTML) ? (String) intent.getExtras().get(TJAdUnitConstants.String.HTML) : null;
            str = str3;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = new View(this);
        this.f = view;
        view.setBackgroundColor(0);
        this.a.addView(this.f, -1, -1);
        TJWebView tJWebView = new TJWebView(this);
        this.g = tJWebView;
        tJWebView.setWebViewClient(new v9(this));
        this.h = new TJAdUnitJSBridge(new BridgeDelegate());
        if (zBooleanValue) {
            this.g.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        } else {
            this.g.loadUrl(str);
        }
        this.a.addView(this.g, -1, -1);
        this.a.addView(this.d);
        this.a.addView(this.c);
        setContentView(this.a, layoutParams);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.a.removeAllViews();
        TJWebView tJWebView = this.g;
        if (tJWebView != null) {
            tJWebView.loadUrl("about:blank");
            this.g.destroy();
            this.g = null;
        }
        TJAdUnitJSBridge tJAdUnitJSBridge = this.h;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.destroy();
            this.h = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        TJWebView tJWebView = this.g;
        if (tJWebView != null) {
            tJWebView.onPause();
        }
        TJAdUnitJSBridge tJAdUnitJSBridge = this.h;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setEnabled(false);
            this.h.pause();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        TJWebView tJWebView = this.g;
        if (tJWebView != null) {
            tJWebView.onResume();
        }
        TJAdUnitJSBridge tJAdUnitJSBridge = this.h;
        if (tJAdUnitJSBridge != null) {
            tJAdUnitJSBridge.setEnabled(true);
            this.h.resume();
        }
    }

    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
    }

    @Override // com.tapjoy.TJActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
    }

    public final boolean a(String str) {
        boolean z;
        boolean z2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
            z = activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            TapjoyLog.d("TJWebViewActivity", "Exception getting NetworkInfo: " + e.getLocalizedMessage());
        }
        if (z && URLUtil.isValidUrl(str)) {
            try {
                String host = new URL(TapjoyConnectCore.getHostURL()).getHost();
                z2 = (host != null && str.contains(host)) || str.contains(TapjoyConnectCore.getRedirectDomain()) || str.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL()));
            } catch (MalformedURLException unused) {
            }
            if (z2) {
                return false;
            }
            if (this.h.allowRedirect) {
                Uri uri = Uri.parse(str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uri);
                intent.addFlags(268435456);
                if (this.g.getContext() != null) {
                    try {
                        this.g.getContext().startActivity(intent);
                        return true;
                    } catch (Exception e2) {
                        TapjoyLog.e("TJWebViewActivity", "Exception in loading URL. " + e2.getMessage());
                    }
                }
            } else if (str.startsWith("javascript:")) {
                try {
                    this.g.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
                    return true;
                } catch (Exception e3) {
                    TapjoyLog.e("TJWebViewActivity", "Exception in evaluateJavascript. Device not supported. " + e3.toString());
                }
            }
            return false;
        }
        showErrorDialog();
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
