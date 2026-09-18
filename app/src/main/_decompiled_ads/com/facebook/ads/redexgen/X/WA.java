package com.facebook.ads.redexgen.X;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WA implements InterfaceC0871Cv {
    public static String[] A06 = {"f3ASEvE0MACuH7PXtcW6SQzpVLuDWBs6", "UAkl7YLcJ73MhJIfOQ7gtBxP58V39hXf", "sKTt9gGYn0qCOxzPnchEZBW", "TIj2tKxLfGdHgu1Q1GnzrxOOh9OPKkUY", "NlS114awdnJt6ePSWIiXVyR", "Ttbg6FQm3oQML", "hnRFaN1D1NI4WPLkXSYbmAvKq8H9o2zk", "6DjXFLFEMVHWeegs6rtlgiLmiwpKRWRw"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final InterfaceC0865Co A04;
    public final C0980Hh A05 = new C0980Hh(32);

    public WA(InterfaceC0865Co interfaceC0865Co) {
        this.A04 = interfaceC0865Co;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0871Cv
    public final void A4P(C0980Hh c0980Hh, boolean z) {
        int i = -1;
        if (z) {
            int iA0E = c0980Hh.A0E();
            int iA06 = c0980Hh.A06();
            String[] strArr = A06;
            String str = strArr[4];
            String str2 = strArr[2];
            int payloadStartOffset = str.length();
            if (payloadStartOffset != str2.length()) {
                throw new RuntimeException();
            }
            A06[5] = "fX8Qw0M3arh1i";
            i = iA06 + iA0E;
        }
        if (this.A03) {
            if (!z) {
                return;
            }
            this.A03 = false;
            c0980Hh.A0Y(i);
            this.A00 = 0;
        }
        while (c0980Hh.A04() > 0) {
            int payloadStartPosition = this.A00;
            if (payloadStartPosition < 3) {
                if (payloadStartPosition == 0) {
                    int tableId = c0980Hh.A0E();
                    c0980Hh.A0Y(c0980Hh.A06() - 1);
                    if (tableId == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int tableId2 = c0980Hh.A04();
                int iMin = Math.min(tableId2, 3 - this.A00);
                c0980Hh.A0c(this.A05.A00, this.A00, iMin);
                int payloadStartPosition2 = this.A00 + iMin;
                this.A00 = payloadStartPosition2;
                if (payloadStartPosition2 == 3) {
                    this.A05.A0W(3);
                    this.A05.A0Z(1);
                    int iA0E2 = this.A05.A0E();
                    int headerBytesToRead = this.A05.A0E();
                    this.A02 = (iA0E2 & 128) != 0;
                    this.A01 = (((iA0E2 & 15) << 8) | headerBytesToRead) + 3;
                    int headerBytesToRead2 = this.A05.A05();
                    if (headerBytesToRead2 < this.A01) {
                        byte[] bArr = this.A05.A00;
                        C0980Hh c0980Hh2 = this.A05;
                        int headerBytesToRead3 = this.A01;
                        c0980Hh2.A0W(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(headerBytesToRead3, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.A05.A00, 0, 3);
                    }
                }
            } else {
                int iA04 = c0980Hh.A04();
                int headerBytesToRead4 = this.A01;
                int iMin2 = Math.min(iA04, headerBytesToRead4 - this.A00);
                c0980Hh.A0c(this.A05.A00, this.A00, iMin2);
                int payloadStartPosition3 = this.A00 + iMin2;
                this.A00 = payloadStartPosition3;
                int bodyBytesToRead = this.A01;
                if (payloadStartPosition3 != bodyBytesToRead) {
                    continue;
                } else {
                    if (this.A02) {
                        if (C0996Hx.A09(this.A05.A00, 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        this.A05.A0W(this.A01 - 4);
                    } else {
                        this.A05.A0W(bodyBytesToRead);
                    }
                    this.A04.A4O(this.A05);
                    this.A00 = 0;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0871Cv
    public final void A8g(C0992Ht c0992Ht, InterfaceC0840Bc interfaceC0840Bc, C0870Cu c0870Cu) {
        this.A04.A8g(c0992Ht, interfaceC0840Bc, c0870Cu);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0871Cv
    public final void AEv() {
        this.A03 = true;
    }
}
