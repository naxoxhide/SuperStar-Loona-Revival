package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.h0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements b0 {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f866b;
    public t c;
    public x d;
    public y e;
    public c0 f;
    public e0 g;

    public d0 a() {
        return this.f;
    }

    public e0 b() {
        return this.g;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        h0.a(jSONObject, "id", this.a);
        h0.a(jSONObject, "spotId", this.f866b);
        h0.a(jSONObject, "display", this.c);
        h0.a(jSONObject, "monitor", this.d);
        h0.a(jSONObject, "native", this.e);
        h0.a(jSONObject, "video", this.f);
        h0.a(jSONObject, "viewability", this.g);
        return jSONObject.toString();
    }
}
