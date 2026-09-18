package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class s6 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2811b = new HashMap();
    public final String c;
    public final String d;
    public final TapjoyURLConnection e;
    public boolean f;

    public s6(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.a = str;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f2811b.put(next, jSONObject.optString(next));
        }
        this.c = jSONObject2.optString(TJAdUnitConstants.String.BEACON_SHOW_PATH);
        this.d = jSONObject2.optString("error");
        this.e = new TapjoyURLConnection();
    }
}
