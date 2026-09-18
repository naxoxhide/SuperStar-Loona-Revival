package b.b.a.a.i.a;

/* JADX INFO: compiled from: AssertUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        a(str);
        throw null;
    }

    public static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}
