package com.bytedance.sdk.openadsdk.q.c;

import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: PAGMRCEventManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: compiled from: PAGMRCEventManager.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ q c;
        final /* synthetic */ com.bytedance.sdk.openadsdk.q.c.a d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, q qVar, com.bytedance.sdk.openadsdk.q.c.a aVar, int i) {
            super(str);
            this.c = qVar;
            this.d = aVar;
            this.e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.c1()) {
                if (this.c.X0()) {
                    com.bytedance.sdk.openadsdk.core.i0.l.c.a(this.c.E0(), new com.bytedance.sdk.openadsdk.core.i0.l.c.e("show_urls", this.c));
                } else {
                    com.bytedance.sdk.openadsdk.d.c.a(this.c);
                }
            }
            String strA = a0.a(this.c);
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.q.c.a aVar = this.d;
            if (aVar != null) {
                try {
                    jSONObject.put("root_view", com.bytedance.sdk.openadsdk.q.c.a.a(aVar));
                    int i = this.e;
                    if (i != -1) {
                        jSONObject.put("dynamic_show_type", i);
                    }
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.openadsdk.d.c.b(this.c, strA, "mrc_show", jSONObject);
        }
    }

    public static void a(q qVar, com.bytedance.sdk.openadsdk.q.c.a aVar, int i) {
        qVar.m1();
        y.d(new a("mrc_report", qVar, aVar, i));
    }
}
