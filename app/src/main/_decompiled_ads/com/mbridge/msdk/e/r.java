package com.mbridge.msdk.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.adxcorp.ads.common.AdConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ReportManager.java */
/* JADX INFO: loaded from: classes4.dex */
final class r {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2051b;
    private final int c;
    private final int d;
    private final k e;
    private Handler f;
    private boolean g = true;
    private final AtomicInteger h = new AtomicInteger(0);
    private volatile boolean i = false;
    private volatile boolean j = false;
    private final AtomicInteger k = new AtomicInteger(0);
    private final Object l = new Object();

    public r(k kVar) {
        this.a = kVar.f();
        this.f2051b = kVar.k();
        this.c = kVar.l();
        this.d = kVar.m();
        this.e = kVar;
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.f = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000L);
        Handler handler = this.f;
        handler.sendMessageDelayed(Message.obtain(handler, 1), this.c);
        this.g = false;
    }

    public final void b() {
        this.f.removeMessages(1);
        Handler handler = this.f;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public final void a(e eVar) {
        Handler handler = this.f;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    public final void c() {
        synchronized (this.l) {
            if (!this.i) {
                this.i = true;
                this.a.c();
            }
            if (!this.j) {
                this.j = true;
                this.k.set(this.a.a());
            }
        }
    }

    protected final boolean d() {
        return this.k.get() >= this.f2051b;
    }

    /* JADX INFO: compiled from: ReportManager.java */
    private static final class b extends Handler {
        private final r a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.a = rVar;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i = message.what;
            if (i == 2 || i == 3) {
                b();
                if (com.mbridge.msdk.e.a.a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
                return;
            }
            if (i == 5) {
                if (com.mbridge.msdk.e.a.a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.b(this.a);
                sendMessageDelayed(Message.obtain(this, 5), AdConstants.MEDIATION_CUSTOM_EVENT_TIMEOUT);
                return;
            }
            if (i != 6) {
                if (i == 7) {
                    this.a.c();
                    b();
                    if (com.mbridge.msdk.e.a.a) {
                        a("触发上报（flush）当前 Event 数量：");
                    }
                    a();
                    return;
                }
                b();
                if (com.mbridge.msdk.e.a.a) {
                    a("触发上报（timer）当前 Event 数量：");
                }
                a();
                return;
            }
            r.a(this.a);
            e eVar = message.obj instanceof e ? (e) message.obj : null;
            boolean z = false;
            if (com.mbridge.msdk.e.a.a && !y.a(eVar)) {
                a(String.format("收到 Event( %s )，当前 Event 数量：", eVar.a()));
            }
            if (y.b(eVar) && eVar.c() == 1) {
                z = true;
            }
            if (z || this.a.d()) {
                b();
                if (com.mbridge.msdk.e.a.a) {
                    a("触发上报（notice check）当前 Event 数量：");
                }
                a();
            }
        }

        private void a(String str) {
            Log.d("TrackManager", str + this.a.k.get() + " 数据库记录数：" + this.a.a.a());
        }

        private void a() {
            try {
                r.e(this.a);
            } catch (Exception e) {
                if (com.mbridge.msdk.e.a.a) {
                    Log.e("TrackManager", "report failed ", e);
                }
            }
        }

        private void b() {
            try {
                removeMessages(1);
            } catch (Exception e) {
                if (com.mbridge.msdk.e.a.a) {
                    Log.e("TrackManager", "removeMessages failed ", e);
                }
            }
            if (this.a.e()) {
                return;
            }
            try {
                sendMessageDelayed(Message.obtain(this, 1), this.a.c);
            } catch (Exception e2) {
                if (com.mbridge.msdk.e.a.a) {
                    Log.e("TrackManager", "sendMessageDelayed failed ", e2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ReportManager.java */
    private static final class a implements q {
        private final Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final r f2052b;

        public a(Handler handler, r rVar) {
            this.a = handler;
            this.f2052b = rVar;
        }

        @Override // com.mbridge.msdk.e.q
        public final void a(s sVar) {
            r.a(this.f2052b, sVar.a());
            r.g(this.f2052b);
            Handler handler = this.a;
            handler.sendMessage(Message.obtain(handler, 2));
            if (com.mbridge.msdk.e.a.a) {
                Log.d("TrackManager", "report success " + sVar.a().size() + " 剩余事件数：" + this.f2052b.k.get() + " 个，数据库记录数：" + this.f2052b.a.a() + " 个");
            }
        }

        @Override // com.mbridge.msdk.e.q
        public final void a(s sVar, int i, String str) {
            r.b(this.f2052b, sVar.a());
            int iH = r.h(this.f2052b);
            Handler handler = this.a;
            handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) iH) * 1000);
            if (com.mbridge.msdk.e.a.a) {
                Log.d("TrackManager", "report failed " + sVar.a().size() + " 剩余事件数：" + this.f2052b.k.get() + " 个，数据库记录数：" + this.f2052b.a.a() + " 个");
            }
        }
    }

    final boolean e() {
        return this.g;
    }

    static /* synthetic */ void a(r rVar) {
        rVar.k.incrementAndGet();
    }

    static /* synthetic */ void b(r rVar) {
        int iB = rVar.a.b();
        if (com.mbridge.msdk.e.a.a) {
            Log.d("TrackManager", "删除无效数据的数量 = " + iB + " 当前剩余事件数 = " + rVar.k.get() + " 数据库中剩余事件数 = " + rVar.a.a());
        }
    }

    static /* synthetic */ void e(r rVar) {
        List<i> listA = rVar.a.a(rVar.f2051b);
        if (y.a((List<?>) listA)) {
            if (com.mbridge.msdk.e.a.a) {
                Log.d("TrackManager", "report: 没有可以上报的数据");
                return;
            }
            return;
        }
        rVar.a.a(listA);
        AtomicInteger atomicInteger = rVar.k;
        atomicInteger.set(atomicInteger.get() - listA.size());
        if (com.mbridge.msdk.e.a.a) {
            Log.d("TrackManager", "report: 上报的数量 = " + listA.size() + " 当前剩余事件数 = " + rVar.k.get() + " 数据库中剩余事件数 = " + rVar.a.a());
        }
        boolean zO = false;
        try {
            zO = rVar.e.o();
        } catch (IllegalStateException e) {
            if (com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "report environment check failed ", e);
            }
        }
        if (!zO) {
            if (com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "report 失败，请检查 TrackConfig 配置是否正确");
                return;
            }
            return;
        }
        n nVarP = rVar.e.p();
        nVarP.a(new a(rVar.f, rVar));
        Map<String, String> map = new HashMap<>();
        try {
            map = rVar.e.i().a(rVar.e.j(), listA, rVar.e.e());
        } catch (Exception e2) {
            if (com.mbridge.msdk.e.a.a) {
                Log.e("TrackManager", "report decorate request params failed ", e2);
            }
        }
        nVarP.a(new s(listA), map, y.b(listA));
    }

    static /* synthetic */ void a(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        rVar.a.b((List<i>) list);
    }

    static /* synthetic */ void g(r rVar) {
        rVar.h.set(0);
    }

    static /* synthetic */ void b(r rVar, List list) {
        if (y.a((List<?>) list)) {
            return;
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!y.a(iVar)) {
                boolean z = !iVar.b() && iVar.d() >= rVar.d;
                boolean z2 = !iVar.a() && iVar.g() < System.currentTimeMillis();
                if (z || z2) {
                    iVar.b(-1);
                } else {
                    iVar.a(iVar.d() + 1);
                    iVar.b(3);
                    i++;
                }
            }
        }
        rVar.a.c((List<i>) list);
        AtomicInteger atomicInteger = rVar.k;
        atomicInteger.set(atomicInteger.get() + i);
    }

    static /* synthetic */ int h(r rVar) {
        return rVar.h.getAndIncrement();
    }
}
