package com.tapjoy.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p9 {
    public final double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f2799b;
    public final double c;
    public final double d;
    public final float e;

    public p9(JSONObject jSONObject) {
        this.a = jSONObject.optDouble("width", 0.0d);
        this.f2799b = jSONObject.optDouble("height", 0.0d);
        this.c = jSONObject.optDouble("left", 0.0d);
        this.d = jSONObject.optDouble("top", 0.0d);
        this.e = (float) jSONObject.optDouble("cornerRadius", 0.0d);
    }
}
