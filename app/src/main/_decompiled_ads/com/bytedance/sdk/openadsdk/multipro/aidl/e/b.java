package com.bytedance.sdk.openadsdk.multipro.aidl.e;

import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IDislikeClosedListener;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: DislikeClosedListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends IDislikeClosedListener.Stub {
    private final com.bytedance.sdk.openadsdk.core.bannerexpress.a.h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f804b;

    /* JADX INFO: compiled from: DislikeClosedListenerImpl.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.a != null) {
                b.this.a.onItemClickClosed();
                TTDislikeListView.a(6, b.this.f804b);
            }
        }
    }

    public b(String str, com.bytedance.sdk.openadsdk.core.bannerexpress.a.h hVar) {
        this.f804b = str;
        this.a = hVar;
    }

    @Override // com.bytedance.sdk.openadsdk.IDislikeClosedListener
    public void onItemClickClosed() throws RemoteException {
        y.a(new a());
    }
}
