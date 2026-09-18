package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.b.s;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class g extends h {
    private static final byte[] BW = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean BX;

    g() {
    }

    public static boolean F(y yVar) {
        int iPj = yVar.pj();
        byte[] bArr = BW;
        if (iPj < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        yVar.r(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected void e(boolean z) {
        super.e(z);
        if (z) {
            this.BX = false;
        }
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected long G(y yVar) {
        return aF(B(yVar.hO()));
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected boolean a(y yVar, long j, h.a aVar) {
        if (!this.BX) {
            byte[] bArrCopyOf = Arrays.copyOf(yVar.hO(), yVar.pk());
            aVar.dU = new v.a().m("audio/opus").N(s.i(bArrCopyOf)).O(48000).c(s.j(bArrCopyOf)).bT();
            this.BX = true;
            return true;
        }
        com.applovin.exoplayer2.l.a.checkNotNull(aVar.dU);
        boolean z = yVar.px() == 1332770163;
        yVar.fx(0);
        return z;
    }

    private long B(byte[] bArr) {
        int i;
        int i2 = bArr[0] & 255;
        int i3 = i2 & 3;
        int i4 = 2;
        if (i3 == 0) {
            i4 = 1;
        } else if (i3 != 1 && i3 != 2) {
            i4 = bArr[1] & 63;
        }
        int i5 = i2 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i = 2500 << i6;
        } else if (i5 >= 12) {
            i = 10000 << (i6 & 1);
        } else {
            i = i6 == 3 ? 60000 : 10000 << i6;
        }
        return ((long) i4) * ((long) i);
    }
}
