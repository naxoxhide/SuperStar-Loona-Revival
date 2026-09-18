package com.tapjoy;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tapjoy.internal.la;

/* JADX INFO: loaded from: classes4.dex */
public class TapjoyLog {
    public static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2715b = 6;

    public static void a(String str, boolean z) {
        if (!z && TapjoyAppSettings.getInstance() != null && TapjoyAppSettings.getInstance().f2705b != null) {
            d("TapjoyLog", "setLoggingLevel -- log setting already persisted");
            return;
        }
        if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
            f2715b = 2;
            new Handler(Looper.getMainLooper()).post(new la());
        } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
            f2715b = 4;
        } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
            f2715b = 6;
        } else {
            d("TapjoyLog", "unrecognized loggingLevel: ".concat(str));
            f2715b = 6;
        }
        d("TapjoyLog", "logThreshold=" + f2715b);
    }

    public static void d(String str, String str2) {
        a(str, str2, 3);
    }

    public static void e(String str, String str2) {
        e(str, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, str2));
    }

    public static void i(String str, String str2) {
        a(str, str2, 4);
    }

    public static boolean isLoggingEnabled() {
        return a;
    }

    public static void setDebugEnabled(boolean z) {
        a = z;
        if (z) {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean z) {
        if (z) {
            a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    public static void v(String str, String str2) {
        a(str, str2, 2);
    }

    public static void w(String str, String str2) {
        a(str, str2, 5);
    }

    public static void e(String str, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage != null) {
            if (f2715b == 2 || tapjoyErrorMessage.getType() != TapjoyErrorMessage.ErrorType.INTERNAL_ERROR) {
                a(str, tapjoyErrorMessage.toString(), 6);
            }
        }
    }

    public static void a(String str, String str2, int i) {
        String str3 = "TapjoyLog:" + str;
        if (f2715b <= i) {
            if (str2.length() > 4096) {
                int i2 = 0;
                while (i2 <= str2.length() / 4096) {
                    int i3 = i2 * 4096;
                    i2++;
                    int length = i2 * 4096;
                    if (length > str2.length()) {
                        length = str2.length();
                    }
                    Log.println(i, str3, str2.substring(i3, length));
                }
                return;
            }
            Log.println(i, str3, str2);
        }
    }
}
