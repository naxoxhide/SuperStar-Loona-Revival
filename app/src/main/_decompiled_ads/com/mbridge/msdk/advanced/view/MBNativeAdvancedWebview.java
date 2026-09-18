package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.mbridge.msdk.advanced.common.NetWorkStateReceiver;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

/* JADX INFO: loaded from: classes2.dex */
public class MBNativeAdvancedWebview extends WindVaneWebView {
    private static final String e = "MBNativeAdvancedWebview";
    private AdSession f;
    private NetWorkStateReceiver g;

    public MBNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.g == null) {
                this.g = new NetWorkStateReceiver(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            aa.a(e, th.getMessage());
        }
    }

    public void unregisterNetWorkReceiver() {
        try {
            NetWorkStateReceiver netWorkStateReceiver = this.g;
            if (netWorkStateReceiver != null) {
                netWorkStateReceiver.a();
                getContext().unregisterReceiver(this.g);
            }
        } catch (Throwable th) {
            aa.a(e, th.getMessage());
        }
    }

    public AdSession getAdSession() {
        return this.f;
    }

    public void setAdSession(AdSession adSession) {
        this.f = adSession;
    }

    public void finishAdSession() {
        try {
            AdSession adSession = this.f;
            if (adSession != null) {
                adSession.finish();
                this.f = null;
            }
        } catch (Exception e2) {
            aa.a("OMSDK", e2.getMessage());
        }
    }
}
