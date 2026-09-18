package com.bytedance.sdk.openadsdk.core.f0;

import org.json.JSONObject;

/* JADX INFO: compiled from: DeepLink.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f580b;
    private int c;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.f580b;
    }

    public int c() {
        return this.c;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("u", this.a);
            jSONObject.put("ft", this.c);
            jSONObject.put("fu", this.f580b);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.f580b = str;
    }

    public void a(int i) {
        this.c = i;
    }
}
