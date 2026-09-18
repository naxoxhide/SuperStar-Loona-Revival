package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0929Fg {
    public static byte[] A00;
    public static String[] A01 = {"UAa0Z", "y84zlLC7EVblAi9s6IjzDwtWlv", "hWSmc3nAoC6lO20JdXQ8UQAJh4", "HAxIJdFwG2BHjJ6kBVBijNmfixc4v4eM", "sMFPtSIIwmEBUNkX5nfAspCddytOxG7k", "XuEZcwrwjFPAmN9wFCdffjeuCf3K5K0k", "0bJFkLVdjL4ExnLkyIfxNw93FYOhEgu9", "GtmYUKm65Uny9K5bn1TkELKUpeSnjSJ3"};
    public static final int A02;
    public static final int A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{56, 30, 26, 46, 15, 18, 23, 37, 53, 38, 80, 40, 46, 86, 91, 108, 84, 86, 79, 79, 86, 81, 88, 31, 77, 90, 82, 94, 86, 81, 91, 90, 77, 31, 80, 89, 31, 82, 94, 83, 89, 80, 77, 82, 90, 91, 31, 108, 122, 118, 31, 113, 126, 115, 31, 74, 81, 86, 75, 17};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 21 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A03(long j, C0980Hh c0980Hh, InterfaceC0848Bm[] interfaceC0848BmArr) {
        while (c0980Hh.A04() > 1) {
            int iA00 = A00(c0980Hh);
            int iA01 = A00(c0980Hh);
            int iA06 = c0980Hh.A06();
            if (A01[3].charAt(16) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "sJRWMhzWyXWsYNwcYdMxu9waYeZJW4nD";
            strArr[5] = "JDck5DNLGL8VXNpOftdo1S17ghv9bSuy";
            int iA07 = iA06 + iA01;
            if (iA01 == -1 || iA01 > c0980Hh.A04()) {
                Log.w(A01(0, 7, 76), A01(15, 45, 8));
                iA07 = c0980Hh.A07();
            } else if (iA00 == 4 && iA01 >= 8) {
                int iA0E = c0980Hh.A0E();
                int iA0I = c0980Hh.A0I();
                int iA08 = iA0I == 49 ? c0980Hh.A08() : 0;
                int iA0E2 = c0980Hh.A0E();
                if (iA0I == 47) {
                    c0980Hh.A0Z(1);
                }
                boolean z = iA0E == 181 && (iA0I == 49 || iA0I == 47) && iA0E2 == 3;
                if (iA0I == 49) {
                    z &= iA08 == A03 || iA08 == A02;
                }
                if (z) {
                    int iA0E3 = c0980Hh.A0E() & 31;
                    c0980Hh.A0Z(1);
                    int i = iA0E3 * 3;
                    int iA09 = c0980Hh.A06();
                    for (InterfaceC0848Bm interfaceC0848Bm : interfaceC0848BmArr) {
                        c0980Hh.A0Y(iA09);
                        interfaceC0848Bm.AEr(c0980Hh, i);
                        interfaceC0848Bm.AEs(j, 1, i, 0, null);
                    }
                }
            }
            c0980Hh.A0Y(iA07);
        }
    }

    static {
        A02();
        A03 = C0996Hx.A08(A01(11, 4, 88));
        A02 = C0996Hx.A08(A01(7, 4, 86));
    }

    public static int A00(C0980Hh c0980Hh) {
        int i = 0;
        while (value != 0) {
            int b2 = c0980Hh.A0E();
            i += b2;
            if (b2 != 255) {
                return i;
            }
        }
        if (A01[0].length() != 5) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "XY7JbweA6fzPXsut6MPl2wkiFN";
        strArr[1] = "9Cope1RtGoIRUkWui2tRq11YR8";
        return -1;
    }
}
