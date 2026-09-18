package b.b.a.a.h.x.i;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* JADX INFO: compiled from: CacheConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.b.a.a.h.b, Cloneable {
    private static volatile b.b.a.a.h.b f;
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f179b;
    private boolean c;
    private boolean d;
    private File e;

    public a(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    private static long g() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static b.b.a.a.h.b h() {
        return f;
    }

    @Override // b.b.a.a.h.b
    public boolean a() {
        return this.c;
    }

    @Override // b.b.a.a.h.b
    public File c() {
        return this.e;
    }

    @Override // b.b.a.a.h.b
    public long d() {
        return this.a;
    }

    @Override // b.b.a.a.h.b
    public boolean e() {
        return this.d;
    }

    @Override // b.b.a.a.h.b
    public int f() {
        return this.f179b;
    }

    public a(int i, long j, boolean z, boolean z2, File file) {
        this.a = j;
        this.f179b = i;
        this.c = z;
        this.d = z2;
        this.e = file;
    }

    public static void a(Context context, b.b.a.a.h.b bVar) {
        if (bVar != null) {
            f = bVar;
        } else {
            f = a(new File(context.getCacheDir(), "image"));
        }
    }

    public static b.b.a.a.h.b a(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (f == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(g() / 16, 41943040L);
        } else {
            iMin = Math.min(f.f() / 2, 31457280);
            jMin = Math.min(f.d() / 2, 41943040L);
        }
        return new a(Math.max(iMin, 26214400), Math.max(jMin, 20971520L), file);
    }
}
