package com.bytedance.sdk.openadsdk.b;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdBackupView;
import com.bytedance.sdk.openadsdk.component.view.PAGAppOpenAdExpressView;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;

/* JADX INFO: compiled from: AppOpenAdExpressManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends com.bytedance.sdk.openadsdk.b.c {
    private PAGAppOpenAdExpressView x;
    private boolean y;

    /* JADX INFO: compiled from: AppOpenAdExpressManager.java */
    class a implements PAGBannerAdWrapperListener {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdClicked(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdDismissed() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderFail(View view, String str, int i) {
            b.this.e.d();
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderSuccess(View view, float f, float f2) {
            if (b.this.x.y()) {
                b.this.y = true;
                b bVar = b.this;
                b.super.a((ViewGroup) bVar.d);
                b.super.b();
                b.super.g();
                return;
            }
            b bVar2 = b.this;
            if (!bVar2.c) {
                bVar2.e.e();
            } else if (bVar2.a(bVar2.x.getVideoFrameLayout())) {
                b.this.e.e();
            } else {
                b.this.e.d();
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppOpenAdExpressManager.java */
    class C0173b implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        C0173b() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            b.this.e.b();
        }
    }

    /* JADX INFO: compiled from: AppOpenAdExpressManager.java */
    class c implements b.b.a.a.d.f.c {
        c() {
        }

        @Override // b.b.a.a.d.f.c
        public boolean a(ViewGroup viewGroup, int i) {
            m.a("AppOpenAdExpressManager", "open_ad", "isUseBackup() called with: view = [" + viewGroup + "], errCode = [" + i + "]");
            try {
                ((NativeExpressView) viewGroup).o();
                new OpenScreenAdBackupView(b.this.a).a((NativeExpressView) b.this.x);
                return true;
            } catch (Exception e) {
                Log.e("AppOpenAdExpressManager", "", e);
                return false;
            }
        }
    }

    public b(Activity activity, q qVar, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.b.a aVar, int i, boolean z, com.bytedance.sdk.openadsdk.b.p.a aVar2) {
        super(activity, qVar, frameLayout, aVar, i, z, aVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.b.c
    public int d() {
        return this.x.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.b.c
    public void g() {
        this.x.C();
    }

    @Override // com.bytedance.sdk.openadsdk.b.c
    public void b() {
        this.x.setClickListener(com.bytedance.sdk.openadsdk.b.h.b.b(this.f437b, this.a, this.s, this.x));
        com.bytedance.sdk.openadsdk.core.nativeexpress.f fVarA = com.bytedance.sdk.openadsdk.b.h.b.a(this.f437b, this.a, this.s, this.x);
        this.x.setClickCreativeListener(fVarA);
        fVarA.a(new C0173b());
        this.x.setBackupListener(new c());
    }

    @Override // com.bytedance.sdk.openadsdk.b.c
    public void a(ViewGroup viewGroup) {
        q.a aVarI0;
        Pair<Float, Float> pairA = com.bytedance.sdk.openadsdk.core.nativeexpress.q.a.a(this.a.getWindow(), this.g);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(String.valueOf(this.f437b.S())).setExpressViewAcceptedSize(((Float) pairA.first).floatValue(), ((Float) pairA.second).floatValue()).build();
        if (m.c() && (aVarI0 = this.f437b.I0()) != null) {
            m.a("AppOpenAdExpressManager", "open_ad", "tryDynamicNative: id is " + aVarI0.d());
        }
        PAGAppOpenAdExpressView pAGAppOpenAdExpressView = new PAGAppOpenAdExpressView(this.a, this.f437b, adSlotBuild, "open_ad");
        this.x = pAGAppOpenAdExpressView;
        pAGAppOpenAdExpressView.setTopListener(this.e);
        this.x.setExpressVideoListenerProxy(this.e);
        this.x.setExpressInteractionListener(new a());
        this.f437b.b(1);
        this.d.addView(this.x, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.b.c
    public void a(int i, int i2, boolean z) {
        if (this.y) {
            super.a(i, i2, z);
        } else {
            this.x.a(String.valueOf(i), i2, 0, z);
        }
    }
}
