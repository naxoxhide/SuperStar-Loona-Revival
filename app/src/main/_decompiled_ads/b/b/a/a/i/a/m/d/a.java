package b.b.a.a.i.a.m.d;

/* JADX INFO: compiled from: PolicyConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f224b;

    a(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.a = i;
        this.f224b = i2;
    }

    public static a a() {
        return new a(1, 100, 172800000L);
    }

    public static a b() {
        return new a(1, 100, -1L);
    }

    public static a c() {
        return new a(3, 100, 172800000L);
    }

    public int d() {
        return this.f224b;
    }

    public int e() {
        return this.a;
    }
}
