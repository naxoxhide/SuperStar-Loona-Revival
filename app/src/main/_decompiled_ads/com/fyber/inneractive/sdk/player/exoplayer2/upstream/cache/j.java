package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements f, Comparator<g> {
    public final TreeSet<g> a = new TreeSet<>(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1209b;

    public j(long j) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b
    public void a(a aVar, g gVar) {
        this.a.remove(gVar);
        this.f1209b -= gVar.c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b
    public void b(a aVar, g gVar) {
        this.a.add(gVar);
        this.f1209b += gVar.c;
        a(aVar, 0L);
    }

    @Override // java.util.Comparator
    public int compare(g gVar, g gVar2) {
        g gVar3 = gVar;
        g gVar4 = gVar2;
        long j = gVar3.f;
        long j2 = gVar4.f;
        if (j - j2 == 0) {
            return gVar3.compareTo(gVar4);
        }
        return j < j2 ? -1 : 1;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.a.b
    public void a(a aVar, g gVar, g gVar2) {
        this.a.remove(gVar);
        this.f1209b -= gVar.c;
        b(aVar, gVar2);
    }

    public final void a(a aVar, long j) {
        while (this.f1209b + j > 10485760) {
            try {
                aVar.a(this.a.first());
            } catch (a.C0298a unused) {
            }
        }
    }
}
