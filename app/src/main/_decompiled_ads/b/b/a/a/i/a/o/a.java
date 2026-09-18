package b.b.a.a.i.a.o;

import b.b.a.a.i.a.i;

/* JADX INFO: compiled from: MyTrack.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile b a;

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new c(i.f().c(), new f(i.f().c()));
                }
            }
        }
        return a;
    }
}
