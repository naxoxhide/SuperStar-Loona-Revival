package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final String aox;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private final String f8do;

    public d(JSONObject jSONObject, n nVar) {
        this.f8do = JsonUtils.getString(jSONObject, "id", "");
        this.aox = JsonUtils.getString(jSONObject, "price", null);
    }

    public String mQ() {
        return this.f8do;
    }

    public String uQ() {
        return this.aox;
    }
}
