package com.bytedance.sdk.openadsdk.core.f0;

import com.facebook.internal.NativeProtocol;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static int g = 1;
    private static int h = 5;
    private String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f574b = "";
    private String c = "";
    private double d = -1.0d;
    private int e = -1;
    private int f;

    public String a() {
        return this.f574b;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public double f() {
        return this.d;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, a());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, b());
            jSONObject.put("comment_num", c());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, d());
            jSONObject.put(CampaignEx.JSON_KEY_PACKAGE_NAME, e());
            jSONObject.put("score", f());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.m.b(e.toString());
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f574b = str;
    }

    public void b(int i) {
        if (i <= 0) {
            this.e = -1;
        } else {
            this.e = i;
        }
    }

    public int c() {
        return this.e;
    }

    public void a(double d) {
        if (d >= g && d <= h) {
            this.d = d;
        } else {
            this.d = -1.0d;
        }
    }

    public int b() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }
}
