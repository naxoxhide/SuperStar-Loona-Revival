package com.tapjoy.internal;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e5 {
    public static String a(PackageManager packageManager, String str) {
        Signature[] signatureArr;
        try {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
            signatureArr = null;
        }
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(signatureArr[0].toByteArray()), 2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static int b(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    public static String c(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
