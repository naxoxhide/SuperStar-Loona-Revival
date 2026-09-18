package com.bytedance.sdk.openadsdk.m.i;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TTSaveHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static boolean a() {
        return o.a() == null;
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void a(String str, String str2, Boolean bool) {
        if (a()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a.a(b(str), str2, bool);
        } else {
            a(b(str), str2, bool);
        }
    }

    public static void b(String str, String str2, String str3) {
        if (a()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a.b(b(str), str2, str3);
        } else {
            a(b(str), str2, str3);
        }
    }

    public static void a(String str, String str2, Long l) {
        if (a()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a.a(b(str), str2, l);
        } else {
            a(b(str), str2, l);
        }
    }

    public static void a(String str, String str2, Integer num) {
        if (a()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a.a(b(str), str2, num);
        } else {
            a(b(str), str2, num);
        }
    }

    public static int a(String str, String str2, int i) {
        if (a()) {
            return i;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            return a.a(b(str), str2, i);
        }
        return a.a(o.a(), b(str), str2, i);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (a()) {
            return z;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            return a.a(b(str), str2, z);
        }
        return a.a(o.a(), b(str), str2, z);
    }

    public static long a(String str, String str2, long j) {
        if (a()) {
            return j;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            return a.a(b(str), str2, j);
        }
        return a.a(o.a(), b(str), str2, j);
    }

    public static String a(String str, String str2, String str3) {
        if (a()) {
            return str3;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            return a.a(b(str), str2, str3);
        }
        return a.a(o.a(), b(str), str2, str3);
    }

    public static void a(String str, String str2) {
        if (a()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                a.a(b(str), str2);
            } else {
                b.a(o.a(), b(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        if (a()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.m.b.b()) {
            a.a(b(str));
        } else {
            b.a(o.a(), b(str));
        }
    }

    private static <T> void a(String str, String str2, T t) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            b.b.a.a.b.f fVarC = b.b.a.a.b.a(o.a(), b(str)).c();
            b.a(fVarC, str2, (Object) t);
            fVarC.apply();
        } else {
            SharedPreferences sharedPreferencesC = b.c(o.a(), b(str));
            if (sharedPreferencesC == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            b.a(editorEdit, str2, t);
            editorEdit.apply();
        }
    }
}
