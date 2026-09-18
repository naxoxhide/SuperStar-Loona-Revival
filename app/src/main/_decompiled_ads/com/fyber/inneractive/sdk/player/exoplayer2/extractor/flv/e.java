package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1064b;
    public final k c;
    public int d;
    public boolean e;
    public int f;

    public e(n nVar) {
        super(nVar);
        this.f1064b = new k(i.a);
        this.c = new k(4);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d
    public boolean a(k kVar) throws d.a {
        int iL = kVar.l();
        int i = (iL >> 4) & 15;
        int i2 = iL & 15;
        if (i2 != 7) {
            throw new d.a("Video format not supported: " + i2);
        }
        this.f = i;
        return i != 5;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d
    public void b(k kVar, long j) throws l {
        int iL = kVar.l();
        long jN = j + (((long) kVar.n()) * 1000);
        if (iL == 0 && !this.e) {
            k kVar2 = new k(new byte[kVar.a()]);
            kVar.a(kVar2.a, 0, kVar.a());
            com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarB = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(kVar2);
            this.d = aVarB.f1251b;
            this.a.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "video/avc", (String) null, -1, -1, aVarB.c, aVarB.d, -1.0f, aVarB.a, -1, aVarB.e, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
            this.e = true;
            return;
        }
        if (iL == 1 && this.e) {
            byte[] bArr = this.c.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (kVar.a() > 0) {
                kVar.a(this.c.a, i, this.d);
                this.c.e(0);
                int iO = this.c.o();
                this.f1064b.e(0);
                this.a.a(this.f1064b, 4);
                this.a.a(kVar, iO);
                i2 = i2 + 4 + iO;
            }
            this.a.a(jN, this.f == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
