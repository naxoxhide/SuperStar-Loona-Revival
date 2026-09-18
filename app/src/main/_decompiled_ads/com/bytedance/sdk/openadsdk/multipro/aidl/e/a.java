package com.bytedance.sdk.openadsdk.multipro.aidl.e;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: AppOpenAdListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends IAppOpenAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.a.e.b a;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppOpenAdListenerImpl.java */
    class RunnableC0245a implements Runnable {
        RunnableC0245a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onAdShow();
            }
        }
    }

    /* JADX INFO: compiled from: AppOpenAdListenerImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onAdClicked();
            }
        }
    }

    /* JADX INFO: compiled from: AppOpenAdListenerImpl.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.onAdSkip();
            }
        }
    }

    /* JADX INFO: compiled from: AppOpenAdListenerImpl.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.a != null) {
                a.this.a.a();
            }
        }
    }

    public a(com.bytedance.sdk.openadsdk.a.e.b bVar) {
        this.a = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdClicked() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new b());
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new RunnableC0245a());
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdSkip() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new c());
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onAdTimeOver() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new d());
    }

    @Override // com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    private void a() {
        this.a = null;
    }
}
