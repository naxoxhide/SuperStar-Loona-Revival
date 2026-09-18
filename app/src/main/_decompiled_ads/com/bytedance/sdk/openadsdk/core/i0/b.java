package com.bytedance.sdk.openadsdk.core.i0;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VastIcon.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    private long m;
    private long n;

    public b(int i, int i2, long j, long j2, com.bytedance.sdk.openadsdk.core.i0.m.a.c cVar, com.bytedance.sdk.openadsdk.core.i0.m.a.d dVar, String str, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list, List<com.bytedance.sdk.openadsdk.core.i0.l.c> list2, String str2) {
        super(i, i2, cVar, dVar, str, list, list2, str2);
        this.m = j;
        this.n = j2;
        this.k = "icon_click";
    }

    public static b b(JSONObject jSONObject) {
        c cVarA = c.a(jSONObject);
        if (cVarA == null) {
            return null;
        }
        return new b(cVarA.a, cVarA.f600b, jSONObject.optLong("offset", -1L), jSONObject.optLong("duration", -1L), cVarA.c, cVarA.d, cVarA.e, cVarA.f, cVarA.g, cVarA.h);
    }

    @Override // com.bytedance.sdk.openadsdk.core.i0.c
    public JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        if (jSONObjectE != null) {
            jSONObjectE.put("offset", this.m);
            jSONObjectE.put("duration", this.n);
        }
        return jSONObjectE;
    }
}
