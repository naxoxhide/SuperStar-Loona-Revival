package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements o {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1070b;

    public i(j jVar, int i) {
        this.f1070b = jVar;
        this.a = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
    public void a() throws IOException {
        this.f1070b.j();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
    public boolean isReady() {
        j jVar = this.f1070b;
        return jVar.y || !(jVar.h() || jVar.j.valueAt(this.a).f());
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.j jVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar, boolean z) {
        j jVar2 = this.f1070b;
        int i = this.a;
        if (jVar2.h()) {
            return -3;
        }
        while (true) {
            boolean z2 = true;
            if (jVar2.k.size() <= 1) {
                break;
            }
            int i2 = jVar2.k.getFirst().j;
            for (int i3 = 0; i3 < jVar2.j.size(); i3++) {
                if (jVar2.v[i3]) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.c cVar = jVar2.j.valueAt(i3).c;
                    if ((cVar.i == 0 ? cVar.r : cVar.f1060b[cVar.k]) == i2) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (!z2) {
                break;
            }
            jVar2.k.removeFirst();
        }
        f first = jVar2.k.getFirst();
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar = first.c;
        if (!iVar.equals(jVar2.q)) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.f.a aVar = jVar2.h;
            int i4 = jVar2.a;
            int i5 = first.d;
            Object obj = first.e;
            long j = first.f;
            if (aVar.f1182b != null) {
                aVar.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.e(aVar, i4, iVar, i5, obj, j));
            }
        }
        jVar2.q = iVar;
        return jVar2.j.valueAt(i).a(jVar, bVar, z, jVar2.y, jVar2.w);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.o
    public void a(long j) {
        j jVar = this.f1070b;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVarValueAt = jVar.j.valueAt(this.a);
        if (jVar.y && j > dVarValueAt.d()) {
            dVarValueAt.g();
        } else {
            dVarValueAt.a(j, true);
        }
    }
}
