package com.tapjoy;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p {
    public final /* synthetic */ TJAdUnitJSBridge a;

    public p(TJAdUnitJSBridge tJAdUnitJSBridge) {
        this.a = tJAdUnitJSBridge;
    }

    public void execute(String str, JSONObject jSONObject) {
        TapjoyLog.d("TJAdUnitJSBridge", "ExternalEventHandler -- name=" + str + "; data=" + jSONObject.toString());
        this.a.invokeJSAdunitMethod(str, jSONObject);
    }
}
