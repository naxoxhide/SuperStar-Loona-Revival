package com.bytedance.sdk.openadsdk.core.g0;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.e;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SecSdkHelperUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static boolean a = false;

    public static void a(String str) {
        if (TextUtils.isEmpty(str) || !o.d().O()) {
            return;
        }
        b.a().c(str);
    }

    public static String b() {
        if (o.d().O()) {
            return b.a().d();
        }
        return null;
    }

    public static void c() {
        if (!a && o.d().O()) {
            b.a();
            a = b.a().b();
        }
    }

    public static void d() {
        if (o.d().O()) {
            b.a().b("AdShow");
        }
    }

    public static Map<String, String> a(String str, String str2) {
        if (o.d().O()) {
            return b.a().a(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject != null && o.d().O()) {
            try {
                jSONObject.put("sec_did", b.a().c());
                String strA = e.a(jSONObject.toString());
                Map<String, String> mapA = b.a().a("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", strA != null ? strA.getBytes() : new byte[0]);
                if (mapA == null || mapA.size() <= 0) {
                    return;
                }
                for (String str : mapA.keySet()) {
                    jSONObject.put(str, mapA.get(str));
                }
                jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                jSONObject.put("pangle_m", strA);
            } catch (JSONException e) {
                m.b("SecSdkHelperUtil", e.getMessage());
            }
        }
    }

    public static String a() {
        if (o.d().O()) {
            return b.a().c();
        }
        return null;
    }
}
