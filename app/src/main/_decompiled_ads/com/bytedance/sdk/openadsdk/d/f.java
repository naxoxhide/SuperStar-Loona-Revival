package com.bytedance.sdk.openadsdk.d;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEventV3.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends a {
    public static final SimpleDateFormat r = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public f(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.d.a
    public JSONObject e() {
        return this.f715b;
    }
}
