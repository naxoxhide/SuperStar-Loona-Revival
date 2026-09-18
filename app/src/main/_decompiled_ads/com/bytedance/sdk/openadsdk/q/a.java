package com.bytedance.sdk.openadsdk.q;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TrackAdUrlUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static int a(int i) {
        if (i != 15) {
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        if (i != 5) {
                            return -1;
                        }
                    }
                }
            }
            return i2;
        }
        return 5;
    }

    public static List<String> a(List<String> list, boolean z) {
        String strC = j.c(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strC)) {
                next = next.replace("{UID}", strC).replace("__UID__", strC);
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            m.b("TrackAdUrlUtils", e.getMessage());
            return str;
        }
    }

    public static List<String> a(List<String> list, boolean z, q qVar) {
        String strC = j.c(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strC)) {
                next = next.replace("{UID}", strC).replace("__UID__", strC);
            }
            if (next.contains("__CID__") && qVar != null && !TextUtils.isEmpty(qVar.e())) {
                next = next.replace("__CID__", qVar.e());
            }
            if (next.contains("__CTYPE__") && qVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(a(qVar.c0())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", b.c.a.a.a.b.a.b().a());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(a0.t()));
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
