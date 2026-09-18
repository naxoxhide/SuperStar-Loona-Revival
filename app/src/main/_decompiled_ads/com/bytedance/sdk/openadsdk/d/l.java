package com.bytedance.sdk.openadsdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: OpenAppSuccEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    private static volatile l f;
    private HandlerThread a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f723b;
    private final Executor c = Executors.newCachedThreadPool();
    private c d = c.a();
    private Map<String, Object> e;

    /* JADX INFO: compiled from: OpenAppSuccEvent.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 100) {
                return true;
            }
            b bVar = null;
            Object obj = message.obj;
            if (obj != null && (obj instanceof b)) {
                bVar = (b) obj;
            }
            if (bVar == null) {
                return true;
            }
            l.this.b(bVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: OpenAppSuccEvent.java */
    private static class b implements Runnable, Serializable {
        public final AtomicInteger a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f724b = new AtomicBoolean(false);
        public q c;
        public String d;
        public Map<String, Object> e;

        public b(q qVar, String str, Map<String, Object> map) {
            this.c = qVar;
            this.d = str;
            this.e = map;
        }

        public static b a(q qVar, String str, Map<String, Object> map) {
            return new b(qVar, str, map);
        }

        public void b() {
            this.a.incrementAndGet();
        }

        public int c() {
            return this.a.get();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d)) {
                com.bytedance.sdk.component.utils.m.a("materialMeta or eventTag is null, pls check");
                return;
            }
            String str = this.f724b.get() ? "dpl_success" : "dpl_failed";
            if (this.e == null) {
                this.e = new HashMap();
            }
            q qVar = this.c;
            if (qVar != null && qVar.G() == 0) {
                Map<String, Object> map = this.e;
                q qVar2 = this.c;
                map.put("auto_click", Boolean.valueOf((qVar2 == null || qVar2.b1()) ? false : true));
            }
            this.e.put("lifeCycleInit", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.m.a().d()));
            com.bytedance.sdk.openadsdk.d.c.a(this.c, this.d, str, this.e);
        }

        public b a(boolean z) {
            this.f724b.set(z);
            return this;
        }
    }

    /* JADX INFO: compiled from: OpenAppSuccEvent.java */
    private static class c {
        public int a = 500;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f725b = 5000;

        private c() {
        }

        public static c a() {
            return new c();
        }
    }

    private l() {
        if (this.a == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.a = handlerThread;
            handlerThread.start();
        }
        this.f723b = new Handler(this.a.getLooper(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        if (a0.v()) {
            a(bVar);
        } else {
            c(bVar.a(true));
        }
    }

    private void c(b bVar) {
        if (bVar == null) {
            return;
        }
        this.c.execute(bVar);
    }

    public static l a() {
        if (f == null) {
            synchronized (l.class) {
                if (f == null) {
                    f = new l();
                }
            }
        }
        return f;
    }

    public l a(Map<String, Object> map) {
        this.e = map;
        return a();
    }

    public void a(q qVar, String str) {
        Message messageObtainMessage = this.f723b.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = b.a(qVar, str, this.e);
        messageObtainMessage.sendToTarget();
    }

    private void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.b();
        int iC = bVar.c();
        c cVar = this.d;
        if (iC * cVar.a > cVar.f725b) {
            c(bVar.a(false));
            return;
        }
        Message messageObtainMessage = this.f723b.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = bVar;
        this.f723b.sendMessageDelayed(messageObtainMessage, this.d.a);
    }
}
