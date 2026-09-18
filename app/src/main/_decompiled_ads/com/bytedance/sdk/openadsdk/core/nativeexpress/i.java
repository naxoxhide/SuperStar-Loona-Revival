package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: ExpressEventManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static void a(int i, String str, String str2, q qVar) {
        com.bytedance.sdk.openadsdk.l.b.a().c(com.bytedance.sdk.openadsdk.l.c.b.o().a(a(str)).f(str2).e(qVar != null ? qVar.U() : "").b(i).b(com.bytedance.sdk.openadsdk.core.g.a(i)));
    }

    private static int a(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }
}
