package com.bytedance.sdk.openadsdk.core;

import android.util.Base64;
import kotlin.text.Typography;

/* JADX INFO: compiled from: AESKey.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f555b = o.d().r();

    private static String a() {
        char[] cArr = {203, Typography.paragraph, 168, Typography.degree, 207, 148, 149, 178, 205, Typography.paragraph, 149, 166, 134, 178, 184, Typography.degree, 206, Typography.registered, 187, 178, 150, 185, Typography.section, 166};
        char[] cArr2 = new char[24];
        for (int i = 23; i >= 0; i--) {
            cArr2[23 - i] = (char) (cArr[i] ^ 255);
        }
        return new String(cArr2);
    }

    public static String b() {
        return new String(Base64.decode(a, 0)).substring(2);
    }

    public static String c() {
        return new String(Base64.decode(f555b, 0)).substring(2);
    }
}
