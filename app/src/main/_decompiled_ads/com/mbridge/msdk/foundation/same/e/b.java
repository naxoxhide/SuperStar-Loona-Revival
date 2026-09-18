package com.mbridge.msdk.foundation.same.e;

import android.content.Context;
import com.mbridge.msdk.foundation.tools.ac;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CommonTaskLoader.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    ThreadPoolExecutor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    HashMap<Long, a> f2122b;
    WeakReference<Context> c;

    public b(Context context, int i) {
        if (ac.a().a("c_t_l_t_p", true)) {
            this.a = c.a();
        } else {
            if (i == 0) {
                this.a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.a = new ThreadPoolExecutor(i, (i * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.a.allowCoreThreadTimeOut(true);
        }
        this.f2122b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    public b(Context context) {
        if (ac.a().a("c_t_l_t_p", true)) {
            this.a = c.a();
        } else {
            if (ac.a().a("c_t_p_t_l", true)) {
                int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.a.allowCoreThreadTimeOut(true);
        }
        this.f2122b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.b bVar) {
        this.f2122b.put(Long.valueOf(a.f2120b), aVar);
        aVar.d = new a.b() { // from class: com.mbridge.msdk.foundation.same.e.b.1
            @Override // com.mbridge.msdk.foundation.same.e.a.b
            public final void a(a.EnumC0483a enumC0483a) {
                if (enumC0483a == a.EnumC0483a.CANCEL || enumC0483a == a.EnumC0483a.FINISH) {
                    b.this.f2122b.remove(Long.valueOf(a.f2120b));
                } else if (enumC0483a == a.EnumC0483a.RUNNING && b.this.c.get() == null) {
                    b.this.a();
                }
                a.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(enumC0483a);
                }
            }
        };
    }

    public final synchronized void a() {
        try {
            Iterator<Map.Entry<Long, a>> it = this.f2122b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().d();
            }
            this.f2122b.clear();
        } catch (Exception unused) {
        }
    }

    public final void a(a aVar) {
        b(aVar, null);
        this.a.execute(aVar);
    }

    public final void a(a aVar, a.b bVar) {
        b(aVar, bVar);
        this.a.execute(aVar);
    }
}
