package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* JADX INFO: compiled from: InitLifecycleHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class m {
    private com.bytedance.sdk.openadsdk.utils.a a = new com.bytedance.sdk.openadsdk.utils.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f641b;

    /* JADX INFO: compiled from: InitLifecycleHelper.java */
    private static class a {
        private static m a = new m();
    }

    public static m a() {
        return a.a;
    }

    public boolean b() {
        return this.a.b();
    }

    public void c() {
        try {
            Context contextA = o.a();
            if (contextA instanceof Application) {
                ((Application) contextA).registerActivityLifecycleCallbacks(this.a);
                this.f641b = true;
            } else if (contextA != null && contextA.getApplicationContext() != null) {
                ((Application) contextA.getApplicationContext()).registerActivityLifecycleCallbacks(this.a);
                this.f641b = true;
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean d() {
        return this.f641b;
    }
}
