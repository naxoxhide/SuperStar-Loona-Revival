package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class j1 {
    public static final j1 f = new j1();
    public Context a;
    public File d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f2772b = null;
    public SharedPreferences c = null;
    public final ThreadPoolExecutor e = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public final synchronized String a(URL url) {
        String str;
        String string;
        try {
            String string2 = url.toString();
            try {
                String strConvertToHex = TapjoyUtil.convertToHex(MessageDigest.getInstance("SHA-1").digest(string2.getBytes()));
                String string3 = this.c.getString(strConvertToHex, null);
                if (string3 == null) {
                    this.c.edit().putString(strConvertToHex, string2).commit();
                    return strConvertToHex;
                }
                if (string3.equals(string2)) {
                    return strConvertToHex;
                }
                int i = 0;
                do {
                    i++;
                    str = strConvertToHex + "_" + i;
                    string = this.c.getString(str, null);
                    if (string == null) {
                        break;
                    }
                } while (!string.equals(string2));
                this.c.edit().putString(str, string2).commit();
                return str;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
