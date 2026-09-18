package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private ConsentForm axA;
    private final x logger;
    private final n sdk;

    public interface a {
        void onFlowHidden(Bundle bundle);

        void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl);

        void onFlowLoaded(Bundle bundle);

        void onFlowShowFailed(CmpErrorImpl cmpErrorImpl);
    }

    public String getSdkVersion() {
        return null;
    }

    public boolean zS() {
        return true;
    }

    public boolean zT() {
        return true;
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(n.getApplicationContext());
        d("Initializing with SDK Version: " + getSdkVersion() + ", consentStatus: " + consentInformation.getConsentStatus() + ", consentFormAvailable: " + consentInformation.isConsentFormAvailable());
    }

    public void destroy() {
        if (this.axA != null) {
            this.axA = null;
        }
    }

    public void a(final Activity activity, com.applovin.impl.privacy.cmp.a aVar, final a aVar2) {
        ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
        if (u.b(n.getApplicationContext(), this.sdk) && aVar.getDebugUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            UserMessagingPlatform.getConsentInformation(activity).reset();
            builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId(StringUtils.emptyIfNull(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.GOOGLE_TEST_DEVICE_HASHED_ID))).build());
        }
        UserMessagingPlatform.getConsentInformation(activity).requestConsentInfoUpdate(activity, builder.build(), new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.applovin.impl.privacy.cmp.b.1
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
            public void onConsentInfoUpdateSuccess() {
                ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(activity);
                boolean zIsConsentFormAvailable = consentInformation.isConsentFormAvailable();
                int consentStatus = consentInformation.getConsentStatus();
                b.this.d("Loaded parameters consentStatus: " + consentStatus + ", consentFormAvailable: " + zIsConsentFormAvailable);
                if (!zIsConsentFormAvailable) {
                    b.this.e("Failed to load form.");
                    aVar2.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form unavailable"));
                } else if (consentStatus != 2) {
                    b.this.e("Failed to load with consent status: " + consentStatus);
                    aVar2.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_NOT_REQUIRED, "Consent form not required for consent status: " + consentStatus));
                } else {
                    b.this.d("Successfully requested consent info");
                    b.this.d("Loading consent form...");
                    UserMessagingPlatform.loadConsentForm(activity, new UserMessagingPlatform.OnConsentFormLoadSuccessListener() { // from class: com.applovin.impl.privacy.cmp.b.1.1
                        @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
                        public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                            b.this.d("Successfully loaded consent form");
                            b.this.axA = consentForm;
                            aVar2.onFlowLoaded(null);
                        }
                    }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() { // from class: com.applovin.impl.privacy.cmp.b.1.2
                        @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
                        public void onConsentFormLoadFailure(FormError formError) {
                            b.this.e("Failed to load with error: " + formError);
                            aVar2.onFlowLoadFailed(b.this.a(formError, "Consent form load failed"));
                        }
                    });
                }
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.applovin.impl.privacy.cmp.b.2
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
            public void onConsentInfoUpdateFailure(FormError formError) {
                b.this.e("Failed to request consent info with error: " + formError);
                aVar2.onFlowLoadFailed(b.this.a(formError, "Consent info update failed"));
            }
        });
    }

    public void b(Activity activity, com.applovin.impl.privacy.cmp.a aVar, final a aVar2) {
        if (this.axA == null) {
            e("Failed to show - not ready yet");
            aVar2.onFlowShowFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form not ready"));
        } else {
            d("Showing consent form...");
            this.axA.show(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: com.applovin.impl.privacy.cmp.b.3
                @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
                public void onConsentFormDismissed(FormError formError) {
                    if (formError != null) {
                        b.this.e("Failed to show with error: " + formError);
                        aVar2.onFlowShowFailed(b.this.a(formError, "Consent form show failed"));
                    } else {
                        b.this.d("Consent form finished showing");
                        aVar2.onFlowHidden(null);
                    }
                }
            });
        }
    }

    public void zQ() {
        d("Resetting consent information");
        UserMessagingPlatform.getConsentInformation(n.getApplicationContext()).reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0016  */
    public CmpErrorImpl a(FormError formError, String str) {
        AppLovinCmpError.Code code = AppLovinCmpError.Code.UNSPECIFIED;
        int errorCode = formError.getErrorCode();
        if (errorCode == 1 || errorCode == 2) {
            code = AppLovinCmpError.Code.FORM_UNAVAILABLE;
        } else if (errorCode == 3) {
            code = AppLovinCmpError.Code.INTEGRATION_ERROR;
        } else if (errorCode == 4) {
            code = AppLovinCmpError.Code.FORM_UNAVAILABLE;
        }
        return new CmpErrorImpl(code, str, formError.getErrorCode(), formError.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        if (x.Fk()) {
            this.logger.f("GoogleCmpAdapter", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (x.Fk()) {
            this.logger.i("GoogleCmpAdapter", str);
        }
    }
}
