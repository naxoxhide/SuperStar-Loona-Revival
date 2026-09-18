package com.igaworks.adpopcorn.nativead.custom;

/* JADX INFO: loaded from: classes2.dex */
public class ApCustomRewardCPMError {
    public static final int CAN_NOT_FIND_AVAILABLE_CAMPAIGN = 1000;
    public static final String CAN_NOT_FIND_AVAILABLE_CAMPAIGN_MESSAGE = "Can not find available campaign";
    public static final int EXCEPTION = 200;
    public static final String EXCEPTION_MESSAGE = "Exception";
    public static final int LANDING_FAILED = 6001;
    public static final String LANDING_FAILED_MESSAGE = "Landing URL exception";
    public static final int PARTICIPATION_FAILED = 6000;
    public static final String PARTICIPATION_FAILED_MESSAGE = "Participation failed";
    public static final int SERVER_TIMEOUT = 5000;
    public static final String SERVER_TIMEOUT_MESSAGE = "Server Timeout";
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1633b;

    public ApCustomRewardCPMError(int i, String str) {
        this.f1633b = "";
        this.a = i;
        this.f1633b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.f1633b;
    }

    public void setErrorCode(int i) {
        this.a = i;
    }

    public void setErrorMessage(String str) {
        this.f1633b = str;
    }
}
