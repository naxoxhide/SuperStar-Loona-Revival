package com.bytedance.sdk.openadsdk.d;

import com.bytedance.sdk.openadsdk.core.f0.q;

/* JADX INFO: compiled from: LastShowAdManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: compiled from: LastShowAdManager.java */
    static class a implements Runnable {
        final /* synthetic */ q a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f722b;

        a(q qVar, String str) {
            this.a = qVar;
            this.f722b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.bytedance.sdk.openadsdk.utils.l.a(this.a.n1().toString(), this.f722b);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(q qVar, String str) {
        if (qVar != null) {
            com.bytedance.sdk.component.utils.i.a().post(new a(qVar, str));
        }
    }
}
