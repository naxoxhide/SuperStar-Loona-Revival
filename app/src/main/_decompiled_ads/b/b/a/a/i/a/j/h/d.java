package b.b.a.a.i.a.j.h;

import b.b.a.a.i.a.m.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: EventMemoryCacheManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends b.b.a.a.i.a.m.a> {
    private b.b.a.a.i.a.m.d.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<T> f211b = new ConcurrentLinkedQueue();
    private String c;

    public d(b.b.a.a.i.a.m.d.a aVar, Queue<String> queue, String str) {
        this.c = "EventMemoryCacheManager";
        this.a = aVar;
        this.c = str;
    }

    public void a(T t) {
        Queue<T> queue = this.f211b;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized List<b.b.a.a.i.a.m.a> b(int i, int i2) {
        if (!a(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a.e());
        do {
            T tPoll = this.f211b.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.a.d());
        return arrayList;
    }

    public synchronized void a(int i, List<T> list) {
        try {
            if (i != -1 && i != 200 && i != 509) {
                this.f211b.addAll(list);
            } else {
                b.b.a.a.i.a.l.c.d(this.c + " memory size：" + this.f211b.size());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean a(int i, int i2) {
        int size = this.f211b.size();
        int iE = this.a.e();
        b.b.a.a.i.a.l.c.d(this.c + " size:" + size + " cacheCount:" + iE + " message:" + i);
        if (i != 2 && i != 1) {
            return size >= iE;
        }
        if (b.b.a.a.i.a.l.a.d()) {
            return size >= 1;
        }
        return size >= iE;
    }
}
