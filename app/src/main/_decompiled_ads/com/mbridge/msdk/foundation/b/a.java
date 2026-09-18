package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseCandidateCache.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2059b = "BaseCandidateCache";
    protected com.mbridge.msdk.foundation.db.c a;
    private String c;
    private JSONArray d;

    public final void a(JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        String ecppv = list.get(0).getEcppv();
        if (TextUtils.isEmpty(ecppv)) {
            return;
        }
        String strB = u.b(ecppv);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            if (Double.parseDouble(strB) <= 0.0d) {
                return;
            }
            JSONObject jSONObjectE = e(b(str));
            int iOptInt = jSONObjectE != null ? jSONObjectE.optInt("max_cache_num", 20) : 20;
            com.mbridge.msdk.foundation.db.c cVar = this.a;
            if (cVar == null || iOptInt <= 0) {
                return;
            }
            cVar.a(list, this.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str, String str2, int i, String str3) {
        try {
            if (this.a == null || TextUtils.isEmpty(str3)) {
                return;
            }
            if (i == 1) {
                this.a.a(str2, str, this.c, i);
            } else if (i == 2) {
                this.a.a(this.c, str2, str);
            } else if (i == 3) {
                this.a.b(str2, str, this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String b(String str) {
        c cVarD = d(str);
        if (cVarD != null && cVarD.a() != c.d && cVarD.a() != c.f2062b) {
            String[] strArrSplit = u.b(str.split("_")[3]).split("\\|");
            if (strArrSplit.length > 1) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    public final double c(String str) {
        c cVarD = d(str);
        if (cVarD != null && cVarD.a() != c.d && cVarD.a() != c.f2062b) {
            try {
                String[] strArrSplit = u.b(str.split("_")[3]).split("\\|");
                if (strArrSplit.length > 0) {
                    return Double.parseDouble(strArrSplit[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1.0d;
    }

    public final c d(String str) {
        c cVar = new c();
        if (TextUtils.isEmpty(str) || str.split("_").length <= 3 || TextUtils.isEmpty(str.split("_")[3])) {
            cVar.a("bid token exception");
            cVar.a(c.f2062b);
            return cVar;
        }
        JSONArray jSONArray = this.d;
        if (jSONArray == null || jSONArray.length() == 0) {
            cVar.a("config is empty");
            cVar.a(c.f2062b);
            return cVar;
        }
        String strB = u.b(str.split("_")[3]);
        if (TextUtils.isEmpty(strB)) {
            cVar.a("bid token exception:decode error");
            cVar.a(c.f2062b);
            return cVar;
        }
        if (strB.split("\\|").length == 0) {
            cVar.a("bid token can not get bid price");
            cVar.a(c.f2062b);
            return cVar;
        }
        if (TextUtils.isEmpty(this.c)) {
            cVar.a("unitId is empty");
            cVar.a(c.d);
        }
        return cVar;
    }

    public final void a(List<CampaignEx> list, String str, String str2, int i, String str3, int i2, double d) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        CampaignEx campaignEx = list.get(i3);
                        campaignEx.setReadyState(0);
                        campaignEx.setNLRid(str);
                        campaignEx.setNRid(str2);
                        campaignEx.setErrReasonByDefaultAd(str3);
                        campaignEx.setErrTypeByDefaultAd(i);
                        String strA = u.a(d + "");
                        campaignEx.setNoticeUrl(a(campaignEx.getNoticeUrl(), i2, str2, strA));
                        campaignEx.setClickURL(a(campaignEx.getClickURL(), i2, str2, strA));
                        campaignEx.setImpressionURL(a(campaignEx.getImpressionURL(), i2, str2, strA));
                        campaignEx.setOnlyImpressionURL(a(campaignEx.getOnlyImpressionURL(), i2, str2, strA));
                        campaignEx.setAdvImp(a(campaignEx.getAdvImpList(), i2, str2, strA));
                        j nativeVideoTracking = campaignEx.getNativeVideoTracking();
                        if (nativeVideoTracking != null) {
                            nativeVideoTracking.k(a(nativeVideoTracking.l(), i2, str2, strA));
                            nativeVideoTracking.c(a(nativeVideoTracking.c(), i2, str2, strA));
                            nativeVideoTracking.o(a(nativeVideoTracking.p(), i2, str2, strA));
                            nativeVideoTracking.s(a(nativeVideoTracking.t(), i2, str2, strA));
                            nativeVideoTracking.a(a(nativeVideoTracking.a(), i2, str2, strA));
                            nativeVideoTracking.b(a(nativeVideoTracking.b(), i2, str2, strA));
                            nativeVideoTracking.r(a(nativeVideoTracking.s(), i2, str2, strA));
                            nativeVideoTracking.u(a(nativeVideoTracking.v(), i2, str2, strA));
                            nativeVideoTracking.t(a(nativeVideoTracking.v(), i2, str2, strA));
                            nativeVideoTracking.v(a(nativeVideoTracking.w(), i2, str2, strA));
                            nativeVideoTracking.h(a(nativeVideoTracking.h(), i2, str2, strA));
                            nativeVideoTracking.p(a(nativeVideoTracking.q(), i2, str2, strA));
                            nativeVideoTracking.q(a(nativeVideoTracking.r(), i2, str2, strA));
                            nativeVideoTracking.n(a(nativeVideoTracking.o(), i2, str2, strA));
                            nativeVideoTracking.e(a(nativeVideoTracking.e(), i2, str2, strA));
                            nativeVideoTracking.f(a(nativeVideoTracking.f(), i2, str2, strA));
                            nativeVideoTracking.g(a(nativeVideoTracking.g(), i2, str2, strA));
                            nativeVideoTracking.i(a(nativeVideoTracking.j(), i2, str2, strA));
                            nativeVideoTracking.j(a(nativeVideoTracking.k(), i2, str2, strA));
                            nativeVideoTracking.l(a(nativeVideoTracking.m(), i2, str2, strA));
                            nativeVideoTracking.a(a(nativeVideoTracking.i(), i2, str2, strA));
                            nativeVideoTracking.d(a(nativeVideoTracking.d(), i2, str2, strA));
                            nativeVideoTracking.m(a(nativeVideoTracking.n(), i2, str2, strA));
                            campaignEx.setNativeVideoTracking(nativeVideoTracking);
                            campaignEx.setNativeVideoTrackingString(CampaignEx.object2TrackingStr(nativeVideoTracking));
                        }
                        campaignEx.setPv_urls(b(campaignEx.getPv_urls(), i2, str2, strA));
                    }
                    if (list.size() == 1) {
                        m.a().a(list.get(0));
                    } else {
                        m.a().b(list);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String a(Map<Integer, String> map, int i, String str, String str2) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                String value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CampaignEx.JSON_AD_IMP_KEY, entry.getKey());
                jSONObject.put("url", a(value, i, str, str2));
                jSONArray.put(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray.toString();
    }

    private List<Map<Integer, String>> a(List<Map<Integer, String>> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Map<Integer, String> map = list.get(i2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    map.put(entry.getKey(), a(entry.getValue(), i, str, str2));
                }
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    private List<String> b(List<String> list, int i, String str, String str2) {
        if (list == null || list.size() == 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(a(list.get(i2), i, str, str2));
        }
        return arrayList;
    }

    private String[] a(String[] strArr, int i, String str, String str2) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = a(strArr[i2], i, str, str2);
        }
        return strArr2;
    }

    private String a(String str, int i, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.contains("ca_sce") || str.contains("real_rid") || str.contains("real_bp")) {
            return str;
        }
        if (al.b(str) > 0) {
            return str + "&ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
        }
        return str + "?ca_sce=" + i + "&real_rid=" + str2 + "&real_bp=" + str3;
    }

    public final c a() {
        c cVar = new c();
        try {
            JSONArray jSONArray = this.d;
            if (jSONArray != null && jSONArray.length() != 0) {
                if (this.a == null) {
                    cVar.a("db error");
                    cVar.a(c.d);
                    return cVar;
                }
                return cVar;
            }
            cVar.a("setting config is null");
            cVar.a(c.f2062b);
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final JSONObject e(String str) {
        JSONArray jSONArray = this.d;
        if (jSONArray == null) {
            return null;
        }
        if (jSONArray.length() > 1) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int i = 0; i < this.d.length(); i++) {
                try {
                    JSONObject jSONObjectOptJSONObject = this.d.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.getString("g"))) {
                        return jSONObjectOptJSONObject;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return this.d.optJSONObject(0);
    }

    public final void a(List<C0477a> list, int i) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list, new Comparator<C0477a>() { // from class: com.mbridge.msdk.foundation.b.a.1
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(C0477a c0477a, C0477a c0477a2) {
                            return Double.compare(c0477a.a, c0477a2.a);
                        }
                    });
                    int size = list.size() - i;
                    if (size > 0) {
                        List<C0477a> listSubList = list.subList(0, size);
                        if (this.a == null || listSubList.size() <= 0) {
                            return;
                        }
                        for (int i2 = 0; i2 < listSubList.size(); i2++) {
                            b bVar = listSubList.get(i2).f2060b;
                            this.a.a(this.c, bVar.a(), bVar.b());
                        }
                    }
                }
            } catch (Exception e) {
                aa.a(f2059b, e);
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseCandidateCache.java */
    public static class C0477a {
        private double a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f2060b;

        public C0477a(double d, b bVar) {
            this.a = d;
            this.f2060b = bVar;
        }

        public final b a() {
            return this.f2060b;
        }
    }

    public final List<b> a(int i) {
        com.mbridge.msdk.foundation.db.c cVar;
        if (i >= 0 && (cVar = this.a) != null) {
            cVar.a(this.c, i);
        }
        com.mbridge.msdk.foundation.db.c cVar2 = this.a;
        if (cVar2 != null) {
            return cVar2.a(this.c);
        }
        return null;
    }
}
