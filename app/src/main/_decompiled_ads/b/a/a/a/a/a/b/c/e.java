package b.a.a.a.a.a.b.c;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.component.utils.m;
import java.util.Set;

/* JADX INFO: compiled from: Proxy.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    static volatile b.a.a.a.a.a.b.c.l.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile b.a.a.a.a.a.b.c.l.c f37b;
    private static volatile b.a.a.a.a.a.b.c.m.c c;
    private static volatile Context e;
    public static volatile boolean f;
    static volatile boolean h;
    public static volatile Integer k;
    public static final boolean d = m.c();
    static volatile boolean g = true;
    static volatile int i = 0;
    public static volatile int j = 3;

    public static Context b() {
        return e;
    }

    public static b.a.a.a.a.a.b.c.l.b c() {
        return a;
    }

    public static b.a.a.a.a.a.b.c.l.c d() {
        return f37b;
    }

    /* JADX INFO: compiled from: Proxy.java */
    static class a implements b.a.a.a.a.a.b.c.l.c.f {
        a() {
        }

        @Override // b.a.a.a.a.a.b.c.l.c.f
        public void a(String str) {
            if (e.d) {
                Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
            }
        }

        @Override // b.a.a.a.a.a.b.c.l.c.f
        public void a(Set<String> set) {
            e.c.a(set, 0);
            if (e.d) {
                Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
            }
        }
    }

    public static void a(boolean z) {
        g = z;
    }

    public static void b(boolean z) {
        h = z;
    }

    public static void a(int i2) {
        i = i2;
    }

    public static void a(b.a.a.a.a.a.b.c.l.c cVar, Context context) {
        if (cVar != null && context != null) {
            e = context.getApplicationContext();
            if (f37b != null) {
                return;
            }
            b.a.a.a.a.a.b.c.l.b bVar = a;
            if (bVar != null && bVar.a.getAbsolutePath().equals(cVar.a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            f37b = cVar;
            c = b.a.a.a.a.a.b.c.m.c.a(context);
            f37b.a(new a());
            f fVarF = f.f();
            fVarF.a(cVar);
            fVarF.a(c);
            d dVarD = d.d();
            dVarD.a(cVar);
            dVarD.a(c);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }
}
