package com.applovin.exoplayer2.e.b;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.m;
import com.applovin.exoplayer2.e.p;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class a extends com.applovin.exoplayer2.e.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(final p pVar, int i, long j, long j2) {
        super(new com.applovin.exoplayer2.e.a.d() { // from class: com.applovin.exoplayer2.e.b.-$$Lambda$xH0svk7nNtniYrB3Y5RTIPBycyM
            @Override // com.applovin.exoplayer2.e.a.d
            public final long timeUsToTargetTime(long j3) {
                return pVar.an(j3);
            }
        }, new C0087a(pVar, i), pVar.dd(), 0L, pVar.uI, j, j2, pVar.ii(), Math.max(6, pVar.uD));
        Objects.requireNonNull(pVar);
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.e.b.a$a, reason: collision with other inner class name */
    private static final class C0087a implements com.applovin.exoplayer2.e.a.f {
        private final p uz;
        private final int vK;
        private final m.a vL;

        private C0087a(p pVar, int i) {
            this.uz = pVar;
            this.vK = i;
            this.vL = new m.a();
        }

        @Override // com.applovin.exoplayer2.e.a.f
        public com.applovin.exoplayer2.e.a.e b(i iVar, long j) throws IOException {
            long jIe = iVar.ie();
            long jI = i(iVar);
            long jId = iVar.id();
            iVar.bI(Math.max(6, this.uz.uD));
            long jI2 = i(iVar);
            long jId2 = iVar.id();
            if (jI <= j && jI2 > j) {
                return com.applovin.exoplayer2.e.a.e.aj(jId);
            }
            if (jI2 <= j) {
                return com.applovin.exoplayer2.e.a.e.n(jI2, jId2);
            }
            return com.applovin.exoplayer2.e.a.e.m(jI, jIe);
        }

        private long i(i iVar) throws IOException {
            while (iVar.id() < iVar.mo44if() - 6 && !m.a(iVar, this.uz, this.vK, this.vL)) {
                iVar.bI(1);
            }
            if (iVar.id() >= iVar.mo44if() - 6) {
                iVar.bI((int) (iVar.mo44if() - iVar.id()));
                return this.uz.uI;
            }
            return this.vL.uy;
        }
    }
}
