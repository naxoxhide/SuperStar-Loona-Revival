package b.b.a.a.h.y;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: DecoderVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.h.f f190b;

    public e(byte[] bArr, b.b.a.a.h.f fVar) {
        this.a = bArr;
        this.f190b = fVar;
    }

    @Override // b.b.a.a.h.y.i
    public String a() {
        return "decode";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        b.b.a.a.h.x.f fVarH = cVar.h();
        try {
            Bitmap bitmapA = fVarH.a(cVar).a(this.a);
            if (bitmapA != null) {
                cVar.a(new m(bitmapA, this.f190b, false));
                fVarH.e(cVar.f()).a(cVar.e(), bitmapA);
            } else {
                a(1002, "decode failed bitmap null", null, cVar);
            }
        } catch (Throwable th) {
            a(1002, "decode failed:" + th.getMessage(), th, cVar);
        }
    }

    private void a(int i, String str, Throwable th, b.b.a.a.h.x.c cVar) {
        if (this.f190b == null) {
            cVar.a(new k());
        } else {
            cVar.a(new h(i, str, th));
        }
    }
}
