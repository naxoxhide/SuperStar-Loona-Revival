package com.tapjoy;

import com.tapjoy.internal.wa;

/* JADX INFO: loaded from: classes4.dex */
public class FiveRocksIntegration {
    public static final wa a = new wa();

    public static void addPlacementCallback(String str, TJPlacement tJPlacement) {
        wa waVar = a;
        synchronized (waVar) {
            waVar.put(str, tJPlacement);
        }
    }
}
