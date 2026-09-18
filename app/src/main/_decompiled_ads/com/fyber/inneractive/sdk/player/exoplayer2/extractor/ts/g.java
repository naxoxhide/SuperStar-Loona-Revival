package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements h {
    public final List<v.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.n[] f1124b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public g(List<v.a> list) {
        this.a = list;
        this.f1124b = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.n[list.size()];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a() {
        this.c = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void b() {
        if (this.c) {
            for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar : this.f1124b) {
                nVar.a(this.f, 1, this.e, 0, null);
            }
            this.c = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.h hVar, v.d dVar) {
        for (int i = 0; i < this.f1124b.length; i++) {
            v.a aVar = this.a.get(i);
            dVar.a();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVarA = hVar.a(dVar.c(), 3);
            nVarA.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a(dVar.b(), "application/dvbsubs", (String) null, -1, (List<byte[]>) Collections.singletonList(aVar.f1144b), aVar.a, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
            this.f1124b[i] = nVarA;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        if (this.c) {
            if (this.d != 2 || a(kVar, 32)) {
                if (this.d != 1 || a(kVar, 0)) {
                    int i = kVar.f1236b;
                    int iA = kVar.a();
                    for (com.fyber.inneractive.sdk.player.exoplayer2.extractor.n nVar : this.f1124b) {
                        kVar.e(i);
                        nVar.a(kVar, iA);
                    }
                    this.e += iA;
                }
            }
        }
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, int i) {
        if (kVar.a() == 0) {
            return false;
        }
        if (kVar.l() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }
}
