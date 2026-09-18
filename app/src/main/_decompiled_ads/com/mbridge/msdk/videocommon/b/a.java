package com.mbridge.msdk.videocommon.b;

import org.json.JSONObject;

/* JADX INFO: compiled from: AdParams.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2652b;

    private a(String str, String str2) {
        this.a = str;
        this.f2652b = str2;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString("appId"), jSONObject.optString("placementId"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
