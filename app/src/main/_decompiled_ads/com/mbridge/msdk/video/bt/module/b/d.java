package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: ProxyShowRewardListener.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends b {
    private h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f2476b;
    private String c;
    private String d;
    private boolean e;
    private Context f;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;

    /* JADX WARN: Code duplicated, block: B:10:0x0042  */
    public d(Context context, boolean z, com.mbridge.msdk.videocommon.d.c cVar, CampaignEx campaignEx, h hVar, String str, String str2) {
        long jQ;
        this.a = hVar;
        this.f2476b = cVar;
        this.c = str2;
        this.d = str;
        this.e = z;
        this.f = context;
        try {
            String strH = com.mbridge.msdk.foundation.controller.b.d().h();
            if (TextUtils.isEmpty(strH)) {
                jQ = 0;
            } else {
                com.mbridge.msdk.c.c cVarB = com.mbridge.msdk.c.d.a().b(strH);
                cVarB = cVarB == null ? com.mbridge.msdk.c.d.a().b() : cVarB;
                if (cVarB != null) {
                    jQ = cVarB.Q() * 1000;
                } else {
                    jQ = 0;
                }
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (campaignEx != null) {
                if (campaignEx.isSpareOffer(jF, jQ)) {
                    campaignEx.setSpareOfferFlag(1);
                    if (cVar.z() == 1) {
                        campaignEx.setCbt(1);
                        return;
                    } else {
                        campaignEx.setCbt(0);
                        return;
                    }
                }
                campaignEx.setSpareOfferFlag(0);
                campaignEx.setCbt(0);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a() {
        super.a();
        h hVar = this.a;
        if (hVar == null || this.g) {
            return;
        }
        this.g = true;
        hVar.a();
        this.a.a(2, this.d, this.c);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z, com.mbridge.msdk.videocommon.b.c cVar) {
        super.a(z, cVar);
        h hVar = this.a;
        if (hVar == null || this.i) {
            return;
        }
        this.i = true;
        hVar.a(7, this.d, this.c);
        this.a.a(z, cVar);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z, int i) {
        super.a(z, i);
        h hVar = this.a;
        if (hVar == null || this.i) {
            return;
        }
        hVar.a(z, i);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str) {
        super.a(str);
        h hVar = this.a;
        if (hVar == null || this.h) {
            return;
        }
        this.h = true;
        hVar.a(str);
        this.a.a(4, this.d, this.c);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z, String str, String str2) {
        super.a(z, str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(z, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.b(str, str2);
            this.a.a(6, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.a;
        if (hVar != null) {
            hVar.a(str, str2);
            this.a.a(5, str, str2);
        }
    }
}
