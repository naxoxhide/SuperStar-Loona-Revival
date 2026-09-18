package com.applovin.sdk;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinUserService {

    public interface OnConsentDialogDismissListener {
        void onDismiss();
    }

    void preloadConsentDialog();

    void showConsentDialog(Activity activity, OnConsentDialogDismissListener onConsentDialogDismissListener);
}
