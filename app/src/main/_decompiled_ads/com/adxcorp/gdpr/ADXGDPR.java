package com.adxcorp.gdpr;

/* JADX INFO: loaded from: classes.dex */
public class ADXGDPR {
    public static String ADX_SDK_VERSION = "2.5.1";

    public interface ADXConsentListener {
        void onResult(ADXConsentState aDXConsentState);
    }

    public enum ADXConsentState {
        ADXConsentStateUnknown,
        ADXConsentStateNotRequired,
        ADXConsentStateDenied,
        ADXConsentStateConfirm
    }

    public enum ADXLocate {
        ADXLocateInEEAorUnknown,
        ADXLocateNotEEA,
        ADXLocateCheckFail
    }

    public interface ADXLocateListener {
        void onResult(ADXLocate aDXLocate);
    }
}
