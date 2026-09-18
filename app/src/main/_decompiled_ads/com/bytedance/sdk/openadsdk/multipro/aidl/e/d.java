package com.bytedance.sdk.openadsdk.multipro.aidl.e;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: RewardVideoListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends IRewardAdInteractionListener.Stub {
    private com.bytedance.sdk.openadsdk.a.f.a a;

    /* JADX INFO: compiled from: RewardVideoListenerImpl.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.onAdShow();
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoListenerImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.onAdVideoBarClick();
            }
        }
    }

    /* JADX INFO: compiled from: RewardVideoListenerImpl.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.onAdClose();
            }
            d.this.a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.aidl.e.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RewardVideoListenerImpl.java */
    class RunnableC0247d implements Runnable {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f805b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        RunnableC0247d(boolean z, int i, String str, int i2, String str2) {
            this.a = z;
            this.f805b = i;
            this.c = str;
            this.d = i2;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.onRewardVerify(this.a, this.f805b, this.c, this.d, this.e);
            }
        }
    }

    public d(com.bytedance.sdk.openadsdk.a.f.a aVar) {
        this.a = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new c());
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new b());
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException {
        if (this.a == null) {
            return;
        }
        y.a(new RunnableC0247d(z, i, str, i2, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a = null;
    }
}
