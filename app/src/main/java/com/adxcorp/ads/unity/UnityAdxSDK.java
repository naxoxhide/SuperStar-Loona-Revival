package com.adxcorp.ads.unity;

import android.app.Activity;
import com.adxcorp.ads.ADXConfiguration;

public class UnityAdxSDK {
    private static UnityAdxSDK s_instance = new UnityAdxSDK();

    public interface OnInitializedListener {
        void onInitialized();
    }

    public static UnityAdxSDK getInstance() {
        return s_instance;
    }

    public static Object getGdprType(int i) { return "NONE"; }
    public static Object getGdprType() { return "NONE"; }
    public static Object setGdprType(String s) { return null; }
    public Object setGdprType(int i) { return this; }

    public static void initialize(Activity activity, String appId, String gdprConsent, String ccpaConsent) {}
    public static void initialize(Activity activity, String appId) {}
    public void initialize(String appId, String gdprConsent, String ccpaConsent) {}
    public void initialize(String appId) {}
    public void initialize(ADXConfiguration config, OnInitializedListener listener) {
        if (listener != null) {
            listener.onInitialized();
        }
    }
    public void setGDPRConsent(String gdprConsent) {}
    public void setCCPAConsent(String ccpaConsent) {}
}
