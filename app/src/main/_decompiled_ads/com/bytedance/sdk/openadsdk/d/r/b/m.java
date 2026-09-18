package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: PlayBufferModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements c {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f760b;
    public long c;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.c = j;
    }

    public void a(int i) {
        this.f760b = i;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.a);
            jSONObject.put("buffers_count", this.f760b);
            jSONObject.put("total_duration", this.c);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("PlayBufferModel", th.getMessage());
        }
    }
}
