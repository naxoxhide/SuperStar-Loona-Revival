package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardSetting.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private Map<String, Integer> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.videocommon.b.c> f2658b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String i;
    private int j = 0;
    private String k = "";
    private String l = "";

    public final String a() {
        return this.k;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.l;
    }

    public final long d() {
        return this.c * 1000;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final long e() {
        return this.d * 1000;
    }

    public final void b(long j) {
        this.d = j;
    }

    public final long f() {
        return this.e * 1000;
    }

    public final void c(long j) {
        this.e = j;
    }

    public final long g() {
        return this.f;
    }

    public final void d(long j) {
        this.f = j;
    }

    public final long h() {
        return this.g;
    }

    public final void e(long j) {
        this.g = j;
    }

    public final void a(int i) {
        this.j = i;
    }

    public final long i() {
        return this.h;
    }

    public final Map<String, Integer> j() {
        if (this.a == null) {
            HashMap map = new HashMap();
            this.a = map;
            map.put("1", 1000);
            this.a.put("9", 1000);
            this.a.put("8", 1000);
        }
        return this.a;
    }

    public final void a(Map<String, Integer> map) {
        this.a = map;
    }

    public final Map<String, com.mbridge.msdk.videocommon.b.c> k() {
        return this.f2658b;
    }

    public final void b(Map<String, com.mbridge.msdk.videocommon.b.c> map) {
        this.f2658b = map;
    }

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.i = jSONObject.optString("ab_id", "");
                    aVar2.l = jSONObject.optString("rid", "");
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            int iIntValue = Integer.valueOf(jSONObjectOptJSONObject.optInt(next, 1000)).intValue();
                            if (!TextUtils.isEmpty(next)) {
                                if (!TextUtils.isEmpty(next) && iIntValue == 0) {
                                    map.put(next, 1000);
                                } else {
                                    map.put(next, Integer.valueOf(iIntValue));
                                }
                            }
                        }
                        aVar2.a = map;
                    }
                    aVar2.f2658b = com.mbridge.msdk.videocommon.b.c.a(jSONObject.optJSONArray(ReportUtil.EVENT_TYPE_REWARD));
                    aVar2.c = jSONObject.optLong("getpf", 43200L);
                    aVar2.d = jSONObject.optLong("ruct", 5400L);
                    aVar2.e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L);
                    aVar2.f = jSONObject.optLong("dlct", 3600L);
                    aVar2.g = jSONObject.optLong("vcct", 5L);
                    aVar2.h = jSONObject.optLong("current_time");
                    aVar2.k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e) {
                    e = e;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return aVar;
    }

    public final JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.b.c> map2 = this.f2658b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.b.c> entry2 : this.f2658b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.b.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.a());
                            jSONObject3.put("amount", value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put(ReportUtil.EVENT_TYPE_REWARD, jSONArray);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.c);
            jSONObject.put("ruct", this.d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("vtag", this.k);
            jSONObject.put("isDefault", this.j);
            return jSONObject;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }
}
