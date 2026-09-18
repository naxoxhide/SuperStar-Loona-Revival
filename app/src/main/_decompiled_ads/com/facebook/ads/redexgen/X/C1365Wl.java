package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1365Wl implements InterfaceC0838Ba {
    public static byte[] A0E;
    public static String[] A0F = {"FKupPKXcsIkycQ3l5ptAH5wluEqc6YoI", "RW", "ogqWAOna8QODFLIqijT7vOYnhApvYyU7", "UAOUtvFDqNmRNLgZ1GU6DrNnbPesxUgh", "z4WGtVpeHmr0jWMfeyoB2cmDzFByDj9w", "gdGWUcFUabEj8aTRXEAi5amp", "tmhvTid", "WDNv6R6VbALBmvSk6DCmHF7NFi0i9puO"};
    public static final InterfaceC0841Bd A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public InterfaceC0840Bc A04;
    public InterfaceC0848Bm A05;
    public InterfaceC1366Wm A06;
    public Metadata A07;
    public final int A08;
    public final long A09;
    public final C0842Be A0A;
    public final Bf A0B;
    public final Bg A0C;
    public final C0980Hh A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{-94, -57, -65, -56, -110, -92, -96, -79, -94, -89, -92, -93, 95, -77, -82, -82, 95, -84, -96, -83, -72, 95, -95, -72, -77, -92, -78, 109, -115, 121, -119, -128, -100, -83, -78, -85};
    }

    static {
        A05();
        A0G = new C1367Wn();
        A0J = C0996Hx.A08(A04(32, 4, 37));
        A0H = C0996Hx.A08(A04(0, 4, 58));
        A0I = C0996Hx.A08(A04(28, 4, 24));
    }

    public C1365Wl() {
        this(0);
    }

    public C1365Wl(int i) {
        this(i, -9223372036854775807L);
    }

    public C1365Wl(int i, long j) {
        this.A08 = i;
        this.A09 = j;
        this.A0D = new C0980Hh(10);
        this.A0C = new Bg();
        this.A0A = new C0842Be();
        this.A02 = -9223372036854775807L;
        this.A0B = new Bf();
    }

    private int A00(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            interfaceC0839Bb.AEm();
            if (!interfaceC0839Bb.ADm(this.A0D.A00, 0, 4, true)) {
                return -1;
            }
            this.A0D.A0Y(0);
            int iA08 = this.A0D.A08();
            int sampleHeaderData = this.A01;
            if (A06(iA08, sampleHeaderData)) {
                int sampleHeaderData2 = Bg.A00(iA08);
                if (sampleHeaderData2 != -1) {
                    Bg.A04(iA08, this.A0C);
                    if (this.A02 == -9223372036854775807L) {
                        InterfaceC1366Wm interfaceC1366Wm = this.A06;
                        long jA7a = interfaceC0839Bb.A7a();
                        if (A0F[0].charAt(7) == '2') {
                            throw new RuntimeException();
                        }
                        A0F[5] = "uwsYCHPiCgNXlhDD9rc7dT19";
                        this.A02 = interfaceC1366Wm.A7z(jA7a);
                        if (this.A09 != -9223372036854775807L) {
                            this.A02 += this.A09 - this.A06.A7z(0L);
                        }
                    }
                    int sampleHeaderData3 = this.A0C.A02;
                    this.A00 = sampleHeaderData3;
                }
            }
            interfaceC0839Bb.AFe(1);
            this.A01 = 0;
            return 0;
        }
        int iAEq = this.A05.AEq(interfaceC0839Bb, this.A00, true);
        if (iAEq == -1) {
            return -1;
        }
        int bytesAppended = this.A00 - iAEq;
        this.A00 = bytesAppended;
        if (bytesAppended > 0) {
            return 0;
        }
        this.A05.AEs(this.A02 + ((this.A03 * 1000000) / ((long) this.A0C.A03)), 1, this.A0C.A02, 0, null);
        this.A03 += (long) this.A0C.A04;
        this.A00 = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r3 == r0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A01(com.facebook.ads.redexgen.X.C0980Hh r4, int r5) {
        /*
            int r1 = r4.A07()
            int r0 = r5 + 4
            if (r1 < r0) goto L3e
            r4.A0Y(r5)
            int r3 = r4.A08()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1365Wl.A0F
            r0 = 4
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L38
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1365Wl.A0F
            java.lang.String r1 = "RZ9mFeyNnV0sPgPCsPCuasZg37Uzdp17"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "fK9CAyTZYj28knSP6u8xHPIK1qnXYcxa"
            r0 = 3
            r2[r0] = r1
            int r0 = com.facebook.ads.redexgen.X.C1365Wl.A0J
            if (r3 == r0) goto L37
            int r0 = com.facebook.ads.redexgen.X.C1365Wl.A0H
            if (r3 != r0) goto L3e
        L37:
            return r3
        L38:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            int r1 = r4.A07()
            r0 = 40
            if (r1 < r0) goto L54
            r0 = 36
            r4.A0Y(r0)
            int r1 = r4.A08()
            int r0 = com.facebook.ads.redexgen.X.C1365Wl.A0I
            if (r1 != r0) goto L54
            return r0
        L54:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1365Wl.A01(com.facebook.ads.redexgen.X.Hh, int):int");
    }

    private DJ A02(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        interfaceC0839Bb.ADl(this.A0D.A00, 0, 4);
        this.A0D.A0Y(0);
        Bg.A04(this.A0D.A08(), this.A0C);
        return new DJ(interfaceC0839Bb.A7B(), interfaceC0839Bb.A7a(), this.A0C);
    }

    private InterfaceC1366Wm A03(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        C0980Hh c0980Hh = new C0980Hh(this.A0C.A02);
        interfaceC0839Bb.ADl(c0980Hh.A00, 0, this.A0C.A02);
        int i = 21;
        if ((this.A0C.A05 & 1) != 0) {
            int i2 = this.A0C.A01;
            if (A0F[5].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[6] = "1a7oiXE";
            strArr[1] = "rh";
            if (i2 != 1) {
                i = 36;
            }
        } else if (this.A0C.A01 == 1) {
            i = 13;
        }
        int xingBase = A01(c0980Hh, i);
        if (xingBase == A0J || xingBase == A0H) {
            D2 d2A01 = D2.A01(interfaceC0839Bb.A7B(), interfaceC0839Bb.A7a(), this.A0C, c0980Hh);
            if (d2A01 != null && !this.A0A.A03()) {
                interfaceC0839Bb.AEm();
                interfaceC0839Bb.A3S(i + 141);
                C0980Hh frame = this.A0D;
                interfaceC0839Bb.ADl(frame.A00, 0, 3);
                C0980Hh frame2 = this.A0D;
                frame2.A0Y(0);
                C0842Be c0842Be = this.A0A;
                C0980Hh frame3 = this.A0D;
                c0842Be.A04(frame3.A0G());
            }
            interfaceC0839Bb.AFe(this.A0C.A02);
            if (d2A01 != null && !d2A01.A95() && xingBase == A0H) {
                return A02(interfaceC0839Bb);
            }
            return d2A01;
        }
        if (xingBase == A0I) {
            D3 d3A00 = D3.A00(interfaceC0839Bb.A7B(), interfaceC0839Bb.A7a(), this.A0C, c0980Hh);
            interfaceC0839Bb.AFe(this.A0C.A02);
            return d3A00;
        }
        interfaceC0839Bb.AEm();
        return null;
    }

    public static boolean A06(int i, long j) {
        return ((long) ((-128000) & i)) == ((-128000) & j);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    /* JADX WARN: Code duplicated, block: B:58:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0115  */
    /* JADX WARN: Code duplicated, block: B:69:0x009d A[EDGE_INSN: B:69:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x009d A[EDGE_INSN: B:72:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x009d A[EDGE_INSN: B:75:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    private boolean A07(InterfaceC0839Bb interfaceC0839Bb, boolean z) throws InterruptedException, IOException {
        byte[] bArr;
        boolean z2;
        int candidateSynchronizedHeaderData;
        int validFrameCount;
        int candidateSynchronizedHeaderData2;
        int validFrameCount2;
        int iA08;
        int candidateSynchronizedHeaderData3;
        int frameSize = 0;
        int i = 0;
        int peekedId3Bytes = 0;
        int searchedBytes = 0;
        int headerData = z ? 16384 : 131072;
        interfaceC0839Bb.AEm();
        if (interfaceC0839Bb.A7a() == 0) {
            int i2 = this.A08;
            String[] strArr = A0F;
            String str = strArr[4];
            String str2 = strArr[3];
            int candidateSynchronizedHeaderData4 = str.charAt(21);
            int validFrameCount3 = str2.charAt(21);
            if (candidateSynchronizedHeaderData4 != validFrameCount3) {
                String[] strArr2 = A0F;
                strArr2[6] = "aodgJ9F";
                strArr2[1] = "Mh";
                int validFrameCount4 = i2 & 2;
                int validFrameCount5 = validFrameCount4 != 0 ? 1 : 0;
                Metadata metadataA00 = this.A0B.A00(interfaceC0839Bb, validFrameCount5 != 0 ? C0842Be.A04 : null);
                this.A07 = metadataA00;
                if (metadataA00 != null) {
                    C0842Be c0842Be = this.A0A;
                    int candidateSynchronizedHeaderData5 = A0F[5].length();
                    if (candidateSynchronizedHeaderData5 != 24) {
                        String[] strArr3 = A0F;
                        strArr3[2] = "kwUpXSrSJ0NLH72x1DIQc8Fq054MCj03";
                        strArr3[7] = "uritoxjB27zl8eiC6KQaQvgdEg1vP6Ps";
                        c0842Be.A05(metadataA00);
                    } else {
                        A0F[0] = "W2SW3glva3ohlkheP4GgDHO6E3mNlxjo";
                        c0842Be.A05(metadataA00);
                    }
                }
                peekedId3Bytes = (int) interfaceC0839Bb.A7V();
                if (!z) {
                    interfaceC0839Bb.AFe(peekedId3Bytes);
                }
                while (true) {
                    bArr = this.A0D.A00;
                    if (frameSize > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String[] strArr4 = A0F;
                    String str3 = strArr4[4];
                    String str4 = strArr4[3];
                    candidateSynchronizedHeaderData = str3.charAt(21);
                    validFrameCount = str4.charAt(21);
                    if (candidateSynchronizedHeaderData != validFrameCount) {
                        A0F[0] = "F41ajW8QxYjYysO7QQhMOwz5jLXMzQYc";
                        if (!interfaceC0839Bb.ADm(bArr, 0, 4, z2)) {
                            break;
                        }
                        this.A0D.A0Y(0);
                        iA08 = this.A0D.A08();
                        if ((i == 0 && !A06(iA08, i)) || (candidateSynchronizedHeaderData3 = Bg.A00(iA08)) == -1) {
                            int candidateSynchronizedHeaderData6 = searchedBytes + 1;
                            if (searchedBytes == headerData) {
                                if (z) {
                                    return false;
                                }
                                throw new C07909d(A04(4, 24, 32));
                            }
                            frameSize = 0;
                            i = 0;
                            if (z) {
                                interfaceC0839Bb.AEm();
                                int validFrameCount6 = peekedId3Bytes + candidateSynchronizedHeaderData6;
                                interfaceC0839Bb.A3S(validFrameCount6);
                            } else {
                                interfaceC0839Bb.AFe(1);
                            }
                            searchedBytes = candidateSynchronizedHeaderData6;
                        } else {
                            frameSize++;
                            if (frameSize == 1) {
                                Bg.A04(iA08, this.A0C);
                                i = iA08;
                            } else if (frameSize == 4) {
                                break;
                            }
                            int validFrameCount7 = candidateSynchronizedHeaderData3 - 4;
                            interfaceC0839Bb.A3S(validFrameCount7);
                        }
                    } else {
                        if (!interfaceC0839Bb.ADm(bArr, 0, 4, z2)) {
                            break;
                        }
                        this.A0D.A0Y(0);
                        iA08 = this.A0D.A08();
                        if (i == 0) {
                            frameSize++;
                            if (frameSize == 1) {
                                Bg.A04(iA08, this.A0C);
                                i = iA08;
                            } else if (frameSize == 4) {
                                break;
                                break;
                            }
                            int validFrameCount8 = candidateSynchronizedHeaderData3 - 4;
                            interfaceC0839Bb.A3S(validFrameCount8);
                        } else {
                            frameSize++;
                            if (frameSize == 1) {
                                Bg.A04(iA08, this.A0C);
                                i = iA08;
                            } else if (frameSize == 4) {
                                break;
                                break;
                            }
                            int validFrameCount9 = candidateSynchronizedHeaderData3 - 4;
                            interfaceC0839Bb.A3S(validFrameCount9);
                        }
                    }
                }
                if (z) {
                    interfaceC0839Bb.AFe(peekedId3Bytes + searchedBytes);
                } else {
                    interfaceC0839Bb.AEm();
                }
                this.A01 = i;
                String[] strArr5 = A0F;
                String str5 = strArr5[2];
                String str6 = strArr5[7];
                candidateSynchronizedHeaderData2 = str5.charAt(28);
                validFrameCount2 = str6.charAt(28);
                if (candidateSynchronizedHeaderData2 != validFrameCount2) {
                    A0F[0] = "JRrUIGwZBJczcB1fqhgNVGoVSbza2n0c";
                    return true;
                }
            }
        } else {
            while (true) {
                bArr = this.A0D.A00;
                if (frameSize > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                String[] strArr6 = A0F;
                String str7 = strArr6[4];
                String str8 = strArr6[3];
                candidateSynchronizedHeaderData = str7.charAt(21);
                validFrameCount = str8.charAt(21);
                if (candidateSynchronizedHeaderData != validFrameCount) {
                    A0F[0] = "F41ajW8QxYjYysO7QQhMOwz5jLXMzQYc";
                    if (!interfaceC0839Bb.ADm(bArr, 0, 4, z2)) {
                        break;
                        break;
                    }
                    this.A0D.A0Y(0);
                    iA08 = this.A0D.A08();
                    if (i == 0) {
                        frameSize++;
                        if (frameSize == 1) {
                            Bg.A04(iA08, this.A0C);
                            i = iA08;
                        } else if (frameSize == 4) {
                            break;
                            break;
                        }
                        int validFrameCount10 = candidateSynchronizedHeaderData3 - 4;
                        interfaceC0839Bb.A3S(validFrameCount10);
                    } else {
                        frameSize++;
                        if (frameSize == 1) {
                            Bg.A04(iA08, this.A0C);
                            i = iA08;
                        } else if (frameSize == 4) {
                            break;
                            break;
                        }
                        int validFrameCount11 = candidateSynchronizedHeaderData3 - 4;
                        interfaceC0839Bb.A3S(validFrameCount11);
                    }
                } else {
                    if (!interfaceC0839Bb.ADm(bArr, 0, 4, z2)) {
                        break;
                        break;
                    }
                    this.A0D.A0Y(0);
                    iA08 = this.A0D.A08();
                    if (i == 0) {
                        frameSize++;
                        if (frameSize == 1) {
                            Bg.A04(iA08, this.A0C);
                            i = iA08;
                        } else if (frameSize == 4) {
                            break;
                            break;
                        }
                        int validFrameCount12 = candidateSynchronizedHeaderData3 - 4;
                        interfaceC0839Bb.A3S(validFrameCount12);
                    } else {
                        frameSize++;
                        if (frameSize == 1) {
                            Bg.A04(iA08, this.A0C);
                            i = iA08;
                        } else if (frameSize == 4) {
                            break;
                            break;
                        }
                        int validFrameCount13 = candidateSynchronizedHeaderData3 - 4;
                        interfaceC0839Bb.A3S(validFrameCount13);
                    }
                }
            }
            if (z) {
                interfaceC0839Bb.AFe(peekedId3Bytes + searchedBytes);
            } else {
                interfaceC0839Bb.AEm();
            }
            this.A01 = i;
            String[] strArr7 = A0F;
            String str9 = strArr7[2];
            String str10 = strArr7[7];
            candidateSynchronizedHeaderData2 = str9.charAt(28);
            validFrameCount2 = str10.charAt(28);
            if (candidateSynchronizedHeaderData2 != validFrameCount2) {
                A0F[0] = "JRrUIGwZBJczcB1fqhgNVGoVSbza2n0c";
                return true;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A04 = interfaceC0840Bc;
        this.A05 = interfaceC0840Bc.AFx(0, 1);
        this.A04.A5T();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        if (this.A01 == 0) {
            try {
                A07(interfaceC0839Bb, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A06 == null) {
            InterfaceC1366Wm interfaceC1366WmA03 = A03(interfaceC0839Bb);
            this.A06 = interfaceC1366WmA03;
            if (interfaceC1366WmA03 == null || (!interfaceC1366WmA03.A95() && (this.A08 & 1) != 0)) {
                this.A06 = A02(interfaceC0839Bb);
            }
            this.A04.AEx(this.A06);
            this.A05.A5j(Format.A05(null, this.A0C.A06, null, -1, 4096, this.A0C.A01, this.A0C.A03, -1, this.A0A.A00, this.A0A.A01, null, null, 0, null, (this.A08 & 2) != 0 ? null : this.A07));
        }
        return A00(interfaceC0839Bb);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        this.A01 = 0;
        this.A02 = -9223372036854775807L;
        this.A03 = 0L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        return A07(interfaceC0839Bb, true);
    }
}
