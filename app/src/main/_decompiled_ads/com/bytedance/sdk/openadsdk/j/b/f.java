package com.bytedance.sdk.openadsdk.j.b;

import b.b.a.a.e.r;
import com.bytedance.sdk.openadsdk.core.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayableEndCardOverlayMethod.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends b.b.a.a.e.e<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x f778b;

    public f(x xVar) {
        this.f778b = xVar;
    }

    public static void a(r rVar, x xVar) {
        rVar.a("overlayRenderFinish", new f(xVar));
    }

    @Override // b.b.a.a.e.e
    public JSONObject a(JSONObject jSONObject, b.b.a.a.e.f fVar) throws Exception {
        this.f778b.r();
        return null;
    }
}
