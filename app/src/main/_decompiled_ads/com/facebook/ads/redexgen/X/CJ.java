package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CJ {
    public static byte[] A00;
    public static String[] A01 = {"vniJFRP", "oJtPNZwcQG6hLH64wW6tXvk3sbQ9WwGW", "zry57w6QfhfaFpFxdZgKHC1xYn", "fo4QeY", "i9CLNlynjhorIFu8zs9NEh7lWGRKe1E6", "M5SbcVIJ6zX6bTvbAFwxovtl6mtBjy6T", "O1VKgn8XNf4GQEXWcT9RCCs6YBao3Pp0", "jcDd8FEzgCzhSc3FOh8Nko0kxmmUpCTh"};

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-28, 7, 7, -4, -43, 8, 3, 1, -23, 8, -3, 0, -85, -60, -55, -53, -58, -58, -59, -56, -54, -69, -70, 118, -58, -55, -55, -66, 118, -52, -69, -56, -55, -65, -59, -60, -112, 118};
    }

    static {
        A04();
    }

    public static int A00(byte[] bArr) {
        CI parsedAtom = A01(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A00;
        }
        if (A01[0].length() == 21) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "fw1Vu3";
        strArr[2] = "Fgm9cv2CAdprrHHvAJvClRGcka";
        return -1;
    }

    public static CI A01(byte[] bArr) {
        C0980Hh c0980Hh = new C0980Hh(bArr);
        if (c0980Hh.A07() < 32) {
            return null;
        }
        c0980Hh.A0Y(0);
        if (c0980Hh.A08() != c0980Hh.A04() + 4 || c0980Hh.A08() != C1.A0s) {
            return null;
        }
        int dataSize = C1.A01(c0980Hh.A08());
        if (dataSize > 1) {
            Log.w(A02(0, 12, 98), A02(12, 26, 36) + dataSize);
            return null;
        }
        UUID uuid = new UUID(c0980Hh.A0L(), c0980Hh.A0L());
        if (dataSize == 1) {
            int atomType = c0980Hh.A0H() * 16;
            if (A01[0].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "thpi9L";
            strArr[2] = "TMAT5NZ1bWTkNSNpNaLonMSfAF";
            c0980Hh.A0Z(atomType);
        }
        int atomSize = c0980Hh.A0H();
        if (atomSize != c0980Hh.A04()) {
            return null;
        }
        byte[] bArr2 = new byte[atomSize];
        c0980Hh.A0c(bArr2, 0, atomSize);
        return new CI(uuid, dataSize, bArr2);
    }

    public static UUID A03(byte[] bArr) {
        CI parsedAtom = A01(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A01;
        }
        return null;
    }
}
