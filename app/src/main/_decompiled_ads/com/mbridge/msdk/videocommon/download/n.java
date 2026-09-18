package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: UnitCacheCtroller.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private com.mbridge.msdk.videocommon.listener.a e;
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> g;
    private Context j;
    private ExecutorService k;
    private String m;
    private com.mbridge.msdk.videocommon.d.c n;
    private int p;
    private m q;
    private boolean r;
    private List<CampaignEx> c = new ArrayList();
    private boolean d = true;
    private String f = "";
    private d h = new d() { // from class: com.mbridge.msdk.videocommon.download.n.1
        @Override // com.mbridge.msdk.videocommon.download.d
        public final void a(long j, int i) {
            if (i == 5 || i == 4) {
                n.this.d = true;
                n.this.a();
            }
            if (i == 2) {
                n.this.d = true;
            }
        }
    };
    private CopyOnWriteArrayList<Map<String, a>> i = new CopyOnWriteArrayList<>();
    private long l = 3600;
    private int o = 1;
    com.mbridge.msdk.c.f a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.c.f f2673b = null;

    public n(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i) {
        this.p = 1;
        try {
            boolean zA = l.a.a.a(i);
            this.r = zA;
            if (zA) {
                this.m = str;
                this.p = i;
                this.q = new m(list, str, i);
                return;
            }
        } catch (Exception unused) {
            this.q = null;
            this.r = false;
        }
        this.j = com.mbridge.msdk.foundation.controller.b.d().g();
        List<CampaignEx> list2 = this.c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        b(this.c);
    }

    public n(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i) {
        this.p = 1;
        try {
            boolean zA = l.a.a.a(i);
            this.r = zA;
            if (zA) {
                this.m = str;
                this.p = i;
                this.q = new m(campaignEx, str, i);
                return;
            }
        } catch (Exception unused) {
            this.q = null;
            this.r = false;
        }
        this.j = com.mbridge.msdk.foundation.controller.b.d().g();
        List<CampaignEx> list = this.c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.k = executorService;
        this.m = str;
        this.p = i;
        b(this.c);
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.a(aVar);
        } else {
            this.e = aVar;
        }
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.a(str, aVar);
            return;
        }
        if (this.g == null) {
            this.g = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.g.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.a(list);
            return;
        }
        List<CampaignEx> list2 = this.c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.c);
    }

    public final void a(CampaignEx campaignEx) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.a(campaignEx);
            return;
        }
        List<CampaignEx> list = this.c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        b(this.c);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c1 A[Catch: Exception -> 0x00f7, TryCatch #4 {Exception -> 0x00f7, blocks: (B:34:0x00b2, B:36:0x00c1, B:38:0x00ca, B:39:0x00d0, B:41:0x00d8, B:42:0x00ec, B:44:0x00f0), top: B:110:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ca A[Catch: Exception -> 0x00f7, TryCatch #4 {Exception -> 0x00f7, blocks: (B:34:0x00b2, B:36:0x00c1, B:38:0x00ca, B:39:0x00d0, B:41:0x00d8, B:42:0x00ec, B:44:0x00f0), top: B:110:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8 A[Catch: Exception -> 0x00f7, TryCatch #4 {Exception -> 0x00f7, blocks: (B:34:0x00b2, B:36:0x00c1, B:38:0x00ca, B:39:0x00d0, B:41:0x00d8, B:42:0x00ec, B:44:0x00f0), top: B:110:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f0 A[Catch: Exception -> 0x00f7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00f7, blocks: (B:34:0x00b2, B:36:0x00c1, B:38:0x00ca, B:39:0x00d0, B:41:0x00d8, B:42:0x00ec, B:44:0x00f0), top: B:110:0x00b2 }] */
    private void b(List<CampaignEx> list) {
        String str;
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        boolean z;
        com.mbridge.msdk.videocommon.d.a aVarB;
        com.mbridge.msdk.videocommon.d.c cVar;
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.get(0) != null) {
            this.f = list.get(0).getCurrentLRid();
        }
        e();
        d();
        int i = this.p;
        if (i == 1) {
            try {
                if (!TextUtils.isEmpty(this.m)) {
                    com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                    this.a = fVarE;
                    if (fVarE == null) {
                        this.a = com.mbridge.msdk.c.f.d(this.m);
                    }
                    com.mbridge.msdk.c.f fVar = this.a;
                    if (fVar != null) {
                        this.l = fVar.i();
                        this.o = this.a.k();
                    }
                }
            } catch (Exception unused) {
                aa.d("UnitCacheCtroller", "make sure your had put native video jar into your project");
                return;
            }
        } else if (i == 287) {
            try {
                Class.forName("com.mbridge.msdk.videocommon.d.a");
                aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
                if (aVarB == null) {
                    com.mbridge.msdk.videocommon.d.b.a().c();
                }
                if (aVarB != null) {
                    this.l = aVarB.g();
                }
                if (!TextUtils.isEmpty(this.m)) {
                    this.n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                }
                cVar = this.n;
                if (cVar != null) {
                    this.o = cVar.w();
                }
            } catch (Exception unused2) {
                aa.d("UnitCacheCtroller", "make sure your had put reward jar into your project");
                return;
            }
        } else if (i == 298) {
            com.mbridge.msdk.c.f fVarF = com.mbridge.msdk.c.d.a().f(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
            this.f2673b = fVarF;
            if (fVarF == null) {
                this.f2673b = com.mbridge.msdk.c.d.a().d(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
            }
            com.mbridge.msdk.c.f fVar2 = this.f2673b;
            if (fVar2 != null) {
                this.l = fVar2.i();
                this.o = this.f2673b.k();
            }
        } else if (i == 94) {
            Class.forName("com.mbridge.msdk.videocommon.d.a");
            aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (aVarB != null) {
                this.l = aVarB.g();
            }
            if (!TextUtils.isEmpty(this.m)) {
                this.n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
            }
            cVar = this.n;
            if (cVar != null) {
                this.o = cVar.w();
            }
        } else if (i == 95) {
            try {
                if (!TextUtils.isEmpty(this.m)) {
                    com.mbridge.msdk.c.f fVarE2 = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                    if (fVarE2 == null) {
                        fVarE2 = com.mbridge.msdk.c.f.e(this.m);
                    }
                    if (fVarE2 != null) {
                        this.l = fVarE2.i();
                        this.o = fVarE2.k();
                    }
                }
            } catch (Exception unused3) {
                aa.d("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                return;
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            CampaignEx campaignEx = list.get(i2);
            if (campaignEx != null) {
                int i3 = this.p;
                if (i3 == 94 || i3 == 287) {
                    str = campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode();
                } else {
                    str = campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                }
                if ((c(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.i) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i4 = 0;
                        while (true) {
                            try {
                                if (i4 >= this.i.size()) {
                                    z = false;
                                    break;
                                }
                                Map<String, a> map = this.i.get(i4);
                                if (map != null && map.containsKey(str)) {
                                    a aVar = map.get(str);
                                    aVar.a(campaignEx);
                                    aVar.a(this.o);
                                    aVar.e(false);
                                    map.remove(str);
                                    map.put(str, aVar);
                                    this.i.set(i4, map);
                                    z = true;
                                    break;
                                }
                                i4++;
                            } catch (Throwable unused4) {
                            }
                        }
                        if (!z) {
                            a aVar2 = new a(this.j, campaignEx, this.m, this.o);
                            aVar2.a(this.o);
                            aVar2.d(this.p);
                            HashMap map2 = new HashMap();
                            map2.put(str, aVar2);
                            this.i.add(map2);
                        }
                    }
                }
            }
        }
        List<CampaignEx> list2 = this.c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.c.clear();
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((this.r && this.q != null) || ac.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.i) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    while (i < this.i.size()) {
                        Map<String, a> map = this.i.get(i);
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value != null) {
                                if (jCurrentTimeMillis - value.g() > this.l * 1000 && value.j() == 1) {
                                    value.b("download timeout");
                                    value.a(this.o);
                                    value.r();
                                    this.i.remove(map);
                                    i--;
                                }
                                if (value.j() != 1 && value.j() != 5 && value.j() != 0) {
                                    value.r();
                                    this.i.remove(map);
                                    i--;
                                }
                            }
                        }
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i = 0;
                    while (i < this.i.size()) {
                        Map<String, a> map = this.i.get(i);
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value != null && value.k() != null && value.f()) {
                                value.q();
                                this.i.remove(map);
                                i--;
                            }
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
                aa.d("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x019f A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01ad A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:108:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:116:0x01da  */
    /* JADX WARN: Code duplicated, block: B:118:0x01df A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:121:0x01e6 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01ea A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:130:0x0202  */
    /* JADX WARN: Code duplicated, block: B:132:0x0206 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x021a  */
    /* JADX WARN: Code duplicated, block: B:153:0x0184 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x0187 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x016b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0146 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0155 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x016d A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0175 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0179 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0180 A[Catch: all -> 0x022e, Exception -> 0x0230, TRY_LEAVE, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0195 A[Catch: all -> 0x022e, Exception -> 0x0230, TryCatch #0 {Exception -> 0x0230, blocks: (B:11:0x0021, B:12:0x0026, B:14:0x002e, B:15:0x003e, B:17:0x0044, B:19:0x0052, B:22:0x005a, B:23:0x0063, B:25:0x0069, B:28:0x0073, B:30:0x007d, B:32:0x0087, B:34:0x0095, B:36:0x00a3, B:38:0x00ad, B:39:0x00b4, B:41:0x00be, B:47:0x00cf, B:50:0x00d7, B:53:0x00df, B:55:0x00eb, B:57:0x00f1, B:58:0x00f9, B:80:0x0146, B:82:0x0155, B:84:0x015b, B:86:0x016d, B:88:0x0175, B:89:0x0179, B:91:0x0180, B:97:0x0188, B:99:0x0195, B:101:0x019f, B:103:0x01ad, B:118:0x01df, B:121:0x01e6, B:123:0x01ea, B:125:0x01f4, B:127:0x01fa, B:132:0x0206, B:134:0x0210, B:136:0x0216, B:115:0x01cf, B:61:0x0106, B:63:0x010c, B:65:0x0114, B:68:0x011b, B:70:0x0121, B:72:0x0127, B:74:0x012e, B:76:0x0134, B:77:0x0138, B:79:0x0142), top: B:150:0x0021, outer: #1 }] */
    public final List<a> a(String str, int i, boolean z, List<CampaignEx> list, boolean z2) {
        long j;
        Iterator<Map.Entry<String, a>> it;
        boolean zIsEmpty;
        int iJ;
        int i2;
        long jG;
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.a(list, z2);
        }
        ArrayList arrayList = new ArrayList();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    while (i3 < this.i.size()) {
                        Map<String, a> map = this.i.get(i3);
                        Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                        while (it2.hasNext()) {
                            a value = it2.next().getValue();
                            if (value == null || value.k() == null) {
                                j = jCurrentTimeMillis;
                                it = it2;
                                it2 = it;
                                jCurrentTimeMillis = j;
                            } else {
                                CampaignEx campaignExK = value.k();
                                boolean z3 = false;
                                for (CampaignEx campaignEx : list) {
                                    if (campaignExK != null && campaignEx != null && !TextUtils.isEmpty(campaignExK.getRequestId()) && !TextUtils.isEmpty(campaignEx.getRequestId()) && campaignExK.getId().equals(campaignEx.getId()) && campaignExK.getRequestId().equals(campaignEx.getRequestId())) {
                                        if (!TextUtils.isEmpty(campaignEx.getLocalRequestId())) {
                                            campaignExK.setLocalRequestId(campaignEx.getLocalRequestId());
                                        }
                                        if (!TextUtils.isEmpty(campaignEx.getNLRid())) {
                                            campaignExK.setNLRid(campaignEx.getNLRid());
                                        }
                                        z3 = true;
                                    }
                                }
                                if (z3 && ((!z || campaignExK.isBidCampaign()) && (z || !campaignExK.isBidCampaign()))) {
                                    String str2 = campaignExK.getendcard_url();
                                    String videoUrlEncode = campaignExK.getVideoUrlEncode();
                                    String strE = "";
                                    if (campaignExK != null && campaignExK.getRewardTemplateMode() != null) {
                                        strE = campaignExK.getRewardTemplateMode().e();
                                    }
                                    campaignExK.getRewardTemplateMode();
                                    it = it2;
                                    if (i == 94 || i == 287) {
                                        if (TextUtils.isEmpty(strE) || strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a(i, campaignExK, strE)) {
                                            if (b(str2, campaignExK)) {
                                                if (value.f()) {
                                                    value.q();
                                                } else if (ak.a(videoUrlEncode)) {
                                                    arrayList.add(value);
                                                } else if (a(value, b(campaignExK), z2)) {
                                                    arrayList.add(value);
                                                } else {
                                                    zIsEmpty = TextUtils.isEmpty(value.p());
                                                    iJ = value.j();
                                                    if (iJ == 5) {
                                                        if (value.f()) {
                                                            value.q();
                                                            this.i.remove(map);
                                                            i3--;
                                                            it2 = it;
                                                        } else if (!zIsEmpty) {
                                                            value.a(0, 0);
                                                            if (i == 95) {
                                                                arrayList.add(value);
                                                            }
                                                        } else {
                                                            if (!a(str2, campaignExK)) {
                                                                return null;
                                                            }
                                                            arrayList.add(value);
                                                        }
                                                    } else {
                                                        if (ac.a().a("u_n_c_e_d", true)) {
                                                            j = jCurrentTimeMillis;
                                                            i2 = 1;
                                                        } else {
                                                            jG = value.g();
                                                            if (value.j() == 1) {
                                                                j = jCurrentTimeMillis;
                                                                if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                                    value.b("download timeout");
                                                                    value.r();
                                                                    this.i.remove(map);
                                                                    i3--;
                                                                    if (i != 1) {
                                                                    }
                                                                }
                                                            } else {
                                                                j = jCurrentTimeMillis;
                                                            }
                                                            if (iJ != 4) {
                                                            }
                                                            this.i.remove(map);
                                                            value.r();
                                                            i3--;
                                                        }
                                                        if (iJ == i2) {
                                                            if (i != 94) {
                                                                arrayList.add(value);
                                                            } else {
                                                                arrayList.add(value);
                                                            }
                                                        } else if (!value.f()) {
                                                            if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                if (i != 94) {
                                                                    arrayList.add(value);
                                                                } else {
                                                                    arrayList.add(value);
                                                                }
                                                            } else if (i != 94) {
                                                                arrayList.add(value);
                                                            } else {
                                                                arrayList.add(value);
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                zIsEmpty = TextUtils.isEmpty(value.p());
                                                iJ = value.j();
                                                if (iJ == 5) {
                                                    if (value.f()) {
                                                        value.q();
                                                        this.i.remove(map);
                                                        i3--;
                                                        it2 = it;
                                                    } else if (!zIsEmpty) {
                                                        value.a(0, 0);
                                                        if (i == 95) {
                                                            arrayList.add(value);
                                                        }
                                                    } else {
                                                        if (!a(str2, campaignExK)) {
                                                            return null;
                                                        }
                                                        arrayList.add(value);
                                                    }
                                                } else {
                                                    if (ac.a().a("u_n_c_e_d", true)) {
                                                        jG = value.g();
                                                        if (value.j() == 1) {
                                                            j = jCurrentTimeMillis;
                                                            if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                                value.b("download timeout");
                                                                value.r();
                                                                this.i.remove(map);
                                                                i3--;
                                                                if (i != 1 && i != 94) {
                                                                }
                                                            }
                                                        } else {
                                                            j = jCurrentTimeMillis;
                                                        }
                                                        if (iJ != 4 || iJ == 2) {
                                                            this.i.remove(map);
                                                            value.r();
                                                            i3--;
                                                        } else {
                                                            i2 = 1;
                                                        }
                                                    } else {
                                                        j = jCurrentTimeMillis;
                                                        i2 = 1;
                                                    }
                                                    if (iJ == i2) {
                                                        if (!value.f()) {
                                                            if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(value, b(campaignExK), z2) && a(str2, campaignExK)) {
                                                                arrayList.add(value);
                                                            } else if (i != 94) {
                                                                arrayList.add(value);
                                                            } else {
                                                                arrayList.add(value);
                                                            }
                                                        }
                                                    } else if ((i != 94 || i == 287) && a(value, b(campaignExK), z2) && a(str2, campaignExK)) {
                                                        arrayList.add(value);
                                                    }
                                                }
                                            }
                                        }
                                        j = jCurrentTimeMillis;
                                    } else {
                                        zIsEmpty = TextUtils.isEmpty(value.p());
                                        iJ = value.j();
                                        if (iJ == 5) {
                                            if (value.f()) {
                                                value.q();
                                                this.i.remove(map);
                                                i3--;
                                                it2 = it;
                                            } else {
                                                if (!zIsEmpty) {
                                                    value.a(0, 0);
                                                    if (i == 95) {
                                                        arrayList.add(value);
                                                    }
                                                } else {
                                                    if (!a(str2, campaignExK)) {
                                                        return null;
                                                    }
                                                    arrayList.add(value);
                                                }
                                                j = jCurrentTimeMillis;
                                            }
                                        } else {
                                            if (ac.a().a("u_n_c_e_d", true)) {
                                                jG = value.g();
                                                if (value.j() == 1) {
                                                    j = jCurrentTimeMillis;
                                                    if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                        value.b("download timeout");
                                                        value.r();
                                                        this.i.remove(map);
                                                        i3--;
                                                        if (i != 1) {
                                                        }
                                                    }
                                                } else {
                                                    j = jCurrentTimeMillis;
                                                }
                                                if (iJ != 4) {
                                                }
                                                this.i.remove(map);
                                                value.r();
                                                i3--;
                                            } else {
                                                j = jCurrentTimeMillis;
                                                i2 = 1;
                                            }
                                            if (iJ == i2) {
                                                if (i != 94) {
                                                    arrayList.add(value);
                                                } else {
                                                    arrayList.add(value);
                                                }
                                            } else if (!value.f()) {
                                                if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                    if (i != 94) {
                                                        arrayList.add(value);
                                                    } else {
                                                        arrayList.add(value);
                                                    }
                                                } else if (i != 94) {
                                                    arrayList.add(value);
                                                } else {
                                                    arrayList.add(value);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    j = jCurrentTimeMillis;
                                    it = it2;
                                }
                                it2 = it;
                                jCurrentTimeMillis = j;
                            }
                        }
                        i3++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public final boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            CampaignEx campaignEx = list.get(i);
            if (campaignEx == null || !a(new a(com.mbridge.msdk.foundation.controller.b.d().g(), campaignEx, str, this.o), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return e(campaignEx);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a6 A[Catch: all -> 0x0284, DONT_GENERATE, TRY_ENTER, TryCatch #0 {all -> 0x0284, blocks: (B:11:0x0019, B:15:0x0025, B:17:0x0031, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:90:0x0173, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:100:0x019e, B:102:0x01a0, B:104:0x01a6, B:106:0x01a8, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:129:0x0209, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:149:0x0246, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:158:0x0262, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:80:0x0149, B:82:0x014b, B:84:0x0155, B:172:0x028a, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:165:0x0281, B:25:0x0049, B:171:0x0287), top: B:178:0x0019, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01a8 A[Catch: all -> 0x0284, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {all -> 0x0284, blocks: (B:11:0x0019, B:15:0x0025, B:17:0x0031, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:90:0x0173, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:100:0x019e, B:102:0x01a0, B:104:0x01a6, B:106:0x01a8, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:129:0x0209, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:149:0x0246, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:158:0x0262, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:80:0x0149, B:82:0x014b, B:84:0x0155, B:172:0x028a, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:165:0x0281, B:25:0x0049, B:171:0x0287), top: B:178:0x0019, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01b9 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x01c3 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x01d0 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:121:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f0 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x01f6 A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_LEAVE, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x020b A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_ENTER, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0218  */
    /* JADX WARN: Code duplicated, block: B:140:0x022a A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0230  */
    /* JADX WARN: Code duplicated, block: B:143:0x0232 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0236 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0250 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:154:0x0252 A[Catch: all -> 0x0284, Exception -> 0x0286, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0194 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0157 A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_ENTER, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0169 A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_LEAVE, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x017a A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_ENTER, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0196 A[Catch: all -> 0x0284, Exception -> 0x0286, TRY_LEAVE, TryCatch #1 {Exception -> 0x0286, blocks: (B:11:0x0019, B:15:0x0025, B:28:0x0073, B:29:0x0078, B:31:0x0080, B:32:0x0090, B:34:0x0096, B:36:0x00a4, B:39:0x00ac, B:40:0x00b6, B:42:0x00bc, B:49:0x00dd, B:52:0x00e5, B:55:0x00ec, B:57:0x00f8, B:59:0x00fe, B:60:0x0106, B:86:0x0157, B:88:0x0169, B:94:0x017a, B:96:0x0180, B:98:0x0196, B:102:0x01a0, B:110:0x01ac, B:112:0x01b9, B:114:0x01c3, B:116:0x01d0, B:122:0x01ea, B:124:0x01f0, B:126:0x01f6, B:131:0x020b, B:137:0x021e, B:140:0x022a, B:143:0x0232, B:145:0x0236, B:147:0x0240, B:151:0x0248, B:154:0x0252, B:156:0x025c, B:64:0x0113, B:66:0x0119, B:68:0x0123, B:71:0x012c, B:73:0x0132, B:75:0x0138, B:78:0x0143, B:82:0x014b, B:19:0x0033, B:21:0x003f, B:27:0x0057, B:164:0x027a, B:25:0x0049), top: B:178:0x0019, outer: #0 }] */
    public final a a(int i, boolean z) {
        List<CampaignEx> listA;
        List<CampaignEx> list;
        char c;
        boolean z2;
        boolean zIsEmpty;
        int iJ;
        int i2;
        long jG;
        int i3;
        m mVar;
        i = i;
        if (this.r && (mVar = this.q) != null) {
            return mVar.b();
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                try {
                    int i4 = this.p;
                    char c2 = 287;
                    int i5 = 94;
                    boolean z3 = true;
                    if (i4 == 94 || i4 == 287) {
                        listA = com.mbridge.msdk.videocommon.a.a.a().a(this.m, 1, z);
                        if ((listA == null || listA.size() == 0) && (i == 94 || i == 287)) {
                            listA = com.mbridge.msdk.videocommon.a.a.a().c(this.m, 1, z, "");
                        }
                        if (listA != null) {
                            aa.a("UnitCacheCtroller", "UnitCache isReady campaignList = " + listA.size());
                        } else {
                            aa.a("UnitCacheCtroller", "UnitCache isReady campaignList = 0");
                            return null;
                        }
                    } else {
                        listA = com.mbridge.msdk.videocommon.a.a.a().a(this.m, 1);
                        if (listA == null) {
                            return null;
                        }
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i6 = 0;
                    while (i6 < this.i.size()) {
                        Map<String, a> map = this.i.get(i6);
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value == null || value.k() == null) {
                                list = listA;
                                c = c2;
                                z2 = z3;
                            } else {
                                CampaignEx campaignExK = value.k();
                                Iterator<CampaignEx> it2 = listA.iterator();
                                boolean z4 = false;
                                while (it2.hasNext()) {
                                    if (campaignExK.getId().equals(it2.next().getId())) {
                                        z4 = true;
                                    }
                                }
                                if (z4 && ((!z || campaignExK.isBidCampaign()) && (z || !campaignExK.isBidCampaign()))) {
                                    String str = campaignExK.getendcard_url();
                                    String videoUrlEncode = campaignExK.getVideoUrlEncode();
                                    String strE = "";
                                    if (campaignExK != null && campaignExK.getRewardTemplateMode() != null) {
                                        strE = campaignExK.getRewardTemplateMode().e();
                                    }
                                    String str2 = strE;
                                    campaignExK.getRewardTemplateMode();
                                    if (this.p == i5 || i == 287) {
                                        if (TextUtils.isEmpty(str2) || str2.contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a(this.p, campaignExK, str2)) {
                                            if (b(str, campaignExK)) {
                                                if (value.f()) {
                                                    value.q();
                                                } else {
                                                    if (ak.a(videoUrlEncode)) {
                                                        return value;
                                                    }
                                                    if (a(value, b(campaignExK))) {
                                                        return value;
                                                    }
                                                    zIsEmpty = TextUtils.isEmpty(value.p());
                                                    iJ = value.j();
                                                    if (this.p != 298) {
                                                    }
                                                    if (iJ == 5) {
                                                        if (value.f()) {
                                                            value.q();
                                                            this.i.remove(map);
                                                            i6--;
                                                            c2 = 287;
                                                            i5 = 94;
                                                            z3 = true;
                                                        } else if (!zIsEmpty) {
                                                            value.a(0, 0);
                                                            if (this.p == 95) {
                                                                return value;
                                                            }
                                                        } else {
                                                            if (a(str, campaignExK)) {
                                                                return value;
                                                            }
                                                            return null;
                                                        }
                                                    } else {
                                                        if (!ac.a().a("u_n_c_e_d", true)) {
                                                            jG = value.g();
                                                            if (value.j() == 1) {
                                                                list = listA;
                                                                if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                                    value.b("download timeout");
                                                                    value.r();
                                                                    this.i.remove(map);
                                                                    i6--;
                                                                    i3 = this.p;
                                                                    if (i3 != 1) {
                                                                    }
                                                                }
                                                            } else {
                                                                list = listA;
                                                            }
                                                            if (this.p == 95) {
                                                                if (value.f()) {
                                                                    return value;
                                                                }
                                                                value.q();
                                                                this.i.remove(map);
                                                            } else {
                                                                if (ac.a().a("u_n_c_e_d", true)) {
                                                                }
                                                                z2 = true;
                                                                if (iJ == 1) {
                                                                    if (value.f()) {
                                                                        i5 = 94;
                                                                        c = 287;
                                                                    } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                        return value;
                                                                    }
                                                                }
                                                                i2 = this.p;
                                                                i5 = 94;
                                                                c = 287;
                                                                if (i2 != 94) {
                                                                }
                                                            }
                                                            i6--;
                                                        } else {
                                                            list = listA;
                                                            if (this.p == 95) {
                                                                if (value.f()) {
                                                                    return value;
                                                                }
                                                                value.q();
                                                                this.i.remove(map);
                                                            } else {
                                                                if (ac.a().a("u_n_c_e_d", true)) {
                                                                }
                                                                z2 = true;
                                                                if (iJ == 1) {
                                                                    if (value.f()) {
                                                                        i5 = 94;
                                                                        c = 287;
                                                                    } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                        return value;
                                                                    }
                                                                }
                                                                i2 = this.p;
                                                                i5 = 94;
                                                                c = 287;
                                                                if (i2 != 94) {
                                                                }
                                                            }
                                                            i6--;
                                                        }
                                                        listA = list;
                                                        c2 = 287;
                                                        i5 = 94;
                                                        z3 = true;
                                                    }
                                                }
                                            } else {
                                                zIsEmpty = TextUtils.isEmpty(value.p());
                                                iJ = value.j();
                                                if (this.p != 298 && a(value, b(campaignExK))) {
                                                    return value;
                                                }
                                                if (iJ == 5) {
                                                    if (value.f()) {
                                                        value.q();
                                                        this.i.remove(map);
                                                        i6--;
                                                        c2 = 287;
                                                        i5 = 94;
                                                        z3 = true;
                                                    } else if (!zIsEmpty) {
                                                        value.a(0, 0);
                                                        if (this.p == 95) {
                                                            return value;
                                                        }
                                                    } else {
                                                        if (a(str, campaignExK)) {
                                                            return value;
                                                        }
                                                        return null;
                                                    }
                                                } else {
                                                    if (!ac.a().a("u_n_c_e_d", true)) {
                                                        jG = value.g();
                                                        if (value.j() == 1) {
                                                            list = listA;
                                                            if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                                value.b("download timeout");
                                                                value.r();
                                                                this.i.remove(map);
                                                                i6--;
                                                                i3 = this.p;
                                                                if (i3 != 1 && i3 != 94) {
                                                                }
                                                            }
                                                        } else {
                                                            list = listA;
                                                        }
                                                        if (this.p == 95) {
                                                            if (value.f()) {
                                                                return value;
                                                            }
                                                            value.q();
                                                            this.i.remove(map);
                                                        } else if (ac.a().a("u_n_c_e_d", true) && (iJ == 4 || iJ == 2)) {
                                                            this.i.remove(map);
                                                            value.r();
                                                        } else {
                                                            z2 = true;
                                                            if (iJ == 1) {
                                                                if (value.f()) {
                                                                    i5 = 94;
                                                                    c = 287;
                                                                } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(value, b(campaignExK)) && a(str, campaignExK)) {
                                                                    return value;
                                                                }
                                                            }
                                                            i2 = this.p;
                                                            i5 = 94;
                                                            c = 287;
                                                            if ((i2 != 94 || i2 == 287) && a(value, b(campaignExK)) && a(str, campaignExK)) {
                                                            }
                                                        }
                                                        i6--;
                                                    } else {
                                                        list = listA;
                                                        if (this.p == 95) {
                                                            if (value.f()) {
                                                                return value;
                                                            }
                                                            value.q();
                                                            this.i.remove(map);
                                                        } else {
                                                            if (ac.a().a("u_n_c_e_d", true)) {
                                                            }
                                                            z2 = true;
                                                            if (iJ == 1) {
                                                                if (value.f()) {
                                                                    i5 = 94;
                                                                    c = 287;
                                                                } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                    return value;
                                                                }
                                                            }
                                                            i2 = this.p;
                                                            i5 = 94;
                                                            c = 287;
                                                            return i2 != 94 ? value : value;
                                                        }
                                                        i6--;
                                                    }
                                                    listA = list;
                                                    c2 = 287;
                                                    i5 = 94;
                                                    z3 = true;
                                                }
                                            }
                                        }
                                        list = listA;
                                        z2 = true;
                                        i5 = 94;
                                        c = 287;
                                    } else {
                                        zIsEmpty = TextUtils.isEmpty(value.p());
                                        iJ = value.j();
                                        if (this.p != 298) {
                                        }
                                        if (iJ == 5) {
                                            if (value.f()) {
                                                value.q();
                                                this.i.remove(map);
                                                i6--;
                                                c2 = 287;
                                                i5 = 94;
                                                z3 = true;
                                            } else if (!zIsEmpty) {
                                                value.a(0, 0);
                                                if (this.p == 95) {
                                                    return value;
                                                }
                                                list = listA;
                                                z2 = true;
                                                i5 = 94;
                                                c = 287;
                                            } else {
                                                if (a(str, campaignExK)) {
                                                    return value;
                                                }
                                                return null;
                                            }
                                        } else {
                                            if (!ac.a().a("u_n_c_e_d", true)) {
                                                jG = value.g();
                                                if (value.j() == 1) {
                                                    list = listA;
                                                    if (jCurrentTimeMillis - jG > this.l * 1000) {
                                                        value.b("download timeout");
                                                        value.r();
                                                        this.i.remove(map);
                                                        i6--;
                                                        i3 = this.p;
                                                        if (i3 != 1) {
                                                        }
                                                    }
                                                } else {
                                                    list = listA;
                                                }
                                                if (this.p == 95) {
                                                    if (value.f()) {
                                                        return value;
                                                    }
                                                    value.q();
                                                    this.i.remove(map);
                                                } else {
                                                    if (ac.a().a("u_n_c_e_d", true)) {
                                                    }
                                                    z2 = true;
                                                    if (iJ == 1) {
                                                        if (value.f()) {
                                                            i5 = 94;
                                                            c = 287;
                                                        } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                            return value;
                                                        }
                                                    }
                                                    i2 = this.p;
                                                    i5 = 94;
                                                    c = 287;
                                                    if (i2 != 94) {
                                                    }
                                                }
                                                i6--;
                                            } else {
                                                list = listA;
                                                if (this.p == 95) {
                                                    if (value.f()) {
                                                        return value;
                                                    }
                                                    value.q();
                                                    this.i.remove(map);
                                                } else {
                                                    if (ac.a().a("u_n_c_e_d", true)) {
                                                    }
                                                    z2 = true;
                                                    if (iJ == 1) {
                                                        if (value.f()) {
                                                            i5 = 94;
                                                            c = 287;
                                                        } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                            return value;
                                                        }
                                                    }
                                                    i2 = this.p;
                                                    i5 = 94;
                                                    c = 287;
                                                    if (i2 != 94) {
                                                    }
                                                }
                                                i6--;
                                            }
                                            listA = list;
                                            c2 = 287;
                                            i5 = 94;
                                            z3 = true;
                                        }
                                    }
                                } else {
                                    list = listA;
                                    c = c2;
                                    z2 = true;
                                }
                            }
                            z3 = z2;
                            c2 = c;
                            listA = list;
                        }
                        i6++;
                        listA = listA;
                        i = i;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(a aVar, int i) {
        long jL = aVar.l();
        long jI = aVar.i();
        if (TextUtils.isEmpty(aVar.e())) {
            aa.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i == 0) {
            if (aVar.k() != null && !TextUtils.isEmpty(aVar.k().getVideoUrlEncode())) {
                return true;
            }
        } else if (jI > 0 && jL * 100 >= jI * ((long) i)) {
            if (i != 100 || aVar.j() == 5) {
                return true;
            }
            aVar.r();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i, boolean z) {
        long jL = aVar.l();
        long jI = aVar.i();
        if (TextUtils.isEmpty(aVar.e())) {
            aa.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx campaignExK = aVar.k();
        if (campaignExK != null) {
            if (campaignExK.getRsIgnoreCheckRule() != null && campaignExK.getRsIgnoreCheckRule().size() > 0 && campaignExK.getRsIgnoreCheckRule().contains(0)) {
                aa.b("UnitCacheCtroller", "Is not check video download status");
                return true;
            }
            if (campaignExK.getIsTimeoutCheckVideoStatus() == 1 && campaignExK.getVideoCheckType() == 1) {
                return true;
            }
            if (z && campaignExK.getVideoCheckType() == 1) {
                if (i == 0) {
                    return true;
                }
                if ((jI != 0 || jL != 0) && jL >= ((long) (i / 100)) * jI) {
                    campaignExK.setIsTimeoutCheckVideoStatus(1);
                    return true;
                }
            }
        }
        return a(aVar, i);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                return (campaignEx.isDynamicView() && !af.j(str)) || ak.a(str) || b(str, campaignEx);
            }
            aa.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return false;
        }
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
            return ak.b(g.a().b(str)) || ak.b(h.a.a.b(str));
        }
        aa.b("UnitCacheCtroller", "Is not check endCard download status : " + str);
        return true;
    }

    private boolean a(int i, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(1)) {
            return (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0 && g.a().b(str) == null) ? false : true;
        }
        aa.b("UnitCacheCtroller", "Is not check template download status");
        return true;
    }

    public final a b(int i, boolean z) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.c();
        }
        try {
            return a(i, z);
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return null;
        }
    }

    public final a a(String str) {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                for (Map<String, a> map : this.i) {
                    if (map != null && map.containsKey(str)) {
                        return map.get(str);
                    }
                }
            } catch (Throwable unused) {
                aa.d("UnitCacheCtroller", "failed to get campaignTast by cid");
            }
            return null;
        }
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            for (Map<String, a> map : copyOnWriteArrayList) {
                if (map != null) {
                    Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue().j() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00d6  */
    public final void a() {
        int iS;
        com.mbridge.msdk.videocommon.listener.a aVar;
        int i;
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.a();
            return;
        }
        d();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                if (!a(this.i)) {
                    this.d = true;
                }
                for (Map<String, a> map : this.i) {
                    if (map != null) {
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value != null && !value.f()) {
                                if (this.p == 95) {
                                    this.d = true;
                                }
                                int iJ = value.j();
                                final CampaignEx campaignExK = value.k();
                                if (campaignExK != null && iJ == 0) {
                                    iJ = c.getInstance().b(campaignExK.getId(), campaignExK.getVideoUrlEncode());
                                }
                                int i2 = iJ;
                                value.a(new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.videocommon.download.n.2
                                    @Override // com.mbridge.msdk.videocommon.listener.a
                                    public final void a(String str) {
                                        com.mbridge.msdk.videocommon.listener.a aVar2;
                                        if (n.this.e != null) {
                                            n.this.e.a(str);
                                        }
                                        if (n.this.g == null || n.this.g.size() <= 0 || campaignExK == null || (aVar2 = (com.mbridge.msdk.videocommon.listener.a) n.this.g.get(campaignExK.getRequestId())) == null) {
                                            return;
                                        }
                                        aVar2.a(str);
                                    }

                                    @Override // com.mbridge.msdk.videocommon.listener.a
                                    public final void a(String str, String str2) {
                                        com.mbridge.msdk.videocommon.listener.a aVar2;
                                        if (n.this.e != null) {
                                            n.this.e.a(str, str2);
                                        }
                                        CampaignEx campaignEx = campaignExK;
                                        if (campaignEx == null || campaignEx.getRsIgnoreCheckRule() == null || campaignExK.getRsIgnoreCheckRule().size() <= 0 || !campaignExK.getRsIgnoreCheckRule().contains(0)) {
                                            if (n.this.g == null || n.this.g.size() <= 0 || campaignExK == null || (aVar2 = (com.mbridge.msdk.videocommon.listener.a) n.this.g.get(campaignExK.getRequestId())) == null) {
                                                return;
                                            }
                                            aVar2.a(str, str2);
                                            return;
                                        }
                                        aa.b("UnitCacheCtroller", "Is not check video download status");
                                    }
                                });
                                int iB = b(campaignExK);
                                if (this.p == 1) {
                                    if (this.a == null) {
                                        this.a = com.mbridge.msdk.c.f.d(this.m);
                                    }
                                    iB = d(campaignExK);
                                }
                                int i3 = iB;
                                value.c(i3);
                                int i4 = this.p;
                                if (i4 == 94 || i4 == 287 || i4 == 95) {
                                    if (this.n == null) {
                                        this.n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.m, this.p == 287);
                                    }
                                    com.mbridge.msdk.videocommon.d.c cVar = this.n;
                                    iS = cVar != null ? cVar.s() : 0;
                                } else {
                                    if (i4 != 298) {
                                        iS = 0;
                                    } else {
                                        if (this.f2673b == null) {
                                            this.f2673b = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                                        }
                                        com.mbridge.msdk.c.f fVar = this.f2673b;
                                        if (fVar != null) {
                                            iS = fVar.g();
                                        } else {
                                            iS = 0;
                                        }
                                    }
                                    if (this.p == 1) {
                                        if (this.a == null) {
                                            this.a = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                                        }
                                        com.mbridge.msdk.c.f fVar2 = this.a;
                                        if (fVar2 != null) {
                                            iS = fVar2.g();
                                        }
                                    }
                                }
                                value.b(iS);
                                int videoCtnType = campaignExK != null ? campaignExK.getVideoCtnType() : 1;
                                value.e(videoCtnType);
                                aa.d("UnitCacheCtroller", "ready_rate : " + i3 + " cd_rate : " + iS + " videoCtnType : " + videoCtnType);
                                if (a(value, b(campaignExK))) {
                                    com.mbridge.msdk.videocommon.listener.a aVar2 = this.e;
                                    if (aVar2 != null && ((i = this.p) == 297 || i == 298)) {
                                        aVar2.a(campaignExK.getVideoUrlEncode());
                                    }
                                    ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.g;
                                    if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (aVar = this.g.get(campaignExK.getRequestId())) != null && campaignExK != null) {
                                        try {
                                            if (campaignExK.getCurrentLRid().equals(this.f)) {
                                                HashMap map2 = new HashMap();
                                                map2.put("type", "4");
                                                map2.put("cache", "1");
                                                map2.put("update", "1");
                                                com.mbridge.msdk.foundation.same.report.m.a().a("2000153", campaignExK, map2);
                                            }
                                        } catch (Exception e) {
                                            aa.d("UnitCacheCtroller", e.getMessage());
                                        }
                                        aVar.a(campaignExK.getVideoUrlEncode());
                                    }
                                }
                                if (i2 != 1 && (i2 != 5 || !a(value, i3))) {
                                    if (i2 == 4) {
                                        continue;
                                    } else {
                                        if (w.r(this.j) != 9 && this.o == 2) {
                                            return;
                                        }
                                        if (i2 == 2 || this.d) {
                                            value.a(this.h);
                                            if (a(value, i3)) {
                                                int i5 = this.p;
                                                if (i5 == 94 || i5 == 287) {
                                                    value.n();
                                                }
                                            } else {
                                                int i6 = this.p;
                                                if (i6 == 1 || i6 == 95 || i6 == 298) {
                                                    this.d = false;
                                                }
                                                value.n();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.r || this.q == null) && (copyOnWriteArrayList = this.i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    for (Map<String, a> map : this.i) {
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                a value = it.next().getValue();
                                if (value != null && value.j() == 1) {
                                    value.b("playing and stop download");
                                    value.r();
                                    this.i.remove(map);
                                    return;
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            return mVar.d();
        }
        return this.i;
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.c.f fVar = this.a;
            if (fVar != null) {
                return fVar.f();
            }
            return 100;
        } catch (Exception unused) {
            return 100;
        }
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        m mVar;
        if (this.r && (mVar = this.q) != null) {
            mVar.b(str);
            return;
        }
        try {
            synchronized (this.i) {
                if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.i) != null && copyOnWriteArrayList.size() > 0) {
                    for (Map<String, a> map : this.i) {
                        if (map != null) {
                            for (Map.Entry<String, a> entry : map.entrySet()) {
                                if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                    this.i.remove(map);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f2673b == null) {
                    this.f2673b = com.mbridge.msdk.c.d.a().c(com.mbridge.msdk.foundation.controller.b.d().h(), this.m);
                }
                return this.f2673b.f();
            }
            if (campaignEx.getAdType() == 42) {
                return d(null);
            }
            if (this.n == null) {
                this.n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), this.m, false);
            }
            return this.n.r();
        } catch (Throwable th) {
            aa.b("UnitCacheCtroller", th.getMessage(), th);
            return 100;
        }
    }
}
