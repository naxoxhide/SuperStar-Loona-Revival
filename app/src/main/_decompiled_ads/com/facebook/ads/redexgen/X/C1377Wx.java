package com.facebook.ads.redexgen.X;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1377Wx extends AbstractC0849Bo {
    public static byte[] A03;
    public static String[] A04 = {"NGxGYCc4p5LcUzQMJWyw5DiDSRjOQe9F", "UCFVtk8FFiQwlTHXhlKlMorjx3xQRwUs", "gTYsvz0mqVjOzoMK", "3KonftsBU2Jf7i08alR6FL8DBvSTG56H", "D2cphfoCJeCyY12qt8LourkPjJ4neP20", "nKjfLlw2BnKut4cvipNa", "Z1RdCfwuszFRU44UcECPMtJ2BxVCI0wR", ""};
    public static final int[] A05;
    public int A00;
    public boolean A01;
    public boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[6].charAt(5) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "nNsRewLEUEMjLhcIGLcqJY6DWywwxHcp";
            strArr[3] = "fafmuFk897DEXRggqTinAcDDyPNFBZka";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 126);
            i4++;
        }
    }

    public static void A01() {
        A03 = new byte[]{39, 91, 74, 79, 85, 6, 76, 85, 88, 83, 71, 90, 6, 84, 85, 90, 6, 89, 91, 86, 86, 85, 88, 90, 75, 74, 32, 6, 48, 68, 51, 56, 62, -2, 54, 6, 0, 0, -4, 48, 59, 48, 70, -33, -13, -30, -25, -19, -83, -27, -75, -81, -81, -85, -21, -22, -33, -11, -24, -4, -21, -16, -10, -74, -12, -9, -69, -24, -76, -13, -24, -5, -12, 41, Base64.padSymbol, 44, 49, 55, -9, 53, 56, 45, 47};
    }

    static {
        A01();
        A05 = new int[]{5512, 11025, 22050, 44100};
    }

    public C1377Wx(InterfaceC0848Bm interfaceC0848Bm) {
        super(interfaceC0848Bm);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0849Bo
    public final void A0B(C0980Hh c0980Hh, long j) throws C07909d {
        if (this.A00 == 2) {
            int iA04 = c0980Hh.A04();
            super.A00.AEr(c0980Hh, iA04);
            super.A00.AEs(j, 1, iA04, 0, null);
            return;
        }
        int iA0E = c0980Hh.A0E();
        int packetType = A04[2].length();
        if (packetType != 16) {
            throw new RuntimeException();
        }
        A04[7] = "";
        if (iA0E == 0 && !this.A01) {
            byte[] bArr = new byte[c0980Hh.A04()];
            c0980Hh.A0c(bArr, 0, bArr.length);
            Pair<Integer, Integer> audioParams = HM.A03(bArr);
            super.A00.A5j(Format.A07(null, A00(58, 15, 9), null, -1, -1, ((Integer) audioParams.second).intValue(), ((Integer) audioParams.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            this.A01 = true;
            return;
        }
        int packetType2 = this.A00;
        if (packetType2 == 10 && iA0E != 1) {
            return;
        }
        int iA05 = c0980Hh.A04();
        super.A00.AEr(c0980Hh, iA05);
        super.A00.AEs(j, 1, iA05, 0, null);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bd  */
    @Override // com.facebook.ads.redexgen.X.AbstractC0849Bo
    public final boolean A0C(C0980Hh c0980Hh) throws C1373Wt {
        int pcmEncoding;
        if (!this.A02) {
            int iA0E = c0980Hh.A0E();
            if (A04[2].length() == 16) {
                A04[5] = "dXuDB62giJCeOUzZyzuh";
                int i = (iA0E >> 4) & 15;
                this.A00 = i;
                if (i == 2) {
                    int sampleRateIndex = (iA0E >> 2) & 3;
                    super.A00.A5j(Format.A07(null, A00(73, 10, 74), null, -1, -1, 1, A05[sampleRateIndex], null, null, 0, null));
                    this.A01 = true;
                } else if (i == 7 || i == 8) {
                    String type = i == 7 ? A00(28, 15, 81) : A00(43, 15, 0);
                    int i2 = iA0E & 1;
                    if (A04[1].charAt(9) != '8') {
                        A04[2] = "aabLL8EV5C3yGzSa";
                        if (i2 == 1) {
                            pcmEncoding = 2;
                        } else {
                            pcmEncoding = 3;
                        }
                    } else if (i2 == 1) {
                        pcmEncoding = 2;
                    } else {
                        pcmEncoding = 3;
                    }
                    Format format = Format.A06(null, type, null, -1, -1, 1, 8000, pcmEncoding, null, null, 0, null);
                    super.A00.A5j(format);
                    this.A01 = true;
                } else if (i != 10) {
                    throw new C1373Wt(A00(0, 28, 104) + this.A00);
                }
                this.A02 = true;
                return true;
            }
            throw new RuntimeException();
        }
        if (A04[4].charAt(28) != 'G') {
            A04[1] = "XJizbdJnEvbAe8rCZCbZRYx6n8uD67e5";
            c0980Hh.A0Z(1);
            return true;
        }
        throw new RuntimeException();
    }
}
