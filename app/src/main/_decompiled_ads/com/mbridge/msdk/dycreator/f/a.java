package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: MBRewardData.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.mbridge.msdk.dycreator.f.a.a {
    private DyOption a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f2007b;

    public a(DyOption dyOption) {
        this.a = dyOption;
        this.f2007b = dyOption.getCampaignEx();
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final CampaignEx getBindData() {
        return this.f2007b;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final DyOption getEffectData() {
        return this.a;
    }
}
