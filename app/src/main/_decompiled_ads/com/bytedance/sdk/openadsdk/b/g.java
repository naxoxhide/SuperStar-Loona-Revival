package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.s;
import com.bytedance.sdk.openadsdk.core.f0.v;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.settings.n;
import com.bytedance.sdk.openadsdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements y.a {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p<com.bytedance.sdk.openadsdk.d.a> f447b;
    private final f c;
    private AdSlot f;
    private PAGAppOpenAdLoadListener g;
    private int h;
    private boolean k;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private int e = 0;
    private volatile int i = 0;
    private final v j = new v();

    /* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
    class a implements p.a {
        final /* synthetic */ AdSlot a;

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
        class RunnableC0176a implements Runnable {
            final /* synthetic */ q a;

            RunnableC0176a(q qVar) {
                this.a = qVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.j.a(2);
                g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 100, this.a));
            }
        }

        a(AdSlot adSlot) {
            this.a = adSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, com.bytedance.sdk.openadsdk.core.f0.b bVar) {
            g.this.i = 2;
            m.a("TTAppOpenAdLoadManager", "try load app open ad from network success");
            if (aVar == null || aVar.b() == null || aVar.b().size() == 0) {
                g.this.i = 3;
                g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(2, 100, 20001, com.bytedance.sdk.openadsdk.core.g.a(20001)));
                bVar.a(-3);
                com.bytedance.sdk.openadsdk.core.f0.b.a(bVar);
                return;
            }
            q qVar = aVar.b().get(0);
            long jN = qVar.n();
            g.this.j.j = jN;
            if (q.c(qVar)) {
                g.this.a(qVar, this.a);
            } else {
                if (o.d().m() == 1) {
                    g.this.j.j = -1L;
                    g.this.j.a(3);
                    g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 100, qVar));
                }
                g.this.a(qVar);
            }
            if (g.this.j.i) {
                m.a("TTAppOpenAdLoadManager", "onAdLoad: invoke callback after ", Long.valueOf(jN), "ms for bidding");
                if (jN != 0) {
                    l.a().postDelayed(new RunnableC0176a(qVar), jN);
                } else {
                    g.this.j.a(2);
                    g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 100, qVar));
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.a
        public void onError(int i, String str) {
            g.this.i = 3;
            m.a("TTAppOpenAdLoadManager", "try load app open ad from network fail, " + i + ", " + str);
            g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(2, 100, i, str));
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
    class b extends b.b.a.a.k.g {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            q qVarE = g.this.c.e(g.this.e);
            if (qVarE == null) {
                g.this.a(false);
                return;
            }
            boolean zC = q.c(qVarE);
            if (zC || o.d().m() != 1) {
                z = false;
            } else {
                g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 101, qVarE));
                z = true;
            }
            if (!g.this.c.b(g.this.e) && !g.this.c.a(g.this.e)) {
                g.this.a(true);
                return;
            }
            if (n.j0().p(g.this.f.getCodeId()) == 0) {
                g.this.c.c(g.this.e);
            }
            m.a("TTAppOpenAdLoadManager", "Cached material resolution success, video = " + zC);
            if (zC) {
                if (!TextUtils.isEmpty(g.this.c.a(qVarE)) || Build.VERSION.SDK_INT < 23) {
                    g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 101, qVarE));
                    return;
                }
                m.a("TTAppOpenAdLoadManager", "Video cache path not found");
                g.this.a(false);
                com.bytedance.sdk.openadsdk.b.k.a.b(qVarE);
                return;
            }
            if (g.this.c.b(qVarE)) {
                if (z) {
                    return;
                }
                g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(1, 101, qVarE));
            } else {
                m.a("TTAppOpenAdLoadManager", "Image cache path not found");
                g.this.a(false);
                com.bytedance.sdk.openadsdk.b.k.a.b(qVarE);
            }
        }
    }

    public g(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = o.a();
        }
        this.f447b = o.c();
        this.c = f.a(this.a);
    }

    private void b(AdSlot adSlot) {
        this.i = 1;
        s sVar = new s();
        sVar.h = this.j;
        sVar.d = 1;
        sVar.f = 2;
        this.f447b.a(adSlot, sVar, 3, new a(adSlot));
    }

    /* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
    class c implements f.k {
        final /* synthetic */ q a;

        c(q qVar) {
            this.a = qVar;
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.k
        public void a() {
            Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: video load success");
            g.this.i = 4;
            com.bytedance.sdk.openadsdk.b.l.b bVar = new com.bytedance.sdk.openadsdk.b.l.b(1, 100, this.a);
            bVar.a(true);
            g.this.a(bVar);
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.k
        public void a(int i, String str) {
            m.a("TTAppOpenAdLoadManager", "preLoadFail() called with: code = [" + i + "], message = [" + str + "]");
            g.this.i = 5;
            g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(2, 100, 10003, com.bytedance.sdk.openadsdk.core.g.a(10003)));
        }
    }

    /* JADX INFO: compiled from: TTAppOpenAdLoadManager.java */
    class d implements f.j {
        final /* synthetic */ q a;

        d(q qVar) {
            this.a = qVar;
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.j
        public void a(com.bytedance.sdk.openadsdk.n.d.b bVar) {
            Log.d("TTAppOpenAdLoadManager", "preLoadSuccess: image load success");
            g.this.i = 4;
            com.bytedance.sdk.openadsdk.b.l.b bVar2 = new com.bytedance.sdk.openadsdk.b.l.b(1, 100, this.a);
            bVar2.a(true);
            g.this.a(bVar2);
        }

        @Override // com.bytedance.sdk.openadsdk.b.f.j
        public void a() {
            Log.d("TTAppOpenAdLoadManager", "preLoadFail: image load fail");
            g.this.i = 5;
            g.this.a(new com.bytedance.sdk.openadsdk.b.l.b(2, 100, 10003, com.bytedance.sdk.openadsdk.core.g.a(10003)));
        }
    }

    public static g a(Context context) {
        return new g(context);
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        if (i <= 0) {
            m.a("TTAppOpenAdLoadManager", "Since the timeout value passed by loadAppOpenAd is <=0, now it is set to the default value of 3500ms");
            i = 3500;
        }
        this.f = adSlot;
        this.j.i = !TextUtils.isEmpty(adSlot.getBidAdm());
        if (bVar instanceof PAGAppOpenAdLoadListener) {
            this.g = (PAGAppOpenAdLoadListener) bVar;
        }
        this.e = a(this.f);
        this.h = i;
        this.j.b(z.c());
        if (this.j.i || n.j0().p(this.f.getCodeId()) == 0) {
            b(this.f);
        }
        if (this.j.i) {
            return;
        }
        new y(l.a().getLooper(), this).sendEmptyMessageDelayed(1, i);
        a();
    }

    private void a() {
        com.bytedance.sdk.openadsdk.utils.y.c(new b("tryGetAppOpenAdFromCache"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.c.c(this.e);
        }
        if (n.j0().p(this.f.getCodeId()) == 1) {
            b(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, AdSlot adSlot) {
        this.c.a(qVar, adSlot, this.j, new c(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        this.c.a(qVar, this.j, new d(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.b.l.b bVar) {
        int iE = bVar.e();
        int iC = bVar.c();
        if (this.d.get()) {
            if (iE == 1 && iC == 100 && bVar.f()) {
                f.a(o.a()).a(new com.bytedance.sdk.openadsdk.b.l.a(this.e, bVar.d()));
                if (this.k) {
                    return;
                }
                com.bytedance.sdk.openadsdk.b.k.a.a(bVar.d(), 1, this.j);
                return;
            }
            return;
        }
        if (iE != 1) {
            if (iE == 2 || iE == 3) {
                PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = this.g;
                if (pAGAppOpenAdLoadListener != null) {
                    pAGAppOpenAdLoadListener.onError(bVar.a(), bVar.b());
                }
                this.d.set(true);
                if (iE == 3) {
                    com.bytedance.sdk.openadsdk.b.k.a.a(this.i, this.h);
                    return;
                }
                return;
            }
            return;
        }
        if (this.g != null) {
            this.g.onAdLoaded(new com.bytedance.sdk.openadsdk.b.d(this.a, bVar.d(), iC == 101, this.f));
        }
        this.d.set(true);
        if (iC == 101) {
            com.bytedance.sdk.openadsdk.b.k.a.a(bVar.d(), this.j.h().d());
            return;
        }
        if (iC == 100) {
            com.bytedance.sdk.openadsdk.b.k.a.a(bVar.d(), 0, this.j);
            this.k = true;
            if (this.j.i) {
                return;
            }
            if (n.j0().p(this.f.getCodeId()) == 0) {
                this.c.b(this.f);
            } else {
                this.c.a(new com.bytedance.sdk.openadsdk.b.l.a(this.e, bVar.d()));
            }
        }
    }

    public int a(AdSlot adSlot) {
        try {
            return Integer.parseInt(adSlot.getCodeId());
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        if (message.what != 1 || this.d.get()) {
            return;
        }
        a(new com.bytedance.sdk.openadsdk.b.l.b(3, 102, 10002, com.bytedance.sdk.openadsdk.core.g.a(10002)));
    }
}
