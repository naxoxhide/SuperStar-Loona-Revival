package com.mbridge.msdk.e.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private final com.mbridge.msdk.e.a.a e;
    private final h f;
    private final q g;
    private final i[] h;
    private b i;
    private final AtomicInteger a = new AtomicInteger();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<m<?>> f2031b = new HashSet();
    private final PriorityBlockingQueue<m<?>> c = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<m<?>> d = new PriorityBlockingQueue<>();
    private final List<a> j = new ArrayList();

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface a {
        void a(m<?> mVar, int i);
    }

    public n(h hVar, q qVar, int i, com.mbridge.msdk.e.a.a aVar) {
        this.e = aVar;
        this.f = hVar;
        this.h = new i[i];
        this.g = qVar;
    }

    public final <T> m<T> a(m<T> mVar) {
        mVar.a(this);
        synchronized (this.f2031b) {
            this.f2031b.add(mVar);
        }
        mVar.b(this.a.incrementAndGet());
        a(mVar, 0);
        if (!mVar.o()) {
            c(mVar);
        } else {
            this.c.add(mVar);
        }
        return mVar;
    }

    final <T> void b(m<T> mVar) {
        synchronized (this.f2031b) {
            this.f2031b.remove(mVar);
        }
        a(mVar, 5);
    }

    final void a(m<?> mVar, int i) {
        synchronized (this.j) {
            Iterator<a> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(mVar, i);
            }
        }
    }

    final <T> void c(m<T> mVar) {
        this.d.add(mVar);
    }

    public final void a() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.a();
        }
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.a();
            }
        }
        b bVar2 = new b(this.c, this.d, this.e, this.g);
        this.i = bVar2;
        bVar2.start();
        for (int i = 0; i < this.h.length; i++) {
            i iVar2 = new i(this.d, this.f, this.e, this.g);
            this.h[i] = iVar2;
            iVar2.start();
        }
    }
}
