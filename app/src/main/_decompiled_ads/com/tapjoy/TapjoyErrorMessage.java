package com.tapjoy;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyErrorMessage {
    public static final String API_NOT_AVAILABLE_ERROR = "The interface is no longer operational.";
    public static final String ASSET_ERROR = "asset error";
    public static final String DEVICE_OS_NOT_SUPPORTED = "Device OS version not supported";
    public static final String NETWORK_ERROR = "network error";
    public static final int TJC_ERROR_INTEGRATION = 1;
    public static final int TJC_ERROR_SDK = 2;
    public static final int TJC_ERROR_SERVER = 3;
    public final ErrorType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2713b;

    public enum ErrorType {
        INTERNAL_ERROR,
        SDK_ERROR,
        SERVER_ERROR,
        INTEGRATION_ERROR,
        NETWORK_ERROR;

        ErrorType() {
        }
    }

    public TapjoyErrorMessage(ErrorType errorType, String str) {
        this.a = errorType;
        this.f2713b = str;
    }

    public ErrorType getType() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type=" + this.a.toString());
        sb.append(";Message=" + this.f2713b);
        return sb.toString();
    }
}
