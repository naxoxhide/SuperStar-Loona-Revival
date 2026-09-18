package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: PAGNetworkTools.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static String a(Context context) {
        int iA = com.bytedance.sdk.component.utils.w.a(context, 0L);
        if (iA == 2) {
            return "2g";
        }
        if (iA == 3) {
            return "3g";
        }
        if (iA == 4) {
            return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        if (iA != 5) {
            return iA != 6 ? TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : "5g";
        }
        return "4g";
    }
}
