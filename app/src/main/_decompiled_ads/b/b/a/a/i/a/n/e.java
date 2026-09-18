package b.b.a.a.i.a.n;

import java.util.UUID;

/* JADX INFO: compiled from: TTRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Runnable, Comparable<e> {
    private int a;

    public e(String str) {
        this.a = 0;
        this.a = 5;
        String str2 = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    public void a(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        if (a() < eVar.a()) {
            return 1;
        }
        return a() >= eVar.a() ? -1 : 0;
    }
}
