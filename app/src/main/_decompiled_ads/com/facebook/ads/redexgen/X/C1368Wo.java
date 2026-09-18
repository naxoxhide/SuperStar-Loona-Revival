package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.DrmInitData;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1368Wo implements InterfaceC0838Ba {
    public static byte[] A0p;
    public static String[] A0q = {"WhKu7pkuAeXCsVE8uRhv3EZwgBp9riSc", "wrDeNyGLCWUv14ZggE2zPWUzu5gjoOIg", "xUs1VEgTJlmvEesGlKYim2mGX89Mn6Ap", "W8YnXYO8xf4ClNYvDZVYWX", "B88t6KSt5rHqx0X", "mP1RKkMa67OSAD0gBpbGTYhDs7d4UNMk", "rmkWP1gG3PZnRTV6Vu72xnpKfVt", "q3NSDD9bEbAX3BTi5XmjKvgCV917aeoR"};
    public static final InterfaceC0841Bd A0r;
    public static final UUID A0s;
    public static final byte[] A0t;
    public static final byte[] A0u;
    public static final byte[] A0v;
    public static final byte[] A0w;
    public static final byte[] A0x;
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public InterfaceC0840Bc A0N;
    public C0854Bw A0O;
    public HX A0P;
    public HX A0Q;
    public ByteBuffer A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public int[] A0b;
    public final SparseArray<C0854Bw> A0c;
    public final InterfaceC0852Bs A0d;
    public final C0855Bz A0e;
    public final C0980Hh A0f;
    public final C0980Hh A0g;
    public final C0980Hh A0h;
    public final C0980Hh A0i;
    public final C0980Hh A0j;
    public final C0980Hh A0k;
    public final C0980Hh A0l;
    public final C0980Hh A0m;
    public final C0980Hh A0n;
    public final boolean A0o;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0p = new byte[]{65, -113, -112, -107, 65, -108, -106, -111, -111, -112, -109, -107, -122, -123, -98, -87, -86, -35, -77, -98, -87, -85, -35, -77, -98, -87, -85, -35, -77, -98, -87, -85, -35, 56, 67, 69, 119, 77, 56, 67, 69, 119, 77, 56, 67, 69, 119, 63, 56, 67, 70, 119, -107, -103, -89, -89, -71, -56, -56, -67, -62, -69, -57, -105, -67, -60, -68, -71, -58, -95, -61, -72, -71, 116, -53, -23, -53, -53, -51, -55, -25, -55, -53, -69, -81, -51, -78, -62, -63, -117, -87, -114, -98, -99, 121, -113, -94, -102, -100, -113, -99, -99, -93, -63, -90, -74, -75, -111, -82, -79, -75, -75, -82, -89, -75, -75, -120, -90, -116, -120, -118, 122, 94, 124, 99, 105, 94, 96, -77, -47, -65, -62, -73, -71, -95, -66, -92, 85, 115, 97, 100, 89, 91, 67, 96, 71, 116, -110, -128, -122, 98, 116, 118, -128, -77, -47, -63, -62, -57, -59, -100, -70, -85, -98, -88, -118, -92, -87, -81, -118, -89, -92, -81, -117, -87, -98, -100, -97, -113, -110, -114, -92, -62, -71, -78, -75, -91, -84, -74, -109, -79, -66, 119, -60, 112, -61, -77, -79, -68, -75, 112, -60, -71, -67, -75, -77, -65, -76, -75, 112, -64, -62, -71, -65, -62, 112, -60, -65, 112, -60, -71, -67, -75, -77, -65, -76, -75, -93, -77, -79, -68, -75, 112, -78, -75, -71, -66, -73, 112, -61, -75, -60, 126, 89, -123, -125, 120, 127, -124, 127, -124, 125, 54, 123, -124, 121, -120, -113, -122, -118, 127, -123, -124, 54, 119, -124, 122, 54, 121, -123, -125, -122, -120, 123, -119, -119, 127, -123, -124, 54, 127, -119, 54, -124, -123, -118, 54, -119, -117, -122, -122, -123, -120, -118, 123, 122, -69, -25, -26, -20, -35, -26, -20, -69, -25, -27, -24, -71, -28, -33, -25, -104, -111, -67, -68, -62, -77, -68, -62, -109, -68, -79, -113, -70, -75, -67, 110, -89, -45, -46, -40, -55, -46, -40, -87, -46, -57, -45, -56, -51, -46, -53, -77, -42, -56, -55, -42, -124, 120, -92, -93, -87, -102, -93, -87, 122, -93, -104, -92, -103, -98, -93, -100, -120, -104, -92, -91, -102, 85, -59, -16, -28, -43, -6, -15, -26, -95, 94, -119, 125, 110, -109, -118, 127, 108, 127, 123, 126, 112, 127, -116, -115, -125, -119, -120, 58, -68, -71, -60, -61, -105, -29, -40, -38, -32, -27, -34, -105, -22, -40, -28, -25, -29, -36, -105, -22, -32, -15, -36, -105, -26, -20, -21, -105, -26, -35, -105, -23, -40, -27, -34, -36, -91, -79, -82, -71, -72, -66, -47, -51, -48, -62, -47, -34, -33, -43, -37, -38, -116, -60, -19, -30, -15, -8, -17, -13, -28, -29, -97, -45, -15, -32, -30, -22, -97, -27, -18, -12, -19, -29, -97, -31, -12, -13, -97, -62, -18, -19, -13, -28, -19, -13, -60, -19, -30, -54, -28, -8, -56, -61, -97, -10, -32, -14, -97, -19, -18, -13, -97, -27, -18, -12, -19, -29, 103, -102, -106, -121, -112, -107, -117, -111, -112, 66, -124, -117, -106, 66, -117, -107, 66, -107, -121, -106, 66, -117, -112, 66, -107, -117, -119, -112, -125, -114, 66, -124, -101, -106, -121, -91, -50, -47, -52, -64, -45, -103, 127, -78, -45, -64, -47, -45, -117, 127, -92, -51, -61, -117, 127, -79, -60, -64, -61, -82, -47, -61, -60, -47, -117, 127, -85, -64, -40, -60, -47, -117, 127, -78, -45, -40, -53, -60, -117, 127, -83, -64, -52, -60, -117, 127, -84, -64, -47, -58, -56, -51, -85, -117, 127, -84, -64, -47, -58, -56, -51, -79, -117, 127, -84, -64, -47, -58, -56, -51, -75, -117, 127, -92, -59, -59, -60, -62, -45, -117, 127, -77, -60, -41, -45, -99, -78, -76, -70, -65, -72, 113, -64, -65, -67, -54, 113, -60, -58, -63, -63, -64, -61, -59, -74, -75, 113, -70, -65, 113, -92, -70, -66, -63, -67, -74, -109, -67, -64, -76, -68, -60, 127, 115, -121, -108, -118, -121, -102, -107, -104, -97, 70, -117, -110, -117, -109, -117, -108, -102, 70, 121, -117, -117, -111, 111, 106, 70, -107, -104, 70, 121, -117, -117, -111, 118, -107, -103, -113, -102, -113, -107, -108, 70, -108, -107, -102, 70, -116, -107, -101, -108, -118, -54, -14, -23, -15, -26, -19, -23, -30, -99, -48, -30, -28, -22, -30, -21, -15, -99, -30, -23, -30, -22, -30, -21, -15, -16, -99, -21, -20, -15, -99, -16, -14, -19, -19, -20, -17, -15, -30, -31, -102, -69, 108, -62, -83, -72, -75, -80, 108, -64, -66, -83, -81, -73, -65, 108, -61, -79, -66, -79, 108, -78, -69, -63, -70, -80, 119, -104, 73, -97, -118, -107, -110, -115, 73, -97, -118, -101, -110, -105, -99, 73, -107, -114, -105, -112, -99, -111, 73, -106, -118, -100, -108, 73, -113, -104, -98, -105, -115, 112, 124, 97, 115, 95, 112, 114, 95, -44, -32, -55, -59, -50, -41, -80, -47, -56, -44, -104, -92, -103, -118, -99, -103, 116, -122, -104, -104, -72, -60, -71, -86, -67, -71, -108, -70, -71, -85, -99, -42, -30, -39, -46, -59, -42, -40, -59, 104, -127, 120, -117, -125, 120, 118, -121, 120, 119, 51, 124, 119, 77, 51, 127, -104, -113, -94, -102, -113, -115, -98, -113, -114, 74, -106, -117, -115, -109, -104, -111, 74, -96, -117, -106, -97, -113, 100, 74, -86, -77, -95, -92, -103, -101, -122, -38, -29, -47, -44, -55, -53, -72, -77, -51, -41, -45, -77, -59, -44, -72, -63, -81, -78, -89, -87, -106, -111, -85, -75, -79, -111, -93, -75, -78, 122, -125, 113, 116, 105, 107, 88, 83, 109, 119, 115, 83, 101, 122, 103, -53, -44, -62, -59, -70, -68, -87, -92, -66, -56, -60, -92, -56, -59, 116, 125, 107, 110, 99, 101, 102, 77, 103, 113, 109, 77, 102, 99, 116, 97, -47, -38, -56, -50, -86, -47, -63, -46, -86, -63, -54, -48, -51, -66, -66, -67, -58, 
        -69, -81, -84, -74, -71, -88, -100, -91, -100, -106, 126, 118, 127, 118, 112, 89, -13, -25, -6, -8, -11, -7, -15, -25, -63, -76, -81, -80, -70, 122, -62, -80, -83, -72, -12, -30, -33, -22};
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0297 A[EDGE_INSN: B:101:0x0297->B:94:0x0297 BREAK  A[LOOP:1: B:90:0x028b->B:92:0x028f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0224 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0202 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x023d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:79:0x0243  */
    /* JADX WARN: Code duplicated, block: B:80:0x0252  */
    /* JADX WARN: Code duplicated, block: B:84:0x0274  */
    /* JADX WARN: Code duplicated, block: B:86:0x0278  */
    /* JADX WARN: Code duplicated, block: B:88:0x0280  */
    /* JADX WARN: Code duplicated, block: B:92:0x028f A[LOOP:1: B:90:0x028b->B:92:0x028f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:93:0x0295  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a9  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A08(InterfaceC0839Bb interfaceC0839Bb, C0854Bw c0854Bw, int i) throws InterruptedException, IOException {
        int iA07;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        int iA00;
        String[] strArr;
        String[] strArr2;
        int i5;
        boolean z;
        int i6;
        if (A03(843, 11, 89).equals(c0854Bw.A0Y)) {
            A09(interfaceC0839Bb, A0w, i);
            return;
        }
        if (A03(833, 10, 57).equals(c0854Bw.A0Y)) {
            A09(interfaceC0839Bb, A0u, i);
            return;
        }
        InterfaceC0848Bm interfaceC0848Bm = c0854Bw.A0W;
        if (this.A0S) {
            iA07 = i + this.A0j.A07();
            if (!A03(938, 15, 24).equals(c0854Bw.A0Y)) {
                strArr2 = A0q;
                if (strArr2[3].length() != strArr2[4].length()) {
                    A0q[7] = "RszYuFLetKptIKAzZi5TrivHGyzVJlzF";
                    if (A03(967, 16, 18).equals(c0854Bw.A0Y)) {
                        if (c0854Bw.A0X != null) {
                            if (this.A0j.A07() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            HI.A04(z);
                            c0854Bw.A0X.A01(interfaceC0839Bb, this.A01, iA07);
                        }
                        while (true) {
                            i5 = this.A07;
                            if (i5 < iA07) {
                                break;
                                break;
                            }
                            A00(interfaceC0839Bb, interfaceC0848Bm, iA07 - i5);
                        }
                    } else {
                        bArr = this.A0h.A00;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        i2 = c0854Bw.A0M;
                        i3 = 4 - c0854Bw.A0M;
                        while (this.A07 < iA07) {
                            i4 = this.A09;
                            if (i4 == 0) {
                                A0A(interfaceC0839Bb, bArr, i3, i2);
                                this.A0h.A0Y(0);
                                this.A09 = this.A0h.A0H();
                                this.A0i.A0Y(0);
                                interfaceC0848Bm.AEr(this.A0i, 4);
                                this.A08 += 4;
                            } else {
                                iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                                strArr = A0q;
                                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                    String[] strArr3 = A0q;
                                    strArr3[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                    strArr3[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                    this.A09 = iA00;
                                }
                            }
                        }
                    }
                } else {
                    String[] strArr4 = A0q;
                    strArr4[0] = "n5KvGwKmSVXSgkcPIzRNIJsu4vgaIOKI";
                    strArr4[2] = "bzKZ8kTny4n19sCxh6YTLkMgvo4kJK45";
                    if (A03(967, 16, 18).equals(c0854Bw.A0Y)) {
                        if (c0854Bw.A0X != null) {
                            if (this.A0j.A07() == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            HI.A04(z);
                            c0854Bw.A0X.A01(interfaceC0839Bb, this.A01, iA07);
                        }
                        while (true) {
                            i5 = this.A07;
                            if (i5 < iA07) {
                                break;
                            } else {
                                A00(interfaceC0839Bb, interfaceC0848Bm, iA07 - i5);
                            }
                        }
                    } else {
                        bArr = this.A0h.A00;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        i2 = c0854Bw.A0M;
                        i3 = 4 - c0854Bw.A0M;
                        while (this.A07 < iA07) {
                            i4 = this.A09;
                            if (i4 == 0) {
                                A0A(interfaceC0839Bb, bArr, i3, i2);
                                this.A0h.A0Y(0);
                                this.A09 = this.A0h.A0H();
                                this.A0i.A0Y(0);
                                interfaceC0848Bm.AEr(this.A0i, 4);
                                this.A08 += 4;
                            } else {
                                iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                                strArr = A0q;
                                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                    String[] strArr5 = A0q;
                                    strArr5[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                    strArr5[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                    this.A09 = iA00;
                                }
                            }
                        }
                    }
                }
            } else {
                bArr = this.A0h.A00;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                i2 = c0854Bw.A0M;
                i3 = 4 - c0854Bw.A0M;
                while (this.A07 < iA07) {
                    i4 = this.A09;
                    if (i4 == 0) {
                        A0A(interfaceC0839Bb, bArr, i3, i2);
                        this.A0h.A0Y(0);
                        this.A09 = this.A0h.A0H();
                        this.A0i.A0Y(0);
                        interfaceC0848Bm.AEr(this.A0i, 4);
                        this.A08 += 4;
                    } else {
                        iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                        strArr = A0q;
                        if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                            String[] strArr6 = A0q;
                            strArr6[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                            strArr6[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                            this.A09 = iA00;
                        }
                    }
                }
            }
            if (A03(181, 8, 87).equals(c0854Bw.A0Y)) {
                this.A0n.A0Y(0);
                interfaceC0848Bm.AEr(this.A0n, 4);
                this.A08 += 4;
                return;
            }
            return;
        }
        if (c0854Bw.A0c) {
            this.A01 &= -1073741825;
            if (!this.A0X) {
                interfaceC0839Bb.readFully(this.A0k.A00, 0, 1);
                this.A07++;
                if ((this.A0k.A00[0] & 128) == 128) {
                    throw new C07909d(A03(504, 35, 22));
                }
                this.A00 = this.A0k.A00[0];
                this.A0X = true;
            }
            byte b2 = this.A00;
            if ((b2 & 1) == 1) {
                boolean z2 = (b2 & 2) == 2;
                this.A01 |= 1073741824;
                if (!this.A0T) {
                    interfaceC0839Bb.readFully(this.A0f.A00, 0, 8);
                    this.A07 += 8;
                    this.A0T = true;
                    this.A0k.A00[0] = (byte) ((z2 ? 128 : 0) | 8);
                    this.A0k.A0Y(0);
                    interfaceC0848Bm.AEr(this.A0k, 1);
                    this.A08++;
                    this.A0f.A0Y(0);
                    interfaceC0848Bm.AEr(this.A0f, 8);
                    this.A08 += 8;
                }
                if (z2) {
                    if (!this.A0U) {
                        interfaceC0839Bb.readFully(this.A0k.A00, 0, 1);
                        this.A07++;
                        this.A0k.A0Y(0);
                        this.A0A = this.A0k.A0E();
                        this.A0U = true;
                    }
                    int i7 = this.A0A * 4;
                    this.A0k.A0W(i7);
                    interfaceC0839Bb.readFully(this.A0k.A00, 0, i7);
                    this.A07 += i7;
                    short s = (short) ((this.A0A / 2) + 1);
                    int i8 = (s * 6) + 2;
                    ByteBuffer byteBuffer = this.A0R;
                    if (byteBuffer == null || byteBuffer.capacity() < i8) {
                        this.A0R = ByteBuffer.allocate(i8);
                    }
                    this.A0R.position(0);
                    if (A0q[7].charAt(2) != 'J') {
                        String[] strArr7 = A0q;
                        strArr7[3] = "THDQpgmvr4cFRBgiNMs8PF";
                        strArr7[4] = "1poAoCQZUv3pf1E";
                        this.A0R.putShort(s);
                        int iA0H = 0;
                        int i9 = 0;
                        while (true) {
                            i6 = this.A0A;
                            if (i9 >= i6) {
                                break;
                            }
                            int i10 = iA0H;
                            iA0H = this.A0k.A0H();
                            if (i9 % 2 == 0) {
                                this.A0R.putShort((short) (iA0H - i10));
                            } else {
                                this.A0R.putInt(iA0H - i10);
                            }
                            i9++;
                        }
                        int i11 = (i - this.A07) - iA0H;
                        if (i6 % 2 == 1) {
                            this.A0R.putInt(i11);
                        } else {
                            this.A0R.putShort((short) i11);
                            this.A0R.putInt(0);
                        }
                        this.A0g.A0b(this.A0R.array(), i8);
                        interfaceC0848Bm.AEr(this.A0g, i8);
                        this.A08 += i8;
                    }
                }
            }
        } else if (c0854Bw.A0f != null) {
            this.A0j.A0b(c0854Bw.A0f, c0854Bw.A0f.length);
        }
        this.A0S = true;
        iA07 = i + this.A0j.A07();
        if (!A03(938, 15, 24).equals(c0854Bw.A0Y)) {
            strArr2 = A0q;
            if (strArr2[3].length() != strArr2[4].length()) {
                A0q[7] = "RszYuFLetKptIKAzZi5TrivHGyzVJlzF";
                if (A03(967, 16, 18).equals(c0854Bw.A0Y)) {
                    if (c0854Bw.A0X != null) {
                        if (this.A0j.A07() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        HI.A04(z);
                        c0854Bw.A0X.A01(interfaceC0839Bb, this.A01, iA07);
                    }
                    while (true) {
                        i5 = this.A07;
                        if (i5 < iA07) {
                            break;
                            break;
                        }
                        A00(interfaceC0839Bb, interfaceC0848Bm, iA07 - i5);
                    }
                } else {
                    bArr = this.A0h.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    i2 = c0854Bw.A0M;
                    i3 = 4 - c0854Bw.A0M;
                    while (this.A07 < iA07) {
                        i4 = this.A09;
                        if (i4 == 0) {
                            A0A(interfaceC0839Bb, bArr, i3, i2);
                            this.A0h.A0Y(0);
                            this.A09 = this.A0h.A0H();
                            this.A0i.A0Y(0);
                            interfaceC0848Bm.AEr(this.A0i, 4);
                            this.A08 += 4;
                        } else {
                            iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                            strArr = A0q;
                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                String[] strArr8 = A0q;
                                strArr8[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                strArr8[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                this.A09 = iA00;
                            }
                        }
                    }
                }
            } else {
                String[] strArr9 = A0q;
                strArr9[0] = "n5KvGwKmSVXSgkcPIzRNIJsu4vgaIOKI";
                strArr9[2] = "bzKZ8kTny4n19sCxh6YTLkMgvo4kJK45";
                if (A03(967, 16, 18).equals(c0854Bw.A0Y)) {
                    if (c0854Bw.A0X != null) {
                        if (this.A0j.A07() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        HI.A04(z);
                        c0854Bw.A0X.A01(interfaceC0839Bb, this.A01, iA07);
                    }
                    while (true) {
                        i5 = this.A07;
                        if (i5 < iA07) {
                            break;
                            break;
                        }
                        A00(interfaceC0839Bb, interfaceC0848Bm, iA07 - i5);
                    }
                } else {
                    bArr = this.A0h.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    i2 = c0854Bw.A0M;
                    i3 = 4 - c0854Bw.A0M;
                    while (this.A07 < iA07) {
                        i4 = this.A09;
                        if (i4 == 0) {
                            A0A(interfaceC0839Bb, bArr, i3, i2);
                            this.A0h.A0Y(0);
                            this.A09 = this.A0h.A0H();
                            this.A0i.A0Y(0);
                            interfaceC0848Bm.AEr(this.A0i, 4);
                            this.A08 += 4;
                        } else {
                            iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                            strArr = A0q;
                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                String[] strArr10 = A0q;
                                strArr10[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                                strArr10[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                                this.A09 = iA00;
                            }
                        }
                    }
                }
            }
        } else {
            bArr = this.A0h.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            i2 = c0854Bw.A0M;
            i3 = 4 - c0854Bw.A0M;
            while (this.A07 < iA07) {
                i4 = this.A09;
                if (i4 == 0) {
                    A0A(interfaceC0839Bb, bArr, i3, i2);
                    this.A0h.A0Y(0);
                    this.A09 = this.A0h.A0H();
                    this.A0i.A0Y(0);
                    interfaceC0848Bm.AEr(this.A0i, 4);
                    this.A08 += 4;
                } else {
                    iA00 = i4 - A00(interfaceC0839Bb, interfaceC0848Bm, i4);
                    strArr = A0q;
                    if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                        String[] strArr11 = A0q;
                        strArr11[1] = "agkFlLz8FmVBufdg5xCACjDlG3vMW3hz";
                        strArr11[5] = "TJ6FvEhwXk7W3hxgnwrmoI06U5KOwDqT";
                        this.A09 = iA00;
                    }
                }
            }
        }
        if (A03(181, 8, 87).equals(c0854Bw.A0Y)) {
            this.A0n.A0Y(0);
            interfaceC0848Bm.AEr(this.A0n, 4);
            this.A08 += 4;
            return;
        }
        return;
        throw new RuntimeException();
    }

    static {
        A06();
        A0r = new C1370Wq();
        A0w = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        A0x = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0t = C0996Hx.A0i(A03(539, 90, 83));
        A0u = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        A0v = new byte[]{32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
        A0s = new UUID(72057594037932032L, -9223371306706625679L);
    }

    public C1368Wo() {
        this(0);
    }

    public C1368Wo(int i) {
        this(new C1371Wr(), i);
    }

    public C1368Wo(InterfaceC0852Bs interfaceC0852Bs, int i) {
        this.A0K = -1L;
        this.A0M = -9223372036854775807L;
        this.A0G = -9223372036854775807L;
        this.A0H = -9223372036854775807L;
        this.A0F = -1L;
        this.A0J = -1L;
        this.A0E = -9223372036854775807L;
        this.A0d = interfaceC0852Bs;
        interfaceC0852Bs.A8f(new C1369Wp(this, null));
        this.A0o = (i & 1) == 0;
        this.A0e = new C0855Bz();
        this.A0c = new SparseArray<>();
        this.A0k = new C0980Hh(4);
        this.A0n = new C0980Hh(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0l = new C0980Hh(4);
        this.A0i = new C0980Hh(C0976Hd.A03);
        this.A0h = new C0980Hh(4);
        this.A0j = new C0980Hh();
        this.A0m = new C0980Hh();
        this.A0f = new C0980Hh(8);
        this.A0g = new C0980Hh();
    }

    private int A00(InterfaceC0839Bb interfaceC0839Bb, InterfaceC0848Bm interfaceC0848Bm, int i) throws InterruptedException, IOException {
        int bytesRead;
        int strippedBytesLeft = this.A0j.A04();
        if (strippedBytesLeft > 0) {
            bytesRead = Math.min(i, strippedBytesLeft);
            interfaceC0848Bm.AEr(this.A0j, bytesRead);
        } else {
            bytesRead = interfaceC0848Bm.AEq(interfaceC0839Bb, i, false);
        }
        this.A07 += bytesRead;
        this.A08 += bytesRead;
        return bytesRead;
    }

    private long A01(long j) throws C07909d {
        long j2 = this.A0M;
        if (j2 != -9223372036854775807L) {
            return C0996Hx.A0F(j, j2, 1000L);
        }
        throw new C07909d(A03(189, 54, 68));
    }

    private InterfaceC0845Bj A02() {
        HX hx;
        HX hx2;
        if (this.A0K == -1 || this.A0H == -9223372036854775807L || (hx = this.A0Q) == null || hx.A02() == 0 || (hx2 = this.A0P) == null || hx2.A02() != this.A0Q.A02()) {
            this.A0Q = null;
            this.A0P = null;
            return new X0(this.A0H);
        }
        int iA02 = this.A0Q.A02();
        int[] iArr = new int[iA02];
        long[] jArr = new long[iA02];
        long[] timesUs = new long[iA02];
        long[] jArr2 = new long[iA02];
        for (int i = 0; i < iA02; i++) {
            jArr2[i] = this.A0Q.A03(i);
            jArr[i] = this.A0K + this.A0P.A03(i);
        }
        for (int i2 = 0; i2 < cuePointsSize; i2++) {
            int cuePointsSize = i2 + 1;
            iArr[i2] = (int) (jArr[cuePointsSize] - jArr[i2]);
            int cuePointsSize2 = i2 + 1;
            timesUs[i2] = jArr2[cuePointsSize2] - jArr2[i2];
        }
        int cuePointsSize3 = iA02 - 1;
        iArr[iA02 - 1] = (int) ((this.A0K + this.A0L) - jArr[cuePointsSize3]);
        timesUs[iA02 - 1] = this.A0H - jArr2[iA02 - 1];
        this.A0Q = null;
        this.A0P = null;
        return new X5(iArr, jArr, timesUs, jArr2);
    }

    private void A05() {
        this.A07 = 0;
        this.A08 = 0;
        this.A09 = 0;
        this.A0S = false;
        this.A0X = false;
        this.A0U = false;
        this.A0A = 0;
        this.A00 = (byte) 0;
        this.A0T = false;
        this.A0j.A0V();
    }

    private void A07(InterfaceC0839Bb interfaceC0839Bb, int i) throws InterruptedException, IOException {
        if (this.A0k.A07() >= i) {
            return;
        }
        if (this.A0k.A05() < i) {
            C0980Hh c0980Hh = this.A0k;
            c0980Hh.A0b(Arrays.copyOf(c0980Hh.A00, Math.max(this.A0k.A00.length * 2, i)), this.A0k.A07());
        }
        byte[] bArr = this.A0k.A00;
        int iA07 = this.A0k.A07();
        if (A0q[6].length() != 27) {
            throw new RuntimeException();
        }
        String[] strArr = A0q;
        strArr[0] = "ZmQc4cegfKT6TM2j1HdEhTMrEsYvVAK8";
        strArr[2] = "PLs1alOmXmQPSsdSdZUe4T02xUG6CaQT";
        interfaceC0839Bb.readFully(bArr, iA07, i - this.A0k.A07());
        this.A0k.A0X(i);
    }

    private void A09(InterfaceC0839Bb interfaceC0839Bb, byte[] bArr, int i) throws InterruptedException, IOException {
        int length = bArr.length + i;
        int sizeWithPrefix = this.A0m.A05();
        if (sizeWithPrefix < length) {
            int sizeWithPrefix2 = length + i;
            this.A0m.A00 = Arrays.copyOf(bArr, sizeWithPrefix2);
        } else {
            System.arraycopy(bArr, 0, this.A0m.A00, 0, bArr.length);
        }
        byte[] bArr2 = this.A0m.A00;
        int sizeWithPrefix3 = bArr.length;
        interfaceC0839Bb.readFully(bArr2, sizeWithPrefix3, i);
        this.A0m.A0W(length);
    }

    private void A0A(InterfaceC0839Bb interfaceC0839Bb, byte[] bArr, int i, int i2) throws InterruptedException, IOException {
        int iMin = Math.min(i2, this.A0j.A04());
        int pendingStrippedBytes = i2 - iMin;
        interfaceC0839Bb.readFully(bArr, i + iMin, pendingStrippedBytes);
        if (iMin > 0) {
            this.A0j.A0c(bArr, i, iMin);
        }
        int pendingStrippedBytes2 = this.A07;
        this.A07 = pendingStrippedBytes2 + i2;
    }

    private void A0B(C0854Bw c0854Bw, long j) {
        if (c0854Bw.A0X != null) {
            Bx bx = c0854Bw.A0X;
            if (A0q[6].length() != 27) {
                throw new RuntimeException();
            }
            A0q[6] = "nKrIVrdQs7NkqXN01cL0onp1lFd";
            bx.A03(c0854Bw, j);
        } else {
            if (A03(843, 11, 89).equals(c0854Bw.A0Y)) {
                A0C(c0854Bw, A03(33, 19, 7), 19, 1000L, A0x);
            } else if (A03(833, 10, 57).equals(c0854Bw.A0Y)) {
                A0C(c0854Bw, A03(14, 19, 109), 21, 10000L, A0v);
            }
            c0854Bw.A0W.AEs(j, this.A01, this.A08, 0, c0854Bw.A0V);
        }
        this.A0V = true;
        A05();
    }

    private void A0C(C0854Bw c0854Bw, String str, int i, long j, byte[] bArr) {
        A0D(this.A0m.A00, this.A0C, str, i, j, bArr);
        InterfaceC0848Bm interfaceC0848Bm = c0854Bw.A0W;
        C0980Hh c0980Hh = this.A0m;
        interfaceC0848Bm.AEr(c0980Hh, c0980Hh.A07());
        this.A08 += this.A0m.A07();
    }

    public static void A0D(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] timeCodeData;
        if (j == -9223372036854775807L) {
            timeCodeData = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - (((long) (i2 * 3600)) * 1000000);
            int i3 = (int) (j3 / 60000000);
            int minutes = i3 * 60;
            long j4 = j3 - (((long) minutes) * 1000000);
            int lastValue = (int) (j4 / 1000000);
            int seconds = (int) ((j4 - (((long) lastValue) * 1000000)) / j2);
            timeCodeData = C0996Hx.A0i(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(lastValue), Integer.valueOf(seconds)));
        }
        System.arraycopy(timeCodeData, 0, bArr, i, bArr2.length);
    }

    private boolean A0E(C0843Bh c0843Bh, long j) {
        if (this.A0Y) {
            this.A0J = j;
            c0843Bh.A00 = this.A0F;
            this.A0Y = false;
            return true;
        }
        boolean z = this.A0a;
        String[] strArr = A0q;
        if (strArr[0].charAt(31) == strArr[2].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0q;
        strArr2[1] = "bgcuSmmv9nMD5qNgR1ZnJGCWOsXR4zDF";
        strArr2[5] = "rXrXJdml0w7r8hjghYXvJH5LLiJomjK3";
        if (z) {
            long j2 = this.A0J;
            if (j2 != -1) {
                c0843Bh.A00 = j2;
                this.A0J = -1L;
                return true;
            }
        }
        return false;
    }

    public static boolean A0F(String str) {
        if (!A03(PointerIconCompat.TYPE_CELL, 5, 58).equals(str) && !A03(PointerIconCompat.TYPE_COPY, 5, 20).equals(str) && !A03(902, 7, 72).equals(str)) {
            String strA03 = A03(953, 14, 105);
            String[] strArr = A0q;
            if (strArr[1].charAt(15) == strArr[5].charAt(15)) {
                A0q[7] = "rYhgwmDh4TKBcj4Uwcvshsmah3Wf4ae0";
                if (!strA03.equals(str) && !A03(923, 15, 86).equals(str) && !A03(909, 14, 120).equals(str) && !A03(938, 15, 24).equals(str) && !A03(967, 16, 18).equals(str) && !A03(983, 15, 111).equals(str)) {
                    String[] strArr2 = A0q;
                    if (strArr2[1].charAt(15) != strArr2[5].charAt(15)) {
                        throw new RuntimeException();
                    }
                    A0q[6] = "rlxG2GXYid9bCHwXApke8Gz33sW";
                    if (!A03(998, 8, 91).equals(str) && !A03(154, 6, 102).equals(str) && !A03(181, 8, 87).equals(str) && !A03(74, 5, 126).equals(str) && !A03(128, 9, 102).equals(str) && !A03(137, 9, 8).equals(str) && !A03(79, 5, 124).equals(str) && !A03(116, 6, 59).equals(str) && !A03(173, 8, 62).equals(str) && !A03(84, 5, 98).equals(str) && !A03(89, 13, 62).equals(str) && !A03(102, 14, 86).equals(str) && !A03(122, 6, 17).equals(str) && !A03(146, 8, 39).equals(str) && !A03(160, 13, 79).equals(str)) {
                        boolean zEquals = A03(843, 11, 89).equals(str);
                        String[] strArr3 = A0q;
                        if (strArr3[0].charAt(31) != strArr3[2].charAt(31)) {
                            String[] strArr4 = A0q;
                            strArr4[1] = "DfP1dlVZEdoO22ggDOih4DhJX4h9DttB";
                            strArr4[5] = "iPMsbxRLvFu5COzgJWPWeI2fmUuAHT3S";
                            if (!zEquals && !A03(833, 10, 57).equals(str) && !A03(854, 8, 119).equals(str) && !A03(823, 10, 117).equals(str) && !A03(815, 8, 17).equals(str)) {
                                return false;
                            }
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return true;
    }

    public static int[] A0H(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    public final void A0I(int i) throws C07909d {
        switch (i) {
            case 160:
                if (this.A04 != 2) {
                    return;
                }
                if (!this.A0W) {
                    this.A01 = 1 | this.A01;
                }
                A0B(this.A0c.get(this.A05), this.A0D);
                this.A04 = 0;
                return;
            case 174:
                if (A0F(this.A0O.A0Y)) {
                    C0854Bw c0854Bw = this.A0O;
                    c0854Bw.A09(this.A0N, c0854Bw.A0N);
                    this.A0c.put(this.A0O.A0N, this.A0O);
                }
                this.A0O = null;
                return;
            case 19899:
                int i2 = this.A0B;
                if (i2 != -1) {
                    long j = this.A0I;
                    if (j != -1) {
                        if (i2 != 475249515) {
                            return;
                        }
                        this.A0F = j;
                        return;
                    }
                }
                throw new C07909d(A03(667, 50, 26));
            case 25152:
                if (!this.A0O.A0c) {
                    return;
                }
                if (this.A0O.A0V != null) {
                    this.A0O.A0U = new DrmInitData(new DrmInitData.SchemeData(C9E.A04, A03(1024, 10, 63), this.A0O.A0V.A03));
                    return;
                }
                throw new C07909d(A03(449, 55, 115));
            case 28032:
                if (!this.A0O.A0c || this.A0O.A0f == null) {
                    return;
                } else {
                    throw new C07909d(A03(243, 53, 10));
                }
            case 357149030:
                if (this.A0M == -9223372036854775807L) {
                    this.A0M = 1000000L;
                }
                long j2 = this.A0G;
                if (j2 == -9223372036854775807L) {
                    return;
                }
                this.A0H = A01(j2);
                return;
            case 374648427:
                if (this.A0c.size() != 0) {
                    this.A0N.A5T();
                    return;
                }
                throw new C07909d(A03(756, 26, 64));
            case 475249515:
                if (this.A0a) {
                    return;
                }
                this.A0N.AEx(A02());
                this.A0a = true;
                return;
            default:
                return;
        }
    }

    public final void A0J(int i, double d) {
        switch (i) {
            case 181:
                this.A0O.A0O = (int) d;
                break;
            case 17545:
                this.A0G = (long) d;
                break;
            case 21969:
                this.A0O.A06 = (float) d;
                break;
            case 21970:
                this.A0O.A07 = (float) d;
                break;
            case 21971:
                this.A0O.A04 = (float) d;
                break;
            case 21972:
                this.A0O.A05 = (float) d;
                break;
            case 21973:
                this.A0O.A02 = (float) d;
                break;
            case 21974:
                this.A0O.A03 = (float) d;
                break;
            case 21975:
                this.A0O.A08 = (float) d;
                break;
            case 21976:
                this.A0O.A09 = (float) d;
                break;
            case 21977:
                this.A0O.A00 = (float) d;
                break;
            case 21978:
                this.A0O.A01 = (float) d;
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0307  */
    /* JADX WARN: Code duplicated, block: B:123:0x01de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x020d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:131:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x02b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x023c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x027e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x017e A[PHI: r3
      0x017e: PHI (r3v18 int[]) = (r3v10 int[]), (r3v19 int[]) binds: [B:55:0x01a0, B:50:0x017c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x01b5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:75:0x0213  */
    /* JADX WARN: Code duplicated, block: B:77:0x0229  */
    /* JADX WARN: Code duplicated, block: B:79:0x022e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0251 A[LOOP:4: B:82:0x024f->B:83:0x0251, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:84:0x025f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0282  */
    /* JADX WARN: Code duplicated, block: B:92:0x0293  */
    /* JADX WARN: Code duplicated, block: B:94:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:99:0x02c2  */
    public final void A0K(int i, int headerSize, InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        int[] iArrA0H;
        int i2;
        int i3;
        int i4;
        int i5;
        String[] strArr;
        long j;
        int sampleIndex;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        String[] strArr2;
        int headerSize2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        String[] strArr3;
        int i16 = 0;
        int i17 = 1;
        switch (i) {
            case 161:
            case 163:
                if (this.A04 == 0) {
                    this.A05 = (int) this.A0e.A05(interfaceC0839Bb, false, true, 8);
                    this.A06 = this.A0e.A04();
                    this.A0C = -9223372036854775807L;
                    this.A04 = 1;
                    this.A0k.A0V();
                }
                C0854Bw c0854Bw = this.A0c.get(this.A05);
                if (c0854Bw == null) {
                    interfaceC0839Bb.AFe(headerSize - this.A06);
                    this.A04 = 0;
                    return;
                }
                if (this.A04 == 1) {
                    A07(interfaceC0839Bb, 3);
                    int i18 = (this.A0k.A00[2] & 6) >> 1;
                    if (i18 == 0) {
                        this.A02 = 1;
                        int[] iArrA0H2 = A0H(this.A0b, 1);
                        this.A0b = iArrA0H2;
                        iArrA0H2[0] = (headerSize - this.A06) - 3;
                    } else if (i == 163) {
                        A07(interfaceC0839Bb, 4);
                        int i19 = (this.A0k.A00[3] & 255) + 1;
                        this.A02 = i19;
                        int[] iArr2 = this.A0b;
                        String[] strArr4 = A0q;
                        if (strArr4[0].charAt(31) != strArr4[2].charAt(31)) {
                            String[] strArr5 = A0q;
                            strArr5[3] = "RwuJZhEYbPwrYhgspkpAZU";
                            strArr5[4] = "DTAVHXJ2rXJnopR";
                            iArrA0H = A0H(iArr2, i19);
                            this.A0b = iArrA0H;
                            if (i18 == 2) {
                                i14 = (headerSize - this.A06) - 4;
                                i15 = this.A02;
                                strArr3 = A0q;
                                if (strArr3[1].charAt(15) == strArr3[5].charAt(15)) {
                                    String[] strArr6 = A0q;
                                    strArr6[1] = "RQftDwpqwbIXAF1g5dDgy2XjM3R9Fufd";
                                    strArr6[5] = "50lzYqnE8by0N6RgVVPD3M33x9kk99sn";
                                    Arrays.fill(iArrA0H, 0, i15, i14 / i15);
                                }
                            } else if (i18 == 1) {
                                if (i18 == 3) {
                                    i2 = 0;
                                    i3 = 4;
                                    i4 = 0;
                                    while (true) {
                                        i5 = this.A02;
                                        if (i4 < i5 - 1) {
                                            this.A0b[i5 - 1] = ((headerSize - this.A06) - i3) - i2;
                                        } else {
                                            this.A0b[i4] = i16;
                                            strArr = A0q;
                                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                                throw new RuntimeException();
                                            }
                                            A0q[6] = "AJCSp0dPwFu9XZoKvCoy3nlmL9O";
                                            i3++;
                                            A07(interfaceC0839Bb, i3);
                                            if (this.A0k.A00[i3 - 1] != 0) {
                                                j = 0;
                                                sampleIndex = 0;
                                                while (sampleIndex < 8) {
                                                    i7 = i17 << (7 - sampleIndex);
                                                    if ((this.A0k.A00[i3 - 1] & i7) != 0) {
                                                        int i20 = i3 - 1;
                                                        i3 += sampleIndex;
                                                        A07(interfaceC0839Bb, i3);
                                                        j = this.A0k.A00[i20] & 255 & (i7 ^ (-1));
                                                        for (i8 = i20 + 1; i8 < i3; i8++) {
                                                            j = (j << 8) | ((long) (this.A0k.A00[i8] & 255));
                                                        }
                                                        if (i4 > 0) {
                                                            j -= (1 << ((sampleIndex * 7) + 6)) - 1;
                                                        }
                                                        if (j < -2147483648L) {
                                                            if (A0q[7].charAt(2) != 'J') {
                                                                String[] strArr7 = A0q;
                                                                strArr7[3] = "iXrhrupjbccuPW1gfooQkR";
                                                                strArr7[4] = "StwCIbMJGGxOC39";
                                                                if (j > 2147483647L) {
                                                                }
                                                                i6 = (int) j;
                                                                iArr = this.A0b;
                                                                if (i4 == 0) {
                                                                    i6 += iArr[i4 - 1];
                                                                }
                                                                iArr[i4] = i6;
                                                                i2 += i6;
                                                                i4++;
                                                                i16 = 0;
                                                                i17 = 1;
                                                            } else {
                                                                if (j > 2147483647L) {
                                                                }
                                                                i6 = (int) j;
                                                                iArr = this.A0b;
                                                                if (i4 == 0) {
                                                                    i6 += iArr[i4 - 1];
                                                                }
                                                                iArr[i4] = i6;
                                                                i2 += i6;
                                                                i4++;
                                                                i16 = 0;
                                                                i17 = 1;
                                                            }
                                                        }
                                                        throw new C07909d(A03(396, 37, 107));
                                                    }
                                                    sampleIndex++;
                                                    strArr2 = A0q;
                                                    if (strArr2[0].charAt(31) != strArr2[2].charAt(31)) {
                                                        A0q[7] = "JvemuAcSz5vc2l4QyutSma8u3cOiXxC4";
                                                        i17 = 1;
                                                    } else {
                                                        i17 = 1;
                                                    }
                                                }
                                                if (j < -2147483648L) {
                                                    if (A0q[7].charAt(2) != 'J') {
                                                        String[] strArr8 = A0q;
                                                        strArr8[3] = "iXrhrupjbccuPW1gfooQkR";
                                                        strArr8[4] = "StwCIbMJGGxOC39";
                                                        if (j > 2147483647L) {
                                                        }
                                                        i6 = (int) j;
                                                        iArr = this.A0b;
                                                        if (i4 == 0) {
                                                            i6 += iArr[i4 - 1];
                                                        }
                                                        iArr[i4] = i6;
                                                        i2 += i6;
                                                        i4++;
                                                        i16 = 0;
                                                        i17 = 1;
                                                    } else {
                                                        if (j > 2147483647L) {
                                                        }
                                                        i6 = (int) j;
                                                        iArr = this.A0b;
                                                        if (i4 == 0) {
                                                            i6 += iArr[i4 - 1];
                                                        }
                                                        iArr[i4] = i6;
                                                        i2 += i6;
                                                        i4++;
                                                        i16 = 0;
                                                        i17 = 1;
                                                    }
                                                }
                                                throw new C07909d(A03(396, 37, 107));
                                            }
                                            throw new C07909d(A03(782, 33, 29));
                                        }
                                    }
                                } else {
                                    throw new C07909d(A03(877, 25, 30) + i18);
                                }
                            } else {
                                headerSize2 = 0;
                                i9 = 4;
                                i10 = 0;
                                while (true) {
                                    i11 = this.A02;
                                    if (i10 < i11 - 1) {
                                        this.A0b[i11 - 1] = ((headerSize - this.A06) - i9) - headerSize2;
                                    } else {
                                        this.A0b[i10] = 0;
                                        do {
                                            i9++;
                                            A07(interfaceC0839Bb, i9);
                                            i12 = this.A0k.A00[i9 - 1] & 255;
                                            int[] iArr3 = this.A0b;
                                            i13 = iArr3[i10] + i12;
                                            iArr3[i10] = i13;
                                        } while (i12 == 255);
                                        headerSize2 += i13;
                                        i10++;
                                    }
                                }
                            }
                        } else {
                            iArrA0H = A0H(iArr2, i19);
                            this.A0b = iArrA0H;
                            if (i18 == 2) {
                                i14 = (headerSize - this.A06) - 4;
                                i15 = this.A02;
                                strArr3 = A0q;
                                if (strArr3[1].charAt(15) == strArr3[5].charAt(15)) {
                                    String[] strArr9 = A0q;
                                    strArr9[1] = "RQftDwpqwbIXAF1g5dDgy2XjM3R9Fufd";
                                    strArr9[5] = "50lzYqnE8by0N6RgVVPD3M33x9kk99sn";
                                    Arrays.fill(iArrA0H, 0, i15, i14 / i15);
                                }
                            } else if (i18 == 1) {
                                if (i18 == 3) {
                                    i2 = 0;
                                    i3 = 4;
                                    i4 = 0;
                                    while (true) {
                                        i5 = this.A02;
                                        if (i4 < i5 - 1) {
                                            this.A0b[i5 - 1] = ((headerSize - this.A06) - i3) - i2;
                                        } else {
                                            this.A0b[i4] = i16;
                                            strArr = A0q;
                                            if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                                                throw new RuntimeException();
                                            }
                                            A0q[6] = "AJCSp0dPwFu9XZoKvCoy3nlmL9O";
                                            i3++;
                                            A07(interfaceC0839Bb, i3);
                                            if (this.A0k.A00[i3 - 1] != 0) {
                                                j = 0;
                                                sampleIndex = 0;
                                                while (sampleIndex < 8) {
                                                    i7 = i17 << (7 - sampleIndex);
                                                    if ((this.A0k.A00[i3 - 1] & i7) != 0) {
                                                        int i21 = i3 - 1;
                                                        i3 += sampleIndex;
                                                        A07(interfaceC0839Bb, i3);
                                                        j = this.A0k.A00[i21] & 255 & (i7 ^ (-1));
                                                        while (i8 < i3) {
                                                            j = (j << 8) | ((long) (this.A0k.A00[i8] & 255));
                                                        }
                                                        if (i4 > 0) {
                                                            j -= (1 << ((sampleIndex * 7) + 6)) - 1;
                                                        }
                                                        if (j < -2147483648L) {
                                                            if (A0q[7].charAt(2) != 'J') {
                                                                String[] strArr10 = A0q;
                                                                strArr10[3] = "iXrhrupjbccuPW1gfooQkR";
                                                                strArr10[4] = "StwCIbMJGGxOC39";
                                                                if (j > 2147483647L) {
                                                                }
                                                                i6 = (int) j;
                                                                iArr = this.A0b;
                                                                if (i4 == 0) {
                                                                    i6 += iArr[i4 - 1];
                                                                }
                                                                iArr[i4] = i6;
                                                                i2 += i6;
                                                                i4++;
                                                                i16 = 0;
                                                                i17 = 1;
                                                            } else {
                                                                if (j > 2147483647L) {
                                                                }
                                                                i6 = (int) j;
                                                                iArr = this.A0b;
                                                                if (i4 == 0) {
                                                                    i6 += iArr[i4 - 1];
                                                                }
                                                                iArr[i4] = i6;
                                                                i2 += i6;
                                                                i4++;
                                                                i16 = 0;
                                                                i17 = 1;
                                                            }
                                                        }
                                                        throw new C07909d(A03(396, 37, 107));
                                                    }
                                                    sampleIndex++;
                                                    strArr2 = A0q;
                                                    if (strArr2[0].charAt(31) != strArr2[2].charAt(31)) {
                                                        A0q[7] = "JvemuAcSz5vc2l4QyutSma8u3cOiXxC4";
                                                        i17 = 1;
                                                    } else {
                                                        i17 = 1;
                                                    }
                                                }
                                                if (j < -2147483648L) {
                                                    if (A0q[7].charAt(2) != 'J') {
                                                        String[] strArr11 = A0q;
                                                        strArr11[3] = "iXrhrupjbccuPW1gfooQkR";
                                                        strArr11[4] = "StwCIbMJGGxOC39";
                                                        if (j > 2147483647L) {
                                                        }
                                                        i6 = (int) j;
                                                        iArr = this.A0b;
                                                        if (i4 == 0) {
                                                            i6 += iArr[i4 - 1];
                                                        }
                                                        iArr[i4] = i6;
                                                        i2 += i6;
                                                        i4++;
                                                        i16 = 0;
                                                        i17 = 1;
                                                    } else {
                                                        if (j > 2147483647L) {
                                                        }
                                                        i6 = (int) j;
                                                        iArr = this.A0b;
                                                        if (i4 == 0) {
                                                            i6 += iArr[i4 - 1];
                                                        }
                                                        iArr[i4] = i6;
                                                        i2 += i6;
                                                        i4++;
                                                        i16 = 0;
                                                        i17 = 1;
                                                    }
                                                }
                                                throw new C07909d(A03(396, 37, 107));
                                            }
                                            throw new C07909d(A03(782, 33, 29));
                                        }
                                    }
                                } else {
                                    throw new C07909d(A03(877, 25, 30) + i18);
                                }
                            } else {
                                headerSize2 = 0;
                                i9 = 4;
                                i10 = 0;
                                while (true) {
                                    i11 = this.A02;
                                    if (i10 < i11 - 1) {
                                        this.A0b[i11 - 1] = ((headerSize - this.A06) - i9) - headerSize2;
                                    } else {
                                        this.A0b[i10] = 0;
                                        do {
                                            i9++;
                                            A07(interfaceC0839Bb, i9);
                                            i12 = this.A0k.A00[i9 - 1] & 255;
                                            int[] iArr4 = this.A0b;
                                            i13 = iArr4[i10] + i12;
                                            iArr4[i10] = i13;
                                        } while (i12 == 255);
                                        headerSize2 += i13;
                                        i10++;
                                    }
                                }
                            }
                        }
                    } else {
                        throw new C07909d(A03(629, 38, 69));
                    }
                    this.A0D = this.A0E + A01((this.A0k.A00[0] << 8) | (this.A0k.A00[1] & 255));
                    this.A01 = (c0854Bw.A0Q == 2 || (i == 163 && (this.A0k.A00[2] & 128) == 128) ? 1 : 0) | ((this.A0k.A00[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                    this.A04 = 2;
                    this.A03 = 0;
                }
                if (i != 163) {
                    A08(interfaceC0839Bb, c0854Bw, this.A0b[0]);
                    return;
                }
                while (true) {
                    int i22 = this.A03;
                    if (i22 < this.A02) {
                        A08(interfaceC0839Bb, c0854Bw, this.A0b[i22]);
                        A0B(c0854Bw, this.A0D + ((long) ((this.A03 * c0854Bw.A0F) / 1000)));
                        int i23 = this.A03;
                        String[] strArr12 = A0q;
                        if (strArr12[3].length() != strArr12[4].length()) {
                            String[] strArr13 = A0q;
                            strArr13[3] = "D8CgfCqU2RyOXDgpSzfJOF";
                            strArr13[4] = "qE8wnFvtme9ZmNp";
                            this.A03 = i23 + 1;
                        } else {
                            String[] strArr14 = A0q;
                            strArr14[0] = "QTaMrDGiQsJaoOEX9JrEklVzvDfFq8um";
                            strArr14[2] = "wfV4ykUdaNXbzihAU76Od3hvCzrHPeln";
                            this.A03 = i23 + 1;
                        }
                    } else {
                        this.A04 = 0;
                        return;
                    }
                }
                break;
            case 16981:
                this.A0O.A0f = new byte[headerSize];
                byte[] bArr = this.A0O.A0f;
                String[] strArr15 = A0q;
                if (strArr15[1].charAt(15) == strArr15[5].charAt(15)) {
                    A0q[6] = "apQqLvL9mVkkZpyD1gGQRufbtxV";
                    interfaceC0839Bb.readFully(bArr, 0, headerSize);
                    return;
                }
                break;
            case 18402:
                byte[] bArr2 = new byte[headerSize];
                interfaceC0839Bb.readFully(bArr2, 0, headerSize);
                this.A0O.A0V = new C0847Bl(1, bArr2, 0, 0);
                return;
            case 21419:
                Arrays.fill(this.A0l.A00, (byte) 0);
                interfaceC0839Bb.readFully(this.A0l.A00, 4 - headerSize, headerSize);
                this.A0l.A0Y(0);
                this.A0B = (int) this.A0l.A0M();
                return;
            case 25506:
                this.A0O.A0d = new byte[headerSize];
                interfaceC0839Bb.readFully(this.A0O.A0d, 0, headerSize);
                return;
            case 30322:
                this.A0O.A0e = new byte[headerSize];
                interfaceC0839Bb.readFully(this.A0O.A0e, 0, headerSize);
                return;
            default:
                throw new C07909d(A03(862, 15, 7) + i);
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0040  */
    public final void A0L(int i, long j) throws C07909d {
        boolean z = false;
        String strA03 = A03(0, 14, 21);
        switch (i) {
            case 131:
                this.A0O.A0Q = (int) j;
                return;
            case 136:
                C0854Bw c0854Bw = this.A0O;
                String[] strArr = A0q;
                if (strArr[1].charAt(15) != strArr[5].charAt(15)) {
                    String[] strArr2 = A0q;
                    strArr2[1] = "dnlPxGSMw9IfVDogfualtgwGzOIqKL0v";
                    strArr2[5] = "sfCl2vw1fgJd0VDghIrSAi3kGetUjpNf";
                    if (j == 1) {
                        z = true;
                    }
                } else {
                    String[] strArr3 = A0q;
                    strArr3[1] = "e8S13q37f3oqi2Xgxg7oDCnYjszKvzMZ";
                    strArr3[5] = "sUUQ807hVNhLoz0ge5jS5NLDJS8BF8yk";
                    if (j == 1) {
                        z = true;
                    }
                }
                c0854Bw.A0Z = z;
                return;
            case 155:
                this.A0C = A01(j);
                return;
            case 159:
                this.A0O.A0B = (int) j;
                return;
            case 176:
                this.A0O.A0R = (int) j;
                return;
            case 179:
                this.A0Q.A04(A01(j));
                return;
            case 186:
                this.A0O.A0J = (int) j;
                return;
            case 215:
                this.A0O.A0N = (int) j;
                return;
            case 231:
                this.A0E = A01(j);
                return;
            case 241:
                if (this.A0Z) {
                    return;
                }
                HX hx = this.A0P;
                String[] strArr4 = A0q;
                if (strArr4[0].charAt(31) == strArr4[2].charAt(31)) {
                    throw new RuntimeException();
                }
                String[] strArr5 = A0q;
                strArr5[3] = "PHYzuIxoVCpcvyGp46FNV8";
                strArr5[4] = "jONBlxc6dKLj6ao";
                hx.A04(j);
                this.A0Z = true;
                return;
            case 251:
                this.A0W = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                } else {
                    throw new C07909d(A03(296, 16, 108) + j + strA03);
                }
            case 17029:
                if (j >= 1 && j <= 2) {
                    return;
                } else {
                    throw new C07909d(A03(377, 19, 14) + j + strA03);
                }
            case 17143:
                if (j == 1) {
                    return;
                } else {
                    throw new C07909d(A03(433, 16, 96) + j + strA03);
                }
            case 18401:
                if (j == 5) {
                    return;
                } else {
                    throw new C07909d(A03(312, 15, 66) + j + strA03);
                }
            case 18408:
                if (j == 1) {
                    return;
                } else {
                    throw new C07909d(A03(52, 22, 72) + j + strA03);
                }
            case 20529:
                if (j == 0) {
                    return;
                } else {
                    throw new C07909d(A03(327, 21, 88) + j + strA03);
                }
            case 20530:
                if (j == 1) {
                    return;
                } else {
                    throw new C07909d(A03(348, 21, 41) + j + strA03);
                }
            case 21420:
                this.A0I = this.A0K + j;
                return;
            case 21432:
                int layout = (int) j;
                switch (layout) {
                    case 0:
                        this.A0O.A0P = 0;
                        return;
                    case 1:
                        this.A0O.A0P = 2;
                        return;
                    case 3:
                        this.A0O.A0P = 1;
                        return;
                    case 15:
                        this.A0O.A0P = 3;
                        return;
                    default:
                        return;
                }
            case 21680:
                int layout2 = (int) j;
                this.A0O.A0I = layout2;
                return;
            case 21682:
                int layout3 = (int) j;
                this.A0O.A0H = layout3;
                return;
            case 21690:
                int layout4 = (int) j;
                this.A0O.A0G = layout4;
                return;
            case 21930:
                C0854Bw c0854Bw2 = this.A0O;
                if (A0q[7].charAt(2) != 'J') {
                    A0q[7] = "jzNtO6nbghsOK2zNzcbiuAHR0hMudXvD";
                    c0854Bw2.A0a = j == 1;
                    return;
                }
                break;
            case 21945:
                int layout5 = (int) j;
                switch (layout5) {
                    case 1:
                        this.A0O.A0C = 2;
                        return;
                    case 2:
                        this.A0O.A0C = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int layout6 = (int) j;
                switch (layout6) {
                    case 1:
                    case 6:
                    case 7:
                        C0854Bw c0854Bw3 = this.A0O;
                        String[] strArr6 = A0q;
                        String str = strArr6[3];
                        String str2 = strArr6[4];
                        int length = str.length();
                        int layout7 = str2.length();
                        if (length != layout7) {
                            A0q[7] = "mV5wi4RdAtLICzfql5r9CviPSqv5gEzL";
                            c0854Bw3.A0E = 3;
                            return;
                        }
                        break;
                    case 16:
                        this.A0O.A0E = 6;
                        return;
                    case 18:
                        this.A0O.A0E = 7;
                        return;
                    default:
                        return;
                }
                break;
            case 21947:
                this.A0O.A0b = true;
                int layout8 = (int) j;
                switch (layout8) {
                    case 1:
                        this.A0O.A0D = 1;
                        return;
                    case 2:
                    case 3:
                    case 8:
                    default:
                        return;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        C0854Bw c0854Bw4 = this.A0O;
                        if (A0q[6].length() == 27) {
                            String[] strArr7 = A0q;
                            strArr7[0] = "a0uWSiKj3FE77SqtP8skZXqIoOHsVkha";
                            strArr7[2] = "zxuZMYlEoYkqiqBcXObqrQLJbRKLzsvV";
                            c0854Bw4.A0D = 2;
                            return;
                        }
                        break;
                    case 9:
                        this.A0O.A0D = 6;
                        return;
                }
                break;
            case 21948:
                int layout9 = (int) j;
                this.A0O.A0K = layout9;
                return;
            case 21949:
                C0854Bw c0854Bw5 = this.A0O;
                int i2 = (int) j;
                if (A0q[6].length() == 27) {
                    A0q[7] = "cRzVQdX7r3sNL6uNWZqYIbMTncmWUqDN";
                    c0854Bw5.A0L = i2;
                    return;
                }
                break;
            case 22186:
                this.A0O.A0S = j;
                return;
            case 22203:
                this.A0O.A0T = j;
                return;
            case 25188:
                int layout10 = (int) j;
                this.A0O.A0A = layout10;
                return;
            case 2352003:
                int layout11 = (int) j;
                this.A0O.A0F = layout11;
                return;
            case 2807729:
                this.A0M = j;
                return;
            default:
                return;
        }
        throw new RuntimeException();
    }

    public final void A0M(int i, long j, long j2) throws C07909d {
        switch (i) {
            case 160:
                this.A0W = false;
                return;
            case 174:
                this.A0O = new C0854Bw(null);
                return;
            case 187:
                this.A0Z = false;
                return;
            case 19899:
                this.A0B = -1;
                this.A0I = -1L;
                return;
            case 20533:
                this.A0O.A0c = true;
                return;
            case 21968:
                this.A0O.A0b = true;
                return;
            case 25152:
            default:
                return;
            case 408125543:
                long j3 = this.A0K;
                if (j3 == -1 || j3 == j) {
                    this.A0K = j;
                    this.A0L = j2;
                    return;
                }
                throw new C07909d(A03(717, 39, 113));
            case 475249515:
                this.A0Q = new HX();
                this.A0P = new HX();
                return;
            case 524531317:
                if (this.A0a) {
                    return;
                }
                if (this.A0o && this.A0F != -1) {
                    this.A0Y = true;
                    return;
                } else {
                    this.A0N.AEx(new X0(this.A0H));
                    this.A0a = true;
                    return;
                }
        }
    }

    public final void A0N(int i, String str) throws C07909d {
        switch (i) {
            case 134:
                this.A0O.A0Y = str;
                return;
            case FirebaseError.ERROR_WEAK_PASSWORD /* 17026 */:
                if (A03(1034, 4, 113).equals(str) || A03(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 8, 122).equals(str)) {
                    return;
                } else {
                    throw new C07909d(A03(369, 8, 117) + str + A03(0, 14, 21));
                }
            case 2274716:
                this.A0O.A0g = str;
                return;
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A0N = interfaceC0840Bc;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        this.A0V = false;
        boolean zAEB = true;
        while (zAEB && !this.A0V) {
            zAEB = this.A0d.AEB(interfaceC0839Bb);
            if (zAEB && A0E(c0843Bh, interfaceC0839Bb.A7a())) {
                return 1;
            }
        }
        if (zAEB) {
            return 0;
        }
        int i = 0;
        while (true) {
            SparseArray<C0854Bw> sparseArray = this.A0c;
            String[] strArr = A0q;
            String str = strArr[0];
            String str2 = strArr[2];
            int iCharAt = str.charAt(31);
            int i2 = str2.charAt(31);
            if (iCharAt == i2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0q;
            strArr2[3] = "Tajypdz7aNAm7FibYO8x24";
            strArr2[4] = "TBunjD0UUDKaUo7";
            int i3 = sparseArray.size();
            if (i < i3) {
                this.A0c.valueAt(i).A07();
                i++;
            } else {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        this.A0E = -9223372036854775807L;
        this.A04 = 0;
        this.A0d.reset();
        this.A0e.A06();
        A05();
        for (int i = 0; i < i; i++) {
            this.A0c.valueAt(i).A08();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        return new By().A01(interfaceC0839Bb);
    }
}
