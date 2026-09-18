package com.kakao.adfit.n;

import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: HttpHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static com.kakao.adfit.common.volley.a.C0448a a(com.kakao.adfit.m.d dVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = dVar.c;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpHeaders.DATE);
        long jB = str != null ? b(str) : 0L;
        String str2 = map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            int i2 = 0;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get(HttpHeaders.EXPIRES);
        long jB2 = str3 != null ? b(str3) : 0L;
        String str4 = map.get(HttpHeaders.LAST_MODIFIED);
        long jB3 = str4 != null ? b(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j4 = jCurrentTimeMillis + (j * 1000);
            if (i != 0) {
                j3 = j4;
            } else {
                j3 = j4;
                j4 += j2 * 1000;
            }
        } else {
            j3 = 0;
            if (jB <= 0 || jB2 < jB) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jB2 - jB);
                j3 = j4;
            }
        }
        com.kakao.adfit.common.volley.a.C0448a c0448a = new com.kakao.adfit.common.volley.a.C0448a();
        c0448a.a = dVar.f1851b;
        c0448a.f1716b = str5;
        c0448a.f = j3;
        c0448a.e = j4;
        c0448a.c = jB;
        c0448a.d = jB3;
        c0448a.g = map;
        c0448a.h = dVar.d;
        return c0448a;
    }

    public static long b(String str) {
        try {
            return a("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                com.kakao.adfit.common.volley.h.d("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            com.kakao.adfit.common.volley.h.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static List<com.kakao.adfit.m.b> b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.kakao.adfit.m.b(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    static String a(long j) {
        return a("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get(HttpHeaders.CONTENT_TYPE)) != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "UTF-8");
    }

    static Map<String, String> a(List<com.kakao.adfit.m.b> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.kakao.adfit.m.b bVar : list) {
            treeMap.put(bVar.a(), bVar.b());
        }
        return treeMap;
    }

    static List<com.kakao.adfit.m.b> a(List<com.kakao.adfit.m.b> list, com.kakao.adfit.common.volley.a.C0448a c0448a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<com.kakao.adfit.m.b> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<com.kakao.adfit.m.b> list2 = c0448a.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (com.kakao.adfit.m.b bVar : c0448a.h) {
                    if (!treeSet.contains(bVar.a())) {
                        arrayList.add(bVar);
                    }
                }
            }
        } else if (!c0448a.g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0448a.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new com.kakao.adfit.m.b(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    static Map<String, String> a(com.kakao.adfit.common.volley.a.C0448a c0448a) {
        HashMap map = new HashMap();
        if (c0448a == null) {
            return map;
        }
        String str = c0448a.f1716b;
        if (str != null) {
            map.put(HttpHeaders.IF_NONE_MATCH, str);
        }
        long j = c0448a.d;
        if (j > 0) {
            map.put(HttpHeaders.IF_MODIFIED_SINCE, a(j));
        }
        return map;
    }
}
