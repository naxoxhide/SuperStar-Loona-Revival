package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: LoadVideoStartModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f758b;

    public k(String str, long j) {
        this.a = str;
        this.f758b = j;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.a);
            jSONObject.put("preload_size", this.f758b);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("LoadVideoStartModel", th.getMessage());
        }
    }
}
