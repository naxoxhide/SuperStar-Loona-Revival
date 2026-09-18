package b.b.a.a.j.f;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private EnumC0046b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f243b;

    /* JADX INFO: renamed from: b.b.a.a.j.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Logger.java */
    public enum EnumC0046b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* JADX INFO: compiled from: Logger.java */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* JADX INFO: compiled from: Logger.java */
    private static class d {
        private static final b a = new b();
    }

    public static void a(EnumC0046b enumC0046b) {
        synchronized (b.class) {
            d.a.a = enumC0046b;
        }
    }

    public static void b(String str, String str2) {
        if (d.a.a.compareTo(EnumC0046b.ERROR) <= 0) {
            d.a.f243b.a(str, str2);
        }
    }

    private b() {
        this.a = EnumC0046b.OFF;
        this.f243b = new b.b.a.a.j.f.a();
    }

    public static void a(String str, String str2) {
        if (d.a.a.compareTo(EnumC0046b.DEBUG) <= 0) {
            d.a.f243b.b(str, str2);
        }
    }
}
