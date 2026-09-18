package b.b.a.a.h.x.k;

import java.io.Closeable;

/* JADX INFO: compiled from: IOUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
