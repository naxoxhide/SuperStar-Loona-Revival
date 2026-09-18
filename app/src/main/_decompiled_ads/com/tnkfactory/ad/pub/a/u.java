package com.tnkfactory.ad.pub.a;

import com.tnkfactory.framework.crypto.EncryptUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class u {
    public static Map<String, String> a = new HashMap();

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.HashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public static String a(String str) {
        String str2 = (String) a.get(str);
        if (str2 != null) {
            return str2;
        }
        String strDecryptRC4 = EncryptUtils.decryptRC4(str);
        a.put(str, strDecryptRC4);
        return strDecryptRC4;
    }
}
