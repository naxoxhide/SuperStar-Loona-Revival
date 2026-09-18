package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;

/* JADX INFO: compiled from: DefaultReport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements o {
    @Override // com.mbridge.msdk.foundation.same.report.o
    public final void a(Context context, b.InterfaceC0486b interfaceC0486b, b bVar, com.mbridge.msdk.foundation.same.net.g.d dVar) throws Exception {
        if (bVar == null || dVar == null) {
            if (MBridgeConstans.DEBUG) {
                aa.d("CommonReport", "reportEvent or params or reportEvent is null");
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(context);
        if (bVar.l() == null) {
            new com.mbridge.msdk.foundation.same.net.b();
        }
        if (bVar.j()) {
            if (k.a().c() && !TextUtils.isEmpty(bVar.p())) {
                k.a().a(bVar.p());
            } else {
                aVar.postFocusReport(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVar, new a(context, interfaceC0486b, bVar, dVar));
            }
        } else if (k.a().c() && !TextUtils.isEmpty(bVar.p())) {
            k.a().a(bVar.p());
        } else {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVar, new a(context, interfaceC0486b, bVar, dVar));
        }
        if (MBridgeConstans.DEBUG) {
            aa.a("CommonReport", "report: key = " + bVar.i() + " retry = " + bVar.k() + " isFocusReport = " + bVar.j() + " isTimer = " + bVar.o() + "\ndata = " + bVar.p());
        }
    }

    /* JADX INFO: compiled from: DefaultReport.java */
    private static final class a extends com.mbridge.msdk.foundation.same.report.d.b {
        private final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b.InterfaceC0486b f2173b;
        private final b c;
        private final com.mbridge.msdk.foundation.same.net.g.d d;
        private final boolean e;

        private a(Context context, b.InterfaceC0486b interfaceC0486b, b bVar, com.mbridge.msdk.foundation.same.net.g.d dVar) {
            this.a = context;
            this.f2173b = interfaceC0486b;
            this.c = bVar;
            this.d = dVar;
            this.e = bVar.k();
        }

        @Override // com.mbridge.msdk.foundation.same.report.d.b
        public final void onSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.a("CommonReport", "report success: " + str);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.report.d.b
        public final void onFailed(String str) {
            if (MBridgeConstans.DEBUG) {
                aa.d("CommonReport", "report failed: " + str + " and isRetry = " + this.e);
            }
            b bVar = this.c;
            if (bVar == null || !this.e || this.a == null) {
                return;
            }
            final String strP = bVar.p();
            if (TextUtils.isEmpty(strP)) {
                return;
            }
            final long jQ = this.c.q();
            if (jQ <= 0) {
                jQ = System.currentTimeMillis();
            }
            final Context context = this.a;
            this.c.c().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (TextUtils.isEmpty(strP) || context == null) {
                        return;
                    }
                    try {
                        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                        lVar.c(strP);
                        lVar.a(jQ);
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.a(com.mbridge.msdk.foundation.same.net.f.d.a().a);
                        com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("CommonReport", "createReportDataThread error: " + e.getMessage());
                        }
                    }
                }
            });
        }
    }
}
