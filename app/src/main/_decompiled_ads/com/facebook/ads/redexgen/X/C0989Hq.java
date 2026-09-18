package com.facebook.ads.redexgen.X;

import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0989Hq implements Comparator<C0990Hr> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(C0990Hr c0990Hr, C0990Hr c0990Hr2) {
        if (c0990Hr.A00 < c0990Hr2.A00) {
            return -1;
        }
        return c0990Hr2.A00 < c0990Hr.A00 ? 1 : 0;
    }
}
