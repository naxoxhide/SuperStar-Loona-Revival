package b.b.a.a.i.a.k.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import b.b.a.a.i.a.f;
import b.b.a.a.i.a.h;
import b.b.a.a.i.a.i;
import b.b.a.a.i.a.j.d;
import b.b.a.a.i.a.n.e;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdPriorityLogThread.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends HandlerThread implements Handler.Callback {
    private static int o = 10;
    private static int p = 200;
    private volatile boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f218b;
    protected d c;
    private b.b.a.a.i.a.k.c d;
    private final PriorityBlockingQueue<b.b.a.a.i.a.m.a> e;
    private volatile int f;
    private volatile long g;
    private volatile long h;
    private final AtomicInteger i;
    private final AtomicInteger j;
    private volatile Handler k;
    private final List<b.b.a.a.i.a.m.a> l;
    private final AtomicInteger m;
    private final AtomicInteger n;

    /* JADX INFO: compiled from: AdPriorityLogThread.java */
    class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f219b;
        final /* synthetic */ boolean c;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, List list, boolean z, long j) {
            super(str);
            this.f219b = list;
            this.c = z;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.a((List<b.b.a.a.i.a.m.a>) this.f219b, this.c, this.d, cVar.f);
        }
    }

    /* JADX INFO: compiled from: AdPriorityLogThread.java */
    class b implements b.b.a.a.i.a.k.b {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f220b;

        b(boolean z, long j) {
            this.a = z;
            this.f220b = j;
        }

        @Override // b.b.a.a.i.a.k.b
        public void a(List<b.b.a.a.i.a.k.g.a> list) {
            try {
                c.this.j.decrementAndGet();
                if (list == null || list.size() == 0) {
                    return;
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    b.b.a.a.i.a.k.g.a aVar = list.get(i);
                    if (aVar != null) {
                        c.this.a(this.a, aVar.b(), aVar.a(), this.f220b);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public c(PriorityBlockingQueue<b.b.a.a.i.a.m.a> priorityBlockingQueue) {
        super("csj_log");
        this.a = true;
        this.f218b = new Object();
        this.g = 0L;
        this.h = 0L;
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.l = new ArrayList();
        this.m = new AtomicInteger(0);
        this.n = new AtomicInteger(0);
        this.e = priorityBlockingQueue;
        this.c = new b.b.a.a.i.a.j.b();
    }

    public static void d(int i) {
        o = i;
        b.b.a.a.i.a.l.c.b("PADLT", "config size=" + i);
    }

    public static void e(int i) {
        p = i;
        b.b.a.a.i.a.l.c.b("PADLT", "applog_interval=" + i);
    }

    private void f() {
        if (this.e.size() >= 100) {
            for (int i = 0; i < 100; i++) {
                b.b.a.a.i.a.m.a aVarPoll = this.e.poll();
                if (aVarPoll instanceof b.b.a.a.i.a.m.b) {
                    b.b.a.a.i.a.l.c.a("ignore tm");
                } else if (aVarPoll != null) {
                    a(aVarPoll);
                } else {
                    b.b.a.a.i.a.l.c.b("event == null");
                }
            }
        }
    }

    private boolean g() {
        return b.b.a.a.i.a.k.d.g.f212b && (this.f == 4 || this.f == 7 || this.f == 6 || this.f == 5 || this.f == 2);
    }

    private void h() {
        if (!isAlive()) {
            b.b.a.a.i.a.l.c.a("th dead");
            b.b.a.a.i.a.k.d.g.a();
        } else {
            if (d()) {
                return;
            }
            b.b.a.a.i.a.l.c.a("monitor  mLogThread ");
            c(6);
        }
    }

    private void i() {
        b.b.a.a.i.a.l.c.a("sendServerBusyOrRoutineErrorRetryMessage");
        h();
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.G(), 1);
        c(1);
    }

    public void c(int i) {
        try {
            boolean zA = a(i, b.b.a.a.i.a.k.d.g.f212b);
            b.b.a.a.i.a.l.c.d("notify flush : " + zA + " " + i);
            if (i == 6 || zA) {
                b.b.a.a.i.a.m.b bVar = new b.b.a.a.i.a.m.b();
                bVar.a(i);
                this.e.add(bVar);
                a(3);
            }
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b(th.getMessage());
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                b.b.a.a.i.a.l.c.a("HANDLER_MESSAGE_INIT");
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.u(), 1);
                a(true);
                e();
            } else {
                if (i != 2 && i != 3) {
                    if (i == 11) {
                        b.b.a.a.i.a.l.c.a("opt upload");
                        ArrayList arrayList = new ArrayList(this.l);
                        this.l.clear();
                        a((List<b.b.a.a.i.a.m.a>) arrayList, false, "timeout_dispatch");
                        a();
                    }
                    return true;
                }
                b.b.a.a.i.a.l.c.a("-----------------server busy handleMessage---------------- ");
                i();
            }
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b("error:" + th.getMessage());
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.k = new Handler(getLooper(), this);
        b.b.a.a.i.a.k.d.g.a(this.k);
        this.k.sendEmptyMessage(1);
        b.b.a.a.i.a.l.c.a("onLooperPrepared");
    }

    private boolean b(int i) {
        if (i >= 4 && this.j.get() == 0) {
            b.b.a.a.i.a.k.d dVar = b.b.a.a.i.a.k.d.g;
            if (!dVar.f212b && !dVar.c) {
                return true;
            }
        }
        return false;
    }

    private void e() {
        while (d()) {
            try {
                b.b.a.a.i.a.k.e.a aVar = b.b.a.a.i.a.k.d.h;
                b.b.a.a.i.a.l.b.a(aVar.F(), 1);
                b.b.a.a.i.a.m.a aVarPoll = this.e.poll(60000L, TimeUnit.MILLISECONDS);
                int size = this.e.size();
                b.b.a.a.i.a.l.c.a("poll size:" + size);
                if (aVarPoll instanceof b.b.a.a.i.a.m.b) {
                    a(aVarPoll, size);
                } else if (aVarPoll == null) {
                    int iIncrementAndGet = this.i.incrementAndGet();
                    b.b.a.a.i.a.l.b.a(aVar.o(), 1);
                    if (b(iIncrementAndGet)) {
                        b();
                        return;
                    } else if (iIncrementAndGet < 4) {
                        b.b.a.a.i.a.l.c.a("timeoutCount:" + iIncrementAndGet);
                        this.f = 1;
                        b((b.b.a.a.i.a.m.a) null);
                    }
                } else {
                    a(aVarPoll);
                    b(aVarPoll);
                }
            } catch (Throwable th) {
                b.b.a.a.i.a.l.c.b("run exception:" + th.getMessage());
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.I(), 1);
            }
        }
    }

    public boolean d() {
        return this.a;
    }

    private void b() {
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.Z(), 1);
        a(false);
        b.b.a.a.i.a.k.d.g.e();
        b.b.a.a.i.a.l.c.d("exit log thread");
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean a(int i, boolean z) {
        f fVarA = i.f().a();
        if (fVarA != null && fVarA.a(i.f().c())) {
            return this.c.a(i, z);
        }
        b.b.a.a.i.a.l.c.b("AdThread NET IS NOT AVAILABLE!!!");
        return false;
    }

    private void b(b.b.a.a.i.a.m.a aVar) {
        int i = 0;
        if (g()) {
            b.b.a.a.i.a.l.c.d("upload cancel:" + b.b.a.a.i.a.l.a.a(this.f));
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.q(), 1);
            if (this.e.size() != 0) {
                return;
            }
            if (!this.k.hasMessages(2)) {
                b.b.a.a.i.a.k.d.g.f212b = false;
                this.h = 0L;
                this.g = 0L;
                this.m.set(0);
                this.n.set(0);
            } else {
                a(false);
                return;
            }
        }
        do {
            boolean zA = a(this.f, b.b.a.a.i.a.k.d.g.f212b);
            b.b.a.a.i.a.l.a.a(zA, this.f, aVar);
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.p(), 1);
            if (zA) {
                List<b.b.a.a.i.a.m.a> listA = this.c.a(this.f, -1, null);
                if (listA != null) {
                    b.b.a.a.i.a.l.c.d("upload size=" + listA.size() + "  times=" + i);
                    b(listA);
                } else {
                    b.b.a.a.i.a.l.c.c("no need upload");
                    c();
                }
            } else {
                c();
            }
            i++;
            b.b.a.a.i.a.l.c.c("times=" + i);
            if (!zA) {
                return;
            }
        } while (i <= 6);
    }

    private void c() {
        try {
            if (this.e.size() == 0 && this.k.hasMessages(11) && d()) {
                a(false);
            }
        } catch (Exception e) {
            b.b.a.a.i.a.l.c.b(e.getMessage());
        }
    }

    public void a(b.b.a.a.i.a.m.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        b.b.a.a.i.a.l.c.a("ignore result : " + z + CertificateUtil.DELIMITER + this.a + " adType: " + ((int) aVar.f()));
        if (z) {
            if (this.k != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(aVar);
                a((List<b.b.a.a.i.a.m.a>) arrayList, true, "ignore_result_dispatch");
                return;
            }
            b.b.a.a.i.a.l.c.b("handler is null，ignore is true");
            return;
        }
        this.e.add(aVar);
        a(2);
    }

    private void a(b.b.a.a.i.a.m.a aVar, int i) {
        this.i.set(0);
        b.b.a.a.i.a.l.c.a("handleThreadMessage()");
        if (i == 0) {
            this.f = ((b.b.a.a.i.a.m.b) aVar).j();
            if (this.f != 6) {
                b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.d0(), 1);
                b(aVar);
                return;
            }
            return;
        }
        b.b.a.a.i.a.m.b bVar = (b.b.a.a.i.a.m.b) aVar;
        if (bVar.j() == 1) {
            this.f = 1;
            b(aVar);
        } else if (bVar.j() == 2) {
            b.b.a.a.i.a.l.c.a("before size:" + i);
            f();
            b.b.a.a.i.a.l.c.a("after size :" + i);
            this.f = 2;
            b(aVar);
        }
    }

    private void a(b.b.a.a.i.a.m.a aVar) {
        this.i.set(0);
        b.b.a.a.i.a.k.d dVar = b.b.a.a.i.a.k.d.g;
        if (dVar.f212b) {
            this.f = 5;
        } else if (dVar.c) {
            this.f = 7;
        } else {
            this.f = 4;
        }
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.n(), 1);
        this.c.a(aVar, this.f);
        b.b.a.a.i.a.l.a.k(aVar);
    }

    private void b(List<b.b.a.a.i.a.m.a> list) {
        if (list.size() != 0) {
            b.b.a.a.i.a.l.a.a(list, this.e.size());
            if (list.size() <= 1 && !b.b.a.a.i.a.l.a.d()) {
                b.b.a.a.i.a.m.a aVar = list.get(0);
                if (aVar != null) {
                    if (aVar.c() == 1) {
                        a(list, "highPriority");
                        b.b.a.a.i.a.l.c.b("PADLT", "Single high priority （ applog ）");
                        return;
                    }
                    if (aVar.f() == 0 && aVar.c() == 2) {
                        if (aVar.g() == 3) {
                            a(list, "version_v3");
                            return;
                        } else {
                            a(list);
                            return;
                        }
                    }
                    if (aVar.f() == 1) {
                        b.b.a.a.i.a.l.c.b("PADLT", "Stats batch report （ stats ）");
                        a(list, "stats");
                        return;
                    } else if (aVar.f() == 3) {
                        a(list, "adType_v3");
                        return;
                    } else if (aVar.f() == 2) {
                        b.b.a.a.i.a.l.c.b("PADLT", "Single high priority （ stats ）");
                        a(list, "other");
                        return;
                    } else {
                        b.b.a.a.i.a.l.c.a("upload adLogEvent adType error");
                        return;
                    }
                }
                b.b.a.a.i.a.l.c.a("upload adLogEvent is null");
                return;
            }
            b.b.a.a.i.a.l.c.b("PADLT", "Batch report（ local or stats ）");
            a(list, "batchRead");
            return;
        }
        c();
        b.b.a.a.i.a.l.c.a("upload list is empty");
    }

    private void a(List<b.b.a.a.i.a.m.a> list, String str) {
        a(str);
        a(list, false, str);
        a();
    }

    private void a(List<b.b.a.a.i.a.m.a> list) {
        this.l.addAll(list);
        b.b.a.a.i.a.l.c.b("PADLT", "a batch applog generation cur=" + this.l.size());
        f fVarA = i.f().a();
        if (fVarA != null && fVarA.h() != null) {
            o = fVarA.h().c();
        }
        if (this.l.size() >= o) {
            if (this.k.hasMessages(11)) {
                this.k.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.l);
            this.l.clear();
            a((List<b.b.a.a.i.a.m.a>) arrayList, false, "max_size_dispatch");
            a();
            b.b.a.a.i.a.l.c.b("PADLT", "batch applog report ( size ) " + o);
            return;
        }
        if (this.e.size() == 0) {
            a(false);
            if (this.k.hasMessages(11)) {
                this.k.removeMessages(11);
            }
            if (this.k.hasMessages(1)) {
                this.k.removeMessages(1);
            }
            long jB = p;
            if (fVarA != null && fVarA.h() != null) {
                jB = fVarA.h().b();
            }
            this.k.sendEmptyMessageDelayed(11, jB);
            b.b.a.a.i.a.l.c.b("PADLT", "batch applog report delay ( time )" + jB);
            return;
        }
        b.b.a.a.i.a.l.c.a("uploadBatchOptimize nothing：" + this.e.size() + "  " + this.a);
    }

    private void a(String str) {
        if (this.k.hasMessages(11)) {
            this.k.removeMessages(11);
        }
        if (this.l.size() != 0) {
            ArrayList arrayList = new ArrayList(this.l);
            this.l.clear();
            a((List<b.b.a.a.i.a.m.a>) arrayList, false, "before_" + str);
            a();
            b.b.a.a.i.a.l.c.c("PADLT", "applog batch reporting size = " + arrayList.size());
            return;
        }
        b.b.a.a.i.a.l.c.a("ensureUploadOptBatch empty：" + str);
    }

    private void a(List<b.b.a.a.i.a.m.a> list, boolean z, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        b.b.a.a.i.a.l.a.a(list, this.f, str);
        b.b.a.a.i.a.k.c cVarJ = i.f().j();
        this.d = cVarJ;
        if (cVarJ != null) {
            b(list, z, jCurrentTimeMillis);
        } else {
            a(list, z, jCurrentTimeMillis);
        }
    }

    private void a(List<b.b.a.a.i.a.m.a> list, boolean z, long j) {
        f fVarA = i.f().a();
        if (fVarA != null) {
            Executor executorB = fVarA.b();
            if (list.get(0).c() == 1) {
                executorB = fVarA.a();
            }
            if (executorB == null) {
                return;
            }
            this.j.incrementAndGet();
            executorB.execute(new a("csj_log_upload", list, z, j));
        }
    }

    private void b(List<b.b.a.a.i.a.m.a> list, boolean z, long j) {
        this.j.incrementAndGet();
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.K(), 1);
        try {
            this.d.a(list, new b(z, j));
        } catch (Exception e) {
            b.b.a.a.i.a.l.c.b("outer exception：" + e.getMessage());
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.I(), 1);
            this.j.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<b.b.a.a.i.a.m.a> list, boolean z, long j, int i) {
        b.b.a.a.i.a.k.g.b bVarA;
        try {
            b.b.a.a.i.a.m.a aVar = list.get(0);
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.K(), 1);
            if (aVar.f() == 0) {
                bVarA = i.g().a(list);
                a(bVarA, list);
                if (bVarA != null) {
                    b.b.a.a.i.a.l.a.a(list, bVarA.c);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<b.b.a.a.i.a.m.a> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().b());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    b.b.a.a.i.a.l.c.b("json exception:" + e.getMessage());
                }
                bVarA = i.g().a(jSONObject);
            }
            b.b.a.a.i.a.k.g.b bVar = bVarA;
            this.j.decrementAndGet();
            a(z, bVar, list, j);
        } catch (Throwable th) {
            b.b.a.a.i.a.l.c.b("inner exception:" + th.getMessage());
            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.I(), 1);
            this.j.decrementAndGet();
        }
    }

    private void a(int i) {
        if (!d()) {
            if (this.k == null) {
                return;
            }
            b.b.a.a.i.a.k.e.a aVar = b.b.a.a.i.a.k.d.h;
            b.b.a.a.i.a.l.b.a(aVar.N(), 1);
            if (this.k.hasMessages(1)) {
                return;
            }
            if (i == 1) {
                b.b.a.a.i.a.l.b.a(aVar.f(), 1);
            } else if (i == 2) {
                b.b.a.a.i.a.l.b.a(aVar.v(), 1);
            } else if (i == 3) {
                b.b.a.a.i.a.l.b.a(aVar.H(), 1);
            }
            this.k.sendEmptyMessage(1);
            return;
        }
        b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.w(), 1);
    }

    private void a(b.b.a.a.i.a.k.g.b bVar, List<b.b.a.a.i.a.m.a> list) {
        if (bVar == null || !bVar.a) {
            return;
        }
        List<b.b.a.a.i.a.e> listA = b.b.a.a.i.a.b.a();
        if (list == null || listA == null || listA.size() == 0) {
            return;
        }
        for (b.b.a.a.i.a.m.a aVar : list) {
            if (aVar.c() == 1) {
                String strC = b.b.a.a.i.a.l.a.c(aVar);
                String strE = b.b.a.a.i.a.l.a.e(aVar);
                for (b.b.a.a.i.a.e eVar : listA) {
                    if (eVar != null) {
                        eVar.a(strC, strE);
                    }
                }
            }
        }
    }

    private void a() {
        if (this.k.hasMessages(11)) {
            c();
        } else {
            a(1);
        }
        b.b.a.a.i.a.l.c.a("afterUpload message:" + this.f);
        b.b.a.a.i.a.k.e.a aVar = b.b.a.a.i.a.k.d.h;
        b.b.a.a.i.a.l.b.a(aVar.h(), 1);
        if (this.f != 2) {
            return;
        }
        b.b.a.a.i.a.l.b.a(aVar.e(), 1);
        synchronized (this.f218b) {
            try {
                try {
                    long jNanoTime = System.nanoTime();
                    this.f218b.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    StringBuilder sbAppend = new StringBuilder().append("afterUpload delta:").append(jNanoTime2).append(" start:").append(jNanoTime).append(" condition:");
                    b.b.a.a.i.a.k.d dVar = b.b.a.a.i.a.k.d.g;
                    b.b.a.a.i.a.l.c.a(sbAppend.append(dVar.f212b || dVar.c).toString());
                    if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                        if (!dVar.f212b && !dVar.c) {
                            b.b.a.a.i.a.l.c.d("afterUpload meet notifyRunOnce again");
                            b.b.a.a.i.a.l.b.a(aVar.g(), 1);
                            c(2);
                            return;
                        }
                        b.b.a.a.i.a.l.b.a(aVar.U(), 1);
                        b.b.a.a.i.a.l.c.b("afterUpload wait serverBusy");
                        return;
                    }
                    b.b.a.a.i.a.l.c.b("afterUpload wait timeout");
                    b.b.a.a.i.a.l.b.a(aVar.e0(), 1);
                } catch (InterruptedException e) {
                    b.b.a.a.i.a.l.c.b("wait exception:" + e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, b.b.a.a.i.a.k.g.b bVar, List<b.b.a.a.i.a.m.a> list, long j) {
        if (z || bVar == null) {
            return;
        }
        int i = bVar.f217b;
        int i2 = -2;
        if (bVar.d) {
            i = -1;
        } else if (i < 0) {
            i = -2;
        }
        if (i == 510 || i == 511) {
            i = -2;
        }
        if (bVar.a || ((i < 500 || i >= 509) && i <= 513)) {
            i2 = i;
        }
        if (list != null) {
            b.b.a.a.i.a.l.c.a("preprocessResult code is " + i2 + " sz:" + list.size() + "  count:" + this.j.get());
        }
        a(i2, list, j);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0087 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0091 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x009d A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d1 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00df A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f3 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0108 A[Catch: all -> 0x0156, TryCatch #0 {, blocks: (B:5:0x0005, B:8:0x000b, B:10:0x001d, B:12:0x0023, B:62:0x0110, B:64:0x0114, B:65:0x011e, B:23:0x003c, B:25:0x004f, B:26:0x0054, B:28:0x0056, B:30:0x0063, B:31:0x0068, B:33:0x006a, B:35:0x007d, B:36:0x0082, B:37:0x0087, B:39:0x008d, B:41:0x0091, B:43:0x009d, B:44:0x00a2, B:46:0x00aa, B:47:0x00af, B:48:0x00d1, B:50:0x00df, B:51:0x00e4, B:53:0x00e6, B:55:0x00f3, B:56:0x00f8, B:58:0x00fa, B:60:0x0108, B:61:0x010d, B:68:0x0154), top: B:73:0x0005 }] */
    private void a(int i, List<b.b.a.a.i.a.m.a> list, long j) {
        b.b.a.a.i.a.k.d dVar;
        h hVarH;
        synchronized (this.f218b) {
            if (list != null) {
                if (this.k != null) {
                    b.b.a.a.i.a.l.a.a(i, list, j);
                    this.c.a(i, list);
                    f fVarA = i.f().a();
                    if (fVarA != null && (hVarH = fVarA.h()) != null) {
                        hVarH.a(i, list);
                    }
                    if (i == -2) {
                        b.b.a.a.i.a.k.d dVar2 = b.b.a.a.i.a.k.d.g;
                        dVar2.f212b = false;
                        dVar2.c = true;
                        if (this.k.hasMessages(3)) {
                            b.b.a.a.i.a.l.c.a("already routine error message");
                            return;
                        } else {
                            if (System.currentTimeMillis() - this.h < 15000) {
                                b.b.a.a.i.a.l.c.a("already routine error,too short");
                                return;
                            }
                            this.h = System.currentTimeMillis();
                            if (this.k.hasMessages(2)) {
                                this.k.removeMessages(2);
                            }
                            a(3, 15000L);
                        }
                    } else if (i == -1) {
                        dVar = b.b.a.a.i.a.k.d.g;
                        if (!dVar.f212b || dVar.c) {
                            dVar.f212b = false;
                            dVar.c = false;
                            if (this.k.hasMessages(2)) {
                                this.k.removeMessages(2);
                            }
                            if (this.k.hasMessages(3)) {
                                this.k.removeMessages(3);
                            }
                            this.h = 0L;
                            this.g = 0L;
                            this.m.set(0);
                            this.n.set(0);
                            b.b.a.a.i.a.l.c.a("--dispatchResult flush--");
                            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.c0(), 1);
                            c(2);
                        }
                    } else if (i == 0) {
                        b.b.a.a.i.a.k.d dVar3 = b.b.a.a.i.a.k.d.g;
                        dVar3.f212b = false;
                        dVar3.c = true;
                        if (this.k.hasMessages(3)) {
                            b.b.a.a.i.a.l.c.a("already routine error message");
                            return;
                        } else {
                            if (System.currentTimeMillis() - this.h < 15000) {
                                b.b.a.a.i.a.l.c.a("already routine error,too short");
                                return;
                            }
                            this.h = System.currentTimeMillis();
                            if (this.k.hasMessages(2)) {
                                this.k.removeMessages(2);
                            }
                            a(3, 15000L);
                        }
                    } else if (i == 200) {
                        dVar = b.b.a.a.i.a.k.d.g;
                        if (!dVar.f212b) {
                            dVar.f212b = false;
                            dVar.c = false;
                            if (this.k.hasMessages(2)) {
                                this.k.removeMessages(2);
                            }
                            if (this.k.hasMessages(3)) {
                                this.k.removeMessages(3);
                            }
                            this.h = 0L;
                            this.g = 0L;
                            this.m.set(0);
                            this.n.set(0);
                            b.b.a.a.i.a.l.c.a("--dispatchResult flush--");
                            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.c0(), 1);
                            c(2);
                        } else {
                            dVar.f212b = false;
                            dVar.c = false;
                            if (this.k.hasMessages(2)) {
                                this.k.removeMessages(2);
                            }
                            if (this.k.hasMessages(3)) {
                                this.k.removeMessages(3);
                            }
                            this.h = 0L;
                            this.g = 0L;
                            this.m.set(0);
                            this.n.set(0);
                            b.b.a.a.i.a.l.c.a("--dispatchResult flush--");
                            b.b.a.a.i.a.l.b.a(b.b.a.a.i.a.k.d.h.c0(), 1);
                            c(2);
                        }
                    } else if (i == 509) {
                        b.b.a.a.i.a.k.d dVar4 = b.b.a.a.i.a.k.d.g;
                        dVar4.f212b = true;
                        dVar4.c = false;
                        b.b.a.a.i.a.l.c.a("-----------------  server busy start---------------- ");
                        if (this.k.hasMessages(2)) {
                            b.b.a.a.i.a.l.c.a("already server busy message");
                            return;
                        }
                        if (System.currentTimeMillis() - this.g < 30000) {
                            b.b.a.a.i.a.l.c.a("already server busy，too short");
                            return;
                        }
                        this.g = System.currentTimeMillis();
                        b.b.a.a.i.a.l.c.a("-----------------  server busy send---------------- ");
                        if (this.k.hasMessages(3)) {
                            this.k.removeMessages(3);
                        }
                        a(2, 30000L);
                    }
                    if (this.f == 2) {
                        b.b.a.a.i.a.l.c.a("send notify");
                        this.f218b.notify();
                    }
                    b.b.a.a.i.a.l.c.c("upload thread reuse or close: " + this.a + " queue:" + this.e.size() + " " + this.f);
                }
            }
        }
    }

    public void a(int i, long j) {
        if (this.k == null) {
            b.b.a.a.i.a.l.c.b("mHandler == null");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        if (i == 2) {
            int iIncrementAndGet = this.m.incrementAndGet();
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            b.b.a.a.i.a.l.c.a("sendMonitorMessage:" + i + "  busy:" + iIncrementAndGet + "  l:" + j2);
            this.k.sendMessageDelayed(messageObtain, j2);
            return;
        }
        if (i == 3) {
            int iIncrementAndGet2 = this.n.incrementAndGet();
            b.b.a.a.i.a.l.c.a("sendMonitorMessage:" + i + "  error:" + iIncrementAndGet2);
            this.k.sendMessageDelayed(messageObtain, ((long) (((iIncrementAndGet2 - 1) % 4) + 1)) * j);
            return;
        }
        b.b.a.a.i.a.l.c.b("sendMonitorMessage error state");
    }
}
