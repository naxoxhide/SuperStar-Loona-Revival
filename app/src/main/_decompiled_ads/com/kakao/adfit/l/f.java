package com.kakao.adfit.l;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;

/* JADX INFO: compiled from: VastTimeFormat.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static long a(String str) {
        int i;
        long j = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf > 0) {
                String strSubstring = str.substring(0, iIndexOf);
                j = 0 + ((long) Integer.parseInt(str.substring(iIndexOf + 1)));
                str = strSubstring;
            }
            String[] strArrSplit = str.split(CertificateUtil.DELIMITER);
            int length = strArrSplit.length;
            if (length == 1) {
                i = Integer.parseInt(strArrSplit[0]);
            } else if (length == 2) {
                j += ((long) Integer.parseInt(strArrSplit[0])) * 60000;
                i = Integer.parseInt(strArrSplit[1]);
            } else {
                if (length != 3) {
                    return j;
                }
                j = j + (((long) Integer.parseInt(strArrSplit[0])) * 3600000) + (((long) Integer.parseInt(strArrSplit[1])) * 60000);
                i = Integer.parseInt(strArrSplit[2]);
            }
            return j + (((long) i) * 1000);
        } catch (Exception unused) {
            com.kakao.adfit.k.f.b("Invalid Duration");
            return 0L;
        }
    }
}
