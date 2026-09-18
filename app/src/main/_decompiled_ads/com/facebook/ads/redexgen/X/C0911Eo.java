package com.facebook.ads.redexgen.X;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0911Eo extends AbstractC1465a9 {
    public static byte[] A00;
    public static String[] A01 = {"d7tLiGkqyLa7cKOkED7RtvmpIXZH8d0b", "LmA4T64r6T9e", "1EBtOKlPck0twYp3ElEJQmg3d", "uhXcdOUibAChEZNBNQuPqKRIQ2", "Z", "LV0o53GlcsqgEYK9Pr4EwymnJShooL9b", "NLZosIPt4DzrQXhRsvqwWEHVFOTX5bDJ", "MQasnwh7q"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 72, 12, 69, 95, 12, 66, 67, 88, 12, 94, 73, 77, 72, 85, 12, 67, 94, 12, 77, SignedBytes.MAX_POWER_OF_TWO, 94, 73, 77, 72, 85, 12, 72, 69, 95, 92, SignedBytes.MAX_POWER_OF_TWO, 77, 85, 73, 72, 56, 57, 48, Base64.padSymbol, 37};
    }

    static {
        A03();
    }

    public C0911Eo(YA ya, C06111r c06111r) {
        super(ya, c06111r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A01(long j) {
        HashMap map = new HashMap();
        map.put(A00(36, 5, 104), String.valueOf(System.currentTimeMillis() - j));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(List<String> trackingUrls, Map<String, String> extraData) {
        if (trackingUrls == null || trackingUrls.isEmpty()) {
            return;
        }
        Iterator<String> it = trackingUrls.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[0] = "jDIZMq7wlAdnEmkEGDRuOyHBIh8qxobs";
            if (zHasNext) {
                new R1(this.A0B, extraData).execute(it.next());
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0L() {
        C1499ah c1499ah = (C1499ah) this.A01;
        if (c1499ah.A0T()) {
            if (this.A06 != null) {
                this.A06.A0B(c1499ah);
                return;
            }
            return;
        }
        throw new IllegalStateException(A00(0, 36, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1465a9
    public final void A0N(InterfaceC05820o interfaceC05820o, C8F c8f, C8D c8d, C06121s c06121s) {
        C1499ah c1499ah = (C1499ah) interfaceC05820o;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1461a5 c1461a5 = new C1461a5(this, c06121s, c1499ah, jCurrentTimeMillis, c8d);
        A0E().postDelayed(c1461a5, c8f.A05().A05());
        c1499ah.A0L(this.A0B, new C1460a4(this, c1461a5, jCurrentTimeMillis, c8d), this.A08, c06121s, UJ.A0K());
    }
}
