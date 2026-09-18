package com.applovin.impl.privacy.a;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int ERROR_CODE_UNSPECIFIED = -1;
    public static int axE = -100;
    public static int axF = -200;
    private final String axp;
    private final int code;

    public a(int i, String str) {
        this.code = i;
        this.axp = str;
    }

    public String toString() {
        return "AppLovinConsentFlowErrorImpl{code=" + this.code + ", message='" + this.axp + "'}";
    }
}
