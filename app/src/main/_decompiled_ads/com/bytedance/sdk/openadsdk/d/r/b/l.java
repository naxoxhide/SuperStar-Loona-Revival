package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: LoadVideoSuccessModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f759b;
    private long c;
    private long d;

    public void a(String str) {
        this.a = str;
    }

    public void b(long j) {
        this.d = j;
    }

    public void c(long j) {
        this.f759b = j;
    }

    public void a(long j) {
        this.c = j;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.a);
            jSONObject.put("preload_size", this.f759b);
            jSONObject.put("load_time", this.c);
            jSONObject.put("local_cache", this.d);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("LoadVideoSuccessModel", th.getMessage());
        }
    }
}
