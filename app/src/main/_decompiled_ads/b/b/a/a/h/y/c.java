package b.b.a.a.h.y;

import android.text.TextUtils;

/* JADX INFO: compiled from: CacheKeyVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "generate_key";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        if (TextUtils.isEmpty(cVar.e())) {
            b.b.a.a.h.l lVarI = cVar.h().i();
            cVar.a(lVarI.a(cVar));
            cVar.b(lVarI.b(cVar));
        }
        cVar.a(new g());
    }
}
