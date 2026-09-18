package com.tapjoy.internal;

import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;

/* JADX INFO: loaded from: classes4.dex */
public final class z1 implements a2 {
    @Override // com.tapjoy.internal.a2
    public final void a(String str) {
    }

    @Override // com.tapjoy.internal.a2
    public final void b(String str) {
        TJPlacement tJPlacement;
        TJPlacementListener tJPlacementListener;
        wa waVar = FiveRocksIntegration.a;
        synchronized (waVar) {
            tJPlacement = (TJPlacement) waVar.get(str);
        }
        if (tJPlacement == null || (tJPlacementListener = tJPlacement.c) == null) {
            return;
        }
        tJPlacementListener.onContentShow(tJPlacement);
    }

    @Override // com.tapjoy.internal.a2
    public final void a(String str, a aVar) {
        TJPlacement tJPlacement;
        TJPlacementListener tJPlacementListener;
        TJPlacement tJPlacement2;
        TJPlacementListener tJPlacementListener2;
        if (aVar != null) {
            Object obj = (b) aVar;
            if (obj instanceof x5) {
                z5 z5Var = (z5) ((x5) obj);
                String str2 = z5Var.f2839b;
                String str3 = z5Var.c;
                wa waVar = FiveRocksIntegration.a;
                synchronized (waVar) {
                    tJPlacement2 = (TJPlacement) waVar.get(str);
                }
                if (tJPlacement2 == null || (tJPlacementListener2 = tJPlacement2.c) == null) {
                    return;
                }
                tJPlacementListener2.onPurchaseRequest(tJPlacement2, new w1(str2), str3);
                return;
            }
            if (obj instanceof m6) {
                o6 o6Var = (o6) ((m6) obj);
                String str4 = o6Var.f2791b;
                String str5 = o6Var.c;
                int i = o6Var.d;
                String str6 = o6Var.e;
                wa waVar2 = FiveRocksIntegration.a;
                synchronized (waVar2) {
                    tJPlacement = (TJPlacement) waVar2.get(str);
                }
                if (tJPlacement == null || (tJPlacementListener = tJPlacement.c) == null) {
                    return;
                }
                tJPlacementListener.onRewardRequest(tJPlacement, new x1(str4, str6), str5, i);
            }
        }
    }

    @Override // com.tapjoy.internal.a2
    public final void a(String str, String str2, a aVar) {
        TJPlacement tJPlacement;
        if (aVar != null) {
            ((b) aVar).a(new y1(str));
        }
        wa waVar = FiveRocksIntegration.a;
        synchronized (waVar) {
            tJPlacement = (TJPlacement) waVar.get(str);
        }
        if (tJPlacement != null) {
            TapjoyConnectCore.viewDidClose(str2);
            TJPlacementListener tJPlacementListener = tJPlacement.c;
            if (tJPlacementListener != null) {
                tJPlacementListener.onContentDismiss(tJPlacement);
            }
        }
    }
}
