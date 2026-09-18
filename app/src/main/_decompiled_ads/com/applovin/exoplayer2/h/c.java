package com.applovin.exoplayer2.h;

import android.net.Uri;
import com.applovin.exoplayer2.l.ai;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c implements s {
    private final com.applovin.exoplayer2.e.l KP;
    private com.applovin.exoplayer2.e.h KQ;
    private com.applovin.exoplayer2.e.i KR;

    public c(com.applovin.exoplayer2.e.l lVar) {
        this.KP = lVar;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    @Override // com.applovin.exoplayer2.h.s
    public void a(com.applovin.exoplayer2.k.g gVar, Uri uri, Map<String, List<String>> map, long j, long j2, com.applovin.exoplayer2.e.j jVar) throws IOException {
        com.applovin.exoplayer2.e.e eVar = new com.applovin.exoplayer2.e.e(gVar, j, j2);
        this.KR = eVar;
        if (this.KQ != null) {
            return;
        }
        com.applovin.exoplayer2.e.h[] hVarArrA = this.KP.a(uri, map);
        if (hVarArrA.length == 1) {
            this.KQ = hVarArrA[0];
        } else {
            int length = hVarArrA.length;
            for (int i = 0; i < length; i++) {
                com.applovin.exoplayer2.e.h hVar = hVarArrA[i];
                try {
                    if (hVar.a(eVar)) {
                        this.KQ = hVar;
                        com.applovin.exoplayer2.l.a.checkState(hVar != null || eVar.ie() == j);
                        eVar.ic();
                        break;
                    } else {
                        boolean z = this.KQ != null || eVar.ie() == j;
                        com.applovin.exoplayer2.l.a.checkState(z);
                        eVar.ic();
                    }
                } catch (EOFException unused) {
                    if (this.KQ != null || eVar.ie() == j) {
                    }
                } catch (Throwable th) {
                    com.applovin.exoplayer2.l.a.checkState(this.KQ != null || eVar.ie() == j);
                    eVar.ic();
                    throw th;
                }
                com.applovin.exoplayer2.l.a.checkState(z);
                eVar.ic();
            }
            if (this.KQ == null) {
                throw new ae("None of the available extractors (" + ai.h(hVarArrA) + ") could read the stream.", (Uri) com.applovin.exoplayer2.l.a.checkNotNull(uri));
            }
        }
        this.KQ.a(jVar);
    }

    @Override // com.applovin.exoplayer2.h.s
    public void release() {
        com.applovin.exoplayer2.e.h hVar = this.KQ;
        if (hVar != null) {
            hVar.release();
            this.KQ = null;
        }
        this.KR = null;
    }

    @Override // com.applovin.exoplayer2.h.s
    public void kK() {
        com.applovin.exoplayer2.e.h hVar = this.KQ;
        if (hVar instanceof com.applovin.exoplayer2.e.f.d) {
            ((com.applovin.exoplayer2.e.f.d) hVar).iG();
        }
    }

    @Override // com.applovin.exoplayer2.h.s
    public long kL() {
        com.applovin.exoplayer2.e.i iVar = this.KR;
        if (iVar != null) {
            return iVar.ie();
        }
        return -1L;
    }

    @Override // com.applovin.exoplayer2.h.s
    public void o(long j, long j2) {
        ((com.applovin.exoplayer2.e.h) com.applovin.exoplayer2.l.a.checkNotNull(this.KQ)).o(j, j2);
    }

    @Override // com.applovin.exoplayer2.h.s
    public int a(com.applovin.exoplayer2.e.u uVar) throws IOException {
        return ((com.applovin.exoplayer2.e.h) com.applovin.exoplayer2.l.a.checkNotNull(this.KQ)).b((com.applovin.exoplayer2.e.i) com.applovin.exoplayer2.l.a.checkNotNull(this.KR), uVar);
    }
}
