package com.mbridge.msdk.e;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: EventProcessor.java */
/* JADX INFO: loaded from: classes4.dex */
final class g implements l {
    private final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r f2040b;
    private final j c;
    private final AtomicLong d = new AtomicLong(0);
    private final long[] e = new long[2];

    public g(c cVar, r rVar, j jVar) {
        this.a = cVar;
        this.f2040b = rVar;
        this.c = jVar;
    }

    @Override // com.mbridge.msdk.e.l
    public final void a(e eVar) {
        long jIncrementAndGet = this.d.incrementAndGet();
        this.e[0] = System.currentTimeMillis();
        this.e[1] = jIncrementAndGet;
    }

    @Override // com.mbridge.msdk.e.l
    public final void b(final e eVar) {
        this.c.b(new Runnable() { // from class: com.mbridge.msdk.e.g.1
            @Override // java.lang.Runnable
            public final void run() {
                i iVar = new i(eVar);
                iVar.a(1);
                iVar.b(0);
                iVar.a(System.currentTimeMillis() + eVar.h());
                g.this.f2040b.c();
                if (g.this.a.a(iVar) > 0) {
                    g.this.f2040b.a(eVar);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.e.l
    public final long[] a() {
        long[] jArr = this.e;
        return jArr.length == 0 ? new long[]{0, 0} : jArr;
    }
}
