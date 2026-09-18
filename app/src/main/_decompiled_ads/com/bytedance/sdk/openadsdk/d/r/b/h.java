package com.bytedance.sdk.openadsdk.d.r.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: FeedPlayModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements c {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f755b;
    private int c;

    public void a(long j) {
        this.f755b = j;
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
            jSONObject.put("video_start_duration", this.a);
            jSONObject.put("video_cache_size", this.f755b);
            jSONObject.put("is_auto_play", this.c);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.m.b("FeedPlayModel", th.getMessage());
        }
    }
}
