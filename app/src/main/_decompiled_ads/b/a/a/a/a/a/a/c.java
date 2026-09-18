package b.a.a.a.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.a.f.a.j;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: VideoConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static Context a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f20b = null;
    private static boolean c = false;
    private static j d = null;
    private static int e = 1;
    public static boolean f = false;

    public static Context a() {
        return a;
    }

    public static j b() {
        if (d == null) {
            j.a aVar = new j.a("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            d = aVar.a(10000L, timeUnit).b(10000L, timeUnit).c(10000L, timeUnit).a();
        }
        return d;
    }

    public static int c() {
        return e;
    }

    public static String d() {
        if (TextUtils.isEmpty(f20b)) {
            try {
                File file = new File(a().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                f20b = file.getAbsolutePath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f20b;
    }

    public static boolean e() {
        return f;
    }

    public static boolean f() {
        return c;
    }

    public static void a(Context context, String str) {
        a = context;
        f20b = str;
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void a(j jVar) {
        d = jVar;
    }

    public static void a(int i) {
        e = i;
    }
}
