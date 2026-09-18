package com.bytedance.sdk.openadsdk.o;

import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: NetType.java */
/* JADX INFO: loaded from: classes2.dex */
public enum d {
    TYPE_2G("2g"),
    TYPE_3G("3g"),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI(TapjoyConstants.TJC_CONNECTION_TYPE_WIFI),
    TYPE_UNKNOWN(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE);

    private String a;

    d(String str) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
