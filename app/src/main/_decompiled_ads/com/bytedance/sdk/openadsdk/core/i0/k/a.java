package com.bytedance.sdk.openadsdk.core.i0.k;

/* JADX INFO: compiled from: VastErrorCode.java */
/* JADX INFO: loaded from: classes2.dex */
public enum a {
    XML_PARSING_ERROR(100),
    SCHEMA_VALIDATION_ERROR(101),
    WRAPPER_TIMEOUT(301),
    NO_ADS_VAST_RESPONSE(303),
    GENERAL_LINEAR_AD_ERROR(400),
    GENERAL_COMPANION_AD_ERROR(600),
    UNDEFINED_ERROR(900);

    private final int a;

    a(int i2) {
        this.a = i2;
    }

    public String b() {
        return String.valueOf(this.a);
    }
}
