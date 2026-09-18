package com.tapjoy.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class d5 {
    public float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2743b;

    public static d5 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            d5 d5Var = new d5();
            int length = str.length() - 1;
            char cCharAt = str.charAt(length);
            if (cCharAt == 'w') {
                d5Var.a = Float.valueOf(str.substring(0, length)).floatValue();
                d5Var.f2743b = 1;
            } else if (cCharAt == 'h') {
                d5Var.a = Float.valueOf(str.substring(0, length)).floatValue();
                d5Var.f2743b = 2;
            } else {
                d5Var.a = Float.valueOf(str).floatValue();
                d5Var.f2743b = 0;
            }
            return d5Var;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final float a(float f, float f2) {
        int i = this.f2743b;
        if (i == 1) {
            return (this.a * f) / 100.0f;
        }
        if (i == 2) {
            return (this.a * f2) / 100.0f;
        }
        return this.a;
    }
}
