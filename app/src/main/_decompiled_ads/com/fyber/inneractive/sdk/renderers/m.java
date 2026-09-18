package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.q;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.w;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.x;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;

/* JADX WARN: Unexpected interfaces in signature: [com.fyber.inneractive.sdk.player.controller.w] */
/* JADX INFO: loaded from: classes2.dex */
public class m extends z<f0, InneractiveFullscreenAdEventsListener> implements com.fyber.inneractive.sdk.interfaces.c {
    public WeakReference<InneractiveFullscreenVideoContentController> A;
    public com.fyber.inneractive.sdk.interfaces.c.b E;
    public n G;
    public com.fyber.inneractive.sdk.interfaces.c.a x;
    public com.fyber.inneractive.sdk.player.ui.h y;
    public com.fyber.inneractive.sdk.player.controller.b z;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public UnitDisplayType F = UnitDisplayType.INTERSTITIAL;
    public boolean H = false;
    public final com.fyber.inneractive.sdk.player.c.InterfaceC0276c I = new a();
    public final RelativeLayout.LayoutParams J = new RelativeLayout.LayoutParams(-1, -1);
    public boolean K = false;
    public boolean L = false;

    public class a implements com.fyber.inneractive.sdk.player.c.InterfaceC0276c {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.player.c.InterfaceC0276c
        public void a(com.fyber.inneractive.sdk.player.c cVar) {
            m.this.z.d(false);
            m.this.z.h();
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.r
    public void H() {
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    public boolean J() {
        return this.K;
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    public int L() {
        Integer numB;
        AdContent adcontent = this.f928b;
        if (adcontent == 0) {
            return -1;
        }
        f0 f0Var = (f0) adcontent;
        if (f0Var.c == null || (numB = ((q) f0Var.c.a(q.class)).b("close_clickable_area_dp")) == null) {
            return -1;
        }
        return numB.intValue();
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    public int M() {
        Integer numB;
        AdContent adcontent = this.f928b;
        if (adcontent == 0) {
            return -1;
        }
        f0 f0Var = (f0) adcontent;
        if (f0Var.c == null || (numB = ((q) f0Var.c.a(q.class)).b("close_visible_size_dp")) == null) {
            return -1;
        }
        return numB.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c1  */
    @Override // com.fyber.inneractive.sdk.flow.z
    public long N() {
        long j;
        f0 f0Var;
        T t;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        com.fyber.inneractive.sdk.model.vast.c cVar;
        Integer numB;
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (B()) {
                Integer numB2 = ((com.fyber.inneractive.sdk.config.global.features.b) ((f0) this.f928b).c.a(com.fyber.inneractive.sdk.config.global.features.b.class)).b("end_card_skip_time_sec");
                int i = 0;
                int iIntValue = numB2 != null ? numB2.intValue() : 0;
                if (iIntValue >= 0 && iIntValue <= 5) {
                    i = iIntValue;
                }
                if (i > 0) {
                    return i;
                }
            }
            return 0L;
        }
        IAConfigManager iAConfigManager = IAConfigManager.M;
        com.fyber.inneractive.sdk.config.g gVarA = iAConfigManager.u.f886b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        long jIntValue = 3;
        gVarA.getClass();
        if (gVarA.a.containsKey("endcard_cr") || gVarA.a.containsKey("endcard_ci")) {
            String str = this.F != UnitDisplayType.REWARDED ? "endcard_ci" : "endcard_cr";
            try {
                j = gVarA.a.containsKey(str) ? Long.parseLong(gVarA.a.get(str)) : 3L;
            } catch (Exception unused) {
            }
            if (j >= 0 && j <= 5) {
                this.u = true;
                jIntValue = j;
            }
        } else {
            com.fyber.inneractive.sdk.config.i iVar = iAConfigManager.u.f886b;
            String string = Long.toString(3L);
            if (iVar.a.containsKey("vast_endcard_x_delay")) {
                string = iVar.a.get("vast_endcard_x_delay");
            }
            try {
                jIntValue = Long.parseLong(string);
            } catch (Throwable unused2) {
            }
            AdContent adcontent = this.f928b;
            if (adcontent != 0 && (t = (f0Var = (f0) adcontent).f927b) != 0 && (bVar = ((com.fyber.inneractive.sdk.response.g) t).K) != null && (cVar = bVar.h) != null && cVar.a == com.fyber.inneractive.sdk.model.vast.h.Static) {
                r rVar = (r) f0Var.c.a(r.class);
                if (rVar != null) {
                    int i2 = r.a.a[this.F.ordinal()];
                    if (i2 == 1) {
                        numB = rVar.b("endcard_x_btn_delay_rv");
                    } else if (i2 != 2) {
                        numB = null;
                    } else {
                        numB = rVar.b("endcard_x_btn_delay_iv");
                    }
                } else {
                    numB = null;
                }
                if (numB != null) {
                    jIntValue = numB.intValue();
                }
            }
        }
        com.fyber.inneractive.sdk.player.controller.b bVar2 = this.z;
        if (bVar2 != null) {
            bVar2.a(jIntValue * 1000);
        }
        return jIntValue * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    public boolean O() {
        com.fyber.inneractive.sdk.player.ui.h hVar = this.y;
        return hVar != null && ((com.fyber.inneractive.sdk.player.ui.l) hVar).f();
    }

    public final void R() {
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public void S() {
        if (this.C || this.c == 0) {
            return;
        }
        boolean z = true;
        this.C = true;
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar == null || (!aVar.wasDismissedByUser() && !IAConfigManager.M.u.f886b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a("dsos", false))) {
            z = false;
        }
        if (z) {
            a(t.EVENT_CLOSE);
            a(t.EVENT_CLOSE_LINEAR);
        }
        ((InneractiveFullscreenAdEventsListener) this.c).onAdDismissed(this.a);
    }

    public final void T() {
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.d == null || ((a0) f0Var.d).c == null) {
                return;
            }
            IAConfigManager.M.x.a(((a0) f0Var.d).c.f899b == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO, com.fyber.inneractive.sdk.cache.session.enums.a.CLICK);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0098  */
    @Override // com.fyber.inneractive.sdk.flow.z, com.fyber.inneractive.sdk.interfaces.c
    public void a(com.fyber.inneractive.sdk.interfaces.c.a aVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        boolean z;
        c0 c0Var;
        super.a(aVar, activity);
        this.x = aVar;
        this.B = false;
        this.C = false;
        this.L = false;
        InneractiveUnitController selectedUnitController = this.a.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (selectedUnitController instanceof InneractiveFullscreenUnitController) {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.A = new WeakReference<>((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        IAlog.e("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                    }
                }
            } else {
                IAlog.e("%sWrong type of unit controller found. Expecting InneractiveFullscreenUnitController", IAlog.a(this));
            }
        }
        b0 b0Var = this.a.getAdContent().d;
        if (b0Var != null && (c0Var = ((a0) b0Var).f) != null) {
            this.F = c0Var.j;
        }
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            ((f0) adcontent).i();
        }
        AdContent adcontent2 = this.f928b;
        com.fyber.inneractive.sdk.player.h hVar = adcontent2 != 0 ? ((f0) adcontent2).i : null;
        Context context = this.x.getLayout().getContext();
        if (hVar != null) {
            com.fyber.inneractive.sdk.player.a.InterfaceC0275a interfaceC0275a = hVar.f;
            if (interfaceC0275a == null) {
                z = false;
            } else {
                if (((com.fyber.inneractive.sdk.player.e) interfaceC0275a).f1002b != null) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                IAlog.e("%sFull screen video ad renderer is not valid.", IAlog.a(this));
                throw new InneractiveUnitController.AdDisplayError("Full screen video could not be loaded");
            }
            ((com.fyber.inneractive.sdk.player.e) interfaceC0275a).getClass();
            c cVar = new c(hVar);
            this.G = cVar;
            this.y = cVar.a(context, ((f0) this.f928b).c);
            com.fyber.inneractive.sdk.player.controller.b bVarA = this.G.a(this.a, (f0) this.f928b);
            this.z = bVarA;
            bVarA.d(this.G.c());
            this.z.a(this);
            ((com.fyber.inneractive.sdk.player.ui.d) this.y).b();
            this.J.addRule(13);
            this.x.getLayout().addView((View) this.y, this.J);
            this.k = ((View) this.y).findViewById(R.id.ia_click_overlay);
            this.G.a(this.I);
            this.B = true;
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.flow.z, com.fyber.inneractive.sdk.flow.r, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        R();
        if (this.B) {
            S();
        }
        com.fyber.inneractive.sdk.player.controller.b bVar = this.z;
        if (bVar != null) {
            bVar.destroy();
            this.z = null;
        }
        com.fyber.inneractive.sdk.player.ui.h hVar = this.y;
        if (hVar != null) {
            hVar.destroy();
            this.y = null;
        }
        this.x = null;
        this.A = null;
        super.destroy();
    }

    public void e() {
        if (!this.D) {
            this.v.a(true);
        }
        this.D = true;
    }

    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.ui.h hVar = this.y;
        if ((hVar != null && ((com.fyber.inneractive.sdk.player.ui.l) hVar).f()) && this.K) {
            return;
        }
        if (!z) {
            this.v.a();
            return;
        }
        com.fyber.inneractive.sdk.player.controller.b bVar = this.z;
        String string = null;
        com.fyber.inneractive.sdk.flow.vast.e eVarC = bVar != null ? bVar.c() : null;
        if (eVarC != null && eVarC.c) {
            com.fyber.inneractive.sdk.util.e eVar = com.fyber.inneractive.sdk.util.e.FMP_ENDCARD;
            eVar.a(eVarC.d);
            string = eVar.toString();
        }
        this.v.a(string);
    }

    public void g() {
        com.fyber.inneractive.sdk.model.vast.c cVar;
        com.fyber.inneractive.sdk.model.vast.i iVar;
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.a == null || f0Var.f927b == 0) {
                return;
            }
            String string = null;
            T();
            com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.response.g) ((f0) this.f928b).f927b).K;
            if (bVar != null && (cVar = bVar.h) != null && (iVar = cVar.f960b) != null) {
                string = iVar.toString();
            }
            a(string);
        }
    }

    public void h() {
        this.K = true;
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        if (!this.t) {
            this.t = true;
            com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
            if (aVar != null) {
                d(aVar.isCloseButtonDisplay());
            }
        }
        com.fyber.inneractive.sdk.interfaces.c.a aVar2 = this.x;
        if (aVar2 == null || !aVar2.isCloseButtonDisplay()) {
            return;
        }
        e(true ^ this.u);
    }

    public void j() {
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(false);
        }
        a(new WebViewRendererProcessHasGoneError());
    }

    public void k() {
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(true);
        }
    }

    public void l() {
        IAConfigManager.M.x.a(this.F == UnitDisplayType.INTERSTITIAL ? com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO, com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION);
        E();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public void m() {
        S();
        InneractiveAdSpot inneractiveAdSpot = this.a;
        if (inneractiveAdSpot == null || !(inneractiveAdSpot instanceof w)) {
            return;
        }
        ((w) inneractiveAdSpot).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.z, com.fyber.inneractive.sdk.interfaces.c
    public void o() {
        super.o();
        this.v.b();
    }

    public void onCompleted() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.q.a(this.A);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        com.fyber.inneractive.sdk.config.f0 f0Var = IAConfigManager.M.x;
        UnitDisplayType unitDisplayType = this.F;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.REWARDED;
        f0Var.a(unitDisplayType == unitDisplayType2 ? com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO, com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION);
        if (this.F == unitDisplayType2) {
            com.fyber.inneractive.sdk.interfaces.c.b bVar = this.E;
            if (bVar != null) {
                ((InneractiveFullscreenUnitController.a) bVar).a();
            }
            I();
        }
        AdContent adcontent = this.f928b;
        if (adcontent == 0 || ((f0) adcontent).i == null) {
            return;
        }
        K();
    }

    public void onPlayerError() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.q.a(this.A);
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    public void onProgress(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.q.a(this.A);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    public void s() {
        D();
    }

    @Override // com.fyber.inneractive.sdk.flow.z, com.fyber.inneractive.sdk.interfaces.c
    public void t() {
        super.t();
        com.fyber.inneractive.sdk.util.a aVar = this.v;
        if (aVar.f1330b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public boolean v() {
        com.fyber.inneractive.sdk.player.controller.b bVar;
        com.fyber.inneractive.sdk.interfaces.c.a aVar;
        com.fyber.inneractive.sdk.player.ui.h hVar;
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.i != null && (bVar = this.z) != null && (aVar = this.x) != null && (hVar = this.y) != null) {
                ((com.fyber.inneractive.sdk.player.e) f0Var.i.f).getClass();
                if (bVar == null) {
                    aVar.dismissAd(true);
                    return true;
                }
                if (((com.fyber.inneractive.sdk.player.ui.l) hVar).f()) {
                    if (!this.q) {
                        return true;
                    }
                    aVar.dismissAd(true);
                    return true;
                }
                if (!bVar.e()) {
                    return true;
                }
                bVar.c(true);
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.r
    public void x() {
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    @Override // com.fyber.inneractive.sdk.flow.z, com.fyber.inneractive.sdk.interfaces.c
    public void b(boolean z) {
        boolean z2;
        s sVar;
        f0 f0Var;
        T t;
        s sVar2;
        f(z);
        com.fyber.inneractive.sdk.player.ui.h hVar = this.y;
        if (hVar == null) {
            z2 = false;
        } else {
            View view = ((com.fyber.inneractive.sdk.player.ui.l) hVar).y;
            if (view != null && view.getVisibility() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (!z2 && !this.H) {
            com.fyber.inneractive.sdk.player.controller.b bVar = this.z;
            if (!((bVar == null || bVar.d()) ? false : true)) {
                AdContent adcontent = this.f928b;
                if (!((adcontent == 0 || (t = (f0Var = (f0) adcontent).f927b) == 0 || ((com.fyber.inneractive.sdk.response.g) t).K == null || (sVar2 = f0Var.c) == null || !((r) sVar2.a(r.class)).a("dual_endcard_enabled", false)) ? false : true)) {
                    R();
                    return;
                }
                com.fyber.inneractive.sdk.player.controller.b bVar2 = this.z;
                r rVar = null;
                com.fyber.inneractive.sdk.flow.vast.e eVarC = bVar2 != null ? bVar2.c() : null;
                if (!((eVarC == null || eVarC.f933b == null || !eVarC.a || eVarC.c) ? false : true)) {
                    R();
                    return;
                }
                this.K = false;
                this.q = false;
                com.fyber.inneractive.sdk.interfaces.c.a aVar = this.l;
                if (aVar != null) {
                    aVar.disableCloseButton();
                }
                this.v.a();
                P();
                K();
                com.fyber.inneractive.sdk.util.q.a(((com.fyber.inneractive.sdk.player.ui.l) this.y).p);
                this.G.a.a(eVarC.g);
                AdContent adcontent2 = this.f928b;
                if (adcontent2 != 0 && (sVar = ((f0) adcontent2).c) != null) {
                    rVar = (r) sVar.a(r.class);
                }
                com.fyber.inneractive.sdk.player.ui.h hVar2 = this.y;
                com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
                cVar.f1265b = true;
                cVar.g = eVarC.f933b;
                com.fyber.inneractive.sdk.model.vast.h hVar3 = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card;
                cVar.h = hVar3;
                boolean z3 = rVar != null && rVar.a("shouldEnableEndCardAutoClick", false);
                int i = 3;
                if (rVar != null) {
                    Integer numB = rVar.b("autoClickDelay");
                    int iIntValue = numB != null ? numB.intValue() : 3;
                    if (iIntValue >= 0 && iIntValue <= 10) {
                        i = iIntValue;
                    }
                }
                Integer numValueOf = Integer.valueOf(i);
                if (z3) {
                    cVar.f = numValueOf;
                }
                hVar2.a(new com.fyber.inneractive.sdk.player.ui.b(cVar));
                this.G.a.a(hVar3, 2);
                com.fyber.inneractive.sdk.interfaces.c.a aVar2 = this.x;
                if (aVar2 != null) {
                    aVar2.secondEndCardWasDisplayed();
                    return;
                }
                return;
            }
        }
        R();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public void a(com.fyber.inneractive.sdk.interfaces.c.b bVar) {
        this.E = bVar;
    }

    public x.a a(k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
        Context context;
        T();
        if (this.y.getContext() == null) {
            context = com.fyber.inneractive.sdk.util.l.a;
        } else {
            context = this.y.getContext();
        }
        AdContent adcontent = this.f928b;
        return a(context, adcontent != 0 ? ((f0) adcontent).k() : null, k0Var, eVar);
    }

    public void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar != null) {
            aVar.setActivityOrientation(z, orientation);
        }
    }

    public void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
        com.fyber.inneractive.sdk.interfaces.c.a aVar = this.x;
        if (aVar == null || aVar.getLayout() == null || this.x.getLayout().getContext() == null) {
            return;
        }
        if (!this.L) {
            u.a(this.x.getLayout().getContext(), str, str2, this.f928b);
            this.L = true;
            IAlog.a(IAlog.a(this) + "reporting auto redirect", new Object[0]);
            return;
        }
        IAlog.a(IAlog.a(this) + "redirect already reported for this ad", new Object[0]);
    }

    public x.a a(String str, k0 k0Var, com.fyber.inneractive.sdk.web.b.a aVar, boolean z) {
        Context context;
        com.fyber.inneractive.sdk.model.vast.i iVar;
        if (this.F == UnitDisplayType.INTERSTITIAL) {
            this.H = true;
        }
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.f927b != 0 && f0Var.f927b != 0) {
                com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.response.g) f0Var.f927b).K;
                T();
                if (bVar != null) {
                    com.fyber.inneractive.sdk.model.vast.c cVar = bVar.h;
                    a((cVar == null || (iVar = cVar.f960b) == null || z) ? null : iVar.toString());
                    com.fyber.inneractive.sdk.util.e eVar = z ? com.fyber.inneractive.sdk.util.e.DEFAULT_ENDCARD : com.fyber.inneractive.sdk.util.e.VAST_ENDCARD;
                    com.fyber.inneractive.sdk.player.controller.b bVar2 = this.z;
                    com.fyber.inneractive.sdk.flow.vast.e eVarC = bVar2 != null ? bVar2.c() : null;
                    if (aVar != null) {
                        eVar = com.fyber.inneractive.sdk.util.e.FMP_ENDCARD;
                        eVar.a(aVar.a);
                        eVar.a(aVar.f1356b);
                    } else if (eVarC != null && eVarC.c) {
                        eVar = com.fyber.inneractive.sdk.util.e.FMP_ENDCARD;
                        eVar.a(eVarC.e);
                        eVar.a(eVarC.d);
                    }
                    if (this.y.getContext() == null) {
                        context = com.fyber.inneractive.sdk.util.l.a;
                    } else {
                        context = this.y.getContext();
                    }
                    x.a aVarA = a(context, str, k0Var, eVar);
                    if (cVar != null && aVarA.a != x.d.FAILED) {
                        f0 f0Var2 = (f0) this.f928b;
                        String[] strArr = {t.EVENT_CLICK.toString()};
                        com.fyber.inneractive.sdk.player.h hVar = f0Var2.i;
                        if (hVar != null) {
                            hVar.a("EVENT_TRACKING", strArr);
                        }
                    }
                    return aVarA;
                }
            }
        }
        return new x.a(x.d.FAILED, new Exception("Internal SDK Error"), "null");
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean b(f0 f0Var) {
        com.fyber.inneractive.sdk.config.h hVar;
        T t;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        com.fyber.inneractive.sdk.model.vast.c cVar;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        com.fyber.inneractive.sdk.config.i iVar = iAConfigManager.u.f886b;
        iVar.getClass();
        String str = iAConfigManager.d;
        if (iVar.f885b.containsKey(str)) {
            hVar = iVar.f885b.get(str);
        } else {
            hVar = new com.fyber.inneractive.sdk.config.h();
        }
        if (hVar.a.containsKey(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD) || (t = f0Var.f927b) == 0 || (bVar = ((com.fyber.inneractive.sdk.response.g) t).K) == null || (cVar = bVar.h) == null || cVar.a != com.fyber.inneractive.sdk.model.vast.h.Static) {
            return false;
        }
        r rVar = (r) f0Var.c.a(r.class);
        UnitDisplayType unitDisplayType = this.F;
        rVar.getClass();
        int i = r.a.a[unitDisplayType.ordinal()];
        if (i == 1) {
            return rVar.a("countdown_rv", false);
        }
        if (i != 2) {
            return false;
        }
        return rVar.a("countdown_iv", false);
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.h hVar;
        AdContent adcontent = this.f928b;
        if (adcontent == 0 || (hVar = ((f0) adcontent).i) == null) {
            return;
        }
        hVar.a("TRACKING_COMPLETED", new String[0]);
        K();
        String[] strArr = new String[0];
        com.fyber.inneractive.sdk.player.h hVar2 = ((f0) this.f928b).i;
        if (hVar2 != null) {
            hVar2.a("TRACKING_COMPLETED", strArr);
        }
        if (IAConfigManager.M.u.f886b.a(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD).a("dsos", false) && z) {
            R();
        }
        f(z);
    }

    public void a(View view, String str) {
        if (view == null || view.getContext() == null) {
            return;
        }
        InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
        D();
    }

    @Override // com.fyber.inneractive.sdk.flow.z
    public long a(long j) {
        if (this.u) {
            return j;
        }
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.f886b;
        long j2 = 12;
        String string = Long.toString(12L);
        if (iVar.a.containsKey("vast_endcard_x_fallback_delay")) {
            string = iVar.a.get("vast_endcard_x_fallback_delay");
        }
        try {
            j2 = Long.parseLong(string);
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    public void a(t tVar) {
        AdContent adcontent = this.f928b;
        if (adcontent != 0) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.i != null) {
                String[] strArr = {tVar.e()};
                com.fyber.inneractive.sdk.player.h hVar = f0Var.i;
                if (hVar != null) {
                    hVar.a("EVENT_TRACKING", strArr);
                }
            }
        }
    }
}
