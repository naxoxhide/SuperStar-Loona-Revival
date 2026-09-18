package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: FeedOverModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f753b;
    private int c = 0;

    public void a(long j) {
        this.f753b = j;
    }

    public void b(long j) {
        this.a = j;
    }

    public void a(int i) {
        this.c = i;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.a);
            jSONObject.put("buffers_time", this.f753b);
            jSONObject.put("video_backup", this.c);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("FeedOverModel", th.getMessage());
        }
    }
}
