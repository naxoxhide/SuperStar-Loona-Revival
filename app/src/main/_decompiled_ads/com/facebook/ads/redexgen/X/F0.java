package com.facebook.ads.redexgen.X;

import com.google.common.primitives.SignedBytes;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F0 extends AbstractC1484aS implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 5751287062553772011L;

    static {
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{72, 79, 85, 68, 83, 82, 85, 72, 85, 72, SignedBytes.MAX_POWER_OF_TWO, 77};
    }

    public F0(List<C1D> list) {
        super(list);
    }

    public static F0 A02(JSONObject jSONObject, YA ya) {
        F0 f0 = new F0(AbstractC1484aS.A08(jSONObject, ya, new C1481aP()));
        f0.A15(jSONObject);
        f0.A0Z(A03(0, 12, 67));
        return f0;
    }

    @Override // com.facebook.ads.redexgen.X.C1C
    public final int A0F() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.C1C
    public final int A0G() {
        return 0;
    }
}
