package com.mbridge.msdk.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HandlerH5MessageManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2464b;
    private String c;

    private b() {
        this.c = "handlerNativeResult";
        this.a = 0;
        this.f2464b = 1;
    }

    /* JADX INFO: compiled from: HandlerH5MessageManager.java */
    private static final class a {
        private static b a = new b();
    }

    public static b a() {
        return a.a;
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    String strOptString = jSONObject.optString("uniqueIdentifier");
                    String strOptString2 = jSONObject.optString("name");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                        int iOptInt = 0;
                        if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.toString())) {
                            iOptInt = jSONObjectOptJSONObject.optInt("type", 0);
                        }
                        a(this.a, "receivedMessage", obj);
                        if (strOptString.equalsIgnoreCase("reporter")) {
                            com.mbridge.msdk.mbsignalcommon.a.a.a().a(obj, strOptString2, jSONArrayOptJSONArray, iOptInt);
                            return;
                        } else {
                            if (strOptString.equalsIgnoreCase("MediaPlayer")) {
                                com.mbridge.msdk.video.bt.a.a unused = com.mbridge.msdk.video.bt.a.a.C0514a.a;
                                return;
                            }
                            return;
                        }
                    }
                    a(this.f2464b, "module or method is null", obj);
                    return;
                }
            } catch (Exception e) {
                aa.a("HandlerH5MessageManager", e.getMessage());
                a(this.f2464b, e.getMessage(), obj);
                return;
            } catch (Throwable th) {
                aa.a("HandlerH5MessageManager", th.getMessage());
                a(this.f2464b, th.getMessage(), obj);
                return;
            }
        }
        a(this.f2464b, "params is null", obj);
    }

    private void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            aa.a("HandlerH5MessageManager", e.getMessage());
        } catch (Throwable th) {
            aa.a("HandlerH5MessageManager", th.getMessage());
        }
    }
}
