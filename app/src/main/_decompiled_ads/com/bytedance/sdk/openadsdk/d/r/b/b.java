package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: EndcardSkipModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f750b;
    private int c;
    private int d;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.f750b = j;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.a);
            jSONObject.put("total_duration", this.f750b);
            jSONObject.put("vbtt_skip_type", this.c);
            jSONObject.put("skip_reason", this.d);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("EndcardSkipModel", th.getMessage());
        }
    }
}
