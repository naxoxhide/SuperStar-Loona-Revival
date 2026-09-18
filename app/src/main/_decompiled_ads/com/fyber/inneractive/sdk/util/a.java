package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public InneractiveAdSpot a;
    public boolean c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1330b = false;
    public long d = 0;
    public long e = 0;
    public long f = 0;

    public void a(boolean z) {
        this.c = z;
        if (this.f1330b) {
            Object[] objArr = new Object[2];
            objArr[0] = "AdExperienceLatency: ";
            objArr[1] = z ? "skip" : "close";
            IAlog.a("%s%s timer could not start. Timer is in action!", objArr);
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "AdExperienceLatency: ";
        objArr2[1] = z ? "skip" : "close";
        IAlog.a("%s%s timer started", objArr2);
        this.d = System.currentTimeMillis();
        this.f1330b = true;
    }

    public void b() {
        if (!this.f1330b || this.e <= 0) {
            return;
        }
        this.f += System.currentTimeMillis() - this.e;
        this.e = 0L;
    }

    public void a() {
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.f1330b = false;
    }

    public void a(String str) {
        com.fyber.inneractive.sdk.config.global.s sVar;
        if (this.f1330b) {
            String strA = w.a(this.d, this.f);
            InneractiveAdSpot inneractiveAdSpot = this.a;
            com.fyber.inneractive.sdk.flow.q adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(this.c ? com.fyber.inneractive.sdk.network.r.USER_SKIP_ACTION_LATENCY : com.fyber.inneractive.sdk.network.r.USER_CLOSE_ACTION_LATENCY, adContent != null ? adContent.a : null, adContent != null ? adContent.d() : null, (adContent == null || (sVar = adContent.c) == null) ? null : sVar.c());
            JSONObject jSONObject = new JSONObject();
            String str2 = this.c ? "skip_action_latency" : "close_action_latency";
            try {
                jSONObject.put(str2, strA);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", str2, strA);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("origin", str);
                } catch (Exception unused2) {
                    IAlog.e("Got exception adding param to json object: %s, %s", "origin", str);
                }
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
            a();
        }
    }
}
