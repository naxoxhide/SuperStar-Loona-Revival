package com.bytedance.sdk.openadsdk.d.p;

import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: StatsLogAdLogImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements com.bytedance.sdk.openadsdk.l.e.a {
    public static final l a = new l();

    /* JADX INFO: compiled from: StatsLogAdLogImpl.java */
    class a extends b.b.a.a.k.g {
        final /* synthetic */ com.bytedance.sdk.openadsdk.l.a c;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, String str, com.bytedance.sdk.openadsdk.l.a aVar, boolean z) {
            super(str);
            this.c = aVar;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.sdk.openadsdk.l.c.a logStats = this.c.getLogStats();
                if (logStats == null) {
                    return;
                }
                b.b.a.a.i.a.m.c.a aVar = new b.b.a.a.i.a.m.c.a(q.a(), logStats.a());
                aVar.c((byte) 0);
                aVar.b(this.d ? (byte) 2 : (byte) 3);
                aVar.a((byte) 1);
                if (b.b.a.a.i.a.b.b()) {
                    d.a(o.a(), com.bytedance.sdk.openadsdk.m.b.b());
                }
                b.b.a.a.i.a.b.a(aVar);
            } catch (Throwable unused) {
            }
        }
    }

    private l() {
    }

    @Override // com.bytedance.sdk.openadsdk.l.e.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.l.e.a
    public void a(com.bytedance.sdk.openadsdk.l.a aVar) {
        a(aVar, false);
    }

    @Override // com.bytedance.sdk.openadsdk.l.e.a
    public void a(com.bytedance.sdk.openadsdk.l.a aVar, boolean z) {
        a(new a(this, "uploadLogEvent", aVar, z));
    }

    private void a(b.b.a.a.k.g gVar) {
        if (gVar == null) {
            return;
        }
        if (!y.f()) {
            y.c(gVar, 5);
        } else {
            gVar.run();
        }
    }
}
