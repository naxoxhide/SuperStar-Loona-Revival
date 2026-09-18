package com.stansassets.core.utility;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class AN_Logger {
    private static String TAG = "AndroidNative";
    private static boolean m_enableWTFLogging = true;
    private static boolean m_error = true;
    private static boolean m_info = true;
    private static boolean m_warning = true;

    public static void SetLogLevel(boolean z, boolean z2, boolean z3, boolean z4) {
        m_info = z;
        m_warning = z2;
        m_error = z3;
        m_enableWTFLogging = z4;
        Log.wtf(TAG, "Log Level is set info:" + z + " warning: " + z2 + " error: " + z3 + " enableWTFLogging:" + z4);
    }

    public static void Log(String str) {
        printLog(str, AN_LoggerLogType.Info);
    }

    public static void LogWarning(String str) {
        printLog(str, AN_LoggerLogType.Warning);
    }

    public static void LogError(String str) {
        printLog(str, AN_LoggerLogType.Error);
    }

    private static void printLog(String str, AN_LoggerLogType aN_LoggerLogType) {
        boolean z = aN_LoggerLogType != AN_LoggerLogType.Info || m_info;
        if (aN_LoggerLogType == AN_LoggerLogType.Warning && !m_warning) {
            z = false;
        }
        if ((aN_LoggerLogType != AN_LoggerLogType.Error || m_error) ? z : false) {
            if (str.length() > 1000) {
                PrintNativeLog("Communication log to big to print it, we need to do something about it", aN_LoggerLogType);
                PrintNativeLog(str, aN_LoggerLogType);
            } else {
                PrintNativeLog(str, aN_LoggerLogType);
            }
        }
    }

    private static void PrintNativeLog(String str, AN_LoggerLogType aN_LoggerLogType) {
        if (m_enableWTFLogging) {
            Log.wtf(TAG, str);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$stansassets$core$utility$AN_LoggerLogType[aN_LoggerLogType.ordinal()];
        if (i == 1) {
            Log.d(TAG, str);
        } else if (i == 2) {
            Log.w(TAG, str);
        } else {
            if (i != 3) {
                return;
            }
            Log.e(TAG, str);
        }
    }

    /* JADX INFO: renamed from: com.stansassets.core.utility.AN_Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$stansassets$core$utility$AN_LoggerLogType;

        static {
            int[] iArr = new int[AN_LoggerLogType.values().length];
            $SwitchMap$com$stansassets$core$utility$AN_LoggerLogType = iArr;
            try {
                iArr[AN_LoggerLogType.Info.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$stansassets$core$utility$AN_LoggerLogType[AN_LoggerLogType.Warning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$stansassets$core$utility$AN_LoggerLogType[AN_LoggerLogType.Error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
