package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CK {
    public static byte[] A00;
    public static String[] A01 = {"bdaFL9zMZ", "I63pCoSBBbO7fDlHhIa7BrZ6Ava1cIF3", "x5nJfB3W8HSDeHix", "yyLZDQNtNFC811gZWNvs8tiPSoT", "kE4kWLsRx96QKHczqOKboI9lp", "rJUZcTDeN", "z735Hr0viTdtcy9jRTmcNapxWooAX9zU", "rl5X7GmnpjWHRCYLou0FtooQfFV"};
    public static final int[] A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[3] = "MWn";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 122);
            if (A01[7].length() == 12) {
                throw new RuntimeException();
            }
            A01[7] = "KMAr4";
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-44, 8, -45, 2, 25, 77, 24, 72, -8, 44, 42, -5, 22, 74, 74, 25, -49, 3, 12, -20, 32, 43, -17, 14, 66, 78, 17, -42, -67, -54, -87, 63, 38, 72, 18, 63, 38, 72, 66, -41, -35, -40, -32, 4, 25, 6, -44, 19, -31, 35, -51, 27, 24, 41, -28, 12, 26, 7, -43, 23, 33, 29, -32, 55, 65, Base64.padSymbol, 1, 62, 72, 68, 9, -9, 1, -3, -61, 9, 19, 15, -42, 40, 50, 46, 44, 14, 7, 7, 12, 24, 27, -33, -36, 97, 100, 40, 38, -10, -7, -91, -91};
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:62:0x010f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static boolean A05(InterfaceC0839Bb interfaceC0839Bb, boolean z) throws InterruptedException, IOException {
        boolean z2;
        long jA7B = interfaceC0839Bb.A7B();
        long j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j2 = -1;
        if (jA7B != -1 && jA7B <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = jA7B;
        }
        int i = (int) j;
        C0980Hh c0980Hh = new C0980Hh(64);
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i2 >= i) {
                z2 = false;
                break;
            }
            int i3 = 8;
            c0980Hh.A0W(8);
            interfaceC0839Bb.ADl(c0980Hh.A00, 0, 8);
            long jA0M = c0980Hh.A0M();
            int iA08 = c0980Hh.A08();
            if (jA0M == 1) {
                i3 = 16;
                interfaceC0839Bb.ADl(c0980Hh.A00, 8, 8);
                if (A01[3].length() == 21) {
                    throw new RuntimeException();
                }
                A01[3] = "x";
                c0980Hh.A0X(16);
                jA0M = c0980Hh.A0N();
            } else if (jA0M == 0) {
                long jA7B2 = interfaceC0839Bb.A7B();
                if (jA7B2 != j2) {
                    jA0M = (jA7B2 - interfaceC0839Bb.A7a()) + ((long) 8);
                }
            }
            if (jA0M < i3) {
                if (A01[6].length() != 14) {
                    A01[6] = "xNdZT7PF3cfE5U51qI7qEUy5Bn2I1n4";
                    return false;
                }
                A01[6] = "uC";
                return false;
            }
            i2 += i3;
            if (iA08 != C1.A0k) {
                if (iA08 == C1.A0j) {
                    z2 = false;
                } else if (iA08 == C1.A0n) {
                    z2 = false;
                } else {
                    if ((((long) i2) + jA0M) - ((long) i3) >= i) {
                        z2 = false;
                        break;
                    }
                    int i4 = (int) (jA0M - ((long) i3));
                    i2 += i4;
                    if (iA08 == C1.A0V) {
                        if (i4 < 8) {
                            return false;
                        }
                        c0980Hh.A0W(i4);
                        interfaceC0839Bb.ADl(c0980Hh.A00, 0, i4);
                        int i5 = i4 / 4;
                        for (int i6 = 0; i6 < i5; i6++) {
                            if (A01[3].length() != 21) {
                                String[] strArr = A01;
                                strArr[2] = "gohG7oAKJXd788dq";
                                strArr[4] = "s0tItg43zYN2kAKL8Ko7hXkhv";
                                if (i6 != 1) {
                                    if (A02(c0980Hh.A08())) {
                                        z3 = true;
                                        break;
                                    }
                                } else {
                                    if (A01[7].length() != 12) {
                                        throw new RuntimeException();
                                    }
                                    A01[7] = "X5YHVW4uSpKOduvkf9RISQBbBxib";
                                    c0980Hh.A0Z(4);
                                }
                            } else {
                                if (i6 != 1) {
                                    if (A02(c0980Hh.A08())) {
                                        z3 = true;
                                        break;
                                    }
                                } else {
                                    if (A01[7].length() != 12) {
                                        throw new RuntimeException();
                                    }
                                    A01[7] = "X5YHVW4uSpKOduvkf9RISQBbBxib";
                                    c0980Hh.A0Z(4);
                                }
                            }
                        }
                        if (!z3) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        interfaceC0839Bb.A3S(i4);
                    }
                    j2 = -1;
                }
                z4 = true;
                break;
            }
            j2 = -1;
        }
        if (z3 && z == z4) {
            return true;
        }
        return z2;
    }

    static {
        A01();
        A02 = new int[]{C0996Hx.A08(A00(79, 4, 69)), C0996Hx.A08(A00(59, 4, 52)), C0996Hx.A08(A00(63, 4, 84)), C0996Hx.A08(A00(67, 4, 91)), C0996Hx.A08(A00(71, 4, 20)), C0996Hx.A08(A00(75, 4, 38)), C0996Hx.A08(A00(43, 4, 41)), C0996Hx.A08(A00(55, 4, 42)), C0996Hx.A08(A00(51, 4, 57)), C0996Hx.A08(A00(87, 4, 49)), C0996Hx.A08(A00(91, 4, 122)), C0996Hx.A08(A00(0, 4, 39)), C0996Hx.A08(A00(4, 4, 108)), C0996Hx.A08(A00(19, 4, 63)), C0996Hx.A08(A00(23, 4, 97)), C0996Hx.A08(A00(8, 4, 75)), C0996Hx.A08(A00(12, 4, 105)), C0996Hx.A08(A00(31, 4, 120)), C0996Hx.A08(A00(27, 4, 15)), C0996Hx.A08(A00(47, 4, 51)), C0996Hx.A08(A00(83, 4, 41)), C0996Hx.A08(A00(35, 4, 120)), C0996Hx.A08(A00(95, 4, 11)), C0996Hx.A08(A00(39, 4, 16))};
    }

    public static boolean A02(int i) {
        if ((i >>> 8) == C0996Hx.A08(A00(16, 3, 34))) {
            return true;
        }
        for (int i2 : A02) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A03(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        return A05(interfaceC0839Bb, true);
    }

    public static boolean A04(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        return A05(interfaceC0839Bb, false);
    }
}
