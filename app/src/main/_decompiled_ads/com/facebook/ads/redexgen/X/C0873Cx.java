package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0873Cx {
    public static byte[] A00;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static W2 A00(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        HI.A01(interfaceC0839Bb);
        C0980Hh c0980Hh = new C0980Hh(16);
        if (C0872Cw.A00(interfaceC0839Bb, c0980Hh).A00 != C0996Hx.A08(A01(111, 4, 112))) {
            return null;
        }
        int iA02 = 0;
        interfaceC0839Bb.ADl(c0980Hh.A00, 0, 4);
        c0980Hh.A0Y(0);
        int iA08 = c0980Hh.A08();
        int iA09 = C0996Hx.A08(A01(195, 4, 13));
        String strA01 = A01(199, 15, 13);
        if (iA08 != iA09) {
            Log.e(strA01, A01(115, 25, 27) + iA08);
            return null;
        }
        C0872Cw c0872CwA00 = C0872Cw.A00(interfaceC0839Bb, c0980Hh);
        while (c0872CwA00.A00 != C0996Hx.A08(A01(218, 4, 32))) {
            interfaceC0839Bb.A3S((int) c0872CwA00.A01);
            c0872CwA00 = C0872Cw.A00(interfaceC0839Bb, c0980Hh);
        }
        HI.A04(c0872CwA00.A01 >= 16);
        interfaceC0839Bb.ADl(c0980Hh.A00, 0, 16);
        c0980Hh.A0Y(0);
        int iA0C = c0980Hh.A0C();
        int iA0C2 = c0980Hh.A0C();
        int iA0B = c0980Hh.A0B();
        int iA0B2 = c0980Hh.A0B();
        int iA0C3 = c0980Hh.A0C();
        int iA0C4 = c0980Hh.A0C();
        int i = (iA0C2 * iA0C4) / 8;
        if (iA0C3 != i) {
            throw new C07909d(A01(57, 26, 48) + i + A01(10, 7, 62) + iA0C3);
        }
        switch (iA0C) {
            case 1:
            case 65534:
                iA02 = C0996Hx.A02(iA0C4);
                break;
            case 3:
                if (iA0C4 == 32) {
                    iA02 = 4;
                }
                break;
            default:
                Log.e(strA01, A01(166, 29, 30) + iA0C);
                return null;
        }
        if (iA02 == 0) {
            Log.e(strA01, A01(140, 26, 101) + iA0C4 + A01(0, 10, 35) + iA0C);
            return null;
        }
        interfaceC0839Bb.A3S(((int) c0872CwA00.A01) - 16);
        return new W2(iA0C2, iA0B, iA0B2, iA0C3, iA0C4, iA02);
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{39, 97, 104, 117, 39, 115, 126, 119, 98, 39, 33, 58, 125, 117, 110, 32, 58, 123, 80, 77, 86, 83, 24, 81, 75, 24, 76, 87, 87, 24, 84, 89, 74, 95, 93, 24, 16, 70, 10, 127, 122, 19, 17, 24, 76, 87, 24, 75, 83, 81, 72, 3, 24, 81, 92, 2, 24, 81, 108, 100, 113, 119, 96, 113, 112, 52, 118, 120, 123, 119, 127, 52, 117, 120, 125, 115, 122, 121, 113, 122, 96, 46, 52, 103, 73, SignedBytes.MAX_POWER_OF_TWO, 65, 92, 71, SignedBytes.MAX_POWER_OF_TWO, 73, 14, 91, SignedBytes.MAX_POWER_OF_TWO, 69, SignedBytes.MAX_POWER_OF_TWO, 65, 89, SignedBytes.MAX_POWER_OF_TWO, 14, 121, 111, 120, 14, 77, 70, 91, SignedBytes.MAX_POWER_OF_TWO, 69, 20, 14, 6, 29, 18, 18, 106, 81, 76, 74, 79, 79, 80, 77, 75, 90, 91, 31, 109, 118, 121, 121, 31, 89, 80, 77, 82, 94, 75, 5, 31, 20, 47, 50, 52, 49, 49, 46, 51, 53, 36, 37, 97, 22, 0, 23, 97, 35, 40, 53, 97, 37, 36, 49, 53, 41, 97, 111, 84, 73, 79, 74, 74, 85, 72, 78, 95, 94, 26, 109, 123, 108, 26, 92, 85, 72, 87, 91, 78, 26, 78, 67, 74, 95, 0, 26, 126, 104, 127, 108, 126, 72, 95, 97, 76, 72, 77, 76, 91, 123, 76, 72, 77, 76, 91, 10, 15, 26, 15, 98, 105, 112, 36};
    }

    public static void A03(InterfaceC0839Bb interfaceC0839Bb, W2 w2) throws InterruptedException, IOException {
        HI.A01(interfaceC0839Bb);
        HI.A01(w2);
        interfaceC0839Bb.AEm();
        C0980Hh c0980Hh = new C0980Hh(8);
        C0872Cw c0872CwA00 = C0872Cw.A00(interfaceC0839Bb, c0980Hh);
        while (c0872CwA00.A00 != C0996Hx.A08(A01(214, 4, 74))) {
            Log.w(A01(199, 15, 13), A01(83, 28, 10) + c0872CwA00.A00);
            long j = c0872CwA00.A01 + 8;
            if (c0872CwA00.A00 == C0996Hx.A08(A01(111, 4, 112))) {
                j = 12;
            }
            if (j <= 2147483647L) {
                interfaceC0839Bb.AFe((int) j);
                c0872CwA00 = C0872Cw.A00(interfaceC0839Bb, c0980Hh);
            } else {
                throw new C07909d(A01(17, 40, 28) + c0872CwA00.A00);
            }
        }
        interfaceC0839Bb.AFe(8);
        w2.A06(interfaceC0839Bb.A7a(), c0872CwA00.A01);
    }
}
