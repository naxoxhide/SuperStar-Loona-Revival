package b.b.a.a.f.a.q;

/* JADX INFO: compiled from: Segment.java */
/* JADX INFO: loaded from: classes.dex */
final class c {
    final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f161b;
    int c;
    boolean d;
    boolean e;
    c f;
    c g;

    c() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final c a() {
        c cVar = this.f;
        c cVar2 = cVar != this ? cVar : null;
        c cVar3 = this.g;
        if (cVar3 != null) {
            cVar3.f = cVar;
        }
        c cVar4 = this.f;
        if (cVar4 != null) {
            cVar4.g = cVar3;
        }
        this.f = null;
        this.g = null;
        return cVar2;
    }

    final c b() {
        this.d = true;
        return new c(this.a, this.f161b, this.c, true, false);
    }

    c(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.f161b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final c a(c cVar) {
        cVar.g = this;
        cVar.f = this.f;
        this.f.g = cVar;
        this.f = cVar;
        return cVar;
    }
}
