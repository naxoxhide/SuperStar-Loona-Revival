package b.b.a.a.d.f;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WebViewRenderInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements j {
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b.b.a.a.d.h.a f120b;
    private h c;
    private m d;
    private ScheduledFuture<?> e;
    private AtomicBoolean f = new AtomicBoolean(false);

    /* JADX INFO: compiled from: WebViewRenderInterceptor.java */
    private class b implements Runnable {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j.a f122b;

        public b(int i, j.a aVar) {
            this.a = i;
            this.f122b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 1) {
                com.bytedance.sdk.component.utils.m.a("RenderInterceptor", "WebView Render timeout");
                p.this.f120b.a(true);
                p.this.a(this.f122b, 107);
            }
        }
    }

    public p(Context context, m mVar, b.b.a.a.d.h.a aVar, h hVar) {
        this.a = context;
        this.d = mVar;
        this.c = hVar;
        this.f120b = aVar;
        aVar.a(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ScheduledFuture<?> scheduledFuture = this.e;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.e.cancel(false);
                this.e = null;
            }
            com.bytedance.sdk.component.utils.m.a("RenderInterceptor", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public b.b.a.a.d.h.a d() {
        return this.f120b;
    }

    @Override // b.b.a.a.d.f.j
    public void release() {
        this.f120b.k();
        c();
    }

    @Override // b.b.a.a.d.f.j
    public void b() {
        this.f120b.c();
    }

    @Override // b.b.a.a.d.f.j
    public boolean a(j.a aVar) {
        int iR = this.d.r();
        if (iR < 0) {
            a(aVar, 107);
        } else {
            this.e = b.b.a.a.k.e.h().schedule(new b(1, aVar), iR, TimeUnit.MILLISECONDS);
            this.f120b.a(new a(aVar));
        }
        return true;
    }

    /* JADX INFO: compiled from: WebViewRenderInterceptor.java */
    class a implements g {
        final /* synthetic */ j.a a;

        a(j.a aVar) {
            this.a = aVar;
        }

        @Override // b.b.a.a.d.f.g
        public void a(View view, n nVar) {
            o oVarA;
            p.this.c();
            if (this.a.c() || (oVarA = this.a.a()) == null) {
                return;
            }
            oVarA.a(p.this.f120b, nVar);
            this.a.a(true);
        }

        @Override // b.b.a.a.d.f.g
        public void a(int i) {
            p.this.a(this.a, i);
        }
    }

    @Override // b.b.a.a.d.f.j
    public void a() {
        this.f120b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j.a aVar, int i) {
        if (aVar.c() || this.f.get()) {
            return;
        }
        c();
        this.d.o().d(i);
        if (aVar.a(this)) {
            aVar.b(this);
        } else {
            o oVarA = aVar.a();
            if (oVarA == null) {
                return;
            } else {
                oVarA.b(i);
            }
        }
        this.f.getAndSet(true);
    }
}
