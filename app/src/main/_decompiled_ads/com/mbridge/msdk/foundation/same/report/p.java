package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.net.URLEncoder;

/* JADX INFO: compiled from: ReportController.java */
/* JADX INFO: loaded from: classes4.dex */
public class p {
    public static final String a = "p";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2182b;
    private int c;

    public p(Context context, int i) {
        this.c = 0;
        this.f2182b = context;
        this.c = i;
    }

    public p(Context context) {
        this.c = 0;
        this.f2182b = context.getApplicationContext();
    }

    public final void a(int i, String str) {
        new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a("event", q.a((Campaign) null, i, "request"), this.f2182b, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.1
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onFailed(String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onSuccess(String str2) {
            }
        });
    }

    public final void a(final com.mbridge.msdk.foundation.entity.l lVar, final Boolean bool) {
        if (lVar != null) {
            if (lVar.c().equals("GET")) {
                new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b).get(0, lVar.b(), null, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.12
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.p.12.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (p.this.f2182b != null && lVar != null) {
                                        com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(p.this.f2182b)).a(lVar.b());
                                        if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(p.this.f2182b)).b() <= 20) {
                                            return;
                                        }
                                        com.mbridge.msdk.foundation.controller.c.a().c();
                                    }
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.b(p.a, "reportNetError", e);
                                    }
                                }
                            }
                        });
                    }
                });
                return;
            }
            if (lVar.c().equals("POST")) {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
                if (TextUtils.isEmpty(lVar.d())) {
                    return;
                }
                com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(lVar.d(), this.f2182b, lVar.a());
                if (lVar.e() > 0) {
                    dVarA.a(TapjoyConstants.TJC_RETRY, lVar.e() + "");
                }
                aVar.post(0, lVar.b(), dVarA, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.13
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.p.13.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (p.this.f2182b == null || lVar == null) {
                                    return;
                                }
                                try {
                                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(p.this.f2182b)).a(lVar.d(), lVar.b(), lVar.f());
                                    if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(p.this.f2182b)).a() <= 0) {
                                        return;
                                    }
                                    com.mbridge.msdk.foundation.controller.c.a().c();
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.b(p.a, "reportNetError", e);
                                    }
                                }
                            }
                        });
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str) {
                        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.p.13.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (p.this.f2182b == null || lVar == null) {
                                    return;
                                }
                                com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(p.this.f2182b)).a(lVar);
                            }
                        });
                    }
                });
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            String str4 = "click_type=" + URLEncoder.encode("1", "utf-8") + "&" + BidResponsedEx.KEY_CID + "=" + URLEncoder.encode(str, "utf-8") + "&" + MBridgeConstans.PROPERTIES_UNIT_ID + "=" + URLEncoder.encode(str2, "utf-8") + "&" + SDKConstants.PARAM_KEY + "=" + URLEncoder.encode("2000027", "utf-8") + "&http_url=" + URLEncoder.encode(str3, "utf-8");
            if (k.a().c()) {
                k.a().a(str4);
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(str4, this.f2182b, str2), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.2
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str5) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str5) {
                    }
                });
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public final void a(String str, final File file) {
        new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b).post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(this.f2182b, str), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.3
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onFailed(String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onSuccess(String str2) {
                File file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
            }
        });
    }

    public final void a(final String str, String str2, String str3, Frame frame) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
        com.mbridge.msdk.foundation.same.net.g.d dVarA = q.a(str2, this.f2182b, str3);
        if (frame != null) {
            dVarA.a("session_id", frame.getSessionId());
            dVarA.a(CampaignUnit.JSON_KEY_PARENT_SESSION_ID, frame.getParentSessionId());
        }
        aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, dVarA, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.4
            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onFailed(String str4) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.d.b
            public final void onSuccess(String str4) {
                if ("click_duration".equals(str) || "load_duration".equals(str)) {
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.p.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.foundation.controller.c.a().c();
                        }
                    });
                }
            }
        });
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.d dVar, String str2) {
        com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
        String strA = com.mbridge.msdk.foundation.entity.d.a(dVar);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if (k.a().c()) {
            k.a().a(strA);
        } else {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(strA, this.f2182b, str2), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.5
                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onFailed(String str3) {
                }

                @Override // com.mbridge.msdk.foundation.same.report.d.b
                public final void onSuccess(String str3) {
                }
            });
        }
    }

    public final void a() {
        try {
            if (q.a()) {
                com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
                String strH = com.mbridge.msdk.foundation.controller.b.d().h();
                com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(strH);
                if (cVarB == null) {
                    cVarB = com.mbridge.msdk.c.d.a().b();
                }
                String str = "key=2000053&Appid=" + strH + "&uptips2=" + cVarB.K() + "&info_status=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().c() + "&iseu=" + cVarB.L();
                String strA = w.a();
                if (!TextUtils.isEmpty(strA)) {
                    str = str + "&gaid=" + strA;
                }
                String str2 = str + "&GDPR_area=" + cVarB.aB() + "&GDPR_consent=" + com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().f();
                if (k.a().c()) {
                    k.a().a(str2);
                    return;
                }
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(str2, this.f2182b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.6
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str3) {
                    }
                });
                q.b();
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }

    public final void a(int i, int i2, String str, String str2, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            StringBuilder sb = new StringBuilder();
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000058", "utf-8")).append("&").append(PangleConstants.APP_ID).append("=").append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.b.d().h(), "utf-8")).append("&").append("dl_type").append("=").append(URLEncoder.encode(i + "", "utf-8")).append("&").append("dl_link_type").append("=").append(URLEncoder.encode(i2 + "", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(str3, "utf-8")).append("&").append("tgt_v").append("=").append(URLEncoder.encode(w.k(this.f2182b) + "", "utf-8")).append("&").append("app_v_n").append("=").append(URLEncoder.encode(w.j(this.f2182b) + "", "utf-8")).append("&").append("app_v_c").append("=").append(URLEncoder.encode(w.i(this.f2182b) + "", "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(sb.toString(), this.f2182b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.7
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str4) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str4) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=").append(1).append("&");
            }
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000066", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(str3, "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str4, "utf-8")).append("&").append("err_method").append("=").append(str5);
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(sb.toString(), this.f2182b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.8
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append("hb=").append(1).append("&");
            }
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000065", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(str3, "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str4, "utf-8")).append("&").append(CampaignEx.JSON_KEY_CLICK_URL).append("=").append(URLEncoder.encode(str5, "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(sb.toString(), this.f2182b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.9
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            StringBuilder sb = new StringBuilder();
            sb.append(SDKConstants.PARAM_KEY).append("=").append(URLEncoder.encode("2000071", "utf-8")).append("&").append("rid").append("=").append(URLEncoder.encode(str, "utf-8")).append("&").append("rid_n").append("=").append(URLEncoder.encode(str2, "utf-8")).append("&").append(BidResponsedEx.KEY_CID).append("=").append(URLEncoder.encode(str3, "utf-8")).append("&").append(MBridgeConstans.PROPERTIES_UNIT_ID).append("=").append(URLEncoder.encode(str4, "utf-8")).append("&").append("reason").append("=").append(URLEncoder.encode(str5, "utf-8")).append("&").append("network_type").append("=").append(URLEncoder.encode(w.r(this.f2182b) + "", "utf-8")).append("&").append("result").append("=").append(URLEncoder.encode("0", "utf-8"));
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(sb.toString(), this.f2182b, str4), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.10
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.a aVar = new com.mbridge.msdk.foundation.same.report.d.a(this.f2182b);
            StringBuilder sb = new StringBuilder();
            StringBuilder sbAppend = sb.append(SDKConstants.PARAM_KEY).append("=").append("2000112").append("&").append("st_net").append("=").append(i2).append("&").append("result").append("=").append(i).append("&").append("type").append("=").append(i3).append("&").append("url").append("=").append(str2).append("&").append("reason").append("=");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sbAppend.append(str);
            if (k.a().c()) {
                k.a().a(sb.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.f.d.a().a, q.a(sb.toString(), this.f2182b, ""), new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.p.11
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onSuccess(String str3) {
                        aa.a("", "reportSettingLoadFailed onSuccess");
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void onFailed(String str3) {
                        aa.a("", "reportSettingLoadFailed onFailed:" + str3);
                    }
                });
            }
        } catch (Throwable unused) {
            aa.d(a, "reportSettingLoadFailed onFailed");
        }
    }
}
