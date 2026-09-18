package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: compiled from: AESUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.component.utils.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AESUtils.java */
    static class C0162a {
        static final Random a = a.c();
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String strB = b(jSONObject.toString());
                if (TextUtils.isEmpty(strB)) {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                } else {
                    jSONObject2.put("message", strB);
                    jSONObject2.put("cypher", 3);
                }
            } catch (Throwable unused) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
            }
        } catch (Throwable th) {
            m.a(th.getMessage());
        }
        return jSONObject2;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strB = b();
        String strA = a(strB, 32);
        String strA2 = a();
        String strB2 = null;
        if (strA != null && strA2 != null) {
            strB2 = b.b.a.a.g.a.b(str, strA2, strA);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(3).append(strB).append(strA2).append(strB2);
        return sb.toString();
    }

    public static Random c() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public static String b() {
        String strA = a(16);
        if (strA == null || strA.length() != 32) {
            return null;
        }
        return strA;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strA = a(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strA == null) ? str : b.b.a.a.g.a.a(str.substring(49), strSubstring, strA);
    }

    public static String a(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    public static String a() {
        String strA = a(8);
        if (strA == null || strA.length() != 16) {
            return null;
        }
        return strA;
    }

    public static String a(int i) {
        try {
            byte[] bArr = new byte[i];
            C0162a.a.nextBytes(bArr);
            return e.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
