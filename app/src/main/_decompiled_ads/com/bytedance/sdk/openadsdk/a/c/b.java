package com.bytedance.sdk.openadsdk.a.c;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bytedance.sdk.component.utils.p;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;

/* JADX INFO: compiled from: PAGFeedVideoAdImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends h implements b.a.a.a.a.a.a.g.c.d, b.a.a.a.a.a.a.g.c.InterfaceC0008c, com.bytedance.sdk.openadsdk.m.g.a.InterfaceC0241a {
    private c j;
    private final com.bytedance.sdk.openadsdk.m.g.a k;
    private boolean l;
    private boolean m;
    private AdSlot n;

    /* JADX INFO: compiled from: PAGFeedVideoAdImpl.java */
    class a implements NativeVideoTsView.h {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.h
        public void a(View view, int i) {
            n nVar = b.this.a;
            if (nVar != null) {
                nVar.a(view, i);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGFeedVideoAdImpl.java */
    class C0167b implements NativeVideoTsView.i {
        C0167b() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.i
        public void a(boolean z, long j, long j2, long j3, boolean z2) {
            b.this.k.a = z;
            b.this.k.e = j;
            b.this.k.f = j2;
            b.this.k.g = j3;
            b.this.k.d = z2;
        }
    }

    public b(Context context, q qVar, int i, AdSlot adSlot) {
        super(context, qVar, i);
        this.l = false;
        this.m = true;
        this.e = i;
        this.n = adSlot;
        this.k = new com.bytedance.sdk.openadsdk.m.g.a();
        b(this.f);
        a("embeded_ad");
        this.d.a(this);
    }

    public void b(int i) {
        int iB = o.d().b(i);
        int iB2 = p.b(o.a());
        if (3 == iB) {
            this.l = false;
            this.m = false;
        } else if (1 == iB && a0.h(iB2)) {
            this.l = false;
            this.m = true;
        } else if (2 == iB) {
            if (a0.f(iB2) || a0.h(iB2) || a0.g(iB2)) {
                this.l = false;
                this.m = true;
            }
        } else if (4 == iB) {
            this.l = true;
        } else if (5 == iB && (a0.h(iB2) || a0.g(iB2))) {
            this.m = true;
        }
        com.bytedance.sdk.openadsdk.a.c.a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.l);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void c() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public View f() {
        NativeVideoTsView nativeVideoTsView;
        q qVar = this.f390b;
        if (qVar != null && this.c != null) {
            if (q.c(qVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.c, this.f390b, this.a.a());
                    q qVar2 = this.f390b;
                    if (qVar2 != null && qVar2.k1()) {
                        com.bytedance.sdk.openadsdk.core.i0.f fVarA = nativeVideoTsView.a((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        com.bytedance.sdk.openadsdk.a.c.a aVar = this.d;
                        if (aVar != null) {
                            aVar.a(fVarA);
                        }
                    }
                    this.a.a(nativeVideoTsView.getNativeVideoController());
                    com.bytedance.sdk.openadsdk.a.c.a aVar2 = this.d;
                    if (aVar2 != null) {
                        aVar2.a(nativeVideoTsView);
                    }
                    nativeVideoTsView.setVideoAdClickListenerTTNativeAd(this);
                    nativeVideoTsView.setAdCreativeClickListener(new a());
                    nativeVideoTsView.setControllerStatusCallBack(new C0167b());
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.e) {
                        nativeVideoTsView.setIsAutoPlay(this.l ? this.n.isAutoPlay() : this.m);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.m);
                    }
                    nativeVideoTsView.setIsQuiet(o.d().f(String.valueOf(this.f)));
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                    nativeVideoTsView = null;
                }
            } else {
                nativeVideoTsView = null;
            }
            if (q.c(this.f390b) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                return nativeVideoTsView;
            }
            ApmHelper.reportCustomError(this.f390b.c0() + "," + nativeVideoTsView, "getAdView null", new RuntimeException());
        }
        return null;
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void g() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.e(this);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void l() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.d(this);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void onVideoAdPaused() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        com.bytedance.sdk.openadsdk.a.c.a aVar = this.d;
        if (aVar != null) {
            aVar.l();
        }
    }

    public void a(c cVar) {
        this.j = cVar;
    }

    @Override // b.a.a.a.a.a.a.g.c.d
    public void a(int i, int i2) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(i, i2);
        }
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void a(long j, long j2) {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a(j, j2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.g.a.InterfaceC0241a
    public com.bytedance.sdk.openadsdk.m.g.a a() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.a.c.h
    protected void a(String str) {
        super.a(str);
    }

    @Override // b.a.a.a.a.a.a.g.c.InterfaceC0008c
    public void b() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.b(this);
        }
    }
}
