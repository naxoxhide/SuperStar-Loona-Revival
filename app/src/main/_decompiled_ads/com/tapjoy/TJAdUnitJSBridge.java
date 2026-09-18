package com.tapjoy;

import android.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.tapjoy.internal.i8;
import com.tapjoy.internal.s6;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TJAdUnitJSBridge implements TJWebViewJSInterfaceListener {
    public static Object g;
    public TJWebViewJSInterface a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TJJSBridgeDelegate f2684b;
    public TJSplitWebView c;
    public ProgressDialog d;
    public boolean e;
    public boolean didLaunchOtherActivity = false;
    public boolean allowRedirect = true;
    public String otherActivityCallbackID = null;
    public boolean customClose = false;
    public boolean closeRequested = false;
    public String splitWebViewCallbackID = null;
    public final ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();

    public TJAdUnitJSBridge(TJJSBridgeDelegate tJJSBridgeDelegate) {
        this.f2684b = tJJSBridgeDelegate;
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        WebView webView = tJJSBridgeDelegate.getWebView();
        if (webView == null) {
            TapjoyLog.e("TJAdUnitJSBridge", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        TJWebViewJSInterface tJWebViewJSInterface = new TJWebViewJSInterface(webView, this);
        this.a = tJWebViewJSInterface;
        webView.addJavascriptInterface(tJWebViewJSInterface, TJAdUnitConstants.JAVASCRIPT_INTERFACE_ID);
        setEnabled(true);
        try {
            Context context = tJJSBridgeDelegate.getContext();
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("appJSMessageHandler")) {
                if (g == null) {
                    g = Class.forName(bundle.getString("appJSMessageHandler")).newInstance();
                }
                g.getClass().getDeclaredMethod("setHandler", Object.class, String.class).invoke(g, new p(this), p.class.getDeclaredMethods()[0].getName());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            throw new RuntimeException(e);
        } catch (ClassNotFoundException unused) {
            TapjoyLog.d("TJAdUnitJSBridge", "No app-provided support for JS handler");
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(WebView webView, boolean z, boolean z2) {
        if (webView != null) {
            webView.post(new q(this, webView, z, z2));
        }
    }

    public void alert(JSONObject jSONObject, String str) {
        String str2;
        JSONArray jSONArray;
        String string;
        int i;
        String string2 = "";
        TapjoyLog.d("TJAdUnitJSBridge", "alert_method: " + jSONObject);
        try {
            string = jSONObject.getString("title");
            try {
                string2 = jSONObject.getString("message");
                jSONArray = jSONObject.getJSONArray(TJAdUnitConstants.String.BUTTONS);
            } catch (Exception e) {
                e = e;
                str2 = string2;
                string2 = string;
                invokeJSCallback(str, Boolean.FALSE);
                e.printStackTrace();
                jSONArray = null;
                String str3 = str2;
                string = string2;
                string2 = str3;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = "";
        }
        Context context = this.f2684b.getContext();
        if (context == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "Cannot alert -- TJAdUnitActivity is null");
            return;
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context, R.style.Theme.Material.Light.Dialog.Alert).setTitle(string).setMessage(string2).create();
        if (jSONArray == null || jSONArray.length() == 0) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            if (i2 != 0) {
                i = i2 != 1 ? -1 : -3;
            } else {
                i = -2;
            }
            try {
                arrayList.add(jSONArray.getString(i2));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            alertDialogCreate.setButton(i, (CharSequence) arrayList.get(i2), new f(this, str));
            i2++;
        }
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.show();
    }

    public void attachVolumeListener(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.ATTACH);
            int iOptInt = jSONObject.optInt(TJAdUnitConstants.String.INTERVAL, 500);
            if (iOptInt > 0) {
                this.f2684b.attachVolumeListener(z, iOptInt);
                invokeJSCallback(str, Boolean.TRUE);
            } else {
                TapjoyLog.d("TJAdUnitJSBridge", "Invalid `interval` value passed to attachVolumeListener(): interval=" + iOptInt);
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "attachVolumeListener exception " + e.toString());
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void cachePathForURL(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().getPathOfCachedURL(string));
            } else {
                invokeJSCallback(str, "");
            }
        } catch (Exception unused) {
            invokeJSCallback(str, "");
        }
    }

    public void cleanUpJSBridge() {
        TJWebViewJSInterface tJWebViewJSInterface = this.a;
        if (tJWebViewJSInterface != null) {
            WebView webView = tJWebViewJSInterface.f2703b;
            if (webView != null) {
                webView.removeAllViews();
                this.a.f2703b.destroy();
                this.a.f2703b = null;
            }
            this.a = null;
        }
    }

    public void clearCache(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() == null) {
            invokeJSCallback(str, Boolean.FALSE);
        } else {
            TapjoyCache.getInstance().clearTapjoyCache();
            invokeJSCallback(str, Boolean.TRUE);
        }
    }

    public void clearLoggingLevel(JSONObject jSONObject, String str) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void clearVideo(JSONObject jSONObject, String str) {
        this.f2684b.clearVideo(new l(this, str), jSONObject.optBoolean(TJAdUnitConstants.String.VISIBLE, false));
    }

    public void closeRequested(Boolean bool) {
        TJSplitWebView tJSplitWebView = this.c;
        if (tJSplitWebView != null) {
            if (tJSplitWebView.goBack()) {
                return;
            }
            this.c.j.dismissSplitView(null, null);
        } else {
            this.closeRequested = true;
            HashMap map = new HashMap();
            map.put(TJAdUnitConstants.String.FORCE_CLOSE, bool);
            invokeJSAdunitMethod(TJAdUnitConstants.String.CLOSE_REQUESTED, map);
        }
    }

    public void contentReady(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(this.f2684b.fireContentReady()));
    }

    public void destroy() {
    }

    public void dismiss(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.TRUE);
        this.f2684b.dismiss();
    }

    public void dismissSplitView(JSONObject jSONObject, String str) {
        TapjoyUtil.runOnMainThread(new d(this, str));
    }

    public void dismissStoreView(JSONObject jSONObject, String str) {
        dismissSplitView(jSONObject, str);
    }

    public void display() {
        invokeJSAdunitMethod("display", new Object[0]);
    }

    public void displayFullscreenWebview(JSONObject jSONObject, String str) {
        String string;
        Boolean boolValueOf = null;
        try {
            string = jSONObject.getString("url");
        } catch (JSONException unused) {
            string = null;
        }
        try {
            if (jSONObject.has(TJAdUnitConstants.String.REUSE_HTML)) {
                boolValueOf = Boolean.valueOf(jSONObject.getBoolean(TJAdUnitConstants.String.REUSE_HTML));
            }
        } catch (JSONException unused2) {
        }
        if ((string == null || string.length() == 0) && boolValueOf == null) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        Intent intent = new Intent(this.f2684b.getContext(), (Class<?>) TJWebViewActivity.class);
        intent.setAction("android.intent.action.VIEW");
        intent.setPackage(this.f2684b.getContext().getPackageName());
        intent.putExtra("url", string);
        intent.putExtra(TJAdUnitConstants.String.REUSE_HTML, boolValueOf);
        String str2 = (String) this.f2684b.getData(TJAdUnitConstants.String.HTML, String.class);
        if (str2 != null) {
            intent.putExtra(TJAdUnitConstants.String.HTML, str2);
        }
        this.f2684b.getContext().startActivity(intent);
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void displayStoreURL(JSONObject jSONObject, String str) {
        displayURL(jSONObject, str);
    }

    public void displayURL(JSONObject jSONObject, String str) {
        String str2;
        String strOptString;
        try {
            String strOptString2 = jSONObject.optString("style");
            String string = jSONObject.getString("url");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_LAYOUT);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(TJAdUnitConstants.String.SPLIT_VIEW_EXIT_HOSTS);
            String strOptString3 = jSONObject.optString(TJAdUnitConstants.String.USER_AGENT, null);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER);
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString4 = jSONObjectOptJSONObject2.optString("on", null);
                strOptString = jSONObjectOptJSONObject2.optString("to", null);
                str2 = strOptString4;
            } else {
                str2 = null;
                strOptString = null;
            }
            if (TJAdUnitConstants.String.STYLE_SPLIT.equals(strOptString2)) {
                TapjoyUtil.runOnMainThread(new g(this, jSONObject, jSONArrayOptJSONArray, jSONObjectOptJSONObject, strOptString3, str2, strOptString, str, string));
                return;
            }
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = str;
            this.f2684b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.TRUE);
            e.printStackTrace();
        }
    }

    public void displayVideo(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (string.length() <= 0 || string == "") {
                invokeJSCallback(str, Boolean.FALSE);
            } else {
                this.f2684b.loadVideoUrl(string, new k(this, str));
            }
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void fetchData(JSONObject jSONObject, String str) {
        try {
            invokeJSCallback(str, new TJDataFetcher().a(jSONObject.getJSONArray("values")));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void flushBacklogMessageQueue() {
        while (true) {
            Pair pair = (Pair) this.f.poll();
            if (pair == null) {
                return;
            } else {
                onDispatchMethod((String) pair.first, (JSONObject) pair.second);
            }
        }
    }

    public void flushMessageQueue() {
        TJWebViewJSInterface tJWebViewJSInterface = this.a;
        if (tJWebViewJSInterface == null) {
            return;
        }
        tJWebViewJSInterface.flushMessageQueue();
    }

    public void getCachedAssets(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() != null) {
            invokeJSCallback(str, TapjoyCache.getInstance().cachedAssetsToJSON());
        } else {
            invokeJSCallback(str, "");
        }
    }

    public void getKeyValue(JSONObject jSONObject, String str) {
        try {
            invokeJSCallback(str, new TJKeyValueStorage(this.f2684b.getContext()).getValue(jSONObject.getString(SDKConstants.PARAM_KEY)));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void getOrientation(JSONObject jSONObject, String str) {
        invokeJSCallback(str, this.f2684b.getOrientation());
    }

    public void getSplitViewURL(JSONObject jSONObject, String str) {
        TapjoyUtil.runOnMainThread(new e(this, str));
    }

    public void getTextZoom(JSONObject jSONObject, String str) {
        TapjoyUtil.runOnMainThread(new i(this, str));
    }

    public void getVolume(JSONObject jSONObject, String str) {
        Map<String, Object> volumeArgs = this.f2684b.getVolumeArgs();
        if (volumeArgs != null) {
            invokeJSCallback(str, volumeArgs);
        } else {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void hasSplitView(JSONObject jSONObject, String str) {
        TapjoyUtil.runOnMainThread(new o(this, str));
    }

    public void invokeJSAdunitMethod(String str, Object... objArr) {
        ArrayList<?> arrayList = new ArrayList<>(Arrays.asList(objArr));
        TJWebViewJSInterface tJWebViewJSInterface = this.a;
        if (tJWebViewJSInterface != null) {
            tJWebViewJSInterface.callback(arrayList, str, (String) null);
        }
    }

    public void invokeJSCallback(String str, Object... objArr) {
        if (TextUtils.isEmpty(str)) {
            TapjoyLog.d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        ArrayList<?> arrayList = new ArrayList<>(Arrays.asList(objArr));
        TJWebViewJSInterface tJWebViewJSInterface = this.a;
        if (tJWebViewJSInterface != null) {
            tJWebViewJSInterface.callback(arrayList, "", str);
        }
    }

    public void isNetworkAvailable(JSONObject jSONObject, String str) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f2684b.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            invokeJSCallback(str, Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()));
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void log(JSONObject jSONObject, String str) {
        try {
            TapjoyLog.d("TJAdUnitJSBridge", "Logging message=" + jSONObject.getString("message"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void nativeEval(JSONObject jSONObject, String str) {
        TapjoyUtil.runOnMainThread(new m(this, jSONObject, str));
    }

    public void notifyOrientationChanged(String str, int i, int i2) {
        HashMap map = new HashMap();
        map.put("orientation", str);
        map.put("width", Integer.valueOf(i));
        map.put("height", Integer.valueOf(i2));
        invokeJSAdunitMethod(TJAdUnitConstants.String.ORIENTATION_CHANGED_EVENT, map);
    }

    @Override // com.tapjoy.TJWebViewJSInterfaceListener
    public void onDispatchMethod(String str, JSONObject jSONObject) {
        if (!this.e) {
            TapjoyLog.d("TJAdUnitJSBridge", "Bridge currently disabled. Adding " + str + " to message queue");
            this.f.add(new Pair(str, jSONObject));
            return;
        }
        String strOptString = null;
        try {
            strOptString = jSONObject.optString(TJAdUnitConstants.String.CALLBACK_ID, null);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            Method method = TJAdUnitJSBridge.class.getMethod(str, JSONObject.class, String.class);
            TapjoyLog.d("TJAdUnitJSBridge", "Dispatching method: " + method + " with data=" + jSONObject2 + "; callbackID=" + strOptString);
            if (this.a == null) {
                return;
            }
            method.invoke(this, jSONObject2, strOptString);
        } catch (Exception e) {
            e.printStackTrace();
            invokeJSCallback(strOptString, Boolean.FALSE);
        }
    }

    public void onVideoCompletion() {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_COMPLETE_EVENT);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoError(String str) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_ERROR_EVENT);
        map.put("error", str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoInfo(String str) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_INFO_EVENT);
        map.put(TJAdUnitConstants.String.VIDEO_INFO, str);
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoPaused(int i) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PAUSE_EVENT);
        map.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoProgress(int i) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_PROGRESS_EVENT);
        map.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoReady(int i, int i2, int i3) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_READY_EVENT);
        map.put(TJAdUnitConstants.String.VIDEO_DURATION, Integer.valueOf(i));
        map.put(TJAdUnitConstants.String.VIDEO_WIDTH, Integer.valueOf(i2));
        map.put(TJAdUnitConstants.String.VIDEO_HEIGHT, Integer.valueOf(i3));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVideoStarted(int i) {
        HashMap map = new HashMap();
        map.put(TJAdUnitConstants.String.VIDEO_EVENT_NAME, TJAdUnitConstants.String.VIDEO_START_EVENT);
        map.put(TJAdUnitConstants.String.VIDEO_CURRENT_TIME, Integer.valueOf(i));
        invokeJSAdunitMethod(TJAdUnitConstants.String.VIDEO_EVENT, map);
    }

    public void onVolumeChanged() {
        invokeJSAdunitMethod(TJAdUnitConstants.String.VOLUME_CHANGED, this.f2684b.getVolumeArgs());
    }

    public void openApp(JSONObject jSONObject, String str) {
        try {
            Context context = this.f2684b.getContext();
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(jSONObject.getString(TJAdUnitConstants.String.BUNDLE)));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void pause() {
        try {
            invokeJSAdunitMethod("onVisibilityStateChange", TJAdUnitConstants.String.HIDDEN);
        } catch (Exception e) {
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void pauseVideo(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(this.f2684b.pauseVideo()));
    }

    public void playVideo(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(this.f2684b.playVideo()));
    }

    public void present(JSONObject jSONObject, String str) {
        try {
            Boolean boolValueOf = Boolean.FALSE;
            Boolean boolValueOf2 = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.VISIBLE));
            try {
                boolValueOf = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.TRANSPARENT));
            } catch (Exception unused) {
            }
            try {
                this.customClose = Boolean.valueOf(jSONObject.getString(TJAdUnitConstants.String.CUSTOM_CLOSE)).booleanValue();
            } catch (Exception unused2) {
            }
            final boolean zBooleanValue = boolValueOf2.booleanValue();
            final boolean zBooleanValue2 = boolValueOf.booleanValue();
            final WebView webView = this.f2684b.getWebView();
            TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.-$$Lambda$TJAdUnitJSBridge$Nc78v6hZwjjbBOs9zlBJ-r5KLaI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(webView, zBooleanValue, zBooleanValue2);
                }
            });
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void removeAssetFromCache(JSONObject jSONObject, String str) {
        try {
            String string = jSONObject.getString("url");
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(string)));
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void resume() {
        try {
            invokeJSAdunitMethod("onVisibilityStateChange", TJAdUnitConstants.String.VISIBLE);
        } catch (Exception e) {
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void sendMessageToApp(JSONObject jSONObject, String str) {
        try {
            Object obj = g;
            if (obj != null) {
                obj.getClass().getDeclaredMethod("onMessage", String.class, Object.class).invoke(g, "message", jSONObject.get("message"));
                invokeJSCallback(str, Boolean.TRUE);
            }
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void setAllowRedirect(JSONObject jSONObject, String str) {
        boolean z;
        try {
            z = jSONObject.getBoolean("enabled");
        } catch (Exception unused) {
            z = true;
        }
        this.allowRedirect = z;
        invokeJSCallback(str, Boolean.TRUE);
    }

    public void setBackgroundColor(JSONObject jSONObject, String str) {
        try {
            this.f2684b.setBackgroundColor(jSONObject.getString("backgroundColor"), new j(this, str));
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setCloseButtonClickable(JSONObject jSONObject, String str) {
        try {
            this.f2684b.setCloseButtonClickable(jSONObject.optBoolean(TJAdUnitConstants.String.CLICKABLE));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setCloseButtonVisible(JSONObject jSONObject, String str) {
        try {
            this.f2684b.setCloseButtonVisible(jSONObject.getBoolean(TJAdUnitConstants.String.VISIBLE));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setEnabled(boolean z) {
        this.e = z;
        if (z) {
            flushBacklogMessageQueue();
        }
    }

    public void setEventPreloadLimit(JSONObject jSONObject, String str) {
        if (TapjoyCache.getInstance() == null) {
            invokeJSCallback(str, Boolean.FALSE);
            return;
        }
        try {
            TJPlacementManager.setCachedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_CACHE_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setKeyValue(JSONObject jSONObject, String str) {
        try {
            new TJKeyValueStorage(this.f2684b.getContext()).setValue(jSONObject.getString(SDKConstants.PARAM_KEY), jSONObject.get("value"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            TapjoyLog.e("TJAdUnitJSBridge", "Exception: " + e.toString());
        }
    }

    public void setLoggingLevel(JSONObject jSONObject, String str) {
        try {
            TapjoyAppSettings.getInstance().saveLoggingLevel(String.valueOf(jSONObject.getString(TJAdUnitConstants.String.LOGGING_LEVEL)));
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "setLoggingLevel exception " + e.getLocalizedMessage());
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setNavigationEventBlocker(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void setOrientation(JSONObject jSONObject, String str) {
        int i;
        try {
            String string = jSONObject.getString("orientation");
            if (string.equals(TJAdUnitConstants.String.LANDSCAPE) || string.equals(TJAdUnitConstants.String.LANDSCAPE_LEFT)) {
                i = 8;
            } else {
                i = string.equals(TJAdUnitConstants.String.LANDSCAPE_RIGHT) ? 0 : 1;
            }
            invokeJSCallback(str, Boolean.valueOf(this.f2684b.setOrientation(i)));
        } catch (Exception unused) {
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setPrerenderLimit(JSONObject jSONObject, String str) {
        try {
            TJPlacementManager.setPreRenderedPlacementLimit(jSONObject.getInt(TJAdUnitConstants.String.TJC_PLACEMENT_PRE_RENDERED_LIMIT));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception unused) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setScrollable(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.FALSE);
    }

    public void setSpinnerVisible(JSONObject jSONObject, String str) {
        try {
            boolean z = jSONObject.getBoolean(TJAdUnitConstants.String.VISIBLE);
            String strOptString = jSONObject.optString("title");
            String strOptString2 = jSONObject.optString("message");
            Context context = this.f2684b.getContext();
            if (context != null) {
                TapjoyUtil.runOnMainThread(new n(this, z, context, strOptString, strOptString2, str));
            } else {
                TapjoyLog.d("TJAdUnitJSBridge", "Cannot setSpinnerVisible -- Context is null");
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setTextZoom(JSONObject jSONObject, String str) {
        try {
            float f = (float) jSONObject.getDouble(TJAdUnitConstants.String.TEXT_ZOOM);
            this.f2684b.setTextZoom(f);
            invokeJSAdunitMethod(str, Float.valueOf(f));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVideoMargins(JSONObject jSONObject, String str) {
        try {
            invokeJSCallback(str, Boolean.valueOf(this.f2684b.setVideoMargins((float) jSONObject.optDouble("left", 0.0d), (float) jSONObject.optDouble("top", 0.0d), (float) jSONObject.optDouble("right", 0.0d), (float) jSONObject.optDouble(TJAdUnitConstants.String.BOTTOM, 0.0d))));
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void setVideoMute(JSONObject jSONObject, String str) {
        try {
            this.f2684b.muteVideo(jSONObject.getBoolean("enabled"));
            invokeJSCallback(str, Boolean.TRUE);
        } catch (JSONException unused) {
            TapjoyLog.d("TJAdUnitJSBridge", "Failed to parse 'enabled' from json params.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void setupSdkBeacons(JSONObject jSONObject, String str) {
        TapjoyLog.d("TJAdUnitJSBridge", "setupSdkBeacons_method: " + jSONObject);
        try {
            this.f2684b.setupSdkBeacons(new s6(jSONObject.getString("url"), jSONObject.getJSONObject("params"), jSONObject.getJSONObject(TJAdUnitConstants.String.BEACON_PATH_MAP)));
            HashMap map = new HashMap();
            map.put("status", "true");
            if (i8.e) {
                map.put("sdk_beacon_id", this.f2684b.getBeaconId());
            }
            invokeJSCallback(str, map);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void shouldClose(JSONObject jSONObject, String str) {
        try {
            this.f2684b.shouldClose(Boolean.valueOf(jSONObject.getString("close")).booleanValue());
            invokeJSCallback(str, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(str, Boolean.FALSE);
            this.f2684b.shouldClose(true);
            e.printStackTrace();
        }
        this.closeRequested = false;
    }

    public void triggerEvent(JSONObject jSONObject, String str) {
        if (this.f2684b != null) {
            try {
                String string = jSONObject.getString("eventName");
                if (string.equals("start")) {
                    this.f2684b.fireOnVideoStart();
                    return;
                }
                if (string.equals("complete")) {
                    this.f2684b.fireOnVideoComplete();
                } else if (string.equals("error")) {
                    this.f2684b.fireOnVideoError("Error while trying to play video.");
                } else if (string.equals("click")) {
                    this.f2684b.fireOnClick();
                }
            } catch (Exception unused) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
            }
        }
    }

    public void unsetOrientation(JSONObject jSONObject, String str) {
        invokeJSCallback(str, Boolean.valueOf(this.f2684b.unsetOrientation()));
    }

    public void cacheAsset(JSONObject jSONObject, String str) {
        String string;
        Long lValueOf = 0L;
        try {
            String string2 = jSONObject.getString("url");
            try {
                string = jSONObject.getString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID);
            } catch (Exception unused) {
                string = "";
            }
            try {
                lValueOf = Long.valueOf(jSONObject.getLong(TapjoyConstants.TJC_TIME_TO_LIVE));
            } catch (Exception unused2) {
            }
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(str, TapjoyCache.getInstance().cacheAssetFromURL(string2, string, lValueOf.longValue()));
            } else {
                invokeJSCallback(str, Boolean.FALSE);
            }
        } catch (Exception unused3) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(str, Boolean.FALSE);
        }
    }

    public void contentError(JSONObject jSONObject, String str) {
        int i;
        String string;
        try {
            i = jSONObject.getInt("code");
        } catch (JSONException e) {
            TapjoyLog.e("TJAdUnitJSBridge", e.getLocalizedMessage());
            i = -1;
        }
        try {
            string = jSONObject.getString("message");
        } catch (JSONException e2) {
            TapjoyLog.e("TJAdUnitJSBridge", e2.getLocalizedMessage());
            string = "Unknown Content Error";
        }
        TJJSBridgeDelegate tJJSBridgeDelegate = this.f2684b;
        if (tJJSBridgeDelegate == null) {
            invokeJSCallback(str, Boolean.FALSE);
        } else {
            tJJSBridgeDelegate.fireContentError(new TJError(i, string));
            invokeJSCallback(str, Boolean.TRUE);
        }
    }

    public void invokeJSAdunitMethod(String str, Map<String, Object> map) {
        TJWebViewJSInterface tJWebViewJSInterface = this.a;
        if (tJWebViewJSInterface != null) {
            tJWebViewJSInterface.callback(map, str, (String) null);
        }
    }

    public void invokeJSCallback(String str, Map<String, Object> map) {
        this.a.callback(map, "", str);
    }
}
