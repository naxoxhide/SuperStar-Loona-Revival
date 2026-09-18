package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0880Dj implements Handler.Callback, InterfaceC1338Vh, GQ, EX, C9H, InterfaceC08019o {
    public static byte[] A0V;
    public static String[] A0W = {"TSIQGmaqgvrUxo0yYDewkVNDuuioOpPV", "LhstooR1wZsH8RVMZSyyF7FJZ5wrHutR", "WZmkRBn8iXpnqDBIN644YOqcruHieEQJ", "OBm1ApV8rqkCiyt7FxArHXpNA0", "RSLtmQKc5IgtmDXEpea3qKBmF", "cT5hSyxhu4oYAFMn61C1ja3cHbuAf9wl", "QQz6Qig88n9IGtqyO", "pBG4ezF2k8D44jdvacVEPM0q7VNUtk0G"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public C9T A04;
    public C07919e A05;
    public EY A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public XS[] A0C;
    public final long A0D;
    public final Handler A0E;
    public final HandlerThread A0F;
    public final XV A0G;
    public final XT A0H;
    public final C9Z A0J;
    public final C08099x A0L;
    public final C08109y A0M;
    public final GR A0N;
    public final GS A0O;
    public final HL A0P;
    public final HV A0Q;
    public final ArrayList<C9R> A0R;
    public final boolean A0S;
    public final XS[] A0T;
    public final InterfaceC08059s[] A0U;
    public final C07899c A0K = new C07899c();
    public C08089v A06 = C08089v.A03;
    public final C9S A0I = new C9S();

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0V, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 42);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A07() throws C9K, IOException {
        long jAG7 = this.A0P.AG7();
        A0I();
        if (!this.A0K.A0P()) {
            A0B();
            A0R(jAG7, 10L);
            return;
        }
        C07879a c07879aA0G = this.A0K.A0G();
        C0993Hu.A02(A06(150, 10, 20));
        A0J();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        c07879aA0G.A08.A55(this.A05.A0A - this.A0D, this.A0S);
        boolean z = true;
        boolean z2 = true;
        for (XS xs : this.A0C) {
            xs.AEb(this.A03, jElapsedRealtime);
            boolean z3 = true;
            z = z && xs.A8q();
            boolean z4 = xs.A90() || xs.A8q() || A0s(xs);
            if (!z4) {
                xs.AA5();
            }
            if (!z2 || !z4) {
                z3 = false;
            }
            z2 = z3;
        }
        if (!z2) {
            A0B();
        }
        long j = c07879aA0G.A02.A01;
        if (z && ((j == -9223372036854775807L || j <= this.A05.A0A) && c07879aA0G.A02.A05)) {
            A0N(4);
            A0H();
        } else if (this.A05.A00 == 2 && A0u(z2)) {
            A0N(3);
            if (this.A08) {
                A0G();
            }
        } else if (this.A05.A00 == 3) {
            int length = this.A0C.length;
            String[] strArr = A0W;
            if (strArr[4].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[4] = "Eggx5Ft4Lgnx6HVrotcHBkscR";
            strArr2[3] = "Urp4oA4mdP1paz0o5Y10JqXrCe";
            if (length != 0 ? !z2 : !A0q()) {
                this.A09 = this.A08;
                A0N(2);
                A0H();
            }
        }
        if (this.A05.A00 == 2) {
            for (XS xs2 : this.A0C) {
                xs2.AA5();
            }
        }
        boolean z5 = this.A08;
        if (A0W[7].charAt(9) != '8') {
            throw new RuntimeException();
        }
        A0W[5] = "rTELFOhgZqImPwKgVJI0nXuoysvpkaxO";
        if ((z5 && this.A05.A00 == 3) || this.A05.A00 == 2) {
            A0R(jAG7, 10L);
        } else if (this.A0C.length == 0 || this.A05.A00 == 4) {
            this.A0Q.AEY(2);
        } else {
            A0R(jAG7, 1000L);
        }
        C0993Hu.A00();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0064  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x0106  */
    /* JADX WARN: Code duplicated, block: B:47:0x0111  */
    /* JADX WARN: Code duplicated, block: B:48:0x0113  */
    /* JADX WARN: Code duplicated, block: B:55:0x0133  */
    /* JADX WARN: Code duplicated, block: B:57:0x013c  */
    /* JADX WARN: Code duplicated, block: B:76:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0E() throws C9K {
        C07879a c07879aA0G;
        boolean[] zArr;
        long jA0B;
        int i;
        boolean[] zArr2;
        int i2;
        XS[] xsArr;
        XS xs;
        boolean z;
        InterfaceC0916Et interfaceC0916Et;
        long j;
        if (this.A0K.A0P()) {
            float f = this.A0G.A7Z().A01;
            C07879a c07879aA0H = this.A0K.A0H();
            if (A0W[6].length() == 17) {
                String[] strArr = A0W;
                strArr[1] = "D9etX6yGBrwjRzOUEpEFU5ER5XUfrbIh";
                strArr[0] = "v3YP09X53VrDeZJkDNiGeietvmwAimn0";
                boolean z2 = true;
                for (C07879a c07879aA0G2 = this.A0K.A0G(); c07879aA0G2 != null && c07879aA0G2.A06; c07879aA0G2 = c07879aA0G2.A01) {
                    if (c07879aA0G2.A0I(f)) {
                        if (A0W[2].charAt(12) != 'N') {
                            A0W[2] = "qdzsaLeT6GVLLZLLIHWPE1kBVsafqqMr";
                            if (z2) {
                                c07879aA0G = this.A0K.A0G();
                                boolean zA0S = this.A0K.A0S(c07879aA0G);
                                zArr = new boolean[this.A0T.length];
                                jA0B = c07879aA0G.A0B(this.A05.A0A, zA0S, zArr);
                                A0i(c07879aA0G.A03, c07879aA0G.A04);
                                if (this.A05.A00 != 4 && jA0B != this.A05.A0A) {
                                    C07919e c07919e = this.A05;
                                    this.A05 = c07919e.A04(c07919e.A04, jA0B, this.A05.A01);
                                    this.A0I.A04(4);
                                    A0P(jA0B);
                                }
                                i = 0;
                                if (A0W[2].charAt(12) != 'N') {
                                    String[] strArr2 = A0W;
                                    strArr2[1] = "v6rigB8My08mC5ZvZtTcxONYTtnHkhiY";
                                    strArr2[0] = "jJJ7EyTzSHhVUQBMBNjuu6IlWzfsi9o6";
                                    zArr2 = new boolean[this.A0T.length];
                                    i2 = 0;
                                } else {
                                    A0W[7] = "5RhHFxqKf8KludlSzI9zDK8m295dvAFV";
                                    zArr2 = new boolean[this.A0T.length];
                                    i2 = 0;
                                }
                                while (true) {
                                    xsArr = this.A0T;
                                    if (i2 < xsArr.length) {
                                        this.A05 = this.A05.A05(c07879aA0G.A03, c07879aA0G.A04);
                                        A0p(zArr2, i);
                                        break;
                                    }
                                    xs = xsArr[i2];
                                    if (xs.A7t() != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zArr2[i2] = z;
                                    interfaceC0916Et = c07879aA0G.A0A[i2];
                                    if (interfaceC0916Et != null) {
                                        i++;
                                    }
                                    if (!zArr2[i2]) {
                                        if (interfaceC0916Et != xs.A7w()) {
                                            A0b(xs);
                                        } else if (zArr[i2]) {
                                            j = this.A03;
                                            if (A0W[5].charAt(1) != 'w') {
                                                throw new RuntimeException();
                                            }
                                            A0W[7] = "kUW5tsmcM8CZIAjkj84TOGdyZAx2gWc6";
                                            xs.AEn(j);
                                        } else {
                                            continue;
                                        }
                                    }
                                    i2++;
                                }
                            } else {
                                this.A0K.A0S(c07879aA0G2);
                                if (c07879aA0G2.A06) {
                                    c07879aA0G2.A0A(Math.max(c07879aA0G2.A02.A03, c07879aA0G2.A08(this.A03)), false);
                                    A0i(c07879aA0G2.A03, c07879aA0G2.A04);
                                }
                            }
                        } else {
                            A0W[5] = "7WrBcNkU6uNk4nx5t1RXmqyIgKSjjx3l";
                            if (z2) {
                                c07879aA0G = this.A0K.A0G();
                                boolean zA0S2 = this.A0K.A0S(c07879aA0G);
                                zArr = new boolean[this.A0T.length];
                                jA0B = c07879aA0G.A0B(this.A05.A0A, zA0S2, zArr);
                                A0i(c07879aA0G.A03, c07879aA0G.A04);
                                if (this.A05.A00 != 4) {
                                    C07919e c07919e2 = this.A05;
                                    this.A05 = c07919e2.A04(c07919e2.A04, jA0B, this.A05.A01);
                                    this.A0I.A04(4);
                                    A0P(jA0B);
                                }
                                i = 0;
                                if (A0W[2].charAt(12) != 'N') {
                                    String[] strArr3 = A0W;
                                    strArr3[1] = "v6rigB8My08mC5ZvZtTcxONYTtnHkhiY";
                                    strArr3[0] = "jJJ7EyTzSHhVUQBMBNjuu6IlWzfsi9o6";
                                    zArr2 = new boolean[this.A0T.length];
                                    i2 = 0;
                                } else {
                                    A0W[7] = "5RhHFxqKf8KludlSzI9zDK8m295dvAFV";
                                    zArr2 = new boolean[this.A0T.length];
                                    i2 = 0;
                                }
                                while (true) {
                                    xsArr = this.A0T;
                                    if (i2 < xsArr.length) {
                                        this.A05 = this.A05.A05(c07879aA0G.A03, c07879aA0G.A04);
                                        A0p(zArr2, i);
                                        break;
                                    }
                                    xs = xsArr[i2];
                                    if (xs.A7t() != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zArr2[i2] = z;
                                    interfaceC0916Et = c07879aA0G.A0A[i2];
                                    if (interfaceC0916Et != null) {
                                        i++;
                                    }
                                    if (!zArr2[i2]) {
                                        if (interfaceC0916Et != xs.A7w()) {
                                            A0b(xs);
                                        } else if (zArr[i2]) {
                                            j = this.A03;
                                            if (A0W[5].charAt(1) != 'w') {
                                                throw new RuntimeException();
                                            }
                                            A0W[7] = "kUW5tsmcM8CZIAjkj84TOGdyZAx2gWc6";
                                            xs.AEn(j);
                                        } else {
                                            continue;
                                        }
                                    }
                                    i2++;
                                }
                            } else {
                                this.A0K.A0S(c07879aA0G2);
                                if (c07879aA0G2.A06) {
                                    c07879aA0G2.A0A(Math.max(c07879aA0G2.A02.A03, c07879aA0G2.A08(this.A03)), false);
                                    A0i(c07879aA0G2.A03, c07879aA0G2.A04);
                                }
                            }
                        }
                        int i3 = this.A05.A00;
                        if (A0W[6].length() == 17) {
                            String[] strArr4 = A0W;
                            strArr4[4] = "GCKjwcvTJfMpQgG8NpKVbaI1H";
                            strArr4[3] = "kOcbaoLdOMGBVdRezVYeBIh2yM";
                            if (i3 == 4) {
                                return;
                            }
                            A09();
                            A0J();
                            HV hv = this.A0Q;
                            if (A0W[6].length() == 17) {
                                A0W[5] = "0v8QL5oJXgBRdj6LoWxDDzyaCLbuPlQC";
                                hv.AF2(2);
                                return;
                            }
                        }
                    } else {
                        if (c07879aA0G2 == c07879aA0H) {
                            z2 = false;
                        }
                    }
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cb  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0I() throws C9K, IOException {
        int i;
        C0880Dj c0880Dj = this;
        EY ey = c0880Dj.A07;
        if (ey == null) {
            return;
        }
        if (c0880Dj.A01 > 0) {
            ey.AA4();
            return;
        }
        A0C();
        C07879a c07879aA0F = c0880Dj.A0K.A0F();
        if (c07879aA0F == null || c07879aA0F.A0H()) {
            c0880Dj.A0k(false);
        } else if (!c0880Dj.A05.A08) {
            A09();
        }
        if (!c0880Dj.A0K.A0P()) {
            return;
        }
        C07879a c07879aA0G = c0880Dj.A0K.A0G();
        C07879a c07879aA0H = c0880Dj.A0K.A0H();
        boolean z = false;
        while (true) {
            boolean z2 = c0880Dj.A08;
            if (A0W[6].length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[4] = "7VXwhx8w334qXwwhe6EPuoxrs";
            strArr[3] = "i8G0S3EG91lb4Tbi5TJ2bFfoM2";
            if (z2 && c07879aA0G != c07879aA0H && c0880Dj.A03 >= c07879aA0G.A01.A00) {
                if (z) {
                    A0A();
                }
                boolean z3 = c07879aA0G.A02.A06;
                String[] strArr2 = A0W;
                if (strArr2[1].charAt(10) != strArr2[0].charAt(10)) {
                    A0W[7] = "JHuaS3X828K0z1yeMtavkm7JkVnfol1Z";
                    if (z3) {
                        i = 0;
                    } else {
                        i = 3;
                    }
                } else {
                    A0W[5] = "wtrsjVL1JaCAi24uhunV07R35PJNTCvI";
                    if (z3) {
                        i = 0;
                    } else {
                        i = 3;
                    }
                }
                C07879a c07879a = c07879aA0G;
                c07879aA0G = c0880Dj.A0K.A0C();
                c0880Dj.A0V(c07879a);
                c0880Dj.A05 = c0880Dj.A05.A04(c07879aA0G.A02.A04, c07879aA0G.A02.A03, c07879aA0G.A02.A00);
                c0880Dj.A0I.A04(i);
                A0J();
                z = true;
            } else if (c07879aA0H.A02.A05) {
                int i2 = 0;
                while (true) {
                    XS[] xsArr = c0880Dj.A0T;
                    if (i2 >= xsArr.length) {
                        return;
                    }
                    XS xs = xsArr[i2];
                    InterfaceC0916Et interfaceC0916Et = c07879aA0H.A0A[i2];
                    if (interfaceC0916Et != null && xs.A7w() == interfaceC0916Et && xs.A8Q()) {
                        xs.AFE();
                    }
                    i2++;
                }
            } else {
                if (c07879aA0H.A01 == null || !c07879aA0H.A01.A06) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    XS[] xsArr2 = c0880Dj.A0T;
                    if (i3 < xsArr2.length) {
                        XS xs2 = xsArr2[i3];
                        InterfaceC0916Et interfaceC0916Et2 = c07879aA0H.A0A[i3];
                        InterfaceC0916Et interfaceC0916EtA7w = xs2.A7w();
                        String[] strArr3 = A0W;
                        if (strArr3[1].charAt(10) != strArr3[0].charAt(10)) {
                            A0W[2] = "GzZd6F7lJVp08TeGQitpN19OrvCnG4PK";
                            if (interfaceC0916EtA7w != interfaceC0916Et2) {
                                return;
                            }
                        } else {
                            A0W[5] = "G5Kl7lcZBM87T4fNUwO1IYVdGnNcsgpo";
                            if (interfaceC0916EtA7w != interfaceC0916Et2) {
                                return;
                            }
                        }
                        if (interfaceC0916Et2 != null && !xs2.A8Q()) {
                            return;
                        } else {
                            i3++;
                        }
                    } else {
                        GS gs = c07879aA0H.A04;
                        C07879a c07879aA0D = c0880Dj.A0K.A0D();
                        GS gs2 = c07879aA0D.A04;
                        boolean z4 = c07879aA0D.A08.AED() != -9223372036854775807L;
                        int i4 = 0;
                        while (true) {
                            XS[] xsArr3 = c0880Dj.A0T;
                            String[] strArr4 = A0W;
                            if (strArr4[1].charAt(10) != strArr4[0].charAt(10)) {
                                A0W[5] = "zgqvIFw9hHXttypZtkJx3efsgqUZ32NO";
                                if (i4 >= xsArr3.length) {
                                    return;
                                }
                            } else if (i4 >= xsArr3.length) {
                                return;
                            }
                            XS xs3 = xsArr3[i4];
                            if (gs.A00(i4)) {
                                if (z4) {
                                    xs3.AFE();
                                } else if (!xs3.A8n()) {
                                    GO goA00 = gs2.A01.A00(i4);
                                    boolean zA00 = gs2.A00(i4);
                                    boolean z5 = c0880Dj.A0U[i4].A83() == 5;
                                    C08069t c08069t = gs.A03[i4];
                                    C08069t c08069t2 = gs2.A03[i4];
                                    if (zA00 && c08069t2.equals(c08069t) && !z5) {
                                        xs3.AEd(A0v(goA00), c07879aA0D.A0A[i4], c07879aA0D.A07());
                                    } else {
                                        xs3.AFE();
                                    }
                                }
                            }
                            i4++;
                            c0880Dj = this;
                        }
                    }
                }
            }
        }
    }

    public static void A0K() {
        byte[] bArr = {68, 121, 110, 81, 109, 96, 120, 100, 115, 72, 108, 113, 109, 72, 111, 117, 100, 115, 111, 96, 109, 111, 82, 69, 122, 70, 75, 83, 79, 88, 99, 71, 90, 70, 99, 68, 94, 79, 88, 68, 75, 70, 16, 98, 75, 68, 78, 70, 79, 88, 66, 108, 101, 100, 121, 98, 101, 108, 43, 102, 110, 120, 120, 106, 108, 110, 120, 43, 120, 110, 101, 127, 43, 106, 109, 127, 110, 121, 43, 121, 110, 103, 110, 106, 120, 110, 37, 69, 98, 120, 105, 126, 98, 109, 96, 44, 126, 121, 98, 120, 101, 97, 105, 44, 105, 126, 126, 99, 126, 34, 24, 36, 41, 49, 42, 41, 43, 35, 104, 45, 58, 58, 39, 58, 102, 74, 118, 108, 107, 122, 124, 57, 124, 107, 107, 118, 107, 55, 72, 111, 116, 107, 59, 125, 122, 114, 119, 126, 127, 53, 90, 81, 109, 81, 83, 91, 105, 81, 76, 85};
        String[] strArr = A0W;
        if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
            throw new RuntimeException();
        }
        A0W[7] = "OuUcfGxYs8HKuxzYIQS3N8YCcqwYwO9D";
        A0V = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:656)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0S(C9Q c9q) throws C9K {
        if (c9q.A01 != this.A07) {
            return;
        }
        AbstractC08119z abstractC08119z = this.A05.A03;
        AbstractC08119z abstractC08119z2 = c9q.A00;
        Object obj = c9q.A02;
        this.A0K.A0N(abstractC08119z2);
        this.A05 = this.A05.A03(abstractC08119z2, obj);
        A0F();
        int i = this.A01;
        if (i > 0) {
            this.A0I.A03(i);
            this.A01 = 0;
            C9T c9t = this.A04;
            if (c9t != null) {
                Pair<Integer, Long> pairA04 = A04(c9t, true);
                this.A04 = null;
                if (pairA04 == null) {
                    A08();
                    return;
                }
                int iIntValue = ((Integer) pairA04.first).intValue();
                long jLongValue = ((Long) pairA04.second).longValue();
                EW ewA0L = this.A0K.A0L(iIntValue, jLongValue);
                this.A05 = this.A05.A04(ewA0L, ewA0L.A01() ? 0L : jLongValue, jLongValue);
                return;
            }
            if (this.A05.A02 == -9223372036854775807L) {
                if (abstractC08119z2.A0E()) {
                    A08();
                    return;
                }
                Pair<Integer, Long> pairA05 = A05(abstractC08119z2, abstractC08119z2.A05(this.A0B), -9223372036854775807L);
                int iIntValue2 = ((Integer) pairA05.first).intValue();
                long jLongValue2 = ((Long) pairA05.second).longValue();
                EW ewA0L2 = this.A0K.A0L(iIntValue2, jLongValue2);
                this.A05 = this.A05.A04(ewA0L2, ewA0L2.A01() ? 0L : jLongValue2, jLongValue2);
                return;
            }
            return;
        }
        int i2 = this.A05.A04.A02;
        long j = this.A05.A01;
        if (abstractC08119z.A0E()) {
            if (abstractC08119z2.A0E()) {
                return;
            }
            EW ewA0L3 = this.A0K.A0L(i2, j);
            this.A05 = this.A05.A04(ewA0L3, ewA0L3.A01() ? 0L : j, j);
            return;
        }
        C07879a c07879aA0E = this.A0K.A0E();
        int iA04 = abstractC08119z2.A04(c07879aA0E == null ? abstractC08119z.A0A(i2, this.A0L, true).A03 : c07879aA0E.A09);
        if (iA04 != -1) {
            if (iA04 != i2) {
                this.A05 = this.A05.A01(iA04);
            }
            EW ew = this.A05.A04;
            if (ew.A01()) {
                EW ewA0L4 = this.A0K.A0L(iA04, j);
                if (!ewA0L4.equals(ew)) {
                    this.A05 = this.A05.A04(ewA0L4, A02(ewA0L4, ewA0L4.A01() ? 0L : j), j);
                    return;
                }
            }
            if (this.A0K.A0U(ew, this.A03)) {
                return;
            }
            A0j(false);
            return;
        }
        int iA01 = A01(i2, abstractC08119z, abstractC08119z2);
        if (A0W[2].charAt(12) == 'N') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[4] = "W6zkXP9eIZkyJx4uPbHf9NTX6";
        strArr[3] = "m3yrwIeXeqUIkhQgLJp1WNCsrl";
        if (iA01 == -1) {
            A08();
            return;
        }
        Pair<Integer, Long> pairA06 = A05(abstractC08119z2, abstractC08119z2.A09(iA01, this.A0L).A00, -9223372036854775807L);
        int iIntValue3 = ((Integer) pairA06.first).intValue();
        long jLongValue3 = ((Long) pairA06.second).longValue();
        EW ewA0L5 = this.A0K.A0L(iIntValue3, jLongValue3);
        abstractC08119z2.A0A(iIntValue3, this.A0L, true);
        if (c07879aA0E != null) {
            Object obj2 = this.A0L.A03;
            c07879aA0E.A02 = c07879aA0E.A02.A00(-1);
            while (c07879aA0E.A01 != null) {
                c07879aA0E = c07879aA0E.A01;
                if (c07879aA0E.A09.equals(obj2)) {
                    C07899c c07899c = this.A0K;
                    C07889b c07889b = c07879aA0E.A02;
                    if (A0W[2].charAt(12) == 'N') {
                        throw new RuntimeException();
                    }
                    A0W[5] = "ODoCru5Men7rnsumvsVlRJsOWyiHNrdt";
                    c07879aA0E.A02 = c07899c.A0J(c07889b, iIntValue3);
                } else {
                    c07879aA0E.A02 = c07879aA0E.A02.A00(-1);
                }
            }
        }
        boolean zA01 = ewA0L5.A01();
        if (A0W[6].length() != 17) {
            throw new RuntimeException();
        }
        A0W[7] = "hRbRvIJE18IQkSZp4h0fxN12mLMfZDhd";
        this.A05 = this.A05.A04(ewA0L5, A02(ewA0L5, zA01 ? 0L : jLongValue3), jLongValue3);
    }

    static {
        A0K();
    }

    public C0880Dj(XS[] xsArr, GR gr, GS gs, C9Z c9z, boolean z, int i, boolean z2, Handler handler, XT xt, HL hl) {
        this.A0T = xsArr;
        this.A0N = gr;
        this.A0O = gs;
        this.A0J = c9z;
        this.A08 = z;
        this.A02 = i;
        this.A0B = z2;
        this.A0E = handler;
        this.A0H = xt;
        this.A0P = hl;
        this.A0D = c9z.A60();
        this.A0S = c9z.AEo();
        this.A05 = new C07919e(AbstractC08119z.A01, -9223372036854775807L, TrackGroupArray.A04, gs);
        this.A0U = new InterfaceC08059s[xsArr.length];
        for (int i2 = 0; i2 < xsArr.length; i2++) {
            xsArr[i2].AFH(i2);
            this.A0U[i2] = xsArr[i2].A6D();
        }
        this.A0G = new XV(this, hl);
        this.A0R = new ArrayList<>();
        this.A0C = new XS[0];
        this.A0M = new C08109y();
        this.A0L = new C08099x();
        gr.A00(this);
        HandlerThread handlerThread = new HandlerThread(A06(21, 29, 0), -16);
        this.A0F = handlerThread;
        handlerThread.start();
        this.A0Q = hl.A4Z(handlerThread.getLooper(), this);
    }

    private int A00() {
        AbstractC08119z abstractC08119z = this.A05.A03;
        if (abstractC08119z.A0E()) {
            return 0;
        }
        return abstractC08119z.A0B(abstractC08119z.A05(this.A0B), this.A0M).A00;
    }

    private int A01(int i, AbstractC08119z abstractC08119z, AbstractC08119z abstractC08119z2) {
        int iA03 = i;
        int maxIterations = -1;
        int iA00 = abstractC08119z.A00();
        for (int i2 = 0; i2 < iA00 && maxIterations == -1; i2++) {
            iA03 = abstractC08119z.A03(iA03, this.A0L, this.A0M, this.A02, this.A0B);
            if (iA03 == -1) {
                break;
            }
            maxIterations = abstractC08119z2.A04(abstractC08119z.A0A(iA03, this.A0L, true).A03);
        }
        return maxIterations;
    }

    private long A02(EW ew, long j) throws C9K {
        return A03(ew, j, this.A0K.A0G() != this.A0K.A0H());
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a8  */
    private long A03(EW ew, long j, boolean z) throws C9K {
        InterfaceC1337Vg interfaceC1337Vg;
        long j2;
        boolean z2;
        A0H();
        this.A09 = false;
        A0N(2);
        C07879a c07879aA0G = this.A0K.A0G();
        C07879a newPlayingPeriodHolder = c07879aA0G;
        while (newPlayingPeriodHolder != null) {
            boolean zA0t = A0t(ew, j, newPlayingPeriodHolder);
            String[] strArr = A0W;
            if (strArr[1].charAt(10) != strArr[0].charAt(10)) {
                A0W[7] = "3g90ZjAQy8gphAPE4L2ghHg16cmQ019E";
                if (zA0t) {
                    this.A0K.A0S(newPlayingPeriodHolder);
                    break;
                }
                newPlayingPeriodHolder = this.A0K.A0C();
            }
            throw new RuntimeException();
        }
        if (c07879aA0G != newPlayingPeriodHolder || z) {
            for (XS xs : this.A0C) {
                A0b(xs);
            }
            this.A0C = new XS[0];
            c07879aA0G = null;
        }
        if (newPlayingPeriodHolder != null) {
            A0V(c07879aA0G);
            String[] strArr2 = A0W;
            if (strArr2[1].charAt(10) != strArr2[0].charAt(10)) {
                String[] strArr3 = A0W;
                strArr3[4] = "JYav744H3005gGdd3wHQ67gij";
                strArr3[3] = "FVGbgJ3f5rxs8oy2Mt1O3WpPvx";
                if (newPlayingPeriodHolder.A05) {
                    j = newPlayingPeriodHolder.A08.AF0(j);
                    interfaceC1337Vg = newPlayingPeriodHolder.A08;
                    j2 = j - this.A0D;
                    z2 = this.A0S;
                    if (A0W[7].charAt(9) == '8') {
                        A0W[7] = "LvYFslBjN8wEk55S4mS5Jlrj4VNptxmz";
                        interfaceC1337Vg.A55(j2, z2);
                    }
                    throw new RuntimeException();
                }
            } else if (newPlayingPeriodHolder.A05) {
                j = newPlayingPeriodHolder.A08.AF0(j);
                interfaceC1337Vg = newPlayingPeriodHolder.A08;
                j2 = j - this.A0D;
                z2 = this.A0S;
                if (A0W[7].charAt(9) == '8') {
                    A0W[7] = "LvYFslBjN8wEk55S4mS5Jlrj4VNptxmz";
                    interfaceC1337Vg.A55(j2, z2);
                }
                throw new RuntimeException();
            }
            A0P(j);
            A09();
        } else {
            this.A0K.A0O(true);
            A0P(j);
        }
        this.A0Q.AF2(2);
        if (A0W[2].charAt(12) != 'N') {
            A0W[2] = "qbdkiXSPlbFYutVyIKxCWSr3uDHCS3n2";
            return j;
        }
        throw new RuntimeException();
    }

    private Pair<Integer, Long> A04(C9T c9t, boolean z) {
        int iA01;
        AbstractC08119z abstractC08119z = this.A05.A03;
        AbstractC08119z abstractC08119z2 = c9t.A02;
        if (abstractC08119z.A0E()) {
            return null;
        }
        if (abstractC08119z2.A0E()) {
            abstractC08119z2 = abstractC08119z;
        }
        try {
            Pair<Integer, Long> pairA07 = abstractC08119z2.A07(this.A0M, this.A0L, c9t.A00, c9t.A01);
            if (abstractC08119z == abstractC08119z2) {
                return pairA07;
            }
            int iA04 = abstractC08119z.A04(abstractC08119z2.A0A(((Integer) pairA07.first).intValue(), this.A0L, true).A03);
            if (iA04 != -1) {
                return Pair.create(Integer.valueOf(iA04), (Long) pairA07.second);
            }
            if (!z || (iA01 = A01(((Integer) pairA07.first).intValue(), abstractC08119z2, abstractC08119z)) == -1) {
                return null;
            }
            Pair<Integer, Long> pairA05 = A05(abstractC08119z, abstractC08119z.A09(iA01, this.A0L).A00, -9223372036854775807L);
            String[] strArr = A0W;
            if (strArr[4].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[1] = "LZRu6qU1d7MAJxELkyp6D6bqJ9pCtQWv";
            strArr2[0] = "5OOlDtGsHYXmvjCA2lYHypc4I8JTMes9";
            return pairA05;
        } catch (IndexOutOfBoundsException unused) {
            throw new C9Y(abstractC08119z, c9t.A00, c9t.A01);
        }
    }

    private Pair<Integer, Long> A05(AbstractC08119z abstractC08119z, int i, long j) {
        return abstractC08119z.A07(this.A0M, this.A0L, i, j);
    }

    private void A08() {
        A0N(4);
        A0o(false, true, false);
    }

    private void A09() {
        C07879a c07879aA0F = this.A0K.A0F();
        long nextLoadPositionUs = c07879aA0F.A06();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            A0k(false);
            return;
        }
        boolean zAFX = this.A0J.AFX(nextLoadPositionUs - c07879aA0F.A08(this.A03), this.A0G.A7Z().A01);
        A0k(zAFX);
        if (zAFX) {
            c07879aA0F.A0F(this.A03);
        }
    }

    private void A0A() {
        int i;
        if (this.A0I.A06(this.A05)) {
            Handler handler = this.A0E;
            int i2 = this.A0I.A01;
            if (this.A0I.A03) {
                i = this.A0I.A00;
            } else {
                i = -1;
            }
            handler.obtainMessage(0, i2, i, this.A05).sendToTarget();
            this.A0I.A05(this.A05);
        }
    }

    private void A0B() throws IOException {
        C07879a c07879aA0F = this.A0K.A0F();
        C07879a readingPeriodHolder = this.A0K.A0H();
        if (c07879aA0F != null && !c07879aA0F.A06) {
            if (readingPeriodHolder != null) {
                C07879a loadingPeriodHolder = readingPeriodHolder.A01;
                if (loadingPeriodHolder != c07879aA0F) {
                    return;
                }
            }
            XS[] xsArr = this.A0C;
            if (A0W[2].charAt(12) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[4] = "M2PhxJTgTMxoek0nGdRGZ8ED7";
            strArr[3] = "JhH24KrsERDOvzAX41swXn1Uhz";
            for (XS xs : xsArr) {
                if (!xs.A8Q()) {
                    return;
                }
            }
            c07879aA0F.A08.AA3();
        }
    }

    private void A0C() throws IOException {
        this.A0K.A0M(this.A03);
        if (this.A0K.A0Q()) {
            C07889b c07889bA0I = this.A0K.A0I(this.A03, this.A05);
            if (c07889bA0I == null) {
                this.A07.AA4();
                return;
            }
            InterfaceC1337Vg mediaPeriod = this.A0K.A0K(this.A0U, this.A0N, this.A0J.A5v(), this.A07, this.A05.A03.A0A(c07889bA0I.A04.A02, this.A0L, true).A03, c07889bA0I);
            mediaPeriod.ADu(this, c07889bA0I.A03);
            A0k(true);
        }
    }

    private void A0D() {
        A0o(true, true, true);
        this.A0J.ACg();
        A0N(1);
        this.A0F.quit();
        synchronized (this) {
            this.A0A = true;
            notifyAll();
        }
    }

    private void A0F() {
        for (int size = this.A0R.size() - 1; size >= 0; size--) {
            if (!A0r(this.A0R.get(size))) {
                this.A0R.get(size).A03.A0A(false);
                this.A0R.remove(size);
            }
        }
        Collections.sort(this.A0R);
    }

    private void A0G() throws C9K {
        this.A09 = false;
        this.A0G.A05();
        for (XS xs : this.A0C) {
            xs.start();
        }
    }

    private void A0H() throws C9K {
        this.A0G.A06();
        for (XS xs : this.A0C) {
            A0c(xs);
        }
    }

    private void A0J() throws C9K {
        long jA0C;
        if (!this.A0K.A0P()) {
            return;
        }
        C07879a c07879aA0G = this.A0K.A0G();
        InterfaceC1337Vg interfaceC1337Vg = c07879aA0G.A08;
        if (A0W[6].length() != 17) {
            throw new RuntimeException();
        }
        A0W[7] = "e9etinPRA8BQH2CZknXr4yAbSJ3blA39";
        long jAED = interfaceC1337Vg.AED();
        if (jAED != -9223372036854775807L) {
            A0P(jAED);
            if (jAED != this.A05.A0A) {
                C07919e c07919e = this.A05;
                EW ew = c07919e.A04;
                long periodPositionUs = this.A05.A01;
                this.A05 = c07919e.A04(ew, jAED, periodPositionUs);
                this.A0I.A04(4);
            }
        } else {
            long jA04 = this.A0G.A04();
            this.A03 = jA04;
            long jA08 = c07879aA0G.A08(jA04);
            A0Q(this.A05.A0A, jA08);
            this.A05.A0A = jA08;
        }
        C07919e c07919e2 = this.A05;
        if (this.A0C.length == 0) {
            jA0C = c07879aA0G.A02.A01;
        } else {
            jA0C = c07879aA0G.A0C(true);
        }
        c07919e2.A09 = jA0C;
    }

    private void A0L(float f) {
        for (C07879a c07879aA0E = this.A0K.A0E(); c07879aA0E != null; c07879aA0E = c07879aA0E.A01) {
            GS gs = c07879aA0E.A04;
            if (A0W[7].charAt(9) != '8') {
                throw new RuntimeException();
            }
            A0W[5] = "TmHCYSIZuHNmxK6kBnR58JopztOBcNrn";
            if (gs != null) {
                for (GO go : c07879aA0E.A04.A01.A01()) {
                    if (go != null) {
                        go.ACP(f);
                    }
                }
            }
        }
    }

    private void A0M(int i) throws C9K {
        this.A02 = i;
        if (!this.A0K.A0R(i)) {
            A0j(true);
        }
    }

    private void A0N(int i) {
        if (this.A05.A00 != i) {
            C07919e c07919eA02 = this.A05.A02(i);
            if (A0W[7].charAt(9) != '8') {
                throw new RuntimeException();
            }
            A0W[2] = "kM2qExU4ybhQ7HWfawBquzR2zjX0F4jA";
            this.A05 = c07919eA02;
        }
    }

    private void A0O(int i, boolean playing, int i2) throws C9K {
        C07879a c07879aA0G = this.A0K.A0G();
        XS xs = this.A0T[i];
        this.A0C[i2] = xs;
        if (xs.A7t() == 0) {
            C08069t c08069t = c07879aA0G.A04.A03[i];
            String[] strArr = A0W;
            if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            A0W[2] = "NYdCxyfB4qBB5fQElsuicf6C6huVudSr";
            Format[] formatArrA0v = A0v(c07879aA0G.A04.A01.A00(i));
            boolean z = this.A08 && this.A05.A00 == 3;
            xs.A5Q(c08069t, formatArrA0v, c07879aA0G.A0A[i], this.A03, !playing && z, c07879aA0G.A07());
            this.A0G.A09(xs);
            if (z) {
                xs.start();
            }
        }
    }

    private void A0P(long j) throws C9K {
        if (this.A0K.A0P()) {
            j = this.A0K.A0G().A09(j);
        }
        this.A03 = j;
        this.A0G.A07(j);
        for (XS xs : this.A0C) {
            xs.AEn(this.A03);
        }
    }

    private void A0Q(long j, long j2) throws C9K {
        C9R c9r;
        if (this.A0R.isEmpty() || this.A05.A04.A01()) {
            return;
        }
        if (this.A05.A02 == j) {
            j--;
        }
        C07919e c07919e = this.A05;
        if (A0W[2].charAt(12) == 'N') {
            throw new RuntimeException();
        }
        A0W[2] = "iI9novLuZIFAEfCO4qiE3Y1J9OFTcxg5";
        int i = c07919e.A04.A02;
        int currentPeriodIndex = this.A00;
        C9R c9r2 = currentPeriodIndex > 0 ? this.A0R.get(currentPeriodIndex - 1) : null;
        while (c9r2 != null) {
            if (c9r2.A00 <= i) {
                int i2 = c9r2.A00;
                if (A0W[7].charAt(9) == '8') {
                    A0W[2] = "hDlIvL5rLgyE5VG4VUIth4YrdDyvlxxs";
                    if (i2 != i || c9r2.A01 <= j) {
                        break;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
            int currentPeriodIndex2 = this.A00 - 1;
            this.A00 = currentPeriodIndex2;
            c9r2 = currentPeriodIndex2 > 0 ? this.A0R.get(currentPeriodIndex2 - 1) : null;
        }
        if (this.A00 < this.A0R.size()) {
            c9r = this.A0R.get(this.A00);
        } else {
            c9r = null;
        }
        while (c9r != null && c9r.A02 != null && (c9r.A00 < i || (c9r.A00 == i && c9r.A01 <= j))) {
            int i3 = this.A00 + 1;
            this.A00 = i3;
            if (i3 < this.A0R.size()) {
                c9r = this.A0R.get(this.A00);
            } else {
                c9r = null;
            }
        }
        while (c9r != null && c9r.A02 != null && c9r.A00 == i && c9r.A01 > j && c9r.A01 <= j2) {
            A0Z(c9r.A03);
            if (c9r.A03.A0B() || c9r.A03.A0D()) {
                this.A0R.remove(this.A00);
            } else {
                this.A00++;
            }
            if (this.A00 < this.A0R.size()) {
                ArrayList<C9R> arrayList = this.A0R;
                int i4 = this.A00;
                if (A0W[5].charAt(1) == 'w') {
                    throw new RuntimeException();
                }
                A0W[6] = "2inRqgHKNmW90mXz8";
                c9r = arrayList.get(i4);
            } else {
                c9r = null;
            }
        }
    }

    private void A0R(long j, long j2) {
        this.A0Q.AEY(2);
        this.A0Q.AF3(2, j + j2);
    }

    private void A0T(C9T c9t) throws Throwable {
        long jLongValue;
        EW ewA0L;
        long jLongValue2;
        boolean seekPositionAdjusted;
        this.A0I.A03(1);
        Pair<Integer, Long> resolvedSeekPosition = A04(c9t, true);
        if (resolvedSeekPosition == null) {
            ewA0L = new EW(A00());
            jLongValue2 = -9223372036854775807L;
            jLongValue = -9223372036854775807L;
            seekPositionAdjusted = true;
        } else {
            int iIntValue = ((Integer) resolvedSeekPosition.first).intValue();
            jLongValue = ((Long) resolvedSeekPosition.second).longValue();
            ewA0L = this.A0K.A0L(iIntValue, jLongValue);
            if (ewA0L.A01()) {
                jLongValue2 = 0;
                seekPositionAdjusted = true;
            } else {
                jLongValue2 = ((Long) resolvedSeekPosition.second).longValue();
                seekPositionAdjusted = c9t.A01 == -9223372036854775807L;
            }
        }
        try {
            try {
                if (this.A07 != null && this.A01 <= 0) {
                    if (A0W[5].charAt(1) != 'w') {
                        A0W[5] = "YfoxJXVxtggAgJ3C0qUN5WGXkfVCteCk";
                        try {
                            if (jLongValue2 == -9223372036854775807L) {
                                A0N(4);
                                A0o(false, true, false);
                            } else {
                                long jA5s = jLongValue2;
                                if (ewA0L.equals(this.A05.A04)) {
                                    C07879a c07879aA0G = this.A0K.A0G();
                                    if (c07879aA0G != null && jA5s != 0) {
                                        jA5s = c07879aA0G.A08.A5s(jA5s, this.A06);
                                    }
                                    long contentPositionUs = C9E.A01(jA5s);
                                    if (contentPositionUs == C9E.A01(this.A05.A0A)) {
                                        this.A05 = this.A05.A04(ewA0L, this.A05.A0A, jLongValue);
                                        if (seekPositionAdjusted) {
                                            this.A0I.A04(2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                long jA02 = A02(ewA0L, jA5s);
                                seekPositionAdjusted |= jLongValue2 != jA02;
                                if (A0W[6].length() == 17) {
                                    A0W[7] = "LtwUHLpv08wEzos7LWvR75PA6MqqEvuh";
                                    jLongValue2 = jA02;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            this.A05 = this.A05.A04(ewA0L, jLongValue2, jLongValue);
                            if (seekPositionAdjusted) {
                                this.A0I.A04(2);
                            }
                            throw th;
                        }
                    }
                    throw new RuntimeException();
                }
                this.A04 = c9t;
                this.A05 = this.A05.A04(ewA0L, jLongValue2, jLongValue);
                if (seekPositionAdjusted) {
                    C9S c9s = this.A0I;
                    String[] strArr = A0W;
                    if (strArr[4].length() != strArr[3].length()) {
                        A0W[6] = "NnvGpWmx2ly54VvtA";
                        c9s.A04(2);
                    } else {
                        c9s.A04(2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void A0V(C07879a c07879a) throws C9K {
        C07879a c07879aA0G = this.A0K.A0G();
        if (c07879aA0G == null || c07879a == c07879aA0G) {
            return;
        }
        int i = 0;
        boolean[] zArr = new boolean[this.A0T.length];
        int i2 = 0;
        while (true) {
            XS[] xsArr = this.A0T;
            if (i2 < xsArr.length) {
                XS xs = xsArr[i2];
                zArr[i2] = xs.A7t() != 0;
                if (c07879aA0G.A04.A00(i2)) {
                    i++;
                }
                if (zArr[i2] && (!c07879aA0G.A04.A00(i2) || (xs.A8n() && xs.A7w() == c07879a.A0A[i2]))) {
                    A0b(xs);
                }
                i2++;
            } else {
                this.A05 = this.A05.A05(c07879aA0G.A03, c07879aA0G.A04);
                A0p(zArr, i);
                return;
            }
        }
    }

    private void A0W(C07929f c07929f) {
        this.A0G.AFP(c07929f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0X(C08039q c08039q) throws C9K {
        if (c08039q.A0D()) {
            return;
        }
        try {
            c08039q.A04().A8L(c08039q.A00(), c08039q.A09());
            c08039q.A0A(true);
            String[] strArr = A0W;
            if (strArr[1].charAt(10) == strArr[0].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0W;
            strArr2[4] = "j7cBoz179DrNpy3qD7RptXNd9";
            strArr2[3] = "0iwSWX3dM4PAnuiRq1LulMUFPW";
        } catch (Throwable th) {
            c08039q.A0A(true);
            throw th;
        }
    }

    private void A0Y(C08039q c08039q) throws C9K {
        if (c08039q.A02() == -9223372036854775807L) {
            A0Z(c08039q);
            return;
        }
        if (this.A07 == null || this.A01 > 0) {
            this.A0R.add(new C9R(c08039q));
            return;
        }
        C9R c9r = new C9R(c08039q);
        if (A0r(c9r)) {
            this.A0R.add(c9r);
            Collections.sort(this.A0R);
        } else {
            c08039q.A0A(false);
        }
    }

    private void A0Z(C08039q c08039q) throws C9K {
        if (c08039q.A03().getLooper() == this.A0Q.A7D()) {
            A0X(c08039q);
            C07919e c07919e = this.A05;
            if (A0W[6].length() != 17) {
                throw new RuntimeException();
            }
            A0W[5] = "cBEQE15IFXZqMCE104UHZMDgeC8qTiqN";
            if (c07919e.A00 == 3 || this.A05.A00 == 2) {
                this.A0Q.AF2(2);
                return;
            }
            return;
        }
        this.A0Q.AAH(15, c08039q).sendToTarget();
    }

    private void A0a(final C08039q c08039q) {
        c08039q.A03().post(new Runnable() { // from class: com.facebook.ads.redexgen.X.9P
            public static byte[] A02;

            static {
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 14);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{-60, -9, -18, -49, -21, -32, -8, -28, -15, -56, -20, -17, -21, -56, -19, -13, -28, -15, -19, -32, -21, -52, -27, -36, -17, -25, -36, -38, -21, -36, -37, -105, -36, -23, -23, -26, -23, -105, -37, -36, -29, -32, -19, -36, -23, -32, -27, -34, -105, -28, -36, -22, -22, -40, -34, -36, -105, -26, -27, -105, -36, -17, -21, -36, -23, -27, -40, -29, -105, -21, -33, -23, -36, -40, -37, -91};
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (K0.A02(this)) {
                    return;
                }
                try {
                    try {
                        this.A00.A0X(c08039q);
                    } catch (C9K e) {
                        Log.e(A00(0, 21, 113), A00(21, 55, 105), e);
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    K0.A00(th, this);
                }
            }
        });
    }

    private void A0b(XS xs) throws C9K {
        this.A0G.A08(xs);
        A0c(xs);
        xs.A53();
    }

    private void A0c(XS xs) throws C9K {
        if (xs.A7t() == 2) {
            xs.stop();
        }
    }

    private void A0d(C08089v c08089v) {
        this.A06 = c08089v;
    }

    private void A0e(InterfaceC1337Vg interfaceC1337Vg) {
        if (!this.A0K.A0T(interfaceC1337Vg)) {
            return;
        }
        this.A0K.A0M(this.A03);
        A09();
    }

    private void A0f(InterfaceC1337Vg interfaceC1337Vg) throws C9K {
        if (!this.A0K.A0T(interfaceC1337Vg)) {
            return;
        }
        C07879a c07879aA0F = this.A0K.A0F();
        c07879aA0F.A0E(this.A0G.A7Z().A01);
        A0i(c07879aA0F.A03, c07879aA0F.A04);
        if (!this.A0K.A0P()) {
            C07879a loadingPeriodHolder = this.A0K.A0C();
            A0P(loadingPeriodHolder.A02.A03);
            A0V(null);
        }
        A09();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0917Eu
    /* JADX INFO: renamed from: A0g, reason: merged with bridge method [inline-methods] */
    public final void AAx(InterfaceC1337Vg interfaceC1337Vg) {
        this.A0Q.AAH(10, interfaceC1337Vg).sendToTarget();
    }

    private void A0h(EY ey, boolean z, boolean z2) {
        this.A01++;
        A0o(true, z, z2);
        this.A0J.onPrepared();
        this.A07 = ey;
        A0N(2);
        ey.ADx(this.A0H, true, this);
        this.A0Q.AF2(2);
    }

    private void A0i(TrackGroupArray trackGroupArray, GS gs) {
        this.A0J.ADD(this.A0T, trackGroupArray, gs.A01);
    }

    private void A0j(boolean z) throws C9K {
        EW ew = this.A0K.A0G().A02.A04;
        long jA03 = A03(ew, this.A05.A0A, true);
        if (jA03 != this.A05.A0A) {
            C07919e c07919e = this.A05;
            this.A05 = c07919e.A04(ew, jA03, c07919e.A01);
            if (z) {
                this.A0I.A04(4);
            }
        }
    }

    private void A0k(boolean z) {
        if (this.A05.A08 != z) {
            this.A05 = this.A05.A06(z);
        }
    }

    private void A0l(boolean z) throws C9K {
        this.A09 = false;
        this.A08 = z;
        if (!z) {
            A0H();
            A0J();
        } else if (this.A05.A00 == 3) {
            A0G();
            this.A0Q.AF2(2);
        } else {
            if (this.A05.A00 != 2) {
                return;
            }
            this.A0Q.AF2(2);
        }
    }

    private void A0m(boolean z) throws C9K {
        this.A0B = z;
        if (!this.A0K.A0V(z)) {
            A0j(true);
        }
    }

    private void A0n(boolean z, boolean z2) {
        A0o(true, z, z);
        this.A0I.A03(this.A01 + (z2 ? 1 : 0));
        this.A01 = 0;
        this.A0J.AD4();
        A0N(1);
    }

    private void A0o(boolean z, boolean z2, boolean z3) {
        Object obj;
        long j;
        GS gs;
        EY ey;
        this.A0Q.AEY(2);
        this.A09 = false;
        this.A0G.A06();
        this.A03 = 0L;
        for (XS xs : this.A0C) {
            try {
                A0b(xs);
            } catch (C9K | RuntimeException e) {
                Log.e(A06(0, 21, 43), A06(138, 12, 49), e);
            }
        }
        this.A0C = new XS[0];
        this.A0K.A0O(!z2);
        A0k(false);
        if (z2) {
            this.A04 = null;
        }
        if (z3) {
            this.A0K.A0N(AbstractC08119z.A01);
            Iterator<C9R> it = this.A0R.iterator();
            while (it.hasNext()) {
                it.next().A03.A0A(false);
            }
            this.A0R.clear();
            this.A00 = 0;
        }
        AbstractC08119z abstractC08119z = z3 ? AbstractC08119z.A01 : this.A05.A03;
        if (z3) {
            obj = null;
        } else {
            obj = this.A05.A07;
        }
        EW ew = z2 ? new EW(A00()) : this.A05.A04;
        long j2 = -9223372036854775807L;
        if (z2) {
            j = -9223372036854775807L;
        } else {
            j = this.A05.A0A;
        }
        if (!z2) {
            j2 = this.A05.A01;
        }
        int i = this.A05.A00;
        TrackGroupArray trackGroupArray = z3 ? TrackGroupArray.A04 : this.A05.A05;
        if (z3) {
            gs = this.A0O;
        } else {
            gs = this.A05.A06;
        }
        this.A05 = new C07919e(abstractC08119z, obj, ew, j, j2, i, false, trackGroupArray, gs);
        if (z && (ey = this.A07) != null) {
            ey.AEV(this);
            this.A07 = null;
        }
    }

    private void A0p(boolean[] zArr, int i) throws C9K {
        this.A0C = new XS[i];
        int enabledRendererCount = 0;
        C07879a c07879aA0G = this.A0K.A0G();
        for (int i2 = 0; i2 < enabledRendererCount; i2++) {
            if (c07879aA0G.A04.A00(i2)) {
                A0O(i2, zArr[i2], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A0q() {
        C07879a c07879aA0G = this.A0K.A0G();
        long j = c07879aA0G.A02.A01;
        if (j != -9223372036854775807L) {
            long playingPeriodDurationUs = this.A05.A0A;
            if (playingPeriodDurationUs >= j) {
                C07879a c07879a = c07879aA0G.A01;
                if (A0W[7].charAt(9) != '8') {
                    throw new RuntimeException();
                }
                String[] strArr = A0W;
                strArr[1] = "YaIhV2LltIG4HuclCS5WOO9hjwkCXeMt";
                strArr[0] = "X0pypN8zwLPsNLuJVHuHfetSc0yM8k9B";
                if (c07879a != null) {
                    C07879a playingPeriodHolder = c07879aA0G.A01;
                    if (!playingPeriodHolder.A06) {
                        C07879a playingPeriodHolder2 = c07879aA0G.A01;
                        if (playingPeriodHolder2.A02.A04.A01()) {
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean A0r(C9R c9r) {
        if (c9r.A02 == null) {
            Pair<Integer, Long> pairA04 = A04(new C9T(c9r.A03.A08(), c9r.A03.A01(), C9E.A00(c9r.A03.A02())), false);
            if (pairA04 == null) {
                return false;
            }
            int iIntValue = ((Integer) pairA04.first).intValue();
            long jLongValue = ((Long) pairA04.second).longValue();
            AbstractC08119z abstractC08119z = this.A05.A03;
            Integer num = (Integer) pairA04.first;
            String[] strArr = A0W;
            String str = strArr[1];
            String str2 = strArr[0];
            int iCharAt = str.charAt(10);
            int index = str2.charAt(10);
            if (iCharAt == index) {
                throw new RuntimeException();
            }
            A0W[6] = "Qe4SjxIsSBa3x6HAW";
            c9r.A01(iIntValue, jLongValue, abstractC08119z.A0A(num.intValue(), this.A0L, true).A03);
        } else {
            int iA04 = this.A05.A03.A04(c9r.A02);
            if (iA04 == -1) {
                return false;
            }
            c9r.A00 = iA04;
        }
        return true;
    }

    private boolean A0s(XS xs) {
        C07879a c07879aA0H = this.A0K.A0H();
        C07879a readingPeriodHolder = c07879aA0H.A01;
        if (readingPeriodHolder != null) {
            C07879a readingPeriodHolder2 = c07879aA0H.A01;
            if (readingPeriodHolder2.A06 && xs.A8Q()) {
                return true;
            }
        }
        return false;
    }

    private boolean A0t(EW ew, long j, C07879a c07879a) {
        if (ew.equals(c07879a.A02.A04) && c07879a.A06) {
            this.A05.A03.A09(c07879a.A02.A04.A02, this.A0L);
            int iA04 = this.A0L.A04(j);
            if (iA04 == -1 || this.A0L.A09(iA04) == c07879a.A02.A02) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean A0u(boolean z) {
        if (this.A0C.length == 0) {
            return A0q();
        }
        if (!z) {
            return false;
        }
        if (!this.A05.A08) {
            return true;
        }
        C07879a c07879aA0F = this.A0K.A0F();
        long jA0C = c07879aA0F.A0C(!c07879aA0F.A02.A05);
        return jA0C == Long.MIN_VALUE || this.A0J.AFa(jA0C - c07879aA0F.A08(this.A03), this.A0G.A7Z().A01, this.A09);
    }

    public static Format[] A0v(GO go) {
        int length = go != null ? go.length() : 0;
        Format[] formatArr = new Format[length];
        String[] strArr = A0W;
        String str = strArr[1];
        String str2 = strArr[0];
        int iCharAt = str.charAt(10);
        int length2 = str2.charAt(10);
        if (iCharAt == length2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0W;
        strArr2[4] = "X04sVE4WijYjotgv6w3bASzS6";
        strArr2[3] = "U1jCIvxI6fY8JZE6Ili1DHAvIg";
        for (int i = 0; i < length; i++) {
            formatArr[i] = go.A6z(i);
        }
        return formatArr;
    }

    public final Looper A0w() {
        return this.A0F.getLooper();
    }

    public final synchronized void A0x() {
        if (this.A0A) {
            return;
        }
        this.A0Q.AF2(7);
        boolean z = false;
        while (!wasInterrupted) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final void A0y(AbstractC08119z abstractC08119z, int i, long j) {
        this.A0Q.AAH(3, new C9T(abstractC08119z, i, j)).sendToTarget();
    }

    public final void A0z(EY ey, boolean z, boolean z2) {
        this.A0Q.AAG(0, z ? 1 : 0, z2 ? 1 : 0, ey).sendToTarget();
    }

    public final void A10(boolean z) {
        this.A0Q.AAF(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void A11(boolean z) {
        this.A0Q.AAF(6, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.C9H
    public final void ACO(C07929f c07929f) {
        this.A0E.obtainMessage(1, c07929f).sendToTarget();
        A0L(c07929f.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1338Vh
    public final void ACW(InterfaceC1337Vg interfaceC1337Vg) {
        this.A0Q.AAH(9, interfaceC1337Vg).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.EX
    public final void ACz(EY ey, AbstractC08119z abstractC08119z, Object obj) {
        this.A0Q.AAH(8, new C9Q(ey, abstractC08119z, obj)).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC08019o
    public final synchronized void AF4(C08039q c08039q) {
        if (this.A0A) {
            Log.w(A06(0, 21, 43), A06(50, 37, 33));
            c08039q.A0A(false);
        } else {
            this.A0Q.AAH(14, c08039q).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA06 = A06(0, 21, 43);
        try {
            switch (message.what) {
                case 0:
                    A0h((EY) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    A0l(message.arg1 != 0);
                    break;
                case 2:
                    A07();
                    break;
                case 3:
                    A0T((C9T) message.obj);
                    break;
                case 4:
                    A0W((C07929f) message.obj);
                    break;
                case 5:
                    A0d((C08089v) message.obj);
                    break;
                case 6:
                    A0n(message.arg1 != 0, true);
                    break;
                case 7:
                    A0D();
                    return true;
                case 8:
                    A0S((C9Q) message.obj);
                    break;
                case 9:
                    A0f((InterfaceC1337Vg) message.obj);
                    break;
                case 10:
                    A0e((InterfaceC1337Vg) message.obj);
                    break;
                case 11:
                    A0E();
                    break;
                case 12:
                    A0M(message.arg1);
                    break;
                case 13:
                    A0m(message.arg1 != 0);
                    break;
                case 14:
                    A0Y((C08039q) message.obj);
                    break;
                case 15:
                    A0a((C08039q) message.obj);
                    break;
                default:
                    return false;
            }
            A0A();
        } catch (C9K e) {
            Log.e(strA06, A06(110, 15, 98), e);
            A0n(false, false);
            this.A0E.obtainMessage(2, e).sendToTarget();
            A0A();
        } catch (IOException e2) {
            Log.e(strA06, A06(125, 13, 51), e2);
            A0n(false, false);
            this.A0E.obtainMessage(2, C9K.A00(e2)).sendToTarget();
            A0A();
        } catch (RuntimeException e3) {
            Log.e(strA06, A06(87, 23, 38), e3);
            A0n(false, false);
            this.A0E.obtainMessage(2, C9K.A02(e3)).sendToTarget();
            A0A();
        }
        return true;
    }
}
