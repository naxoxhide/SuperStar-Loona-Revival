package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements InvocationHandler {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f2771b;
    public final Looper c;

    public j(Object obj, Thread thread, Looper looper) {
        this.a = obj;
        this.f2771b = thread;
        this.c = looper;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.f2771b == Thread.currentThread()) {
            return method.invoke(this.a, objArr);
        }
        if (!method.getReturnType().equals(Void.TYPE)) {
            throw new UnsupportedOperationException("method not return void: " + method.getName());
        }
        i iVar = new i(this, method, objArr);
        if (this.c != null && new Handler(this.c).post(iVar)) {
            return null;
        }
        if (this.f2771b == h.a() && h.c.a(iVar)) {
            return null;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || !new Handler(mainLooper).post(iVar)) {
            return method.invoke(this.a, objArr);
        }
        return null;
    }
}
