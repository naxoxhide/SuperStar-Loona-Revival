package com.bytedance.sdk.openadsdk.core.j0.b;

import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(q qVar) {
        if (t.i(qVar)) {
            com.bytedance.sdk.openadsdk.d.c.b(qVar, "playable_preload", "preload_start", (JSONObject) null);
        }
    }

    public static void a(q qVar, long j, long j2) {
        if (qVar != null) {
            if (t.h(qVar) || t.i(qVar)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loadzip_success_time", j);
                    jSONObject.put("unzip_success_time", j2);
                } catch (JSONException e) {
                    m.b("PlayableEvent", "onSuccess json error", e);
                }
                com.bytedance.sdk.openadsdk.d.c.b(qVar, "playable_preload", "preload_success", jSONObject);
            }
        }
    }

    public static void a(q qVar, int i, String str) {
        if (qVar != null) {
            if (t.h(qVar) || t.i(qVar)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i);
                    jSONObject.put("error_reason", str);
                } catch (JSONException e) {
                    m.b("PlayableEvent", "onFail json error", e);
                }
                com.bytedance.sdk.openadsdk.d.c.b(qVar, "playable_preload", "preload_fail", jSONObject);
            }
        }
    }
}
