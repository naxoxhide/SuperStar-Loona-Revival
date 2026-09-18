package com.adxcorp.gdpr;

import android.app.Activity;
import android.content.Context;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GoogleMobileAdsConsentManager {
    private static GoogleMobileAdsConsentManager instance;
    private final ConsentInformation consentInformation;

    public interface OnConsentGatheringCompleteListener {
        void consentGatheringComplete(FormError formError);
    }

    private GoogleMobileAdsConsentManager(Context context) {
        this.consentInformation = UserMessagingPlatform.getConsentInformation(context);
    }

    public static GoogleMobileAdsConsentManager getInstance(Context context) {
        if (instance == null) {
            instance = new GoogleMobileAdsConsentManager(context);
        }
        return instance;
    }

    public boolean canRequestAds() {
        return this.consentInformation.canRequestAds();
    }

    public boolean isPrivacyOptionsRequired() {
        return this.consentInformation.getPrivacyOptionsRequirementStatus() == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
    }

    public void gatherConsent(final Activity activity, boolean z, List<String> list, final OnConsentGatheringCompleteListener onConsentGatheringCompleteListener) {
        ConsentRequestParameters consentRequestParametersBuild;
        if (z) {
            ConsentDebugSettings.Builder builder = new ConsentDebugSettings.Builder(activity);
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    builder.addTestDeviceHashedId(it.next());
                }
            }
            builder.setDebugGeography(1);
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().setConsentDebugSettings(builder.build()).build();
        } else {
            consentRequestParametersBuild = new ConsentRequestParameters.Builder().build();
        }
        this.consentInformation.requestConsentInfoUpdate(activity, consentRequestParametersBuild, new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.adxcorp.gdpr.GoogleMobileAdsConsentManager.1
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
            public void onConsentInfoUpdateSuccess() {
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.adxcorp.gdpr.GoogleMobileAdsConsentManager.1.1
                    @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
                    public void onConsentFormDismissed(FormError formError) {
                        onConsentGatheringCompleteListener.consentGatheringComplete(formError);
                    }
                });
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.adxcorp.gdpr.GoogleMobileAdsConsentManager.2
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
            public void onConsentInfoUpdateFailure(FormError formError) {
                onConsentGatheringCompleteListener.consentGatheringComplete(formError);
            }
        });
    }

    public void showPrivacyOptionsForm(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity, onConsentFormDismissedListener);
    }

    public int getConsentStatus() {
        return this.consentInformation.getConsentStatus();
    }
}
