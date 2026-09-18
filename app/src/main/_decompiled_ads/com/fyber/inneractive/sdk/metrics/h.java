package com.fyber.inneractive.sdk.metrics;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h implements g {
    public final Map<a, Long> a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<a, Long> f956b = new LinkedHashMap();
    public long c;
    public long d;

    public static class a {
        public final String a = UUID.randomUUID().toString();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f957b;

        public a(String str) {
            this.f957b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            return this.a.equals(((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public void a() {
        this.d = System.currentTimeMillis();
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public void b() {
        this.c = System.currentTimeMillis();
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public void a(String str) {
        this.f956b.put(new a(str), Long.valueOf(System.currentTimeMillis() - this.d));
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public void b(String str) {
        this.a.put(new a(str), Long.valueOf(System.currentTimeMillis() - this.c));
    }

    public static JSONArray a(Map<a, Long> map) {
        JSONArray jSONArray = new JSONArray();
        for (a aVar : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("outcome", aVar.f957b);
                jSONObject.putOpt("time", map.get(aVar));
                jSONObject.putOpt("idx", Integer.valueOf(jSONArray.length()));
            } catch (JSONException unused) {
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public void a(com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest, s sVar) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArrayA = a(this.f956b);
        try {
            jSONObject.put("adl", jSONArrayA);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "adl", jSONArrayA);
        }
        JSONArray jSONArrayA2 = a(this.a);
        try {
            jSONObject.put("adml", jSONArrayA2);
        } catch (Exception unused2) {
            IAlog.e("Got exception adding param to json object: %s, %s", "adml", jSONArrayA2);
        }
        if (!TextUtils.isEmpty(null)) {
            try {
                jSONObject.put("dns_failed", (Object) null);
            } catch (Exception unused3) {
                IAlog.e("Got exception adding param to json object: %s, %s", "dns_failed", null);
            }
        }
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(r.SDK_BIDDING_METRICS, inneractiveAdRequest, eVar, sVar.c());
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }
}
