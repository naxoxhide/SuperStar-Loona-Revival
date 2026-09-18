package com.bytedance.sdk.openadsdk.utils;

import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static final long a = a(0.05f);

    /* JADX INFO: compiled from: MemoryUtils.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, long j) {
            super(str);
            this.c = str2;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scene", this.c);
                jSONObject.put("mem_size", this.d);
                com.bytedance.sdk.openadsdk.l.b.a().a("dynamic_mem_not_enough", jSONObject);
                com.bytedance.sdk.component.utils.m.c("MemoryUtils", "dynamic_mem_not_enough", jSONObject);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.m.b("MemoryUtils", "run: ", e);
            }
        }
    }

    public static long a(float f) {
        return Double.valueOf(f * Runtime.getRuntime().maxMemory()).longValue();
    }

    private static void b(long j, String str) {
        y.c(new a("isMemoryEnough", str, j), 5);
    }

    public static boolean a(long j, String str) {
        if (!com.bytedance.sdk.openadsdk.core.o.d().E() || Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >= j) {
            return true;
        }
        b(j, str);
        return false;
    }

    public static int a() {
        try {
            int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 33554432);
            if (iMaxMemory <= 2) {
                return 2;
            }
            if (iMaxMemory >= 5) {
                return 5;
            }
            return iMaxMemory;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
