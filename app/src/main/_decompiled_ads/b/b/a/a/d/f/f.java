package b.b.a.a.d.f;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: NativeRenderInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements j {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.d.f.a f114b;
    private m c;

    public f(Context context, m mVar, b.b.a.a.d.f.a aVar) {
        this.a = context;
        this.f114b = aVar;
        this.c = mVar;
    }

    @Override // b.b.a.a.d.f.j
    public void a() {
    }

    @Override // b.b.a.a.d.f.j
    public void b() {
    }

    @Override // b.b.a.a.d.f.j
    public void release() {
    }

    @Override // b.b.a.a.d.f.j
    public boolean a(j.a aVar) {
        this.c.o().e();
        this.f114b.a(new a(aVar));
        return true;
    }

    public void a(c cVar) {
        this.f114b.a(cVar);
    }

    /* JADX INFO: compiled from: NativeRenderInterceptor.java */
    class a implements g {
        final /* synthetic */ j.a a;

        a(j.a aVar) {
            this.a = aVar;
        }

        @Override // b.b.a.a.d.f.g
        public void a(View view, n nVar) {
            if (this.a.c()) {
                return;
            }
            o oVarA = this.a.a();
            if (oVarA != null) {
                oVarA.a(f.this.f114b, nVar);
            }
            this.a.a(true);
        }

        @Override // b.b.a.a.d.f.g
        public void a(int i) {
            o oVarA = this.a.a();
            if (oVarA != null) {
                oVarA.b(i);
            }
        }
    }
}
