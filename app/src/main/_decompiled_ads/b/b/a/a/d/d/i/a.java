package b.b.a.a.d.d.i;

import android.text.TextUtils;
import b.b.a.a.d.f.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ComputeRuler.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public Map<String, c> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, c> f93b = new HashMap();
    public Map<String, c> c = new HashMap();
    private double d;
    private int e;
    private double f;
    private String g;
    private m h;

    /* JADX INFO: renamed from: b.b.a.a.d.d.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComputeRuler.java */
    static class C0024a implements Cloneable {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f94b;
        float c;

        C0024a() {
        }

        public Object clone() {
            try {
                return (C0024a) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: ComputeRuler.java */
    static class b {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f95b;
        int c;
        double d;
        float e;

        b() {
        }

        static JSONObject a(b bVar) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", bVar.a);
                jSONObject.put("letterSpacing", bVar.f95b);
                jSONObject.put("lineHeight", bVar.d);
                jSONObject.put("maxWidth", bVar.e);
                jSONObject.put("fontWeight", bVar.c);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* JADX INFO: compiled from: ComputeRuler.java */
    static class c {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f96b;

        public c() {
        }

        public String toString() {
            return "UnitSize{width=" + this.a + ", height=" + this.f96b + '}';
        }

        public c(float f, float f2) {
            this.a = f;
            this.f96b = f2;
        }
    }

    public a(double d, int i, double d2, String str, m mVar) {
        Math.random();
        this.d = d;
        this.e = i;
        this.f = d2;
        this.g = str;
        this.h = mVar;
    }

    private c a(String str, b bVar, boolean z, boolean z2, int i, b.b.a.a.d.d.h.h hVar) {
        return j.a(str, hVar.n().f(), b.a(bVar).toString(), z, z2, i, hVar, this.d, this.e, this.f, this.g, this.h);
    }

    private c e(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        String str = hVar.g() + "_" + f + "_" + f2;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        c cVarF = f(hVar, f, f2);
        this.c.put(str, cVarF);
        return cVarF;
    }

    private c f(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        b.b.a.a.d.d.h.f fVarG = hVar.n().g();
        hVar.n().a();
        fVarG.u0();
        float fA = fVarG.A();
        int iT = fVarG.T();
        double dV = fVarG.V();
        int iB = fVarG.B();
        boolean zV0 = fVarG.v0();
        boolean zW0 = fVarG.w0();
        int iU = fVarG.U();
        b bVar = new b();
        bVar.a = fA;
        bVar.f95b = iT;
        bVar.c = iB;
        bVar.d = dV;
        bVar.e = f;
        return a(hVar.n().a(), bVar, zV0, zW0, iU, hVar);
    }

    public c b(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        float fMin;
        c cVar = new c();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            cVar.a = 0.0f;
            cVar.f96b = 0.0f;
            return cVar;
        }
        if (hVar.u()) {
            return d(hVar, f, f2);
        }
        float fQ = hVar.q();
        float f4 = hVar.f();
        float fI = hVar.i();
        float fH = hVar.h();
        b.b.a.a.d.d.h.f fVarG = hVar.n().g();
        String strQ0 = fVarG.q0();
        String strC = fVarG.C();
        float fMin2 = ((TextUtils.equals(strQ0, "flex") || TextUtils.equals(strQ0, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) ? f : Math.min(fQ, f)) - fI;
        if (TextUtils.equals(strC, "scale")) {
            fMin = Math.round(fMin2 / f4) + fH;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fH) * f4);
            }
        } else {
            fMin = (TextUtils.equals(strC, DebugKt.DEBUG_PROPERTY_VALUE_AUTO) || TextUtils.equals(strC, "flex")) ? f2 : Math.min(f4, f2);
        }
        float f5 = fMin - fH;
        List<List<b.b.a.a.d.d.h.h>> listD = hVar.d();
        Iterator<List<b.b.a.a.d.d.h.h>> it = listD.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<b.b.a.a.d.d.h.h>> it2 = it;
            List<b.b.a.a.d.d.h.h> next = it.next();
            c cVar2 = cVar;
            c cVarA = a(next, fMin2, f5);
            if (c(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, cVarA.a);
            }
            float f6 = f3;
            fMax2 = hVar.n().f().equals("carousel") ? Math.max(hVar.f(), cVarA.f96b) : fMax2 + cVarA.f96b;
            cVar = cVar2;
            it = it2;
            f3 = f6;
        }
        c cVar3 = cVar;
        if (TextUtils.equals(strQ0, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            if (f3 == listD.size()) {
                fMin2 = f;
            } else {
                for (List<b.b.a.a.d.d.h.h> list : listD) {
                    d(list);
                    a(list, fMax, f5);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strC, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            if (fMax2 <= f2) {
                f5 = fMax2;
            } else {
                c(listD, fMin2, f5);
            }
        } else if ((TextUtils.equals(strC, "fixed") || TextUtils.equals(strC, "flex")) && f5 < fMax2) {
            c(listD, fMin2, f5);
        }
        cVar3.a = Math.min(fMin2 + fI, f);
        cVar3.f96b = Math.min(f5 + fH, f2);
        return cVar3;
    }

    public c c(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        c cVar = new c();
        if (hVar.n().g() == null) {
            return cVar;
        }
        c cVarE = e(hVar, f, f2);
        float f3 = cVarE.a;
        float f4 = cVarE.f96b;
        cVar.a = Math.min(f3, f);
        cVar.f96b = Math.min(f4, f2);
        return cVar;
    }

    public c d(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(hVar.n().a()) && hVar.n().g().w() == null) {
            return new c(0.0f, 0.0f);
        }
        if (TextUtils.equals(hVar.n().f(), "creative-playable-bait")) {
            return new c(0.0f, 0.0f);
        }
        float fQ = hVar.q();
        float f4 = hVar.f();
        b.b.a.a.d.d.h.f fVarG = hVar.n().g();
        String strQ0 = fVarG.q0();
        String strC = fVarG.C();
        float fJ = hVar.j();
        float fK = hVar.k();
        float fI = hVar.i();
        float fH = hVar.h();
        if (TextUtils.equals(strQ0, "fixed")) {
            f = Math.min(fQ, f);
            if (TextUtils.equals(strC, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                f3 = c(hVar, f - fI, f2 - fH).f96b;
                f4 = f3 + fH;
            }
        } else if (TextUtils.equals(strQ0, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            c cVarC = c(hVar, f - fI, f2 - fH);
            f = cVarC.a + fI;
            if (TextUtils.equals(strC, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                f3 = cVarC.f96b;
                f4 = f3 + fH;
            }
        } else if (!TextUtils.equals(strQ0, "flex")) {
            f = fQ;
        } else if (TextUtils.equals(strC, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            f3 = c(hVar, f - fI, f2 - fH).f96b;
            f4 = f3 + fH;
        }
        if (TextUtils.equals(strC, "scale")) {
            float fRound = Math.round((f - fJ) / f4) + fK;
            if (fRound > f2) {
                f = Math.round((f2 - fK) * f4) + fJ;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strC, "fixed")) {
            f2 = Math.min(f4 + fK, f2);
        } else if (!TextUtils.equals(strC, "flex")) {
            f2 = f4;
        }
        c cVar = new c();
        cVar.a = f;
        cVar.f96b = f2;
        return cVar;
    }

    public c a(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        if (hVar == null) {
            return null;
        }
        c cVarD = d(hVar);
        if (cVarD != null && (cVarD.a != 0.0f || cVarD.f96b != 0.0f)) {
            return cVarD;
        }
        c cVarB = b(hVar, f, f2);
        a(hVar, cVarB);
        return cVarB;
    }

    private c a(List<b.b.a.a.d.d.h.h> list, float f, float f2) {
        c cVarB = b(list);
        if (cVarB != null && (cVarB.a != 0.0f || cVarB.f96b != 0.0f)) {
            return cVarB;
        }
        c cVarB2 = b(list, f, f2);
        a(list, cVarB2);
        return cVarB2;
    }

    private boolean a(b.b.a.a.d.d.h.h hVar) {
        if (hVar == null) {
            return false;
        }
        if (TextUtils.equals(hVar.n().g().C(), "flex")) {
            return true;
        }
        return b(hVar);
    }

    private void e(b.b.a.a.d.d.h.h hVar) {
        this.a.remove(c(hVar));
        List<List<b.b.a.a.d.d.h.h>> listD = hVar.d();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        Iterator<List<b.b.a.a.d.d.h.h>> it = listD.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    private boolean a(List<b.b.a.a.d.d.h.h> list, boolean z) {
        boolean z2;
        Iterator<b.b.a.a.d.d.h.h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            b.b.a.a.d.d.h.h next = it.next();
            b.b.a.a.d.d.h.f fVarG = next.n().g();
            String strC = fVarG.C();
            if (TextUtils.equals(strC, "flex") || (z && ((TextUtils.equals(fVarG.q0(), "flex") && TextUtils.equals(fVarG.C(), "scale") && b.b.a.a.d.d.h.e.f.get(next.n().f()).intValue() == 7) || TextUtils.equals(strC, "flex")))) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        Iterator<b.b.a.a.d.d.h.h> it2 = list.iterator();
        while (it2.hasNext()) {
            if (b(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private void c(List<List<b.b.a.a.d.d.h.h>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<b.b.a.a.d.d.h.h>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (a(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<b.b.a.a.d.d.h.h> list2 : list) {
            C0024a c0024a = new C0024a();
            boolean zA = a(list2, !z);
            c0024a.a = zA ? 1.0f : a(list2, f, f2).f96b;
            c0024a.f94b = !zA;
            arrayList.add(c0024a);
        }
        List<C0024a> listA = i.a(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((C0024a) arrayList.get(i)).a != listA.get(i).a) {
                List<b.b.a.a.d.d.h.h> list3 = list.get(i);
                d(list3);
                a(list3, f, listA.get(i).a);
            }
        }
    }

    private void a(List<C0024a> list, float f, List<b.b.a.a.d.d.h.h> list2) {
        float f2 = 0.0f;
        for (C0024a c0024a : list) {
            if (c0024a.f94b) {
                f2 += c0024a.a;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).f94b && list2.get(i2).v()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    C0024a c0024a2 = list.get(i3);
                    if (c0024a2.f94b && list2.get(i3).v()) {
                        c0024a2.a -= fCeil;
                    }
                }
            }
        }
    }

    private boolean c(List<b.b.a.a.d.d.h.h> list) {
        boolean z;
        List<List<b.b.a.a.d.d.h.h>> listD;
        Iterator<b.b.a.a.d.d.h.h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().n().g().q0(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (b.b.a.a.d.d.h.h hVar : list) {
                if (TextUtils.equals(hVar.n().g().q0(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && (listD = hVar.d()) != null) {
                    Iterator<List<b.b.a.a.d.d.h.h>> it2 = listD.iterator();
                    int i = 0;
                    while (true) {
                        if (it2.hasNext()) {
                            List<b.b.a.a.d.d.h.h> next = it2.next();
                            i++;
                            if (c(next)) {
                                if (i == next.size()) {
                                    z2 = true;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return z2;
        }
    }

    public c d(b.b.a.a.d.d.h.h hVar) {
        return this.a.get(c(hVar));
    }

    private void d(List<b.b.a.a.d.d.h.h> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f93b.remove(a(list));
        Iterator<b.b.a.a.d.d.h.h> it = list.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }

    public void a() {
        this.c.clear();
        this.a.clear();
        this.f93b.clear();
    }

    private String a(List<b.b.a.a.d.d.h.h> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strG = list.get(i).g();
            if (i < list.size() - 1) {
                sb.append(strG).append("-");
            } else {
                sb.append(strG);
            }
        }
        return sb.toString();
    }

    private String c(b.b.a.a.d.d.h.h hVar) {
        return hVar.g();
    }

    private void a(b.b.a.a.d.d.h.h hVar, c cVar) {
        this.a.put(c(hVar), cVar);
    }

    private void a(List<b.b.a.a.d.d.h.h> list, c cVar) {
        this.f93b.put(a(list), cVar);
    }

    private c b(List<b.b.a.a.d.d.h.h> list, float f, float f2) {
        float fMax;
        a(list);
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (b.b.a.a.d.d.h.h hVar : list) {
            b.b.a.a.d.d.h.f fVarG = hVar.n().g();
            if (fVarG.e0() == 1 || fVarG.e0() == 2) {
                arrayList.add(hVar);
            }
            if (fVarG.e0() != 1 && fVarG.e0() != 2) {
                arrayList2.add(hVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((b.b.a.a.d.d.h.h) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return cVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<b.b.a.a.d.d.h.h> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(a(it2.next(), f, f2).a));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            fMax = 0.0f;
            if (i >= arrayList2.size()) {
                break;
            }
            b.b.a.a.d.d.h.h hVar2 = arrayList2.get(i);
            String strQ0 = hVar2.n().g().q0();
            float fQ = hVar2.q();
            boolean zEquals = TextUtils.equals(strQ0, "flex");
            if (TextUtils.equals(strQ0, DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
                List<List<b.b.a.a.d.d.h.h>> listD = hVar2.d();
                if (listD == null || listD.size() <= 0) {
                    zEquals = false;
                    break;
                }
                Iterator<List<b.b.a.a.d.d.h.h>> it3 = listD.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        zEquals = false;
                        break;
                    }
                    if (c(it3.next())) {
                        zEquals = true;
                        break;
                    }
                }
            }
            C0024a c0024a = new C0024a();
            if (!zEquals) {
                fQ = ((Float) arrayList3.get(i)).floatValue();
            }
            c0024a.a = fQ;
            c0024a.f94b = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            c0024a.c = fMax;
            arrayList4.add(c0024a);
            i++;
        }
        a(arrayList4, f, arrayList2);
        List<C0024a> listA = i.a(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listA.get(i2).a;
            if (((Float) arrayList3.get(i2)).floatValue() != listA.get(i2).a) {
                e(arrayList2.get(i2));
            }
        }
        Iterator<b.b.a.a.d.d.h.h> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (it4.hasNext()) {
            i3++;
            if (!a(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            b.b.a.a.d.d.h.h hVar3 = arrayList2.get(i4);
            c cVarA = a(hVar3, listA.get(i4).a, f2);
            if (!a(hVar3)) {
                fMax = Math.max(fMax, cVarA.f96b);
            }
            arrayList5.add(cVarA);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((c) it5.next()).f96b));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                b.b.a.a.d.d.h.h hVar4 = arrayList2.get(i5);
                if (a(hVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    e(hVar4);
                    a(hVar4, listA.get(i5).a, fMax);
                }
            }
        }
        cVar.a = f3;
        cVar.f96b = fMax;
        return cVar;
    }

    private boolean b(b.b.a.a.d.d.h.h hVar) {
        List<List<b.b.a.a.d.d.h.h>> listD;
        if (!hVar.u() && TextUtils.equals(hVar.n().g().C(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && (listD = hVar.d()) != null && listD.size() > 0) {
            if (listD.size() == 1) {
                Iterator<b.b.a.a.d.d.h.h> it = listD.get(0).iterator();
                while (it.hasNext()) {
                    if (!a(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<b.b.a.a.d.d.h.h>> it2 = listD.iterator();
            while (it2.hasNext()) {
                if (a(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public c b(List<b.b.a.a.d.d.h.h> list) {
        return this.f93b.get(a(list));
    }
}
