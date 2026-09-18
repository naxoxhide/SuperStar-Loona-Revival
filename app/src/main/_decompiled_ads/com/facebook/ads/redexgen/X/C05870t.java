package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05870t {
    public static InterfaceC05820o A00;

    public final InterfaceC05820o A00(YA ya, AdPlacementType adPlacementType) {
        InterfaceC05820o interfaceC05820o = A00;
        if (interfaceC05820o != null) {
            return interfaceC05820o;
        }
        switch (C05860s.A00[adPlacementType.ordinal()]) {
            case 1:
                return new C1502ak();
            case 2:
                return new C1501aj();
            case 3:
                return new C1499ah(ya);
            case 4:
                return new FD(ya);
            case 5:
                return new FA();
            default:
                return null;
        }
    }
}
