package com.bytedance.sdk.openadsdk.d.p;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.utils.y;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: OverSeaEventUploadImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements b.b.a.a.i.a.k.c {
    public p<com.bytedance.sdk.openadsdk.d.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f746b = new c();

    /* JADX INFO: compiled from: OverSeaEventUploadImpl.java */
    class a extends b.b.a.a.k.g {
        final /* synthetic */ List c;
        final /* synthetic */ b.b.a.a.i.a.k.b d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, List list, b.b.a.a.i.a.k.b bVar, List list2) {
            super(str);
            this.c = list;
            this.d = bVar;
            this.e = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it;
            try {
                it = j.this.a(this.c).entrySet().iterator();
            } catch (Throwable th) {
                m.b("OverSeaEventUploadImp", th.getMessage());
                it = null;
            }
            if (it == null) {
                b.b.a.a.i.a.k.b bVar = this.d;
                if (bVar != null) {
                    bVar.a(this.e);
                    return;
                }
                return;
            }
            while (it.hasNext()) {
                try {
                    com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.d);
                    List<b.b.a.a.i.a.m.a> list = (List) ((Map.Entry) it.next()).getValue();
                    ArrayList arrayList = new ArrayList();
                    for (b.b.a.a.i.a.m.a aVar : list) {
                        arrayList.add(new com.bytedance.sdk.openadsdk.d.a(aVar.i(), aVar.b()));
                    }
                    com.bytedance.sdk.openadsdk.d.e eVarC = j.this.c(arrayList);
                    if (this.d != null && eVarC != null) {
                        boolean z = eVarC.d;
                        if (j.this.a(arrayList, eVarC)) {
                            z = true;
                        }
                        this.e.add(new b.b.a.a.i.a.k.g.a(new b.b.a.a.i.a.k.g.b(eVarC.a, eVarC.f717b, eVarC.c, z, ""), list));
                        if (eVarC.f717b == 200) {
                            com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.d, true);
                        } else if (z) {
                            com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.d, false);
                        }
                    }
                } catch (Throwable th2) {
                    m.b("OverSeaEventUploadImp", th2.getMessage());
                }
            }
            b.b.a.a.i.a.k.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.a(this.e);
            }
        }
    }

    /* JADX INFO: compiled from: OverSeaEventUploadImpl.java */
    class b extends b.b.a.a.k.g {
        final /* synthetic */ List c;
        final /* synthetic */ b.b.a.a.i.a.k.b d;
        final /* synthetic */ List e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, List list, b.b.a.a.i.a.k.b bVar, List list2, List list3) {
            super(str);
            this.c = list;
            this.d = bVar;
            this.e = list2;
            this.f = list3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.d.e eVarD = j.this.d(this.c);
            if (this.d == null || eVarD == null) {
                return;
            }
            this.e.add(new b.b.a.a.i.a.k.g.a(new b.b.a.a.i.a.k.g.b(eVarD.a, eVarD.f717b, eVarD.c, eVarD.d, ""), this.f));
            this.d.a(this.e);
            if (eVarD.f717b == 200) {
                com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.e, true);
            } else if (eVarD.d) {
                com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.e, false);
            }
        }
    }

    private boolean b(List<com.bytedance.sdk.openadsdk.d.a> list) {
        JSONObject jSONObjectE;
        if (list == null || list.size() == 0 || (jSONObjectE = list.get(0).e()) == null) {
            return true;
        }
        return TextUtils.isEmpty(jSONObjectE.optString("app_log_url"));
    }

    public com.bytedance.sdk.openadsdk.d.e c(List<com.bytedance.sdk.openadsdk.d.a> list) {
        if (this.a == null) {
            this.a = o.c();
        }
        if (this.a == null) {
            return null;
        }
        int iX = n.j0().X();
        if (3 == iX) {
            return this.a.a(this.f746b.a(this.f746b.a(list, false), System.currentTimeMillis(), this.f746b.d(), true), this.f746b.a(list), true);
        }
        if (2 != iX) {
            return this.a.a(this.f746b.a(list, System.currentTimeMillis(), this.f746b.d(), false), this.f746b.a(list), false);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectD = this.f746b.d();
        this.a.a(this.f746b.a(this.f746b.a(list, true), jCurrentTimeMillis, jSONObjectD, true), this.f746b.a(list), true);
        return this.a.a(this.f746b.a(this.f746b.b(list), jCurrentTimeMillis, jSONObjectD, false), this.f746b.a(list), false);
    }

    public com.bytedance.sdk.openadsdk.d.e d(List<com.bytedance.sdk.openadsdk.l.e.b.a> list) {
        if (this.a == null) {
            this.a = o.c();
        }
        if (list == null || list.size() == 0 || !com.bytedance.sdk.openadsdk.core.settings.j.a()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<com.bytedance.sdk.openadsdk.l.e.b.a> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a);
            }
            jSONObject.put("stats_list", jSONArray);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put(CampaignEx.JSON_KEY_ST_TS, jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.e.a(String.valueOf(jCurrentTimeMillis).concat("stats_list")));
        } catch (Exception unused) {
        }
        return this.a.a(jSONObject);
    }

    @Override // b.b.a.a.i.a.k.c
    public void a(List<b.b.a.a.i.a.m.a> list, b.b.a.a.i.a.k.b bVar) {
        b.b.a.a.i.a.m.a aVar;
        if (list == null || list.isEmpty() || (aVar = list.get(0)) == null) {
            return;
        }
        byte bF = aVar.f();
        ArrayList arrayList = new ArrayList();
        if (bF == 0) {
            y.c(new a("upload_ad_event", list, bVar, arrayList), 10);
            return;
        }
        if (bF == 1) {
            ArrayList arrayList2 = new ArrayList();
            for (b.b.a.a.i.a.m.a aVar2 : list) {
                arrayList2.add(new com.bytedance.sdk.openadsdk.l.e.b.a(aVar2.i(), aVar2.b()));
            }
            com.bytedance.sdk.openadsdk.d.p.a.a(com.bytedance.sdk.openadsdk.d.p.a.e);
            if (arrayList2.size() > 0) {
                y.c(new b("upload_stats_event", arrayList2, bVar, arrayList, list), 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<com.bytedance.sdk.openadsdk.d.a> list, com.bytedance.sdk.openadsdk.d.e eVar) {
        int i;
        return !b(list) && (i = eVar.f717b) >= 400 && i < 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<b.b.a.a.i.a.m.a>> a(List<b.b.a.a.i.a.m.a> list) {
        HashMap<String, List<b.b.a.a.i.a.m.a>> map = new HashMap<>();
        new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            b.b.a.a.i.a.m.a aVar = list.get(i);
            JSONObject jSONObjectB = aVar.b();
            if (jSONObjectB != null) {
                String strOptString = jSONObjectB.optString("app_log_url");
                List<b.b.a.a.i.a.m.a> arrayList = map.get(strOptString);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(strOptString, arrayList);
                }
                arrayList.add(aVar);
            }
        }
        return map;
    }
}
