package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1468aC extends K8 {
    public static byte[] A03;
    public final /* synthetic */ C1502ak A00;
    public final /* synthetic */ C06121s A01;
    public final /* synthetic */ C0920Ex A02;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{32, 5, 0, 17, 21, 4, 19, 65, 21, 8, 12, 4, 14, 20, 21, 79};
    }

    public C1468aC(C0920Ex c0920Ex, C06121s c06121s, C1502ak c1502ak) {
        this.A02 = c0920Ex;
        this.A01 = c06121s;
        this.A00 = c1502ak;
    }

    @Override // com.facebook.ads.redexgen.X.K8
    public final void A06() {
        this.A02.A0P(this.A01);
        this.A02.A0M(this.A00);
        this.A02.ABH(new JG(AdErrorType.NETWORK_ERROR, A00(0, 16, 43)));
    }
}
