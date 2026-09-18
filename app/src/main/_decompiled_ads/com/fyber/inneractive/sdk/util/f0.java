package com.fyber.inneractive.sdk.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: loaded from: classes2.dex */
public enum f0 {
    UNKNOWN(""),
    ETHERNET("3g"),
    WIFI(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI),
    MOBILE_3G("3g"),
    MOBILE_4G("4g");

    public final String key;

    f0(String str) {
        this.key = str;
    }

    public static f0 e() {
        int type;
        NetworkInfo activeNetworkInfo;
        try {
            type = (!l.b("android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) l.a.getSystemService("connectivity")).getActiveNetworkInfo()) == null) ? 8 : activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
        if (type == 9) {
            return ETHERNET;
        }
        if (type != 0) {
            if (type == 1) {
                return WIFI;
            }
            if (type != 2 && type != 3 && type != 4 && type != 5) {
                return UNKNOWN;
            }
        }
        return j.i() == 13 ? MOBILE_4G : MOBILE_3G;
    }
}
