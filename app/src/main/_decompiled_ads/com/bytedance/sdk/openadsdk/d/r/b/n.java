package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: PlayErrorModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class n implements c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f761b;
    private final int c;
    private final int d;
    private final String e;

    public n(b.a.a.a.a.a.a.f.a aVar) {
        this.c = aVar.a();
        this.d = aVar.b();
        this.e = aVar.c();
    }

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.f761b = j;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.a);
            jSONObject.put("total_duration", this.f761b);
            jSONObject.put("error_code", this.c);
            jSONObject.put("extra_error_code", this.d);
            jSONObject.put("error_message", this.e);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("PlayErrorModel", th.getMessage());
        }
    }
}
