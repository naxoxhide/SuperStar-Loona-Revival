package com.bytedance.sdk.openadsdk.core.g0;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SecSdkHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.g0.a f595b;
    private String a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.g0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SecSdkHelper.java */
    private static class C0199b {
        private static final b a = new b();
    }

    public static b a() {
        return C0199b.a;
    }

    public void b(String str) {
        com.bytedance.sdk.openadsdk.core.g0.a aVar = f595b;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public void c(String str) {
        com.bytedance.sdk.openadsdk.core.g0.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = f595b) == null) {
            return;
        }
        aVar.b(str);
    }

    public String d() {
        try {
            if (!TextUtils.isEmpty(this.a)) {
                return this.a;
            }
            String strA = h.a("sdk_app_sha1", 2592000000L);
            this.a = strA;
            if (!TextUtils.isEmpty(strA)) {
                return this.a;
            }
            com.bytedance.sdk.openadsdk.core.g0.a aVar = f595b;
            if (aVar != null) {
                this.a = aVar.d();
            }
            if (a(this.a)) {
                String upperCase = this.a.toUpperCase();
                this.a = upperCase;
                h.a("sdk_app_sha1", upperCase);
                return this.a;
            }
            String strA2 = com.bytedance.sdk.component.utils.c.a(o.a());
            this.a = strA2;
            if (!a(strA2)) {
                return "";
            }
            String upperCase2 = this.a.toUpperCase();
            this.a = upperCase2;
            h.a("sdk_app_sha1", upperCase2);
            return this.a;
        } catch (Exception unused) {
            return "";
        }
    }

    private b() {
        this.a = null;
        f595b = new com.bytedance.sdk.openadsdk.core.g0.a();
    }

    private boolean a(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(CertificateUtil.DELIMITER)) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        com.bytedance.sdk.openadsdk.core.g0.a aVar = f595b;
        if (aVar == null) {
            return false;
        }
        return aVar.g();
    }

    public String c() {
        String strC;
        com.bytedance.sdk.openadsdk.core.g0.a aVar = f595b;
        return (aVar == null || (strC = aVar.c()) == null) ? "" : strC;
    }

    public Map<String, String> a(String str, byte[] bArr) {
        com.bytedance.sdk.openadsdk.core.g0.a aVar = f595b;
        if (aVar != null) {
            return aVar.a(str, bArr);
        }
        return new HashMap();
    }
}
