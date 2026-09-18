package com.bytedance.sdk.openadsdk.b.m.p;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: RewardFullExpressManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final com.bytedance.sdk.openadsdk.b.m.p.a a;

    /* JADX INFO: compiled from: RewardFullExpressManager.java */
    class b implements PAGBannerAdWrapperListener {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.b.m.q.b f496b;

        /* JADX INFO: compiled from: RewardFullExpressManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f496b.a(false, false, false);
            }
        }

        b(com.bytedance.sdk.openadsdk.core.j0.c.b bVar, com.bytedance.sdk.openadsdk.b.m.q.b bVar2) {
            this.a = bVar;
            this.f496b = bVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdClicked(View view, int i) {
            if (f.this.a == null || f.this.a.a == null || !f.this.a.a.V0()) {
                return;
            }
            this.a.onRewardBarClick(view);
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdDismissed() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onAdShow(View view, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderFail(View view, String str, int i) {
            if (!f.this.a.a.X0()) {
                f.this.a.Q.d(true);
                f.this.a.Q.E();
            }
            com.bytedance.sdk.component.utils.m.a("TTAD.RFExpressM", "onRenderFail、、、code:" + i);
            f.this.a.J.e().post(new a());
            f.this.a.T.a();
        }

        @Override // com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener
        public void onRenderSuccess(View view, float f, float f2) {
            if (t.h(f.this.a.a)) {
                return;
            }
            if (!f.this.a.a.X0()) {
                if (f.this.a.J.g()) {
                    this.f496b.a(true);
                    f.this.a.G.d(false);
                } else {
                    f.this.a.G.d(true);
                }
                f.this.a.T.a(8);
                f.this.a.Q.d(true);
                f.this.a.Q.E();
                if (f.this.a.J.g()) {
                    f.this.a.J.f().setBackgroundColor(-16777216);
                    this.f496b.a(f.this.a.T.e());
                } else if (f.this.a.a.N0() != null && this.f496b.c()) {
                    f.this.a.i = true;
                }
            }
            this.f496b.d();
            if ((this.f496b instanceof com.bytedance.sdk.openadsdk.b.m.q.e) && !f.this.a.J.g()) {
                com.bytedance.sdk.openadsdk.b.m.q.e.a(f.this.a.a);
                f.this.a.V.b();
            }
            f.this.a.T.a();
        }
    }

    /* JADX INFO: compiled from: RewardFullExpressManager.java */
    class c extends com.bytedance.sdk.openadsdk.core.nativeexpress.g {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b M;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
            super(context, qVar, str, i);
            this.M = bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            super.a(view, f, f2, f3, f4, sparseArray, z);
            this.M.onRewardBarClick(view);
        }
    }

    /* JADX INFO: compiled from: RewardFullExpressManager.java */
    class d extends com.bytedance.sdk.openadsdk.core.nativeexpress.f {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b R;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, q qVar, String str, int i, com.bytedance.sdk.openadsdk.core.j0.c.b bVar) {
            super(context, qVar, str, i);
            this.R = bVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a, com.bytedance.sdk.openadsdk.core.c0.b, com.bytedance.sdk.openadsdk.core.c0.c
        public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(f.this.a.G.e()));
            a(map);
            super.a(view, f, f2, f3, f4, sparseArray, z);
            if (a(view, z)) {
                this.R.onRewardBarClick(view);
            }
        }
    }

    public f(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: compiled from: RewardFullExpressManager.java */
    class a implements com.bytedance.sdk.openadsdk.core.nativeexpress.l {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.j0.c.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bytedance.sdk.openadsdk.b.m.q.b f495b;

        a(com.bytedance.sdk.openadsdk.core.j0.c.b bVar, com.bytedance.sdk.openadsdk.b.m.q.b bVar2) {
            this.a = bVar;
            this.f495b = bVar2;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void a(boolean z) {
            if (f.this.a.d != z) {
                f.this.a.R.b();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void d(int i) {
            f.this.a.h = i;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void e() {
            f.this.a.N.b(this.f495b);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void f() {
            if (f.this.a.T == null || f.this.a.T.b() == null) {
                return;
            }
            f.this.a.T.b().performClick();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public int i() {
            if (f.this.a.J.i()) {
                return 4;
            }
            if (f.this.a.J.h()) {
                return 5;
            }
            if (f.this.a.G.u()) {
                return 1;
            }
            if (f.this.a.G.w()) {
                return 2;
            }
            f.this.a.G.v();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void j() {
            f.this.a.R.a();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public long k() {
            return f.this.a.G.n();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l
        public void a(int i) {
            if (i != 1) {
                if (i == 2) {
                    f.this.a.G.A();
                    return;
                }
                if (i == 3) {
                    f.this.a.G.a(this.a);
                    return;
                } else if (i == 4) {
                    f.this.a.G.C();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (f.this.a.G.w() || f.this.a.G.v()) {
                return;
            }
            this.a.a(0L, false);
        }
    }

    public void a(float[] fArr, com.bytedance.sdk.openadsdk.core.j0.c.b bVar, com.bytedance.sdk.openadsdk.b.m.q.b bVar2) {
        com.bytedance.sdk.openadsdk.component.reward.view.c cVar;
        com.bytedance.sdk.component.utils.m.a("TTAD.RFExpressM", "initExpressView() called with: size = [" + Arrays.toString(fArr) + "]");
        this.a.J.a(new AdSlot.Builder().setCodeId(String.valueOf(this.a.a.S())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build());
        com.bytedance.sdk.openadsdk.b.m.p.a aVar = this.a;
        j jVar = aVar.R;
        if (jVar != null && (cVar = aVar.J) != null) {
            jVar.a(cVar.d());
        }
        this.a.J.a(new a(bVar, bVar2));
        this.a.J.a(new b(bVar, bVar2));
        com.bytedance.sdk.openadsdk.b.m.p.a aVar2 = this.a;
        TTBaseVideoActivity tTBaseVideoActivity = aVar2.V;
        q qVar = aVar2.a;
        String str = aVar2.g;
        c cVar2 = new c(this, tTBaseVideoActivity, qVar, str, a0.f(str), bVar);
        HashMap map = new HashMap();
        if (t.h(this.a.a)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        cVar2.a(map);
        com.bytedance.sdk.openadsdk.b.m.p.a aVar3 = this.a;
        TTBaseVideoActivity tTBaseVideoActivity2 = aVar3.V;
        q qVar2 = aVar3.a;
        String str2 = aVar3.g;
        d dVar = new d(tTBaseVideoActivity2, qVar2, str2, a0.f(str2), bVar);
        HashMap map2 = new HashMap();
        if (t.h(this.a.a)) {
            map2.put("click_scence", 3);
        } else {
            map2.put("click_scence", 1);
        }
        dVar.a(map2);
        this.a.J.a(cVar2, dVar);
        FrameLayout.LayoutParams layoutParams = this.a.a.X0() ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.a.T.e().addView(this.a.J.d(), layoutParams);
        if (!this.a.J.g()) {
            bVar2.a(false);
        }
        this.a.J.l();
    }
}
