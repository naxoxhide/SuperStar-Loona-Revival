package com.mbridge.msdk.mbbid.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: RequesManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2278b;
    private String c;
    private BidListennning e;
    private BidResponsedEx f;
    private int g;
    private long i;
    private long j;
    private boolean k;
    private int l;
    private boolean h = false;
    private Context d = com.mbridge.msdk.foundation.controller.b.d().g();

    public final void a(boolean z) {
        this.k = z;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void a(long j) {
        this.i = j;
    }

    public final void b(long j) {
        this.j = j;
    }

    public b(String str, String str2, String str3) {
        this.a = str;
        this.f2278b = str2;
        this.c = str3;
    }

    public final void b(boolean z) {
        try {
            if (!this.h) {
                this.h = true;
                if (this.d == null) {
                    a("context is null");
                }
                com.mbridge.msdk.mbbid.common.b.a aVar = new com.mbridge.msdk.mbbid.common.b.a(this.d);
                d dVar = new d();
                String strH = com.mbridge.msdk.foundation.controller.b.d().h();
                dVar.a("app_id", strH);
                dVar.a("sign", SameMD5.getMD5(strH + com.mbridge.msdk.foundation.controller.b.d().j()));
                dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f2278b);
                if (!TextUtils.isEmpty(this.a)) {
                    dVar.a(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, this.a);
                }
                dVar.a("bid_floor", this.c);
                dVar.a(d.c, af.b(this.d, this.f2278b));
                dVar.a(d.f2148b, com.mbridge.msdk.foundation.same.a.d.a(this.f2278b, ""));
                String str = "1";
                dVar.a("req_type", this.k ? "1" : "2");
                dVar.a("orientation", w.h(this.d) + "");
                int i = this.g;
                if (i == 296) {
                    if (this.i > 0 && this.j > 0) {
                        dVar.a(CampaignUnit.JSON_KEY_UNIT_SIZE, this.j + "x" + this.i);
                        try {
                            Method method = Class.forName("com.mbridge.msdk.mbbanner.common.util.BannerUtils").getMethod("getCloseIds", String.class);
                            if (method.invoke(null, this.f2278b) instanceof String) {
                                dVar.a("close_id", method.invoke(null, this.f2278b).toString());
                            }
                        } catch (Exception unused) {
                            a("banner module is miss");
                            return;
                        }
                    } else {
                        a("bid required param is missing or error");
                        return;
                    }
                } else if (i == 297) {
                    if (this.i > 0 && this.j > 0) {
                        dVar.a(CampaignUnit.JSON_KEY_UNIT_SIZE, this.j + "x" + this.i);
                        dVar.a("orientation", this.l + "");
                    } else {
                        a("ad display area is too small");
                        return;
                    }
                } else if (i != 298) {
                    if (!z) {
                        str = "0";
                    }
                    dVar.a("rw_plus", str);
                } else if (this.i > 0 && this.j > 0) {
                    dVar.a(CampaignUnit.JSON_KEY_UNIT_SIZE, this.j + "x" + this.i);
                } else {
                    a("bid required param is missing or error");
                    return;
                }
                final String md5 = SameMD5.getMD5(af.c());
                dVar.a(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
                a aVar2 = new a(this.a, this.f2278b) { // from class: com.mbridge.msdk.mbbid.common.a.b.1
                    @Override // com.mbridge.msdk.mbbid.common.b.b
                    public final void a(BidResponsedEx bidResponsedEx) {
                        b.this.h = false;
                        b.this.f = bidResponsedEx;
                        com.mbridge.msdk.mbbid.common.c.a.a(b.this.d, b.this.f2278b, bidResponsedEx.getBidId(), md5, bidResponsedEx.getBidToken());
                        b.a(b.this, (BidResponsed) bidResponsedEx);
                    }

                    @Override // com.mbridge.msdk.mbbid.common.b.b
                    public final void a(int i2, String str2) {
                        b.this.h = false;
                        com.mbridge.msdk.mbbid.common.c.a.a(b.this.d, b.this.f2278b, str2, md5);
                        b.this.a(str2);
                    }
                };
                aVar2.setUnitId(this.f2278b);
                aVar2.setPlacementId(this.a);
                aVar.get(1, com.mbridge.msdk.foundation.same.net.f.d.a().a(false, ""), dVar, aVar2);
                return;
            }
            a("current unit is biding");
        } catch (Throwable th) {
            a(th.getMessage());
        }
    }

    public final void a(BidListennning bidListennning) {
        this.e = bidListennning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BidListennning bidListennning = this.e;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    static /* synthetic */ void a(b bVar, BidResponsed bidResponsed) {
        BidListennning bidListennning = bVar.e;
        if (bidListennning != null) {
            bidListennning.onSuccessed(bidResponsed);
        }
    }
}
