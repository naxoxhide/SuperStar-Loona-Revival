package com.kakao.adfit.common.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecutorDelivery.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.kakao.adfit.m.e {
    private final Executor a;

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    class a implements Executor {
        final /* synthetic */ Handler a;

        a(Handler handler) {
            this.a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* JADX INFO: compiled from: ExecutorDelivery.java */
    private static class b implements Runnable {
        private final e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f1720b;
        private final Runnable c;

        public b(e eVar, g gVar, Runnable runnable) {
            this.a = eVar;
            this.f1720b = gVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.s()) {
                this.a.c("canceled-at-delivery");
                return;
            }
            if (this.f1720b.a()) {
                this.a.a(this.f1720b.a);
            } else {
                this.a.a(this.f1720b.c);
            }
            if (this.f1720b.d) {
                this.a.a("intermediate-response");
            } else {
                this.a.c("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public c(Handler handler) {
        this.a = new a(handler);
    }

    @Override // com.kakao.adfit.m.e
    public void a(e<?> eVar, g<?> gVar) {
        a(eVar, gVar, null);
    }

    @Override // com.kakao.adfit.m.e
    public void a(e<?> eVar, g<?> gVar, Runnable runnable) {
        eVar.t();
        eVar.a("post-response");
        this.a.execute(new b(eVar, gVar, runnable));
    }

    @Override // com.kakao.adfit.m.e
    public void a(e<?> eVar, VolleyError volleyError) {
        eVar.a("post-error");
        this.a.execute(new b(eVar, g.a(volleyError), null));
    }
}
