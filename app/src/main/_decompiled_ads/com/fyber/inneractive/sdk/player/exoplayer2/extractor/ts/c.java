package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("ID3");
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f1120b = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(200);
    public d c;
    public boolean d;

    public c(long j) {
        this.a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(10);
        byte[] bArr = kVar.a;
        com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.j(bArr, bArr.length);
        int i = 0;
        while (true) {
            bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
            bVar.a(kVar.a, 0, 10, false);
            kVar.e(0);
            if (kVar.n() != e) {
                break;
            }
            kVar.f(3);
            int iK = kVar.k();
            i += iK + 10;
            bVar.a(iK, false);
        }
        bVar.e = 0;
        bVar.a(i, false);
        int i2 = 0;
        int i3 = 0;
        int i4 = i;
        while (true) {
            bVar.a(kVar.a, 0, 2, false);
            kVar.e(0);
            if ((kVar.q() & 65526) != 65520) {
                bVar.e = 0;
                i4++;
                if (i4 - i >= 8192) {
                    return false;
                }
                bVar.a(i4, false);
                i2 = 0;
                i3 = 0;
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                bVar.a(kVar.a, 0, 4, false);
                jVar.b(14);
                int iA = jVar.a(13);
                if (iA <= 6) {
                    return false;
                }
                bVar.a(iA - 6, false);
                i3 += iA;
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        d dVar = new d(true, null);
        this.c = dVar;
        dVar.a(hVar, new v.d(Integer.MIN_VALUE, 0, 1));
        hVar.c();
        hVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m.a(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.d = false;
        this.c.c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        int iA = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).a(this.f1120b.a, 0, 200);
        if (iA == -1) {
            return -1;
        }
        this.f1120b.e(0);
        this.f1120b.d(iA);
        if (!this.d) {
            this.c.o = this.a;
            this.d = true;
        }
        this.c.a(this.f1120b);
        return 0;
    }
}
