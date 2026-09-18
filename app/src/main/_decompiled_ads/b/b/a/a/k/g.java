package b.b.a.a.k;

/* JADX INFO: compiled from: TTRunnable.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Runnable, Comparable<g> {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f251b;

    public g(String str, int i) {
        this.a = 0;
        this.a = i == 0 ? 5 : i;
        this.f251b = str;
    }

    public String getName() {
        return this.f251b;
    }

    public int getPriority() {
        return this.a;
    }

    public void setPriority(int i) {
        this.a = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(g gVar) {
        if (getPriority() < gVar.getPriority()) {
            return 1;
        }
        return getPriority() >= gVar.getPriority() ? -1 : 0;
    }

    public g(String str) {
        this.a = 0;
        this.a = 5;
        this.f251b = str;
    }
}
