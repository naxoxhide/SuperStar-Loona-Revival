package com.tapjoy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.g2;
import com.tapjoy.internal.ra;
import com.tapjoy.internal.v1;
import com.tapjoy.internal.wa;
import com.tapjoy.internal.y9;
import com.tapjoy.internal.z1;
import com.tapjoy.internal.z9;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e0 extends y9 {
    public boolean c = false;
    public String d = "";
    public TJCurrency e = null;

    public final void a(Context context) throws TapjoyIntegrationException {
        boolean z;
        v1 v1Var = v1.m;
        if (v1Var.d == null) {
            v1Var.b(context);
        }
        try {
            v1Var.d.getClassLoader().loadClass("com.android.installreferrer.api.InstallReferrerStateListener");
            z = true;
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            z = false;
        }
        if (!z) {
            throw new TapjoyIntegrationException("InstallReferrerClient APIs aren't available in your project. To use activateInstallReferrerClient() API,`com.android.installreferrer:installreferrer` dependency is required to your project level build.gradle file");
        }
        new TJInstallReferrer().init(context);
    }

    public final boolean b(String str) {
        if (this.c) {
            return true;
        }
        String str2 = "Can not call " + str + " because Tapjoy SDK is not initialized.";
        this.d = str2;
        TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, str2));
        return false;
    }

    public final boolean a() {
        v1 v1Var = v1.m;
        if (!v1Var.a()) {
            return false;
        }
        Boolean bool = v1Var.e.c.w;
        Boolean bool2 = ra.y;
        if (bool == null) {
            bool2.getClass();
            bool = bool2;
        }
        return bool.booleanValue();
    }

    public synchronized boolean a(Context context, String str, Hashtable hashtable, TJConnectListener tJConnectListener) {
        Object obj;
        boolean z = false;
        if (Build.VERSION.SDK_INT < 24) {
            TapjoyLog.e("TapjoyAPI", TapjoyErrorMessage.DEVICE_OS_NOT_SUPPORTED);
            if (tJConnectListener != null) {
                ((fa) tJConnectListener).a.a(2, TapjoyErrorMessage.DEVICE_OS_NOT_SUPPORTED);
                tJConnectListener.onConnectFailure();
            }
            return false;
        }
        if (hashtable != null && (obj = hashtable.get(TapjoyConnectFlag.ENABLE_LOGGING)) != null) {
            TapjoyLog.setDebugEnabled("true".equals(obj.toString()));
        }
        TapjoyConnectCore.setSDKType("event");
        if (context == null) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The application context is NULL"));
            if (tJConnectListener != null) {
                ((fa) tJConnectListener).a.a(1, "The application context is NULL");
                tJConnectListener.onConnectFailure();
            }
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy"));
            if (tJConnectListener != null) {
                ((fa) tJConnectListener).a.a(1, "The SDK key is NULL. A valid SDK key is required to connect successfully to Tapjoy");
                tJConnectListener.onConnectFailure();
            }
            return false;
        }
        wa waVar = FiveRocksIntegration.a;
        v1 v1Var = v1.m;
        if (!v1Var.c) {
            v1Var.c = true;
        }
        v1Var.l = g2.a(new z1());
        try {
            TapjoyAppSettings.init(context);
            TapjoyConnectCore.requestTapjoyConnect(context, str, hashtable, new z9(this, context, (fa) tJConnectListener));
            this.c = true;
            if (hashtable != null && String.valueOf(hashtable.get(TapjoyConnectFlag.DISABLE_AUTOMATIC_SESSION_TRACKING)).equalsIgnoreCase("true")) {
                z = true;
            }
            if (!z) {
                com.tapjoy.internal.e.a(context);
            } else {
                TapjoyLog.i("TapjoyAPI", "Automatic session tracking is disabled.");
            }
            return true;
        } catch (TapjoyIntegrationException e) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, e.getMessage()));
            if (tJConnectListener != null) {
                ((fa) tJConnectListener).a.a(1, e.getMessage());
                tJConnectListener.onConnectFailure();
            }
            return false;
        } catch (TapjoyException e2) {
            TapjoyLog.e("TapjoyAPI", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, e2.getMessage()));
            if (tJConnectListener != null) {
                ((fa) tJConnectListener).a.a(1, e2.getMessage());
                tJConnectListener.onConnectFailure();
            }
            return false;
        }
    }

    public final boolean a(String str) {
        if (this.a) {
            return true;
        }
        TapjoyLog.w("TapjoyAPI", "Can not call " + str + " because Tapjoy SDK has not successfully connected.");
        return false;
    }
}
