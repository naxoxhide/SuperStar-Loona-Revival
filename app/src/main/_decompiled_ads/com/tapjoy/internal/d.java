package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ HashSet a;

    public d(HashSet hashSet) {
        this.a = hashSet;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.a.add(activity.getClass().getName() + "@" + System.identityHashCode(activity));
        if (this.a.size() == 1) {
            v1 v1Var = v1.m;
            if (v1Var.b() && v1Var.d()) {
                q.a(null);
            }
        }
        t.c.a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.a.remove(activity.getClass().getName() + "@" + System.identityHashCode(activity));
        if (this.a.size() <= 0) {
            v1 v1Var = v1.m;
            if (v1Var.b()) {
                y6 y6Var = v1Var.g;
                if (y6Var.f2834b.get()) {
                    y6Var.c.run();
                }
            }
        }
    }
}
