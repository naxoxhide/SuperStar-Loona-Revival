package com.igaworks.adpopcorn.nativead;

/* JADX INFO: loaded from: classes2.dex */
public class ApNativeRewardCPMError {
    public static final int CAN_NOT_FIND_AVAILABLE_CAMPAIGN = 1000;
    public static final String CAN_NOT_FIND_AVAILABLE_CAMPAIGN_MESSAGE = "Can not find available campaign";
    public static final int EXCEPTION = 200;
    public static final int RENDERING_EXCEPTION = 5020;
    public static final String RENDERING_EXCEPTION_MESSAGE = "Rendering exception";
    public static final int SERVER_TIMEOUT = 5000;
    public static final String SERVER_TIMEOUT_MESSAGE = "Server Timeout";
    public static final int UNKNOWN_EXCEPTION = 9999;
    public static final String UNKNOWN_EXCEPTION_MESSAGE = "Unknown exception";
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1629b;

    public ApNativeRewardCPMError(int i, String str) {
        this.f1629b = "";
        this.a = i;
        this.f1629b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.f1629b;
    }

    public void setErrorCode(int i) {
        this.a = i;
    }

    public void setErrorMessage(String str) {
        this.f1629b = str;
    }
}
