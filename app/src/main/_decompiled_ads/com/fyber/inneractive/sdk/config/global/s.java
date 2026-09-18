package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public Map<Class<? extends com.fyber.inneractive.sdk.config.global.features.g>, com.fyber.inneractive.sdk.config.global.features.g> c;
    public JSONArray d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f884b = "";
    public final r a = new r();

    public s() {
        e();
        Map<Class<? extends com.fyber.inneractive.sdk.config.global.features.g>, com.fyber.inneractive.sdk.config.global.features.g> mapA = a();
        this.c = mapA;
        IAlog.a("%s: created. Supported features: %s", "SupportedFeaturesProvider", mapA);
    }

    public static s b() {
        boolean zF = f();
        s sVar = new s();
        if (zF) {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            iAConfigManager.L.a("", true);
            iAConfigManager.E.a(iAConfigManager.L);
        }
        return sVar;
    }

    public static boolean f() {
        int i = com.fyber.inneractive.sdk.config.f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.featuresConfig");
        if (TextUtils.isEmpty(property)) {
            return false;
        }
        try {
            IAConfigManager.M.z.a = l.a(new JSONObject(property));
            return true;
        } catch (Exception unused) {
            IAlog.a("failed parsing local features json", new Object[0]);
            return false;
        }
    }

    public Map<Class<? extends com.fyber.inneractive.sdk.config.global.features.g>, com.fyber.inneractive.sdk.config.global.features.g> a() {
        HashMap map = new HashMap();
        for (Map.Entry<Class<? extends com.fyber.inneractive.sdk.config.global.features.g>, com.fyber.inneractive.sdk.config.global.features.g> entry : this.c.entrySet()) {
            map.put(entry.getKey(), entry.getValue().b());
        }
        return map;
    }

    public JSONArray c() {
        JSONArray jSONArray = this.d;
        if (jSONArray == null || jSONArray.length() == 0) {
            JSONArray jSONArrayA = g.a(this.c, false);
            this.d = jSONArrayA;
            IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        }
        return this.d;
    }

    public JSONArray d() {
        JSONArray jSONArrayA = g.a(this.c, true);
        IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArrayA);
        return jSONArrayA;
    }

    public void e() {
        this.a.getClass();
        HashMap map = new HashMap();
        map.put(com.fyber.inneractive.sdk.config.global.features.r.class, new com.fyber.inneractive.sdk.config.global.features.r());
        map.put(com.fyber.inneractive.sdk.config.global.features.c.class, new com.fyber.inneractive.sdk.config.global.features.c());
        map.put(com.fyber.inneractive.sdk.config.global.features.l.class, new com.fyber.inneractive.sdk.config.global.features.l());
        map.put(com.fyber.inneractive.sdk.config.global.features.e.class, new com.fyber.inneractive.sdk.config.global.features.e());
        map.put(com.fyber.inneractive.sdk.config.global.features.k.class, new com.fyber.inneractive.sdk.config.global.features.k());
        map.put(com.fyber.inneractive.sdk.config.global.features.d.class, new com.fyber.inneractive.sdk.config.global.features.d());
        map.put(com.fyber.inneractive.sdk.config.global.features.q.class, new com.fyber.inneractive.sdk.config.global.features.q());
        map.put(com.fyber.inneractive.sdk.config.global.features.h.class, new com.fyber.inneractive.sdk.config.global.features.h());
        map.put(com.fyber.inneractive.sdk.config.global.features.i.class, new com.fyber.inneractive.sdk.config.global.features.i());
        map.put(com.fyber.inneractive.sdk.config.global.features.p.class, new com.fyber.inneractive.sdk.config.global.features.p());
        map.put(com.fyber.inneractive.sdk.config.global.features.n.class, new com.fyber.inneractive.sdk.config.global.features.n());
        map.put(com.fyber.inneractive.sdk.config.global.features.b.class, new com.fyber.inneractive.sdk.config.global.features.b());
        map.put(com.fyber.inneractive.sdk.config.global.features.m.class, new com.fyber.inneractive.sdk.config.global.features.m());
        map.put(com.fyber.inneractive.sdk.config.global.features.a.class, new com.fyber.inneractive.sdk.config.global.features.a());
        map.put(com.fyber.inneractive.sdk.config.global.features.f.class, new com.fyber.inneractive.sdk.config.global.features.f());
        map.put(com.fyber.inneractive.sdk.config.global.features.j.class, new com.fyber.inneractive.sdk.config.global.features.j());
        this.c = map;
        this.d = null;
    }

    public void a(e eVar) {
        for (com.fyber.inneractive.sdk.config.global.features.g gVar : this.c.values()) {
            ArrayList arrayList = (ArrayList) gVar.c();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                b bVar = (b) arrayList.get(size);
                List<d> list = bVar.d;
                if (list != null) {
                    for (d dVar : list) {
                        if (dVar.a(eVar)) {
                            gVar.c.remove(bVar.a);
                            gVar.d.remove(bVar.a);
                            this.d = null;
                            IAlog.a("%s: Experiment %s filtered! after response %s", "SupportedFeaturesProvider", bVar.a, dVar);
                            break;
                        }
                    }
                }
            }
        }
    }

    public <T extends com.fyber.inneractive.sdk.config.global.features.g> T a(Class<T> cls) {
        if (this.c.containsKey(cls)) {
            T t = (T) this.c.get(cls);
            if (cls.isInstance(t)) {
                return t;
            }
        }
        try {
            return cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            IAlog.a("Couldn't create a feature for %s", e, cls.getName());
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:40:0x0107  */
    /* JADX WARN: Code duplicated, block: B:47:0x0127  */
    /* JADX WARN: Code duplicated, block: B:51:0x0138  */
    /* JADX WARN: Code duplicated, block: B:52:0x013f  */
    public void a(String str, boolean z) {
        int i;
        int i2;
        Iterator<k> it;
        n nVar;
        int i3;
        com.fyber.inneractive.sdk.util.s sVar;
        boolean zA;
        int i4;
        k next;
        this.f884b = str;
        a aVar = IAConfigManager.M.z;
        aVar.f873b = this;
        for (com.fyber.inneractive.sdk.config.global.features.g gVar : this.c.values()) {
            boolean z2 = gVar instanceof com.fyber.inneractive.sdk.config.global.features.o;
            if ((z2 && z) || (!z2 && !z)) {
                l lVar = aVar.a;
                if (gVar != null && lVar != null) {
                    q qVarA = lVar.a(gVar.f878b);
                    int i5 = 2;
                    int i6 = 1;
                    if (qVarA != null) {
                        gVar.a = qVarA.a;
                        IAlog.a("%s: Feature before variant merge: %s", "a", gVar);
                        Map<String, b> map = qVarA.c;
                        Iterator<String> it2 = map.keySet().iterator();
                        while (it2.hasNext()) {
                            b bVar = map.get(it2.next());
                            if (bVar != null) {
                                int iNextInt = new Random().nextInt(100) + i6;
                                int i7 = 3;
                                if (bVar.f874b < iNextInt) {
                                    Object[] objArr = new Object[4];
                                    objArr[0] = "a";
                                    objArr[i6] = bVar.a;
                                    objArr[i5] = Integer.valueOf(iNextInt);
                                    objArr[3] = Integer.valueOf(bVar.f874b);
                                    IAlog.a("%s: Experiment '%s' filtered! rand: %d, with perc: %d", objArr);
                                    i2 = i6;
                                    i = 3;
                                } else {
                                    List<d> list = bVar.d;
                                    if (list != null) {
                                        Iterator<d> it3 = list.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                d next2 = it3.next();
                                                try {
                                                    Long lValueOf = Long.valueOf(IAConfigManager.M.d);
                                                    e eVar = new e();
                                                    eVar.f876b = lValueOf;
                                                    eVar.c = com.fyber.inneractive.sdk.serverapi.a.a(aVar.f873b.f884b);
                                                    if (next2.a(eVar)) {
                                                        Object[] objArr2 = new Object[i7];
                                                        objArr2[0] = "a";
                                                        objArr2[i6] = bVar.a;
                                                        objArr2[2] = next2;
                                                        IAlog.a("%s: Experiment '%s' filtered! with %s", objArr2);
                                                    }
                                                } catch (NumberFormatException unused) {
                                                    Object[] objArr3 = new Object[i6];
                                                    objArr3[0] = "a";
                                                    IAlog.a("%s: invalid publisherId", objArr3);
                                                    i7 = 3;
                                                }
                                            } else {
                                                if (gVar instanceof com.fyber.inneractive.sdk.config.global.features.r) {
                                                    it = bVar.c.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            k next3 = it.next();
                                                            nVar = next3.a;
                                                            if (nVar == null && nVar.a() != null && next3.a.a().containsKey("use_fmp_cache_mechanism")) {
                                                                i3 = i6;
                                                            } else {
                                                                i3 = 0;
                                                            }
                                                            if (i3 == 0) {
                                                                sVar = IAConfigManager.M.I.get(t.Video);
                                                                if (sVar != null) {
                                                                    zA = sVar.a("vid_cache");
                                                                } else {
                                                                    zA = false;
                                                                }
                                                                if (!zA) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                Object[] objArr4 = new Object[4];
                                                objArr4[0] = "a";
                                                objArr4[i6] = bVar.a;
                                                objArr4[2] = Integer.valueOf(iNextInt);
                                                i = 3;
                                                objArr4[3] = Integer.valueOf(bVar.f874b);
                                                IAlog.a("%s: Experiment '%s' NOT filtered! rand: %d, with perc: %d", objArr4);
                                                i2 = 0;
                                            }
                                            i2 = i6;
                                            i = 3;
                                        }
                                    } else {
                                        if (gVar instanceof com.fyber.inneractive.sdk.config.global.features.r) {
                                            it = bVar.c.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    k next4 = it.next();
                                                    nVar = next4.a;
                                                    if (nVar == null) {
                                                        i3 = 0;
                                                    } else {
                                                        i3 = 0;
                                                    }
                                                    if (i3 == 0) {
                                                        sVar = IAConfigManager.M.I.get(t.Video);
                                                        if (sVar != null) {
                                                            zA = sVar.a("vid_cache");
                                                        } else {
                                                            zA = false;
                                                        }
                                                        if (!zA) {
                                                            i2 = i6;
                                                            i = 3;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        Object[] objArr5 = new Object[4];
                                        objArr5[0] = "a";
                                        objArr5[i6] = bVar.a;
                                        objArr5[2] = Integer.valueOf(iNextInt);
                                        i = 3;
                                        objArr5[3] = Integer.valueOf(bVar.f874b);
                                        IAlog.a("%s: Experiment '%s' NOT filtered! rand: %d, with perc: %d", objArr5);
                                        i2 = 0;
                                    }
                                }
                                if (i2 == 0) {
                                    List<k> list2 = bVar.c;
                                    int iNextInt2 = new Random().nextInt(100) + i6;
                                    Object[] objArr6 = new Object[i];
                                    objArr6[0] = "a";
                                    objArr6[i6] = bVar.a;
                                    int i8 = 2;
                                    objArr6[2] = Integer.valueOf(iNextInt2);
                                    IAlog.a("%s: selectVariant for experiment '%s' generated random number: %d", objArr6);
                                    Iterator<k> it4 = list2.iterator();
                                    int i9 = 0;
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            i4 = i6;
                                            next = null;
                                            break;
                                        }
                                        next = it4.next();
                                        i9 += next.c;
                                        Object[] objArr7 = new Object[i8];
                                        objArr7[0] = "a";
                                        objArr7[i6] = next;
                                        IAlog.a("%s: selectVariant variant found: %s", objArr7);
                                        if (i9 >= iNextInt2) {
                                            i4 = 1;
                                            break;
                                        }
                                        Object[] objArr8 = new Object[i8];
                                        objArr8[0] = "a";
                                        objArr8[1] = next.f882b;
                                        IAlog.a("%s: selectVariant variant '%s' percentage outside selected range", objArr8);
                                        i6 = 1;
                                        i8 = 2;
                                    }
                                    if (next != null) {
                                        Object[] objArr9 = new Object[3];
                                        objArr9[0] = "a";
                                        objArr9[i4] = bVar.a;
                                        objArr9[2] = next;
                                        IAlog.a("%s: experiment '%s' variant selected! %s", objArr9);
                                    } else {
                                        Object[] objArr10 = new Object[2];
                                        objArr10[0] = "a";
                                        objArr10[i4] = bVar.a;
                                        IAlog.a("%s: experiment '%s' no variant was selected! using control group", objArr10);
                                    }
                                    gVar.c.put(bVar.a, bVar);
                                    if (next != null) {
                                        gVar.d.put(bVar.a, next);
                                    }
                                    i5 = 2;
                                    i6 = 1;
                                } else {
                                    i5 = 2;
                                }
                            }
                        }
                    }
                    Object[] objArr11 = new Object[i5];
                    objArr11[0] = "a";
                    objArr11[1] = gVar;
                    IAlog.a("%s: Feature after variant merge: %s", objArr11);
                }
            }
        }
    }
}
