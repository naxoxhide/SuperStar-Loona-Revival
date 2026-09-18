package b.b.a.a.j.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.common.AdConstants;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.y;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements y.a {
    private static boolean m;
    private static ThreadPoolExecutor n;
    private final boolean a;
    private final Context h;
    private b.b.a.a.j.a j;
    private int k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f237b = false;
    private boolean c = true;
    private boolean d = false;
    private long e = 0;
    private long f = 0;
    private AtomicBoolean g = new AtomicBoolean(false);
    private volatile boolean i = false;
    final y l = b.b.a.a.k.i.a.a().b(this, "tt-net");

    /* JADX INFO: renamed from: b.b.a.a.j.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppConfig.java */
    class RunnableC0045a implements Runnable {
        RunnableC0045a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f();
        }
    }

    /* JADX INFO: compiled from: AppConfig.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zA = b.b.a.a.j.f.e.a(a.this.h);
            if (zA) {
                a.this.f = System.currentTimeMillis();
                if (a.this.g.compareAndSet(false, true)) {
                    a.this.d(zA);
                } else {
                    b.b.a.a.j.f.b.a("TNCManager", "doRefresh, already running");
                }
            }
        }
    }

    public a(Context context, int i) {
        this.h = context;
        this.a = r.c(context);
        this.k = i;
    }

    private void c(boolean z) {
        if (this.d) {
            return;
        }
        if (this.c) {
            this.c = false;
            this.e = 0L;
            this.f = 0L;
        }
        long j = z ? 360000L : 43200000L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.e > j) {
            if (jCurrentTimeMillis - this.f > AdConstants.MEDIATION_CUSTOM_EVENT_TIMEOUT || !this.i) {
                a();
            }
        }
    }

    public static ThreadPoolExecutor e() {
        if (n == null) {
            synchronized (a.class) {
                if (n == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    n = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return n;
    }

    void d(boolean z) {
        b.b.a.a.j.f.b.a("TNCManager", "doRefresh, actual request");
        g();
        this.d = true;
        if (!z) {
            this.l.sendEmptyMessage(102);
            return;
        }
        try {
            c();
        } catch (Exception unused) {
            this.g.set(false);
        }
    }

    synchronized void f() {
        if (System.currentTimeMillis() - this.e > 3600000) {
            this.e = System.currentTimeMillis();
            try {
                if (g.a().a(this.k).d() != null) {
                    g.a().a(this.k).d().c();
                }
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void g() {
        if (this.i) {
            return;
        }
        this.i = true;
        long j = this.h.getSharedPreferences("ss_app_config", 0).getLong("last_refresh_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j > jCurrentTimeMillis) {
            j = jCurrentTimeMillis;
        }
        this.e = j;
        try {
            if (g.a().a(this.k).d() != null) {
                g.a().a(this.k).d().b();
            }
        } catch (Exception unused) {
        }
    }

    public void h() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            if (this.a) {
                g();
            } else {
                f();
            }
        } catch (Throwable unused) {
        }
    }

    public void i() {
        b(false);
    }

    public synchronized void b(boolean z) {
        if (this.a) {
            c(z);
        } else if (this.e <= 0) {
            try {
                e().execute(new RunnableC0045a());
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z) {
        m = z;
    }

    public static void a(Context context, int i) {
        a aVarA;
        if (m && (aVarA = g.a().a(i, context)) != null) {
            if (r.c(context)) {
                aVarA.b(true);
            } else {
                aVarA.i();
            }
        }
    }

    public String[] b() {
        String[] strArrA = g.a().a(this.k).b() != null ? g.a().a(this.k).b().a() : null;
        return (strArrA == null || strArrA.length <= 0) ? new String[0] : strArrA;
    }

    private b.b.a.a.j.a d() {
        if (this.j == null) {
            b.b.a.a.j.a.b bVar = new b.b.a.a.j.a.b();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            this.j = bVar.a(10L, timeUnit).b(10L, timeUnit).c(10L, timeUnit).a();
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        y yVar = this.l;
        if (yVar != null) {
            yVar.sendEmptyMessage(i);
        }
    }

    private boolean c() {
        String[] strArrB = b();
        if (strArrB != null && strArrB.length != 0) {
            a(0);
        }
        return false;
    }

    public boolean a() {
        b.b.a.a.j.f.b.a("TNCManager", "doRefresh: updating state " + this.g.get());
        e().execute(new b());
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.y.a
    public void a(Message message) {
        int i = message.what;
        if (i == 101) {
            this.d = false;
            this.e = System.currentTimeMillis();
            b.b.a.a.j.f.b.a("TNCManager", "doRefresh, succ");
            if (this.c) {
                i();
            }
            this.g.set(false);
            return;
        }
        if (i != 102) {
            return;
        }
        this.d = false;
        if (this.c) {
            i();
        }
        b.b.a.a.j.f.b.a("TNCManager", "doRefresh, error");
        this.g.set(false);
    }

    /* JADX INFO: compiled from: AppConfig.java */
    class c extends b.b.a.a.j.c.a {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, b.b.a.a.j.b bVar) {
            JSONObject jSONObject;
            if (bVar == null || !bVar.g()) {
                a.this.a(this.a + 1);
                return;
            }
            String string = null;
            try {
                jSONObject = new JSONObject(bVar.a());
            } catch (Exception unused) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                a.this.a(this.a + 1);
                return;
            }
            try {
                string = jSONObject.getString("message");
            } catch (Exception unused2) {
            }
            if (!"success".equals(string)) {
                a.this.a(this.a + 1);
                return;
            }
            try {
                if (a.this.a(jSONObject)) {
                    a.this.b(101);
                } else {
                    a.this.a(this.a + 1);
                }
            } catch (Exception unused3) {
            }
        }

        @Override // b.b.a.a.j.c.a
        public void a(b.b.a.a.j.d.c cVar, IOException iOException) {
            a.this.a(this.a + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Object obj) throws Exception {
        JSONObject jSONObject;
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            jSONObject = new JSONObject(str);
            if (!"success".equals(jSONObject.getString("message"))) {
                return false;
            }
        } else {
            jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
        }
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        synchronized (this) {
            SharedPreferences.Editor editorEdit = this.h.getSharedPreferences("ss_app_config", 0).edit();
            editorEdit.putLong("last_refresh_time", System.currentTimeMillis());
            editorEdit.apply();
        }
        if (g.a().a(this.k).d() == null) {
            return true;
        }
        g.a().a(this.k).d().a(jSONObject2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String[] strArrB = b();
        if (strArrB != null && strArrB.length > i) {
            String str = strArrB[i];
            if (TextUtils.isEmpty(str)) {
                b(102);
                return;
            }
            try {
                String strA = a(str);
                if (TextUtils.isEmpty(strA)) {
                    b(102);
                    return;
                }
                b.b.a.a.j.d.b bVarB = d().b();
                bVarB.b(strA);
                a(bVarB);
                bVarB.a(new c(i));
                return;
            } catch (Throwable th) {
                b.b.a.a.j.f.b.a("AppConfig", "try app config exception: " + th);
                return;
            }
        }
        b(102);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://").append(str).append("/get_domains/v4/");
        return sb.toString();
    }

    private void a(b.b.a.a.j.d.b bVar) {
        String str;
        if (bVar == null) {
            return;
        }
        Address addressA = g.a().a(this.k).b() != null ? g.a().a(this.k).b().a(this.h) : null;
        if (addressA != null && addressA.hasLatitude() && addressA.hasLongitude()) {
            bVar.b("latitude", addressA.getLatitude() + "");
            bVar.b("longitude", addressA.getLongitude() + "");
            String locality = addressA.getLocality();
            if (!TextUtils.isEmpty(locality)) {
                bVar.b("city", Uri.encode(locality));
            }
        }
        if (this.f237b) {
            bVar.b("force", "1");
        }
        try {
            if (Build.VERSION.SDK_INT < 21) {
                str = Build.CPU_ABI;
            } else {
                str = Build.SUPPORTED_ABIS[0];
            }
            bVar.b("abi", str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (g.a().a(this.k).b() != null) {
            bVar.b("aid", g.a().a(this.k).b().e() + "");
            bVar.b("device_platform", g.a().a(this.k).b().d());
            bVar.b("channel", g.a().a(this.k).b().f());
            bVar.b("version_code", g.a().a(this.k).b().b() + "");
            bVar.b("custom_info_1", g.a().a(this.k).b().c());
        }
    }

    public static void a(ThreadPoolExecutor threadPoolExecutor) {
        n = threadPoolExecutor;
    }
}
