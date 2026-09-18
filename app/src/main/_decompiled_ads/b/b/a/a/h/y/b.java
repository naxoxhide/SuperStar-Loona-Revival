package b.b.a.a.h.y;

import b.b.a.a.h.u;

/* JADX INFO: compiled from: BytesVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements i {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.h.f f189b;

    /* JADX INFO: compiled from: BytesVisitor.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[u.values().length];
            a = iArr;
            try {
                iArr[u.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[u.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[u.BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(byte[] bArr, b.b.a.a.h.f fVar) {
        this.a = bArr;
        this.f189b = fVar;
    }

    @Override // b.b.a.a.h.y.i
    public String a() {
        return "image_type";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        i mVar;
        u uVarQ = cVar.q();
        cVar.a(this.a.length);
        int i = a.a[uVarQ.ordinal()];
        if (i == 1) {
            byte[] bArr = this.a;
            mVar = new m(bArr, this.f189b, b.b.a.a.h.x.k.a.a(bArr));
        } else if (i != 3) {
            if (b.b.a.a.h.x.k.a.b(this.a)) {
                mVar = new e(this.a, this.f189b);
            } else {
                byte[] bArr2 = this.a;
                mVar = new m(bArr2, this.f189b, b.b.a.a.h.x.k.a.a(bArr2));
            }
        } else if (b.b.a.a.h.x.k.a.b(this.a)) {
            mVar = new e(this.a, this.f189b);
        } else {
            mVar = this.f189b == null ? new k() : new h(1001, "not image format", null);
        }
        cVar.a(mVar);
    }
}
