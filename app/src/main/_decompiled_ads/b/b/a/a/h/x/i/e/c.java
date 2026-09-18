package b.b.a.a.h.x.i.e;

import b.b.a.a.h.r;

/* JADX INFO: compiled from: LruCountRawCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements r {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.h.x.i.c<String, byte[]> f186b;

    /* JADX INFO: compiled from: LruCountRawCache.java */
    class a extends b.b.a.a.h.x.i.c<String, byte[]> {
        a(c cVar, int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // b.b.a.a.h.x.i.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int c(String str, byte[] bArr) {
            if (bArr == null) {
                return 0;
            }
            return bArr.length;
        }
    }

    public c(int i, int i2) {
        this.a = i2;
        this.f186b = new a(this, i);
    }

    @Override // b.b.a.a.h.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public byte[] get(String str) {
        return this.f186b.b(str);
    }

    @Override // b.b.a.a.h.a
    public boolean a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.f186b.a(str, bArr);
        return true;
    }
}
