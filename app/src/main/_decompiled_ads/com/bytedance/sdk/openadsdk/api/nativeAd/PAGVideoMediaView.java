package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.c0.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* JADX INFO: loaded from: classes2.dex */
public class PAGVideoMediaView extends PAGMediaView implements a.InterfaceC0194a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NativeVideoTsView f435b;
    private final com.bytedance.sdk.openadsdk.a.c.a c;

    public PAGVideoMediaView(Context context, View view, com.bytedance.sdk.openadsdk.a.c.a aVar) {
        super(context);
        a(view);
        this.c = aVar;
    }

    private void a(View view) {
        if (view instanceof NativeVideoTsView) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) view;
            this.f435b = nativeVideoTsView;
            addView(nativeVideoTsView, -1, -1);
        }
    }

    private void b() {
        NativeVideoTsView nativeVideoTsView = this.f435b;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.N();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void close() {
        NativeVideoTsView nativeVideoTsView = this.f435b;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.s();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a
    public long getVideoProgress() {
        NativeVideoTsView nativeVideoTsView = this.f435b;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.f435b.getNativeVideoController().o();
    }

    public void handleInterruptVideo() {
        if (a()) {
            return;
        }
        b();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof a) {
            ((a) onClickListener).a((a.InterfaceC0194a) this);
        }
    }

    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.a.c.a aVar = this.c;
        if (aVar == null) {
            return;
        }
        aVar.a(new PAGVideoAdListener(this) { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView.1
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdComplete() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPaused() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPlay() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoError() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }
        });
    }

    private boolean a() {
        NativeVideoTsView nativeVideoTsView = this.f435b;
        if (nativeVideoTsView != null) {
            return nativeVideoTsView.M();
        }
        return false;
    }
}
