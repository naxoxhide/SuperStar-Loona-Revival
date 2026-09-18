package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.web.c0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    public final com.fyber.inneractive.sdk.player.controller.c g;

    public e(com.fyber.inneractive.sdk.player.controller.c cVar) {
        this.g = cVar;
        a(cVar.a());
    }

    @Override // com.fyber.inneractive.sdk.flow.vast.a
    public void a() {
        this.f933b = null;
        this.a = false;
        com.fyber.inneractive.sdk.player.controller.c cVar = this.g;
        c0 c0Var = cVar.a;
        if (c0Var != null) {
            c0Var.c();
            cVar.a = null;
        }
    }
}
