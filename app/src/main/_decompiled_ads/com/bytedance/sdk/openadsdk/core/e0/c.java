package com.bytedance.sdk.openadsdk.core.e0;

import b.b.a.a.j.d.d;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrequentCallEventHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: compiled from: FrequentCallEventHelper.java */
    static class a extends b.b.a.a.j.c.a {
        a() {
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            m.d("uploadFrequentEvent", iOException.getMessage());
        }
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void b(String str, long j) {
        JSONObject jSONObjectA = a(str, j);
        d dVarD = com.bytedance.sdk.openadsdk.n.c.b().d().d();
        dVarD.b(a0.j("/api/ad/union/sdk/stats/"));
        dVarD.d(jSONObjectA.toString());
        dVarD.a(new a());
    }
}
