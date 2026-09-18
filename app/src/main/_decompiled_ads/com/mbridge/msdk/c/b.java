package com.mbridge.msdk.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: EventLibMonitorSetting.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1905b;
    private int c;
    private int d = 0;
    private int e = 1;
    private int f = 30;
    private int g = 0;
    private int h = 1;
    private int i = 0;

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f1905b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public static b a(String str) {
        Exception e;
        b bVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar = new b();
            try {
                bVar.a = jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.f.d.a().c);
                bVar.f1905b = jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.f.d.a().k);
                bVar.c = jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.f.d.a().o);
                bVar.d = jSONObject.optInt("type", 1);
                bVar.f = jSONObject.optInt("d_t", 30);
                bVar.g = jSONObject.optInt("d_a", 0);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            bVar = null;
        }
        return bVar;
    }
}
