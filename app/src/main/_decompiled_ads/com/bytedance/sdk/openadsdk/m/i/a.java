package com.bytedance.sdk.openadsdk.m.i;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import b.b.a.a.i.a.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: SPMultiHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a() {
        if (o.a() != null) {
            return true;
        }
        m.b("The context of SPHelper is null, please initialize sdk in main process");
        return false;
    }

    private static Context b() {
        return o.a();
    }

    private static g c() {
        try {
            if (a()) {
                return com.bytedance.sdk.openadsdk.m.f.a.a(o.a());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d() {
        return com.bytedance.sdk.openadsdk.m.d.f791b + RemoteSettings.FORWARD_SLASH_STRING + "t_sp" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        if (!a()) {
            return;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                b.a(b(), str, str2, bool);
                return;
            }
            g gVarC = c();
            if (gVarC != null) {
                Uri uri = Uri.parse(d() + "boolean" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str));
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", bool);
                gVarC.a(uri, contentValues, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        if (!a()) {
            return;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                b.a(b(), str, str2, str3);
                return;
            }
            g gVarC = c();
            if (gVarC != null) {
                Uri uri = Uri.parse(d() + "string" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str));
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", str3);
                gVarC.a(uri, contentValues, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        if (!a()) {
            return;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                b.a(b(), str, str2, num);
                return;
            }
            g gVarC = c();
            if (gVarC != null) {
                Uri uri = Uri.parse(d() + "int" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str));
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", num);
                gVarC.a(uri, contentValues, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        if (!a()) {
            return;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                b.a(b(), str, str2, l);
                return;
            }
            g gVarC = c();
            if (gVarC != null) {
                Uri uri = Uri.parse(d() + "long" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str));
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", l);
                gVarC.a(uri, contentValues, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void a(String str, String str2, Float f) {
        if (!a()) {
            return;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                b.a(b(), str, str2, f);
                return;
            }
            g gVarC = c();
            if (gVarC != null) {
                Uri uri = Uri.parse(d() + "float" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str));
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", f);
                gVarC.a(uri, contentValues, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str, String str2, String str3) {
        String strA;
        if (!a()) {
            return str3;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                return a(b(), str, str2, str3);
            }
            g gVarC = c();
            return (gVarC == null || (strA = gVarC.a(Uri.parse(new StringBuilder().append(d()).append("string").append(RemoteSettings.FORWARD_SLASH_STRING).append(str2).append(b(str)).toString()))) == null || strA.equals("null")) ? str3 : strA;
        } catch (Throwable unused) {
        }
    }

    protected static String a(Context context, String str, String str2, String str3) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2, str3);
        }
        SharedPreferences sharedPreferencesC = b.c(context, str);
        return sharedPreferencesC == null ? str3 : sharedPreferencesC.getString(str2, str3);
    }

    public static int a(String str, String str2, int i) {
        String strA;
        if (!a()) {
            return i;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                return a(b(), str, str2, i);
            }
            g gVarC = c();
            if (gVarC != null && (strA = gVarC.a(Uri.parse(d() + "int" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str)))) != null && !strA.equals("null")) {
                return Integer.parseInt(strA);
            }
            return i;
        } catch (Throwable unused) {
        }
    }

    protected static int a(Context context, String str, String str2, int i) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2, i);
        }
        SharedPreferences sharedPreferencesC = b.c(context, str);
        return sharedPreferencesC == null ? i : sharedPreferencesC.getInt(str2, i);
    }

    protected static float a(Context context, String str, String str2, float f) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2, f);
        }
        SharedPreferences sharedPreferencesC = b.c(context, str);
        return sharedPreferencesC == null ? f : sharedPreferencesC.getFloat(str2, f);
    }

    public static boolean a(String str, String str2, boolean z) {
        String strA;
        if (!a()) {
            return z;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                return a(b(), str, str2, z);
            }
            g gVarC = c();
            if (gVarC != null && (strA = gVarC.a(Uri.parse(d() + "boolean" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str)))) != null && !strA.equals("null")) {
                return Boolean.parseBoolean(strA);
            }
            return z;
        } catch (Throwable unused) {
        }
    }

    protected static boolean a(Context context, String str, String str2, boolean z) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2, z);
        }
        SharedPreferences sharedPreferencesC = b.c(context, str);
        return sharedPreferencesC == null ? z : sharedPreferencesC.getBoolean(str2, z);
    }

    public static long a(String str, String str2, long j) {
        String strA;
        if (!a()) {
            return j;
        }
        try {
            if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                return a(b(), str, str2, j);
            }
            g gVarC = c();
            if (gVarC != null && (strA = gVarC.a(Uri.parse(d() + "long" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str)))) != null && !strA.equals("null")) {
                return Long.parseLong(strA);
            }
            return j;
        } catch (Throwable unused) {
        }
    }

    protected static long a(Context context, String str, String str2, long j) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2, j);
        }
        SharedPreferences sharedPreferencesC = b.c(context, str);
        return sharedPreferencesC == null ? j : sharedPreferencesC.getLong(str2, j);
    }

    public static void a(String str, String str2) {
        if (a()) {
            try {
                if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                    b.a(b(), str, str2);
                    return;
                }
                g gVarC = c();
                if (gVarC != null) {
                    gVarC.a(Uri.parse(d() + "long" + RemoteSettings.FORWARD_SLASH_STRING + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                    b.a(b(), str);
                    return;
                }
                g gVarC = c();
                if (gVarC != null) {
                    gVarC.a(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
