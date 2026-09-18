package com.mbridge.msdk.advanced.d;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* JADX INFO: compiled from: NativeLoadAdvancedResponseHandler.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends b {
    private int a;

    public abstract void a(int i, String str);

    public abstract void a(CampaignUnit campaignUnit, int i);

    @Override // com.mbridge.msdk.advanced.d.b
    public final void a(List<Frame> list) {
    }

    public c(int i) {
        this.a = i;
    }

    @Override // com.mbridge.msdk.advanced.d.b
    public final void a(List<com.mbridge.msdk.foundation.same.net.c.b> list, CampaignUnit campaignUnit) {
        a(campaignUnit, this.a);
    }

    @Override // com.mbridge.msdk.advanced.d.b
    public final void b(int i, String str) {
        a(i, str);
    }
}
