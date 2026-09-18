package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.m0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.UnknownHostException;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InneractiveAdRequest f924b;
    public final com.fyber.inneractive.sdk.response.g c;
    public com.fyber.inneractive.sdk.config.global.s d;
    public com.fyber.inneractive.sdk.model.vast.b e;
    public Context f;
    public boolean g;
    public m0 h;
    public final com.fyber.inneractive.sdk.flow.vast.b i;
    public int j;
    public final com.fyber.inneractive.sdk.flow.vast.c l;
    public final PriorityQueue<com.fyber.inneractive.sdk.flow.vast.a> k = new PriorityQueue<>(10, new com.fyber.inneractive.sdk.flow.vast.a.b());
    public com.fyber.inneractive.sdk.player.controller.c m = null;
    public final com.fyber.inneractive.sdk.web.d.InterfaceC0308d n = new a();
    public final com.fyber.inneractive.sdk.network.w<String> o = new b();
    public final int a = IAConfigManager.c().a().a("companion_retry_count", 2, 0);

    public class b implements com.fyber.inneractive.sdk.network.w<String> {
        public b() {
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(String str, Exception exc, boolean z) {
            String str2 = str;
            if (str2 != null) {
                m mVar = m.this;
                if (mVar.e != null) {
                    com.fyber.inneractive.sdk.flow.vast.c cVar = mVar.l;
                    if (!cVar.i) {
                        IAlog.a("FmpEndcardLoadingStarted", new Object[0]);
                        cVar.i = true;
                        m mVar2 = m.this;
                        mVar2.l.g.a(str2, mVar2.n);
                        return;
                    }
                }
            }
            if (exc == null || (exc instanceof com.fyber.inneractive.sdk.network.f) || z) {
                return;
            }
            m.a(m.this, exc);
        }
    }

    public class d implements com.fyber.inneractive.sdk.network.w<m0.a> {
        public final /* synthetic */ com.fyber.inneractive.sdk.model.vast.c a;

        public d(com.fyber.inneractive.sdk.model.vast.c cVar) {
            this.a = cVar;
        }

        @Override // com.fyber.inneractive.sdk.network.w
        public void a(m0.a aVar, Exception exc, boolean z) {
            View view;
            m0.a aVar2 = aVar;
            m.this.getClass();
            com.fyber.inneractive.sdk.flow.vast.a aVar3 = new com.fyber.inneractive.sdk.flow.vast.a();
            ImageView imageView = new ImageView(IAConfigManager.M.v.a());
            aVar3.f933b = imageView;
            imageView.setId(R.id.inneractive_vast_endcard_static);
            aVar3.f933b.setContentDescription("inneractive_vast_endcard_static");
            m.this.getClass();
            if ((exc == null && aVar2 != null && aVar2.f991b == null && aVar2.a != null) && (view = aVar3.f933b) != null) {
                ((ImageView) view).setImageBitmap(aVar2.a);
                aVar3.a = true;
                m.this.k.add(aVar3);
                return;
            }
            IAlog.a("%s Fetching companion image failed!", IAlog.a(m.this));
            com.fyber.inneractive.sdk.model.vast.c cVar = this.a;
            boolean zA = t0.a(cVar.f, cVar.f960b);
            m.this.getClass();
            if ((aVar2 == null || (aVar2.f991b != null && ((exc instanceof com.fyber.inneractive.sdk.network.b) || (exc instanceof UnknownHostException)))) && zA) {
                m mVar = m.this;
                if (mVar.j <= mVar.a) {
                    IAlog.a("%sloadStaticCompanion retry", IAlog.a(this));
                    m.this.b(this.a);
                    return;
                }
            }
            String str = null;
            if (!zA) {
                m mVar2 = m.this;
                mVar2.getClass();
                new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.q.VAST_COMPANION_INCOMPATIBLE_MIMETYPE, mVar2.f924b, mVar2.c, (JSONArray) null).a((String) null);
            }
            if (aVar2 != null && !TextUtils.isEmpty(aVar2.f991b)) {
                str = aVar2.f991b;
            }
            m.a(m.this, this.a.a(), str);
            m.this.a();
        }
    }

    public m(Context context, com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.s sVar, com.fyber.inneractive.sdk.flow.vast.b bVar) {
        this.e = gVar.e();
        this.f = context;
        this.c = gVar;
        this.f924b = inneractiveAdRequest;
        this.d = sVar;
        this.i = bVar;
        com.fyber.inneractive.sdk.web.b bVar2 = new com.fyber.inneractive.sdk.web.b(inneractiveAdRequest, gVar, this.d, this.e);
        com.fyber.inneractive.sdk.flow.vast.c cVar = new com.fyber.inneractive.sdk.flow.vast.c(new com.fyber.inneractive.sdk.player.controller.c(this.f, bVar, com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card, bVar2));
        this.l = cVar;
        bVar2.a(cVar);
    }

    public static void a(m mVar, JSONObject jSONObject, String str) {
        mVar.getClass();
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.q.VAST_COMPANION_FAILED_LOADING, mVar.f924b, mVar.c, mVar.d.c());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("companion_data", jSONObject);
        } catch (Exception unused) {
            IAlog.e("Got exception adding param to json object: %s, %s", "companion_data", jSONObject);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put("reason", str);
            } catch (Exception unused2) {
                IAlog.e("Got exception adding param to json object: %s, %s", "reason", str);
            }
        }
        aVar.f.put(jSONObject2);
        aVar.a((String) null);
    }

    public final void b() {
        com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.VAST_COMPANION_LOAD_ATTEMPT;
        InneractiveAdRequest inneractiveAdRequest = this.f924b;
        com.fyber.inneractive.sdk.response.g gVar = this.c;
        com.fyber.inneractive.sdk.config.global.s sVar = this.d;
        new com.fyber.inneractive.sdk.network.s.a(rVar, inneractiveAdRequest, gVar, sVar == null ? null : sVar.c()).a((String) null);
    }

    public void c() {
        com.fyber.inneractive.sdk.config.global.s sVar = this.d;
        if ((sVar == null || !((com.fyber.inneractive.sdk.config.global.features.f) sVar.a(com.fyber.inneractive.sdk.config.global.features.f.class)).a("enabled_fmp_endcard", false) || this.e.f == null) ? false : true) {
            IAlog.a("sending fmpHtmlRequest", new Object[0]);
            int i = IAlog.a;
            IAlog.a(1, null, "%s: %s", "COMPANION_TYPE", com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card.name());
            com.fyber.inneractive.sdk.config.global.s sVar2 = this.d;
            String strA = sVar2 != null ? ((com.fyber.inneractive.sdk.config.global.features.f) sVar2.a(com.fyber.inneractive.sdk.config.global.features.f.class)).a(CampaignEx.ENDCARD_URL, "") : null;
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.fyber.inneractive.sdk.network.g0 g0Var = new com.fyber.inneractive.sdk.network.g0(this.o, this.f, new com.fyber.inneractive.sdk.cache.c(strA));
            IAConfigManager.M.s.a.offer(g0Var);
            g0Var.a(q0.QUEUED);
        }
    }

    public class c implements com.fyber.inneractive.sdk.web.d.InterfaceC0308d {
        public final /* synthetic */ com.fyber.inneractive.sdk.flow.vast.e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.fyber.inneractive.sdk.model.vast.c f925b;

        public c(com.fyber.inneractive.sdk.flow.vast.e eVar, com.fyber.inneractive.sdk.model.vast.c cVar) {
            this.a = eVar;
            this.f925b = cVar;
        }

        @Override // com.fyber.inneractive.sdk.web.d.InterfaceC0308d
        public void a(com.fyber.inneractive.sdk.web.d dVar) {
            com.fyber.inneractive.sdk.flow.vast.e eVar = this.a;
            eVar.a = true;
            m.this.k.add(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:8:0x003b  */
        @Override // com.fyber.inneractive.sdk.web.d.InterfaceC0308d
        public void a(com.fyber.inneractive.sdk.web.d dVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
            boolean z;
            IAlog.a(IAlog.a(m.this) + " Fetching companion html failed!", new Object[0]);
            if (com.fyber.inneractive.sdk.model.vast.i.Gif.equals(this.f925b.f960b)) {
                com.fyber.inneractive.sdk.model.vast.c cVar = this.f925b;
                if (t0.a(cVar.f, cVar.f960b)) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            this.a.a = false;
            m mVar = m.this;
            if (mVar.j <= mVar.a && z) {
                IAlog.a("%sloadHtmlCompanion retry", IAlog.a(this));
                m.this.a(this.f925b);
                return;
            }
            if (!z) {
                new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.q.VAST_COMPANION_INCOMPATIBLE_MIMETYPE, mVar.f924b, mVar.c, (JSONArray) null).a((String) null);
            }
            m.a(m.this, this.f925b.a(), null);
            this.a.a = false;
            m.this.a();
        }
    }

    public final void b(com.fyber.inneractive.sdk.model.vast.c cVar) {
        b();
        int i = IAlog.a;
        IAlog.a(1, null, "%s: %s", "COMPANION_TYPE", cVar.a.name());
        this.j++;
        m0 m0Var = new m0(new d(cVar), cVar.f, this.d);
        this.h = m0Var;
        IAConfigManager.M.s.b(m0Var);
    }

    public class a implements com.fyber.inneractive.sdk.web.d.InterfaceC0308d {
        public a() {
        }

        @Override // com.fyber.inneractive.sdk.web.d.InterfaceC0308d
        public void a(com.fyber.inneractive.sdk.web.d dVar) {
            IAlog.a("%s Fetching companion fmp successfully ", IAlog.a(m.this));
            m.this.l.a = true;
        }

        @Override // com.fyber.inneractive.sdk.web.d.InterfaceC0308d
        public void a(com.fyber.inneractive.sdk.web.d dVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
            IAlog.a("%s Fetching companion fmp failed! will load default companion", IAlog.a(m.this));
            m mVar = m.this;
            mVar.l.a = false;
            m.a(mVar, inneractiveInfrastructureError.getCause());
        }
    }

    public void a() {
        boolean z;
        if (this.k.size() == 1) {
            return;
        }
        IAlog.a("%sloadNextVastCompanion called", IAlog.a(this));
        this.g = false;
        if (this.e == null) {
            IAlog.a("%svast data is null! Object must have already been destroyed", IAlog.a(this));
            z = false;
        } else {
            z = true;
        }
        if (this.e.g.size() == 0) {
            IAlog.b("%sgetNextIAvastCompanion - No companion ads found", IAlog.a(this));
            z = false;
        }
        if (!z) {
            IAlog.a("%sno more companion ads available.", IAlog.a(this));
            return;
        }
        com.fyber.inneractive.sdk.model.vast.b bVar = this.e;
        com.fyber.inneractive.sdk.model.vast.c cVarPoll = bVar.g.poll();
        bVar.h = cVarPoll;
        IAlog.a("%sgetNextIAvastCompanion returning: %s", IAlog.a(this), cVarPoll);
        this.j = 0;
        if (cVarPoll != null) {
            if (cVarPoll.a == com.fyber.inneractive.sdk.model.vast.h.Static && !com.fyber.inneractive.sdk.model.vast.i.Gif.equals(cVarPoll.f960b)) {
                b(cVarPoll);
            } else {
                a(cVarPoll);
            }
        }
    }

    public static void a(m mVar, Throwable th) {
        com.fyber.inneractive.sdk.config.global.s sVar = mVar.d;
        JSONArray jSONArrayC = sVar == null ? null : sVar.c();
        com.fyber.inneractive.sdk.flow.vast.c cVar = mVar.l;
        InneractiveAdRequest inneractiveAdRequest = mVar.f924b;
        com.fyber.inneractive.sdk.response.g gVar = mVar.c;
        cVar.getClass();
        IAlog.a("sending FMP_COMPANION_FAILED_LOADING event", new Object[0]);
        com.fyber.inneractive.sdk.network.s.a aVar = new com.fyber.inneractive.sdk.network.s.a(com.fyber.inneractive.sdk.network.q.FMP_COMPANION_FAILED_LOADING, inneractiveAdRequest, gVar, jSONArrayC);
        String message = th != null ? th.getMessage() : null;
        if (!TextUtils.isEmpty(message)) {
            aVar.a("error", message);
        }
        cVar.a(aVar);
        aVar.a((String) null);
    }

    public final void a(com.fyber.inneractive.sdk.model.vast.c cVar) {
        boolean zContainsKey;
        String str;
        com.fyber.inneractive.sdk.web.g gVar;
        int i = com.fyber.inneractive.sdk.util.r.a[com.fyber.inneractive.sdk.util.t.Mraid.ordinal()];
        if (i != 1) {
            zContainsKey = i != 2 ? false : com.fyber.inneractive.sdk.factories.b.a.a.a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST);
        } else {
            zContainsKey = com.fyber.inneractive.sdk.factories.b.a.a.a.containsKey(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML);
        }
        if (zContainsKey) {
            b();
            this.j++;
            int i2 = IAlog.a;
            IAlog.a(1, null, "%s: %s", "COMPANION_TYPE", cVar.a.name());
            com.fyber.inneractive.sdk.player.controller.c cVar2 = new com.fyber.inneractive.sdk.player.controller.c(this.f, this.i, cVar.a, null);
            com.fyber.inneractive.sdk.flow.vast.e eVar = new com.fyber.inneractive.sdk.flow.vast.e(cVar2);
            c cVar3 = new c(eVar, cVar);
            String strReplace = cVar.f;
            com.fyber.inneractive.sdk.model.vast.h hVar = cVar.a;
            if (hVar == com.fyber.inneractive.sdk.model.vast.h.Iframe) {
                String strC = com.fyber.inneractive.sdk.util.l.c("fyb_iframe_endcard_tmpl.html");
                if (!TextUtils.isEmpty(strC)) {
                    strReplace = strC.replace("$__IMGSRC__$", cVar.f).replace("$__SrcIframeUrl__$", cVar.f);
                }
            } else if (hVar == com.fyber.inneractive.sdk.model.vast.h.Static && cVar.f960b == com.fyber.inneractive.sdk.model.vast.i.Gif) {
                com.fyber.inneractive.sdk.web.c0 c0Var = eVar.g.a;
                if (c0Var != null && (gVar = c0Var.f1358b) != null) {
                    WebSettings settings = gVar.getSettings();
                    if (Build.VERSION.SDK_INT >= 17) {
                        settings.setMediaPlaybackRequiresUserGesture(false);
                    }
                    settings.setLoadWithOverviewMode(true);
                    settings.setUseWideViewPort(true);
                }
                com.fyber.inneractive.sdk.web.c0 c0Var2 = eVar.g.a;
                if (c0Var2 != null) {
                    c0Var2.E = false;
                }
                String strC2 = com.fyber.inneractive.sdk.util.l.c("fyb_static_endcard_tmpl.html");
                if (!TextUtils.isEmpty(strC2)) {
                    strReplace = strC2.replace("$__IMGSRC__$", cVar.f);
                }
                if (!TextUtils.isEmpty(strReplace) && (str = cVar.g) != null) {
                    strReplace = strReplace.replace("$__IMGHREF__$", str.replace("\"", "\\\""));
                }
            }
            cVar2.a(strReplace, cVar3);
        }
    }
}
