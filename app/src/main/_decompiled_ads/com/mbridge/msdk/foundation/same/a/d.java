package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StaticDataPoll.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {
    public static Map<String, Long> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f2102b = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> c = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> e = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> g = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> h = new HashMap();
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> i = new HashMap();
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b>> j = null;
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> k = null;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> l = null;
    private static final String m = "d";

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD = d(str2);
        if (campaignEx == null || mapD == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.d.a aVar = new com.mbridge.msdk.foundation.same.d.a(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (mapD.containsKey(str)) {
                List<com.mbridge.msdk.foundation.same.d.a> list = mapD.get(str);
                if (list != null && list.size() == 20) {
                    list.remove(0);
                }
                if (list != null) {
                    list.add(aVar);
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            mapD.put(str, arrayList);
        } catch (Throwable th) {
            aa.b(m, th.getMessage(), th);
        }
    }

    public static String a(String str, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD;
        List<com.mbridge.msdk.foundation.same.d.a> list;
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            mapD = d(str2);
        } else {
            mapD = null;
            if (c.containsKey(str)) {
                mapD = c;
            } else if (d.containsKey(str)) {
                mapD = d;
            } else if (e.containsKey(str)) {
                mapD = e;
            } else if (f.containsKey(str)) {
                mapD = f;
            } else if (g.containsKey(str)) {
                mapD = g;
            } else if (h.containsKey(str)) {
                mapD = h;
            } else if (i.containsKey(str)) {
                mapD = i;
            }
        }
        if (mapD != null) {
            try {
                if (ak.b(str) && mapD.containsKey(str) && (list = mapD.get(str)) != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i2).a());
                        jSONObject.put("1", list.get(i2).b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static void a(String str, String str2, String str3, long j2, long j3, long j4) {
        if (j == null) {
            j = new ConcurrentHashMap<>();
        }
        try {
            if (j.containsKey(str)) {
                ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> concurrentHashMap = j.get(str);
                if (concurrentHashMap != null) {
                    com.mbridge.msdk.foundation.entity.b bVar = concurrentHashMap.get(str2);
                    if (bVar == null) {
                        com.mbridge.msdk.foundation.entity.b bVar2 = new com.mbridge.msdk.foundation.entity.b();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str3);
                        bVar2.a(arrayList);
                        bVar2.a(j2);
                        bVar2.b(j3);
                        bVar2.c(j4);
                        concurrentHashMap.put(str2, bVar2);
                        return;
                    }
                    if (bVar.c() != null) {
                        bVar.a(j2);
                        bVar.b(j3);
                        bVar.c(j4);
                        bVar.c().add(str3);
                        return;
                    }
                    return;
                }
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str3);
            ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> concurrentHashMap2 = new ConcurrentHashMap<>();
            com.mbridge.msdk.foundation.entity.b bVar3 = new com.mbridge.msdk.foundation.entity.b();
            bVar3.a(arrayList2);
            bVar3.a(j2);
            bVar3.b(j3);
            bVar3.c(j4);
            concurrentHashMap2.put(str2, bVar3);
            j.put(str, concurrentHashMap2);
        } catch (Throwable th) {
            aa.d(m, th.getMessage());
        }
    }

    public static void b(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = j) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            j.remove(str);
            return;
        }
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> concurrentHashMap2 = j.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2)) {
            return;
        }
        concurrentHashMap2.remove(str2);
    }

    public static ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b>> concurrentHashMap = j;
        if (concurrentHashMap == null) {
            f fVarA = f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
            if (fVarA != null) {
                fVarA.d(str, "");
                j = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return j.get(str);
        }
        return null;
    }

    public static void a(String str, String str2, int i2) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        int size;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (k == null) {
            k = new ConcurrentHashMap<>();
        }
        try {
            if (k.containsKey(str)) {
                copyOnWriteArrayList = k.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                k.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            if (copyOnWriteArrayList == null || (size = copyOnWriteArrayList.size() - i2) < 0) {
                return;
            }
            for (int i3 = 0; i3 < size; i3++) {
                copyOnWriteArrayList.remove(i3);
            }
        } catch (Exception e2) {
            aa.a(m, e2.getMessage());
        }
    }

    public static void b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = k) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = k.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }

    public static String c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        return (TextUtils.isEmpty(str) || (concurrentHashMap = k) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = k.get(str)) == null || copyOnWriteArrayList.size() <= 0) ? "" : copyOnWriteArrayList.get(0);
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (l == null) {
                l = new ConcurrentHashMap<>();
            }
            if (l.containsKey(str)) {
                if (l.get(str) == null) {
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                    concurrentHashMap.put(str2, str3);
                    l.put(str, concurrentHashMap);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(str2, str3);
            l.put(str, concurrentHashMap2);
        } catch (Exception e2) {
            aa.a(m, e2.getMessage());
        }
    }

    public static com.mbridge.msdk.foundation.entity.c c(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        com.mbridge.msdk.foundation.entity.c cVar = new com.mbridge.msdk.foundation.entity.c();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return cVar;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = l;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = l.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                cVar.b(1);
                cVar.c(concurrentHashMap.get(str2));
            }
        } catch (Exception e2) {
            aa.a(m, e2.getMessage());
        }
        return cVar;
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = l;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = l.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e2) {
            aa.a(m, e2.getMessage());
        }
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d(String str) {
        str.hashCode();
        switch (str) {
            case "banner":
                return g;
            case "native":
                return c;
            case "reward":
                return d;
            case "splash":
                return h;
            case "h5_native":
                return i;
            case "interstitial":
                return f;
            case "interactive":
                return e;
            default:
                return null;
        }
    }
}
