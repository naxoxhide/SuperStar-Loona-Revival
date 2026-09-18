package com.bytedance.sdk.openadsdk.core.f0;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DspStyle.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f581b;
    private final int c;

    public l(JSONObject jSONObject) {
        this.a = jSONObject.optInt("auto_click", 0);
        this.f581b = jSONObject.optInt("close_jump_probability", 0);
        this.c = jSONObject.optInt("skip_jump_probability", 0);
    }

    public int a() {
        return this.a;
    }

    public int b() {
        int i = this.f581b;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public int c() {
        int i = this.c;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.a;
            if (i == 1) {
                jSONObject.put("auto_click", i);
            }
            int i2 = this.f581b;
            if (i2 > 0 && i2 <= 100) {
                jSONObject.put("close_jump_probability", i2);
            }
            int i3 = this.c;
            if (i3 > 0 && i3 <= 100) {
                jSONObject.put("skip_jump_probability", i3);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
