package com.bytedance.sdk.openadsdk.l.c;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.l.c.b;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogStatsBase.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<T extends b> implements a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f786b;
    private String c;
    private String g;
    private String i;
    private String j;
    private String k;
    private String l;
    private String d = BuildConfig.VERSION_NAME;
    private long e = System.currentTimeMillis() / 1000;
    private int f = 0;
    private int h = 0;

    @JProtect
    private JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, a0.i());
            jSONObject.put("ua", a0.t());
            jSONObject.put("gaid", b.c.a.a.a.b.a.b().a());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static b<b> o() {
        return new b<>();
    }

    private T p() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.l.c.a
    @JProtect
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_sdk_version", l());
            jSONObject.put(TapjoyConstants.TJC_APP_VERSION_NAME, a0.s());
            jSONObject.put("timestamp", m());
            jSONObject.put("conn_type", p.c(o.a()));
            jSONObject.put(PangleConstants.APP_ID, TextUtils.isEmpty(h.a().d()) ? "" : h.a().d());
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, d());
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put("type", n());
            }
            jSONObject.put("error_code", e());
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("error_msg", f());
            }
            if (!TextUtils.isEmpty(j())) {
                jSONObject.put("rit", j());
            }
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, c());
            }
            if (b() > 0) {
                jSONObject.put("adtype", b());
            }
            if (!TextUtils.isEmpty(i())) {
                jSONObject.put("req_id", i());
            }
            if (!TextUtils.isEmpty(h())) {
                jSONObject.put("extra", h());
            }
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("event_extra", g());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("duration", k());
            }
        } catch (Throwable th) {
            m.b("LogStatsBase", th.getMessage());
        }
        return jSONObject;
    }

    public int b() {
        return this.f;
    }

    public T c(String str) {
        this.k = str;
        return (T) p();
    }

    public T e(String str) {
        this.g = str;
        return (T) p();
    }

    public T f(String str) {
        this.f786b = str;
        return (T) p();
    }

    public String g() {
        return this.k;
    }

    public T h(String str) {
        this.a = str;
        return (T) p();
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.f786b;
    }

    public String k() {
        return this.l;
    }

    public String l() {
        return TextUtils.isEmpty(this.d) ? "" : this.d;
    }

    public long m() {
        return this.e;
    }

    public String n() {
        return this.a;
    }

    public T b(int i) {
        this.h = i;
        return (T) p();
    }

    public T g(String str) {
        this.l = str;
        return (T) p();
    }

    public String c() {
        return this.c;
    }

    public int e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String h() {
        return this.j;
    }

    public T b(String str) {
        this.i = str;
        return (T) p();
    }

    public T d(String str) {
        this.j = str;
        return (T) p();
    }

    public T a(String str) {
        this.c = str;
        return (T) p();
    }

    public T a(int i) {
        this.f = i;
        return (T) p();
    }
}
