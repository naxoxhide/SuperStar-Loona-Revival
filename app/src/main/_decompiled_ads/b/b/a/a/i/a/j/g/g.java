package b.b.a.a.i.a.j.g;

import b.b.a.a.i.a.i;

/* JADX INFO: compiled from: TTPathConst.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a = "com.bytedance.openadsdk";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f209b = "content://" + a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (i.f().c() != null) {
            a = i.f().c().getPackageName();
            f209b = "content://" + a + ".TTMultiProvider";
        }
    }
}
