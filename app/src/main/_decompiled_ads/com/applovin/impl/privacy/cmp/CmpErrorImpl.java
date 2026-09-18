package com.applovin.impl.privacy.cmp;

import com.applovin.sdk.AppLovinCmpError;

/* JADX INFO: loaded from: classes.dex */
public class CmpErrorImpl implements AppLovinCmpError {
    private final AppLovinCmpError.Code axo;
    private final String axp;
    private final int axq;
    private final String axr;

    public String toString() {
        return "CmpErrorImpl(code=" + getCode() + ", message=" + getMessage() + ", cmpCode=" + getCmpCode() + ", cmpMessage=" + getCmpMessage() + ")";
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public AppLovinCmpError.Code getCode() {
        return this.axo;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getMessage() {
        return this.axp;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public int getCmpCode() {
        return this.axq;
    }

    @Override // com.applovin.sdk.AppLovinCmpError
    public String getCmpMessage() {
        return this.axr;
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str) {
        this(code, str, -1, "");
    }

    public CmpErrorImpl(AppLovinCmpError.Code code, String str, int i, String str2) {
        this.axo = code;
        this.axp = str;
        this.axq = i;
        this.axr = str2;
    }
}
