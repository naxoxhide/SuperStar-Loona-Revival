package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1158Oi {
    public static final Map<String, WeakReference<C1157Oh>> A00 = new HashMap();

    public static int A00() {
        return A00.size();
    }

    public static C1157Oh A01(YA ya, AbstractC1484aS abstractC1484aS, int i, InterfaceC1155Of interfaceC1155Of) {
        C1157Oh c1157Oh = new C1157Oh(ya, abstractC1484aS, ya.A01().A09(), i);
        c1157Oh.A0b(interfaceC1155Of);
        c1157Oh.A0X();
        A00.put(abstractC1484aS.A0R(), new WeakReference<>(c1157Oh));
        return c1157Oh;
    }

    public static C1157Oh A02(String str) {
        WeakReference<C1157Oh> weakReference = A00.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1484aS abstractC1484aS, C1157Oh c1157Oh) {
        A00.put(abstractC1484aS.A0R(), new WeakReference<>(c1157Oh));
    }

    public static void A04(String str) {
        A00.remove(str);
    }
}
