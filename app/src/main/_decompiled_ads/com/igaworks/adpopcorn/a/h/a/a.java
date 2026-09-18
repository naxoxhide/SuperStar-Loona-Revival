package com.igaworks.adpopcorn.a.h.a;

import android.content.Context;
import com.igaworks.adpopcorn.cores.common.c;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1496b = null;

    public JSONObject a(String str, String str2, String str3, String str4, String str5) throws JSONException, NoSuchAlgorithmException, InvalidKeyException {
        String strA = c.a(this.f1496b, this.a + str + str3 + str4);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MBridgeConstans.APP_KEY, this.a);
        jSONObject.put("usn", str);
        jSONObject.put("adid", str5);
        jSONObject.put("client_verify", str3);
        jSONObject.put(InAppPurchaseMetaData.KEY_SIGNATURE, strA);
        jSONObject.put("reward_key", str4);
        return jSONObject;
    }

    public void a(String str, String str2, Context context) {
        this.a = str;
        this.f1496b = str2;
    }
}
