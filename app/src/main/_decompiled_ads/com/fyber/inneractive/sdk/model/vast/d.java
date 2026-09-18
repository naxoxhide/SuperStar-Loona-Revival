package com.fyber.inneractive.sdk.model.vast;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f961b;
    public int c = a();
    public final int d;

    public static class a implements Comparator<d> {
        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            return dVar.c - dVar2.c;
        }
    }

    public d(String str, String str2) {
        this.a = str;
        this.f961b = str2;
        this.d = b(str2);
    }

    public final int a() {
        String str;
        if (this.d != 2 || (str = this.f961b) == null) {
            return -1;
        }
        ArrayList arrayList = (ArrayList) a(str);
        return (((((Integer) arrayList.get(0)).intValue() * 60 * 60) + (((Integer) arrayList.get(1)).intValue() * 60) + ((Integer) arrayList.get(2)).intValue()) * 1000) + ((Integer) arrayList.get(3)).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d  */
    public int b(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !str.startsWith("-")) {
            if (str.endsWith("%")) {
                if (str.endsWith("%")) {
                    try {
                        int iB = b();
                        if (iB < 0 || iB > 100) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } catch (NumberFormatException e) {
                        IAlog.e("ProgressTrackingEvent: failed isPercentageOffsetValid with %s", e.getMessage());
                    }
                } else {
                    z = false;
                }
                if (z) {
                    return 1;
                }
            }
            if (str.contains(CertificateUtil.DELIMITER)) {
                ArrayList arrayList = (ArrayList) a(str);
                if (!arrayList.isEmpty() && ((Integer) arrayList.get(0)).intValue() >= 0 && ((Integer) arrayList.get(1)).intValue() >= 0 && ((Integer) arrayList.get(2)).intValue() >= 0 && ((Integer) arrayList.get(3)).intValue() >= 0) {
                    return 2;
                }
            }
        }
        return 0;
    }

    public List<Integer> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String[] strArrSplit = str.split(CertificateUtil.DELIMITER);
        if (strArrSplit.length != 3) {
            return arrayList;
        }
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        String[] strArrSplit2 = strArrSplit[2].split("\\.");
        String str4 = strArrSplit2[0];
        String str5 = strArrSplit2.length > 1 ? strArrSplit2[1] : "000";
        try {
            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str3)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str4)));
            arrayList.add(Integer.valueOf(Integer.parseInt(str5)));
            return arrayList;
        } catch (NumberFormatException e) {
            IAlog.e("ProgressTrackingEvent: failed convertOffsetToTimeList with %s", e.getMessage());
            return new ArrayList();
        }
    }

    public int b() {
        if (TextUtils.isEmpty(this.f961b)) {
            return -1;
        }
        String str = this.f961b;
        return Integer.parseInt(str.substring(0, str.length() - 1));
    }
}
