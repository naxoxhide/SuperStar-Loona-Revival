package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DownLoadManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static volatile c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f2664b;
    private boolean c = false;
    private ConcurrentHashMap<String, n> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> e;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> g;

    private c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f2664b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static c getInstance() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public final a a(String str, String str2) {
        n nVarC = c(str);
        if (nVarC != null) {
            return nVarC.a(str2);
        }
        return null;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public final CopyOnWriteArrayList<a> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.g;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.g.get(str);
    }

    public final n c(String str) {
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public final boolean a(int i, String str, boolean z) {
        try {
            n nVarC = c(str);
            return (nVarC == null || nVarC.a(i, z) == null) ? false : true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return a(i, str, z, i2, z2, i3, list, false);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x018b  */
    public final boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list, boolean z3) {
        n nVarC;
        boolean z4;
        CampaignEx campaignEx;
        boolean z5 = false;
        if (list != null) {
            try {
                if (list.size() != 0 && (nVarC = c(str)) != null) {
                    List<a> listA = nVarC.a(str, i, z, list, z3);
                    if (listA != null && listA.size() != 0) {
                        if (z2) {
                            if (list.size() <= 0 || (campaignEx = list.get(0)) == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                z4 = false;
                            } else {
                                aa.b("DownLoadManager", "Is not check video download status with TPL");
                                z4 = true;
                            }
                            try {
                                if (i3 == 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (a aVar : listA) {
                                        for (CampaignEx campaignEx2 : list) {
                                            if (aVar != null && aVar.k() != null && campaignEx2 != null && campaignEx2.getId().equals(aVar.k().getId()) && campaignEx2.getRequestId().equals(aVar.k().getRequestId())) {
                                                arrayList.add(aVar);
                                            }
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        z5 = true;
                                    } else {
                                        z5 = z4;
                                    }
                                } else {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (a aVar2 : listA) {
                                        for (CampaignEx campaignEx3 : list) {
                                            if (aVar2 != null && aVar2.k() != null && campaignEx3 != null && campaignEx3.getId().equals(aVar2.k().getId()) && campaignEx3.getRequestId().equals(aVar2.k().getRequestId())) {
                                                arrayList2.add(aVar2);
                                            }
                                        }
                                    }
                                    if (arrayList2.size() >= i2) {
                                        z5 = true;
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                z5 = z4;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            for (a aVar3 : listA) {
                                for (CampaignEx campaignEx4 : list) {
                                    if (aVar3 != null && aVar3.k() != null && campaignEx4 != null && campaignEx4.getId().equals(aVar3.k().getId()) && campaignEx4.getRequestId().equals(aVar3.k().getRequestId())) {
                                        arrayList3.add(aVar3);
                                    }
                                }
                            }
                            if (arrayList3.size() > 0) {
                                z5 = true;
                            }
                        }
                    }
                    if (z5) {
                        ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> concurrentHashMap = this.e;
                        if (concurrentHashMap == null) {
                            this.e = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap.containsKey(str)) {
                            this.e.remove(str);
                        }
                        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap2 = this.g;
                        if (concurrentHashMap2 == null) {
                            this.g = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap2.containsKey(str)) {
                            this.g.remove(str);
                        }
                        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap3 = this.f;
                        if (concurrentHashMap3 == null) {
                            this.f = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap3.containsKey(str)) {
                            this.f.remove(str);
                        }
                        if (listA != null && listA.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                            CopyOnWriteArrayList<a> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
                            for (a aVar4 : listA) {
                                ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
                                CampaignEx campaignExK = aVar4.k();
                                concurrentHashMap4.put(campaignExK.getId() + campaignExK.getVideoUrlEncode() + campaignExK.getBidToken(), aVar4);
                                copyOnWriteArrayList.add(concurrentHashMap4);
                                copyOnWriteArrayList2.add(campaignExK);
                                copyOnWriteArrayList3.add(aVar4);
                            }
                            this.e.put(str, (CopyOnWriteArrayList<Map<String, a>>) copyOnWriteArrayList);
                            this.f.put(str, copyOnWriteArrayList2);
                            this.g.put(str, copyOnWriteArrayList3);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return z5;
    }

    public void load(String str) {
        n nVarC = c(str);
        if (nVarC != null) {
            nVarC.a();
        }
    }

    public n createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.d.containsKey(str)) {
            n nVar = this.d.get(str);
            if (i == 94 || i == 287) {
                nVar.a(copyOnWriteArrayList.get(0).getRequestId(), aVar);
            } else {
                nVar.a(aVar);
            }
            nVar.a(copyOnWriteArrayList);
            return nVar;
        }
        n nVar2 = new n(context, copyOnWriteArrayList, this.f2664b, str, i);
        if (aVar != null) {
            nVar2.a(aVar);
        }
        this.d.put(str, nVar2);
        return nVar2;
    }

    public n createUnitCache(Context context, String str, CampaignEx campaignEx, int i, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.d.containsKey(str)) {
            n nVar = this.d.get(str);
            if (i == 94 || i == 287) {
                nVar.a(campaignEx.getRequestId(), aVar);
            } else {
                nVar.a(aVar);
            }
            nVar.a(campaignEx);
            return nVar;
        }
        n nVar2 = new n(context, campaignEx, this.f2664b, str, i);
        if (aVar != null) {
            nVar2.a(aVar);
        }
        this.d.put(str, nVar2);
        return nVar2;
    }

    public final void a(boolean z) {
        this.c = z;
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                n value = it.next().getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayListC;
        a value;
        CampaignEx campaignExK;
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                n value2 = it.next().getValue();
                if (value2 != null && (copyOnWriteArrayListC = value2.c()) != null) {
                    int size = copyOnWriteArrayListC.size();
                    for (int i = 0; i < size; i++) {
                        Map<String, a> map = copyOnWriteArrayListC.get(i);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (campaignExK = value.k()) != null) {
                                String videoUrlEncode = campaignExK.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.j();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final void b(boolean z) {
        if (z) {
            if (this.c) {
                return;
            }
        } else {
            this.c = false;
        }
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> entry : concurrentHashMap.entrySet()) {
                n value = entry.getValue();
                String key = entry.getKey();
                try {
                    Class.forName("com.mbridge.msdk.videocommon.d.a");
                    com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), key);
                    if (cVarA != null) {
                        if (cVarA.w() == 2) {
                            value.b();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e) {
                    aa.d("DownLoadManager", e.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            com.mbridge.msdk.c.f fVarE = com.mbridge.msdk.c.d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), key);
                            if (fVarE == null) {
                                fVarE = com.mbridge.msdk.c.f.e(key);
                            }
                            if (fVarE.k() == 2) {
                                value.b();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e2) {
                        aa.d("DownLoadManager", e2.getMessage());
                    }
                }
            }
        }
    }
}
