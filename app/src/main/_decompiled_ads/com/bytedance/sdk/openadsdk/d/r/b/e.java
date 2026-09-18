package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: FeedContinueModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f752b;

    public void a(long j) {
        this.a = j;
    }

    public void b(long j) {
        this.f752b = j;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.a);
            jSONObject.put("total_duration", this.f752b);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("FeedContinueModel", th.getMessage());
        }
    }
}
