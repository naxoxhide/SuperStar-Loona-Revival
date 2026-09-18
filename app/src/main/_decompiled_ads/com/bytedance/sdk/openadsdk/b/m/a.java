package com.bytedance.sdk.openadsdk.b.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: ChooseAdHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.m.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChooseAdHelper.java */
    static class RunnableC0181a implements Runnable {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f459b;
        final /* synthetic */ String c;

        RunnableC0181a(q qVar, boolean z, String str) {
            this.a = qVar;
            this.f459b = z;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strC;
            q qVar = this.a;
            if (qVar == null || (strC = qVar.c((String) null)) == null) {
                return;
            }
            try {
                Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
                AdSlot adSlotB = e.a(contextA).b(strC);
                e.a(contextA).a(strC);
                if (adSlotB != null) {
                    if (!this.f459b || TextUtils.isEmpty(this.c)) {
                        e.a(contextA).b(adSlotB);
                    } else {
                        e.a(contextA).a(adSlotB);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.core.f0.a aVar, int i) {
        if (aVar == null || aVar.b() == null || aVar.b().size() <= 0) {
            return;
        }
        if (i >= aVar.b().size()) {
            i = 0;
        }
        q qVar = aVar.b().get(i);
        a(qVar, true, d.a(com.bytedance.sdk.openadsdk.core.o.a()).b(qVar));
    }

    public static void a(q qVar, boolean z, String str) {
        com.bytedance.sdk.openadsdk.core.l.a().post(new RunnableC0181a(qVar, z, str));
    }
}
