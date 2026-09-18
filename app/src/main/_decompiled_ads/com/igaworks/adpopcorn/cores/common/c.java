package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.WindowManager;
import com.tapjoy.TapjoyConstants;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static Display a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public static String a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKeySpec);
        return a(mac.doFinal(str2.getBytes()));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = b2 + (b2 < 0 ? (byte) 256 : (byte) 0);
            if (i2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toString(i2, 16));
        }
        return stringBuffer.toString();
    }

    public static String b(Context context) {
        if (context == null) {
            return "unKnown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "unKnown";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING)) {
                return TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
            }
            if (networkInfo2 != null) {
                return (networkInfo2.getState() == NetworkInfo.State.CONNECTED || networkInfo2.getState() == NetworkInfo.State.CONNECTING) ? TapjoyConstants.TJC_CONNECTION_TYPE_WIFI : "unknown";
            }
            return "unknown";
        } catch (Exception e) {
            h.a(context, "[ADPOPCORN]", "Get Custom Network Info Error", 0);
            e.printStackTrace();
            return "unKnown";
        }
    }

    public static boolean c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (connectivityManager == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
        } catch (SecurityException unused) {
        } catch (Exception unused2) {
            return false;
        }
        return true;
    }
}
