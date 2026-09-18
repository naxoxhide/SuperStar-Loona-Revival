package com.mbridge.msdk.c;

import org.json.JSONObject;

/* JADX INFO: compiled from: BCP.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1903b;
    private int c;
    private int d = 0;
    private int e = 1;
    private int f = 0;
    private int g = 0;
    private int h = 0;

    public final int a() {
        return this.h;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.f1903b;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    public final int h() {
        return this.g;
    }

    public static a a(String str) {
        Exception e;
        a aVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.a = jSONObject.optString("http_domain", com.mbridge.msdk.foundation.same.net.f.d.a().f2147b);
                aVar.f1903b = jSONObject.optString("tcp_domain", com.mbridge.msdk.foundation.same.net.f.d.a().i);
                aVar.c = jSONObject.optInt("tcp_port", com.mbridge.msdk.foundation.same.net.f.d.a().m);
                aVar.d = jSONObject.optInt("type", 0);
                int i = 1;
                int iOptInt = jSONObject.optInt("batch_size", 1);
                if (iOptInt >= 1) {
                    i = iOptInt;
                }
                aVar.e = i;
                aVar.f = jSONObject.optInt("duration", 0);
                aVar.g = jSONObject.optInt("disable", 0);
                aVar.h = jSONObject.optInt("e_t_l", 0);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            aVar = null;
        }
        return aVar;
    }
}
