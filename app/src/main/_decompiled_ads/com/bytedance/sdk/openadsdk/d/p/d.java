package com.bytedance.sdk.openadsdk.d.p;

import android.content.Context;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: AdLogSwitchUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f743b = new AtomicBoolean(false);

    /* JADX INFO: compiled from: AdLogSwitchUtils.java */
    static class a extends b.b.a.a.k.g {
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, List list) {
            super(str);
            this.c = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.b.a.a.i.a.b.b()) {
                d.a(o.a(), com.bytedance.sdk.openadsdk.m.b.b());
            }
            b.b.a.a.i.a.b.a(com.bytedance.sdk.openadsdk.core.j.c(o.a()), this.c, true);
        }
    }

    public static void a(Context context, boolean z) {
        if (f743b.compareAndSet(false, true)) {
            b.b.a.a.i.a.b.a(new b.b.a.a.i.a.a.b().a(new j()).c(b.b.a.a.i.a.m.d.a.a()).a(b.b.a.a.i.a.m.d.a.c()).b(b.b.a.a.i.a.m.d.a.b()).a(z).a(new k()).a(h.f745b).a(o.d().l()).b(o.d().T()).a(), context);
            b();
        }
    }

    public static void b() {
        b.b.a.a.i.a.b.c();
    }

    public static void c() {
        try {
            b.b.a.a.i.a.b.d();
        } catch (Throwable th) {
            m.b("AdLogSwitchUtils", th.getMessage());
        }
        try {
            b.b.a.a.i.a.b.e();
        } catch (Throwable th2) {
            m.b("AdLogSwitchUtils", th2.getMessage());
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.d.a aVar) {
        b.b.a.a.i.a.m.c.a aVar2 = new b.b.a.a.i.a.m.c.a(aVar.f(), aVar);
        aVar2.b(aVar.g() ? (byte) 1 : (byte) 2);
        aVar2.a((byte) 0);
        if (b.b.a.a.i.a.b.b()) {
            a(o.a(), com.bytedance.sdk.openadsdk.m.b.b());
        }
        b.b.a.a.i.a.b.a(aVar2);
    }

    public static com.bytedance.sdk.openadsdk.l.e.a a() {
        return l.a;
    }

    public static void a(List<String> list) {
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.d.c.a(new a("track", list));
    }

    public static void a(String str) {
        if (b.b.a.a.i.a.b.b()) {
            a(o.a(), com.bytedance.sdk.openadsdk.m.b.b());
        }
        b.b.a.a.i.a.b.a(str);
    }
}
