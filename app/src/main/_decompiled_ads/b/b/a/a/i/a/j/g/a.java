package b.b.a.a.i.a.j.g;

import android.content.Context;

/* JADX INFO: compiled from: DBAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {
    private static volatile a c;

    private a(Context context) {
        super(context);
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }
}
