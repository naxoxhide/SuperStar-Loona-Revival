package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.player.controller.t;
import com.fyber.inneractive.sdk.player.controller.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.x;
import com.fyber.inneractive.sdk.util.z;

/* JADX INFO: loaded from: classes2.dex */
public class h extends r<f0, InneractiveAdViewEventsListener> implements com.fyber.inneractive.sdk.interfaces.b, InneractiveNativeVideoContentController.Renderer, z.e {
    public FrameLayout l;
    public com.fyber.inneractive.sdk.player.ui.h m;
    public t n;
    public VideoContentListener o;
    public ViewGroup q;
    public n r;
    public Runnable u;
    public final com.fyber.inneractive.sdk.player.c.InterfaceC0276c p = new a();
    public float s = 0.0f;
    public Rect t = new Rect();
    public boolean v = false;
    public final t.a w = new b();

    public class a implements com.fyber.inneractive.sdk.player.c.InterfaceC0276c {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.player.c.InterfaceC0276c
        public void a(com.fyber.inneractive.sdk.player.c cVar) {
            t tVar = h.this.n;
            if (tVar != null) {
                tVar.d(false);
                h.this.n.h();
            }
        }
    }

    public static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.getClass();
        return z;
    }

    public final void J() {
        ViewGroup viewGroup;
        Runnable runnable = this.u;
        if (runnable == null || (viewGroup = this.q) == null) {
            return;
        }
        viewGroup.removeCallbacks(runnable);
        this.u = null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a(int i) {
    }

    @Override // com.fyber.inneractive.sdk.flow.r, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        u();
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public int f() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void n() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.d(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public int p() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public void pauseVideo() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.pauseVideo();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public void playVideo() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.b(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void r() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void u() {
        J();
        z.d.a.a(this.q);
        IAlog.a("%sunbind called. root is %s", IAlog.a(this), this.q);
        if (this.n != null) {
            IAlog.a("%sdestroying video ui controller", IAlog.a(this));
            this.n.a((w) null);
            this.n.destroy();
            this.n = null;
        }
        if (this.m != null) {
            this.q.setLayoutTransition(null);
            this.q.removeView(this.l);
            this.m.destroy();
            this.m = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.r
    public View y() {
        return this.l;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public boolean a(q qVar) {
        return qVar instanceof f0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a(ViewGroup viewGroup) {
        Bitmap bitmap;
        InneractiveAdSpot inneractiveAdSpot = this.a;
        if (inneractiveAdSpot == null) {
            IAlog.e("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.q = viewGroup;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (!(selectedUnitController instanceof InneractiveAdViewUnitController)) {
            IAlog.e("%sWrong type of unit controller found. Expecting InneractiveAdViewUnitController", IAlog.a(this));
        } else {
            InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
            if (selectedContentController != null) {
                if (selectedContentController instanceof InneractiveAdViewVideoContentController) {
                    this.o = ((InneractiveAdViewVideoContentController) selectedContentController).getEventsListener();
                } else {
                    IAlog.e("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                }
            }
        }
        this.v = false;
        this.l = new FrameLayout(viewGroup.getContext());
        AdContent adcontent = this.f928b;
        com.fyber.inneractive.sdk.player.h hVar = adcontent != 0 ? ((f0) adcontent).i : null;
        Context context = viewGroup.getContext();
        if (hVar != null) {
            ((com.fyber.inneractive.sdk.player.e) hVar.f).getClass();
            com.fyber.inneractive.sdk.renderers.a aVar = new com.fyber.inneractive.sdk.renderers.a(hVar);
            this.r = aVar;
            this.m = aVar.a(context, ((f0) this.f928b).c);
            this.n = (t) this.r.a(this.a, (f0) this.f928b);
            this.q.addView(this.l, new ViewGroup.LayoutParams(-1, -2));
            this.q.setLayoutTransition(null);
            this.l.addView((View) this.m, new FrameLayout.LayoutParams(-2, -2, 17));
            this.n.a(this.w);
            this.n.d(this.r.c());
            this.r.a(this.p);
            if ((this.r instanceof com.fyber.inneractive.sdk.renderers.a) && (bitmap = ((com.fyber.inneractive.sdk.player.e) hVar.f).k) != null) {
                this.n.a(bitmap);
            }
            z zVar = z.d.a;
            ViewGroup viewGroup2 = this.q;
            zVar.getClass();
            zVar.a(viewGroup2.getContext(), viewGroup2, this);
        }
    }

    public class b implements t.a {
        public b() {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void a(String str, String str2) {
            h hVar = h.this;
            hVar.getClass();
            IAlog.a("%s ad view video ad renderer callback: onSuspiciousNoUserWebActionDetected", IAlog.a(hVar));
            ViewGroup viewGroup = h.this.q;
            if (viewGroup == null || viewGroup.getContext() == null) {
                return;
            }
            h hVar2 = h.this;
            if (hVar2.v) {
                hVar2.getClass();
                IAlog.a("%s redirect already reported for this ad", IAlog.a(hVar2));
                return;
            }
            u.a(hVar2.q.getContext(), str, str2, h.this.f928b);
            h.this.v = true;
            h hVar3 = h.this;
            hVar3.getClass();
            IAlog.a("%s reporting auto redirect", IAlog.a(hVar3));
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void a(boolean z) {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void a(boolean z, Orientation orientation) {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.t.a
        public void c() {
            h hVar = h.this;
            EventsListener eventslistener = hVar.c;
            if (eventslistener != 0) {
                ((InneractiveAdViewEventsListener) eventslistener).onAdExpanded(hVar.a);
            }
            ViewGroup viewGroup = h.this.q;
            if (viewGroup == null || viewGroup.getContext() == null) {
                return;
            }
            h hVar2 = h.this;
            com.fyber.inneractive.sdk.display.a bVar = hVar2.f928b instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c();
            if (bVar instanceof com.fyber.inneractive.sdk.display.c) {
                Context context = hVar2.q.getContext();
                InneractiveAdSpot inneractiveAdSpot = h.this.a;
                Intent intent = new Intent(context, (Class<?>) InneractiveFullscreenAdActivity.class);
                intent.putExtra("spotId", inneractiveAdSpot.getLocalUniqueId());
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                try {
                    IAlog.a("%sIAInterstitialUtil: Opening interstitial for spot id: %s", IAlog.a(context), inneractiveAdSpot.getLocalUniqueId());
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    IAlog.c("%sIAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?", IAlog.a(context));
                }
            }
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void e() {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void g() {
            com.fyber.inneractive.sdk.model.vast.c cVar;
            com.fyber.inneractive.sdk.model.vast.i iVar;
            AdContent adcontent = h.this.f928b;
            if (adcontent != 0) {
                f0 f0Var = (f0) adcontent;
                if (f0Var.a == null || f0Var.f927b == 0) {
                    return;
                }
                String string = null;
                com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.response.g) f0Var.f927b).K;
                if (bVar != null && (cVar = bVar.h) != null && (iVar = cVar.f960b) != null) {
                    string = iVar.toString();
                }
                h.this.a(string);
            }
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void h() {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void j() {
            h.this.a(new WebViewRendererProcessHasGoneError());
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void k() {
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void l() {
            h hVar = h.this;
            f0 f0Var = (f0) hVar.f928b;
            if (f0Var.j) {
                return;
            }
            f0Var.j = true;
            hVar.E();
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void onCompleted() {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener == null || (hVar = hVar2.m) == null || !((com.fyber.inneractive.sdk.player.ui.d) hVar).e) {
                return;
            }
            videoContentListener.onCompleted();
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void onPlayerError() {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener == null || (hVar = hVar2.m) == null || !((com.fyber.inneractive.sdk.player.ui.d) hVar).e) {
                return;
            }
            videoContentListener.onPlayerError();
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void onProgress(int i, int i2) {
            com.fyber.inneractive.sdk.player.ui.h hVar;
            h hVar2 = h.this;
            VideoContentListener videoContentListener = hVar2.o;
            if (videoContentListener == null || (hVar = hVar2.m) == null || !((com.fyber.inneractive.sdk.player.ui.d) hVar).e) {
                return;
            }
            videoContentListener.onProgress(i, i2);
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public com.fyber.inneractive.sdk.ignite.k q() {
            return com.fyber.inneractive.sdk.ignite.k.NONE;
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void s() {
            h hVar = h.this;
            if (hVar.c != 0) {
                hVar.D();
            }
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public void a(View view, String str) {
            if (view == null || view.getContext() == null) {
                return;
            }
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
            h.this.D();
        }

        @Override // com.fyber.inneractive.sdk.player.controller.w
        public x.a a(k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
            Context context;
            h hVar = h.this;
            if (hVar.m.getContext() == null) {
                context = com.fyber.inneractive.sdk.util.l.a;
            } else {
                context = h.this.m.getContext();
            }
            AdContent adcontent = h.this.f928b;
            return hVar.a(context, adcontent != 0 ? ((f0) adcontent).k() : null, k0Var, eVar);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x004f A[PHI: r0
          0x004f: PHI (r0v5 java.lang.String) = (r0v0 java.lang.String), (r0v6 java.lang.String) binds: [B:21:0x003c, B:25:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.fyber.inneractive.sdk.player.controller.w
        public x.a a(String str, k0 k0Var, com.fyber.inneractive.sdk.web.b.a aVar, boolean z) {
            com.fyber.inneractive.sdk.model.vast.c cVar;
            com.fyber.inneractive.sdk.model.vast.i iVar;
            AdContent adcontent = h.this.f928b;
            String str2 = null;
            if (adcontent != 0) {
                f0 f0Var = (f0) adcontent;
                if (f0Var.a != null && f0Var.f927b != 0) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.response.g) f0Var.f927b).K;
                    h.this.a((bVar == null || z || (cVar = bVar.h) == null || (iVar = cVar.f960b) == null) ? null : iVar.toString());
                }
            }
            if (TextUtils.isEmpty(str)) {
                f0 f0Var2 = (f0) h.this.f928b;
                T t = f0Var2.f927b;
                if (t == 0) {
                    str = str2;
                } else {
                    com.fyber.inneractive.sdk.model.vast.c cVar2 = ((com.fyber.inneractive.sdk.response.g) t).K.h;
                    str2 = cVar2 != null ? cVar2.g : null;
                    if (str2 == null) {
                        str = f0Var2.k();
                    } else {
                        str = str2;
                    }
                }
            }
            h hVar = h.this;
            Context context = com.fyber.inneractive.sdk.util.l.a;
            ViewGroup viewGroup = hVar.q;
            if (viewGroup != null && viewGroup.getContext() != null) {
                context = hVar.q.getContext();
            }
            return hVar.a(context, str, k0Var, z ? com.fyber.inneractive.sdk.util.e.DEFAULT_ENDCARD : com.fyber.inneractive.sdk.util.e.VAST_ENDCARD);
        }
    }

    @Override // com.fyber.inneractive.sdk.util.z.e
    public void a(View view, float f, Rect rect) {
        if (this.s == f && this.t.equals(rect)) {
            return;
        }
        this.s = f;
        this.t.set(rect);
        t tVar = this.n;
        if (tVar != null) {
            tVar.b(false);
            ((com.fyber.inneractive.sdk.player.ui.d) this.m).b();
            this.n.a(f);
        }
        if (f > 0.0f) {
            J();
            i iVar = new i(this);
            this.u = iVar;
            this.q.postDelayed(iVar, 100L);
            return;
        }
        J();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public boolean a(View view) {
        return view.equals(this.q);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public void a() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.a();
        }
    }
}
