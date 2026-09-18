package com.bytedance.sdk.openadsdk.l.c;

import android.os.SystemClock;
import android.text.TextUtils;
import b.b.a.a.f.a.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int j = -10;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f787b;
    private long c;
    private long d;
    private int e;
    private int f;
    private boolean g = false;
    private String h;
    private int i;

    public c a(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.e = bytes.length;
        }
        return this;
    }

    public c b(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.f = bytes.length;
        }
        return this;
    }

    public void c() {
        this.f787b = SystemClock.elapsedRealtime();
    }

    public c d(String str) {
        this.a = str;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.a);
            jSONObject.put("duration", this.c);
            jSONObject.put("request_size", this.e);
            jSONObject.put("response_size", this.f);
            jSONObject.put("result", this.g ? 1 : 0);
            if (!this.g && !TextUtils.isEmpty(this.h)) {
                jSONObject.put("msg", this.h);
            }
            jSONObject.put("conn_type", a0.f(o.a()));
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, a0.h());
            long j2 = this.d;
            if (j2 > 0) {
                jSONObject.put("net_duration", j2);
            }
            jSONObject.put("code", this.i);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public c c(String str) {
        this.h = str;
        return this;
    }

    public c a(m mVar) {
        byte[] bArr;
        if (mVar != null) {
            if (mVar.d == m.a.STRING_TYPE && !TextUtils.isEmpty(mVar.a())) {
                this.e = mVar.a().getBytes().length;
            }
            if (mVar.d == m.a.BYTE_ARRAY_TYPE && (bArr = mVar.c) != null) {
                this.e = bArr.length;
            }
        }
        return this;
    }

    public void b() {
        this.c = SystemClock.elapsedRealtime() - this.f787b;
        com.bytedance.sdk.openadsdk.l.b.a(this);
    }

    public c a(int i) {
        this.i = i;
        return this;
    }

    public void a() {
        this.d = SystemClock.elapsedRealtime() - this.f787b;
    }

    public c a(boolean z) {
        this.g = z;
        return this;
    }
}
