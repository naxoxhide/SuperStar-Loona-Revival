package com.tapjoy.internal;

import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;

/* JADX INFO: loaded from: classes4.dex */
public final class y1 {
    public final /* synthetic */ String a;

    public y1(String str) {
        this.a = str;
    }

    public final void a(String str, String str2, int i, String str3) {
        TJPlacement tJPlacement;
        TJPlacementListener tJPlacementListener;
        wa waVar = FiveRocksIntegration.a;
        synchronized (waVar) {
            tJPlacement = (TJPlacement) waVar.get(this.a);
        }
        if (tJPlacement == null || (tJPlacementListener = tJPlacement.c) == null) {
            return;
        }
        tJPlacementListener.onRewardRequest(tJPlacement, new x1(str, str3), str2, i);
    }
}
