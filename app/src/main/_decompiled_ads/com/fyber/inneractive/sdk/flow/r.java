package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.integrity.IntegrityManager;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.p0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r<AdContent extends q, EventsListener extends InneractiveUnitController.EventsListener> implements InneractiveAdRenderer, InneractiveInternalBrowserActivity.InternalBrowserListener, com.fyber.inneractive.sdk.click.f.a, com.fyber.inneractive.sdk.web.t.g {
    public InneractiveAdSpot a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdContent f928b;
    public EventsListener c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = true;
    public Runnable h;
    public com.fyber.inneractive.sdk.click.l i;
    public com.fyber.inneractive.sdk.click.l.b j;
    public View k;

    public class a implements com.fyber.inneractive.sdk.click.l.b {
        public final /* synthetic */ k0 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.fyber.inneractive.sdk.util.e f929b;

        public a(k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
            this.a = k0Var;
            this.f929b = eVar;
        }

        @Override // com.fyber.inneractive.sdk.click.l.b
        public void a(com.fyber.inneractive.sdk.click.b bVar) {
            r rVar = r.this;
            rVar.getClass();
            IAlog.a("%s super click result: %s", IAlog.a(rVar), bVar);
            r rVar2 = r.this;
            if (rVar2.i == null) {
                rVar2.getClass();
                IAlog.a("%s click handler is null. Probably cancelled", IAlog.a(rVar2));
                return;
            }
            rVar2.i = null;
            rVar2.j = null;
            rVar2.H();
            if (bVar != null) {
                r rVar3 = r.this;
                k0 k0Var = this.a;
                com.fyber.inneractive.sdk.util.e eVar = this.f929b;
                rVar3.getClass();
                com.fyber.inneractive.sdk.click.l.d dVar = bVar.a;
                if (dVar == com.fyber.inneractive.sdk.click.l.d.OPEN_IN_EXTERNAL_APPLICATION || dVar == com.fyber.inneractive.sdk.click.l.d.OPEN_GOOGLE_STORE) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external application", new Object[0]);
                    List<com.fyber.inneractive.sdk.click.i> list = bVar.f;
                    com.fyber.inneractive.sdk.click.i iVar = list.get(list.size() - 1);
                    com.fyber.inneractive.sdk.click.l.d dVar2 = iVar.c;
                    if (dVar2 == com.fyber.inneractive.sdk.click.l.d.OPENED_IN_EXTERNAL_BROWSER) {
                        rVar3.a(iVar.a, dVar2);
                    }
                    if (rVar3.c != null) {
                        rVar3.G();
                    }
                } else if (dVar == com.fyber.inneractive.sdk.click.l.d.OPENED_IN_INTERNAL_BROWSER) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser", new Object[0]);
                    rVar3.d = true;
                    InneractiveInternalBrowserActivity.setInternalBrowserListener(rVar3);
                } else if (dVar == com.fyber.inneractive.sdk.click.l.d.OPENED_USING_CHROME_NAVIGATE || dVar == com.fyber.inneractive.sdk.click.l.d.OPENED_IN_EXTERNAL_BROWSER) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external browser", new Object[0]);
                    rVar3.a(bVar.d, bVar.a);
                    if (rVar3.c != null) {
                        rVar3.G();
                    }
                }
                if (rVar3.q() == com.fyber.inneractive.sdk.ignite.k.NONE || !(TextUtils.isEmpty(bVar.c) || bVar.c.equals("IgniteGooglePlay"))) {
                    rVar3.b(bVar, k0Var, eVar);
                }
            }
        }
    }

    public int A() {
        return -1;
    }

    public boolean B() {
        com.fyber.inneractive.sdk.config.global.s sVar;
        AdContent adcontent = this.f928b;
        return (adcontent == null || (sVar = adcontent.c) == null || sVar.a(com.fyber.inneractive.sdk.config.global.features.b.class) == null || ((ArrayList) ((com.fyber.inneractive.sdk.config.global.features.b) this.f928b.c.a(com.fyber.inneractive.sdk.config.global.features.b.class)).c()).size() <= 0) ? false : true;
    }

    public boolean C() {
        AdContent adcontent = this.f928b;
        if (adcontent != null) {
            return adcontent.e();
        }
        return true;
    }

    public void D() {
        com.fyber.inneractive.sdk.response.e eVarD;
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdClicked", IAlog.a(this));
            this.c.onAdClicked(this.a);
        }
        AdContent adcontent = this.f928b;
        if (adcontent == null || (eVarD = adcontent.d()) == null) {
            return;
        }
        IAConfigManager.M.x.a(eVarD.n, "LAST_CLICKED", "1");
    }

    public void E() {
        com.fyber.inneractive.sdk.response.e eVarD;
        OnGlobalImpressionDataListener onGlobalImpressionDataListener;
        if (this.e || this.c == null) {
            return;
        }
        IAlog.a("%sCalling external interface onAdImpression", IAlog.a(this));
        this.c.onAdImpression(this.a);
        AdContent adcontent = this.f928b;
        if (adcontent != null && (eVarD = adcontent.d()) != null) {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            com.fyber.inneractive.sdk.config.f0 f0Var = iAConfigManager.x;
            if (f0Var != null) {
                UnitDisplayType unitDisplayType = eVarD.n;
                ImpressionData impressionData = eVarD.r;
                f0Var.a(unitDisplayType, "LAST_DOMAIN_SHOWED", impressionData != null ? impressionData.getAdvertiserDomain() : null);
                f0Var.a(unitDisplayType, "LAST_APP_BUNDLE_ID", eVarD.y);
                if (this.f928b.isVideoAd()) {
                    f0Var.a(unitDisplayType, "LAST_VAST_SKIPED");
                    f0Var.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                }
                f0Var.a(unitDisplayType, "LAST_CLICKED");
            }
            com.fyber.inneractive.sdk.util.e0 e0Var = iAConfigManager.A;
            com.fyber.inneractive.sdk.config.b0 b0Var = this.f928b.d;
            ImpressionData impressionData2 = eVarD.r;
            e0Var.getClass();
            if (b0Var != null && (onGlobalImpressionDataListener = e0Var.a) != null) {
                com.fyber.inneractive.sdk.config.a0 a0Var = (com.fyber.inneractive.sdk.config.a0) b0Var;
                onGlobalImpressionDataListener.onImpression(a0Var.f866b, a0Var.a, impressionData2);
            }
            EventsListener eventslistener = this.c;
            if (eventslistener instanceof InneractiveFullscreenAdEventsListenerWithImpressionData) {
                ((InneractiveFullscreenAdEventsListenerWithImpressionData) eventslistener).onAdImpression(this.a, eVarD.r);
            } else if (eventslistener instanceof InneractiveAdViewEventsListenerWithImpressionData) {
                ((InneractiveAdViewEventsListenerWithImpressionData) eventslistener).onAdImpression(this.a, eVarD.r);
            }
        }
        this.e = true;
    }

    public void F() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a(this));
            this.c.onAdWillCloseInternalBrowser(this.a);
        }
    }

    public void G() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillOpenExternalApp", IAlog.a(this));
            this.c.onAdWillOpenExternalApp(this.a);
        }
        this.f = false;
    }

    public void H() {
        View viewY = y();
        if (viewY == null || this.k == null || viewY.getParent() == null || !(viewY.getParent() instanceof ViewGroup)) {
            return;
        }
        viewY.getLayoutParams();
        ((ViewGroup) viewY.getParent()).removeView(this.k);
        c(this.k);
        this.k = null;
    }

    public void I() {
        AdContent adcontent = this.f928b;
        if (adcontent == null || adcontent.d() == null) {
            return;
        }
        String str = this.f928b.d().o;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.d("%sfiring rewarded completion!", IAlog.a(this));
        int i = IAlog.a;
        IAlog.a(1, null, "AD_REWARDED_COMPLETION", new Object[0]);
        j0.b(str);
    }

    public void b(View view) {
    }

    public void b(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.k;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.d("%sfiring impression!", IAlog.a(this));
        int i = IAlog.a;
        IAlog.a(1, null, "AD_IMPRESSION", new Object[0]);
        j0.b(str);
    }

    public void c(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public boolean canRefreshAd() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        if (this.d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
            this.d = false;
        }
        Runnable runnable = this.h;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
            this.h = null;
        }
        this.f928b = null;
        this.c = null;
        this.a = null;
        if (this.i != null) {
            H();
            p0 p0Var = this.i.g;
            if (p0Var != null) {
                p0Var.a = true;
            }
            this.i = null;
            this.j = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.a = inneractiveAdSpot;
        this.f928b = (AdContent) inneractiveAdSpot.getAdContent();
        this.c = (EventsListener) inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public void onApplicationInBackground() {
        G();
        this.f = false;
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public void onInternalBrowserDismissed() {
        IAlog.a("onInternalBrowserDismissed callback called", new Object[0]);
        if (this.d) {
            this.d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
        }
        F();
        this.f = false;
    }

    public com.fyber.inneractive.sdk.ignite.k q() {
        AdContent adcontent = this.f928b;
        return (adcontent == null || !adcontent.f() || this.f928b.d() == null) ? com.fyber.inneractive.sdk.ignite.k.NONE : this.f928b.d().F;
    }

    public void x() {
        View viewY = y();
        if (viewY == null || viewY.getParent() == null || !(viewY.getParent() instanceof ViewGroup) || this.k != null) {
            return;
        }
        View viewInflate = ViewGroup.inflate(viewY.getContext(), R.layout.ia_click_overlay, null);
        this.k = viewInflate;
        if (viewInflate != null) {
            ((ViewGroup) viewY.getParent()).addView(this.k, viewY.getLayoutParams());
            b(this.k);
        }
    }

    public abstract View y();

    public int z() {
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b6  */
    public com.fyber.inneractive.sdk.util.x.a a(Context context, String str, k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
        String queryParameter;
        boolean z;
        String str2;
        AdContent adcontent;
        if (!this.g || this.d) {
            String str3 = this.d ? "external/browser is already open" : "click is in grace period";
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - %s", str3);
            return new com.fyber.inneractive.sdk.util.x.a(com.fyber.inneractive.sdk.util.x.d.FAILED, new Exception(str3), IntegrityManager.INTEGRITY_TYPE_NONE);
        }
        if (context != null) {
            IAlog.a("%sBlocking clicks until grace has ended", IAlog.a(this));
            this.g = false;
            Runnable runnable = this.h;
            if (runnable != null) {
                com.fyber.inneractive.sdk.util.m.f1343b.removeCallbacks(runnable);
            }
            s sVar = new s(this);
            this.h = sVar;
            com.fyber.inneractive.sdk.util.m.f1343b.postDelayed(sVar, 1000L);
        }
        D();
        if (TextUtils.isEmpty(str)) {
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - is empty", new Object[0]);
            return new com.fyber.inneractive.sdk.util.x.a(com.fyber.inneractive.sdk.util.x.d.FAILED, new Exception("empty url"), IntegrityManager.INTEGRITY_TYPE_NONE);
        }
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if ((iAConfigManager.E == null || (adcontent = this.f928b) == null || adcontent.d() == null || !this.f928b.d().b()) ? false : true) {
            iAConfigManager.E.a((com.fyber.inneractive.sdk.ignite.h) null);
        }
        this.j = new a(k0Var, eVar);
        if (TextUtils.isEmpty(str)) {
            queryParameter = null;
        } else {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (scheme == null || !scheme.equals("fybernativebrowser") || host == null || !host.equals("navigate")) {
                queryParameter = null;
            } else {
                queryParameter = uri.getQueryParameter("url");
            }
        }
        String scheme2 = !TextUtils.isEmpty(str) ? Uri.parse(str).getScheme() : null;
        if (TextUtils.isEmpty(queryParameter)) {
            z = !str.contains("FYBER_OPEN_BROWSER");
            str2 = str;
        } else {
            str2 = queryParameter;
            z = false;
        }
        if (y() != null) {
            x();
        }
        com.fyber.inneractive.sdk.click.l lVar = new com.fyber.inneractive.sdk.click.l(z);
        lVar.h.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.h(scheme2, !z), new com.fyber.inneractive.sdk.click.f(this, k0Var, eVar), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.g(), new com.fyber.inneractive.sdk.click.j()));
        this.i = lVar;
        AdContent adcontent2 = this.f928b;
        com.fyber.inneractive.sdk.web.t tVarC = adcontent2 != null ? adcontent2.c() : null;
        if (tVarC != null) {
            tVarC.i = this;
        }
        AdContent adcontent3 = this.f928b;
        boolean z2 = adcontent3 != null && adcontent3.a(k0Var.c, eVar);
        AdContent adcontent4 = this.f928b;
        if (adcontent4 != null && adcontent4.d() != null) {
            this.f928b.i();
        }
        com.fyber.inneractive.sdk.click.l lVar2 = this.i;
        com.fyber.inneractive.sdk.click.l.b bVar = this.j;
        AdContent adcontent5 = this.f928b;
        lVar2.a(context, str2, bVar, tVarC, z2, (adcontent5 == null || adcontent5.d() == null) ? com.fyber.inneractive.sdk.ignite.k.NONE : this.f928b.d().F, this.a.getLocalUniqueId());
        return new com.fyber.inneractive.sdk.util.x.a(com.fyber.inneractive.sdk.util.x.d.OPEN_IN_EXTERNAL_APPLICATION, null, context.getClass().getName());
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0174  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b0  */
    public final void b(com.fyber.inneractive.sdk.click.b bVar, k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
        boolean z;
        com.fyber.inneractive.sdk.config.global.s sVar;
        com.fyber.inneractive.sdk.config.global.s sVar2;
        com.fyber.inneractive.sdk.config.global.s sVar3;
        AdContent adcontent = this.f928b;
        InneractiveAdRequest inneractiveAdRequest = adcontent != null ? adcontent.a : null;
        com.fyber.inneractive.sdk.response.e eVarD = adcontent != null ? adcontent.d() : null;
        AdContent adcontent2 = this.f928b;
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.r.FYBER_SUCCESS_CLICK, inneractiveAdRequest, eVarD, (adcontent2 == null || (sVar3 = adcontent2.c) == null) ? null : sVar3.c());
        com.fyber.inneractive.sdk.network.s.b bVar2 = new com.fyber.inneractive.sdk.network.s.b();
        long j = bVar.e;
        if (j != 0) {
            bVar2.a("time_passed", Long.valueOf(j));
        }
        JSONArray jSONArray = new JSONArray();
        for (com.fyber.inneractive.sdk.click.i iVar : bVar.f) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", iVar.a);
                jSONObject.put("success", iVar.f860b);
                jSONObject.put("opened_by", iVar.c);
                jSONObject.put("reason", iVar.d);
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject);
        }
        bVar2.a("urls", jSONArray);
        bVar2.a("origin", eVar);
        if (eVar == com.fyber.inneractive.sdk.util.e.FMP_ENDCARD) {
            bVar2.a("version", eVar.e());
        }
        if (k0Var != null && k0Var.c) {
            bVar2.a("is_auto_click", Boolean.TRUE);
        }
        boolean z2 = false;
        if (k0Var != null) {
            if (k0Var.a > 0.0f && k0Var.f1341b > 0.0f) {
                boolean zC = C();
                int iA = A();
                if (!zC) {
                    iA = com.fyber.inneractive.sdk.util.l.b(iA);
                }
                float f = iA == 0 ? 0.0f : k0Var.a / iA;
                boolean zC2 = C();
                int iZ = z();
                if (!zC2) {
                    iZ = com.fyber.inneractive.sdk.util.l.b(iZ);
                }
                float f2 = iZ != 0 ? k0Var.f1341b / iZ : 0.0f;
                IAlog.a("Point location -  x - %.2f , y- %.2f", Float.valueOf(f), Float.valueOf(f2));
                C();
                Locale locale = Locale.ENGLISH;
                com.fyber.inneractive.sdk.network.s.b bVarA = bVar2.a("td_x", String.format(locale, "%.2f", Float.valueOf(f)));
                C();
                bVarA.a("td_y", String.format(locale, "%.2f", Float.valueOf(f2)));
            }
        }
        if (C()) {
            bVar2.a("o", com.fyber.inneractive.sdk.util.l.c() == 1 ? "p" : "l");
        } else {
            bVar2.a("b_w", Integer.valueOf(A()));
            bVar2.a("b_h", Integer.valueOf(z()));
        }
        AdContent adcontent3 = this.f928b;
        com.fyber.inneractive.sdk.config.global.features.c cVar = (adcontent3 == null || (sVar2 = adcontent3.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.c) sVar2.a(com.fyber.inneractive.sdk.config.global.features.c.class);
        if (cVar == null) {
            z = false;
        } else {
            com.fyber.inneractive.sdk.model.vast.a aVar2 = cVar.e;
            if (aVar2 != null ? aVar2.d : false) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            if (com.fyber.inneractive.sdk.util.e.DEFAULT_ENDCARD.equals(eVar) || com.fyber.inneractive.sdk.util.e.VIDEO_CTA.equals(eVar)) {
                z2 = true;
            } else if (com.fyber.inneractive.sdk.util.e.VIDEO_CLICK.equals(eVar)) {
                AdContent adcontent4 = this.f928b;
                com.fyber.inneractive.sdk.config.global.features.r rVar = (adcontent4 == null || (sVar = adcontent4.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.r) sVar.a(com.fyber.inneractive.sdk.config.global.features.r.class);
                if (rVar != null && rVar.a("show_cta", true)) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            bVar2.a("cta_lng", IAConfigManager.M.p);
        }
        aVar.f.put(bVar2.a);
        aVar.a((String) null);
    }

    public void a(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.l;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        int i = IAlog.a;
        IAlog.a(1, null, "AD_CLICKED", new Object[0]);
        j0.b(str);
    }

    @Override // com.fyber.inneractive.sdk.click.f.a
    public void a(com.fyber.inneractive.sdk.click.b bVar, k0 k0Var, com.fyber.inneractive.sdk.util.e eVar) {
        b(bVar, k0Var, eVar);
    }

    public final void a(String str, com.fyber.inneractive.sdk.click.l.d dVar) {
        com.fyber.inneractive.sdk.response.e eVarD;
        JSONArray jSONArrayC;
        InneractiveAdRequest inneractiveAdRequest;
        AdContent adcontent = this.f928b;
        if (adcontent != null) {
            eVarD = adcontent.d();
            AdContent adcontent2 = this.f928b;
            inneractiveAdRequest = adcontent2.a;
            com.fyber.inneractive.sdk.config.global.s sVar = adcontent2.c;
            jSONArrayC = sVar != null ? sVar.c() : null;
        } else {
            eVarD = null;
            jSONArrayC = null;
            inneractiveAdRequest = null;
        }
        com.fyber.inneractive.sdk.network.s.a aVarA = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.r.EXTERNAL_BROWSER_OPENED, inneractiveAdRequest, eVarD, jSONArrayC).a("url", str);
        Object[] objArr = new Object[2];
        objArr[0] = "fallback";
        objArr[1] = (dVar == com.fyber.inneractive.sdk.click.l.d.OPENED_USING_CHROME_NAVIGATE || dVar == com.fyber.inneractive.sdk.click.l.d.OPENED_IN_EXTERNAL_BROWSER) ? "chrome" : "na";
        aVarA.a(objArr).a((String) null);
    }

    public void a(String str) {
        if (this.f) {
            return;
        }
        this.f = true;
        com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.VAST_EVENT_COMPANION_CLICKED;
        AdContent adcontent = this.f928b;
        InneractiveAdRequest inneractiveAdRequest = adcontent != null ? adcontent.a : null;
        com.fyber.inneractive.sdk.response.e eVarD = adcontent != null ? adcontent.d() : null;
        AdContent adcontent2 = this.f928b;
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(rVar, inneractiveAdRequest, eVarD, adcontent2 != null ? adcontent2.c.c() : null);
        JSONObject jSONObject = new JSONObject();
        if (str == null) {
            str = "na";
        }
        try {
            jSONObject.put("mime", str);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "mime", str);
        }
        aVar.f.put(jSONObject);
        aVar.a((String) null);
    }

    public void a(InneractiveUnitController.AdDisplayError adDisplayError) {
        String simpleName = adDisplayError.getClass().getSimpleName();
        String message = adDisplayError.getMessage();
        AdContent adcontent = this.f928b;
        com.fyber.inneractive.sdk.network.t.a(simpleName, message, adcontent != null ? adcontent.a : null, adcontent != null ? adcontent.d() : null);
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdEnteredErrorState: %s", IAlog.a(this), adDisplayError.getMessage());
            this.c.onAdEnteredErrorState(this.a, adDisplayError);
        }
    }

    public void a(com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.b bVar) {
        com.fyber.inneractive.sdk.cache.session.d dVar = IAConfigManager.M.x.a;
        if (dVar != null) {
            com.fyber.inneractive.sdk.util.m.a(new com.fyber.inneractive.sdk.cache.session.c(dVar, aVar, bVar));
        }
    }
}
