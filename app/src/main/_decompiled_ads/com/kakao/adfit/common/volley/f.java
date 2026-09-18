package com.kakao.adfit.common.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final AtomicInteger a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<e<?>> f1725b;
    private final PriorityBlockingQueue<e<?>> c;
    private final PriorityBlockingQueue<e<?>> d;
    private final com.kakao.adfit.common.volley.a e;
    private final com.kakao.adfit.m.c f;
    private final com.kakao.adfit.m.e g;
    private final d[] h;
    private b i;
    private final List<a> j;

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface a {
        void a(e<?> eVar, int i);
    }

    public f(com.kakao.adfit.common.volley.a aVar, com.kakao.adfit.m.c cVar, int i, com.kakao.adfit.m.e eVar) {
        this.a = new AtomicInteger();
        this.f1725b = new HashSet();
        this.c = new PriorityBlockingQueue<>();
        this.d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.e = aVar;
        this.f = cVar;
        this.h = new d[i];
        this.g = eVar;
    }

    public int a() {
        return this.a.incrementAndGet();
    }

    public void b() {
        c();
        b bVar = new b(this.c, this.d, this.e, this.g);
        this.i = bVar;
        bVar.start();
        for (int i = 0; i < this.h.length; i++) {
            d dVar = new d(this.d, this.f, this.e, this.g);
            this.h[i] = dVar;
            dVar.start();
        }
    }

    public void c() {
        b bVar = this.i;
        if (bVar != null) {
            bVar.b();
        }
        for (d dVar : this.h) {
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    <T> void d(e<T> eVar) {
        this.d.add(eVar);
    }

    public <T> e<T> a(e<T> eVar) {
        eVar.a(this);
        synchronized (this.f1725b) {
            this.f1725b.add(eVar);
        }
        eVar.b(a());
        eVar.a("add-to-queue");
        a(eVar, 0);
        b(eVar);
        return eVar;
    }

    <T> void c(e<T> eVar) {
        synchronized (this.f1725b) {
            this.f1725b.remove(eVar);
        }
        a(eVar, 5);
    }

    <T> void b(e<T> eVar) {
        if (!eVar.v()) {
            d(eVar);
        } else {
            this.c.add(eVar);
        }
    }

    void a(e<?> eVar, int i) {
        synchronized (this.j) {
            Iterator<a> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(eVar, i);
            }
        }
    }

    public f(com.kakao.adfit.common.volley.a aVar, com.kakao.adfit.m.c cVar, int i) {
        this(aVar, cVar, i, new c(new Handler(Looper.getMainLooper())));
    }

    public f(com.kakao.adfit.common.volley.a aVar, com.kakao.adfit.m.c cVar) {
        this(aVar, cVar, 4);
    }
}
