package b.b.a.a.i.a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.r;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: EventMultiUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final d a = new d();

    /* JADX INFO: compiled from: EventMultiUtils.java */
    class a implements Runnable {
        a(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.i.a.l.a.f();
        }
    }

    /* JADX INFO: compiled from: EventMultiUtils.java */
    class b extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.b.a.a.i.a.f f196b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, b.b.a.a.i.a.f fVar) {
            super(str);
            this.f196b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.i.a.l.c.a("TTExecutor start");
            d.this.a(this.f196b.d());
        }
    }

    /* JADX INFO: compiled from: EventMultiUtils.java */
    class c extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.b.a.a.i.a.f f197b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, b.b.a.a.i.a.f fVar) {
            super(str);
            this.f197b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f197b.d());
        }
    }

    /* JADX INFO: renamed from: b.b.a.a.i.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventMultiUtils.java */
    class C0040d extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.b.a.a.i.a.m.a f198b;
        final /* synthetic */ b.b.a.a.i.a.f c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0040d(String str, b.b.a.a.i.a.m.a aVar, b.b.a.a.i.a.f fVar) {
            super(str);
            this.f198b = aVar;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f198b, this.c.d());
        }
    }

    /* JADX INFO: compiled from: EventMultiUtils.java */
    class e extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f199b;
        final /* synthetic */ List c;
        final /* synthetic */ boolean d;
        final /* synthetic */ b.b.a.a.i.a.f e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, String str2, List list, boolean z, b.b.a.a.i.a.f fVar) {
            super(str);
            this.f199b = str2;
            this.c = list;
            this.d = z;
            this.e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f199b, this.c, this.d, this.e.d());
        }
    }

    /* JADX INFO: compiled from: EventMultiUtils.java */
    class f extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f200b;
        final /* synthetic */ b.b.a.a.i.a.f c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, String str2, b.b.a.a.i.a.f fVar) {
            super(str);
            this.f200b = str2;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f200b, this.c.d());
        }
    }

    public void c() {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || fVarA.a() == null) {
            return;
        }
        if (!i.f().k()) {
            i.f().m();
            return;
        }
        if (a(i.f().c(), fVarA)) {
            i.f().m();
        } else if (a()) {
            fVarA.a().execute(new c("stop", fVarA));
        } else {
            b(fVarA.d());
        }
    }

    public void d() {
    }

    public void b(b.b.a.a.i.a.a aVar, Context context) {
        a(aVar, context);
        i.f().a(context);
        i.f().a(aVar.i());
        i.f().b(aVar.f());
        i.f().c(aVar.g());
        i.f().a(aVar.d());
        i.f().d(aVar.h());
        i.f().a(aVar.e() == null ? b.b.a.a.i.a.j.g.e.f208b : aVar.e());
        i.f().a(aVar.j());
        i.f().a(aVar.a());
        b.b.a.a.i.a.k.g.c.d(aVar.b());
        b.b.a.a.i.a.k.g.c.e(aVar.c());
        a(aVar);
    }

    private void a(b.b.a.a.i.a.a aVar) {
        Executor executorB;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            b.b.a.a.i.a.l.a.f();
            return;
        }
        b.b.a.a.i.a.f fVarA = aVar.a();
        if (fVarA == null || (executorB = fVarA.b()) == null) {
            return;
        }
        executorB.execute(new a(this));
    }

    private void a(b.b.a.a.i.a.a aVar, Context context) {
        b.b.a.a.i.a.c.a(context, "context == null");
        b.b.a.a.i.a.c.a(aVar, "AdLogConfig == null");
        b.b.a.a.i.a.c.a(aVar.a(), "AdLogDepend ==null");
    }

    private boolean a(Context context, b.b.a.a.i.a.f fVar) {
        if (context == null || fVar == null) {
            return false;
        }
        if (fVar.d() == 2) {
            return true;
        }
        if (fVar.d() == 1) {
            return fVar.n();
        }
        try {
            return r.c(context);
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b(th.getMessage());
            return true;
        }
    }

    public void b() {
        b.b.a.a.i.a.l.c.a("EventMultiUtils start");
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || fVarA.a() == null) {
            return;
        }
        if (i.f().k()) {
            if (a(i.f().c(), fVarA)) {
                i.f().l();
                return;
            } else if (a()) {
                fVarA.a().execute(new b("start", fVarA));
                return;
            } else {
                a(fVarA.d());
                return;
            }
        }
        i.f().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            b.b.a.a.i.a.k.f.a.c();
        } else if (i == 1) {
            b.b.a.a.i.a.k.f.b.d();
        }
    }

    private boolean a() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void a(b.b.a.a.i.a.m.a aVar) {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (aVar == null || fVarA == null || i.f().c() == null || fVarA.a() == null) {
            return;
        }
        if (i.f().k()) {
            boolean zA = a(i.f().c(), fVarA);
            b.b.a.a.i.a.l.c.a("dispatchEvent mainProcess:" + zA);
            if (zA) {
                i.f().a(aVar);
                return;
            }
            b.b.a.a.i.a.l.c.a("sub thread dispatch:" + a());
            if (a()) {
                fVarA.a().execute(new C0040d("dispatchEvent", aVar, fVarA));
                return;
            } else {
                a(aVar, fVarA.d());
                return;
            }
        }
        i.f().a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i == 0) {
            b.b.a.a.i.a.k.f.a.d();
        } else if (i == 1) {
            b.b.a.a.i.a.k.f.b.e();
        }
    }

    public void b(b.b.a.a.i.a.m.a aVar) {
        a(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.b.a.a.i.a.m.a aVar, int i) {
        if (i == 0) {
            b.b.a.a.i.a.k.f.a.a(aVar);
        } else if (i == 1) {
            b.b.a.a.i.a.k.f.b.a(aVar);
        }
    }

    public void a(String str, List<String> list, boolean z) {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || fVarA.a() == null || !fVarA.f()) {
            return;
        }
        if (fVarA.d() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (fVarA.d() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (i.f().k() && !a(i.f().c(), fVarA)) {
            if (a()) {
                fVarA.a().execute(new e("trackFailed", str, list, z, fVarA));
                return;
            } else {
                a(str, list, z, fVarA.d());
                return;
            }
        }
        i.f().a(str, list, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<String> list, boolean z, int i) {
        if (i == 0) {
            b.b.a.a.i.a.k.f.a.a(str, list, z);
        } else if (i == 1) {
            b.b.a.a.i.a.k.f.b.a(str, list, z);
        }
    }

    public void a(String str) {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || fVarA.a() == null || !fVarA.f()) {
            return;
        }
        if (fVarA.d() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (i.f().k() && !a(i.f().c(), fVarA)) {
            if (a()) {
                fVarA.a().execute(new f("trackFailed", str, fVarA));
                return;
            } else {
                a(str, fVarA.d());
                return;
            }
        }
        i.f().a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        if (i == 0) {
            b.b.a.a.i.a.k.f.a.a(str);
        } else if (i == 1) {
            b.b.a.a.i.a.k.f.b.a(str);
        }
    }
}
