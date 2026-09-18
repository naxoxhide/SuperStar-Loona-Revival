package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0976Hd {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"NtIRWyZV8H4fZGcEpCmcKf3IqD05aRmR", "GeJrrdqpTOChTmOZ0a7zD9rW5xWuwwPC", "fB9woPX", "60Ey3AJYIgulbHGVt5ok32wwr6OtRAhs", "ywmal8sml3QBlriqnsJwUXbJL0wOA6tO", "h15JbuXclRunjao1u8Y3u6XMQgnEqNxE", "VnL2Csv3rCYD2ISe0PbhclEmcnjJ2Dil", "pqWxkCx1Owc6AlIW11IRV9LZfrwFezHs"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    /* JADX WARN: Code duplicated, block: B:24:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x009f  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:57:0x010e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0120  */
    /* JADX WARN: Code duplicated, block: B:62:0x0132  */
    /* JADX WARN: Code duplicated, block: B:69:0x0158  */
    /* JADX WARN: Code duplicated, block: B:75:0x0171  */
    /* JADX WARN: Code duplicated, block: B:77:0x0176  */
    /* JADX WARN: Code duplicated, block: B:78:0x0179  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:88:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:89:0x01de  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ec A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:94:0x0203 A[LOOP:0: B:92:0x01fe->B:94:0x0203, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 22
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0975Hc A06(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iA04;
        int iA05;
        boolean zA0A;
        long jA04;
        int i6;
        boolean zA0A2;
        int i7;
        int i8;
        String[] strArr;
        float f;
        int iA06;
        float[] fArr;
        int iA07;
        int iA08;
        int iA09;
        int iA010;
        int i9;
        int i10;
        int i11;
        C0981Hi c0981Hi = new C0981Hi(bArr, i, i2);
        c0981Hi.A07(8);
        int iA011 = c0981Hi.A05(8);
        c0981Hi.A07(16);
        int iA012 = c0981Hi.A04();
        int iA013 = 1;
        boolean zA0A3 = false;
        if (iA011 == 100) {
            iA013 = c0981Hi.A04();
            zA0A3 = iA013 == 3 ? c0981Hi.A0A() : false;
            c0981Hi.A04();
            c0981Hi.A04();
            c0981Hi.A06();
            if (c0981Hi.A0A()) {
                if (iA013 != 3) {
                    i3 = 8;
                } else {
                    i3 = 12;
                }
                for (i4 = 0; i4 < i3; i4++) {
                    if (c0981Hi.A0A()) {
                        if (i4 < 6) {
                            i5 = 16;
                        } else {
                            i5 = 64;
                        }
                        A09(c0981Hi, i5);
                    }
                }
            }
            int iA014 = c0981Hi.A04() + 4;
            iA04 = c0981Hi.A04();
            iA05 = 0;
            zA0A = false;
            if (iA04 == 0) {
                iA05 = c0981Hi.A04() + 4;
                if (A02[4].charAt(6) == 's') {
                    String[] strArr2 = A02;
                    strArr2[6] = "0FcrA39w8cpWUUBY0PhZdDl2WVIzmr3H";
                    strArr2[1] = "bEwoHyJue3o3gWd30VLAmFgh8fIWiG5R";
                }
            } else if (iA04 == 1) {
                zA0A = c0981Hi.A0A();
                c0981Hi.A03();
                c0981Hi.A03();
                jA04 = c0981Hi.A04();
                for (i6 = 0; i6 < jA04; i6++) {
                    c0981Hi.A04();
                }
            }
            c0981Hi.A04();
            c0981Hi.A06();
            int iA015 = c0981Hi.A04() + 1;
            int iA016 = c0981Hi.A04() + 1;
            zA0A2 = c0981Hi.A0A();
            int i12 = (2 - (zA0A2 ? 1 : 0)) * iA016;
            if (!zA0A2) {
                c0981Hi.A06();
            }
            c0981Hi.A06();
            i7 = iA015 * 16;
            i8 = i12 * 16;
            if (c0981Hi.A0A()) {
                int iA017 = c0981Hi.A04();
                int iA018 = c0981Hi.A04();
                iA09 = c0981Hi.A04();
                iA010 = c0981Hi.A04();
                if (iA013 == 0) {
                    i9 = 1;
                    i10 = 2 - (zA0A2 ? 1 : 0);
                } else {
                    if (iA013 == 3) {
                        i9 = 1;
                    } else {
                        i9 = 2;
                    }
                    i10 = (2 - (zA0A2 ? 1 : 0)) * (iA013 == 1 ? 2 : 1);
                }
                i11 = (iA017 + iA018) * i9;
                if (A02[2].length() != 30) {
                    String[] strArr3 = A02;
                    strArr3[6] = "K9ZSRxGlh7Ws8i4c0lKuIdr8XNNG4vGX";
                    strArr3[1] = "z3Vhx6GLQ83q5V050JhbnsU4vD8C98vT";
                    i7 -= i11;
                    i8 -= (iA09 + iA010) * i10;
                }
            } else {
                strArr = A02;
                if (strArr[6].charAt(16) != strArr[1].charAt(16)) {
                    String[] strArr4 = A02;
                    strArr4[6] = "rEmuJ6sFB5gWWdCI0T7L47ZB03FBkEHD";
                    strArr4[1] = "kUZJy2qQtWdVgeJj0t3oDkGmETEmhFuj";
                } else {
                    String[] strArr5 = A02;
                    strArr5[5] = "DSl3hQKuabn38CmnzrECcwmRq5HwdYpG";
                    strArr5[0] = "fA6X51zRtxq1lySt2ARPPLPLlCaXaXco";
                }
            }
            f = 1.0f;
            if (c0981Hi.A0A() && c0981Hi.A0A()) {
                iA06 = c0981Hi.A05(8);
                if (iA06 == 255) {
                    iA07 = c0981Hi.A05(16);
                    iA08 = c0981Hi.A05(16);
                    if (iA07 != 0 && iA08 != 0) {
                        f = iA07 / iA08;
                    }
                } else {
                    fArr = A04;
                    if (iA06 < fArr.length) {
                        f = fArr[iA06];
                    } else {
                        Log.w(A07(0, 11, 38), A07(11, 35, 89) + iA06);
                    }
                }
            }
            return new C0975Hc(iA012, i7, i8, f, zA0A3, zA0A2, iA014, iA04, iA05, zA0A);
        }
        if (A02[4].charAt(6) == 's') {
            String[] strArr6 = A02;
            strArr6[5] = "yVhhMtRnqXgY1Kb3O7KmUsZDbX87nSR0";
            strArr6[0] = "CScaMkkS4ynj4HoVSfcs8Df7mB4vIw2E";
            if (iA011 == 110 || iA011 == 122 || iA011 == 244 || iA011 == 44 || iA011 == 83 || iA011 == 86) {
                iA013 = c0981Hi.A04();
                if (iA013 == 3) {
                }
                c0981Hi.A04();
                c0981Hi.A04();
                c0981Hi.A06();
                if (c0981Hi.A0A()) {
                    if (iA013 != 3) {
                        i3 = 8;
                    } else {
                        i3 = 12;
                    }
                    while (i4 < i3) {
                        if (c0981Hi.A0A()) {
                            if (i4 < 6) {
                                i5 = 16;
                            } else {
                                i5 = 64;
                            }
                            A09(c0981Hi, i5);
                        }
                    }
                }
            } else {
                String[] strArr7 = A02;
                if (strArr7[5].charAt(21) != strArr7[0].charAt(21)) {
                    A02[2] = "JhuiEkWh4gR2K7eJg";
                    if (iA011 != 118) {
                        if (iA011 != 128 || iA011 == 138) {
                        }
                    }
                } else if (iA011 != 118) {
                    if (iA011 != 128) {
                    }
                }
                iA013 = c0981Hi.A04();
                if (iA013 == 3) {
                }
                c0981Hi.A04();
                c0981Hi.A04();
                c0981Hi.A06();
                if (c0981Hi.A0A()) {
                    if (iA013 != 3) {
                        i3 = 8;
                    } else {
                        i3 = 12;
                    }
                    while (i4 < i3) {
                        if (c0981Hi.A0A()) {
                            if (i4 < 6) {
                                i5 = 16;
                            } else {
                                i5 = 64;
                            }
                            A09(c0981Hi, i5);
                        }
                    }
                }
            }
            int iA019 = c0981Hi.A04() + 4;
            iA04 = c0981Hi.A04();
            iA05 = 0;
            zA0A = false;
            if (iA04 == 0) {
                iA05 = c0981Hi.A04() + 4;
                if (A02[4].charAt(6) == 's') {
                    String[] strArr8 = A02;
                    strArr8[6] = "0FcrA39w8cpWUUBY0PhZdDl2WVIzmr3H";
                    strArr8[1] = "bEwoHyJue3o3gWd30VLAmFgh8fIWiG5R";
                }
            } else if (iA04 == 1) {
                zA0A = c0981Hi.A0A();
                c0981Hi.A03();
                c0981Hi.A03();
                jA04 = c0981Hi.A04();
                while (i6 < jA04) {
                    c0981Hi.A04();
                }
            }
            c0981Hi.A04();
            c0981Hi.A06();
            int iA0110 = c0981Hi.A04() + 1;
            int iA0111 = c0981Hi.A04() + 1;
            zA0A2 = c0981Hi.A0A();
            int i13 = (2 - (zA0A2 ? 1 : 0)) * iA0111;
            if (!zA0A2) {
                c0981Hi.A06();
            }
            c0981Hi.A06();
            i7 = iA0110 * 16;
            i8 = i13 * 16;
            if (c0981Hi.A0A()) {
                int iA0112 = c0981Hi.A04();
                int iA0113 = c0981Hi.A04();
                iA09 = c0981Hi.A04();
                iA010 = c0981Hi.A04();
                if (iA013 == 0) {
                    i9 = 1;
                    i10 = 2 - (zA0A2 ? 1 : 0);
                } else {
                    if (iA013 == 3) {
                        i9 = 1;
                    } else {
                        i9 = 2;
                    }
                    i10 = (2 - (zA0A2 ? 1 : 0)) * (iA013 == 1 ? 2 : 1);
                }
                i11 = (iA0112 + iA0113) * i9;
                if (A02[2].length() != 30) {
                    String[] strArr9 = A02;
                    strArr9[6] = "K9ZSRxGlh7Ws8i4c0lKuIdr8XNNG4vGX";
                    strArr9[1] = "z3Vhx6GLQ83q5V050JhbnsU4vD8C98vT";
                    i7 -= i11;
                    i8 -= (iA09 + iA010) * i10;
                }
            } else {
                strArr = A02;
                if (strArr[6].charAt(16) != strArr[1].charAt(16)) {
                    String[] strArr10 = A02;
                    strArr10[6] = "rEmuJ6sFB5gWWdCI0T7L47ZB03FBkEHD";
                    strArr10[1] = "kUZJy2qQtWdVgeJj0t3oDkGmETEmhFuj";
                } else {
                    String[] strArr11 = A02;
                    strArr11[5] = "DSl3hQKuabn38CmnzrECcwmRq5HwdYpG";
                    strArr11[0] = "fA6X51zRtxq1lySt2ARPPLPLlCaXaXco";
                }
            }
            f = 1.0f;
            if (c0981Hi.A0A()) {
                iA06 = c0981Hi.A05(8);
                if (iA06 == 255) {
                    iA07 = c0981Hi.A05(16);
                    iA08 = c0981Hi.A05(16);
                    if (iA07 != 0) {
                        f = iA07 / iA08;
                    }
                } else {
                    fArr = A04;
                    if (iA06 < fArr.length) {
                        f = fArr[iA06];
                    } else {
                        Log.w(A07(0, 11, 38), A07(11, 35, 89) + iA06);
                    }
                }
            }
            return new C0975Hc(iA012, i7, i8, f, zA0A3, zA0A2, iA019, iA04, iA05, zA0A);
        }
        throw new RuntimeException();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{117, 90, 87, 110, 85, 82, 79, 110, 79, 82, 87, 17, 42, 33, 60, 52, 33, 39, 48, 33, 32, 100, 37, 55, 52, 33, 39, 48, 27, 54, 37, 48, 45, 43, 27, 45, 32, 39, 100, 50, 37, 40, 49, 33, 126, 100, 30, 1, 12, 13, 7, 71, 9, 30, 11, 85, 74, 71, 70, 76, 12, 75, 70, 85, SignedBytes.MAX_POWER_OF_TWO};
    }

    static {
        A08();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int A02(byte[] bArr, int i) {
        int i2;
        synchronized (A05) {
            int scratchEscapeCount = 0;
            int i3 = 0;
            while (scratchEscapeCount < i) {
                scratchEscapeCount = A03(bArr, scratchEscapeCount, i);
                if (scratchEscapeCount < i) {
                    int[] iArr = A01;
                    if (iArr.length <= i3) {
                        A01 = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    A01[i3] = scratchEscapeCount;
                    scratchEscapeCount += 3;
                    i3++;
                }
            }
            i2 = i - i3;
            int unescapedPosition = 0;
            int escapedPosition = 0;
            for (int unescapedLength = 0; unescapedLength < i3; unescapedLength++) {
                int scratchEscapeCount2 = A01[unescapedLength];
                int scratchEscapeCount3 = scratchEscapeCount2 - unescapedPosition;
                System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, scratchEscapeCount3);
                int escapedPosition2 = escapedPosition + scratchEscapeCount3;
                int position = escapedPosition2 + 1;
                bArr[escapedPosition2] = 0;
                escapedPosition = position + 1;
                bArr[position] = 0;
                unescapedPosition += scratchEscapeCount3 + 3;
            }
            System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, i2 - escapedPosition);
        }
        return i2;
    }

    public static int A03(byte[] bArr, int i, int i2) {
        while (i < i) {
            int i3 = bArr[i];
            if (i3 == 0) {
                int i4 = i + 1;
                if (bArr[i4] == 0) {
                    int i5 = i + 2;
                    if (bArr[i5] == 3) {
                        return i;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0139  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x011b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0129  */
    /* JADX WARN: Code duplicated, block: B:94:0x012b  */
    public static int A04(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        int i3 = i2 - i;
        HI.A04(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
            if (zArr[0]) {
                A0B(zArr);
                int length = i - 3;
                return length;
            }
            if (i3 > 1 && zArr[1]) {
                int length2 = bArr[i];
                if (length2 == 1) {
                    A0B(zArr);
                    int length3 = i - 2;
                    return length3;
                }
            }
            if (i3 > 2 && zArr[2]) {
                int length4 = bArr[i];
                if (length4 == 0) {
                    int length5 = i + 1;
                    if (bArr[length5] == 1) {
                        A0B(zArr);
                        int length6 = i - 1;
                        return length6;
                    }
                }
            }
        }
        int limit = i2 - 1;
        int i4 = i + 2;
        while (i4 < limit) {
            int length7 = bArr[i4];
            if ((length7 & 254) == 0) {
                int length8 = i4 - 2;
                if (bArr[length8] == 0) {
                    int length9 = i4 - 1;
                    if (bArr[length9] == 0) {
                        int length10 = bArr[i4];
                        if (length10 == 1) {
                            if (zArr != null) {
                                A0B(zArr);
                            }
                            int i5 = i4 - 2;
                            if (A02[2].length() != 30) {
                                String[] strArr = A02;
                                strArr[5] = "cwZIqZ1AW63JkQ3pIqo9DKAUVDIU8B2n";
                                strArr[0] = "C4ULzJ2O8tT1dK0koFoE4t7X4OAunQC5";
                                return i5;
                            }
                            throw new RuntimeException();
                        }
                    }
                }
                i4 -= 2;
            }
            i4 += 3;
        }
        if (zArr != null) {
            if (i3 > 2) {
                int length11 = i2 - 3;
                if (bArr[length11] == 0) {
                    int length12 = i2 - 2;
                    byte b2 = bArr[length12];
                    String[] strArr2 = A02;
                    String str = strArr2[6];
                    String str2 = strArr2[1];
                    int iCharAt = str.charAt(16);
                    int length13 = str2.charAt(16);
                    if (iCharAt == length13) {
                        String[] strArr3 = A02;
                        strArr3[5] = "3nijOMlfzKgjywxgx1aIEuQEOVvcrnGF";
                        strArr3[0] = "mhxYTAHU7iRAJ8bI14cg8xnokscJO5gc";
                        if (b2 == 0) {
                            int length14 = i2 - 1;
                            byte b3 = bArr[length14];
                            String[] strArr4 = A02;
                            String str3 = strArr4[5];
                            String str4 = strArr4[0];
                            int iCharAt2 = str3.charAt(21);
                            int length15 = str4.charAt(21);
                            if (iCharAt2 == length15) {
                                throw new RuntimeException();
                            }
                            String[] strArr5 = A02;
                            strArr5[3] = "9ZCFGjZIw1dXFFVp2oTHQfikOa97hWgs";
                            strArr5[7] = "4W5bkIHCCYZDsaIH6FljQxOPKIhpSySs";
                            if (b3 == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                    }
                    throw new RuntimeException();
                }
                z = false;
            } else if (i3 == 2) {
                if (zArr[2]) {
                    int length16 = i2 - 2;
                    if (bArr[length16] == 0) {
                        int length17 = i2 - 1;
                        if (bArr[length17] == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
            } else if (zArr[1]) {
                int length18 = i2 - 1;
                if (bArr[length18] == 1) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            zArr[0] = z;
            if (i3 > 1) {
                int length19 = i2 - 2;
                if (bArr[length19] == 0) {
                    int length20 = i2 - 1;
                    if (bArr[length20] == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } else if (zArr[2]) {
                int length21 = i2 - 1;
                if (bArr[length21] == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            zArr[1] = z2;
            int length22 = i2 - 1;
            zArr[2] = bArr[length22] == 0;
        }
        return i2;
    }

    public static C0974Hb A05(byte[] bArr, int i, int i2) {
        C0981Hi c0981Hi = new C0981Hi(bArr, i, i2);
        c0981Hi.A07(8);
        int iA04 = c0981Hi.A04();
        int seqParameterSetId = c0981Hi.A04();
        c0981Hi.A06();
        return new C0974Hb(iA04, seqParameterSetId, c0981Hi.A0A());
    }

    public static void A09(C0981Hi c0981Hi, int i) {
        int i2 = 8;
        int deltaScale = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (deltaScale != 0) {
                int lastScale = c0981Hi.A03();
                deltaScale = ((lastScale + i2) + 256) % 256;
            }
            if (deltaScale != 0) {
                i2 = deltaScale;
            }
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[1];
            int nextScale = str.charAt(16);
            int lastScale2 = str2.charAt(16);
            if (nextScale != lastScale2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "KXMRoqtdhshm8G74asFo5uqDFob0Iegs";
            strArr2[7] = "VTZDrARlCd8p2vM8k7YrNOP12vylJmks";
        }
    }

    public static void A0A(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (length < iPosition) {
            int length = byteBuffer.get(i2);
            int value = length & 255;
            if (i == 3) {
                int consecutiveZeros = A02[4].charAt(6);
                if (consecutiveZeros != 115) {
                    throw new RuntimeException();
                }
                A02[2] = "cLm552F16buuPP9xMufxVHaN";
                if (value == 1) {
                    int length2 = i2 + 1;
                    int consecutiveZeros2 = byteBuffer.get(length2) & 31;
                    if (consecutiveZeros2 == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        int length3 = i2 - 3;
                        byteBufferDuplicate.position(length3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        int consecutiveZeros3 = A02[4].charAt(6);
                        if (consecutiveZeros3 != 115) {
                            String[] strArr = A02;
                            strArr[3] = "6nmXEFQWU8IXvuDOHtOk9CPNFswxHRRs";
                            strArr[7] = "sRzFReGlCKeKmBP91kaLZyOllIcQLpOs";
                            return;
                        } else {
                            String[] strArr2 = A02;
                            strArr2[5] = "MM5ABksrrLy98KCtfJajpuklss5i1OmF";
                            strArr2[0] = "sCLzk23Fd4ag3qXWex39LdUh6FJSiknG";
                            return;
                        }
                    }
                }
            } else if (value == 0) {
                i++;
            }
            if (value != 0) {
                i = 0;
            }
            i2++;
        }
        byteBuffer.clear();
    }

    public static void A0B(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0C(String str, byte b2) {
        if (A07(46, 9, 117).equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return A07(55, 10, 62).equals(str) && ((b2 & 126) >> 1) == 39;
    }
}
