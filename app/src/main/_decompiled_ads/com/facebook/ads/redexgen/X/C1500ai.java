package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1500ai extends K8 {
    public final /* synthetic */ C1499ah A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public C1500ai(C1499ah c1499ah, Map map, Map map2) {
        this.A00 = c1499ah;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        if (!TextUtils.isEmpty(this.A00.A01.A0Y())) {
            HashMap map = new HashMap();
            Map<String, String> extraData = this.A02;
            map.putAll(extraData);
            Map<String, String> extraData2 = this.A01;
            map.putAll(extraData2);
            this.A00.A09.A09().A9i(this.A00.A01.A0Y(), map);
        }
    }
}
