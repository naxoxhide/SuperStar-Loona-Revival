package com.kakao.adfit.ads;

/* JADX INFO: loaded from: classes2.dex */
public enum AdError {
    PERMISSION_DENIED(101, "Please check these permissions. android.permission.INTERNET, android.permission.ACCESS_NETWORK_STATE."),
    UNKNOWN_CLIENT_ID(201, "There's no client id in your app. Please provide a valid 'clientId' attribute in the 'com.kakao.adfit.ads.ba.BannerAdView' tag of layout XML. For example, clientId=\"yourClientId\". Or you can use setClientId() method."),
    HTTP_FAILED(202, "Http failed"),
    INVALID_AD(301, "invalid ad"),
    NO_AD(302, "no received ad"),
    FAIL_TO_DRAW(501, "fail to draw ad"),
    SDK_EXCEPTION(601, "SDK exception");

    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1678b;

    AdError(int i, String str) {
        this.a = str;
        this.f1678b = i;
    }

    public int getErrorCode() {
        return this.f1678b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "(" + this.a + ")";
    }
}
