package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: TTClientBiddingUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class u {
    public static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, Double d) {
        if (qVar == null || qVar.i0() == null) {
            return;
        }
        Map<String, Object> mapI0 = qVar.i0();
        try {
            Object obj = qVar.i0().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapI0.get("nurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                }
                com.bytedance.sdk.openadsdk.core.o.c().a(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.m.b("report Win error");
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.f0.q qVar, Double d, String str, String str2) {
        if (qVar == null || qVar.i0() == null) {
            return;
        }
        Map<String, Object> mapI0 = qVar.i0();
        try {
            Object obj = qVar.i0().get("sdk_bidding_type");
            if (obj != null && Integer.parseInt(obj.toString()) == 2) {
                String strReplace = (String) mapI0.get("lurl");
                if (TextUtils.isEmpty(strReplace)) {
                    return;
                }
                if (d != null) {
                    strReplace = strReplace.replace("${AUCTION_PRICE}", String.valueOf(d));
                }
                if (str != null) {
                    strReplace = strReplace.replace("${AUCTION_LOSS}", str);
                }
                if (str2 != null) {
                    strReplace = strReplace.replace("${AUCTION_WINNER}", str2);
                }
                com.bytedance.sdk.openadsdk.core.o.c().a(strReplace);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.utils.m.b("report Loss error");
        }
    }
}
