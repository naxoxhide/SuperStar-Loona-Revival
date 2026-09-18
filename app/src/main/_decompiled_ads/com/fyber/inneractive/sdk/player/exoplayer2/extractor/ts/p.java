package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.r a;
    public boolean d;
    public boolean e;
    public boolean f;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.h g;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k c = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(4096);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<a> f1136b = new SparseArray<>();

    public static final class a {
        public final h a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.r f1137b;
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.j c = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public long g;

        public a(h hVar, com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar) {
            this.a = hVar;
            this.f1137b = rVar;
        }
    }

    public p(com.fyber.inneractive.sdk.player.exoplayer2.util.r rVar) {
        this.a = rVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        byte[] bArr = new byte[14];
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(bArr, 0, 14, false);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        bVar.a(bArr[13] & 7, false);
        bVar.a(bArr, 0, 3, false);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        this.g = hVar;
        hVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m.a(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.a.c = -9223372036854775807L;
        for (int i = 0; i < this.f1136b.size(); i++) {
            a aVarValueAt = this.f1136b.valueAt(i);
            aVarValueAt.f = false;
            aVarValueAt.a.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b0  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        h mVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        if (!bVar.a(this.c.a, 0, 4, true)) {
            return -1;
        }
        this.c.e(0);
        int iC = this.c.c();
        if (iC == 441) {
            return -1;
        }
        if (iC == 442) {
            bVar.a(this.c.a, 0, 10, false);
            this.c.e(9);
            bVar.c((this.c.l() & 7) + 14);
            return 0;
        }
        if (iC == 443) {
            bVar.a(this.c.a, 0, 2, false);
            this.c.e(0);
            bVar.c(this.c.q() + 6);
            return 0;
        }
        if (((iC & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            bVar.c(1);
            return 0;
        }
        int i = iC & 255;
        a aVar = this.f1136b.get(i);
        if (!this.d) {
            if (aVar == null) {
                boolean z = this.e;
                h iVar = null;
                if (z || i != 189) {
                    if (!z && (i & 224) == 192) {
                        mVar = new m(null);
                        this.e = true;
                    } else if (!this.f && (i & 240) == 224) {
                        iVar = new i();
                        this.f = true;
                    }
                    if (iVar != null) {
                        iVar.a(this.g, new v.d(Integer.MIN_VALUE, i, 256));
                        aVar = new a(iVar, this.a);
                        this.f1136b.put(i, aVar);
                    }
                } else {
                    mVar = new b(null);
                    this.e = true;
                }
                iVar = mVar;
                if (iVar != null) {
                    iVar.a(this.g, new v.d(Integer.MIN_VALUE, i, 256));
                    aVar = new a(iVar, this.a);
                    this.f1136b.put(i, aVar);
                }
            }
            if ((this.e && this.f) || bVar.c > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                this.d = true;
                this.g.c();
            }
        }
        bVar.a(this.c.a, 0, 2, false);
        this.c.e(0);
        int iQ = this.c.q() + 6;
        if (aVar == null) {
            bVar.c(iQ);
        } else {
            this.c.c(iQ);
            bVar.b(this.c.a, 0, iQ, false);
            this.c.e(6);
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = this.c;
            kVar.a(aVar.c.a, 0, 3);
            aVar.c.b(0);
            aVar.c.c(8);
            aVar.d = aVar.c.b();
            aVar.e = aVar.c.b();
            aVar.c.c(6);
            kVar.a(aVar.c.a, 0, aVar.c.a(8));
            aVar.c.b(0);
            aVar.g = 0L;
            if (aVar.d) {
                aVar.c.c(4);
                long jA = ((long) aVar.c.a(3)) << 30;
                aVar.c.c(1);
                long jA2 = jA | ((long) (aVar.c.a(15) << 15));
                aVar.c.c(1);
                long jA3 = jA2 | ((long) aVar.c.a(15));
                aVar.c.c(1);
                if (!aVar.f && aVar.e) {
                    aVar.c.c(4);
                    long jA4 = ((long) aVar.c.a(3)) << 30;
                    aVar.c.c(1);
                    long jA5 = jA4 | ((long) (aVar.c.a(15) << 15));
                    aVar.c.c(1);
                    long jA6 = ((long) aVar.c.a(15)) | jA5;
                    aVar.c.c(1);
                    aVar.f1137b.b(jA6);
                    aVar.f = true;
                }
                aVar.g = aVar.f1137b.b(jA3);
            }
            aVar.a.a(aVar.g, true);
            aVar.a.a(kVar);
            aVar.a.b();
            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = this.c;
            kVar2.d(kVar2.b());
        }
        return 0;
    }
}
