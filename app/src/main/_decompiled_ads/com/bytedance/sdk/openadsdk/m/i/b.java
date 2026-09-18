package com.bytedance.sdk.openadsdk.m.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.h;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SPMultiHelperImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    private static SoftReference<ConcurrentHashMap<String, Map<String, Object>>> a;

    private static Object a(String str, String str2) {
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap;
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference == null || (concurrentHashMap = softReference.get()) == null || (map = concurrentHashMap.get(b(str))) == null) {
            return null;
        }
        return map.get(str2);
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "sphelper_ttopenadsdk" : str;
    }

    public static SharedPreferences c(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(b(str), 0);
        } catch (Throwable th) {
            m.b("SPMultiHelperImpl", "getSharedPreferences error ", th.getMessage());
            return null;
        }
    }

    static String b(Context context, String str, String str2, String str3) {
        Object objA = a(str, str2);
        if (objA != null) {
            return objA + "";
        }
        Object objA2 = a(context, str, str2, str3);
        a(str, str2, objA2);
        return objA2 + "";
    }

    private static void a(String str, String str2, Object obj) {
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null) {
            a = new SoftReference<>(new ConcurrentHashMap());
        }
        String strB = b(str);
        ConcurrentHashMap<String, Map<String, Object>> concurrentHashMap = a.get();
        if (concurrentHashMap.get(strB) == null) {
            concurrentHashMap.put(strB, new HashMap());
        }
        concurrentHashMap.get(strB).put(str2, obj);
    }

    static boolean b(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            return b.b.a.a.b.a(context, str).a(str2);
        }
        SharedPreferences sharedPreferencesC = c(context, str);
        return sharedPreferencesC != null && sharedPreferencesC.contains(str2);
    }

    static Map<String, ?> b(Context context, String str) {
        SharedPreferences sharedPreferencesC = c(context, str);
        if (sharedPreferencesC == null) {
            return null;
        }
        return sharedPreferencesC.getAll();
    }

    private static void a(String str) {
        Map<String, Object> map;
        SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
        if (softReference == null || softReference.get() == null || (map = a.get().get(b(str))) == null) {
            return;
        }
        map.clear();
    }

    static synchronized <T> void a(Context context, String str, String str2, T t) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            b.b.a.a.b bVarA = b.b.a.a.b.a(context, str);
            if (t.equals(a(str, str2))) {
                return;
            }
            b.b.a.a.b.f fVarC = bVarA.c();
            a(fVarC, str2, (Object) t);
            fVarC.apply();
            return;
        }
        SharedPreferences sharedPreferencesC = c(context, str);
        if (sharedPreferencesC == null) {
            return;
        }
        if (t.equals(a(str, str2))) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        a(editorEdit, str2, t);
        editorEdit.apply();
        a(str, str2, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void a(SharedPreferences.Editor editor, String str, T t) {
        if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            editor.putString(str, (String) t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> void a(b.b.a.a.b.f fVar, String str, T t) {
        if (t instanceof Integer) {
            fVar.putInt(str, ((Integer) t).intValue());
        }
        if (t instanceof Long) {
            fVar.putLong(str, ((Long) t).longValue());
        }
        if (t instanceof Float) {
            fVar.putFloat(str, ((Float) t).floatValue());
        }
        if (t instanceof Boolean) {
            fVar.putBoolean(str, ((Boolean) t).booleanValue());
        }
        if (t instanceof String) {
            fVar.putString(str, (String) t);
        }
    }

    private static Object a(Context context, String str, String str2, String str3) {
        String strB = b(str);
        if (!b(context, strB, str2)) {
            return null;
        }
        if (str3.equalsIgnoreCase("string")) {
            return a.a(context, strB, str2, (String) null);
        }
        if (str3.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(a.a(context, strB, str2, false));
        }
        if (str3.equalsIgnoreCase("int")) {
            return Integer.valueOf(a.a(context, strB, str2, 0));
        }
        if (str3.equalsIgnoreCase("long")) {
            return Long.valueOf(a.a(context, strB, str2, 0L));
        }
        if (str3.equalsIgnoreCase("float")) {
            return Float.valueOf(a.a(context, strB, str2, 0.0f));
        }
        if (str3.equalsIgnoreCase("string_set")) {
            return a.a(context, strB, str2, (String) null);
        }
        return null;
    }

    public static void a(Context context, String str, String str2) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
                b.b.a.a.b.a(context, str).c().remove(str2).apply();
                return;
            }
            SharedPreferences sharedPreferencesC = c(context, str);
            if (sharedPreferencesC == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
            editorEdit.remove(str2);
            editorEdit.apply();
            SoftReference<ConcurrentHashMap<String, Map<String, Object>>> softReference = a;
            if (softReference == null || softReference.get() == null) {
                return;
            }
            Map<String, Object> map = a.get().get(b(str));
            if (map != null && map.size() != 0) {
                map.remove(str2);
            }
        } catch (Throwable unused) {
        }
    }

    static void a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19 && h.e(str)) {
            b.b.a.a.b.a(context, str).c().clear().apply();
            a(str);
            return;
        }
        SharedPreferences sharedPreferencesC = c(context, str);
        if (sharedPreferencesC == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        editorEdit.clear();
        editorEdit.apply();
        a(str);
    }
}
