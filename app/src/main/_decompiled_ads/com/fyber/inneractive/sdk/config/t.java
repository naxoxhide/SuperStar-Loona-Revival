package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.h0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class t implements h0.a {
    public Integer a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UnitDisplayType f899b;
    public Boolean c;
    public Integer d;

    @Override // com.fyber.inneractive.sdk.util.h0.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        h0.a(jSONObject, "refresh", this.a);
        h0.a(jSONObject, "unitDisplayType", this.f899b);
        h0.a(jSONObject, "close", this.c);
        h0.a(jSONObject, "hideDelay", this.d);
        return jSONObject;
    }
}
