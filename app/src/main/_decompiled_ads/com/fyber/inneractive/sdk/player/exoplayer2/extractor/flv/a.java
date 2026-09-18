package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends d {
    public static final int[] e = {5512, 11025, 22050, 44100};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1061b;
    public boolean c;
    public int d;

    public a(n nVar) {
        super(nVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d
    public boolean a(k kVar) throws d.a {
        if (this.f1061b) {
            kVar.f(1);
        } else {
            int iL = kVar.l();
            int i = (iL >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.a.a(i.a((String) null, "audio/mpeg", (String) null, -1, -1, 1, e[(iL >> 2) & 3], -1, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.a.a(i.a((String) null, i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (iL & 1) == 1 ? 2 : 3, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
                this.c = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.d);
            }
            this.f1061b = true;
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.d
    public void b(k kVar, long j) {
        if (this.d == 2) {
            int iA = kVar.a();
            this.a.a(kVar, iA);
            this.a.a(j, 1, iA, 0, null);
            return;
        }
        int iL = kVar.l();
        if (iL != 0 || this.c) {
            if (this.d != 10 || iL == 1) {
                int iA2 = kVar.a();
                this.a.a(kVar, iA2);
                this.a.a(j, 1, iA2, 0, null);
                return;
            }
            return;
        }
        int iA3 = kVar.a();
        byte[] bArr = new byte[iA3];
        System.arraycopy(kVar.a, kVar.f1236b, bArr, 0, iA3);
        kVar.f1236b += iA3;
        Pair<Integer, Integer> pairA = com.fyber.inneractive.sdk.player.exoplayer2.util.c.a(bArr);
        this.a.a(i.a((String) null, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), -1, (List<byte[]>) Collections.singletonList(bArr), (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
        this.c = true;
    }
}
