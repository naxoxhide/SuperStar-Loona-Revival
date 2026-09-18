package com.bytedance.sdk.openadsdk.q.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: PAGAdViewInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f817b;
    private final float c;

    public a(int i, int i2, float f) {
        this.a = i;
        this.f817b = i2;
        this.c = f;
    }

    public static JSONObject a(a aVar) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", aVar.a);
        jSONObject.put("height", aVar.f817b);
        jSONObject.put("alpha", aVar.c);
        return jSONObject;
    }
}
