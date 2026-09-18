package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.out.MBridgeIds;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONObject;

/* JADX INFO: compiled from: MetricsReportUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class m {
    private static volatile m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2181b = "";
    private ConcurrentHashMap<String, Map<String, String>> c = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, c> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, String>> e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, Map<String, String>>> f = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, String>> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, com.mbridge.msdk.foundation.entity.e>> h = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> i = new ConcurrentHashMap<>();
    private Executor j = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.report.m.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("mb-common-report-thread");
            return threadNewThread;
        }
    });
    private volatile com.mbridge.msdk.e.m k;

    private b.a b(String str, String str2) {
        String str3;
        String str4;
        HashMap map = new HashMap();
        ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.c;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str2)) {
            return null;
        }
        Map<String, String> map2 = this.c.get(str2);
        if (map2 != null) {
            String str5 = map2.get("unitId");
            String str6 = map2.get("adtp");
            map.putAll(map2);
            str3 = str5;
            str4 = str6;
        } else {
            str3 = null;
            str4 = null;
        }
        return b(str, str2, "", str3, str4, map);
    }

    private b.a b(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        ConcurrentHashMap<String, Map<String, String>> concurrentHashMap;
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        b.a aVar = null;
        if (!TextUtils.isEmpty(str) && contextG != null) {
            try {
                String strH = com.mbridge.msdk.foundation.controller.b.d().h();
                HashMap map2 = new HashMap();
                long jCurrentTimeMillis = System.currentTimeMillis();
                map2.put(CampaignEx.JSON_KEY_ST_TS, String.valueOf(jCurrentTimeMillis));
                Map<String, String> map3 = new HashMap<>();
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.e;
                if (concurrentHashMap2 != null) {
                    map3 = concurrentHashMap2.get(str2);
                }
                if ((map3 == null || map3.size() == 0) && (concurrentHashMap = this.g) != null) {
                    map3 = concurrentHashMap.get(str2);
                }
                String str6 = "";
                if (map3 != null && map3.size() > 0 && map3.containsKey("lrid")) {
                    str6 = map3.get("lrid");
                }
                if (TextUtils.isEmpty(str6)) {
                    map2.put("lrid", str2);
                } else {
                    map2.put("lrid", str6);
                }
                b.a aVarA = b.a(str, str3).a(contextG).d(str4).b(strH).e(str5).a(str).c(this.f2181b).b(jCurrentTimeMillis).a(this.j).a(map2).a(map);
                if (aVarA == null) {
                    return null;
                }
                aVar = aVarA;
                if (aVar != null) {
                    aVar.a(map);
                }
            } catch (Exception e) {
                aa.a("MetricsReportUtil", e.getMessage());
            }
        }
        return aVar;
    }

    private void a(String str, String str2, Map<String, String> map, boolean z) {
        a(str, str2, map, z, 0);
    }

    private void a(String str, String str2, Map<String, String> map, boolean z, int i) {
        Map<String, Map<String, String>> map2;
        Map<String, String> map3;
        if (TextUtils.isEmpty(str2)) {
            b(str, map);
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map4 = null;
        try {
            if (i == 1) {
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.e;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(str2)) {
                    map4 = this.e.get(str2);
                }
            } else {
                ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.g;
                if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str2)) {
                    map4 = this.g.get(str2);
                }
            }
            if (map4 != null) {
                map.putAll(map4);
            }
            if (this.f.containsKey(str2) && (map2 = this.f.get(str2)) != null) {
                if ((map2.containsKey("2000127") || map2.containsKey("2000048") || map2.containsKey("2000152")) && (map3 = map2.get(str)) != null) {
                    map.putAll(map3);
                }
                Map<String, String> map5 = map2.get("0");
                if (map5 != null && !map5.isEmpty()) {
                    map.putAll(map5);
                }
            }
            b.a aVarB = b(str, str2);
            if (aVarB == null) {
                return;
            }
            aVarB.a(map);
            if ((str.equals("2000127") || str.equals("2000128") || str.equals("2000129") || str.equals("2000130") || str.equals("2000137")) && this.e.containsKey(str2)) {
                Map<String, String> map6 = this.e.get(str2);
                if (aVarB != null && map6 != null) {
                    aVarB.a(map6);
                }
            }
            aVarB.b(z);
            if (str.equals("2000047") || str.equals("2000048")) {
                aVarB.a(true);
            }
            b bVarA = aVarB.a();
            if (bVarA == null) {
                return;
            }
            if (str.equals("2000127")) {
                a(str2, bVarA);
            }
            ConcurrentHashMap<String, c> concurrentHashMap3 = this.d;
            if (concurrentHashMap3 != null && concurrentHashMap3.containsKey(str2)) {
                c cVar = this.d.get(str2);
                if (cVar != null) {
                    if (str.equals("2000125")) {
                        cVar.a(bVarA, "2000123", false, false).b();
                    } else if (str.equals("2000126")) {
                        cVar.a(bVarA, "2000125", false, true).b();
                    } else if (str.equals("2000127")) {
                        cVar.a(bVarA, "2000123", false, false).b();
                    } else if (str.equals("2000133")) {
                        cVar.a(bVarA, "2000154", false, true).b();
                    } else if (str.equals("2000047") || str.equals("2000048")) {
                        cVar.a(bVarA, "2000123", false, true).b();
                    } else if (str.equals("2000154")) {
                        cVar.a(bVarA, "2000127", false, false).b();
                    } else if (str.equals("2000155")) {
                        cVar.a(bVarA, "2000154", false, true).b();
                    } else {
                        bVarA.b();
                    }
                }
            } else {
                bVarA.b();
            }
            if ("2000151".equals(str)) {
                b(str2);
            }
        } catch (Exception e) {
            aa.a("MetricsReportUtil", e.getMessage());
        }
    }

    private void b(String str, Map<String, String> map) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (map != null) {
            try {
                if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    String str2 = map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                    String str3 = (TextUtils.isEmpty(str2) || (concurrentHashMap = this.i) == null || !concurrentHashMap.containsKey(str2)) ? "" : this.i.get(str2);
                    if (c(str3, "")) {
                        map.remove(MBridgeConstans.PROPERTIES_UNIT_ID);
                        b(str, "", str2, str3, map);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(String str) {
        try {
            ConcurrentHashMap<String, Map<String, String>> concurrentHashMap = this.c;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                Map<String, String> map = this.c.get(str);
                String str2 = map != null ? map.get("adtp") : "";
                return c(str2, "");
            }
            return false;
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    private boolean c(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && (str2.equals(BidResponsed.KEY_BID_ID) || str2.equals("buyer_id") || str2.equals("roas") || str2.equals("InitSDK"))) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int i = Integer.parseInt(str);
            if (i != 94 && i != 279) {
                if (i == 296) {
                    return ac.a().a("r_l_b_m_t_b", false);
                }
                if (i != 287 && i != 288) {
                    return false;
                }
            }
            return ac.a().a("r_l_b_m_t_r_i", true);
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
            return false;
        }
    }

    public static m a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m();
                }
            }
        }
        return a;
    }

    public final void a(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("unitId", str2);
        map.put("adtp", str3);
        if (this.c == null) {
            this.c = new ConcurrentHashMap<>();
        }
        this.c.put(str, map);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Map<String, String> map2;
        ConcurrentHashMap<String, String> concurrentHashMap = this.i;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str4, str5);
        }
        if (TextUtils.isEmpty(str2)) {
            b(str, str3, str4, str5, map);
            return;
        }
        if (c(str5, str3)) {
            Map<String, String> map3 = map == null ? new HashMap() : map;
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
            try {
                HashMap map4 = new HashMap();
                map4.put("unitId", str4);
                map4.put("adtp", str5);
                if (map3 != null) {
                    if (map3.containsKey(CampaignEx.JSON_KEY_HB) && map3.get(CampaignEx.JSON_KEY_HB) != null) {
                        map4.put(CampaignEx.JSON_KEY_HB, map3.get(CampaignEx.JSON_KEY_HB));
                    } else {
                        map4.put(CampaignEx.JSON_KEY_HB, "0");
                    }
                    if (map3.containsKey("bid_tk") && map3.get("bid_tk") != null) {
                        map4.put("bid_tk", map3.get("bid_tk"));
                    }
                }
                this.c.put(str2, map4);
                b.a aVarB = b(str, str2, str3, str4, str5, map3);
                if (aVarB != null && !TextUtils.isEmpty(str2)) {
                    ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.g;
                    if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0 && this.g.containsKey(str2) && map3 != null && (map2 = this.g.get(str2)) != null) {
                        map3.putAll(map2);
                    }
                    if (map3 != null && map3.size() > 0) {
                        aVarB.a(map3);
                    }
                    if (str.equals("2000123")) {
                        aVarB.a(true);
                    }
                    b bVarA = aVarB.a();
                    if (bVarA == null) {
                        return;
                    }
                    if (str.equals("2000123") && !TextUtils.isEmpty(str3)) {
                        a(str2, bVarA);
                        if (str3.equals("auto_load") || str3.equals("self_load")) {
                            return;
                        }
                    }
                    bVarA.b();
                }
            } catch (Exception e) {
                aa.a("MetricsReportUtil", e.getMessage());
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (TextUtils.isEmpty(str) || contextG == null) {
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                aa.a("MetricsReportUtil", e.getMessage());
                return;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put(CampaignEx.JSON_KEY_ST_TS, String.valueOf(jCurrentTimeMillis));
        b.a aVarA = b.a(str, str2).a(contextG).d(str3).b(com.mbridge.msdk.foundation.controller.b.d().h()).e(str4).a(false).b(jCurrentTimeMillis).a(this.j);
        if (aVarA == null) {
            return;
        }
        aVarA.a(map);
        b bVarA = aVarA.a();
        if (bVarA == null) {
            return;
        }
        bVarA.b();
    }

    public final void b(String str, String str2, String str3, String str4, Map<String, String> map) {
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (TextUtils.isEmpty(str) || contextG == null || !c(str4, str2)) {
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                aa.a("MetricsReportUtil", e.getMessage());
                return;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put(CampaignEx.JSON_KEY_ST_TS, String.valueOf(jCurrentTimeMillis));
        b.a aVarA = b.a(str, str2).a(contextG).d(str3).b(com.mbridge.msdk.foundation.controller.b.d().h()).e(str4).a(false).b(jCurrentTimeMillis).a(this.j);
        if (aVarA == null) {
            return;
        }
        aVarA.a(map);
        b bVarA = aVarA.a();
        if (bVarA == null) {
            return;
        }
        bVarA.b();
    }

    public final void a(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str2)) {
            b(str, map);
        } else if (a(str2)) {
            a(str, str2, map, false);
        }
    }

    public final void a(String str, List<CampaignEx> list, Map<String, String> map) {
        CampaignEx campaignEx;
        if (list == null || list.size() == 0 || (campaignEx = list.get(0)) == null || !c(campaignEx.getAdType() + "", "")) {
            return;
        }
        try {
            Map<String, String> mapA = a(list);
            if (list.size() > 1) {
                this.e.put(campaignEx.getCurrentLRid(), mapA);
            } else {
                this.g.put(campaignEx.getCurrentLRid(), mapA);
            }
            if (mapA != null) {
                map.putAll(mapA);
            }
            if (TextUtils.isEmpty(campaignEx.getCurrentLRid())) {
                b(str, "", campaignEx.getCampaignUnitId(), campaignEx.getAdType() + "", map);
            } else {
                a(str, campaignEx.getCurrentLRid(), map, false, 1);
            }
        } catch (Exception e) {
            aa.a("MetricsReportUtil", e.getMessage());
        }
    }

    public final void a(String str, CampaignEx campaignEx, Map<String, String> map) {
        if (campaignEx != null && c(campaignEx.getAdType() + "", "")) {
            if (map != null) {
                try {
                    if (map.containsKey("update")) {
                        a(campaignEx);
                        map.remove("update");
                    }
                } catch (Exception e) {
                    aa.a("MetricsReportUtil", e.getMessage());
                    return;
                }
            }
            if (TextUtils.isEmpty(campaignEx.getCurrentLRid())) {
                b(str, "", campaignEx.getCampaignUnitId(), campaignEx.getAdType() + "", map);
            } else {
                a(str, campaignEx.getCurrentLRid(), map, false);
            }
        }
    }

    public final void b(String str, String str2, Map<String, String> map) {
        try {
            if (TextUtils.isEmpty(str2)) {
                b(str, map);
            } else if (a(str2)) {
                a(str, str2, map, false, 1);
            }
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    public final void a(String str, MBridgeIds mBridgeIds, Map<String, String> map) {
        if (mBridgeIds == null || TextUtils.isEmpty(mBridgeIds.getLocalRequestId())) {
            b(str, map);
        } else if (a(mBridgeIds.getLocalRequestId())) {
            a(str, mBridgeIds.getLocalRequestId(), map, false);
        }
    }

    public final Map<String, String> a(List<CampaignEx> list) {
        String str = CampaignEx.JSON_KEY_EC_TEMP_ID;
        String str2 = "endcard_crid";
        String str3 = "video_crid";
        String str4 = "vtid";
        String str5 = "crid";
        HashMap map = new HashMap();
        try {
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null) {
                    map.put("rid", campaignEx.getRequestId() + "");
                    if (campaignEx.getMof_tplid() != 0) {
                        map.put("stid", campaignEx.getMof_tplid() + "");
                    }
                    CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                    if (rewardTemplateMode != null && rewardTemplateMode.b() != 0) {
                        if (map.containsKey(str4)) {
                            map.put(str4, ((String) map.get(str4)) + "," + rewardTemplateMode.b());
                        } else {
                            map.put(str4, rewardTemplateMode.b() + "");
                        }
                    }
                    if (campaignEx.getCreativeId() != 0) {
                        if (map.containsKey(str5)) {
                            map.put(str5, ((String) map.get(str5)) + "," + campaignEx.getCreativeId());
                        } else {
                            map.put(str5, campaignEx.getCreativeId() + "");
                        }
                    }
                    if (campaignEx.getVidCrtvId() != 0) {
                        if (map.containsKey(str3)) {
                            map.put(str3, ((String) map.get(str3)) + "," + campaignEx.getVidCrtvId());
                        } else {
                            map.put(str3, campaignEx.getVidCrtvId() + "");
                        }
                    }
                    if (campaignEx.getEcCrtvId() != 0) {
                        if (map.containsKey(str2)) {
                            map.put(str2, ((String) map.get(str2)) + "," + campaignEx.getEcCrtvId());
                        } else {
                            map.put(str2, campaignEx.getEcCrtvId() + "");
                        }
                    }
                    if (campaignEx.getEcTemplateId() != 0) {
                        if (map.containsKey(str)) {
                            map.put(str, ((String) map.get(str)) + "," + campaignEx.getEcTemplateId());
                        } else {
                            map.put(str, campaignEx.getEcTemplateId() + "");
                        }
                    }
                    String str6 = str;
                    String str7 = str2;
                    String str8 = "1";
                    String str9 = str3;
                    String str10 = str4;
                    String str11 = str5;
                    if (campaignEx.isDynamicView()) {
                        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                            map.put("sdyv", "1");
                        }
                        if (map.containsKey("vdyv")) {
                            map.put("vdyv", ((String) map.get("vdyv")) + ",1");
                        } else {
                            map.put("vdyv", "1");
                        }
                        boolean zJ = af.j(campaignEx.getendcard_url());
                        if (map.containsKey("edyv")) {
                            if (zJ) {
                                map.put("edyv", ((String) map.get("edyv")) + ",2");
                            } else {
                                map.put("edyv", ((String) map.get("edyv")) + ",1");
                            }
                        } else if (zJ) {
                            map.put("edyv", "2");
                        } else {
                            map.put("edyv", "1");
                        }
                    } else {
                        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                            map.put("sdyv", "2");
                        }
                        if (map.containsKey("vdyv")) {
                            map.put("vdyv", ((String) map.get("vdyv")) + ",2");
                        } else {
                            map.put("vdyv", "2");
                        }
                        if (map.containsKey("edyv")) {
                            map.put("edyv", ((String) map.get("edyv")) + ",2");
                        } else {
                            map.put("edyv", "2");
                        }
                    }
                    if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
                        JSONObject jSONObject = new JSONObject(campaignEx.getExt_data());
                        if (map.containsKey("dspid")) {
                            map.put("dspid", ((String) map.get("dspid")) + "," + jSONObject.optString("par_dspid"));
                        } else {
                            map.put("dspid", jSONObject.optString("par_dspid"));
                        }
                    }
                    if (campaignEx.getPlayable_ads_without_video() == 2) {
                        if (map.containsKey("only_ec")) {
                            map.put("only_ec", ((String) map.get("only_ec")) + ",2");
                        } else {
                            map.put("only_ec", "2");
                        }
                    } else if (map.containsKey("only_ec")) {
                        map.put("only_ec", ((String) map.get("only_ec")) + ",1");
                    } else {
                        map.put("only_ec", "1");
                    }
                    if (!TextUtils.isEmpty(campaignEx.getExpIds())) {
                        map.put(CampaignEx.URL_KEY_EXP_IDS, campaignEx.getExpIds());
                    }
                    if (map.containsKey(BidResponsedEx.KEY_CID)) {
                        map.put(BidResponsedEx.KEY_CID, ((String) map.get(BidResponsedEx.KEY_CID)) + "," + campaignEx.getId());
                    } else {
                        map.put(BidResponsedEx.KEY_CID, campaignEx.getId());
                    }
                    if (map.containsKey("rid_n")) {
                        map.put("rid_n", ((String) map.get("rid_n")) + "," + campaignEx.getRequestIdNotice());
                    } else {
                        map.put("rid_n", campaignEx.getRequestIdNotice());
                    }
                    map.put("bid_tk", campaignEx.getBidToken() + "");
                    if (!campaignEx.isBidCampaign()) {
                        str8 = "0";
                    }
                    map.put(CampaignEx.JSON_KEY_HB, str8);
                    map.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT() + "");
                    map.put("n_rid", campaignEx.getNRid());
                    map.put("n_lrid", campaignEx.getNLRid());
                    map.put("lrid", campaignEx.getLocalRequestId());
                    if (com.mbridge.msdk.foundation.controller.b.c != null) {
                        String str12 = com.mbridge.msdk.foundation.controller.b.c.get(campaignEx.getCampaignUnitId());
                        if (!TextUtils.isEmpty(str12)) {
                            map.put("u_stid", str12);
                        }
                    }
                    str = str6;
                    str2 = str7;
                    str3 = str9;
                    str4 = str10;
                    str5 = str11;
                }
            }
        } catch (Exception e) {
            aa.a("MetricsReportUtil", e.getMessage());
        }
        return map;
    }

    public final void a(String str, Map<String, String> map) {
        if (map != null && map.containsKey("r_stid")) {
            this.f2181b = map.get("r_stid");
            map.remove("r_stid");
        }
        c(str, "0", map);
    }

    public final void c(String str, String str2, Map<String, String> map) {
        Map<String, Map<String, String>> map2;
        if (a(str) && !TextUtils.isEmpty(str)) {
            try {
                ConcurrentHashMap<String, Map<String, Map<String, String>>> concurrentHashMap = this.f;
                if (concurrentHashMap != null) {
                    if (!concurrentHashMap.containsKey(str) || (map2 = this.f.get(str)) == null) {
                        map2 = new HashMap<>();
                    }
                    map2.put(str2, map);
                    this.f.put(str, map2);
                }
            } catch (Exception e) {
                aa.a("MetricsReportUtil", e.getMessage());
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        Map<String, String> map;
        if (campaignEx == null) {
            return;
        }
        try {
            b(campaignEx);
            if (c(campaignEx.getAdType() + "", "")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(campaignEx);
                Map<String, String> mapA = a(arrayList);
                if (this.g.containsKey(campaignEx.getCurrentLRid()) && (map = this.g.get(campaignEx.getCurrentLRid())) != null && map.size() > 0) {
                    map.putAll(mapA);
                    this.g.put(campaignEx.getCurrentLRid(), map);
                } else {
                    this.g.put(campaignEx.getCurrentLRid(), mapA);
                }
            }
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    public final void b(List<CampaignEx> list) {
        Map<String, String> map;
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            CampaignEx campaignEx = list.get(0);
            String currentLRid = campaignEx != null ? campaignEx.getCurrentLRid() : "";
            b(campaignEx);
            if (a(currentLRid)) {
                Map<String, String> mapA = a(list);
                if (this.e.containsKey(currentLRid) && (map = this.e.get(currentLRid)) != null && map.size() > 0) {
                    map.putAll(mapA);
                    this.e.put(currentLRid, map);
                } else {
                    this.e.put(currentLRid, mapA);
                }
            }
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    private void b(CampaignEx campaignEx) {
        ConcurrentHashMap<String, Map<String, String>> concurrentHashMap;
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getCurrentLRid()) || (concurrentHashMap = this.c) == null || concurrentHashMap.containsKey(campaignEx.getCurrentLRid())) {
                    return;
                }
                HashMap map = new HashMap();
                map.put("unitId", campaignEx.getCampaignUnitId());
                map.put("adtp", campaignEx.getAdType() + "");
                map.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? "1" : "0");
                if (!TextUtils.isEmpty(campaignEx.getBidToken())) {
                    map.put("bid_tk", campaignEx.getBidToken());
                }
                this.c.put(campaignEx.getCurrentLRid(), map);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(com.mbridge.msdk.foundation.entity.n nVar, CampaignEx campaignEx) {
        b bVarA;
        if (nVar == null) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("result", nVar.C() + "");
            if (!TextUtils.isEmpty(nVar.x()) && !nVar.x().equals("0")) {
                map.put("duration", nVar.x() + "");
            }
            if (!TextUtils.isEmpty(nVar.n())) {
                map.put("rus_rid", nVar.n() + "");
            }
            if (!TextUtils.isEmpty(nVar.m())) {
                map.put("rs_rid", nVar.m() + "");
            }
            map.put("reason", nVar.w() + "");
            map.put(CampaignEx.ENDCARD_URL, nVar.g());
            map.put("network_type", nVar.z() + "");
            map.put("network_str", nVar.A());
            map.put("rid_n", nVar.p());
            map.put(BidResponsedEx.KEY_CID, nVar.r() + "");
            if (nVar.s().equals("2000022")) {
                map.put(CampaignEx.JSON_KEY_IMAGE_URL, nVar.e());
                map.put("template_url", nVar.j());
                map.put(CampaignEx.JSON_KEY_VIDEO_LENGTHL, nVar.u() + "");
                map.put(CampaignEx.JSON_KEY_VIDEO_SIZE, nVar.y() + "");
                map.put("video_url", nVar.f());
            } else if (nVar.s().equals("2000043")) {
                map.put("mraid_type", nVar.k() + "");
                map.put("type", nVar.h() + "");
            } else if (nVar.s().equals("2000045")) {
                map.put("type", nVar.d() + "");
                if (nVar.d() == 1 || nVar.d() == 2) {
                    map.remove("duration");
                }
            }
            String strS = nVar.s();
            try {
                String currentLRid = campaignEx.getCurrentLRid();
                String campaignUnitId = campaignEx.getCampaignUnitId();
                int adType = campaignEx.getAdType();
                map.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? "1" : "0");
                map.put("bid_tk", campaignEx.getBidToken());
                ArrayList arrayList = new ArrayList();
                arrayList.add(campaignEx);
                Map<String, String> mapA = a(arrayList);
                if (mapA != null) {
                    map.putAll(mapA);
                }
                b.a aVarB = b(strS, currentLRid, "", campaignUnitId, adType + "", map);
                if (aVarB == null || (bVarA = aVarB.a()) == null) {
                    return;
                }
                bVarA.b();
            } catch (Exception e) {
                aa.d("MetricsReportUtil", e.getMessage());
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:136:0x0399 A[Catch: Exception -> 0x04a1, TryCatch #10 {Exception -> 0x04a1, blocks: (B:136:0x0399, B:138:0x03a3, B:140:0x03af, B:142:0x03bb, B:144:0x03c7, B:154:0x03e4, B:134:0x0394, B:160:0x03f5, B:163:0x0403, B:191:0x0499, B:166:0x040b, B:168:0x042a, B:170:0x0430, B:172:0x043b, B:176:0x044a, B:178:0x0453, B:180:0x045d, B:183:0x0474, B:181:0x0466, B:185:0x0489, B:187:0x0490, B:188:0x0494, B:147:0x03d2, B:149:0x03d6, B:151:0x03dc), top: B:218:0x016b, inners: #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:226:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String str, String str2, List<CampaignEx> list, String str3, String str4) {
        int iL;
        Object obj;
        String str5;
        m mVar;
        int size;
        int iL2;
        Map<String, com.mbridge.msdk.foundation.entity.e> map;
        HashMap map2 = new HashMap();
        String str6 = "reason2";
        String str7 = "";
        if (list != null) {
            for (CampaignEx campaignEx : list) {
                if (campaignEx != null) {
                    if (TextUtils.isEmpty((CharSequence) map2.get(BidResponsedEx.KEY_CID))) {
                        map2.put(BidResponsedEx.KEY_CID, campaignEx.getId());
                    } else {
                        map2.put(BidResponsedEx.KEY_CID, ((String) map2.get(BidResponsedEx.KEY_CID)) + "," + campaignEx.getId());
                    }
                    if (TextUtils.isEmpty((CharSequence) map2.get(CampaignEx.JSON_KEY_RETARGET_TYPE))) {
                        map2.put(CampaignEx.JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType() + "");
                    } else {
                        map2.put(CampaignEx.JSON_KEY_RETARGET_TYPE, ((String) map2.get(CampaignEx.JSON_KEY_RETARGET_TYPE)) + "," + campaignEx.getRtinsType());
                    }
                    if (TextUtils.isEmpty((CharSequence) map2.get("rid_n"))) {
                        map2.put("rid_n", campaignEx.getRequestIdNotice());
                    } else {
                        map2.put("rid_n", ((String) map2.get("rid_n")) + "," + campaignEx.getRequestIdNotice());
                    }
                    if (TextUtils.isEmpty((CharSequence) map2.get(CampaignEx.JSON_KEY_VIDEO_SIZE))) {
                        map2.put(CampaignEx.JSON_KEY_VIDEO_SIZE, campaignEx.getVideoSize() + "");
                    } else {
                        map2.put(CampaignEx.JSON_KEY_VIDEO_SIZE, ((String) map2.get(CampaignEx.JSON_KEY_VIDEO_SIZE)) + "," + campaignEx.getVideoSize());
                    }
                    if (campaignEx.getErrTypeByDefaultAd() != -1) {
                        map2.put("type2", String.valueOf(campaignEx.getErrTypeByDefaultAd()));
                    }
                    if (!TextUtils.isEmpty(campaignEx.getErrReasonByDefaultAd())) {
                        map2.put("reason2", campaignEx.getErrReasonByDefaultAd());
                    }
                }
            }
        }
        try {
            CampaignEx campaignEx2 = null;
            try {
                if ("2000047".equals(str)) {
                    String str8 = TextUtils.isEmpty(str3) ? "unknown_unit_id" : str3;
                    try {
                        ConcurrentHashMap<String, Map<String, com.mbridge.msdk.foundation.entity.e>> concurrentHashMap = this.h;
                        com.mbridge.msdk.foundation.entity.e eVar = (concurrentHashMap == null || !concurrentHashMap.containsKey(str8) || (map = this.h.get(str8)) == null || !map.containsKey(str4)) ? null : map.get(str4);
                        String str9 = "unknown_unit_id".equals(str8) ? "" : str8;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            HashMap map3 = new HashMap();
                            if (eVar != null) {
                                try {
                                    map3.put("type", eVar.c() + "");
                                    map3.put("reason", eVar.d());
                                    if (eVar.e() != 0) {
                                        map3.put("code", eVar.e() + "");
                                    }
                                    if (eVar.a() != -1) {
                                        map3.put("type2", eVar.a() + "");
                                    }
                                    if (!TextUtils.isEmpty(eVar.b())) {
                                        map3.put("reason2", eVar.b());
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    obj = this;
                                    str5 = str2;
                                    try {
                                        str6 = r8;
                                        aa.d(str6, e.getMessage());
                                        mVar = obj;
                                        if (eVar != null) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        str6 = r8;
                                        aa.d(str6, e.getMessage());
                                    }
                                }
                            }
                            Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                            if (contextG != null) {
                                map3.put("network_available", af.d(contextG) + "");
                            }
                            if (list == null || list.size() <= 0) {
                                size = 0;
                            } else {
                                campaignEx2 = list.get(0);
                                size = list.size();
                            }
                            obj = "adtp";
                            if (campaignEx2 != null) {
                                String currentLRid = campaignEx2.getCurrentLRid();
                                try {
                                    map3.put(BidResponsedEx.KEY_CID, campaignEx2.getId());
                                    map3.put("adtp", campaignEx2.getAdType() + "");
                                    map3.put(CampaignEx.JSON_KEY_HB, campaignEx2.isBidCampaign() ? "1" : "0");
                                    if (campaignEx2.getRewardTemplateMode() != null) {
                                        if (!TextUtils.isEmpty(campaignEx2.getMof_template_url())) {
                                            iL2 = af.l(campaignEx2.getMof_template_url());
                                        } else {
                                            iL2 = af.l(campaignEx2.getRewardTemplateMode().e());
                                        }
                                        if (iL2 != 0) {
                                            map3.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, iL2 + "");
                                        }
                                    }
                                    str5 = currentLRid;
                                } catch (Exception e3) {
                                    e = e3;
                                    obj = this;
                                    str5 = currentLRid;
                                    str6 = r8;
                                    aa.d(str6, e.getMessage());
                                    mVar = obj;
                                    if (eVar != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            } else {
                                if (!map2.isEmpty()) {
                                    map3.put(CampaignEx.JSON_KEY_HB, map2.get("isBid"));
                                }
                                str5 = str2;
                            }
                            try {
                                map2.remove("isBid");
                                map3.put("network_type", w.r(contextG) + "");
                                map3.put(MBridgeConstans.PROPERTIES_UNIT_ID, str9);
                                if (!TextUtils.isEmpty(str9)) {
                                    map3.put("u_stid", com.mbridge.msdk.foundation.controller.b.c.get(str9));
                                }
                                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.l)) {
                                    map3.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.l);
                                }
                                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.m)) {
                                    map3.put("c", com.mbridge.msdk.foundation.same.a.m);
                                }
                                map3.putAll(map2);
                                if (TextUtils.isEmpty(str5)) {
                                    b(str, "load fail", str9, (eVar == null || eVar.f() == null) ? "" : eVar.f().get("adtp"), map3);
                                    obj = this;
                                } else {
                                    try {
                                        if (size > 1) {
                                            m mVar2 = this;
                                            mVar2.b(str, str5, map3);
                                            obj = mVar2;
                                        } else {
                                            m mVar3 = this;
                                            mVar3.a(str, str5, map3);
                                            obj = mVar3;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        str6 = r8;
                                        aa.d(str6, e.getMessage());
                                        mVar = obj;
                                    }
                                }
                                str6 = "MetricsReportUtil";
                                mVar = obj;
                            } catch (Exception e5) {
                                e = e5;
                                obj = this;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            obj = this;
                        }
                        if (eVar != null || TextUtils.isEmpty(eVar.d()) || eVar.d().contains("current unit is loading") || eVar.d().contains("checkOverCap failed") || eVar.d().contains("bidToken is empty")) {
                            return;
                        }
                        mVar.b(str5);
                        if (TextUtils.isEmpty(str9)) {
                            return;
                        }
                        try {
                            ConcurrentHashMap<String, Map<String, com.mbridge.msdk.foundation.entity.e>> concurrentHashMap2 = mVar.h;
                            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str9)) {
                                return;
                            }
                            mVar.h.remove(str9);
                            return;
                        } catch (Exception e7) {
                            aa.d(str6, e7.getMessage());
                            return;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } else {
                    str6 = "MetricsReportUtil";
                    Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                    if (contextG2 == null || list == null || TextUtils.isEmpty(str3)) {
                        return;
                    }
                    try {
                        map2.put("network_type", w.r(contextG2) + "");
                        map2.put(MBridgeConstans.PROPERTIES_UNIT_ID, str3);
                        if (list != null && list.size() > 0) {
                            campaignEx2 = list.get(0);
                        }
                        if (campaignEx2 != null) {
                            String currentLRid2 = campaignEx2.getCurrentLRid();
                            map2.put(CampaignEx.JSON_KEY_HB, campaignEx2.isBidCampaign() ? "1" : "0");
                            if (campaignEx2.getRewardTemplateMode() != null) {
                                if (!TextUtils.isEmpty(campaignEx2.getMof_template_url())) {
                                    iL = af.l(campaignEx2.getMof_template_url());
                                } else {
                                    iL = af.l(campaignEx2.getRewardTemplateMode().e());
                                }
                                if (iL != 0) {
                                    map2.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, iL + "");
                                }
                            }
                            str7 = currentLRid2;
                        }
                        if (list.size() > 1) {
                            b(str, str7, map2);
                            return;
                        } else {
                            a(str, str7, map2);
                            return;
                        }
                    } catch (Exception e9) {
                        aa.d(str6, e9.getMessage());
                        return;
                    }
                }
            } catch (Exception e10) {
                e = e10;
            }
            e = e10;
        } catch (Exception e11) {
            e = e11;
            str6 = "MetricsReportUtil";
        }
        aa.d(str6, e.getMessage());
    }

    public final com.mbridge.msdk.foundation.entity.e a(String str, String str2) {
        Map<String, com.mbridge.msdk.foundation.entity.e> map;
        ConcurrentHashMap<String, Map<String, com.mbridge.msdk.foundation.entity.e>> concurrentHashMap = this.h;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str) || (map = this.h.get(str)) == null || !map.containsKey(str2)) {
            return null;
        }
        return map.get(str2);
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.e eVar) {
        if (eVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown_unit_id";
        }
        if (this.h == null) {
            this.h = new ConcurrentHashMap<>();
        }
        String strD = eVar.d();
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        if (!this.h.containsKey(str)) {
            HashMap map = new HashMap();
            map.put(strD, eVar);
            this.h.put(str, map);
        } else {
            Map<String, com.mbridge.msdk.foundation.entity.e> map2 = this.h.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            if (map2.size() >= 200) {
                map2.clear();
            }
            map2.put(strD, eVar);
        }
    }

    private void a(String str, b bVar) {
        if (this.d.containsKey(str)) {
            c cVar = this.d.get(str);
            if (cVar != null) {
                cVar.a(bVar);
                return;
            }
            return;
        }
        c cVar2 = new c();
        cVar2.a(bVar);
        this.d.put(str, cVar2);
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ConcurrentHashMap<String, Map<String, Map<String, String>>> concurrentHashMap = this.f;
            if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
                this.f.remove(str);
            }
            ConcurrentHashMap<String, Map<String, String>> concurrentHashMap2 = this.c;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str)) {
                this.c.remove(str);
            }
            ConcurrentHashMap<String, c> concurrentHashMap3 = this.d;
            if (concurrentHashMap3 != null && concurrentHashMap3.containsKey(str)) {
                this.d.remove(str);
            }
            ConcurrentHashMap<String, Map<String, String>> concurrentHashMap4 = this.e;
            if (concurrentHashMap4 != null && concurrentHashMap4.containsKey(str)) {
                this.e.remove(str);
            }
            ConcurrentHashMap<String, Map<String, String>> concurrentHashMap5 = this.g;
            if (concurrentHashMap5 == null || !concurrentHashMap5.containsKey(str)) {
                return;
            }
            this.g.remove(str);
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    public final void b() {
        if (this.k != null) {
            this.k.e();
        }
    }

    public final void c() {
        if (ac.a().a("metrics", "e_t_l", ac.a().a("e_t_l", 0)) == 1) {
            d().e();
        }
    }

    public final com.mbridge.msdk.e.m d() {
        if (this.k == null) {
            this.k = com.mbridge.msdk.e.m.a("mtg_sdk", com.mbridge.msdk.foundation.controller.b.d().g(), e());
            this.k.a(h.c());
            this.k.a();
        }
        return this.k;
    }

    private com.mbridge.msdk.e.w e() {
        com.mbridge.msdk.e.o oVar;
        int iA = ac.a().a("metrics", "t_m_e_t", ac.a().a("t_m_e_t", 604800000));
        int iA2 = ac.a().a("metrics", "t_m_e_s", ac.a().a("t_m_e_s", 50));
        int iA3 = ac.a().a("metrics", "t_m_r_c", ac.a().a("t_m_r_c", 50));
        int iA4 = ac.a().a("metrics", "t_m_t", ac.a().a("t_m_t", 15000));
        int iA5 = ac.a().a("metrics", "t_m_r_t_s", ac.a().a("t_m_r_t_s", 2));
        int iA6 = ac.a().a("metrics", "t_r_t", ac.a().a("t_r_t", 0));
        if (iA6 != 0 && iA6 != 1) {
            iA6 = 0;
        }
        try {
            com.mbridge.msdk.e.w.a aVarA = new com.mbridge.msdk.e.w.a().e(iA).a(iA2).d(iA3).b(iA4).c(iA5).a(new i()).a(h.a()).a(new u());
            if (iA6 == 1) {
                oVar = new com.mbridge.msdk.e.o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.f.d.a().h, com.mbridge.msdk.foundation.same.net.f.d.a().l);
            } else {
                oVar = new com.mbridge.msdk.e.o(new com.mbridge.msdk.e.a.a.g(), DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS, 0);
            }
            com.mbridge.msdk.e.w.a aVarA2 = aVarA.a(iA6, oVar);
            com.mbridge.msdk.e.a.a = MBridgeConstans.DEBUG;
            return aVarA2.a();
        } catch (Exception e) {
            aa.d("EventLibraryReport", "configTrackManager error: " + e.getMessage());
            return null;
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, int i) {
        com.mbridge.msdk.e.m mVarD = a().d();
        if (mVarD == null) {
            return;
        }
        if (!mVarD.a("2000105")) {
            aa.a("MetricsReportUtil", "reportClickImpException can not track");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("url", "");
            } else {
                jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
            }
            jSONObject.put("type", i);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("rid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("rid_n", str4);
            }
            try {
                long[] jArrF = mVarD.f();
                jSONObject.put("track_time", jArrF[0]);
                jSONObject.put("track_count", jArrF[1]);
                jSONObject.put("session_id", mVarD.b());
            } catch (Exception unused) {
            }
            jSONObject.put("reason", URLEncoder.encode(str, "utf-8"));
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("2000105");
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
            eVar.a(h.b());
            mVarD.a(eVar);
        } catch (Exception e) {
            aa.d("MetricsReportUtil", e.getMessage());
        }
    }

    public final void a(CampaignEx campaignEx, Context context, String str, String str2, boolean z, String str3, String str4, long j, String str5) {
        int iA;
        com.mbridge.msdk.e.m mVarD = a().d();
        if (mVarD == null) {
            return;
        }
        if (!mVarD.a("2000078")) {
            aa.a("MetricsReportUtil", "report78ByTrackManager can not track");
            return;
        }
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
            if (campaignEx != null) {
                jSONObject.put(BidResponsedEx.KEY_CID, campaignEx.getId());
                jSONObject.put("adtp", campaignEx.getAdType());
            }
            if (z) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            } else {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("rid", str3);
            } else if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getRequestId())) {
                jSONObject.put("rid", campaignEx.getRequestId());
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("rid_n", str4);
            } else if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getRequestIdNotice())) {
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            }
            jSONObject.put("during", j);
            jSONObject.put("reason", str);
            jSONObject.put("r_stid", str5);
            try {
                long[] jArrF = mVarD.f();
                jSONObject.put("track_time", jArrF[0]);
                jSONObject.put("track_count", jArrF[1]);
                jSONObject.put("session_id", mVarD.b());
            } catch (Exception unused) {
            }
            if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && (iA = com.mbridge.msdk.foundation.same.b.a(campaignEx, campaignEx.getRewardTemplateMode().e())) != -1) {
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, iA);
            }
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("2000078");
            eVar.a(jSONObject);
            eVar.a(0);
            eVar.b(0);
            eVar.a(h.b());
            mVarD.a(eVar);
        } catch (Exception e) {
            aa.d("MetricsReportUtil", "reportEntryLoadFailedMessage error:" + e.getMessage());
        }
    }
}
