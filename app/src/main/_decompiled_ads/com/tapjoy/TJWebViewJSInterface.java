package com.tapjoy;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJWebViewJSInterface {
    public final ConcurrentLinkedQueue a = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f2703b;
    public final TJWebViewJSInterfaceListener c;
    public boolean d;

    public TJWebViewJSInterface(WebView webView, TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener) {
        this.f2703b = webView;
        this.c = tJWebViewJSInterfaceListener;
    }

    public void callback(ArrayList<?> arrayList, String str, String str2) {
        try {
            callbackToJavaScript(new JSONArray((Collection) arrayList), str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callbackToJavaScript(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TJAdUnitConstants.String.ARGUMENTS, obj);
            if (str != null && str.length() > 0) {
                jSONObject.put("method", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str2 != null && str2.length() > 0) {
                jSONObject2.put(TJAdUnitConstants.String.CALLBACK_ID, str2);
            }
            jSONObject2.put("data", jSONObject);
            String str3 = "javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('" + jSONObject2 + "');";
            if (!this.d) {
                this.a.add(str3);
                return;
            }
            WebView webView = this.f2703b;
            if (webView != null) {
                TapjoyUtil.runOnMainThread(new d0(webView, str3));
            } else {
                TapjoyLog.w("TJWebViewJSInterface", "No available webview to execute js");
            }
        } catch (Exception e) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e.toString());
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void dispatchMethod(String str) {
        TapjoyLog.d("TJWebViewJSInterface", "dispatchMethod params: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getJSONObject("data").getString("method");
            TapjoyLog.d("TJWebViewJSInterface", "method: " + string);
            TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener = this.c;
            if (tJWebViewJSInterfaceListener == null || this.f2703b == null) {
                return;
            }
            tJWebViewJSInterfaceListener.onDispatchMethod(string, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void flushMessageQueue() {
        if (this.d) {
            return;
        }
        while (true) {
            String str = (String) this.a.poll();
            if (str == null) {
                this.d = true;
                return;
            } else {
                WebView webView = this.f2703b;
                if (webView != null) {
                    TapjoyUtil.runOnMainThread(new d0(webView, str));
                }
            }
        }
    }

    public void callback(Map<?, ?> map, String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject(map));
            callbackToJavaScript(jSONArray, str, str2);
        } catch (Exception e) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e.toString());
            e.printStackTrace();
        }
    }
}
