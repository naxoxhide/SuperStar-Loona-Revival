package com.bytedance.sdk.openadsdk.a.c;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import b.b.a.a.h.u;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGImageItem;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView;
import com.bytedance.sdk.openadsdk.core.f0.n;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.b0;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: PAGExtraFuncationHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f387b;
    protected final q c;
    private com.bytedance.sdk.openadsdk.a.c.b d;
    private ImageView e;
    private PAGMediaView f;
    private PAGMediaView g;
    private com.bytedance.sdk.openadsdk.core.c0.a h;
    private WeakReference<com.bytedance.sdk.openadsdk.core.i0.f> i;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PAGExtraFuncationHelper.java */
    class C0166a extends com.bytedance.sdk.openadsdk.core.c0.c {
        C0166a(a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.c
        protected void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, boolean z) {
            try {
                ((PAGVideoMediaView) view).handleInterruptVideo();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: PAGExtraFuncationHelper.java */
    class b extends PAGMediaView {
        b(a aVar, Context context) {
            super(context);
        }

        private void a(boolean z) {
            Integer num = this.a;
            if (num != null) {
                com.bytedance.sdk.openadsdk.q.c.e.a(com.bytedance.sdk.openadsdk.q.c.e.a(num), z ? 4 : 8);
            }
        }

        @Override // android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            a(z);
        }
    }

    /* JADX INFO: compiled from: PAGExtraFuncationHelper.java */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.l();
        }
    }

    public a(Context context, q qVar, String str) {
        this.a = context;
        this.c = qVar;
        this.f387b = str;
    }

    public void a(com.bytedance.sdk.openadsdk.a.c.b bVar) {
        this.d = bVar;
    }

    public void a(boolean z) {
    }

    public View b() {
        if (o.a() == null) {
            m.b("TTNativeAdImpl", "getAdLogoView mContext == null");
            return null;
        }
        ImageView imageView = new ImageView(o.a());
        imageView.setImageResource(t.e(o.a(), "tt_ad_logo_new"));
        imageView.setOnClickListener(new c());
        return imageView;
    }

    public PAGMediaView c() {
        return this.g;
    }

    public String d() {
        q qVar = this.c;
        if (qVar != null) {
            return qVar.r();
        }
        return null;
    }

    public String e() {
        q qVar = this.c;
        if (qVar != null) {
            return qVar.B();
        }
        return null;
    }

    public PAGMediaView f() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x012f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0139  */
    public PAGMediaView g() {
        PAGMediaView bVar;
        com.bytedance.sdk.openadsdk.utils.b.a(this.c);
        PAGMediaView pAGVideoMediaView = null;
        if (!q.c(this.c)) {
            List<n> listD0 = this.c.d0();
            if (listD0 == null || listD0.isEmpty()) {
                ApmHelper.reportCustomError("images empty", "getMediaView return null", new RuntimeException());
            } else {
                ImageView imageView = new ImageView(this.a);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                n nVar = listD0.get(0);
                if (nVar != null) {
                    com.bytedance.sdk.openadsdk.h.d.a(nVar).a(u.BITMAP).a(com.bytedance.sdk.openadsdk.h.c.a(this.c, nVar.d(), imageView));
                }
                bVar = new b(this, this.a);
                bVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                bVar.addView(imageView, -1, -1);
                if (this.h == null || !com.bytedance.sdk.openadsdk.core.settings.n.j0().m(String.valueOf(this.c.S()))) {
                    imageView.setOnClickListener(null);
                    imageView.setOnTouchListener(null);
                } else {
                    imageView.setOnClickListener(this.h);
                    imageView.setOnTouchListener(this.h);
                }
                imageView.setTag(520093762, Boolean.TRUE);
                ImageView imageView2 = this.e;
                if (imageView2 != null) {
                    imageView2.setOnClickListener(null);
                    this.e.setOnTouchListener(null);
                }
                this.e = imageView;
            }
            if (bVar != null) {
                bVar.setMrcTrackerKey(com.bytedance.sdk.openadsdk.q.c.e.a(this.c));
            } else {
                bVar = new PAGMediaView(this.a);
            }
            this.g = bVar;
            return bVar;
        }
        com.bytedance.sdk.openadsdk.a.c.b bVar2 = this.d;
        if (bVar2 != null) {
            View viewF = bVar2.f();
            if (viewF != null) {
                if (viewF.getParent() instanceof ViewGroup) {
                    ((ViewGroup) viewF.getParent()).removeView(viewF);
                }
                PAGMediaView pAGMediaView = this.f;
                if (pAGMediaView != null) {
                    pAGMediaView.setOnClickListener(null);
                    this.f.setOnTouchListener(null);
                }
                pAGVideoMediaView = new PAGVideoMediaView(this.a, viewF, this);
                pAGVideoMediaView.setTag(520093762, Boolean.TRUE);
                if (this.h == null || !com.bytedance.sdk.openadsdk.core.settings.n.j0().m(String.valueOf(this.c.S()))) {
                    C0166a c0166a = new C0166a(this);
                    pAGVideoMediaView.setOnClickListener(c0166a);
                    pAGVideoMediaView.setOnTouchListener(c0166a);
                } else {
                    pAGVideoMediaView.setOnClickListener(this.h);
                    pAGVideoMediaView.setOnTouchListener(this.h);
                }
                this.f = pAGVideoMediaView;
                pAGVideoMediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            } else {
                ApmHelper.reportCustomError("adVideoView null", "getMediaView return null", new RuntimeException());
            }
        } else {
            ApmHelper.reportCustomError("mPAGFeedVideoAdImpl null", "getMediaView return null", new RuntimeException());
        }
        bVar = pAGVideoMediaView;
        if (bVar != null) {
            bVar.setMrcTrackerKey(com.bytedance.sdk.openadsdk.q.c.e.a(this.c));
        } else {
            bVar = new PAGMediaView(this.a);
        }
        this.g = bVar;
        return bVar;
    }

    public PAGImageItem h() {
        q qVar = this.c;
        if (qVar == null || qVar.b0() == null) {
            return null;
        }
        return new PAGImageItem(this.c.b0().b(), this.c.b0().e(), this.c.b0().d(), (float) this.c.b0().a());
    }

    public String i() {
        q qVar = this.c;
        if (qVar != null) {
            return qVar.K0();
        }
        return null;
    }

    public ImageView j() {
        return this.e;
    }

    public void k() {
        com.bytedance.sdk.openadsdk.core.i0.f fVar;
        WeakReference<com.bytedance.sdk.openadsdk.core.i0.f> weakReference = this.i;
        if (weakReference == null || (fVar = weakReference.get()) == null) {
            return;
        }
        fVar.a(13);
    }

    public void l() {
        Context context = this.a;
        if (context != null) {
            TTWebsiteActivity.a(context, this.c, this.f387b);
        }
    }

    /* JADX INFO: compiled from: PAGExtraFuncationHelper.java */
    class d implements com.bytedance.sdk.openadsdk.a.c.c {
        final /* synthetic */ PAGVideoAdListener a;

        d(a aVar, PAGVideoAdListener pAGVideoAdListener) {
            this.a = pAGVideoAdListener;
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void a(int i, int i2) {
            PAGVideoAdListener pAGVideoAdListener = this.a;
            if (pAGVideoAdListener != null) {
                pAGVideoAdListener.onVideoError();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void a(long j, long j2) {
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void b(PAGNativeAd pAGNativeAd) {
            PAGVideoAdListener pAGVideoAdListener = this.a;
            if (pAGVideoAdListener != null) {
                pAGVideoAdListener.onVideoAdComplete();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void c(PAGNativeAd pAGNativeAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void d(PAGNativeAd pAGNativeAd) {
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void e(PAGNativeAd pAGNativeAd) {
            PAGVideoAdListener pAGVideoAdListener = this.a;
            if (pAGVideoAdListener != null) {
                pAGVideoAdListener.onVideoAdPlay();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.a.c.c
        public void a(PAGNativeAd pAGNativeAd) {
            PAGVideoAdListener pAGVideoAdListener = this.a;
            if (pAGVideoAdListener != null) {
                pAGVideoAdListener.onVideoAdPaused();
            }
        }
    }

    public void a(NativeVideoTsView nativeVideoTsView) {
        new WeakReference(nativeVideoTsView);
    }

    public void a(com.bytedance.sdk.openadsdk.core.c0.a aVar) {
        this.h = aVar;
    }

    public View a() {
        q qVar;
        if (o.a() != null && (qVar = this.c) != null) {
            if (!qVar.k1() || !this.c.d()) {
                return null;
            }
            ImageView imageView = new ImageView(o.a());
            com.bytedance.sdk.openadsdk.n.c.b().a((int) b0.a(o.a(), 14.0f, true), imageView, this.c);
            return imageView;
        }
        m.b("TTNativeAdImpl", "getAdChoicesView mContext == null");
        return null;
    }

    public void a(PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.a.c.b bVar = this.d;
        if (bVar != null) {
            bVar.a(new d(this, pAGVideoAdListener));
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.i0.f fVar) {
        this.i = new WeakReference<>(fVar);
    }
}
