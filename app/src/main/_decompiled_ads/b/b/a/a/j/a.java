package b.b.a.a.j;

import android.content.Context;
import b.b.a.a.f.a.h;
import b.b.a.a.f.a.j;
import b.b.a.a.j.d.d;
import b.b.a.a.j.e.f;
import b.b.a.a.j.e.g;
import com.bytedance.sdk.component.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: NetClient.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f230b;
    private int c;

    /* JADX INFO: compiled from: NetClient.java */
    public static final class b {
        boolean d = true;
        final List<h> e = new ArrayList();
        int a = 10000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f231b = 10000;
        int c = 10000;

        public b a(long j, TimeUnit timeUnit) {
            this.a = a("timeout", j, timeUnit);
            return this;
        }

        public b b(long j, TimeUnit timeUnit) {
            this.f231b = a("timeout", j, timeUnit);
            return this;
        }

        public b c(long j, TimeUnit timeUnit) {
            this.c = a("timeout", j, timeUnit);
            return this;
        }

        public b a(boolean z) {
            this.d = z;
            return this;
        }

        private static int a(String str, long j, TimeUnit timeUnit) {
            if (j >= 0) {
                Objects.requireNonNull(timeUnit, "unit == null");
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                }
                if (millis != 0 || j <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(str + " too small.");
            }
            throw new IllegalArgumentException(str + " < 0");
        }

        public a a() {
            return new a(this);
        }
    }

    public static void e() {
        b.b.a.a.j.f.b.a(b.b.a.a.j.f.b.EnumC0046b.DEBUG);
    }

    public void a(Context context, boolean z, b.b.a.a.j.e.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iE = bVar.e();
        this.c = iE;
        f fVar = this.f230b;
        if (fVar != null) {
            fVar.a(iE);
        }
        g.a().a(this.c).b(z);
        g.a().a(this.c).a(bVar);
        g.a().a(this.c).a(context, r.c(context));
    }

    public b.b.a.a.j.d.b b() {
        return new b.b.a.a.j.d.b(this.a);
    }

    public j c() {
        return this.a;
    }

    public d d() {
        return new d(this.a);
    }

    private a(b bVar) {
        j.a aVar = new j.a();
        long j = bVar.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        j.a aVarB = aVar.a(j, timeUnit).c(bVar.c, timeUnit).b(bVar.f231b, timeUnit);
        if (bVar.d) {
            f fVar = new f();
            this.f230b = fVar;
            aVarB.a(fVar);
        }
        List<h> list = bVar.e;
        if (list != null && list.size() > 0) {
            Iterator<h> it = bVar.e.iterator();
            while (it.hasNext()) {
                aVarB.a(it.next());
            }
        }
        this.a = aVarB.a();
    }

    public void a(Context context, boolean z) {
        b.b.a.a.j.e.a.a(true);
        if (a(context) || (!r.c(context) && z)) {
            g.a().a(this.c, context).g();
            g.a().a(this.c, context).i();
        }
        if (r.c(context)) {
            g.a().a(this.c, context).g();
            g.a().a(this.c, context).i();
        }
    }

    public b.b.a.a.j.d.a a() {
        return new b.b.a.a.j.d.a(this.a);
    }

    private static boolean a(Context context) {
        String strA = r.a(context);
        return strA != null && (strA.endsWith(":push") || strA.endsWith(":pushservice"));
    }
}
