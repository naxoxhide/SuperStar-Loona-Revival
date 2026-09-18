package b.b.a.a.f.a;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class o implements Closeable {
    public abstract InputStream a();

    public abstract byte[] b();

    public abstract long c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract String d();
}
