package b.a.a.a.a.a.b.b;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import b.a.a.a.a.a.b.b.b.b;
import b.a.a.a.a.a.b.b.b.c;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SdkMediaDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends MediaDataSource {
    public static final ConcurrentHashMap<String, a> e = new ConcurrentHashMap<>();
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f28b = -2147483648L;
    private final Context c;
    private final b.a.a.a.a.a.a.f.c d;

    public a(Context context, b.a.a.a.a.a.a.f.c cVar) {
        this.c = context;
        this.d = cVar;
        this.a = new b(context, cVar);
    }

    public b.a.a.a.a.a.a.f.c a() {
        return this.d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b.a.a.a.a.a.a.i.c.b("SdkMediaDataSource", "close: ", this.d.m());
        c cVar = this.a;
        if (cVar != null) {
            cVar.close();
        }
        e.remove(this.d.e());
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.f28b == -2147483648L) {
            if (this.c == null || TextUtils.isEmpty(this.d.m())) {
                return -1L;
            }
            this.f28b = this.a.length();
            b.a.a.a.a.a.a.i.c.c("SdkMediaDataSource", "getSize: " + this.f28b);
        }
        return this.f28b;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        int iA = this.a.a(j, bArr, i, i2);
        b.a.a.a.a.a.a.i.c.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + iA + "  current = " + Thread.currentThread());
        return iA;
    }

    public static a a(Context context, b.a.a.a.a.a.a.f.c cVar) {
        a aVar = new a(context, cVar);
        e.put(cVar.e(), aVar);
        return aVar;
    }
}
