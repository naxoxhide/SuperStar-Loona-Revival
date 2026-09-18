package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: LoadVideoErrorModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f757b;
    private long c;
    private int d;
    private String e;
    private String f;

    public void a(long j) {
        this.c = j;
    }

    public void b(long j) {
        this.f757b = j;
    }

    public void c(String str) {
        this.a = str;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(String str) {
        this.f = str;
    }

    public void a(String str) {
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.a);
            jSONObject.put("preload_size", this.f757b);
            jSONObject.put("load_time", this.c);
            jSONObject.put("error_code", this.d);
            jSONObject.put("error_message", this.e);
            jSONObject.put("error_message_server", this.f);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("LoadVideoErrorModel", th.getMessage());
        }
    }
}
