package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: InternalContainer.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {
    private static volatile Context a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile p<com.bytedance.sdk.openadsdk.d.a> f661b = null;
    private static int c = -1;

    /* JADX INFO: compiled from: InternalContainer.java */
    private static class a {
        private static volatile Application a;

        static {
            try {
                Object objB = b();
                a = (Application) objB.getClass().getMethod("getApplication", new Class[0]).invoke(objB, new Object[0]);
                com.bytedance.sdk.component.utils.m.b("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("MyApplication", "application get failed", th);
            }
        }

        public static Application a() {
            return a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.m.b("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context a() {
        if (a == null) {
            a(null);
        }
        return a;
    }

    public static com.bytedance.sdk.openadsdk.l.e.a b() {
        return !com.bytedance.sdk.openadsdk.core.settings.j.a() ? com.bytedance.sdk.openadsdk.l.e.b.a() : com.bytedance.sdk.openadsdk.d.p.d.a();
    }

    public static p<com.bytedance.sdk.openadsdk.d.a> c() {
        if (f661b == null) {
            synchronized (o.class) {
                if (f661b == null) {
                    f661b = new q(a);
                }
            }
        }
        return f661b;
    }

    public static com.bytedance.sdk.openadsdk.core.settings.d d() {
        return com.bytedance.sdk.openadsdk.core.settings.n.j0();
    }

    public static int e() {
        Context contextA;
        if (c < 0 && (contextA = a()) != null) {
            c = ViewConfiguration.get(contextA).getScaledTouchSlop();
        }
        return c;
    }

    public static void a(Context context) {
        if (a == null) {
            synchronized (o.class) {
                if (a == null) {
                    if (context != null) {
                        a = context;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            a = applicationContext;
                        }
                        return;
                    }
                    try {
                        Application applicationA = a.a();
                        if (applicationA != null) {
                            a = applicationA;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
