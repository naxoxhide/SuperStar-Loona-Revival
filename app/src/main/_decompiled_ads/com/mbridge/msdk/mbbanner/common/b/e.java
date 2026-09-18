package com.mbridge.msdk.mbbanner.common.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.videocommon.download.g;

/* JADX INFO: compiled from: DownloadBannerUrlListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements g.b {
    private static final String a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2254b;
    private com.mbridge.msdk.mbbanner.common.c.b c;
    private CampaignEx d;

    public e(com.mbridge.msdk.mbbanner.common.c.b bVar, String str, CampaignEx campaignEx) {
        this.c = bVar;
        this.f2254b = str;
        this.d = campaignEx;
    }

    @Override // com.mbridge.msdk.videocommon.download.g.a
    public final void a(String str, boolean z) {
        com.mbridge.msdk.mbbanner.common.c.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.f2254b, 3, str, true, this.d);
        }
    }

    @Override // com.mbridge.msdk.videocommon.download.g.a
    public final void a(String str, String str2) {
        com.mbridge.msdk.mbbanner.common.c.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.f2254b, 3, str, false, this.d);
        }
    }
}
