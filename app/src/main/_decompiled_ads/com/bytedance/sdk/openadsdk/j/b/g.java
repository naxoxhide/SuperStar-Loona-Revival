package com.bytedance.sdk.openadsdk.j.b;

import b.b.a.a.e.r;
import com.bytedance.sdk.openadsdk.core.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: SendCommerceLandingPageMeta.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends b.b.a.a.e.e<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f779b;

    public g(x xVar) {
        this.f779b = xVar;
    }

    public static void a(r rVar, x xVar) {
        rVar.a("commonConvert", new g(xVar));
    }

    @Override // b.b.a.a.e.e
    public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        this.f779b.g(jSONObject);
        return null;
    }
}
