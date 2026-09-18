package com.tapjoy.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Runnable {
    public final /* synthetic */ Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object[] f2767b;
    public final /* synthetic */ j c;

    public i(j jVar, Method method, Object[] objArr) {
        this.c = jVar;
        this.a = method;
        this.f2767b = objArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.invoke(this.c.a, this.f2767b);
        } catch (IllegalAccessException e) {
            s9.a(e);
            throw null;
        } catch (IllegalArgumentException e2) {
            s9.a(e2);
            throw null;
        } catch (InvocationTargetException e3) {
            s9.a(e3);
            throw null;
        }
    }
}
