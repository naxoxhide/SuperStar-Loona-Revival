package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class A8 {
    public static byte[] A00;
    public static String[] A01 = {"sCxx5L5gWudXPe4xp1ThsNryHSmynjHF", "9Nf9uybzHO2S6jQpjiGasa9ZwcLHyUhN", "2aneS77IEDbgq", "fX6HyBPcmxgssJA51nXZ3qA", "", "AlikR2RGcjs8IOnjMv6bsO9qZZebDHqD", "DHEXyDlkH8L0aTNQHdBgfWGXbAOYtdTx", "PJLs5pK7Ccf4tt9LWMwQ38VoV6l96kFD"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Format A07(C0980Hh c0980Hh, String str, String str2, DrmInitData drmInitData) {
        int i = A05[(c0980Hh.A0E() & 192) >> 6];
        int iA0E = c0980Hh.A0E();
        int i2 = A04[(iA0E & 56) >> 3];
        if ((iA0E & 4) != 0) {
            i2++;
        }
        return Format.A07(str, A0A(0, 9, 26), null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static Format A08(C0980Hh c0980Hh, String str, String str2, DrmInitData drmInitData) {
        c0980Hh.A0Z(2);
        int i = A05[(c0980Hh.A0E() & 192) >> 6];
        int iA0E = c0980Hh.A0E();
        int i2 = A04[(iA0E & 14) >> 1];
        if ((iA0E & 1) != 0) {
            i2++;
        }
        if (((c0980Hh.A0E() & 30) >> 1) > 0 && (c0980Hh.A0E() & 2) != 0) {
            i2 += 2;
        }
        String strA0A = A0A(9, 10, 48);
        if (c0980Hh.A04() > 0 && (c0980Hh.A0E() & 1) != 0) {
            strA0A = A0A(19, 14, 124);
        }
        return Format.A07(str, strA0A, null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0207  */
    /* JADX WARN: Code duplicated, block: B:160:0x0273  */
    /* JADX WARN: Code duplicated, block: B:162:0x027d  */
    /* JADX WARN: Code duplicated, block: B:164:0x028e  */
    /* JADX WARN: Code duplicated, block: B:166:0x02a9  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static A7 A09(C0979Hg c0979Hg) {
        String strA0A;
        int iA01;
        int i;
        int i2;
        int i3;
        int i4;
        int iA04;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int iA03 = c0979Hg.A03();
        c0979Hg.A08(40);
        boolean z = c0979Hg.A04(5) == 16;
        c0979Hg.A07(iA03);
        int i11 = -1;
        if (!z) {
            strA0A = A0A(0, 9, 26);
            c0979Hg.A08(32);
            int iA05 = c0979Hg.A04(2);
            iA01 = A01(iA05, c0979Hg.A04(6));
            c0979Hg.A08(8);
            int iA06 = c0979Hg.A04(3);
            if ((iA06 & 1) == 0 || iA06 == 1) {
                i = 2;
            } else {
                i = 2;
                c0979Hg.A08(2);
            }
            if ((iA06 & 4) != 0) {
                c0979Hg.A08(i);
            }
            if (iA06 == i) {
                c0979Hg.A08(i);
            }
            i2 = A05[iA05];
            i3 = 1536;
            boolean zA0F = c0979Hg.A0F();
            int[] iArr = A04;
            if (A01[6].charAt(31) != 'Q') {
                A01[2] = "4KahRN";
                i4 = iArr[iA06] + (zA0F ? 1 : 0);
                return new A7(strA0A, i11, i4, i2, iA01, i3);
            }
            throw new RuntimeException();
        }
        c0979Hg.A08(16);
        switch (c0979Hg.A04(2)) {
            case 0:
                i11 = 0;
                break;
            case 1:
                i11 = 1;
                break;
            case 2:
                i11 = 2;
                break;
            default:
                i11 = -1;
                break;
        }
        c0979Hg.A08(3);
        iA01 = (c0979Hg.A04(11) + 1) * 2;
        int iA07 = c0979Hg.A04(2);
        if (iA07 == 3) {
            iA04 = 3;
            i2 = A06[c0979Hg.A04(2)];
            i5 = 6;
        } else {
            iA04 = c0979Hg.A04(2);
            String[] strArr = A01;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A01;
                strArr2[7] = "8hYjpgfNHnAwS9QM7NBT3rLslQs0BeQi";
                strArr2[5] = "JdPcmmaJKVXmYa4gXJhhMISDBvQK9V8e";
                i5 = A03[iA04];
                i2 = A05[iA07];
            } else {
                i5 = A03[iA04];
                i2 = A05[iA07];
            }
        }
        i3 = i5 * 256;
        int iA08 = c0979Hg.A04(3);
        boolean zA0F2 = c0979Hg.A0F();
        i4 = A04[iA08] + (zA0F2 ? 1 : 0);
        c0979Hg.A08(10);
        if (c0979Hg.A0F()) {
            c0979Hg.A08(8);
        }
        if (iA08 == 0) {
            c0979Hg.A08(5);
            if (c0979Hg.A0F()) {
                c0979Hg.A08(8);
            }
        }
        if (i11 == 1 && c0979Hg.A0F()) {
            c0979Hg.A08(16);
        }
        if (c0979Hg.A0F()) {
            if (iA08 > 2) {
                c0979Hg.A08(2);
            }
            if ((iA08 & 1) == 0 || iA08 <= 2) {
                i9 = 6;
            } else {
                i9 = 6;
                c0979Hg.A08(6);
            }
            if ((iA08 & 4) != 0) {
                c0979Hg.A08(i9);
            }
            if (zA0F2 && c0979Hg.A0F()) {
                c0979Hg.A08(5);
            }
            if (i11 == 0) {
                if (c0979Hg.A0F()) {
                    i10 = 6;
                    c0979Hg.A08(6);
                } else {
                    i10 = 6;
                }
                if (iA08 == 0 && c0979Hg.A0F()) {
                    c0979Hg.A08(i10);
                }
                if (c0979Hg.A0F()) {
                    c0979Hg.A08(i10);
                }
                int iA09 = c0979Hg.A04(2);
                if (iA09 == 1) {
                    c0979Hg.A08(5);
                } else if (iA09 == 2) {
                    c0979Hg.A08(12);
                } else if (iA09 == 3) {
                    int iA010 = c0979Hg.A04(5);
                    if (c0979Hg.A0F()) {
                        c0979Hg.A08(5);
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        boolean zA0F3 = c0979Hg.A0F();
                        String[] strArr3 = A01;
                        if (strArr3[1].charAt(20) != strArr3[0].charAt(20)) {
                            A01[2] = "kC";
                            if (zA0F3) {
                                c0979Hg.A08(4);
                            }
                        } else {
                            A01[2] = "vcp8LN0Hh9uJKmo";
                            if (zA0F3) {
                                c0979Hg.A08(4);
                            }
                        }
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        if (c0979Hg.A0F()) {
                            c0979Hg.A08(4);
                        }
                        if (c0979Hg.A0F()) {
                            if (c0979Hg.A0F()) {
                                c0979Hg.A08(4);
                            }
                            if (c0979Hg.A0F()) {
                                c0979Hg.A08(4);
                            }
                        }
                    }
                    if (c0979Hg.A0F()) {
                        c0979Hg.A08(5);
                        String[] strArr4 = A01;
                        if (strArr4[3].length() != strArr4[4].length()) {
                            String[] strArr5 = A01;
                            strArr5[1] = "LWpchFhzl4zZLaolhYStszHUjMzJpa2W";
                            strArr5[0] = "6uYdOttcy9rqBmgvIK07scrDJCGtgIZT";
                            if (c0979Hg.A0F()) {
                                c0979Hg.A08(7);
                                if (c0979Hg.A0F()) {
                                    if (A01[6].charAt(31) != 'Q') {
                                        String[] strArr6 = A01;
                                        strArr6[3] = "efqTs5tkRdGBLzL99Y2zBy0";
                                        strArr6[4] = "";
                                        c0979Hg.A08(8);
                                    } else {
                                        c0979Hg.A08(8);
                                    }
                                }
                            }
                        } else if (c0979Hg.A0F()) {
                            c0979Hg.A08(7);
                            if (c0979Hg.A0F()) {
                                if (A01[6].charAt(31) != 'Q') {
                                    String[] strArr7 = A01;
                                    strArr7[3] = "efqTs5tkRdGBLzL99Y2zBy0";
                                    strArr7[4] = "";
                                    c0979Hg.A08(8);
                                } else {
                                    c0979Hg.A08(8);
                                }
                            }
                        }
                    }
                    c0979Hg.A08((iA010 + 2) * 8);
                    c0979Hg.A05();
                }
                if (iA08 < 2) {
                    if (c0979Hg.A0F()) {
                        c0979Hg.A08(14);
                    }
                    if (iA08 == 0 && c0979Hg.A0F()) {
                        c0979Hg.A08(14);
                    }
                }
                if (c0979Hg.A0F()) {
                    if (iA04 == 0) {
                        c0979Hg.A08(5);
                    } else {
                        for (int i12 = 0; i12 < i5; i12++) {
                            if (c0979Hg.A0F()) {
                                c0979Hg.A08(5);
                            }
                        }
                    }
                }
            }
        }
        if (c0979Hg.A0F()) {
            c0979Hg.A08(5);
            if (iA08 == 2) {
                c0979Hg.A08(4);
            }
            if (iA08 >= 6) {
                c0979Hg.A08(2);
            }
            boolean zA0F4 = c0979Hg.A0F();
            if (A01[6].charAt(31) != 'Q') {
                A01[6] = "dl0wWt6J8L8AikPCmNhR7kaZE8RAZ0S5";
                if (zA0F4) {
                    i8 = 8;
                    c0979Hg.A08(8);
                } else {
                    i8 = 8;
                }
                if (iA08 == 0 && c0979Hg.A0F()) {
                    c0979Hg.A08(i8);
                }
                i6 = 3;
                if (iA07 < 3) {
                    c0979Hg.A06();
                }
            }
            throw new RuntimeException();
        }
        i6 = 3;
        if (i11 == 0 && iA04 != i6) {
            c0979Hg.A06();
        }
        if (i11 != 2) {
            i7 = 6;
        } else if (iA04 == i6 || c0979Hg.A0F()) {
            i7 = 6;
            c0979Hg.A08(6);
        } else {
            i7 = 6;
        }
        strA0A = A0A(9, 10, 48);
        if (c0979Hg.A0F()) {
            int iA011 = c0979Hg.A04(i7);
            String[] strArr8 = A01;
            if (strArr8[3].length() == strArr8[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr9 = A01;
            strArr9[1] = "3ApKKtyzWMiiSaP5bzYqsGtpnyYQD1rl";
            strArr9[0] = "8bIrpLiP8D9Hp4mjJ2yCsEloJ1XyNCEo";
            if (iA011 == 1 && c0979Hg.A04(8) == 1) {
                strA0A = A0A(19, 14, 124);
            }
        }
        return new A7(strA0A, i11, i4, i2, iA01, i3);
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{-69, -49, -66, -61, -55, -119, -69, -67, -115, -47, -27, -44, -39, -33, -97, -43, -47, -45, -93, 29, 49, 32, 37, 43, -21, 33, 29, 31, -17, -23, 38, 43, 31};
    }

    static {
        A0B();
        A03 = new int[]{1, 2, 3, 6};
        A05 = new int[]{48000, 44100, 32000};
        A06 = new int[]{24000, 22050, 16000};
        A04 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        A02 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
        A07 = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    }

    public static int A00() {
        return 1536;
    }

    public static int A01(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = A05;
        int halfFrmsizecod = iArr.length;
        if (i >= halfFrmsizecod || i2 < 0) {
            return -1;
        }
        int[] iArr2 = A07;
        int halfFrmsizecod2 = iArr2.length;
        if (i3 >= halfFrmsizecod2) {
            return -1;
        }
        int bitrate = iArr[i];
        if (bitrate == 44100) {
            int halfFrmsizecod3 = i2 % 2;
            return (iArr2[i3] + halfFrmsizecod3) * 2;
        }
        int sampleRate = A02[i3];
        if (bitrate == 32000) {
            int i4 = sampleRate * 6;
            if (A01[6].charAt(31) == 81) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "qimZQilZsB2lt3Dt1pYE9Xl";
            strArr[4] = "";
            return i4;
        }
        int halfFrmsizecod4 = sampleRate * 4;
        return halfFrmsizecod4;
    }

    public static int A02(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int startIndex = byteBuffer.limit();
        int i = startIndex - 10;
        for (int i2 = iPosition; i2 <= i; i2++) {
            int startIndex2 = i2 + 4;
            int endIndex = byteBuffer.getInt(startIndex2);
            if ((endIndex & (-16777217)) == -1167101192) {
                return i2 - iPosition;
            }
        }
        String[] strArr = A01;
        String str = strArr[7];
        String str2 = strArr[5];
        int endIndex2 = str.charAt(29);
        int startIndex3 = str2.charAt(29);
        if (endIndex2 == startIndex3) {
            throw new RuntimeException();
        }
        A01[2] = "FkGXqBuH9rf";
        return -1;
    }

    public static int A03(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            int[] iArr = A03;
            int fscod = byteBuffer.position();
            i = iArr[(byteBuffer.get(fscod + 4) & 48) >> 4];
        }
        int fscod2 = i * 256;
        return fscod2;
    }

    public static int A04(ByteBuffer byteBuffer, int i) {
        boolean isMlp = (byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187;
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + (isMlp ? 9 : 8)) >> 4) & 7);
    }

    public static int A05(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        int fscod = (bArr[4] & 192) >> 6;
        int frmsizecod = bArr[4] & 63;
        return A01(fscod, frmsizecod);
    }

    public static int A06(byte[] bArr) {
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        boolean isMlp = (bArr[7] & 255) == 187;
        byte b2 = bArr[isMlp ? '\t' : '\b'];
        String[] strArr = A01;
        if (strArr[3].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "Qkic1459317rghhXW1uTsPZAwlwTKIiV";
        strArr2[0] = "TPYz26W0Cq4ZALktt0QhsmVlkvC9xybr";
        return 40 << ((b2 >> 4) & 7);
    }
}
