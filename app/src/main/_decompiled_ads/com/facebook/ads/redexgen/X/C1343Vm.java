package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1343Vm implements InterfaceC0916Et {
    public static String[] A03 = {"2iJQWlRsUDoPLtxxhE0wL9Cx9C7nOBrU", "oJgjoNY6hjjHJmelHDlI5xZuIY2b67h", "lPiJTezOZt4yDoox6bX3l7R6F2XzCVNN", "wrWzKGBonHGMzL1uPVOM3eUURFaMzKwB", "aBcbXNoo2m3wtFqQFSiOk3RFoevM7GVG", "GcCP7ZOQcwM7LeXwSBQclRy3S6aYmmD", "JUPsbTU3PQNYOt9vjPoPUzbQPtEFF22Q", "21kt6KXNgOdDUktVBInrV9GyhB6eLfYq"};
    public boolean A00;
    public final InterfaceC0916Et A01;
    public final /* synthetic */ BW A02;

    public C1343Vm(BW bw, InterfaceC0916Et interfaceC0916Et) {
        this.A02 = bw;
        this.A01 = interfaceC0916Et;
    }

    public final void A00() {
        this.A00 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final boolean A90() {
        return !this.A02.A03() && this.A01.A90();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final void AA2() throws IOException {
        this.A01.AA2();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Instruction removed from duplicated block: B:15:0x0029, please report this as an issue */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final int AEC(C9X c9x, XE xe, boolean z) {
        int encoderPadding;
        if (this.A02.A03()) {
            return -3;
        }
        if (this.A00) {
            xe.A02(4);
            return -4;
        }
        int iAEC = this.A01.AEC(c9x, xe, z);
        if (iAEC != -5) {
            if (this.A02.A00 != Long.MIN_VALUE && ((iAEC == -4 && xe.A00 >= this.A02.A00) || (iAEC == -3 && this.A02.A68() == Long.MIN_VALUE))) {
                xe.A07();
                xe.A02(4);
                this.A00 = true;
                return -4;
            }
            return iAEC;
        }
        Format format = c9x.A00;
        int result = format.A06;
        if (result == 0) {
            int result2 = format.A07;
            if (result2 != 0) {
                if (this.A02.A01 != 0) {
                    encoderPadding = 0;
                } else {
                    encoderPadding = format.A06;
                }
                c9x.A00 = format.A0G(encoderPadding, this.A02.A00 == Long.MIN_VALUE ? format.A07 : 0);
            }
        } else {
            if (this.A02.A01 != 0) {
                encoderPadding = 0;
            } else {
                encoderPadding = format.A06;
            }
            c9x.A00 = format.A0G(encoderPadding, this.A02.A00 == Long.MIN_VALUE ? format.A07 : 0);
        }
        return -5;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0916Et
    public final int AFd(long j) {
        if (!this.A02.A03()) {
            return this.A01.AFd(j);
        }
        if (A03[7].charAt(6) == 'T') {
            throw new RuntimeException();
        }
        A03[0] = "I7Vle9theSHJs2vfg5SYnPGKFT8j8RVM";
        return -3;
    }
}
