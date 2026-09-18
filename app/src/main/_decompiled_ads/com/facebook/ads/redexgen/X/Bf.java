package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Bf {
    public final C0980Hh A00 = new C0980Hh(10);

    public final Metadata A00(InterfaceC0839Bb interfaceC0839Bb, DQ dq) throws InterruptedException, IOException {
        int tagLength = 0;
        Metadata metadataA0O = null;
        while (true) {
            try {
                interfaceC0839Bb.ADl(this.A00.A00, 0, 10);
                this.A00.A0Y(0);
                int iA0G = this.A00.A0G();
                int peekedId3Bytes = C1349Vu.A03;
                if (iA0G != peekedId3Bytes) {
                    break;
                }
                this.A00.A0Z(3);
                int iA0D = this.A00.A0D();
                int framesLength = iA0D + 10;
                if (metadataA0O == null) {
                    byte[] bArr = new byte[framesLength];
                    System.arraycopy(this.A00.A00, 0, bArr, 0, 10);
                    interfaceC0839Bb.ADl(bArr, 10, iA0D);
                    metadataA0O = new C1349Vu(dq).A0O(bArr, framesLength);
                } else {
                    interfaceC0839Bb.A3S(iA0D);
                }
                tagLength += framesLength;
            } catch (EOFException unused) {
            }
        }
        interfaceC0839Bb.AEm();
        interfaceC0839Bb.A3S(tagLength);
        return metadataA0O;
    }
}
