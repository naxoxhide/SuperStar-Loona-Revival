package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static int a;

    public static int a(Context context) {
        try {
            int i = a;
            if (i > 0) {
                return i;
            }
            context.getPackageManager().getApplicationInfo("com.igaworks.adpopcorn.debug", 0);
            a = 2;
        } catch (Exception unused) {
            a = 1;
        }
        return a;
    }

    public static void a(Context context, String str, String str2, int i) {
        try {
            if (a(context) < 2) {
                return;
            }
            if (str != null && str.length() > 0) {
                str = "AP:" + str;
            }
            if (str2 == null || str2.length() < 800) {
                a(str, str2, i);
                return;
            }
            int i2 = 0;
            while (i2 <= str2.length() / 800) {
                int i3 = i2 * 800;
                i2++;
                int length = i2 * 800;
                if (length > str2.length()) {
                    length = str2.length();
                }
                a(str, str2.substring(i3, length), i);
            }
        } catch (Exception e) {
            Log.e("AP:APLogger", "APLogger Exception : " + e.getStackTrace());
        }
    }

    public static void a(Context context, String str, StackTraceElement[] stackTraceElementArr, String str2, int i) {
        try {
            if (a(context) < 2) {
                return;
            }
            String str3 = "  _MESSAGE_ = " + str2;
            if (stackTraceElementArr != null) {
                char c = 1;
                if (stackTraceElementArr.length <= 1) {
                    c = 0;
                }
                a(str, "_CLASS_ = " + stackTraceElementArr[c].getClassName() + "  _METHOD_ = " + stackTraceElementArr[c].getMethodName() + "  _LINE_ = " + String.valueOf(stackTraceElementArr[c].getLineNumber()) + "  _MESSAGE_ = " + str2, i);
            }
        } catch (Exception e) {
            Log.e("AP:APLogger", "APLogger Exception : " + e.getStackTrace());
        }
    }

    public static void a(String str, Context context) {
        Toast.makeText(context, "[AP]:" + str, 0).show();
    }

    private static void a(String str, String str2, int i) {
        try {
            if (i == 0) {
                Log.e(str, str2);
            } else if (i == 1) {
                Log.w(str, str2);
            } else if (i == 2) {
                Log.i(str, str2);
            } else if (i == 3) {
                Log.d(str, str2);
            } else if (i != 4) {
            } else {
                Log.v(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str, String str2, int i) {
        String string;
        try {
            if (a(context) < 2) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    if (applicationInfo.metaData.containsKey("enable_ap_log")) {
                        String string2 = applicationInfo.metaData.getString("enable_ap_log");
                        if (string2 != null && string2.contentEquals("disable")) {
                            return;
                        }
                    } else if (applicationInfo.metaData.containsKey("igaw_log_enable") && (string = applicationInfo.metaData.getString("igaw_log_enable")) != null && string.contentEquals("disable")) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (str != null && str.length() > 0) {
                str = "AP:" + str;
            }
            if (str2 == null || str2.length() < 800) {
                a(str, str2, i);
                return;
            }
            int i2 = 0;
            while (i2 <= str2.length() / 800) {
                int i3 = i2 * 800;
                i2++;
                int length = i2 * 800;
                if (length > str2.length()) {
                    length = str2.length();
                }
                a(str, str2.substring(i3, length), i);
            }
        } catch (Exception e2) {
            Log.e("AP:APLogger", "APLogger Exception : " + e2.getStackTrace());
        }
    }
}
