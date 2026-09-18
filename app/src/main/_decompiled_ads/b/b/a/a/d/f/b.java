package b.b.a.a.d.f;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: compiled from: DynamicRenderInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements j {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.d.d.g.a f112b;
    private ThemeStatusBroadcastReceiver c;
    private h d;
    private m e;
    private int f;

    public b(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, b.b.a.a.d.d.i.g gVar, h hVar, b.b.a.a.d.d.j.a aVar, b.b.a.a.d.d.g.a aVar2) {
        this.a = context;
        this.e = mVar;
        this.c = themeStatusBroadcastReceiver;
        this.d = hVar;
        if (aVar2 != null) {
            this.f112b = aVar2;
        } else {
            this.f112b = new b.b.a.a.d.d.g.a(context, themeStatusBroadcastReceiver, z, gVar, mVar, aVar);
        }
        this.f112b.a(this.d);
        if (gVar instanceof b.b.a.a.d.d.i.f) {
            this.f = 3;
        } else {
            this.f = 2;
        }
    }

    @Override // b.b.a.a.d.f.j
    public void a() {
    }

    @Override // b.b.a.a.d.f.j
    public void b() {
    }

    @Override // b.b.a.a.d.f.j
    public void release() {
        b.b.a.a.d.d.g.a aVar = this.f112b;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // b.b.a.a.d.f.j
    public boolean a(j.a aVar) {
        this.e.o().e(this.f);
        this.f112b.a(new a(aVar));
        return true;
    }

    public b.b.a.a.d.d.d c() {
        b.b.a.a.d.d.g.a aVar = this.f112b;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    /* JADX INFO: compiled from: DynamicRenderInterceptor.java */
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
            b.this.e.o().f(b.this.f);
            b.this.e.o().c(b.this.f);
            b.this.e.o().g();
            o oVarA = this.a.a();
            if (oVarA == null) {
                return;
            }
            oVarA.a(b.this.f112b, nVar);
            this.a.a(true);
        }

        @Override // b.b.a.a.d.f.g
        public void a(int i) {
            b.this.e.o().a(b.this.f, i, this.a.a(b.this));
            if (this.a.a(b.this)) {
                this.a.b(b.this);
                return;
            }
            o oVarA = this.a.a();
            if (oVarA == null) {
                return;
            }
            oVarA.b(i);
        }
    }
}
