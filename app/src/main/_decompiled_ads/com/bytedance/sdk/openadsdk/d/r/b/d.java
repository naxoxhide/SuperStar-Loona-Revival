package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: FeedBreakModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements c {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f751b;
    public int c;
    public int d = 0;

    public void a(long j) {
        this.f751b = j;
    }

    public void b(long j) {
        this.a = j;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    @Override // com.bytedance.sdk.openadsdk.d.r.b.c
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.a);
            jSONObject.put("buffers_time", this.f751b);
            jSONObject.put("break_reason", this.c);
            jSONObject.put("video_backup", this.d);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("FeedBreakModel", th.getMessage());
        }
    }
}
