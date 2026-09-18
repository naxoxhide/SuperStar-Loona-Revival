package com.mbridge.msdk.dycreator.bus;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class SubscriberMethod {
    final Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadMode f2002b;
    final Class<?> c;
    String d;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.a = method;
        this.f2002b = threadMode;
        this.c = cls;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        a();
        return this.d.equals(((SubscriberMethod) obj).d);
    }

    private synchronized void a() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#').append(this.a.getName());
            sb.append('(').append(this.c.getName());
            this.d = sb.toString();
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
