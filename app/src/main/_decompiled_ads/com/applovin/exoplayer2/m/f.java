package com.applovin.exoplayer2.m;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.l.z;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final List<byte[]> dB;
    public final String dw;
    public final int wo;

    public static f av(y yVar) throws ai {
        try {
            yVar.fz(21);
            int iPo = yVar.po() & 3;
            int iPo2 = yVar.po();
            int iIl = yVar.il();
            int i = 0;
            for (int i2 = 0; i2 < iPo2; i2++) {
                yVar.fz(1);
                int iPp = yVar.pp();
                for (int i3 = 0; i3 < iPp; i3++) {
                    int iPp2 = yVar.pp();
                    i += iPp2 + 4;
                    yVar.fz(iPp2);
                }
            }
            yVar.fx(iIl);
            byte[] bArr = new byte[i];
            int i4 = 0;
            String strC = null;
            for (int i5 = 0; i5 < iPo2; i5++) {
                int iPo3 = yVar.po() & WorkQueueKt.MASK;
                int iPp3 = yVar.pp();
                for (int i6 = 0; i6 < iPp3; i6++) {
                    int iPp4 = yVar.pp();
                    System.arraycopy(v.abK, 0, bArr, i4, v.abK.length);
                    int length = i4 + v.abK.length;
                    System.arraycopy(yVar.hO(), yVar.il(), bArr, length, iPp4);
                    if (iPo3 == 33 && i6 == 0) {
                        strC = com.applovin.exoplayer2.l.e.c(new z(bArr, length, length + iPp4));
                    }
                    i4 = length + iPp4;
                    yVar.fz(iPp4);
                }
            }
            return new f(i == 0 ? null : Collections.singletonList(bArr), iPo + 1, strC);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ai.c("Error parsing HEVC config", e);
        }
    }

    private f(List<byte[]> list, int i, String str) {
        this.dB = list;
        this.wo = i;
        this.dw = str;
    }
}
