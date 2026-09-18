package b.b.a.a.j.e;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: TncInstanceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private static volatile g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<Integer, e> f242b;
    private static HashMap<Integer, a> c;

    private g() {
        f242b = new HashMap<>();
        c = new HashMap<>();
    }

    public static synchronized g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    public e a(int i) {
        e eVar = f242b.get(Integer.valueOf(i));
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(i);
        f242b.put(Integer.valueOf(i), eVar2);
        return eVar2;
    }

    public a a(int i, Context context) {
        a aVar = c.get(Integer.valueOf(i));
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(context, i);
        c.put(Integer.valueOf(i), aVar2);
        return aVar2;
    }
}
