package com.bytedance.sdk.openadsdk.a.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.y;

/* JADX INFO: compiled from: PAGNativeFeedAdWrapperListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements f {
    private PAGNativeAdInteractionListener a;

    /* JADX INFO: compiled from: PAGNativeFeedAdWrapperListenerImpl.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.a != null) {
                g.this.a.onAdClicked();
            }
        }
    }

    /* JADX INFO: compiled from: PAGNativeFeedAdWrapperListenerImpl.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.a != null) {
                g.this.a.onAdClicked();
            }
        }
    }

    /* JADX INFO: compiled from: PAGNativeFeedAdWrapperListenerImpl.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.a != null) {
                g.this.a.onAdShowed();
            }
        }
    }

    /* JADX INFO: compiled from: PAGNativeFeedAdWrapperListenerImpl.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.a != null) {
                g.this.a.onAdDismissed();
            }
        }
    }

    public g(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.a = pAGNativeAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.f
    public void b(View view, PAGNativeAd pAGNativeAd) {
        y.a(new a());
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.f
    public void onAdDismissed() {
        y.a(new d());
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.f
    public void a(View view, PAGNativeAd pAGNativeAd) {
        y.a(new b());
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.f
    public void a(PAGNativeAd pAGNativeAd) {
        y.a(new c());
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.f
    public boolean a() {
        return this.a != null;
    }
}
