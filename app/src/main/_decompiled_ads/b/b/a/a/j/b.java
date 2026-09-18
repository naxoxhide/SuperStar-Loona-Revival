package b.b.a.a.j;

import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: NetResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f232b;
    final Map<String, String> c;
    final String d;
    final long e;
    final long f;
    private File g = null;
    private final boolean h;

    public b(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.h = z;
        this.a = i;
        this.f232b = str;
        this.c = map;
        this.d = str2;
        this.e = j;
        this.f = j2;
    }

    public String a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public long c() {
        return this.e - this.f;
    }

    public File d() {
        return this.g;
    }

    public Map<String, String> e() {
        return this.c;
    }

    public String f() {
        return this.f232b;
    }

    public boolean g() {
        return this.h;
    }

    public void a(File file) {
        this.g = file;
    }
}
