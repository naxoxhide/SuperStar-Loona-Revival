package b.a.a.a.a.a.b.c;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.security.CertificateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ProxyServer.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static volatile f m;
    private volatile ServerSocket a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f38b;
    private final AtomicInteger c = new AtomicInteger(0);
    private volatile b.a.a.a.a.a.b.c.m.c d;
    private volatile b.a.a.a.a.a.b.c.l.c e;
    private volatile b.a.a.a.a.a.b.c.l.b f;
    private final SparseArray<Set<g>> g;
    private final g.e h;
    private volatile b.a.a.a.a.a.b.c.c i;
    private volatile b.a.a.a.a.a.b.c.c j;
    private final Runnable k;
    private final AtomicBoolean l;

    /* JADX INFO: compiled from: ProxyServer.java */
    class a implements g.e {
        a() {
        }

        @Override // b.a.a.a.a.a.b.c.g.e
        public void a(g gVar) {
            if (e.d) {
                Log.d("ProxyServer", "afterExecute, ProxyTask: " + gVar);
            }
            int iD = gVar.d();
            synchronized (f.this.g) {
                Set set = (Set) f.this.g.get(iD);
                if (set != null) {
                    set.remove(gVar);
                }
            }
        }

        @Override // b.a.a.a.a.a.b.c.g.e
        public void b(g gVar) {
            synchronized (f.this.g) {
                Set set = (Set) f.this.g.get(gVar.d());
                if (set != null) {
                    set.add(gVar);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ProxyServer.java */
    class b implements Runnable {

        /* JADX INFO: compiled from: ProxyServer.java */
        class a extends b.b.a.a.k.g {
            final /* synthetic */ g c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(b bVar, String str, int i, g gVar) {
                super(str, i);
                this.c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.c.run();
            }
        }

        b() {
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0111  */
        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = 0;
                f.this.a = new ServerSocket(0, 50, InetAddress.getByName(f.this.g()));
                f fVar = f.this;
                fVar.f38b = fVar.a.getLocalPort();
                if (f.this.f38b == -1) {
                    f.b("socket not bound", "");
                    f.this.c();
                    return;
                }
                j.a(f.this.g(), f.this.f38b);
                if (f.this.h()) {
                    b.a.a.a.a.a.a.i.c.b("ProxyServer", "run:  state = ", f.this.c);
                    if (f.this.c.compareAndSet(0, 1)) {
                        b.a.a.a.a.a.a.i.c.b("ProxyServer", "run:  state = ", f.this.c);
                        if (e.d) {
                            b.a.a.a.a.a.a.i.c.c("ProxyServer", "proxy server start!");
                        }
                        while (f.this.c.get() == 1) {
                            try {
                                try {
                                    Socket socketAccept = f.this.a.accept();
                                    b.a.a.a.a.a.b.c.m.c cVar = f.this.d;
                                    if (cVar != null) {
                                        b.b.a.a.k.e.d().execute(new a(this, "ProxyTask", 10, new g.c().a(cVar).a(socketAccept).a(f.this.h).a()));
                                    } else {
                                        b.a.a.a.a.a.b.d.a.a(socketAccept);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    f.b("accept error", Log.getStackTraceString(e));
                                    i++;
                                    if (i > 3) {
                                        if (e.d) {
                                            b.a.a.a.a.a.a.i.c.c("ProxyServer", "proxy server closed!");
                                        }
                                        f.this.c();
                                    }
                                }
                            } catch (Throwable th) {
                                String stackTraceString = Log.getStackTraceString(th);
                                Log.e("ProxyServer", "proxy server crashed!  " + stackTraceString);
                                f.b("error", stackTraceString);
                            }
                        }
                        if (e.d) {
                            b.a.a.a.a.a.a.i.c.c("ProxyServer", "proxy server closed!");
                        }
                        f.this.c();
                    }
                }
            } catch (IOException e2) {
                if (e.d) {
                    Log.e("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e2));
                }
                f.b("create ServerSocket error", Log.getStackTraceString(e2));
                f.this.c();
            }
        }
    }

    /* JADX INFO: compiled from: ProxyServer.java */
    private static final class c implements Callable<Boolean> {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f39b;

        c(String str, int i) {
            this.a = str;
            this.f39b = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            Throwable th;
            Socket socket;
            try {
                b.a.a.a.a.a.a.i.c.c("ProxyServer", "call: ");
                socket = new Socket(this.a, this.f39b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(b.a.a.a.a.a.b.d.a.f58b));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        Boolean bool = Boolean.TRUE;
                        b.a.a.a.a.a.b.d.a.a(socket);
                        return bool;
                    }
                    b.a.a.a.a.a.b.d.a.a(socket);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        b.a.a.a.a.a.a.i.c.c("ProxyServer", "call: " + th.getMessage());
                        f.b("ping error", Log.getStackTraceString(th));
                    } finally {
                        b.a.a.a.a.a.b.d.a.a(socket);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                socket = null;
            }
            return Boolean.FALSE;
        }
    }

    private f() {
        SparseArray<Set<g>> sparseArray = new SparseArray<>(2);
        this.g = sparseArray;
        this.h = new a();
        this.k = new b();
        this.l = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.g) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                SparseArray<Set<g>> sparseArray = this.g;
                Set<g> set = sparseArray.get(sparseArray.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c.compareAndSet(1, 2) || this.c.compareAndSet(0, 2)) {
            b.a.a.a.a.a.b.d.a.a(this.a);
            b();
        }
    }

    public static f f() {
        if (m == null) {
            synchronized (f.class) {
                if (m == null) {
                    m = new f();
                }
            }
        }
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean h() {
        b.b.a.a.k.f fVar = new b.b.a.a.k.f(new c(g(), this.f38b), 5, 1);
        b.b.a.a.k.e.d().submit(fVar);
        a();
        try {
            if (((Boolean) fVar.get()).booleanValue()) {
                b.a.a.a.a.a.a.i.c.c("ProxyServer", "pingTest: ");
                if (e.d) {
                    b.a.a.a.a.a.a.i.c.c("ProxyServer", "Ping OK!");
                }
                return true;
            }
            Log.e("ProxyServer", "Ping error");
            b("ping error", "");
            c();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            b("ping error", Log.getStackTraceString(th));
            c();
            return false;
        }
    }

    b.a.a.a.a.a.b.c.c d() {
        return this.i;
    }

    b.a.a.a.a.a.b.c.c e() {
        return this.j;
    }

    public void i() {
        if (this.l.compareAndSet(false, true)) {
            Thread thread = new Thread(this.k);
            thread.setName("csj_proxy_server");
            thread.start();
        }
    }

    boolean a(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.g) {
            Set<g> set = this.g.get(i);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.h)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    void a(b.a.a.a.a.a.b.c.m.c cVar) {
        this.d = cVar;
    }

    void a(b.a.a.a.a.a.b.c.l.c cVar) {
        this.e = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        String str2;
        if (strArr != null && strArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                b(SDKConstants.PARAM_KEY, "key is empty");
                return strArr[0];
            }
            if (this.d == null) {
                b(UserDataStore.DATE_OF_BIRTH, "VideoProxyDB is null");
                return strArr[0];
            }
            if ((z ? this.f : this.e) == null) {
                b("cache", "Cache is null");
                return strArr[0];
            }
            int i = this.c.get();
            if (i != 1) {
                b("state", "ProxyServer is not running, " + i);
                return strArr[0];
            }
            List<String> listA = b.a.a.a.a.a.b.d.a.a(strArr);
            if (listA == null) {
                b("url", "url not start with http/https");
                return strArr[0];
            }
            String strA = i.a(str, z2 ? str : b.a.a.a.a.a.a.i.b.a(str), listA);
            if (strA == null) {
                b("url", "combine proxy url error");
                return strArr[0];
            }
            if (z) {
                str2 = "https://" + g() + CertificateUtil.DELIMITER + this.f38b + "?f=1&" + strA;
            } else {
                str2 = "https://" + g() + CertificateUtil.DELIMITER + this.f38b + "?" + strA;
            }
            return str2.replaceFirst("s", "");
        }
        b("url", "url is empty");
        return null;
    }

    private void a() {
        Socket socketAccept = null;
        try {
            socketAccept = this.a.accept();
            socketAccept.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socketAccept.getInputStream())).readLine())) {
                OutputStream outputStream = socketAccept.getOutputStream();
                outputStream.write("OK\n".getBytes(b.a.a.a.a.a.b.d.a.f58b));
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            b("ping error", Log.getStackTraceString(e));
        } finally {
            b.a.a.a.a.a.b.d.a.a(socketAccept);
        }
        b.a.a.a.a.a.a.i.c.c("ProxyServer", "answerPing: ");
    }
}
