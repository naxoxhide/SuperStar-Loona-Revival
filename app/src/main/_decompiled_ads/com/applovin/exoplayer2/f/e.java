package com.applovin.exoplayer2.f;

import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.v;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
final class e {
    private long Hd;
    private long He;
    private boolean Hf;

    e() {
    }

    public void Y() {
        this.Hd = 0L;
        this.He = 0L;
        this.Hf = false;
    }

    public long a(v vVar, com.applovin.exoplayer2.c.g gVar) {
        if (this.He == 0) {
            this.Hd = gVar.rJ;
        }
        if (this.Hf) {
            return gVar.rJ;
        }
        ByteBuffer byteBuffer = (ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(gVar.rH);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & 255);
        }
        int iAH = r.aH(i);
        if (iAH == -1) {
            this.Hf = true;
            this.He = 0L;
            this.Hd = gVar.rJ;
            q.h("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return gVar.rJ;
        }
        long jAK = aK(vVar.dM);
        this.He += (long) iAH;
        return jAK;
    }

    public long k(v vVar) {
        return aK(vVar.dM);
    }

    private long aK(long j) {
        return this.Hd + Math.max(0L, ((this.He - 529) * 1000000) / j);
    }
}
