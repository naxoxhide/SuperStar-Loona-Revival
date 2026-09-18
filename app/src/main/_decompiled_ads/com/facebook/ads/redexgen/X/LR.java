package com.facebook.ads.redexgen.X;

import com.facebook.ads.VideoStartReason;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LR {
    public static EnumC1185Pj A00(VideoStartReason videoStartReason) {
        switch (LQ.A00[videoStartReason.ordinal()]) {
            case 1:
                return EnumC1185Pj.A02;
            case 2:
                return EnumC1185Pj.A03;
            case 3:
                return EnumC1185Pj.A04;
            default:
                return EnumC1185Pj.A03;
        }
    }
}
