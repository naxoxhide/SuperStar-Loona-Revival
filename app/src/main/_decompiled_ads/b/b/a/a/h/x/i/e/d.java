package b.b.a.a.h.x.i.e;

import android.graphics.Bitmap;
import b.b.a.a.h.q;

/* JADX INFO: compiled from: MemoryCacheWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements q {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b.b.a.a.h.x.i.b f187b;

    public d(q qVar) {
        this(qVar, null);
    }

    @Override // b.b.a.a.h.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get(String str) {
        Bitmap bitmap = this.a.get(str);
        b.b.a.a.h.x.i.b bVar = this.f187b;
        if (bVar != null) {
            bVar.b(str, bitmap);
        }
        return bitmap;
    }

    public d(q qVar, b.b.a.a.h.x.i.b bVar) {
        this.a = qVar;
        this.f187b = bVar;
    }

    @Override // b.b.a.a.h.a
    public boolean a(String str, Bitmap bitmap) {
        boolean zA = this.a.a(str, bitmap);
        b.b.a.a.h.x.i.b bVar = this.f187b;
        if (bVar != null) {
            bVar.a(str, Boolean.valueOf(zA));
        }
        return zA;
    }
}
