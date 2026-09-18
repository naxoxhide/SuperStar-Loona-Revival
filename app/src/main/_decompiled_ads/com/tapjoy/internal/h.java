package com.tapjoy.internal;

import android.opengl.GLSurfaceView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final va a = new va();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final va f2761b = new va();
    public static final f c = new f();

    public static void a(GLSurfaceView gLSurfaceView) {
        a.a(gLSurfaceView);
        gLSurfaceView.queueEvent(new g());
    }

    public static Thread a() {
        WeakReference weakReference = f2761b.a;
        return (Thread) (weakReference != null ? weakReference.get() : null);
    }
}
