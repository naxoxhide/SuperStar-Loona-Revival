package com.bytedance.sdk.openadsdk.d.r.b;

import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.d.r.b.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseEventModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<T extends c> {
    private q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f749b;
    private JSONObject c;
    private T d;
    private boolean e = false;

    public a(q qVar, String str, JSONObject jSONObject, T t) {
        this.d = null;
        this.a = qVar;
        this.f749b = str;
        this.c = jSONObject;
        this.d = t;
    }

    public JSONObject a() {
        if (this.c == null) {
            this.c = new JSONObject();
        }
        return this.c;
    }

    public T b() {
        return this.d;
    }

    public q c() {
        return this.a;
    }

    public String d() {
        return this.f749b;
    }

    public boolean e() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
