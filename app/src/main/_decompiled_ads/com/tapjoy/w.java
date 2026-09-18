package com.tapjoy;

import android.content.Context;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.tapjoy.internal.b9;
import com.tapjoy.internal.c9;
import com.tapjoy.internal.d9;
import com.tapjoy.internal.e9;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class w extends TJJSBridgeDelegate {
    public final /* synthetic */ TJOfferwallDiscoverView a;

    public w(TJOfferwallDiscoverView tJOfferwallDiscoverView) {
        this.a = tJOfferwallDiscoverView;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean fireContentError(TJError tJError) {
        super.fireContentError(tJError);
        if (this.a.c == null) {
            return true;
        }
        TapjoyUtil.runOnMainThread(new c9(this, tJError));
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final boolean fireContentReady() {
        super.fireContentReady();
        if (this.a.c == null) {
            return true;
        }
        TapjoyUtil.runOnMainThread(new b9(this));
        return true;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Context getContext() {
        return this.a.a.getContext();
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Object getData(String str, Class cls) {
        return str.equalsIgnoreCase(TJAdUnitConstants.String.HTML) ? this.a.d.response : super.getData(str, cls);
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final Map getOrientation() {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        String str = displayMetrics.widthPixels > displayMetrics.heightPixels ? TJAdUnitConstants.String.LANDSCAPE : TJAdUnitConstants.String.PORTRAIT;
        HashMap map = new HashMap();
        map.put("orientation", str);
        map.put("width", Integer.valueOf(this.a.getWidth()));
        map.put("height", Integer.valueOf(this.a.getHeight()));
        return map;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void getTextZoom(TJTaskHandler tJTaskHandler) {
        TapjoyUtil.runOnMainThread(new d9(this, tJTaskHandler));
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final WebView getWebView() {
        return this.a.a;
    }

    @Override // com.tapjoy.TJJSBridgeDelegate
    public final void setTextZoom(float f) {
        TapjoyUtil.runOnMainThread(new e9(this, f));
    }
}
