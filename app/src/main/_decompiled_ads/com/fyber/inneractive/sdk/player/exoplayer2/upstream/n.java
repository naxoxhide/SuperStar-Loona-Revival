package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements g.a {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0<? super g> f1218b;
    public final g.a c;

    public n(Context context, a0<? super g> a0Var, g.a aVar) {
        this.a = context.getApplicationContext();
        this.f1218b = a0Var;
        this.c = aVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.g.a
    public g a() {
        return new m(this.a, this.f1218b, this.c.a());
    }
}
