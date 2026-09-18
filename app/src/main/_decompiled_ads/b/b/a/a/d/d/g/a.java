package b.b.a.a.d.d.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.b.a.a.d.d.h.f;
import b.b.a.a.d.d.i.g;
import b.b.a.a.d.f.h;
import b.b.a.a.d.f.k;
import b.b.a.a.d.f.m;
import b.b.a.a.d.f.n;
import b.b.a.a.k.e;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.i;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: DynamicRender.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.b.a.a.d.f.d<DynamicRootView>, k {
    private DynamicRootView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f80b;
    private Context c;
    private b.b.a.a.d.f.g d;
    private h e;
    private m f;
    private ScheduledFuture<?> g;
    private AtomicBoolean h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b.b.a.a.d.d.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DynamicRender.java */
    class RunnableC0022a implements Runnable {
        RunnableC0022a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    /* JADX INFO: compiled from: DynamicRender.java */
    class b implements b.b.a.a.d.d.j.b {

        /* JADX INFO: renamed from: b.b.a.a.d.d.g.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DynamicRender.java */
        class RunnableC0023a implements Runnable {
            final /* synthetic */ b.b.a.a.d.d.h.h a;

            RunnableC0023a(b.b.a.a.d.d.h.h hVar) {
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.a);
            }
        }

        b() {
        }

        @Override // b.b.a.a.d.d.j.b
        public void a(b.b.a.a.d.d.h.h hVar) {
            a.this.a();
            a.this.f.o().g(a.this.b());
            a.this.c(hVar);
            a.this.a(hVar);
            new Handler(Looper.getMainLooper()).post(new RunnableC0023a(hVar));
            if (a.this.a == null || hVar == null) {
                return;
            }
            a.this.a.setBgColor(hVar.b());
            a.this.a.setBgMaterialCenterCalcColor(hVar.c());
        }
    }

    /* JADX INFO: compiled from: DynamicRender.java */
    class c implements Comparator<b.b.a.a.d.d.h.h> {
        c(a aVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b.b.a.a.d.d.h.h hVar, b.b.a.a.d.d.h.h hVar2) {
            f fVarG = hVar.n().g();
            f fVarG2 = hVar2.n().g();
            if (fVarG == null || fVarG2 == null) {
                return 0;
            }
            return fVarG.s0() >= fVarG2.s0() ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: DynamicRender.java */
    private class d implements Runnable {
        private int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 2) {
                com.bytedance.sdk.component.utils.m.a("DynamicRender", "Dynamic parse time out");
                a.this.a.b(a.this.f80b instanceof b.b.a.a.d.d.i.f ? WorkQueueKt.MASK : 117);
            }
        }
    }

    public a(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, g gVar, m mVar, b.b.a.a.d.d.j.a aVar) {
        this.c = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, mVar, aVar);
        this.a = dynamicRootView;
        this.f80b = gVar;
        this.f = mVar;
        dynamicRootView.setRenderListener(this);
        this.f = mVar;
    }

    private boolean f() {
        DynamicRootView dynamicRootView = this.a;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f.o().a(b());
        if (!b.b.a.a.d.e.b.a.a(this.f.q())) {
            this.a.b(this.f80b instanceof b.b.a.a.d.d.i.f ? 123 : 113);
        } else {
            this.f80b.a(new b());
            this.f80b.a(this.f);
        }
    }

    public void g() {
        a(e());
    }

    @Override // b.b.a.a.d.f.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DynamicRootView e() {
        return c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(b.b.a.a.d.d.h.h hVar) {
        List<b.b.a.a.d.d.h.h> listE;
        if (hVar == null || (listE = hVar.e()) == null || listE.size() <= 0) {
            return;
        }
        Collections.sort(listE, new c(this));
        for (b.b.a.a.d.d.h.h hVar2 : listE) {
            if (hVar2 != null) {
                c(hVar2);
            }
        }
    }

    @Override // b.b.a.a.d.f.d
    public void a(b.b.a.a.d.f.g gVar) {
        this.d = gVar;
        int iR = this.f.r();
        if (iR < 0) {
            this.a.b(this.f80b instanceof b.b.a.a.d.d.i.f ? WorkQueueKt.MASK : 117);
        } else {
            this.g = e.h().schedule(new d(2), iR, TimeUnit.MILLISECONDS);
            i.b().postDelayed(new RunnableC0022a(), this.f.c());
        }
    }

    @Override // b.b.a.a.d.f.d
    public int b() {
        return this.f80b instanceof b.b.a.a.d.d.i.f ? 3 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b.b.a.a.d.d.h.h hVar) {
        if (hVar == null) {
            this.a.b(this.f80b instanceof b.b.a.a.d.d.i.f ? 123 : 113);
            return;
        }
        this.f.o().b(b());
        try {
            this.a.a(hVar, b());
        } catch (Exception unused) {
            this.a.b(this.f80b instanceof b.b.a.a.d.d.i.f ? 128 : 118);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.b.a.a.d.d.h.h hVar) {
        float fS;
        float fE;
        List<b.b.a.a.d.d.h.h> listE;
        if (hVar == null) {
            return;
        }
        List<b.b.a.a.d.d.h.h> listE2 = hVar.e();
        if (listE2 == null || listE2.size() <= 0) {
            fS = 0.0f;
        } else {
            fS = 0.0f;
            for (b.b.a.a.d.d.h.h hVar2 : listE2) {
                if (hVar2.s() > hVar.s() - hVar2.f() || (listE = hVar2.e()) == null || listE.size() <= 0) {
                    fE = 0.0f;
                } else {
                    fE = 0.0f;
                    for (b.b.a.a.d.d.h.h hVar3 : listE) {
                        if (hVar3.n().f().equals("logo-union")) {
                            fE = hVar3.n().e();
                            fS = (((-fE) + hVar.s()) - hVar2.s()) + hVar2.n().g().z();
                        }
                    }
                }
                a(hVar2);
                if (fE <= -15.0f) {
                    hVar2.a(hVar2.f() - fE);
                    hVar2.g(hVar2.s() + fE);
                    for (b.b.a.a.d.d.h.h hVar4 : hVar2.e()) {
                        hVar4.g(hVar4.s() - fE);
                    }
                }
            }
        }
        b.b.a.a.d.d.h.h hVarL = hVar.l();
        if (hVarL == null) {
            return;
        }
        float fR = hVar.r() - hVarL.r();
        float fS2 = hVar.s() - hVarL.s();
        hVar.f(fR);
        hVar.g(fS2);
        if (fS > 0.0f) {
            hVar.g(hVar.s() - fS);
            hVar.a(hVar.f() + fS);
            for (b.b.a.a.d.d.h.h hVar5 : hVar.e()) {
                hVar5.g(hVar5.s() + fS);
            }
        }
    }

    public DynamicRootView c() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                a(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.e) view).b();
        }
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    @Override // b.b.a.a.d.f.k
    public void a(n nVar) {
        if (this.h.get()) {
            return;
        }
        this.h.set(true);
        if (nVar.n() && f()) {
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.d.a(e(), nVar);
            return;
        }
        this.d.a(nVar.c());
    }

    @Override // b.b.a.a.d.f.k
    public void a(View view, int i, b.b.a.a.d.b bVar) {
        h hVar = this.e;
        if (hVar != null) {
            hVar.a(view, i, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            ScheduledFuture<?> scheduledFuture = this.g;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.g.cancel(false);
                this.g = null;
            }
            com.bytedance.sdk.component.utils.m.a("DynamicRender", "WebView Render cancel timeout timer");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
