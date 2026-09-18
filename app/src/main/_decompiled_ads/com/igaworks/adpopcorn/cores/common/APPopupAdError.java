package com.igaworks.adpopcorn.cores.common;

/* JADX INFO: loaded from: classes2.dex */
public class APPopupAdError {
    public static final int ADID_ABUSING = 500;
    public static final int ALL_LOADED_POPUP_AD_SHOWN = 5005;
    public static final String ALL_LOADED_POPUP_AD_SHOWN_MESSAGE = "All loaded popup ad shown";
    public static final int ALREADY_COMPLETED_CAMPAIGN = 2000;
    public static final String ALREADY_COMPLETED_CAMPAIGN_MESSAGE = "Already completed campaign";
    public static final int CAN_NOT_FIND_AVAILABLE_CAMPAIGN = 1000;
    public static final String CAN_NOT_FIND_AVAILABLE_CAMPAIGN_MESSAGE = "Can not find available campaign";
    public static final int EXCEPTION = 200;
    public static final int INVALID_MEDIA_KEY = 1400;
    public static final int MISSING_REQUIRED_PERMISSION = 5010;
    public static final String MISSING_REQUIRED_PERMISSION_MESSAGE = "Missing required permissions";
    public static final int NO_POPUP_AD_LOADED = 5003;
    public static final String NO_POPUP_AD_LOADED_MESSAGE = "No Popup Ad Loaded";
    public static final int SERVER_TIMEOUT = 5000;
    public static final String SERVER_TIMEOUT_MESSAGE = "Server Timeout";
    public static final int TERMINATED_OR_INVALID_CAMPAIGN = 999;
    public static final String TERMINATED_OR_INVALID_CAMPAIGN_MESSAGE = "Terminated or invalid campaign";
    public static final int UNKNOWN_EXCEPTION = 9999;
    public static final String UNKNOWN_EXCEPTION_MESSAGE = "Unknown excepton";
    public static final int USER_IDENTIFIER_MISSING = 2250;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1603b;

    public APPopupAdError(int i, String str) {
        this.f1603b = "";
        this.a = i;
        this.f1603b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.f1603b;
    }

    public void setErrorCode(int i) {
        this.a = i;
    }

    public void setErrorMessage(String str) {
        this.f1603b = str;
    }
}
