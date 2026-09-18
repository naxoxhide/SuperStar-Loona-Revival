package com.bytedance.sdk.openadsdk.multipro.aidl.e;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: FullScreenVideoListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends IFullScreenVideoAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.a.d.b a;

    /* JADX INFO: compiled from: FullScreenVideoListenerImpl.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.a != null) {
                c.this.a.onAdShow();
            }
        }
    }

    /* JADX INFO: compiled from: FullScreenVideoListenerImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.a != null) {
                c.this.a.onAdVideoBarClick();
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.e.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FullScreenVideoListenerImpl.java */
    class RunnableC0246c implements Runnable {
        RunnableC0246c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.a != null) {
                c.this.a.onAdClose();
            }
            c.this.a();
        }
    }

    public c(com.bytedance.sdk.openadsdk.a.d.b bVar) {
        this.a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new RunnableC0246c());
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new b());
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a = null;
    }
}
