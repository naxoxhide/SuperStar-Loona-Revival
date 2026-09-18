package com.mbridge.msdk.mbbanner.common.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;

/* JADX INFO: compiled from: ProxyBannerShowListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements c {
    private static final String a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2255b;
    private com.mbridge.msdk.c.f c;

    public f(c cVar, com.mbridge.msdk.c.f fVar) {
        this.c = fVar;
        this.f2255b = cVar;
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void a(List<CampaignEx> list) {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.a(list);
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void a(String str) {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void a() {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void b() {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void c() {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void d() {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.d();
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void a(CampaignEx campaignEx) {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.a(campaignEx);
        }
    }

    @Override // com.mbridge.msdk.mbbanner.common.b.c
    public final void e() {
        c cVar = this.f2255b;
        if (cVar != null) {
            cVar.e();
        }
    }
}
