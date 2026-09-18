package com.igaworks.adpopcorn.cores.common;

import android.content.Context;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static l f1615b;
    private a.d a;

    private l(Context context) {
    }

    public static l a(Context context) {
        if (f1615b == null) {
            f1615b = new l(context);
        }
        return f1615b;
    }

    public static String a(String str) {
        try {
            String string = new BigInteger(1, MessageDigest.getInstance(SameMD5.TAG).digest(str.getBytes())).toString(16);
            while (string.length() < 32) {
                string = "0" + string;
            }
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public a.d a(Context context, a.c cVar) {
        try {
            a.d dVarA = a.a(context, cVar);
            if (dVarA != null) {
                this.a = dVarA;
            }
        } catch (Exception e) {
            h.b(context, "AP_OFFER", "getAndroidADID error : " + e.toString(), 3);
        }
        return this.a;
    }
}
