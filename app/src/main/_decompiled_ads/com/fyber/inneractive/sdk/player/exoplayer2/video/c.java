package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final List<byte[]> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1253b;

    public c(List<byte[]> list, int i) {
        this.a = list;
        this.f1253b = i;
    }

    public static c a(k kVar) throws l {
        try {
            kVar.f(21);
            int iL = kVar.l() & 3;
            int iL2 = kVar.l();
            int i = kVar.f1236b;
            int i2 = 0;
            for (int i3 = 0; i3 < iL2; i3++) {
                kVar.f(1);
                int iQ = kVar.q();
                for (int i4 = 0; i4 < iQ; i4++) {
                    int iQ2 = kVar.q();
                    i2 += iQ2 + 4;
                    kVar.f(iQ2);
                }
            }
            kVar.e(i);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < iL2; i6++) {
                kVar.f(1);
                int iQ3 = kVar.q();
                for (int i7 = 0; i7 < iQ3; i7++) {
                    int iQ4 = kVar.q();
                    byte[] bArr2 = i.a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(kVar.a, kVar.f1236b, bArr, length, iQ4);
                    i5 = length + iQ4;
                    kVar.f(iQ4);
                }
            }
            return new c(i2 == 0 ? null : Collections.singletonList(bArr), iL + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new l("Error parsing HEVC config", e);
        }
    }
}
