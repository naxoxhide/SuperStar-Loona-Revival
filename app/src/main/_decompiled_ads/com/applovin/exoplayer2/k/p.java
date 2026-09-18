package com.applovin.exoplayer2.k;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class p implements i.a {
    private final Context E;
    private final i.a aas;
    private final aa aat;

    public p(Context context, String str) {
        this(context, str, (aa) null);
    }

    public p(Context context, String str, aa aaVar) {
        this(context, aaVar, new q.a().aO(str));
    }

    public p(Context context, aa aaVar, i.a aVar) {
        this.E = context.getApplicationContext();
        this.aat = aaVar;
        this.aas = aVar;
    }

    @Override // com.applovin.exoplayer2.k.i.a
    /* JADX INFO: renamed from: ou, reason: merged with bridge method [inline-methods] */
    public o of() {
        o oVar = new o(this.E, this.aas.of());
        aa aaVar = this.aat;
        if (aaVar != null) {
            oVar.c(aaVar);
        }
        return oVar;
    }
}
