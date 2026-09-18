package com.bytedance.sdk.openadsdk.b.m;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import org.json.JSONObject;

/* JADX INFO: compiled from: SpCache.java */
/* JADX INFO: loaded from: classes2.dex */
class m {
    private final String a;

    m(String str) {
        this.a = TextUtils.isEmpty(str) ? "" : str;
    }

    private String b() {
        return this.a + "_adslot_preload";
    }

    private String c() {
        return this.a + "_adslot";
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.a + "_cache_" + str;
    }

    void a(String str, String str2) {
        try {
            com.bytedance.sdk.openadsdk.m.i.d.a(d(str), "has_played", Boolean.FALSE);
            com.bytedance.sdk.openadsdk.m.i.d.a(d(str), "create_time", Long.valueOf(System.currentTimeMillis()));
            com.bytedance.sdk.openadsdk.m.i.d.b(d(str), "material_data", str2);
        } catch (Throwable unused) {
        }
    }

    long e(String str) {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(d(str), "create_time", 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    boolean f(String str) {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(d(str), "has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    String b(String str) {
        try {
            return com.bytedance.sdk.openadsdk.m.i.d.a(d(str), "material_data", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    AdSlot c(String str) {
        try {
            String strA = com.bytedance.sdk.openadsdk.m.i.d.a(c(), str, (String) null);
            return AdSlot.getSlot(strA != null ? new JSONObject(strA) : null);
        } catch (Throwable unused) {
            return null;
        }
    }

    void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (TextUtils.isEmpty(adSlot.getCodeId())) {
                    return;
                }
                com.bytedance.sdk.openadsdk.m.i.d.b(c(), adSlot.getCodeId(), adSlot.toJsonObj().toString());
            } catch (Throwable unused) {
            }
        }
    }

    void a(String str) {
        try {
            com.bytedance.sdk.openadsdk.m.i.d.a(d(str));
        } catch (Throwable unused) {
        }
    }

    void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (TextUtils.isEmpty(adSlot.getCodeId())) {
                    return;
                }
                com.bytedance.sdk.openadsdk.m.i.d.b(b(), "preload_data", adSlot.toJsonObj().toString());
            } catch (Throwable unused) {
            }
        }
    }

    AdSlot a() {
        try {
            String strA = com.bytedance.sdk.openadsdk.m.i.d.a(b(), "preload_data", (String) null);
            com.bytedance.sdk.openadsdk.m.i.d.a(b());
            return AdSlot.getSlot(strA != null ? new JSONObject(strA) : null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
