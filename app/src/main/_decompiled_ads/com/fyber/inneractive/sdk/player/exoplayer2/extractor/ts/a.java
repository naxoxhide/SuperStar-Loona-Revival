package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public static final int e = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("ID3");
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k f1118b = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(2786);
    public b c;
    public boolean d;

    public a(long j) {
        this.a = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws InterruptedException, IOException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(10);
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
        int i3 = i;
        while (true) {
            bVar.a(kVar.a, 0, 5, false);
            kVar.e(0);
            if (kVar.q() != 2935) {
                bVar.e = 0;
                i3++;
                if (i3 - i >= 8192) {
                    return false;
                }
                bVar.a(i3, false);
                i2 = 0;
            } else {
                i2++;
                if (i2 >= 4) {
                    return true;
                }
                byte[] bArr = kVar.a;
                int iA = bArr.length < 5 ? -1 : com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a((bArr[4] & 192) >> 6, bArr[4] & 63);
                if (iA == -1) {
                    return false;
                }
                bVar.a(iA - 5, false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar) {
        b bVar = new b(null);
        this.c = bVar;
        bVar.d = "0";
        bVar.e = hVar.a(0, 1);
        hVar.c();
        hVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m.a(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public void a(long j, long j2) {
        this.d = false;
        this.c.a();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws InterruptedException, IOException {
        int iA = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).a(this.f1118b.a, 0, 2786);
        if (iA == -1) {
            return -1;
        }
        this.f1118b.e(0);
        this.f1118b.d(iA);
        if (!this.d) {
            this.c.l = this.a;
            this.d = true;
        }
        this.c.a(this.f1118b);
        return 0;
    }
}
