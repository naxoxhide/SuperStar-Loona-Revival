package com.bytedance.sdk.openadsdk.m.g;

import org.json.JSONObject;

/* JADX INFO: compiled from: VideoControllerDataModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f795b;
    public boolean c;
    public boolean d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.m.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoControllerDataModel.java */
    public interface InterfaceC0241a {
        a a();
    }

    public a a(boolean z) {
        this.d = z;
        return this;
    }

    public a b(boolean z) {
        this.a = z;
        return this;
    }

    public a c(boolean z) {
        this.c = z;
        return this;
    }

    public a d(boolean z) {
        this.f795b = z;
        return this;
    }

    public a a(long j) {
        this.g = j;
        return this;
    }

    public a b(long j) {
        this.e = j;
        return this;
    }

    public a c(long j) {
        this.f = j;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.a);
            jSONObject.put("isFromVideoDetailPage", this.f795b);
            jSONObject.put("isFromDetailPage", this.c);
            jSONObject.put("duration", this.e);
            jSONObject.put("totalPlayDuration", this.f);
            jSONObject.put("currentPlayPosition", this.g);
            jSONObject.put("isAutoPlay", this.d);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.b(jSONObject.optBoolean("isCompleted"));
        aVar.d(jSONObject.optBoolean("isFromVideoDetailPage"));
        aVar.c(jSONObject.optBoolean("isFromDetailPage"));
        aVar.b(jSONObject.optLong("duration"));
        aVar.c(jSONObject.optLong("totalPlayDuration"));
        aVar.a(jSONObject.optLong("currentPlayPosition"));
        aVar.a(jSONObject.optBoolean("isAutoPlay"));
        return aVar;
    }
}
