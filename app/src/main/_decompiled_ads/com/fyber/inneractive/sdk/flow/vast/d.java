package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.model.vast.n;
import com.fyber.inneractive.sdk.model.vast.o;
import com.fyber.inneractive.sdk.model.vast.p;
import com.fyber.inneractive.sdk.model.vast.q;
import com.fyber.inneractive.sdk.model.vast.s;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.model.vast.v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.l;
import com.fyber.inneractive.sdk.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public int a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f935b = -1;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public final List<com.fyber.inneractive.sdk.measurement.f> i = new ArrayList();
    public Map<o, g> f = new LinkedHashMap();
    public List<com.fyber.inneractive.sdk.model.vast.g> g = new ArrayList();
    public final List<com.fyber.inneractive.sdk.model.vast.g> h = new ArrayList();

    public class a extends Exception {
        public int a;

        public a(d dVar, String str, int i) {
            super(str);
            this.a = i;
        }
    }

    public void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.g gVar, boolean z) throws a {
        List<s> list;
        List<String> list2 = gVar.h;
        if (list2 != null) {
            if (z) {
                this.h.add(gVar);
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                if (!x.f(it.next())) {
                    throw new a(this, "Found non secure click tracking url for companion: " + gVar, 0);
                }
            }
        }
        String str = gVar.g;
        if (!x.f(str)) {
            throw new a(this, "Found non secure click through url: " + str, 0);
        }
        Integer num = gVar.a;
        Integer num2 = gVar.f964b;
        boolean z2 = true;
        if (!(num != null && num2 != null && num.intValue() >= 100 && num2.intValue() >= 100)) {
            throw new a(this, "Incompatible size: " + num + "," + num2, 16);
        }
        String str2 = gVar.c;
        List<s> list3 = gVar.j;
        if (list3 != null) {
            for (s sVar : list3) {
                if (!x.f(sVar.f971b)) {
                    throw new a(this, "Found non secure tracking event: " + sVar, 0);
                }
            }
        }
        if (TextUtils.isEmpty(gVar.e) && TextUtils.isEmpty(gVar.f) && gVar.d == null) {
            z2 = false;
        }
        if (!z2) {
            throw new a(this, "None sources of companion avaliable", 0);
        }
        String str3 = gVar.e;
        if (!x.f(str3)) {
            throw new a(this, "Found non secure iframe url:" + str3, 0);
        }
        com.fyber.inneractive.sdk.model.vast.j jVar = gVar.d;
        if (jVar != null) {
            com.fyber.inneractive.sdk.model.vast.i iVarA = com.fyber.inneractive.sdk.model.vast.i.a(jVar.a);
            if (iVarA == null) {
                throw new a(this, "Found invalid creative type:" + jVar.a, 0);
            }
            list = list3;
            a(bVar, com.fyber.inneractive.sdk.model.vast.h.Static, z, num.intValue(), num2.intValue(), str2, str, list2, list, jVar.f965b, iVarA);
        } else {
            list = list3;
        }
        if (!TextUtils.isEmpty(str3)) {
            a(bVar, com.fyber.inneractive.sdk.model.vast.h.Iframe, z, num.intValue(), num2.intValue(), str2, str, list2, list, str3, null);
        }
        String str4 = gVar.f;
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        a(bVar, com.fyber.inneractive.sdk.model.vast.h.Html, z, num.intValue(), num2.intValue(), str2, str, list2, list, str4, null);
    }

    public com.fyber.inneractive.sdk.model.vast.b a(com.fyber.inneractive.sdk.model.vast.e eVar, List<com.fyber.inneractive.sdk.model.vast.e> list, String str) throws i {
        IAlog.a("%sprocess started", "VastProcessor: ");
        if (eVar != null && eVar.c != null) {
            int iE = l.e();
            int iD = l.d();
            com.fyber.inneractive.sdk.model.vast.b bVar = new com.fyber.inneractive.sdk.model.vast.b(new h(this.c, iE, iD), new f(iE, iD));
            bVar.a = str;
            List<com.fyber.inneractive.sdk.model.vast.k> list2 = eVar.c.c;
            if (list2 != null && !list2.isEmpty()) {
                if (list != null) {
                    Iterator<com.fyber.inneractive.sdk.model.vast.e> it = list.iterator();
                    while (it.hasNext()) {
                        v vVar = it.next().f962b;
                        if (vVar != null) {
                            a(bVar, (com.fyber.inneractive.sdk.model.vast.f) vVar, true);
                        }
                    }
                }
                a(bVar, (com.fyber.inneractive.sdk.model.vast.f) eVar.c, false);
                if (bVar.d.size() == 0) {
                    if (this.f.size() == 0) {
                        throw new i("ErrorNoMediaFiles", "No media files exist after merge");
                    }
                    throw new i("ErrorNoCompatibleMediaFile", "No compatible media files after filtering");
                }
                if (IAlog.a == 2) {
                    IAlog.d("%sLogging merged model media files: ", "VastProcessor: ");
                    Iterator it2 = new ArrayList(bVar.d).iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        IAlog.d("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i), (o) it2.next());
                        i++;
                    }
                }
                if (IAlog.a == 2) {
                    IAlog.d("%sLogging merged model companion ads: ", "VastProcessor: ");
                    ArrayList arrayList = new ArrayList(bVar.g);
                    if (arrayList.size() > 0) {
                        Iterator it3 = arrayList.iterator();
                        int i2 = 0;
                        while (it3.hasNext()) {
                            IAlog.d("%s(%d) %s", "VastProcessor: ", Integer.valueOf(i2), ((com.fyber.inneractive.sdk.model.vast.c) it3.next()).a());
                            i2++;
                        }
                    } else {
                        IAlog.d("%sNo companion ads found!", "VastProcessor: ");
                    }
                }
                return bVar;
            }
            throw new i("ErrorNoMediaFiles", "Empty inline with no creatives");
        }
        IAlog.a("%sno inline found", "VastProcessor: ");
        throw new i("ErrorNoMediaFiles", "Empty inline ad found");
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0133  */
    /* JADX WARN: Code duplicated, block: B:65:0x013d  */
    /* JADX WARN: Code duplicated, block: B:66:0x013f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0142  */
    /* JADX WARN: Code duplicated, block: B:70:0x014b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0165  */
    /* JADX WARN: Code duplicated, block: B:77:0x0169  */
    /* JADX WARN: Code duplicated, block: B:82:0x017d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0185  */
    /* JADX WARN: Code duplicated, block: B:85:0x018d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0195  */
    public final void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.f fVar, boolean z) {
        String[] strArrSplit;
        boolean z2;
        String str;
        g gVar;
        Integer num;
        Map<t, List<String>> map;
        List<String> list;
        IAlog.a("%sprocessing ad element: %s", "VastProcessor: ", fVar);
        List<String> list2 = fVar.f963b;
        if (list2 != null) {
            for (String str2 : list2) {
                IAlog.a("%sadding impression url: %s", "VastProcessor: ", str2);
                a(bVar, t.EVENT_IMPRESSION, str2);
            }
        }
        String str3 = fVar.a;
        if (!TextUtils.isEmpty(str3)) {
            IAlog.a("%sadding error url: %s", "VastProcessor: ", str3);
            bVar.a(t.EVENT_ERROR, str3);
        }
        if (IAConfigManager.M.J != null) {
            for (com.fyber.inneractive.sdk.measurement.f fVar2 : fVar.d) {
                if (fVar2.b()) {
                    bVar.e.add(fVar2);
                } else {
                    t tVar = t.EVENT_VERIFICATION_NOT_EXECUTED;
                    if (((tVar == null || (map = fVar2.c) == null || (list = map.get(tVar)) == null) ? 0 : list.size()) > 0) {
                        com.fyber.inneractive.sdk.player.e.a(new com.fyber.inneractive.sdk.measurement.e(fVar2, fVar2.a(tVar), com.fyber.inneractive.sdk.measurement.g.VERIFICATION_NOT_SUPPORTED), tVar);
                    }
                    this.i.add(fVar2);
                }
            }
        }
        com.fyber.inneractive.sdk.model.vast.l lVar = fVar.e;
        if (lVar != null) {
            bVar.f = lVar;
        }
        for (com.fyber.inneractive.sdk.model.vast.k kVar : fVar.c) {
            n nVar = kVar.a;
            if (nVar != null) {
                List<o> list3 = nVar.a;
                if (list3 != null) {
                    bVar.j = list3.size();
                    for (o oVar : list3) {
                        String str4 = oVar.a;
                        p pVar = p.progressive;
                        g gVar2 = null;
                        if (!str4.equals(pVar.mValue)) {
                            gVar2 = new g(g.a.UNSUPPORTED_DELIVERY, pVar.mValue);
                        } else if ((this.f935b > -1) && (num = oVar.e) != null && num.intValue() != 0) {
                            int iIntValue = oVar.e.intValue();
                            int i = this.a;
                            if (iIntValue < i) {
                                gVar2 = new g(g.a.BITRATE_NOT_IN_RANGE, Integer.valueOf(i));
                            } else {
                                int iIntValue2 = oVar.e.intValue();
                                int i2 = this.f935b;
                                if (iIntValue2 > i2) {
                                    gVar2 = new g(g.a.BITRATE_NOT_IN_RANGE, Integer.valueOf(i2));
                                } else {
                                    if (q.a(oVar.d) != q.UNKNOWN) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        gVar = new g(g.a.UNSUPPORTED_MIME_TYPE, null);
                                    } else if (!this.d) {
                                        str = oVar.f;
                                        if (str == null) {
                                            if (TextUtils.isEmpty(oVar.g)) {
                                                gVar = new g(g.a.NO_CONTENT, null);
                                            } else if (!x.f(oVar.g)) {
                                                gVar = new g(g.a.UNSECURED_VIDEO_URL, null);
                                            }
                                        } else if (TextUtils.isEmpty(oVar.g)) {
                                            gVar = new g(g.a.NO_CONTENT, null);
                                        } else if (!x.f(oVar.g)) {
                                            gVar = new g(g.a.UNSECURED_VIDEO_URL, null);
                                        }
                                    } else {
                                        str = oVar.f;
                                        if (str == null) {
                                            if (TextUtils.isEmpty(oVar.g)) {
                                                gVar = new g(g.a.NO_CONTENT, null);
                                            } else if (!x.f(oVar.g)) {
                                                gVar = new g(g.a.UNSECURED_VIDEO_URL, null);
                                            }
                                        } else if (TextUtils.isEmpty(oVar.g)) {
                                            gVar = new g(g.a.NO_CONTENT, null);
                                        } else if (!x.f(oVar.g)) {
                                            gVar = new g(g.a.UNSECURED_VIDEO_URL, null);
                                        }
                                    }
                                    gVar2 = gVar;
                                }
                            }
                        } else {
                            if (q.a(oVar.d) != q.UNKNOWN) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                gVar = new g(g.a.UNSUPPORTED_MIME_TYPE, null);
                            } else if (!this.d && oVar.f969b.intValue() >= oVar.c.intValue()) {
                                gVar = new g(g.a.VERTICAL_VIDEO_EXPECTED, null);
                            } else {
                                str = oVar.f;
                                if (str == null && this.e && str.equalsIgnoreCase("VPAID")) {
                                    gVar = new g(g.a.FILTERED_BY_APP_OR_UNIT, null);
                                } else if (TextUtils.isEmpty(oVar.g)) {
                                    gVar = new g(g.a.NO_CONTENT, null);
                                } else if (!x.f(oVar.g)) {
                                    gVar = new g(g.a.UNSECURED_VIDEO_URL, null);
                                }
                            }
                            gVar2 = gVar;
                        }
                        if (gVar2 != null) {
                            IAlog.a("%smedia file filtered!: %s", "VastProcessor: ", oVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", oVar);
                            IAlog.a("%s-- %s", "VastProcessor: ", gVar2);
                            this.f.put(oVar, gVar2);
                        } else {
                            IAlog.a("%sadding media file: %s", "VastProcessor: ", oVar);
                            bVar.d.add(oVar);
                            bVar.k.add(oVar);
                            bVar.i++;
                        }
                    }
                }
                List<String> list4 = nVar.d;
                if (list4 != null) {
                    Iterator<String> it = list4.iterator();
                    while (it.hasNext()) {
                        a(bVar, t.EVENT_CLICK, it.next());
                    }
                }
                List<s> list5 = nVar.f968b;
                if (list5 != null) {
                    for (s sVar : list5) {
                        t tVarA = t.a(sVar.a);
                        if (tVarA != t.UNKNOWN) {
                            bVar.a(tVarA, sVar.f971b);
                        }
                        if (tVarA == t.EVENT_PROGRESS) {
                            String str5 = sVar.f971b;
                            String str6 = sVar.c;
                            com.fyber.inneractive.sdk.model.vast.d dVar = new com.fyber.inneractive.sdk.model.vast.d(str5, str6);
                            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6) && dVar.d != 0) {
                                bVar.m.add(dVar);
                            }
                        }
                    }
                }
                String str7 = nVar.c;
                if (str7 != null) {
                    bVar.f959b = str7;
                }
                String str8 = nVar.e;
                if (!TextUtils.isEmpty(str8) && (strArrSplit = str8.split(CertificateUtil.DELIMITER)) != null && strArrSplit.length <= 3) {
                    if (strArrSplit.length == 1) {
                        try {
                            Integer.parseInt(str8);
                        } catch (NumberFormatException unused) {
                        }
                    } else if (strArrSplit.length == 2) {
                        Integer.parseInt(strArrSplit[1]);
                        Integer.parseInt(strArrSplit[0]);
                    } else {
                        Integer.parseInt(strArrSplit[2]);
                        Integer.parseInt(strArrSplit[1]);
                        Integer.parseInt(strArrSplit[0]);
                    }
                }
            }
            List<com.fyber.inneractive.sdk.model.vast.g> list6 = kVar.f966b;
            if (list6 != null) {
                for (com.fyber.inneractive.sdk.model.vast.g gVar3 : list6) {
                    try {
                        a(bVar, gVar3, z);
                    } catch (a e) {
                        IAlog.a("Failed processing companion ad: %s error = %s", gVar3, e.getMessage());
                        gVar3.i = e;
                        this.g.add(gVar3);
                    }
                }
            }
        }
    }

    public final void a(com.fyber.inneractive.sdk.response.i iVar, t tVar, String str) throws i {
        if (x.f(str)) {
            ((com.fyber.inneractive.sdk.model.vast.b) iVar).a(tVar, str);
            return;
        }
        throw new i("VastErrorUnsecure", "found unsecure tracking event: " + tVar.e());
    }

    public void a(com.fyber.inneractive.sdk.model.vast.b bVar, com.fyber.inneractive.sdk.model.vast.h hVar, boolean z, int i, int i2, String str, String str2, List<String> list, List<s> list2, String str3, com.fyber.inneractive.sdk.model.vast.i iVar) {
        com.fyber.inneractive.sdk.model.vast.c cVar = new com.fyber.inneractive.sdk.model.vast.c(hVar, i, i2, str);
        cVar.g = str2;
        if (list2 != null) {
            for (s sVar : list2) {
                cVar.a(t.a(sVar.a), sVar.f971b);
            }
        }
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                cVar.a(t.EVENT_CLICK, it.next());
            }
        }
        a(cVar, z);
        cVar.f = str3;
        cVar.f960b = iVar;
        bVar.g.add(cVar);
        bVar.l.add(cVar);
    }

    public boolean a(com.fyber.inneractive.sdk.model.vast.c cVar, boolean z) {
        boolean z2 = false;
        if (!this.h.isEmpty()) {
            com.fyber.inneractive.sdk.model.vast.g gVarRemove = null;
            if (z) {
                List<com.fyber.inneractive.sdk.model.vast.g> list = this.h;
                gVarRemove = list.remove(list.size() - 1);
            }
            String str = cVar.e;
            for (com.fyber.inneractive.sdk.model.vast.g gVar : this.h) {
                String str2 = gVar.c;
                if ((str != null && str.equals(str2)) || (str2 == null && cVar.c == gVar.a.intValue() && cVar.d == gVar.f964b.intValue())) {
                    List<String> list2 = gVar.h;
                    if (list2 != null) {
                        for (String str3 : list2) {
                            if (x.f(str3)) {
                                cVar.a(t.EVENT_CLICK, str3);
                            }
                        }
                    }
                    z2 = true;
                }
            }
            if (gVarRemove != null) {
                this.h.add(gVarRemove);
            }
        }
        return z2;
    }
}
