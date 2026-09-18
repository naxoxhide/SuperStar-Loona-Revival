package com.applovin.exoplayer2.e.j;

import android.util.Pair;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class c {
    public static b aa(i iVar) throws IOException {
        byte[] bArr;
        com.applovin.exoplayer2.l.a.checkNotNull(iVar);
        y yVar = new y(16);
        if (a.a(iVar, yVar).zD != 1380533830) {
            return null;
        }
        iVar.c(yVar.hO(), 0, 4);
        yVar.fx(0);
        int iPx = yVar.px();
        if (iPx != 1463899717) {
            q.i("WavHeaderReader", "Unsupported RIFF format: " + iPx);
            return null;
        }
        a aVarA = a.a(iVar, yVar);
        while (aVarA.zD != 1718449184) {
            iVar.bI((int) aVarA.Gs);
            aVarA = a.a(iVar, yVar);
        }
        com.applovin.exoplayer2.l.a.checkState(aVarA.Gs >= 16);
        iVar.c(yVar.hO(), 0, 16);
        yVar.fx(0);
        int iPq = yVar.pq();
        int iPq2 = yVar.pq();
        int iPE = yVar.pE();
        int iPE2 = yVar.pE();
        int iPq3 = yVar.pq();
        int iPq4 = yVar.pq();
        int i = ((int) aVarA.Gs) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            iVar.c(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = ai.ada;
        }
        return new b(iPq, iPq2, iPE, iPE2, iPq3, iPq4, bArr);
    }

    public static Pair<Long, Long> ab(i iVar) throws IOException {
        com.applovin.exoplayer2.l.a.checkNotNull(iVar);
        iVar.ic();
        y yVar = new y(8);
        a aVarA = a.a(iVar, yVar);
        while (aVarA.zD != 1684108385) {
            if (aVarA.zD != 1380533830 && aVarA.zD != 1718449184) {
                q.h("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.zD);
            }
            long j = aVarA.Gs + 8;
            if (aVarA.zD == 1380533830) {
                j = 12;
            }
            if (j > 2147483647L) {
                throw com.applovin.exoplayer2.ai.p("Chunk is too large (~2GB+) to skip; id: " + aVarA.zD);
            }
            iVar.bH((int) j);
            aVarA = a.a(iVar, yVar);
        }
        iVar.bH(8);
        long jIe = iVar.ie();
        long j2 = aVarA.Gs + jIe;
        long jMo44if = iVar.mo44if();
        if (jMo44if != -1 && j2 > jMo44if) {
            q.h("WavHeaderReader", "Data exceeds input length: " + j2 + ", " + jMo44if);
            j2 = jMo44if;
        }
        return Pair.create(Long.valueOf(jIe), Long.valueOf(j2));
    }

    private static final class a {
        public final long Gs;
        public final int zD;

        private a(int i, long j) {
            this.zD = i;
            this.Gs = j;
        }

        public static a a(i iVar, y yVar) throws IOException {
            iVar.c(yVar.hO(), 0, 8);
            yVar.fx(0);
            return new a(yVar.px(), yVar.pw());
        }
    }
}
