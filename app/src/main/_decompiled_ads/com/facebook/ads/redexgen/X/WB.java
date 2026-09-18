package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WB implements InterfaceC0838Ba {
    public static String[] A08 = {"pV6afMZIVEGTOqSkK4PJAxqV3cRTXe0d", "IAHwWl6p9dkO64XBfZ0QYdoG1FARrH3l", "8O8qDLmpQAmlCV9yXa4a4pqjSYQFT4zH", "zdF1gQZIlZar6BQddk1LhfG9pE3e2nBq", "3CFwU8lFm", "v9T9Lg78nTaSAiVLG9Jw7rJGA2UCfL0z", "6lAaLpwrnWkg", "Pzi"};
    public static final InterfaceC0841Bd A09 = new WC();
    public long A00;
    public InterfaceC0840Bc A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final SparseArray<C0864Cn> A05;
    public final C0980Hh A06;
    public final C0992Ht A07;

    public WB() {
        this(new C0992Ht(0L));
    }

    public WB(C0992Ht c0992Ht) {
        this.A07 = c0992Ht;
        this.A06 = new C0980Hh(4096);
        this.A05 = new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void A8e(InterfaceC0840Bc interfaceC0840Bc) {
        this.A01 = interfaceC0840Bc;
        interfaceC0840Bc.AEx(new X0(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final int AE9(InterfaceC0839Bb interfaceC0839Bb, C0843Bh c0843Bh) throws InterruptedException, IOException {
        long j;
        if (!interfaceC0839Bb.ADm(this.A06.A00, 0, 4, true)) {
            return -1;
        }
        this.A06.A0Y(0);
        int iA08 = this.A06.A08();
        if (iA08 == 441) {
            return -1;
        }
        if (iA08 == 442) {
            interfaceC0839Bb.ADl(this.A06.A00, 0, 10);
            this.A06.A0Y(9);
            int nextStartCode = this.A06.A0E();
            interfaceC0839Bb.AFe((nextStartCode & 7) + 14);
            return 0;
        }
        if (iA08 == 443) {
            interfaceC0839Bb.ADl(this.A06.A00, 0, 2);
            this.A06.A0Y(0);
            int nextStartCode2 = this.A06.A0I();
            int i = nextStartCode2 + 6;
            if (A08[7].length() != 22) {
                String[] strArr = A08;
                strArr[5] = "HKquBkRqV5bg6e7zOk5qC1bF2o25gd0c";
                strArr[0] = "faW9VDigV6ilhrF8PW3drZ4wwMfODA0N";
                interfaceC0839Bb.AFe(i);
                return 0;
            }
        } else {
            int nextStartCode3 = iA08 & InputDeviceCompat.SOURCE_ANY;
            if ((nextStartCode3 >> 8) != 1) {
                interfaceC0839Bb.AFe(1);
                return 0;
            }
            int i2 = iA08 & 255;
            C0864Cn c0864Cn = this.A05.get(i2);
            if (!this.A02) {
                if (c0864Cn == null) {
                    InterfaceC0859Cg elementaryStreamReader = null;
                    if (i2 == 189) {
                        elementaryStreamReader = new WQ();
                        this.A03 = true;
                        this.A00 = interfaceC0839Bb.A7a();
                    } else if ((i2 & 224) == 192) {
                        elementaryStreamReader = new WE();
                        this.A03 = true;
                        this.A00 = interfaceC0839Bb.A7a();
                    } else if ((i2 & 240) == 224) {
                        elementaryStreamReader = new WJ();
                        this.A04 = true;
                        this.A00 = interfaceC0839Bb.A7a();
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.A4l(this.A01, new C0870Cu(i2, 256));
                        c0864Cn = new C0864Cn(elementaryStreamReader, this.A07);
                        this.A05.put(i2, c0864Cn);
                    }
                }
                if (this.A03 && this.A04) {
                    j = this.A00 + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                } else {
                    j = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                }
                if (interfaceC0839Bb.A7a() > j) {
                    this.A02 = true;
                    InterfaceC0840Bc interfaceC0840Bc = this.A01;
                    if (A08[6].length() != 7) {
                        A08[4] = "xdmI1xGjCkbROfx6HlMFi8Q1HtnAUXbK";
                        interfaceC0840Bc.A5T();
                    }
                }
            }
            interfaceC0839Bb.ADl(this.A06.A00, 0, 2);
            this.A06.A0Y(0);
            int nextStartCode4 = this.A06.A0I();
            int i3 = nextStartCode4 + 6;
            if (c0864Cn == null) {
                interfaceC0839Bb.AFe(i3);
            } else {
                this.A06.A0W(i3);
                interfaceC0839Bb.readFully(this.A06.A00, 0, i3);
                this.A06.A0Y(6);
                c0864Cn.A03(this.A06);
                C0980Hh c0980Hh = this.A06;
                int nextStartCode5 = c0980Hh.A05();
                c0980Hh.A0X(nextStartCode5);
            }
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final void AEw(long j, long j2) {
        this.A07.A08();
        for (int i = 0; i < i; i++) {
            this.A05.valueAt(i).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0838Ba
    public final boolean AFg(InterfaceC0839Bb interfaceC0839Bb) throws InterruptedException, IOException {
        byte[] bArr = new byte[14];
        interfaceC0839Bb.ADl(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4) {
            return false;
        }
        int i = bArr[8] & 4;
        if (A08[4].length() != 31) {
            A08[6] = "Yb1F33WkxQfWiaSVh137";
            if (i != 4) {
                return false;
            }
            String[] strArr = A08;
            if (strArr[5].charAt(30) == strArr[0].charAt(30)) {
                String[] strArr2 = A08;
                strArr2[2] = "0jRSG84WTzZndWahG37MGXBabYk0DmjV";
                strArr2[3] = "QaZZpRdUVGXpS1N3yC2DPVE3W204sMee";
                if ((bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
                    return false;
                }
                int packStuffingLength = bArr[13] & 7;
                interfaceC0839Bb.A3S(packStuffingLength);
                interfaceC0839Bb.ADl(bArr, 0, 3);
                int packStuffingLength2 = bArr[0];
                int i2 = (packStuffingLength2 & 255) << 16;
                int packStuffingLength3 = bArr[1];
                int i3 = i2 | ((packStuffingLength3 & 255) << 8);
                int packStuffingLength4 = bArr[2];
                return 1 == ((packStuffingLength4 & 255) | i3);
            }
        }
        throw new RuntimeException();
    }
}
