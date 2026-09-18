package com.mbridge.msdk.b.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PreloadListenerEx.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements PreloadListener {
    WeakReference<PreloadListener> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1902b = false;
    private int c = 0;

    public final boolean a() {
        return this.f1902b;
    }

    public final void a(boolean z) {
        this.f1902b = z;
    }

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.a = new WeakReference<>(preloadListener);
        }
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().onPreloadSucceed();
    }

    @Override // com.mbridge.msdk.out.PreloadListener
    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.a.get().onPreloadFaild(str);
    }
}
