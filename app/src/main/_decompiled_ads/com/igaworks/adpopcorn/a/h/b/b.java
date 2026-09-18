package com.igaworks.adpopcorn.a.h.b;

import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.sql.Timestamp;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1498b = null;
    private String c = null;

    public String a() {
        return this.a;
    }

    public JSONObject a(String str) {
        String string = Long.toString(new Timestamp(new Date().getTime()).getTime());
        b(string);
        if (b() == null) {
            return null;
        }
        com.igaworks.adpopcorn.a.f.c.l = string;
        String strA = com.igaworks.adpopcorn.cores.common.c.a(b(), a() + c() + string);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MBridgeConstans.APP_KEY, this.a);
        jSONObject.put("usn", this.f1498b);
        jSONObject.put("adid", str);
        jSONObject.put("client_verify", string);
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, strA);
        return jSONObject;
    }

    public void a(String str, String str2, String str3) {
        this.a = str;
        this.f1498b = str2;
        this.c = str3;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
    }

    public String c() {
        return this.f1498b;
    }
}
