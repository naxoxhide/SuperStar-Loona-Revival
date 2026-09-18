package com.mbridge.msdk.reward.a;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mbridge.msdk.foundation.b.d;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.reward.adapter.c;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardCandidateController.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static String a = "RewardCandidateController";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f2353b;

    public a(String str, boolean z) {
        try {
            this.f2353b = com.mbridge.msdk.foundation.controller.a.a().a(str, b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str, z).H());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(List<CampaignEx> list, String str, c cVar) {
        try {
            d dVar = this.f2353b;
            if (dVar != null) {
                dVar.a(list, str);
                d dVar2 = this.f2353b;
                JSONObject jSONObjectE = dVar2.e(dVar2.b(str));
                if (jSONObjectE == null || this.f2353b.c(str) <= 0.0d) {
                    return;
                }
                int iOptInt = jSONObjectE.optInt("max_usage_limit", 10);
                a(this.f2353b.a(iOptInt), jSONObjectE, jSONObjectE.optInt("max_cache_num", 20), -1.0d, cVar, "", str, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final com.mbridge.msdk.foundation.b.c a(String str, String str2, CampaignEx campaignEx, e eVar, int i, c cVar) {
        String requestId;
        int iC;
        String strD;
        com.mbridge.msdk.foundation.b.c cVarA;
        try {
            if (!com.mbridge.msdk.foundation.controller.a.a().a) {
                return null;
            }
            com.mbridge.msdk.foundation.controller.a.a().a = false;
            if (campaignEx == null) {
                requestId = "";
            } else {
                try {
                    requestId = campaignEx.getRequestId();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (eVar != null) {
                iC = eVar.c();
                strD = eVar.d();
            } else {
                iC = 0;
                strD = null;
            }
            d dVar = this.f2353b;
            if (dVar == null) {
                cVarA = new com.mbridge.msdk.foundation.b.c();
                cVarA.a("can not get manager");
                cVarA.a(com.mbridge.msdk.foundation.b.c.d);
            } else {
                com.mbridge.msdk.foundation.b.c cVarD = dVar.d(str);
                if (cVarD.a() > com.mbridge.msdk.foundation.b.c.a) {
                    return cVarD;
                }
                String[] strArrSplit = u.b(str.split("_")[3]).split("\\|");
                double d = Double.parseDouble(strArrSplit[0]);
                cVarA = a(d, strArrSplit.length > 1 ? strArrSplit[1] : "", cVar, str2, str);
                this.f2353b.a(cVarA.c(), str2, requestId, iC, strD, i, d);
            }
            return cVarA;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private com.mbridge.msdk.foundation.b.c a(double d, String str, c cVar, String str2, String str3) {
        com.mbridge.msdk.foundation.b.c cVarA = this.f2353b.a();
        try {
            if (cVarA.a() > 0) {
                return cVarA;
            }
            JSONObject jSONObjectE = this.f2353b.e(str);
            if (jSONObjectE != null) {
                int iOptInt = jSONObjectE.optInt("max_usage_limit", 10);
                int iOptInt2 = jSONObjectE.optInt("max_cache_num", 20);
                if (iOptInt2 > 0) {
                    List<com.mbridge.msdk.foundation.b.b> listA = this.f2353b.a(iOptInt);
                    if (listA != null && listA.size() > 0) {
                        return a(listA, jSONObjectE, iOptInt2, d, cVar, str2, str3, true);
                    }
                    cVarA.a("no cache");
                    cVarA.a(com.mbridge.msdk.foundation.b.c.d);
                } else {
                    cVarA.a("max cache num error");
                    cVarA.a(com.mbridge.msdk.foundation.b.c.d);
                }
            } else {
                cVarA.a("setting config not mapping");
                cVarA.a(com.mbridge.msdk.foundation.b.c.d);
            }
            a(str2, 1, d, cVarA, (List<com.mbridge.msdk.foundation.b.a.C0477a>) null, jSONObjectE);
            return cVarA;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private com.mbridge.msdk.foundation.b.c a(List<com.mbridge.msdk.foundation.b.b> list, JSONObject jSONObject, int i, double d, c cVar, String str, String str2, boolean z) {
        int i2;
        double d2;
        double d3;
        List<com.mbridge.msdk.foundation.b.b> list2 = list;
        com.mbridge.msdk.foundation.b.c cVar2 = new com.mbridge.msdk.foundation.b.c();
        if (jSONObject == null) {
            cVar2.a("config is null");
            cVar2.a(com.mbridge.msdk.foundation.b.c.d);
            return cVar2;
        }
        if (list2 == null || list.size() == 0) {
            cVar2.a("candidate is null");
            cVar2.a(com.mbridge.msdk.foundation.b.c.d);
            return cVar2;
        }
        ArrayList arrayList = new ArrayList();
        double dOptDouble = jSONObject.optDouble("t_disc", 0.8d);
        double dOptDouble2 = jSONObject.optDouble("u_disc", 0.95d);
        double dOptDouble3 = jSONObject.optDouble("max_ecppv_diff", 0.0d);
        int iOptInt = jSONObject.optInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, 1800);
        int size = list.size();
        List<String> arrayList2 = new ArrayList<>();
        int i3 = 0;
        if (size > 0) {
            arrayList2 = com.mbridge.msdk.videocommon.a.a.a().c(list2.get(0).c());
        }
        List<String> list3 = arrayList2;
        com.mbridge.msdk.foundation.b.b bVar = null;
        double d4 = 0.0d;
        while (i3 < size) {
            com.mbridge.msdk.foundation.b.b bVar2 = list2.get(i3);
            if (bVar2 != null) {
                i2 = i3;
                d3 = dOptDouble3;
                double dPow = Math.pow(dOptDouble2, bVar2.g()) * bVar2.f() * Math.pow(dOptDouble, (System.currentTimeMillis() - bVar2.e()) / (((double) iOptInt) * 1000.0d));
                if (a(bVar2, cVar, str2)) {
                    d2 = dOptDouble;
                    arrayList.add(new com.mbridge.msdk.foundation.b.a.C0477a(dPow, bVar2));
                    if ((list3 == null || list3.size() <= 0 || !list3.contains(bVar2.a())) && dPow >= d - d3 && dPow > d4) {
                        d4 = dPow;
                        bVar = bVar2;
                    }
                } else {
                    d2 = dOptDouble;
                }
            } else {
                i2 = i3;
                d2 = dOptDouble;
                d3 = dOptDouble3;
            }
            i3 = i2 + 1;
            list2 = list;
            dOptDouble = d2;
            dOptDouble3 = d3;
        }
        d dVar = this.f2353b;
        if (dVar != null) {
            dVar.a(arrayList, i);
        }
        if (bVar != null) {
            cVar2.a(bVar.d());
            cVar2.a(com.mbridge.msdk.foundation.b.c.c);
        } else {
            cVar2.a("no match campaign");
            cVar2.a(com.mbridge.msdk.foundation.b.c.d);
        }
        if (z) {
            a(str, 1, d, cVar2, arrayList, jSONObject);
        }
        return cVar2;
    }

    private boolean a(com.mbridge.msdk.foundation.b.b bVar, c cVar, String str) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListD;
        if (bVar == null || (copyOnWriteArrayListD = bVar.d()) == null || copyOnWriteArrayListD.size() == 0) {
            return false;
        }
        for (int i = 0; i < copyOnWriteArrayListD.size(); i++) {
            CampaignEx campaignEx = copyOnWriteArrayListD.get(i);
            if (af.c(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx.getPackageName())) {
                d dVar = this.f2353b;
                if (dVar != null) {
                    dVar.a(bVar.b(), bVar.a(), 2, campaignEx.getEcppv());
                }
                return false;
            }
            if (cVar != null && !cVar.a((List<CampaignEx>) copyOnWriteArrayListD, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()))) {
                d dVar2 = this.f2353b;
                if (dVar2 != null) {
                    dVar2.a(bVar.b(), bVar.a(), 2, campaignEx.getEcppv());
                }
                return false;
            }
        }
        return true;
    }

    public final boolean a(String str) {
        JSONObject jSONObjectE;
        try {
            d dVar = this.f2353b;
            return (dVar == null || (jSONObjectE = dVar.e(dVar.b(str))) == null || jSONObjectE.optInt("c_cb", 0) != 1) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public final void a(String str, String str2, int i, String str3) {
        d dVar = this.f2353b;
        if (dVar != null) {
            dVar.a(str, str2, i, str3);
        }
    }

    private void a(String str, int i, double d, com.mbridge.msdk.foundation.b.c cVar, List<com.mbridge.msdk.foundation.b.a.C0477a> list, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                aa.d(a, "report lrid is null");
                return;
            }
            HashMap map = new HashMap();
            map.put("type", i + "");
            if (this.f2353b != null) {
                map.put("bp", u.a(d + ""));
                if (jSONObject != null) {
                    map.put("config", jSONObject.toString());
                }
            }
            if (cVar != null) {
                if (cVar.a() == com.mbridge.msdk.foundation.b.c.c) {
                    map.put("result", "1");
                } else {
                    map.put("result", "2");
                    map.put("reason", cVar.b());
                }
            } else {
                map.put("result", "2");
                map.put("reason", "candidate result is null");
            }
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.mbridge.msdk.foundation.b.b bVarA = list.get(i2).a();
                    if (bVarA != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("ecppv", u.a(bVarA.f() + ""));
                        jSONObject2.put("showCount", bVarA.g());
                        jSONObject2.put("intervalTime", System.currentTimeMillis() - bVarA.e());
                        jSONArray.put(jSONObject2);
                    }
                }
                map.put("data", jSONArray.toString());
            }
            m.a().a("m_candidate_data", str, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
