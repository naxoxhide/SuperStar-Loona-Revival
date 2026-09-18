package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.bridge.gms.AdvertisingId;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1392Xm implements C7W {
    public final /* synthetic */ AdvertisingId A00;
    public final /* synthetic */ C1391Xl A01;

    public C1392Xm(C1391Xl c1391Xl, AdvertisingId advertisingId) {
        this.A01 = c1391Xl;
        this.A00 = advertisingId;
    }

    @Override // com.facebook.ads.redexgen.X.C7W
    public final boolean A8w() {
        return this.A00.isLimitAdTracking();
    }

    @Override // com.facebook.ads.redexgen.X.C7W
    public final String getId() {
        return this.A00.getId();
    }
}
