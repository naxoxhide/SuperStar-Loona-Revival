package com.bytedance.sdk.openadsdk.l.d;

import b.b.a.a.k.c;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.l.c.b;

/* JADX INFO: compiled from: ReportThreadLogServiceImp.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.l.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReportThreadLogServiceImp.java */
    class C0240a implements com.bytedance.sdk.openadsdk.l.a {
        final /* synthetic */ b.b.a.a.k.j.a a;

        C0240a(a aVar, b.b.a.a.k.j.a aVar2) {
            this.a = aVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.l.a
        public com.bytedance.sdk.openadsdk.l.c.a getLogStats() throws Exception {
            b.b.a.a.k.j.a aVar;
            if (!o.d().U() || (aVar = this.a) == null || aVar.a() == null) {
                return null;
            }
            return b.o().h("stats_sdk_thread_num").c(this.a.a().toString());
        }
    }

    @Override // b.b.a.a.k.c
    public void a(b.b.a.a.k.j.a aVar) {
        com.bytedance.sdk.openadsdk.l.b.a();
        com.bytedance.sdk.openadsdk.l.b.a("stats_sdk_thread_num", false, (com.bytedance.sdk.openadsdk.l.a) new C0240a(this, aVar));
    }
}
