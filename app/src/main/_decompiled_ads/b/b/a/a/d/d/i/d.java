package b.b.a.a.d.d.i;

import android.text.TextUtils;
import b.b.a.a.d.f.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DynamicCanvas.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private b.b.a.a.d.d.h.h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.b.a.a.d.d.h.b f97b;
    protected b.b.a.a.d.d.i.a c;
    private a d;

    /* JADX INFO: compiled from: DynamicCanvas.java */
    static class a {
        float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f98b;

        a() {
        }
    }

    public d(double d, int i, double d2, String str, m mVar) {
        this.c = new b.b.a.a.d.d.i.a(d, i, d2, str, mVar);
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.c.a();
    }

    public void a(b.b.a.a.d.d.h.h hVar, float f, float f2) {
        if (hVar != null) {
            this.a = hVar;
        }
        b.b.a.a.d.d.h.h hVar2 = this.a;
        float fQ = hVar2.q();
        float f3 = hVar2.f();
        float f4 = TextUtils.equals(hVar2.n().g().C(), "fixed") ? f3 : 65536.0f;
        this.c.a();
        this.c.a(hVar2, fQ, f4);
        b.b.a.a.d.d.i.a.c cVarD = this.c.d(hVar2);
        b.b.a.a.d.d.h.b bVar = new b.b.a.a.d.d.h.b();
        bVar.a = f;
        bVar.f84b = f2;
        if (cVarD != null) {
            fQ = cVarD.a;
        }
        bVar.c = fQ;
        if (cVarD != null) {
            f3 = cVarD.f96b;
        }
        bVar.d = f3;
        bVar.e = "root";
        bVar.f = hVar2;
        hVar2.f(f);
        bVar.f.g(bVar.f84b);
        bVar.f.e(bVar.c);
        bVar.f.a(bVar.d);
        b.b.a.a.d.d.h.b bVarA = a(bVar, 0.0f);
        this.f97b = bVarA;
        a(bVarA);
    }

    public void a(b.b.a.a.d.d.h.b bVar) {
        if (bVar == null) {
            return;
        }
        com.bytedance.sdk.component.utils.m.a("DynamicCanvas", "native parser: type = " + bVar.f.n().f() + "; width = " + bVar.c + "; height = " + bVar.d + "; x = " + bVar.a + "; y = " + bVar.f84b);
        List<List<b.b.a.a.d.d.h.b>> list = bVar.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<b.b.a.a.d.d.h.b> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<b.b.a.a.d.d.h.b> it = list2.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0315  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ee  */
    public b.b.a.a.d.d.h.b a(b.b.a.a.d.d.h.b bVar, float f) {
        float fA;
        float fA2;
        int i;
        float f2;
        float fA3;
        float fA4;
        b.b.a.a.d.d.h.b bVar2;
        b.b.a.a.d.d.h.i iVarA;
        float f3;
        b.b.a.a.d.d.h.i iVar;
        b.b.a.a.d.d.i.a.c cVarD;
        b.b.a.a.d.d.i.a.c cVarD2;
        b.b.a.a.d.d.h.b bVar3 = bVar;
        b.b.a.a.d.d.h.h hVar = bVar3.f;
        if (hVar == null) {
            return bVar3;
        }
        hVar.a();
        List<List<b.b.a.a.d.d.h.h>> listD = hVar.d();
        if (listD == null || listD.size() <= 0) {
            return bVar3;
        }
        b.b.a.a.d.d.h.f fVarG = hVar.n().g();
        float fD0 = fVarG.d0();
        float fC0 = fVarG.c0();
        float fA0 = fVarG.a0();
        float fB0 = fVarG.b0();
        float fP = fVarG.p();
        String strQ = fVarG.Q();
        String strR = fVarG.R();
        float f4 = bVar3.a + fB0;
        float f5 = bVar3.f84b + fD0;
        float f6 = fP * 2.0f;
        float f7 = ((bVar3.c - fB0) - fC0) - f6;
        float f8 = ((bVar3.d - fD0) - fA0) - f6;
        b.b.a.a.d.d.h.i iVar2 = new b.b.a.a.d.d.h.i(f4, f5);
        if (bVar3.g == null) {
            bVar3.g = new ArrayList();
        }
        Iterator<List<b.b.a.a.d.d.h.h>> it = listD.iterator();
        float f9 = 0.0f;
        while (it.hasNext()) {
            b.b.a.a.d.d.i.a.c cVarB = this.c.b(it.next());
            if (cVarB != null) {
                f9 += cVarB.f96b;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f9 >= f8) {
            fA = 0.0f;
            fA2 = 0.0f;
        } else {
            if (TextUtils.equals(strR, "center")) {
                fA2 = (f8 - f9) / 2.0f;
            } else if (TextUtils.equals(strR, "flex-end")) {
                fA2 = f8 - f9;
            } else if (TextUtils.equals(strR, "space-around")) {
                fA2 = i.a((f8 - f9) / (listD.size() + 1));
                fA = fA2;
            } else {
                if (!TextUtils.equals(strR, "space-between") || listD.size() <= 1) {
                    fA = 0.0f;
                } else {
                    fA = i.a((f8 - f9) / (listD.size() - 1));
                }
                fA2 = 0.0f;
            }
            fA = 0.0f;
        }
        iVar2.f92b += fA2;
        float f10 = f;
        for (int i2 = 0; i2 < listD.size(); i2 = i) {
            List<b.b.a.a.d.d.h.h> list = listD.get(i2);
            i = i2 + 1;
            if (i >= bVar3.g.size()) {
                int size = (i - bVar3.g.size()) + 1;
                int i3 = 0;
                while (i3 < size) {
                    bVar3.g.add(new ArrayList());
                    i3++;
                    size = size;
                    f10 = f10;
                }
            }
            float f11 = f10;
            Iterator<b.b.a.a.d.d.h.h> it2 = list.iterator();
            float f12 = 0.0f;
            while (true) {
                f2 = fA;
                if (!it2.hasNext()) {
                    break;
                }
                b.b.a.a.d.d.h.h next = it2.next();
                b.b.a.a.d.d.h.f fVarG2 = next.n().g();
                String strQ0 = fVarG2.q0();
                Iterator<b.b.a.a.d.d.h.h> it3 = it2;
                int iE0 = fVarG2.e0();
                if (!TextUtils.equals(strQ0, "flex") && iE0 != 1 && iE0 != 2 && (cVarD2 = this.c.d(next)) != null) {
                    f12 += cVarD2.a;
                }
                fA = f2;
                it2 = it3;
            }
            Math.max(f7 - f12, 0.0f);
            Iterator<b.b.a.a.d.d.h.h> it4 = list.iterator();
            float f13 = 0.0f;
            while (it4.hasNext()) {
                b.b.a.a.d.d.h.h next2 = it4.next();
                b.b.a.a.d.d.h.f fVarG3 = next2.n().g();
                Iterator<b.b.a.a.d.d.h.h> it5 = it4;
                if (fVarG3.e0() != 1 && fVarG3.e0() != 2 && (cVarD = this.c.d(next2)) != null) {
                    f13 += cVarD.a;
                }
                it4 = it5;
            }
            if (f13 >= f7) {
                fA3 = 0.0f;
                fA4 = 0.0f;
            } else {
                if (TextUtils.equals(strQ, "center")) {
                    fA3 = (f7 - f13) / 2.0f;
                } else if (TextUtils.equals(strQ, "flex-end")) {
                    fA3 = f7 - f13;
                } else if (TextUtils.equals(strQ, str2)) {
                    fA3 = i.a((f7 - f13) / (list.size() + 1));
                    fA4 = fA3;
                } else if (!TextUtils.equals(strQ, str) || list.size() <= 1) {
                    fA3 = 0.0f;
                } else {
                    fA4 = i.a((f7 - f13) / (list.size() - 1.0f));
                    fA3 = 0.0f;
                }
                fA4 = 0.0f;
            }
            iVar2.a += fA3;
            Iterator<b.b.a.a.d.d.h.h> it6 = list.iterator();
            float fMax = 0.0f;
            while (it6.hasNext()) {
                b.b.a.a.d.d.h.h next3 = it6.next();
                float f14 = this.c.d(next3) != null ? this.c.d(next3).f96b : 0.0f;
                b.b.a.a.d.d.h.f fVarG4 = next3.n().g();
                Iterator<b.b.a.a.d.d.h.h> it7 = it6;
                String str3 = str;
                if (fVarG4.e0() == 1 || fVarG4.e0() == 2) {
                    f14 = 0.0f;
                }
                fMax = Math.max(fMax, f14);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<b.b.a.a.d.d.h.h> it8 = list.iterator();
            f10 = f11;
            while (it8.hasNext()) {
                b.b.a.a.d.d.h.h next4 = it8.next();
                b.b.a.a.d.d.i.a.c cVarD3 = this.c.d(next4);
                b.b.a.a.d.d.h.f fVarG5 = next4.n().g();
                Iterator<b.b.a.a.d.d.h.h> it9 = it8;
                float fZ = fVarG5.Z();
                String str5 = strQ;
                float fY = fVarG5.Y();
                float f15 = f10;
                float fW = fVarG5.W();
                float f16 = f7;
                float fX = fVarG5.X();
                float f17 = cVarD3 == null ? 0.0f : cVarD3.a;
                float f18 = cVarD3 == null ? 0.0f : cVarD3.f96b;
                b.b.a.a.d.d.h.h hVar2 = hVar;
                float f19 = TextUtils.equals(hVar.g(), "root") ? i : f15;
                b.b.a.a.d.d.h.i iVar3 = iVar2;
                if (fVarG5.e0() == 1) {
                    bVar2 = bVar;
                    iVarA = a(bVar2, fVarG5, (f17 - fY) - fX, (f18 - fZ) - fW);
                } else {
                    bVar2 = bVar;
                    iVarA = iVar3;
                }
                b.b.a.a.d.d.h.i iVarA2 = fVarG5.e0() == 2 ? a(fVarG5, this.c.d(this.a), new b.b.a.a.d.d.i.a.c((f17 - fY) - fX, (f18 - fZ) - fW)) : iVarA;
                String strB = fVarG.b();
                if (fMax <= f18 || TextUtils.equals(strB, "flex-start")) {
                    f3 = 0.0f;
                } else {
                    strB.hashCode();
                    if (strB.equals("center")) {
                        f3 = (fMax - f18) / 2.0f;
                    } else if (strB.equals("flex-end")) {
                        f3 = fMax - f18;
                    } else {
                        f3 = 0.0f;
                    }
                }
                b.b.a.a.d.d.h.b bVar4 = new b.b.a.a.d.d.h.b();
                bVar4.a = iVarA2.a + fX;
                bVar4.f84b = iVarA2.f92b + fZ + f3;
                bVar4.c = (f17 - fY) - fX;
                bVar4.d = (f18 - fZ) - fW;
                bVar4.e = bVar2.e + "." + next4.g();
                bVar4.f = next4;
                next4.f(bVar4.a);
                bVar4.f.g(bVar4.f84b);
                bVar4.f.e(bVar4.c);
                bVar4.f.a(bVar4.d);
                float f20 = f19;
                int i4 = i;
                bVar2.g.get(i4).add(a(bVar4, f20));
                if (fVarG5.e0() == 1) {
                    iVar = iVar3;
                } else if (fVarG5.e0() != 2) {
                    iVar = iVar3;
                    iVar.a += f17 + fA4;
                } else {
                    iVar = iVar3;
                }
                f10 = f20;
                i = i4;
                strQ = str5;
                f7 = f16;
                str2 = str2;
                fA4 = fA4;
                hVar = hVar2;
                iVar2 = iVar;
                it8 = it9;
            }
            b.b.a.a.d.d.h.i iVar4 = iVar2;
            iVar4.a = f4;
            iVar4.f92b += fMax + f2;
            listD = listD;
            fA = f2;
            str = str4;
            hVar = hVar;
            iVar2 = iVar4;
            bVar3 = bVar;
        }
        return bVar3;
    }

    private b.b.a.a.d.d.h.i a(b.b.a.a.d.d.h.f fVar, b.b.a.a.d.d.i.a.c cVar, b.b.a.a.d.d.i.a.c cVar2) {
        float fS = fVar.S();
        float fP0 = fVar.p0();
        float fF0 = fVar.f0();
        float fS2 = fVar.s();
        boolean zA0 = fVar.A0();
        boolean zB0 = fVar.B0();
        boolean zC0 = fVar.C0();
        boolean zZ0 = fVar.z0();
        if (!zA0) {
            if (zB0) {
                float f = this.d.a;
                if (f == 0.0f) {
                    f = cVar.a;
                }
                fS = (f - fF0) - cVar2.a;
            } else {
                fS = 0.0f;
            }
        }
        if (!zC0) {
            if (zZ0) {
                float f2 = this.d.f98b;
                if (f2 == 0.0f) {
                    f2 = cVar.f96b;
                }
                fP0 = (f2 - fS2) - cVar2.f96b;
            } else {
                fP0 = 0.0f;
            }
        }
        return new b.b.a.a.d.d.h.i(fS, fP0);
    }

    private b.b.a.a.d.d.h.i a(b.b.a.a.d.d.h.b bVar, b.b.a.a.d.d.h.f fVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = bVar.a;
        float f6 = bVar.f84b;
        float fS = fVar.S();
        float fP0 = fVar.p0();
        float fF0 = fVar.f0();
        float fS2 = fVar.s();
        boolean zA0 = fVar.A0();
        boolean zB0 = fVar.B0();
        boolean zC0 = fVar.C0();
        boolean zZ0 = fVar.z0();
        String strA = fVar.a();
        float f7 = bVar.c;
        float f8 = bVar.d;
        if (TextUtils.equals(strA, "0")) {
            if (zA0) {
                f5 = bVar.a + fS;
            } else if (zB0) {
                f5 = ((bVar.a + f7) - fF0) - f;
            }
            if (zC0) {
                f4 = bVar.f84b;
                f6 = f4 + fP0;
            } else if (zZ0) {
                f3 = bVar.f84b;
                f6 = ((f3 + f8) - fS2) - f2;
            }
        } else if (TextUtils.equals(strA, "1")) {
            f5 = bVar.a + ((f7 - f) / 2.0f);
            if (zC0) {
                f4 = bVar.f84b;
                f6 = f4 + fP0;
            } else if (zZ0) {
                f3 = bVar.f84b;
                f6 = ((f3 + f8) - fS2) - f2;
            }
        } else if (TextUtils.equals(strA, "2")) {
            f6 = bVar.f84b + ((f8 - f2) / 2.0f);
            if (zA0) {
                f5 = bVar.a + fS;
            } else if (zB0) {
                f5 = ((bVar.a + f7) - fF0) - f;
            }
        } else if (TextUtils.equals(strA, "3")) {
            f5 = bVar.a + ((f7 - f) / 2.0f);
            f6 = bVar.f84b + ((f8 - f2) / 2.0f);
        }
        return new b.b.a.a.d.d.h.i(f5, f6);
    }
}
