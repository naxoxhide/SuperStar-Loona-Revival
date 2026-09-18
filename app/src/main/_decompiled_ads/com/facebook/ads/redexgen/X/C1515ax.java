package com.facebook.ads.redexgen.X;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1515ax implements InterfaceC05780j {
    public final /* synthetic */ YA A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C1515ax(JSONObject jSONObject, YA ya, String str) {
        this.A02 = jSONObject;
        this.A00 = ya;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05780j
    public final String A6N() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05780j
    public final Collection<String> A6g() {
        return C05790k.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05780j
    public final EnumC05770i A77() {
        return C05790k.A00(this.A02);
    }
}
