package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements h {
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k a = new com.fyber.inneractive.sdk.player.exoplayer2.util.k(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n f1132b;
    public boolean c;
    public long d;
    public int e;
    public int f;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.f1132b.a(this.d, 1, i, 0, null);
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        dVar.a();
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 4);
        this.f1132b = nVarA;
        nVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(dVar.b(), "application/id3", null, -1, null));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        if (this.c) {
            int iA = kVar.a();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(kVar.a, kVar.f1236b, this.a.a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.a.e(0);
                    if (73 == this.a.l() && 68 == this.a.l() && 51 == this.a.l()) {
                        this.a.f(3);
                        this.e = this.a.k() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.e - this.f);
            this.f1132b.a(kVar, iMin2);
            this.f += iMin2;
        }
    }
}
