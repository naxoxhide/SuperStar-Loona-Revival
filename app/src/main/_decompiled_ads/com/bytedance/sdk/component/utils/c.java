package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.facebook.internal.security.CertificateUtil;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: AppSigning.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static HashMap<String, ArrayList<String>> a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        String strA;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (a.get(str) != null) {
                return a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : b(context, packageName)) {
                    if (SameMD5.TAG.equals(str)) {
                        strA = a(signature, SameMD5.TAG);
                    } else if ("SHA1".equals(str)) {
                        strA = a(signature, "SHA1");
                    } else {
                        strA = "SHA256".equals(str) ? a(signature, "SHA256") : "error!";
                    }
                    arrayList.add(strA);
                }
            } catch (Exception e) {
                m.b(e.toString());
            }
            a.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            m.b(e.toString());
            return null;
        }
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListA = a(context, "SHA1");
        if (arrayListA != null && arrayListA.size() != 0) {
            for (int i = 0; i < arrayListA.size(); i++) {
                sb.append(arrayListA.get(i));
                if (i < arrayListA.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] bArrDigest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(CertificateUtil.DELIMITER);
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
        } catch (Exception e) {
            m.b(e.toString());
        }
        return "error!";
    }
}
