package com.mbridge.msdk.advanced.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NetWorkStateReceiver extends BroadcastReceiver {
    private static final String a = "NetWorkStateReceiver";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f1892b;
    private int c;

    public NetWorkStateReceiver(WebView webView) {
        this.f1892b = webView;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.f1892b, 0);
                return;
            }
            if (com.mbridge.msdk.foundation.same.a.c) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    a(this.f1892b, 0);
                    return;
                }
                if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                    if (activeNetworkInfo.getType() == 1) {
                        a(this.f1892b, 9);
                        return;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        a(this.f1892b, 0);
                        return;
                    }
                    int networkType = telephonyManager.getNetworkType();
                    this.c = networkType;
                    int iC = w.c(networkType);
                    this.c = iC;
                    a(this.f1892b, iC);
                    return;
                }
                return;
            }
            a(this.f1892b, 0);
        } catch (Throwable th) {
            aa.a(a, th.getMessage());
        }
    }

    public final void a() {
        this.f1892b = null;
    }

    private void a(WebView webView, int i) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i);
                g.a().a(webView, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                aa.a(a, th.getMessage());
            }
        }
    }
}
