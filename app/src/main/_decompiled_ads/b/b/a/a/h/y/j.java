package b.b.a.a.h.y;

import android.graphics.Bitmap;
import b.b.a.a.h.u;

/* JADX INFO: compiled from: MemoryCacheVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends a {
    @Override // b.b.a.a.h.y.i
    public String a() {
        return "memory_cache";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        u uVarQ = cVar.q();
        Bitmap bitmap = (uVarQ == u.BITMAP || uVarQ == u.AUTO) ? cVar.h().e(cVar.f()).get(cVar.e()) : null;
        if (bitmap == null) {
            cVar.a(new l());
        } else {
            cVar.a(new m(bitmap, null, false));
        }
    }
}
