package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.a.h.k;
import b.b.a.a.h.u;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderSurfaceView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.bytedance.sdk.openadsdk.utils.b0;
import com.bytedance.sdk.openadsdk.utils.h;
import com.facebook.internal.security.CertificateUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeVideoLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements b.a.a.a.a.a.a.g.b<q>, y.a, com.bykv.vk.openvk.component.video.api.renderview.a, com.bytedance.sdk.openadsdk.core.widget.d.b, com.bytedance.sdk.openadsdk.core.widget.e.c, b.a.a.a.a.a.a.e.a, com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a {
    b.c.a.a.a.a.c A;
    b.a.a.a.a.a.a.g.c B;
    com.bytedance.sdk.openadsdk.core.c0.a C;
    com.bytedance.sdk.openadsdk.core.c0.a D;
    boolean E;
    private NativeVideoTsView.h F;
    private long G;
    ViewGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.bykv.vk.openvk.component.video.api.renderview.b f686b;
    ImageView c;
    View d;
    View e;
    ImageView f;
    View g;
    View h;
    ImageView i;
    View j;
    CornerIV k;
    TextView l;
    TextView m;
    TextView n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    boolean t;
    int u;
    q v;
    Context w;
    com.bytedance.sdk.openadsdk.core.widget.e x;
    com.bytedance.sdk.openadsdk.core.video.nativevideo.a y;
    boolean z;

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class a implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        a() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            if (e.this.F != null) {
                e.this.F.a(view, i);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class b extends com.bytedance.sdk.openadsdk.core.c0.a {
        b(Context context, q qVar, String str, int i) {
            super(context, qVar, str, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a
        public boolean g() {
            View view;
            CornerIV cornerIV;
            TextView textView;
            View view2 = e.this.h;
            return (view2 != null && view2.getVisibility() == 0) || ((view = e.this.j) != null && view.getVisibility() == 0) || (((cornerIV = e.this.k) != null && cornerIV.getVisibility() == 0) || ((textView = e.this.l) != null && textView.getVisibility() == 0));
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.a
        public boolean j() {
            com.bytedance.sdk.openadsdk.core.widget.e eVar = e.this.x;
            boolean zC = eVar != null ? eVar.c() : false;
            m.d("ClickCreativeListener", "isVisible=" + zC + ",mPlayBtn.getVisibility() == VISIBLE->" + (e.this.c.getVisibility() == 0));
            return zC || e.this.c.getVisibility() == 0;
        }
    }

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class c implements com.bytedance.sdk.openadsdk.core.c0.b.a {
        c() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.c0.b.a
        public void a(View view, int i) {
            if (e.this.F != null) {
                e.this.F.a(view, i);
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.o()) {
                TextView textView = e.this.n;
                if (textView == null || textView.getVisibility() != 0) {
                    e eVar = e.this;
                    eVar.y.c(eVar, view);
                }
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class f implements Runnable {
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.i0.b a;

        f(com.bytedance.sdk.openadsdk.core.i0.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.i0.b bVar;
            CornerIV cornerIV = e.this.k;
            if (cornerIV == null || !cornerIV.isShown() || (bVar = this.a) == null) {
                return;
            }
            bVar.b(e.this.getVideoProgress());
        }
    }

    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class g extends b.b.a.a.k.g {
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ q e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, int i, String str2, q qVar) {
            super(str);
            this.c = i;
            this.d = str2;
            this.e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.c);
                jSONObject.put("description", this.c + CertificateUtil.DELIMITER + this.d);
                jSONObject.put("url", e.this.v.b0().d());
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.d.c.b(e.this.v, e.this.v != null ? a0.d(this.e.R()) : null, "load_vast_icon_fail", jSONObject);
        }
    }

    public e(Context context, ViewGroup viewGroup, boolean z, int i, q qVar, b.a.a.a.a.a.a.g.c cVar, boolean z2) {
        this.s = true;
        this.z = true;
        this.E = true;
        String str = Build.MODEL;
        if (this instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.d) {
            return;
        }
        this.w = o.a().getApplicationContext();
        b(z2);
        this.a = viewGroup;
        this.s = z;
        this.u = i;
        this.B = cVar;
        this.v = qVar;
        f(8);
        a(context, this.a);
        n();
        l();
    }

    private boolean h() {
        return q.c(this.v) && this.v.I0() == null && this.v.V() == 1;
    }

    public void a(long j) {
    }

    public void a(long j, long j2) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void b() {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(boolean z) {
        this.z = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.c0.a aVar = this.C;
            if (aVar != null) {
                aVar.b(true);
            }
            com.bytedance.sdk.openadsdk.core.c0.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.b(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.c0.a aVar3 = this.C;
        if (aVar3 != null) {
            aVar3.b(false);
        }
        com.bytedance.sdk.openadsdk.core.c0.a aVar4 = this.D;
        if (aVar4 != null) {
            aVar4.b(false);
        }
    }

    public boolean b(int i) {
        return false;
    }

    public void c(int i, int i2) {
        this.q = i;
        this.r = i2;
    }

    public void c(boolean z) {
    }

    public void d(int i) {
        m.d("Progress", "setSeekProgress-percent=" + i);
    }

    public boolean d() {
        return false;
    }

    public void e(int i) {
        b0.a((View) this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.f686b;
        if (bVar != null) {
            bVar.setVisibility(i);
        }
    }

    public void f(int i) {
        b0.a((View) this.a, i);
    }

    boolean g() {
        return (this.u & 4) != 4 || this.s;
    }

    @Override // b.a.a.a.a.a.a.g.b
    public View getMediaView() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.c0.a.InterfaceC0194a
    public long getVideoProgress() {
        if (this.G <= 0) {
            q qVar = this.v;
            if (qVar != null && qVar.N0() != null) {
                this.G = (long) (this.v.N0().s() * 1000.0d);
            }
            b.a.a.a.a.a.a.g.c cVar = this.B;
            if (cVar != null) {
                this.G = cVar.a();
            }
        }
        return this.G;
    }

    void i() {
        try {
            b0.a(this.h, 8);
            b0.a((View) this.i, 8);
            b0.a(this.j, 8);
            b0.a((View) this.k, 8);
            b0.a((View) this.l, 8);
            b0.a((View) this.m, 8);
            b0.a((View) this.n, 8);
        } catch (Exception unused) {
        }
    }

    public void j() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b k() {
        return this.f686b;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:31:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    void l() {
        String str;
        int i;
        int i2;
        String str2;
        b.c.a.a.a.a.c cVar;
        b.c.a.a.a.a.c cVar2;
        com.bytedance.sdk.openadsdk.core.c0.a aVar;
        String str3 = this.z ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.v.f1()) {
            i2 = 7;
            str2 = "rewarded_video";
        } else {
            if (!this.v.Y0()) {
                if (this.v.T0()) {
                    i2 = 2;
                    str2 = "banner_ad";
                } else {
                    str = str3;
                    i = 1;
                }
                if (this.v.e0() == 4) {
                    this.A = b.c.a.a.a.a.d.a(this.w, this.v, str);
                }
                com.bytedance.sdk.openadsdk.core.c0.a aVar2 = new com.bytedance.sdk.openadsdk.core.c0.a(this.w, this.v, str, i);
                this.C = aVar2;
                aVar2.a(this);
                this.C.c(true);
                if (this.z) {
                    this.C.b(true);
                } else {
                    this.C.b(false);
                    this.C.d(true);
                }
                this.C.a(this.B);
                this.C.a(true);
                this.C.a(new a());
                cVar = this.A;
                if (cVar != null && (aVar = this.C) != null) {
                    aVar.a(cVar);
                }
                if (h()) {
                    b bVar = new b(this.w, this.v, str, i);
                    this.D = bVar;
                    bVar.a(new c());
                    this.D.c(true);
                    if (this.z) {
                        this.D.b(true);
                    } else {
                        this.D.b(false);
                    }
                    this.D.a(this.B);
                    this.D.a(true);
                    cVar2 = this.A;
                    if (cVar2 != null) {
                        this.D.a(cVar2);
                    }
                    this.D.a(this);
                }
            }
            i2 = 5;
            str2 = "fullscreen_interstitial_ad";
        }
        i = i2;
        str = str2;
        if (this.v.e0() == 4) {
            this.A = b.c.a.a.a.a.d.a(this.w, this.v, str);
        }
        com.bytedance.sdk.openadsdk.core.c0.a aVar3 = new com.bytedance.sdk.openadsdk.core.c0.a(this.w, this.v, str, i);
        this.C = aVar3;
        aVar3.a(this);
        this.C.c(true);
        if (this.z) {
            this.C.b(true);
        } else {
            this.C.b(false);
            this.C.d(true);
        }
        this.C.a(this.B);
        this.C.a(true);
        this.C.a(new a());
        cVar = this.A;
        if (cVar != null) {
            aVar.a(cVar);
        }
        if (h()) {
            b bVar2 = new b(this.w, this.v, str, i);
            this.D = bVar2;
            bVar2.a(new c());
            this.D.c(true);
            if (this.z) {
                this.D.b(true);
            } else {
                this.D.b(false);
            }
            this.D.a(this.B);
            this.D.a(true);
            cVar2 = this.A;
            if (cVar2 != null) {
                this.D.a(cVar2);
            }
            this.D.a(this);
        }
    }

    void m() {
        if (this.y == null || this.x != null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.widget.e eVar = new com.bytedance.sdk.openadsdk.core.widget.e();
        this.x = eVar;
        eVar.a(this.w, this.a);
        this.x.a(this.y, this);
        m.a("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    void n() {
        this.f686b.a(this);
        this.c.setOnClickListener(new d());
    }

    boolean o() {
        if (this.y != null) {
            return true;
        }
        m.b("NewLiveViewLayout", "callback is null");
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.t = true;
        if (o()) {
            this.y.b(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.t = false;
        if (!o()) {
            return true;
        }
        this.y.a(this, surfaceTexture);
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public boolean p() {
        return this.s;
    }

    public boolean q() {
        return this.t;
    }

    public void r() {
        b0.a((View) this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.f686b;
        if (bVar != null) {
            b0.a(bVar.getView(), 0);
        }
    }

    public void s() {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        CornerIV cornerIV = this.k;
        if (cornerIV != null) {
            cornerIV.setImageBitmap(null);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder == this.f686b.getHolder() && o()) {
            this.y.a(this, surfaceHolder, i, i2, i3);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f686b.getHolder()) {
            return;
        }
        this.t = true;
        if (o()) {
            this.y.b(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.a
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f686b.getHolder()) {
            return;
        }
        this.t = false;
        if (o()) {
            this.y.a(this, surfaceHolder);
        }
    }

    public void t() {
        f(8);
        if (g()) {
            this.f686b.setVisibility(8);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        f(8);
        b0.a(this.h, 8);
        b0.a((View) this.i, 8);
        b0.a(this.j, 8);
        b0.a((View) this.k, 8);
        b0.a((View) this.l, 8);
        b0.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
        q qVar;
        b0.f(this.d);
        b0.f(this.e);
        if (this.f != null && (qVar = this.v) != null && qVar.N0() != null && this.v.N0().b() != null) {
            b0.f(this.f);
            com.bytedance.sdk.openadsdk.n.c.b().a(this.v.N0().b(), this.v.N0().c(), this.v.N0().a(), this.f, this.v);
        }
        if (this.c.getVisibility() == 0) {
            b0.a((View) this.c, 8);
        }
    }

    public void x() {
        b0.f(this.d);
        b0.f(this.e);
        if (this.c.getVisibility() == 0) {
            b0.a((View) this.c, 8);
        }
    }

    public boolean f() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        return eVar != null && eVar.c();
    }

    @Override // b.a.a.a.a.a.a.g.b
    public /* bridge */ /* synthetic */ void a(q qVar, WeakReference weakReference, boolean z) {
        a(qVar, (WeakReference<Context>) weakReference, z);
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.a.getParent() == null) {
            viewGroup.addView(this.a);
        }
        f(0);
    }

    public void a(NativeVideoTsView.h hVar) {
        this.F = hVar;
    }

    @Override // b.a.a.a.a.a.a.g.b
    public void e() {
        b0.d(this.d);
        b0.d(this.e);
        ImageView imageView = this.f;
        if (imageView != null) {
            b0.d(imageView);
        }
    }

    public void a(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.c0.a aVar = this.C;
        if (aVar != null) {
            aVar.a(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.c0.a aVar2 = this.D;
        if (aVar2 != null) {
            aVar2.a(pAGNativeAd);
        }
    }

    @Override // b.a.a.a.a.a.a.g.b
    public void c() {
        a(false, this.s);
        i();
    }

    private void c(int i) {
        b0.a(this.j, i);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeVideoLayout.java */
    class C0219e implements b.b.a.a.h.o<Bitmap> {
        final /* synthetic */ q a;

        C0219e(q qVar) {
            this.a = qVar;
        }

        @Override // b.b.a.a.h.o
        public void a(k<Bitmap> kVar) {
            if (kVar == null || kVar.c() == null) {
                return;
            }
            CornerIV cornerIV = e.this.k;
            if (cornerIV != null) {
                cornerIV.setImageBitmap(kVar.c());
            }
            com.bytedance.sdk.openadsdk.d.c.b(e.this.v, e.this.v != null ? a0.d(this.a.R()) : null, "load_vast_icon_success", (JSONObject) null);
        }

        @Override // b.b.a.a.h.o
        public void a(int i, String str, Throwable th) {
            e.this.a(i, str, this.a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.widget.RelativeLayout] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View, com.bykv.vk.openvk.component.video.api.renderview.b] */
    void a(Context context, View view) {
        ?? r6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        b.a.a.a.a.a.a.g.c cVar = this.B;
        if (cVar != null && cVar.isUseTextureView()) {
            SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(this.w);
            m.a("NewLiveViewLayout", "use TextureView......");
            r6 = sSRenderTextureView;
        } else {
            SSRenderSurfaceView sSRenderSurfaceView = new SSRenderSurfaceView(this.w);
            m.a("NewLiveViewLayout", "use SurfaceView......");
            r6 = sSRenderSurfaceView;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(r6, 0, layoutParams);
        }
        b0.a((View) r6, 8);
        this.f686b = r6;
        this.c = (ImageView) view.findViewById(h.J0);
        this.d = view.findViewById(h.G0);
        this.e = view.findViewById(h.I0);
        this.f = (ImageView) view.findViewById(h.H0);
        this.g = view.findViewById(h.D0);
        m.a("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void b(int i, int i2) {
        if (i == -1) {
            i = b0.i(this.w);
        }
        if (i <= 0) {
            return;
        }
        this.o = i;
        if (!p() && !d() && (this.u & 8) != 8) {
            this.p = a(i);
        } else {
            this.p = i2;
        }
        a(this.o, this.p);
    }

    public void b(boolean z, boolean z2) {
        ImageView imageView = this.c;
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(t.e(this.w, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageResource(t.e(this.w, "tt_stop_movebar_textpage"));
            }
        }
    }

    void a(View view, Context context) {
        View view2;
        if (view == null || context == null || (view2 = this.g) == null || view2.getParent() == null || this.h != null) {
            return;
        }
        this.h = this.g;
        this.i = (ImageView) view.findViewById(h.F0);
        this.j = view.findViewById(h.E0);
        this.k = (CornerIV) view.findViewById(h.K);
        this.l = (TextView) view.findViewById(h.L);
        this.m = (TextView) view.findViewById(h.M);
        this.n = (TextView) view.findViewById(h.N);
    }

    public boolean a(int i, b.a.a.a.a.a.a.f.b bVar, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.x;
        return eVar == null || eVar.a(i, bVar, z);
    }

    public void a(b.a.a.a.a.a.a.g.a aVar) {
        if (aVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
            this.y = (com.bytedance.sdk.openadsdk.core.video.nativevideo.a) aVar;
            m();
        }
    }

    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.a.setLayoutParams(layoutParams);
    }

    private int a(int i) {
        if (this.q <= 0 || this.r <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.w.getResources().getDimensionPixelSize(t.d(this.w, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.w.getResources().getDimensionPixelSize(t.d(this.w, "tt_video_container_minheight"));
        int i2 = (int) (this.r * ((i * 1.0f) / this.q));
        if (i2 > dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i2 < dimensionPixelSize2 ? dimensionPixelSize2 : i2;
    }

    @Override // b.a.a.a.a.a.a.g.b
    public void a(boolean z) {
        this.E = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void a(q qVar, WeakReference<Context> weakReference, boolean z) {
        String strB;
        q qVar2;
        q qVar3;
        if (qVar == null) {
            return;
        }
        a(false, this.s);
        a(this.a, o.a());
        View view = this.h;
        if (view != null) {
            b0.a(view, 0);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            b0.a((View) imageView, 0);
        }
        b0.a(this.j, 0);
        if (this.i != null && (qVar3 = this.v) != null && qVar3.N0() != null && this.v.N0().b() != null) {
            com.bytedance.sdk.openadsdk.n.c.b().a(this.v.N0().b(), this.v.N0().c(), this.v.N0().a(), this.i, qVar);
        }
        if (!TextUtils.isEmpty(qVar.F0())) {
            strB = qVar.F0();
        } else if (!TextUtils.isEmpty(qVar.K0())) {
            strB = qVar.K0();
        } else {
            strB = !TextUtils.isEmpty(qVar.B()) ? qVar.B() : "";
        }
        if (this.k != null && (qVar2 = this.v) != null && qVar2.b0() != null && this.v.b0().d() != null) {
            b0.a((View) this.k, 0);
            b0.a((View) this.l, 4);
            q qVar4 = this.v;
            if (qVar4 != null && qVar4.k1()) {
                com.bytedance.sdk.openadsdk.h.d.a(this.v.b0()).a(u.BITMAP).a(new com.bytedance.sdk.openadsdk.h.b(qVar, this.v.b0().d(), new C0219e(qVar)));
                if (this.v.M0() != null && this.v.M0().h() != null) {
                    this.v.M0().h().b(0L);
                }
            } else {
                com.bytedance.sdk.openadsdk.n.c.b().a(this.v.b0(), this.k, qVar);
            }
            q qVar5 = this.v;
            if (qVar5 != null && qVar5.k1()) {
                try {
                    this.k.setTag(570425345, "VAST_ICON");
                } catch (Throwable unused) {
                }
            }
            q qVar6 = this.v;
            if (qVar6 != null && qVar6.M0() != null && this.v.M0().h() != null) {
                com.bytedance.sdk.openadsdk.core.i0.b bVarH = this.v.M0().h();
                CornerIV cornerIV = this.k;
                if (cornerIV != null) {
                    cornerIV.post(new f(bVarH));
                }
            }
            if (h()) {
                this.k.setOnClickListener(this.D);
                this.k.setOnTouchListener(this.D);
            } else {
                this.k.setOnClickListener(this.C);
                this.k.setOnTouchListener(this.C);
            }
        } else if (!TextUtils.isEmpty(strB)) {
            b0.a((View) this.k, 4);
            b0.a((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(strB.substring(0, 1));
                if (h()) {
                    this.l.setOnClickListener(this.D);
                    this.l.setOnTouchListener(this.D);
                } else {
                    this.l.setOnClickListener(this.C);
                    this.l.setOnTouchListener(this.C);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(strB)) {
            this.m.setText(strB);
            this.m.setTag(570425345, "VAST_TITLE");
        }
        b0.a((View) this.m, 0);
        b0.a((View) this.n, 0);
        String strR = qVar.r();
        if (TextUtils.isEmpty(strR)) {
            int iE0 = qVar.e0();
            if (iE0 == 2 || iE0 == 3) {
                strR = t.k(this.w, "tt_video_mobile_go_detail");
            } else if (iE0 == 4) {
                strR = t.k(this.w, "tt_video_download_apk");
            } else if (iE0 != 5) {
                strR = t.k(this.w, "tt_video_mobile_go_detail");
            } else {
                strR = t.k(this.w, "tt_video_dial_phone");
            }
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(strR);
            this.n.setOnClickListener(this.C);
            this.n.setOnTouchListener(this.C);
        }
        if (this.E) {
            return;
        }
        c(4);
    }

    public e(Context context, ViewGroup viewGroup, boolean z, int i, q qVar, b.a.a.a.a.a.a.g.c cVar) {
        this(context, viewGroup, z, i, qVar, cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, q qVar) {
        com.bytedance.sdk.openadsdk.d.c.a(new g("load_vast_icon_fail", i, str, qVar));
    }

    public void a(boolean z, boolean z2, boolean z3) {
        b0.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 0);
    }

    public void a(boolean z, boolean z2) {
        b0.a((View) this.c, 8);
    }

    public void a() {
        a(true, false);
    }

    @Override // b.a.a.a.a.a.a.g.b
    public void a(Drawable drawable) {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            viewGroup.setBackgroundDrawable(drawable);
        }
    }
}
