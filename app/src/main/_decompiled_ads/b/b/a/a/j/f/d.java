package b.b.a.a.j.f;

import android.util.Log;
import com.bytedance.sdk.component.utils.m;

/* JADX INFO: compiled from: NLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f245b = 4;

    public static boolean a() {
        return a;
    }

    public static void b(String str, String str2) {
        if (a && str2 != null && f245b <= 2) {
            Log.v(m.c(str), str2);
        }
    }

    public static void a(String str) {
        b("NetLog", str);
    }

    public static void a(String str, String str2) {
        if (a && str2 != null && f245b <= 4) {
            Log.i(m.c(str), str2);
        }
    }
}
