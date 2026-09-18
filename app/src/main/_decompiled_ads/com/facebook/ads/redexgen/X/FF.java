package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FF extends AbstractC1514aw {
    public static byte[] A02;
    public static final String A03;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{122, 93, 85, 80, 89, 88, 28, 72, 83, 28, 83, 76, 89, 82, 28, 80, 85, 82, 87, 28, 73, 78, 80, 6, 28, 43, 46, 41, 44};
    }

    static {
        A01();
        A03 = FF.class.getSimpleName();
    }

    public FF(YA ya, InterfaceC1004If interfaceC1004If, String str, Uri uri, Map<String, String> mExtraData, C05810n c05810n, boolean z) {
        super(ya, interfaceC1004If, str, c05810n, z);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC05750g
    public final EnumC05740f A0A() {
        try {
            KZ.A0B(new KZ(), ((AbstractC05750g) this).A00, C1050Kc.A00(this.A00.getQueryParameter(A00(25, 4, 8))), ((AbstractC05750g) this).A02);
            return null;
        } catch (Exception unused) {
            String str = A00(0, 25, 115) + this.A00.toString();
            return EnumC05740f.A02;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1514aw
    public final void A0D() {
        EnumC05740f enumC05740fA0A = null;
        if (((AbstractC1514aw) this).A02) {
            enumC05740fA0A = A0A();
        }
        A0E(this.A01, enumC05740fA0A);
    }
}
