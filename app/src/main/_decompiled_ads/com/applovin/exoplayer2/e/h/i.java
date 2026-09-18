package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.z;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class i extends h {
    private a Cf;
    private int Cg;
    private boolean Ch;
    private z.d Ci;
    private z.b Cj;

    static int a(byte b2, int i, int i2) {
        return (b2 >> i2) & (255 >>> (8 - i));
    }

    i() {
    }

    public static boolean F(y yVar) {
        try {
            return z.a(1, yVar, true);
        } catch (ai unused) {
            return false;
        }
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected void e(boolean z) {
        super.e(z);
        if (z) {
            this.Cf = null;
            this.Ci = null;
            this.Cj = null;
        }
        this.Cg = 0;
        this.Ch = false;
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected void aG(long j) {
        super.aG(j);
        this.Ch = j != 0;
        z.d dVar = this.Ci;
        this.Cg = dVar != null ? dVar.vn : 0;
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected long G(y yVar) {
        if ((yVar.hO()[0] & 1) == 1) {
            return -1L;
        }
        int iA = a(yVar.hO()[0], (a) com.applovin.exoplayer2.l.a.N(this.Cf));
        long j = this.Ch ? (this.Cg + iA) / 4 : 0;
        d(yVar, j);
        this.Ch = true;
        this.Cg = iA;
        return j;
    }

    @Override // com.applovin.exoplayer2.e.h.h
    protected boolean a(y yVar, long j, h.a aVar) throws IOException {
        if (this.Cf != null) {
            com.applovin.exoplayer2.l.a.checkNotNull(aVar.dU);
            return false;
        }
        a aVarJ = J(yVar);
        this.Cf = aVarJ;
        if (aVarJ == null) {
            return true;
        }
        z.d dVar = aVarJ.Ck;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.tf);
        arrayList.add(aVarJ.Cl);
        aVar.dU = new v.a().m("audio/vorbis").G(dVar.vl).H(dVar.vk).N(dVar.mI).O(dVar.dM).c(arrayList).bT();
        return true;
    }

    a J(y yVar) throws IOException {
        z.d dVar = this.Ci;
        if (dVar == null) {
            this.Ci = z.c(yVar);
            return null;
        }
        z.b bVar = this.Cj;
        if (bVar == null) {
            this.Cj = z.d(yVar);
            return null;
        }
        byte[] bArr = new byte[yVar.pk()];
        System.arraycopy(yVar.hO(), 0, bArr, 0, yVar.pk());
        z.c[] cVarArrD = z.d(yVar, dVar.mI);
        return new a(dVar, bVar, bArr, cVarArrD, z.bS(cVarArrD.length - 1));
    }

    static void d(y yVar, long j) {
        if (yVar.pl() < yVar.pk() + 4) {
            yVar.I(Arrays.copyOf(yVar.hO(), yVar.pk() + 4));
        } else {
            yVar.fA(yVar.pk() + 4);
        }
        byte[] bArrHO = yVar.hO();
        bArrHO[yVar.pk() - 4] = (byte) (j & 255);
        bArrHO[yVar.pk() - 3] = (byte) ((j >>> 8) & 255);
        bArrHO[yVar.pk() - 2] = (byte) ((j >>> 16) & 255);
        bArrHO[yVar.pk() - 1] = (byte) ((j >>> 24) & 255);
    }

    private static int a(byte b2, a aVar) {
        if (!aVar.Cm[a(b2, aVar.Cn, 1)].vg) {
            return aVar.Ck.vn;
        }
        return aVar.Ck.vo;
    }

    static final class a {
        public final z.b Cj;
        public final z.d Ck;
        public final byte[] Cl;
        public final z.c[] Cm;
        public final int Cn;

        public a(z.d dVar, z.b bVar, byte[] bArr, z.c[] cVarArr, int i) {
            this.Ck = dVar;
            this.Cj = bVar;
            this.Cl = bArr;
            this.Cm = cVarArr;
            this.Cn = i;
        }
    }
}
