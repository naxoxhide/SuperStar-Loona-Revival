package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

/* JADX INFO: loaded from: classes.dex */
public class UserServiceImpl implements AppLovinUserService {
    private final n sdk;

    public String toString() {
        return "UserService{}";
    }

    UserServiceImpl(n nVar) {
        this.sdk = nVar;
    }

    @Override // com.applovin.sdk.AppLovinUserService
    public void preloadConsentDialog() {
        this.sdk.BW().preloadConsentDialog();
    }

    @Override // com.applovin.sdk.AppLovinUserService
    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.sdk.BW().a(activity, onConsentDialogDismissListener);
    }
}
