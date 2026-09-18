package com.facebook.ads.redexgen.X;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C06121s {
    public final long A00;
    public final C8G A01;
    public final String A02;
    public final JSONObject A03;

    public C06121s(JSONObject jSONObject, C8G c8g, String str, long j) {
        this.A03 = jSONObject;
        this.A01 = c8g;
        this.A02 = str;
        this.A00 = j;
    }

    public final long A00() {
        return this.A00;
    }

    public final C8G A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final JSONObject A03() {
        return this.A03;
    }
}
