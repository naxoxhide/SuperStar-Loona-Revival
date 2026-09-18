package b.b.a.a.h.y;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: NetVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends b.b.a.a.h.y.a {

    /* JADX INFO: compiled from: NetVisitor.java */
    class a implements Runnable {
        final /* synthetic */ b.b.a.a.h.x.c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.b.a.a.h.x.f f192b;
        final /* synthetic */ byte[] c;

        a(k kVar, b.b.a.a.h.x.c cVar, b.b.a.a.h.x.f fVar, byte[] bArr) {
            this.a = cVar;
            this.f192b = fVar;
            this.c = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strO = this.a.o();
            b.b.a.a.h.b bVarF = this.a.f();
            if (bVarF.a()) {
                this.f192b.f(this.a.f()).a(strO, this.c);
            }
            if (bVarF.e()) {
                this.f192b.d(this.a.f()).a(strO, this.c);
            }
        }
    }

    @Override // b.b.a.a.h.y.i
    public String a() {
        return "net_request";
    }

    @Override // b.b.a.a.h.y.i
    public void a(b.b.a.a.h.x.c cVar) {
        b.b.a.a.h.x.f fVarH = cVar.h();
        b.b.a.a.h.d dVarH = fVarH.h();
        cVar.a(false);
        try {
            b.b.a.a.h.f fVarA = dVarH.a(new b.b.a.a.h.w.c(cVar.a(), cVar.t(), cVar.s()));
            int iA = fVarA.a();
            cVar.a(fVarA.c());
            if (fVarA.a() == 200) {
                byte[] bArr = (byte[]) fVarA.getData();
                cVar.a(new b(bArr, fVarA));
                fVarH.k().submit(new a(this, cVar, fVarH, bArr));
            } else {
                fVarH.j().a(String.valueOf(fVarA));
                Object data = fVarA.getData();
                a(iA, fVarA.d(), data instanceof Throwable ? (Throwable) data : null, cVar);
            }
        } catch (Throwable th) {
            a(PointerIconCompat.TYPE_WAIT, "net request failed!", th, cVar);
        }
    }

    private void a(int i, String str, Throwable th, b.b.a.a.h.x.c cVar) {
        cVar.a(new h(i, str, th));
    }
}
