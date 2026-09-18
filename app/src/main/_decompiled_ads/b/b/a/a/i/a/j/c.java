package b.b.a.a.i.a.j;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.a.i.a.i;
import b.b.a.a.i.a.j.g.h.g;
import com.android.vending.expansion.zipfile.APEZProvider;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DBCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements d {
    private b.b.a.a.i.a.j.g.h.d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.i.a.j.g.h.a f204b;
    private b.b.a.a.i.a.j.g.h.b c;
    private g d;
    private b.b.a.a.i.a.j.g.h.f e;
    private b.b.a.a.i.a.j.g.h.e f;
    private b.b.a.a.i.a.m.d.a g;
    private b.b.a.a.i.a.m.d.a h;
    private b.b.a.a.i.a.m.d.a i;
    private b.b.a.a.i.a.m.d.a j;
    private b.b.a.a.i.a.m.d.a k;
    private b.b.a.a.i.a.m.d.a l;

    public c() {
        Context contextC = i.f().c();
        if (b.b.a.a.i.a.k.a.d()) {
            b.b.a.a.i.a.m.d.a aVarE = i.f().e();
            this.g = aVarE;
            this.a = new b.b.a.a.i.a.j.g.h.d(contextC, aVarE);
        }
        if (b.b.a.a.i.a.k.a.b()) {
            b.b.a.a.i.a.m.d.a aVarH = i.f().h();
            this.i = aVarH;
            this.c = new b.b.a.a.i.a.j.g.h.b(contextC, aVarH);
        }
        if (b.b.a.a.i.a.k.a.a()) {
            b.b.a.a.i.a.m.d.a aVarH2 = i.f().h();
            this.h = aVarH2;
            this.f204b = new b.b.a.a.i.a.j.g.h.a(contextC, aVarH2);
        }
        if (b.b.a.a.i.a.k.a.f()) {
            b.b.a.a.i.a.m.d.a aVarH3 = i.f().h();
            this.j = aVarH3;
            this.d = new g(contextC, aVarH3);
        }
        if (b.b.a.a.i.a.k.a.c()) {
            b.b.a.a.i.a.m.d.a aVarB = i.f().b();
            this.k = aVarB;
            this.e = new b.b.a.a.i.a.j.g.h.f(contextC, aVarB);
        }
        if (b.b.a.a.i.a.k.a.e()) {
            b.b.a.a.i.a.m.d.a aVarI = i.f().i();
            this.l = aVarI;
            this.f = new b.b.a.a.i.a.j.g.h.e(contextC, aVarI);
        }
    }

    @Override // b.b.a.a.i.a.j.d
    public void a(b.b.a.a.i.a.m.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        try {
            aVar.b(System.currentTimeMillis());
            if (aVar.f() == 0 && aVar.c() == 1) {
                if (b.b.a.a.i.a.k.a.d()) {
                    this.a.a(aVar);
                }
            } else if (aVar.f() == 3 && aVar.c() == 2) {
                if (b.b.a.a.i.a.k.a.b()) {
                    this.c.a(aVar);
                }
            } else if (aVar.f() == 0 && aVar.c() == 2) {
                if (b.b.a.a.i.a.k.a.a()) {
                    this.f204b.a(aVar);
                }
            } else if (aVar.f() == 1 && aVar.c() == 2) {
                if (b.b.a.a.i.a.k.a.f()) {
                    this.d.a(aVar);
                }
            } else if (aVar.f() == 1 && aVar.c() == 3) {
                if (b.b.a.a.i.a.k.a.c()) {
                    this.e.a(aVar);
                }
            } else if (aVar.f() == 2 && aVar.c() == 3 && b.b.a.a.i.a.k.a.e()) {
                this.f.a(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.J(), 1);
        }
    }

    public List<b.b.a.a.i.a.m.a> b(b.b.a.a.i.a.m.a aVar, int i) {
        if (aVar.f() == 0 && aVar.c() == 1 && b.b.a.a.i.a.k.a.d()) {
            if (this.g.d() <= i) {
                return null;
            }
            List<b.b.a.a.i.a.m.a> listA = this.a.a(this.g.d() - i, APEZProvider.FILEID);
            if (listA != null && listA.size() != 0) {
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.B(), 1);
            }
            return listA;
        }
        if (aVar.f() == 3 && aVar.c() == 2 && b.b.a.a.i.a.k.a.b()) {
            if (this.i.d() > i) {
                return this.c.a(this.i.d() - i, APEZProvider.FILEID);
            }
        } else if (aVar.f() == 0 && aVar.c() == 2 && b.b.a.a.i.a.k.a.a()) {
            if (this.h.d() > i) {
                List<b.b.a.a.i.a.m.a> listA2 = this.f204b.a(this.h.d() - i, APEZProvider.FILEID);
                if (listA2 != null && listA2.size() != 0) {
                    b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.d(), 1);
                }
                return listA2;
            }
        } else if (aVar.f() == 1 && aVar.c() == 2 && b.b.a.a.i.a.k.a.f()) {
            if (this.j.d() > i) {
                List<b.b.a.a.i.a.m.a> listA3 = this.d.a(this.j.d() - i, APEZProvider.FILEID);
                if (listA3 != null && listA3.size() != 0) {
                    b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.Y(), 1);
                }
                return listA3;
            }
        } else if (aVar.f() == 1 && aVar.c() == 3 && b.b.a.a.i.a.k.a.c()) {
            if (this.k.d() > i) {
                List<b.b.a.a.i.a.m.a> listA4 = this.e.a(this.k.d() - i, APEZProvider.FILEID);
                if (listA4 != null && listA4.size() != 0) {
                    b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.m(), 1);
                }
                return listA4;
            }
        } else if (aVar.f() == 2 && aVar.c() == 3 && b.b.a.a.i.a.k.a.e() && this.l.d() > i) {
            return this.f.a(this.l.d() - i, APEZProvider.FILEID);
        }
        return null;
    }

    @Override // b.b.a.a.i.a.j.d
    public void a(int i, List<b.b.a.a.i.a.m.a> list) {
        b.b.a.a.i.a.l.c.a("dbCache handleResult start");
        if (list != null && list.size() != 0 && list.get(0) != null) {
            b.b.a.a.i.a.m.a aVar = list.get(0);
            if (i == 200 || i == -1) {
                b.b.a.a.i.a.k.e.a aVar2 = b.b.a.a.i.a.k.d.h;
                b.b.a.a.i.a.l.b.a(aVar2.i(), list.size());
                if (i != 200) {
                    b.b.a.a.i.a.l.b.a(aVar2.D(), list.size());
                }
                if (aVar.f() == 0 && aVar.c() == 1) {
                    if (b.b.a.a.i.a.k.a.d()) {
                        this.a.c(list);
                    }
                } else if (aVar.f() == 3 && aVar.c() == 2) {
                    if (b.b.a.a.i.a.k.a.b()) {
                        this.c.c(list);
                    }
                } else if (aVar.f() == 0 && aVar.c() == 2) {
                    if (b.b.a.a.i.a.k.a.a()) {
                        this.f204b.c(list);
                    }
                } else if (aVar.f() == 1 && aVar.c() == 2) {
                    if (b.b.a.a.i.a.k.a.f()) {
                        this.d.c(list);
                    }
                } else if (aVar.f() == 1 && aVar.c() == 3) {
                    if (b.b.a.a.i.a.k.a.c()) {
                        this.e.c(list);
                    }
                } else if (aVar.f() == 2 && aVar.c() == 3 && b.b.a.a.i.a.k.a.e()) {
                    this.f.c(list);
                }
            }
        }
        b.b.a.a.i.a.l.c.a("dbCache handleResult end");
    }

    @Override // b.b.a.a.i.a.j.d
    public List<b.b.a.a.i.a.m.a> a(int i, int i2, List<String> list) {
        if (b.b.a.a.i.a.k.a.d()) {
            List<b.b.a.a.i.a.m.a> listA = this.a.a(APEZProvider.FILEID);
            if (a(listA, list)) {
                b.b.a.a.i.a.l.c.a("high db get size:" + listA.size());
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.y(), 1);
                return listA;
            }
        }
        if (b.b.a.a.i.a.k.a.b()) {
            List<b.b.a.a.i.a.m.a> listA2 = this.c.a(APEZProvider.FILEID);
            if (a(listA2, list)) {
                b.b.a.a.i.a.l.c.a("v3ad db get :" + listA2.size());
                return listA2;
            }
        }
        if (b.b.a.a.i.a.k.a.a()) {
            List<b.b.a.a.i.a.m.a> listA3 = this.f204b.a(APEZProvider.FILEID);
            if (a(listA3, list)) {
                b.b.a.a.i.a.l.c.a("adevent db get :" + listA3.size());
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.a(), 1);
                return listA3;
            }
        }
        if (b.b.a.a.i.a.k.a.f()) {
            List<b.b.a.a.i.a.m.a> listA4 = this.d.a(APEZProvider.FILEID);
            if (a(listA4, list)) {
                b.b.a.a.i.a.l.c.a("real stats db get :" + listA4.size());
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.V(), 1);
                return listA4;
            }
        }
        if (b.b.a.a.i.a.k.a.c()) {
            List<b.b.a.a.i.a.m.a> listA5 = this.e.a(APEZProvider.FILEID);
            if (a(listA5, list)) {
                b.b.a.a.i.a.l.c.a("batch db get :" + listA5.size());
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.j(), 1);
                return listA5;
            }
        }
        if (!b.b.a.a.i.a.k.a.e()) {
            return null;
        }
        List<b.b.a.a.i.a.m.a> listA6 = this.f.a(APEZProvider.FILEID);
        if (!a(listA6, list)) {
            return null;
        }
        b.b.a.a.i.a.l.c.a("other db get :" + listA6.size());
        return listA6;
    }

    private boolean a(List<b.b.a.a.i.a.m.a> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<b.b.a.a.i.a.m.a> it = list.iterator();
                while (it.hasNext()) {
                    b.b.a.a.i.a.m.a next = it.next();
                    if (next != null) {
                        String strI = next.i();
                        if (!TextUtils.isEmpty(strI) && list2.contains(strI)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th) {
                b.b.a.a.i.a.l.c.b("DBCacheStrategy", "deleteMemList: " + th.getMessage());
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // b.b.a.a.i.a.j.d
    public boolean a(int i, boolean z) {
        b.b.a.a.i.a.j.g.h.e eVar;
        b.b.a.a.i.a.j.g.h.f fVar;
        g gVar;
        b.b.a.a.i.a.j.g.h.a aVar;
        b.b.a.a.i.a.j.g.h.b bVar;
        b.b.a.a.i.a.j.g.h.d dVar;
        if (b.b.a.a.i.a.k.a.d() && (dVar = this.a) != null && dVar.a(i)) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.z(), 1);
            return true;
        }
        if (b.b.a.a.i.a.k.a.b() && (bVar = this.c) != null && bVar.a(i)) {
            return true;
        }
        if (b.b.a.a.i.a.k.a.a() && (aVar = this.f204b) != null && aVar.a(i)) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.b(), 1);
            return true;
        }
        if (b.b.a.a.i.a.k.a.f() && (gVar = this.d) != null && gVar.a(i)) {
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.W(), 1);
            return true;
        }
        if (!b.b.a.a.i.a.k.a.c() || (fVar = this.e) == null || !fVar.a(i)) {
            return b.b.a.a.i.a.k.a.e() && (eVar = this.f) != null && eVar.a(i);
        }
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.k(), 1);
        return true;
    }
}
