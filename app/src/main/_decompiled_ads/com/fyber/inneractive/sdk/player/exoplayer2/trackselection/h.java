package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public final s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f1199b;
    public final Object c;
    public final o[] d;

    public h(s sVar, f fVar, Object obj, o[] oVarArr) {
        this.a = sVar;
        this.f1199b = fVar;
        this.c = obj;
        this.d = oVarArr;
    }

    public boolean a(h hVar, int i) {
        return hVar != null && u.a(this.f1199b.f1198b[i], hVar.f1199b.f1198b[i]) && u.a(this.d[i], hVar.d[i]);
    }
}
