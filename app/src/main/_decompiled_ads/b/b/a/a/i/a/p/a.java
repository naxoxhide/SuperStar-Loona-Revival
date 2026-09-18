package b.b.a.a.i.a.p;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: TimerUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile HandlerThread a = new HandlerThread("csj_ad_log", 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f229b = null;
    private static int c = 3000;

    static {
        a.start();
    }

    public static Handler a() {
        if (a == null || !a.isAlive()) {
            synchronized (a.class) {
                if (a == null || !a.isAlive()) {
                    a = new HandlerThread("csj_init_handle", -1);
                    a.start();
                    f229b = new Handler(a.getLooper());
                }
            }
        } else if (f229b == null) {
            synchronized (a.class) {
                if (f229b == null) {
                    f229b = new Handler(a.getLooper());
                }
            }
        }
        return f229b;
    }

    public static int b() {
        if (c <= 0) {
            c = 3000;
        }
        return c;
    }
}
