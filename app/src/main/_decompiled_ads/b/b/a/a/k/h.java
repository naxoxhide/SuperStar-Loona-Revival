package b.b.a.a.k;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: TTThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements ThreadFactory {
    private final ThreadGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f252b;
    private int c;

    public h(int i, String str) {
        this.c = i;
        this.a = new ThreadGroup("csj_g_" + str);
        this.f252b = "csj_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.a, runnable, this.f252b);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        int i = this.c;
        if (i > 10 || i < 1) {
            this.c = 5;
        }
        thread.setPriority(this.c);
        return thread;
    }
}
