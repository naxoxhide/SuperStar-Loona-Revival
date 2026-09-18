package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.RoomMasterTable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.PreloadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativePreloadController.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final String d = "b";
    private static Map<String, Map<Long, Object>> e = new HashMap();
    private static Map<String, Boolean> f = new HashMap();
    private static Map<String, k> g = new HashMap();
    private static Map<String, Integer> h = new HashMap();
    private static Map<String, Integer> i = new HashMap();
    private static b j = null;
    private static int u = -1;
    private static int v = -2;
    protected List<Integer> c;
    private e k;
    private com.mbridge.msdk.click.a l;
    private f m;
    private String n;
    private Handler o;
    private Map<String, Object> q;
    private List<Integer> r;
    private List<Integer> s;
    private boolean t;
    private boolean w;
    private int x;
    private int y;
    Queue<Integer> a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Queue<Long> f2307b = null;
    private int p = 0;
    private com.mbridge.msdk.foundation.same.e.b z = new com.mbridge.msdk.foundation.same.e.b(com.mbridge.msdk.foundation.controller.b.d().g());

    public b() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.o = new Handler() { // from class: com.mbridge.msdk.mbnative.controller.b.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
            }
        };
    }

    public final void a(Map<String, Object> map, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        com.mbridge.msdk.b.a.a aVar;
        String str5;
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        List<Campaign> listB;
        Object obj;
        try {
            this.q = map;
            this.w = false;
            if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                String str6 = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                if ((!e.containsKey(((i2 + 1) % 2) + "_" + str6) || e.containsKey(i2 + "_" + str6)) && !TextUtils.isEmpty(str6)) {
                    if (map.containsKey(MBridgeConstans.PREIMAGE)) {
                        this.t = ((Boolean) map.get(MBridgeConstans.PREIMAGE)).booleanValue();
                    }
                    com.mbridge.msdk.click.a aVar2 = this.l;
                    if (aVar2 == null) {
                        this.l = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.b.d().g(), str6);
                    } else {
                        aVar2.a(str6);
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                        this.p = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
                        this.n = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
                    }
                    if (f.containsKey(str6) && f.get(str6).booleanValue()) {
                        Map<String, Map<Long, Object>> map2 = e;
                        Map<Long, Object> map3 = map2.get(i2 + "_" + str6);
                        com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
                        if (map3 != null && map3.size() > 0) {
                            Long next = map3.keySet().iterator().next();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (cVarB == null) {
                                cVarB = com.mbridge.msdk.c.d.a().b();
                            }
                            if (jCurrentTimeMillis - next.longValue() >= cVarB.W() * 1000) {
                                map2.remove(str6);
                            } else if (i2 == 1) {
                                return;
                            }
                        }
                    }
                    f.put(str6, true);
                    this.y = 1;
                    try {
                        if (map.containsKey("ad_num")) {
                            int iIntValue = ((Integer) map.get("ad_num")).intValue();
                            this.y = iIntValue;
                            if (iIntValue < 1) {
                                this.y = 1;
                            }
                            if (this.y > 10) {
                                this.y = 10;
                            }
                        }
                    } catch (Exception unused) {
                        aa.d(d, "ADNUM MUST BE INTEGER");
                    }
                    h.put(str6, Integer.valueOf(this.y));
                    com.mbridge.msdk.b.a.a aVar3 = (!map.containsKey(MBridgeConstans.PRELOAD_RESULT_LISTENER) || (obj = map.get(MBridgeConstans.PRELOAD_RESULT_LISTENER)) == null) ? null : new com.mbridge.msdk.b.a.a((PreloadListener) obj);
                    if (map.containsKey("app_id") && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD)) {
                        str2 = (String) map.get("app_id");
                        str = (String) map.get(MBridgeConstans.APP_KEY);
                    } else {
                        str = null;
                        str2 = null;
                    }
                    if (this.k == null) {
                        this.k = new e();
                    }
                    this.k.a(com.mbridge.msdk.foundation.controller.b.d().g(), str2, str, str6);
                    f fVarE = com.mbridge.msdk.c.d.a().e(str2, str6);
                    this.m = fVarE;
                    if (fVarE == null) {
                        this.m = f.d(str6);
                    }
                    if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                        String str7 = (String) map.get(MBridgeConstans.PLACEMENT_ID);
                        str3 = TextUtils.isEmpty(str7) ? "" : str7;
                    }
                    this.r = this.m.r();
                    this.c = this.m.s();
                    this.s = this.m.s();
                    List<Integer> list = this.r;
                    if (list == null || list.size() <= 0) {
                        com.mbridge.msdk.b.a.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            aVar4.onPreloadFaild("do not have sorceList");
                            return;
                        }
                        return;
                    }
                    this.a = new LinkedList();
                    Iterator<Integer> it = this.r.iterator();
                    while (it.hasNext()) {
                        this.a.add(it.next());
                    }
                    List<Integer> list2 = this.s;
                    if (list2 != null && list2.size() > 0) {
                        this.f2307b = new LinkedList();
                        Iterator<Integer> it2 = this.s.iterator();
                        while (it2.hasNext()) {
                            this.f2307b.add(Long.valueOf(it2.next().intValue() * 1000));
                        }
                    }
                    if (this.r.contains(1) && i2 == 0) {
                        try {
                            str4 = "";
                            com.mbridge.msdk.b.a.a aVar5 = aVar3;
                            str5 = str6;
                            try {
                                a(1, this.c.get(this.r.indexOf(1)).intValue() * 1000, i2, this.m, str6, str3, aVar3, false);
                                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA2 = com.mbridge.msdk.mbnative.a.c.a(1);
                                if (bVarA2 == null || (listB = bVarA2.b(str5, 0)) == null || listB.size() <= 0) {
                                    aVar = aVar5;
                                } else {
                                    aVar = aVar5;
                                    try {
                                        a(true, aVar, (String) null);
                                    } catch (Exception unused2) {
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            str4 = "";
                            aVar = aVar3;
                            str5 = str6;
                        }
                    } else {
                        str4 = "";
                        aVar = aVar3;
                        str5 = str6;
                    }
                    a(i2, this.m, str5, str3, aVar);
                    f fVar = this.m;
                    i.put(str5, Integer.valueOf(fVar != null ? fVar.v() * this.y : 1));
                    try {
                        Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                        Class.forName("com.mbridge.msdk.videocommon.download.c");
                        c.a(com.mbridge.msdk.foundation.controller.b.d().g(), str5);
                        y.b();
                        if (TextUtils.isEmpty(str5)) {
                            return;
                        }
                        com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a();
                        int iA = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
                        if (iA <= 0) {
                            iA = this.y;
                        }
                        f fVarE2 = com.mbridge.msdk.c.d.a().e(str4, str5);
                        this.m = fVarE2;
                        if (fVarE2 == null) {
                            this.m = f.d(str5);
                        }
                        List<Integer> listR = this.m.r();
                        this.r = listR;
                        List<Campaign> listB2 = (listR == null || listR.size() <= 0 || !this.r.contains(1) || (bVarA = com.mbridge.msdk.mbnative.a.c.a(1)) == null) ? null : bVarA.b(str5, iA);
                        if (listB2 != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i3 = 0; i3 < listB2.size(); i3++) {
                                CampaignEx campaignEx = (CampaignEx) listB2.get(i3);
                                if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                    arrayList.add(campaignEx);
                                }
                            }
                            if (arrayList.size() > 0) {
                                Class<?> cls = Class.forName("com.mbridge.msdk.videocommon.download.c");
                                Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                                cls.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, Class.forName("com.mbridge.msdk.videocommon.listener.a")).invoke(objInvoke, com.mbridge.msdk.foundation.controller.b.d().g(), str5, new CopyOnWriteArrayList(arrayList), 1, null);
                                cls.getMethod("load", String.class).invoke(objInvoke, str5);
                            }
                        }
                    } catch (Throwable unused5) {
                        aa.d(d, "init cam cache failed");
                    }
                }
            }
        } catch (Exception e2) {
            aa.d(d, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e2) {
            aa.d(d, com.mbridge.msdk.mbnative.b.a.a(e2));
        }
        return 0;
    }

    private void a(int i2, f fVar, String str, String str2, com.mbridge.msdk.b.a.a aVar) {
        Queue<Integer> queue = this.a;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        try {
            int iIntValue = this.a.poll().intValue();
            long jLongValue = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.f2307b;
            if (queue2 != null && queue2.size() > 0) {
                jLongValue = this.f2307b.poll().longValue();
            }
            aa.b(d, "preload start queue adsource = " + iIntValue);
            a(iIntValue, jLongValue, str, str2, this.q, i2, fVar, aVar);
        } catch (Throwable unused) {
            aa.d(d, "queue poll exception");
        }
    }

    private void a(int i2, long j2, String str, String str2, Map<String, Object> map, int i3, f fVar, com.mbridge.msdk.b.a.a aVar) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        if (i2 != 1 && (bVarA = com.mbridge.msdk.mbnative.a.c.a(i2)) != null) {
            List<Campaign> listB = bVarA.b(str, this.y);
            if (listB != null && listB.size() > 0) {
                a(true, aVar, (String) null);
                return;
            }
        }
        if (i2 == 1) {
            a(i2, j2, i3, fVar, str, str2, aVar, true);
        } else if (i2 == 2) {
            a(2, j2, i3, fVar, str, str2, aVar, false);
        } else {
            a(i2, j2, i3, fVar, str, str2, aVar, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:126:0x02b9 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02c8 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02da A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:143:0x030a  */
    /* JADX WARN: Code duplicated, block: B:147:0x0315  */
    /* JADX WARN: Code duplicated, block: B:149:0x0318 A[Catch: Exception -> 0x048d, TRY_ENTER, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:150:0x032f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0332 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0387 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0392 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:160:0x039a A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:165:0x03d0 A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:171:0x042d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:172:0x042f A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:175:0x045e A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0465  */
    /* JADX WARN: Code duplicated, block: B:178:0x046a A[Catch: Exception -> 0x048d, TryCatch #2 {Exception -> 0x048d, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:17:0x0099, B:19:0x00a3, B:20:0x00ad, B:22:0x00b7, B:24:0x00c1, B:26:0x00c7, B:27:0x00d0, B:29:0x00e9, B:30:0x00f0, B:32:0x00f6, B:33:0x00fb, B:35:0x0124, B:36:0x0129, B:43:0x0142, B:46:0x014a, B:48:0x0152, B:50:0x0158, B:52:0x015d, B:54:0x0161, B:58:0x0175, B:60:0x017d, B:62:0x0183, B:66:0x018e, B:67:0x01a2, B:69:0x01a6, B:70:0x01be, B:72:0x01c6, B:74:0x01d5, B:75:0x01ed, B:78:0x01fe, B:80:0x0204, B:84:0x0211, B:86:0x0218, B:88:0x021e, B:114:0x0269, B:115:0x0276, B:124:0x028e, B:126:0x02b9, B:127:0x02c0, B:129:0x02c8, B:131:0x02da, B:132:0x02e3, B:134:0x02eb, B:140:0x02fb, B:144:0x030b, B:149:0x0318, B:153:0x0348, B:155:0x0387, B:156:0x038c, B:158:0x0392, B:160:0x039a, B:162:0x03a4, B:163:0x03c6, B:165:0x03d0, B:167:0x03da, B:168:0x03fc, B:169:0x0403, B:173:0x0432, B:175:0x045e, B:179:0x0473, B:178:0x046a, B:172:0x042f, B:152:0x0332, B:141:0x0300, B:142:0x0305, B:94:0x0227, B:96:0x022d, B:108:0x0252, B:118:0x0281, B:180:0x047b), top: B:189:0x001a }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private void a(int i2, long j2, int i3, f fVar, String str, String str2, com.mbridge.msdk.b.a.a aVar, boolean z) {
        int i4;
        int i5;
        int iOptInt;
        int iB;
        int i6;
        String strA;
        a aVar2;
        k kVar;
        JSONArray jSONArrayA;
        String str3;
        int iOptInt2;
        String string;
        List<Campaign> listB;
        List<Campaign> listB2;
        try {
            com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a();
            int iP = this.m.p();
            int iQ = this.m.q();
            com.mbridge.msdk.mbnative.e.a.a aVar3 = new com.mbridge.msdk.mbnative.e.a.a(com.mbridge.msdk.foundation.controller.b.d().g());
            com.mbridge.msdk.foundation.same.net.g.d dVar = new com.mbridge.msdk.foundation.same.net.g.d();
            String strH = com.mbridge.msdk.foundation.controller.b.d().h();
            String strJ = com.mbridge.msdk.foundation.controller.b.d().j();
            Map<String, Object> map = this.q;
            if (map != null && map.containsKey("app_id") && this.q.containsKey(MBridgeConstans.APP_KEY) && this.q.containsKey(MBridgeConstans.KEY_WORD) && this.q.get(MBridgeConstans.KEY_WORD) != null) {
                if (this.q.get("app_id") instanceof String) {
                    strH = (String) this.q.get("app_id");
                }
                if (this.q.get(MBridgeConstans.APP_KEY) instanceof String) {
                    strJ = (String) this.q.get(MBridgeConstans.APP_KEY);
                }
                String str4 = this.q.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.q.get(MBridgeConstans.KEY_WORD) : null;
                if (!TextUtils.isEmpty(str4)) {
                    dVar.a("smart", u.a(str4));
                }
            }
            String str5 = strH;
            String str6 = strJ;
            dVar.a("app_id", str5);
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            dVar.a("req_type", "1");
            if (!TextUtils.isEmpty(this.n)) {
                dVar.a("category", this.n);
            }
            if (!TextUtils.isEmpty(str2)) {
                dVar.a(MBridgeConstans.PLACEMENT_ID, str2);
            }
            dVar.a("sign", SameMD5.getMD5(str5 + str6));
            dVar.a("only_impression", "1");
            String strH2 = af.h(str);
            if (!TextUtils.isEmpty(strH2)) {
                dVar.a("j", strH2);
            }
            int iIntValue = h.get(str).intValue();
            if (iP != u && iP != 0 && iIntValue != 0) {
                if (i3 == 0) {
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(i2);
                    if (z) {
                        if (bVarA != null && (listB2 = bVarA.b(str, iIntValue)) != null && listB2.size() > 0) {
                            a(true, aVar, (String) null);
                            return;
                        } else {
                            if (this.w) {
                                a("", i3, str, str2, aVar);
                                return;
                            }
                            return;
                        }
                    }
                    if (i2 != 1 && bVarA != null && (listB = bVarA.b(str, iIntValue)) != null && listB.size() > 0) {
                        a(true, aVar, (String) null);
                        return;
                    }
                }
                if (iIntValue != 0) {
                    dVar.a("ad_num", iIntValue + "");
                }
                if (this.p != 0) {
                    dVar.a("frame_num", this.p + "");
                }
                if (this.q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    String str7 = (String) this.q.get(MBridgeConstans.NATIVE_INFO);
                    if (TextUtils.isEmpty(str7)) {
                        i4 = iIntValue;
                        i5 = 0;
                        iOptInt = 0;
                    } else {
                        aa.d(d, "nativeinfo" + str7);
                        try {
                            JSONArray jSONArray = new JSONArray(str7);
                            if (jSONArray.length() > 0) {
                                str3 = str7;
                                int i7 = 0;
                                iOptInt = 0;
                                iOptInt2 = 0;
                                while (i7 < jSONArray.length()) {
                                    try {
                                        JSONObject jSONObject = (JSONObject) jSONArray.opt(i7);
                                        int i8 = iOptInt;
                                        i4 = iIntValue;
                                        try {
                                            int iOptInt3 = jSONObject.optInt("id", 0);
                                            if (2 == iOptInt3) {
                                                iOptInt = jSONObject.optInt("ad_num");
                                                if (iP > 0) {
                                                    try {
                                                        jSONObject.put("ad_num", iP);
                                                    } catch (JSONException e2) {
                                                        e = e2;
                                                        aa.d(d, com.mbridge.msdk.mbnative.b.a.a(e));
                                                        i5 = iOptInt2;
                                                        string = str3;
                                                        dVar.a(MBridgeConstans.NATIVE_INFO, string);
                                                        iP = i4;
                                                        dVar.a("ad_num", iP + "");
                                                        dVar.a("ping_mode", "1");
                                                        if (com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) == null) {
                                                            com.mbridge.msdk.c.d.a().b();
                                                        }
                                                        if (!NativeController.a(this.q)) {
                                                            jSONArrayA = af.a(com.mbridge.msdk.foundation.controller.b.d().g(), str);
                                                            if (jSONArrayA.length() > 0) {
                                                                dVar.a(com.mbridge.msdk.foundation.same.net.g.d.c, af.a(jSONArrayA));
                                                            }
                                                        }
                                                        if (g.containsKey(str)) {
                                                            iB = 0;
                                                        } else {
                                                            iB = 0;
                                                        }
                                                        if (this.q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                                                            i6 = 1;
                                                            if (i2 == 1) {
                                                                dVar.a("tnum", this.x + "");
                                                            }
                                                            dVar.a("offset", iB + "");
                                                            dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                                                            dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
                                                            strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                                                            if (!TextUtils.isEmpty(strA)) {
                                                                dVar.a(com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
                                                            }
                                                            if (Build.VERSION.SDK_INT >= 14) {
                                                                if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                                                                    dVar.a("video_width", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                                                                }
                                                                if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                                                                    dVar.a("video_height", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                                                                }
                                                                dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                                            }
                                                            aVar2 = new a(i2);
                                                            aVar2.setUnitId(str);
                                                            aVar2.setPlacementId(str2);
                                                            aVar2.setAdType(42);
                                                            aVar2.d(i4);
                                                            aVar2.b(iOptInt);
                                                            aVar2.c(i5);
                                                            aVar2.a(iQ);
                                                            aVar2.a(aVar);
                                                            if (i2 == 1) {
                                                                aVar2.b(true);
                                                            } else {
                                                                aVar2.b(true);
                                                            }
                                                            aVar2.a(NativeController.b(this.q));
                                                            RunnableC0493b runnableC0493b = new RunnableC0493b(1, aVar2, i3, str, str2);
                                                            aVar2.a(runnableC0493b);
                                                            aVar2.e(i3);
                                                            runnableC0493b.a(aVar);
                                                            runnableC0493b.a(z);
                                                            runnableC0493b.a(str);
                                                            if (i3 == 0) {
                                                                aVar3.choiceV3OrV5BySetting(1, dVar, aVar2, "");
                                                            } else if (i3 == 1) {
                                                                aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.f.d.a().u, dVar, aVar2);
                                                            }
                                                            this.o.postDelayed(runnableC0493b, j2);
                                                            return;
                                                        }
                                                        i6 = 1;
                                                        if (i2 == i6) {
                                                            dVar.a("tnum", this.y + "");
                                                        }
                                                        dVar.a("offset", iB + "");
                                                        dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                                                        dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
                                                        strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                                                        if (!TextUtils.isEmpty(strA)) {
                                                            dVar.a(com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
                                                        }
                                                        if (Build.VERSION.SDK_INT >= 14) {
                                                            if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                                                                dVar.a("video_width", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                                                            }
                                                            if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                                                                dVar.a("video_height", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                                                            }
                                                            dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                                        }
                                                        aVar2 = new a(i2);
                                                        aVar2.setUnitId(str);
                                                        aVar2.setPlacementId(str2);
                                                        aVar2.setAdType(42);
                                                        aVar2.d(i4);
                                                        aVar2.b(iOptInt);
                                                        aVar2.c(i5);
                                                        aVar2.a(iQ);
                                                        aVar2.a(aVar);
                                                        if (i2 == 1) {
                                                            aVar2.b(true);
                                                        } else {
                                                            aVar2.b(true);
                                                        }
                                                        aVar2.a(NativeController.b(this.q));
                                                        RunnableC0493b runnableC0493b2 = new RunnableC0493b(1, aVar2, i3, str, str2);
                                                        aVar2.a(runnableC0493b2);
                                                        aVar2.e(i3);
                                                        runnableC0493b2.a(aVar);
                                                        runnableC0493b2.a(z);
                                                        runnableC0493b2.a(str);
                                                        if (i3 == 0) {
                                                            aVar3.choiceV3OrV5BySetting(1, dVar, aVar2, "");
                                                        } else if (i3 == 1) {
                                                            aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.f.d.a().u, dVar, aVar2);
                                                        }
                                                        this.o.postDelayed(runnableC0493b2, j2);
                                                        return;
                                                    }
                                                } else {
                                                    continue;
                                                }
                                            } else {
                                                if (3 == iOptInt3) {
                                                    iOptInt2 = jSONObject.optInt("ad_num");
                                                    if (iP > 0) {
                                                        jSONObject.put("ad_num", iP);
                                                    }
                                                }
                                                iOptInt = i8;
                                            }
                                            i7++;
                                            iIntValue = i4;
                                        } catch (JSONException e3) {
                                            e = e3;
                                            iOptInt = i8;
                                        }
                                    } catch (JSONException e4) {
                                        e = e4;
                                        i4 = iIntValue;
                                    }
                                }
                                i4 = iIntValue;
                                i5 = iOptInt2;
                            } else {
                                i4 = iIntValue;
                                str3 = str7;
                                i5 = 0;
                                iOptInt = 0;
                            }
                            try {
                                this.x = Math.max(iOptInt, i5);
                                string = jSONArray.toString();
                            } catch (JSONException e5) {
                                e = e5;
                                iOptInt2 = i5;
                                aa.d(d, com.mbridge.msdk.mbnative.b.a.a(e));
                                i5 = iOptInt2;
                                string = str3;
                            }
                        } catch (JSONException e6) {
                            e = e6;
                            i4 = iIntValue;
                            str3 = str7;
                            iOptInt = 0;
                            iOptInt2 = 0;
                        }
                        dVar.a(MBridgeConstans.NATIVE_INFO, string);
                    }
                    iP = i4;
                } else {
                    i4 = iIntValue;
                    if (iP == v || iP == 0) {
                        iP = i4;
                    }
                    i5 = 0;
                    iOptInt = 0;
                }
                dVar.a("ad_num", iP + "");
                dVar.a("ping_mode", "1");
                if (com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) == null) {
                    com.mbridge.msdk.c.d.a().b();
                }
                if (!NativeController.a(this.q)) {
                    jSONArrayA = af.a(com.mbridge.msdk.foundation.controller.b.d().g(), str);
                    if (jSONArrayA.length() > 0) {
                        dVar.a(com.mbridge.msdk.foundation.same.net.g.d.c, af.a(jSONArrayA));
                    }
                }
                if (g.containsKey(str) || (kVar = g.get(str)) == null) {
                    iB = 0;
                } else if (i2 != 1 && i2 == 2) {
                    iB = kVar.a();
                } else {
                    iB = kVar.b();
                }
                if (this.q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    i6 = 1;
                    if (i2 == 1) {
                        dVar.a("tnum", this.x + "");
                    }
                    dVar.a("offset", iB + "");
                    dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                    dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
                    strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                    if (!TextUtils.isEmpty(strA)) {
                        dVar.a(com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
                    }
                    if (Build.VERSION.SDK_INT >= 14) {
                        if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                            dVar.a("video_width", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                        }
                        if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                            dVar.a("video_height", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                        }
                        dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                    }
                    aVar2 = new a(i2);
                    aVar2.setUnitId(str);
                    aVar2.setPlacementId(str2);
                    aVar2.setAdType(42);
                    aVar2.d(i4);
                    aVar2.b(iOptInt);
                    aVar2.c(i5);
                    aVar2.a(iQ);
                    aVar2.a(aVar);
                    if (i2 == 1 || z) {
                        aVar2.b(true);
                    }
                    aVar2.a(NativeController.b(this.q));
                    RunnableC0493b runnableC0493b3 = new RunnableC0493b(1, aVar2, i3, str, str2);
                    aVar2.a(runnableC0493b3);
                    aVar2.e(i3);
                    runnableC0493b3.a(aVar);
                    runnableC0493b3.a(z);
                    runnableC0493b3.a(str);
                    if (i3 == 0) {
                        aVar3.choiceV3OrV5BySetting(1, dVar, aVar2, "");
                    } else if (i3 == 1) {
                        aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.f.d.a().u, dVar, aVar2);
                    }
                    this.o.postDelayed(runnableC0493b3, j2);
                    return;
                }
                i6 = 1;
                if (i2 == i6) {
                    dVar.a("tnum", this.y + "");
                }
                dVar.a("offset", iB + "");
                dVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                dVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i2 + "");
                strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                if (!TextUtils.isEmpty(strA)) {
                    dVar.a(com.mbridge.msdk.foundation.same.net.g.d.f2148b, strA);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                        dVar.a("video_width", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                    }
                    if (this.q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                        dVar.a("video_height", ((Integer) this.q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                    }
                    dVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                }
                aVar2 = new a(i2);
                aVar2.setUnitId(str);
                aVar2.setPlacementId(str2);
                aVar2.setAdType(42);
                aVar2.d(i4);
                aVar2.b(iOptInt);
                aVar2.c(i5);
                aVar2.a(iQ);
                aVar2.a(aVar);
                if (i2 == 1) {
                    aVar2.b(true);
                } else {
                    aVar2.b(true);
                }
                aVar2.a(NativeController.b(this.q));
                RunnableC0493b runnableC0493b4 = new RunnableC0493b(1, aVar2, i3, str, str2);
                aVar2.a(runnableC0493b4);
                aVar2.e(i3);
                runnableC0493b4.a(aVar);
                runnableC0493b4.a(z);
                runnableC0493b4.a(str);
                if (i3 == 0) {
                    aVar3.choiceV3OrV5BySetting(1, dVar, aVar2, "");
                } else if (i3 == 1) {
                    aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.f.d.a().u, dVar, aVar2);
                }
                this.o.postDelayed(runnableC0493b4, j2);
                return;
            }
            a("The request was refused", i3, str, str2, aVar);
        } catch (Exception e7) {
            String str8 = d;
            aa.d(str8, com.mbridge.msdk.mbnative.b.a.a(e7));
            aa.d(str8, e7.getMessage());
        }
    }

    public static void a(int i2, String str) {
        k kVar;
        if (g.containsKey(str)) {
            kVar = g.get(str);
        } else {
            kVar = new k();
        }
        int iIntValue = h.get(str).intValue();
        int iIntValue2 = i.containsKey(str) ? i.get(str).intValue() : 1;
        if (i2 == 1) {
            int iB = iIntValue + kVar.b();
            kVar.b(iB <= iIntValue2 ? iB : 0);
        } else if (i2 == 2) {
            int iA = iIntValue + kVar.a();
            kVar.a(iA <= iIntValue2 ? iA : 0);
        }
        g.put(str, kVar);
    }

    public static void b(int i2, String str) {
        if (g.containsKey(str)) {
            k kVar = g.get(str);
            if (i2 == 1) {
                kVar.b(0);
            } else if (i2 == 2) {
                kVar.a(0);
            }
            g.put(str, kVar);
        }
    }

    /* JADX INFO: compiled from: NativePreloadController.java */
    public class a extends com.mbridge.msdk.mbnative.e.a.b implements com.mbridge.msdk.foundation.same.e.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2308b;
        private int c;
        private int d;
        private int e;
        private int f;
        private Runnable i;
        private com.mbridge.msdk.b.a.a k;
        private List<String> g = null;
        private boolean h = false;
        private boolean j = true;

        public final void a(List<String> list) {
            this.g = list;
        }

        public final void a(int i) {
            this.f = i;
        }

        public final void b(int i) {
            this.d = i;
        }

        public final void c(int i) {
            this.e = i;
        }

        public final void d(int i) {
            this.c = i;
        }

        public a(int i) {
            this.f2308b = i;
        }

        public final void a(com.mbridge.msdk.b.a.a aVar) {
            this.k = aVar;
        }

        public final void b(boolean z) {
            this.j = z;
        }

        @Override // com.mbridge.msdk.foundation.same.e.d
        public final void a(boolean z) {
            this.h = z;
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, final CampaignUnit campaignUnit) {
            b.this.w = true;
            b.this.a(true, this.k, (String) null);
            b.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.b.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (a.this.i != null) {
                        b.this.o.removeCallbacks(a.this.i);
                    }
                    if (b.e.containsKey("0_" + a.this.unitId)) {
                        b.e.remove("0_" + a.this.unitId);
                    }
                    if (a.this.f > 0) {
                        if (campaignUnit.ads.size() <= a.this.f) {
                            a.this.c = campaignUnit.ads.size();
                        } else {
                            a aVar = a.this;
                            aVar.c = aVar.f;
                        }
                    } else if (a.this.f == -1) {
                        a.this.c = 0;
                    } else if (a.this.f == -3) {
                        a.this.c = campaignUnit.ads.size();
                    } else if (a.this.f == -2) {
                        if (campaignUnit.getTemplate() == 3) {
                            if (a.this.e != 0) {
                                a aVar2 = a.this;
                                aVar2.c = aVar2.e;
                            }
                        } else if (a.this.d != 0) {
                            a aVar3 = a.this;
                            aVar3.c = aVar3.d;
                        }
                        if (a.this.c <= 0) {
                            a.this.c = ((Integer) b.h.get(a.this.unitId)).intValue();
                        }
                    }
                    if (campaignUnit.ads.size() < a.this.c) {
                        a.this.c = campaignUnit.ads.size();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < campaignUnit.ads.size(); i++) {
                        CampaignEx campaignEx = campaignUnit.ads.get(i);
                        campaignEx.setCampaignUnitId(a.this.unitId);
                        if (arrayList.size() < a.this.c && campaignEx.getOfferType() != 99) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList2.add(campaignEx);
                            }
                        }
                        b.this.a(b.this.t, campaignEx);
                    }
                    b.a(b.this, arrayList2, a.this.unitId);
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1);
                    if (bVarA != null) {
                        bVarA.a(a.this.unitId, arrayList);
                    }
                    b.a(a.this.f2308b, a.this.unitId);
                    if (Looper.myLooper() != null && z) {
                        Looper.loop();
                    }
                    if (campaignUnit.getAds().get(0) != null) {
                        com.mbridge.msdk.click.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignUnit.getAds().get(0).getMaitve(), campaignUnit.getAds().get(0).getMaitve_src());
                    }
                }
            }));
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void a(final int i, final String str) {
            b.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.b.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!a.this.h) {
                        if (a.this.i != null) {
                            b.this.o.removeCallbacks(a.this.i);
                        }
                        if (a.this.b() == 1 || a.this.j) {
                            b.this.a(str, a.this.b(), a.this.unitId, a.this.placementId, a.this.k);
                        }
                    } else if (a.this.j) {
                        b.this.a(str, a.this.b(), a.this.unitId, a.this.placementId, a.this.k);
                    }
                    if (i == -1) {
                        b.b(a.this.f2308b, a.this.unitId);
                    }
                    if (Looper.myLooper() == null || !z) {
                        return;
                    }
                    Looper.loop();
                }
            }));
        }

        public final void a(Runnable runnable) {
            this.i = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.e.a.b
        public final void b(final List<Frame> list) {
            b.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.b.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!a.this.h && a.this.i != null) {
                        b.this.o.removeCallbacks(a.this.i);
                    }
                    List list2 = list;
                    if (list2 != null && list2.size() > 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            Iterator<CampaignEx> it2 = ((Frame) it.next()).getCampaigns().iterator();
                            while (it2.hasNext()) {
                                b.this.a(b.this.t, it2.next());
                            }
                        }
                        HashMap map = new HashMap();
                        map.put(Long.valueOf(System.currentTimeMillis()), list);
                        if (b.e.containsKey("1_" + a.this.unitId)) {
                            b.e.remove("1_" + a.this.unitId);
                        }
                        b.e.put("1_" + a.this.unitId, map);
                    }
                    if (Looper.myLooper() == null || !z) {
                        return;
                    }
                    Looper.loop();
                }
            }));
        }
    }

    public final void a(String str, int i2, String str2, String str3, com.mbridge.msdk.b.a.a aVar) {
        Log.e(d, str);
        try {
            Queue<Integer> queue = this.a;
            if ((queue != null && queue.size() <= 0) || this.a == null) {
                a(false, aVar, str);
            } else {
                a(i2, this.m, str2, str3, aVar);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.mbnative.controller.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativePreloadController.java */
    public class RunnableC0493b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2312b;
        private com.mbridge.msdk.foundation.same.e.d c;
        private int d;
        private String e;
        private String f;
        private com.mbridge.msdk.b.a.a g;
        private boolean h = false;

        public final void a(boolean z) {
            this.h = z;
        }

        public final void a(com.mbridge.msdk.b.a.a aVar) {
            this.g = aVar;
        }

        public final void a(String str) {
            this.e = str;
        }

        public RunnableC0493b(int i, com.mbridge.msdk.foundation.same.e.d dVar, int i2, String str, String str2) {
            this.f2312b = i;
            this.c = dVar;
            this.d = i2;
            this.e = str;
            this.f = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.a(true);
            int i = this.f2312b;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                b.this.a("REQUEST_TIMEOUT", this.d, this.e, this.f, this.g);
            } else {
                b.this.w = true;
                if (this.h || this.d == 1) {
                    b.this.a("REQUEST_TIMEOUT", this.d, this.e, this.f, this.g);
                }
            }
        }
    }

    public static Map<String, Map<Long, Object>> a() {
        return e;
    }

    public static Map<String, Boolean> b() {
        return f;
    }

    public static Map<String, k> c() {
        return g;
    }

    public static Map<String, Integer> d() {
        return h;
    }

    public static Map<String, Integer> e() {
        return i;
    }

    public final void a(boolean z, com.mbridge.msdk.b.a.a aVar, String str) {
        if (z) {
            if (aVar == null || aVar.a()) {
                return;
            }
            aVar.a(true);
            aVar.onPreloadSucceed();
            return;
        }
        if (aVar == null || aVar.a()) {
            return;
        }
        aVar.a(true);
        aVar.onPreloadFaild(str);
    }

    public final void a(boolean z, Campaign campaign) {
        if (campaign == null) {
            return;
        }
        if (z && campaign.getIconDrawable() == null) {
            campaign.loadIconUrlAsyncWithBlock(null);
        }
        if (z && campaign.getBigDrawable() == null) {
            campaign.loadImageUrlAsyncWithBlock(null);
        }
    }

    public final void a(Thread thread) {
        if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD) {
            thread.run();
        } else {
            thread.start();
        }
    }

    static /* synthetic */ void a(b bVar, List list, String str) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        Class.forName("com.mbridge.msdk.nativex.view.MBMediaView");
                        Class.forName("com.mbridge.msdk.videocommon.download.c");
                        Class<?> cls = Class.forName("com.mbridge.msdk.videocommon.download.c");
                        Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        if (objInvoke != null) {
                            cls.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, Class.forName("com.mbridge.msdk.videocommon.listener.a")).invoke(objInvoke, com.mbridge.msdk.foundation.controller.b.d().g(), str, new CopyOnWriteArrayList(list), 1, null);
                            cls.getMethod("load", String.class).invoke(objInvoke, str);
                        }
                    } catch (Exception unused) {
                        aa.d(d, "please import the videocommon aar");
                    }
                }
            } catch (Exception e2) {
                aa.d(d, com.mbridge.msdk.mbnative.b.a.a(e2));
            }
        }
    }
}
