package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: NetworkUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static boolean a(Context context) {
        return b(context) != 0;
    }

    public static int b(Context context) {
        return w.a(context, 60000L);
    }

    public static int c(Context context) {
        int iB = b(context);
        if (iB == 1) {
            return 0;
        }
        if (iB == 4) {
            return 1;
        }
        if (iB == 5) {
            return 4;
        }
        if (iB != 6) {
            return iB;
        }
        return 6;
    }

    public static String d(Context context) {
        int iB = b(context);
        if (iB == 2) {
            return "2g";
        }
        if (iB == 3) {
            return "3g";
        }
        if (iB == 4) {
            return TapjoyConstants.TJC_CONNECTION_TYPE_WIFI;
        }
        if (iB != 5) {
            return iB != 6 ? TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : "5g";
        }
        return "4g";
    }

    public static boolean e(Context context) {
        return b(context) == 5;
    }

    public static boolean f(Context context) {
        return b(context) == 6;
    }

    public static boolean g(Context context) {
        return b(context) == 4;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }
}
