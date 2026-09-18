package com.mbridge.msdk.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatisticsOnNotifyListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends f {
    protected boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CampaignEx f2548b;
    protected List<CampaignEx> c;
    protected boolean d;
    protected com.mbridge.msdk.videocommon.download.a e;
    protected com.mbridge.msdk.videocommon.b.c f;
    protected String g;
    protected String h;
    protected com.mbridge.msdk.video.module.a.a i;
    protected int j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    public final void a(CampaignEx campaignEx) {
        this.f2548b = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public k(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i, boolean z) {
        this.d = false;
        this.i = new f();
        this.j = 1;
        if (!z && campaignEx != null && ak.b(str2) && aVar != null && aVar2 != null) {
            this.f2548b = campaignEx;
            this.h = str;
            this.g = str2;
            this.e = aVar;
            this.f = cVar;
            this.i = aVar2;
            this.a = true;
            this.j = i;
            this.d = false;
            return;
        }
        if (!z || campaignEx == null || !ak.b(str2) || aVar2 == null) {
            return;
        }
        this.f2548b = campaignEx;
        this.h = str;
        this.g = str2;
        this.e = aVar;
        this.f = cVar;
        this.i = aVar2;
        this.a = true;
        this.j = i;
        this.d = true;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        this.i.a(i, obj);
    }

    public final void a(int i) {
        if (this.f2548b != null) {
            if (i == 1 || i == 2) {
                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b, i, this.j);
            }
        }
    }

    public final void a() {
        if (!this.a || this.f2548b == null) {
            return;
        }
        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("2000061", this.f2548b.getId(), this.f2548b.getRequestId(), this.f2548b.getRequestIdNotice(), this.g, w.r(com.mbridge.msdk.foundation.controller.b.d().g()));
        nVar.b(this.f2548b.isMraid() ? com.mbridge.msdk.foundation.entity.n.a : com.mbridge.msdk.foundation.entity.n.f2098b);
        com.mbridge.msdk.foundation.same.report.n.b(nVar, com.mbridge.msdk.foundation.controller.b.d().g(), this.g);
    }

    public final void a(int i, String str) {
        if (this.f2548b != null) {
            com.mbridge.msdk.foundation.same.report.n.c(new com.mbridge.msdk.foundation.entity.n("2000062", this.f2548b.getId(), this.f2548b.getRequestId(), this.f2548b.getRequestIdNotice(), this.g, w.r(com.mbridge.msdk.foundation.controller.b.d().g()), i, str), com.mbridge.msdk.foundation.controller.b.d().g(), this.g);
        }
    }

    public final void b(int i) {
        CampaignEx campaignEx = this.f2548b;
        if (campaignEx != null) {
            String noticeUrl = campaignEx.getNoticeUrl();
            if (TextUtils.isEmpty(noticeUrl)) {
                return;
            }
            if (i == 1 || i == 2) {
                if (!noticeUrl.contains("endscreen_type")) {
                    StringBuilder sb = new StringBuilder(noticeUrl);
                    if (noticeUrl.contains("?")) {
                        sb.append("&endscreen_type=").append(i);
                    } else {
                        sb.append("?endscreen_type=").append(i);
                    }
                    noticeUrl = sb.toString();
                } else if (i == 2) {
                    if (noticeUrl.contains("endscreen_type=1")) {
                        noticeUrl = noticeUrl.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else if (noticeUrl.contains("endscreen_type=2")) {
                    noticeUrl = noticeUrl.replace("endscreen_type=2", "endscreen_type=1");
                }
                this.f2548b.setNoticeUrl(noticeUrl);
            }
        }
    }

    public final void b() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!k.this.a || k.this.f2548b == null || !ak.b(k.this.g) || com.mbridge.msdk.foundation.controller.b.d().g() == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.db.j jVarA = com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                    com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
                    fVar.a(System.currentTimeMillis());
                    fVar.b(k.this.g);
                    fVar.a(k.this.f2548b.getId());
                    jVarA.a(fVar);
                } catch (Throwable th) {
                    aa.b("NotifyListener", th.getMessage(), th);
                }
            }
        };
        com.mbridge.msdk.foundation.controller.c.a();
        com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
    }

    public final void c() {
        try {
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (k.this.a && k.this.f2548b != null && ak.b(k.this.g)) {
                            com.mbridge.msdk.videocommon.a.a.a().a(k.this.f2548b, k.this.g);
                        }
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        com.mbridge.msdk.videocommon.a.a.a().c(k.this.h, k.this.f2548b.getAdType());
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        aa.a("NotifyListener", th.getMessage());
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.c.a();
            com.mbridge.msdk.foundation.same.f.b.a().execute(runnable);
        } catch (Throwable th) {
            aa.b("NotifyListener", th.getMessage(), th);
        }
    }

    protected final void d() {
        com.mbridge.msdk.videocommon.download.a aVar = this.e;
        if (aVar != null) {
            aVar.f(true);
        }
    }

    protected final void e() {
        String str;
        try {
            CampaignEx campaignEx = this.f2548b;
            if (campaignEx != null && campaignEx.isDynamicView() && this.d && !this.f2548b.isCampaignIsFiltered()) {
                this.l = true;
                return;
            }
            if (!this.a || TextUtils.isEmpty(this.f2548b.getOnlyImpressionURL()) || com.mbridge.msdk.foundation.same.a.d.a == null || com.mbridge.msdk.foundation.same.a.d.a.containsKey(this.f2548b.getOnlyImpressionURL()) || this.l) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.a.put(this.f2548b.getOnlyImpressionURL(), Long.valueOf(System.currentTimeMillis()));
            String onlyImpressionURL = this.f2548b.getOnlyImpressionURL();
            if (this.f2548b.getSpareOfferFlag() == 1) {
                str = onlyImpressionURL + "&to=1&cbt=" + this.f2548b.getCbt() + "&tmorl=" + this.j;
            } else {
                str = onlyImpressionURL + "&to=0&cbt=" + this.f2548b.getCbt() + "&tmorl=" + this.j;
            }
            String str2 = str;
            if (!this.d || this.f2548b.isCampaignIsFiltered()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b, this.g, str2, false, true, com.mbridge.msdk.click.a.a.h);
                c();
            }
            this.l = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final void f() {
        String str;
        try {
            if (!this.a || this.k || TextUtils.isEmpty(this.f2548b.getImpressionURL())) {
                return;
            }
            this.k = true;
            if (this.f2548b.isBidCampaign() && this.f2548b != null) {
                try {
                    HashMap map = new HashMap();
                    List<com.mbridge.msdk.foundation.entity.c> listB = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(this.f2548b.getCampaignUnitId(), this.f2548b.getRequestId());
                    if (listB != null && listB.size() > 0 && listB.get(0) != null) {
                        if (listB.get(0).d() == 1) {
                            map.put("encrypt_p=", "encrypt_p=" + listB.get(0).b());
                            map.put("irlfa=", "irlfa=1");
                            for (Map.Entry entry : map.entrySet()) {
                                String str2 = (String) entry.getKey();
                                String str3 = (String) entry.getValue();
                                CampaignEx campaignEx = this.f2548b;
                                campaignEx.setImpressionURL(campaignEx.getImpressionURL().replaceAll(str2, str3));
                                CampaignEx campaignEx2 = this.f2548b;
                                campaignEx2.setOnlyImpressionURL(campaignEx2.getOnlyImpressionURL().replaceAll(str2, str3));
                            }
                        }
                        aa.a("BidReplaceCampignDao", "removeReplace count " + com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.b.d().g()).a(this.f2548b.getRequestId()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String impressionURL = this.f2548b.getImpressionURL();
            if (this.f2548b.getSpareOfferFlag() == 1) {
                str = impressionURL + "&to=1&cbt=" + this.f2548b.getCbt() + "&tmorl=" + this.j;
            } else {
                str = impressionURL + "&to=0&cbt=" + this.f2548b.getCbt() + "&tmorl=" + this.j;
            }
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b, this.g, str, false, true, com.mbridge.msdk.click.a.a.g);
            com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b);
            new Thread(new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g())).b(k.this.f2548b.getId());
                    } catch (Throwable th) {
                        aa.b("NotifyListener", th.getMessage(), th);
                    }
                }
            }).start();
            if (!this.a || com.mbridge.msdk.foundation.same.a.d.d == null || TextUtils.isEmpty(this.f2548b.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.a(this.g, this.f2548b, ReportUtil.EVENT_TYPE_REWARD);
        } catch (Throwable th) {
            aa.b("NotifyListener", th.getMessage(), th);
        }
    }

    protected final void g() {
        CampaignEx campaignEx;
        List<String> pv_urls;
        try {
            if (!this.a || this.m || (campaignEx = this.f2548b) == null) {
                return;
            }
            this.m = true;
            if ((campaignEx.isDynamicView() && this.d && !this.f2548b.isCampaignIsFiltered()) || (pv_urls = this.f2548b.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2548b, this.g, it.next(), false, true);
            }
        } catch (Throwable th) {
            aa.d("NotifyListener", th.getMessage());
        }
    }

    protected final void h() {
        CampaignEx campaignEx = this.f2548b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getCampaignUnitId()) || this.f2548b.getNativeVideoTracking() == null || this.f2548b.getNativeVideoTracking().o() == null) {
            return;
        }
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        CampaignEx campaignEx2 = this.f2548b;
        com.mbridge.msdk.click.a.a(contextG, campaignEx2, campaignEx2.getCampaignUnitId(), this.f2548b.getNativeVideoTracking().o(), false, false);
    }

    protected final void a(String str) {
        try {
            if (this.a) {
                q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                com.mbridge.msdk.foundation.entity.n nVar = null;
                if (!TextUtils.isEmpty(this.f2548b.getNoticeUrl())) {
                    int iR = w.r(com.mbridge.msdk.foundation.controller.b.d().g());
                    nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iR, this.f2548b.getNoticeUrl(), str, w.a(com.mbridge.msdk.foundation.controller.b.d().g(), iR));
                } else if (!TextUtils.isEmpty(this.f2548b.getClickURL())) {
                    int iR2 = w.r(com.mbridge.msdk.foundation.controller.b.d().g());
                    nVar = new com.mbridge.msdk.foundation.entity.n("2000021", iR2, this.f2548b.getClickURL(), str, w.a(com.mbridge.msdk.foundation.controller.b.d().g(), iR2));
                }
                if (nVar != null) {
                    nVar.q(this.f2548b.getId());
                    nVar.e(this.f2548b.getVideoUrlEncode());
                    nVar.s(str);
                    nVar.m(this.f2548b.getRequestId());
                    nVar.o(this.f2548b.getRequestIdNotice());
                    nVar.p(this.g);
                    qVarA.a(nVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final void b(String str) {
        List<CampaignEx> list;
        if (this.f2548b == null || (list = this.c) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("camp_position")) {
                this.f2548b = this.c.get(jSONObject.getInt("camp_position"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
