package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.extractor.ts.TsPayloadReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class W6 implements InterfaceC0865Co {
    public static String[] A05 = {"ZoOhGYHP8SNfCMTpI8hB8esJvCxQNk4a", "iCY0vtQk2BMTn8YKksXnllwhxYcEMWPa", "FRJmrfeKqiG8dvU06WzW6", "wyGcQq4l", "", "l2", "ODNaIWitniiqKmZchEPotBtPtmPon6SS", "r1S7VBlY5d2QYAsiLWImTDUS2fBhu4wR"};
    public final int A00;
    public final /* synthetic */ W5 A04;
    public final C0979Hg A03 = new C0979Hg(new byte[5]);
    public final SparseArray<InterfaceC0871Cv> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A4O(C0980Hh c0980Hh) {
        C0992Ht c0992Ht;
        InterfaceC0871Cv interfaceC0871CvA4f;
        if (c0980Hh.A0E() != 2) {
            return;
        }
        if (this.A04.A05 == 1 || this.A04.A05 == 2 || this.A04.A01 == 1) {
            c0992Ht = (C0992Ht) this.A04.A0B.get(0);
        } else {
            c0992Ht = new C0992Ht(((C0992Ht) this.A04.A0B.get(0)).A03());
            this.A04.A0B.add(c0992Ht);
        }
        c0980Hh.A0Z(2);
        int iA0I = c0980Hh.A0I();
        int i = 5;
        c0980Hh.A0Z(5);
        c0980Hh.A0a(this.A03, 2);
        int i2 = 4;
        this.A03.A08(4);
        int i3 = 12;
        c0980Hh.A0Z(this.A03.A04(12));
        int i4 = 21;
        if (this.A04.A05 == 2 && this.A04.A03 == null) {
            C0868Cs c0868Cs = new C0868Cs(21, null, null, new byte[0]);
            W5 w5 = this.A04;
            w5.A03 = w5.A09.A4f(21, c0868Cs);
            this.A04.A03.A8g(c0992Ht, this.A04.A02, new C0870Cu(iA0I, 21, 8192));
        }
        this.A01.clear();
        this.A02.clear();
        int iA04 = c0980Hh.A04();
        while (iA04 > 0) {
            c0980Hh.A0a(this.A03, i);
            int iA05 = this.A03.A04(8);
            this.A03.A08(3);
            int iA06 = this.A03.A04(13);
            this.A03.A08(i2);
            int iA07 = this.A03.A04(i3);
            C0868Cs c0868CsA00 = A00(c0980Hh, iA07);
            if (iA05 == 6) {
                iA05 = c0868CsA00.A00;
            }
            iA04 -= iA07 + 5;
            int i5 = this.A04.A05 == 2 ? iA05 : iA06;
            if (!this.A04.A07.get(i5)) {
                if (this.A04.A05 == 2 && iA05 == i4) {
                    W5 w6 = this.A04;
                    String[] strArr = A05;
                    if (strArr[2].length() == strArr[3].length()) {
                        throw new RuntimeException();
                    }
                    A05[0] = "McoDKrxcl9g055s4tJZatQwjzcY0TxoH";
                    interfaceC0871CvA4f = w6.A03;
                } else {
                    interfaceC0871CvA4f = this.A04.A09.A4f(iA05, c0868CsA00);
                }
                if (this.A04.A05 != 2 || iA06 < this.A02.get(i5, 8192)) {
                    this.A02.put(i5, iA06);
                    this.A01.put(i5, interfaceC0871CvA4f);
                }
            }
            i = 5;
            i2 = 4;
            i3 = 12;
            i4 = 21;
        }
        int size = this.A02.size();
        for (int i6 = 0; i6 < size; i6++) {
            int iKeyAt = this.A02.keyAt(i6);
            this.A04.A07.put(iKeyAt, true);
            InterfaceC0871Cv interfaceC0871CvValueAt = this.A01.valueAt(i6);
            if (interfaceC0871CvValueAt != null) {
                W5 w7 = this.A04;
                String[] strArr2 = A05;
                if (strArr2[5].length() == strArr2[4].length()) {
                    throw new RuntimeException();
                }
                A05[0] = "prZScD3eoAfWT6wNb9RUJeZXyBQ1ma5M";
                if (interfaceC0871CvValueAt != w7.A03) {
                    interfaceC0871CvValueAt.A8g(c0992Ht, this.A04.A02, new C0870Cu(iA0I, iKeyAt, 8192));
                }
                this.A04.A06.put(this.A02.valueAt(i6), interfaceC0871CvValueAt);
            }
        }
        if (this.A04.A05 == 2) {
            if (this.A04.A04) {
                return;
            }
            this.A04.A02.A5T();
            this.A04.A01 = 0;
            this.A04.A04 = true;
            return;
        }
        this.A04.A06.remove(this.A00);
        W5 w8 = this.A04;
        w8.A01 = w8.A05 != 1 ? this.A04.A01 - 1 : 0;
        if (this.A04.A01 == 0) {
            this.A04.A02.A5T();
            this.A04.A04 = true;
        }
    }

    public W6(W5 w5, int i) {
        this.A04 = w5;
        this.A00 = i;
    }

    private C0868Cs A00(C0980Hh c0980Hh, int i) {
        int iA06 = c0980Hh.A06();
        int i2 = iA06 + i;
        int descriptorLength = -1;
        String strTrim = null;
        List<TsPayloadReader.DvbSubtitleInfo> dvbSubtitleInfos = null;
        while (c0980Hh.A06() < i2) {
            int descriptorsStartPosition = c0980Hh.A0E();
            int iA07 = c0980Hh.A06() + c0980Hh.A0E();
            if (descriptorsStartPosition == 5) {
                long jA0M = c0980Hh.A0M();
                if (jA0M != W5.A0F) {
                    long j = W5.A0G;
                    if (A05[0].charAt(13) == 108) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[5] = "OX";
                    strArr[4] = "";
                    if (jA0M == j) {
                        descriptorLength = 135;
                    } else if (jA0M == W5.A0H) {
                        descriptorLength = 36;
                    }
                } else {
                    descriptorLength = 129;
                }
            } else if (descriptorsStartPosition == 106) {
                descriptorLength = 129;
            } else if (descriptorsStartPosition == 122) {
                descriptorLength = 135;
            } else if (descriptorsStartPosition == 123) {
                descriptorLength = 138;
            } else if (descriptorsStartPosition == 10) {
                strTrim = c0980Hh.A0S(3).trim();
            } else if (descriptorsStartPosition == 89) {
                descriptorLength = 89;
                dvbSubtitleInfos = new ArrayList<>();
                while (c0980Hh.A06() < iA07) {
                    String language = c0980Hh.A0S(3).trim();
                    int streamType = c0980Hh.A0E();
                    byte[] bArr = new byte[4];
                    c0980Hh.A0c(bArr, 0, 4);
                    dvbSubtitleInfos.add(new C0867Cr(language, streamType, bArr));
                }
            }
            c0980Hh.A0Z(iA07 - c0980Hh.A06());
        }
        c0980Hh.A0Y(i2);
        return new C0868Cs(descriptorLength, strTrim, dvbSubtitleInfos, Arrays.copyOfRange(c0980Hh.A00, iA06, i2));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0865Co
    public final void A8g(C0992Ht c0992Ht, InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
    }
}
